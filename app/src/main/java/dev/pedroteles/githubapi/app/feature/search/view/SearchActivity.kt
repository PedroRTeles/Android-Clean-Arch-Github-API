package dev.pedroteles.githubapi.app.feature.search.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import dev.pedroteles.githubapi.R
import dev.pedroteles.githubapi.app.feature.search.viewmodel.SearchViewModel
import dev.pedroteles.githubapi.app.feature.userinfo.view.UserInfoActivity
import kotlinx.android.synthetic.main.activity_search.*
import org.koin.android.ext.android.inject

class SearchActivity : AppCompatActivity() {
    private val viewModel: SearchViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        setupButton()
        observeData()
    }

    private fun observeData() {
        viewModel.githubUserLiveData.observe(this, Observer {
            val intent = Intent(this, UserInfoActivity::class.java)
            intent.putExtra("USER_INFO", it)

            startActivity(intent)
        })

        viewModel.messageLiveData.observe(this, Observer { message ->
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        })
    }

    fun setupButton() {
        btnSearchUser.setOnClickListener {
            viewModel.searchUser(edtUsername.text.toString())
        }
    }
}