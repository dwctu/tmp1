package com.wear.bean;

/* loaded from: classes3.dex */
public class AnalyticsBean {
    public boolean usedSliderPannel = true;
    public boolean usedTouchPannel = true;
    public boolean isSlider = false;

    public String getEvenString() {
        return this.isSlider ? "usedSliderPannel" : "usedTouchPannel";
    }
}
