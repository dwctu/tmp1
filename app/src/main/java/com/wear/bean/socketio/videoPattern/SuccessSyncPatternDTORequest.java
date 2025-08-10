package com.wear.bean.socketio.videoPattern;

import com.wear.bean.socketio.msg.ApiClassAnnotation;
import dc.rf2;
import java.util.List;

@ApiClassAnnotation(cls = String.class)
/* loaded from: classes3.dex */
public class SuccessSyncPatternDTORequest implements rf2 {
    private String ackId;
    private List<String> toys;

    public String getAckId() {
        return this.ackId;
    }

    @Override // dc.pf2
    public String getAction() {
        return "SuccessSyncPatternDTO";
    }

    @Override // dc.rf2
    public String getBeanAckId() {
        return getAckId();
    }

    public List<String> getToys() {
        return this.toys;
    }

    public void setAckId(String str) {
        this.ackId = str;
    }

    public void setToys(List<String> list) {
        this.toys = list;
    }
}
