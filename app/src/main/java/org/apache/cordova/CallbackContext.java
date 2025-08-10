package org.apache.cordova;

import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class CallbackContext {
    private static final String LOG_TAG = "CordovaPlugin";
    private String callbackId;
    private int changingThreads;
    public boolean finished;
    private CordovaWebView webView;

    public CallbackContext(String str, CordovaWebView cordovaWebView) {
        this.callbackId = str;
        this.webView = cordovaWebView;
    }

    public void error(JSONObject jSONObject) {
        sendPluginResult(new PluginResult(PluginResult.Status.ERROR, jSONObject));
    }

    public String getCallbackId() {
        return this.callbackId;
    }

    public boolean isChangingThreads() {
        return this.changingThreads > 0;
    }

    public boolean isFinished() {
        return this.finished;
    }

    public void sendPluginResult(PluginResult pluginResult) {
        synchronized (this) {
            if (!this.finished) {
                this.finished = !pluginResult.getKeepCallback();
                this.webView.sendPluginResult(pluginResult, this.callbackId);
                return;
            }
            LOG.w(LOG_TAG, "Attempted to send a second callback for ID: " + this.callbackId + "\nResult was: " + pluginResult.getMessage());
        }
    }

    public void success(JSONObject jSONObject) {
        sendPluginResult(new PluginResult(PluginResult.Status.OK, jSONObject));
    }

    public void error(String str) {
        sendPluginResult(new PluginResult(PluginResult.Status.ERROR, str));
    }

    public void success(String str) {
        sendPluginResult(new PluginResult(PluginResult.Status.OK, str));
    }

    public void error(int i) {
        sendPluginResult(new PluginResult(PluginResult.Status.ERROR, i));
    }

    public void success(JSONArray jSONArray) {
        sendPluginResult(new PluginResult(PluginResult.Status.OK, jSONArray));
    }

    public void success(byte[] bArr) {
        sendPluginResult(new PluginResult(PluginResult.Status.OK, bArr));
    }

    public void success(int i) {
        sendPluginResult(new PluginResult(PluginResult.Status.OK, i));
    }

    public void success() {
        sendPluginResult(new PluginResult(PluginResult.Status.OK));
    }
}
