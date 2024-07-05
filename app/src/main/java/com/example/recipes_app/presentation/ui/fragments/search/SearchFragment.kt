package com.example.recipes_app.presentation.ui.fragments.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipes_app.R
import com.example.recipes_app.databinding.FragmentSearchBinding
import com.example.recipes_app.presentation.ui.fragments.search.adapters.CategorySliderAdapter
import com.example.recipes_app.presentation.ui.fragments.search.adapters.RecipesSliderAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding
        get() = _binding
            ?: throw RuntimeException(getString(R.string.binding_in_fragment_main_is_null))


    private val viewModel: SearchViewModel by viewModel<SearchViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllCategories()
        this.init()
    }

    private fun init() {
        // TODO: implement all recipes RecyclerView
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(finalText: String?): Boolean {
                // code
                return true
            }

            override fun onQueryTextChange(text: String?): Boolean {
                // code
                return true
            }

        })

        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.mealCategorySlider.layoutManager = layoutManager
        val adapter = CategorySliderAdapter(requireContext())
        adapter.submitList(emptyList())

        binding.mealCategorySlider.adapter = adapter

        viewModel.categoriesLD.observe(viewLifecycleOwner) { categories ->
            adapter.submitList(categories)
        }

        val layoutManager2 =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.mealSlider.layoutManager = layoutManager2

        val recipeAdapter = RecipesSliderAdapter(requireContext())

        recipeAdapter.submitList(emptyList())
        binding.mealSlider.adapter = recipeAdapter

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}