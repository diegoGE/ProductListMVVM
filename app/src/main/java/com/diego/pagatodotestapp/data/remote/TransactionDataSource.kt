package com.diego.pagatodotestapp.data.remote

import com.diego.pagatodotestapp.data.model.TransactionList
import com.diego.pagatodotestapp.repository.WebService

/**
 * This class is the place where we are going to look for information to the server and we are going to bring it
 */
class TransactionDataSource(private val webService: WebService) {
    suspend fun getUserTransaction(): TransactionList = webService.getUserTransaction()
    suspend fun getTransactionEmpty(): TransactionList = webService.getTransactionEmpty()
    suspend fun getTransactionInvalidFormed(): TransactionList = webService.getTransactionInvalidFormed()
}