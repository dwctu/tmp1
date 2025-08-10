package com.wear.protocol;

import com.wear.util.WearUtils;
import dc.hu3;

/* loaded from: classes3.dex */
public class EntitySync extends EntityControl {
    public String controlTime;
    public String data;
    public String type;

    public enum SyncOPTType {
        request,
        cancel,
        accept,
        reject,
        networkError,
        noAnswer,
        swap,
        end,
        swapLDR,
        swapLDS,
        swapLDRActiveToy,
        controlLinnkHandShake;

        public static SyncOPTType fromString(String str) {
            if (WearUtils.e1(str)) {
                return null;
            }
            return valueOf(str);
        }
    }

    public EntitySync() {
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
        return MessageType.sync;
    }

    @Override // com.wear.protocol.EntityControl
    public String getOPTType() {
        return getSyncOPTType().toString();
    }

    public SyncOPTType getSyncOPTType() {
        return SyncOPTType.fromString(this.type);
    }

    public String getType() {
        return this.type;
    }

    @Override // com.wear.protocol.HandleListener
    public void rejectAction(String str, String str2) {
        EntitySync entitySync = new EntitySync();
        SyncOPTType syncOPTType = SyncOPTType.reject;
        entitySync.setType(syncOPTType.toString());
        entitySync.setData(str2);
        hu3.g0(entitySync, str, MessageType.sync, syncOPTType.toString(), null, null);
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

    public EntitySync(String str) {
        EntitySync entitySync = (EntitySync) fromJsonToDecrypt(str, EntitySync.class);
        this.type = entitySync.getType();
        this.id = entitySync.getId();
        this.data = entitySync.getData();
        this.controlTime = entitySync.getControlTime();
    }
}
