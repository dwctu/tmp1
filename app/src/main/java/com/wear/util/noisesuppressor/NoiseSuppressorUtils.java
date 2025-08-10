package com.wear.util.noisesuppressor;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: NoiseSuppressorUtils.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\n\n\u0002\u0010\u0017\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0086 J\u0011\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0086 J\u0019\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0086 J-\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0086 J\u0019\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0086 J\t\u0010\u0011\u001a\u00020\u0004H\u0086 J\u0011\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0004H\u0086 J\u0019\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0086 J-\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0017H\u0086 J\u0019\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0086 ¨\u0006\u0019"}, d2 = {"Lcom/wear/util/noisesuppressor/NoiseSuppressorUtils;", "", "()V", "nsCreate", "", "nsFree", "", "nsHandler", "nsInit", "frequency", "nsProcess", "spframe", "", "num_bands", "outframe", "nsSetPolicy", "mode", "nsxCreate", "nsxFree", "nsxHandler", "nsxInit", "nsxProcess", "speechFrame", "", "nsxSetPolicy", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class NoiseSuppressorUtils {
    public NoiseSuppressorUtils() {
        System.loadLibrary("legacy_ns-lib");
    }

    public final native long nsCreate();

    public final native int nsFree(long nsHandler);

    public final native int nsInit(long nsHandler, int frequency);

    public final native int nsProcess(long nsHandler, @Nullable float[] spframe, int num_bands, @Nullable float[] outframe);

    public final native int nsSetPolicy(long nsHandler, int mode);

    public final native long nsxCreate();

    public final native int nsxFree(long nsxHandler);

    public final native int nsxInit(long nsxHandler, int frequency);

    public final native int nsxProcess(long nsxHandler, @Nullable short[] speechFrame, int num_bands, @Nullable short[] outframe);

    public final native int nsxSetPolicy(long nsxHandler, int mode);
}
