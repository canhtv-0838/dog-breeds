package com.sun.dogbreeds.di

import com.sun.dogbreeds.data.repsitory.BreedInfoRepository
import com.sun.dogbreeds.data.repsitory.BreedRemoteRepository
import com.sun.dogbreeds.data.repsitory.BreedsLocalRepository
import com.sun.dogbreeds.data.repsitory.FavoriteRepository
import com.sun.dogbreeds.data.source.local.BreedLocalDataSource
import com.sun.dogbreeds.data.source.local.FavoriteLocalDataSource
import com.sun.dogbreeds.data.source.remote.BreedInfoRemoteDataSource
import com.sun.dogbreeds.data.source.remote.BreedRemoteDataSource
import com.sun.dogbreeds.utils.KoinNames
import org.koin.core.qualifier.named
import org.koin.dsl.module

val sourceModule = module {

    single(named(KoinNames.BREED_LOCAL_DATA_SOURCE)) {
        BreedLocalDataSource(appDatabase = get(named(KoinNames.APP_DATABASE)))
    }

    single(named(KoinNames.BREED_LOCAL_REPOSITORY)) {
        BreedsLocalRepository(localDataSource = get(named(KoinNames.BREED_LOCAL_DATA_SOURCE)))
    }

    single(named(KoinNames.BREED_REMOTE_REPOSITORY)) {
        BreedRemoteRepository(dataSource = get(named(KoinNames.BREED_REMOTE_DATA_SOURCE)))
    }

    single(named(KoinNames.BREED_INFO_REPOSITORY)) {
        BreedInfoRepository(dataSource = get(named(KoinNames.BREED_INFO_REMOTE_DATA_SOURCE)))
    }

    single(named(KoinNames.BREED_INFO_REMOTE_DATA_SOURCE)) {
        BreedInfoRemoteDataSource(theDogApi = get(named(KoinNames.THE_DOG_API)))
    }

    single(named(KoinNames.BREED_REMOTE_DATA_SOURCE)) {
        BreedRemoteDataSource(dogCeoApi = get(named(KoinNames.DOG_CEO_API)))
    }

    single(named(KoinNames.FAVORITE_DATA_SOURCE)) {
        FavoriteLocalDataSource(appDatabase = get(named(KoinNames.APP_DATABASE)))
    }

    single(named(KoinNames.FAVORITE_REPOSITORY)) {
        FavoriteRepository(dataSource = get(named(KoinNames.FAVORITE_DATA_SOURCE)))
    }
}
