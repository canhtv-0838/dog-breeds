package com.sun.dogbreeds.data.source

private const val MSG_DATA_NOT_FOUND = "Data not found in data source"

open class DataSourceException(message: String? = null) : Exception(message)

class DataNotAvailableException : DataSourceException(MSG_DATA_NOT_FOUND)
