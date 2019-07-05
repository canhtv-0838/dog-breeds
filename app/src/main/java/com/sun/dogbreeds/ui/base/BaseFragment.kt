package com.sun.dogbreeds.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    protected lateinit var viewDataBinding: VB
    protected abstract val layoutResource: Int
    protected abstract val viewModel: VM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        viewDataBinding = DataBindingUtil.inflate(inflater, layoutResource, container, false) as VB
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBindingVariables()
        initComponents()
        observeData()
    }

    open fun setBindingVariables() {
        viewModel.create()
    }

    protected abstract fun initComponents()

    protected abstract fun observeData()

    protected fun toast(message: String) = context?.let {
        Toast.makeText(it, message, Toast.LENGTH_SHORT).show()
    }
}
