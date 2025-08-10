package com.wear.protocol;

import com.wear.bean.ToyBean;
import com.wear.util.WearUtils;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class EntityPartnerToy extends DataEntityAbstract {
    private ToyBean all;
    public String cate;
    private HashMap<String, ToyBean> type;

    public enum ToyOPTType {
        type,
        all;

        public static ToyOPTType fromString(String str) {
            if (WearUtils.e1(str)) {
                return null;
            }
            return valueOf(str);
        }
    }

    public EntityPartnerToy() {
    }

    public ToyBean getAll() {
        return this.all;
    }

    public String getCate() {
        return this.cate;
    }

    @Override // com.wear.protocol.DataEntityAbstract
    public MessageType getEntityType() {
        return MessageType.partnertoy;
    }

    public ToyOPTType getToyOPTType() {
        return ToyOPTType.fromString(this.cate);
    }

    public HashMap<String, ToyBean> getType() {
        return this.type;
    }

    public void setAll(ToyBean toyBean) {
        this.all = toyBean;
    }

    public int setAllFunc(String str, String str2, boolean z) {
        ToyBean toyBean = new ToyBean(str, str2, z);
        this.all = toyBean;
        return toyBean.getV1() != -1 ? this.all.getV1() : this.all.getV();
    }

    public void setCate(String str) {
        this.cate = str;
    }

    public void setType(HashMap<String, ToyBean> map) {
        this.type = map;
    }

    public EntityPartnerToy(String str) {
        EntityPartnerToy entityPartnerToy = (EntityPartnerToy) fromJsonToDecrypt(str, EntityPartnerToy.class);
        this.cate = entityPartnerToy.getCate();
        this.type = entityPartnerToy.getType();
        this.all = entityPartnerToy.getAll();
    }
}
