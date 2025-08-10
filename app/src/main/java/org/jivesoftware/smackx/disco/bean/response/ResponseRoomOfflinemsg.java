package org.jivesoftware.smackx.disco.bean.response;

import java.util.List;

/* loaded from: classes5.dex */
public class ResponseRoomOfflinemsg extends BaseResponse {
    private List<DataBean> data;

    public static class DataBean {
        private String body;
        private long createTime;
        private String msgId;
        private int type;

        public String getBody() {
            return this.body;
        }

        public long getCreateTime() {
            return this.createTime;
        }

        public String getMsgId() {
            return this.msgId;
        }

        public int getType() {
            return this.type;
        }

        public void setBody(String str) {
            this.body = str;
        }

        public void setCreateTime(long j) {
            this.createTime = j;
        }

        public void setMsgId(String str) {
            this.msgId = str;
        }

        public void setType(int i) {
            this.type = i;
        }
    }

    public List<DataBean> getData() {
        return this.data;
    }

    public void setData(List<DataBean> list) {
        this.data = list;
    }
}
