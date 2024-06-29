package com.example.recipes_app.presentation.ui.fragments.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding


// TODO: todo!!!!!!

abstract class BaseFragment<ViewModel: BaseViewModel, Binding: ViewBinding>(
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {

    protected abstract val viewModel: ViewModel
    protected abstract val binding: Binding

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
        setupListeners()
        setupRequests()
        setupSubscribers()
    }

    abstract fun initialize()

    abstract fun setupListeners()

    abstract fun setupRequests()

    abstract fun setupSubscribers()
}