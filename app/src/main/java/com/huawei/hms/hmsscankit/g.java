package com.huawei.hms.hmsscankit;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.scankit.p.C0376nb;
import com.huawei.hms.scankit.p.C0384pb;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

/* compiled from: RemoteDecoder.java */
/* loaded from: classes3.dex */
public class g {
    private static volatile C0376nb a;
    private static volatile IRemoteDecoderDelegate b;

    public static HmsScan[] a(Context context, Bitmap bitmap, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) throws IllegalAccessException, InstantiationException, IllegalArgumentException {
        HmsScan[] hmsScanArr = new HmsScan[0];
        if (b == null) {
            IRemoteCreator iRemoteCreatorB = j.b(context);
            if (iRemoteCreatorB == null) {
                return hmsScanArr;
            }
            try {
                b = iRemoteCreatorB.newRemoteDecoderDelegate();
            } catch (RemoteException unused) {
                com.huawei.hms.scankit.util.a.b("RemoteDecoder", "RemoteException");
            }
        }
        if (b == null) {
            return hmsScanArr;
        }
        try {
            Bundle bundle = new Bundle();
            if (hmsScanAnalyzerOptions != null) {
                bundle.putInt(DetailRect.FORMAT_FLAG, hmsScanAnalyzerOptions.mode);
                bundle.putBoolean(DetailRect.PHOTO_MODE, hmsScanAnalyzerOptions.photoMode);
            }
            bundle.putInt(DetailRect.TYPE_TRANS, 3);
            bundle.putAll(C0384pb.a(context));
            HmsScan[] hmsScanArrDecodeWithBitmap = b.decodeWithBitmap(ObjectWrapper.wrap(bitmap), ObjectWrapper.wrap(bundle));
            return hmsScanArrDecodeWithBitmap != null ? hmsScanArrDecodeWithBitmap : hmsScanArr;
        } catch (RemoteException unused2) {
            com.huawei.hms.scankit.util.a.b("RemoteDecoder", "RemoteException");
            return hmsScanArr;
        }
    }

    private static void a(Bundle bundle) {
        if (DynamicModuleInitializer.getContext() == null) {
            try {
                j.a(AGConnectInstance.getInstance().getContext());
            } catch (ClassNotFoundException e) {
                com.huawei.hms.scankit.util.a.b("ClassNotFoundException", e.getMessage());
            } catch (IllegalAccessException e2) {
                com.huawei.hms.scankit.util.a.b("IllegalAccessException", e2.getMessage());
            } catch (Exception e3) {
                com.huawei.hms.scankit.util.a.b("Exception", e3.getMessage());
            } catch (NoClassDefFoundError e4) {
                com.huawei.hms.scankit.util.a.b("NoClassDefFoundError", e4.getMessage());
                return;
            } catch (NoSuchMethodException e5) {
                com.huawei.hms.scankit.util.a.b("NoSuchMethodException", e5.getMessage());
            } catch (InvocationTargetException e6) {
                com.huawei.hms.scankit.util.a.b("InvocationTargetException", e6.getMessage());
            }
        }
        try {
            if (a == null) {
                try {
                    try {
                        a = new C0376nb();
                        if (a == null) {
                            return;
                        }
                    } catch (Exception e7) {
                        com.huawei.hms.scankit.util.a.b("RemoteDecoder", e7.getMessage());
                        if (a == null) {
                            return;
                        }
                    }
                } catch (RuntimeException e8) {
                    com.huawei.hms.scankit.util.a.b("RemoteDecoder", e8.getMessage());
                    if (a == null) {
                        return;
                    }
                }
            }
            a.a(bundle);
        } catch (Throwable th) {
            if (a != null) {
                throw th;
            }
        }
    }

    public static Bundle a(String str, int i, int i2, int i3, HmsBuildBitmapOption hmsBuildBitmapOption) {
        Bundle bundle = new Bundle();
        bundle.putInt("contentLength", str == null ? -1 : str.length());
        bundle.putInt("scanType", i);
        bundle.putInt("reqWidth", i2);
        bundle.putInt("reqHeight", i3);
        bundle.putString("buildBitmapOption", hmsBuildBitmapOption == null ? "null" : hmsBuildBitmapOption.toString());
        bundle.putString("apiName", "BuildBitmap");
        bundle.putLong("callTime", System.currentTimeMillis());
        bundle.putString("transId", UUID.randomUUID().toString());
        return bundle;
    }

    public static void a(int i, Bitmap bitmap, Bundle bundle) {
        if (bundle != null) {
            bundle.putInt("result", i);
            bundle.putInt("outputWidth", bitmap == null ? -1 : bitmap.getWidth());
            bundle.putInt("outputHeight", bitmap != null ? bitmap.getHeight() : -1);
            long j = bundle.getLong("callTime");
            bundle.putLong("costTime", System.currentTimeMillis() - j);
            bundle.putString("callTime", new f("yyyyMMddHHmmss.SSS").format(Long.valueOf(j)));
            a(bundle);
        }
    }
}
