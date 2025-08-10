package com.broadcom.bt.util.bmsg;

/* loaded from: classes.dex */
public class BMessageVCard extends BMessageBase {
    private static final boolean ERR_CHECK = true;
    private static final String TAG = "BMessageVCard";
    private BMessageBase mParent;
    private BMessageVCard mPreviousVCard;

    public BMessageVCard(BMessageBase bMessageBase, int i) {
        this.mParent = bMessageBase;
        setNativeRef(i);
    }

    public BMessageVCardProperty addProperty(byte b, String str, String str2) {
        if (!isNativeCreated()) {
            return null;
        }
        if (b >= 0 && b <= 3) {
            int iAddBvCardProp = BMessageManager.addBvCardProp(this.mNativeObjectRef, b, str, str2);
            if (iAddBvCardProp > 0) {
                return new BMessageVCardProperty(this, iAddBvCardProp);
            }
            return null;
        }
        String str3 = "Invalid vCard property: " + ((int) b);
        return null;
    }

    public BMessageVCard getNextvCard() {
        int bvCardNext;
        if (!isNativeCreated() || (bvCardNext = BMessageManager.getBvCardNext(this.mNativeObjectRef)) <= 0) {
            return null;
        }
        return new BMessageVCard(this, bvCardNext);
    }

    public BMessageVCardProperty getProperty(byte b) {
        if (!isNativeCreated()) {
            return null;
        }
        if (b >= 0 && b <= 3) {
            int bvCardProp = BMessageManager.getBvCardProp(this.mNativeObjectRef, b);
            if (bvCardProp > 0) {
                return new BMessageVCardProperty(this, bvCardProp);
            }
            return null;
        }
        String str = "Invalid vCard property: " + ((int) b);
        return null;
    }

    public byte getVersion() {
        if (isNativeCreated()) {
            return BMessageManager.getBvCardVer(this.mNativeObjectRef);
        }
        return (byte) -1;
    }

    public void setVersion(byte b) {
        if (isNativeCreated()) {
            BMessageManager.setBvCardVer(this.mNativeObjectRef, b);
        }
    }

    private BMessageVCard(BMessageVCard bMessageVCard, int i) {
        this(bMessageVCard.mParent, i);
        this.mPreviousVCard = bMessageVCard;
    }
}
