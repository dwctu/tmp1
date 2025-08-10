package dc;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import dc.zg;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: VideoDecoder.java */
/* loaded from: classes.dex */
public class hm<T> implements ch<T, Bitmap> {
    public static final zg<Long> d = zg.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());
    public static final zg<Integer> e = zg.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());
    public static final e f = new e();
    public final f<T> a;
    public final cj b;
    public final e c;

    /* compiled from: VideoDecoder.java */
    public class a implements zg.b<Long> {
        public final ByteBuffer a = ByteBuffer.allocate(8);

        @Override // dc.zg.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NonNull byte[] bArr, @NonNull Long l, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putLong(l.longValue()).array());
            }
        }
    }

    /* compiled from: VideoDecoder.java */
    public class b implements zg.b<Integer> {
        public final ByteBuffer a = ByteBuffer.allocate(4);

        @Override // dc.zg.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putInt(num.intValue()).array());
            }
        }
    }

    /* compiled from: VideoDecoder.java */
    public static final class c implements f<AssetFileDescriptor> {
        public c() {
        }

        @Override // dc.hm.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) throws IllegalArgumentException {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* compiled from: VideoDecoder.java */
    @RequiresApi(23)
    public static final class d implements f<ByteBuffer> {

        /* compiled from: VideoDecoder.java */
        public class a extends MediaDataSource {
            public final /* synthetic */ ByteBuffer a;

            public a(d dVar, ByteBuffer byteBuffer) {
                this.a = byteBuffer;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // android.media.MediaDataSource
            public long getSize() {
                return this.a.limit();
            }

            @Override // android.media.MediaDataSource
            public int readAt(long j, byte[] bArr, int i, int i2) {
                if (j >= this.a.limit()) {
                    return -1;
                }
                this.a.position((int) j);
                int iMin = Math.min(i2, this.a.remaining());
                this.a.get(bArr, i, iMin);
                return iMin;
            }
        }

        @Override // dc.hm.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) throws IllegalArgumentException {
            mediaMetadataRetriever.setDataSource(new a(this, byteBuffer));
        }
    }

    /* compiled from: VideoDecoder.java */
    @VisibleForTesting
    public static class e {
        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    /* compiled from: VideoDecoder.java */
    @VisibleForTesting
    public interface f<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    /* compiled from: VideoDecoder.java */
    public static final class g implements f<ParcelFileDescriptor> {
        @Override // dc.hm.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) throws IllegalArgumentException {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    public hm(cj cjVar, f<T> fVar) {
        this(cjVar, fVar, f);
    }

    public static ch<AssetFileDescriptor, Bitmap> c(cj cjVar) {
        return new hm(cjVar, new c(null));
    }

    @RequiresApi(api = 23)
    public static ch<ByteBuffer, Bitmap> d(cj cjVar) {
        return new hm(cjVar, new d());
    }

    @Nullable
    public static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, ql qlVar) {
        Bitmap bitmapG = (Build.VERSION.SDK_INT < 27 || i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE || qlVar == ql.d) ? null : g(mediaMetadataRetriever, j, i, i2, i3, qlVar);
        return bitmapG == null ? f(mediaMetadataRetriever, j, i) : bitmapG;
    }

    public static Bitmap f(MediaMetadataRetriever mediaMetadataRetriever, long j, int i) {
        return mediaMetadataRetriever.getFrameAtTime(j, i);
    }

    @TargetApi(27)
    public static Bitmap g(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, ql qlVar) {
        try {
            int i4 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int i5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int i6 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (i6 == 90 || i6 == 270) {
                i5 = i4;
                i4 = i5;
            }
            float fB = qlVar.b(i4, i5, i2, i3);
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(i4 * fB), Math.round(fB * i5));
        } catch (Throwable unused) {
            Log.isLoggable("VideoDecoder", 3);
            return null;
        }
    }

    public static ch<ParcelFileDescriptor, Bitmap> h(cj cjVar) {
        return new hm(cjVar, new g());
    }

    @Override // dc.ch
    public boolean a(@NonNull T t, @NonNull ah ahVar) {
        return true;
    }

    @Override // dc.ch
    public ti<Bitmap> b(@NonNull T t, int i, int i2, @NonNull ah ahVar) throws IOException {
        long jLongValue = ((Long) ahVar.c(d)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + jLongValue);
        }
        Integer num = (Integer) ahVar.c(e);
        if (num == null) {
            num = 2;
        }
        ql qlVar = (ql) ahVar.c(ql.f);
        if (qlVar == null) {
            qlVar = ql.e;
        }
        ql qlVar2 = qlVar;
        MediaMetadataRetriever mediaMetadataRetrieverA = this.c.a();
        try {
            try {
                this.a.a(mediaMetadataRetrieverA, t);
                Bitmap bitmapE = e(mediaMetadataRetrieverA, jLongValue, num.intValue(), i, i2, qlVar2);
                mediaMetadataRetrieverA.release();
                return jl.d(bitmapE, this.b);
            } catch (RuntimeException e2) {
                throw new IOException(e2);
            }
        } catch (Throwable th) {
            mediaMetadataRetrieverA.release();
            throw th;
        }
    }

    @VisibleForTesting
    public hm(cj cjVar, f<T> fVar, e eVar) {
        this.b = cjVar;
        this.a = fVar;
        this.c = eVar;
    }
}
