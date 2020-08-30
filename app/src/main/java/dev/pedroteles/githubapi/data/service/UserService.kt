package dev.pedroteles.githubapi.data.service

import dev.pedroteles.githubapi.data.entity.GitHubUserEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("users/{username}")
    suspend fun searchUser(@Path("username") username: String) : GitHubUserEntity?
}