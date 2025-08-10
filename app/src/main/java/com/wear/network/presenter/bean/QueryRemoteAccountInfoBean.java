package com.wear.network.presenter.bean;

import java.util.List;

/* loaded from: classes3.dex */
public class QueryRemoteAccountInfoBean {
    private int code;
    private DataBean data;
    private String message;
    private boolean result;

    public static class DataBean {
        private List<ListBean> list;

        public static class ListBean {
            private String email;
            private String remoteAccountId;

            public String getEmail() {
                return this.email;
            }

            public String getRemoteAccountId() {
                return this.remoteAccountId;
            }

            public void setEmail(String str) {
                this.email = str;
            }

            public void setRemoteAccountId(String str) {
                this.remoteAccountId = str;
            }
        }

        public List<ListBean> getList() {
            return this.list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }
    }

    public int getCode() {
        return this.code;
    }

    public DataBean getData() {
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

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResult(boolean z) {
        this.result = z;
    }
}
