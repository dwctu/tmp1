package dc;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.messaging.Constants;
import com.wear.bean.SyncWsProtocol;
import com.wear.bean.VideoFlagConfig;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.xp2;
import java.util.ArrayList;
import java.util.List;
import org.webrtc.AudioSource;
import org.webrtc.AudioTrack;
import org.webrtc.Camera1Enumerator;
import org.webrtc.CameraEnumerator;
import org.webrtc.CameraVideoCapturer;
import org.webrtc.EglBase;
import org.webrtc.IceCandidate;
import org.webrtc.MediaConstraints;
import org.webrtc.MediaStream;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.SessionDescription;
import org.webrtc.SoftwareVideoDecoderFactory;
import org.webrtc.SoftwareVideoEncoderFactory;
import org.webrtc.SurfaceTextureHelper;
import org.webrtc.VideoCapturer;
import org.webrtc.VideoSink;
import org.webrtc.VideoSource;
import org.webrtc.VideoTrack;
import org.webrtc.audio.AudioDeviceModule;
import org.webrtc.audio.JavaAudioDeviceModule;

/* compiled from: WebRtcTool.java */
/* loaded from: classes3.dex */
public class aq2 implements xp2.a {
    public static volatile aq2 s;
    public d a;
    public EglBase.Context b;
    public PeerConnectionFactory c;
    public MediaStream d;
    public PeerConnection f;
    public VideoCapturer j;
    public VideoSource k;
    public VideoTrack l;
    public AudioSource m;
    public AudioTrack n;
    public boolean o;
    public SurfaceTextureHelper p;

    @Nullable
    public tp2 r;
    public final yp2 g = new yp2();
    public final yp2 h = new yp2();
    public Handler q = new Handler(Looper.getMainLooper());
    public Context i = WearUtils.x;
    public List<PeerConnection.IceServer> e = new ArrayList();

    /* compiled from: WebRtcTool.java */
    public class a extends zp2 {
        public a(String str) {
            super(str);
        }

        @Override // dc.zp2, org.webrtc.SdpObserver
        public void onCreateSuccess(SessionDescription sessionDescription) {
            super.onCreateSuccess(sessionDescription);
            aq2.this.f.setLocalDescription(new zp2("setLocalSdp:"), sessionDescription);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) sessionDescription.type.canonicalForm());
            jSONObject.put("sdp", (Object) sessionDescription.description);
            aq2.this.a.d(jSONObject);
        }
    }

    /* compiled from: WebRtcTool.java */
    public class b extends xp2 {
        public b(String str, xp2.a aVar) {
            super(str, aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void c(VideoTrack videoTrack) {
            videoTrack.addSink(aq2.this.g);
            aq2.this.a.o();
        }

        @Override // dc.xp2, org.webrtc.PeerConnection.Observer
        public void onAddStream(MediaStream mediaStream) {
            List<VideoTrack> list;
            super.onAddStream(mediaStream);
            if (!aq2.this.a.i() || (list = mediaStream.videoTracks) == null || list.size() == 0) {
                return;
            }
            xe3.a("webRtcMessage", "==mediaStream==" + mediaStream.videoTracks.size());
            final VideoTrack videoTrack = mediaStream.videoTracks.get(0);
            aq2.this.q.post(new Runnable() { // from class: dc.sp2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.c(videoTrack);
                }
            });
        }

        @Override // dc.xp2, org.webrtc.PeerConnection.Observer
        public void onIceCandidate(IceCandidate iceCandidate) {
            super.onIceCandidate(iceCandidate);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) "candidate");
            jSONObject.put(Constants.ScionAnalytics.PARAM_LABEL, (Object) Integer.valueOf(iceCandidate.sdpMLineIndex));
            jSONObject.put(TtmlNode.ATTR_ID, (Object) iceCandidate.sdpMid);
            jSONObject.put("candidate", (Object) iceCandidate.sdp);
            String str = "我的：=====" + jSONObject.toJSONString();
            aq2.this.a.d(jSONObject);
        }
    }

    /* compiled from: WebRtcTool.java */
    public class c implements Runnable {
        public final /* synthetic */ JSONObject a;

        /* compiled from: WebRtcTool.java */
        public class a extends zp2 {
            public a(String str) {
                super(str);
            }

            @Override // dc.zp2, org.webrtc.SdpObserver
            public void onCreateSuccess(SessionDescription sessionDescription) {
                super.onCreateSuccess(sessionDescription);
                aq2.this.f.setLocalDescription(new zp2("setLocalSdp:"), sessionDescription);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", (Object) sessionDescription.type.canonicalForm());
                jSONObject.put("sdp", (Object) sessionDescription.description);
                aq2.this.a.d(jSONObject);
            }
        }

        public c(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            aq2 aq2Var = aq2.this;
            aq2Var.f = aq2Var.k();
            aq2.this.f.setRemoteDescription(new zp2("setRemoteSdp:"), new SessionDescription(SessionDescription.Type.OFFER, this.a.getString("sdp")));
            aq2.this.f.createAnswer(new a("localAnswerSdp"), new MediaConstraints());
        }
    }

    /* compiled from: WebRtcTool.java */
    public interface d {
        boolean connectSuc();

        void d(JSONObject jSONObject);

        void e();

        void h(EglBase.Context context);

        boolean i();

        void o();
    }

    public static aq2 j() {
        if (s == null) {
            synchronized (aq2.class) {
                if (s == null) {
                    s = new aq2();
                }
            }
        }
        return s;
    }

    public void A(VideoSink videoSink) {
        this.h.a(videoSink);
    }

    public void B(VideoSink videoSink) {
        this.g.a(videoSink);
    }

    public void C() {
        VideoCapturer videoCapturer = this.j;
        if (videoCapturer instanceof CameraVideoCapturer) {
            ((CameraVideoCapturer) videoCapturer).switchCamera(null);
        }
    }

    public void d() {
        VideoTrack videoTrack;
        MediaStream mediaStream = this.d;
        if (mediaStream != null && (videoTrack = this.l) != null) {
            mediaStream.removeTrack(videoTrack);
        }
        VideoCapturer videoCapturer = this.j;
        if (videoCapturer != null) {
            videoCapturer.dispose();
            this.j = null;
        }
        VideoSource videoSource = this.k;
        if (videoSource != null) {
            videoSource.dispose();
            this.k = null;
        }
        VideoTrack videoTrack2 = this.l;
        if (videoTrack2 != null) {
            videoTrack2.dispose();
            this.l = null;
        }
    }

    public final VideoCapturer e() {
        VideoCapturer videoCapturerF = f(new Camera1Enumerator(false));
        this.j = videoCapturerF;
        return videoCapturerF;
    }

    public final VideoCapturer f(CameraEnumerator cameraEnumerator) {
        CameraVideoCapturer cameraVideoCapturerCreateCapturer;
        CameraVideoCapturer cameraVideoCapturerCreateCapturer2;
        String[] deviceNames = cameraEnumerator.getDeviceNames();
        for (String str : deviceNames) {
            if (cameraEnumerator.isFrontFacing(str) && (cameraVideoCapturerCreateCapturer2 = cameraEnumerator.createCapturer(str, null)) != null) {
                return cameraVideoCapturerCreateCapturer2;
            }
        }
        for (String str2 : deviceNames) {
            if (!cameraEnumerator.isFrontFacing(str2) && (cameraVideoCapturerCreateCapturer = cameraEnumerator.createCapturer(str2, null)) != null) {
                return cameraVideoCapturerCreateCapturer;
            }
        }
        return null;
    }

    public final AudioDeviceModule g() {
        return JavaAudioDeviceModule.builder(this.i).setUseHardwareAcousticEchoCanceler(true).setUseHardwareNoiseSuppressor(true).createAudioDeviceModule();
    }

    public final void h() {
        MediaStream mediaStreamCreateLocalMediaStream = this.c.createLocalMediaStream("mediaStream");
        this.d = mediaStreamCreateLocalMediaStream;
        VideoTrack videoTrack = this.l;
        if (videoTrack != null) {
            mediaStreamCreateLocalMediaStream.addTrack(videoTrack);
        }
        AudioTrack audioTrack = this.n;
        if (audioTrack != null) {
            this.d.addTrack(audioTrack);
        }
    }

    public void i() {
        PeerConnection peerConnection = this.f;
        if (peerConnection != null) {
            peerConnection.close();
        }
        this.f = null;
        z();
        y();
        FragmentActivity fragmentActivity = MyApplication.K;
        if (fragmentActivity != null) {
            fragmentActivity.setVolumeControlStream(3);
        }
        tp2 tp2Var = this.r;
        if (tp2Var != null) {
            tp2Var.l();
            this.r = null;
        }
        this.o = false;
    }

    public final synchronized PeerConnection k() {
        PeerConnection peerConnection = this.f;
        if (peerConnection != null) {
            return peerConnection;
        }
        PeerConnection.RTCConfiguration rTCConfiguration = new PeerConnection.RTCConfiguration(this.e);
        rTCConfiguration.bundlePolicy = PeerConnection.BundlePolicy.MAXBUNDLE;
        rTCConfiguration.rtcpMuxPolicy = PeerConnection.RtcpMuxPolicy.REQUIRE;
        rTCConfiguration.continualGatheringPolicy = PeerConnection.ContinualGatheringPolicy.GATHER_CONTINUALLY;
        rTCConfiguration.iceTransportsType = PeerConnection.IceTransportsType.ALL;
        rTCConfiguration.tcpCandidatePolicy = PeerConnection.TcpCandidatePolicy.DISABLED;
        PeerConnection peerConnectionCreatePeerConnection = this.c.createPeerConnection(rTCConfiguration, new b("PC:", this));
        this.f = peerConnectionCreatePeerConnection;
        peerConnectionCreatePeerConnection.addStream(this.d);
        return this.f;
    }

    public final void l() {
        MediaConstraints mediaConstraints = new MediaConstraints();
        mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("googEchoCancellation", "true"));
        mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("googAutoGainControl", "true"));
        mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("googHighpassFilter", "true"));
        mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("googNoiseSuppression", "true"));
        AudioSource audioSourceCreateAudioSource = this.c.createAudioSource(mediaConstraints);
        this.m = audioSourceCreateAudioSource;
        this.n = this.c.createAudioTrack("ARDAMSa0", audioSourceCreateAudioSource);
    }

    public void m() {
        List<VideoFlagConfig> listI = pg3.h().i();
        if (listI == null || listI.size() <= 0) {
            return;
        }
        for (VideoFlagConfig videoFlagConfig : listI) {
            this.e.add(PeerConnection.IceServer.builder(videoFlagConfig.getUrl()).setUsername(videoFlagConfig.getUserName()).setPassword(videoFlagConfig.getPwd()).createIceServer());
        }
    }

    public final void n() {
        this.b = lg4.b().getEglBaseContext();
        PeerConnectionFactory.initialize(PeerConnectionFactory.InitializationOptions.builder(this.i).setFieldTrials("WebRTC-IntelVP8/Enabled/").setEnableInternalTracer(true).createInitializationOptions());
        PeerConnectionFactory.Options options = new PeerConnectionFactory.Options();
        SoftwareVideoEncoderFactory softwareVideoEncoderFactory = new SoftwareVideoEncoderFactory();
        SoftwareVideoDecoderFactory softwareVideoDecoderFactory = new SoftwareVideoDecoderFactory();
        AudioDeviceModule audioDeviceModuleG = g();
        this.c = PeerConnectionFactory.builder().setOptions(options).setAudioDeviceModule(audioDeviceModuleG).setVideoEncoderFactory(softwareVideoEncoderFactory).setVideoDecoderFactory(softwareVideoDecoderFactory).createPeerConnectionFactory();
        audioDeviceModuleG.release();
        d dVar = this.a;
        if (dVar != null) {
            dVar.h(this.b);
        }
    }

    public final void o() {
        this.p = SurfaceTextureHelper.create("CaptureThread", this.b);
        VideoCapturer videoCapturerE = e();
        this.j = videoCapturerE;
        VideoSource videoSourceCreateVideoSource = this.c.createVideoSource(videoCapturerE.isScreencast());
        this.k = videoSourceCreateVideoSource;
        this.j.initialize(this.p, this.i, videoSourceCreateVideoSource.getCapturerObserver());
        this.j.startCapture(480, 640, 30);
        VideoTrack videoTrackCreateVideoTrack = this.c.createVideoTrack(SyncWsProtocol.CONTROL_BEGIN_TYPE_KEY, this.k);
        this.l = videoTrackCreateVideoTrack;
        videoTrackCreateVideoTrack.addSink(this.h);
    }

    @Override // dc.xp2.a
    public void onIceConnectionChange(PeerConnection.IceConnectionState iceConnectionState) {
        FragmentActivity fragmentActivity;
        String str = "IceConnectionState==" + iceConnectionState.toString();
        if (iceConnectionState == PeerConnection.IceConnectionState.CONNECTED || iceConnectionState == PeerConnection.IceConnectionState.COMPLETED) {
            if (!this.a.connectSuc() || (fragmentActivity = MyApplication.K) == null) {
                return;
            }
            fragmentActivity.setVolumeControlStream(0);
            return;
        }
        if (iceConnectionState == PeerConnection.IceConnectionState.DISCONNECTED || iceConnectionState == PeerConnection.IceConnectionState.CLOSED || iceConnectionState == PeerConnection.IceConnectionState.FAILED) {
            this.a.e();
        }
    }

    public void p(d dVar) {
        this.a = dVar;
        this.o = false;
    }

    public void q(String str) {
        try {
            String str2 = "==Received==" + str;
            JSONObject jSONObject = (JSONObject) JSON.parseObject(str, JSONObject.class);
            String string = jSONObject.getString("type");
            if ("offer".equals(string)) {
                t(jSONObject);
            } else if ("answer".equals(string)) {
                r(jSONObject);
            } else if ("candidate".equals(string)) {
                s(jSONObject);
            } else if ("loaded".equals(string)) {
                u();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void r(JSONObject jSONObject) {
        PeerConnection peerConnectionK = k();
        this.f = peerConnectionK;
        peerConnectionK.setRemoteDescription(new zp2("setRemoteSdp:"), new SessionDescription(SessionDescription.Type.ANSWER, jSONObject.getString("sdp")));
    }

    public final void s(JSONObject jSONObject) {
        this.f = k();
        this.f.addIceCandidate(new IceCandidate(jSONObject.getString(TtmlNode.ATTR_ID), jSONObject.getInteger(Constants.ScionAnalytics.PARAM_LABEL).intValue(), jSONObject.getString("candidate")));
    }

    public final void t(JSONObject jSONObject) {
        w();
        this.q.post(new c(jSONObject));
    }

    public final void u() {
        this.f = k();
        MediaConstraints mediaConstraints = new MediaConstraints();
        mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
        mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", this.a.i() ? "true" : "false"));
        this.f.createOffer(new a("createOfferSdp:"), mediaConstraints);
    }

    public void v() {
        try {
            VideoCapturer videoCapturer = this.j;
            if (videoCapturer != null) {
                videoCapturer.startCapture(480, 640, 30);
            }
        } catch (Exception unused) {
        }
    }

    public void w() {
        if (this.o) {
            return;
        }
        if (this.c == null) {
            n();
        }
        if (this.a.i()) {
            o();
        }
        l();
        h();
        tp2 tp2VarB = tp2.b(this.i);
        this.r = tp2VarB;
        tp2VarB.k(null);
        this.o = true;
    }

    public void x(boolean z) {
        if (this.o) {
            return;
        }
        if (this.c == null) {
            n();
        }
        if (z) {
            o();
        }
        l();
        h();
        WearUtils.x.w0(true);
        tp2 tp2VarB = tp2.b(this.i);
        this.r = tp2VarB;
        tp2VarB.k(null);
        this.o = true;
    }

    public final void y() {
        AudioSource audioSource = this.m;
        if (audioSource != null) {
            audioSource.dispose();
            this.m = null;
        }
        AudioTrack audioTrack = this.n;
        if (audioTrack != null) {
            audioTrack.dispose();
            this.n = null;
        }
    }

    public final void z() {
        VideoCapturer videoCapturer = this.j;
        if (videoCapturer != null) {
            try {
                videoCapturer.stopCapture();
                this.j.dispose();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.j = null;
        }
        VideoSource videoSource = this.k;
        if (videoSource != null) {
            videoSource.dispose();
            this.k = null;
        }
        VideoTrack videoTrack = this.l;
        if (videoTrack != null) {
            videoTrack.dispose();
            this.l = null;
        }
        SurfaceTextureHelper surfaceTextureHelper = this.p;
        if (surfaceTextureHelper != null) {
            surfaceTextureHelper.dispose();
            this.p = null;
        }
    }
}
