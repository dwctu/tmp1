package com.wear.protocol;

import com.wear.util.WearUtils;
import dc.hu3;

/* loaded from: classes3.dex */
public class EntityLive extends EntityControl {
    public String controlTime;
    public String data;
    public String type;

    public enum LiveOPTType {
        request,
        cancel,
        accept,
        reject,
        networkError,
        noAnswer,
        end;

        public static LiveOPTType fromString(String str) {
            if (WearUtils.e1(str)) {
                return null;
            }
            return valueOf(str);
        }
    }

    public EntityLive() {
    }

    public String getControlTime() {
        return this.controlTime;
    }

    public String getData() {
        return this.data;
    }

    @Override // com.wear.protocol.HandleListener
    public String getDataValue() {
        return this.data;
    }

    @Override // com.wear.protocol.DataEntityAbstract
    public MessageType getEntityType() {
        return MessageType.live;
    }

    public LiveOPTType getLiveOPTType() {
        return LiveOPTType.fromString(this.type);
    }

    @Override // com.wear.protocol.EntityControl
    public String getOPTType() {
        return getLiveOPTType().toString();
    }

    public String getType() {
        return this.type;
    }

    @Override // com.wear.protocol.HandleListener
    public void rejectAction(String str, String str2) {
        EntityLive entityLive = new EntityLive();
        LiveOPTType liveOPTType = LiveOPTType.reject;
        entityLive.setType(liveOPTType.toString());
        entityLive.setData(str2);
        hu3.g0(entityLive, str, MessageType.live, liveOPTType.toString(), null, null);
    }

    public void setControlTime(String str) {
        this.controlTime = str;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public EntityLive(String str) {
        EntityLive entityLive = (EntityLive) fromJsonToDecrypt(str, EntityLive.class);
        this.type = entityLive.getType();
        this.data = entityLive.getData();
        this.id = entityLive.getId();
        this.controlTime = entityLive.getControlTime();
    }
}
