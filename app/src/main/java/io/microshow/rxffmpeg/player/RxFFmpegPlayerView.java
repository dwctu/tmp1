package io.microshow.rxffmpeg.player;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import io.microshow.rxffmpeg.player.IMediaPlayer;
import io.microshow.rxffmpeg.player.MeasureHelper;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class RxFFmpegPlayerView extends FrameLayout {
    public static final int MODE_FULL_SCREEN = 1;
    public static final int MODE_NORMAL = 0;
    private FrameLayout mContainer;
    private Context mContext;
    private int mCurrentMode;
    private MeasureHelper mMeasureHelper;
    public BaseMediaPlayer mPlayer;
    private RxFFmpegPlayerController mPlayerController;
    public PlayerCoreType mPlayerCoreType;
    private TextureView mTextureView;

    public enum PlayerCoreType {
        PCT_RXFFMPEG_PLAYER,
        PCT_SYSTEM_MEDIA_PLAYER
    }

    public static class VideoSizeChangedListener implements IMediaPlayer.OnVideoSizeChangedListener {
        private WeakReference<RxFFmpegPlayerView> mWeakReference;

        public VideoSizeChangedListener(RxFFmpegPlayerView rxFFmpegPlayerView) {
            this.mWeakReference = new WeakReference<>(rxFFmpegPlayerView);
        }

        @Override // io.microshow.rxffmpeg.player.IMediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, float f) {
            RxFFmpegPlayerView rxFFmpegPlayerView = this.mWeakReference.get();
            if (rxFFmpegPlayerView != null) {
                rxFFmpegPlayerView.updateVideoLayoutParams(i, i2, f);
            }
        }
    }

    public RxFFmpegPlayerView(Context context) {
        this(context, null);
    }

    private void addTextureView() {
        this.mContainer.removeView(this.mTextureView);
        this.mContainer.addView(this.mTextureView, 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    private void initContainer() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.mContainer = frameLayout;
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.mContainer, new FrameLayout.LayoutParams(-1, -1));
    }

    private void initPlayer() {
        if (this.mTextureView == null) {
            this.mTextureView = new ScaleTextureView(this.mContext);
        }
        if (this.mPlayerCoreType == PlayerCoreType.PCT_SYSTEM_MEDIA_PLAYER) {
            this.mPlayer = new SystemMediaPlayerImpl();
        } else {
            this.mPlayer = new RxFFmpegPlayerImpl();
        }
        this.mPlayer.setTextureView(this.mTextureView);
        this.mPlayer.setOnVideoSizeChangedListener(new VideoSizeChangedListener(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVideoLayoutParams(final int i, final int i2, final float f) {
        post(new Runnable() { // from class: io.microshow.rxffmpeg.player.RxFFmpegPlayerView.2
            @Override // java.lang.Runnable
            public void run() {
                RxFFmpegPlayerView.this.mMeasureHelper.setVideoSizeInfo(new MeasureHelper.VideoSizeInfo(i, i2, f));
                RxFFmpegPlayerView.this.mMeasureHelper.setVideoLayoutParams(RxFFmpegPlayerView.this.mTextureView, RxFFmpegPlayerView.this.mContainer);
            }
        });
    }

    public boolean enterFullScreen() {
        ViewGroup fullScreen;
        if (this.mCurrentMode == 1 || (fullScreen = Helper.setFullScreen(this.mContext, true)) == null) {
            return false;
        }
        removeView(this.mContainer);
        fullScreen.addView(this.mContainer, new FrameLayout.LayoutParams(-1, -1));
        this.mCurrentMode = 1;
        return true;
    }

    public boolean exitFullScreen() {
        ViewGroup fullScreen;
        if (this.mCurrentMode != 1 || (fullScreen = Helper.setFullScreen(this.mContext, false)) == null) {
            return false;
        }
        fullScreen.removeView(this.mContainer);
        addView(this.mContainer, new FrameLayout.LayoutParams(-1, -1));
        this.mCurrentMode = 0;
        return false;
    }

    public FrameLayout getContainerView() {
        return this.mContainer;
    }

    public int getMuteSolo() {
        BaseMediaPlayer baseMediaPlayer = this.mPlayer;
        if (baseMediaPlayer == null || baseMediaPlayer.getMuteSolo() == -1) {
            return 0;
        }
        return this.mPlayer.getMuteSolo();
    }

    public TextureView getTextureView() {
        return this.mTextureView;
    }

    public int getVolume() {
        BaseMediaPlayer baseMediaPlayer = this.mPlayer;
        if (baseMediaPlayer == null || baseMediaPlayer.getVolume() == -1) {
            return 100;
        }
        return this.mPlayer.getVolume();
    }

    public boolean isFullScreenModel() {
        return this.mCurrentMode == 1;
    }

    public boolean isLooping() {
        BaseMediaPlayer baseMediaPlayer = this.mPlayer;
        return baseMediaPlayer != null && baseMediaPlayer.isLooping();
    }

    public boolean isPlaying() {
        BaseMediaPlayer baseMediaPlayer = this.mPlayer;
        return baseMediaPlayer != null && baseMediaPlayer.isPlaying();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        MeasureHelper measureHelper = this.mMeasureHelper;
        if (measureHelper != null) {
            measureHelper.setVideoLayoutParams(this.mTextureView, this.mContainer);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int[] iArrDoMeasure = this.mMeasureHelper.doMeasure(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(iArrDoMeasure[0], iArrDoMeasure[1]);
    }

    public void pause() {
        BaseMediaPlayer baseMediaPlayer = this.mPlayer;
        if (baseMediaPlayer != null) {
            baseMediaPlayer.pause();
            RxFFmpegPlayerController rxFFmpegPlayerController = this.mPlayerController;
            if (rxFFmpegPlayerController != null) {
                rxFFmpegPlayerController.onPause();
            }
        }
    }

    public void play(String str, boolean z) {
        if (this.mPlayer == null || Helper.isFastClick()) {
            return;
        }
        this.mPlayer.play(str, z);
        RxFFmpegPlayerController rxFFmpegPlayerController = this.mPlayerController;
        if (rxFFmpegPlayerController != null) {
            rxFFmpegPlayerController.onResume();
        }
    }

    public void release() {
        BaseMediaPlayer baseMediaPlayer = this.mPlayer;
        if (baseMediaPlayer != null) {
            baseMediaPlayer.release();
            this.mPlayer = null;
        }
        setKeepScreenOn(false);
    }

    public void repeatPlay() {
        BaseMediaPlayer baseMediaPlayer = this.mPlayer;
        if (baseMediaPlayer != null) {
            baseMediaPlayer.repeatPlay();
        }
    }

    public void resume() {
        BaseMediaPlayer baseMediaPlayer = this.mPlayer;
        if (baseMediaPlayer != null) {
            baseMediaPlayer.resume();
            RxFFmpegPlayerController rxFFmpegPlayerController = this.mPlayerController;
            if (rxFFmpegPlayerController != null) {
                rxFFmpegPlayerController.onResume();
            }
        }
    }

    public void setController(RxFFmpegPlayerController rxFFmpegPlayerController, MeasureHelper.FitModel fitModel) {
        initPlayer();
        setFitModel(fitModel);
        this.mContainer.removeView(this.mPlayerController);
        this.mPlayerController = rxFFmpegPlayerController;
        rxFFmpegPlayerController.setPlayerView(this);
        this.mContainer.addView(this.mPlayerController, new FrameLayout.LayoutParams(-1, -1));
        addTextureView();
    }

    public void setFitModel(MeasureHelper.FitModel fitModel) {
        MeasureHelper measureHelper = this.mMeasureHelper;
        if (measureHelper == null || fitModel == null) {
            return;
        }
        measureHelper.setFitModel(fitModel);
        this.mMeasureHelper.setDefaultVideoLayoutParams();
    }

    public void setMuteSolo(int i) {
        BaseMediaPlayer baseMediaPlayer = this.mPlayer;
        if (baseMediaPlayer != null) {
            baseMediaPlayer.setMuteSolo(i);
        }
    }

    public void setOnCompleteListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        BaseMediaPlayer baseMediaPlayer = this.mPlayer;
        if (baseMediaPlayer != null) {
            baseMediaPlayer.setOnCompleteListener(onCompletionListener);
        }
    }

    public void setPlayerBackgroundColor(int i) {
        FrameLayout frameLayout = this.mContainer;
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(i);
        }
    }

    public void setTextureViewEnabledTouch(boolean z) {
        TextureView textureView = this.mTextureView;
        if (textureView == null || !(textureView instanceof ScaleTextureView)) {
            return;
        }
        ((ScaleTextureView) textureView).setEnabledTouch(z);
    }

    public void setVolume(int i) {
        BaseMediaPlayer baseMediaPlayer = this.mPlayer;
        if (baseMediaPlayer != null) {
            baseMediaPlayer.setVolume(i);
        }
    }

    public void switchPlayerCore(PlayerCoreType playerCoreType) {
        this.mPlayerCoreType = playerCoreType;
    }

    public boolean switchScreen() {
        return isFullScreenModel() ? exitFullScreen() : enterFullScreen();
    }

    public RxFFmpegPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPlayerCoreType = PlayerCoreType.PCT_RXFFMPEG_PLAYER;
        this.mCurrentMode = 0;
        this.mContext = context;
        this.mMeasureHelper = new MeasureHelper(this) { // from class: io.microshow.rxffmpeg.player.RxFFmpegPlayerView.1
            @Override // io.microshow.rxffmpeg.player.MeasureHelper
            public boolean isFullScreen() {
                return RxFFmpegPlayerView.this.mCurrentMode == 1;
            }
        };
        initContainer();
        setKeepScreenOn(true);
    }
}
