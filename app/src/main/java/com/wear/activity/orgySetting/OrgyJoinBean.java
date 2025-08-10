package com.wear.activity.orgySetting;

/* loaded from: classes3.dex */
public class OrgyJoinBean {
    private Integer code;
    private Data data;
    private String message;
    private Boolean result;

    public static class Data {
        private String joinId;
        private String joinStatus;

        public String getJoinId() {
            return this.joinId;
        }

        public String getJoinStatus() {
            return this.joinStatus;
        }

        public void setJoinId(String str) {
            this.joinId = str;
        }

        public void setJoinStatus(String str) {
            this.joinStatus = str;
        }
    }

    public Integer getCode() {
        return this.code;
    }

    public Data getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public Boolean isResult() {
        return this.result;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResult(Boolean bool) {
        this.result = bool;
    }
}
