package com.hercute.mcrabe.global.error.exception

data class CategoriesAlreadyExistException (val msg: String) : RuntimeException(
    "이미 존재하는 분류입니다."
)