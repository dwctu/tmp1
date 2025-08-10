package dc;

import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.os.Handler;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AudioPlayer.kt */
/* loaded from: classes3.dex */
public final class qg1 {

    @Nullable
    public MediaExtractor a;

    @Nullable
    public MediaCodec b;

    @Nullable
    public AudioTrack c;

    @NotNull
    public final ug1 d;
    public boolean e;
    public int f;
    public boolean g;
    public boolean h;

    @NotNull
    public final pg1 i;

    /* compiled from: AudioPlayer.kt */
    public static final class a implements Runnable {
        public final /* synthetic */ ch1 b;

        public a(ch1 ch1Var) {
            this.b = ch1Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                qg1.this.j(this.b);
            } catch (Throwable th) {
                xh1.c.c("AnimPlayer.AudioPlayer", "Audio exception=" + th, th);
                qg1.this.g();
            }
        }
    }

    public qg1(@NotNull pg1 player) {
        Intrinsics.checkParameterIsNotNull(player, "player");
        this.i = player;
        this.d = new ug1(null, null);
    }

    public final void c() {
        if (!this.e) {
            d();
        } else {
            this.h = true;
            k();
        }
    }

    public final void d() {
        if (this.i.n()) {
            xh1.c.d("AnimPlayer.AudioPlayer", "destroyThread");
            Handler handlerA = this.d.a();
            if (handlerA != null) {
                handlerA.removeCallbacksAndMessages(null);
            }
            ug1 ug1Var = this.d;
            ug1Var.d(sg1.l.b(ug1Var.b()));
        }
    }

    public final int e(int i) {
        switch (i) {
            case 1:
                return 2;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            default:
                throw new RuntimeException("Unsupported channel count: " + i);
        }
    }

    public final boolean f() {
        return sg1.l.a(this.d, "anim_audio_thread");
    }

    public final void g() {
        try {
            MediaCodec mediaCodec = this.b;
            if (mediaCodec != null) {
                mediaCodec.stop();
                mediaCodec.release();
            }
            this.b = null;
            MediaExtractor mediaExtractor = this.a;
            if (mediaExtractor != null) {
                mediaExtractor.release();
            }
            this.a = null;
            AudioTrack audioTrack = this.c;
            if (audioTrack != null) {
                audioTrack.pause();
                audioTrack.flush();
                audioTrack.stop();
                audioTrack.release();
            }
            this.c = null;
        } catch (Throwable th) {
            xh1.c.c("AnimPlayer.AudioPlayer", "release exception=" + th, th);
        }
        this.e = false;
        if (this.h) {
            d();
        }
    }

    public final void h(int i) {
        this.f = i;
    }

    public final void i(@NotNull ch1 fileContainer) {
        Intrinsics.checkParameterIsNotNull(fileContainer, "fileContainer");
        this.g = false;
        this.h = false;
        if (f()) {
            if (this.e) {
                k();
            }
            this.e = true;
            Handler handlerA = this.d.a();
            if (handlerA != null) {
                handlerA.post(new a(fileContainer));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j(dc.ch1 r24) throws java.lang.IllegalStateException, android.media.MediaCodec.CryptoException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.qg1.j(dc.ch1):void");
    }

    public final void k() {
        this.g = true;
    }
}
