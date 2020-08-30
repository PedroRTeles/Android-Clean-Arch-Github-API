package dev.pedroteles.githubapi.app.search.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import dev.pedroteles.githubapi.R
import dev.pedroteles.githubapi.app.search.viewmodel.SearchViewModel
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

        })
    }

    fun setupButton() {
        btnSearchUser.setOnClickListener {
            viewModel.searchUser(edtUsername.text.toString())
        }
    }
}