package dev.pedroteles.githubapi.app.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.pedroteles.githubapi.app.base.BaseViewModel
import dev.pedroteles.githubapi.app.entity.GitHubUserDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel : BaseViewModel() {
    private val githubUserMutable: MutableLiveData<GitHubUserDTO> = MutableLiveData()

    val githubUserLiveData: LiveData<GitHubUserDTO>
        get() = githubUserMutable

    fun searchUser(username: String) {
        CoroutineScope(Dispatchers.Main).launch {

        }
    }
}