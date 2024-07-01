package com.hercute.mcrabe.domain.categories.service

import com.hercute.mcrabe.domain.categories.dto.CategoriesResponse
import com.hercute.mcrabe.domain.categories.dto.CreateCategoriesRequest
import com.hercute.mcrabe.domain.categories.dto.UpdateCategoriesRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface CategoriesService {
    fun createCategory(request : CreateCategoriesRequest)

    fun updateCategory(categoryId: Long, request : UpdateCategoriesRequest)
    fun deleteCategory(categoryId: Long)

    fun getCategoryList() : List<CategoriesResponse>

    fun getCategory(categoryId: Long) : CategoriesResponse

    fun getPaginatedCategoryList(pageable : Pageable, status : String?) : Page<CategoriesResponse>?
}