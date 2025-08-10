package io.agora.rtc2;

import com.google.android.exoplayer2.audio.AacUtil;
import io.agora.base.internal.CalledByNative;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes4.dex */
public class ScreenCaptureParameters {
    public boolean captureAudio = false;
    public VideoCaptureParameters videoCaptureParameters = new VideoCaptureParameters();
    public boolean captureVideo = true;
    public AudioCaptureParameters audioCaptureParameters = new AudioCaptureParameters();

    public static class AudioCaptureParameters {
        public int sampleRate = AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND;
        public int channels = 2;
        public int captureSignalVolume = 100;

        @CalledByNative("AudioCaptureParameters")
        public int getCaptureSignalVolume() {
            return this.captureSignalVolume;
        }

        @CalledByNative("AudioCaptureParameters")
        public int getChannels() {
            return this.channels;
        }

        @CalledByNative("AudioCaptureParameters")
        public int getSampleRate() {
            return this.sampleRate;
        }

        public String toString() {
            return "AudioCaptureParameters{sampleRate=" + this.sampleRate + ", channels=" + this.channels + ", captureSignalVolume=" + this.captureSignalVolume + MessageFormatter.DELIM_STOP;
        }
    }

    public static class VideoCaptureParameters {
        public int bitrate = 0;
        public int framerate = 15;
        public int width = 1280;
        public int height = 720;
        public int contentHint = 1;

        @CalledByNative("VideoCaptureParameters")
        public int getBitrate() {
            return this.bitrate;
        }

        @CalledByNative("VideoCaptureParameters")
        public int getContentHint() {
            return this.contentHint;
        }

        @CalledByNative("VideoCaptureParameters")
        public int getFramerate() {
            return this.framerate;
        }

        @CalledByNative("VideoCaptureParameters")
        public int getHeight() {
            return this.height;
        }

        @CalledByNative("VideoCaptureParameters")
        public int getWidth() {
            return this.width;
        }

        public String toString() {
            return "VideoCaptureParameters{bitrate=" + this.bitrate + ", framerate=" + this.framerate + ", width=" + this.width + ", height=" + this.height + ", contentHint=" + this.contentHint + MessageFormatter.DELIM_STOP;
        }
    }

    @CalledByNative
    public AudioCaptureParameters getAudioCaptureParameters() {
        return this.audioCaptureParameters;
    }

    @CalledByNative
    public VideoCaptureParameters getVideoCaptureParameters() {
        return this.videoCaptureParameters;
    }

    @CalledByNative
    public boolean isCaptureAudio() {
        return this.captureAudio;
    }

    @CalledByNative
    public boolean isCaptureVideo() {
        return this.captureVideo;
    }

    public String toString() {
        return "ScreenCaptureParameters{captureAudio=" + this.captureAudio + ", videoCaptureParameters=" + this.videoCaptureParameters + ", captureVideo=" + this.captureVideo + ", audioCaptureParameters=" + this.audioCaptureParameters + MessageFormatter.DELIM_STOP;
    }
}
