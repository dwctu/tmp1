package com.broadcom.bt.util.bmsg;

/* loaded from: classes.dex */
public class BMessageBodyContent extends BMessageBase {
    private static final String TAG = "BMessageBodyContent";
    private BMessageBody mMsgBody;
    private BMessageBodyContent mPreviousBodyContent;

    public BMessageBodyContent(BMessageBody bMessageBody, int i) {
        this.mMsgBody = bMessageBody;
        setNativeRef(i);
    }

    public void addMessageContent(String str) {
        if (isNativeCreated()) {
            BMessageManager.addBContMsg(this.mNativeObjectRef, str);
        }
    }

    public void addSubject(String str) {
    }

    public String getFirstMessageContent() {
        if (isNativeCreated()) {
            return BMessageManager.getBCont1stMsg(this.mNativeObjectRef);
        }
        return null;
    }

    public BMessageBodyContent getNextContent() {
        int bContNext;
        if (!isNativeCreated() || (bContNext = BMessageManager.getBContNext(this.mNativeObjectRef)) <= 0) {
            return null;
        }
        return new BMessageBodyContent(this, bContNext);
    }

    public String getNextMessageContent() {
        if (isNativeCreated()) {
            return BMessageManager.getBContNextMsg(this.mNativeObjectRef);
        }
        return null;
    }

    public String getSubject() {
        return "";
    }

    private BMessageBodyContent(BMessageBodyContent bMessageBodyContent, int i) {
        this(bMessageBodyContent.mMsgBody, i);
        this.mPreviousBodyContent = bMessageBodyContent;
    }
}
