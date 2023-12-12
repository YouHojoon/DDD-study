package com.example.ddd.order.domain.service

import com.example.ddd.member.domain.exception.MemberNotFoundException
import com.example.ddd.member.domain.repository.MemberRepository
import com.example.ddd.order.domain.model.OrderId
import com.example.ddd.order.domain.model.ShippingInfo
import com.example.ddd.order.domain.exception.OrderNotFoundException
import com.example.ddd.order.domain.repository.OrderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.jvm.optionals.getOrNull

@Service
class ChangeOrderService(
    private val repo: OrderRepository,
    private val memberRepo: MemberRepository
) {
    @Transactional
    fun changeShippingInfo(id: OrderId, newShippingInfo: ShippingInfo, useNewShippingAsMemberAddr: Boolean){
        val order = repo.findById(id).getOrNull() ?: throw OrderNotFoundException()
        order.changeShippingInfo(newShippingInfo)

        if(useNewShippingAsMemberAddr){
            val member = memberRepo.findById(order.orderer.memberId).getOrNull() ?: throw MemberNotFoundException()
            member.changeAddress(newShippingInfo.address)
        }

    }
}