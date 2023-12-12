package com.example.ddd.order.domain.repository

import com.example.ddd.order.domain.model.Order
import com.example.ddd.order.domain.model.OrderId
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<Order, OrderId>{
}