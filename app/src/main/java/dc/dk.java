package dc;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import dc.ih;
import dc.lk;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileLoader.java */
/* loaded from: classes.dex */
public class dk<Data> implements lk<File, Data> {
    public final d<Data> a;

    /* compiled from: FileLoader.java */
    public static class a<Data> implements mk<File, Data> {
        public final d<Data> a;

        public a(d<Data> dVar) {
            this.a = dVar;
        }

        @Override // dc.mk
        @NonNull
        public final lk<File, Data> b(@NonNull pk pkVar) {
            return new dk(this.a);
        }
    }

    /* compiled from: FileLoader.java */
    public static class b extends a<ParcelFileDescriptor> {

        /* compiled from: FileLoader.java */
        public class a implements d<ParcelFileDescriptor> {
            @Override // dc.dk.d
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            @Override // dc.dk.d
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public ParcelFileDescriptor b(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, 268435456);
            }

            @Override // dc.dk.d
            public Class<ParcelFileDescriptor> getDataClass() {
                return ParcelFileDescriptor.class;
            }
        }

        public b() {
            super(new a());
        }
    }

    /* compiled from: FileLoader.java */
    public static final class c<Data> implements ih<Data> {
        public final File a;
        public final d<Data> b;
        public Data c;

        public c(File file, d<Data> dVar) {
            this.a = file;
            this.b = dVar;
        }

        @Override // dc.ih
        public void a() {
            Data data = this.c;
            if (data != null) {
                try {
                    this.b.a(data);
                } catch (IOException unused) {
                }
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

        /* JADX WARN: Type inference failed for: r3v3, types: [Data, java.lang.Object] */
        @Override // dc.ih
        public void d(@NonNull of ofVar, @NonNull ih.a<? super Data> aVar) {
            try {
                Data dataB = this.b.b(this.a);
                this.c = dataB;
                aVar.e(dataB);
            } catch (FileNotFoundException e) {
                Log.isLoggable("FileLoader", 3);
                aVar.b(e);
            }
        }

        @Override // dc.ih
        @NonNull
        public Class<Data> getDataClass() {
            return this.b.getDataClass();
        }
    }

    /* compiled from: FileLoader.java */
    public interface d<Data> {
        void a(Data data) throws IOException;

        Data b(File file) throws FileNotFoundException;

        Class<Data> getDataClass();
    }

    /* compiled from: FileLoader.java */
    public static class e extends a<InputStream> {

        /* compiled from: FileLoader.java */
        public class a implements d<InputStream> {
            @Override // dc.dk.d
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // dc.dk.d
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public InputStream b(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }

            @Override // dc.dk.d
            public Class<InputStream> getDataClass() {
                return InputStream.class;
            }
        }

        public e() {
            super(new a());
        }
    }

    public dk(d<Data> dVar) {
        this.a = dVar;
    }

    @Override // dc.lk
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public lk.a<Data> b(@NonNull File file, int i, int i2, @NonNull ah ahVar) {
        return new lk.a<>(new mp(file), new c(file, this.a));
    }

    @Override // dc.lk
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull File file) {
        return true;
    }
}
