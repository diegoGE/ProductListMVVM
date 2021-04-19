package com.diego.pagatodotestapp.presentation

import android.text.Editable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.diego.pagatodotestapp.core.Resource
import com.diego.pagatodotestapp.repository.TransactionRepository
import kotlinx.coroutines.Dispatchers

class UserTransactionViewModel(private val repo: TransactionRepository): ViewModel() {

    fun fetchUserTransaction() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getUserTransaction()))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }

    fun fetchUserTransactionEmpty() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getTransactionEmpty()))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }

    fun fetchUserTransactionInvalidFormat() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getTransactionInvalidFormed()))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }
}

/**
 * This factory class is created to avoid passing parameters to the ViewModel class
 * when wanting to make an instance of the interface to communicate with the repository.
 */
class TransactionViewModelFactory(private val repo: TransactionRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(TransactionRepository::class.java).newInstance(repo)
    }

}