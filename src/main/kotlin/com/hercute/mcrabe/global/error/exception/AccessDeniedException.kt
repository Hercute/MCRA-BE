package com.hercute.mcrabe.global.error.exception

data class AccessDeniedException(val id: Long) : RuntimeException(
    "권한이 없습니다."
)
