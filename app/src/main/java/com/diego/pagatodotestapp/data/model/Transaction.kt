package com.diego.pagatodotestapp.data.model

//Definition transaction model
data class Transaction(
        val uuid: String = "",
        val merchantUuid: String = "",
        val merchantName: String = "",
        val currencyCode: String = "",
        val amount: Int = -1,
        val timestamp: Long = -1
)

//Definition transaction list model
data class TransactionList(val servicioPrueba: List<Transaction> = listOf())
