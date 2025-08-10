package com.broadcom.bt.util.bmsg;

/* loaded from: classes.dex */
public class BMessageBody extends BMessageBase {
    private static final boolean ERR_CHECK = true;
    private static final String TAG = "BMessageBody";
    private BMessageEnvelope mParent;

    public BMessageBody(BMessageEnvelope bMessageEnvelope, int i) {
        this.mParent = bMessageEnvelope;
        setNativeRef(i);
    }

    public BMessageBodyContent addContent() {
        int iAddBBodyCont;
        if (!isNativeCreated() || (iAddBBodyCont = BMessageManager.addBBodyCont(this.mNativeObjectRef)) <= 0) {
            return null;
        }
        return new BMessageBodyContent(this, iAddBBodyCont);
    }

    public byte getCharSet() {
        if (isNativeCreated()) {
            return BMessageManager.getBBodyCharset(this.mNativeObjectRef);
        }
        return (byte) 2;
    }

    public BMessageBodyContent getContent() {
        int bBodyCont;
        if (!isNativeCreated() || (bBodyCont = BMessageManager.getBBodyCont(this.mNativeObjectRef)) <= 0) {
            return null;
        }
        return new BMessageBodyContent(this, bBodyCont);
    }

    public byte getEncoding() {
        if (isNativeCreated()) {
            return BMessageManager.getBBodyEnc(this.mNativeObjectRef);
        }
        return (byte) 14;
    }

    public byte getLanguage() {
        if (isNativeCreated()) {
            return BMessageManager.getBBodyLang(this.mNativeObjectRef);
        }
        return (byte) 1;
    }

    public int getPartId() {
        if (isNativeCreated()) {
            return BMessageManager.getBBodyPartId(this.mNativeObjectRef);
        }
        return Integer.MIN_VALUE;
    }

    public boolean isMultipart() {
        if (isNativeCreated()) {
            return false;
        }
        return BMessageManager.isBBodyMultiP(this.mNativeObjectRef);
    }

    public void setCharSet(byte b) {
        if (b >= 0 && b <= 1) {
            BMessageManager.setBBodyCharset(this.mNativeObjectRef, b);
            return;
        }
        String str = "Invalid charset: " + ((int) b);
    }

    public void setEncoding(byte b) {
        if (b >= 0 && b < 14) {
            BMessageManager.setBBodyEnc(this.mNativeObjectRef, b);
            return;
        }
        String str = "Invalid encoding: " + ((int) b);
    }

    public void setLanguage(byte b) {
        if (b == 0 || (b >= 2 && b <= 10)) {
            BMessageManager.setBBodyLang(this.mNativeObjectRef, b);
            return;
        }
        String str = "Invalid language: " + ((int) b);
    }

    public void setPartId(int i) {
        if (isNativeCreated()) {
            BMessageManager.setBBodyPartId(this.mNativeObjectRef, i);
        }
    }
}
