package com.wear.bean.socketio.controlLink.response;

import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.protocol.controlLink.ControlLinkCommunMessage;
import java.util.List;

/* loaded from: classes3.dex */
public class GetNewMessageACKResponse extends BaseResponseBean {
    private List<ControlLinkCommunMessage> list;
    private int listCount;

    public List<ControlLinkCommunMessage> getList() {
        return this.list;
    }

    public int getListCount() {
        return this.listCount;
    }

    public void setList(List<ControlLinkCommunMessage> list) {
        this.list = list;
    }

    public void setListCount(int i) {
        this.listCount = i;
    }
}
