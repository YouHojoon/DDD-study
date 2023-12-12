package com.example.ddd.product.domain.repository

import com.example.ddd.category.domain.model.CategoryId
import com.example.ddd.product.domain.model.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Long> {
    fun findByCategoryId(categoryId: CategoryId, pageRequest: PageRequest): Page<Product>
}