package com.yetanotherdevagency.tooling

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private fun printIntentBundleExtras(intent: Intent): String {
         val bundle = intent.extras ?: return ""

        var result = ""
        for (key in bundle.keySet()) {
            result += key + ": " + bundle.get(key) + "\n"
        }
        return result
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        when {
            intent?.action == Intent.ACTION_SEND || intent?.action == Intent.ACTION_SEND_MULTIPLE -> {
                findViewById<TextView>(R.id.content).text = intent.toString()
                findViewById<TextView>(R.id.extras).text = printIntentBundleExtras(intent)
            }
        }
    }
}
