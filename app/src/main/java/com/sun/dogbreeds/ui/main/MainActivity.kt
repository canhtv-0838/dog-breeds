package com.sun.dogbreeds.ui.main

import androidx.lifecycle.Observer
import com.sun.dogbreeds.R
import com.sun.dogbreeds.databinding.ActivityMainBinding
import com.sun.dogbreeds.ui.base.BaseActivity
import com.sun.dogbreeds.ui.favorite.FavoriteFragment
import com.sun.dogbreeds.ui.search.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutResource: Int = R.layout.activity_main

    override val viewModel: MainViewModel by viewModel()

    override fun initComponents() {
        bottomNavigation?.setOnNavigationItemSelectedListener { menuItem ->
            viewModel.navigationItemSelectedId.value = menuItem.itemId
            true
        }
    }

    override fun observeData() {
        viewModel.navigationItemSelectedId.observe(this@MainActivity, Observer {
            when (it) {
                R.id.item_search -> replaceFragment(R.id.frameMainContent, SearchFragment(), false)
                R.id.item_favorite -> replaceFragment(R.id.frameMainContent, FavoriteFragment(), false)
            }
        })
    }
}
