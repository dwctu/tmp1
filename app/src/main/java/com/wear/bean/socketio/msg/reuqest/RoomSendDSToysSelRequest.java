package com.wear.bean.socketio.msg.reuqest;

import com.wear.bean.socketio.msg.ApiClassAnnotation;
import com.wear.bean.socketio.msg.response.DSMultiToySelectChangeResponse;
import java.util.List;

@ApiClassAnnotation(cls = String.class)
/* loaded from: classes3.dex */
public class RoomSendDSToysSelRequest extends BaseGroupControlRequest {
    private List<DSMultiToySelectChangeResponse.BallSelectBean> listBalls;

    @Override // com.wear.bean.socketio.msg.reuqest.BaseGroupControlRequest, com.wear.bean.socketio.BaseRequestBean, dc.pf2
    public String getAction() {
        return "MULTI_TOYS_CHANGE_TOY_FUN";
    }

    public List<DSMultiToySelectChangeResponse.BallSelectBean> getListBalls() {
        return this.listBalls;
    }

    public void setListBalls(List<DSMultiToySelectChangeResponse.BallSelectBean> list) {
        this.listBalls = list;
    }
}
