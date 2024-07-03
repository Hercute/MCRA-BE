package com.hercute.mcrabe.global.error.exception

data class AlreadyProcessedException (val msg: String) : RuntimeException(
    "이미 처리된 요청입니다."
)