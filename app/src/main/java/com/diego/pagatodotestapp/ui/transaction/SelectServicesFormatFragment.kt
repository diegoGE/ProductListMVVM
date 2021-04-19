package com.diego.pagatodotestapp.ui.transaction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.diego.pagatodotestapp.R
import com.diego.pagatodotestapp.databinding.FragmentSelectServicesFormatBinding
import com.diego.pagatodotestapp.databinding.FragmentTransactionBinding


class SelectServicesFormatFragment : Fragment(R.layout.fragment_select_services_format) {

    private lateinit var binding: FragmentSelectServicesFormatBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSelectServicesFormatBinding.bind(view)

        binding.validService.setOnClickListener {
            val action = SelectServicesFormatFragmentDirections.actionSelectServicesFormatFragmentToTransactionFragment("valid")
            findNavController().navigate(action)
        }

        binding.emptyService.setOnClickListener {
            val action = SelectServicesFormatFragmentDirections.actionSelectServicesFormatFragmentToTransactionFragment("empty")
            findNavController().navigate(action)
        }

        binding.invalidService.setOnClickListener {
            val action = SelectServicesFormatFragmentDirections.actionSelectServicesFormatFragmentToTransactionFragment("invalid")
            findNavController().navigate(action)
        }
    }

}