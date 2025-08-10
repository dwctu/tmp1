package com.wear.bean.event;

import com.wear.bean.UpdateVersionBean;

/* loaded from: classes3.dex */
public class VersionUpdataEvent {
    public boolean isShowHotView;
    public UpdateVersionBean versionBean;

    public VersionUpdataEvent(UpdateVersionBean updateVersionBean, boolean z) {
        this.versionBean = updateVersionBean;
        this.isShowHotView = z;
    }
}
