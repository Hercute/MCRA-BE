package com.hercute.mcrabe.global.error.exception

data class ModelNotFoundException(val model: String, val id: Long?) : RuntimeException(
    "Model $model not found with given id: $id"
)