package com.example.payment.loan.dto

data class LoanReviewDto(
        val userKey:String,
        val userLimitAmount: Long,
        val userLoanInterest: Double
)