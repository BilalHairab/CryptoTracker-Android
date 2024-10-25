package com.bhairab.cryptotracker.core.data.networking

import com.bhairab.cryptotracker.core.domain.util.NetworkError
import com.bhairab.cryptotracker.core.domain.util.Result
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

/**
 * Created by Bilal Hairab on 25/10/2024.
 */
//Review(4): reified (needs inline): because generic types are only available during compile time, not runtime => so, a suspending runtime function with generic return, would need reified also.
suspend inline fun <reified T> responseToResult(response: HttpResponse): Result<T, NetworkError> {
    return when(response.status.value) {
        in 200..299 -> {
            try {
                Result.Success(response.body<T>())
            } catch (e: NoTransformationFoundException) {
                Result.Error(NetworkError.SERIALIZATION_ERROR)
            }
        }
        408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
        429 -> Result.Error(NetworkError.TOO_MANY_REQUESTS)
        in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
        else -> Result.Error(NetworkError.UNKNOWN_ERROR)
    }
}