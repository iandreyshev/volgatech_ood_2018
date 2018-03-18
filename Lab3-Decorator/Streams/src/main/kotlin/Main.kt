import cipher.ShuffleCodec
import cipher.ReplacementCipherDecoder
import cipher.ReplacementCipherEncoder
import cmdParser.StreamsCmdParser
import compressor.SimpleCompressor
import inputStream.MemoryInputStream
import outputStream.MemoryOutputStream
import java.io.File

class Main {
    companion object {

        private var mOutputFilePath: String = ""
        private var mMemory: ByteArray = ByteArray(0)
        private val mCompressor = SimpleCompressor()

        @JvmStatic
        fun main(args: Array<String>) {
            val parser = StreamsCmdParser(::initFiles, ::compress, ::decompress, ::encrypt, ::decrypt)

            if (parser.execute(args)) {
                mOutputFilePath.resPath.outputStream().write(mMemory)
            }
        }

        private fun initFiles(inputFilePath: String, outputFilePath: String) {
            mOutputFilePath = outputFilePath

            val fileBytes = inputFilePath.resPath.inputStream().readBytes()
            mMemory = fileBytes.sliceArray(0 until fileBytes.size)
        }

        private fun compress() {
            mMemory = mCompressor.compress(mMemory)
        }

        private fun decompress() {
            mMemory = mCompressor.decompress(mMemory)
        }

        private fun encrypt(key: Long) {
            val output = ArrayList<Byte>()
            val stream = MemoryOutputStream(output)
            val encoder = ReplacementCipherEncoder(ShuffleCodec(key), stream)

            encoder.write(mMemory, mMemory.size)
            mMemory = output.toByteArray()
        }

        private fun decrypt(key: Long) {
            val stream = MemoryInputStream(mMemory.asList())
            val decoder = ReplacementCipherDecoder(ShuffleCodec(key), stream)
            val output = ArrayList<Byte>()

            decoder.read(output, mMemory.size)
            mMemory = output.toByteArray()
        }

        private val String.resPath: File
            get() = File("src/main/resources/" + this)

    }
}
