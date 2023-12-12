package com.example.ddd.category.domain.model

import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
data class CategoryId(private val value: Long): Serializable
