package com.wear.bean.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoiceControlConfigBean.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/wear/bean/data/DefaultPatternConfig;", "", "APatternUrl", "", "BPatternUrl", "CPatternUrl", "DPatternUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAPatternUrl", "()Ljava/lang/String;", "getBPatternUrl", "getCPatternUrl", "getDPatternUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DefaultPatternConfig {

    @NotNull
    private final String APatternUrl;

    @NotNull
    private final String BPatternUrl;

    @NotNull
    private final String CPatternUrl;

    @NotNull
    private final String DPatternUrl;

    public DefaultPatternConfig(@NotNull String APatternUrl, @NotNull String BPatternUrl, @NotNull String CPatternUrl, @NotNull String DPatternUrl) {
        Intrinsics.checkNotNullParameter(APatternUrl, "APatternUrl");
        Intrinsics.checkNotNullParameter(BPatternUrl, "BPatternUrl");
        Intrinsics.checkNotNullParameter(CPatternUrl, "CPatternUrl");
        Intrinsics.checkNotNullParameter(DPatternUrl, "DPatternUrl");
        this.APatternUrl = APatternUrl;
        this.BPatternUrl = BPatternUrl;
        this.CPatternUrl = CPatternUrl;
        this.DPatternUrl = DPatternUrl;
    }

    public static /* synthetic */ DefaultPatternConfig copy$default(DefaultPatternConfig defaultPatternConfig, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = defaultPatternConfig.APatternUrl;
        }
        if ((i & 2) != 0) {
            str2 = defaultPatternConfig.BPatternUrl;
        }
        if ((i & 4) != 0) {
            str3 = defaultPatternConfig.CPatternUrl;
        }
        if ((i & 8) != 0) {
            str4 = defaultPatternConfig.DPatternUrl;
        }
        return defaultPatternConfig.copy(str, str2, str3, str4);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAPatternUrl() {
        return this.APatternUrl;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getBPatternUrl() {
        return this.BPatternUrl;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getCPatternUrl() {
        return this.CPatternUrl;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getDPatternUrl() {
        return this.DPatternUrl;
    }

    @NotNull
    public final DefaultPatternConfig copy(@NotNull String APatternUrl, @NotNull String BPatternUrl, @NotNull String CPatternUrl, @NotNull String DPatternUrl) {
        Intrinsics.checkNotNullParameter(APatternUrl, "APatternUrl");
        Intrinsics.checkNotNullParameter(BPatternUrl, "BPatternUrl");
        Intrinsics.checkNotNullParameter(CPatternUrl, "CPatternUrl");
        Intrinsics.checkNotNullParameter(DPatternUrl, "DPatternUrl");
        return new DefaultPatternConfig(APatternUrl, BPatternUrl, CPatternUrl, DPatternUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DefaultPatternConfig)) {
            return false;
        }
        DefaultPatternConfig defaultPatternConfig = (DefaultPatternConfig) other;
        return Intrinsics.areEqual(this.APatternUrl, defaultPatternConfig.APatternUrl) && Intrinsics.areEqual(this.BPatternUrl, defaultPatternConfig.BPatternUrl) && Intrinsics.areEqual(this.CPatternUrl, defaultPatternConfig.CPatternUrl) && Intrinsics.areEqual(this.DPatternUrl, defaultPatternConfig.DPatternUrl);
    }

    @NotNull
    public final String getAPatternUrl() {
        return this.APatternUrl;
    }

    @NotNull
    public final String getBPatternUrl() {
        return this.BPatternUrl;
    }

    @NotNull
    public final String getCPatternUrl() {
        return this.CPatternUrl;
    }

    @NotNull
    public final String getDPatternUrl() {
        return this.DPatternUrl;
    }

    public int hashCode() {
        return (((((this.APatternUrl.hashCode() * 31) + this.BPatternUrl.hashCode()) * 31) + this.CPatternUrl.hashCode()) * 31) + this.DPatternUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "DefaultPatternConfig(APatternUrl=" + this.APatternUrl + ", BPatternUrl=" + this.BPatternUrl + ", CPatternUrl=" + this.CPatternUrl + ", DPatternUrl=" + this.DPatternUrl + ')';
    }
}
