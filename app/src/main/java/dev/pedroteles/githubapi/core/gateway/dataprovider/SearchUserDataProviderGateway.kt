package dev.pedroteles.githubapi.core.gateway.dataprovider

import dev.pedroteles.githubapi.core.entity.GitHubUserCore

interface SearchUserDataProviderGateway {
    suspend fun searchUser(username: String) : GitHubUserCore
}