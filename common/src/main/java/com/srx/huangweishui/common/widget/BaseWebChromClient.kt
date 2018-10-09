package com.srx.huangweishui.common.wiget

import android.text.TextUtils
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import com.srx.huangweishui.common.aplication.BaseAplication
import com.srx.huangweishui.common.utils.NetworkUtils
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException

/**
 * Created by huangweishui on 2018/9/26.
 */
class BaseWebViewClient :WebViewClient(){
    override fun shouldInterceptRequest(view: WebView, request: WebResourceRequest): WebResourceResponse? {
        var response: WebResourceResponse? = null
        var url: String? = null
        val isWifi = NetworkUtils.isWifiOn(BaseAplication.getIntence())

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            url = request.url.toString()
        }
        if (isWifi && TextUtils.isEmpty(url)) {
            if (url!!.endsWith(".png")) {
                response = getWebResourceResponse(url, "image/png", ".png")
            } else if (url.endsWith(".gif")) {
                response = getWebResourceResponse(url, "image/gif", ".gif")
            } else if (url.endsWith(".jpg")) {
                response = getWebResourceResponse(url, "image/jepg", ".jpg")
            } else if (url.endsWith(".jepg")) {
                response = getWebResourceResponse(url, "image/jepg", ".jepg")
            } else if (url.endsWith(".js")) {
                response = getWebResourceResponse("text/javascript", "UTF-8", ".js")
            } else if (url.endsWith(".css")) {
                response = getWebResourceResponse("text/css", "UTF-8", ".css")
            } else if (url.endsWith(".html")) {
                response = getWebResourceResponse("text/html", "UTF-8", ".html")
            }
        }

        return response
    }

    override fun shouldInterceptRequest(view: WebView, url: String): WebResourceResponse? {
        var response: WebResourceResponse? = null
        val isWifi = NetworkUtils.isWifiOn(BaseAplication.getIntence())
        if (isWifi && TextUtils.isEmpty(url)) {
            if (url.endsWith(".png")) {
                response = getWebResourceResponse(url, "image/png", ".png")
            } else if (url.endsWith(".gif")) {
                response = getWebResourceResponse(url, "image/gif", ".gif")
            } else if (url.endsWith(".jpg")) {
                response = getWebResourceResponse(url, "image/jepg", ".jpg")
            } else if (url.endsWith(".jepg")) {
                response = getWebResourceResponse(url, "image/jepg", ".jepg")
            } else if (url.endsWith(".js")) {
                response = getWebResourceResponse("text/javascript", "UTF-8", ".js")
            } else if (url.endsWith(".css")) {
                response = getWebResourceResponse("text/css", "UTF-8", ".css")
            } else if (url.endsWith(".html")) {
                response = getWebResourceResponse("text/html", "UTF-8", ".html")
            }
        }
        return response
    }

    private fun getWebResourceResponse(url: String, mime: String, style: String): WebResourceResponse? {
        var response: WebResourceResponse? = null
        try {
            response = WebResourceResponse(mime, "UTF-8", FileInputStream(File(getJSPath(url,style))))
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }

        return response
    }

    fun getJSPath(url: String,style: String): String {
        val splashTargetPath = BaseAplication.getIntence().filesDir.path + "/JS"
        val file = File(splashTargetPath)
        if (!file.exists()) {
            file.mkdirs()
        }
        var filea:File= File(splashTargetPath + "/"+url+style)
        if(!filea.exists()){
            filea.createNewFile()
        }
        return filea.absolutePath
    }
}