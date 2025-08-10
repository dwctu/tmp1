package com.wear.bean.socketio.videoPattern;

import com.wear.bean.socketio.chatBase.BaseAckRequestBean;
import java.util.List;

/* loaded from: classes3.dex */
public class MPHeartbeatRequest extends BaseAckRequestBean {
    private String colaId;
    private List<ToyInfo> toys;

    public static class ToyInfo {
        private boolean connect;
        private String toyType;
        private String toyVersion;

        public boolean getConnect() {
            return this.connect;
        }

        public String getToyType() {
            return this.toyType;
        }

        public String getToyVersion() {
            return this.toyVersion;
        }

        public void setConnect(boolean z) {
            this.connect = z;
        }

        public void setToyType(String str) {
            this.toyType = str;
        }

        public void setToyVersion(String str) {
            this.toyVersion = str;
        }
    }

    @Override // com.wear.bean.socketio.chatBase.BaseAckRequestBean, dc.pf2
    public String getAction() {
        return "mp_response_from_js_heartbeat_ts";
    }

    public String getColaId() {
        return this.colaId;
    }

    public List<ToyInfo> getToys() {
        return this.toys;
    }

    public void setColaId(String str) {
        this.colaId = str;
    }

    public void setToys(List<ToyInfo> list) {
        this.toys = list;
    }
}
