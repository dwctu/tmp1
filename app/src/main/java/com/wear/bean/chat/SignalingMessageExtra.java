package com.wear.bean.chat;

import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: SignalingMessageExtra.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/wear/bean/chat/SignalingMessageExtra;", "", "()V", "controlMode", "", "getControlMode", "()Ljava/lang/Integer;", "setControlMode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", SettingsJsonConstants.FEATURES_KEY, "", "", "getFeatures", "()Ljava/util/List;", "setFeatures", "(Ljava/util/List;)V", "panelMode", "getPanelMode", "setPanelMode", "toyMac", "getToyMac", "()Ljava/lang/String;", "setToyMac", "(Ljava/lang/String;)V", "type", "getType", "setType", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SignalingMessageExtra {

    @Nullable
    private Integer controlMode;

    @Nullable
    private List<String> features;

    @Nullable
    private Integer panelMode;

    @Nullable
    private String toyMac = "";

    @Nullable
    private Integer type;

    @Nullable
    public final Integer getControlMode() {
        return this.controlMode;
    }

    @Nullable
    public final List<String> getFeatures() {
        return this.features;
    }

    @Nullable
    public final Integer getPanelMode() {
        return this.panelMode;
    }

    @Nullable
    public final String getToyMac() {
        return this.toyMac;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }

    public final void setControlMode(@Nullable Integer num) {
        this.controlMode = num;
    }

    public final void setFeatures(@Nullable List<String> list) {
        this.features = list;
    }

    public final void setPanelMode(@Nullable Integer num) {
        this.panelMode = num;
    }

    public final void setToyMac(@Nullable String str) {
        this.toyMac = str;
    }

    public final void setType(@Nullable Integer num) {
        this.type = num;
    }
}
