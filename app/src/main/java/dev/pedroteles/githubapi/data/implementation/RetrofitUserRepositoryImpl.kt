package dev.pedroteles.githubapi.data.implementation

import dev.pedroteles.githubapi.data.entity.GitHubUserEntity
import dev.pedroteles.githubapi.data.repository.UserRepository
import dev.pedroteles.githubapi.data.service.UserService
import kotlinx.coroutines.coroutineScope
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.await

class RetrofitUserRepositoryImpl : KoinComponent, UserRepository {
    private val retrofit: Retrofit by inject()

    override suspend fun searchUser(username: String): GitHubUserEntity? = coroutineScope {
        val service = retrofit.create(UserService::class.java)

        try {
            service.searchUser(username)
        } catch (e: HttpException) {
            null
        }
    }
}