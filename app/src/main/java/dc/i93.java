package dc;

import android.content.Context;
import com.wear.ui.longDistance.imagepicker.data.MediaFile;
import java.util.ArrayList;

/* compiled from: MediaLoadTask.java */
/* loaded from: classes4.dex */
public class i93 implements Runnable {
    public Context a;
    public c93 b;
    public e93 c;
    public a93 d;

    public i93(Context context, a93 a93Var) {
        this.a = context;
        this.d = a93Var;
        this.b = new c93(context);
        this.c = new e93(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList<MediaFile> arrayList = new ArrayList<>();
        ArrayList<MediaFile> arrayList2 = new ArrayList<>();
        c93 c93Var = this.b;
        if (c93Var != null) {
            arrayList = c93Var.g();
        }
        e93 e93Var = this.c;
        if (e93Var != null) {
            arrayList2 = e93Var.g();
        }
        a93 a93Var = this.d;
        if (a93Var != null) {
            a93Var.a(d93.b(this.a, arrayList, arrayList2));
        }
    }
}
