package com.example.observer

import com.example.observer.domain.ObserverUseCase
import com.example.observer.domain.TryCatchUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ObserverConfiguration {

    @Bean
    fun tryCatchUseCase() = TryCatchUseCase()

    @Bean
    fun observerUseCase() = ObserverUseCase()

}