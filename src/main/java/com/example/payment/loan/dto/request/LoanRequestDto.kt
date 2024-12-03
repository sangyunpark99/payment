package com.example.payment.loan.dto.request

import com.example.payment.loan.dto.UserInfoDto

data class LoanRequestDto(
        val userName: String,
        val userIncomeAmount: Long,
        var userRegisterNumber: String
) {
    fun toUserInfoDto(userKey: String) =
            UserInfoDto(
                   userKey, userName, userRegisterNumber, userIncomeAmount
            )
}