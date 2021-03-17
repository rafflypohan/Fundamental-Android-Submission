package com.belajar.githubuser.user

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.belajar.githubuser.DetailActivity
import com.belajar.githubuser.R
import com.belajar.githubuser.databinding.ItemUserBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class UserAdapter(private val listUser: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.CardViewViewHolder>() {

    class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemUserBinding.bind(itemView)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardViewViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return CardViewViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val user = listUser[position]

        Glide.with(holder.itemView.context)
            .load(user.avatar)
            .apply(RequestOptions().override(350, 350))
            .into(holder.binding.imgUser)

        with(holder) {
            with(binding) {
                tvName.text = user.name
                tvUsername.text = user.username
                tvFollower.text = user.follower + " followers"
                tvRepository.text = user.repository + " repositories"
            }

            itemView.setOnClickListener {
                val context = holder.binding.tvName.context
                val detailIntent = Intent(context, DetailActivity::class.java)
                detailIntent.apply {
                    putExtra(DetailActivity.EXTRA_USER, user)
                }
                context.startActivity(detailIntent)
            }
        }
    }

    override fun getItemCount(): Int = listUser.size

}