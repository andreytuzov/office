package io.office.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.office.db.entity.SpecialityEntity
import io.office.db.entity.WorkerEntity
import io.office.db.entity.WorkerWithSpecialityEntity

@Database(entities = [WorkerEntity::class, SpecialityEntity::class, WorkerWithSpecialityEntity::class], version = 1, exportSchema = false)
abstract class WorkerDatabase : RoomDatabase() {
    abstract fun workersDao(): WorkersDao

    companion object {

        @Volatile
        private var INSTANCE: WorkerDatabase? = null

        fun getInstance(context: Context): WorkerDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context, WorkerDatabase::class.java, "workers.db")
                            .build()
                    }
                }
            }
            return INSTANCE!!
        }
    }
}