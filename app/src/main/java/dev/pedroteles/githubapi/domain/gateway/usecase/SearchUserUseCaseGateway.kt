package dev.pedroteles.githubapi.domain.gateway.usecase

import dev.pedroteles.githubapi.domain.entity.GitHubUser

interface SearchUserUseCaseGateway {
    suspend fun searchUser(username: String) : GitHubUser
}