package com.component.dxfunctionkits.featureconfig.bean;

import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.roster.packet.RosterVer;

/* compiled from: FeatureConfigReqBean.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u0003X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/component/dxfunctionkits/featureconfig/bean/FeatureConfigReqBean;", "", "ac", "", RosterVer.ELEMENT, "devid", "dataVer", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAc", "()Ljava/lang/String;", "getDataVer", "()I", "getDevid", "pf", "getPf", "getVer", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "featureConfig_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class FeatureConfigReqBean {

    @NotNull
    private final String ac;
    private final int dataVer;

    @NotNull
    private final String devid;

    @NotNull
    private final String pf;

    @NotNull
    private final String ver;

    public FeatureConfigReqBean(@NotNull String ac, @NotNull String ver, @NotNull String devid, int i) {
        Intrinsics.checkNotNullParameter(ac, "ac");
        Intrinsics.checkNotNullParameter(ver, "ver");
        Intrinsics.checkNotNullParameter(devid, "devid");
        this.ac = ac;
        this.ver = ver;
        this.devid = devid;
        this.dataVer = i;
        this.pf = DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE;
    }

    public static /* synthetic */ FeatureConfigReqBean copy$default(FeatureConfigReqBean featureConfigReqBean, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = featureConfigReqBean.ac;
        }
        if ((i2 & 2) != 0) {
            str2 = featureConfigReqBean.ver;
        }
        if ((i2 & 4) != 0) {
            str3 = featureConfigReqBean.devid;
        }
        if ((i2 & 8) != 0) {
            i = featureConfigReqBean.dataVer;
        }
        return featureConfigReqBean.copy(str, str2, str3, i);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAc() {
        return this.ac;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getVer() {
        return this.ver;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getDevid() {
        return this.devid;
    }

    /* renamed from: component4, reason: from getter */
    public final int getDataVer() {
        return this.dataVer;
    }

    @NotNull
    public final FeatureConfigReqBean copy(@NotNull String ac, @NotNull String ver, @NotNull String devid, int dataVer) {
        Intrinsics.checkNotNullParameter(ac, "ac");
        Intrinsics.checkNotNullParameter(ver, "ver");
        Intrinsics.checkNotNullParameter(devid, "devid");
        return new FeatureConfigReqBean(ac, ver, devid, dataVer);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeatureConfigReqBean)) {
            return false;
        }
        FeatureConfigReqBean featureConfigReqBean = (FeatureConfigReqBean) other;
        return Intrinsics.areEqual(this.ac, featureConfigReqBean.ac) && Intrinsics.areEqual(this.ver, featureConfigReqBean.ver) && Intrinsics.areEqual(this.devid, featureConfigReqBean.devid) && this.dataVer == featureConfigReqBean.dataVer;
    }

    @NotNull
    public final String getAc() {
        return this.ac;
    }

    public final int getDataVer() {
        return this.dataVer;
    }

    @NotNull
    public final String getDevid() {
        return this.devid;
    }

    @NotNull
    public final String getPf() {
        return this.pf;
    }

    @NotNull
    public final String getVer() {
        return this.ver;
    }

    public int hashCode() {
        return (((((this.ac.hashCode() * 31) + this.ver.hashCode()) * 31) + this.devid.hashCode()) * 31) + this.dataVer;
    }

    @NotNull
    public String toString() {
        return "FeatureConfigReqBean(ac=" + this.ac + ", ver=" + this.ver + ", devid=" + this.devid + ", dataVer=" + this.dataVer + ')';
    }
}
