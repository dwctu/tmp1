package org.apache.cordova;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.broadcom.bt.util.io.IOUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginManager;
import org.apache.cordova.PluginResult;
import org.json.JSONException;

/* loaded from: classes5.dex */
public class PluginManager {
    private static String DEFAULT_HOSTNAME = "localhost";
    private static String SCHEME_HTTPS = "https";
    private static final int SLOW_EXEC_WARNING_THRESHOLD;
    private static String TAG = "PluginManager";
    private final CordovaWebView app;
    private final CordovaInterface ctx;
    private boolean isInitialized;
    private CordovaPlugin permissionRequester;
    private final Map<String, CordovaPlugin> pluginMap = Collections.synchronizedMap(new LinkedHashMap());
    private final Map<String, PluginEntry> entryMap = Collections.synchronizedMap(new LinkedHashMap());

    static {
        SLOW_EXEC_WARNING_THRESHOLD = Debug.isDebuggerConnected() ? 60 : 16;
    }

    public PluginManager(CordovaWebView cordovaWebView, CordovaInterface cordovaInterface, Collection<PluginEntry> collection) {
        this.ctx = cordovaInterface;
        this.app = cordovaWebView;
        setPluginEntries(collection);
    }

    public static /* synthetic */ void a(String str, Object obj, String str2, CordovaPlugin cordovaPlugin) {
        if (cordovaPlugin != null) {
            cordovaPlugin.onMessage(str, obj);
        }
    }

    private String getLaunchUrlPrefix() {
        if (this.app.getPreferences().getBoolean("AndroidInsecureFileModeEnabled", false)) {
            return "file://";
        }
        return this.app.getPreferences().getString("scheme", SCHEME_HTTPS).toLowerCase() + "://" + this.app.getPreferences().getString("hostname", DEFAULT_HOSTNAME).toLowerCase() + IOUtils.DIR_SEPARATOR_UNIX;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.apache.cordova.CordovaPlugin instantiatePlugin(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L12
            java.lang.String r1 = ""
            boolean r1 = r1.equals(r5)     // Catch: java.lang.Exception -> L10
            if (r1 != 0) goto L12
            java.lang.Class r1 = java.lang.Class.forName(r5)     // Catch: java.lang.Exception -> L10
            goto L13
        L10:
            r1 = move-exception
            goto L29
        L12:
            r1 = r0
        L13:
            if (r1 == 0) goto L17
            r2 = 1
            goto L18
        L17:
            r2 = 0
        L18:
            java.lang.Class<org.apache.cordova.CordovaPlugin> r3 = org.apache.cordova.CordovaPlugin.class
            boolean r3 = r3.isAssignableFrom(r1)     // Catch: java.lang.Exception -> L10
            r2 = r2 & r3
            if (r2 == 0) goto L47
            java.lang.Object r1 = r1.newInstance()     // Catch: java.lang.Exception -> L10
            org.apache.cordova.CordovaPlugin r1 = (org.apache.cordova.CordovaPlugin) r1     // Catch: java.lang.Exception -> L10
            r0 = r1
            goto L47
        L29:
            r1.printStackTrace()
            java.io.PrintStream r1 = java.lang.System.out
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error adding plugin "
            r2.append(r3)
            r2.append(r5)
            java.lang.String r5 = "."
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            r1.println(r5)
        L47:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.cordova.PluginManager.instantiatePlugin(java.lang.String):org.apache.cordova.CordovaPlugin");
    }

    private void startupPlugins() {
        synchronized (this.entryMap) {
            for (PluginEntry pluginEntry : this.entryMap.values()) {
                if (pluginEntry.onload) {
                    getPlugin(pluginEntry.service);
                } else {
                    LOG.d(TAG, "startupPlugins: put - " + pluginEntry.service);
                    this.pluginMap.put(pluginEntry.service, null);
                }
            }
        }
    }

    public void addService(String str, String str2) {
        addService(str, str2, false);
    }

    public void exec(String str, String str2, String str3, String str4) {
        CordovaPlugin plugin = getPlugin(str);
        if (plugin == null) {
            LOG.d(TAG, "exec() call to unknown plugin: " + str);
            this.app.sendPluginResult(new PluginResult(PluginResult.Status.CLASS_NOT_FOUND_EXCEPTION), str3);
            return;
        }
        CallbackContext callbackContext = new CallbackContext(str3, this.app);
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean zExecute = plugin.execute(str2, str4, callbackContext);
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            if (jCurrentTimeMillis2 > SLOW_EXEC_WARNING_THRESHOLD) {
                LOG.w(TAG, "THREAD WARNING: exec() call to " + str + "." + str2 + " blocked the main thread for " + jCurrentTimeMillis2 + "ms. Plugin should use CordovaInterface.getThreadPool().");
            }
            if (zExecute) {
                return;
            }
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.INVALID_ACTION));
        } catch (JSONException unused) {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.JSON_EXCEPTION));
        } catch (Exception e) {
            LOG.e(TAG, "Uncaught exception from plugin", e);
            callbackContext.error(e.getMessage());
        }
    }

    public CordovaPlugin getPlugin(String str) {
        CordovaPlugin cordovaPluginInstantiatePlugin = this.pluginMap.get(str);
        if (cordovaPluginInstantiatePlugin == null) {
            PluginEntry pluginEntry = this.entryMap.get(str);
            if (pluginEntry == null) {
                return null;
            }
            CordovaPlugin cordovaPlugin = pluginEntry.plugin;
            cordovaPluginInstantiatePlugin = cordovaPlugin != null ? cordovaPlugin : instantiatePlugin(pluginEntry.pluginClass);
            CordovaInterface cordovaInterface = this.ctx;
            CordovaWebView cordovaWebView = this.app;
            cordovaPluginInstantiatePlugin.privateInitialize(str, cordovaInterface, cordovaWebView, cordovaWebView.getPreferences());
            LOG.d(TAG, "getPlugin - put: " + str);
            this.pluginMap.put(str, cordovaPluginInstantiatePlugin);
        }
        return cordovaPluginInstantiatePlugin;
    }

    public Collection<PluginEntry> getPluginEntries() {
        return this.entryMap.values();
    }

    public ArrayList<CordovaPluginPathHandler> getPluginPathHandlers() {
        ArrayList<CordovaPluginPathHandler> arrayList = new ArrayList<>();
        for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
            if (cordovaPlugin != null && cordovaPlugin.getPathHandler() != null) {
                arrayList.add(cordovaPlugin.getPathHandler());
            }
        }
        return arrayList;
    }

    public void init() {
        LOG.d(TAG, "init()");
        this.isInitialized = true;
        onPause(false);
        onDestroy();
        this.pluginMap.clear();
        startupPlugins();
    }

    public void onConfigurationChanged(Configuration configuration) {
        synchronized (this.pluginMap) {
            for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
                if (cordovaPlugin != null) {
                    cordovaPlugin.onConfigurationChanged(configuration);
                }
            }
        }
    }

    public void onDestroy() {
        synchronized (this.pluginMap) {
            for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
                if (cordovaPlugin != null) {
                    cordovaPlugin.onDestroy();
                }
            }
        }
    }

    public void onNewIntent(Intent intent) {
        synchronized (this.pluginMap) {
            for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
                if (cordovaPlugin != null) {
                    cordovaPlugin.onNewIntent(intent);
                }
            }
        }
    }

    public boolean onOverrideUrlLoading(String str) {
        synchronized (this.entryMap) {
            Iterator<PluginEntry> it = this.entryMap.values().iterator();
            while (it.hasNext()) {
                CordovaPlugin cordovaPlugin = this.pluginMap.get(it.next().service);
                if (cordovaPlugin != null && cordovaPlugin.onOverrideUrlLoading(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void onPause(boolean z) {
        synchronized (this.pluginMap) {
            for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
                if (cordovaPlugin != null) {
                    cordovaPlugin.onPause(z);
                }
            }
        }
    }

    public boolean onReceivedClientCertRequest(CordovaWebView cordovaWebView, ICordovaClientCertRequest iCordovaClientCertRequest) {
        synchronized (this.pluginMap) {
            for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
                if (cordovaPlugin != null && cordovaPlugin.onReceivedClientCertRequest(this.app, iCordovaClientCertRequest)) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean onReceivedHttpAuthRequest(CordovaWebView cordovaWebView, ICordovaHttpAuthHandler iCordovaHttpAuthHandler, String str, String str2) {
        synchronized (this.pluginMap) {
            for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
                if (cordovaPlugin != null && cordovaPlugin.onReceivedHttpAuthRequest(this.app, iCordovaHttpAuthHandler, str, str2)) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        boolean z;
        synchronized (this.entryMap) {
            Iterator<PluginEntry> it = this.entryMap.values().iterator();
            z = false;
            while (it.hasNext()) {
                CordovaPlugin cordovaPlugin = this.pluginMap.get(it.next().service);
                if (cordovaPlugin != null && cordovaPlugin.onRenderProcessGone(webView, renderProcessGoneDetail)) {
                    z = true;
                }
            }
        }
        return z;
    }

    public void onReset() {
        synchronized (this.pluginMap) {
            for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
                if (cordovaPlugin != null) {
                    cordovaPlugin.onReset();
                }
            }
        }
    }

    public void onResume(boolean z) {
        synchronized (this.pluginMap) {
            for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
                if (cordovaPlugin != null) {
                    cordovaPlugin.onResume(z);
                }
            }
        }
    }

    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState;
        Bundle bundle = new Bundle();
        synchronized (this.pluginMap) {
            for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
                if (cordovaPlugin != null && (bundleOnSaveInstanceState = cordovaPlugin.onSaveInstanceState()) != null) {
                    bundle.putBundle(cordovaPlugin.getServiceName(), bundleOnSaveInstanceState);
                }
            }
        }
        return bundle;
    }

    public void onStart() {
        synchronized (this.pluginMap) {
            for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
                if (cordovaPlugin != null) {
                    cordovaPlugin.onStart();
                }
            }
        }
    }

    public void onStop() {
        synchronized (this.pluginMap) {
            for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
                if (cordovaPlugin != null) {
                    cordovaPlugin.onStop();
                }
            }
        }
    }

    public Object postMessage(final String str, final Object obj) {
        LOG.d(TAG, "postMessage: " + str);
        synchronized (this.pluginMap) {
            this.pluginMap.forEach(new BiConsumer() { // from class: dc.ie4
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj2, Object obj3) {
                    PluginManager.a(str, obj, (String) obj2, (CordovaPlugin) obj3);
                }
            });
        }
        return this.ctx.onMessage(str, obj);
    }

    public Uri remapUri(Uri uri) {
        Uri uriRemapUri;
        synchronized (this.pluginMap) {
            for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
                if (cordovaPlugin != null && (uriRemapUri = cordovaPlugin.remapUri(uri)) != null) {
                    return uriRemapUri;
                }
            }
            return null;
        }
    }

    public void setPluginEntries(Collection<PluginEntry> collection) {
        if (this.isInitialized) {
            onPause(false);
            onDestroy();
            this.pluginMap.clear();
            this.entryMap.clear();
        }
        Iterator<PluginEntry> it = collection.iterator();
        while (it.hasNext()) {
            addService(it.next());
        }
        if (this.isInitialized) {
            startupPlugins();
        }
    }

    public boolean shouldAllowBridgeAccess(String str) {
        Boolean boolShouldAllowBridgeAccess;
        synchronized (this.entryMap) {
            Iterator<PluginEntry> it = this.entryMap.values().iterator();
            while (it.hasNext()) {
                CordovaPlugin cordovaPlugin = this.pluginMap.get(it.next().service);
                if (cordovaPlugin != null && (boolShouldAllowBridgeAccess = cordovaPlugin.shouldAllowBridgeAccess(str)) != null) {
                    return boolShouldAllowBridgeAccess.booleanValue();
                }
            }
            return str.startsWith(getLaunchUrlPrefix());
        }
    }

    public boolean shouldAllowNavigation(String str) {
        Boolean boolShouldAllowNavigation;
        synchronized (this.entryMap) {
            Iterator<PluginEntry> it = this.entryMap.values().iterator();
            while (it.hasNext()) {
                CordovaPlugin cordovaPlugin = this.pluginMap.get(it.next().service);
                if (cordovaPlugin != null && (boolShouldAllowNavigation = cordovaPlugin.shouldAllowNavigation(str)) != null) {
                    return boolShouldAllowNavigation.booleanValue();
                }
            }
            return str.startsWith(getLaunchUrlPrefix()) || str.startsWith("about:blank");
        }
    }

    public boolean shouldAllowRequest(String str) {
        Boolean boolShouldAllowRequest;
        synchronized (this.entryMap) {
            Iterator<PluginEntry> it = this.entryMap.values().iterator();
            while (it.hasNext()) {
                CordovaPlugin cordovaPlugin = this.pluginMap.get(it.next().service);
                if (cordovaPlugin != null && (boolShouldAllowRequest = cordovaPlugin.shouldAllowRequest(str)) != null) {
                    return boolShouldAllowRequest.booleanValue();
                }
            }
            if (str.startsWith("blob:") || str.startsWith("data:") || str.startsWith("about:blank") || str.startsWith("https://ssl.gstatic.com/accessibility/javascript/android/")) {
                return true;
            }
            if (str.startsWith("file://")) {
                return !str.contains("/app_webview/");
            }
            return false;
        }
    }

    public Boolean shouldOpenExternalUrl(String str) {
        Boolean boolShouldOpenExternalUrl;
        synchronized (this.entryMap) {
            Iterator<PluginEntry> it = this.entryMap.values().iterator();
            while (it.hasNext()) {
                CordovaPlugin cordovaPlugin = this.pluginMap.get(it.next().service);
                if (cordovaPlugin != null && (boolShouldOpenExternalUrl = cordovaPlugin.shouldOpenExternalUrl(str)) != null) {
                    return boolShouldOpenExternalUrl;
                }
            }
            return Boolean.FALSE;
        }
    }

    public void addService(String str, String str2, boolean z) {
        addService(new PluginEntry(str, str2, z));
    }

    public void addService(PluginEntry pluginEntry) {
        this.entryMap.put(pluginEntry.service, pluginEntry);
        CordovaPlugin cordovaPlugin = pluginEntry.plugin;
        if (cordovaPlugin != null) {
            String str = pluginEntry.service;
            CordovaInterface cordovaInterface = this.ctx;
            CordovaWebView cordovaWebView = this.app;
            cordovaPlugin.privateInitialize(str, cordovaInterface, cordovaWebView, cordovaWebView.getPreferences());
            LOG.d(TAG, "addService: put - " + pluginEntry.service);
            this.pluginMap.put(pluginEntry.service, pluginEntry.plugin);
        }
    }
}
