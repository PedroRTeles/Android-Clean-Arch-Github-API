package dev.pedroteles.githubapi.data.repository

import dev.pedroteles.githubapi.data.entity.GitHubUserEntity

interface UserRepository {
    suspend fun searchUser(username: String) : GitHubUserEntity?
}