package dc;

import org.webrtc.SdpObserver;
import org.webrtc.SessionDescription;

/* compiled from: SdpAdapter.java */
/* loaded from: classes3.dex */
public class zp2 implements SdpObserver {
    public zp2(String str) {
        String str2 = "SdpAdapter " + str;
    }

    public final void a(String str) {
        String str2 = "==SdpAdapter==" + str;
    }

    @Override // org.webrtc.SdpObserver
    public void onCreateFailure(String str) {
        a("onCreateFailure " + str);
    }

    @Override // org.webrtc.SdpObserver
    public void onCreateSuccess(SessionDescription sessionDescription) {
        a("onCreateSuccess " + sessionDescription);
    }

    @Override // org.webrtc.SdpObserver
    public void onSetFailure(String str) {
        a("onSetFailure " + str);
    }

    @Override // org.webrtc.SdpObserver
    public void onSetSuccess() {
        a("onSetSuccess ");
    }
}
