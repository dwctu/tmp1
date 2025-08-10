package org.apache.cordova;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import androidx.appcompat.app.AppCompatActivity;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.cordova.PluginResult;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.amp.packet.AMPExtension;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class CordovaInterfaceImpl implements CordovaInterface {
    private static final String TAG = "CordovaInterfaceImpl";
    public AppCompatActivity activity;
    public CordovaPlugin activityResultCallback;
    public int activityResultRequestCode;
    public boolean activityWasDestroyed;
    public String initCallbackService;
    public CallbackMap permissionResultCallbacks;
    public PluginManager pluginManager;
    public Bundle savedPluginState;
    public ActivityResultHolder savedResult;
    public ExecutorService threadPool;

    public static class ActivityResultHolder {
        private Intent intent;
        private int requestCode;
        private int resultCode;

        public ActivityResultHolder(int i, int i2, Intent intent) {
            this.requestCode = i;
            this.resultCode = i2;
            this.intent = intent;
        }
    }

    public CordovaInterfaceImpl(AppCompatActivity appCompatActivity) {
        this(appCompatActivity, Executors.newCachedThreadPool());
    }

    @Override // org.apache.cordova.CordovaInterface
    public AppCompatActivity getActivity() {
        return this.activity;
    }

    @Override // org.apache.cordova.CordovaInterface
    public Context getContext() {
        return this.activity;
    }

    @Override // org.apache.cordova.CordovaInterface
    public ExecutorService getThreadPool() {
        return this.threadPool;
    }

    @Override // org.apache.cordova.CordovaInterface
    public boolean hasPermission(String str) {
        return this.activity.checkSelfPermission(str) == 0;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        CordovaPlugin plugin = this.activityResultCallback;
        if (plugin == null && this.initCallbackService != null) {
            this.savedResult = new ActivityResultHolder(i, i2, intent);
            PluginManager pluginManager = this.pluginManager;
            if (pluginManager != null && (plugin = pluginManager.getPlugin(this.initCallbackService)) != null) {
                plugin.onRestoreStateForActivityResult(this.savedPluginState.getBundle(plugin.getServiceName()), new ResumeCallback(plugin.getServiceName(), this.pluginManager));
            }
        }
        this.activityResultCallback = null;
        if (plugin != null) {
            LOG.d(TAG, "Sending activity result to plugin");
            this.initCallbackService = null;
            this.savedResult = null;
            plugin.onActivityResult(i, i2, intent);
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Got an activity result, but no plugin was registered to receive it");
        sb.append(this.savedResult != null ? " yet!" : ".");
        LOG.w(TAG, sb.toString());
        return false;
    }

    public void onCordovaInit(PluginManager pluginManager) throws JSONException {
        CoreAndroid coreAndroid;
        this.pluginManager = pluginManager;
        ActivityResultHolder activityResultHolder = this.savedResult;
        if (activityResultHolder != null) {
            onActivityResult(activityResultHolder.requestCode, this.savedResult.resultCode, this.savedResult.intent);
            return;
        }
        if (this.activityWasDestroyed) {
            this.activityWasDestroyed = false;
            if (pluginManager == null || (coreAndroid = (CoreAndroid) pluginManager.getPlugin(CoreAndroid.PLUGIN_NAME)) == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(AMPExtension.Action.ATTRIBUTE_NAME, StreamManagement.Resume.ELEMENT);
            } catch (JSONException e) {
                LOG.e(TAG, "Failed to create event message", e);
            }
            coreAndroid.sendResumeEvent(new PluginResult(PluginResult.Status.OK, jSONObject));
        }
    }

    @Override // org.apache.cordova.CordovaInterface
    public Object onMessage(String str, Object obj) {
        if (!"exit".equals(str)) {
            return null;
        }
        this.activity.finish();
        return null;
    }

    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) throws JSONException {
        Pair<CordovaPlugin, Integer> andRemoveCallback = this.permissionResultCallbacks.getAndRemoveCallback(i);
        if (andRemoveCallback != null) {
            ((CordovaPlugin) andRemoveCallback.first).onRequestPermissionResult(((Integer) andRemoveCallback.second).intValue(), strArr, iArr);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        CordovaPlugin cordovaPlugin = this.activityResultCallback;
        if (cordovaPlugin != null) {
            bundle.putString("callbackService", cordovaPlugin.getServiceName());
        }
        PluginManager pluginManager = this.pluginManager;
        if (pluginManager != null) {
            bundle.putBundle("plugin", pluginManager.onSaveInstanceState());
        }
    }

    @Override // org.apache.cordova.CordovaInterface
    public void requestPermission(CordovaPlugin cordovaPlugin, int i, String str) {
        requestPermissions(cordovaPlugin, i, new String[]{str});
    }

    @Override // org.apache.cordova.CordovaInterface
    @SuppressLint({"NewApi"})
    public void requestPermissions(CordovaPlugin cordovaPlugin, int i, String[] strArr) {
        getActivity().requestPermissions(strArr, this.permissionResultCallbacks.registerCallback(cordovaPlugin, i));
    }

    public void restoreInstanceState(Bundle bundle) {
        this.initCallbackService = bundle.getString("callbackService");
        this.savedPluginState = bundle.getBundle("plugin");
        this.activityWasDestroyed = true;
    }

    @Override // org.apache.cordova.CordovaInterface
    public void setActivityResultCallback(CordovaPlugin cordovaPlugin) {
        CordovaPlugin cordovaPlugin2 = this.activityResultCallback;
        if (cordovaPlugin2 != null) {
            cordovaPlugin2.onActivityResult(this.activityResultRequestCode, 0, null);
        }
        this.activityResultCallback = cordovaPlugin;
    }

    public void setActivityResultRequestCode(int i) {
        this.activityResultRequestCode = i;
    }

    @Override // org.apache.cordova.CordovaInterface
    public void startActivityForResult(CordovaPlugin cordovaPlugin, Intent intent, int i) {
        setActivityResultCallback(cordovaPlugin);
        try {
            this.activity.startActivityForResult(intent, i);
        } catch (RuntimeException e) {
            this.activityResultCallback = null;
            throw e;
        }
    }

    public CordovaInterfaceImpl(AppCompatActivity appCompatActivity, ExecutorService executorService) {
        this.activityWasDestroyed = false;
        this.activity = appCompatActivity;
        this.threadPool = executorService;
        this.permissionResultCallbacks = new CallbackMap();
    }
}
