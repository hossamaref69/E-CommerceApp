package com.example.e_comerceApp.ui.activities.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.e_comerceApp.R
import com.example.e_comerceApp.data.utils.SharedPreferenceHelper
import com.example.e_comerceApp.databinding.ActivitySplashBinding
import com.example.e_comerceApp.ui.activities.auth.AuthActivity
import com.example.e_comerceApp.ui.activities.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    @Inject
    lateinit var sharedPreferenceHelper: SharedPreferenceHelper
    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val token = sharedPreferenceHelper.getToken()
        if (token.isNullOrEmpty()){
            navigateToAuth()
        }else{
            navigateToHome()
        }
    }

    private fun navigateToAuth() {
        Handler(mainLooper).postDelayed({
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }

    private fun navigateToHome() {
        Handler(mainLooper).postDelayed({
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}