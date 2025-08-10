package org.webrtc;

import androidx.annotation.Nullable;
import java.util.Arrays;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.webrtc.PeerConnection;

/* loaded from: classes5.dex */
public class IceCandidate {
    public final PeerConnection.AdapterType adapterType;
    public final String sdp;
    public final int sdpMLineIndex;
    public final String sdpMid;
    public final String serverUrl;

    public IceCandidate(String str, int i, String str2) {
        this.sdpMid = str;
        this.sdpMLineIndex = i;
        this.sdp = str2;
        this.serverUrl = "";
        this.adapterType = PeerConnection.AdapterType.UNKNOWN;
    }

    private static boolean objectEquals(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof IceCandidate)) {
            return false;
        }
        IceCandidate iceCandidate = (IceCandidate) obj;
        return objectEquals(this.sdpMid, iceCandidate.sdpMid) && this.sdpMLineIndex == iceCandidate.sdpMLineIndex && objectEquals(this.sdp, iceCandidate.sdp);
    }

    @CalledByNative
    public String getSdp() {
        return this.sdp;
    }

    @CalledByNative
    public String getSdpMid() {
        return this.sdpMid;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sdpMid, Integer.valueOf(this.sdpMLineIndex), this.sdp});
    }

    public String toString() {
        return this.sdpMid + SignatureImpl.INNER_SEP + this.sdpMLineIndex + SignatureImpl.INNER_SEP + this.sdp + SignatureImpl.INNER_SEP + this.serverUrl + SignatureImpl.INNER_SEP + this.adapterType.toString();
    }

    @CalledByNative
    public IceCandidate(String str, int i, String str2, String str3, PeerConnection.AdapterType adapterType) {
        this.sdpMid = str;
        this.sdpMLineIndex = i;
        this.sdp = str2;
        this.serverUrl = str3;
        this.adapterType = adapterType;
    }
}
