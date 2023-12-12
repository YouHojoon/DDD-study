package com.example.ddd.member.domain.model

data class Password(private val value: String){
    fun match(password: String): Boolean{
        return password == value
    }
}
