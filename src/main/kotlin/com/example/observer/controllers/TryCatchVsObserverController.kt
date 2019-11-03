package com.example.observer.controllers

import com.example.observer.domain.InvalidInputException
import com.example.observer.domain.Outcome2Exception
import com.example.observer.domain.Outcome3Exception
import com.example.observer.domain.TryCatchUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class TryCatchVsObserverController(
    val tryCatchUseCase: TryCatchUseCase
) {

    @GetMapping("tryCatch")
    public fun tryCatchPattern(@RequestParam("option") option: String): ResponseEntity<String> {
        try {
            val result = tryCatchUseCase.execute(option)
            return ResponseEntity.ok(result)
        } catch (e: Outcome2Exception) {
            return ResponseEntity.ok("outcome 2")
        } catch (e: Outcome3Exception) {
            return ResponseEntity.ok("outcome 3")
        } catch (e: InvalidInputException) {
            return ResponseEntity.badRequest().body("invalid input")
        }
    }

}