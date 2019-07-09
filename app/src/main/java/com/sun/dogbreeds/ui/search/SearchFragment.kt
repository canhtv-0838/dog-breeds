package com.sun.dogbreeds.ui.search

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.Observer
import com.sun.dogbreeds.R
import com.sun.dogbreeds.databinding.FragmentSearchBinding
import com.sun.dogbreeds.ui.base.BaseFragment
import com.sun.dogbreeds.utils.KoinNames
import com.sun.dogbreeds.utils.hideSoftKeyboard
import com.sun.dogbreeds.utils.showSoftKeyboard
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.android.ext.android.get
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

private const val TAG = "SearchFragment"

class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>(), View.OnClickListener {

    override val layoutResource: Int = R.layout.fragment_search

    override val viewModel: SearchViewModel by viewModel()

    private val breedAdapter: BreedAdapter = get(named(KoinNames.BREED_ADAPTER))

    override fun initComponents() {
        initSearchBox()
        initRecyclerView()
        listenEvents()
    }

    private fun initSearchBox() = with(inputSearch) {
        setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                hideSoftKeyboard()
                true
            } else {
                false
            }
        }
        addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) = viewModel.searchBreeds()

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    private fun initRecyclerView() {
        recyclerBreeds?.adapter = breedAdapter.apply {
            onItemClick = {
                // change screen
            }
        }
    }

    private fun listenEvents() {
        imageSearch?.setOnClickListener(this)
        imageCancel?.setOnClickListener(this)
    }

    override fun observeData() {
        super.observeData()

        viewModel.searchResult.observe(this, Observer { breeds ->
            breeds?.let {
                breedAdapter.updateData(it)
            }
        })
    }

    override fun setBindingVariables() {
        viewDataBinding.viewModel = this@SearchFragment.viewModel
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.imageSearch -> showSearchBox()
            R.id.imageCancel -> hideSearchBox()
        }
    }

    private fun showSearchBox() {
        constraintSearchBox?.visibility = View.VISIBLE
        inputSearch?.showSoftKeyboard()
    }

    private fun hideSearchBox() {
        constraintSearchBox?.visibility = View.GONE
        inputSearch?.hideSoftKeyboard()
    }
}
