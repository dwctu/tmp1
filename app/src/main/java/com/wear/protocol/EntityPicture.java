package com.wear.protocol;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.wear.util.WearUtils;

/* loaded from: classes3.dex */
public class EntityPicture extends DataEntityAbstract {
    public String compressPath;
    public String fileMd5;
    public double h;
    public String localUrl;
    private long mediaId;
    public String msgId;
    public String originalPath;
    public String type;
    public String url;
    public double w;

    public EntityPicture() {
        setMsgId(WearUtils.E());
    }

    public String getCompressPath() {
        return this.compressPath;
    }

    @Override // com.wear.protocol.DataEntityAbstract
    public MessageType getEntityType() {
        return MessageType.picture;
    }

    public String getFileMd5() {
        return this.fileMd5;
    }

    public double getH() {
        double d = this.h;
        if (d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return d;
        }
        return 360.0d;
    }

    public String getLocalUrl() {
        return this.localUrl;
    }

    public long getMediaId() {
        return this.mediaId;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getOriginalPath() {
        return this.originalPath;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public double getW() {
        double d = this.w;
        if (d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return d;
        }
        return 240.0d;
    }

    public void setCompressPath(String str) {
        this.compressPath = str;
    }

    public void setFileMd5(String str) {
        this.fileMd5 = str;
    }

    public void setH(double d) {
        this.h = d;
    }

    public void setLocalUrl(String str) {
        this.localUrl = str;
    }

    public void setMediaId(long j) {
        this.mediaId = j;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setOriginalPath(String str) {
        this.originalPath = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setW(double d) {
        this.w = d;
    }

    public EntityPicture(String str) {
        EntityPicture entityPicture = (EntityPicture) fromJsonToDecrypt(str, EntityPicture.class);
        this.url = entityPicture.getUrl();
        this.w = entityPicture.getW();
        this.h = entityPicture.getH();
        this.type = entityPicture.getType();
        this.fileMd5 = entityPicture.getFileMd5();
        this.msgId = entityPicture.getMsgId();
        this.localUrl = entityPicture.getLocalUrl();
        this.compressPath = entityPicture.getCompressPath();
        this.originalPath = entityPicture.getOriginalPath();
        this.mediaId = entityPicture.getMediaId();
    }
}
