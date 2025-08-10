package com.wear.protocol;

import android.text.TextUtils;
import com.wear.bean.ToyBean;
import com.wear.bean.ToyFuncOrderPacket;
import com.wear.bean.ToyMacOrderPacket;
import com.wear.bean.controlmutlitoys.Ball2CurveEventBean;
import com.wear.util.WearUtils;
import java.util.HashMap;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class EntityToy extends DataEntityAbstract {
    private ToyBean all;
    public String cate;
    private ToyFuncOrderPacket func;
    private HashMap<String, ToyBean> id;
    private int lineType;
    private ToyMacOrderPacket mac;
    private long receiveTime;
    private HashMap<String, ToyBean> type;
    private int version;

    public enum ToyOPTType {
        id,
        type,
        all;

        public static ToyOPTType fromString(String str) {
            if (WearUtils.e1(str)) {
                return null;
            }
            return valueOf(str);
        }
    }

    public EntityToy() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int addId(java.lang.String r3, java.lang.String r4, java.lang.String r5, boolean r6) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.protocol.EntityToy.addId(java.lang.String, java.lang.String, java.lang.String, boolean):int");
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

    public void createToyBean(String str, String str2, boolean z) {
        this.all = new ToyBean(str, str2, z);
    }

    @Override // com.wear.protocol.DataEntityAbstract
    public <T> T fromJsonToDecrypt(String str, Class<T> cls) {
        String strDecrypt = CommunMessage.decrypt(str);
        String str2 = "数据===" + strDecrypt;
        return (T) WearUtils.A.fromJson(strDecrypt, (Class) cls);
    }

    public ToyBean getAll() {
        return this.all;
    }

    public String getCate() {
        return this.cate;
    }

    @Override // com.wear.protocol.DataEntityAbstract
    public MessageType getEntityType() {
        return MessageType.toy;
    }

    public ToyFuncOrderPacket getFunc() {
        return this.func;
    }

    public HashMap<String, ToyBean> getId() {
        return this.id;
    }

    public int getLineType() {
        return this.lineType;
    }

    public ToyMacOrderPacket getMac() {
        return this.mac;
    }

    public long getReceiveTime() {
        return this.receiveTime;
    }

    public ToyOPTType getToyOPTType() {
        return ToyOPTType.fromString(this.cate);
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

    public int setAllFunc(Ball2CurveEventBean ball2CurveEventBean) {
        ToyBean toyBean = new ToyBean(ball2CurveEventBean);
        this.all = toyBean;
        return toyBean.getV1() != -1 ? this.all.getV1() : this.all.getV();
    }

    public void setAllFuncValue(String str, String str2, boolean z) {
        ToyBean toyBean = new ToyBean(str, str2, z);
        this.all = toyBean;
        this.all.fillAll(toyBean.getMaxFunValidValue());
    }

    public void setCate(String str) {
        if (TextUtils.equals(ToyOPTType.all.toString(), str)) {
            this.version = 4;
        }
        this.cate = str;
    }

    public void setFunc(ToyFuncOrderPacket toyFuncOrderPacket) {
        this.func = toyFuncOrderPacket;
    }

    public void setId(HashMap<String, ToyBean> map) {
        this.id = map;
    }

    public void setLineType(int i) {
        this.lineType = i;
    }

    public void setMac(ToyMacOrderPacket toyMacOrderPacket) {
        this.mac = toyMacOrderPacket;
    }

    public void setReceiveTime(long j) {
        this.receiveTime = j;
    }

    public void setType(HashMap<String, ToyBean> map) {
        this.type = map;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public String toString() {
        return "EntityToy{version=" + this.version + ", cate='" + this.cate + "', id=" + this.id + ", type=" + this.type + ", all=" + this.all + ", mac=" + this.mac + ", func=" + this.func + MessageFormatter.DELIM_STOP;
    }

    public EntityToy(String str) {
        EntityToy entityToy = (EntityToy) fromJsonToDecrypt(str, EntityToy.class);
        this.cate = entityToy.getCate();
        this.id = entityToy.getId();
        this.type = entityToy.getType();
        this.all = entityToy.getAll();
        this.mac = entityToy.getMac();
        this.func = entityToy.getFunc();
        this.version = entityToy.getVersion();
    }

    public int addId(Ball2CurveEventBean ball2CurveEventBean) {
        if (this.id == null) {
            this.id = new HashMap<>();
        }
        ToyBean toyBean = new ToyBean(ball2CurveEventBean);
        if (!WearUtils.e1(ball2CurveEventBean.getToyAddress())) {
            this.id.put(ball2CurveEventBean.getToyAddress(), toyBean);
        }
        return toyBean.getV1() != -1 ? toyBean.getV1() : toyBean.getV();
    }
}
