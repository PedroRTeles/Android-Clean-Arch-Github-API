package dev.pedroteles.githubapi.app.entity

data class GitHubUserDTO(
    val id: Long,
    val login: String,
    val name: String,
    val avatarUrl: String,
    val url: String,
    val blog: String,
    val location: String,
    val bio: String
)