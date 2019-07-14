package com.sun.dogbreeds.ui.detail

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import com.google.android.material.appbar.AppBarLayout
import com.sun.dogbreeds.R
import com.sun.dogbreeds.data.db.entity.BreedInfo
import com.sun.dogbreeds.databinding.FragmentDetailBinding
import com.sun.dogbreeds.ui.base.BaseFragment
import com.sun.dogbreeds.ui.base.OnFragmentInteractionListener
import com.sun.dogbreeds.ui.favorite.FavoriteFragment
import com.sun.dogbreeds.utils.Constants
import com.sun.dogbreeds.utils.KoinNames
import kotlinx.android.synthetic.main.fragment_detail.*
import org.koin.android.ext.android.get
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

private const val TAG = "DetailFragment"

class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>(),
    AppBarLayout.OnOffsetChangedListener,
    Toolbar.OnMenuItemClickListener {

    override val layoutResource: Int = R.layout.fragment_detail

    override val viewModel: DetailViewModel by viewModel()

    private val imageAdapter: BreedImageAdapter = get(named(KoinNames.BREED_IMAGE_ADAPTER))

    private var listener: OnFragmentInteractionListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) listener = context
    }

    override fun initComponents() {
        initAppBar()
        initRecyclerView()
    }

    private fun initAppBar() {
        toolbar?.run {
            inflateMenu(R.menu.menu_collapsed_toolbar)

            setOnMenuItemClickListener(this@DetailFragment)

            setNavigationOnClickListener {
                activity?.onBackPressed()
            }
        }
        appbar?.addOnOffsetChangedListener(this)
    }

    private fun initRecyclerView() {
        recyclerImages?.adapter = imageAdapter
    }

    override fun initData() {
        super.initData()

        (arguments?.getParcelable<BreedInfo>(Constants.EXTRA_BREED_INFO))?.let { breedInfo ->
            viewModel.breedInfoData.value = breedInfo
        }
    }

    override fun observeData() = with(viewModel) {
        super.observeData()

        breedInfoData.observe(this@DetailFragment, Observer { data ->
            data?.let {
                getData(breedInfo = it)
            }
        })

        images.observe(this@DetailFragment, Observer { urls ->
            urls?.let {
                imageAdapter.updateData(it)
            }
        })

        detailInfo.observe(this@DetailFragment, Observer { info ->
            info?.let {
                notifyChange()
            }
        })
    }

    override fun setBindingVariables() {
        viewDataBinding.run {
            this.bindingViewModel = this@DetailFragment.viewModel
            lifecycleOwner = this@DetailFragment
        }
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean =
        item?.let {
            if (it.itemId == R.id.item_favorite_detail) listener?.onScreenChange(FavoriteFragment())
            true
        } ?: false

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, offset: Int) = with(viewModel) {
        if (isDisplayingFavoriteButton.value != (offset == 0)) {
            isDisplayingFavoriteButton.value = offset == 0
            notifyChange()
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {
        @JvmStatic
        fun newInstance(breedInfo: BreedInfo) = DetailFragment().apply {
            arguments = Bundle().apply { putParcelable(Constants.EXTRA_BREED_INFO, breedInfo) }
        }
    }
}
