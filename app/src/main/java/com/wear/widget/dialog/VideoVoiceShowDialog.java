package com.wear.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.PowerManager;
import android.widget.FrameLayout;
import butterknife.BindView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.lovense.wear.R;
import com.wear.bean.event.WebRtcStatusEvent;
import com.wear.protocol.MessageType;
import dc.ch3;
import dc.ev1;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes4.dex */
public class VideoVoiceShowDialog extends FullScreenDialog implements SensorEventListener {

    @BindView(R.id.fl_root_view)
    public FrameLayout flRootView;
    public ev1 g;
    public SensorManager h;
    public PowerManager i;
    public Sensor j;
    public PowerManager.WakeLock k;
    public boolean l;

    public class a implements DialogInterface.OnDismissListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            VideoVoiceShowDialog videoVoiceShowDialog = VideoVoiceShowDialog.this;
            ev1 ev1Var = videoVoiceShowDialog.g;
            if (ev1Var != null) {
                ev1Var.a(videoVoiceShowDialog.flRootView);
            }
            VideoVoiceShowDialog.this.t();
            VideoVoiceShowDialog.this.u();
        }
    }

    public VideoVoiceShowDialog(Context context) {
        super(context);
        this.l = false;
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_video_voice;
    }

    @Override // dc.is3
    public void i() {
        setOnDismissListener(new a());
        ev1 ev1Var = this.g;
        if (ev1Var != null) {
            ev1Var.b(this.flRootView);
        }
        s();
        v();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(WebRtcStatusEvent webRtcStatusEvent) {
        this.l = webRtcStatusEvent.getStatus() == 1;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.l && ch3.n().u().currentControlType == MessageType.voice) {
            if (sensorEvent.values[0] == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                PowerManager.WakeLock wakeLock = this.k;
                if (wakeLock == null || wakeLock.isHeld()) {
                    return;
                }
                this.k.acquire();
                return;
            }
            PowerManager.WakeLock wakeLock2 = this.k;
            if (wakeLock2 == null || !wakeLock2.isHeld()) {
                return;
            }
            this.k.release();
        }
    }

    public final void s() {
        SensorManager sensorManager = (SensorManager) this.b.getSystemService("sensor");
        this.h = sensorManager;
        if (sensorManager != null) {
            this.j = sensorManager.getDefaultSensor(8);
        }
        PowerManager powerManager = (PowerManager) this.b.getSystemService("power");
        this.i = powerManager;
        if (Build.VERSION.SDK_INT < 21 || powerManager == null) {
            return;
        }
        this.k = powerManager.newWakeLock(32, getClass().getSimpleName());
    }

    public void setICreateRootView(ev1 ev1Var) {
        this.g = ev1Var;
    }

    public final void t() {
        SensorManager sensorManager = this.h;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    public final void u() {
        PowerManager.WakeLock wakeLock = this.k;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.k.release();
        }
        this.k = null;
        this.i = null;
        this.h = null;
    }

    public final void v() {
        Sensor sensor;
        SensorManager sensorManager = this.h;
        if (sensorManager == null || (sensor = this.j) == null) {
            return;
        }
        sensorManager.registerListener(this, sensor, 3);
    }
}
