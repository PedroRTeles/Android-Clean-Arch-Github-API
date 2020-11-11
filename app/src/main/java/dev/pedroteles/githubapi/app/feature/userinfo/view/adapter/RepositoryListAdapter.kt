package dev.pedroteles.githubapi.app.feature.userinfo.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.pedroteles.githubapi.R
import dev.pedroteles.githubapi.domain.entity.GitHubRepository
import kotlinx.android.synthetic.main.repositories_list_item.view.*

class RepositoryListAdapter(
    private val gitHubRepositories: List<GitHubRepository>,
    private val context: Context) : RecyclerView.Adapter<RepositoryListAdapter.RepositoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.repositories_list_item, parent, false)
        return RepositoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val repository = gitHubRepositories[position]
        holder.populateView(repository)
    }

    override fun getItemCount(): Int {
        return gitHubRepositories.size
    }

    class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateView(gitHubRepository: GitHubRepository) {
            itemView.txtLanguage.text = gitHubRepository.language
            itemView.txtRepositoryName.text = gitHubRepository.name
        }
    }
}