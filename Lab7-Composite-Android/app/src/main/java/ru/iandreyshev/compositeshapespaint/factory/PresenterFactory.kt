package ru.iandreyshev.compositeshapespaint.factory

import ru.iandreyshev.compositeshapespaint.presenter.MainPresenter
import ru.iandreyshev.compositeshapespaint.presenter.interfaces.IMainPresenter
import ru.iandreyshev.compositeshapespaint.ui.viewModel.interfaces.AbstractViewModel
import ru.iandreyshev.compositeshapespaint.ui.viewModel.interfaces.IMainViewModel
import ru.iandreyshev.compositeshapespaint.presenter.interfaces.IPresenterFactory
import ru.iandreyshev.compositeshapespaint.presenter.interfaces.IPresenter
import kotlin.reflect.KClass

object PresenterFactory : IPresenterFactory {
    override fun <TPresenter : IPresenter>
            create(presenterClass: KClass<TPresenter>, viewModel: AbstractViewModel<*>?): IPresenter {
        return when (presenterClass) {
            IMainPresenter::class -> {
                MainPresenter(viewModel as IMainViewModel)
            }
            else -> throw IllegalArgumentException("Unknown presenter class ${presenterClass.qualifiedName}")
        }
    }
}
