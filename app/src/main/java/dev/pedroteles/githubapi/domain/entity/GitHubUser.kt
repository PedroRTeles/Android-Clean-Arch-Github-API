package dev.pedroteles.githubapi.domain.entity

interface GitHubUser {
    val id: Long
    val login: String
    val name: String
    val avatarUrl: String?
    val url: String
    val blog: String?
    val location: String?
    val bio: String?
}
