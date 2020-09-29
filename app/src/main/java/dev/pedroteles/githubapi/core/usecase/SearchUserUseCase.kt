package dev.pedroteles.githubapi.core.usecase

import dev.pedroteles.githubapi.core.base.BaseUseCase
import dev.pedroteles.githubapi.core.entity.GitHubUserCore
import dev.pedroteles.githubapi.core.gateway.dataprovider.SearchUserDataProviderGateway
import dev.pedroteles.githubapi.core.gateway.usecase.SearchUserUseCaseGateway
import org.koin.core.inject

class SearchUserUseCase : BaseUseCase(), SearchUserUseCaseGateway {
    private val dataProvider: SearchUserDataProviderGateway by inject()

    override suspend fun searchUser(username: String): GitHubUserCore {
        return dataProvider.searchUser(username)
    }
}