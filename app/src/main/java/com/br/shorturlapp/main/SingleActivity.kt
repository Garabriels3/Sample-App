package com.br.shorturlapp.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.br.shorturlapp.R
import com.br.shorturlapp.databinding.ActivitySingleBinding

class SingleActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySingleBinding.inflate(layoutInflater) }

    private val navController by lazy {
        findNavController(this, R.id.nav_host_container)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}