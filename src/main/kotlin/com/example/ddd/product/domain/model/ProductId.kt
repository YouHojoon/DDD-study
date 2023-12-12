package com.example.ddd.product.domain.model

import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import java.io.Serializable


data class ProductId(
    private val long: Long
): Serializable
