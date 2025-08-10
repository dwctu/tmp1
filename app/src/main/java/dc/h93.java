package dc;

import android.content.Context;
import com.wear.ui.longDistance.imagepicker.data.MediaFile;
import java.util.ArrayList;

/* compiled from: ImageLoadTask.java */
/* loaded from: classes4.dex */
public class h93 implements Runnable {
    public Context a;
    public c93 b;
    public a93 c;

    public h93(Context context, a93 a93Var) {
        this.a = context;
        this.c = a93Var;
        this.b = new c93(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList<MediaFile> arrayList = new ArrayList<>();
        c93 c93Var = this.b;
        if (c93Var != null) {
            arrayList = c93Var.g();
        }
        a93 a93Var = this.c;
        if (a93Var != null) {
            a93Var.a(d93.a(this.a, arrayList));
        }
    }
}
