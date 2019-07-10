package com.sun.dogbreeds.ui.favorite

import androidx.lifecycle.Observer
import com.sun.dogbreeds.R
import com.sun.dogbreeds.databinding.FragmentFavoriteBinding
import com.sun.dogbreeds.ui.base.BaseFragment
import com.sun.dogbreeds.utils.KoinNames
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.koin.android.ext.android.get
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding, FavoriteViewModel>() {

    override val layoutResource: Int = R.layout.fragment_favorite

    override val viewModel: FavoriteViewModel by viewModel()

    private val favoriteAdapter: FavoriteAdapter = get(named(KoinNames.FAVORITE_ADAPTER))

    override fun initComponents() {
        recyclerFavorites?.adapter = favoriteAdapter
    }

    override fun setBindingVariables() {
        viewDataBinding.bindingViewModel = this@FavoriteFragment.viewModel
    }

    override fun observeData() {
        super.observeData()

        viewModel.favorites.observe(this, Observer { breedInfos ->
            breedInfos?.let {
                favoriteAdapter.updateData(it)
            }
        })
    }
}
