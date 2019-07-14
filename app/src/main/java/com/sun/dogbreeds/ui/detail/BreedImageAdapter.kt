package com.sun.dogbreeds.ui.detail

import android.view.ViewGroup
import com.sun.dogbreeds.R
import com.sun.dogbreeds.databinding.ItemBreedImageBinding
import com.sun.dogbreeds.ui.base.BaseRecyclerAdapter

class BreedImageAdapter : BaseRecyclerAdapter<String, ItemBreedImageBinding, BreedImageAdapter.BreedImageViewHolder>() {

    override fun getItemLayoutResource(viewType: Int): Int = R.layout.item_breed_image

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedImageViewHolder = BreedImageViewHolder(
        binding = getViewHolderDataBinding(parent, viewType) as ItemBreedImageBinding
    )

    class BreedImageViewHolder(
        binding: ItemBreedImageBinding
    ) : BaseRecyclerAdapter.BaseViewHolder<String, ItemBreedImageBinding>(binding) {

        override fun onBindData(itemData: String) {
            binding.imageUrl = itemData
        }
    }
}
