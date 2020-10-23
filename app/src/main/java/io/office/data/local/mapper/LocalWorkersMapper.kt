package io.office.data.local.mapper

import io.office.data.local.model.SpecialityWithWorkersModel
import io.office.data.local.model.WorkerWithSpecialitiesModel
import io.office.data.local.model.entity.SpecialityEntity
import io.office.data.local.model.entity.WorkerEntity
import io.office.domain.model.Speciality
import io.office.domain.model.SpecialityWithWorkers
import io.office.domain.model.Worker
import io.office.domain.model.WorkerWithSpecialities
import javax.inject.Inject

interface LocalWorkersMapper {

    fun map(entity: SpecialityWithWorkersModel): SpecialityWithWorkers
    fun map(entity: WorkerWithSpecialitiesModel): WorkerWithSpecialities
    fun map(entity: SpecialityEntity): Speciality

    fun map(model: WorkerWithSpecialities): WorkerWithSpecialitiesModel

    class Impl @Inject constructor() : LocalWorkersMapper {

        override fun map(entity: SpecialityWithWorkersModel): SpecialityWithWorkers {
            return SpecialityWithWorkers(
                speciality = map(entity.speciality),
                workers = entity.workers.map(::map)
            )
        }

        override fun map(entity: WorkerWithSpecialitiesModel): WorkerWithSpecialities {
            return WorkerWithSpecialities(
                worker = map(entity.worker),
                specialities = entity.specialities.map(::map)
            )
        }

        private fun map(entity: WorkerEntity): Worker {
            return Worker(
                id = entity.id,
                name = entity.name,
                lastName = entity.lastName,
                avatarUri = entity.avatarUri,
                birthday = entity.birthday
            )
        }

        override fun map(entity: SpecialityEntity): Speciality {
            return Speciality(
                id = entity.id,
                name = entity.name
            )
        }

        override fun map(model: WorkerWithSpecialities): WorkerWithSpecialitiesModel {
            return WorkerWithSpecialitiesModel(
                worker = map(model.worker),
                specialities = model.specialities.map(::map)
            )
        }

        private fun map(model: Worker): WorkerEntity {
            return WorkerEntity(
                id = model.id,
                name = model.name,
                lastName = model.lastName,
                avatarUri = model.avatarUri,
                birthday = model.birthday
            )
        }

        private fun map(model: Speciality): SpecialityEntity {
            return SpecialityEntity(
                id = model.id,
                name = model.name
            )
        }
    }
}