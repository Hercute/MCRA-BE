package com.hercute.mcrabe.domain.categories.repository

import com.hercute.mcrabe.domain.categories.model.Categories
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Categories, Long> , CustonCategoriesRepository{
    fun existsBymain(main : String) : Boolean
    fun existsBysub(sub : String) : Boolean
}
