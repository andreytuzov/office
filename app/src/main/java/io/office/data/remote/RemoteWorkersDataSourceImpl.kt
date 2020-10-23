package io.office.data.remote

import io.office.data.RemoteWorkersDataSource
import io.office.data.model.RemoteWorkersResult
import io.office.data.remote.mapper.RemoteWorkersMapper
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RemoteWorkersDataSourceImpl @Inject constructor(
    private val api: WorkersApi,
    private val mapper: RemoteWorkersMapper
) : RemoteWorkersDataSource {

    override suspend fun getWorkers(): RemoteWorkersResult {
        return try {
            val response = api.getWorkers()
            val workers = response.workers.map(mapper::map)
            return RemoteWorkersResult.Success(workers)
        } catch (ex: IOException) {
            RemoteWorkersResult.NetworkConnectionError
        } catch (ex : HttpException) {
            RemoteWorkersResult.NotFoundException
        }
    }
}