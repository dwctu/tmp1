package dc;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.wear.ui.longDistance.CameraNewActivity;
import com.wear.util.MyApplication;
import io.agora.rtc2.Constants;
import java.util.Calendar;

/* compiled from: SensorControler.java */
/* loaded from: classes4.dex */
public class kh3 implements SensorEventListener {
    public static kh3 l;
    public SensorManager a;
    public Sensor b;
    public int c;
    public int d;
    public int e;
    public Calendar g;
    public a k;
    public long f = 0;
    public boolean h = false;
    public boolean i = false;
    public int j = 0;

    /* compiled from: SensorControler.java */
    public interface a {
        void a3();
    }

    public kh3() {
        SensorManager sensorManager = (SensorManager) MyApplication.F().a().getSystemService("sensor");
        this.a = sensorManager;
        this.b = sensorManager.getDefaultSensor(1);
    }

    public static kh3 b() {
        if (l == null) {
            l = new kh3();
        }
        return l;
    }

    public int a(float f, float f2) {
        if (Math.abs(f) <= 6.0f || Math.abs(f2) >= 4.0f) {
            return (Math.abs(f2) <= 6.0f || Math.abs(f) >= 4.0f || f2 > 6.0f) ? 0 : 180;
        }
        if (f > 6.0f) {
            return Constants.VIDEO_ORIENTATION_270;
        }
        return 90;
    }

    public void c() {
        d();
        this.a.registerListener(this, this.b, 3);
    }

    public final void d() {
        this.j = 0;
        this.i = false;
        this.c = 0;
        this.d = 0;
        this.e = 0;
    }

    public void e(a aVar) {
        this.k = aVar;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor == null) {
            return;
        }
        float[] fArr = sensorEvent.values;
        CameraNewActivity.C = a(fArr[0], fArr[1]);
        String str = "mSensorRotation = " + CameraNewActivity.C;
        if (this.h) {
            d();
            return;
        }
        if (sensorEvent.sensor.getType() == 1) {
            float[] fArr2 = sensorEvent.values;
            int i = (int) fArr2[0];
            int i2 = (int) fArr2[1];
            int i3 = (int) fArr2[2];
            Calendar calendar = Calendar.getInstance();
            this.g = calendar;
            long timeInMillis = calendar.getTimeInMillis();
            this.g.get(13);
            if (this.j != 0) {
                int iAbs = Math.abs(this.c - i);
                int iAbs2 = Math.abs(this.d - i2);
                int iAbs3 = Math.abs(this.e - i3);
                if (Math.sqrt((iAbs * iAbs) + (iAbs2 * iAbs2) + (iAbs3 * iAbs3)) > 1.4d) {
                    this.j = 2;
                } else {
                    if (this.j == 2) {
                        this.f = timeInMillis;
                        this.i = true;
                    }
                    if (this.i && timeInMillis - this.f > 500 && !this.h) {
                        this.i = false;
                        a aVar = this.k;
                        if (aVar != null) {
                            aVar.a3();
                        }
                    }
                    this.j = 1;
                }
            } else {
                this.f = timeInMillis;
                this.j = 1;
            }
            this.c = i;
            this.d = i2;
            this.e = i3;
        }
    }
}
