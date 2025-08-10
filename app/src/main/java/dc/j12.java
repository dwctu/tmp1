package dc;

import com.wear.main.closeRange.music.MusicControl;
import com.wear.util.MyApplication;

/* compiled from: MusicUtilsP.java */
/* loaded from: classes3.dex */
public class j12 {
    public MyApplication a;
    public so3 b;
    public ff3 c;

    /* compiled from: MusicUtilsP.java */
    public class a extends ff3 {
        public a() {
        }

        @Override // dc.ff3
        public void a() {
            super.a();
            MusicControl.h0().b0();
        }

        @Override // dc.ff3
        public void b(boolean z, Object obj) throws IllegalStateException {
            if (z) {
                int iIntValue = ((Integer) obj).intValue();
                if (iIntValue != -1) {
                    rq1.d.j(iIntValue);
                } else {
                    j12.this.b.G();
                    MusicControl.h0().r0();
                }
            }
        }
    }

    public void a() {
        b(null);
    }

    public void b(ff3 ff3Var) {
        if (ff3Var == null) {
            this.c = new a();
        } else {
            this.c = ff3Var;
        }
        if (k12.m.b() != null) {
            k12.m.b().setVolumeControlStream(3);
        }
        if (this instanceof m12) {
            MusicControl.h0().e.I();
        }
    }
}
