package dev.pedroteles.githubapi.factory

import dev.pedroteles.githubapi.data.entity.GitHubUserEntity

class UserFactory {
    companion object {
        fun validUserEntity() : GitHubUserEntity {
            return GitHubUserEntity(
                id = 1,
                name = "Test",
                login = "Test",
                avatarUrl = "testUrl",
                url = "testUrl",
                blog = "testBlog",
                location = "Test",
                bio = "Test"
            )
        }
    }
}