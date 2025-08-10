package dc;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmSession;

/* compiled from: DrmSession.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class wr0 {
    public static boolean $default$playClearSamplesWithoutKeys(DrmSession drmSession) {
        return false;
    }

    public static void a(@Nullable DrmSession drmSession, @Nullable DrmSession drmSession2) {
        if (drmSession == drmSession2) {
            return;
        }
        if (drmSession2 != null) {
            drmSession2.acquire(null);
        }
        if (drmSession != null) {
            drmSession.release(null);
        }
    }
}
