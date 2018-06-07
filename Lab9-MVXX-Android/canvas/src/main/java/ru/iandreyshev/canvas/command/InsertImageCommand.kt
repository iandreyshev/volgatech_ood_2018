package ru.iandreyshev.canvas.command

import ru.iandreyshev.command.Command
import ru.iandreyshev.canvas.file.IFile
import ru.iandreyshev.canvas.core.CanvasObject

internal class InsertImageCommand(
        private val objectsList: MutableList<CanvasObject>,
        private val file: IFile,
        private val image: CanvasObject
) : Command() {

    private val mPosition: Int = objectsList.size

    override fun onExecute() {
        objectsList.add(image)
    }

    override fun onUndo() {
        objectsList.removeAt(mPosition)
        file.flush()
    }

    override fun onDestroyNotExecuted() {
        file.delete()
    }

}
