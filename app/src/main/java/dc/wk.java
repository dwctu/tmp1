package dc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.DefaultLoadControl;
import dc.lk;
import java.io.InputStream;

/* compiled from: HttpGlideUrlLoader.java */
/* loaded from: classes.dex */
public class wk implements lk<ek, InputStream> {
    public static final zg<Integer> b = zg.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS));

    @Nullable
    public final kk<ek, ek> a;

    /* compiled from: HttpGlideUrlLoader.java */
    public static class a implements mk<ek, InputStream> {
        public final kk<ek, ek> a = new kk<>(500);

        @Override // dc.mk
        @NonNull
        public lk<ek, InputStream> b(pk pkVar) {
            return new wk(this.a);
        }
    }

    public wk(@Nullable kk<ek, ek> kkVar) {
        this.a = kkVar;
    }

    @Override // dc.lk
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public lk.a<InputStream> b(@NonNull ek ekVar, int i, int i2, @NonNull ah ahVar) {
        kk<ek, ek> kkVar = this.a;
        if (kkVar != null) {
            ek ekVarA = kkVar.a(ekVar, 0, 0);
            if (ekVarA == null) {
                this.a.b(ekVar, 0, 0, ekVar);
            } else {
                ekVar = ekVarA;
            }
        }
        return new lk.a<>(ekVar, new oh(ekVar, ((Integer) ahVar.c(b)).intValue()));
    }

    @Override // dc.lk
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull ek ekVar) {
        return true;
    }
}
