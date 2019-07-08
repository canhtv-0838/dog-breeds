package com.sun.dogbreeds.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sun.dogbreeds.R

object BindingAdapters {

    @BindingAdapter("adapter")
    @JvmStatic
    fun setRecyclerAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
        view.adapter = adapter
    }

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun setImageUrl(view: ImageView, url: String?) {
        url?.let { Glide.with(view.context).load(it).placeholder(R.color.color_gray).into(view) }
    }
}
