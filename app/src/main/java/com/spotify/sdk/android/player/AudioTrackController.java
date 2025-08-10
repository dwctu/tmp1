package com.spotify.sdk.android.player;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.os.Build;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes3.dex */
public class AudioTrackController implements AudioController {
    private static final int AUDIO_BUFFER_CAPACITY = 81920;
    private static final int AUDIO_BUFFER_SIZE_FRAMES = 2048;
    private static final int AUDIO_BUFFER_SIZE_SAMPLES = 4096;
    private static final int BUFFER_LATENCY_FACTOR = 2;
    private static final int DEFAULT_CHANNEL_COUNT = 2;
    private AudioTrack mAudioTrack;
    private int mChannels;
    private int mSampleRate;
    private final ExecutorService mExecutorService = Executors.newSingleThreadExecutor();
    private final Object mPlayingMutex = new Object();
    private final Runnable mAudioRunnable = new Runnable() { // from class: com.spotify.sdk.android.player.AudioTrackController.1
        public final short[] pendingSamples = new short[4096];

        @Override // java.lang.Runnable
        public void run() {
            int iPeek = AudioTrackController.this.mAudioBuffer.peek(this.pendingSamples);
            if (iPeek > 0) {
                AudioTrackController.this.mAudioBuffer.remove(AudioTrackController.this.writeSamplesToAudioOutput(this.pendingSamples, iPeek));
            }
        }
    };
    private final AudioRingBuffer mAudioBuffer = new AudioRingBuffer(AUDIO_BUFFER_CAPACITY);

    @TargetApi(21)
    private void createAudioTrack(int i, int i2) {
        int i3;
        if (i2 == 0) {
            throw new IllegalStateException("Input source has 0 channels");
        }
        if (i2 == 1) {
            i3 = 4;
        } else {
            if (i2 != 2) {
                throw new IllegalArgumentException("Unsupported input source has " + i2 + " channels");
            }
            i3 = 12;
        }
        int minBufferSize = AudioTrack.getMinBufferSize(i, i3, 2) * 2;
        float maxVolume = AudioTrack.getMaxVolume();
        synchronized (this.mPlayingMutex) {
            AudioTrack audioTrack = new AudioTrack(3, i, i3, 2, minBufferSize, 1);
            this.mAudioTrack = audioTrack;
            if (audioTrack.getState() == 1) {
                if (Build.VERSION.SDK_INT >= 21) {
                    this.mAudioTrack.setVolume(maxVolume);
                } else {
                    this.mAudioTrack.setStereoVolume(maxVolume, maxVolume);
                }
                this.mAudioTrack.play();
            } else {
                this.mAudioTrack.release();
                this.mAudioTrack = null;
            }
        }
    }

    private boolean isAudioTrackPlaying() {
        AudioTrack audioTrack = this.mAudioTrack;
        return audioTrack != null && audioTrack.getPlayState() == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int writeSamplesToAudioOutput(short[] sArr, int i) {
        int iWrite;
        if (!isAudioTrackPlaying() || (iWrite = this.mAudioTrack.write(sArr, 0, i)) <= 0) {
            return 0;
        }
        return iWrite;
    }

    @Override // com.spotify.sdk.android.player.AudioController
    public int onAudioDataDelivered(short[] sArr, int i, int i2, int i3) {
        if (this.mAudioTrack != null && (this.mSampleRate != i2 || this.mChannels != i3)) {
            synchronized (this.mPlayingMutex) {
                this.mAudioTrack.release();
                this.mAudioTrack = null;
            }
        }
        this.mSampleRate = i2;
        this.mChannels = i3;
        if (this.mAudioTrack == null) {
            createAudioTrack(i2, i3);
        }
        try {
            this.mExecutorService.execute(this.mAudioRunnable);
        } catch (RejectedExecutionException unused) {
        }
        return this.mAudioBuffer.write(sArr, i);
    }

    @Override // com.spotify.sdk.android.player.AudioController
    public void onAudioFlush() {
        this.mAudioBuffer.clear();
        if (this.mAudioTrack != null) {
            synchronized (this.mPlayingMutex) {
                this.mAudioTrack.pause();
                this.mAudioTrack.flush();
                this.mAudioTrack.release();
                this.mAudioTrack = null;
            }
        }
    }

    @Override // com.spotify.sdk.android.player.AudioController
    public void onAudioPaused() throws IllegalStateException {
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            audioTrack.pause();
        }
    }

    @Override // com.spotify.sdk.android.player.AudioController
    public void onAudioResumed() throws IllegalStateException {
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            audioTrack.play();
        }
    }

    @Override // com.spotify.sdk.android.player.AudioController
    public void start() {
    }

    @Override // com.spotify.sdk.android.player.AudioController
    public void stop() {
        this.mExecutorService.shutdown();
    }
}
