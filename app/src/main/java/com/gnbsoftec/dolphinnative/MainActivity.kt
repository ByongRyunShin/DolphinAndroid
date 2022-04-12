package com.gnbsoftec.dolphinnative

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.gnbsoftec.dolphinnative.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.root)
        init(binding)
        binding.webview.setWebViewClient(object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                // do your stuff here
            }
        })
    }
    override fun onBackPressed() {
        if (binding.webview.canGoBack())
        {
            binding.webview.goBack()
        }
        else
        {
            finish()
        }
    }
    private fun init(binding: ActivityMainBinding){
        binding.webview.apply{
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            webChromeClient = WebChromeClient()
            webViewClient = WebViewClient()
        }
        binding.webview.loadUrl("http://222.122.196.22:8380/login.frm")
    }
}