package com.hercute.mcrabe.domain.recipe.controller

import com.hercute.mcrabe.domain.recipe.dto.step.CreateStepRequest
import com.hercute.mcrabe.domain.recipe.dto.step.StepResponse
import com.hercute.mcrabe.domain.recipe.dto.step.UpdateStepRequest
import com.hercute.mcrabe.domain.recipe.dto.tag.CreateTagRequest
import com.hercute.mcrabe.domain.recipe.dto.tag.TagResponse
import com.hercute.mcrabe.domain.recipe.dto.tag.UpdateTagRequest
import com.hercute.mcrabe.domain.recipe.service.StepService
import com.hercute.mcrabe.domain.recipe.service.TagService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController

@RequestMapping("/steps")
class StepController(
    private val stepService: StepService
) {
    //@Operation(summary = "스탭 생성")
    @Transactional
    @PostMapping
    fun createStep(
        @Valid @RequestBody request: CreateStepRequest,
        @RequestParam recipeId : Long,
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(stepService.createStep(recipeId, request))
    }

    //@Operation(summary = "스탭 단건 조회")
    @Transactional
    @GetMapping("/{stepId}")
    fun getStep(
        @PathVariable stepId: Long,
    ): ResponseEntity<StepResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(stepService.getStep(stepId))
    }

    //@Operation(summary = "스탭 통합 조회")
    @Transactional
    @GetMapping("/stepList")
    fun getStepList(
        // 조회 조건 추가 필요
    ): ResponseEntity<Page<StepResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(stepService.getStepList())
    }

    @Transactional
    @PutMapping("/{stepId}")
    fun updateStepMap(
        @PathVariable stepId: Long,
        @Valid @RequestBody request: UpdateStepRequest
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(stepService.updateStep(stepId, request))
    }

    @Transactional
    @DeleteMapping("/{stepId}")
    fun deleteStep(
        @PathVariable stepId: Long,
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .body(stepService.deleteStep(stepId))
    }
}