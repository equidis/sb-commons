package com.github.jntakpe.commons.test

import reactor.core.publisher.Mono

interface TestInitializer<T> {

    fun init(): List<T>

    fun clean(): Mono<Void>
}
