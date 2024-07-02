package com.hercute.mcrabe.domain.recipe.controller

import com.hercute.mcrabe.domain.recipe.dto.tagMap.CreateTagMapRequest
import com.hercute.mcrabe.domain.recipe.dto.tagMap.TagMapResponse
import com.hercute.mcrabe.domain.recipe.dto.tagMap.UpdateTagMapRequest
import com.hercute.mcrabe.domain.recipe.service.TagMapService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tagMaps")
class TagMapController (
    private val tagMapService: TagMapService
) {
    //@Operation(summary = "레시피 생성")
    @Transactional
    @PostMapping
    fun createTagMap(
        @RequestParam recipeId : Long,
        @Valid @RequestBody request: CreateTagMapRequest,
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(tagMapService.createTagMap(recipeId, request))
    }

    //@Operation(summary = "레시피 단건 조회")
    @Transactional
    @GetMapping("/{tagMapId}")
    fun getTagMap(
        @PathVariable tagMapId : Long,
    ): ResponseEntity<TagMapResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(tagMapService.getTagMap(tagMapId))
    }

    //@Operation(summary = "레시피 통합 조회")
    @Transactional
    @GetMapping("/tagMapList")
    fun getTagMapList(
        // 조회 조건 추가 필요
    ): ResponseEntity<Page<TagMapResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(tagMapService.getTagMapList())
    }

    @Transactional
    @PutMapping("/{tagMapId}")
    fun updateTagMap(
        @PathVariable tagMapId : Long,
        @Valid @RequestBody request: UpdateTagMapRequest
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(tagMapService.updateTagMap(tagMapId, request))
    }

    @Transactional
    @DeleteMapping("/{tagMapId}")
    fun deleteTagMap(
        @PathVariable tagMapId : Long,
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .body(tagMapService.deleteTagMap(tagMapId))
    }
}