package com.example.recipes_app.presentation.ui.fragments.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.recipes_app.R
import com.example.recipes_app.databinding.FragmentDetailBinding
import com.example.recipes_app.presentation.model.RecipeUIO
import com.example.recipes_app.presentation.utils.loadImage
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    private val args by navArgs<DetailFragmentArgs>()
    private var _binding: FragmentDetailBinding? = null
    private val binding: FragmentDetailBinding
        get() = _binding
            ?: throw RuntimeException(getString(R.string.fragment_detail_binding_is_null))
    private val viewModel by viewModel<DetailViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getRecipe(args.id)
        viewModel.ld.observe(viewLifecycleOwner) { data ->
            showData(data)
        }
    }

    private fun showData(data: RecipeUIO) = with(binding) {
        tvName.text = data.name
        val areaText = tvArea.text.toString() + " " + data.area.toString()
        tvArea.text = areaText
        val categoryText = tvCategory.text.toString() + " " + data.category
        tvCategory.text = categoryText
        tvInstructions.text = data.instructions
        imgRecipe.loadImage(data.imgUrl.toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}