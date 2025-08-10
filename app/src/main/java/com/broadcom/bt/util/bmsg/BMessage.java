package com.broadcom.bt.util.bmsg;

import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class BMessage extends BMessageBase {
    private static final boolean ERR_CHECK = true;
    private static final String TAG = "BMessage";

    public BMessage() throws IOException {
        if (!setNativeRef(BMessageManager.createBMsg())) {
            throw new IOException("Unable to create BMesage object");
        }
    }

    public static BMessage parse(File file) {
        if (file.exists() && file.isFile()) {
            int bMsgFile = BMessageManager.parseBMsgFile(file.getAbsolutePath());
            if (bMsgFile > 0) {
                return new BMessage(bMsgFile);
            }
            return null;
        }
        String str = "Unable to parse " + file.getAbsolutePath() + ". Invalid file.";
        return null;
    }

    public BMessageEnvelope addEnvelope() {
        int iAddBMsgEnv = BMessageManager.addBMsgEnv(this.mNativeObjectRef);
        if (iAddBMsgEnv <= 0) {
            return null;
        }
        return new BMessageEnvelope(this, iAddBMsgEnv);
    }

    public BMessageVCard addOriginator() {
        int iAddBMsgOrig = BMessageManager.addBMsgOrig(this.mNativeObjectRef);
        if (iAddBMsgOrig <= 0) {
            return null;
        }
        return new BMessageVCard(this, iAddBMsgOrig);
    }

    public String decodeSMSSubmitPDU(String str) {
        return BMessageManager.decodeSMSSubmitPDU(str);
    }

    public String encodeSMSDeliverPDU(String str, String str2, String str3, String str4) {
        return BMessageManager.encodeSMSDeliverPDU(str, str2, str3, str4);
    }

    public void finalize() {
        finish();
    }

    public void finish() {
        if (isNativeCreated()) {
            BMessageManager.deleteBMsg(this.mNativeObjectRef);
            clearNativeRef();
        }
    }

    public BMessageEnvelope getEnvelope() {
        int bMsgEnv = BMessageManager.getBMsgEnv(this.mNativeObjectRef);
        if (bMsgEnv <= 0) {
            return null;
        }
        return new BMessageEnvelope(this, bMsgEnv);
    }

    public String getFolder() {
        return BMessageManager.getBMsgFldr(this.mNativeObjectRef);
    }

    public byte getMessageType() {
        return BMessageManager.getBMsgMType(this.mNativeObjectRef);
    }

    public BMessageVCard getOriginator() {
        int bMsgOrig = BMessageManager.getBMsgOrig(this.mNativeObjectRef);
        if (bMsgOrig <= 0) {
            return null;
        }
        return new BMessageVCard(this, bMsgOrig);
    }

    public boolean isRead() {
        return BMessageManager.isBMsgRd(this.mNativeObjectRef);
    }

    public void setFolder(String str) {
        BMessageManager.setBMsgFldr(this.mNativeObjectRef, str);
    }

    public void setMessageType(byte b) {
        if (!BMessageManager.hasBitError(b, 4)) {
            BMessageManager.setBMsgMType(this.mNativeObjectRef, b);
            return;
        }
        String str = "Invalid message type: " + ((int) b);
    }

    public void setReadStatus(boolean z) {
        BMessageManager.setBMsgRd(this.mNativeObjectRef, z);
    }

    public boolean write(int i) {
        if (i > 0) {
            return BMessageManager.writeBMsgFileFD(this.mNativeObjectRef, i);
        }
        String str = "Unable to write bmessage to file descriptor " + i;
        return false;
    }

    public boolean write(File file) {
        if (file.exists()) {
            String str = "Unable to write to " + file.getAbsolutePath() + ". File already exists.";
            return false;
        }
        return BMessageManager.writeBMsgFile(this.mNativeObjectRef, file.getAbsolutePath());
    }

    public BMessage(int i) {
        setNativeRef(i);
    }

    public static BMessage parse(int i) {
        int bMsgFileFD = BMessageManager.parseBMsgFileFD(i);
        if (bMsgFileFD > 0) {
            return new BMessage(bMsgFileFD);
        }
        return null;
    }
}
