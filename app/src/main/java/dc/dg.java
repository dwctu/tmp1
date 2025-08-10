package dc;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import androidx.core.internal.view.SupportMenu;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: WebpHeaderParser.java */
/* loaded from: classes.dex */
public class dg {
    public static final boolean a = f();

    /* compiled from: WebpHeaderParser.java */
    public static final class a implements c {
        public final byte[] a;
        public final int b;
        public final int c;
        public int d;

        public a(byte[] bArr, int i, int i2) {
            this.a = bArr;
            this.b = i;
            this.c = i2;
            this.d = i;
        }

        @Override // dc.dg.c
        public int a() throws IOException {
            return ((b() << 8) & 65280) | (b() & 255);
        }

        @Override // dc.dg.c
        public int b() throws IOException {
            int i = this.d;
            if (i >= this.b + this.c) {
                return -1;
            }
            byte[] bArr = this.a;
            this.d = i + 1;
            return bArr[i];
        }

        @Override // dc.dg.c
        public long skip(long j) throws IOException {
            int iMin = (int) Math.min((this.b + this.c) - this.d, j);
            this.d += iMin;
            return iMin;
        }
    }

    /* compiled from: WebpHeaderParser.java */
    public static final class b implements c {
        public final ByteBuffer a;

        public b(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // dc.dg.c
        public int a() throws IOException {
            return ((b() << 8) & 65280) | (b() & 255);
        }

        @Override // dc.dg.c
        public int b() throws IOException {
            if (this.a.remaining() < 1) {
                return -1;
            }
            return this.a.get();
        }

        @Override // dc.dg.c
        public long skip(long j) throws IOException {
            int iMin = (int) Math.min(this.a.remaining(), j);
            ByteBuffer byteBuffer = this.a;
            byteBuffer.position(byteBuffer.position() + iMin);
            return iMin;
        }
    }

    /* compiled from: WebpHeaderParser.java */
    public interface c {
        int a() throws IOException;

        int b() throws IOException;

        long skip(long j) throws IOException;
    }

    /* compiled from: WebpHeaderParser.java */
    public static final class d implements c {
        public final InputStream a;

        public d(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // dc.dg.c
        public int a() throws IOException {
            return ((this.a.read() << 8) & 65280) | (this.a.read() & 255);
        }

        @Override // dc.dg.c
        public int b() throws IOException {
            return this.a.read();
        }

        @Override // dc.dg.c
        public long skip(long j) throws IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long jSkip = this.a.skip(j2);
                if (jSkip <= 0) {
                    if (this.a.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j2 -= jSkip;
            }
            return j - j2;
        }
    }

    /* compiled from: WebpHeaderParser.java */
    public enum e {
        WEBP_SIMPLE(false, false),
        WEBP_LOSSLESS(false, false),
        WEBP_LOSSLESS_WITH_ALPHA(true, false),
        WEBP_EXTENDED(false, false),
        WEBP_EXTENDED_WITH_ALPHA(true, false),
        WEBP_EXTENDED_ANIMATED(false, true),
        NONE_WEBP(false, false);

        private final boolean hasAlpha;
        private final boolean hasAnimation;

        e(boolean z, boolean z2) {
            this.hasAlpha = z;
            this.hasAnimation = z2;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }

        public boolean hasAnimation() {
            return this.hasAnimation;
        }
    }

    public static e a(c cVar) throws IOException {
        if ((((cVar.a() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & 65535)) != 1380533830) {
            return e.NONE_WEBP;
        }
        cVar.skip(4L);
        if ((((cVar.a() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & 65535)) != 1464156752) {
            return e.NONE_WEBP;
        }
        int iA = ((cVar.a() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & 65535);
        if (iA == 1448097824) {
            return e.WEBP_SIMPLE;
        }
        if (iA == 1448097868) {
            cVar.skip(4L);
            return (cVar.b() & 8) != 0 ? e.WEBP_LOSSLESS_WITH_ALPHA : e.WEBP_LOSSLESS;
        }
        if (iA != 1448097880) {
            return e.NONE_WEBP;
        }
        cVar.skip(4L);
        int iB = cVar.b();
        return (iB & 2) != 0 ? e.WEBP_EXTENDED_ANIMATED : (iB & 16) != 0 ? e.WEBP_EXTENDED_WITH_ALPHA : e.WEBP_EXTENDED;
    }

    public static e b(InputStream inputStream, zi ziVar) throws IOException {
        if (inputStream == null) {
            return e.NONE_WEBP;
        }
        if (!inputStream.markSupported()) {
            inputStream = new bm(inputStream, ziVar);
        }
        inputStream.mark(21);
        try {
            vp.d(inputStream);
            return a(new d(inputStream));
        } finally {
            inputStream.reset();
        }
    }

    public static e c(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return e.NONE_WEBP;
        }
        vp.d(byteBuffer);
        return a(new b(byteBuffer));
    }

    public static e d(byte[] bArr, int i, int i2) throws IOException {
        return a(new a(bArr, i, i2));
    }

    public static boolean e(e eVar) {
        return eVar == e.WEBP_EXTENDED_ANIMATED;
    }

    public static boolean f() {
        int i = Build.VERSION.SDK_INT;
        if (i < 17) {
            return false;
        }
        if (i == 17) {
            byte[] bArrDecode = Base64.decode("UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==", 0);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options);
            if (options.outHeight != 1 || options.outWidth != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean g(e eVar) {
        return (eVar == e.NONE_WEBP || eVar == e.WEBP_SIMPLE) ? false : true;
    }

    public static boolean h(e eVar) {
        return eVar == e.WEBP_SIMPLE || eVar == e.WEBP_LOSSLESS || eVar == e.WEBP_LOSSLESS_WITH_ALPHA || eVar == e.WEBP_EXTENDED || eVar == e.WEBP_EXTENDED_WITH_ALPHA;
    }
}
