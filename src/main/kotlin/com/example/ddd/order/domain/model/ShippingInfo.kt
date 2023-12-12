package com.example.ddd.order.domain.model

import com.example.ddd.common.model.Address

class ShippingInfo(
    private val receiver: Receiver,
    val address: Address
) {

}