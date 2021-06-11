package com.example.retrofit.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.retrofit.data.model.Article
import com.example.retrofit.databinding.ItemNewsBinding

private var Any.text: String?
    get() {
        TODO("Not yet implemented")
    }
    set(Source) {}
private val ViewBinding.tvSource: Any
    get() {
        TODO("Not yet implemented")
    }

class ArticleAdapter(
    private val articles: List<Article>,
    param: (Any) -> Unit
) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    override fun getItemCount(): Int = articles.size

    inner class ArticleViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            // TODO
        }

        fun bind(article: Article) {
            Glide.with(binding.ivImage).load(article.urlToImage).into(binding.ivImage)
            binding.tvSource.text = article.source.name
            binding.tvTitle.text = article.title
        }
    }
}