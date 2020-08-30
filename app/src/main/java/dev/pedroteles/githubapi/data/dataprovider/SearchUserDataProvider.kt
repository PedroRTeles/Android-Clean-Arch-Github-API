package dev.pedroteles.githubapi.data.dataprovider

import dev.pedroteles.githubapi.data.BaseDataProvider
import dev.pedroteles.githubapi.data.dataprovider.mapper.SearchUserDataProviderMapper
import dev.pedroteles.githubapi.data.repository.UserRepository
import dev.pedroteles.githubapi.domain.entity.GitHubUserCore
import dev.pedroteles.githubapi.domain.gateway.dataprovider.SearchUserDataProviderGateway
import org.koin.standalone.inject

class SearchUserDataProvider : BaseDataProvider(), SearchUserDataProviderGateway {
    private val repository: UserRepository by inject()

    override suspend fun searchUser(username: String): GitHubUserCore {
        val entity = repository.searchUser(username)

        if(entity != null)
            return SearchUserDataProviderMapper.entityToCore(entity)

        return SearchUserDataProviderMapper.userNotFound()
    }
}