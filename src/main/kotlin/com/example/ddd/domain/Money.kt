package com.example.ddd.domain

data class Money(val value: Int){
    operator fun plus(rhs: Money): Money {
        return Money(value + rhs.value)
    }

    operator fun times(rhs: Int): Money {
        return Money(value * rhs)
    }
}

