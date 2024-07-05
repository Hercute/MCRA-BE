package com.hercute.mcrabe.domain.recipe.controller

import com.hercute.mcrabe.domain.recipe.dto.tag.CreateTagRequest
import com.hercute.mcrabe.domain.recipe.dto.tag.TagResponse
import com.hercute.mcrabe.domain.recipe.dto.tag.UpdateTagRequest
import com.hercute.mcrabe.domain.recipe.service.TagService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController

@RequestMapping("/tags")
class TagController(
    private val tagService: TagService
) {
    //@Operation(summary = "레시피 생성")
    @Transactional
    @PostMapping
    fun createTag(
        @Valid @RequestBody request: CreateTagRequest,
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(tagService.createTag(request))
    }

    //@Operation(summary = "레시피 단건 조회")
    @Transactional
    @GetMapping("/{tagId}")
    fun getTag(
        @PathVariable tagId: Long,
    ): ResponseEntity<TagResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(tagService.getTag(tagId))
    }

    //@Operation(summary = "레시피 통합 조회")
    @Transactional
    @GetMapping("/tagList")
    fun getTagList(
        // 조회 조건 추가 필요
    ): ResponseEntity<Page<TagResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(tagService.getTagList())
    }

    @Transactional
    @PutMapping("/{tagId}")
    fun updateTagMap(
        @PathVariable tagId: Long,
        @Valid @RequestBody request: UpdateTagRequest
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(tagService.updateTag(tagId, request))
    }

    @Transactional
    @DeleteMapping("/{tagId}")
    fun deleteRecipeList(
        @PathVariable tagId: Long,
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .body(tagService.deleteTag(tagId))
    }
}