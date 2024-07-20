package com.example.recipes_app.presentation.ui.fragments.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipes_app.R
import com.example.recipes_app.databinding.FragmentSearchBinding
import com.example.recipes_app.presentation.ui.fragments.search.adapters.CategorySliderAdapter
import com.example.recipes_app.presentation.ui.fragments.search.adapters.RecipesSliderAdapter
import com.example.recipes_app.presentation.ui.fragments.search.bottom_sheet.ModalBottomSheetDialog
import com.example.recipes_app.presentation.utils.inVisible
import com.example.recipes_app.presentation.utils.showToast
import com.example.recipes_app.presentation.utils.visible
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding
        get() = _binding
            ?: throw RuntimeException(getString(R.string.binding_in_fragment_main_is_null))

    private lateinit var categoryAdapter: CategorySliderAdapter
    private lateinit var recipeAdapter: RecipesSliderAdapter


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

        binding.tvViewAll.setOnClickListener {
            val modalBottomSheet = ModalBottomSheetDialog()
            parentFragmentManager.let {
                modalBottomSheet.show(it, ModalBottomSheetDialog.BOTTOM_TAG)
            }
        }

        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.mealCategorySlider.layoutManager = layoutManager

        categoryAdapter = CategorySliderAdapter(requireContext()) { category ->
            viewModel.getLimitedRecipesByCategory(category)
            binding.tvCategoryName.text = category
        }

        binding.mealCategorySlider.adapter = categoryAdapter

        viewModel.categoryStateLD.observe(viewLifecycleOwner) { result ->
            with(binding) {
                if (result.isLoading) {
                    if (mealCategorySlider.isVisible) {
                        mealSlider.inVisible()
                        mainProgressBar.visible()
                        tvCategoryName.inVisible()
                    }
                } else {
                    if (result.error.isNotBlank()) {
                        showToast(getString(R.string.something_went_wrong))
                    } else {
                        categoryAdapter.submitList(result.list)
                        mainProgressBar.inVisible()
                        tvCategoryName.visible()
                        mealCategorySlider.visible()
                    }
                }

            }
        }

        val layoutManager2 =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.mealSlider.layoutManager = layoutManager2

        val lambda = fun (id: String){
            findNavController().navigate(
                SearchFragmentDirections.actionNavigationSearchToNavigationDetailPage(id)
            )
        }
        val labmda2 = fun(id:String){
            viewModel.saveRecipe(id)

        }

        recipeAdapter = RecipesSliderAdapter(requireContext(), lambda,labmda2)

        binding.mealSlider.adapter = recipeAdapter

        viewModel.recipesStateLD.observe(viewLifecycleOwner) { data ->
            with(binding) {
                if (data.isLoading) {
                    if (mealSlider.isVisible) {
                        binding.mealSlider.inVisible()
                        progressBarRecipes.visible()
                    }
                } else {
                    if (data.error.isNotBlank()) {
                        showToast(getString(R.string.something_went_wrong))
                    } else {
                        recipeAdapter.submitList(data.list)
                        tvViewAll.visible()
                        progressBarRecipes.inVisible()
                        mealSlider.visible()
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}