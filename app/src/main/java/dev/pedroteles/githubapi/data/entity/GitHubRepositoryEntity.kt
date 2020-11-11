package dev.pedroteles.githubapi.data.entity

import com.google.gson.annotations.SerializedName
import dev.pedroteles.githubapi.domain.entity.GitHubRepository

data class GitHubRepositoryEntity(
    @SerializedName("id")
    override var id: Int,
    @SerializedName("name")
    override var name: String,
    @SerializedName("language")
    override var language: String
) : GitHubRepository