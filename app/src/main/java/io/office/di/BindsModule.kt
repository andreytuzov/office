package io.office.di

import dagger.Binds
import dagger.Module
import io.office.data.LocalWorkersDataSource
import io.office.data.RemoteWorkersDataSource
import io.office.data.WorkersRepositoryImpl
import io.office.data.local.LocalWorkersDataSourceImpl
import io.office.data.local.mapper.LocalWorkersMapper
import io.office.data.remote.RemoteWorkersDataSourceImpl
import io.office.data.remote.mapper.RemoteWorkersMapper
import io.office.di.scope.AppScope
import io.office.domain.WorkersRepository
import io.office.domain.mapper.DateMapper
import io.office.navigation.Router
import io.office.navigation.RouterImpl

@Module
interface BindsModule {
    @Binds
    fun bindLocalWorkersDataSource(impl: LocalWorkersDataSourceImpl): LocalWorkersDataSource

    @Binds
    fun bindRemoteWorkersDataSource(impl: RemoteWorkersDataSourceImpl): RemoteWorkersDataSource

    @Binds
    fun bindRemoteWorkersMapper(impl: RemoteWorkersMapper.Impl): RemoteWorkersMapper

    @Binds
    fun bindLocalWorkersMapper(impl: LocalWorkersMapper.Impl): LocalWorkersMapper

    @Binds
    fun bindWorkersRepository(impl: WorkersRepositoryImpl): WorkersRepository

    @AppScope
    @Binds
    fun bindRouter(impl: RouterImpl): Router

    @Binds
    fun bindDateMapper(impl: DateMapper.Impl): DateMapper
}