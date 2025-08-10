package dc;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ImageReader.java */
/* loaded from: classes.dex */
public interface xl {

    /* compiled from: ImageReader.java */
    public static final class a implements xl {
        public final ph a;
        public final zi b;
        public final List<ImageHeaderParser> c;

        public a(InputStream inputStream, List<ImageHeaderParser> list, zi ziVar) {
            vp.d(ziVar);
            this.b = ziVar;
            vp.d(list);
            this.c = list;
            this.a = new ph(inputStream, ziVar);
        }

        @Override // dc.xl
        @Nullable
        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeStream(this.a.b(), null, options);
        }

        @Override // dc.xl
        public void b() {
            this.a.c();
        }

        @Override // dc.xl
        public int c() throws IOException {
            return wg.b(this.c, this.a.b(), this.b);
        }

        @Override // dc.xl
        public ImageHeaderParser.ImageType d() throws IOException {
            return wg.e(this.c, this.a.b(), this.b);
        }
    }

    /* compiled from: ImageReader.java */
    @RequiresApi(21)
    public static final class b implements xl {
        public final zi a;
        public final List<ImageHeaderParser> b;
        public final rh c;

        public b(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, zi ziVar) {
            vp.d(ziVar);
            this.a = ziVar;
            vp.d(list);
            this.b = list;
            this.c = new rh(parcelFileDescriptor);
        }

        @Override // dc.xl
        @Nullable
        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.c.b().getFileDescriptor(), null, options);
        }

        @Override // dc.xl
        public void b() {
        }

        @Override // dc.xl
        public int c() throws IOException {
            return wg.a(this.b, this.c, this.a);
        }

        @Override // dc.xl
        public ImageHeaderParser.ImageType d() throws IOException {
            return wg.d(this.b, this.c, this.a);
        }
    }

    @Nullable
    Bitmap a(BitmapFactory.Options options) throws IOException;

    void b();

    int c() throws IOException;

    ImageHeaderParser.ImageType d() throws IOException;
}
