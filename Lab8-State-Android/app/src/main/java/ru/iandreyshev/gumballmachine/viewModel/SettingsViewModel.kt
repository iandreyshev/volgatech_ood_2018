package ru.iandreyshev.gumballmachine.viewModel

import android.app.Application
import ru.iandreyshev.gumballmachine.interactor.interfaces.IInteractor
import ru.iandreyshev.gumballmachine.interactor.interfaces.ISettingsInteractor
import ru.iandreyshev.gumballmachine.viewModel.interfaces.AbstractViewModel
import ru.iandreyshev.gumballmachine.viewModel.interfaces.ISettingsViewModel

class SettingsViewModel(
        app: Application
) : AbstractViewModel<ISettingsInteractor>(app), ISettingsViewModel
