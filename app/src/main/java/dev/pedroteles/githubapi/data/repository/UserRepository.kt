package dev.pedroteles.githubapi.data.repository

import dev.pedroteles.githubapi.data.entity.GitHubRepositoryEntity
import dev.pedroteles.githubapi.data.entity.GitHubUserEntity

interface UserRepository {
    suspend fun searchUser(username: String) : GitHubUserEntity?
    suspend fun getUserRepositories(username: String) : List<GitHubRepositoryEntity>?
}