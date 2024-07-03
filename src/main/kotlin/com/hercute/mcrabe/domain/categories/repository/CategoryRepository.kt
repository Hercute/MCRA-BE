package com.hercute.mcrabe.domain.categories.repository

import com.hercute.mcrabe.domain.categories.model.Categories
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Categories, Long> , CustomCategoriesRepository{
    fun existsByMain(main : String) : Boolean
    fun existsBySub(sub : String) : Boolean
}
