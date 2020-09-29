package dev.pedroteles.githubapi.data.dataprovider.mapper

import dev.pedroteles.githubapi.data.entity.GitHubUserEntity
import dev.pedroteles.githubapi.core.entity.GitHubUserCore

class SearchUserDataProviderMapper {
    companion object {
        fun entityToCore(entity: GitHubUserEntity) : GitHubUserCore {
            return GitHubUserCore(
                userFound = true,
                id = entity.id,
                login = entity.login,
                avatarUrl = entity.avatarUrl,
                name = entity.name,
                url = entity.url,
                blog = entity.blog,
                location = entity.location,
                bio = entity.bio
            )
        }

        fun userNotFound() : GitHubUserCore {
            return GitHubUserCore(
                userFound = false
            )
        }
    }
}
