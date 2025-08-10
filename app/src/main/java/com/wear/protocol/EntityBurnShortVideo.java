package com.wear.protocol;

import com.wear.util.WearUtils;

/* loaded from: classes3.dex */
public class EntityBurnShortVideo extends EntityShortVideo {
    public boolean isBurn;

    public EntityBurnShortVideo() {
        setMsgId(WearUtils.E());
    }

    @Override // com.wear.protocol.EntityShortVideo, com.wear.protocol.DataEntityAbstract
    public MessageType getEntityType() {
        return MessageType.burnvideo;
    }

    public boolean isBurn() {
        return this.isBurn;
    }

    public void setBurn(boolean z) {
        this.isBurn = z;
    }

    public EntityBurnShortVideo(String str) {
        super(str);
        EntityBurnShortVideo entityBurnShortVideo = (EntityBurnShortVideo) fromJsonToDecrypt(str, EntityBurnShortVideo.class);
        this.picUrl = entityBurnShortVideo.getPicUrl();
        this.picW = entityBurnShortVideo.getPicW();
        this.picH = entityBurnShortVideo.getPicH();
        this.picLocalUrl = entityBurnShortVideo.getPicLocalUrl();
        this.videoUrl = entityBurnShortVideo.getVideoUrl();
        this.videoW = entityBurnShortVideo.getVideoW();
        this.videoH = entityBurnShortVideo.getVideoH();
        this.size = entityBurnShortVideo.getSize();
        this.duration = entityBurnShortVideo.getDuration();
        this.videoLocalUrl = entityBurnShortVideo.getVideoLocalUrl();
        this.msgId = entityBurnShortVideo.getMsgId();
        this.isBurn = entityBurnShortVideo.isBurn();
    }
}
