package com.hercute.mcrabe.domain.recipe.service

import com.hercute.mcrabe.domain.recipe.dto.tagMap.CreateTagMapRequest
import com.hercute.mcrabe.domain.recipe.dto.tagMap.TagMapResponse
import com.hercute.mcrabe.domain.recipe.dto.tagMap.UpdateTagMapRequest
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class TagMapService {
    fun createTagMap(recipeId : Long, request: CreateTagMapRequest){}
    fun updateTagMap(tagMapId: Long, request: UpdateTagMapRequest){}
    fun getTagMap(tagMapId:Long) : TagMapResponse{
        TODO()
    }
    fun getTagMapList() : Page<TagMapResponse>{
        TODO()
    }
    fun deleteTagMap(tagMapId: Long){}

}