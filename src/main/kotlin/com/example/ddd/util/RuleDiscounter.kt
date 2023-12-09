package com.example.ddd.util

import com.example.ddd.domain.Customer
import com.example.ddd.domain.Money
import com.example.ddd.domain.OrderLine

fun interface RuleDiscounter {
    fun applyRules(customer: Customer, orderLines: List<OrderLine>): Money
}