package dev.pedroteles.githubapi.data.service

import dev.pedroteles.githubapi.data.entity.GitHubRepositoryEntity
import dev.pedroteles.githubapi.data.entity.GitHubUserEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("users/{username}")
    suspend fun searchUser(@Path("username") username: String) : GitHubUserEntity?

    @GET("users/{username}/repos")
    suspend fun getUserRepos(@Path("username") username: String) : List<GitHubRepositoryEntity>?
}