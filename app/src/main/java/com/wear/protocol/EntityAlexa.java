package com.wear.protocol;

import com.wear.util.WearUtils;

/* loaded from: classes3.dex */
public class EntityAlexa extends DataEntityAbstract {
    public String code;
    public String message;
    public String type;

    public enum AlexaOPTType {
        bind,
        unbind;

        public static AlexaOPTType fromString(String str) {
            if (WearUtils.e1(str)) {
                return null;
            }
            return valueOf(str);
        }
    }

    public EntityAlexa() {
    }

    public AlexaOPTType getAlexaOPTType() {
        return AlexaOPTType.fromString(this.type);
    }

    public String getCode() {
        return this.code;
    }

    @Override // com.wear.protocol.DataEntityAbstract
    public MessageType getEntityType() {
        return MessageType.sync;
    }

    public String getMessage() {
        return this.message;
    }

    public String getType() {
        return this.type;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public EntityAlexa(String str) {
        EntityAlexa entityAlexa = (EntityAlexa) fromJsonToDecrypt(str, EntityAlexa.class);
        this.type = entityAlexa.getType();
        this.code = entityAlexa.getCode();
        this.message = entityAlexa.getMessage();
    }
}
