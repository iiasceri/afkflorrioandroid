package md.ciocana.iiasceri.afkflorrioandroid.android

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.webkit.WebViewAssetLoader
import md.ciocana.iiasceri.afkflorrioandroid.Greeting

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val url = "https://www.google.com/"
                    AndroidView(factory = {
                        val wbAL = WebViewAssetLoader.Builder()
                            .addPathHandler("/assets/", WebViewAssetLoader.AssetsPathHandler(this))
                            .addPathHandler("/res/", WebViewAssetLoader.ResourcesPathHandler(this))
                            .build()
                        val webView = WebView(this)
                        webView.apply {
                            webViewClient = WebViewClient()

                            settings.allowFileAccessFromFileURLs = true;
                            settings.allowUniversalAccessFromFileURLs = true;

                            loadUrl(url)
                        }
                        webView
                    })
                }
            }
        }
    }
}