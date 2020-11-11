package dev.pedroteles.githubapi.domain.gateway.usecase

import dev.pedroteles.githubapi.domain.entity.GitHubRepository

interface GetUserRepositoriesUseCaseGateway {
    suspend fun getUserRepositories(username: String) : List<GitHubRepository>
}