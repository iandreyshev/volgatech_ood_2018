package ru.iandreyshev.gumballmachine.factory.useCase

import ru.iandreyshev.gumballmachine.useCase.interfaces.IUseCase
import kotlin.reflect.KClass

interface IUseCaseFactory {
    fun <TUseCase : IUseCase<*>> create(useCaseClass: KClass<TUseCase>): TUseCase
}
