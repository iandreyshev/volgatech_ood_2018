package ru.iandreyshev.adobeKiller.presentation.drawing.drawable

import android.graphics.Bitmap
import ru.iandreyshev.adobeKiller.domain.model.ICanvasObjectVisitor
import ru.iandreyshev.adobeKiller.domain.model.CanvasImage
import ru.iandreyshev.adobeKiller.domain.model.CanvasShape
import ru.iandreyshev.adobeKiller.domain.model.ShapeType
import ru.iandreyshev.adobeKiller.presentation.drawing.canvas.ICanvas

class DrawableHelper(
        private val canvas: ICanvas
) : ICanvasObjectVisitor {

    override fun visit(shape: CanvasShape) {
        val drawable = when (shape.type) {
            ShapeType.Rect -> DrawableRect(shape.frame, shape.style)
            ShapeType.Ellipse -> DrawableEllipse(shape.frame, shape.style)
            ShapeType.Triangle -> DrawableTriangle(shape.frame, shape.style)
        }

        drawable.draw(canvas)
    }

    override fun visit(image: CanvasImage) {
        val drawable = DrawableImage(
                width = image.frame.width,
                height = image.frame.height,
                image = image.image ?: Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888)
        )

        drawable.draw(canvas)
    }

}