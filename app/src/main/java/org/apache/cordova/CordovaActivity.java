package org.apache.cordova;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class CordovaActivity extends AppCompatActivity {
    private static int ACTIVITY_EXITING = 2;
    private static int ACTIVITY_RUNNING = 1;
    private static int ACTIVITY_STARTING = 0;
    public static String TAG = "CordovaActivity";
    public CordovaWebView appView;
    public CordovaInterfaceImpl cordovaInterface;
    public boolean immersiveMode;
    public boolean keepRunning = true;
    public String launchUrl;
    public ArrayList<PluginEntry> pluginEntries;
    public CordovaPreferences preferences;
    private SplashScreen splashScreen;

    public void createViews() {
        this.appView.getView().setId(100);
        this.appView.getView().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setContentView(this.appView.getView());
        if (this.preferences.contains("BackgroundColor")) {
            try {
                this.appView.getView().setBackgroundColor(this.preferences.getInteger("BackgroundColor", ViewCompat.MEASURED_STATE_MASK));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        this.appView.getView().requestFocusFromTouch();
    }

    public void displayError(final String str, final String str2, final String str3, final boolean z) {
        runOnUiThread(new Runnable() { // from class: org.apache.cordova.CordovaActivity.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(str2);
                    builder.setTitle(str);
                    builder.setCancelable(false);
                    builder.setPositiveButton(str3, new DialogInterface.OnClickListener() { // from class: org.apache.cordova.CordovaActivity.4.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            if (z) {
                                CordovaActivity.this.finish();
                            }
                        }
                    });
                    builder.create();
                    builder.show();
                } catch (Exception unused) {
                    CordovaActivity.this.finish();
                }
            }
        });
    }

    public PluginManager getPluginManage() {
        return this.cordovaInterface.pluginManager;
    }

    public void init() throws JSONException {
        this.appView = makeWebView();
        createViews();
        if (!this.appView.isInitialized()) {
            this.appView.init(this.cordovaInterface, this.pluginEntries, this.preferences);
        }
        this.cordovaInterface.onCordovaInit(this.appView.getPluginManager());
        this.cordovaInterface.pluginManager.postMessage("setupSplashScreen", this.splashScreen);
        if ("media".equals(this.preferences.getString("DefaultVolumeStream", "").toLowerCase(Locale.ENGLISH))) {
            setVolumeControlStream(3);
        }
    }

    public void loadConfig() throws XmlPullParserException, IOException {
        ConfigXmlParser configXmlParser = new ConfigXmlParser();
        configXmlParser.parse(this);
        CordovaPreferences preferences = configXmlParser.getPreferences();
        this.preferences = preferences;
        preferences.setPreferencesBundle(getIntent().getExtras());
        this.launchUrl = configXmlParser.getLaunchUrl();
        this.pluginEntries = configXmlParser.getPluginEntries();
        Config.parser = configXmlParser;
    }

    public void loadUrl(String str) {
        if (this.appView == null) {
            init();
        }
        this.keepRunning = this.preferences.getBoolean("KeepRunning", true);
        this.appView.loadUrlIntoView(str, true);
    }

    public CordovaInterfaceImpl makeCordovaInterface() {
        return new CordovaInterfaceImpl(this) { // from class: org.apache.cordova.CordovaActivity.1
            @Override // org.apache.cordova.CordovaInterfaceImpl, org.apache.cordova.CordovaInterface
            public Object onMessage(String str, Object obj) {
                return CordovaActivity.this.onMessage(str, obj);
            }
        };
    }

    public CordovaWebView makeWebView() {
        return new CordovaWebViewImpl(makeWebViewEngine());
    }

    public CordovaWebViewEngine makeWebViewEngine() {
        return CordovaWebViewImpl.createEngine(this, this.preferences);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        LOG.d(TAG, "Incoming Result. Request code = " + i);
        super.onActivityResult(i, i2, intent);
        this.cordovaInterface.onActivityResult(i, i2, intent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        PluginManager pluginManager;
        super.onConfigurationChanged(configuration);
        CordovaWebView cordovaWebView = this.appView;
        if (cordovaWebView == null || (pluginManager = cordovaWebView.getPluginManager()) == null) {
            return;
        }
        pluginManager.onConfigurationChanged(configuration);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.splashScreen = SplashScreen.installSplashScreen(this);
        loadConfig();
        LOG.setLogLevel(this.preferences.getString("loglevel", "ERROR"));
        LOG.i(TAG, "Apache Cordova native platform version 12.0.0 is starting");
        LOG.d(TAG, "CordovaActivity.onCreate()");
        if (!this.preferences.getBoolean("ShowTitle", false)) {
            getWindow().requestFeature(1);
        }
        if (this.preferences.getBoolean("SetFullscreen", false)) {
            LOG.d(TAG, "The SetFullscreen configuration is deprecated in favor of Fullscreen, and will be removed in a future version.");
            this.preferences.set("Fullscreen", true);
        }
        if (!this.preferences.getBoolean("Fullscreen", false)) {
            getWindow().setFlags(2048, 2048);
        } else if (this.preferences.getBoolean("FullscreenNotImmersive", false)) {
            getWindow().setFlags(1024, 1024);
        } else {
            this.immersiveMode = true;
            setImmersiveUiVisibility();
        }
        super.onCreate(bundle);
        CordovaInterfaceImpl cordovaInterfaceImplMakeCordovaInterface = makeCordovaInterface();
        this.cordovaInterface = cordovaInterfaceImplMakeCordovaInterface;
        if (bundle != null) {
            cordovaInterfaceImplMakeCordovaInterface.restoreInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        CordovaWebView cordovaWebView = this.appView;
        if (cordovaWebView != null) {
            cordovaWebView.getPluginManager().postMessage("onCreateOptionsMenu", menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        LOG.d(TAG, "CordovaActivity.onDestroy()");
        super.onDestroy();
        CordovaWebView cordovaWebView = this.appView;
        if (cordovaWebView != null) {
            cordovaWebView.handleDestroy();
        }
    }

    public Object onMessage(String str, Object obj) {
        if (!"onReceivedError".equals(str)) {
            if (!"exit".equals(str)) {
                return null;
            }
            finish();
            return null;
        }
        JSONObject jSONObject = (JSONObject) obj;
        try {
            onReceivedError(jSONObject.getInt("errorCode"), jSONObject.getString("description"), jSONObject.getString(ImagesContract.URL));
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        CordovaWebView cordovaWebView = this.appView;
        if (cordovaWebView != null) {
            cordovaWebView.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        CordovaWebView cordovaWebView = this.appView;
        if (cordovaWebView == null) {
            return true;
        }
        cordovaWebView.getPluginManager().postMessage("onOptionsItemSelected", menuItem);
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LOG.d(TAG, "Paused the activity.");
        CordovaWebView cordovaWebView = this.appView;
        if (cordovaWebView != null) {
            cordovaWebView.handlePause(this.keepRunning || this.cordovaInterface.activityResultCallback != null);
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        CordovaWebView cordovaWebView = this.appView;
        if (cordovaWebView == null) {
            return true;
        }
        cordovaWebView.getPluginManager().postMessage("onPrepareOptionsMenu", menu);
        return true;
    }

    public void onReceivedError(int i, final String str, final String str2) {
        final String string = this.preferences.getString("errorUrl", null);
        if (string != null && !str2.equals(string) && this.appView != null) {
            runOnUiThread(new Runnable() { // from class: org.apache.cordova.CordovaActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    this.appView.showWebPage(string, false, true, null);
                }
            });
        } else {
            final boolean z = i != -2;
            runOnUiThread(new Runnable() { // from class: org.apache.cordova.CordovaActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        this.appView.getView().setVisibility(8);
                        this.displayError("Application Error", str + " (" + str2 + ")", "OK", z);
                    }
                }
            });
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        try {
            this.cordovaInterface.onRequestPermissionResult(i, strArr, iArr);
        } catch (JSONException e) {
            LOG.d(TAG, "JSONException: Parameters fed into the method are not valid");
            e.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        LOG.d(TAG, "Resumed the activity.");
        if (this.appView == null) {
            return;
        }
        if (!getWindow().getDecorView().hasFocus()) {
            getWindow().getDecorView().requestFocus();
        }
        this.appView.handleResume(this.keepRunning);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.cordovaInterface.onSaveInstanceState(bundle);
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        LOG.d(TAG, "Started the activity.");
        CordovaWebView cordovaWebView = this.appView;
        if (cordovaWebView == null) {
            return;
        }
        cordovaWebView.handleStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        LOG.d(TAG, "Stopped the activity.");
        CordovaWebView cordovaWebView = this.appView;
        if (cordovaWebView == null) {
            return;
        }
        cordovaWebView.handleStop();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.immersiveMode) {
            setImmersiveUiVisibility();
        }
    }

    @SuppressLint({"InlinedApi"})
    public void setImmersiveUiVisibility() {
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        this.cordovaInterface.setActivityResultRequestCode(i);
        super.startActivityForResult(intent, i, bundle);
    }
}
