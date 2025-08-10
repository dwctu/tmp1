package dc;

import android.content.res.AssetManager;
import android.text.TextUtils;
import com.wear.util.WearUtils;
import java.io.File;

/* compiled from: RingUtils.java */
/* loaded from: classes4.dex */
public class bg3 {
    public so3 a;
    public boolean b = false;

    /* compiled from: RingUtils.java */
    public class a extends ff3 {
        public final /* synthetic */ c a;

        public a(c cVar) {
            this.a = cVar;
        }

        @Override // dc.ff3
        public void b(boolean z, Object obj) {
            bg3 bg3Var = bg3.this;
            if (bg3Var.b && z && obj == null) {
                bg3Var.e(this.a);
            }
        }
    }

    /* compiled from: RingUtils.java */
    public class b extends ff3 {
        public final /* synthetic */ c a;

        public b(c cVar) {
            this.a = cVar;
        }

        @Override // dc.ff3
        public void b(boolean z, Object obj) {
            bg3 bg3Var = bg3.this;
            if (bg3Var.b && z && obj == null) {
                bg3Var.f(this.a);
            }
        }
    }

    /* compiled from: RingUtils.java */
    public interface c {
        String getFilePath();
    }

    public bg3() {
        this.a = null;
        this.a = new so3();
    }

    public static void a() {
        try {
            AssetManager assets = WearUtils.x.getAssets();
            File file = new File(c());
            if (file.exists()) {
                return;
            }
            WearUtils.r(assets.open("notic_ding.mp3"), file);
        } catch (Exception unused) {
        }
    }

    public static void b() {
        try {
            AssetManager assets = WearUtils.x.getAssets();
            File file = new File(d());
            if (!file.exists()) {
                WearUtils.r(assets.open("ringy_ding_ding.mp3"), file);
            }
            a();
        } catch (Exception unused) {
        }
    }

    public static String c() {
        return WearUtils.T("temp") + File.separator + "notic_ding.mp3";
    }

    public static String d() {
        return WearUtils.T("temp") + File.separator + "ringy_ding_ding.mp3";
    }

    public void e(c cVar) {
        so3 so3Var;
        String filePath = cVar != null ? cVar.getFilePath() : "";
        if (TextUtils.isEmpty(filePath)) {
            filePath = d();
        }
        if (TextUtils.isEmpty(filePath)) {
            return;
        }
        File file = new File(filePath);
        if (!file.exists() || (so3Var = this.a) == null) {
            return;
        }
        so3Var.D(file.getAbsolutePath(), new a(cVar));
    }

    public void f(c cVar) {
        so3 so3Var;
        File file = new File(cVar == null ? c() : cVar.getFilePath());
        if (!file.exists() || (so3Var = this.a) == null) {
            return;
        }
        so3Var.D(file.getAbsolutePath(), new b(cVar));
    }

    public void g(boolean z) {
        this.b = z;
    }

    public void h() {
        this.b = false;
        so3 so3Var = this.a;
        if (so3Var != null) {
            so3Var.F();
        }
        this.a = null;
    }
}
