package dc;

import com.google.android.exoplayer2.ExoPlayer;
import dc.ct;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: BILogManualConsume.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\t\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/component/dxbilog/lib/manual/method/BILogManualConsume;", "Lcom/component/dxbilog/lib/manual/base/BaseCoroutineScopeLoop;", "()V", "BILOG_LAST_UPLOAD_TIME", "", "lastUploadTime", "", "getLastUploadTime", "()J", "setLastUploadTime", "(J)V", "status", "Lcom/component/dxbilog/lib/manual/data/BILogManualEum$UploadStatus;", "getLoopDelayTime", "loopBody", "", "loopEndBefore", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class rs extends ns {

    @NotNull
    public static final rs c = new rs();

    @NotNull
    public static volatile os d = os.IDLE;
    public static long e;

    public rs() {
        super(xz3.a(n04.a()));
    }

    public static final void g() {
        try {
            try {
                ts tsVar = new ts();
                vs vsVar = new vs();
                us usVar = new us();
                at atVar = new at();
                xs xsVar = new xs();
                tsVar.e(vsVar);
                vsVar.e(usVar);
                usVar.e(atVar);
                atVar.e(xsVar);
                ct.a.a(tsVar, null, 1, null);
            } catch (Exception e2) {
                e2.printStackTrace();
                c.h();
            }
        } finally {
            d = os.IDLE;
        }
    }

    @Override // dc.ns
    public long a() {
        return ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
    }

    @Override // dc.ns
    public void b() {
        if (d == os.IDLE) {
            d = os.RUNNING;
            se0.b().execute(new Runnable() { // from class: dc.ps
                @Override // java.lang.Runnable
                public final void run() {
                    rs.g();
                }
            });
        }
    }

    public final long e() {
        return e;
    }

    public final void h() {
        i();
    }

    public final void i() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        e = jCurrentTimeMillis;
        kd0.b("bilog_last_upload_time", Long.valueOf(jCurrentTimeMillis));
    }
}
