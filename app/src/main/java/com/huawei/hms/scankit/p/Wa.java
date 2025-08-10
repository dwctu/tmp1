package com.huawei.hms.scankit.p;

/* compiled from: QRCodeDecoderMetaData.java */
/* loaded from: classes3.dex */
public final class Wa {
    private final boolean a;

    public Wa(boolean z) {
        this.a = z;
    }

    public void a(com.huawei.hms.scankit.aiscan.common.z[] zVarArr) {
        if (!this.a || zVarArr == null || zVarArr.length < 3) {
            return;
        }
        com.huawei.hms.scankit.aiscan.common.z zVar = zVarArr[0];
        zVarArr[0] = zVarArr[2];
        zVarArr[2] = zVar;
    }
}
