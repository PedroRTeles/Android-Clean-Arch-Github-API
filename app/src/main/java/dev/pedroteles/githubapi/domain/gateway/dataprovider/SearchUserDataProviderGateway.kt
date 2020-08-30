package dev.pedroteles.githubapi.domain.gateway.dataprovider

import dev.pedroteles.githubapi.domain.entity.GitHubUserCore

interface SearchUserDataProviderGateway {
    suspend fun searchUser(username: String) : GitHubUserCore
}