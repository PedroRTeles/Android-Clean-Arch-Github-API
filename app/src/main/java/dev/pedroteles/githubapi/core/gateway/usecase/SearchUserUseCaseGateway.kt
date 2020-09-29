package dev.pedroteles.githubapi.core.gateway.usecase

import dev.pedroteles.githubapi.core.entity.GitHubUserCore

interface SearchUserUseCaseGateway {
    suspend fun searchUser(username: String) : GitHubUserCore
}