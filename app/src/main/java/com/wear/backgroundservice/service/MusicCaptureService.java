package com.wear.backgroundservice.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioFormat;
import android.media.AudioPlaybackCaptureConfiguration;
import android.media.AudioRecord;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.IBinder;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.wear.bean.HomeMusicBean;
import dc.fk2;
import dc.m43;
import dc.rd3;
import dc.rq1;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class MusicCaptureService extends Service implements m43 {
    public static int h = 16;
    public static double[][] i = (double[][]) Array.newInstance((Class<?>) double.class, 16, 20);
    public MediaProjectionManager a;
    public MediaProjection b = null;
    public Thread c = null;
    public AudioRecord d = null;
    public List<Integer> e = new ArrayList();
    public List<Integer> f = new ArrayList();
    public boolean g = false;

    public class a extends Thread {
        public a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            MusicCaptureService.this.k();
        }
    }

    public static double b(byte[] bArr) {
        int iAbs = 0;
        for (byte b : bArr) {
            iAbs += Math.abs((int) b);
        }
        return (iAbs * 1.0d) / bArr.length;
    }

    public static double c(double[] dArr) {
        double dAbs = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (double d : dArr) {
            dAbs += Math.abs(d);
        }
        return (dAbs * 1.0d) / dArr.length;
    }

    public static double[] g(byte[] bArr) {
        int i2 = h;
        double[] dArr = new double[i2];
        int length = bArr.length / i2;
        int i3 = 0;
        while (i3 < h) {
            int i4 = i3 + 1;
            dArr[i3] = b(Arrays.copyOfRange(bArr, i3 * length, i4 * length));
            i3 = i4;
        }
        return dArr;
    }

    public static double[] i(double[] dArr, double d) {
        for (int length = dArr.length - 1; length > 0; length--) {
            dArr[length] = dArr[length - 1];
        }
        dArr[0] = d;
        return dArr;
    }

    public final void d() {
        stopForeground(true);
        try {
            ((NotificationManager) getSystemService("notification")).cancel(1008);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void e() {
        Iterator<Integer> it = this.e.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (it.next().intValue() > 0) {
                z = true;
            }
        }
        if (this.e.size() >= 10) {
            this.e.clear();
        }
        this.g = z;
        rd3.f().k(this.g);
    }

    public final void f() {
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(new NotificationChannel("AudioCapture channel", "Audio Capture Service Channel", 3));
        }
    }

    public int h(byte[] bArr) {
        double[] dArrG = g(bArr);
        double dMax = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i2 = 0; i2 < h; i2++) {
            i(i[i2], dArrG[i2]);
            dMax = Math.max(dMax, (dArrG[i2] * 1.0d) / c(i[i2]));
        }
        if (dMax > 2.2d) {
            return 20;
        }
        return dMax > 1.1d ? Math.max((int) ((Math.abs(dMax - 1.1d) * 25.0d) % 20.0d), 3) : dMax > 0.8d ? 2 : 0;
    }

    public void j() throws UnsupportedOperationException, IllegalStateException {
        if (this.b != null) {
            try {
                int i2 = getPackageManager().getApplicationInfo("com.lovense.wear", 1).uid;
                if (Build.VERSION.SDK_INT >= 29) {
                    AudioRecord audioRecordBuild = new AudioRecord.Builder().setAudioFormat(new AudioFormat.Builder().setEncoding(2).setSampleRate(8000).setChannelMask(16).build()).setBufferSizeInBytes(2048).setAudioPlaybackCaptureConfig(new AudioPlaybackCaptureConfiguration.Builder(this.b).addMatchingUsage(1).addMatchingUsage(0).excludeUid(i2).build()).build();
                    this.d = audioRecordBuild;
                    audioRecordBuild.startRecording();
                    a aVar = new a();
                    this.c = aVar;
                    aVar.start();
                    fk2.a.l();
                }
            } catch (PackageManager.NameNotFoundException | UnsupportedOperationException e) {
                e.printStackTrace();
            }
        }
    }

    public final void k() {
        byte[] bArr = new byte[1024];
        while (!this.c.isInterrupted()) {
            this.d.read(bArr, 0, 1024);
            int iH = h(bArr);
            if (this.e.size() < 25) {
                this.e.add(Integer.valueOf(iH));
            }
            if (this.e.size() == 25) {
                e();
            }
            if (rd3.f().o() && rd3.f().n()) {
                String str = "跟随音乐播放pattern: " + iH;
                rq1.d.j(iH);
                rd3.f().u(Math.round(iH));
                this.f.clear();
            } else if (this.f.size() < 6) {
                this.f.add(0);
                rq1.d.j(0);
            }
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        f();
        rd3.f().G(this);
        startForeground(1008, new NotificationCompat.Builder(this, "AudioCapture channel").build());
        this.a = (MediaProjectionManager) getSystemService("media_projection");
    }

    @Override // android.app.Service
    public void onDestroy() {
        rd3.f().z(false);
        EventBus.getDefault().post(new HomeMusicBean(13));
        for (int i2 = 0; i2 < 5; i2++) {
            rq1.d.j(0);
        }
        d();
        stopSelf();
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) throws UnsupportedOperationException, IllegalStateException {
        if (intent == null || Build.VERSION.SDK_INT < 26 || !"AudioCaptureService:Start".equals(intent.getAction())) {
            return 1;
        }
        if (intent.getParcelableExtra("AudioCaptureService:Extra:ResultData") != null) {
            this.b = this.a.getMediaProjection(-1, (Intent) intent.getParcelableExtra("AudioCaptureService:Extra:ResultData"));
        }
        j();
        return 1;
    }
}
