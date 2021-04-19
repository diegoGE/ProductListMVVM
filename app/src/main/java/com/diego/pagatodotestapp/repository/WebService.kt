package com.diego.pagatodotestapp.repository

import com.diego.pagatodotestapp.data.model.TransactionList
import com.diego.pagatodotestapp.utils.UtilsConstants
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * The web service is in charge of using Retrofit to fetch information from the server.
 * https://storage.googleapis.com/recursos_app/Services/pruebaFile.json
 */
interface WebService {
    @GET("Services/pruebaFile.json")
    suspend fun getUserTransaction(): TransactionList

    @GET("Services/servicioVacio.json")
    suspend fun getTransactionEmpty(): TransactionList

    @GET("Services/pruebaMalFormada.json")
    suspend fun getTransactionInvalidFormed(): TransactionList
}

object RetrofitClient{
    val webservice by lazy {
        Retrofit.Builder()
                .baseUrl(UtilsConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build().create(WebService::class.java)
    }
}