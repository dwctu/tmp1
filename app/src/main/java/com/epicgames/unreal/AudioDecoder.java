package com.epicgames.unreal;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class AudioDecoder {
    private byte[] mAacSpecificConfig;
    private int mBitsPerSample;
    private int mChannelCount;
    private int mSampleRate;
    private MediaCodec mAudioCodec = null;
    private boolean bIsInitialized = false;

    private boolean CreateCodec() {
        synchronized (this) {
            try {
                try {
                    this.mAudioCodec = MediaCodec.createDecoderByType(MimeTypes.AUDIO_AAC);
                    MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat(MimeTypes.AUDIO_AAC, this.mSampleRate, this.mChannelCount);
                    mediaFormatCreateAudioFormat.setInteger("bitrate", this.mBitsPerSample);
                    mediaFormatCreateAudioFormat.setByteBuffer("csd-0", ByteBuffer.wrap(new byte[]{Ascii.DC2, Ascii.DC2}));
                    this.mAudioCodec.configure(mediaFormatCreateAudioFormat, (Surface) null, (MediaCrypto) null, 0);
                    this.mAudioCodec.start();
                    this.bIsInitialized = true;
                } catch (Exception e) {
                    GameActivity.Log.warn("Android Audio Decoder: CreateCodec failed!");
                    e.printStackTrace();
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    public byte[] DecodeAudio(byte[] bArr) {
        byte[] bArr2;
        synchronized (this) {
            bArr2 = null;
            MediaCodec mediaCodec = this.mAudioCodec;
            if (mediaCodec != null) {
                int iDequeueInputBuffer = mediaCodec.dequeueInputBuffer(-1L);
                if (iDequeueInputBuffer >= 0) {
                    int length = bArr.length;
                    ByteBuffer inputBuffer = this.mAudioCodec.getInputBuffer(iDequeueInputBuffer);
                    inputBuffer.clear();
                    inputBuffer.put(bArr);
                    inputBuffer.clear();
                    this.mAudioCodec.queueInputBuffer(iDequeueInputBuffer, 0, length, 0L, 0);
                }
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                int iDequeueOutputBuffer = this.mAudioCodec.dequeueOutputBuffer(bufferInfo, 10000L);
                if (iDequeueOutputBuffer == -3) {
                    GameActivity.Log.debug("Android Audio Decoder: INFO_OUTPUT_BUFFERS_CHANGED");
                } else if (iDequeueOutputBuffer == -2) {
                    GameActivity.Log.debug("Android Audio Decoder: New format " + this.mAudioCodec.getOutputFormat());
                } else if (iDequeueOutputBuffer != -1) {
                    ByteBuffer outputBuffer = this.mAudioCodec.getOutputBuffer(iDequeueOutputBuffer);
                    byte[] bArr3 = new byte[bufferInfo.size];
                    outputBuffer.get(bArr3);
                    outputBuffer.clear();
                    this.mAudioCodec.releaseOutputBuffer(iDequeueOutputBuffer, true);
                    bArr2 = bArr3;
                } else {
                    GameActivity.Log.debug("Android Audio Decoder: dequeueOutputBuffer timed out!");
                }
            }
        }
        return bArr2;
    }

    public void release() {
        resetCodec();
    }

    public void resetCodec() {
        synchronized (this) {
            MediaCodec mediaCodec = this.mAudioCodec;
            if (mediaCodec != null) {
                try {
                    mediaCodec.stop();
                    this.mAudioCodec.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean updateConfig(int i, int i2, int i3, byte[] bArr) {
        boolean zCreateCodec;
        synchronized (this) {
            GameActivity.Log.warn("Android Audio Decoder: updateConfig channelCount:" + i2);
            this.bIsInitialized = false;
            this.mSampleRate = i;
            this.mChannelCount = i2;
            this.mBitsPerSample = i3;
            this.mAacSpecificConfig = bArr;
            resetCodec();
            zCreateCodec = CreateCodec();
        }
        return zCreateCodec;
    }
}
