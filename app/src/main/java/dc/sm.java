package dc;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import dc.wf;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* compiled from: ByteBufferGifDecoder.java */
/* loaded from: classes.dex */
public class sm implements ch<ByteBuffer, GifDrawable> {
    public static final a f = new a();
    public static final b g = new b();
    public final Context a;
    public final List<ImageHeaderParser> b;
    public final b c;
    public final a d;
    public final tm e;

    /* compiled from: ByteBufferGifDecoder.java */
    @VisibleForTesting
    public static class a {
        public wf a(wf.a aVar, yf yfVar, ByteBuffer byteBuffer, int i) {
            return new ag(aVar, yfVar, byteBuffer, i);
        }
    }

    /* compiled from: ByteBufferGifDecoder.java */
    @VisibleForTesting
    public static class b {
        public final Queue<zf> a = wp.f(0);

        public synchronized zf a(ByteBuffer byteBuffer) {
            zf zfVarPoll;
            zfVarPoll = this.a.poll();
            if (zfVarPoll == null) {
                zfVarPoll = new zf();
            }
            zfVarPoll.p(byteBuffer);
            return zfVarPoll;
        }

        public synchronized void b(zf zfVar) {
            zfVar.a();
            this.a.offer(zfVar);
        }
    }

    public sm(Context context, List<ImageHeaderParser> list, cj cjVar, zi ziVar) {
        this(context, list, cjVar, ziVar, g, f);
    }

    public static int e(yf yfVar, int i, int i2) {
        int iMin = Math.min(yfVar.a() / i2, yfVar.d() / i);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable("BufferGifDecoder", 2) && iMax > 1) {
            String str = "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + yfVar.d() + "x" + yfVar.a() + "]";
        }
        return iMax;
    }

    @Nullable
    public final vm c(ByteBuffer byteBuffer, int i, int i2, zf zfVar, ah ahVar) {
        long jB = rp.b();
        try {
            yf yfVarC = zfVar.c();
            if (yfVarC.b() > 0 && yfVarC.c() == 0) {
                Bitmap.Config config = ahVar.c(zm.a) == tg.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                wf wfVarA = this.d.a(this.e, yfVarC, byteBuffer, e(yfVarC, i, i2));
                wfVarA.c(config);
                wfVarA.a();
                Bitmap nextFrame = wfVarA.getNextFrame();
                if (nextFrame == null) {
                    return null;
                }
                vm vmVar = new vm(new GifDrawable(this.a, wfVarA, el.c(), i, i2, nextFrame));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    String str = "Decoded GIF from stream in " + rp.a(jB);
                }
                return vmVar;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                String str2 = "Decoded GIF from stream in " + rp.a(jB);
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                String str3 = "Decoded GIF from stream in " + rp.a(jB);
            }
        }
    }

    @Override // dc.ch
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public vm b(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull ah ahVar) {
        zf zfVarA = this.c.a(byteBuffer);
        try {
            return c(byteBuffer, i, i2, zfVarA, ahVar);
        } finally {
            this.c.b(zfVarA);
        }
    }

    @Override // dc.ch
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull ah ahVar) throws IOException {
        return !((Boolean) ahVar.c(zm.b)).booleanValue() && wg.f(this.b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    @VisibleForTesting
    public sm(Context context, List<ImageHeaderParser> list, cj cjVar, zi ziVar, b bVar, a aVar) {
        this.a = context.getApplicationContext();
        this.b = list;
        this.d = aVar;
        this.e = new tm(cjVar, ziVar);
        this.c = bVar;
    }
}
