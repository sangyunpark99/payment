package com.example.payment.loan.service.loanReview

import com.example.payment.loan.dto.LoanReviewDto
import com.example.payment.loan.dto.response.LoanReviewResponseDto

interface LoanReviewService {

    fun loanReview(userKey:String):LoanReviewResponseDto

    fun getLoanResult(userKey:String): LoanReviewDto
}