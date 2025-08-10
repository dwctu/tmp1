package org.jivesoftware.smackx.disco.bean.response;

/* loaded from: classes5.dex */
public class ResponseBroad extends BaseResponse {
    private BroadDataBean data;
    private int type;

    public BroadDataBean getData() {
        return this.data;
    }

    public int getType() {
        return this.type;
    }

    public void setData(BroadDataBean broadDataBean) {
        this.data = broadDataBean;
    }

    public void setType(int i) {
        this.type = i;
    }
}
