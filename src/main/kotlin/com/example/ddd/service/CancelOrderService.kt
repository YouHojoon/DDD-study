package com.example.ddd.service

import org.springframework.transaction.annotation.Transactional

//class CancelOrderService {
//
//    @Transactional
//    fun cancelOrder(orderId: String){
//        val order = findOrderById(orderId)
//        if (order == null)
//            throw OrderNotFoundException(orderId)
//        order.cancel()
//    }
//}