package com.wear.bean;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class RangeBean implements Serializable {
    private Integer maxv;
    private Integer minv;

    public Integer getMaxv() {
        return this.maxv;
    }

    public Integer getMinv() {
        return this.minv;
    }

    public void setMaxv(Integer num) {
        this.maxv = num;
    }

    public void setMinv(Integer num) {
        this.minv = num;
    }
}
