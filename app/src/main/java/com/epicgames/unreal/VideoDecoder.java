package com.epicgames.unreal;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Build;
import android.view.Surface;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes.dex */
public class VideoDecoder {
    private byte[] PPS;
    private byte[] SPS;
    private boolean SupportsImageExternal;
    private boolean SwizzlePixels;
    private boolean VulkanRenderer;
    private volatile boolean WaitOnBitmapRender;
    private int FrameWidth = 0;
    private int FrameHeight = 0;
    private BitmapRenderer mBitmapRenderer = null;
    private OESTextureRenderer mOESTextureRenderer = null;
    private MediaCodec mVideoCodec = null;
    private MediaCodec mAudioCodec = null;
    private Surface mVideoCodecSurface = null;
    private boolean isEOS = false;
    private boolean bIsInitialized = false;
    private volatile boolean NewFrameAvailable = true;
    public LinkedList<Map.Entry<Double, Double>> frameTimeDurationList = new LinkedList<>();

    public class FrameUpdateInfo {
        public Buffer Buffer;
        public double Duration;
        public boolean FrameReady;
        public boolean RegionChanged;
        public double Timestamp;
        public float UOffset;
        public float UScale;
        public float VOffset;
        public float VScale;

        public FrameUpdateInfo() {
        }
    }

    public class OESTextureRenderer implements SurfaceTexture.OnFrameAvailableListener {
        private Surface mSurface;
        private SurfaceTexture mSurfaceTexture;
        private int mTextureID;
        private int mTextureWidth = -1;
        private int mTextureHeight = -1;
        private boolean mFrameAvailable = false;
        private float[] mTransformMatrix = new float[16];
        private boolean mTextureSizeChanged = true;
        private int GL_TEXTURE_EXTERNAL_OES = 36197;
        private float mUScale = 1.0f;
        private float mVScale = -1.0f;
        private float mUOffset = 0.0f;
        private float mVOffset = 1.0f;

        public OESTextureRenderer(int i) {
            this.mSurfaceTexture = null;
            this.mSurface = null;
            this.mTextureID = -1;
            this.mTextureID = i;
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureID);
            this.mSurfaceTexture = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
            this.mSurface = new Surface(this.mSurfaceTexture);
        }

        private FrameUpdateInfo getFrameUpdateInfo() {
            FrameUpdateInfo frameUpdateInfo = VideoDecoder.this.new FrameUpdateInfo();
            frameUpdateInfo.FrameReady = false;
            frameUpdateInfo.RegionChanged = false;
            frameUpdateInfo.UScale = this.mUScale;
            frameUpdateInfo.UOffset = this.mUOffset;
            frameUpdateInfo.VScale = -this.mVScale;
            frameUpdateInfo.VOffset = 1.0f - this.mVOffset;
            if (!this.mFrameAvailable) {
                return frameUpdateInfo;
            }
            this.mFrameAvailable = false;
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture == null) {
                return frameUpdateInfo;
            }
            frameUpdateInfo.FrameReady = true;
            surfaceTexture.updateTexImage();
            this.mSurfaceTexture.getTransformMatrix(this.mTransformMatrix);
            float f = this.mUScale;
            float[] fArr = this.mTransformMatrix;
            if (f != fArr[0] || this.mVScale != fArr[5] || this.mUOffset != fArr[12] || this.mVOffset != fArr[13]) {
                float f2 = fArr[0];
                this.mUScale = f2;
                float f3 = fArr[5];
                this.mVScale = f3;
                float f4 = fArr[12];
                this.mUOffset = f4;
                float f5 = fArr[13];
                this.mVOffset = f5;
                frameUpdateInfo.RegionChanged = true;
                frameUpdateInfo.UScale = f2;
                frameUpdateInfo.UOffset = f4;
                frameUpdateInfo.VScale = -f3;
                frameUpdateInfo.VOffset = 1.0f - f5;
            }
            VideoDecoder videoDecoder = VideoDecoder.this;
            Map.Entry<Double, Double> frameTimeDuration = videoDecoder.getFrameTimeDuration(videoDecoder.getFrameTimestamp());
            frameUpdateInfo.Timestamp = frameTimeDuration.getKey().doubleValue();
            frameUpdateInfo.Duration = frameTimeDuration.getValue().doubleValue();
            GLES20.glBindTexture(this.GL_TEXTURE_EXTERNAL_OES, 0);
            return frameUpdateInfo;
        }

        public int getExternalTextureId() {
            return this.mTextureID;
        }

        public Surface getSurface() {
            return this.mSurface;
        }

        public SurfaceTexture getSurfaceTexture() {
            return this.mSurfaceTexture;
        }

        public boolean isValid() {
            return this.mSurfaceTexture != null;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            synchronized (this) {
                this.mFrameAvailable = true;
            }
        }

        public void release() {
            Surface surface = this.mSurface;
            if (surface != null) {
                surface.release();
                this.mSurface = null;
            }
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.mSurfaceTexture = null;
            }
        }

        public boolean resolutionChanged() {
            boolean z;
            synchronized (this) {
                z = this.mTextureSizeChanged;
                this.mTextureSizeChanged = false;
            }
            return z;
        }

        public void setSize(int i, int i2) {
            synchronized (this) {
                if (i != this.mTextureWidth || i2 != this.mTextureHeight) {
                    this.mTextureWidth = i;
                    this.mTextureHeight = i2;
                    this.mTextureSizeChanged = true;
                }
            }
        }

        public FrameUpdateInfo updateVideoFrame() {
            FrameUpdateInfo frameUpdateInfo;
            synchronized (this) {
                frameUpdateInfo = getFrameUpdateInfo();
            }
            return frameUpdateInfo;
        }
    }

    public VideoDecoder(boolean z, boolean z2, boolean z3) {
        this.SwizzlePixels = true;
        this.VulkanRenderer = false;
        this.SupportsImageExternal = false;
        this.WaitOnBitmapRender = false;
        this.SwizzlePixels = z;
        this.VulkanRenderer = z2;
        this.SupportsImageExternal = z3;
        this.WaitOnBitmapRender = false;
    }

    private boolean CreateBitmapRenderer() {
        releaseBitmapRenderer();
        BitmapRenderer bitmapRenderer = new BitmapRenderer(this.SwizzlePixels, this.VulkanRenderer);
        this.mBitmapRenderer = bitmapRenderer;
        if (!bitmapRenderer.isValid()) {
            this.mBitmapRenderer = null;
            return false;
        }
        this.mBitmapRenderer.setSize(this.FrameWidth, this.FrameHeight);
        this.mVideoCodecSurface = this.mBitmapRenderer.getSurface();
        CreateCodec();
        return true;
    }

    private boolean CreateCodec() {
        try {
            this.mVideoCodec = MediaCodec.createDecoderByType(MimeTypes.VIDEO_H264);
            MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(MimeTypes.VIDEO_H264, this.FrameWidth, this.FrameHeight);
            mediaFormatCreateVideoFormat.setByteBuffer("csd-0", getSPSPPSHeader());
            mediaFormatCreateVideoFormat.setInteger("max-input-size", this.FrameWidth * this.FrameHeight);
            mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
            mediaFormatCreateVideoFormat.setInteger("frame-rate", 30);
            mediaFormatCreateVideoFormat.setInteger("capture-rate", 30);
            this.isEOS = false;
            this.mVideoCodec.configure(mediaFormatCreateVideoFormat, this.mVideoCodecSurface, (MediaCrypto) null, 0);
            this.mVideoCodec.start();
            this.bIsInitialized = true;
            return true;
        } catch (Exception e) {
            GameActivity.Log.warn("Android Video Decoder: CreateCodec failed!");
            e.printStackTrace();
            return false;
        }
    }

    private boolean CreateOESTextureRenderer(int i) {
        releaseOESTextureRenderer();
        OESTextureRenderer oESTextureRenderer = new OESTextureRenderer(i);
        this.mOESTextureRenderer = oESTextureRenderer;
        if (!oESTextureRenderer.isValid()) {
            this.mOESTextureRenderer = null;
            return false;
        }
        this.mOESTextureRenderer.setSize(this.FrameWidth, this.FrameHeight);
        this.mVideoCodecSurface = this.mOESTextureRenderer.getSurface();
        CreateCodec();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double getFrameTimestamp() {
        OESTextureRenderer oESTextureRenderer = this.mOESTextureRenderer;
        SurfaceTexture surfaceTexture = oESTextureRenderer != null ? oESTextureRenderer.getSurfaceTexture() : null;
        BitmapRenderer bitmapRenderer = this.mBitmapRenderer;
        if (bitmapRenderer != null) {
            surfaceTexture = bitmapRenderer.getSurfaceTexture();
        }
        if (surfaceTexture != null) {
            return surfaceTexture.getTimestamp() / 1000;
        }
        return -1.0d;
    }

    private ByteBuffer getSPSPPSHeader() {
        byte[] bArr = {0, 0, 0, 1};
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.SPS.length + this.PPS.length + 8);
        byteBufferAllocate.put(bArr);
        byteBufferAllocate.put(this.SPS);
        byteBufferAllocate.put(bArr);
        byteBufferAllocate.put(this.PPS);
        return byteBufferAllocate;
    }

    public boolean DecodeVideo(byte[] bArr, double d, double d2) {
        if (this.mVideoCodec != null) {
            try {
                synchronized (this) {
                    int iDequeueInputBuffer = this.mVideoCodec.dequeueInputBuffer(-1L);
                    if (iDequeueInputBuffer >= 0) {
                        int length = bArr.length;
                        ByteBuffer inputBuffer = this.mVideoCodec.getInputBuffer(iDequeueInputBuffer);
                        inputBuffer.clear();
                        inputBuffer.put(bArr);
                        inputBuffer.clear();
                        this.mVideoCodec.queueInputBuffer(iDequeueInputBuffer, 0, length, (long) d, 0);
                    }
                    MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                    int iDequeueOutputBuffer = this.mVideoCodec.dequeueOutputBuffer(bufferInfo, -1L);
                    if (iDequeueOutputBuffer == -3) {
                        GameActivity.Log.debug("Android Video Decoder: INFO_OUTPUT_BUFFERS_CHANGED");
                    } else if (iDequeueOutputBuffer == -2) {
                        GameActivity.Log.debug("Android Video Decoder: New format" + this.mVideoCodec.getOutputFormat());
                    } else if (iDequeueOutputBuffer != -1) {
                        addFrameTimeDuration(d, d2);
                        this.mVideoCodec.releaseOutputBuffer(iDequeueOutputBuffer, (bufferInfo.size == 0 || (bufferInfo.flags & 2) == 2) ? false : true);
                    } else {
                        GameActivity.Log.debug("Android Video Decoder: dequeueOutputBuffer timed out!");
                    }
                    if ((bufferInfo.flags & 4) != 0) {
                        GameActivity.Log.warn("OutputBuffer BUFFER_FLAG_END_OF_STREAM");
                    }
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void addFrameTimeDuration(double d, double d2) {
        synchronized (this) {
            this.frameTimeDurationList.add(new AbstractMap.SimpleEntry(Double.valueOf(d), Double.valueOf(d2)));
        }
    }

    public boolean didResolutionChange() {
        OESTextureRenderer oESTextureRenderer = this.mOESTextureRenderer;
        if (oESTextureRenderer != null) {
            return oESTextureRenderer.resolutionChanged();
        }
        BitmapRenderer bitmapRenderer = this.mBitmapRenderer;
        if (bitmapRenderer != null) {
            return bitmapRenderer.resolutionChanged();
        }
        return false;
    }

    public int getExternalTextureId() {
        OESTextureRenderer oESTextureRenderer = this.mOESTextureRenderer;
        if (oESTextureRenderer != null) {
            return oESTextureRenderer.getExternalTextureId();
        }
        BitmapRenderer bitmapRenderer = this.mBitmapRenderer;
        if (bitmapRenderer != null) {
            return bitmapRenderer.getExternalTextureId();
        }
        return -1;
    }

    public Map.Entry<Double, Double> getFrameTimeDuration(double d) {
        Map.Entry simpleEntry = new AbstractMap.SimpleEntry(Double.valueOf(d), Double.valueOf(100.0d));
        synchronized (this) {
            ListIterator<Map.Entry<Double, Double>> listIterator = this.frameTimeDurationList.listIterator();
            while (listIterator.hasNext()) {
                Map.Entry next = listIterator.next();
                double dAbs = Math.abs(((Double) simpleEntry.getKey()).doubleValue() - d);
                if (d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && ((Double) next.getKey()).doubleValue() != d) {
                    if (dAbs != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && dAbs > Math.abs(d - ((Double) next.getKey()).doubleValue())) {
                        simpleEntry = next;
                    }
                }
                simpleEntry = next;
            }
        }
        this.frameTimeDurationList.remove(simpleEntry);
        return simpleEntry;
    }

    public FrameUpdateInfo getVideoLastFrame(int i) {
        initBitmapRenderer();
        if (this.mBitmapRenderer == null) {
            return null;
        }
        this.WaitOnBitmapRender = true;
        FrameUpdateInfo frameUpdateInfoUpdateFrameData = this.mBitmapRenderer.updateFrameData(i);
        this.WaitOnBitmapRender = false;
        return frameUpdateInfoUpdateFrameData;
    }

    public FrameUpdateInfo getVideoLastFrameData() {
        initBitmapRenderer();
        if (this.mBitmapRenderer == null) {
            return null;
        }
        this.WaitOnBitmapRender = true;
        FrameUpdateInfo frameUpdateInfoUpdateFrameData = this.mBitmapRenderer.updateFrameData();
        this.WaitOnBitmapRender = false;
        return frameUpdateInfoUpdateFrameData;
    }

    public void initBitmapRenderer() {
        if (this.mBitmapRenderer != null || CreateBitmapRenderer()) {
            return;
        }
        GameActivity.Log.warn("initBitmapRenderer failed to alloc mBitmapRenderer ");
        release();
    }

    public boolean isCodecReady() {
        return this.bIsInitialized;
    }

    public native void nativeClearCachedAttributeState(int i, int i2);

    public void release() {
        if (this.mOESTextureRenderer != null) {
            while (this.WaitOnBitmapRender) {
            }
            releaseOESTextureRenderer();
        }
        if (this.mBitmapRenderer != null) {
            while (this.WaitOnBitmapRender) {
            }
            releaseOESTextureRenderer();
        }
        resetCodec();
    }

    public void releaseBitmapRenderer() {
        BitmapRenderer bitmapRenderer = this.mBitmapRenderer;
        if (bitmapRenderer != null) {
            bitmapRenderer.release();
            this.mBitmapRenderer = null;
        }
    }

    public void releaseOESTextureRenderer() {
        OESTextureRenderer oESTextureRenderer = this.mOESTextureRenderer;
        if (oESTextureRenderer != null) {
            oESTextureRenderer.release();
            this.mOESTextureRenderer = null;
        }
    }

    public void resetCodec() {
        synchronized (this) {
            MediaCodec mediaCodec = this.mVideoCodec;
            if (mediaCodec != null) {
                try {
                    mediaCodec.stop();
                    this.mVideoCodec.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean updateConfig(int i, int i2, byte[] bArr, byte[] bArr2) {
        this.bIsInitialized = false;
        this.FrameWidth = i;
        this.FrameHeight = i2;
        this.SPS = bArr;
        this.PPS = bArr2;
        if (this.mVideoCodec == null) {
            return true;
        }
        resetCodec();
        return CreateCodec();
    }

    public FrameUpdateInfo updateVideoFrame(int i) {
        if (this.mOESTextureRenderer == null && !CreateOESTextureRenderer(i)) {
            GameActivity.Log.warn("updateVideoFrame failed to alloc mOESTextureRenderer ");
            release();
            return null;
        }
        this.WaitOnBitmapRender = true;
        FrameUpdateInfo frameUpdateInfoUpdateVideoFrame = this.mOESTextureRenderer.updateVideoFrame();
        this.WaitOnBitmapRender = false;
        return frameUpdateInfoUpdateVideoFrame;
    }

    public class BitmapRenderer implements SurfaceTexture.OnFrameAvailableListener {
        private static final int FLOAT_SIZE_BYTES = 4;
        private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
        private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 16;
        private static final int TRIANGLE_VERTICES_DATA_UV_OFFSET = 2;
        private int mBlitBuffer;
        private EGLDisplay mEglDisplay;
        private int mPositionAttrib;
        private int mProgram;
        private EGLContext mSavedContext;
        private EGLDisplay mSavedDisplay;
        private EGLSurface mSavedSurfaceDraw;
        private EGLSurface mSavedSurfaceRead;
        private boolean mSwizzlePixels;
        private int mTexCoordsAttrib;
        private int mTextureUniform;
        private FloatBuffer mTriangleVertices;
        private boolean mUseOwnContext;
        private boolean mVulkanRenderer;
        private Buffer mFrameData = null;
        private SurfaceTexture mSurfaceTexture = null;
        private int mTextureWidth = -1;
        private int mTextureHeight = -1;
        private Surface mSurface = null;
        private boolean mFrameAvailable = false;
        private int mTextureID = -1;
        private int mFBO = -1;
        private int mBlitVertexShaderID = -1;
        private int mBlitFragmentShaderID = -1;
        private float[] mTransformMatrix = new float[16];
        private boolean mTriangleVerticesDirty = true;
        private boolean mTextureSizeChanged = true;
        private int GL_TEXTURE_EXTERNAL_OES = 36197;
        private boolean mCreatedEGLDisplay = false;
        private float[] mTriangleVerticesData = {-1.0f, -1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
        private final String mBlitVextexShader = "attribute vec2 Position;\nattribute vec2 TexCoords;\nvarying vec2 TexCoord;\nvoid main() {\n\tTexCoord = TexCoords;\n\tgl_Position = vec4(Position, 0.0, 1.0);\n}\n";
        private final String mBlitFragmentShaderBGRA = "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES VideoTexture;\nvarying highp vec2 TexCoord;\nvoid main()\n{\n\tgl_FragColor = texture2D(VideoTexture, TexCoord).bgra;\n}\n";
        private final String mBlitFragmentShaderRGBA = "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES VideoTexture;\nvarying highp vec2 TexCoord;\nvoid main()\n{\n\tgl_FragColor = texture2D(VideoTexture, TexCoord).rgba;\n}\n";
        private EGLSurface mEglSurface = EGL14.EGL_NO_SURFACE;
        private EGLContext mEglContext = EGL14.EGL_NO_CONTEXT;

        public BitmapRenderer(boolean z, boolean z2) {
            this.mUseOwnContext = true;
            this.mVulkanRenderer = false;
            this.mSwizzlePixels = false;
            this.mSwizzlePixels = z;
            this.mVulkanRenderer = z2;
            this.mUseOwnContext = true;
            if (z2) {
                this.mSwizzlePixels = true;
                GameActivity.Log.debug("BitmapRenderer: mSwizzlePixels");
            } else {
                String strGlGetString = GLES20.glGetString(7937);
                GameActivity.Log.debug("BitmapRenderer 2" + strGlGetString);
                if (strGlGetString.contains("Adreno (TM) ") && (Integer.parseInt(strGlGetString.substring(12)) < 400 || Build.VERSION.SDK_INT < 22)) {
                    GameActivity.Log.debug("VideoDecoder: disabled shared GL context on " + strGlGetString);
                    this.mUseOwnContext = false;
                }
            }
            if (this.mUseOwnContext) {
                GameActivity.Log.debug("BitmapRenderer 3");
                initContext();
                GameActivity.Log.debug("BitmapRenderer 4");
                saveContext();
                GameActivity.Log.debug("BitmapRenderer 5");
                makeCurrent();
                GameActivity.Log.debug("BitmapRenderer 6");
                initSurfaceTexture();
                GameActivity.Log.debug("BitmapRenderer 7");
                restoreContext();
            } else {
                GameActivity.Log.debug("BitmapRenderer 8");
                initSurfaceTexture();
            }
            GameActivity.Log.debug("BitmapRenderer 9");
        }

        private void UpdateVertexData() {
            if (!this.mTriangleVerticesDirty || this.mBlitBuffer <= 0) {
                return;
            }
            this.mTriangleVertices.position(0);
            this.mTriangleVertices.put(this.mTriangleVerticesData).position(0);
            int[] iArr = new int[1];
            GLES20.glGetIntegerv(34964, iArr, 0);
            int i = iArr[0];
            GLES20.glBindBuffer(34962, this.mBlitBuffer);
            GLES20.glBufferData(34962, this.mTriangleVerticesData.length * 4, this.mTriangleVertices, 35044);
            GLES20.glBindBuffer(34962, i);
            this.mTriangleVerticesDirty = false;
        }

        private boolean copyFrameTexture(int i, Buffer buffer) {
            int i2;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            int i3;
            boolean z6;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            int i12;
            char c;
            if (!this.mFrameAvailable) {
                return false;
            }
            this.mFrameAvailable = false;
            if (this.mSurfaceTexture == null) {
                return false;
            }
            int[] iArr = new int[1];
            int[] iArr2 = new int[4];
            if (this.mUseOwnContext) {
                GLES20.glActiveTexture(33984);
                GLES20.glGetTexParameteriv(3553, 10241, iArr, 0);
                int i13 = iArr[0];
                GLES20.glGetTexParameteriv(3553, 10240, iArr, 0);
                int i14 = iArr[0];
                saveContext();
                makeCurrent();
                i2 = i14;
                i5 = 0;
                z6 = false;
                z5 = false;
                z4 = false;
                z3 = false;
                z2 = false;
                z = false;
                i3 = i13;
                i4 = 0;
            } else {
                GLES20.glGetError();
                boolean zGlIsEnabled = GLES20.glIsEnabled(3042);
                boolean zGlIsEnabled2 = GLES20.glIsEnabled(2884);
                boolean zGlIsEnabled3 = GLES20.glIsEnabled(3089);
                boolean zGlIsEnabled4 = GLES20.glIsEnabled(2960);
                boolean zGlIsEnabled5 = GLES20.glIsEnabled(2929);
                boolean zGlIsEnabled6 = GLES20.glIsEnabled(3024);
                GLES20.glGetIntegerv(36006, iArr, 0);
                int i15 = iArr[0];
                GLES20.glGetIntegerv(34964, iArr, 0);
                int i16 = iArr[0];
                GLES20.glGetIntegerv(2978, iArr2, 0);
                GLES20.glActiveTexture(33984);
                GLES20.glGetTexParameteriv(3553, 10241, iArr, 0);
                int i17 = iArr[0];
                GLES20.glGetTexParameteriv(3553, 10240, iArr, 0);
                int i18 = iArr[0];
                glVerify("save state");
                i2 = i18;
                z = zGlIsEnabled6;
                z2 = zGlIsEnabled5;
                z3 = zGlIsEnabled4;
                z4 = zGlIsEnabled3;
                z5 = zGlIsEnabled2;
                i3 = i17;
                z6 = zGlIsEnabled;
                i4 = i16;
                i5 = i15;
            }
            this.mSurfaceTexture.updateTexImage();
            this.mSurfaceTexture.getTransformMatrix(this.mTransformMatrix);
            float[] fArr = this.mTransformMatrix;
            float f = fArr[12];
            float f2 = f + fArr[0];
            float f3 = fArr[13];
            float f4 = f3 + fArr[5];
            float[] fArr2 = this.mTriangleVerticesData;
            if (fArr2[2] != f || fArr2[6] != f2 || fArr2[11] != f3 || fArr2[3] != f4) {
                fArr2[10] = f;
                fArr2[2] = f;
                fArr2[14] = f2;
                fArr2[6] = f2;
                fArr2[15] = f3;
                fArr2[11] = f3;
                fArr2[7] = f4;
                fArr2[3] = f4;
                this.mTriangleVerticesDirty = true;
            }
            if (buffer != null) {
                buffer.position(0);
            }
            if (!this.mUseOwnContext) {
                GLES20.glDisable(3042);
                GLES20.glDisable(2884);
                GLES20.glDisable(3089);
                GLES20.glDisable(2960);
                GLES20.glDisable(2929);
                GLES20.glDisable(3024);
                GLES20.glColorMask(true, true, true, true);
                glVerify("reset state");
            }
            GLES20.glViewport(0, 0, this.mTextureWidth, this.mTextureHeight);
            glVerify("set viewport");
            if (buffer != null) {
                GLES20.glGenTextures(1, iArr, 0);
                i6 = iArr[0];
            } else {
                i6 = i;
            }
            GLES20.glBindTexture(3553, i6);
            GLES20.glTexParameteri(3553, 10241, 9728);
            GLES20.glTexParameteri(3553, 10240, 9728);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            if (buffer != null) {
                GLES20.glTexImage2D(3553, 0, 6408, this.mTextureWidth, this.mTextureHeight, 0, 6408, 5121, null);
            }
            glVerify("set-up FBO texture");
            GLES20.glBindFramebuffer(36160, this.mFBO);
            glVerify("glBindFramebuffer");
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, i6, 0);
            int iGlCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
            if (iGlCheckFramebufferStatus != 36053) {
                GameActivity.Log.warn("Failed to complete framebuffer attachment (" + iGlCheckFramebufferStatus + ")");
            }
            GLES20.glUseProgram(this.mProgram);
            UpdateVertexData();
            GLES20.glBindBuffer(34962, this.mBlitBuffer);
            GLES20.glEnableVertexAttribArray(this.mPositionAttrib);
            GLES20.glVertexAttribPointer(this.mPositionAttrib, 2, 5126, false, 16, 0);
            GLES20.glEnableVertexAttribArray(this.mTexCoordsAttrib);
            GLES20.glVertexAttribPointer(this.mTexCoordsAttrib, 2, 5126, false, 16, 8);
            glVerify("setup movie texture read");
            GLES20.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
            GLES20.glClear(16384);
            GLES20.glUniform1i(this.mTextureUniform, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(this.GL_TEXTURE_EXTERNAL_OES, this.mTextureID);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glFlush();
            if (buffer != null) {
                i7 = i4;
                i8 = i2;
                i12 = 3553;
                i9 = i3;
                i11 = 36160;
                i10 = i6;
                GLES20.glReadPixels(0, 0, this.mTextureWidth, this.mTextureHeight, 6408, 5121, buffer);
            } else {
                i7 = i4;
                i8 = i2;
                i9 = i3;
                i10 = i6;
                i11 = 36160;
                i12 = 3553;
            }
            glVerify("draw & read movie texture");
            if (this.mUseOwnContext) {
                GLES20.glFramebufferTexture2D(i11, 36064, i12, 0, 0);
                if (buffer != null && i10 > 0) {
                    iArr[0] = i10;
                    GLES20.glDeleteTextures(1, iArr, 0);
                }
                restoreContext();
                GLES20.glTexParameteri(i12, 10241, i9);
                GLES20.glTexParameteri(i12, 10240, i8);
                return true;
            }
            int i19 = i9;
            GLES20.glBindFramebuffer(i11, i5);
            if (buffer == null || i10 <= 0) {
                c = 1;
            } else {
                iArr[0] = i10;
                c = 1;
                GLES20.glDeleteTextures(1, iArr, 0);
            }
            GLES20.glBindBuffer(34962, i7);
            GLES20.glViewport(iArr2[0], iArr2[c], iArr2[2], iArr2[3]);
            if (z6) {
                GLES20.glEnable(3042);
            }
            if (z5) {
                GLES20.glEnable(2884);
            }
            if (z4) {
                GLES20.glEnable(3089);
            }
            if (z3) {
                GLES20.glEnable(2960);
            }
            if (z2) {
                GLES20.glEnable(2929);
            }
            if (z) {
                GLES20.glEnable(3024);
            }
            GLES20.glTexParameteri(i12, 10241, i19);
            GLES20.glTexParameteri(i12, 10240, i8);
            GLES20.glDisableVertexAttribArray(this.mPositionAttrib);
            GLES20.glDisableVertexAttribArray(this.mTexCoordsAttrib);
            VideoDecoder.this.nativeClearCachedAttributeState(this.mPositionAttrib, this.mTexCoordsAttrib);
            return true;
        }

        private int createShader(int i, String str) {
            int iGlCreateShader = GLES20.glCreateShader(i);
            if (iGlCreateShader == 0) {
                return iGlCreateShader;
            }
            GLES20.glShaderSource(iGlCreateShader, str);
            GLES20.glCompileShader(iGlCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
            if (iArr[0] != 0) {
                return iGlCreateShader;
            }
            GameActivity.Log.error("Could not compile shader " + i + SignatureImpl.INNER_SEP);
            GameActivity.Log.error(GLES20.glGetShaderInfoLog(iGlCreateShader));
            GLES20.glDeleteShader(iGlCreateShader);
            return 0;
        }

        private void glVerify(String str) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                return;
            }
            showGlError(str, iGlGetError);
            throw new RuntimeException(str + ": glGetError " + iGlGetError);
        }

        private void glWarn(String str) {
            while (true) {
                int iGlGetError = GLES20.glGetError();
                if (iGlGetError == 0) {
                    return;
                } else {
                    showGlError(str, iGlGetError);
                }
            }
        }

        private void initContext() {
            this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
            EGLContext eGLContextEglGetCurrentContext = EGL14.EGL_NO_CONTEXT;
            int[] iArr = {0};
            int[] iArr2 = {0};
            if (this.mVulkanRenderer) {
                EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
                this.mEglDisplay = eGLDisplayEglGetDisplay;
                if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
                    GameActivity.Log.error("unable to get EGL14 display");
                    return;
                }
                int[] iArr3 = new int[2];
                if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr3, 0, iArr3, 1)) {
                    this.mEglDisplay = null;
                    GameActivity.Log.error("unable to initialize EGL14 display");
                    return;
                }
                this.mCreatedEGLDisplay = true;
            } else {
                this.mEglDisplay = EGL14.eglGetCurrentDisplay();
                eGLContextEglGetCurrentContext = EGL14.eglGetCurrentContext();
                if (Build.VERSION.SDK_INT >= 18 && EGL14.eglQueryContext(this.mEglDisplay, eGLContextEglGetCurrentContext, 12440, iArr, 0) && EGL14.eglQueryContext(this.mEglDisplay, eGLContextEglGetCurrentContext, 12539, iArr2, 0)) {
                    GameActivity.Log.debug("VideoDecoder: Existing GL context is version " + iArr[0] + "." + iArr2[0]);
                } else if (EGL14.eglQueryContext(this.mEglDisplay, eGLContextEglGetCurrentContext, 12440, iArr, 0)) {
                    GameActivity.Log.debug("VideoDecoder: Existing GL context is version " + iArr[0]);
                } else {
                    GameActivity.Log.debug("VideoDecoder: Existing GL context version not detected");
                }
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            EGL14.eglChooseConfig(this.mEglDisplay, new int[]{12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0);
            int[] iArr4 = {12440, 2, 12344};
            int[] iArr5 = {12440, 3, 12539, 1, 12344};
            EGLDisplay eGLDisplay = this.mEglDisplay;
            EGLConfig eGLConfig = eGLConfigArr[0];
            if (iArr[0] == 3) {
                iArr4 = iArr5;
            }
            this.mEglContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, eGLContextEglGetCurrentContext, iArr4, 0);
            if (EGL14.eglQueryString(this.mEglDisplay, 12373).contains("EGL_KHR_surfaceless_context")) {
                this.mEglSurface = EGL14.EGL_NO_SURFACE;
            } else {
                this.mEglSurface = EGL14.eglCreatePbufferSurface(this.mEglDisplay, eGLConfigArr[0], new int[]{12344}, 0);
            }
        }

        private void initSurfaceTexture() {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i = iArr[0];
            this.mTextureID = i;
            if (i <= 0) {
                GameActivity.Log.error("mTextureID <= 0");
                release();
                return;
            }
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureID);
            this.mSurfaceTexture = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
            this.mSurface = new Surface(this.mSurfaceTexture);
            int[] iArr2 = new int[1];
            GLES20.glGenFramebuffers(1, iArr2, 0);
            int i2 = iArr2[0];
            this.mFBO = i2;
            if (i2 <= 0) {
                GameActivity.Log.error("mFBO <= 0");
                release();
                return;
            }
            int iCreateShader = createShader(35633, "attribute vec2 Position;\nattribute vec2 TexCoords;\nvarying vec2 TexCoord;\nvoid main() {\n\tTexCoord = TexCoords;\n\tgl_Position = vec4(Position, 0.0, 1.0);\n}\n");
            this.mBlitVertexShaderID = iCreateShader;
            if (iCreateShader == 0) {
                GameActivity.Log.error("mBlitVertexShaderID == 0");
                release();
                return;
            }
            int iCreateShader2 = createShader(35632, this.mSwizzlePixels ? "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES VideoTexture;\nvarying highp vec2 TexCoord;\nvoid main()\n{\n\tgl_FragColor = texture2D(VideoTexture, TexCoord).bgra;\n}\n" : "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES VideoTexture;\nvarying highp vec2 TexCoord;\nvoid main()\n{\n\tgl_FragColor = texture2D(VideoTexture, TexCoord).rgba;\n}\n");
            if (iCreateShader2 == 0) {
                GameActivity.Log.error("mBlitFragmentShaderID == 0");
                release();
                return;
            }
            int iGlCreateProgram = GLES20.glCreateProgram();
            this.mProgram = iGlCreateProgram;
            if (iGlCreateProgram <= 0) {
                GameActivity.Log.error("mProgram <= 0");
                release();
                return;
            }
            GLES20.glAttachShader(iGlCreateProgram, this.mBlitVertexShaderID);
            GLES20.glAttachShader(this.mProgram, iCreateShader2);
            GLES20.glLinkProgram(this.mProgram);
            int[] iArr3 = new int[1];
            GLES20.glGetProgramiv(this.mProgram, 35714, iArr3, 0);
            if (iArr3[0] != 1) {
                GameActivity.Log.error("Could not link program: ");
                GameActivity.Log.error(GLES20.glGetProgramInfoLog(this.mProgram));
                GLES20.glDeleteProgram(this.mProgram);
                this.mProgram = 0;
                release();
                return;
            }
            this.mPositionAttrib = GLES20.glGetAttribLocation(this.mProgram, "Position");
            this.mTexCoordsAttrib = GLES20.glGetAttribLocation(this.mProgram, "TexCoords");
            this.mTextureUniform = GLES20.glGetUniformLocation(this.mProgram, "VideoTexture");
            GLES20.glGenBuffers(1, iArr2, 0);
            int i3 = iArr2[0];
            this.mBlitBuffer = i3;
            if (i3 <= 0) {
                GameActivity.Log.error("mBlitBuffer <= 0");
                release();
                return;
            }
            this.mTriangleVertices = ByteBuffer.allocateDirect(this.mTriangleVerticesData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.mTriangleVerticesDirty = true;
            if (this.mUseOwnContext) {
                GLES20.glDisable(3042);
                GLES20.glDisable(2884);
                GLES20.glDisable(3089);
                GLES20.glDisable(2960);
                GLES20.glDisable(2929);
                GLES20.glDisable(3024);
                GLES20.glColorMask(true, true, true, true);
            }
        }

        private void makeCurrent() {
            EGLDisplay eGLDisplay = this.mEglDisplay;
            EGLSurface eGLSurface = this.mEglSurface;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEglContext);
        }

        private void restoreContext() {
            EGL14.eglMakeCurrent(this.mSavedDisplay, this.mSavedSurfaceDraw, this.mSavedSurfaceRead, this.mSavedContext);
        }

        private void saveContext() {
            this.mSavedDisplay = EGL14.eglGetCurrentDisplay();
            this.mSavedContext = EGL14.eglGetCurrentContext();
            this.mSavedSurfaceDraw = EGL14.eglGetCurrentSurface(12377);
            this.mSavedSurfaceRead = EGL14.eglGetCurrentSurface(12378);
        }

        private void showGlError(String str, int i) {
            switch (i) {
                case 1280:
                    GameActivity.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_INVALID_ENUM");
                    break;
                case 1281:
                    GameActivity.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_INVALID_VALUE");
                    break;
                case 1282:
                    GameActivity.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_INVALID_OPERATION");
                    break;
                case 1285:
                    GameActivity.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_OUT_OF_MEMORY");
                    break;
                case 1286:
                    GameActivity.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_INVALID_FRAMEBUFFER_OPERATION");
                    break;
                case 36054:
                    GameActivity.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT");
                    break;
                case 36057:
                    GameActivity.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS");
                    break;
                case 36061:
                    GameActivity.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_FRAMEBUFFER_UNSUPPORTED");
                    break;
                default:
                    GameActivity.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError " + i);
                    break;
            }
        }

        public int getExternalTextureId() {
            return this.mTextureID;
        }

        public Surface getSurface() {
            return this.mSurface;
        }

        public SurfaceTexture getSurfaceTexture() {
            return this.mSurfaceTexture;
        }

        public boolean isValid() {
            return this.mSurfaceTexture != null;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            synchronized (this) {
                this.mFrameAvailable = true;
            }
        }

        public void release() {
            Surface surface = this.mSurface;
            if (surface != null) {
                surface.release();
                this.mSurface = null;
            }
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.mSurfaceTexture = null;
            }
            int[] iArr = new int[1];
            int i = this.mBlitBuffer;
            if (i > 0) {
                iArr[0] = i;
                GLES20.glDeleteBuffers(1, iArr, 0);
                this.mBlitBuffer = -1;
            }
            int i2 = this.mProgram;
            if (i2 > 0) {
                GLES20.glDeleteProgram(i2);
                this.mProgram = -1;
            }
            int i3 = this.mBlitVertexShaderID;
            if (i3 > 0) {
                GLES20.glDeleteShader(i3);
                this.mBlitVertexShaderID = -1;
            }
            int i4 = this.mBlitFragmentShaderID;
            if (i4 > 0) {
                GLES20.glDeleteShader(i4);
                this.mBlitFragmentShaderID = -1;
            }
            int i5 = this.mFBO;
            if (i5 > 0) {
                iArr[0] = i5;
                GLES20.glDeleteFramebuffers(1, iArr, 0);
                this.mFBO = -1;
            }
            int i6 = this.mTextureID;
            if (i6 > 0) {
                iArr[0] = i6;
                GLES20.glDeleteTextures(1, iArr, 0);
                this.mTextureID = -1;
            }
            EGLSurface eGLSurface = this.mEglSurface;
            if (eGLSurface != EGL14.EGL_NO_SURFACE) {
                EGL14.eglDestroySurface(this.mEglDisplay, eGLSurface);
                this.mEglSurface = EGL14.EGL_NO_SURFACE;
            }
            EGLContext eGLContext = this.mEglContext;
            if (eGLContext != EGL14.EGL_NO_CONTEXT) {
                EGL14.eglDestroyContext(this.mEglDisplay, eGLContext);
                this.mEglContext = EGL14.EGL_NO_CONTEXT;
            }
            if (this.mCreatedEGLDisplay) {
                EGL14.eglTerminate(this.mEglDisplay);
                this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
                this.mCreatedEGLDisplay = false;
            }
        }

        public boolean resolutionChanged() {
            boolean z;
            synchronized (this) {
                z = this.mTextureSizeChanged;
                this.mTextureSizeChanged = false;
            }
            return z;
        }

        public void setSize(int i, int i2) {
            synchronized (this) {
                if (i != this.mTextureWidth || i2 != this.mTextureHeight) {
                    this.mTextureWidth = i;
                    this.mTextureHeight = i2;
                    this.mFrameData = null;
                    this.mTextureSizeChanged = true;
                }
            }
        }

        public FrameUpdateInfo updateFrameData() {
            int i;
            int i2;
            synchronized (this) {
                if (this.mFrameData == null && (i = this.mTextureWidth) > 0 && (i2 = this.mTextureHeight) > 0) {
                    this.mFrameData = ByteBuffer.allocateDirect(i * i2 * 4);
                }
                if (!copyFrameTexture(0, this.mFrameData)) {
                    return null;
                }
                FrameUpdateInfo frameUpdateInfo = VideoDecoder.this.new FrameUpdateInfo();
                frameUpdateInfo.Buffer = this.mFrameData;
                VideoDecoder videoDecoder = VideoDecoder.this;
                Map.Entry<Double, Double> frameTimeDuration = videoDecoder.getFrameTimeDuration(videoDecoder.getFrameTimestamp());
                frameUpdateInfo.Timestamp = frameTimeDuration.getKey().doubleValue();
                frameUpdateInfo.Duration = frameTimeDuration.getValue().doubleValue();
                frameUpdateInfo.FrameReady = true;
                frameUpdateInfo.RegionChanged = false;
                return frameUpdateInfo;
            }
        }

        public FrameUpdateInfo updateFrameData(int i) {
            synchronized (this) {
                if (!copyFrameTexture(i, null)) {
                    return null;
                }
                FrameUpdateInfo frameUpdateInfo = VideoDecoder.this.new FrameUpdateInfo();
                frameUpdateInfo.Buffer = null;
                VideoDecoder videoDecoder = VideoDecoder.this;
                Map.Entry<Double, Double> frameTimeDuration = videoDecoder.getFrameTimeDuration(videoDecoder.getFrameTimestamp());
                frameUpdateInfo.Timestamp = frameTimeDuration.getKey().doubleValue();
                frameUpdateInfo.Duration = frameTimeDuration.getValue().doubleValue();
                frameUpdateInfo.FrameReady = true;
                frameUpdateInfo.RegionChanged = false;
                return frameUpdateInfo;
            }
        }
    }
}
