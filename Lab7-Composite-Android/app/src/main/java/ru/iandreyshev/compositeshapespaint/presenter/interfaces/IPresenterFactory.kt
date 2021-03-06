package ru.iandreyshev.compositeshapespaint.presenter.interfaces

import ru.iandreyshev.compositeshapespaint.ui.viewModel.interfaces.AbstractViewModel
import kotlin.reflect.KClass

interface IPresenterFactory {
    fun <TPresenter : IPresenter>
            create(presenterClass: KClass<TPresenter>, viewModel: AbstractViewModel<*>?): IPresenter
}
