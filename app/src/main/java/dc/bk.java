package dc;

import android.util.Log;
import androidx.annotation.NonNull;
import dc.ih;
import dc.lk;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferFileLoader.java */
/* loaded from: classes.dex */
public class bk implements lk<File, ByteBuffer> {

    /* compiled from: ByteBufferFileLoader.java */
    public static final class a implements ih<ByteBuffer> {
        public final File a;

        public a(File file) {
            this.a = file;
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
        public void d(@NonNull of ofVar, @NonNull ih.a<? super ByteBuffer> aVar) {
            try {
                aVar.e(np.a(this.a));
            } catch (IOException e) {
                Log.isLoggable("ByteBufferFileLoader", 3);
                aVar.b(e);
            }
        }

        @Override // dc.ih
        @NonNull
        public Class<ByteBuffer> getDataClass() {
            return ByteBuffer.class;
        }
    }

    /* compiled from: ByteBufferFileLoader.java */
    public static class b implements mk<File, ByteBuffer> {
        @Override // dc.mk
        @NonNull
        public lk<File, ByteBuffer> b(@NonNull pk pkVar) {
            return new bk();
        }
    }

    @Override // dc.lk
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public lk.a<ByteBuffer> b(@NonNull File file, int i, int i2, @NonNull ah ahVar) {
        return new lk.a<>(new mp(file), new a(file));
    }

    @Override // dc.lk
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull File file) {
        return true;
    }
}
