package com.sun.dogbreeds.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.sun.dogbreeds.data.api.ApiFactory
import com.sun.dogbreeds.data.api.DogCeoApi
import com.sun.dogbreeds.data.api.TheDogApi
import com.sun.dogbreeds.data.db.AppDatabase
import com.sun.dogbreeds.utils.KoinNames
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module{

    single(named(KoinNames.DOG_CEO_API)) {
        ApiFactory.buildRestApi(
            baseUrl = get(named(KoinNames.DOG_CEO_BASE_URL)),
            restApi = DogCeoApi::class.java,
            converterFactory = get(named(KoinNames.GSON_CONVERTER_FACTORY)),
            callAdapterFactory = get(named(KoinNames.COROUTINE_CALL_ADAPTER_FACTORY))
        )
    }

    single(named(KoinNames.THE_DOG_API)) {
        ApiFactory.buildRestApi(
            baseUrl = get(named(KoinNames.THE_DOG_API_BASE_URL)),
            restApi = TheDogApi::class.java,
            converterFactory = get(named(KoinNames.GSON_CONVERTER_FACTORY)),
            callAdapterFactory = get(named(KoinNames.COROUTINE_CALL_ADAPTER_FACTORY))
        )
    }

    single(named(KoinNames.COROUTINE_CALL_ADAPTER_FACTORY)) {
        CoroutineCallAdapterFactory()
    }

    single(named(KoinNames.GSON_CONVERTER_FACTORY)) {
        GsonConverterFactory.create()
    }

    single(named(KoinNames.DOG_CEO_BASE_URL)) {
        DogCeoApi.BASE_URL
    }

    single(named(KoinNames.THE_DOG_API_BASE_URL)) {
        TheDogApi.BASE_URL
    }

    single(named(KoinNames.APP_DATABASE)) {
        AppDatabase.getInstance(androidContext())
    }
}
