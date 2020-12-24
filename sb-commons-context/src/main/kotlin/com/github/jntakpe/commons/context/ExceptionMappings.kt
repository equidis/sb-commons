package com.github.jntakpe.commons.context

import org.springframework.http.HttpStatus

fun CommonException.toDto() = CommonExceptionDto(message, status.value())

fun CommonExceptionDto.toException(logging: (String, Throwable) -> Unit) = CommonException(message, logging, HttpStatus.valueOf(code))
