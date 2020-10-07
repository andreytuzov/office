package io.office.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object OfficeApi {

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://gitlab.65apps.com/65gb/static/raw/master/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    val officeApiService = retrofit.create(WorkersEndpoint::class.java)
}