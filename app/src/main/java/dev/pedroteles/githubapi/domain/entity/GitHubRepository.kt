package dev.pedroteles.githubapi.domain.entity

interface GitHubRepository {
    var id: Int
    var name: String
    var language: String
}