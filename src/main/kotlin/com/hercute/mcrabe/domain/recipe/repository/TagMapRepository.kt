package com.hercute.mcrabe.domain.recipe.repository

import com.hercute.mcrabe.domain.recipe.model.TagMap
import org.springframework.data.jpa.repository.JpaRepository

interface TagMapRepository: JpaRepository<TagMap, Long> {
}