package io.microshow.rxffmpeg.player;

import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class MeasureHelper {
    private FitModel mFitModel = FitModel.FM_DEFAULT;
    private int mMeasuredHeight;
    private int mMeasuredWidth;
    private VideoSizeInfo mVideoSizeInfo;
    private WeakReference<View> mWeakView;

    public enum FitModel {
        FM_DEFAULT,
        FM_FULL_SCREEN_WIDTH,
        FM_FULL_SCREEN_HEIGHT,
        FM_WH_16X9
    }

    public static class VideoSizeInfo {
        private float mDar;
        private int mHeight;
        private int mWidth;

        public VideoSizeInfo(int i, int i2, float f) {
            this.mWidth = i;
            this.mHeight = i2;
            this.mDar = f;
        }

        public float getDar() {
            return this.mDar;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getWidth() {
            return this.mWidth;
        }
    }

    public MeasureHelper(View view) {
        this.mWeakView = new WeakReference<>(view);
    }

    public int[] doMeasure(int i, int i2) {
        FitModel fitModel = this.mFitModel;
        if (fitModel == FitModel.FM_DEFAULT || fitModel == FitModel.FM_FULL_SCREEN_HEIGHT) {
            i2 = this.mMeasuredHeight;
        }
        return new int[]{i, i2};
    }

    public FitModel getFitModel() {
        return this.mFitModel;
    }

    public VideoSizeInfo getVideoSizeInfo() {
        return this.mVideoSizeInfo;
    }

    public View getView() {
        View view;
        WeakReference<View> weakReference = this.mWeakView;
        if (weakReference == null || (view = weakReference.get()) == null) {
            return null;
        }
        return view;
    }

    public boolean isFullScreen() {
        return false;
    }

    public void setDefaultVideoLayoutParams() {
        View view = getView();
        if (view instanceof RxFFmpegPlayerView) {
            RxFFmpegPlayerView rxFFmpegPlayerView = (RxFFmpegPlayerView) view;
            int screenWidth = Helper.getScreenWidth(view.getContext());
            int i = (screenWidth * 9) / 16;
            setVideoSizeInfo(new VideoSizeInfo(screenWidth, i, screenWidth / i));
            setVideoLayoutParams(rxFFmpegPlayerView.getTextureView(), rxFFmpegPlayerView.getContainerView());
        }
    }

    public void setFitModel(FitModel fitModel) {
        this.mFitModel = fitModel;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setVideoLayoutParams(android.view.TextureView r8, android.widget.FrameLayout r9) {
        /*
            r7 = this;
            if (r8 == 0) goto La0
            if (r9 == 0) goto La0
            io.microshow.rxffmpeg.player.MeasureHelper$VideoSizeInfo r0 = r7.getVideoSizeInfo()
            if (r0 != 0) goto Lc
            goto La0
        Lc:
            io.microshow.rxffmpeg.player.MeasureHelper$VideoSizeInfo r0 = r7.getVideoSizeInfo()
            int r0 = r0.getWidth()
            io.microshow.rxffmpeg.player.MeasureHelper$VideoSizeInfo r1 = r7.getVideoSizeInfo()
            int r1 = r1.getHeight()
            io.microshow.rxffmpeg.player.MeasureHelper$VideoSizeInfo r2 = r7.getVideoSizeInfo()
            r2.getDar()
            float r2 = (float) r0
            float r3 = (float) r1
            float r2 = r2 / r3
            android.view.View r3 = r7.getView()
            android.content.Context r3 = r3.getContext()
            int r3 = io.microshow.rxffmpeg.player.Helper.getScreenWidth(r3)
            boolean r4 = r7.isFullScreen()
            if (r4 == 0) goto L4c
            android.view.View r0 = r7.getView()
            android.content.Context r0 = r0.getContext()
            int r3 = io.microshow.rxffmpeg.player.Helper.getScreenHeight(r0)
        L44:
            float r0 = (float) r3
            float r0 = r0 * r2
            int r0 = (int) r0
            r6 = r3
            r3 = r0
            r0 = r6
            goto L77
        L4c:
            io.microshow.rxffmpeg.player.MeasureHelper$FitModel r4 = r7.mFitModel
            io.microshow.rxffmpeg.player.MeasureHelper$FitModel r5 = io.microshow.rxffmpeg.player.MeasureHelper.FitModel.FM_FULL_SCREEN_WIDTH
            if (r4 != r5) goto L56
        L52:
            float r0 = (float) r3
            float r0 = r0 / r2
            int r0 = (int) r0
            goto L77
        L56:
            io.microshow.rxffmpeg.player.MeasureHelper$FitModel r5 = io.microshow.rxffmpeg.player.MeasureHelper.FitModel.FM_FULL_SCREEN_HEIGHT
            if (r4 != r5) goto L67
            android.view.View r0 = r7.getView()
            android.content.Context r0 = r0.getContext()
            int r3 = io.microshow.rxffmpeg.player.Helper.getFullScreenHeight(r0)
            goto L44
        L67:
            io.microshow.rxffmpeg.player.MeasureHelper$FitModel r5 = io.microshow.rxffmpeg.player.MeasureHelper.FitModel.FM_WH_16X9
            if (r4 != r5) goto L70
            int r3 = r3 * 9
            int r3 = r3 / 16
            goto L44
        L70:
            if (r0 <= r1) goto L73
            goto L52
        L73:
            if (r0 >= r1) goto L76
            goto L44
        L76:
            r0 = r3
        L77:
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
            r1.<init>(r3, r0)
            r2 = 17
            r1.gravity = r2
            r8.setLayoutParams(r1)
            android.widget.FrameLayout$LayoutParams r8 = new android.widget.FrameLayout$LayoutParams
            android.view.View r1 = r7.getView()
            android.content.Context r1 = r1.getContext()
            int r1 = io.microshow.rxffmpeg.player.Helper.getScreenWidth(r1)
            r8.<init>(r1, r0)
            r9.setLayoutParams(r8)
            r7.mMeasuredHeight = r0
            android.view.View r8 = r7.getView()
            r8.requestLayout()
        La0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.microshow.rxffmpeg.player.MeasureHelper.setVideoLayoutParams(android.view.TextureView, android.widget.FrameLayout):void");
    }

    public void setVideoSizeInfo(VideoSizeInfo videoSizeInfo) {
        this.mVideoSizeInfo = videoSizeInfo;
    }
}
