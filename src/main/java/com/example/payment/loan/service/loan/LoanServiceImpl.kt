package com.example.payment.loan.service.loan

import com.example.payment.loan.utils.KeyUtils
import com.example.payment.loan.domain.UserInfo
import com.example.payment.loan.dto.UserInfoDto
import com.example.payment.loan.dto.request.LoanRequestDto
import com.example.payment.loan.dto.response.LoanResponseDto
import com.example.payment.loan.repository.UserInfoRepository
import com.example.payment.loan.utils.EncryptUtils
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class LoanServiceImpl(
        private val keyUtils: KeyUtils,
        private val encryptUtils: EncryptUtils,
        private val userInfoRepository: UserInfoRepository
): LoanService {

    override fun loan(loanRequestDto: LoanRequestDto) : LoanResponseDto{
        val userKey = keyUtils.generateKey()

        loanRequestDto.userRegisterNumber = encryptUtils.encryptString(loanRequestDto.userRegisterNumber)

        saveUserInfo(loanRequestDto.toUserInfoDto(userKey))
        loanReview(userKey)

        return LoanResponseDto(userKey)
    }

    override fun saveUserInfo(userInfoDto: UserInfoDto): UserInfo =
            userInfoRepository.save(userInfoDto.toEntity());

    override fun loanReview(userKey: String) {

    }
}