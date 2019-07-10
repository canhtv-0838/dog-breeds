package com.sun.dogbreeds.ui.favorite

import android.view.ViewGroup
import com.sun.dogbreeds.R
import com.sun.dogbreeds.data.db.entity.BreedInfo
import com.sun.dogbreeds.databinding.ItemFavoriteBinding
import com.sun.dogbreeds.ui.base.BaseRecyclerAdapter

class FavoriteAdapter : BaseRecyclerAdapter<BreedInfo, ItemFavoriteBinding, FavoriteAdapter.FavoriteViewHolder>() {

    var onItemClick: (info: BreedInfo) -> Unit = {}

    override fun getItemLayoutResource(viewType: Int): Int = R.layout.item_favorite

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder = FavoriteViewHolder(
        binding = getViewHolderDataBinding(parent, viewType) as ItemFavoriteBinding,
        onItemClick = onItemClick
    )

    class FavoriteViewHolder(
        binding: ItemFavoriteBinding,
        private val onItemClick: (breedInfo: BreedInfo) -> Unit
    ) : BaseViewHolder<BreedInfo, ItemFavoriteBinding>(binding) {

        override fun onBindData(itemData: BreedInfo) {
            super.onBindData(itemData)
            binding.breedInfo = itemData
        }

        override fun onItemClickListener(itemData: BreedInfo) = onItemClick(itemData)
    }
}
