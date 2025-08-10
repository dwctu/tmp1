package com.wear.protocol;

import com.wear.util.WearUtils;
import dc.hu3;

/* loaded from: classes3.dex */
public class EntityVideo extends EntityControl {
    public static final String CHANGE_VOICE_MODEL_KEY = "voice";
    public String channelName;
    public String controlTime;
    public String data;
    public String type;

    public enum VideoOPTType {
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

        public static VideoOPTType fromString(String str) {
            if (WearUtils.e1(str)) {
                return null;
            }
            return valueOf(str);
        }
    }

    public EntityVideo() {
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
        return MessageType.video;
    }

    @Override // com.wear.protocol.EntityControl
    public String getOPTType() {
        return getVideoOPTType().toString();
    }

    public String getType() {
        return this.type;
    }

    public VideoOPTType getVideoOPTType() {
        return VideoOPTType.fromString(this.type);
    }

    @Override // com.wear.protocol.HandleListener
    public void rejectAction(String str, String str2) {
        WearUtils.z2();
        EntityVideo entityVideo = new EntityVideo();
        VideoOPTType videoOPTType = VideoOPTType.reject;
        entityVideo.setType(videoOPTType.toString());
        entityVideo.setData(str2);
        hu3.g0(entityVideo, str, MessageType.video, videoOPTType.toString(), null, null);
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

    public EntityVideo(String str) {
        EntityVideo entityVideo = (EntityVideo) fromJsonToDecrypt(str, EntityVideo.class);
        this.type = entityVideo.getType();
        this.data = entityVideo.getData();
        this.id = entityVideo.getId();
        this.channelName = entityVideo.getChannelName();
        this.controlTime = entityVideo.getControlTime();
    }
}
