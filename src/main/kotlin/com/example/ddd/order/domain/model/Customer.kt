package com.example.ddd.order.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Customer(
    @Id
    private val id: String
) {

}