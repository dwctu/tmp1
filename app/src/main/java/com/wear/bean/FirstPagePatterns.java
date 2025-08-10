package com.wear.bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class FirstPagePatterns {
    private List<Pattern> patterns = new ArrayList();
    private Long minDate = null;
    private Long maxDate = null;
    private Long likeCountMax = null;
    private Long likeCountMin = null;

    public Long getLikeCountMax() {
        return this.likeCountMax;
    }

    public Long getLikeCountMin() {
        return this.likeCountMin;
    }

    public Long getMaxDate() {
        return this.maxDate;
    }

    public Long getMinDate() {
        return this.minDate;
    }

    public List<Pattern> getPatterns() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.patterns);
        return arrayList;
    }

    public void setLikeCountMax(Long l) {
        this.likeCountMax = l;
    }

    public void setLikeCountMin(Long l) {
        this.likeCountMin = l;
    }

    public void setMaxDate(Long l) {
        this.maxDate = l;
    }

    public void setMinDate(Long l) {
        this.minDate = l;
    }

    public void setPatterns(List<Pattern> list) {
        this.patterns.addAll(list);
    }
}
