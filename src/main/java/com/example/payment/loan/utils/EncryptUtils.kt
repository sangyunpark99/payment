package com.example.payment.loan.utils

import org.springframework.stereotype.Component
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

@Component
class EncryptUtils {

    companion object {
        private const val secretKey = "your-secret-key-"
    }

    private val encoder = Base64.getEncoder()
    private val decoder = Base64.getDecoder()

    fun encryptString(encryptstring: String): String{
        val encryptString = getCipher(Cipher.ENCRYPT_MODE, secretKey).doFinal(encryptstring.toByteArray(Charsets.UTF_8))
        return String(encoder.encode(encryptString))
    }

    fun decryptString(decryptstring: String): String {
        val byteString = decoder.decode(decryptstring.toByteArray(Charsets.UTF_8))

        return String(getCipher(Cipher.DECRYPT_MODE, secretKey).doFinal(byteString))
    }

    fun getCipher(opMode:Int, secretKey: String): Cipher {
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        val sk = SecretKeySpec(secretKey.toByteArray(Charsets.UTF_8), "AES")
        val iv = IvParameterSpec(secretKey.substring(0,16).toByteArray(Charsets.UTF_8))
        cipher.init(opMode, sk, iv)
        return cipher
    }
}