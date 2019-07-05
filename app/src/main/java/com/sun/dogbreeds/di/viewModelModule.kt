package com.sun.dogbreeds.di

import com.sun.dogbreeds.ui.favorite.FavoriteViewModel
import com.sun.dogbreeds.ui.main.MainViewModel
import com.sun.dogbreeds.ui.search.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MainViewModel() }

    viewModel { SearchViewModel() }

    viewModel { FavoriteViewModel() }
}
