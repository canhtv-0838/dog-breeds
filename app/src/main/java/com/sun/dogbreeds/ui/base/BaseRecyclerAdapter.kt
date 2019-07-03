package com.sun.dogbreeds.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T, VB : ViewDataBinding, VH : BaseRecyclerAdapter.BaseViewHolder<T, VB>>
    : RecyclerView.Adapter<VH>() {

    private val items = ArrayList<T>()

    abstract fun getItemLayoutResource(viewType: Int): Int

    override fun onBindViewHolder(holder: VH, position: Int) = holder.onBindData(items[position])

    override fun getItemCount(): Int = items.size

    fun updateData(newItems: List<T>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    fun insertData(data: List<T>) {
        val oldPosition = itemCount
        items.addAll(data)
        val newPosition = itemCount
        if (newPosition > oldPosition) notifyItemRangeInserted(oldPosition, newPosition - 1)
    }

    protected fun getViewHolderDataBinding(parent: ViewGroup, viewType: Int): ViewDataBinding = DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        getItemLayoutResource(viewType),
        parent, false
    )

    protected fun getItemData(position: Int): T? = if (position in 0 until itemCount) items[position] else null

    open class BaseViewHolder<T, VB : ViewDataBinding>(protected val binding: VB) :
        RecyclerView.ViewHolder(binding.root) {

        open fun onBindData(itemData: T) {
        }

        open fun onBindData(itemPosition: Int, itemData: T) {
        }
    }
}
