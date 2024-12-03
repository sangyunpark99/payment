package com.example.payment.loan.service.loan

import com.example.payment.loan.domain.UserInfo
import com.example.payment.loan.dto.UserInfoDto
import com.example.payment.loan.dto.request.LoanRequestDto
import com.example.payment.loan.dto.response.LoanResponseDto
import com.example.payment.loan.dto.response.LoanReviewResponseDto

interface LoanService {

    fun loan(loanRequestDto: LoanRequestDto) : LoanResponseDto

    fun saveUserInfo(userInfoDto: UserInfoDto): UserInfo

    fun loanReview(userKey : String)
}