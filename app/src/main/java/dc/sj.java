package dc;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dc.tj;

/* compiled from: LruResourceCache.java */
/* loaded from: classes.dex */
public class sj extends sp<xg, ti<?>> implements tj {
    public tj.a d;

    public sj(long j) {
        super(j);
    }

    @Override // dc.tj
    @SuppressLint({"InlinedApi"})
    public void a(int i) {
        if (i >= 40) {
            b();
        } else if (i >= 20 || i == 15) {
            m(h() / 2);
        }
    }

    @Override // dc.tj
    @Nullable
    public /* bridge */ /* synthetic */ ti c(@NonNull xg xgVar, @Nullable ti tiVar) {
        return (ti) super.k(xgVar, tiVar);
    }

    @Override // dc.tj
    @Nullable
    public /* bridge */ /* synthetic */ ti d(@NonNull xg xgVar) {
        return (ti) super.l(xgVar);
    }

    @Override // dc.tj
    public void e(@NonNull tj.a aVar) {
        this.d = aVar;
    }

    @Override // dc.sp
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public int i(@Nullable ti<?> tiVar) {
        return tiVar == null ? super.i(null) : tiVar.b();
    }

    @Override // dc.sp
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void j(@NonNull xg xgVar, @Nullable ti<?> tiVar) {
        tj.a aVar = this.d;
        if (aVar == null || tiVar == null) {
            return;
        }
        aVar.a(tiVar);
    }
}
