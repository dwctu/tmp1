package io.agora.rtc2.video;

/* loaded from: classes4.dex */
public class ColorEnhanceOptions {
    public float skinProtectLevel;
    public float strengthLevel;

    public ColorEnhanceOptions() {
        this.strengthLevel = 0.5f;
        this.skinProtectLevel = 1.0f;
    }

    public ColorEnhanceOptions(float f, float f2) {
        this.strengthLevel = f;
        this.skinProtectLevel = f2;
    }
}
