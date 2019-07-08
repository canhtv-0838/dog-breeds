package com.sun.dogbreeds.di

import com.sun.dogbreeds.data.repsitory.BreedsLocalRepository
import com.sun.dogbreeds.data.source.local.BreedLocalDataSource
import com.sun.dogbreeds.utils.KoinNames
import org.koin.core.qualifier.named
import org.koin.dsl.module

val sourceModule = module{

    single(named(KoinNames.BREEDS_LOCAL_DATA_SOURCE)) {
        BreedLocalDataSource(appDatabase = get(named(KoinNames.APP_DATABASE)))
    }

    single(named(KoinNames.BREEDS_LOCAL_REPOSITORY)) {
        BreedsLocalRepository(localDataSource = get(named(KoinNames.BREEDS_LOCAL_DATA_SOURCE)))
    }
}
