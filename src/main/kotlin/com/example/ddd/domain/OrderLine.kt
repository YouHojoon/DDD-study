package com.example.ddd.domain

class OrderLine(
//    private val product: Product,
    private val price: Int,
    private val quantity: Int
) {
    val amounts = calcAmounts()

    private fun calcAmounts(): Money {
        return Money(price) * quantity
    }
}