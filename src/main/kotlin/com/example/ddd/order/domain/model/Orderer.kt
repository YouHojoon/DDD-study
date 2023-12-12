package com.example.ddd.order.domain.model

import com.example.ddd.member.domain.model.MemberId

data class Orderer(
    val memberId: MemberId,
    private val name: String
) {
}