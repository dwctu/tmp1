package dc;

import android.view.Surface;

/* compiled from: WindowSurface.java */
/* loaded from: classes4.dex */
public class qi3 extends ni3 {
    public Surface c;
    public boolean d;

    public qi3(mi3 mi3Var, Surface surface, boolean z) {
        super(mi3Var);
        a(surface);
        this.c = surface;
        this.d = z;
    }

    public void f(mi3 mi3Var) {
        Surface surface = this.c;
        if (surface == null) {
            throw new RuntimeException("not yet implemented for SurfaceTexture");
        }
        this.a = mi3Var;
        a(surface);
    }

    public void g() {
        c();
        Surface surface = this.c;
        if (surface != null) {
            if (this.d) {
                surface.release();
            }
            this.c = null;
        }
    }
}
