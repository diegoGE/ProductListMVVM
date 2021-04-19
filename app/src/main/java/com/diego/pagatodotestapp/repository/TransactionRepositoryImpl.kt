package com.diego.pagatodotestapp.repository

import com.diego.pagatodotestapp.data.model.TransactionList
import com.diego.pagatodotestapp.data.remote.TransactionDataSource

class TransactionRepositoryImpl(private val dataSource: TransactionDataSource): TransactionRepository {
    override suspend fun getUserTransaction(): TransactionList = dataSource.getUserTransaction()
    override suspend fun getTransactionEmpty(): TransactionList = dataSource.getTransactionEmpty()
    override suspend fun getTransactionInvalidFormed(): TransactionList = dataSource.getTransactionInvalidFormed()
}