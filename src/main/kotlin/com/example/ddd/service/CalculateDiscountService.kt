package com.example.ddd.service

import com.example.ddd.NoCustomerException
import com.example.ddd.domain.Customer
import com.example.ddd.domain.Money
import com.example.ddd.domain.OrderLine
import com.example.ddd.repository.CustomerRepository
import com.example.ddd.util.RuleDiscounter
import kotlin.jvm.optionals.getOrNull

class CalculateDiscountService(
    private val ruleDiscounter: RuleDiscounter,
    private val repo: CustomerRepository
) {
    fun calculateDiscount(orderLines: List<OrderLine>, customerId: String): Money{
        val customer = findCustomer(customerId)
        return ruleDiscounter.applyRules(customer, orderLines)
    }

    fun findCustomer(customerId: String): Customer{
        val customer = repo.findById(customerId)
        return customer.getOrNull() ?: throw NoCustomerException()
    }
}