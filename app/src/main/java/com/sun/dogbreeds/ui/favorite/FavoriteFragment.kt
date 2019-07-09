package com.sun.dogbreeds.ui.favorite

import com.sun.dogbreeds.R
import com.sun.dogbreeds.databinding.FragmentFavoriteBinding
import com.sun.dogbreeds.ui.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding, FavoriteViewModel>() {

    override val layoutResource: Int = R.layout.fragment_favorite

    override val viewModel: FavoriteViewModel by viewModel()

    override fun initComponents() {
    }

    override fun initData() {
    }

    override fun observeData() {
    }
}
