package com.bhairab.cryptotracker.core.domain.util

/**
 * Created by Bilal Hairab on 25/10/2024.
 */
enum class NetworkError: Error {
    REQUEST_TIMEOUT,
    TOO_MANY_REQUESTS,
    NO_INTERNET,
    SERVER_ERROR,
    SERIALIZATION_ERROR,
    UNKNOWN_ERROR
}