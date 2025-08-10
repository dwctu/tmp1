package dc;

import androidx.annotation.NonNull;
import dc.jh;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: InputStreamRewinder.java */
/* loaded from: classes.dex */
public final class ph implements jh<InputStream> {
    public final bm a;

    /* compiled from: InputStreamRewinder.java */
    public static final class a implements jh.a<InputStream> {
        public final zi a;

        public a(zi ziVar) {
            this.a = ziVar;
        }

        @Override // dc.jh.a
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public jh<InputStream> a(InputStream inputStream) {
            return new ph(inputStream, this.a);
        }

        @Override // dc.jh.a
        @NonNull
        public Class<InputStream> getDataClass() {
            return InputStream.class;
        }
    }

    public ph(InputStream inputStream, zi ziVar) {
        bm bmVar = new bm(inputStream, ziVar);
        this.a = bmVar;
        bmVar.mark(5242880);
    }

    @Override // dc.jh
    public void a() {
        this.a.release();
    }

    public void c() {
        this.a.e();
    }

    @Override // dc.jh
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public InputStream b() throws IOException {
        this.a.reset();
        return this.a;
    }
}
