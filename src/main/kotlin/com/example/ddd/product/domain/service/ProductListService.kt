package com.example.ddd.product.domain.service

import com.example.ddd.category.domain.exception.CategoryNotFoundException
import com.example.ddd.category.domain.model.CategoryId
import com.example.ddd.category.domain.repository.CategoryRepository
import com.example.ddd.product.domain.model.Product
import com.example.ddd.product.domain.repository.ProductRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import kotlin.jvm.optionals.getOrNull

class ProductListService(
    private val repo: ProductRepository,
    private val categoryRepository: CategoryRepository
) {
    fun findProductsOfCategory(categoryId: CategoryId, page: Int, size: Int): Page<Product>{
        val category = categoryRepository.findById(categoryId).getOrNull() ?: throw CategoryNotFoundException()
        return repo.findByCategoryId(category.categoryId, PageRequest.of(page, size))
    }
}