package org.apache.cordova;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import java.util.concurrent.ExecutorService;

/* loaded from: classes5.dex */
public interface CordovaInterface {
    AppCompatActivity getActivity();

    Context getContext();

    ExecutorService getThreadPool();

    boolean hasPermission(String str);

    Object onMessage(String str, Object obj);

    void requestPermission(CordovaPlugin cordovaPlugin, int i, String str);

    void requestPermissions(CordovaPlugin cordovaPlugin, int i, String[] strArr);

    void setActivityResultCallback(CordovaPlugin cordovaPlugin);

    void startActivityForResult(CordovaPlugin cordovaPlugin, Intent intent, int i);
}
