package ru.iandreyshev.compositeshapespaint.ui.dialog

import android.content.Context
import android.support.annotation.StringRes
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.view_action_dialog.view.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton
import ru.iandreyshev.compositeshapespaint.R

class ActionDialog(
        private val context: Context,
        @StringRes private val titleResId: Int,
        private val onSubmit: String.() -> Unit
) {
    init {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.view_action_dialog, null)
        context.alert {
            title = context.resources.getString(titleResId)
            customView = view
            okButton {
                onSubmit(view.etActionArgs.text.toString())
            }
        }.show()
    }
}