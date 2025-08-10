package io.agora.rtc2.video;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.agora.base.FaceDetectionInfo;
import io.agora.base.VideoFrame;
import io.agora.base.internal.Logging;
import io.agora.base.internal.video.EglBase;
import io.agora.rtc2.video.VideoCapture;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes4.dex */
public abstract class VideoCaptureCamera extends VideoCapture implements IVideoCaptureCamera {
    public static final int ANDROID_CAMERA_SKIP_CONTROL_AE = 1;
    public static final int ANDROID_CAMERA_SKIP_CONTROL_AF = 2;
    public static final int ANDROID_CAMERA_SKIP_CONTROL_DEFAULT = 0;
    public static final int CONTROL_VIDEO_STABILIZATION_MODE_OFF = 0;
    public static final int CONTROL_VIDEO_STABILIZATION_MODE_ON = 1;
    public static final int MAX_CAMERA_TIME_MS = 2000;
    private static final String[] SIZE_HEIGHT_GT_720_BUGGY_DEVICE_LIST = {"Lenovo K520"};
    private static final String TAG = "VideoCaptureCamera";
    public boolean isMirror;
    public final boolean mCaptureToTexture;
    public boolean mEnableAutoFaceFocus;
    public boolean mEnableFaceDetection;
    public final int mId;
    public boolean mIsFaceDetectionStarted;
    public LinkedBlockingQueue<List<FaceDetectionInfo>> mPerFrameFaceDetectionInfoQueue;
    public int mRenderMode;
    public CaptureViewWeakRef mRenderView;
    public final int mSkipControl;

    public class CaptureViewWeakRef<V> extends WeakReference<View> {
        public CaptureViewWeakRef(View view) {
            super(view);
        }

        public int getHeight() {
            if (get() == null) {
                return 0;
            }
            return get().getHeight();
        }

        public int getWidth() {
            if (get() == null) {
                return 0;
            }
            return get().getWidth();
        }
    }

    public VideoCaptureCamera(int i, long j, boolean z, boolean z2, int i2, EglBase.Context context) {
        super(j, context);
        boolean z3 = false;
        this.mEnableAutoFaceFocus = false;
        this.mEnableFaceDetection = false;
        this.mIsFaceDetectionStarted = false;
        this.mPerFrameFaceDetectionInfoQueue = new LinkedBlockingQueue<>();
        this.mRenderView = new CaptureViewWeakRef(null);
        this.isMirror = false;
        this.mId = i;
        this.mSkipControl = i2;
        this.mPQFirst = z2;
        if (z && this.mSurfaceTextureHelper != null) {
            z3 = true;
        }
        this.mCaptureToTexture = z3;
    }

    @Nullable
    public static VideoCapture.FramerateRange findBestFrameRateRange(@NonNull List<VideoCapture.FramerateRange> list, int i, boolean z) {
        if (list.isEmpty()) {
            return null;
        }
        String str = TAG;
        Logging.d(str, "findBestFrameRateRange " + list.toString());
        VideoCapture.FramerateRange framerateRangeFindBestFrameRateRangePreferPQ = z ? findBestFrameRateRangePreferPQ(list, i) : findBestFrameRateRangePreferFPS(list, i);
        if (framerateRangeFindBestFrameRateRangePreferPQ != null) {
            return framerateRangeFindBestFrameRateRangePreferPQ;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to find match fps in ");
        sb.append(z ? "PQ" : " FPS");
        sb.append(" first mode, try closest.");
        Logging.e(str, sb.toString());
        return getClosestFramerateRange(list, i);
    }

    @Nullable
    private static VideoCapture.FramerateRange findBestFrameRateRangePreferFPS(@NonNull List<VideoCapture.FramerateRange> list, int i) {
        Collections.sort(list, new Comparator<VideoCapture.FramerateRange>() { // from class: io.agora.rtc2.video.VideoCaptureCamera.2
            @Override // java.util.Comparator
            public int compare(VideoCapture.FramerateRange framerateRange, VideoCapture.FramerateRange framerateRange2) {
                int i2 = framerateRange.min - framerateRange2.min;
                return i2 == 0 ? framerateRange.max - framerateRange2.max : i2;
            }
        });
        Logging.d(TAG, "sorted fps Ranges List order by min first:" + list.toString());
        for (VideoCapture.FramerateRange framerateRange : list) {
            if (framerateRange.min >= i) {
                Logging.d(TAG, "set fps : " + framerateRange.toString() + " to camera in fps first mode, request:" + i);
                return framerateRange;
            }
        }
        return null;
    }

    @Nullable
    private static VideoCapture.FramerateRange findBestFrameRateRangePreferPQ(@NonNull List<VideoCapture.FramerateRange> list, int i) {
        Collections.sort(list, new Comparator<VideoCapture.FramerateRange>() { // from class: io.agora.rtc2.video.VideoCaptureCamera.3
            @Override // java.util.Comparator
            public int compare(VideoCapture.FramerateRange framerateRange, VideoCapture.FramerateRange framerateRange2) {
                int i2 = framerateRange.max - framerateRange2.max;
                return i2 == 0 ? framerateRange.min - framerateRange2.min : i2;
            }
        });
        Logging.d(TAG, "sorted fps Ranges List order by max first:" + list.toString());
        for (VideoCapture.FramerateRange framerateRange : list) {
            if (framerateRange.max >= i) {
                Logging.d(TAG, "set fps : " + framerateRange.toString() + " to camera in PQ first mode, request:" + i);
                return framerateRange;
            }
        }
        return null;
    }

    public static VideoCapture.FramerateRange getClosestFramerateRange(List<VideoCapture.FramerateRange> list, final int i) {
        return (VideoCapture.FramerateRange) Collections.min(list, new Comparator<VideoCapture.FramerateRange>() { // from class: io.agora.rtc2.video.VideoCaptureCamera.1
            private static final int MAX_FPS_DIFF_THRESHOLD = 5000;
            private static final int MAX_FPS_HIGH_DIFF_WEIGHT = 3;
            private static final int MAX_FPS_LOW_DIFF_WEIGHT = 1;
            private static final int MIN_FPS_HIGH_VALUE_WEIGHT = 4;
            private static final int MIN_FPS_LOW_VALUE_WEIGHT = 1;
            private static final int MIN_FPS_THRESHOLD = 8000;

            private int progressivePenalty(int i2, int i3, int i4, int i5) {
                if (i2 < i3) {
                    return i2 * i4;
                }
                return ((i2 - i3) * i5) + (i4 * i3);
            }

            public int diff(VideoCapture.FramerateRange framerateRange) {
                return progressivePenalty(framerateRange.min, 8000, 1, 4) + progressivePenalty(Math.abs(i - framerateRange.max), 5000, 1, 3);
            }

            @Override // java.util.Comparator
            public int compare(VideoCapture.FramerateRange framerateRange, VideoCapture.FramerateRange framerateRange2) {
                return diff(framerateRange) - diff(framerateRange2);
            }
        });
    }

    public static boolean shouldExcludeSize(int i, int i2) {
        if (i2 > 720) {
            for (String str : SIZE_HEIGHT_GT_720_BUGGY_DEVICE_LIST) {
                if (str.contentEquals(Build.MODEL)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void attachPerFrameMetaInfos(VideoFrame videoFrame) {
        ArrayList arrayList;
        if (this.mPerFrameFaceDetectionInfoQueue.isEmpty() || (arrayList = (ArrayList) this.mPerFrameFaceDetectionInfoQueue.poll()) == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            FaceDetectionInfo faceDetectionInfo = (FaceDetectionInfo) it.next();
            videoFrame.getMetaInfo().getCustomMetaInfo(FaceDetectionInfo.class.getSimpleName()).put(faceDetectionInfo.getId(), faceDetectionInfo);
        }
    }

    @VisibleForTesting
    public boolean isEnableAutoFaceFocus() {
        return this.mEnableAutoFaceFocus;
    }

    @VisibleForTesting
    public boolean isEnableFaceDetection() {
        return this.mEnableFaceDetection;
    }

    @VisibleForTesting
    public boolean isFaceDetectionStarted() {
        return this.mIsFaceDetectionStarted;
    }

    public native void nativeNotifyCameraExposureAreaChanged(long j, int i, int i2, int i3, int i4);

    public native void nativeNotifyCameraFocusAreaChanged(long j, int i, int i2, int i3, int i4);

    public void notifyCameraExposureAreaChanged(Rect rect) {
        long j = this.mNativeVideoCaptureAndroid;
        if (j != 0) {
            VideoCaptureFormat videoCaptureFormat = this.mCaptureFormat;
            nativeNotifyCameraExposureAreaChanged(j, videoCaptureFormat.mWidth, videoCaptureFormat.mHeight, rect.left, rect.top);
        }
    }

    public void notifyCameraFocusAreaChanged(Rect rect) {
        long j = this.mNativeVideoCaptureAndroid;
        if (j != 0) {
            nativeNotifyCameraFocusAreaChanged(j, rect.width(), rect.height(), rect.left, rect.top);
        }
    }

    public void notifyFaceDetection(int i, int i2, ArrayList<RectF> arrayList, ArrayList<Double> arrayList2) {
        int size = arrayList.size();
        if (this.mNativeVideoCaptureAndroid == 0 || size <= 0) {
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        for (int i3 = 0; i3 <= size - 1; i3++) {
            Rect rect = new Rect();
            arrayList.get(i3).round(rect);
            arrayList3.add(new FaceDetectionInfo(i3, rect, arrayList2.get(i3).doubleValue()));
        }
        this.mPerFrameFaceDetectionInfoQueue.offer(arrayList3);
    }

    @VisibleForTesting
    public void setCameraProxyHandler() {
        HandlerThread handlerThread = new HandlerThread("VideoCaptureCamera_ProxyThread");
        handlerThread.start();
        this.mProxyThreadHandler = new Handler(handlerThread.getLooper());
    }

    @Override // io.agora.rtc2.video.IVideoCaptureCamera
    public void setPreviewInfo(View view, boolean z, int i) {
        this.mRenderView = new CaptureViewWeakRef(view);
        this.isMirror = z;
        this.mRenderMode = i;
    }
}
