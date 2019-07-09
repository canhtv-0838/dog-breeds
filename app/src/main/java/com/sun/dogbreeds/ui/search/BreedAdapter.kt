package com.sun.dogbreeds.ui.search

import android.view.ViewGroup
import com.sun.dogbreeds.R
import com.sun.dogbreeds.data.db.entity.Breed
import com.sun.dogbreeds.databinding.ItemBreedBinding
import com.sun.dogbreeds.ui.base.BaseRecyclerAdapter

class BreedAdapter : BaseRecyclerAdapter<Breed, ItemBreedBinding, BreedAdapter.BreedViewHolder>() {

    var onItemClick: (breed: Breed) -> Unit = {}

    override fun getItemLayoutResource(viewType: Int): Int = R.layout.item_breed

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder = BreedViewHolder(
        getViewHolderDataBinding(parent, viewType) as ItemBreedBinding,
        onItemClick
    )

    class BreedViewHolder(
        binding: ItemBreedBinding,
        private val onItemClick: (breed: Breed) -> Unit
    ) : BaseRecyclerAdapter.BaseViewHolder<Breed, ItemBreedBinding>(binding) {

        override fun onBindData(itemData: Breed) {
            super.onBindData(itemData)
            binding.itemBreed = itemData
        }

        override fun onItemClickListener(itemData: Breed) = onItemClick(itemData)
    }
}
