package dev.pedroteles.githubapi.app.feature.userinfo.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.pedroteles.githubapi.R
import dev.pedroteles.githubapi.domain.entity.Repository
import kotlinx.android.synthetic.main.repositories_list_item.view.*

class RepositoryListAdapter(
    private val repositories: List<Repository>,
    private val context: Context) : RecyclerView.Adapter<RepositoryListAdapter.RepositoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.repositories_list_item, parent, false)
        return RepositoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val repository = repositories[position]
        holder.populateView(repository)
    }

    override fun getItemCount(): Int {
        return repositories.size
    }

    class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateView(repository: Repository) {
            itemView.txtLanguage.text = repository.language
            itemView.txtRepositoryName.text = repository.name
        }
    }
}