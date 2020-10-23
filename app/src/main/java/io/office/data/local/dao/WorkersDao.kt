package io.office.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import io.office.data.local.model.SpecialityWithWorkersModel
import io.office.data.local.model.WorkerWithSpecialitiesModel
import io.office.data.local.model.entity.SpecialityEntity
import io.office.data.local.model.entity.WorkerEntity
import io.office.data.local.model.entity.WorkerWithSpecialityEntity
import io.office.domain.model.Speciality
import io.office.domain.model.SpecialityWithWorkers
import io.office.domain.model.WorkerWithSpecialities

@Dao
abstract class WorkersDao {

    @Query("SELECT * FROM speciality")
    abstract fun getSpecialities(): LiveData<List<SpecialityEntity>>

    @Transaction
    @Query("SELECT * FROM speciality WHERE id = :specialityId")
    abstract fun getSpeciality(specialityId: Long): LiveData<SpecialityWithWorkersModel>

    @Transaction
    @Query("SELECT * FROM worker WHERE id = :workerId")
    abstract fun getWorker(workerId: Long): LiveData<WorkerWithSpecialitiesModel>

    @Transaction
    open fun saveWorkers(workersWithSpecialities: List<WorkerWithSpecialitiesModel>) {
        clearAll()
        for (workerWithSpecialities in workersWithSpecialities) {
            val workerId = saveWorker(workerWithSpecialities.worker)
            for (speciality in workerWithSpecialities.specialities) {
                val specialityId = saveSpeciality(speciality)
                saveWorkerWithSpeciality(WorkerWithSpecialityEntity(workerId, specialityId))
            }
        }
    }

    @Transaction
    open fun clearAll() {
        clearWorkers()
        clearSpecialities()
        clearWorkerWithSpeciality()
    }

    @Query("DELETE FROM worker")
    abstract fun clearWorkers()

    @Query("DELETE FROM speciality")
    abstract fun clearSpecialities()

    @Query("DELETE FROM worker_with_speciality")
    abstract fun clearWorkerWithSpeciality()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun saveWorker(worker: WorkerEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun saveSpeciality(speciality: SpecialityEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun saveWorkerWithSpeciality(workerWithSpeciality: WorkerWithSpecialityEntity): Long
}