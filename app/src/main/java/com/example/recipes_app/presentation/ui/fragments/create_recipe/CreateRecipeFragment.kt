package com.example.recipes_app.presentation.ui.fragments.create_recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recipes_app.R
import com.example.recipes_app.databinding.FragmentCreateRecipeBinding
import com.example.recipes_app.presentation.utils.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateRecipeFragment : Fragment() {

    private var _binding: FragmentCreateRecipeBinding? = null
    private val binding: FragmentCreateRecipeBinding
        get() = _binding
            ?: throw RuntimeException(getString(R.string.createrecipebinding_is_null))

    private val viewModel: CreateRecipeViewModel by viewModel<CreateRecipeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateRecipeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            TODO()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}