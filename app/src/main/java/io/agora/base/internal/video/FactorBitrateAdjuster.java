package io.agora.base.internal.video;

/* loaded from: classes4.dex */
public class FactorBitrateAdjuster extends BaseBitrateAdjuster {
    public static final int FACTOR_BASE = 1000;
    public static final int FACTOR_LEVEL1 = 950;
    private int factorLevel;

    public FactorBitrateAdjuster(int i) {
        this.factorLevel = 1000;
        if (i == 950) {
            this.factorLevel = FACTOR_LEVEL1;
        }
    }

    private double getBitrateAdjustmentScale() {
        return this.factorLevel / 1000.0d;
    }

    @Override // io.agora.base.internal.video.BaseBitrateAdjuster, io.agora.base.internal.video.BitrateAdjuster
    public void setTargets(int i, int i2) {
        super.setTargets(i, i2);
        this.targetBitrateBps = (int) (this.targetBitrateBps * getBitrateAdjustmentScale());
    }
}
