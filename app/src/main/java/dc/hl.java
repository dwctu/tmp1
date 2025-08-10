package dc;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: BitmapEncoder.java */
/* loaded from: classes.dex */
public class hl implements dh<Bitmap> {
    public static final zg<Integer> b = zg.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final zg<Bitmap.CompressFormat> c = zg.e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    @Nullable
    public final zi a;

    public hl(@NonNull zi ziVar) {
        this.a = ziVar;
    }

    @Override // dc.dh
    @NonNull
    public ug b(@NonNull ah ahVar) {
        return ug.TRANSFORMED;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0067 A[Catch: all -> 0x00b3, TRY_LEAVE, TryCatch #2 {all -> 0x00b3, blocks: (B:3:0x0021, B:13:0x004d, B:25:0x0061, B:27:0x0067, B:31:0x00af, B:32:0x00b2), top: B:41:0x0021 }] */
    @Override // dc.vg
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(@androidx.annotation.NonNull dc.ti<android.graphics.Bitmap> r9, @androidx.annotation.NonNull java.io.File r10, @androidx.annotation.NonNull dc.ah r11) {
        /*
            r8 = this;
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r9 = r9.get()
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            android.graphics.Bitmap$CompressFormat r1 = r8.d(r9, r11)
            int r2 = r9.getWidth()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r3 = r9.getHeight()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "encode: [%dx%d] %s"
            dc.yp.c(r4, r2, r3, r1)
            long r2 = dc.rp.b()     // Catch: java.lang.Throwable -> Lb3
            dc.zg<java.lang.Integer> r4 = dc.hl.b     // Catch: java.lang.Throwable -> Lb3
            java.lang.Object r4 = r11.c(r4)     // Catch: java.lang.Throwable -> Lb3
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> Lb3
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> Lb3
            r5 = 0
            r6 = 0
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58
            r7.<init>(r10)     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58
            dc.zi r10 = r8.a     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            if (r10 == 0) goto L45
            dc.hh r10 = new dc.hh     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            dc.zi r6 = r8.a     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            r10.<init>(r7, r6)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            r6 = r10
            goto L46
        L45:
            r6 = r7
        L46:
            r9.compress(r1, r4, r6)     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58
            r6.close()     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58
            r5 = 1
        L4d:
            r6.close()     // Catch: java.io.IOException -> L60 java.lang.Throwable -> Lb3
            goto L60
        L51:
            r9 = move-exception
            r6 = r7
            goto Lad
        L54:
            r6 = r7
            goto L58
        L56:
            r9 = move-exception
            goto Lad
        L58:
            r10 = 3
            boolean r10 = android.util.Log.isLoggable(r0, r10)     // Catch: java.lang.Throwable -> L56
            if (r6 == 0) goto L60
            goto L4d
        L60:
            r10 = 2
            boolean r10 = android.util.Log.isLoggable(r0, r10)     // Catch: java.lang.Throwable -> Lb3
            if (r10 == 0) goto La9
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb3
            r10.<init>()     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r0 = "Compressed with type: "
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb3
            r10.append(r1)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r0 = " of size "
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb3
            int r0 = dc.wp.h(r9)     // Catch: java.lang.Throwable -> Lb3
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r0 = " in "
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb3
            double r0 = dc.rp.a(r2)     // Catch: java.lang.Throwable -> Lb3
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r0 = ", options format: "
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb3
            dc.zg<android.graphics.Bitmap$CompressFormat> r0 = dc.hl.c     // Catch: java.lang.Throwable -> Lb3
            java.lang.Object r11 = r11.c(r0)     // Catch: java.lang.Throwable -> Lb3
            r10.append(r11)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r11 = ", hasAlpha: "
            r10.append(r11)     // Catch: java.lang.Throwable -> Lb3
            boolean r9 = r9.hasAlpha()     // Catch: java.lang.Throwable -> Lb3
            r10.append(r9)     // Catch: java.lang.Throwable -> Lb3
            r10.toString()     // Catch: java.lang.Throwable -> Lb3
        La9:
            dc.yp.d()
            return r5
        Lad:
            if (r6 == 0) goto Lb2
            r6.close()     // Catch: java.io.IOException -> Lb2 java.lang.Throwable -> Lb3
        Lb2:
            throw r9     // Catch: java.lang.Throwable -> Lb3
        Lb3:
            r9 = move-exception
            dc.yp.d()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.hl.a(dc.ti, java.io.File, dc.ah):boolean");
    }

    public final Bitmap.CompressFormat d(Bitmap bitmap, ah ahVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) ahVar.c(c);
        return compressFormat != null ? compressFormat : bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }
}
