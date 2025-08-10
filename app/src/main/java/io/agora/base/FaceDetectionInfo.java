package io.agora.base;

import android.graphics.Rect;
import io.agora.base.internal.CalledByNative;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes4.dex */
public final class FaceDetectionInfo implements IMetaInfo {
    private double mDepth;
    private Rect mFaceRect;
    private int mId;

    public FaceDetectionInfo(int i, Rect rect, double d) {
        this.mId = 0;
        this.mId = i;
        this.mFaceRect = rect;
        this.mDepth = d;
    }

    @CalledByNative
    public double getDepth() {
        return this.mDepth;
    }

    @CalledByNative
    public Rect getFaceRect() {
        return this.mFaceRect;
    }

    @Override // io.agora.base.IMetaInfo
    @CalledByNative
    public int getId() {
        return this.mId;
    }

    @Override // io.agora.base.IMetaInfo
    @CalledByNative
    public String getTag() {
        return FaceDetectionInfo.class.getSimpleName();
    }

    public String toString() {
        return "FaceDetectionInfo{mId=" + this.mId + ", mFaceRect=" + this.mFaceRect + ", mDepth=" + this.mDepth + MessageFormatter.DELIM_STOP;
    }
}
