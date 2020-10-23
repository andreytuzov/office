package io.office.data.remote

import io.office.data.remote.response.WorkersResponse
import retrofit2.http.GET

interface WorkersApi {

    @GET("testTask.json")
    suspend fun getWorkers(): WorkersResponse
}