package io.agora.base.internal.video;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import io.agora.base.NV12Buffer;
import io.agora.base.NV21Buffer;
import io.agora.base.TextureBuffer;
import io.agora.base.VideoFrame;
import io.agora.base.internal.CalledByNative;
import io.agora.base.internal.Logging;
import io.agora.rtc2.video.VideoCaptureFormat;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class TextureBufferUtil {
    private static final String TAG = "TextureBufferUtil";

    public @interface BufferType {
        public static final int I420 = 0;
        public static final int I422 = 5;
        public static final int NV12 = 4;
        public static final int NV21 = 3;
        public static final int OES_TEXTURE = 1;
        public static final int RGBA = 6;
        public static final int RGB_TEXTURE = 2;
    }

    @CalledByNative
    public static int getVideoFrameBufferType(VideoFrame.Buffer buffer) {
        if (buffer instanceof VideoFrame.I420Buffer) {
            return 0;
        }
        if (buffer instanceof NV12Buffer) {
            return 4;
        }
        if (buffer instanceof NV21Buffer) {
            return 3;
        }
        if (buffer instanceof VideoFrame.TextureBuffer) {
            VideoFrame.TextureBuffer textureBuffer = (VideoFrame.TextureBuffer) buffer;
            if (VideoFrame.TextureBuffer.Type.OES.equals(textureBuffer.getType())) {
                return 1;
            }
            if (VideoFrame.TextureBuffer.Type.RGB.equals(textureBuffer.getType())) {
                return 2;
            }
        } else {
            if (buffer instanceof VideoFrame.I422Buffer) {
                return 5;
            }
            if (buffer instanceof VideoFrame.RgbaBuffer) {
                return 6;
            }
        }
        throw new IllegalStateException("unknown buffer type");
    }

    private static boolean modifyFinalField(Object obj, String str, Object obj2) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        Field declaredField;
        try {
            declaredField = Field.class.getDeclaredField("accessFlags");
        } catch (NoSuchFieldException unused) {
            Logging.e(TAG, "NoSuchFieldException: accessFlags");
            declaredField = null;
        }
        if (declaredField == null) {
            try {
                declaredField = Field.class.getDeclaredField("modifiers");
            } catch (NoSuchFieldException unused2) {
                Logging.e(TAG, "NoSuchFieldException: modifiers");
            }
        }
        if (declaredField == null) {
            return false;
        }
        try {
            declaredField.setAccessible(true);
            try {
                Field declaredField2 = TextureBuffer.class.getDeclaredField(str);
                declaredField.setInt(declaredField2, declaredField2.getModifiers() & (-17));
                declaredField2.setAccessible(true);
                declaredField2.set(obj, obj2);
                return true;
            } catch (IllegalAccessException unused3) {
                Logging.e(TAG, "IllegalAccessException: " + str);
                return false;
            } catch (IllegalArgumentException unused4) {
                Logging.e(TAG, "IllegalArgumentException: " + str);
                return false;
            } catch (NoSuchFieldException unused5) {
                Logging.e(TAG, "NoSuchFieldException: " + str);
                return false;
            } catch (SecurityException unused6) {
                Logging.e(TAG, "SecurityException: " + str);
                return false;
            }
        } catch (SecurityException unused7) {
            Logging.e(TAG, "SecurityException: setAccessible");
            return false;
        }
    }

    @CalledByNative
    private static void replaceTextureBuffer(Object obj, int i, int i2, int i3, int i4, float[] fArr) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        modifyFinalField(obj, VideoCaptureFormat.keyWidth, Integer.valueOf(i));
        modifyFinalField(obj, VideoCaptureFormat.keyHeight, Integer.valueOf(i2));
        modifyFinalField(obj, "type", i3 == 0 ? VideoFrame.TextureBuffer.Type.OES : VideoFrame.TextureBuffer.Type.RGB);
        modifyFinalField(obj, TtmlNode.ATTR_ID, Integer.valueOf(i4));
        modifyFinalField(obj, "transformMatrix", RendererCommon.convertMatrixToAndroidGraphicsMatrix(fArr));
    }
}
