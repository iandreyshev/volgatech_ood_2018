import command.DocumentCommandQueue
import io.DocumentInterpreter
import java.io.IOException

class Main {
    companion object {
        private val WHITESPACES = Regex("[\r\n\t ]+")
        private const val COMMANDS_MEMORY_SIZE = 10

        private val mInterpreter = DocumentInterpreter()
        private val mCommandsQueue = DocumentCommandQueue(COMMANDS_MEMORY_SIZE)
        private val mDocument = HtmlDocument(mHtml, mCommandsQueue)

        @JvmStatic
        fun main(args: Array<String>) {
            try {
                enterLoop()
            } catch (ex: Exception) {
                println(ex.cause)
            }
        }

        private fun enterLoop() {
            loop@ while (true) {
                val command = readLine()
                        ?.trim()
                        ?.split(WHITESPACES)
                        ?: throw IOException("Input is null")

                if (!mInterpreter.apply(mDocument, command)) {
                    break@loop
                }
            }
        }
    }
}
