package com.wear.activity.orgySetting;

import com.lovense.wear.R;
import dc.ah4;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class OrgySettingEvent {
    private boolean canMark;
    private int fixedBtnEntrance;
    private String fixedBtnImg;
    private String fixedBtnTitle;
    private boolean showBanner;
    private int showJoinBtn;
    private long showTime;
    private int startOrEnd;
    private String timer;
    private String title;

    public OrgySettingEvent() {
        this.startOrEnd = 0;
    }

    public int getFixedBtnEntrance() {
        return this.fixedBtnEntrance;
    }

    public String getFixedBtnImg() {
        return this.fixedBtnImg;
    }

    public String getFixedBtnTitle() {
        return this.fixedBtnTitle;
    }

    public int getShowJoinBtn() {
        return this.showJoinBtn;
    }

    public long getShowTime() {
        return this.showTime;
    }

    public int getStartOrEnd() {
        return this.startOrEnd;
    }

    public String getTimer() {
        return this.timer;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isCanMark() {
        return this.canMark;
    }

    public boolean isShowBanner() {
        return this.showBanner;
    }

    public void postEvent() {
        this.timer = "";
        long j = this.showTime;
        if (j > 0) {
            long jCurrentTimeMillis = j - System.currentTimeMillis();
            if (jCurrentTimeMillis >= 0) {
                int iCeil = (int) Math.ceil(jCurrentTimeMillis / 86400000);
                if (iCeil >= 1) {
                    this.timer = String.valueOf(iCeil) + " " + ah4.e(R.string.event_day_in_banner);
                } else {
                    long j2 = jCurrentTimeMillis % 86400000;
                    int i = (int) (j2 / 3600000);
                    int i2 = (int) ((j2 % 3600000) / 60000);
                    if (i == 0 && i2 == 0) {
                        i2 = 1;
                    }
                    this.timer = String.format(ah4.e(R.string.orgy_event_timer_format), String.valueOf(i), String.valueOf(i2));
                }
            } else {
                this.timer = String.format(ah4.e(R.string.orgy_event_timer_format), String.valueOf(0), String.valueOf(1));
            }
        }
        EventBus.getDefault().post(this);
    }

    public void setCanMark(boolean z) {
        this.canMark = z;
    }

    public void setFixedBtn(int i, String str, String str2) {
        this.fixedBtnEntrance = i;
        this.fixedBtnImg = str;
        this.fixedBtnTitle = str2;
    }

    public void setFixedBtnEntrance(int i) {
        this.fixedBtnEntrance = i;
    }

    public void setFixedBtnImg(String str) {
        this.fixedBtnImg = str;
    }

    public void setFixedBtnTitle(String str) {
        this.fixedBtnTitle = str;
    }

    public void setShowBanner(boolean z) {
        this.showBanner = z;
    }

    public void setShowJoinBtn(int i) {
        this.showJoinBtn = i;
    }

    public void setShowTime(long j) {
        this.showTime = j;
    }

    public void setStartOrEnd(int i) {
        this.startOrEnd = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public OrgySettingEvent(String str, long j, int i, boolean z, boolean z2, int i2) {
        this.startOrEnd = 0;
        this.showTime = j;
        this.title = str;
        this.startOrEnd = i;
        this.showBanner = z;
        this.canMark = z2;
        this.showJoinBtn = i2;
    }
}
