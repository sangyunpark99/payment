package com.example.payment.loan.utils

import org.springframework.stereotype.Component
import java.util.*

@Component
class KeyUtils {
    fun generateKey() = UUID.randomUUID().toString().replace("-","")
}