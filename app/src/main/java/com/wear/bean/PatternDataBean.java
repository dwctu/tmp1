package com.wear.bean;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public class PatternDataBean implements Serializable {
    private List<Pattern> patternDatas;
    private boolean pullToRefresh;

    public PatternDataBean(List<Pattern> list, boolean z) {
        this.patternDatas = list;
        this.pullToRefresh = z;
    }

    public List<Pattern> getPatternDatas() {
        return this.patternDatas;
    }

    public boolean isPullToRefresh() {
        return this.pullToRefresh;
    }

    public void setPatternDatas(List<Pattern> list) {
        this.patternDatas = list;
    }

    public void setPullToRefresh(boolean z) {
        this.pullToRefresh = z;
    }
}
