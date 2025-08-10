package com.wear.bean;

import com.google.gson.internal.LinkedTreeMap;
import dc.db2;

/* loaded from: classes3.dex */
public class SyncWsProtocol {
    public static final String CONTROL_106_TYPE_KEY = "106";
    public static final String CONTROL_107_TYPE_KEY = "107";
    public static final String CONTROL_108_TYPE_KEY = "108";
    public static final String CONTROL_111_TYPE_JOIN_LAN = "111";
    public static final String CONTROL_112_TYPE_CODE_STATE_ANSWER_TOY = "112";
    public static final String CONTROL_116_TYPE_CODE_STATE_CHOOSE_TOY = "116";
    public static final String CONTROL_117_TYPE_CODE_STATE_CANCEL_SYNC = "117";
    public static final String CONTROL_118_TYPE_CODE_LAN_API_CREATE_WS = "118";
    public static final String CONTROL_119_TYPE_CODE_NOTICE_SERVICE_SID = "119";
    public static final String CONTROL_133_TYPE_CODE_WEB_TRAN_HTTP = "133";
    public static final String CONTROL_ACTIVITY_COMMAND_TYPE_KEY = "activityCommand";
    public static final String CONTROL_ACTIVITY_STOP_DISCORD = "stopDiscordActivity";
    public static final String CONTROL_ACTIVITY_TOY_NUM_TYPE_KEY = "activityToyNum";
    public static final String CONTROL_BEGIN_TYPE_KEY = "100";
    public static final String CONTROL_COMMAND_TYPE_KEY = "command";
    public static final String CONTROL_ENDSYNC_TOY_TYPE_KEY = "endsync";
    public static final String CONTROL_JUMP_TYPE_KEY = "103";
    public static final String CONTROL_LAN_API_COMMAND = "lanApiCommand";
    public static final String CONTROL_LAN_API_OFFLINE = "basicJsApiNotifyAppOffline";
    public static final String CONTROL_ORDER_TOY_TYPE_KEY = "order";
    public static final String CONTROL_SCAN_STARTSYNC_JOIN_C_TYPE_KEY = "110";
    public static final String CONTROL_STARTMOVE_TOY_TYPE_KEY = "startmove";
    public static final String CONTROL_STARTSYNC_JOIN_TYPE_KEY = "104";
    public static final String CONTROL_STARTSYNC_TOY_TYPE_KEY = "startsync";
    public static final String CONTROL_STOPMOVE_TOY_TYPE_KEY = "stopmove";
    public static final String CONTROL_SYNC_TOY_TYPE_KEY = "toysync";
    public static final String CONTROL_SYNC_TYPE_KEY = "101";
    public static final String CONTROL_TIME_LEFT_TYPE_KEY = "105";
    public static final String LAN_API_BIND_NOTICE = "lanApiBindNotice";
    public static final String LAN_API_UN_BIND_NOTICE = "lanApiUnBindNotice";
    private Object data;
    private String from;
    private String sid;
    private String type;

    public SyncWsProtocol() {
    }

    public DataBean getData() {
        Object obj = this.data;
        if (obj != null && ((LinkedTreeMap) obj).size() > 0) {
            LinkedTreeMap linkedTreeMap = (LinkedTreeMap) this.data;
            String str = (String) linkedTreeMap.get("type");
            DataBean dataBean = new DataBean((String) linkedTreeMap.get("t"), (String) linkedTreeMap.get("data"));
            dataBean.setType(str);
            String str2 = (String) linkedTreeMap.get("status");
            Object obj2 = linkedTreeMap.get("timeLeft");
            if (obj2 == null) {
                obj2 = linkedTreeMap.get("leftControlTime");
            }
            dataBean.setStatus(str2);
            dataBean.setTimeLeft(obj2);
            this.data = dataBean;
        }
        return (DataBean) this.data;
    }

    public DataBean getEntryData() {
        return (DataBean) this.data;
    }

    public String getFrom() {
        return this.from;
    }

    public String getSid() {
        return this.sid;
    }

    public String getType() {
        return this.type;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setSid(String str) {
        this.sid = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public SyncWsProtocol typeOrder() {
        ((DataBean) this.data).setType(CONTROL_ORDER_TOY_TYPE_KEY);
        return this;
    }

    public SyncWsProtocol typeStartmove() {
        ((DataBean) this.data).setType(CONTROL_STARTMOVE_TOY_TYPE_KEY);
        return this;
    }

    public SyncWsProtocol typeStartsync() {
        ((DataBean) this.data).setType(CONTROL_STARTSYNC_TOY_TYPE_KEY);
        return this;
    }

    public SyncWsProtocol typeState() {
        ((DataBean) this.data).setType(CONTROL_STARTSYNC_TOY_TYPE_KEY);
        return this;
    }

    public SyncWsProtocol typeStopmove() {
        ((DataBean) this.data).setType(CONTROL_STOPMOVE_TOY_TYPE_KEY);
        return this;
    }

    public SyncWsProtocol(int i) {
        this.type = CONTROL_SYNC_TYPE_KEY;
        this.from = db2.A().c;
        this.sid = db2.A().d;
        this.data = new DataBean(String.valueOf(i));
    }

    public static class DataBean {
        public static final String CONTROL_STATUS_CONTROLLING_TYPE_KEY = "controlling";
        public static final String CONTROL_STATUS_QUEUE_TYPE_KEY = "queue";
        public static final String CONTROL_STATUS_SYNC_TYPE_KEY = "sync";
        public static final String CONTROL_STATUS_UNAUTHORIZED_TYPE_KEY = "unauthorized";
        private String data;
        private String status;
        private String t;
        private Object timeLeft;
        private String type;

        public DataBean(String str) {
            this.type = SyncWsProtocol.CONTROL_SYNC_TOY_TYPE_KEY;
            this.data = str;
        }

        public String getData() {
            return this.data;
        }

        public String getStatus() {
            return this.status;
        }

        public String getT() {
            return this.t;
        }

        public Object getTimeLeft() {
            return this.timeLeft;
        }

        public String getType() {
            return this.type;
        }

        public void setData(String str) {
            this.data = str;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public void setT(String str) {
            this.t = str;
        }

        public void setTimeLeft(Object obj) {
            this.timeLeft = obj;
        }

        public void setType(String str) {
            this.type = str;
        }

        public DataBean(String str, String str2) {
            this.t = str;
            this.data = str2;
        }
    }

    public SyncWsProtocol(String str) {
        this.type = str;
        this.from = db2.A().c;
        this.sid = db2.A().d;
    }

    public SyncWsProtocol(String str, String str2) {
        this.type = CONTROL_SYNC_TYPE_KEY;
        this.from = db2.A().c;
        this.sid = db2.A().d;
        this.data = new DataBean(str, str2);
        if (CONTROL_118_TYPE_CODE_LAN_API_CREATE_WS.equals(str)) {
            this.type = CONTROL_118_TYPE_CODE_LAN_API_CREATE_WS;
            this.data = str2;
        }
    }

    public SyncWsProtocol(String str, Object obj) {
        this.type = CONTROL_SYNC_TYPE_KEY;
        this.from = db2.A().c;
        this.sid = db2.A().d;
        if (obj != null) {
            this.data = new DataBean(str, obj.toString());
        }
        if (CONTROL_118_TYPE_CODE_LAN_API_CREATE_WS.equals(str)) {
            this.type = CONTROL_118_TYPE_CODE_LAN_API_CREATE_WS;
            this.data = obj;
        }
    }
}
