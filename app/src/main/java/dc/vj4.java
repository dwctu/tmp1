package dc;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import xyz.doikki.videoplayer.player.BaseVideoView;

/* compiled from: AudioFocusHelper.java */
/* loaded from: classes5.dex */
public final class vj4 implements AudioManager.OnAudioFocusChangeListener {
    public final WeakReference<BaseVideoView> b;
    public final AudioManager c;
    public final Handler a = new Handler(Looper.getMainLooper());
    public boolean d = false;
    public boolean e = false;
    public int f = 0;

    /* compiled from: AudioFocusHelper.java */
    public class a implements Runnable {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            vj4.this.c(this.a);
        }
    }

    public vj4(@NonNull BaseVideoView baseVideoView) {
        this.b = new WeakReference<>(baseVideoView);
        this.c = (AudioManager) baseVideoView.getContext().getApplicationContext().getSystemService("audio");
    }

    public void a() {
        AudioManager audioManager = this.c;
        if (audioManager == null) {
            return;
        }
        this.d = false;
        audioManager.abandonAudioFocus(this);
    }

    public final void c(int i) {
        BaseVideoView baseVideoView = this.b.get();
        if (baseVideoView == null) {
            return;
        }
        if (i == -3) {
            if (!baseVideoView.isPlaying() || baseVideoView.r()) {
                return;
            }
            baseVideoView.setVolume(0.1f, 0.1f);
            return;
        }
        if (i == -2 || i == -1) {
            if (baseVideoView.isPlaying()) {
                this.e = true;
                baseVideoView.pause();
                return;
            }
            return;
        }
        if (i == 1 || i == 2) {
            if (this.d || this.e) {
                baseVideoView.start();
                this.d = false;
                this.e = false;
            }
            if (baseVideoView.r()) {
                return;
            }
            baseVideoView.setVolume(1.0f, 1.0f);
        }
    }

    public void d() {
        AudioManager audioManager;
        if (this.f == 1 || (audioManager = this.c) == null) {
            return;
        }
        if (1 == audioManager.requestAudioFocus(this, 3, 1)) {
            this.f = 1;
        } else {
            this.d = true;
        }
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        if (this.f == i) {
            return;
        }
        this.a.post(new a(i));
        this.f = i;
    }
}
