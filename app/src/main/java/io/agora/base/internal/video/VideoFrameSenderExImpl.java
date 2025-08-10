package io.agora.base.internal.video;

import android.os.Build;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.agora.base.TextureBuffer;
import io.agora.base.VideoFrame;
import io.agora.base.internal.CalledByNative;
import io.agora.base.internal.Logging;
import io.agora.base.internal.video.EglBase;
import io.agora.base.internal.video.EglBase10;
import io.agora.base.internal.video.EglBase14;
import javax.microedition.khronos.egl.EGLContext;

/* loaded from: classes4.dex */
public class VideoFrameSenderExImpl {
    private static final String TAG = "VideoFrameSenderEx";

    @Nullable
    private EglBase.Context eglContext = null;

    @Nullable
    private SurfaceTextureHelper surfaceTextureHelper = null;

    @Nullable
    private Handler toI420Handler = null;

    @Nullable
    private YuvConverter yuvConverter = null;
    private final Object surfaceTextureHelperLock = new Object();

    public @interface VIDEO_PIXEL_FORMAT {
        public static final int VIDEO_TEXTURE_2D = 10;
        public static final int VIDEO_TEXTURE_OES = 11;
    }

    @CalledByNative
    public VideoFrameSenderExImpl() {
        Logging.d(TAG, "constructor()");
    }

    public static EglBase.Context createEglBaseContext(Object obj) {
        EglBase.Context context;
        if (obj instanceof EglBase.Context) {
            return (EglBase.Context) obj;
        }
        if (obj instanceof EGLContext) {
            context = new EglBase10.Context((EGLContext) obj);
        } else {
            if (Build.VERSION.SDK_INT < 17 || !(obj instanceof android.opengl.EGLContext)) {
                throw new IllegalArgumentException("illegal egl context");
            }
            context = new EglBase14.Context((android.opengl.EGLContext) obj);
        }
        return context;
    }

    private boolean createI420Converter(@NonNull EglBase.Context context) {
        Logging.d(TAG, "createI420Converter()");
        if (this.surfaceTextureHelper != null) {
            dispose();
        }
        synchronized (this.surfaceTextureHelperLock) {
            SurfaceTextureHelper surfaceTextureHelperCreate = SurfaceTextureHelper.create("VideoFrameSender", context);
            this.surfaceTextureHelper = surfaceTextureHelperCreate;
            if (surfaceTextureHelperCreate == null) {
                Logging.e(TAG, "Failed to create surfaceTextureHelper");
                return false;
            }
            this.eglContext = context;
            this.toI420Handler = surfaceTextureHelperCreate.getHandler();
            this.yuvConverter = new YuvConverter();
            return true;
        }
    }

    @Nullable
    @CalledByNative
    public VideoFrame.Buffer completeI420Converter(VideoFrame.Buffer buffer) {
        YuvConverter yuvConverter;
        if (!(buffer instanceof IHandlerReplaceable) && !(buffer instanceof VideoFrame.TextureBuffer)) {
            return buffer;
        }
        IHandlerReplaceable iHandlerReplaceable = (IHandlerReplaceable) buffer;
        if (iHandlerReplaceable.getToI420Handler() != null && iHandlerReplaceable.getYuvConverter() != null) {
            return buffer;
        }
        EglBase.Context eglBaseContext = ((VideoFrame.TextureBuffer) buffer).getEglBaseContext();
        EglBase.Context context = this.eglContext;
        if ((context == null || !context.equals(eglBaseContext)) && !createI420Converter(eglBaseContext)) {
            return null;
        }
        Handler handler = this.toI420Handler;
        if (handler != null && (yuvConverter = this.yuvConverter) != null) {
            return iHandlerReplaceable.applyNewI420Handler(handler, yuvConverter);
        }
        Logging.e(TAG, "converter null");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0036 A[Catch: all -> 0x003e, TryCatch #1 {, blocks: (B:4:0x000a, B:6:0x000e, B:10:0x0032, B:12:0x0036, B:13:0x003c, B:9:0x0018), top: B:20:0x000a, inners: #0 }] */
    @io.agora.base.internal.CalledByNative
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void dispose() {
        /*
            r5 = this;
            java.lang.String r0 = "VideoFrameSenderEx"
            java.lang.String r1 = "dispose()"
            io.agora.base.internal.Logging.d(r0, r1)
            java.lang.Object r0 = r5.surfaceTextureHelperLock
            monitor-enter(r0)
            android.os.Handler r1 = r5.toI420Handler     // Catch: java.lang.Throwable -> L3e
            if (r1 == 0) goto L32
            io.agora.base.internal.video.VideoFrameSenderExImpl$1 r2 = new io.agora.base.internal.video.VideoFrameSenderExImpl$1     // Catch: java.lang.Exception -> L17 java.lang.Throwable -> L3e
            r2.<init>()     // Catch: java.lang.Exception -> L17 java.lang.Throwable -> L3e
            io.agora.base.internal.ThreadUtils.invokeAtFrontUninterruptibly(r1, r2)     // Catch: java.lang.Exception -> L17 java.lang.Throwable -> L3e
            goto L32
        L17:
            r1 = move-exception
            java.lang.String r2 = "VideoFrameSenderEx"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3e
            r3.<init>()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r4 = "yuvConverter release failed:"
            r3.append(r4)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L3e
            r3.append(r1)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L3e
            io.agora.base.internal.Logging.e(r2, r1)     // Catch: java.lang.Throwable -> L3e
        L32:
            io.agora.base.internal.video.SurfaceTextureHelper r1 = r5.surfaceTextureHelper     // Catch: java.lang.Throwable -> L3e
            if (r1 == 0) goto L3c
            r1.dispose()     // Catch: java.lang.Throwable -> L3e
            r1 = 0
            r5.surfaceTextureHelper = r1     // Catch: java.lang.Throwable -> L3e
        L3c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
            return
        L3e:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.base.internal.video.VideoFrameSenderExImpl.dispose():void");
    }

    @Nullable
    @CalledByNative
    public VideoFrame.Buffer newTextureBuffer(Object obj, int i, int i2, int i3, int i4, float[] fArr) {
        VideoFrame.TextureBuffer.Type type;
        EglBase.Context contextCreateEglBaseContext = createEglBaseContext(obj);
        if (i3 == 10) {
            type = VideoFrame.TextureBuffer.Type.RGB;
        } else {
            if (i3 != 11) {
                throw new IllegalArgumentException("illegal pixel format");
            }
            type = VideoFrame.TextureBuffer.Type.OES;
        }
        VideoFrame.TextureBuffer.Type type2 = type;
        if (fArr.length != 16) {
            throw new IllegalArgumentException("unsupported matrix");
        }
        TextureBuffer textureBuffer = new TextureBuffer(contextCreateEglBaseContext, i, i2, type2, i4, RendererCommon.convertMatrixToAndroidGraphicsMatrix(fArr), (Handler) null, (YuvConverter) null, (Runnable) null);
        VideoFrame.Buffer bufferCompleteI420Converter = completeI420Converter(textureBuffer);
        textureBuffer.release();
        return bufferCompleteI420Converter;
    }
}
