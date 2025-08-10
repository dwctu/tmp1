package com.wear.bean;

import com.wear.bean.SyncWsProtocol;
import com.wear.protocol.EntityVideo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: RateConfigBean.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/wear/bean/RateFeature;", "", "feature", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getFeature", "()Ljava/lang/String;", "Live", "Sync", "Video", "Voice", "GroupSync", "GroupDS", "RemoteControl", "ControlLink", "ControlRoulette", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public enum RateFeature {
    Live("live"),
    Sync(SyncWsProtocol.DataBean.CONTROL_STATUS_SYNC_TYPE_KEY),
    Video("video"),
    Voice(EntityVideo.CHANGE_VOICE_MODEL_KEY),
    GroupSync("groupSync"),
    GroupDS("groupDAndS"),
    RemoteControl("remoteControl"),
    ControlLink("controlLink"),
    ControlRoulette("controlRoulette");


    @NotNull
    private final String feature;

    RateFeature(String str) {
        this.feature = str;
    }

    @NotNull
    public final String getFeature() {
        return this.feature;
    }
}
