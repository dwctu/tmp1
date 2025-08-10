package com.wear.bean.socketio.msg.response;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public class DSMultiToySelectChangeResponse implements Serializable {
    private Object ackId;
    private List<BallSelectBean> listBalls;
    private String roomId;

    public static class BallSelectBean implements Serializable {
        private String deviceId;
        private String fun;
        private int isSelect;

        public BallSelectBean() {
        }

        public String getDeviceId() {
            return this.deviceId;
        }

        public String getFun() {
            return this.fun;
        }

        public int getIsSelect() {
            return this.isSelect;
        }

        public void setDeviceId(String str) {
            this.deviceId = str;
        }

        public void setFun(String str) {
            this.fun = str;
        }

        public void setIsSelect(int i) {
            this.isSelect = i;
        }

        public BallSelectBean(String str, String str2, int i) {
            this.deviceId = str;
            this.fun = str2;
            this.isSelect = i;
        }
    }

    public Object getAckId() {
        return this.ackId;
    }

    public List<BallSelectBean> getListBalls() {
        return this.listBalls;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public void setAckId(Object obj) {
        this.ackId = obj;
    }

    public void setListBalls(List<BallSelectBean> list) {
        this.listBalls = list;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }
}
