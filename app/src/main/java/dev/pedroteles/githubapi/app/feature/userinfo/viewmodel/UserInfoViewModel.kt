package dev.pedroteles.githubapi.app.feature.userinfo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.pedroteles.githubapi.app.base.BaseViewModel
import dev.pedroteles.githubapi.app.entity.GitHubUserDTO
import dev.pedroteles.githubapi.domain.entity.GitHubRepository
import dev.pedroteles.githubapi.domain.gateway.usecase.GetUserRepositoriesUseCaseGateway
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class UserInfoViewModel(
    private val useCase: GetUserRepositoriesUseCaseGateway) : BaseViewModel() {

    private val repositoryListMutable: MutableLiveData<List<GitHubRepository>> = MutableLiveData()

    val repositoryListLiveData: LiveData<List<GitHubRepository>>
        get() = repositoryListMutable

    fun getDtoObject(userInfo: Any?): GitHubUserDTO {
        return userInfo as GitHubUserDTO
    }

    fun getListRepositories(username: String?) {
        CoroutineScope(Dispatchers.Main).launch {
            if(username != null) {
                val repositoriesList = useCase.getUserRepositories(username)

                repositoryListMutable.value = repositoriesList
            }
        }
    }
}