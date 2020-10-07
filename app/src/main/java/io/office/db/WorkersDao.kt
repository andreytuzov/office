package io.office.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.office.db.entity.SpecialityEntity
import io.office.db.entity.WorkerEntity
import io.office.db.entity.WorkerWithSpecialityEntity

@Dao
abstract class WorkersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun saveWorkers(workers: List<WorkerEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun saveSpeciality(specialities: List<SpecialityEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun saveWorkersWithSpeciality(workersWithSpecialities: List<WorkerWithSpecialityEntity>)

    @Query("SELECT * FROM worker")
    abstract suspend fun getWorkers(): List<WorkerEntity>

    @Query("SELECT speciality.* FROM speciality, worker_with_speciality WHERE worker_with_speciality.workerId = :workerId AND worker_with_speciality.specialityId = speciality.id")
    abstract suspend fun getSpecialitiesByWorkerId(workerId: Long): List<SpecialityEntity>

    @Query("SELECT COUNT(*) FROM worker")
    abstract suspend fun getCountWorkers(): Int
}