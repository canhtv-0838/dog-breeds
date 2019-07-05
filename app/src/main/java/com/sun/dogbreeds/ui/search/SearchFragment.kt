package com.sun.dogbreeds.ui.search

import com.sun.dogbreeds.R
import com.sun.dogbreeds.databinding.FragmentSearchBinding
import com.sun.dogbreeds.ui.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    override val layoutResource: Int = R.layout.fragment_search

    override val viewModel: SearchViewModel by viewModel()

    override fun initComponents() {
    }

    override fun observeData() {
    }
}
