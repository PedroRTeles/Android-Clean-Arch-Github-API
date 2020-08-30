package dev.pedroteles.githubapi.app.feature.userinfo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import dev.pedroteles.githubapi.R
import dev.pedroteles.githubapi.app.feature.userinfo.viewmodel.UserInfoViewModel
import kotlinx.android.synthetic.main.activity_user_info.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class UserInfoActivity : AppCompatActivity() {
    private val viewModel: UserInfoViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        populateUserInfo(intent.extras?.get("USER_INFO"))
    }

    private fun populateUserInfo(userInfo: Any?) {
        val dto = viewModel.getDtoObject(userInfo)

        txtLogin.text = dto.login
        txtName.text = dto.name
        txtUrl.text = dto.url
        txtLocation.text = dto.location
        txtId.text = dto.id.toString()

        CoroutineScope(Dispatchers.Main).launch {
            Picasso.get().load(dto.avatarUrl).into(imgUser)
        }
    }
}