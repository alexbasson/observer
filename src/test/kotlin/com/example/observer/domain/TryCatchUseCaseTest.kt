package com.example.observer.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class TryCatchUseCaseTest {

    lateinit var tryCatchUseCase: TryCatchUseCase

    @BeforeEach
    public fun `set up`() {
        tryCatchUseCase = TryCatchUseCase()
    }

    @Test
    public fun `execute(), when the param is "option1", it returns "happy path"`() {
        val result = tryCatchUseCase.execute("option1")
        assertThat(result).isEqualTo("happy path")
    }

    @Test
    public fun `execute(), when the param is "option2", it throws an Outcome2Exception`() {
        assertThrows(Outcome2Exception::class.java, {
            tryCatchUseCase.execute("option2")
        })
    }

    @Test
    public fun `execute(), when the param is "option3", it throws an Outcome3Exception`() {
        assertThrows(Outcome3Exception::class.java, {
            tryCatchUseCase.execute("option3")
        })
    }

    @Test
    public fun `execute(), when the param is anything else, it throws an InvalidInputException`() {
        assertThrows(InvalidInputException::class.java, {
            tryCatchUseCase.execute("anything else")
        })
    }
}
