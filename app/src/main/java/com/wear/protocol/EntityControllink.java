package com.wear.protocol;

import com.wear.bean.ControlLinkBean;
import com.wear.util.WearUtils;

/* loaded from: classes3.dex */
public class EntityControllink extends DataEntityAbstract {
    public String controlLinkData;

    public EntityControllink() {
    }

    public ControlLinkBean getControlLinkBean() {
        return (ControlLinkBean) WearUtils.A.fromJson(this.controlLinkData, ControlLinkBean.class);
    }

    public String getControlLinkData() {
        return this.controlLinkData;
    }

    @Override // com.wear.protocol.DataEntityAbstract
    public MessageType getEntityType() {
        return MessageType.controllink;
    }

    public void setControlLinkBean(ControlLinkBean controlLinkBean) {
        this.controlLinkData = WearUtils.A.toJson(controlLinkBean);
    }

    public void setControlLinkData(String str) {
        this.controlLinkData = str;
    }

    public EntityControllink(String str) {
        this.controlLinkData = ((EntityControllink) fromJsonToDecrypt(str, EntityControllink.class)).getControlLinkData();
    }
}
