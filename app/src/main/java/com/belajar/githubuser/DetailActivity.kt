package com.belajar.githubuser

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.belajar.githubuser.databinding.ActivityDetailBinding
import com.belajar.githubuser.user.User

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User

        with(binding) {
            tvName.text = user.name
            tvUsername.text = user.username
            user.avatar?.let { imgUser.setImageResource(it) }
            tvRepository.text = user.repository
            tvFollower.text = user.follower
            tvFollowing.text = user.following
            tvCompany.text = " " + user.company
            tvLocation.text = user.location
        }


        supportActionBar?.apply {
            title = user.username
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        finish()
        return true
    }
}