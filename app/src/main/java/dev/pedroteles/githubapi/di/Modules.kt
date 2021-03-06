package dev.pedroteles.githubapi.di

import dev.pedroteles.githubapi.BuildConfig
import dev.pedroteles.githubapi.app.feature.search.viewmodel.SearchViewModel
import dev.pedroteles.githubapi.app.feature.userinfo.viewmodel.UserInfoViewModel
import dev.pedroteles.githubapi.data.dataprovider.GetUserRepositoriesDataProvider
import dev.pedroteles.githubapi.domain.usecase.SearchUserUseCase
import dev.pedroteles.githubapi.data.dataprovider.SearchUserDataProvider
import dev.pedroteles.githubapi.data.implementation.RetrofitUserRepositoryImpl
import dev.pedroteles.githubapi.data.repository.UserRepository
import dev.pedroteles.githubapi.domain.gateway.dataprovider.GetUserRepositoriesDataProviderGateway
import dev.pedroteles.githubapi.domain.gateway.dataprovider.SearchUserDataProviderGateway
import dev.pedroteles.githubapi.domain.gateway.usecase.GetUserRepositoriesUseCaseGateway
import dev.pedroteles.githubapi.domain.gateway.usecase.SearchUserUseCaseGateway
import dev.pedroteles.githubapi.domain.usecase.GetUserRepositoriesUseCase
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val applicationModules = module(override = true) {
    factory { SearchViewModel() }
    factory { UserInfoViewModel(get()) }
}

val dataModules = module(override = true) {
    factory<SearchUserDataProviderGateway> { SearchUserDataProvider(get()) }
    factory<GetUserRepositoriesDataProviderGateway> { GetUserRepositoriesDataProvider(get()) }
    single<UserRepository> { RetrofitUserRepositoryImpl() }
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

val coreModules = module(override = true) {
    factory<SearchUserUseCaseGateway> { SearchUserUseCase(get()) }
    factory<GetUserRepositoriesUseCaseGateway> { GetUserRepositoriesUseCase(get()) }
}