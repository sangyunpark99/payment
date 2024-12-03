package com.example.payment.loan.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class UserInfo(

        val userKey: String,

        val userRegistrationNumber: String,

        val userName: String,

        val userIncomeAmount: Long
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}