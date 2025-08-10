package dc;

import android.app.Application;
import java.io.IOException;
import java.util.LinkedHashMap;
import xyz.doikki.videoplayer.player.VideoView;

/* compiled from: VideoViewManager.java */
/* loaded from: classes5.dex */
public class zj4 {
    public static zj4 c;
    public static yj4 d;
    public final LinkedHashMap<String, VideoView> a = new LinkedHashMap<>();
    public boolean b = c().a;

    public static yj4 c() {
        g(null);
        return d;
    }

    public static zj4 d() {
        if (c == null) {
            synchronized (zj4.class) {
                if (c == null) {
                    c = new zj4();
                }
            }
        }
        return c;
    }

    public static void g(yj4 yj4Var) {
        if (d == null) {
            synchronized (yj4.class) {
                if (d == null) {
                    if (yj4Var == null) {
                        yj4Var = yj4.a().j();
                    }
                    d = yj4Var;
                }
            }
        }
    }

    public void a(VideoView videoView, String str) throws IOException {
        if (!(videoView.getContext() instanceof Application)) {
            fk4.b("The Context of this VideoView is not an Application Context,you must remove it after release,or it will lead to memory leek.");
        }
        VideoView videoViewB = b(str);
        if (videoViewB != null) {
            videoViewB.u();
            f(str);
        }
        this.a.put(str, videoView);
    }

    public VideoView b(String str) {
        return this.a.get(str);
    }

    public boolean e() {
        return this.b;
    }

    public void f(String str) {
        this.a.remove(str);
    }

    public void h(boolean z) {
        this.b = z;
    }
}
