package dev.pedroteles.githubapi.app.feature.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.pedroteles.githubapi.app.base.BaseViewModel
import dev.pedroteles.githubapi.app.entity.GitHubUserDTO
import dev.pedroteles.githubapi.app.mapper.SearchViewModelMapper
import dev.pedroteles.githubapi.domain.exception.GitHubUserNotFoundException
import dev.pedroteles.githubapi.domain.gateway.usecase.SearchUserUseCaseGateway
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.inject

class SearchViewModel : BaseViewModel() {
    private val useCase: SearchUserUseCaseGateway by inject()
    private val githubUserMutable: MutableLiveData<GitHubUserDTO> = MutableLiveData()
    private val messageMutable: MutableLiveData<String> = MutableLiveData()

    val githubUserLiveData: LiveData<GitHubUserDTO>
        get() = githubUserMutable

    val messageLiveData: LiveData<String>
        get() = messageMutable

    fun searchUser(username: String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val userCore = useCase.searchUser(username)
                githubUserMutable.value = SearchViewModelMapper.coreToDTO(userCore)
            } catch (e: GitHubUserNotFoundException) {
                messageMutable.value = SearchViewModelMapper.userNotFound()
            }
        }
    }
}