package dev.pedroteles.githubapi.data.implementation

import dev.pedroteles.githubapi.data.entity.GitHubRepositoryEntity
import dev.pedroteles.githubapi.data.entity.GitHubUserEntity
import dev.pedroteles.githubapi.data.repository.UserRepository
import dev.pedroteles.githubapi.data.service.UserService
import kotlinx.coroutines.coroutineScope
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.await

class RetrofitUserRepositoryImpl : KoinComponent, UserRepository {
    private val retrofit: Retrofit by inject()
    val service = retrofit.create(UserService::class.java)

    override suspend fun searchUser(username: String): GitHubUserEntity? = coroutineScope {
        try {
            service.searchUser(username)
        } catch (e: HttpException) {
            null
        }
    }

    override suspend fun getUserRepositories(username: String): List<GitHubRepositoryEntity>? = coroutineScope {
       try {
           service.getUserRepos(username)
       } catch (e: HttpException) {
           null
       }
    }
}