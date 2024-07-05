package com.hercute.mcrabe.global.error.exception.status

data class EmailAlreadyExistException(val email: String) : RuntimeException(
    "이미 존재하는 이메일 입니다."
)
