package com.sun.dogbreeds.utils

import kotlin.math.min

fun List<String?>.match(filter: String): Boolean = this.any { element ->
    element?.toLowerCase()?.contains(filter.toLowerCase()) ?: false
}

fun List<String>.limit(value: Int) = this.subList(0, min(value, size))
