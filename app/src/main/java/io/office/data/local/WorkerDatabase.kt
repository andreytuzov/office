package io.office.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import io.office.data.local.dao.WorkersDao
import io.office.data.local.model.entity.SpecialityEntity
import io.office.data.local.model.entity.WorkerEntity
import io.office.data.local.model.entity.WorkerWithSpecialityEntity

@Database(entities = [WorkerEntity::class, SpecialityEntity::class, WorkerWithSpecialityEntity::class], version = 1, exportSchema = false)
abstract class WorkerDatabase : RoomDatabase() {
    abstract fun workersDao(): WorkersDao
}