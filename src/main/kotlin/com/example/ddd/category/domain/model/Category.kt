package com.example.ddd.category.domain.model

import com.example.ddd.product.domain.model.Product

class Category(
    val categoryId: CategoryId,
    private val products: Set<Product>
) {
}