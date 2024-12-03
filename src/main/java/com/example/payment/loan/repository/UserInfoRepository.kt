package com.example.payment.loan.repository

import com.example.payment.loan.domain.UserInfo
import org.springframework.data.jpa.repository.JpaRepository

interface UserInfoRepository: JpaRepository<UserInfo, Long> {
}