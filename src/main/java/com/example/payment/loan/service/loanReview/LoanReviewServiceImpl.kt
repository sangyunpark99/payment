package com.example.payment.loan.service.loanReview

import com.example.payment.loan.dto.LoanResultDto
import com.example.payment.loan.dto.LoanReviewDto
import com.example.payment.loan.dto.response.LoanReviewResponseDto
import com.example.payment.loan.repository.LoanReviewRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class LoanReviewServiceImpl(
        private val loanReviewRepository: LoanReviewRepository
) : LoanReviewService {

    override fun loanReview(userKey: String): LoanReviewResponseDto {
        val loanResult = getLoanResult(userKey)

        return LoanReviewResponseDto(
                userKey = userKey,
                loanResult = LoanResultDto(
                        userLimitAmount = loanResult.userLimitAmount,
                        userLoanInterest = loanResult.userLoanInterest)
        )
    }

    override fun getLoanResult(userKey: String): LoanReviewDto {
        val loanReview = loanReviewRepository.findByUserKey(userKey)

        return LoanReviewDto(
                loanReview.userKey,
                loanReview.userLimitAmount,
                loanReview.userLoanInterest
        )
    }
}