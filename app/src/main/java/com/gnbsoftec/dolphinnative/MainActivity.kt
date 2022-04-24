package com.gnbsoftec.dolphinnative

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.view.View
import android.webkit.*
import androidx.appcompat.app.AppCompatActivity
import com.gnbsoftec.dolphinnative.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.root)

        init(binding)
        
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
            webViewClient = MyWebViewClient()
        }
        binding.webview.loadUrl("http://222.122.196.22:8380/login.frm")
    }
    inner class MyWebViewClient : WebViewClient() {
        override fun onPageFinished(view: WebView?, url: String?) {
            binding.splashView.animate()
                .alpha(0.0f)
                .setDuration(600)
                .setListener(object:AnimatorListenerAdapter(){
                    override fun onAnimationEnd(animation: Animator?) {
                        super.onAnimationEnd(animation)
                        binding.splashView.visibility = View.GONE;
                    }
                })
            super.onPageFinished(view, url)
        }

        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            return super.shouldOverrideUrlLoading(view, request)
        }
    }
}