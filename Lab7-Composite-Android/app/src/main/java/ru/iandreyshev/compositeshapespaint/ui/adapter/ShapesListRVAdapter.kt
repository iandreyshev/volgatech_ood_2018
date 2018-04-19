package ru.iandreyshev.compositeshapespaint.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.iandreyshev.compositeshapespaint.R
import ru.iandreyshev.compositeshapespaint.model.shape.IShape

class ShapesListRVAdapter(
        private val getShapes: () -> List<IShape>?,
        private val onClickShape: (IShape) -> Unit
) : RecyclerView.Adapter<ShapeViewRVHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShapeViewRVHolder =
            ShapeViewRVHolder(
                    LayoutInflater.from(parent.context)
                            .inflate(R.layout.lay_shape_select_list_item, parent, false)
            )

    override fun onBindViewHolder(holder: ShapeViewRVHolder, position: Int) {
        val list = getShapes() ?: listOf()
        val item = list[position]

        holder.title.text = item.name
        holder.itemView.setOnClickListener { onClickShape(item) }
    }

    override fun getItemCount(): Int = getShapes()?.size ?: 0
}
