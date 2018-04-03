package command

import document.IDocumentItem
import document.IImage
import io.IImageFileManager

class DeleteItemCommand(
        private val fileManager: IImageFileManager,
        private val items: MutableList<IDocumentItem>,
        private val position: Int
) : Command() {
    private val item: IDocumentItem = items[position]
    private var mBehavior: Command

    init {
        val image = item.image

        mBehavior = when {
            item.paragraph != null -> DeleteParagraph()
            image != null -> DeleteImage(image)
            else -> throw NotImplementedError()
        }
    }

    override fun onExecute() = mBehavior.execute()

    override fun onUndo() = mBehavior.undo()

    override fun onDestroy() = mBehavior.destroy()

    inner class DeleteParagraph : Command() {
        override fun onExecute() {
            items.removeAt(position)
        }

        override fun onUndo() {
            items.add(position, item)
        }
    }

    inner class DeleteImage(private val image: IImage) : Command() {
        override fun onExecute() {
            fileManager.markImageOnDelete(image.path, true)
            items.removeAt(position)
        }

        override fun onUndo() {
            fileManager.markImageOnDelete(image.path, false)
            items.add(position, item)
        }

        override fun onDestroy() {
            fileManager.markImageOnDelete(image.path, false)
        }
    }
}
