package io.agora.base.internal.video;

import android.graphics.Matrix;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.agora.base.VideoFrame;
import io.agora.base.internal.CalledByNative;
import io.agora.base.internal.JniCommon;
import io.agora.base.internal.ThreadUtils;
import io.agora.base.internal.video.EglBase;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public class WrappedNativeTextureBuffer implements VideoFrame.TextureBuffer, IHandlerReplaceable {

    @Nullable
    private final VideoFrame.ColorSpace colorSpace;

    @NonNull
    private final EglBase.Context eglContext;
    private final int height;
    private final int id;
    private long nativeRefCountedPointer;
    private final Object nativeRefLock;

    @Nullable
    private final Handler toI420Handler;
    private final Matrix transformMatrix;
    private final VideoFrame.TextureBuffer.Type type;
    private final int width;

    @Nullable
    private final YuvConverter yuvConverter;

    @CalledByNative
    public WrappedNativeTextureBuffer(@NonNull EglBase.Context context, int i, int i2, boolean z, int i3, float[] fArr, @Nullable Handler handler, @Nullable YuvConverter yuvConverter, long j, int i4, int i5, int i6, int i7) {
        this(context, i, i2, z ? VideoFrame.TextureBuffer.Type.OES : VideoFrame.TextureBuffer.Type.RGB, i3, RendererCommon.convertMatrixToAndroidGraphicsMatrix(fArr), handler, yuvConverter, j, new WrappedNativeColorSpace(i4, i5, i6, i7));
    }

    @Override // io.agora.base.internal.video.IHandlerReplaceable
    public VideoFrame.Buffer applyNewI420Handler(@NonNull Handler handler, @NonNull YuvConverter yuvConverter) {
        WrappedNativeTextureBuffer wrappedNativeTextureBuffer;
        synchronized (this.nativeRefLock) {
            wrappedNativeTextureBuffer = new WrappedNativeTextureBuffer(this.eglContext, this.width, this.height, this.type, this.id, this.transformMatrix, handler, yuvConverter, this.nativeRefCountedPointer, this.colorSpace);
        }
        return wrappedNativeTextureBuffer;
    }

    @CalledByNative
    public void applyNewRefCountedPointer(long j) {
        synchronized (this.nativeRefLock) {
            release();
            this.nativeRefCountedPointer = j;
            retain();
        }
    }

    public WrappedNativeTextureBuffer applyTransformMatrix(Matrix matrix, int i, int i2) {
        WrappedNativeTextureBuffer wrappedNativeTextureBuffer;
        Matrix matrix2 = new Matrix(this.transformMatrix);
        matrix2.preConcat(matrix);
        synchronized (this.nativeRefLock) {
            wrappedNativeTextureBuffer = new WrappedNativeTextureBuffer(this.eglContext, i, i2, this.type, this.id, matrix2, this.toI420Handler, this.yuvConverter, this.nativeRefCountedPointer, this.colorSpace);
        }
        return wrappedNativeTextureBuffer;
    }

    @Override // io.agora.base.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int i, int i2, int i3, int i4, int i5, int i6) {
        Matrix matrix = new Matrix();
        matrix.preTranslate(i / this.width, (r1 - (i2 + i4)) / this.height);
        matrix.preScale(i3 / this.width, i4 / this.height);
        return applyTransformMatrix(matrix, i5, i6);
    }

    @Override // io.agora.base.VideoFrame.TextureBuffer
    @NonNull
    public EglBase.Context getEglBaseContext() {
        return this.eglContext;
    }

    @Override // io.agora.base.VideoFrame.TextureBuffer
    public int getEglContextType() {
        return EglBaseFactory.isEglBase14(this.eglContext) ? VideoFrame.TextureBuffer.ContextType.EGL_CONTEXT_14.ordinal() : VideoFrame.TextureBuffer.ContextType.EGL_CONTEXT_10.ordinal();
    }

    @Override // io.agora.base.VideoFrame.Buffer
    public int getHeight() {
        return this.height;
    }

    @Override // io.agora.base.VideoFrame.TextureBuffer
    public long getNativeEglContext() {
        return this.eglContext.getNativeEglContext();
    }

    @Override // io.agora.base.VideoFrame.TextureBuffer
    public int getSequence() {
        return 0;
    }

    @Override // io.agora.base.VideoFrame.TextureBuffer
    public int getTextureId() {
        return this.id;
    }

    @Override // io.agora.base.internal.video.IHandlerReplaceable
    @Nullable
    public Handler getToI420Handler() {
        return this.toI420Handler;
    }

    @Override // io.agora.base.VideoFrame.TextureBuffer
    public Matrix getTransformMatrix() {
        return this.transformMatrix;
    }

    @Override // io.agora.base.VideoFrame.TextureBuffer
    public float[] getTransformMatrixArray() {
        return RendererCommon.convertMatrixFromAndroidGraphicsMatrix(this.transformMatrix);
    }

    @Override // io.agora.base.VideoFrame.TextureBuffer
    public VideoFrame.TextureBuffer.Type getType() {
        return this.type;
    }

    @Override // io.agora.base.VideoFrame.Buffer
    public int getWidth() {
        return this.width;
    }

    @Override // io.agora.base.internal.video.IHandlerReplaceable
    @Nullable
    public YuvConverter getYuvConverter() {
        return this.yuvConverter;
    }

    @Override // io.agora.base.VideoFrame.Buffer
    public VideoFrame.Buffer mirror(int i) {
        Matrix matrix = new Matrix();
        matrix.preTranslate(0.5f, 0.5f);
        if (i == 90 || i == 270) {
            matrix.preScale(1.0f, -1.0f);
        } else {
            matrix.preScale(-1.0f, 1.0f);
        }
        matrix.preTranslate(-0.5f, -0.5f);
        return applyTransformMatrix(matrix, getWidth(), getHeight());
    }

    @Override // io.agora.base.VideoFrame.Buffer, io.agora.base.internal.RefCounted
    public void release() {
        JniCommon.nativeReleaseRef(this.nativeRefCountedPointer);
    }

    @Override // io.agora.base.VideoFrame.Buffer, io.agora.base.internal.RefCounted
    public void retain() {
        JniCommon.nativeAddRef(this.nativeRefCountedPointer);
    }

    @Override // io.agora.base.VideoFrame.Buffer
    public VideoFrame.Buffer rotate(int i) {
        Matrix matrix = new Matrix();
        int height = (i == 90 || i == 270) ? getHeight() : getWidth();
        int width = (i == 90 || i == 270) ? getWidth() : getHeight();
        matrix.preTranslate(0.5f, 0.5f);
        matrix.preRotate(i);
        matrix.preTranslate(-0.5f, -0.5f);
        return applyTransformMatrix(matrix, height, width);
    }

    @Override // io.agora.base.VideoFrame.Buffer
    @Nullable
    public VideoFrame.I420Buffer toI420() {
        Handler handler = this.toI420Handler;
        if (handler == null || this.yuvConverter == null) {
            throw new IllegalStateException("toI420Handler or yuvConverter is null");
        }
        try {
            return (VideoFrame.I420Buffer) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<VideoFrame.I420Buffer>() { // from class: io.agora.base.internal.video.WrappedNativeTextureBuffer.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public VideoFrame.I420Buffer call() throws Exception {
                    YuvConverter yuvConverter = WrappedNativeTextureBuffer.this.yuvConverter;
                    WrappedNativeTextureBuffer wrappedNativeTextureBuffer = WrappedNativeTextureBuffer.this;
                    return yuvConverter.convert(wrappedNativeTextureBuffer, wrappedNativeTextureBuffer.colorSpace);
                }
            });
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // io.agora.base.VideoFrame.Buffer
    @Nullable
    public VideoFrame.Buffer transform(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        Matrix matrix = new Matrix();
        matrix.preTranslate(i / this.width, (r1 - (i2 + i4)) / this.height);
        matrix.preScale(i3 / this.width, i4 / this.height);
        if (i5 > 0 && i6 > 0 && i7 == 0) {
            return applyTransformMatrix(matrix, i5, i6);
        }
        matrix.preTranslate(0.5f, 0.5f);
        if (i5 < 0) {
            matrix.preScale(-1.0f, 1.0f);
            i5 = -i5;
        }
        if (i6 < 0) {
            matrix.preScale(1.0f, -1.0f);
            i6 = -i6;
        }
        if (i7 == 90 || i7 == 270) {
            int i8 = i6;
            i6 = i5;
            i5 = i8;
        }
        if (i7 != 0) {
            matrix.preRotate(i7);
        }
        matrix.preTranslate(-0.5f, -0.5f);
        return applyTransformMatrix(matrix, i5, i6);
    }

    public WrappedNativeTextureBuffer(@NonNull EglBase.Context context, int i, int i2, VideoFrame.TextureBuffer.Type type, int i3, Matrix matrix, @Nullable Handler handler, @Nullable YuvConverter yuvConverter, long j, @Nullable VideoFrame.ColorSpace colorSpace) {
        Object obj = new Object();
        this.nativeRefLock = obj;
        this.eglContext = context;
        this.width = i;
        this.height = i2;
        this.type = type;
        this.id = i3;
        this.transformMatrix = matrix;
        this.toI420Handler = handler;
        this.yuvConverter = yuvConverter;
        this.colorSpace = colorSpace;
        synchronized (obj) {
            this.nativeRefCountedPointer = j;
            retain();
        }
    }
}
