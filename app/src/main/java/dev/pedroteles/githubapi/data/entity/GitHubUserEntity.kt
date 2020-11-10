package dev.pedroteles.githubapi.data.entity

import com.google.gson.annotations.SerializedName
import dev.pedroteles.githubapi.domain.entity.GitHubUser

data class GitHubUserEntity(
    @SerializedName("id")
    override val id: Long,
    @SerializedName("login")
    override val login: String,
    @SerializedName("name")
    override val name: String,
    @SerializedName("avatar_url")
    override val avatarUrl: String?,
    @SerializedName("html_url")
    override val url: String,
    @SerializedName("blog")
    override val blog: String?,
    @SerializedName("location")
    override val location: String?,
    @SerializedName("bio")
    override val bio: String?
) : GitHubUser