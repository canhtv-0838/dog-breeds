package com.sun.dogbreeds.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel> : Fragment(), LifecycleOwner {

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

        initComponents()
        setBindingVariables()
        initData()
        observeData()
    }

    protected abstract fun initComponents()

    protected open fun initData() {
        viewModel.create()
    }

    protected open fun observeData() {
        viewModel.messageNotification.observe(this, Observer {
            toast(it)
        })
    }

    open fun setBindingVariables() {
    }

    protected fun replaceFragment(id: Int, fragment: Fragment, addToBackStack: Boolean) =
        activity?.supportFragmentManager?.beginTransaction()?.replace(id, fragment)?.apply {
            if (addToBackStack) addToBackStack(null)
        }?.commit()

    protected fun addFragment(id: Int, fragment: Fragment, addToBackStack: Boolean) =
        activity?.supportFragmentManager?.beginTransaction()?.add(id, fragment)?.apply {
            if (addToBackStack) addToBackStack(null)
        }?.commit()

    private fun toast(message: String) = context?.let {
        Toast.makeText(it, message, Toast.LENGTH_SHORT).show()
    }
}
