package com.example.payment.loan.controller

import com.example.payment.loan.dto.request.LoanRequestDto
import com.example.payment.loan.dto.response.LoanResponseDto
import com.example.payment.loan.service.loan.LoanServiceImpl
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/loan")
class LoanController(
        private val loanServiceImpl: LoanServiceImpl
) {

    @PostMapping("/request")
    fun loanRequest(
            @RequestBody loanRequestDto:LoanRequestDto
    ): ResponseEntity<LoanResponseDto> {
        return ResponseEntity.ok(loanServiceImpl.loan(loanRequestDto))
    }
}