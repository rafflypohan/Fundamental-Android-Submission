package com.belajar.githubuser

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.belajar.githubuser.databinding.ActivityMainBinding
import com.belajar.githubuser.user.User
import com.belajar.githubuser.user.UserAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            rvUser.setHasFixedSize(true)
            rvUser.layoutManager = LinearLayoutManager(this@MainActivity)
            rvUser.adapter = UserAdapter(getListUser())
        }

    }

    @SuppressLint("Recycle")
    private fun getListUser(): ArrayList<User> {
        val dataUsername = resources.getStringArray(R.array.username)
        val dataName = resources.getStringArray(R.array.name)
        val dataAvatar = resources.obtainTypedArray(R.array.avatar)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataRepository = resources.getStringArray(R.array.repository)
        val dataFollower = resources.getStringArray(R.array.followers)
        val dataFollowing = resources.getStringArray(R.array.following)

        val listUser: ArrayList<User> = arrayListOf()
        for (pos in dataName.indices) {
            val user = User(
                dataUsername[pos],
                dataName[pos],
                dataAvatar.getResourceId(pos, -1),
                dataCompany[pos],
                dataLocation[pos],
                dataRepository[pos],
                dataFollower[pos],
                dataFollowing[pos]
            )
            listUser.add(user)
        }
        return listUser
    }

}