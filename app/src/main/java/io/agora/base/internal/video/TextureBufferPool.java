package io.agora.base.internal.video;

import android.graphics.Matrix;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.Nullable;
import io.agora.base.TextureBuffer;
import io.agora.base.VideoFrame;
import io.agora.base.internal.ATrace;
import io.agora.base.internal.Logging;
import io.agora.base.internal.ThreadUtils;
import io.agora.base.internal.video.EglBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes4.dex */
public class TextureBufferPool {
    private static final boolean SHRINK_POOL = true;
    private static final String TAG = "TextureBufferPool";
    private static final boolean VERBOSE = false;
    private static final AtomicInteger nextSeq = new AtomicInteger(0);
    private final GlRectDrawer drawer;
    private int dropCount;
    private final EglBase eglBase;
    private final EglBase.Context eglContext;
    private final int glPixelFormat;
    private final Handler handler;
    private boolean isQuitting;
    private final int keepBufferCnt;
    private final int maxBufferCnt;
    private final String name;
    private final boolean ownGlThread;
    private final ArrayList<TextureInfo> textureInfoList;
    private final YuvConverter yuvConverter;

    /* renamed from: io.agora.base.internal.video.TextureBufferPool$5, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] $SwitchMap$io$agora$base$VideoFrame$TextureBuffer$Type;

        static {
            int[] iArr = new int[VideoFrame.TextureBuffer.Type.values().length];
            $SwitchMap$io$agora$base$VideoFrame$TextureBuffer$Type = iArr;
            try {
                iArr[VideoFrame.TextureBuffer.Type.OES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$agora$base$VideoFrame$TextureBuffer$Type[VideoFrame.TextureBuffer.Type.RGB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class TextureInfo {
        public int frameBufferId;
        public int textureId;
        public boolean inUse = false;
        public boolean specified = false;
        public int width = 0;
        public int height = 0;

        public TextureInfo(int i, int i2) {
            this.textureId = i;
            this.frameBufferId = i2;
        }

        public String toString() {
            return "TextureInfo{textureId=" + this.textureId + ", frameBufferId=" + this.frameBufferId + ", inUse=" + this.inUse + ", specified=" + this.specified + ", width=" + this.width + ", height=" + this.height + MessageFormatter.DELIM_STOP;
        }
    }

    private TextureInfo acquireTextureFramebuffer() {
        TextureInfo next;
        Iterator<TextureInfo> it = this.textureInfoList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!next.inUse) {
                break;
            }
        }
        if (next == null) {
            if (this.textureInfoList.size() >= this.maxBufferCnt) {
                int i = this.dropCount + 1;
                this.dropCount = i;
                ATrace.traceCounter("Drop@TexPool", i);
                return null;
            }
            int iGenerateTexture = GlUtil.generateTexture(3553);
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            TextureInfo textureInfo = new TextureInfo(iGenerateTexture, iArr[0]);
            this.textureInfoList.add(textureInfo);
            next = textureInfo;
        }
        next.inUse = true;
        return next;
    }

    public static TextureBufferPool create(final String str, final EglBase.Context context, final int i) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        final Handler handler = new Handler(handlerThread.getLooper());
        final TextureBufferPool[] textureBufferPoolArr = {null};
        try {
            ThreadUtils.invokeAtFrontUninterruptibly(handler, new Runnable() { // from class: io.agora.base.internal.video.TextureBufferPool.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        textureBufferPoolArr[0] = new TextureBufferPool(str, i, 6408, handler, true, TextureBufferPool.createEglAndMakeCurrent(context), null);
                    } catch (RuntimeException e) {
                        Logging.e(TextureBufferPool.TAG, str + " failed to initialize egl", e);
                        handler.getLooper().quit();
                    }
                }
            });
        } catch (Exception e) {
            Logging.e(TAG, str + " failed to initialize egl", e);
        }
        return textureBufferPoolArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static EglBase createEglAndMakeCurrent(EglBase.Context context) {
        EglBase eglBaseCreate = EglBaseFactory.create(context, EglBase.CONFIG_PIXEL_BUFFER);
        try {
            eglBaseCreate.createDummyPbufferSurface();
            eglBaseCreate.makeCurrent();
            return eglBaseCreate;
        } catch (RuntimeException e) {
            eglBaseCreate.release();
            throw e;
        }
    }

    public static TextureBufferPool createWithinGlThread(String str, int i, int i2, Handler handler, EglBase eglBase, YuvConverter yuvConverter) {
        return new TextureBufferPool(str, i, i2, handler, false, eglBase, yuvConverter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoFrame.TextureBuffer doTextureCopy(int i, VideoFrame.TextureBuffer.Type type, int i2, int i3, Matrix matrix, final Runnable runnable) {
        final TextureInfo textureInfoAcquireTextureFramebuffer = acquireTextureFramebuffer();
        if (textureInfoAcquireTextureFramebuffer == null) {
            Logging.w(TAG, "acquireTextureFramebuffer: " + this.name + " dispose()");
            return null;
        }
        ATrace.beginSection("setupTextureFrameBuffer");
        boolean z = setupTextureFrameBuffer(textureInfoAcquireTextureFramebuffer, i2, i3);
        ATrace.endSection();
        if (!z) {
            Logging.w(TAG, "setupTextureFrameBuffer: " + this.name + " !success");
            releaseTextureFramebuffer(textureInfoAcquireTextureFramebuffer);
            return null;
        }
        GLES20.glBindFramebuffer(36160, textureInfoAcquireTextureFramebuffer.frameBufferId);
        ATrace.beginSection("drawTexture");
        drawTexture(i, type, i2, i3);
        ATrace.endSection();
        ATrace.beginSection("flush");
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
        GLES20.glFlush();
        ATrace.endSection();
        final TextureBuffer[] textureBufferArr = new TextureBuffer[1];
        textureBufferArr[0] = new TextureBuffer(this.eglContext, i2, i3, VideoFrame.TextureBuffer.Type.RGB, textureInfoAcquireTextureFramebuffer.textureId, matrix, this.handler, this.yuvConverter, new Runnable() { // from class: io.agora.base.internal.video.TextureBufferPool.4
            @Override // java.lang.Runnable
            public void run() {
                TextureBufferPool.this.handler.post(new Runnable() { // from class: io.agora.base.internal.video.TextureBufferPool.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        TextureBufferPool.this.releaseTextureFramebuffer(textureInfoAcquireTextureFramebuffer);
                        if (TextureBufferPool.this.isQuitting && !TextureBufferPool.this.anyTextureInUse()) {
                            Logging.d(TextureBufferPool.TAG, TextureBufferPool.this.name + " ready to release since no buffer in flight");
                            TextureBufferPool.this.release();
                        }
                        Runnable runnable2 = runnable;
                        if (runnable2 != null) {
                            runnable2.run();
                        }
                    }
                });
            }
        }).withSequence(nextSeq.getAndIncrement());
        return textureBufferArr[0];
    }

    private void drawTexture(int i, VideoFrame.TextureBuffer.Type type, int i2, int i3) {
        GLES20.glClear(16384);
        int i4 = AnonymousClass5.$SwitchMap$io$agora$base$VideoFrame$TextureBuffer$Type[type.ordinal()];
        if (i4 == 1) {
            this.drawer.drawOes(i, GlUtil.IDENTITY_MATRIX, i2, i3, 0, 0, i2, i3);
        } else {
            if (i4 != 2) {
                throw new IllegalArgumentException("Unknown texture type.");
            }
            this.drawer.drawRgb(i, GlUtil.IDENTITY_MATRIX, i2, i3, 0, 0, i2, i3);
        }
        GlUtil.checkNoGLES2Error("TextureBufferPool.drawFrameBuffer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        Logging.d(TAG, this.name + " release()");
        if (!this.textureInfoList.isEmpty()) {
            int size = this.textureInfoList.size();
            int[] iArr = new int[size];
            int[] iArr2 = new int[size];
            for (int i = 0; i < size; i++) {
                TextureInfo textureInfo = this.textureInfoList.get(i);
                iArr[i] = textureInfo.textureId;
                iArr2[i] = textureInfo.frameBufferId;
            }
            Logging.d(TAG, this.name + ": delete textures " + Arrays.toString(iArr));
            GLES20.glDeleteTextures(size, iArr, 0);
            GLES20.glDeleteFramebuffers(1, iArr2, 0);
            this.textureInfoList.clear();
        }
        this.drawer.release();
        if (this.ownGlThread) {
            EglBase eglBase = this.eglBase;
            if (eglBase != null) {
                eglBase.release();
            }
            this.handler.getLooper().quit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseTextureFramebuffer(TextureInfo textureInfo) {
        textureInfo.inUse = false;
        int iIndexOf = this.textureInfoList.indexOf(textureInfo);
        if (iIndexOf < 0) {
            Logging.e(TAG, "texture info not found!");
        } else if (iIndexOf >= this.keepBufferCnt) {
            GLES20.glDeleteTextures(1, new int[]{textureInfo.textureId}, 0);
            GLES20.glDeleteFramebuffers(1, new int[]{textureInfo.frameBufferId}, 0);
            this.textureInfoList.remove(iIndexOf);
        }
    }

    private boolean setupTextureFrameBuffer(TextureInfo textureInfo, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            Logging.w(TAG, "Invalid size: " + i + "x" + i2);
            return false;
        }
        if (textureInfo.specified && textureInfo.width == i && textureInfo.height == i2) {
            return true;
        }
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, textureInfo.textureId);
        ATrace.beginSection("glTexImage2D");
        int i3 = this.glPixelFormat;
        GLES20.glTexImage2D(3553, 0, i3, i, i2, 0, i3, 5121, null);
        ATrace.endSection();
        GlUtil.checkNoGLES2Error("TextureBufferPool.glTexImage2D");
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, textureInfo.frameBufferId);
        ATrace.beginSection("glFramebufferTexture2D");
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, textureInfo.textureId, 0);
        ATrace.endSection();
        int iGlCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        GLES20.glBindFramebuffer(36160, 0);
        if (iGlCheckFramebufferStatus == 36053) {
            textureInfo.specified = true;
            textureInfo.width = i;
            textureInfo.height = i2;
            return true;
        }
        Logging.w(TAG, "Framebuffer not complete, status: " + iGlCheckFramebufferStatus);
        return false;
    }

    public boolean anyTextureInUse() {
        Iterator<TextureInfo> it = this.textureInfoList.iterator();
        while (it.hasNext()) {
            if (it.next().inUse) {
                return true;
            }
        }
        return false;
    }

    public void dispose() {
        Logging.d(TAG, this.name + " dispose()");
        try {
            ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new Runnable() { // from class: io.agora.base.internal.video.TextureBufferPool.3
                @Override // java.lang.Runnable
                public void run() {
                    TextureBufferPool.this.isQuitting = true;
                    if (TextureBufferPool.this.anyTextureInUse()) {
                        return;
                    }
                    Logging.d(TextureBufferPool.TAG, TextureBufferPool.this.name + " ready to release since no more buffer in flight");
                    TextureBufferPool.this.release();
                }
            });
        } catch (Exception e) {
            Logging.d(TAG, this.name + " dispose fail: " + e.getMessage());
        }
    }

    public VideoFrame.TextureBuffer textureCopy(VideoFrame.TextureBuffer textureBuffer, Runnable runnable) {
        if (textureBuffer != null) {
            return textureCopy(textureBuffer.getTextureId(), textureBuffer.getType(), textureBuffer.getWidth(), textureBuffer.getHeight(), textureBuffer.getTransformMatrix(), runnable);
        }
        Logging.w(TAG, "textureCopy: " + this.name + " textureBuffer null");
        return null;
    }

    private TextureBufferPool(String str, int i, int i2, Handler handler, boolean z, EglBase eglBase, YuvConverter yuvConverter) {
        this.textureInfoList = new ArrayList<>();
        this.isQuitting = false;
        this.dropCount = 0;
        Logging.d(TAG, str + " init buffer pool, ownGlThread: " + z + " cnt: " + i);
        this.name = str;
        int iMax = Math.max(i, 1);
        this.maxBufferCnt = iMax;
        this.keepBufferCnt = Math.min(iMax, 3);
        this.glPixelFormat = i2;
        this.handler = handler;
        this.ownGlThread = z;
        this.eglBase = eglBase;
        this.yuvConverter = yuvConverter == null ? new YuvConverter() : yuvConverter;
        this.eglContext = eglBase.getEglBaseContext();
        this.drawer = new GlRectDrawer();
    }

    @Nullable
    public VideoFrame.TextureBuffer textureCopy(final int i, final VideoFrame.TextureBuffer.Type type, final int i2, final int i3, final Matrix matrix, final Runnable runnable) {
        try {
            return (VideoFrame.TextureBuffer) ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new Callable<VideoFrame.TextureBuffer>() { // from class: io.agora.base.internal.video.TextureBufferPool.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public VideoFrame.TextureBuffer call() throws Exception {
                    return TextureBufferPool.this.doTextureCopy(i, type, i2, i3, matrix, runnable);
                }
            });
        } catch (Exception e) {
            Logging.w(TAG, "textureCopy faile: " + e.getMessage());
            return null;
        }
    }
}
