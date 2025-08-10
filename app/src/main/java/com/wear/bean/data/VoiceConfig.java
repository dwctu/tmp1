package com.wear.bean.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoiceControlConfigBean.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/wear/bean/data/VoiceConfig;", "", "defaultPatternConfig", "Lcom/wear/bean/data/DefaultPatternConfig;", "wavePatternConfig", "Lcom/wear/bean/data/WavePatternConfig;", "straightPatternConfig", "Lcom/wear/bean/data/StraightPatternConfig;", "(Lcom/wear/bean/data/DefaultPatternConfig;Lcom/wear/bean/data/WavePatternConfig;Lcom/wear/bean/data/StraightPatternConfig;)V", "getDefaultPatternConfig", "()Lcom/wear/bean/data/DefaultPatternConfig;", "getStraightPatternConfig", "()Lcom/wear/bean/data/StraightPatternConfig;", "getWavePatternConfig", "()Lcom/wear/bean/data/WavePatternConfig;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class VoiceConfig {

    @Nullable
    private final DefaultPatternConfig defaultPatternConfig;

    @Nullable
    private final StraightPatternConfig straightPatternConfig;

    @Nullable
    private final WavePatternConfig wavePatternConfig;

    public VoiceConfig() {
        this(null, null, null, 7, null);
    }

    public VoiceConfig(@Nullable DefaultPatternConfig defaultPatternConfig, @Nullable WavePatternConfig wavePatternConfig, @Nullable StraightPatternConfig straightPatternConfig) {
        this.defaultPatternConfig = defaultPatternConfig;
        this.wavePatternConfig = wavePatternConfig;
        this.straightPatternConfig = straightPatternConfig;
    }

    public static /* synthetic */ VoiceConfig copy$default(VoiceConfig voiceConfig, DefaultPatternConfig defaultPatternConfig, WavePatternConfig wavePatternConfig, StraightPatternConfig straightPatternConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            defaultPatternConfig = voiceConfig.defaultPatternConfig;
        }
        if ((i & 2) != 0) {
            wavePatternConfig = voiceConfig.wavePatternConfig;
        }
        if ((i & 4) != 0) {
            straightPatternConfig = voiceConfig.straightPatternConfig;
        }
        return voiceConfig.copy(defaultPatternConfig, wavePatternConfig, straightPatternConfig);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final DefaultPatternConfig getDefaultPatternConfig() {
        return this.defaultPatternConfig;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final WavePatternConfig getWavePatternConfig() {
        return this.wavePatternConfig;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final StraightPatternConfig getStraightPatternConfig() {
        return this.straightPatternConfig;
    }

    @NotNull
    public final VoiceConfig copy(@Nullable DefaultPatternConfig defaultPatternConfig, @Nullable WavePatternConfig wavePatternConfig, @Nullable StraightPatternConfig straightPatternConfig) {
        return new VoiceConfig(defaultPatternConfig, wavePatternConfig, straightPatternConfig);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceConfig)) {
            return false;
        }
        VoiceConfig voiceConfig = (VoiceConfig) other;
        return Intrinsics.areEqual(this.defaultPatternConfig, voiceConfig.defaultPatternConfig) && Intrinsics.areEqual(this.wavePatternConfig, voiceConfig.wavePatternConfig) && Intrinsics.areEqual(this.straightPatternConfig, voiceConfig.straightPatternConfig);
    }

    @Nullable
    public final DefaultPatternConfig getDefaultPatternConfig() {
        return this.defaultPatternConfig;
    }

    @Nullable
    public final StraightPatternConfig getStraightPatternConfig() {
        return this.straightPatternConfig;
    }

    @Nullable
    public final WavePatternConfig getWavePatternConfig() {
        return this.wavePatternConfig;
    }

    public int hashCode() {
        DefaultPatternConfig defaultPatternConfig = this.defaultPatternConfig;
        int iHashCode = (defaultPatternConfig == null ? 0 : defaultPatternConfig.hashCode()) * 31;
        WavePatternConfig wavePatternConfig = this.wavePatternConfig;
        int iHashCode2 = (iHashCode + (wavePatternConfig == null ? 0 : wavePatternConfig.hashCode())) * 31;
        StraightPatternConfig straightPatternConfig = this.straightPatternConfig;
        return iHashCode2 + (straightPatternConfig != null ? straightPatternConfig.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "VoiceConfig(defaultPatternConfig=" + this.defaultPatternConfig + ", wavePatternConfig=" + this.wavePatternConfig + ", straightPatternConfig=" + this.straightPatternConfig + ')';
    }

    public /* synthetic */ VoiceConfig(DefaultPatternConfig defaultPatternConfig, WavePatternConfig wavePatternConfig, StraightPatternConfig straightPatternConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : defaultPatternConfig, (i & 2) != 0 ? null : wavePatternConfig, (i & 4) != 0 ? null : straightPatternConfig);
    }
}
