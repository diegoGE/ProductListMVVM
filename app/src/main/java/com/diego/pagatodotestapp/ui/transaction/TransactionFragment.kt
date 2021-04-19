package com.diego.pagatodotestapp.ui.transaction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diego.pagatodotestapp.R
import com.diego.pagatodotestapp.databinding.FragmentTransactionBinding
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.diego.pagatodotestapp.core.Resource
import com.diego.pagatodotestapp.data.remote.TransactionDataSource
import com.diego.pagatodotestapp.presentation.TransactionViewModelFactory
import com.diego.pagatodotestapp.presentation.UserTransactionViewModel
import com.diego.pagatodotestapp.repository.RetrofitClient
import com.diego.pagatodotestapp.repository.TransactionRepositoryImpl
import com.diego.pagatodotestapp.ui.transaction.adapters.TrasactionAdapter

class TransactionFragment : Fragment(R.layout.fragment_transaction) {

    private lateinit var binding: FragmentTransactionBinding
    private lateinit var adapter: TrasactionAdapter
    private val args by navArgs<TransactionFragmentArgs>()
    private var select: String? = ""

    private val viewModel by viewModels<UserTransactionViewModel> { TransactionViewModelFactory(TransactionRepositoryImpl(
        TransactionDataSource(RetrofitClient.webservice)
    )) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTransactionBinding.bind(view)
        select = args.idService

        chooseServices()
    }

   private fun fetchUserTransactionValid(){
        viewModel.fetchUserTransaction().observe(viewLifecycleOwner, Observer {result ->
            when(result){
                is Resource.Loading -> {
                    Log.d("liveData","Loading")
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    Log.d("liveData","Success: ${result.data}")
                    binding.progressBar.visibility = View.GONE
                    adapter = TrasactionAdapter(result.data.servicioPrueba)
                    binding.rvTransaction.adapter = adapter
                }
                is Resource.Failure -> {
                    Log.d("liveData","Error ${result.exception}")
                    binding.progressBar.visibility = View.GONE
                }
            }
        })
    }

    private fun fetchUserTransactionEmpty(){
        viewModel.fetchUserTransactionEmpty().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    Log.d("liveData", "Loading")
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    Log.d("liveData", "Success: ${result.data}")
                    Toast.makeText(requireActivity(), "Lista vacía ${result.data}", Toast.LENGTH_SHORT).show()
                    binding.progressBar.visibility = View.GONE
                }
                is Resource.Failure -> {
                    Log.d("liveData", "Error ${result.exception}")
                    binding.progressBar.visibility = View.GONE
                }
            }
        })
    }

    private fun fetchUserTransactionInvalidFormat(){
        viewModel.fetchUserTransactionInvalidFormat().observe(viewLifecycleOwner, Observer {result ->
            when(result){
                is Resource.Loading -> {
                    Log.d("liveData","Loading")
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    Log.d("liveData","Success: ${result.data}")
                    binding.progressBar.visibility = View.GONE
                }
                is Resource.Failure -> {
                    Log.d("liveData","Error ${result.exception}")
                    Toast.makeText(requireActivity(), "Json mal formato ${result.exception}", Toast.LENGTH_SHORT).show()
                    binding.progressBar.visibility = View.GONE
                }
            }
        })
    }

    private fun chooseServices(){
        when(select){
            "valid" -> {
                fetchUserTransactionValid()
            }
            "empty" -> {
                fetchUserTransactionEmpty()
            }
            "invalid" -> {
                fetchUserTransactionInvalidFormat()
            }
        }
    }

}