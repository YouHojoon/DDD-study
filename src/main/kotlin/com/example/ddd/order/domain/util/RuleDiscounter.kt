package com.example.ddd.order.domain.util

import com.example.ddd.order.domain.model.Customer
import com.example.ddd.order.domain.model.Money
import com.example.ddd.order.domain.model.OrderLine

fun interface RuleDiscounter {
    fun applyRules(customer: Customer, orderLines: List<OrderLine>): Money
}