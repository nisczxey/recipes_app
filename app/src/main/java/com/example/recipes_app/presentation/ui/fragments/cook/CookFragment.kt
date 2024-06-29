package com.example.recipes_app.presentation.ui.fragments.cook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recipes_app.databinding.FragmentCookBinding

class CookFragment : Fragment() {

    private var _binding: FragmentCookBinding? = null
    private val binding: FragmentCookBinding
        get() = _binding ?: throw RuntimeException("FragmentFavoritesBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCookBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}