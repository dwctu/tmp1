package com.wear.bean.socketio.videoPattern;

import com.wear.bean.socketio.msg.ApiClassAnnotation;
import dc.rf2;
import java.util.List;

@ApiClassAnnotation(cls = String.class)
/* loaded from: classes3.dex */
public class ModifyPatternResultDTORequest implements rf2 {
    private String ackId;
    private boolean result;
    private List<String> toys;
    private String videoId;

    public String getAckId() {
        return this.ackId;
    }

    @Override // dc.pf2
    public String getAction() {
        return "ModifyPatternResultDTO";
    }

    @Override // dc.rf2
    public String getBeanAckId() {
        return getAckId();
    }

    public List<String> getToys() {
        return this.toys;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public boolean isResult() {
        return this.result;
    }

    public void setAckId(String str) {
        this.ackId = str;
    }

    public void setResult(boolean z) {
        this.result = z;
    }

    public void setToys(List<String> list) {
        this.toys = list;
    }

    public void setVideoId(String str) {
        this.videoId = str;
    }
}
