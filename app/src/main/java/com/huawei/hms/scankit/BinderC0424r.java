package com.huawei.hms.scankit;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.DetailRect;
import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.p.C0356ib;
import com.huawei.hms.scankit.p.C0376nb;
import com.huawei.hms.scankit.p.Ob;

/* compiled from: IRemoteDecoderDelegateImpl.java */
/* renamed from: com.huawei.hms.scankit.r, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class BinderC0424r extends IRemoteDecoderDelegate.Stub {
    private static volatile BinderC0424r a = new BinderC0424r();
    private volatile C0356ib b = null;
    private volatile C0376nb c = null;

    public static BinderC0424r a() {
        return a;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
    public IObjectWrapper buildBitmap(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (iObjectWrapper == null || !(ObjectWrapper.unwrap(iObjectWrapper) instanceof Bundle)) {
            throw new RemoteException("Bundle is Null");
        }
        Bundle bundle = (Bundle) ObjectWrapper.unwrap(iObjectWrapper);
        String string = bundle.getString(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_CONTENT);
        int i = bundle.getInt(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_FOTMAT);
        int i2 = bundle.getInt(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_WIDTH);
        int i3 = bundle.getInt(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_HEIGHT);
        int i4 = bundle.getInt(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_MARGIN, 1);
        int i5 = bundle.getInt(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_COLOR, -1);
        try {
            Bitmap bitmapA = new Ob().a(string, i, i2, i3, new HmsBuildBitmapOption.Creator().setBitmapMargin(i4).setBitmapColor(i5).setBitmapBackgroundColor(bundle.getInt(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_BACKCOLOR, -1)).create());
            if (bitmapA != null) {
                return ObjectWrapper.wrap(bitmapA);
            }
            throw new RemoteException("Bitmap is Null");
        } catch (WriterException e) {
            throw new RemoteException(e.getMessage());
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
    public void buildBitmapLog(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null || !(ObjectWrapper.unwrap(iObjectWrapper) instanceof Bundle)) {
            return;
        }
        Bundle bundle = (Bundle) ObjectWrapper.unwrap(iObjectWrapper);
        try {
            if (this.c == null) {
                try {
                    try {
                        this.c = new C0376nb();
                        if (this.c == null) {
                            return;
                        }
                    } catch (Exception e) {
                        com.huawei.hms.scankit.util.a.b("IRemoteDecoderDelegateImpl", e.getMessage());
                        if (this.c == null) {
                            return;
                        }
                    }
                } catch (RuntimeException e2) {
                    com.huawei.hms.scankit.util.a.b("IRemoteDecoderDelegateImpl", e2.getMessage());
                    if (this.c == null) {
                        return;
                    }
                }
            }
            this.c.a(bundle);
        } catch (Throwable th) {
            if (this.c != null) {
                throw th;
            }
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
    public HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Bundle bundle = (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) ? new Bundle() : (Bundle) ObjectWrapper.unwrap(iObjectWrapper2);
        if (this.b == null) {
            try {
                this.b = new C0356ib(bundle, "Bitmap");
            } catch (RuntimeException unused) {
                com.huawei.hms.scankit.util.a.b("IRemoteDecoderDelegateImpl", "Ha error");
            } catch (Exception unused2) {
                com.huawei.hms.scankit.util.a.b("IRemoteDecoderDelegateImpl", "Ha error");
            }
        }
        return a(iObjectWrapper, iObjectWrapper2);
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
    public IObjectWrapper queryDeepLinkInfo(IObjectWrapper iObjectWrapper) throws RemoteException {
        return null;
    }

    private HmsScan[] a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        boolean z;
        int iB;
        boolean z2;
        if (iObjectWrapper == null) {
            com.huawei.hms.scankit.util.a.b("IRemoteDecoder", "bitmap is null");
            return new HmsScan[0];
        }
        Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            z = false;
            iB = 0;
            z2 = true;
        } else {
            iB = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.FORMAT_FLAG);
            z2 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.PHOTO_MODE, false);
            int i = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.TYPE_TRANS, 0);
            DetailRect.HMSSCAN_SDK_VALUE = i;
            z = i >= 2;
            if (z) {
                iB = com.huawei.hms.scankit.util.b.b(iB);
            }
        }
        if (!(objUnwrap instanceof Bitmap)) {
            return new HmsScan[0];
        }
        HmsScan[] hmsScanArrB = D.a().b((Bitmap) objUnwrap, iB, z2, this.b);
        return !z ? com.huawei.hms.scankit.util.b.a(hmsScanArrB) : hmsScanArrB;
    }
}
