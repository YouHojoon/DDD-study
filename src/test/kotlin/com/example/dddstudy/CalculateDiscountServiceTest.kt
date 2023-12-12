package com.example.dddstudy

import com.example.ddd.order.domain.exception.NoCustomerException
import com.example.ddd.order.domain.model.Money
import com.example.ddd.order.domain.repository.CustomerRepository
import com.example.ddd.order.domain.service.CalculateDiscountService
import com.example.ddd.order.domain.util.RuleDiscounter
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@ExtendWith(SpringExtension::class)
class CalculateDiscountServiceTest{
    @MockBean
    private lateinit var repo: CustomerRepository

    @Test
    @DisplayName("구매자가 없다면 NoCustomerException을 던진다.")
    fun when_noCustomer_thenThrowNoCustomerException(){
        Mockito.`when`(repo.findById("noCustId")).thenReturn(Optional.empty())
        val rule = RuleDiscounter{ customer, orderLines ->  Money(1) }
        val svc = CalculateDiscountService(rule, repo)

        assertThrows<NoCustomerException> {
            svc.calculateDiscount(emptyList(), "noCustId")
        }
    }
}