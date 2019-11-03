package com.example.observer.domain

class TryCatchUseCase {

    fun execute(param: String): String {
        if (param.equals("option1")) {
            return "happy path"
        } else if (param.equals("option2")) {
            throw Outcome2Exception()
        } else if (param.equals("option3")) {
            throw Outcome3Exception()
        }
        throw InvalidInputException()
    }

}
