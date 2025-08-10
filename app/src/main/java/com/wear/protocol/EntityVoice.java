package com.wear.protocol;

import com.wear.util.WearUtils;
import dc.hu3;

/* loaded from: classes3.dex */
public class EntityVoice extends EntityControl {
    public String channelName;
    public String controlTime;
    public String data;
    public String type;

    public enum VoiceOPTType {
        request,
        cancel,
        accept,
        reject,
        networkError,
        noAnswer,
        swap,
        end,
        rtc,
        changeModel,
        swapLDRControl,
        swapLDRActiveToy;

        public static VoiceOPTType fromString(String str) {
            if (WearUtils.e1(str)) {
                return null;
            }
            return valueOf(str);
        }
    }

    public EntityVoice() {
    }

    public String getChannelName() {
        return this.channelName;
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
        return MessageType.voice;
    }

    @Override // com.wear.protocol.EntityControl
    public String getOPTType() {
        return getVoiceOPTType().toString();
    }

    public String getType() {
        return this.type;
    }

    public VoiceOPTType getVoiceOPTType() {
        return VoiceOPTType.fromString(this.type);
    }

    @Override // com.wear.protocol.HandleListener
    public void rejectAction(String str, String str2) {
        WearUtils.z2();
        EntityVoice entityVoice = new EntityVoice();
        VoiceOPTType voiceOPTType = VoiceOPTType.reject;
        entityVoice.setType(voiceOPTType.toString());
        entityVoice.setData(str2);
        hu3.g0(entityVoice, str, MessageType.voice, voiceOPTType.toString(), null, null);
    }

    public void setChannelName(String str) {
        this.channelName = str;
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

    public EntityVoice(String str) {
        EntityVoice entityVoice = (EntityVoice) fromJsonToDecrypt(str, EntityVoice.class);
        this.type = entityVoice.getType();
        this.data = entityVoice.getData();
        this.id = entityVoice.getId();
        this.channelName = entityVoice.getChannelName();
        this.controlTime = entityVoice.getControlTime();
    }
}
