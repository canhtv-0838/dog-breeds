package com.sun.dogbreeds.coroutine

sealed class CoroutineResult<out T : Any> {

    class Success<out T : Any>(val data: T) : CoroutineResult<T>()

    class Error(val throwable: Throwable) : CoroutineResult<Nothing>()
}
