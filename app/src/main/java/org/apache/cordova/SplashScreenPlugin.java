package org.apache.cordova;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.view.animation.AccelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.splashscreen.SplashScreenViewProvider;
import org.json.JSONArray;
import org.json.JSONException;

@SuppressLint({"LongLogTag"})
/* loaded from: classes5.dex */
public class SplashScreenPlugin extends CordovaPlugin {
    private static final boolean DEFAULT_AUTO_HIDE = true;
    private static final int DEFAULT_DELAY_TIME = -1;
    private static final boolean DEFAULT_FADE = true;
    private static final int DEFAULT_FADE_TIME = 500;
    public static final String PLUGIN_NAME = "CordovaSplashScreenPlugin";
    private boolean autoHide;
    private int delayTime;
    private int fadeDuration;
    private boolean isFadeEnabled;
    private boolean keepOnScreen = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean b() {
        return this.keepOnScreen;
    }

    private void attemptCloseOnPageFinished() {
        if (this.autoHide && this.delayTime == -1) {
            this.keepOnScreen = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d() {
        this.keepOnScreen = false;
    }

    private void setupSplashScreen(SplashScreen splashScreen) {
        splashScreen.setKeepOnScreenCondition(new SplashScreen.KeepOnScreenCondition() { // from class: dc.ke4
            @Override // androidx.core.splashscreen.SplashScreen.KeepOnScreenCondition
            public final boolean shouldKeepOnScreen() {
                return this.a.b();
            }
        });
        if (this.autoHide && this.delayTime != -1) {
            new Handler(this.cordova.getContext().getMainLooper()).postDelayed(new Runnable() { // from class: dc.je4
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.d();
                }
            }, this.delayTime);
        }
        if (this.isFadeEnabled) {
            splashScreen.setOnExitAnimationListener(new SplashScreen.OnExitAnimationListener() { // from class: org.apache.cordova.SplashScreenPlugin.1
                @Override // androidx.core.splashscreen.SplashScreen.OnExitAnimationListener
                public void onSplashScreenExit(@NonNull final SplashScreenViewProvider splashScreenViewProvider) {
                    splashScreenViewProvider.getView().animate().alpha(0.0f).setDuration(SplashScreenPlugin.this.fadeDuration).setStartDelay(0L).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListenerAdapter() { // from class: org.apache.cordova.SplashScreenPlugin.1.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            splashScreenViewProvider.remove();
                        }
                    }).start();
                }
            });
        }
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) throws JSONException {
        if (!str.equals("hide") || this.autoHide) {
            return false;
        }
        this.keepOnScreen = false;
        callbackContext.success();
        return true;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public Object onMessage(String str, Object obj) {
        str.hashCode();
        if (str.equals("onPageFinished")) {
            attemptCloseOnPageFinished();
            return null;
        }
        if (!str.equals("setupSplashScreen")) {
            return null;
        }
        setupSplashScreen((SplashScreen) obj);
        return null;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void pluginInitialize() {
        this.autoHide = this.preferences.getBoolean("AutoHideSplashScreen", true);
        this.delayTime = this.preferences.getInteger("SplashScreenDelay", -1);
        LOG.d(PLUGIN_NAME, "Auto Hide: " + this.autoHide);
        if (this.delayTime != -1) {
            LOG.d(PLUGIN_NAME, "Delay: " + this.delayTime + "ms");
        }
        this.isFadeEnabled = this.preferences.getBoolean("FadeSplashScreen", true);
        this.fadeDuration = this.preferences.getInteger("FadeSplashScreenDuration", 500);
        LOG.d(PLUGIN_NAME, "Fade: " + this.isFadeEnabled);
        if (this.isFadeEnabled) {
            LOG.d(PLUGIN_NAME, "Fade Duration: " + this.fadeDuration + "ms");
        }
    }
}
