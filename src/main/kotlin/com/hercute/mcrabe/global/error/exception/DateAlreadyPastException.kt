package com.hercute.mcrabe.global.error.exception

data class DateAlreadyPastException (val msg: String) : RuntimeException(
    "이미 지난 날짜입니다."
)