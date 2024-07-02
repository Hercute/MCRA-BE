package com.hercute.mcrabe.domain.categories.service

import com.hercute.mcrabe.domain.categories.dto.CategoriesResponse
import com.hercute.mcrabe.domain.categories.dto.CreateCategoriesRequest
import com.hercute.mcrabe.domain.categories.dto.UpdateCategoriesRequest
import com.hercute.mcrabe.domain.categories.model.Categories
import com.hercute.mcrabe.domain.categories.repository.CategoryRepository
import com.hercute.mcrabe.domain.categories.repository.CustonCategoriesRepository
import com.hercute.mcrabe.global.error.exception.ModelNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CategoriesServiceImpl(
    private val categoriesRepository: CategoryRepository
) : CategoriesService{
    override fun createCategory(request: CreateCategoriesRequest) {
        val category = Categories(
            main = request.main,
            sub = request.sub,
        )
        check(!categoriesRepository.existsBymain(request.main)){
            "이미 존재하는 대분류 입니다"
        }
        check(!categoriesRepository.existsBysub(request.sub)){
            "이미 존재하는 소분류 입니다"
        }
        categoriesRepository.save(category)
    }

    override fun updateCategory(categoryId: Long, request: UpdateCategoriesRequest) {
        val category = categoriesRepository.findByIdOrNull(categoryId)
            ?: throw ModelNotFoundException("Category", categoryId)
        check(!categoriesRepository.existsBymain(request.main)){
            "이미 존재하는 대분류 입니다"
        }
        check(!categoriesRepository.existsBysub(request.sub)){
            "이미 존재하는 소분류 입니다"
        }

        category.main = request.main
        category.sub = request.sub
        categoriesRepository.save(category)
    }

    override fun deleteCategory(categoryId: Long) {
        val categories = categoriesRepository.findByIdOrNull(categoryId)
            ?: throw ModelNotFoundException("Category", categoryId)
        categoriesRepository.delete(categories)
    }

    override fun getCategoryList(): List<CategoriesResponse> {
        val categoryList = categoriesRepository.findAll()
        return categoryList.map { CategoriesResponse.from(it) }
    }

    override fun getCategory(categoryId: Long): CategoriesResponse {
        val categories = categoriesRepository.findByIdOrNull(categoryId)
            ?: throw ModelNotFoundException("Category", categoryId)
        return CategoriesResponse.from(categories)
    }

    override fun getPaginatedCategoryList(pageable: Pageable, status: String?): Page<CategoriesResponse>? {
        return categoriesRepository.findByPageable(pageable).map { CategoriesResponse.from(it) }
    }
}