package com.cst2335.teng0018

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var switchButton: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_relative)

        val clickHereButton = findViewById<Button>(R.id.button)
        switchButton = findViewById(R.id.switch1)

        clickHereButton.setOnClickListener {
            val toastMessage = resources.getString(R.string.toast)
            Toast.makeText(this@MainActivity, toastMessage, Toast.LENGTH_LONG).show()
        }

        switchButton.setOnCheckedChangeListener { buttonView, isChecked ->
            showSnackbar(isChecked)
        }
    }

    private fun showSnackbar(isChecked: Boolean) {
        val view = findViewById<View>(android.R.id.content) // Find root view

        val switchStatus = if (isChecked) "on" else "off"
        val message = "The switch is now $switchStatus"

        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
            .setAction("Undo") {
                // Reverse the switch state when "Undo" is clicked
                switchButton.isChecked = !isChecked
            }

        snackbar.show()
    }
}