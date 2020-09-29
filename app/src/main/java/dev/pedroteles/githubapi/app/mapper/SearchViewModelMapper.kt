package dev.pedroteles.githubapi.app.mapper

import dev.pedroteles.githubapi.app.entity.GitHubUserDTO
import dev.pedroteles.githubapi.core.entity.GitHubUserCore

class SearchViewModelMapper {
    companion object {
        fun coreToDTO(core: GitHubUserCore) : GitHubUserDTO {
            return GitHubUserDTO(
                id = core.id,
                login = core.login,
                name = core.name,
                avatarUrl = core.avatarUrl,
                url = core.url,
                blog = core.blog,
                location = core.location,
                bio = core.bio
            )
        }

        fun userNotFound(): String {
            return "User not found in GitHub!"
        }
    }
}
