package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Asserts;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes2.dex */
public final class zaa implements Runnable {
    public final /* synthetic */ ImageManager zaa;
    private final Uri zab;

    @Nullable
    private final ParcelFileDescriptor zac;

    public zaa(ImageManager imageManager, @Nullable Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
        this.zaa = imageManager;
        this.zab = uri;
        this.zac = parcelFileDescriptor;
    }

    @Override // java.lang.Runnable
    public final void run() throws InterruptedException, IOException {
        Bitmap bitmap;
        boolean z;
        Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
        ParcelFileDescriptor parcelFileDescriptor = this.zac;
        Bitmap bitmapDecodeFileDescriptor = null;
        boolean z2 = false;
        if (parcelFileDescriptor != null) {
            try {
                bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
            } catch (OutOfMemoryError unused) {
                String strValueOf = String.valueOf(this.zab);
                String.valueOf(strValueOf).length();
                "OOM while loading bitmap for uri: ".concat(String.valueOf(strValueOf));
                z2 = true;
            }
            try {
                this.zac.close();
            } catch (IOException unused2) {
            }
            bitmap = bitmapDecodeFileDescriptor;
            z = z2;
        } else {
            bitmap = null;
            z = false;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ImageManager imageManager = this.zaa;
        imageManager.zae.post(new zac(imageManager, this.zab, bitmap, z, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused3) {
            String strValueOf2 = String.valueOf(this.zab);
            String.valueOf(strValueOf2).length();
            "Latch interrupted while posting ".concat(String.valueOf(strValueOf2));
        }
    }
}
