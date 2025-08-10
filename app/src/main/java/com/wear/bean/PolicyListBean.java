package com.wear.bean;

import java.util.List;

/* loaded from: classes3.dex */
public class PolicyListBean {
    private int code;
    private List<DataDTO> data;
    private String message;
    private boolean result;

    public static class DataDTO {
        private String policyType;
        private String url;

        public String getPolicyType() {
            return this.policyType;
        }

        public String getUrl() {
            return this.url;
        }

        public void setPolicyType(String str) {
            this.policyType = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public Integer getCode() {
        return Integer.valueOf(this.code);
    }

    public List<DataDTO> getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public Boolean isResult() {
        return Boolean.valueOf(this.result);
    }

    public void setCode(Integer num) {
        this.code = num.intValue();
    }

    public void setData(List<DataDTO> list) {
        this.data = list;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResult(Boolean bool) {
        this.result = bool.booleanValue();
    }
}
