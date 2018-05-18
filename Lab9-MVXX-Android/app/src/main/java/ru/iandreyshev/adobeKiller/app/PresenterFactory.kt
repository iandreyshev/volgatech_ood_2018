package ru.iandreyshev.adobeKiller.app

import ru.iandreyshev.adobeKiller.presentation.presenter.CanvasPresenter
import ru.iandreyshev.adobeKiller.presentation.presenter.MenuPresenter
import ru.iandreyshev.adobeKiller.presentation.ui.viewModel.interfaces.InteractorViewModel
import ru.iandreyshev.adobeKiller.presentation.ui.viewModel.interfaces.ICanvasViewModel
import ru.iandreyshev.adobeKiller.presentation.presenter.interfaces.IPresenterFactory
import ru.iandreyshev.adobeKiller.presentation.presenter.interfaces.IPresenter
import ru.iandreyshev.adobeKiller.presentation.ui.viewModel.interfaces.IMenuViewModel

internal class PresenterFactory : IPresenterFactory {

    override fun create(
            useCaseType: UseCaseType,
            viewModel: InteractorViewModel<*>?): IPresenter = when (useCaseType) {

        UseCaseType.MENU -> MenuPresenter(viewModel as IMenuViewModel)
        UseCaseType.CANVAS -> CanvasPresenter(viewModel as ICanvasViewModel)

    }

}
