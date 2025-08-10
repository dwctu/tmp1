package dc;

import android.support.v4.media.session.PlaybackStateCompat;

/* compiled from: SegmentPool.java */
/* loaded from: classes5.dex */
public final class ce4 {
    public static be4 a;
    public static long b;

    public static void a(be4 be4Var) {
        if (be4Var.f != null || be4Var.g != null) {
            throw new IllegalArgumentException();
        }
        if (be4Var.d) {
            return;
        }
        synchronized (ce4.class) {
            long j = b;
            if (j + PlaybackStateCompat.ACTION_PLAY_FROM_URI > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                return;
            }
            b = j + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            be4Var.f = a;
            be4Var.c = 0;
            be4Var.b = 0;
            a = be4Var;
        }
    }

    public static be4 b() {
        synchronized (ce4.class) {
            be4 be4Var = a;
            if (be4Var == null) {
                return new be4();
            }
            a = be4Var.f;
            be4Var.f = null;
            b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return be4Var;
        }
    }
}
