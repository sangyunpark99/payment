package com.example.payment.loan.controller

import com.example.payment.loan.dto.response.LoanReviewResponseDto
import com.example.payment.loan.service.loanReview.LoanReviewServiceImpl
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/review")
class LoanReviewController(
        private val loanReviewServiceImpl: LoanReviewServiceImpl
) {

    @GetMapping("{userKey}")
    fun getLoanReview(
            @PathVariable userKey: String,
    ): ResponseEntity<LoanReviewResponseDto>{
        return ResponseEntity.ok(loanReviewServiceImpl.loanReview(userKey))
    }
}