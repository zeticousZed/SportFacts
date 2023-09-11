package com.example.sportfacts.presentation.activity

import android.content.Context
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.sportfacts.R
import com.example.sportfacts.databinding.ActivityMainBinding
import com.example.sportfacts.presentation.fragments.SportListFragment
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings

class MainActivity : AppCompatActivity() {
    private val firebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
    private var binding: ActivityMainBinding? = null
    private var webView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        webView = findViewById(R.id.web_view)
        configureWebView()
        configurationFirebaseConfig()
        lunchTheConfig()
        if (savedInstanceState == null) {
            navigationFragment(R.id.fragmentContainerView, SportListFragment())
        }
    }

    fun navigationFragment(container: Int, fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(container, fragment)
            .commit()
    }

    fun configurationFirebaseConfig() {
        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(3600)
            .build()
        firebaseRemoteConfig.setConfigSettingsAsync(configSettings)
    }

    fun lunchTheConfig() {
        firebaseRemoteConfig.fetchAndActivate()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val configValue = firebaseRemoteConfig.getString("config_key")
                    if (configValue.isNotEmpty()) {
                        saveLinkLocally(configValue)
                    } else {
                        // Show placeholder or handle empty config value
                        showPlaceholder()
                    }
                } else {
                    showNetworkError()
                }
            }
    }

    private fun saveLinkLocally(link: String) {
        val sharedPreferences = getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("config_link", link)
        editor.apply()
    }

    private fun showNetworkError() {
        Toast.makeText(this, "Ошибка сети", Toast.LENGTH_LONG).show()
    }

    private fun showPlaceholder() {
        navigationFragment(R.id.fragmentContainerView, SportListFragment())
    }

    private fun configureWebView() {
        val mWebSettings = webView?.settings
        webView?.webViewClient = WebViewClient()
        val webSettings = webView?.settings
        webSettings?.javaScriptEnabled = true
        mWebSettings?.javaScriptEnabled = true
        mWebSettings?.loadWithOverviewMode = true
        mWebSettings?.useWideViewPort = true
        mWebSettings?.domStorageEnabled = true
        mWebSettings?.databaseEnabled = true
        mWebSettings?.setSupportZoom(false)
        mWebSettings?.allowFileAccess = true
        mWebSettings?.allowContentAccess = true
        mWebSettings?.loadWithOverviewMode = true
        mWebSettings?.useWideViewPort = true
    }
}