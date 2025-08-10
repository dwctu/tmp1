package com.wear.util.noisesuppressor;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: AutomaticGainControlUtils.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0017\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0004H\u0086 J+\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0086 J\t\u0010\r\u001a\u00020\u0006H\u0086 J\u0011\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086 J1\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0086 JU\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0086 J)\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001bH\u0086 J;\u0010!\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004H\u0086 ¨\u0006$"}, d2 = {"Lcom/wear/util/noisesuppressor/AutomaticGainControlUtils;", "", "()V", "agcAddFarend", "", "agcInst", "", "inFar", "", "samples", "agcAddMic", "inMic", "num_bands", "agcCreate", "agcFree", "agcInit", "minLevel", "maxLevel", "agcMode", "fs", "agcProcess", "inNear", "out", "inMicLevel", "outMicLevel", "echo", "saturationWarning", "", "agcSetConfig", "targetLevelDbfs", "", "compressionGaindB", "limiterEnable", "agcVirtualMic", "micLevelIn", "micLevelOut", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class AutomaticGainControlUtils {
    public AutomaticGainControlUtils() {
        System.loadLibrary("legacy_agc-lib");
    }

    public final native int agcAddFarend(long agcInst, @Nullable short[] inFar, int samples);

    public final native int agcAddMic(long agcInst, @Nullable short[] inMic, int num_bands, int samples);

    public final native long agcCreate();

    public final native int agcFree(long agcInst);

    public final native int agcInit(long agcInst, int minLevel, int maxLevel, int agcMode, int fs);

    public final native int agcProcess(long agcInst, @Nullable short[] inNear, int num_bands, int samples, @Nullable short[] out, int inMicLevel, int outMicLevel, int echo, boolean saturationWarning);

    public final native int agcSetConfig(long agcInst, short targetLevelDbfs, short compressionGaindB, boolean limiterEnable);

    public final native int agcVirtualMic(long agcInst, @Nullable short[] inMic, int num_bands, int samples, int micLevelIn, int micLevelOut);
}
