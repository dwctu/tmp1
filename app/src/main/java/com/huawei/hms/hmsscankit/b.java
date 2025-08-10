package com.huawei.hms.hmsscankit;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.mlsdk.common.MLFrame;
import com.huawei.hms.scankit.p.C0384pb;

/* compiled from: HmsRemoteDecoder.java */
/* loaded from: classes3.dex */
public class b {
    private static volatile IRemoteHmsDecoderDelegate a;

    public static HmsScan[] a(Context context, MLFrame mLFrame, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) throws IllegalAccessException, InstantiationException, IllegalArgumentException {
        int i;
        HmsScan[] hmsScanArr = new HmsScan[0];
        if (a == null) {
            IRemoteCreator iRemoteCreatorB = j.b(context);
            if (iRemoteCreatorB == null) {
                return hmsScanArr;
            }
            try {
                a = iRemoteCreatorB.newRemoteHmsDecoderDelegate();
            } catch (RemoteException unused) {
                com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
            }
        }
        if (a != null) {
            try {
                DetailRect detailRect = mLFrame.acquireProperty() != null ? new DetailRect(mLFrame.acquireProperty().getWidth(), mLFrame.acquireProperty().getHeight()) : new DetailRect();
                Bundle bundle = new Bundle();
                if (hmsScanAnalyzerOptions != null && (i = hmsScanAnalyzerOptions.mode) != 0) {
                    bundle.putInt(DetailRect.FORMAT_FLAG, i);
                }
                bundle.putInt(DetailRect.TYPE_TRANS, 3);
                bundle.putAll(C0384pb.a(context));
                HmsScan[] hmsScanArrDecodeInBitmap = mLFrame.readBitmap() != null ? a.decodeInBitmap(detailRect, ObjectWrapper.wrap(mLFrame.readBitmap()), ObjectWrapper.wrap(bundle)) : a.detectWithByteBuffer(detailRect, ObjectWrapper.wrap(mLFrame.acquireGrayByteBuffer()), ObjectWrapper.wrap(bundle));
                if (hmsScanArrDecodeInBitmap != null) {
                    return hmsScanArrDecodeInBitmap;
                }
            } catch (RemoteException unused2) {
                com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
            }
        }
        return hmsScanArr;
    }
}
