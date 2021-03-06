package ru.iandreyshev.compositeshapespaint.model.container

data class Vec2f(
        var x: Float = 0f,
        var y: Float = 0f
) {
    constructor(x: Int, y: Int) : this(x.toFloat(), y.toFloat())
}
