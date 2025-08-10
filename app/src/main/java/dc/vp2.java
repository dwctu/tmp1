package dc;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.Nullable;
import org.webrtc.ThreadUtils;

/* compiled from: AppRTCProximitySensor.java */
/* loaded from: classes3.dex */
public class vp2 implements SensorEventListener {
    public final ThreadUtils.ThreadChecker a = new ThreadUtils.ThreadChecker();
    public final Runnable b;
    public final SensorManager c;

    @Nullable
    public Sensor d;
    public boolean e;

    public vp2(Context context, Runnable runnable) {
        String str = "AppRTCProximitySensor" + wp2.b();
        this.b = runnable;
        this.c = (SensorManager) context.getSystemService("sensor");
    }

    public static vp2 a(Context context, Runnable runnable) {
        return new vp2(context, runnable);
    }

    public boolean b() {
        this.a.checkIsOnValidThread();
        return this.e;
    }

    public void c() {
        this.a.checkIsOnValidThread();
        String str = "stop" + wp2.b();
        Sensor sensor = this.d;
        if (sensor == null) {
            return;
        }
        this.c.unregisterListener(this, sensor);
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
        this.a.checkIsOnValidThread();
        wp2.a(sensor.getType() == 8);
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        this.a.checkIsOnValidThread();
        wp2.a(sensorEvent.sensor.getType() == 8);
        if (sensorEvent.values[0] < this.d.getMaximumRange()) {
            this.e = true;
        } else {
            this.e = false;
        }
        Runnable runnable = this.b;
        if (runnable != null) {
            runnable.run();
        }
        String str = "onSensorChanged" + wp2.b() + ": accuracy=" + sensorEvent.accuracy + ", timestamp=" + sensorEvent.timestamp + ", distance=" + sensorEvent.values[0];
    }
}
