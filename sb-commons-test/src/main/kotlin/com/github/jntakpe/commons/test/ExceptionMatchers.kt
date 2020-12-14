package com.github.jntakpe.commons.test

import com.github.jntakpe.commons.context.CommonException
import org.assertj.core.api.Assertions.assertThat
import org.springframework.http.HttpStatus
import reactor.test.StepVerifier

fun <T> StepVerifier.Step<T>.expectCommonException(status: HttpStatus, message: String? = null): StepVerifier {
    return consumeErrorWith { it.assertCommonException(status, message) }
}

fun Throwable.assertCommonException(expectedStatus: HttpStatus, expectedMessage: String? = null) {
    assertThat(this).isInstanceOf(CommonException::class.java)
    this as CommonException
    assertThat(status).isEqualTo(expectedStatus)
    expectedMessage?.also { assertThat(message).isEqualTo(it) }
}
