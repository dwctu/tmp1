package dc;

import android.util.Base64;
import androidx.annotation.NonNull;
import dc.ih;
import dc.lk;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: DataUrlLoader.java */
/* loaded from: classes.dex */
public final class ck<Model, Data> implements lk<Model, Data> {
    public final a<Data> a;

    /* compiled from: DataUrlLoader.java */
    public interface a<Data> {
        void a(Data data) throws IOException;

        Data decode(String str) throws IllegalArgumentException;

        Class<Data> getDataClass();
    }

    /* compiled from: DataUrlLoader.java */
    public static final class b<Data> implements ih<Data> {
        public final String a;
        public final a<Data> b;
        public Data c;

        public b(String str, a<Data> aVar) {
            this.a = str;
            this.b = aVar;
        }

        @Override // dc.ih
        public void a() {
            try {
                this.b.a(this.c);
            } catch (IOException unused) {
            }
        }

        @Override // dc.ih
        @NonNull
        public sg c() {
            return sg.LOCAL;
        }

        @Override // dc.ih
        public void cancel() {
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [Data, java.lang.Object] */
        @Override // dc.ih
        public void d(@NonNull of ofVar, @NonNull ih.a<? super Data> aVar) {
            try {
                Data dataDecode = this.b.decode(this.a);
                this.c = dataDecode;
                aVar.e(dataDecode);
            } catch (IllegalArgumentException e) {
                aVar.b(e);
            }
        }

        @Override // dc.ih
        @NonNull
        public Class<Data> getDataClass() {
            return this.b.getDataClass();
        }
    }

    /* compiled from: DataUrlLoader.java */
    public static final class c<Model> implements mk<Model, InputStream> {
        public final a<InputStream> a = new a(this);

        /* compiled from: DataUrlLoader.java */
        public class a implements a<InputStream> {
            public a(c cVar) {
            }

            @Override // dc.ck.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // dc.ck.a
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public InputStream decode(String str) {
                if (!str.startsWith("data:image")) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int iIndexOf = str.indexOf(44);
                if (iIndexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (str.substring(0, iIndexOf).endsWith(";base64")) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }

            @Override // dc.ck.a
            public Class<InputStream> getDataClass() {
                return InputStream.class;
            }
        }

        @Override // dc.mk
        @NonNull
        public lk<Model, InputStream> b(@NonNull pk pkVar) {
            return new ck(this.a);
        }
    }

    public ck(a<Data> aVar) {
        this.a = aVar;
    }

    @Override // dc.lk
    public boolean a(@NonNull Model model) {
        return model.toString().startsWith("data:image");
    }

    @Override // dc.lk
    public lk.a<Data> b(@NonNull Model model, int i, int i2, @NonNull ah ahVar) {
        return new lk.a<>(new mp(model), new b(model.toString(), this.a));
    }
}
