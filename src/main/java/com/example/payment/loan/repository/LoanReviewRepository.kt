package com.example.payment.loan.repository

import com.example.payment.loan.domain.LoanReview
import org.springframework.data.jpa.repository.JpaRepository

interface LoanReviewRepository: JpaRepository<LoanReview, Long>{

    fun findByUserKey(userKey:String): LoanReview
}