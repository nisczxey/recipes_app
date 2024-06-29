package com.example.recipes_app.presentation.ui.fragments.onBoarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.recipes_app.R
import com.example.recipes_app.databinding.FragmentOnBoardingBinding
import com.example.recipes_app.presentation.ui.fragments.onBoarding.adapter.OnBoardingAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class OnBoardingFragment : Fragment() {

    private var  _binding: FragmentOnBoardingBinding? = null
    private val binding:FragmentOnBoardingBinding
        get() = _binding ?: throw RuntimeException("FragmentOnBoarding binding is null")

    private val adapter = OnBoardingAdapter(this::onClick)
    private  val viewModel by viewModel<OnBoardingViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnBoardingBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = adapter
        binding.wormDotsIndicator.attachTo(binding.viewPager)
    }

    private  fun onClick()
    {
        viewModel.onBoardingShown()
        findNavController().navigate(R.id.navigation_search)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}