package com.example.recipes_app.presentation.ui.fragments.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipes_app.databinding.FragmentLibraryBinding
import com.example.recipes_app.presentation.ui.fragments.library.adapter.LibraryListAdapter
import com.example.recipes_app.presentation.ui.fragments.library.adapter.decoration.RecipeItemDecoration
import com.example.recipes_app.presentation.utils.showToast
import com.example.recipes_app.presentation.utils.toPx
import org.koin.androidx.viewmodel.ext.android.viewModel

class LibraryFragment : Fragment() {

    private var _binding: FragmentLibraryBinding? = null
    private val binding: FragmentLibraryBinding
        get() = _binding ?: throw RuntimeException("binding is null in LibraryFragment")

    private val viewModel by viewModel<LibraryViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLibraryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllRecipes()
        init()
    }


    private fun init() {

        val adapter = LibraryListAdapter()

        binding.rvLibraryList.adapter = adapter

        binding.rvLibraryList.addItemDecoration(
            DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        )

        binding.rvLibraryList.addItemDecoration(
            RecipeItemDecoration(
                bottomOffset = 16f.toPx(),
                topOffset = 16f.toPx()
            )
        )

        viewModel.recipesLiveData.observe(viewLifecycleOwner) { data ->
            if (data.isLoading) {
                showToast("loading")
            } else {
                if (data.error.isNotBlank()) {
                    showToast("error")
                } else {
                    adapter.submitList(data.list)
                }
            }
        }
        with(binding) {
            swipeRefreshLayout.setOnRefreshListener {
                viewModel.getAllRecipes()
                swipeRefreshLayout.isRefreshing = false
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}