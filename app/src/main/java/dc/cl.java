package dc;

import android.annotation.SuppressLint;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;

/* compiled from: ImageDecoderResourceDecoder.java */
@RequiresApi(api = 28)
/* loaded from: classes.dex */
public abstract class cl<T> implements ch<ImageDecoder.Source, T> {
    public final wl a = wl.a();

    /* compiled from: ImageDecoderResourceDecoder.java */
    public class a implements ImageDecoder.OnHeaderDecodedListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ tg d;
        public final /* synthetic */ ql e;
        public final /* synthetic */ bh f;

        /* compiled from: ImageDecoderResourceDecoder.java */
        /* renamed from: dc.cl$a$a, reason: collision with other inner class name */
        public class C0167a implements ImageDecoder.OnPartialImageListener {
            public C0167a(a aVar) {
            }

            @Override // android.graphics.ImageDecoder.OnPartialImageListener
            public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                return false;
            }
        }

        public a(int i, int i2, boolean z, tg tgVar, ql qlVar, bh bhVar) {
            this.a = i;
            this.b = i2;
            this.c = z;
            this.d = tgVar;
            this.e = qlVar;
            this.f = bhVar;
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        @SuppressLint({"Override"})
        public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            boolean z = false;
            if (cl.this.a.c(this.a, this.b, this.c, false)) {
                imageDecoder.setAllocator(3);
            } else {
                imageDecoder.setAllocator(1);
            }
            if (this.d == tg.PREFER_RGB_565) {
                imageDecoder.setMemorySizePolicy(0);
            }
            imageDecoder.setOnPartialImageListener(new C0167a(this));
            Size size = imageInfo.getSize();
            int width = this.a;
            if (width == Integer.MIN_VALUE) {
                width = size.getWidth();
            }
            int height = this.b;
            if (height == Integer.MIN_VALUE) {
                height = size.getHeight();
            }
            float fB = this.e.b(size.getWidth(), size.getHeight(), width, height);
            int iRound = Math.round(size.getWidth() * fB);
            int iRound2 = Math.round(size.getHeight() * fB);
            if (Log.isLoggable("ImageDecoder", 2)) {
                String str = "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + iRound + "x" + iRound2 + "] scaleFactor: " + fB;
            }
            imageDecoder.setTargetSize(iRound, iRound2);
            int i = Build.VERSION.SDK_INT;
            if (i < 28) {
                if (i >= 26) {
                    imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
                }
            } else {
                if (this.f == bh.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                    z = true;
                }
                imageDecoder.setTargetColorSpace(ColorSpace.get(z ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            }
        }
    }

    public abstract ti<T> c(ImageDecoder.Source source, int i, int i2, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    @Override // dc.ch
    @Nullable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final ti<T> b(@NonNull ImageDecoder.Source source, int i, int i2, @NonNull ah ahVar) throws IOException {
        tg tgVar = (tg) ahVar.c(rl.f);
        ql qlVar = (ql) ahVar.c(ql.f);
        zg<Boolean> zgVar = rl.j;
        return c(source, i, i2, new a(i, i2, ahVar.c(zgVar) != null && ((Boolean) ahVar.c(zgVar)).booleanValue(), tgVar, qlVar, (bh) ahVar.c(rl.g)));
    }

    @Override // dc.ch
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final boolean a(@NonNull ImageDecoder.Source source, @NonNull ah ahVar) {
        return true;
    }
}
