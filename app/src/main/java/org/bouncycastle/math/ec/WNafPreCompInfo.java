package org.bouncycastle.math.ec;

/* loaded from: classes5.dex */
public class WNafPreCompInfo implements PreCompInfo {
    private ECPoint[] preComp = null;
    private ECPoint[] preCompNeg = null;
    private ECPoint twiceP = null;

    public ECPoint[] getPreComp() {
        return this.preComp;
    }

    public ECPoint[] getPreCompNeg() {
        return this.preCompNeg;
    }

    public ECPoint getTwiceP() {
        return this.twiceP;
    }

    public void setPreComp(ECPoint[] eCPointArr) {
        this.preComp = eCPointArr;
    }

    public void setPreCompNeg(ECPoint[] eCPointArr) {
        this.preCompNeg = eCPointArr;
    }

    public void setTwiceP(ECPoint eCPoint) {
        this.twiceP = eCPoint;
    }
}
