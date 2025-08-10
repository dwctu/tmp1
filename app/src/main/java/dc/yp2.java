package dc;

import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;

/* compiled from: ProxyVideoSink.java */
/* loaded from: classes3.dex */
public class yp2 implements VideoSink {
    public VideoSink a;
    public final Object b = new Object();

    public void a(VideoSink videoSink) {
        synchronized (this.b) {
            this.a = videoSink;
        }
    }

    @Override // org.webrtc.VideoSink
    public synchronized void onFrame(VideoFrame videoFrame) {
        synchronized (this.b) {
            VideoSink videoSink = this.a;
            if (videoSink == null) {
                return;
            }
            videoSink.onFrame(videoFrame);
        }
    }
}
