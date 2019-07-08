package com.sun.dogbreeds.utils

fun List<String?>.match(filter: String): Boolean = this.any { element ->
    element?.toLowerCase()?.contains(filter.toLowerCase()) ?: false
}
