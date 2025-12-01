package com.moiseraelaabel.bteavipredictor

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // If using Chaquopy, initialize Python
        if (!Python.isStarted()) {
            Python.start(AndroidPlatform(this))
        }

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        val webView = WebView(this)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("file:///android_asset/www/index.html")

        val btn = Button(this)
        btn.text = "Run sample prediction (Python)"
        btn.setOnClickListener {
            try {
                val py = Python.getInstance()
                val module = py.getModule("predictor")
                val result = module.callAttr("predict",  [1,2,3,4]).toString()
                Toast.makeText(this, "Prediction: $result", Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                Toast.makeText(this, "Python call failed: ${'$'}{e.message}", Toast.LENGTH_LONG).show()
            }
        }

        layout.addView(webView, LinearLayout.LayoutParams.MATCH_PARENT, 0)
        layout.addView(btn, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        setContentView(layout)
    }
}
