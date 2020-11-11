package dev.pedroteles.githubapi.data.dataprovider

import dev.pedroteles.githubapi.data.repository.UserRepository
import dev.pedroteles.githubapi.domain.entity.GitHubRepository
import dev.pedroteles.githubapi.domain.gateway.dataprovider.GetUserRepositoriesDataProviderGateway
import java.lang.Exception

class GetUserRepositoriesDataProvider(
    private val repository: UserRepository) : GetUserRepositoriesDataProviderGateway {

    override suspend fun getUserRepositories(username: String): List<GitHubRepository> {
        val repositoriesList = repository.getUserRepositories(username)

        if(repositoriesList != null)
            return repositoriesList

        throw Exception()
    }
}