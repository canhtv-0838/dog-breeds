package com.sun.dogbreeds.coroutine

import com.sun.dogbreeds.data.source.DataNotAvailableException
import kotlinx.coroutines.*
import kotlin.coroutines.resume

suspend fun <T : Any> Deferred<T>.awaitResult(): CoroutineResult<T> =
    suspendCancellableCoroutine { continuation ->

        GlobalScope.launch {
            try {
                val response = await()
                if (response.isNotAvailable()) {
                    throw DataNotAvailableException()
                } else {
                    continuation.resume(CoroutineResult.Success(response))
                }
            } catch (e: Throwable) {
                continuation.resume(CoroutineResult.Error(e))
            }
        }
        registerOnCompletion(continuation)
    }

private fun Deferred<*>.registerOnCompletion(continuation: CancellableContinuation<*>) {
    continuation.invokeOnCancellation {
        if (continuation.isCancelled)
            try {
                cancel()
            } catch (ex: Throwable) {
                ex.printStackTrace()
            }
    }
}

private fun <RESPONSE> RESPONSE.isNotAvailable(): Boolean = this == null || (this is List<*> && isEmpty())
