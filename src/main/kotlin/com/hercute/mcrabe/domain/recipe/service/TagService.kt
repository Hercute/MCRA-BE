package com.hercute.mcrabe.domain.recipe.service

import com.hercute.mcrabe.domain.recipe.dto.tag.CreateTagRequest
import com.hercute.mcrabe.domain.recipe.dto.tag.TagResponse
import com.hercute.mcrabe.domain.recipe.dto.tag.UpdateTagRequest
import com.hercute.mcrabe.domain.recipe.dto.tagMap.CreateTagMapRequest
import com.hercute.mcrabe.domain.recipe.dto.tagMap.TagMapResponse
import com.hercute.mcrabe.domain.recipe.dto.tagMap.UpdateTagMapRequest
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class TagService {
    fun createTag(request: CreateTagRequest){}
    fun updateTag(tagId: Long, request: UpdateTagRequest){}
    fun getTag(tagId:Long) : TagResponse {
        TODO()
    }
    fun getTagList() : Page<TagResponse> {
        TODO()
    }
    fun deleteTag(tagId: Long){}
}