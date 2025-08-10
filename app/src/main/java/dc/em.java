package dc;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import dc.rl;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamBitmapDecoder.java */
/* loaded from: classes.dex */
public class em implements ch<InputStream, Bitmap> {
    public final rl a;
    public final zi b;

    /* compiled from: StreamBitmapDecoder.java */
    public static class a implements rl.b {
        public final bm a;
        public final pp b;

        public a(bm bmVar, pp ppVar) {
            this.a = bmVar;
            this.b = ppVar;
        }

        @Override // dc.rl.b
        public void a(cj cjVar, Bitmap bitmap) throws IOException {
            IOException iOExceptionB = this.b.b();
            if (iOExceptionB != null) {
                if (bitmap == null) {
                    throw iOExceptionB;
                }
                cjVar.c(bitmap);
                throw iOExceptionB;
            }
        }

        @Override // dc.rl.b
        public void b() {
            this.a.e();
        }
    }

    public em(rl rlVar, zi ziVar) {
        this.a = rlVar;
        this.b = ziVar;
    }

    @Override // dc.ch
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ti<Bitmap> b(@NonNull InputStream inputStream, int i, int i2, @NonNull ah ahVar) throws IOException {
        bm bmVar;
        boolean z;
        if (inputStream instanceof bm) {
            bmVar = (bm) inputStream;
            z = false;
        } else {
            bmVar = new bm(inputStream, this.b);
            z = true;
        }
        pp ppVarE = pp.e(bmVar);
        try {
            return this.a.g(new tp(ppVarE), i, i2, ahVar, new a(bmVar, ppVarE));
        } finally {
            ppVarE.release();
            if (z) {
                bmVar.release();
            }
        }
    }

    @Override // dc.ch
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull InputStream inputStream, @NonNull ah ahVar) {
        return this.a.p(inputStream);
    }
}
