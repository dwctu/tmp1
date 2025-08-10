package io.agora.metachat;

import io.agora.base.internal.CalledByNative;
import java.util.Arrays;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes4.dex */
public class MetachatUserPositionInfo {
    public float[] mForward;
    public float[] mPosition;
    public float[] mRight;
    public float[] mUp;

    @CalledByNative
    public MetachatUserPositionInfo(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4) {
        this.mPosition = fArr;
        this.mForward = fArr2;
        this.mRight = fArr3;
        this.mUp = fArr4;
    }

    public String toString() {
        return "MetachatUserPositionInfo{mPosition=" + Arrays.toString(this.mPosition) + ", mForward=" + Arrays.toString(this.mForward) + ", mRight=" + Arrays.toString(this.mRight) + ", mUp=" + Arrays.toString(this.mUp) + MessageFormatter.DELIM_STOP;
    }
}
