package ru.iandreyshev.command

interface ICommandQueue {

    val canUndo: Boolean
    val canRedo: Boolean

    fun apply(command: Command)
    fun undo()
    fun redo()
    fun clear()

}
