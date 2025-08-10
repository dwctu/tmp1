package org.apache.cordova.devicemotion;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.wear.widget.control.FingImageLayout;
import dc.s23;
import java.util.List;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.errcode.ErrorCode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class AccelListener extends CordovaPlugin implements SensorEventListener {
    public static int ERROR_FAILED_TO_START = 3;
    public static int RUNNING = 2;
    public static int STARTING = 1;
    public static int STOPPED;
    private CallbackContext callbackContext;
    private Sensor mSensor;
    private SensorManager sensorManager;
    private int status;
    private int accuracy = 2;
    private Handler mainHandler = null;
    private Runnable mainRunnable = new Runnable() { // from class: org.apache.cordova.devicemotion.AccelListener.1
        @Override // java.lang.Runnable
        public void run() {
            AccelListener.this.timeout();
        }
    };
    private float x = 0.0f;
    private float y = 0.0f;
    private float z = 0.0f;
    private long timestamp = 0;

    public AccelListener() {
        setStatus(STOPPED);
    }

    private void fail(ErrorCode errorCode) {
        PluginResult pluginResult = new PluginResult(PluginResult.Status.ERROR, s23.a.a(errorCode));
        pluginResult.setKeepCallback(true);
        this.callbackContext.sendPluginResult(pluginResult);
    }

    private JSONObject getAccelerationJSON() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", this.x);
            jSONObject.put(FingImageLayout.ObjectAnimatorY, this.y);
            jSONObject.put("z", this.z);
            jSONObject.put("timestamp", this.timestamp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private void setStatus(int i) {
        this.status = i;
    }

    private int start() {
        int i;
        int i2 = this.status;
        if (i2 == RUNNING || i2 == (i = STARTING)) {
            startTimeout();
            return this.status;
        }
        setStatus(i);
        List<Sensor> sensorList = this.sensorManager.getSensorList(1);
        if (sensorList == null || sensorList.size() <= 0) {
            setStatus(ERROR_FAILED_TO_START);
            fail(ErrorCode.Error21107.INSTANCE);
            return this.status;
        }
        Sensor sensor = sensorList.get(0);
        this.mSensor = sensor;
        if (!this.sensorManager.registerListener(this, sensor, 2)) {
            setStatus(ERROR_FAILED_TO_START);
            fail(ErrorCode.Error21106.INSTANCE);
            return this.status;
        }
        setStatus(STARTING);
        this.accuracy = 2;
        startTimeout();
        return this.status;
    }

    private void startTimeout() {
        stopTimeout();
        Handler handler = new Handler(Looper.getMainLooper());
        this.mainHandler = handler;
        handler.postDelayed(this.mainRunnable, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    private void stop() {
        stopTimeout();
        if (this.status != STOPPED) {
            this.sensorManager.unregisterListener(this);
        }
        setStatus(STOPPED);
        this.accuracy = 0;
    }

    private void stopTimeout() {
        Handler handler = this.mainHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mainRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void timeout() {
        if (this.status != STARTING || this.accuracy < 2) {
            return;
        }
        this.timestamp = System.currentTimeMillis();
        win();
    }

    private void win() {
        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, getAccelerationJSON());
        pluginResult.setKeepCallback(true);
        this.callbackContext.sendPluginResult(pluginResult);
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) {
        if (str.equals(TtmlNode.START)) {
            this.callbackContext = callbackContext;
            if (this.status != RUNNING) {
                start();
            }
        } else {
            if (!str.equals("stop")) {
                return false;
            }
            if (this.status == RUNNING) {
                stop();
            }
        }
        PluginResult pluginResult = new PluginResult(PluginResult.Status.NO_RESULT, "");
        pluginResult.setKeepCallback(true);
        callbackContext.sendPluginResult(pluginResult);
        return true;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void initialize(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
        super.initialize(cordovaInterface, cordovaWebView);
        this.sensorManager = (SensorManager) cordovaInterface.getActivity().getSystemService("sensor");
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        if (sensor.getType() == 1 && this.status != STOPPED) {
            this.accuracy = i;
        }
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onDestroy() {
        stop();
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onReset() {
        if (this.status == RUNNING) {
            stop();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1 && this.status != STOPPED) {
            setStatus(RUNNING);
            if (this.accuracy >= 2) {
                this.timestamp = System.currentTimeMillis();
                float[] fArr = sensorEvent.values;
                this.x = fArr[0];
                this.y = fArr[1];
                this.z = fArr[2];
                win();
            }
        }
    }
}
