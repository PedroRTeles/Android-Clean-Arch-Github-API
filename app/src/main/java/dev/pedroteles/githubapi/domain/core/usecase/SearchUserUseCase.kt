package dev.pedroteles.githubapi.domain.core.usecase

import dev.pedroteles.githubapi.domain.core.base.BaseUseCase
import dev.pedroteles.githubapi.domain.entity.GitHubUserCore
import dev.pedroteles.githubapi.domain.gateway.dataprovider.SearchUserDataProviderGateway
import dev.pedroteles.githubapi.domain.gateway.usecase.SearchUserUseCaseGateway
import org.koin.core.inject

class SearchUserUseCase : BaseUseCase(), SearchUserUseCaseGateway {
    private val dataProvider: SearchUserDataProviderGateway by inject()

    override suspend fun searchUser(username: String): GitHubUserCore {
        return dataProvider.searchUser(username)
    }
}