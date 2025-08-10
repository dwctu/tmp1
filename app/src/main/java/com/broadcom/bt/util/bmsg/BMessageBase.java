package com.broadcom.bt.util.bmsg;

/* loaded from: classes.dex */
public abstract class BMessageBase {
    public int mNativeObjectRef;

    public void clearNativeRef() {
        this.mNativeObjectRef = 0;
    }

    public boolean isNativeCreated() {
        return this.mNativeObjectRef > 0;
    }

    public boolean setNativeRef(int i) {
        if (i <= 0) {
            return false;
        }
        this.mNativeObjectRef = i;
        return true;
    }
}
