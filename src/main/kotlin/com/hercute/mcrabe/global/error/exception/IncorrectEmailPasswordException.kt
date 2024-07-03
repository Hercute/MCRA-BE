package com.hercute.mcrabe.global.error.exception

data class IncorrectEmailPasswordException (val msg: String) : RuntimeException(
    "잘못된 이메일 또는 비밀번호 입니다."
)