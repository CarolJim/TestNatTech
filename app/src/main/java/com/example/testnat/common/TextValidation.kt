package com.example.testnat.common

import android.util.Patterns
import java.util.regex.Pattern

class TextValidation {
    companion object{
        fun emptyText(text:String):Boolean{
            return text.isNotEmpty()
        }
    }

    fun mailFormat(email: String): Boolean {
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }

    fun validatePhone(phone: String): Boolean {
        val number = phone.trim { it <= ' ' }
        return number.matches("(^[0-9]{10}\$)".toRegex())
    }

    fun validatePassword(password: String): Boolean {
        val number = password.trim { it <= ' ' }
        return number.matches("^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,50}\$".toRegex())
    }

}