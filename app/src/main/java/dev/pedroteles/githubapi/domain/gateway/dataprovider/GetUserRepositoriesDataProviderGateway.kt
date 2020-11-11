package dev.pedroteles.githubapi.domain.gateway.dataprovider

import dev.pedroteles.githubapi.domain.entity.GitHubRepository

interface GetUserRepositoriesDataProviderGateway {
    suspend fun getUserRepositories(username: String) : List<GitHubRepository>
}