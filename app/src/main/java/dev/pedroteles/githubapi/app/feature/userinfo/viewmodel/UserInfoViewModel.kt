package dev.pedroteles.githubapi.app.feature.userinfo.viewmodel

import dev.pedroteles.githubapi.app.base.BaseViewModel
import dev.pedroteles.githubapi.app.entity.GitHubUserDTO

class UserInfoViewModel : BaseViewModel() {
    fun getDtoObject(userInfo: Any?): GitHubUserDTO {
        return userInfo as GitHubUserDTO
    }
}