package io.office.api

import io.office.api.response.WorkersResponse
import retrofit2.http.GET

interface WorkersEndpoint {

    @GET("testTask.json")
    suspend fun getWorkers(): WorkersResponse
}