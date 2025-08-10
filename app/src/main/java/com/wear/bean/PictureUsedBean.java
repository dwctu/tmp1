package com.wear.bean;

/* loaded from: classes3.dex */
public class PictureUsedBean {
    private boolean isHidden;
    private boolean isShowCode;
    private boolean isShowRecall;
    private int usedName;
    private int userImg;

    public int getUsedName() {
        return this.usedName;
    }

    public int getUserImg() {
        return this.userImg;
    }

    public boolean isHidden() {
        return this.isHidden;
    }

    public boolean isShowCode() {
        return this.isShowCode;
    }

    public boolean isShowRecall() {
        return this.isShowRecall;
    }

    public void setHidden(boolean z) {
        this.isHidden = z;
    }

    public void setShowCode(boolean z) {
        this.isShowCode = z;
    }

    public void setShowRecall(boolean z) {
        this.isShowRecall = z;
    }

    public void setUsedName(int i) {
        this.usedName = i;
    }

    public void setUserImg(int i) {
        this.userImg = i;
    }
}
