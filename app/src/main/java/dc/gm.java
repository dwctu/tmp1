package dc;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: UnitBitmapDecoder.java */
/* loaded from: classes.dex */
public final class gm implements ch<Bitmap, Bitmap> {

    /* compiled from: UnitBitmapDecoder.java */
    public static final class a implements ti<Bitmap> {
        public final Bitmap a;

        public a(@NonNull Bitmap bitmap) {
            this.a = bitmap;
        }

        @Override // dc.ti
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap get() {
            return this.a;
        }

        @Override // dc.ti
        public int b() {
            return wp.h(this.a);
        }

        @Override // dc.ti
        @NonNull
        public Class<Bitmap> c() {
            return Bitmap.class;
        }

        @Override // dc.ti
        public void recycle() {
        }
    }

    @Override // dc.ch
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ti<Bitmap> b(@NonNull Bitmap bitmap, int i, int i2, @NonNull ah ahVar) {
        return new a(bitmap);
    }

    @Override // dc.ch
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Bitmap bitmap, @NonNull ah ahVar) {
        return true;
    }
}
