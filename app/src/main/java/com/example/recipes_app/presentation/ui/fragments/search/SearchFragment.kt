package com.example.recipes_app.presentation.ui.fragments.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipes_app.R
import com.example.recipes_app.databinding.FragmentSearchBinding
import com.example.recipes_app.presentation.model.CategoryUIO
import com.example.recipes_app.presentation.model.RecipeUIO
import com.example.recipes_app.presentation.ui.fragments.search.adapters.CategorySliderAdapter
import com.example.recipes_app.presentation.ui.fragments.search.adapters.RecipesSliderAdapter

class SearchFragment : Fragment() {

    private val viewModel: SearchViewModel by viewModels()

    private  var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding
        get() = _binding ?: throw RuntimeException(getString(R.string.binding_in_fragment_main_is_null))


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.init()
    }

    private fun init(){
        // TODO: implement all recipes RecyclerView
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
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
        adapter.submitList(listOf(
            CategoryUIO("","name","https://www.themealdb.com/images/media/meals/1548772327.jpg"),
            CategoryUIO("","name2","https://www.themealdb.com/images/media/meals/ysxwuq1487323065.jpg"),
            CategoryUIO("","name3", "https://www.themealdb.com/images/media/meals/uvuyxu1503067369.jpg"),
            CategoryUIO("","name4","https://www.themealdb.com/images/media/meals/1525873040.jpg"),
            CategoryUIO("","name","https://www.themealdb.com/images/media/meals/1548772327.jpg"),
            CategoryUIO("","name2","https://www.themealdb.com/images/media/meals/ysxwuq1487323065.jpg"),
            CategoryUIO("","name31", "https://www.themealdb.com/images/media/meals/uvuyxu1503067369.jpg"),
            CategoryUIO("","name41212","https://www.themealdb.com/images/media/meals/1525873040.jpg"),
            CategoryUIO("","name","https://www.themealdb.com/images/media/meals/1548772327.jpg"),
            CategoryUIO("","name2","https://www.themealdb.com/images/media/meals/ysxwuq1487323065.jpg"),
            CategoryUIO("","name32", "https://www.themealdb.com/images/media/meals/uvuyxu1503067369.jpg"),
            CategoryUIO("","name44","https://www.themealdb.com/images/media/meals/1525873040.jpg"),
            CategoryUIO("","name","https://www.themealdb.com/images/media/meals/1548772327.jpg"),
            CategoryUIO("","name2","https://www.themealdb.com/images/media/meals/ysxwuq1487323065.jpg"),
            CategoryUIO("","name3", "https://www.themealdb.com/images/media/meals/uvuyxu1503067369.jpg"),
            CategoryUIO("","name423","https://www.themealdb.com/images/media/meals/1525873040.jpg"),
            CategoryUIO("","name2323232","https://www.themealdb.com/images/media/meals/1548772327.jpg"),
            CategoryUIO("","name24242","https://www.themealdb.com/images/media/meals/ysxwuq1487323065.jpg"),
            CategoryUIO("","nam424e3", "https://www.themealdb.com/images/media/meals/uvuyxu1503067369.jpg"),
            CategoryUIO("","nam2424242424e4","https://www.themealdb.com/images/media/meals/1525873040.jpg")

        ))


        binding.mealCategorySlider.adapter = adapter

        val layoutManager2 =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.mealSlider.layoutManager = layoutManager2

        val recipeAdapter = RecipesSliderAdapter(requireContext())

        recipeAdapter.submitList(listOf(
            RecipeUIO("","name1sdasjdjasndjsanjdnjasndjsandjkasbdhjasnfbasjndkafnsjfashjbfjasfkjas", "", "", "https://www.themealdb.com/images/media/meals/41cxjh1683207682.jpg","",true),
            RecipeUIO("","name2", "", "", "https://www.themealdb.com/images/media/meals/xrttsx1487339558.jpg","",true),
            RecipeUIO("","name3", "", "", "https://www.themealdb.com/images/media/meals/mlchx21564916997.jpg","",true),
            RecipeUIO("","name4", "", "", "https://www.themealdb.com/images/media/meals/g373701551450225.jpg","",true),
            RecipeUIO("","name5", "", "", "https://www.themealdb.com/images/media/meals/urtqut1511723591.jpg","",true),
            RecipeUIO("","name6", "", "", "","",true),
            RecipeUIO("","name7", "", "", "https://www.themealdb.com/images/media/meals/urtqut1511723591.jpg","",true),
            RecipeUIO("","name8", "", "", "","",true),
        ))
        binding.mealSlider.adapter = recipeAdapter

        binding.tvViewAll.setOnClickListener {

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}