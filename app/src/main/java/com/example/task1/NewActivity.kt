package com.example.task1

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class NewActivity : AppCompatActivity(){
    private val webView:WebView?=null
    // web view code

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.itemnew)
        title="KotlinApp"
        val webView = findViewById<WebView>(R.id.url)
        webView.webViewClient = WebViewClient()
        var extras = intent.getStringExtra("URI")
        webView.loadUrl("$extras")
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        val actionBar = supportActionBar
        actionBar!!.title="Web View"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
    }
//    this code can be used when you want go back in your app using web view

//    override fun onBackPressed() {
//        if (webView!!.canGoBack()){ // this line is for going back
//            webView.goBack()
//        }
//        else{
//            super.onBackPressed() // if you press two times back button you will eit the app as we can see in other apps
//        }
//    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }




}