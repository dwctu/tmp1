package dc;

import androidx.annotation.NonNull;
import dc.ih;
import dc.lk;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: ByteArrayLoader.java */
/* loaded from: classes.dex */
public class zj<Data> implements lk<byte[], Data> {
    public final b<Data> a;

    /* compiled from: ByteArrayLoader.java */
    public static class a implements mk<byte[], ByteBuffer> {

        /* compiled from: ByteArrayLoader.java */
        /* renamed from: dc.zj$a$a, reason: collision with other inner class name */
        public class C0236a implements b<ByteBuffer> {
            public C0236a(a aVar) {
            }

            @Override // dc.zj.b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ByteBuffer a(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }

            @Override // dc.zj.b
            public Class<ByteBuffer> getDataClass() {
                return ByteBuffer.class;
            }
        }

        @Override // dc.mk
        @NonNull
        public lk<byte[], ByteBuffer> b(@NonNull pk pkVar) {
            return new zj(new C0236a(this));
        }
    }

    /* compiled from: ByteArrayLoader.java */
    public interface b<Data> {
        Data a(byte[] bArr);

        Class<Data> getDataClass();
    }

    /* compiled from: ByteArrayLoader.java */
    public static class c<Data> implements ih<Data> {
        public final byte[] a;
        public final b<Data> b;

        public c(byte[] bArr, b<Data> bVar) {
            this.a = bArr;
            this.b = bVar;
        }

        @Override // dc.ih
        public void a() {
        }

        @Override // dc.ih
        @NonNull
        public sg c() {
            return sg.LOCAL;
        }

        @Override // dc.ih
        public void cancel() {
        }

        @Override // dc.ih
        public void d(@NonNull of ofVar, @NonNull ih.a<? super Data> aVar) {
            aVar.e(this.b.a(this.a));
        }

        @Override // dc.ih
        @NonNull
        public Class<Data> getDataClass() {
            return this.b.getDataClass();
        }
    }

    /* compiled from: ByteArrayLoader.java */
    public static class d implements mk<byte[], InputStream> {

        /* compiled from: ByteArrayLoader.java */
        public class a implements b<InputStream> {
            public a(d dVar) {
            }

            @Override // dc.zj.b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public InputStream a(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }

            @Override // dc.zj.b
            public Class<InputStream> getDataClass() {
                return InputStream.class;
            }
        }

        @Override // dc.mk
        @NonNull
        public lk<byte[], InputStream> b(@NonNull pk pkVar) {
            return new zj(new a(this));
        }
    }

    public zj(b<Data> bVar) {
        this.a = bVar;
    }

    @Override // dc.lk
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public lk.a<Data> b(@NonNull byte[] bArr, int i, int i2, @NonNull ah ahVar) {
        return new lk.a<>(new mp(bArr), new c(bArr, this.a));
    }

    @Override // dc.lk
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull byte[] bArr) {
        return true;
    }
}
