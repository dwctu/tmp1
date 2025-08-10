package com.broadcom.bt.util.bmsg;

/* loaded from: classes.dex */
public class BMessageEnvelope extends BMessageBase {
    private static final String TAG = "BMessageEnvelope";
    private BMessage mBMsg;
    private BMessageEnvelope mBMsgEnvParent;

    public BMessageEnvelope(BMessage bMessage, int i) {
        this.mBMsg = bMessage;
        setNativeRef(i);
    }

    public BMessageBody addBody() {
        int iAddBEnvBody;
        if (!isNativeCreated() || (iAddBEnvBody = BMessageManager.addBEnvBody(this.mNativeObjectRef)) <= 0) {
            return null;
        }
        return new BMessageBody(this, iAddBEnvBody);
    }

    public BMessageEnvelope addChildEnvelope() {
        int iAddBEnvChld;
        if (!isNativeCreated() || (iAddBEnvChld = BMessageManager.addBEnvChld(this.mNativeObjectRef)) <= 0) {
            return null;
        }
        return new BMessageEnvelope(this, iAddBEnvChld);
    }

    public BMessageVCard addRecipient() {
        int iAddBEnvRecip;
        if (!isNativeCreated() || (iAddBEnvRecip = BMessageManager.addBEnvRecip(this.mNativeObjectRef)) <= 0) {
            return null;
        }
        return new BMessageVCard(this, iAddBEnvRecip);
    }

    public BMessageBody getBody() {
        int bEnvBody;
        if (!isNativeCreated() || (bEnvBody = BMessageManager.getBEnvBody(this.mNativeObjectRef)) <= 0) {
            return null;
        }
        return new BMessageBody(this, bEnvBody);
    }

    public BMessageEnvelope getChildEnvelope() {
        int bEnvChld;
        if (!isNativeCreated() || (bEnvChld = BMessageManager.getBEnvChld(this.mNativeObjectRef)) <= 0) {
            return null;
        }
        return new BMessageEnvelope(this, bEnvChld);
    }

    public BMessageVCard getRecipient() {
        int bEnvRecip;
        if (!isNativeCreated() || (bEnvRecip = BMessageManager.getBEnvRecip(this.mNativeObjectRef)) <= 0) {
            return null;
        }
        return new BMessageVCard(this, bEnvRecip);
    }

    private BMessageEnvelope(BMessageEnvelope bMessageEnvelope, int i) {
        this(bMessageEnvelope.mBMsg, i);
        this.mBMsgEnvParent = bMessageEnvelope;
    }
}
