package com.epicgames.unreal;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.SurfaceTexture;
import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Build;
import android.view.Surface;
import com.google.android.exoplayer2.C;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.http.AsyncHttpHead;
import io.agora.rtc2.video.VideoCaptureFormat;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* loaded from: classes.dex */
public class MediaPlayer14 extends MediaPlayer {
    private boolean AudioEnabled;
    private float AudioVolume;
    private boolean NeedTrackInfo;
    private boolean SwizzlePixels;
    private boolean VulkanRenderer;
    private volatile boolean WaitOnBitmapRender;
    private boolean Looping = false;
    private volatile boolean Prepared = false;
    private volatile boolean Completed = false;
    private BitmapRenderer mBitmapRenderer = null;
    private OESTextureRenderer mOESTextureRenderer = null;
    private ArrayList<AudioTrackInfo> audioTracks = new ArrayList<>();
    private ArrayList<VideoTrackInfo> videoTracks = new ArrayList<>();
    private boolean mVideoEnabled = true;

    public class AudioTrackInfo {
        public int Channels;
        public String DisplayName;
        public int Index;
        public String Language;
        public String MimeType;
        public int SampleRate;

        public AudioTrackInfo() {
        }
    }

    public class CaptionTrackInfo {
        public String DisplayName;
        public int Index;
        public String Language;
        public String MimeType;

        public CaptionTrackInfo() {
        }
    }

    public class FrameUpdateInfo {
        public int CurrentPosition;
        public boolean FrameReady;
        public boolean RegionChanged;
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
            FrameUpdateInfo frameUpdateInfo = MediaPlayer14.this.new FrameUpdateInfo();
            frameUpdateInfo.CurrentPosition = MediaPlayer14.this.getCurrentPosition();
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

    public class PakDataSource extends MediaDataSource {
        public ByteBuffer fileBuffer = ByteBuffer.allocateDirect(65536);
        public long fileSize;
        public long identifier;

        public PakDataSource(long j, long j2) {
            this.identifier = j;
            this.fileSize = j2;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
        }

        @Override // android.media.MediaDataSource
        public synchronized long getSize() throws IOException {
            return this.fileSize;
        }

        @Override // android.media.MediaDataSource
        public synchronized int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
            synchronized (this.fileBuffer) {
                long j2 = this.fileSize;
                if (j >= j2) {
                    return -1;
                }
                if (i2 + j > j2) {
                    i2 = (int) (j2 - j);
                }
                int i3 = i2;
                if (i3 <= 0) {
                    return 0;
                }
                int iNativeReadAt = MediaPlayer14.this.nativeReadAt(this.identifier, j, this.fileBuffer, 0, i3);
                if (iNativeReadAt > 0) {
                    System.arraycopy(this.fileBuffer.array(), this.fileBuffer.arrayOffset(), bArr, i, iNativeReadAt);
                }
                return iNativeReadAt;
            }
        }
    }

    public class VideoTrackInfo {
        public int BitRate;
        public String DisplayName;
        public float FrameRate;
        public int Height;
        public int Index;
        public String Language;
        public String MimeType;
        public int Width;

        public VideoTrackInfo() {
        }
    }

    public MediaPlayer14(boolean z, boolean z2, boolean z3) {
        this.SwizzlePixels = true;
        this.VulkanRenderer = false;
        this.NeedTrackInfo = true;
        this.AudioEnabled = true;
        this.AudioVolume = 1.0f;
        this.WaitOnBitmapRender = false;
        this.SwizzlePixels = z;
        this.VulkanRenderer = z2;
        this.NeedTrackInfo = z3;
        this.WaitOnBitmapRender = false;
        this.AudioEnabled = true;
        this.AudioVolume = 1.0f;
        setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.epicgames.unreal.MediaPlayer14.1
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                GameActivity.Log.debug("MediaPlayer14: onError returned what=" + i + ", extra=" + i2);
                return true;
            }
        });
        setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.epicgames.unreal.MediaPlayer14.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                synchronized (mediaPlayer) {
                    MediaPlayer14.this.Prepared = true;
                }
            }
        });
        setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.epicgames.unreal.MediaPlayer14.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                synchronized (mediaPlayer) {
                    if (MediaPlayer14.this.Looping) {
                        MediaPlayer14.this.seekTo(0);
                        MediaPlayer14.this.start();
                    }
                    MediaPlayer14.this.Completed = true;
                }
            }
        });
    }

    private boolean CreateBitmapRenderer() {
        releaseBitmapRenderer();
        BitmapRenderer bitmapRenderer = new BitmapRenderer(this.SwizzlePixels, this.VulkanRenderer);
        this.mBitmapRenderer = bitmapRenderer;
        if (!bitmapRenderer.isValid()) {
            this.mBitmapRenderer = null;
            return false;
        }
        this.mBitmapRenderer.setSize(getVideoWidth(), getVideoHeight());
        setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.epicgames.unreal.MediaPlayer14.4
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                if (MediaPlayer14.this.mBitmapRenderer != null) {
                    MediaPlayer14.this.mBitmapRenderer.setSize(i, i2);
                }
            }
        });
        setVideoEnabled(true);
        if (this.AudioEnabled) {
            setAudioEnabled(true);
        }
        return true;
    }

    private boolean CreateOESTextureRenderer(int i) {
        releaseOESTextureRenderer();
        OESTextureRenderer oESTextureRenderer = new OESTextureRenderer(i);
        this.mOESTextureRenderer = oESTextureRenderer;
        if (!oESTextureRenderer.isValid()) {
            this.mOESTextureRenderer = null;
            return false;
        }
        this.mOESTextureRenderer.setSize(getVideoWidth(), getVideoHeight());
        setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.epicgames.unreal.MediaPlayer14.5
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
                if (MediaPlayer14.this.mOESTextureRenderer != null) {
                    MediaPlayer14.this.mOESTextureRenderer.setSize(i2, i3);
                }
            }
        });
        setVideoEnabled(true);
        if (this.AudioEnabled) {
            setAudioEnabled(true);
        }
        return true;
    }

    public static String RemoteFileExists(String str) throws IOException {
        boolean followRedirects = HttpURLConnection.getFollowRedirects();
        HttpURLConnection.setFollowRedirects(false);
        int i = 5;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                HttpURLConnection.setFollowRedirects(followRedirects);
                return null;
            }
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setRequestMethod(AsyncHttpHead.METHOD);
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    httpURLConnection.disconnect();
                    HttpURLConnection.setFollowRedirects(followRedirects);
                    return str;
                }
                if (responseCode != 303 && responseCode != 301 && responseCode != 302) {
                    HttpURLConnection.setFollowRedirects(followRedirects);
                    return null;
                }
                str = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                URL url = httpURLConnection.getURL();
                httpURLConnection.disconnect();
                if (!str.contains("://")) {
                    str = url.getProtocol() + "://" + url.getHost() + str;
                }
                i = i2;
            } catch (Exception e) {
                e.printStackTrace();
                HttpURLConnection.setFollowRedirects(followRedirects);
                return null;
            }
        }
    }

    private AudioTrackInfo findAudioTrackIndex(int i) {
        Iterator<AudioTrackInfo> it = this.audioTracks.iterator();
        while (it.hasNext()) {
            AudioTrackInfo next = it.next();
            if (next.Index == i) {
                return next;
            }
        }
        return null;
    }

    private VideoTrackInfo findVideoTrackIndex(int i) {
        Iterator<VideoTrackInfo> it = this.videoTracks.iterator();
        while (it.hasNext()) {
            VideoTrackInfo next = it.next();
            if (next.Index == i) {
                return next;
            }
        }
        return null;
    }

    private void updateTrackInfo(MediaExtractor mediaExtractor) {
        if (mediaExtractor == null) {
            return;
        }
        int trackCount = mediaExtractor.getTrackCount();
        this.audioTracks.ensureCapacity(trackCount);
        this.videoTracks.ensureCapacity(trackCount);
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < trackCount; i3++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i3);
            String string = trackFormat.getString("mime");
            if (string.startsWith("audio")) {
                AudioTrackInfo audioTrackInfo = new AudioTrackInfo();
                audioTrackInfo.Index = i3;
                audioTrackInfo.MimeType = string;
                audioTrackInfo.DisplayName = "Audio Track " + i + " (Stream " + i3 + ")";
                audioTrackInfo.Language = C.LANGUAGE_UNDETERMINED;
                audioTrackInfo.Channels = trackFormat.getInteger("channel-count");
                audioTrackInfo.SampleRate = trackFormat.getInteger("sample-rate");
                this.audioTracks.add(audioTrackInfo);
                i++;
            } else if (string.startsWith("video")) {
                VideoTrackInfo videoTrackInfo = new VideoTrackInfo();
                videoTrackInfo.Index = i3;
                videoTrackInfo.MimeType = string;
                videoTrackInfo.DisplayName = "Video Track " + i2 + " (Stream " + i3 + ")";
                videoTrackInfo.Language = C.LANGUAGE_UNDETERMINED;
                videoTrackInfo.BitRate = 0;
                videoTrackInfo.Width = trackFormat.getInteger(VideoCaptureFormat.keyWidth);
                videoTrackInfo.Height = trackFormat.getInteger(VideoCaptureFormat.keyHeight);
                videoTrackInfo.FrameRate = 30.0f;
                if (trackFormat.containsKey("frame-rate")) {
                    videoTrackInfo.FrameRate = trackFormat.getInteger("frame-rate");
                }
                this.videoTracks.add(videoTrackInfo);
                i2++;
            }
        }
    }

    public AudioTrackInfo[] GetAudioTracks() throws IllegalStateException {
        boolean z;
        AudioTrackInfo audioTrackInfoFindAudioTrackIndex;
        MediaFormat format;
        if (!this.NeedTrackInfo || Build.VERSION.SDK_INT < 16) {
            AudioTrackInfo[] audioTrackInfoArr = {new AudioTrackInfo()};
            audioTrackInfoArr[0].Index = 0;
            audioTrackInfoArr[0].MimeType = "audio/unknown";
            audioTrackInfoArr[0].DisplayName = "Audio Track 0 (Stream 0)";
            audioTrackInfoArr[0].Language = C.LANGUAGE_UNDETERMINED;
            audioTrackInfoArr[0].Channels = 2;
            audioTrackInfoArr[0].SampleRate = 44100;
            return audioTrackInfoArr;
        }
        MediaPlayer.TrackInfo[] trackInfo = getTrackInfo();
        int i = 0;
        for (MediaPlayer.TrackInfo trackInfo2 : trackInfo) {
            if (trackInfo2.getTrackType() == 2) {
                i++;
            }
        }
        AudioTrackInfo[] audioTrackInfoArr2 = new AudioTrackInfo[i];
        int i2 = 0;
        for (int i3 = 0; i3 < trackInfo.length; i3++) {
            if (trackInfo[i3].getTrackType() == 2) {
                audioTrackInfoArr2[i2] = new AudioTrackInfo();
                audioTrackInfoArr2[i2].Index = i3;
                audioTrackInfoArr2[i2].DisplayName = "Audio Track " + i2 + " (Stream " + i3 + ")";
                audioTrackInfoArr2[i2].Language = trackInfo[i3].getLanguage();
                if (Build.VERSION.SDK_INT < 19 || (format = trackInfo[i3].getFormat()) == null) {
                    z = false;
                } else {
                    audioTrackInfoArr2[i2].MimeType = format.getString("mime");
                    audioTrackInfoArr2[i2].Channels = format.getInteger("channel-count");
                    audioTrackInfoArr2[i2].SampleRate = format.getInteger("sample-rate");
                    z = true;
                }
                if (!z && this.audioTracks.size() > 0 && (audioTrackInfoFindAudioTrackIndex = findAudioTrackIndex(i3)) != null) {
                    audioTrackInfoArr2[i2].MimeType = audioTrackInfoFindAudioTrackIndex.MimeType;
                    audioTrackInfoArr2[i2].Channels = audioTrackInfoFindAudioTrackIndex.Channels;
                    audioTrackInfoArr2[i2].SampleRate = audioTrackInfoFindAudioTrackIndex.SampleRate;
                    z = true;
                }
                if (!z) {
                    audioTrackInfoArr2[i2].MimeType = "audio/unknown";
                    audioTrackInfoArr2[i2].Channels = 2;
                    audioTrackInfoArr2[i2].SampleRate = 44100;
                }
                i2++;
            }
        }
        return audioTrackInfoArr2;
    }

    public CaptionTrackInfo[] GetCaptionTracks() throws IllegalStateException {
        if (!this.NeedTrackInfo || Build.VERSION.SDK_INT < 21) {
            return new CaptionTrackInfo[0];
        }
        MediaPlayer.TrackInfo[] trackInfo = getTrackInfo();
        int i = 0;
        for (MediaPlayer.TrackInfo trackInfo2 : trackInfo) {
            if (trackInfo2.getTrackType() == 4) {
                i++;
            }
        }
        CaptionTrackInfo[] captionTrackInfoArr = new CaptionTrackInfo[i];
        int i2 = 0;
        for (int i3 = 0; i3 < trackInfo.length; i3++) {
            if (trackInfo[i3].getTrackType() == 4) {
                captionTrackInfoArr[i2] = new CaptionTrackInfo();
                captionTrackInfoArr[i2].Index = i3;
                captionTrackInfoArr[i2].DisplayName = "Caption Track " + i2 + " (Stream " + i3 + ")";
                MediaFormat format = trackInfo[i3].getFormat();
                if (format != null) {
                    captionTrackInfoArr[i2].MimeType = format.getString("mime");
                    captionTrackInfoArr[i2].Language = format.getString("language");
                } else {
                    captionTrackInfoArr[i2].MimeType = "caption/unknown";
                    captionTrackInfoArr[i2].Language = trackInfo[i3].getLanguage();
                }
                i2++;
            }
        }
        return captionTrackInfoArr;
    }

    public VideoTrackInfo[] GetVideoTracks() throws IllegalStateException {
        boolean z;
        VideoTrackInfo videoTrackInfoFindVideoTrackIndex;
        MediaFormat format;
        int videoWidth = getVideoWidth();
        int videoHeight = getVideoHeight();
        if (this.NeedTrackInfo && Build.VERSION.SDK_INT >= 16) {
            MediaPlayer.TrackInfo[] trackInfo = getTrackInfo();
            int i = 0;
            for (MediaPlayer.TrackInfo trackInfo2 : trackInfo) {
                if (trackInfo2.getTrackType() == 1) {
                    i++;
                }
            }
            VideoTrackInfo[] videoTrackInfoArr = new VideoTrackInfo[i];
            int i2 = 0;
            for (int i3 = 0; i3 < trackInfo.length; i3++) {
                if (trackInfo[i3].getTrackType() == 1) {
                    videoTrackInfoArr[i2] = new VideoTrackInfo();
                    videoTrackInfoArr[i2].Index = i3;
                    videoTrackInfoArr[i2].DisplayName = "Video Track " + i2 + " (Stream " + i3 + ")";
                    videoTrackInfoArr[i2].Language = trackInfo[i3].getLanguage();
                    videoTrackInfoArr[i2].BitRate = 0;
                    if (Build.VERSION.SDK_INT < 19 || (format = trackInfo[i3].getFormat()) == null) {
                        z = false;
                    } else {
                        videoTrackInfoArr[i2].MimeType = format.getString("mime");
                        videoTrackInfoArr[i2].Width = Integer.parseInt(format.getString(VideoCaptureFormat.keyWidth));
                        videoTrackInfoArr[i2].Height = Integer.parseInt(format.getString(VideoCaptureFormat.keyHeight));
                        videoTrackInfoArr[i2].FrameRate = format.getFloat("frame-rate");
                        z = true;
                    }
                    if (!z && this.videoTracks.size() > 0 && (videoTrackInfoFindVideoTrackIndex = findVideoTrackIndex(i3)) != null) {
                        videoTrackInfoArr[i2].MimeType = videoTrackInfoFindVideoTrackIndex.MimeType;
                        videoTrackInfoArr[i2].Width = videoTrackInfoFindVideoTrackIndex.Width;
                        videoTrackInfoArr[i2].Height = videoTrackInfoFindVideoTrackIndex.Height;
                        videoTrackInfoArr[i2].FrameRate = videoTrackInfoFindVideoTrackIndex.FrameRate;
                        z = true;
                    }
                    if (!z) {
                        videoTrackInfoArr[i2].MimeType = "video/unknown";
                        videoTrackInfoArr[i2].Width = videoWidth;
                        videoTrackInfoArr[i2].Height = videoHeight;
                        videoTrackInfoArr[i2].FrameRate = 30.0f;
                    }
                    i2++;
                }
            }
            if (i > 0) {
                return videoTrackInfoArr;
            }
        }
        if (videoWidth <= 0 || videoHeight <= 0) {
            return new VideoTrackInfo[0];
        }
        VideoTrackInfo[] videoTrackInfoArr2 = {new VideoTrackInfo()};
        videoTrackInfoArr2[0].Index = 0;
        videoTrackInfoArr2[0].MimeType = "video/unknown";
        videoTrackInfoArr2[0].DisplayName = "Video Track 0 (Stream 0)";
        videoTrackInfoArr2[0].Language = C.LANGUAGE_UNDETERMINED;
        videoTrackInfoArr2[0].BitRate = 0;
        videoTrackInfoArr2[0].Width = videoWidth;
        videoTrackInfoArr2[0].Height = videoHeight;
        videoTrackInfoArr2[0].FrameRate = 30.0f;
        return videoTrackInfoArr2;
    }

    public boolean didComplete() {
        boolean z;
        synchronized (this) {
            z = this.Completed;
            this.Completed = false;
        }
        return z;
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

    @Override // android.media.MediaPlayer
    public int getCurrentPosition() {
        int currentPosition;
        synchronized (this) {
            currentPosition = this.Prepared ? super.getCurrentPosition() : 0;
        }
        return currentPosition;
    }

    @Override // android.media.MediaPlayer
    public int getDuration() {
        int duration;
        synchronized (this) {
            duration = this.Prepared ? super.getDuration() : 0;
        }
        return duration;
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

    public boolean getVideoLastFrame(int i) {
        initBitmapRenderer();
        if (this.mBitmapRenderer == null) {
            return false;
        }
        this.WaitOnBitmapRender = true;
        boolean zUpdateFrameData = this.mBitmapRenderer.updateFrameData(i);
        this.WaitOnBitmapRender = false;
        return zUpdateFrameData;
    }

    public Buffer getVideoLastFrameData() {
        initBitmapRenderer();
        if (this.mBitmapRenderer == null) {
            return null;
        }
        this.WaitOnBitmapRender = true;
        Buffer bufferUpdateFrameData = this.mBitmapRenderer.updateFrameData();
        this.WaitOnBitmapRender = false;
        return bufferUpdateFrameData;
    }

    public void initBitmapRenderer() {
        if (this.mBitmapRenderer != null || CreateBitmapRenderer()) {
            return;
        }
        GameActivity.Log.warn("initBitmapRenderer failed to alloc mBitmapRenderer ");
        reset();
    }

    @Override // android.media.MediaPlayer
    public boolean isLooping() {
        return this.Looping;
    }

    public boolean isPrepared() {
        boolean z;
        synchronized (this) {
            z = this.Prepared;
        }
        return z;
    }

    public native void nativeClearCachedAttributeState(int i, int i2);

    public native int nativeReadAt(long j, long j2, ByteBuffer byteBuffer, int i, int i2);

    @Override // android.media.MediaPlayer
    public void prepare() throws IllegalStateException, IOException {
        synchronized (this) {
            this.Completed = false;
            try {
                try {
                    try {
                        super.prepare();
                        this.Prepared = true;
                    } catch (IllegalStateException e) {
                        GameActivity.Log.debug("MediaPlayer14: Prepare IllegalStateExecption: " + e.toString());
                        throw e;
                    }
                } catch (IOException e2) {
                    GameActivity.Log.debug("MediaPlayer14: Prepare IOException: " + e2.toString());
                    throw e2;
                }
            } catch (Exception e3) {
                GameActivity.Log.debug("MediaPlayer14: Prepare Exception: " + e3.toString());
                throw e3;
            }
        }
    }

    @Override // android.media.MediaPlayer
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
        super.release();
    }

    public void releaseBitmapRenderer() {
        BitmapRenderer bitmapRenderer = this.mBitmapRenderer;
        if (bitmapRenderer != null) {
            bitmapRenderer.release();
            this.mBitmapRenderer = null;
            setSurface(null);
            setOnVideoSizeChangedListener(null);
        }
    }

    public void releaseOESTextureRenderer() {
        OESTextureRenderer oESTextureRenderer = this.mOESTextureRenderer;
        if (oESTextureRenderer != null) {
            oESTextureRenderer.release();
            this.mOESTextureRenderer = null;
            setSurface(null);
            setOnVideoSizeChangedListener(null);
        }
    }

    @Override // android.media.MediaPlayer
    public void reset() {
        synchronized (this) {
            this.Prepared = false;
            this.Completed = false;
        }
        if (this.mOESTextureRenderer != null) {
            while (this.WaitOnBitmapRender) {
            }
            releaseOESTextureRenderer();
        }
        if (this.mBitmapRenderer != null) {
            while (this.WaitOnBitmapRender) {
            }
            releaseBitmapRenderer();
        }
        super.reset();
    }

    @Override // android.media.MediaPlayer
    public void seekTo(int i) {
        synchronized (this) {
            this.Completed = false;
            if (this.Prepared) {
                super.seekTo(i);
            }
        }
    }

    public void setAudioEnabled(boolean z) {
        this.AudioEnabled = z;
        if (!z) {
            setVolume(0.0f, 0.0f);
        } else {
            float f = this.AudioVolume;
            setVolume(f, f);
        }
    }

    public void setAudioVolume(float f) {
        this.AudioVolume = f;
        setAudioEnabled(this.AudioEnabled);
    }

    public boolean setDataSource(String str, long j, long j2) throws ExecutionException, IllegalStateException, InterruptedException, IOException, IllegalArgumentException {
        synchronized (this) {
            this.Prepared = false;
            this.Completed = false;
        }
        this.Looping = false;
        this.AudioEnabled = true;
        this.audioTracks.clear();
        this.videoTracks.clear();
        try {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, StreamManagement.AckRequest.ELEMENT);
                setDataSource(randomAccessFile.getFD(), j, j2);
                releaseOESTextureRenderer();
                releaseBitmapRenderer();
                if (this.NeedTrackInfo && Build.VERSION.SDK_INT >= 16) {
                    MediaExtractor mediaExtractor = new MediaExtractor();
                    mediaExtractor.setDataSource(randomAccessFile.getFD(), j, j2);
                    updateTrackInfo(mediaExtractor);
                    mediaExtractor.release();
                }
                return true;
            }
            return false;
        } catch (IOException e) {
            GameActivity.Log.debug("setDataSource (file): Exception = " + e);
            return false;
        }
    }

    public boolean setDataSourceArchive(long j, long j2) throws ExecutionException, IllegalStateException, InterruptedException, IOException, IllegalArgumentException {
        synchronized (this) {
            this.Prepared = false;
            this.Completed = false;
        }
        this.Looping = false;
        this.AudioEnabled = true;
        this.audioTracks.clear();
        this.videoTracks.clear();
        int i = Build.VERSION.SDK_INT;
        if (i < 23) {
            return false;
        }
        try {
            PakDataSource pakDataSource = new PakDataSource(j, j2);
            setDataSource(pakDataSource);
            releaseOESTextureRenderer();
            releaseBitmapRenderer();
            if (this.NeedTrackInfo && i >= 16) {
                MediaExtractor mediaExtractor = new MediaExtractor();
                mediaExtractor.setDataSource(pakDataSource);
                updateTrackInfo(mediaExtractor);
                mediaExtractor.release();
            }
            return true;
        } catch (IOException e) {
            GameActivity.Log.debug("setDataSource (archive): Exception = " + e);
            return false;
        }
    }

    public boolean setDataSourceURL(String str) throws ExecutionException, IllegalStateException, InterruptedException, IOException, SecurityException, IllegalArgumentException {
        synchronized (this) {
            this.Prepared = false;
            this.Completed = false;
        }
        this.Looping = false;
        this.AudioEnabled = true;
        this.audioTracks.clear();
        this.videoTracks.clear();
        String strRemoteFileExists = RemoteFileExists(str);
        if (strRemoteFileExists == null) {
            return false;
        }
        try {
            setDataSource(strRemoteFileExists);
            releaseOESTextureRenderer();
            releaseBitmapRenderer();
            if (this.NeedTrackInfo && Build.VERSION.SDK_INT >= 16) {
                MediaExtractor mediaExtractor = new MediaExtractor();
                try {
                    mediaExtractor.setDataSource(strRemoteFileExists);
                    updateTrackInfo(mediaExtractor);
                    mediaExtractor.release();
                } catch (Exception e) {
                    GameActivity.Log.debug("setDataSourceURL: Exception = " + e);
                    GameActivity.Log.debug("setDataSourceURL: Continuing without track info");
                    mediaExtractor.release();
                }
            }
            return true;
        } catch (IOException e2) {
            GameActivity.Log.debug("setDataSourceURL: Exception = " + e2);
            return false;
        }
    }

    @Override // android.media.MediaPlayer
    public void setLooping(boolean z) {
        this.Looping = z;
    }

    public void setVideoEnabled(boolean z) {
        this.WaitOnBitmapRender = true;
        this.mVideoEnabled = z;
        if (z) {
            OESTextureRenderer oESTextureRenderer = this.mOESTextureRenderer;
            if (oESTextureRenderer != null && oESTextureRenderer.getSurface() != null) {
                setSurface(this.mOESTextureRenderer.getSurface());
            }
            BitmapRenderer bitmapRenderer = this.mBitmapRenderer;
            if (bitmapRenderer != null && bitmapRenderer.getSurface() != null) {
                setSurface(this.mBitmapRenderer.getSurface());
            }
        } else {
            setSurface(null);
        }
        this.WaitOnBitmapRender = false;
    }

    @Override // android.media.MediaPlayer
    public void start() {
        synchronized (this) {
            this.Completed = false;
            if (this.Prepared) {
                super.start();
            }
        }
    }

    @Override // android.media.MediaPlayer
    public void stop() {
        synchronized (this) {
            this.Completed = false;
            if (this.Prepared) {
                super.stop();
            }
        }
    }

    public FrameUpdateInfo updateVideoFrame(int i) {
        if (this.mOESTextureRenderer == null && !CreateOESTextureRenderer(i)) {
            GameActivity.Log.warn("updateVideoFrame failed to alloc mOESTextureRenderer ");
            reset();
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
        private int mLastFramePosition = -1;
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
            } else {
                String strGlGetString = GLES20.glGetString(7937);
                if (strGlGetString.contains("Adreno (TM) ")) {
                    Matcher matcher = Pattern.compile("Adreno \\(TM\\) (\\d*)").matcher(strGlGetString);
                    if (matcher.find() && matcher.groupCount() >= 1 && (Integer.parseInt(matcher.group(1)) < 400 || Build.VERSION.SDK_INT < 22)) {
                        GameActivity.Log.debug("MediaPlayer14: disabled shared GL context on " + strGlGetString);
                        this.mUseOwnContext = false;
                    }
                }
            }
            if (!this.mUseOwnContext) {
                initSurfaceTexture();
                return;
            }
            initContext();
            saveContext();
            makeCurrent();
            initSurfaceTexture();
            restoreContext();
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
            this.mLastFramePosition = MediaPlayer14.this.getCurrentPosition();
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
            GLES20.glClear(16384);
            GLES20.glUniform1i(this.mTextureUniform, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(this.GL_TEXTURE_EXTERNAL_OES, this.mTextureID);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glFlush();
            if (buffer != null) {
                i12 = 36064;
                i7 = i4;
                i8 = i2;
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
                i12 = 36064;
            }
            glVerify("draw & read movie texture");
            if (this.mUseOwnContext) {
                GLES20.glFramebufferTexture2D(i11, i12, 3553, 0, 0);
                if (buffer != null && i10 > 0) {
                    iArr[0] = i10;
                    GLES20.glDeleteTextures(1, iArr, 0);
                }
                restoreContext();
                GLES20.glTexParameteri(3553, 10241, i9);
                GLES20.glTexParameteri(3553, 10240, i8);
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
            GLES20.glTexParameteri(3553, 10241, i19);
            GLES20.glTexParameteri(3553, 10240, i8);
            GLES20.glDisableVertexAttribArray(this.mPositionAttrib);
            GLES20.glDisableVertexAttribArray(this.mTexCoordsAttrib);
            MediaPlayer14.this.nativeClearCachedAttributeState(this.mPositionAttrib, this.mTexCoordsAttrib);
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
                    GameActivity.Log.debug("MediaPlayer14: Existing GL context is version " + iArr[0] + "." + iArr2[0]);
                } else if (EGL14.eglQueryContext(this.mEglDisplay, eGLContextEglGetCurrentContext, 12440, iArr, 0)) {
                    GameActivity.Log.debug("MediaPlayer14: Existing GL context is version " + iArr[0]);
                } else {
                    GameActivity.Log.debug("MediaPlayer14: Existing GL context version not detected");
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

        public Buffer updateFrameData() {
            int i;
            int i2;
            synchronized (this) {
                if (this.mFrameData == null && (i = this.mTextureWidth) > 0 && (i2 = this.mTextureHeight) > 0) {
                    this.mFrameData = ByteBuffer.allocateDirect(i * i2 * 4);
                }
                if (copyFrameTexture(0, this.mFrameData)) {
                    return this.mFrameData;
                }
                return null;
            }
        }

        public boolean updateFrameData(int i) {
            synchronized (this) {
                return copyFrameTexture(i, null);
            }
        }
    }

    public boolean setDataSource(AssetManager assetManager, String str, long j, long j2) throws ExecutionException, IllegalStateException, InterruptedException, IOException, IllegalArgumentException {
        synchronized (this) {
            this.Prepared = false;
            this.Completed = false;
        }
        this.Looping = false;
        this.AudioEnabled = true;
        this.audioTracks.clear();
        this.videoTracks.clear();
        try {
            AssetFileDescriptor assetFileDescriptorOpenFd = assetManager.openFd(str);
            setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), j, j2);
            releaseOESTextureRenderer();
            releaseBitmapRenderer();
            if (this.NeedTrackInfo && Build.VERSION.SDK_INT >= 16) {
                MediaExtractor mediaExtractor = new MediaExtractor();
                mediaExtractor.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), j, j2);
                updateTrackInfo(mediaExtractor);
                mediaExtractor.release();
            }
            return true;
        } catch (IOException e) {
            GameActivity.Log.debug("setDataSource (asset): Exception = " + e);
            return false;
        }
    }
}
