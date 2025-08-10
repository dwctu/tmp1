package com.epicgames.unreal;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;

/* loaded from: classes.dex */
public class GameApplication_LifecycleAdapter implements GeneratedAdapter {
    public final GameApplication mReceiver;

    public GameApplication_LifecycleAdapter(GameApplication gameApplication) {
        this.mReceiver = gameApplication;
    }

    @Override // androidx.lifecycle.GeneratedAdapter
    public void callMethods(LifecycleOwner lifecycleOwner, Lifecycle.Event event, boolean z, MethodCallsLogger methodCallsLogger) {
        boolean z2 = methodCallsLogger != null;
        if (z) {
            return;
        }
        if (event == Lifecycle.Event.ON_START) {
            if (!z2 || methodCallsLogger.approveCall("onEnterForeground", 1)) {
                this.mReceiver.onEnterForeground();
                return;
            }
            return;
        }
        if (event == Lifecycle.Event.ON_STOP) {
            if (!z2 || methodCallsLogger.approveCall("onEnterBackground", 1)) {
                this.mReceiver.onEnterBackground();
            }
        }
    }
}
