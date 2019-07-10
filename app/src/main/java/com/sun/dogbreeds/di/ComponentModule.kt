package com.sun.dogbreeds.di

import androidx.databinding.PropertyChangeRegistry
import com.sun.dogbreeds.data.db.entity.Breed
import com.sun.dogbreeds.data.model.BreedDetail
import com.sun.dogbreeds.ui.favorite.FavoriteAdapter
import com.sun.dogbreeds.ui.search.BreedAdapter
import com.sun.dogbreeds.utils.Constants
import com.sun.dogbreeds.utils.KoinNames
import org.koin.core.qualifier.named
import org.koin.dsl.module

val componentModule = module {

    single(named(KoinNames.BREED_ADAPTER)) {
        BreedAdapter()
    }

    single(named(KoinNames.FAVORITE_ADAPTER)) {
        FavoriteAdapter()
    }

    single(named(KoinNames.EMPTY_BREED)) {
        Breed(id = Constants.UNAVAILABLE_VALUE, name = Constants.NO_INFORMATION)
    }

    single(named(KoinNames.EMPTY_BREED_DETAIL_INFO)) {
        BreedDetail()
    }

    single(named(KoinNames.PROPERTY_CHANGE_REGISTRY)) {
        PropertyChangeRegistry()
    }
}
