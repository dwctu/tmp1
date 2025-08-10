package com.huawei.hms.scankit;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate;

/* compiled from: IRemoteFrameDecoderDelegateImpl.java */
/* loaded from: classes3.dex */
public class s extends IRemoteFrameDecoderDelegate.Stub {
    private static volatile s a = new s();
    public Point b;
    public int c = 0;
    public Rect d;

    private s() {
    }

    public static s a() {
        return a;
    }

    public synchronized Rect b(int i, int i2) {
        Rect rect = new Rect(a(i, i2));
        Point point = new Point(i, i2);
        Point point2 = this.b;
        if (point2 == null) {
            return null;
        }
        int i3 = point2.x;
        int i4 = point2.y;
        if (i3 < i4) {
            int i5 = rect.left;
            int i6 = point.y;
            rect.left = (i5 * i6) / i3;
            rect.right = (rect.right * i6) / i3;
            int i7 = rect.top;
            int i8 = point.x;
            rect.top = (i7 * i8) / i4;
            rect.bottom = (rect.bottom * i8) / i4;
        } else {
            int i9 = rect.top;
            int i10 = point.y;
            rect.top = (i9 * i10) / i4;
            rect.bottom = (rect.bottom * i10) / i4;
            int i11 = rect.left;
            int i12 = point.x;
            rect.left = (i11 * i12) / i3;
            rect.right = (rect.right * i12) / i3;
        }
        return rect;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate
    public com.huawei.hms.scankit.aiscan.common.x[] decode(byte[] bArr, int i, int i2, int i3, int i4, IObjectWrapper iObjectWrapper) throws RemoteException {
        if (iObjectWrapper != null && (ObjectWrapper.unwrap(iObjectWrapper) instanceof Bundle)) {
            Bundle bundle = (Bundle) ObjectWrapper.unwrap(iObjectWrapper);
            this.b = (Point) bundle.getParcelable("Screen");
            this.d = (Rect) bundle.getParcelable("Rect");
        }
        if (this.d == null) {
            this.d = new Rect(-1, -1, -1, -1);
        }
        if (this.b == null) {
            this.b = new Point(1080, 1920);
        }
        com.huawei.hms.scankit.aiscan.common.r rVarA = a(bArr, i, i2, i3);
        byte[] bArrB = rVarA.b();
        E e = new E(rVarA.c(), rVarA.a(), i4);
        int i5 = this.c;
        this.c = i5 + 1;
        return k.b(bArrB, e.a(i5));
    }

    private com.huawei.hms.scankit.aiscan.common.r a(byte[] bArr, int i, int i2, int i3) {
        if (i3 == 0) {
            byte[] bArr2 = new byte[bArr.length];
            for (int i4 = 0; i4 < i2; i4++) {
                for (int i5 = 0; i5 < i; i5++) {
                    bArr2[(((i5 * i2) + i2) - i4) - 1] = bArr[(i4 * i) + i5];
                }
            }
            return a(bArr2, i2, i);
        }
        if (i3 == 2) {
            byte[] bArr3 = new byte[bArr.length];
            for (int i6 = 0; i6 < i2; i6++) {
                for (int i7 = 0; i7 < i; i7++) {
                    bArr3[(((i - 1) - i7) * i2) + i6] = bArr[(i6 * i) + i7];
                }
            }
            return a(bArr3, i2, i);
        }
        if (i3 != 3) {
            return a(bArr, i, i2);
        }
        byte[] bArr4 = new byte[bArr.length];
        for (int i8 = 0; i8 < i2; i8++) {
            for (int i9 = 0; i9 < i; i9++) {
                bArr4[(((((i2 - 1) - i8) * i) + i) - 1) - i9] = bArr[(i8 * i) + i9];
            }
        }
        return a(bArr4, i, i2);
    }

    public synchronized Rect a(int i, int i2) {
        int iMin;
        int i3;
        int i4;
        iMin = Math.min(i, i2);
        i3 = (i - iMin) / 2;
        i4 = (i2 - iMin) / 2;
        return new Rect(i3, i4, i3 + iMin, iMin + i4);
    }

    public com.huawei.hms.scankit.aiscan.common.r a(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (b(i, i2) == null) {
            return null;
        }
        int iMin = (int) (Math.min(i, i2) * 0.8d);
        int i11 = (i - iMin) / 2;
        int i12 = (i2 - iMin) / 2;
        Rect rect = this.d;
        if (rect == null) {
            i3 = i11;
            i4 = iMin;
        } else {
            if (rect.left == -1 && rect.right == -1 && rect.top == -1 && rect.bottom == -1) {
                iMin = (int) (i * 0.85d);
                i11 = (i - iMin) / 2;
                double d = i2;
                i10 = (int) (0.8d * d);
                i12 = (int) (d * 0.1d);
            } else {
                iMin = (int) (Math.min(i, i2) * 0.9d);
                i11 = (i - iMin) / 2;
                Rect rect2 = this.d;
                Rect rect3 = new Rect(rect2.left, rect2.top, rect2.right, rect2.bottom);
                int iMax = Math.max(i, i2);
                Point point = this.b;
                if (point != null) {
                    i9 = point.x;
                    i8 = point.y;
                } else {
                    i8 = iMax;
                    i9 = i8;
                }
                float fMax = iMax / Math.max(i9, i8);
                Rect rect4 = this.d;
                int i13 = (int) (rect4.top * fMax);
                rect3.top = i13;
                int i14 = (int) (rect4.bottom * fMax);
                rect3.bottom = i14;
                float f = i2 / 14.0f;
                if (i13 > f) {
                    i13 -= (int) f;
                }
                i12 = i13 < 0 ? 0 : i13;
                i10 = i14 - i12;
                if (i12 + i10 > i2) {
                    i12 = (i2 - iMin) / 2;
                    i3 = i11;
                    i4 = iMin;
                }
            }
            int i15 = i11;
            i4 = iMin;
            iMin = i10;
            i3 = i15;
        }
        com.huawei.hms.scankit.util.a.a("ScanSize", "top:" + i12 + "scanSizeHeight" + iMin + "mHeight:" + i2);
        if (i2 < i12 + iMin) {
            i5 = i2;
            i6 = 0;
        } else {
            i5 = iMin;
            i6 = i12;
        }
        if (i < i3 + i4) {
            i7 = i;
            i3 = 0;
        } else {
            i7 = i4;
        }
        return new com.huawei.hms.scankit.aiscan.common.r(bArr, i, i2, i3, i6, i7, i5, false);
    }
}
