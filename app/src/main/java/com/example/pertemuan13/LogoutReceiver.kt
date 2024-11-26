package com.example.pertemuan13

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class LogoutReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        // Ensure context is not null
        context?.let {
            // Get instance of PrefManager and clear session
            val prefManager = PrefManager.getInstance(it)
            prefManager.clear()

            // Show logout message
            Toast.makeText(it, "Logged out successfully!", Toast.LENGTH_SHORT).show()

            // Redirect to LoginActivity
            val loginIntent = Intent(it, LoginActivity::class.java)
            loginIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            it.startActivity(loginIntent)
        }
    }
}
