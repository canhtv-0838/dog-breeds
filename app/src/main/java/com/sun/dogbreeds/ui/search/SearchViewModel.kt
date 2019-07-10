package com.sun.dogbreeds.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun.dogbreeds.coroutine.CoroutineResult
import com.sun.dogbreeds.data.db.entity.Breed
import com.sun.dogbreeds.data.repsitory.BreedsLocalRepository
import com.sun.dogbreeds.ui.base.BaseViewModel
import com.sun.dogbreeds.utils.match
import kotlinx.coroutines.launch

class SearchViewModel(private val repository: BreedsLocalRepository) : BaseViewModel() {

    val searchKey = MutableLiveData<String>()

    private val _searchResult = MutableLiveData<List<Breed>>()
    val searchResult: LiveData<List<Breed>>
        get() = _searchResult

    private val breeds = ArrayList<Breed>()

    override fun create() {
        getBreeds()
        searchBreeds()
    }

    private fun getBreeds() = launch {
        val result = repository.getBreeds()

        _searchResult.value = breeds.apply {
            addAll(
                when (result) {
                    is CoroutineResult.Success -> result.data

                    is CoroutineResult.Error -> {
                        messageNotification.value = result.throwable.message.toString()
                        emptyList()
                    }
                }
            )
        }
    }

    fun searchBreeds() {
        _searchResult.value = searchKey.value?.let { key ->
            breeds.filter { breed ->
                listOf(breed.name, breed.origin).match(key)
            }
        } ?: breeds
    }
}
