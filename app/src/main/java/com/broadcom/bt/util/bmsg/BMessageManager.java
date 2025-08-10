package com.broadcom.bt.util.bmsg;

/* loaded from: classes.dex */
public final class BMessageManager {
    public static final boolean ERR_CHECK = true;

    static {
        System.loadLibrary("bt-client-api");
    }

    public static native int addBBodyCont(int i);

    public static native void addBContMsg(int i, String str);

    public static native int addBEnvBody(int i);

    public static native int addBEnvChld(int i);

    public static native int addBEnvRecip(int i);

    public static native int addBMsgEnv(int i);

    public static native int addBMsgOrig(int i);

    public static native int addBvCardProp(int i, byte b, String str, String str2);

    public static native int createBMsg();

    public static native String decodeSMSSubmitPDU(String str);

    public static native void deleteBMsg(int i);

    public static native String encodeSMSDeliverPDU(String str, String str2, String str3, String str4);

    public static native byte getBBodyCharset(int i);

    public static native int getBBodyCont(int i);

    public static native byte getBBodyEnc(int i);

    public static native byte getBBodyLang(int i);

    public static native int getBBodyPartId(int i);

    public static native String getBCont1stMsg(int i);

    public static native int getBContNext(int i);

    public static native String getBContNextMsg(int i);

    public static native int getBEnvBody(int i);

    public static native int getBEnvChld(int i);

    public static native int getBEnvRecip(int i);

    public static native int getBMsgEnv(int i);

    public static native String getBMsgFldr(int i);

    public static native byte getBMsgMType(int i);

    public static native int getBMsgOrig(int i);

    public static native int getBvCardNext(int i);

    public static native int getBvCardProp(int i, byte b);

    public static native int getBvCardPropNext(int i);

    public static native String getBvCardPropParam(int i);

    public static native String getBvCardPropVal(int i);

    public static native byte getBvCardVer(int i);

    public static boolean hasBitError(int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 <= i2 - 1; i4++) {
            if (((1 << i4) & i) > 0) {
                if (i3 == 1) {
                    return true;
                }
                i3++;
            }
        }
        return i3 != 1;
    }

    public static native boolean isBBodyMultiP(int i);

    public static native boolean isBMsgRd(int i);

    public static native int parseBMsgFile(String str);

    public static native int parseBMsgFileFD(int i);

    public static native void setBBodyCharset(int i, byte b);

    public static native void setBBodyEnc(int i, byte b);

    public static native void setBBodyLang(int i, byte b);

    public static native void setBBodyPartId(int i, int i2);

    public static native void setBMsgFldr(int i, String str);

    public static native void setBMsgMType(int i, byte b);

    public static native void setBMsgRd(int i, boolean z);

    public static native void setBvCardVer(int i, byte b);

    public static native boolean writeBMsgFile(int i, String str);

    public static native boolean writeBMsgFileFD(int i, int i2);
}
