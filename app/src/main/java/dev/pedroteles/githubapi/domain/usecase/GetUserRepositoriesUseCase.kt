package dev.pedroteles.githubapi.domain.usecase

import dev.pedroteles.githubapi.domain.entity.GitHubRepository
import dev.pedroteles.githubapi.domain.gateway.dataprovider.GetUserRepositoriesDataProviderGateway
import dev.pedroteles.githubapi.domain.gateway.usecase.GetUserRepositoriesUseCaseGateway

class GetUserRepositoriesUseCase(
    private val dataProvider: GetUserRepositoriesDataProviderGateway) : GetUserRepositoriesUseCaseGateway {

    override suspend fun getUserRepositories(username: String): List<GitHubRepository> {
        return dataProvider.getUserRepositories(username)
    }
}