package dc;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dc.wf;

/* compiled from: GifBitmapProvider.java */
/* loaded from: classes.dex */
public final class tm implements wf.a {
    public final cj a;

    @Nullable
    public final zi b;

    public tm(cj cjVar, @Nullable zi ziVar) {
        this.a = cjVar;
        this.b = ziVar;
    }

    @Override // dc.wf.a
    public void a(@NonNull Bitmap bitmap) {
        this.a.c(bitmap);
    }

    @Override // dc.wf.a
    @NonNull
    public byte[] b(int i) {
        zi ziVar = this.b;
        return ziVar == null ? new byte[i] : (byte[]) ziVar.c(i, byte[].class);
    }

    @Override // dc.wf.a
    @NonNull
    public Bitmap c(int i, int i2, @NonNull Bitmap.Config config) {
        return this.a.e(i, i2, config);
    }

    @Override // dc.wf.a
    @NonNull
    public int[] d(int i) {
        zi ziVar = this.b;
        return ziVar == null ? new int[i] : (int[]) ziVar.c(i, int[].class);
    }

    @Override // dc.wf.a
    public void e(@NonNull byte[] bArr) {
        zi ziVar = this.b;
        if (ziVar == null) {
            return;
        }
        ziVar.put(bArr);
    }

    @Override // dc.wf.a
    public void f(@NonNull int[] iArr) {
        zi ziVar = this.b;
        if (ziVar == null) {
            return;
        }
        ziVar.put(iArr);
    }
}
