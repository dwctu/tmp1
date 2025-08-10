package com.wear.bean;

import com.lovense.wear.R;
import dc.ah4;

/* loaded from: classes3.dex */
public class NotificationBean {
    public String body;
    public int soundType;
    public String title;

    public NotificationBean(String str, int i) {
        this.title = ah4.e(R.string.app_name);
        this.body = "";
        this.soundType = -1;
        this.body = str;
        this.soundType = i;
    }

    public String getBody() {
        return this.body;
    }

    public int getSoundType() {
        return this.soundType;
    }

    public String getTitle() {
        return this.title;
    }

    public NotificationBean(String str) {
        this.title = ah4.e(R.string.app_name);
        this.body = "";
        this.soundType = -1;
        this.body = str;
    }
}
