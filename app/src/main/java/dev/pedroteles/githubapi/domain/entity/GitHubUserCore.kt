package dev.pedroteles.githubapi.domain.entity

data class GitHubUserCore(
    val userFound: Boolean = false,
    val id: Long = 0,
    val login: String = "",
    val name: String? = "",
    val avatarUrl: String? = "",
    val url: String = "",
    val blog: String? = "",
    val location: String? = "",
    val bio: String? = ""
)