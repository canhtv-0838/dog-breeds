package com.sun.dogbreeds.di

import androidx.databinding.PropertyChangeRegistry
import com.sun.dogbreeds.data.api.response.DogCeoResponse
import com.sun.dogbreeds.data.api.response.TheDogApiResponse
import com.sun.dogbreeds.data.db.entity.Breed
import com.sun.dogbreeds.data.db.entity.BreedInfo
import com.sun.dogbreeds.data.model.BreedDetail
import com.sun.dogbreeds.ui.detail.BreedImageAdapter
import com.sun.dogbreeds.ui.favorite.FavoriteAdapter
import com.sun.dogbreeds.ui.search.BreedAdapter
import com.sun.dogbreeds.utils.KoinNames
import org.koin.core.qualifier.named
import org.koin.dsl.module

val componentModule = module {

    single(named(KoinNames.BREED_ADAPTER)) {
        BreedAdapter()
    }

    single(named(KoinNames.BREED_IMAGE_ADAPTER)) {
        BreedImageAdapter()
    }

    single(named(KoinNames.FAVORITE_ADAPTER)) {
        FavoriteAdapter()
    }

    single(named(KoinNames.EMPTY_BREED)) {
        Breed()
    }

    single(named(KoinNames.EMPTY_THE_DOG_API_RESPONSE)) {
        TheDogApiResponse(
            weight = get(named(KoinNames.EMPTY_WEIGHT)),
            height = get(named(KoinNames.EMPTY_HEIGHT))
        )
    }

    single(named(KoinNames.EMPTY_WEIGHT)) {
        TheDogApiResponse.Weight()
    }

    single(named(KoinNames.EMPTY_HEIGHT)) {
        TheDogApiResponse.Height()
    }

    single(named(KoinNames.EMPTY_DOG_CEO_API_RESPONSE)) {
        DogCeoResponse()
    }

    single(named(KoinNames.EMPTY_BREED_DETAIL_INFO)) {
        BreedDetail()
    }

    factory(named(KoinNames.BREED_INFO_FROM_BREED)) { (breed: Breed) ->
        BreedInfo(breed)
    }

    single(named(KoinNames.EMPTY_BREED_INFO)) {
        BreedInfo()
    }

    single(named(KoinNames.PROPERTY_CHANGE_REGISTRY)) {
        PropertyChangeRegistry()
    }
}
