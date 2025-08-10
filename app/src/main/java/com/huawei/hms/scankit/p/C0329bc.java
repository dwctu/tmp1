package com.huawei.hms.scankit.p;

import org.bouncycastle.crypto.tls.CipherSuite;

/* compiled from: DataMatrixSymbolInfo144.java */
/* renamed from: com.huawei.hms.scankit.p.bc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0329bc extends C0357ic {
    public C0329bc() {
        super(false, 1558, 620, 22, 22, 36, -1, 62);
    }

    @Override // com.huawei.hms.scankit.p.C0357ic
    public int a(int i) {
        return i <= 8 ? CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256 : CipherSuite.TLS_DH_anon_WITH_SEED_CBC_SHA;
    }

    @Override // com.huawei.hms.scankit.p.C0357ic
    public int c() {
        return 10;
    }
}
