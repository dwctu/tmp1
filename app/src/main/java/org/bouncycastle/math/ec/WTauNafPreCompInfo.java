package org.bouncycastle.math.ec;

import org.bouncycastle.math.ec.ECPoint;

/* loaded from: classes5.dex */
public class WTauNafPreCompInfo implements PreCompInfo {
    private ECPoint.F2m[] preComp;

    public WTauNafPreCompInfo(ECPoint.F2m[] f2mArr) {
        this.preComp = null;
        this.preComp = f2mArr;
    }

    public ECPoint.F2m[] getPreComp() {
        return this.preComp;
    }
}
