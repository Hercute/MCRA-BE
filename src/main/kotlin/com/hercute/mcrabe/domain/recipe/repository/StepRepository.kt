package com.hercute.mcrabe.domain.recipe.repository

import com.hercute.mcrabe.domain.recipe.model.Step
import org.springframework.data.jpa.repository.JpaRepository

interface StepRepository : JpaRepository<Step, Long> {
}