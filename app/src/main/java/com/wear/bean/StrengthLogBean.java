package com.wear.bean;

import java.util.List;

/* loaded from: classes3.dex */
public class StrengthLogBean {
    private List<DataBean> data;

    public static class DataBean {
        private String toyDeviceType;
        private List<int[]> toy_strength_range;

        public String getToyDeviceType() {
            return this.toyDeviceType;
        }

        public List<int[]> getToy_strength_range() {
            return this.toy_strength_range;
        }

        public void setToyDeviceType(String str) {
            this.toyDeviceType = str;
        }

        public void setToy_strength_range(List<int[]> list) {
            this.toy_strength_range = list;
        }
    }

    public List<DataBean> getData() {
        return this.data;
    }

    public void setData(List<DataBean> list) {
        this.data = list;
    }
}
