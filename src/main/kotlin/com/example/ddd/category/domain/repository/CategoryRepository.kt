package com.example.ddd.category.domain.repository

import com.example.ddd.category.domain.model.Category
import com.example.ddd.category.domain.model.CategoryId
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository: JpaRepository<Category, CategoryId> {
}