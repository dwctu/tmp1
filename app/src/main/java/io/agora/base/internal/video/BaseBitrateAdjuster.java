package io.agora.base.internal.video;

/* loaded from: classes4.dex */
public class BaseBitrateAdjuster implements BitrateAdjuster {
    public int targetBitrateBps = 0;
    public int targetFps = 0;

    @Override // io.agora.base.internal.video.BitrateAdjuster
    public int getAdjustedBitrateBps() {
        return this.targetBitrateBps;
    }

    @Override // io.agora.base.internal.video.BitrateAdjuster
    public int getCodecConfigFramerate() {
        return this.targetFps;
    }

    @Override // io.agora.base.internal.video.BitrateAdjuster
    public void reportEncodedFrame(int i) {
    }

    @Override // io.agora.base.internal.video.BitrateAdjuster
    public void setTargets(int i, int i2) {
        this.targetBitrateBps = i;
        this.targetFps = i2;
    }
}
