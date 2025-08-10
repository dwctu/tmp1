package com.broadcom.bt.util.bmsg;

/* loaded from: classes.dex */
public class BMessageVCardProperty extends BMessageBase {
    private BMessageVCard mParent;
    private BMessageVCardProperty mPreviousProp;

    public BMessageVCardProperty(BMessageVCard bMessageVCard, int i) {
        this.mParent = bMessageVCard;
        setNativeRef(i);
    }

    public BMessageVCardProperty getNextProperty() {
        int bvCardPropNext;
        if (!isNativeCreated() || (bvCardPropNext = BMessageManager.getBvCardPropNext(this.mNativeObjectRef)) <= 0) {
            return null;
        }
        return new BMessageVCardProperty(this, bvCardPropNext);
    }

    public String getParam() {
        if (isNativeCreated()) {
            return BMessageManager.getBvCardPropParam(this.mNativeObjectRef);
        }
        return null;
    }

    public String getValue() {
        if (isNativeCreated()) {
            return BMessageManager.getBvCardPropVal(this.mNativeObjectRef);
        }
        return null;
    }

    private BMessageVCardProperty(BMessageVCardProperty bMessageVCardProperty, int i) {
        this(bMessageVCardProperty.mParent, i);
        this.mPreviousProp = bMessageVCardProperty;
    }
}
