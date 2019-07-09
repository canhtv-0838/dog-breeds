package com.sun.dogbreeds.di

import androidx.databinding.PropertyChangeRegistry
import com.sun.dogbreeds.ui.search.BreedAdapter
import com.sun.dogbreeds.utils.KoinNames
import org.koin.core.qualifier.named
import org.koin.dsl.module

val componentModule = module {

    single(named(KoinNames.BREED_ADAPTER)) {
        BreedAdapter()
    }

    single(named(KoinNames.PROPERTY_CHANGE_REGISTRY)) {
        PropertyChangeRegistry()
    }
}
