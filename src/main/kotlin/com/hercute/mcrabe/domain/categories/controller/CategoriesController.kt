package com.hercute.mcrabe.domain.categories.controller

import com.hercute.mcrabe.domain.categories.dto.CategoriesResponse
import com.hercute.mcrabe.domain.categories.dto.CreateCategoriesRequest
import com.hercute.mcrabe.domain.categories.dto.UpdateCategoriesRequest
import com.hercute.mcrabe.domain.categories.service.CategoriesService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/categories")
class CategoriesController(
    private val categoriesService: CategoriesService
) {

    @PostMapping
    fun createCategory(
        @Valid @RequestBody request : CreateCategoriesRequest
    ) : ResponseEntity<Unit>{
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(categoriesService.createCategory(request))
    }

    @PostMapping("/{categoryId}")
    fun updateCategory(
        @PathVariable categoryId : Long,
        @Valid @RequestBody request : UpdateCategoriesRequest
    ) : ResponseEntity<Unit>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(categoriesService.updateCategory(categoryId, request))
    }

    @DeleteMapping("/{categoryId}")
    fun deleteCategory(
        @PathVariable categoryId: Long
    ) : ResponseEntity<Unit>{
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .body(categoriesService.deleteCategory(categoryId))
    }

    @GetMapping
    fun getcategoryList(
    ) : ResponseEntity<List<CategoriesResponse>>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(categoriesService.getCategoryList())
    }

    @GetMapping
    fun getCategory(
        @PathVariable categoryId: Long
    ) : ResponseEntity<CategoriesResponse>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(categoriesService.getCategory(categoryId))
    }
}