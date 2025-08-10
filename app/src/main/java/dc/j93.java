package dc;

import android.content.Context;
import com.wear.ui.longDistance.imagepicker.data.MediaFile;
import java.util.ArrayList;

/* compiled from: VideoLoadTask.java */
/* loaded from: classes4.dex */
public class j93 implements Runnable {
    public Context a;
    public e93 b;
    public a93 c;

    public j93(Context context, a93 a93Var) {
        this.a = context;
        this.c = a93Var;
        this.b = new e93(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList<MediaFile> arrayList = new ArrayList<>();
        e93 e93Var = this.b;
        if (e93Var != null) {
            arrayList = e93Var.g();
        }
        a93 a93Var = this.c;
        if (a93Var != null) {
            a93Var.a(d93.c(this.a, arrayList));
        }
    }
}
