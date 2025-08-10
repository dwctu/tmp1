package com.wear.protocol;

import com.wear.util.WearUtils;

/* loaded from: classes3.dex */
public class EntityPattern extends DataEntityAbstract {
    public static final String TYPE_DETAIL_MYSENDPATTERN = "mysendpattern";
    public static final String TYPE_DETAIL_PATTERN_RESEND = "resendpattern";
    public static final String TYPE_DETAIL_PATTERN_RESEND_V2 = "mysendpattern111";
    public boolean IsAutoPlay = false;
    public String feature;
    public String localUrl;
    public String msgId;
    public String name;
    public long time;
    public String toyVersion;
    public String type;
    public String url;

    public EntityPattern() {
        setMsgId(WearUtils.E());
    }

    @Override // com.wear.protocol.DataEntityAbstract
    public MessageType getEntityType() {
        return MessageType.pattern;
    }

    public String getFeature() {
        return this.feature;
    }

    public boolean getIsAutoPlay() {
        return this.IsAutoPlay;
    }

    public String getLocalUrl() {
        return this.localUrl;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getName() {
        return this.name;
    }

    public long getTime() {
        return this.time;
    }

    public String getToyVersion() {
        return this.toyVersion;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setFeature(String str) {
        this.feature = str;
    }

    public void setIsAutoPlay(boolean z) {
        this.IsAutoPlay = z;
    }

    public void setLocalUrl(String str) {
        this.localUrl = str;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setToyVersion(String str) {
        this.toyVersion = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public EntityPattern(String str) {
        EntityPattern entityPattern = (EntityPattern) fromJsonToDecrypt(str, EntityPattern.class);
        this.feature = entityPattern.getFeature();
        this.name = entityPattern.getName();
        this.type = entityPattern.getType();
        this.url = entityPattern.getUrl();
        this.time = entityPattern.getTime();
        this.msgId = entityPattern.getMsgId();
        this.localUrl = entityPattern.getLocalUrl();
        this.toyVersion = entityPattern.getToyVersion();
    }
}
