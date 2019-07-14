package com.sun.dogbreeds.ui.main

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.sun.dogbreeds.R
import com.sun.dogbreeds.databinding.ActivityMainBinding
import com.sun.dogbreeds.ui.base.BaseActivity
import com.sun.dogbreeds.ui.base.OnFragmentInteractionListener
import com.sun.dogbreeds.ui.favorite.FavoriteFragment
import com.sun.dogbreeds.ui.search.SearchFragment
import com.sun.dogbreeds.utils.ScreenNavigator.backToFirstScreen
import com.sun.dogbreeds.utils.ScreenNavigator.getCurrentFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), OnFragmentInteractionListener {

    override val layoutResource: Int = R.layout.activity_main

    override val viewModel: MainViewModel by viewModel()

    override fun initComponents() {
        bottomNavigation?.setOnNavigationItemSelectedListener { menuItem ->
            viewModel.navigationItemSelectedId.value = menuItem.itemId
            true
        }
    }

    override fun observeData() {
        viewModel.navigationItemSelectedId.observe(this@MainActivity, Observer { itemId ->
            when (itemId) {
                R.id.item_search -> {
                    if (getCurrentFragment(this, R.id.frameMainContent) !is SearchFragment) {
                        replaceFragment(R.id.frameMainContent, SearchFragment(), false)
                    }
                }
                R.id.item_favorite -> replaceFragment(R.id.frameMainContent, FavoriteFragment(), false)
            }
        })
    }

    override fun onScreenChange(fragment: Fragment) {
        backToFirstScreen(this@MainActivity)

        viewModel.navigationItemSelectedId.value = when (fragment) {
            is SearchFragment -> R.id.item_search
            is FavoriteFragment -> R.id.item_favorite
            else -> R.id.item_search
        }.also {
            bottomNavigation?.selectedItemId = it
        }
    }
}
