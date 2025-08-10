package dc;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamBitmapWebpDecoder.java */
/* loaded from: classes.dex */
public class jg implements ch<InputStream, Bitmap> {
    public final ng a;
    public final zi b;

    public jg(ng ngVar, zi ziVar) {
        this.a = ngVar;
        this.b = ziVar;
    }

    @Override // dc.ch
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ti<Bitmap> b(@NonNull InputStream inputStream, int i, int i2, @NonNull ah ahVar) throws IOException {
        return this.a.d(inputStream, i, i2, ahVar);
    }

    @Override // dc.ch
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull InputStream inputStream, @NonNull ah ahVar) throws IOException {
        return this.a.l(inputStream, ahVar);
    }
}
