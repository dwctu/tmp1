package dc;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import java.io.IOException;
import java.util.Map;

/* compiled from: AndroidMediaPlayer.java */
/* loaded from: classes5.dex */
public class tj4 extends sj4 implements MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnInfoListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener {
    public MediaPlayer b;
    public int c;
    public Context d;
    public boolean e;

    /* compiled from: AndroidMediaPlayer.java */
    public class a extends Thread {
        public final /* synthetic */ MediaPlayer a;

        public a(tj4 tj4Var, MediaPlayer mediaPlayer) {
            this.a = mediaPlayer;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.a.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public tj4(Context context) {
        this.d = context.getApplicationContext();
    }

    @Override // dc.sj4
    public int a() {
        return this.c;
    }

    @Override // dc.sj4
    public long b() {
        return this.b.getCurrentPosition();
    }

    @Override // dc.sj4
    public long c() {
        return this.b.getDuration();
    }

    @Override // dc.sj4
    public float d() {
        if (Build.VERSION.SDK_INT < 23) {
            return 1.0f;
        }
        try {
            float speed = this.b.getPlaybackParams().getSpeed();
            if (speed == 0.0f) {
                return 1.0f;
            }
            return speed;
        } catch (Exception unused) {
            return 1.0f;
        }
    }

    @Override // dc.sj4
    public long e() {
        return 0L;
    }

    @Override // dc.sj4
    public void f() {
        this.b = new MediaPlayer();
        v();
        this.b.setAudioStreamType(3);
        this.b.setOnErrorListener(this);
        this.b.setOnCompletionListener(this);
        this.b.setOnInfoListener(this);
        this.b.setOnBufferingUpdateListener(this);
        this.b.setOnPreparedListener(this);
        this.b.setOnVideoSizeChangedListener(this);
    }

    @Override // dc.sj4
    public boolean g() {
        return this.b.isPlaying();
    }

    @Override // dc.sj4
    public void h() throws IllegalStateException {
        try {
            this.b.pause();
        } catch (IllegalStateException unused) {
            this.a.a();
        }
    }

    @Override // dc.sj4
    public void i() throws IllegalStateException {
        try {
            this.e = true;
            this.b.prepareAsync();
        } catch (IllegalStateException unused) {
            this.a.a();
        }
    }

    @Override // dc.sj4
    public void j() throws IllegalStateException {
        this.b.setOnErrorListener(null);
        this.b.setOnCompletionListener(null);
        this.b.setOnInfoListener(null);
        this.b.setOnBufferingUpdateListener(null);
        this.b.setOnPreparedListener(null);
        this.b.setOnVideoSizeChangedListener(null);
        w();
        MediaPlayer mediaPlayer = this.b;
        this.b = null;
        new a(this, mediaPlayer).start();
    }

    @Override // dc.sj4
    public void k() throws IllegalStateException {
        w();
        this.b.reset();
        this.b.setSurface(null);
        this.b.setDisplay(null);
        this.b.setVolume(1.0f, 1.0f);
    }

    @Override // dc.sj4
    public void l(long j) throws IllegalStateException {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                this.b.seekTo(j, 3);
            } else {
                this.b.seekTo((int) j);
            }
        } catch (IllegalStateException unused) {
            this.a.a();
        }
    }

    @Override // dc.sj4
    public void m(AssetFileDescriptor assetFileDescriptor) throws IllegalStateException, IOException, IllegalArgumentException {
        try {
            this.b.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        } catch (Exception unused) {
            this.a.a();
        }
    }

    @Override // dc.sj4
    public void n(String str, Map<String, String> map) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        try {
            this.b.setDataSource(this.d, Uri.parse(str), map);
        } catch (Exception unused) {
            this.a.a();
        }
    }

    @Override // dc.sj4
    public void o(boolean z) {
        this.b.setLooping(z);
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.c = i;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.a.g();
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.a.a();
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        if (i != 3) {
            this.a.b(i, i2);
            return true;
        }
        if (!this.e) {
            return true;
        }
        this.a.b(i, i2);
        this.e = false;
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
        this.a.onPrepared();
        t();
        if (u()) {
            return;
        }
        this.a.b(3, 0);
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        int videoWidth = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        if (videoWidth == 0 || videoHeight == 0) {
            return;
        }
        this.a.e(videoWidth, videoHeight);
    }

    @Override // dc.sj4
    public void q(float f) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                MediaPlayer mediaPlayer = this.b;
                mediaPlayer.setPlaybackParams(mediaPlayer.getPlaybackParams().setSpeed(f));
            } catch (Exception unused) {
                this.a.a();
            }
        }
    }

    @Override // dc.sj4
    public void r(Surface surface) {
        try {
            this.b.setSurface(surface);
        } catch (Exception unused) {
            this.a.a();
        }
    }

    @Override // dc.sj4
    public void s(float f, float f2) {
        this.b.setVolume(f, f2);
    }

    @Override // dc.sj4
    public void t() throws IllegalStateException {
        try {
            this.b.start();
        } catch (IllegalStateException unused) {
            this.a.a();
        }
    }

    public final boolean u() throws IllegalStateException {
        try {
            for (MediaPlayer.TrackInfo trackInfo : this.b.getTrackInfo()) {
                if (trackInfo.getTrackType() == 1) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public void v() {
    }

    public void w() throws IllegalStateException {
        try {
            this.b.stop();
        } catch (IllegalStateException unused) {
            this.a.a();
        }
    }
}
