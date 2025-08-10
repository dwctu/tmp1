package dc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioRecord;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.audiofx.Equalizer;
import android.media.audiofx.Visualizer;
import android.net.Uri;
import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.lovense.wear.R;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.kn3;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

/* compiled from: AudioUtil.java */
/* loaded from: classes4.dex */
public class so3 {
    public static int i = 16;
    public static double[][] j = (double[][]) Array.newInstance((Class<?>) double.class, 16, 20);
    public static int k = 1;
    public static int l = 44100;
    public static int m = 12;
    public static int n = 2;
    public static int o = 0;
    public MediaPlayer a;
    public int b;
    public boolean c;
    public boolean d = true;
    public String e;
    public MediaRecorder f;
    public Equalizer g;
    public Visualizer h;

    /* compiled from: AudioUtil.java */
    public class a implements kn3.d {
        public final /* synthetic */ Activity a;

        public a(so3 so3Var, Activity activity) {
            this.a = activity;
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            this.a.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        }
    }

    /* compiled from: AudioUtil.java */
    public class b implements MediaPlayer.OnPreparedListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
            mediaPlayer.start();
            so3.this.d = true;
            so3.this.c = true;
        }
    }

    /* compiled from: AudioUtil.java */
    public class c implements MediaPlayer.OnErrorListener {
        public final /* synthetic */ ff3 a;

        public c(so3 so3Var, ff3 ff3Var) {
            this.a = ff3Var;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            String str = "what:" + i + ", extra:" + i2;
            ye3.d("Z0014", "what:" + i + ", extra:" + i2);
            this.a.b(false, null);
            return false;
        }
    }

    /* compiled from: AudioUtil.java */
    public class d implements MediaPlayer.OnCompletionListener {
        public final /* synthetic */ ff3 a;

        public d(ff3 ff3Var) {
            this.a = ff3Var;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            so3.this.c = false;
            mediaPlayer.release();
            so3.this.a = null;
            this.a.b(true, null);
        }
    }

    /* compiled from: AudioUtil.java */
    public class e implements MediaPlayer.OnCompletionListener {
        public final /* synthetic */ ff3 a;

        public e(ff3 ff3Var) {
            this.a = ff3Var;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            so3.this.c = false;
            mediaPlayer.release();
            so3.this.a = null;
            this.a.b(true, -1);
        }
    }

    /* compiled from: AudioUtil.java */
    public class f implements MediaPlayer.OnErrorListener {
        public f(so3 so3Var) {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            return false;
        }
    }

    /* compiled from: AudioUtil.java */
    public class g implements MediaPlayer.OnPreparedListener {
        public g(so3 so3Var) {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
        }
    }

    /* compiled from: AudioUtil.java */
    public class h implements j {
        public final /* synthetic */ ff3 a;

        /* compiled from: AudioUtil.java */
        public class a implements Visualizer.OnDataCaptureListener {
            public a() {
            }

            @Override // android.media.audiofx.Visualizer.OnDataCaptureListener
            public void onFftDataCapture(Visualizer visualizer, byte[] bArr, int i) {
                double[] dArrM = so3.m(bArr);
                int iMax = 0;
                double dMax = 0.0d;
                for (int i2 = 0; i2 < so3.i; i2++) {
                    so3.z(so3.j[i2], dArrM[i2]);
                    dMax = Math.max(dMax, (dArrM[i2] * 1.0d) / so3.k(so3.j[i2]));
                }
                if (dMax > 2.2d) {
                    iMax = 20;
                } else if (dMax > 1.1d) {
                    iMax = Math.max((int) ((Math.abs(dMax - 1.1d) * 21.0d) % 20.0d), 3);
                } else if (dMax > 0.8d) {
                    iMax = 2;
                } else if (dMax < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && dMax >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    iMax = 1;
                }
                h hVar = h.this;
                if (hVar.a != null && so3.this.c && so3.this.d) {
                    h.this.a.b(true, Integer.valueOf(iMax));
                }
            }

            @Override // android.media.audiofx.Visualizer.OnDataCaptureListener
            public void onWaveFormDataCapture(Visualizer visualizer, byte[] bArr, int i) {
            }
        }

        public h(ff3 ff3Var) {
            this.a = ff3Var;
        }

        @Override // dc.so3.j
        public void onPrepared() throws IllegalStateException {
            int audioSessionId = so3.this.a.getAudioSessionId();
            String str = "Exception2" + audioSessionId;
            try {
                so3.this.h = new Visualizer(audioSessionId);
                so3.this.x();
                so3.this.g = new Equalizer(0, audioSessionId);
                so3.this.g.setEnabled(true);
                so3.this.h.setCaptureSize(Visualizer.getCaptureSizeRange()[1]);
                so3.this.h.setDataCaptureListener(new a(), Visualizer.getMaxCaptureRate() / 2, false, true);
                so3.this.h.setScalingMode(0);
                so3.this.h.setEnabled(true);
                so3.this.C();
            } catch (Exception unused) {
                so3.this.C();
            }
        }
    }

    /* compiled from: AudioUtil.java */
    public class i implements Visualizer.OnDataCaptureListener {
        public final /* synthetic */ ff3 a;

        public i(so3 so3Var, ff3 ff3Var) {
            this.a = ff3Var;
        }

        @Override // android.media.audiofx.Visualizer.OnDataCaptureListener
        public void onFftDataCapture(Visualizer visualizer, byte[] bArr, int i) {
            double[] dArrM = so3.m(bArr);
            int iAbs = 0;
            double dMax = 0.0d;
            for (int i2 = 0; i2 < so3.i; i2++) {
                so3.z(so3.j[i2], dArrM[i2]);
                dMax = Math.max(dMax, (dArrM[i2] * 1.0d) / so3.k(so3.j[i2]));
            }
            if (dMax > 2.2d) {
                iAbs = 20;
            } else if (dMax > 1.1d) {
                iAbs = (int) ((Math.abs(dMax - 1.1d) * 21.0d) % 20.0d);
                if (iAbs < 3) {
                    iAbs = 3;
                }
            } else if (dMax > 0.8d) {
                iAbs = 2;
            } else if (dMax < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && dMax >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                iAbs = 1;
            }
            ff3 ff3Var = this.a;
            if (ff3Var != null) {
                ff3Var.b(true, Integer.valueOf(iAbs));
            }
        }

        @Override // android.media.audiofx.Visualizer.OnDataCaptureListener
        public void onWaveFormDataCapture(Visualizer visualizer, byte[] bArr, int i) {
        }
    }

    /* compiled from: AudioUtil.java */
    public interface j {
        void onPrepared();
    }

    public static boolean J() {
        Boolean bool = Boolean.TRUE;
        AudioRecord audioRecord = new AudioRecord(1, 44100, 16, 1, 44100);
        try {
            try {
                if (audioRecord.getRecordingState() != 1) {
                    bool = Boolean.FALSE;
                }
                audioRecord.startRecording();
                if (audioRecord.getRecordingState() != 3) {
                    audioRecord.stop();
                    bool = Boolean.FALSE;
                }
                audioRecord.stop();
            } catch (Exception unused) {
                bool = Boolean.FALSE;
            }
            audioRecord.release();
            return bool.booleanValue();
        } catch (Throwable th) {
            audioRecord.release();
            throw th;
        }
    }

    public static double j(byte[] bArr) {
        int iAbs = 0;
        for (byte b2 : bArr) {
            iAbs += Math.abs((int) b2);
        }
        return (iAbs * 1.0d) / bArr.length;
    }

    public static double k(double[] dArr) {
        double dAbs = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (double d2 : dArr) {
            dAbs += Math.abs(d2);
        }
        return (dAbs * 1.0d) / dArr.length;
    }

    public static double[] m(byte[] bArr) {
        int i2 = i;
        double[] dArr = new double[i2];
        int length = bArr.length / i2;
        int i3 = 0;
        while (i3 < i) {
            int i4 = i3 + 1;
            dArr[i3] = j(Arrays.copyOfRange(bArr, i3 * length, i4 * length));
            i3 = i4;
        }
        return dArr;
    }

    public static double[] z(double[] dArr, double d2) {
        for (int length = dArr.length - 1; length > 0; length--) {
            dArr[length] = dArr[length - 1];
        }
        dArr[0] = d2;
        return dArr;
    }

    public void A(String str, ff3 ff3Var) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        this.d = true;
        if (this.b >= 2) {
            this.b = 0;
        } else {
            p(str, ff3Var, new h(ff3Var));
        }
    }

    public void B(int i2, ff3 ff3Var) throws IllegalStateException {
        try {
            this.h = new Visualizer(i2);
            x();
            Equalizer equalizer = new Equalizer(0, i2);
            this.g = equalizer;
            equalizer.setEnabled(true);
            this.h.setCaptureSize(Visualizer.getCaptureSizeRange()[1]);
            this.h.setDataCaptureListener(new i(this, ff3Var), Visualizer.getMaxCaptureRate() / 2, false, true);
            this.h.setScalingMode(0);
            this.h.setEnabled(true);
        } catch (Exception unused) {
            if (ff3Var != null) {
                ff3Var.b(true, 0);
            }
            t();
        }
    }

    public final void C() throws IllegalStateException {
        if (this.a == null) {
            this.c = false;
            return;
        }
        this.d = true;
        this.c = true;
        this.a.start();
    }

    public synchronized void D(String str, ff3 ff3Var) {
        if (!WearUtils.e1(str)) {
            this.e = str;
            this.a = new MediaPlayer();
            try {
                this.a.setDataSource(new FileInputStream(str).getFD());
                this.a.prepareAsync();
                this.a.setOnPreparedListener(new b());
                this.a.setOnErrorListener(new c(this, ff3Var));
                this.a.setOnCompletionListener(new d(ff3Var));
            } catch (Exception e2) {
                ye3.d("Z0015", e2.getMessage());
                e2.printStackTrace();
                ff3Var.b(false, null);
            }
        }
    }

    public synchronized void E(String str, ff3 ff3Var, boolean z) {
        if (z) {
            A(str, ff3Var);
        } else {
            D(str, ff3Var);
        }
    }

    public synchronized void F() {
        this.c = false;
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.a.release();
            this.a = null;
        }
    }

    public void G() throws IllegalStateException {
        Visualizer visualizer = this.h;
        if (visualizer != null) {
            visualizer.setEnabled(false);
        }
        F();
    }

    public void H() throws IllegalStateException {
        MediaRecorder mediaRecorder = this.f;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.stop();
                this.f.release();
                this.f = null;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void I() {
        this.d = false;
    }

    public void l() throws IllegalStateException {
        Visualizer visualizer = this.h;
        if (visualizer != null) {
            visualizer.setEnabled(true);
        }
        v();
    }

    public int n() {
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer != null) {
            return mediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public MediaRecorder o() {
        return this.f;
    }

    public void p(String str, ff3 ff3Var, j jVar) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        this.e = str;
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.a = mediaPlayer;
        try {
            mediaPlayer.reset();
            this.a.setOnCompletionListener(new e(ff3Var));
            this.a.setOnErrorListener(new f(this));
            this.a.setOnPreparedListener(new g(this));
            if (Build.VERSION.SDK_INT >= 29) {
                this.a.setDataSource(MyApplication.N(), Uri.parse(str));
            } else {
                this.a.setDataSource(str);
            }
            this.a.prepare();
            jVar.onPrepared();
        } catch (Exception e2) {
            e2.printStackTrace();
            ff3Var.b(false, null);
        }
    }

    public final void q() throws IllegalStateException {
        MediaRecorder mediaRecorder = new MediaRecorder();
        this.f = mediaRecorder;
        mediaRecorder.setAudioSource(1);
        this.f.setOutputFormat(2);
        this.f.setAudioEncodingBitRate(96000);
        this.f.setAudioSamplingRate(44100);
        this.f.setAudioEncoder(3);
        this.f.setOutputFile(this.e);
    }

    public boolean r() throws IllegalStateException {
        try {
            o = 0;
            o = AudioRecord.getMinBufferSize(l, m, n);
            AudioRecord audioRecord = new AudioRecord(k, l, m, n, o);
            audioRecord.startRecording();
            if (audioRecord.getRecordingState() == 3) {
                audioRecord.stop();
                audioRecord.release();
                return true;
            }
            FragmentActivity fragmentActivity = MyApplication.K;
            if (fragmentActivity != null && !fragmentActivity.isDestroyed()) {
                new kn3((Context) fragmentActivity, ah4.e(R.string.setting_record_permission), ah4.e(R.string.common_chage), ah4.e(R.string.common_cancel), false, (kn3.d) new a(this, fragmentActivity)).show();
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean s() {
        return this.c;
    }

    public void t() throws IllegalStateException {
        this.c = false;
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    public void u() throws IllegalStateException {
        Visualizer visualizer = this.h;
        if (visualizer != null) {
            visualizer.setEnabled(false);
        }
        t();
    }

    public void v() throws IllegalStateException {
        this.d = true;
        this.c = true;
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    public boolean w(String str) throws IllegalStateException, IOException {
        if (!r() || str == null || str.equals("")) {
            return false;
        }
        this.e = str;
        try {
            q();
            this.f.prepare();
            this.f.start();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void x() {
        Equalizer equalizer = this.g;
        if (equalizer == null) {
            return;
        }
        equalizer.setControlStatusListener(null);
        this.g.setEnableStatusListener(null);
        this.g.setParameterListener(null);
        this.g.release();
        this.g = null;
    }

    public void y(int i2) throws IllegalStateException {
        try {
            if (this.a != null) {
                String str = "seek: " + i2;
                this.a.seekTo(i2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
