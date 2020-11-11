package dev.pedroteles.githubapi.app.feature.userinfo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.squareup.picasso.Picasso
import dev.pedroteles.githubapi.R
import dev.pedroteles.githubapi.app.entity.GitHubUserDTO
import dev.pedroteles.githubapi.app.feature.userinfo.view.adapter.RepositoryListAdapter
import dev.pedroteles.githubapi.app.feature.userinfo.viewmodel.UserInfoViewModel
import kotlinx.android.synthetic.main.activity_user_info.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class UserInfoActivity : AppCompatActivity() {
    private val viewModel: UserInfoViewModel by inject()
    private lateinit var dto: GitHubUserDTO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        populateDto(intent.extras?.get("USER_INFO"))
        populateUserInfo()
        observeLiveData()
        getUserRepositories()
    }

    private fun populateUserInfo() {
        txtLogin.text = dto.login
        txtName.text = dto.name
        txtUrl.text = dto.url
        txtLocation.text = dto.location
        txtId.text = dto.id.toString()

        getUserPhoto()
    }

    private fun getUserPhoto() {
        CoroutineScope(Dispatchers.Main).launch {
            Picasso.get().load(dto.avatarUrl).into(imgUser)
        }
    }

    private fun populateDto(userInfo: Any?) {
        dto = viewModel.getDtoObject(userInfo)
    }

    private fun observeLiveData() {
        viewModel.repositoryListLiveData.observe(this, Observer {
            rcvRepositories.adapter = RepositoryListAdapter(it, this)
        })
    }

    private fun getUserRepositories() {
        viewModel.getListRepositories(dto.login)
    }
}