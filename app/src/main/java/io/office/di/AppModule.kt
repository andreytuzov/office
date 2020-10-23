package io.office.di

import androidx.room.Room
import dagger.Module
import dagger.Provides
import io.office.App
import io.office.R
import io.office.data.local.WorkerDatabase
import io.office.data.local.dao.WorkersDao
import io.office.data.remote.WorkersApi
import io.office.di.scope.AppScope
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module(includes = [BindsModule::class])
object AppModule {

    @Provides
    @JvmStatic
    fun provideWorkersApi(retrofit: Retrofit): WorkersApi {
        return retrofit.create(WorkersApi::class.java)
    }

    @AppScope
    @Provides
    @JvmStatic
    fun provideRetrofit(app: App): Retrofit {
        return Retrofit.Builder()
            .baseUrl(app.getString(R.string.endpoint))
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @AppScope
    @Provides
    @JvmStatic
    fun provideDatabase(app: App): WorkerDatabase {
        return Room.databaseBuilder(app, WorkerDatabase::class.java, "workers.db")
            .build()
    }

    @Provides
    @JvmStatic
    fun provideWorkerDao(database: WorkerDatabase): WorkersDao {
        return database.workersDao()
    }
}