package io.office.data.remote.mapper

import android.annotation.SuppressLint
import io.office.data.remote.response.SpecialityResponse
import io.office.data.remote.response.WorkerResponse
import io.office.domain.mapper.DateMapper
import io.office.domain.model.Speciality
import io.office.domain.model.Worker
import io.office.domain.model.WorkerWithSpecialities
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

interface RemoteWorkersMapper {

    fun map(workerResponse: WorkerResponse): WorkerWithSpecialities

    class Impl @Inject constructor(
        private val dateMapper: DateMapper
    ): RemoteWorkersMapper {

        override fun map(workerResponse: WorkerResponse): WorkerWithSpecialities {
            return WorkerWithSpecialities(
                worker = Worker(
                    name = normalizeName(workerResponse.name),
                    lastName = normalizeName(workerResponse.lastName),
                    avatarUri = workerResponse.avatarUrl,
                    birthday = workerResponse.birthday?.let(dateMapper::map)
                ),
                specialities = workerResponse.specialities.map(::map)
            )
        }

        @SuppressLint("DefaultLocale")
        private fun normalizeName(value: String): String {
            return value.toLowerCase().capitalize()
        }

        private fun map(specialityResponse: SpecialityResponse): Speciality {
            return Speciality(
                id = specialityResponse.id.toLong(),
                name = specialityResponse.name
            )
        }
    }
}
