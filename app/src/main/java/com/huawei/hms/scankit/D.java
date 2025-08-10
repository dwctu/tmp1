package com.huawei.hms.scankit;

import android.graphics.Bitmap;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.p.C0356ib;
import com.huawei.hms.scankit.p.Fb;
import java.nio.ByteBuffer;

/* compiled from: RemoteDecoderWork.java */
/* loaded from: classes3.dex */
public class D {
    private static volatile D a;

    public static D a() {
        if (a == null) {
            synchronized (D.class) {
                if (a == null) {
                    a = new D();
                }
            }
        }
        return a;
    }

    public HmsScan[] b(Bitmap bitmap, int i, boolean z, C0356ib c0356ib) {
        C0356ib.a aVarA;
        if (c0356ib != null) {
            c0356ib.a("single");
            aVarA = c0356ib.a(z, bitmap.getHeight() * bitmap.getWidth());
            if (bitmap.getHeight() < 30 || bitmap.getWidth() < 30) {
                aVarA.a(-1005);
            }
        } else {
            aVarA = null;
        }
        HmsScan[] hmsScanArrA = Fb.a(k.b(bitmap, new E(i, z)));
        if (c0356ib != null) {
            c0356ib.a(hmsScanArrA, aVarA);
        }
        return hmsScanArrA;
    }

    public HmsScan[] a(Bitmap bitmap, int i, boolean z, C0356ib c0356ib) {
        C0356ib.a aVarA;
        if (c0356ib != null) {
            c0356ib.a("multi");
            aVarA = c0356ib.a(z, bitmap.getHeight() * bitmap.getWidth());
            if (bitmap.getHeight() < 30 || bitmap.getWidth() < 30) {
                aVarA.a(-1005);
            }
        } else {
            aVarA = null;
        }
        HmsScan[] hmsScanArrA = Fb.a(k.a(bitmap, new E(i, z)));
        if (c0356ib != null) {
            c0356ib.a(hmsScanArrA, aVarA);
        }
        return hmsScanArrA;
    }

    public HmsScan[] a(ByteBuffer byteBuffer, int i, int i2, int i3, boolean z, C0356ib c0356ib) {
        C0356ib.a aVarA;
        if (c0356ib != null) {
            c0356ib.a("multi");
            int i4 = i2 * i;
            aVarA = c0356ib.a(z, i4);
            if (i >= 30 && i2 >= 30) {
                if (byteBuffer.array().length < i4) {
                    aVarA.a(-1008);
                }
            } else {
                aVarA.a(-1007);
            }
        } else {
            aVarA = null;
        }
        HmsScan[] hmsScanArrA = Fb.a(k.a(byteBuffer, new E(i, i2, i3, true, z)));
        if (c0356ib != null) {
            c0356ib.a(hmsScanArrA, aVarA);
        }
        return hmsScanArrA;
    }
}
