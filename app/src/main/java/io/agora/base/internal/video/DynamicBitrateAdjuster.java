package io.agora.base.internal.video;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes4.dex */
public class DynamicBitrateAdjuster extends BaseBitrateAdjuster {
    private static final double BITRATE_ADJUSTMENT_MAX_SCALE = 4.0d;
    private static final double BITRATE_ADJUSTMENT_SEC = 3.0d;
    private static final int BITRATE_ADJUSTMENT_STEPS = 20;
    private static final double BITS_PER_BYTE = 8.0d;
    private double deviationBytes = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    private double timeSinceLastAdjustmentMs = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    private int bitrateAdjustmentScaleExp = 0;

    private double getBitrateAdjustmentScale() {
        return Math.pow(BITRATE_ADJUSTMENT_MAX_SCALE, this.bitrateAdjustmentScaleExp / 20.0d);
    }

    @Override // io.agora.base.internal.video.BaseBitrateAdjuster, io.agora.base.internal.video.BitrateAdjuster
    public int getAdjustedBitrateBps() {
        return (int) (this.targetBitrateBps * getBitrateAdjustmentScale());
    }

    @Override // io.agora.base.internal.video.BaseBitrateAdjuster, io.agora.base.internal.video.BitrateAdjuster
    public void reportEncodedFrame(int i) {
        int i2 = this.targetFps;
        if (i2 == 0) {
            return;
        }
        int i3 = this.targetBitrateBps;
        double d = this.deviationBytes + (i - ((i3 / BITS_PER_BYTE) / i2));
        this.deviationBytes = d;
        this.timeSinceLastAdjustmentMs += 1000.0d / i2;
        double d2 = i3 / BITS_PER_BYTE;
        double d3 = BITRATE_ADJUSTMENT_SEC * d2;
        double dMin = Math.min(d, d3);
        this.deviationBytes = dMin;
        double dMax = Math.max(dMin, -d3);
        this.deviationBytes = dMax;
        if (this.timeSinceLastAdjustmentMs <= 3000.0d) {
            return;
        }
        if (dMax > d2) {
            int i4 = this.bitrateAdjustmentScaleExp - ((int) ((dMax / d2) + 0.5d));
            this.bitrateAdjustmentScaleExp = i4;
            this.bitrateAdjustmentScaleExp = Math.max(i4, -20);
            this.deviationBytes = d2;
        } else {
            double d4 = -d2;
            if (dMax < d4) {
                int i5 = this.bitrateAdjustmentScaleExp + ((int) (((-dMax) / d2) + 0.5d));
                this.bitrateAdjustmentScaleExp = i5;
                this.bitrateAdjustmentScaleExp = Math.min(i5, 20);
                this.deviationBytes = d4;
            }
        }
        this.timeSinceLastAdjustmentMs = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    @Override // io.agora.base.internal.video.BaseBitrateAdjuster, io.agora.base.internal.video.BitrateAdjuster
    public void setTargets(int i, int i2) {
        int i3 = this.targetBitrateBps;
        if (i3 > 0 && i < i3) {
            this.deviationBytes = (this.deviationBytes * i) / i3;
        }
        super.setTargets(i, i2);
    }
}
