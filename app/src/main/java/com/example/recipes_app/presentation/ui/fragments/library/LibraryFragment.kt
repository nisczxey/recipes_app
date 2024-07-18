package com.example.recipes_app.presentation.ui.fragments.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recipes_app.databinding.FragmentLibraryBinding
import com.example.recipes_app.presentation.ui.fragments.library.adapter.LibraryListAdapter
import com.example.recipes_app.presentation.utils.showToast
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


    private fun init(){

        val adapter = LibraryListAdapter()

        binding.rvLibraryList.adapter = adapter

        viewModel.recipesLiveData.observe(viewLifecycleOwner){ data ->
            if (data.isLoading){
                showToast("loading")
            } else{
                if (data.error.isNotBlank()){
                    showToast("error")
                } else{
                    if (data.list.isNotEmpty()){
                    adapter.submitList(data.list)
                    } else{
                        showToast("Library List is empty")
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