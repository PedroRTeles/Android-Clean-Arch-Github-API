package dev.pedroteles.githubapi.domain.gateway.usecase

import dev.pedroteles.githubapi.domain.entity.GitHubUserCore

interface SearchUserUseCaseGateway {
    suspend fun searchUser(username: String) : GitHubUserCore
}