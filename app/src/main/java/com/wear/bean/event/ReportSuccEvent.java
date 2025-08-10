package com.wear.bean.event;

/* loaded from: classes3.dex */
public class ReportSuccEvent {
    public boolean isHidePattern;
    public String isShowReview;
    public String patternId;
    public String status;

    public boolean getIsHidePattern() {
        return this.isHidePattern;
    }

    public String getIsShowReview() {
        return this.isShowReview;
    }

    public String getPatternId() {
        return this.patternId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setIsHidePattern(boolean z) {
        this.isHidePattern = z;
    }

    public void setIsShowReview(String str) {
        this.isShowReview = str;
    }

    public void setPatternId(String str) {
        this.patternId = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
