package com.wear.bean.event;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class VideoPatternControlEvent {
    public static final int DOWNLOAD_FILE = 1;
    public static final int PAUSE_CONTROL = 4;
    public static final int SYNC_CONTROL = 2;
    public static final int UNSYNC_CONTROL = 3;
    private boolean isSuccess;
    private Map params = new HashMap();
    private int type;

    public VideoPatternControlEvent(int i, boolean z) {
        this.type = i;
        this.isSuccess = z;
    }

    public Object getParam(String str) {
        return this.params.get(str);
    }

    public int getType() {
        return this.type;
    }

    public boolean hasParam(String str) {
        return this.params.containsKey(str);
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void putParam(String str, Object obj) {
        this.params.put(str, obj);
    }

    public void setSuccess(boolean z) {
        this.isSuccess = z;
    }

    public void setType(int i) {
        this.type = i;
    }
}
