package com.example.pertemuan13

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pertemuan13.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()

            // Simpan status login dan username di SharedPreferences
            val prefManager = PrefManager.getInstance(this)
            prefManager.setLoggedIn(true)
            prefManager.saveUsername(username)

            // Arahkan ke MainActivity setelah login sukses
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
