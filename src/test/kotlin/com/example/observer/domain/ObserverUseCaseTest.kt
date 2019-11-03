package com.example.observer.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ObserverUseCaseTest {

    lateinit var observerUseCase: ObserverUseCase

    @BeforeEach
    public fun `set up`() {
        observerUseCase = ObserverUseCase()
    }

    @Test
    public fun `execute(), when the param is "option1", notifies the outcome handler that the outcome was happyPath with a message of "happyPath"`() {
        val outcomeHandlerSpy = ObserverUseCaseOutcomeHandlerSpy()

        observerUseCase.execute("option1", outcomeHandlerSpy)

        assertThat(outcomeHandlerSpy.happyPathWasCalled).isTrue()
        assertThat(outcomeHandlerSpy.passedMessage).isEqualTo("happy path")
    }

    @Test
    public fun `execute(), when the param is "option2", notifies the outcome handler that the outcome was outcome2 with a message of "outcome 2"`() {
        val outcomeHandlerSpy = ObserverUseCaseOutcomeHandlerSpy()

        observerUseCase.execute("option2", outcomeHandlerSpy)

        assertThat(outcomeHandlerSpy.option2WasCalled).isTrue()
        assertThat(outcomeHandlerSpy.passedMessage).isEqualTo("outcome 2")
    }

    @Test
    public fun `execute(), when the param is "option3", notifies the outcome handler that the outcome was outcome3 with a message of "outcome 3"`() {
        val outcomeHandlerSpy = ObserverUseCaseOutcomeHandlerSpy()

        observerUseCase.execute("option3", outcomeHandlerSpy)

        assertThat(outcomeHandlerSpy.option3WasCalled).isTrue()
        assertThat(outcomeHandlerSpy.passedMessage).isEqualTo("outcome 3")
    }

    @Test
    public fun `execute(), when the param is anything else, notifies the outcome handler that the outcome was invalidInput with a message of "invalid input"`() {
        val outcomeHandlerSpy = ObserverUseCaseOutcomeHandlerSpy()

        observerUseCase.execute("anything else", outcomeHandlerSpy)

        assertThat(outcomeHandlerSpy.invalidInputWasCalled).isTrue()
        assertThat(outcomeHandlerSpy.passedMessage).isEqualTo("invalid input")
    }
}

class ObserverUseCaseOutcomeHandlerSpy : ObserverUseCaseOutcomeHandler<Unit> {
    var happyPathWasCalled = false
    var option2WasCalled = false
    var option3WasCalled = false
    var invalidInputWasCalled = false
    var passedMessage = ""

    override fun happyPath(message: String) {
        happyPathWasCalled = true
        passedMessage = message
    }

    override fun outcome2(message: String) {
        option2WasCalled = true
        passedMessage = message
    }

    override fun outcome3(message: String) {
        option3WasCalled = true
        passedMessage = message
    }

    override fun invalidInput(message: String) {
        invalidInputWasCalled = true
        passedMessage = message
    }

}
