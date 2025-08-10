package dc;

import org.webrtc.CandidatePairChangeEvent;
import org.webrtc.DataChannel;
import org.webrtc.IceCandidate;
import org.webrtc.MediaStream;
import org.webrtc.PeerConnection;
import org.webrtc.RtpReceiver;
import org.webrtc.RtpTransceiver;

/* compiled from: PeerConnectionAdapter.java */
/* loaded from: classes3.dex */
public class xp2 implements PeerConnection.Observer {
    public a a;

    /* compiled from: PeerConnectionAdapter.java */
    public interface a {
        void onIceConnectionChange(PeerConnection.IceConnectionState iceConnectionState);
    }

    public xp2(String str, a aVar) {
        String str2 = "chao " + str;
        this.a = aVar;
    }

    public final void a(String str) {
        String str2 = "==PeerConnectionAdapter==" + str;
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onAddStream(MediaStream mediaStream) {
        a("onAddStream " + mediaStream);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onAddTrack(RtpReceiver rtpReceiver, MediaStream[] mediaStreamArr) {
        a("onAddTrack " + mediaStreamArr);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public /* synthetic */ void onConnectionChange(PeerConnection.PeerConnectionState peerConnectionState) {
        mg4.$default$onConnectionChange(this, peerConnectionState);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onDataChannel(DataChannel dataChannel) {
        a("onDataChannel " + dataChannel);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceCandidate(IceCandidate iceCandidate) {
        a("onIceCandidate " + iceCandidate);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr) {
        a("onIceCandidatesRemoved " + iceCandidateArr);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceConnectionChange(PeerConnection.IceConnectionState iceConnectionState) {
        a("onIceConnectionChange " + iceConnectionState);
        this.a.onIceConnectionChange(iceConnectionState);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceConnectionReceivingChange(boolean z) {
        a("onIceConnectionReceivingChange " + z);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceGatheringChange(PeerConnection.IceGatheringState iceGatheringState) {
        a("onIceGatheringChange " + iceGatheringState);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onRemoveStream(MediaStream mediaStream) {
        a("onRemoveStream " + mediaStream);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onRenegotiationNeeded() {
        a("onRenegotiationNeeded ");
    }

    @Override // org.webrtc.PeerConnection.Observer
    public /* synthetic */ void onSelectedCandidatePairChanged(CandidatePairChangeEvent candidatePairChangeEvent) {
        mg4.$default$onSelectedCandidatePairChanged(this, candidatePairChangeEvent);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onSignalingChange(PeerConnection.SignalingState signalingState) {
        a("onSignalingChange " + signalingState);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public /* synthetic */ void onStandardizedIceConnectionChange(PeerConnection.IceConnectionState iceConnectionState) {
        mg4.$default$onStandardizedIceConnectionChange(this, iceConnectionState);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public /* synthetic */ void onTrack(RtpTransceiver rtpTransceiver) {
        mg4.$default$onTrack(this, rtpTransceiver);
    }
}
