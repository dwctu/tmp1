package com.wear.protocol;

import com.wear.util.WearUtils;

/* loaded from: classes3.dex */
public class EntityShortVideo extends DataEntityAbstract {
    public int duration;
    public String msgId;
    public int picH;
    public String picLocalUrl;
    public String picUrl;
    public int picW;
    public boolean showProgressBar;
    public long size;
    public int videoH;
    public String videoLocalUrl;
    public String videoUrl;
    public int videoW;

    public EntityShortVideo() {
        setMsgId(WearUtils.E());
    }

    public int getDuration() {
        return this.duration;
    }

    @Override // com.wear.protocol.DataEntityAbstract
    public MessageType getEntityType() {
        return MessageType.shortvideo;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public int getPicH() {
        return this.picH;
    }

    public String getPicLocalUrl() {
        return this.picLocalUrl;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public int getPicW() {
        return this.picW;
    }

    public long getSize() {
        return this.size;
    }

    public int getVideoH() {
        return this.videoH;
    }

    public String getVideoLocalUrl() {
        return this.videoLocalUrl;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public int getVideoW() {
        return this.videoW;
    }

    public boolean isShowProgressBar() {
        return this.showProgressBar;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setPicH(int i) {
        this.picH = i;
    }

    public void setPicLocalUrl(String str) {
        this.picLocalUrl = str;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public void setPicW(int i) {
        this.picW = i;
    }

    public void setShowProgressBar(boolean z) {
        this.showProgressBar = z;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setVideoH(int i) {
        this.videoH = i;
    }

    public void setVideoLocalUrl(String str) {
        this.videoLocalUrl = str;
    }

    public void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public void setVideoW(int i) {
        this.videoW = i;
    }

    public EntityShortVideo(String str) {
        EntityShortVideo entityShortVideo = (EntityShortVideo) fromJsonToDecrypt(str, EntityShortVideo.class);
        this.picUrl = entityShortVideo.getPicUrl();
        this.picW = entityShortVideo.getPicW();
        this.picH = entityShortVideo.getPicH();
        this.picLocalUrl = entityShortVideo.getPicLocalUrl();
        this.videoUrl = entityShortVideo.getVideoUrl();
        this.videoW = entityShortVideo.getVideoW();
        this.videoH = entityShortVideo.getVideoH();
        this.size = entityShortVideo.getSize();
        this.duration = entityShortVideo.getDuration();
        this.videoLocalUrl = entityShortVideo.getVideoLocalUrl();
        this.msgId = entityShortVideo.getMsgId();
    }
}
