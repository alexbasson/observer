package com.example.observer.domain

interface ObserverUseCaseOutcomeHandler<T> {
    fun happyPath(message: String): T
    fun outcome2(message: String): T
    fun outcome3(message: String): T
    fun invalidInput(message: String): T
}

class ObserverUseCase {

    fun <T> execute(param: String, outcomeHandler: ObserverUseCaseOutcomeHandler<T>): T {
        if (param.equals("option1")) {
            return outcomeHandler.happyPath("happy path")
        } else if (param.equals("option2")) {
            return outcomeHandler.outcome2("outcome 2")
        } else if (param.equals("option3")) {
            return outcomeHandler.outcome3("outcome 3")
        }
        return outcomeHandler.invalidInput("invalid input")
    }

}