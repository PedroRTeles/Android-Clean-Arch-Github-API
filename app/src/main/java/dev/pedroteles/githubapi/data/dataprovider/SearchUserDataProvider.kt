package dev.pedroteles.githubapi.data.dataprovider

import dev.pedroteles.githubapi.data.BaseDataProvider
import dev.pedroteles.githubapi.data.repository.UserRepository
import dev.pedroteles.githubapi.domain.entity.GitHubUser
import dev.pedroteles.githubapi.domain.exception.GitHubUserNotFoundException
import dev.pedroteles.githubapi.domain.gateway.dataprovider.SearchUserDataProviderGateway

class SearchUserDataProvider(private val repository: UserRepository) : BaseDataProvider(), SearchUserDataProviderGateway {

    override suspend fun searchUser(username: String): GitHubUser {
        val entity = repository.searchUser(username)

        if(entity != null)
            return entity

        throw GitHubUserNotFoundException()
    }
}