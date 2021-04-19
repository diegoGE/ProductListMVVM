package com.diego.pagatodotestapp.repository

import com.diego.pagatodotestapp.data.model.TransactionList

/**
 * In this part we only define the signature of the methods that will be implemented later.
 */
interface TransactionRepository {
   suspend fun getUserTransaction(): TransactionList
   suspend fun getTransactionEmpty(): TransactionList
   suspend fun getTransactionInvalidFormed(): TransactionList
}