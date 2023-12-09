package com.example.ddd.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Customer(
    @Id
    private val id: String
) {

}