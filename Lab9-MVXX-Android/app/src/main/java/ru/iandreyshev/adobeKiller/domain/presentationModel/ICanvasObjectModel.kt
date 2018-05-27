package ru.iandreyshev.adobeKiller.domain.presentationModel

import ru.iandreyshev.adobeKiller.domain.model.CanvasObject
import ru.iandreyshev.adobeKiller.presentation.drawing.frame.IFrame
import ru.iandreyshev.adobeKiller.presentation.drawing.style.IStyle

interface ICanvasObjectModel {

    fun notifyDataChanges(canvasObject: CanvasObject, newFrame: IFrame)
    fun notifyDataChanges(canvasObject: CanvasObject, newStyle: IStyle)

}
