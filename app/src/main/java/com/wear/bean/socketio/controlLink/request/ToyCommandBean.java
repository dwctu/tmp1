package com.wear.bean.socketio.controlLink.request;

import com.wear.bean.ToyBean;
import com.wear.bean.ToyFuncOrderPacket;
import com.wear.bean.ToyMacOrderPacket;
import com.wear.util.WearUtils;
import java.util.HashMap;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class ToyCommandBean {
    private ToyBean all;
    private String cate;
    private ToyFuncOrderPacket func;
    private HashMap<String, ToyBean> id;
    private ToyMacOrderPacket mac;
    private HashMap<String, ToyBean> type;
    private int version;

    public ToyCommandBean() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int addId(java.lang.String r3, java.lang.String r4, java.lang.String r5, boolean r6) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.bean.socketio.controlLink.request.ToyCommandBean.addId(java.lang.String, java.lang.String, java.lang.String, boolean):int");
    }

    public void addLdrId(String str, String str2, int i) {
        if (this.id == null) {
            this.id = new HashMap<>();
        }
        ToyBean toyBean = new ToyBean(str2, i);
        if (WearUtils.e1(str)) {
            return;
        }
        this.id.put(str, toyBean);
    }

    public ToyBean getAll() {
        return this.all;
    }

    public String getCate() {
        return this.cate;
    }

    public ToyFuncOrderPacket getFunc() {
        return this.func;
    }

    public HashMap<String, ToyBean> getId() {
        return this.id;
    }

    public ToyMacOrderPacket getMac() {
        return this.mac;
    }

    public HashMap<String, ToyBean> getType() {
        return this.type;
    }

    public int getVersion() {
        return this.version;
    }

    public void setAll(ToyBean toyBean) {
        this.all = toyBean;
    }

    public int setAllFunc(String str, String str2, boolean z) {
        ToyBean toyBean = new ToyBean(str, str2, z);
        this.all = toyBean;
        return toyBean.getV1() != -1 ? this.all.getV1() : this.all.getV();
    }

    public void setAllValueFunc(String str, String str2, boolean z) {
        ToyBean toyBean = new ToyBean(str, str2, z);
        this.all = toyBean;
        this.all.fillAll(toyBean.getMaxFunValidValue());
    }

    public void setCate(String str) {
        this.cate = str;
    }

    public void setFunc(ToyFuncOrderPacket toyFuncOrderPacket) {
        this.func = toyFuncOrderPacket;
    }

    public void setId(HashMap<String, ToyBean> map) {
        this.id = map;
    }

    public void setMac(ToyMacOrderPacket toyMacOrderPacket) {
        this.mac = toyMacOrderPacket;
    }

    public void setType(HashMap<String, ToyBean> map) {
        this.type = map;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public String toString() {
        return "ToyCommandBean{version=" + this.version + ", cate='" + this.cate + "', type=" + this.type + ", id=" + this.id + ", all=" + this.all + MessageFormatter.DELIM_STOP;
    }

    public ToyCommandBean(String str, HashMap<String, ToyBean> map) {
        this.cate = str;
        this.id = map;
    }
}
