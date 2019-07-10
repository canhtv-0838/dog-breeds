package com.sun.dogbreeds.di

import com.sun.dogbreeds.ui.favorite.FavoriteViewModel
import com.sun.dogbreeds.ui.main.MainViewModel
import com.sun.dogbreeds.ui.search.SearchViewModel
import com.sun.dogbreeds.utils.KoinNames
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MainViewModel() }

    viewModel { SearchViewModel(repository = get(named(KoinNames.BREED_LOCAL_REPOSITORY))) }

    viewModel { FavoriteViewModel(repository = get(named(KoinNames.FAVORITE_REPOSITORY))) }
}
