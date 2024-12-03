package com.example.payment.loan.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class LoanReview (
        val userKey:String,
        val userLimitAmount: Long,
        val userLoanInterest: Double
) {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}