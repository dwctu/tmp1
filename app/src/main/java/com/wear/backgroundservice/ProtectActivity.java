package com.wear.backgroundservice;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class ProtectActivity extends Activity {
    public static WeakReference<ProtectActivity> a;

    public void a() {
        if (isFinishing()) {
            return;
        }
        finish();
    }

    public void b() {
        a = new WeakReference<>(this);
        System.err.println("锁屏!!!");
        Window window = getWindow();
        window.setGravity(51);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.height = 1;
        attributes.width = 1;
        window.setAttributes(attributes);
    }

    public final boolean c() {
        PowerManager powerManager = (PowerManager) getApplicationContext().getSystemService("power");
        return Build.VERSION.SDK_INT >= 20 ? powerManager.isInteractive() : powerManager.isScreenOn();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a();
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = resources.getConfiguration();
        if (configuration.fontScale != 1.0f) {
            configuration.fontScale = 1.0f;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return resources;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        System.err.println("解锁!!!");
        WeakReference<ProtectActivity> weakReference = a;
        if (weakReference == null || weakReference.get() != this) {
            return;
        }
        a = null;
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (c()) {
            a();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a();
        return super.onTouchEvent(motionEvent);
    }
}
