package io.agora.base;

import android.graphics.Matrix;
import androidx.annotation.Nullable;
import io.agora.base.internal.CalledByNative;
import io.agora.base.internal.RefCounted;
import io.agora.base.internal.video.EglBase;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class VideoFrame implements RefCounted {
    private byte[] alphaBuffer;
    private Buffer buffer;
    private ColorSpace colorSpace;
    private VideoFrameMetaInfo metaInfo;
    private int rotation;
    private float sampleAspectRatio;
    private SourceType sourceType;
    private long timestampNs;

    public interface Buffer extends RefCounted {
        @CalledByNative("Buffer")
        Buffer cropAndScale(int i, int i2, int i3, int i4, int i5, int i6);

        @CalledByNative("Buffer")
        int getHeight();

        @CalledByNative("Buffer")
        int getWidth();

        @Nullable
        @CalledByNative("Buffer")
        Buffer mirror(int i);

        @Override // io.agora.base.internal.RefCounted
        @CalledByNative("Buffer")
        void release();

        @Override // io.agora.base.internal.RefCounted
        @CalledByNative("Buffer")
        void retain();

        @Nullable
        @CalledByNative("Buffer")
        Buffer rotate(int i);

        @CalledByNative("Buffer")
        I420Buffer toI420();

        @Nullable
        @CalledByNative("Buffer")
        Buffer transform(int i, int i2, int i3, int i4, int i5, int i6, int i7);
    }

    public interface ColorSpace {

        public enum Matrix {
            RGB(0),
            BT709(1),
            Unspecified(2),
            FCC(4),
            BT470BG(5),
            SMPTE170M(6),
            SMPTE240M(7),
            YCOCG(8),
            BT2020_NCL(9),
            BT2020_CL(10),
            SMPTE2085(11),
            CDNCLS(12),
            CDCLS(13),
            BT2100_ICTCP(14);

            private final int matrix;

            Matrix(int i) {
                this.matrix = i;
            }

            public int getMatrix() {
                return this.matrix;
            }
        }

        public enum Primary {
            BT709(1),
            Unspecified(2),
            BT470M(4),
            BT470BG(5),
            kSMPTE170M(6),
            kSMPTE240M(7),
            kFILM(8),
            kBT2020(9),
            kSMPTEST428(10),
            kSMPTEST431(11),
            kSMPTEST432(12),
            kJEDECP22(22);

            private final int primary;

            Primary(int i) {
                this.primary = i;
            }

            public int getPrimary() {
                return this.primary;
            }
        }

        public enum Range {
            Invalid(0),
            Limited(1),
            Full(2),
            Derived(3);

            private final int range;

            Range(int i) {
                this.range = i;
            }

            public int getRange() {
                return this.range;
            }
        }

        public enum Transfer {
            BT709(1),
            Unspecified(2),
            GAMMA22(4),
            GAMMA28(5),
            SMPTE170M(6),
            SMPTE240M(7),
            LINEAR(8),
            LOG(9),
            LOG_SQRT(10),
            IEC61966_2_4(11),
            BT1361_ECG(12),
            IEC61966_2_1(13),
            BT2020_10(14),
            BT2020_12(15),
            SMPTEST2084(16),
            SMPTEST428(17),
            ARIB_STD_B67(18);

            private final int transfer;

            Transfer(int i) {
                this.transfer = i;
            }

            public int getTransfer() {
                return this.transfer;
            }
        }

        Matrix getMatrix();

        Primary getPrimary();

        Range getRange();

        Transfer getTransfer();
    }

    public interface I420Buffer extends Buffer {
        @CalledByNative("I420Buffer")
        ByteBuffer getDataU();

        @CalledByNative("I420Buffer")
        ByteBuffer getDataV();

        @CalledByNative("I420Buffer")
        ByteBuffer getDataY();

        @CalledByNative("I420Buffer")
        int getStrideU();

        @CalledByNative("I420Buffer")
        int getStrideV();

        @CalledByNative("I420Buffer")
        int getStrideY();
    }

    public interface I422Buffer extends Buffer {
        @CalledByNative("I422Buffer")
        ByteBuffer getDataU();

        @CalledByNative("I422Buffer")
        ByteBuffer getDataV();

        @CalledByNative("I422Buffer")
        ByteBuffer getDataY();

        @CalledByNative("I422Buffer")
        int getStrideU();

        @CalledByNative("I422Buffer")
        int getStrideV();

        @CalledByNative("I422Buffer")
        int getStrideY();
    }

    public interface RgbaBuffer extends Buffer {
        @CalledByNative("RgbaBuffer")
        ByteBuffer getData();
    }

    public enum SourceType {
        kFrontCamera,
        kBackCamera,
        kUnspecified
    }

    public interface TextureBuffer extends Buffer {

        public enum ContextType {
            EGL_CONTEXT_10,
            EGL_CONTEXT_14
        }

        public enum Type {
            OES(36197),
            RGB(3553);

            private final int glTarget;

            Type(int i) {
                this.glTarget = i;
            }

            public int getGlTarget() {
                return this.glTarget;
            }
        }

        EglBase.Context getEglBaseContext();

        @CalledByNative("TextureBuffer")
        int getEglContextType();

        @CalledByNative("TextureBuffer")
        long getNativeEglContext();

        @CalledByNative("TextureBuffer")
        int getSequence();

        @CalledByNative("TextureBuffer")
        int getTextureId();

        Matrix getTransformMatrix();

        @CalledByNative("TextureBuffer")
        float[] getTransformMatrixArray();

        Type getType();
    }

    public VideoFrame(Buffer buffer, int i, long j) {
        this(buffer, i, j, null, null, 1.0f, SourceType.kUnspecified.ordinal());
    }

    public byte[] getAlphaBuffer() {
        return this.alphaBuffer;
    }

    @CalledByNative
    public Buffer getBuffer() {
        return this.buffer;
    }

    public ColorSpace getColorSpace() {
        return this.colorSpace;
    }

    @CalledByNative
    public VideoFrameMetaInfo getMetaInfo() {
        return this.metaInfo;
    }

    public int getRotatedHeight() {
        return this.rotation % 180 == 0 ? this.buffer.getHeight() : this.buffer.getWidth();
    }

    public int getRotatedWidth() {
        return this.rotation % 180 == 0 ? this.buffer.getWidth() : this.buffer.getHeight();
    }

    @CalledByNative
    public int getRotation() {
        return this.rotation;
    }

    public float getSampleAspectRatio() {
        return this.sampleAspectRatio;
    }

    @CalledByNative
    public SourceType getSourceType() {
        return this.sourceType;
    }

    @CalledByNative
    public long getTimestampNs() {
        return this.timestampNs;
    }

    @Override // io.agora.base.internal.RefCounted
    @CalledByNative
    public void release() {
        this.buffer.release();
    }

    public void replaceBuffer(Buffer buffer, int i, long j) {
        release();
        this.buffer = buffer;
        this.rotation = i;
        this.timestampNs = j;
    }

    @Override // io.agora.base.internal.RefCounted
    public void retain() {
        this.buffer.retain();
    }

    @CalledByNative
    public VideoFrame(Buffer buffer, int i, long j, ColorSpace colorSpace, byte[] bArr, float f, int i2) {
        this.metaInfo = new VideoFrameMetaInfo();
        if (buffer == null) {
            throw new IllegalArgumentException("buffer not allowed to be null");
        }
        if (i % 90 != 0) {
            throw new IllegalArgumentException("rotation must be a multiple of 90");
        }
        this.buffer = buffer;
        this.rotation = i;
        this.timestampNs = j;
        this.colorSpace = colorSpace;
        this.alphaBuffer = bArr;
        this.sampleAspectRatio = f;
        this.sourceType = SourceType.values()[i2];
    }
}
