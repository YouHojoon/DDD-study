package com.example.ddd.order.domain.service

import com.example.ddd.order.domain.exception.NoCustomerException
import com.example.ddd.order.domain.model.Customer
import com.example.ddd.order.domain.model.Money
import com.example.ddd.order.domain.model.OrderLine
import com.example.ddd.order.domain.repository.CustomerRepository
import com.example.ddd.order.domain.util.RuleDiscounter
import kotlin.jvm.optionals.getOrNull

class CalculateDiscountService(
    private val ruleDiscounter: RuleDiscounter,
    private val repo: CustomerRepository
) {
    fun calculateDiscount(orderLines: List<OrderLine>, customerId: String): Money {
        val customer = findCustomer(customerId)
        return ruleDiscounter.applyRules(customer, orderLines)
    }

    fun findCustomer(customerId: String): Customer {
        val customer = repo.findById(customerId)
        return customer.getOrNull() ?: throw NoCustomerException()
    }
}