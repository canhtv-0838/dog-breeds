package com.sun.dogbreeds.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun.dogbreeds.R
import com.sun.dogbreeds.coroutine.getData
import com.sun.dogbreeds.data.db.entity.BreedInfo
import com.sun.dogbreeds.data.model.BreedDetail
import com.sun.dogbreeds.data.repsitory.BreedInfoRepository
import com.sun.dogbreeds.data.repsitory.BreedRemoteRepository
import com.sun.dogbreeds.data.repsitory.FavoriteRepository
import com.sun.dogbreeds.ui.base.BaseViewModel
import com.sun.dogbreeds.utils.Constants
import com.sun.dogbreeds.utils.KoinNames
import com.sun.dogbreeds.utils.limit
import kotlinx.coroutines.launch
import org.koin.core.get
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named

private const val TAG = "DetailViewModel"

class DetailViewModel(
    private val favoriteRepository: FavoriteRepository,
    private val infoRepository: BreedInfoRepository,
    private val imageRepository: BreedRemoteRepository
) : BaseViewModel() {

    val breedInfoData = MutableLiveData<BreedInfo>()

    val isDisplayingFavoriteButton = MutableLiveData<Boolean>().apply { value = true }

    private val _images = MutableLiveData<List<String>>().apply { value = emptyList() }
    val images: LiveData<List<String>>
        get() = _images

    private val _isFavoriteBreed = MutableLiveData<Boolean>()
    val isFavoriteBreed: LiveData<Boolean>
        get() = _isFavoriteBreed

    private val _detailInfo = MutableLiveData<BreedDetail>().apply {
        value = get(named(KoinNames.EMPTY_BREED_DETAIL_INFO))
    }
    val detailInfo: LiveData<BreedDetail>
        get() = _detailInfo

    override fun create() {
        breedInfoData.value?.let {
            getFavoriteStatus(name = it.name)
        }
    }

    fun getData(breedInfo: BreedInfo) {
        getBreedDetailInfo(name = breedInfo.name)

        getFavoriteStatus(name = breedInfo.name)

        breedInfo.altName?.let { altName ->
            getBreedImages(name = altName)
        }
    }

    private fun getBreedDetailInfo(name: String) = launch {

        _detailInfo.value = infoRepository.getBreedInfo(name).getData(
            onSuccess = { responses ->
                BreedDetail(response = responses[0])
            },
            onFailed = { throwable ->
                messageNotification.value = throwable.message.toString()
                get(named(KoinNames.EMPTY_BREED_DETAIL_INFO))
            }
        )
    }

    private fun getFavoriteStatus(name: String) = launch {

        _isFavoriteBreed.value = favoriteRepository.isFavorite(name).getData(
            onSuccess = { isFavorite ->
                isFavorite
            },
            onFailed = { throwable ->
                messageNotification.value = throwable.message.toString()
                false
            }
        )
    }

    private fun getBreedImages(name: String) = launch {

        _images.value = imageRepository.getBreedImageUrls(name).getData(
            onSuccess = { response ->
                response.message.limit(value = Constants.LIMIT_IMAGES)
            },
            onFailed = { throwable ->
                messageNotification.value = throwable.message.toString()
                emptyList()
            }
        )
    }

    fun handleFavoriteBreed() = launch {
        _isFavoriteBreed.value?.let { isLoved ->
            breedInfoData.value?.let { breedInfo ->

                if (isLoved) {
                    favoriteRepository.removeFavorite(breedInfo)
                } else {
                    favoriteRepository.addFavorite(breedInfo)
                }
                _isFavoriteBreed.value = !isLoved
                notifyChange()
            }
        }
    }

    private fun getResourceString(id: Int): String = get(named(KoinNames.RESOURCE_STRING)) { parametersOf(id) }
}
