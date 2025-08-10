package dc;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: GifFrameResourceDecoder.java */
/* loaded from: classes.dex */
public final class ym implements ch<wf, Bitmap> {
    public final cj a;

    public ym(cj cjVar) {
        this.a = cjVar;
    }

    @Override // dc.ch
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ti<Bitmap> b(@NonNull wf wfVar, int i, int i2, @NonNull ah ahVar) {
        return jl.d(wfVar.getNextFrame(), this.a);
    }

    @Override // dc.ch
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull wf wfVar, @NonNull ah ahVar) {
        return true;
    }
}
