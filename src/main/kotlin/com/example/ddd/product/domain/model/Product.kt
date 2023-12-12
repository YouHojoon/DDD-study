package com.example.ddd.product.domain.model

import com.example.ddd.category.domain.model.CategoryId
import jakarta.persistence.CollectionTable
import jakarta.persistence.ElementCollection
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn

@Entity
class Product(
    @EmbeddedId
    private val productId: ProductId,

    @ElementCollection
    @CollectionTable(name = "product_category", joinColumns = [JoinColumn(name = "product_id")])
    private val categoryIds: Set<CategoryId> = mutableSetOf()
)