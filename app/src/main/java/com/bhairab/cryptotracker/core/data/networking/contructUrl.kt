package com.bhairab.cryptotracker.core.data.networking

import com.bhairab.cryptotracker.BuildConfig

/**
 * Created by Bilal Hairab on 25/10/2024.
 */

fun constructUrl(url: String): String {
    return when {
        url.startsWith(BuildConfig.BASE_URL) -> url
        url.startsWith("/")-> BuildConfig.BASE_URL + url.drop(1)
        else -> BuildConfig.BASE_URL + url
    }
}