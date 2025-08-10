package io.agora.spatialaudio.internal;

import io.agora.rtc2.RtcConnection;
import io.agora.rtc2.RtcEngine;
import io.agora.spatialaudio.ILocalSpatialAudioEngine;
import io.agora.spatialaudio.LocalSpatialAudioConfig;
import io.agora.spatialaudio.RemoteVoicePositionInfo;
import io.agora.spatialaudio.SpatialAudioZone;
import java.util.Locale;

/* loaded from: classes4.dex */
public class LocalSpatialAudioImpl extends ILocalSpatialAudioEngine {
    private static final String TAG = "LocalSpatialAudioImpl";
    private long mNativeHandle = 0;

    public static String getChannelId(RtcConnection rtcConnection) {
        if (rtcConnection != null) {
            return rtcConnection.channelId;
        }
        return null;
    }

    public static int getUserId(RtcConnection rtcConnection) {
        if (rtcConnection != null) {
            return rtcConnection.localUid;
        }
        return 0;
    }

    private native int nativeClearRemotePositions(long j);

    private native int nativeClearRemotePositionsEx(long j, String str, int i);

    private static native int nativeDestroy(long j);

    private native int nativeMuteRemoteAudioStream(long j, int i, boolean z);

    private native long nativeObjectInit(LocalSpatialAudioConfig localSpatialAudioConfig, long j);

    private native int nativeRemoveRemotePosition(long j, int i);

    private native int nativeRemoveRemotePositionEx(long j, int i, String str, int i2);

    private native int nativeSetParameters(long j, String str);

    private native int nativeSetPlayerAttenuation(long j, int i, double d, boolean z);

    private native int nativeSetRemoteAudioAttenuation(long j, int i, double d, boolean z);

    private native int nativeSetZones(long j, SpatialAudioZone[] spatialAudioZoneArr);

    private native int nativeUpdatePlayerPositionInfo(long j, int i, RemoteVoicePositionInfo remoteVoicePositionInfo);

    private native int nativeUpdateRemotePosition(long j, int i, float[] fArr, float[] fArr2);

    private native int nativeUpdateRemotePositionEx(long j, int i, float[] fArr, float[] fArr2, String str, int i2);

    private native int nativeUpdateSelfPosition(long j, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4);

    private native int nativeUpdateSelfPositionEx(long j, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, String str, int i);

    @Override // io.agora.spatialaudio.ILocalSpatialAudioEngine
    public int clearRemotePositions() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeClearRemotePositions(j);
    }

    @Override // io.agora.spatialaudio.ILocalSpatialAudioEngine
    public int clearRemotePositionsEx(RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeClearRemotePositionsEx(j, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.spatialaudio.ILocalSpatialAudioEngine
    public int initialize(LocalSpatialAudioConfig localSpatialAudioConfig) {
        RtcEngine rtcEngine = localSpatialAudioConfig.mRtcEngine;
        if (rtcEngine == null) {
            return -2;
        }
        long jNativeObjectInit = nativeObjectInit(localSpatialAudioConfig, rtcEngine.getNativeHandle());
        this.mNativeHandle = jNativeObjectInit;
        return jNativeObjectInit == 0 ? -7 : 0;
    }

    @Override // io.agora.spatialaudio.IBaseSpatialAudioEngine
    public int muteAllRemoteAudioStreams(boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        Locale locale = Locale.US;
        Object[] objArr = new Object[1];
        objArr[0] = z ? "true" : "false";
        return nativeSetParameters(j, String.format(locale, "{\"rtc.local_spatial_audio.mute_all_remote_audio_streams\":%s}", objArr));
    }

    @Override // io.agora.spatialaudio.IBaseSpatialAudioEngine
    public int muteLocalAudioStream(boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        Locale locale = Locale.US;
        Object[] objArr = new Object[1];
        objArr[0] = z ? "true" : "false";
        return nativeSetParameters(j, String.format(locale, "{\"rtc.local_spatial_audio.mute_local_stream\":%s}", objArr));
    }

    @Override // io.agora.spatialaudio.IBaseSpatialAudioEngine
    public int muteRemoteAudioStream(int i, boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeMuteRemoteAudioStream(j, i, z);
    }

    @Override // io.agora.spatialaudio.ILocalSpatialAudioEngine
    public int release() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return 0;
        }
        nativeDestroy(j);
        this.mNativeHandle = 0L;
        return 0;
    }

    @Override // io.agora.spatialaudio.ILocalSpatialAudioEngine
    public int removeRemotePosition(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeRemoveRemotePosition(j, i);
    }

    @Override // io.agora.spatialaudio.ILocalSpatialAudioEngine
    public int removeRemotePositionEx(int i, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeRemoveRemotePositionEx(j, i, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.spatialaudio.IBaseSpatialAudioEngine
    public int setAudioRecvRange(float f) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetParameters(j, String.format(Locale.US, "{\"rtc.local_spatial_audio.hear_range\":%f}", Float.valueOf(f)));
    }

    @Override // io.agora.spatialaudio.IBaseSpatialAudioEngine
    public int setDistanceUnit(float f) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetParameters(j, String.format(Locale.US, "{\"rtc.local_spatial_audio.distance_unit\":%f}", Float.valueOf(f)));
    }

    @Override // io.agora.spatialaudio.IBaseSpatialAudioEngine
    public int setMaxAudioRecvCount(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetParameters(j, String.format(Locale.US, "{\"rtc.local_spatial_audio.max_hear_count\":%d}", Integer.valueOf(i)));
    }

    @Override // io.agora.spatialaudio.IBaseSpatialAudioEngine
    public int setPlayerAttenuation(int i, double d, boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetPlayerAttenuation(j, i, d, z);
    }

    @Override // io.agora.spatialaudio.ILocalSpatialAudioEngine
    public int setRemoteAudioAttenuation(int i, double d, boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetRemoteAudioAttenuation(j, i, d, z);
    }

    @Override // io.agora.spatialaudio.IBaseSpatialAudioEngine
    public int setZones(SpatialAudioZone[] spatialAudioZoneArr) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        if (spatialAudioZoneArr == null || spatialAudioZoneArr.length <= 0) {
            return -2;
        }
        for (int i = 0; i < spatialAudioZoneArr.length; i++) {
            if (spatialAudioZoneArr[i] == null || spatialAudioZoneArr[i].position == null || spatialAudioZoneArr[i].position.length != 3 || spatialAudioZoneArr[i].forward == null || spatialAudioZoneArr[i].forward.length != 3 || spatialAudioZoneArr[i].right == null || spatialAudioZoneArr[i].right.length != 3 || spatialAudioZoneArr[i].up == null || spatialAudioZoneArr[i].up.length != 3) {
                return -2;
            }
        }
        return nativeSetZones(this.mNativeHandle, spatialAudioZoneArr);
    }

    @Override // io.agora.spatialaudio.IBaseSpatialAudioEngine
    public int updatePlayerPositionInfo(int i, RemoteVoicePositionInfo remoteVoicePositionInfo) {
        float[] fArr;
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        if (remoteVoicePositionInfo == null || (fArr = remoteVoicePositionInfo.position) == null || fArr.length != 3) {
            return -2;
        }
        float[] fArr2 = remoteVoicePositionInfo.forward;
        if (fArr2 == null || fArr2.length == 3) {
            return nativeUpdatePlayerPositionInfo(j, i, remoteVoicePositionInfo);
        }
        return -2;
    }

    @Override // io.agora.spatialaudio.ILocalSpatialAudioEngine
    public int updateRemotePosition(int i, RemoteVoicePositionInfo remoteVoicePositionInfo) {
        float[] fArr;
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        if (remoteVoicePositionInfo == null || (fArr = remoteVoicePositionInfo.position) == null || fArr.length != 3) {
            return -2;
        }
        if (remoteVoicePositionInfo.forward == null) {
            remoteVoicePositionInfo.forward = new float[]{0.0f, 0.0f, 0.0f};
        }
        return nativeUpdateRemotePosition(j, i, fArr, remoteVoicePositionInfo.forward);
    }

    @Override // io.agora.spatialaudio.ILocalSpatialAudioEngine
    public int updateRemotePositionEx(int i, RemoteVoicePositionInfo remoteVoicePositionInfo, RtcConnection rtcConnection) {
        float[] fArr;
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        if (remoteVoicePositionInfo == null || (fArr = remoteVoicePositionInfo.position) == null || fArr.length != 3) {
            return -2;
        }
        if (remoteVoicePositionInfo.forward == null) {
            remoteVoicePositionInfo.forward = new float[]{0.0f, 0.0f, 0.0f};
        }
        return nativeUpdateRemotePositionEx(j, i, fArr, remoteVoicePositionInfo.forward, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.spatialaudio.IBaseSpatialAudioEngine
    public int updateSelfPosition(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        if (fArr.length == 3 && fArr2.length == 3 && fArr3.length == 3 && fArr4.length == 3) {
            return nativeUpdateSelfPosition(j, fArr, fArr2, fArr3, fArr4);
        }
        return -2;
    }

    @Override // io.agora.spatialaudio.IBaseSpatialAudioEngine
    public int updateSelfPositionEx(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        if (fArr.length == 3 && fArr2.length == 3 && fArr3.length == 3 && fArr4.length == 3) {
            return nativeUpdateSelfPositionEx(j, fArr, fArr2, fArr3, fArr4, getChannelId(rtcConnection), getUserId(rtcConnection));
        }
        return -2;
    }
}
