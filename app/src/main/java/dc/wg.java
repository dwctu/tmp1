package dc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: ImageHeaderParserUtils.java */
/* loaded from: classes.dex */
public final class wg {

    /* compiled from: ImageHeaderParserUtils.java */
    public class a implements g {
        public final /* synthetic */ InputStream a;

        public a(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // dc.wg.g
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.b(this.a);
            } finally {
                this.a.reset();
            }
        }
    }

    /* compiled from: ImageHeaderParserUtils.java */
    public class b implements g {
        public final /* synthetic */ ByteBuffer a;

        public b(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
        }

        @Override // dc.wg.g
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
            return imageHeaderParser.a(this.a);
        }
    }

    /* compiled from: ImageHeaderParserUtils.java */
    public class c implements g {
        public final /* synthetic */ rh a;
        public final /* synthetic */ zi b;

        public c(rh rhVar, zi ziVar) {
            this.a = rhVar;
            this.b = ziVar;
        }

        @Override // dc.wg.g
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws Throwable {
            bm bmVar;
            bm bmVar2 = null;
            try {
                bmVar = new bm(new FileInputStream(this.a.b().getFileDescriptor()), this.b);
            } catch (Throwable th) {
                th = th;
            }
            try {
                ImageHeaderParser.ImageType imageTypeB = imageHeaderParser.b(bmVar);
                try {
                    bmVar.close();
                } catch (IOException unused) {
                }
                this.a.b();
                return imageTypeB;
            } catch (Throwable th2) {
                th = th2;
                bmVar2 = bmVar;
                if (bmVar2 != null) {
                    try {
                        bmVar2.close();
                    } catch (IOException unused2) {
                    }
                }
                this.a.b();
                throw th;
            }
        }
    }

    /* compiled from: ImageHeaderParserUtils.java */
    public class d implements f {
        public final /* synthetic */ InputStream a;
        public final /* synthetic */ zi b;

        public d(InputStream inputStream, zi ziVar) {
            this.a = inputStream;
            this.b = ziVar;
        }

        @Override // dc.wg.f
        public int a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.c(this.a, this.b);
            } finally {
                this.a.reset();
            }
        }
    }

    /* compiled from: ImageHeaderParserUtils.java */
    public class e implements f {
        public final /* synthetic */ rh a;
        public final /* synthetic */ zi b;

        public e(rh rhVar, zi ziVar) {
            this.a = rhVar;
            this.b = ziVar;
        }

        @Override // dc.wg.f
        public int a(ImageHeaderParser imageHeaderParser) throws Throwable {
            bm bmVar;
            bm bmVar2 = null;
            try {
                bmVar = new bm(new FileInputStream(this.a.b().getFileDescriptor()), this.b);
            } catch (Throwable th) {
                th = th;
            }
            try {
                int iC = imageHeaderParser.c(bmVar, this.b);
                try {
                    bmVar.close();
                } catch (IOException unused) {
                }
                this.a.b();
                return iC;
            } catch (Throwable th2) {
                th = th2;
                bmVar2 = bmVar;
                if (bmVar2 != null) {
                    try {
                        bmVar2.close();
                    } catch (IOException unused2) {
                    }
                }
                this.a.b();
                throw th;
            }
        }
    }

    /* compiled from: ImageHeaderParserUtils.java */
    public interface f {
        int a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    /* compiled from: ImageHeaderParserUtils.java */
    public interface g {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    @RequiresApi(21)
    public static int a(@NonNull List<ImageHeaderParser> list, @NonNull rh rhVar, @NonNull zi ziVar) throws IOException {
        return c(list, new e(rhVar, ziVar));
    }

    public static int b(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull zi ziVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new bm(inputStream, ziVar);
        }
        inputStream.mark(5242880);
        return c(list, new d(inputStream, ziVar));
    }

    public static int c(@NonNull List<ImageHeaderParser> list, f fVar) throws IOException {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int iA = fVar.a(list.get(i));
            if (iA != -1) {
                return iA;
            }
        }
        return -1;
    }

    @NonNull
    @RequiresApi(21)
    public static ImageHeaderParser.ImageType d(@NonNull List<ImageHeaderParser> list, @NonNull rh rhVar, @NonNull zi ziVar) throws IOException {
        return g(list, new c(rhVar, ziVar));
    }

    @NonNull
    public static ImageHeaderParser.ImageType e(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull zi ziVar) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new bm(inputStream, ziVar);
        }
        inputStream.mark(5242880);
        return g(list, new a(inputStream));
    }

    @NonNull
    public static ImageHeaderParser.ImageType f(@NonNull List<ImageHeaderParser> list, @Nullable ByteBuffer byteBuffer) throws IOException {
        return byteBuffer == null ? ImageHeaderParser.ImageType.UNKNOWN : g(list, new b(byteBuffer));
    }

    @NonNull
    public static ImageHeaderParser.ImageType g(@NonNull List<ImageHeaderParser> list, g gVar) throws IOException {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImageHeaderParser.ImageType imageTypeA = gVar.a(list.get(i));
            if (imageTypeA != ImageHeaderParser.ImageType.UNKNOWN) {
                return imageTypeA;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
