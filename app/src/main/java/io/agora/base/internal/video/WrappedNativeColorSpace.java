package io.agora.base.internal.video;

import io.agora.base.VideoFrame;
import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public class WrappedNativeColorSpace implements VideoFrame.ColorSpace {
    private VideoFrame.ColorSpace.Matrix matrix;
    private VideoFrame.ColorSpace.Primary primary;
    private VideoFrame.ColorSpace.Range range;
    private VideoFrame.ColorSpace.Transfer transfer;

    @CalledByNative
    public WrappedNativeColorSpace(int i, int i2, int i3, int i4) {
        this.range = VideoFrame.ColorSpace.Range.Invalid;
        this.matrix = VideoFrame.ColorSpace.Matrix.Unspecified;
        this.transfer = VideoFrame.ColorSpace.Transfer.Unspecified;
        this.primary = VideoFrame.ColorSpace.Primary.Unspecified;
        VideoFrame.ColorSpace.Range[] rangeArrValues = VideoFrame.ColorSpace.Range.values();
        int length = rangeArrValues.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                break;
            }
            VideoFrame.ColorSpace.Range range = rangeArrValues[i5];
            if (range.getRange() == i) {
                this.range = range;
                break;
            }
            i5++;
        }
        VideoFrame.ColorSpace.Matrix[] matrixArrValues = VideoFrame.ColorSpace.Matrix.values();
        int length2 = matrixArrValues.length;
        int i6 = 0;
        while (true) {
            if (i6 >= length2) {
                break;
            }
            VideoFrame.ColorSpace.Matrix matrix = matrixArrValues[i6];
            if (matrix.getMatrix() == i2) {
                this.matrix = matrix;
                break;
            }
            i6++;
        }
        VideoFrame.ColorSpace.Transfer[] transferArrValues = VideoFrame.ColorSpace.Transfer.values();
        int length3 = transferArrValues.length;
        int i7 = 0;
        while (true) {
            if (i7 >= length3) {
                break;
            }
            VideoFrame.ColorSpace.Transfer transfer = transferArrValues[i7];
            if (transfer.getTransfer() == i3) {
                this.transfer = transfer;
                break;
            }
            i7++;
        }
        for (VideoFrame.ColorSpace.Primary primary : VideoFrame.ColorSpace.Primary.values()) {
            if (primary.getPrimary() == i4) {
                this.primary = primary;
                return;
            }
        }
    }

    @Override // io.agora.base.VideoFrame.ColorSpace
    public VideoFrame.ColorSpace.Matrix getMatrix() {
        return this.matrix;
    }

    @Override // io.agora.base.VideoFrame.ColorSpace
    public VideoFrame.ColorSpace.Primary getPrimary() {
        return this.primary;
    }

    @Override // io.agora.base.VideoFrame.ColorSpace
    public VideoFrame.ColorSpace.Range getRange() {
        return this.range;
    }

    @Override // io.agora.base.VideoFrame.ColorSpace
    public VideoFrame.ColorSpace.Transfer getTransfer() {
        return this.transfer;
    }
}
