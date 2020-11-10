package dev.pedroteles.githubapi.domain.usecase

import dev.pedroteles.githubapi.domain.base.BaseUseCase
import dev.pedroteles.githubapi.domain.entity.GitHubUser
import dev.pedroteles.githubapi.domain.gateway.dataprovider.SearchUserDataProviderGateway
import dev.pedroteles.githubapi.domain.gateway.usecase.SearchUserUseCaseGateway
import org.koin.core.inject

class SearchUserUseCase : BaseUseCase(), SearchUserUseCaseGateway {
    private val dataProvider: SearchUserDataProviderGateway by inject()

    override suspend fun searchUser(username: String): GitHubUser {
        return dataProvider.searchUser(username)
    }
}