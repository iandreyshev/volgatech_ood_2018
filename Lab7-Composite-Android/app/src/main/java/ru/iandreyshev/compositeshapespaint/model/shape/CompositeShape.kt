package ru.iandreyshev.compositeshapespaint.model.shape

import canvas.Color
import ru.iandreyshev.compositeshapespaint.model.canvas.ICanvas
import ru.iandreyshev.compositeshapespaint.model.containers.CompositeFrame
import ru.iandreyshev.compositeshapespaint.model.containers.AbstractFrame
import extension.forEach2
import extension.getAllSameOrNull

class CompositeShape(override val name: String) : ICompositeShape, CompositeFrame.InnerFramesIterator {
    private val mShapes: HashSet<IShape> = HashSet()

    override val composite: ICompositeShape? = this

    override val frame: AbstractFrame = CompositeFrame(frames = this)

    override fun getFillColor(): Color? =
            mShapes.getAllSameOrNull { getFillColor() }

    override fun setFillColor(color: Color) =
            mShapes.forEach2 { setFillColor(color) }

    override fun getStrokeColor(): Color? =
            mShapes.getAllSameOrNull { getStrokeColor() }

    override fun setStrokeColor(color: Color) =
            mShapes.forEach2 { setStrokeColor(color) }

    override fun getStrokeSize(): Float? =
            mShapes.getAllSameOrNull { getStrokeSize() }

    override fun setStrokeSize(size: Float) =
            mShapes.forEach2 { setStrokeSize(size) }

    override fun add(shape: IShape) {
        mShapes.add(shape)
    }

    override fun remove(shape: IShape) {
        mShapes.remove(shape)
    }

    override fun draw(canvas: ICanvas) = mShapes.forEach2 { draw(canvas) }

    override fun forEach(action: AbstractFrame.() -> Unit) = mShapes.forEach2 { action(frame) }
}
