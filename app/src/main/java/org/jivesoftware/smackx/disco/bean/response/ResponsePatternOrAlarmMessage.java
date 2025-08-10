package org.jivesoftware.smackx.disco.bean.response;

import java.util.List;
import java.util.Objects;

/* loaded from: classes5.dex */
public class ResponsePatternOrAlarmMessage extends BaseResponse {
    private List<DataBean> data;

    public static class DataBean {
        private long createTime;
        private String jid;
        private String nickname;
        private String photo;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            DataBean dataBean = (DataBean) obj;
            return this.createTime == dataBean.createTime && Objects.equals(this.photo, dataBean.photo) && Objects.equals(this.nickname, dataBean.nickname) && Objects.equals(this.jid, dataBean.jid);
        }

        public long getCreateTime() {
            return this.createTime;
        }

        public String getJid() {
            return this.jid;
        }

        public String getNickname() {
            return this.nickname;
        }

        public String getPhoto() {
            return this.photo;
        }

        public int hashCode() {
            return Objects.hash(this.photo, this.nickname, this.jid, Long.valueOf(this.createTime));
        }

        public void setCreateTime(long j) {
            this.createTime = j;
        }

        public void setJid(String str) {
            this.jid = str;
        }

        public void setNickname(String str) {
            this.nickname = str;
        }

        public void setPhoto(String str) {
            this.photo = str;
        }
    }

    public List<DataBean> getData() {
        return this.data;
    }

    public void setData(List<DataBean> list) {
        this.data = list;
    }
}
