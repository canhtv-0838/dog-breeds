package com.sun.dogbreeds.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun.dogbreeds.coroutine.CoroutineResult
import com.sun.dogbreeds.data.db.entity.BreedInfo
import com.sun.dogbreeds.data.repsitory.FavoriteRepository
import com.sun.dogbreeds.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class FavoriteViewModel(private val repository: FavoriteRepository) : BaseViewModel() {

    private val _favorites = MutableLiveData<List<BreedInfo>>()
    val favorites: LiveData<List<BreedInfo>>
        get() = _favorites

    override fun create() {
        getFavorites()
    }

    private fun getFavorites() = launch {
        val result = repository.getFavorites()
        _favorites.value = if (result is CoroutineResult.Success) {
            result.data
        } else {
            if (result is CoroutineResult.Error) messageNotification.value = result.throwable.message.toString()
            emptyList()
        }
        notifyChange()
    }
}
