package dev.pedroteles.githubapi.data.dataprovider

import dev.pedroteles.githubapi.data.BaseDataProvider
import dev.pedroteles.githubapi.data.dataprovider.mapper.SearchUserDataProviderMapper
import dev.pedroteles.githubapi.data.repository.UserRepository
import dev.pedroteles.githubapi.domain.entity.GitHubUserCore
import dev.pedroteles.githubapi.domain.gateway.dataprovider.SearchUserDataProviderGateway

class SearchUserDataProvider(private val repository: UserRepository) : BaseDataProvider(), SearchUserDataProviderGateway {

    override suspend fun searchUser(username: String): GitHubUserCore {
        val entity = repository.searchUser(username)

        if(entity != null)
            return SearchUserDataProviderMapper.entityToCore(entity)

        return SearchUserDataProviderMapper.userNotFound()
    }
}