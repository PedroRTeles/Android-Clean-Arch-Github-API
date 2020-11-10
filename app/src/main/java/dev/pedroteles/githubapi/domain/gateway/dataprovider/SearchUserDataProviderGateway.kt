package dev.pedroteles.githubapi.domain.gateway.dataprovider

import dev.pedroteles.githubapi.domain.entity.GitHubUser

interface SearchUserDataProviderGateway {
    suspend fun searchUser(username: String) : GitHubUser
}