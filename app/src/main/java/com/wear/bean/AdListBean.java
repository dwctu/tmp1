package com.wear.bean;

import java.util.List;

/* loaded from: classes3.dex */
public class AdListBean {
    private int code;
    private List<DataBean> data;
    private String message;
    private boolean result;

    public static class DataBean {
        private String command;
        private String id;
        private long showRank;
        private SourceBean source;

        public static class SourceBean {
            private String dark;
            private String light;

            public String getDark() {
                return this.dark;
            }

            public String getLight() {
                return this.light;
            }

            public void setDark(String str) {
                this.dark = str;
            }

            public void setLight(String str) {
                this.light = str;
            }
        }

        public String getCommand() {
            return this.command;
        }

        public String getId() {
            return this.id;
        }

        public long getShowRank() {
            return this.showRank;
        }

        public SourceBean getSource() {
            return this.source;
        }

        public void setCommand(String str) {
            this.command = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setShowRank(long j) {
            this.showRank = j;
        }

        public void setSource(SourceBean sourceBean) {
            this.source = sourceBean;
        }
    }

    public int getCode() {
        return this.code;
    }

    public List<DataBean> getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isResult() {
        return this.result;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(List<DataBean> list) {
        this.data = list;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResult(boolean z) {
        this.result = z;
    }
}
