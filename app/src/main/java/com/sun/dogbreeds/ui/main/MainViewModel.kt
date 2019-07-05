package com.sun.dogbreeds.ui.main

import androidx.lifecycle.MutableLiveData
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sun.dogbreeds.R
import com.sun.dogbreeds.ui.base.BaseViewModel

class MainViewModel : BaseViewModel() {

    val navigationItemSelectedId: MutableLiveData<Int> = MutableLiveData<Int>().apply {
        value = R.id.item_search
    }

    override fun create() {
    }
}
