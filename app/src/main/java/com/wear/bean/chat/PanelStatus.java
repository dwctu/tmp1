package com.wear.bean.chat;

import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: PanelStatus.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/wear/bean/chat/PanelStatus;", "", "()V", "controlMode", "", "getControlMode", "()Ljava/lang/Integer;", "setControlMode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "controlToyMac", "", "getControlToyMac", "()Ljava/lang/String;", "setControlToyMac", "(Ljava/lang/String;)V", "controlType", "getControlType", "setControlType", SettingsJsonConstants.FEATURES_KEY, "", "getFeatures", "()Ljava/util/List;", "setFeatures", "(Ljava/util/List;)V", "panelMode", "getPanelMode", "setPanelMode", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class PanelStatus {

    @Nullable
    private List<String> features;

    @Nullable
    private String controlType = "";

    @Nullable
    private Integer panelMode = 0;

    @Nullable
    private Integer controlMode = 0;

    @Nullable
    private String controlToyMac = "";

    @Nullable
    public final Integer getControlMode() {
        return this.controlMode;
    }

    @Nullable
    public final String getControlToyMac() {
        return this.controlToyMac;
    }

    @Nullable
    public final String getControlType() {
        return this.controlType;
    }

    @Nullable
    public final List<String> getFeatures() {
        return this.features;
    }

    @Nullable
    public final Integer getPanelMode() {
        return this.panelMode;
    }

    public final void setControlMode(@Nullable Integer num) {
        this.controlMode = num;
    }

    public final void setControlToyMac(@Nullable String str) {
        this.controlToyMac = str;
    }

    public final void setControlType(@Nullable String str) {
        this.controlType = str;
    }

    public final void setFeatures(@Nullable List<String> list) {
        this.features = list;
    }

    public final void setPanelMode(@Nullable Integer num) {
        this.panelMode = num;
    }
}
