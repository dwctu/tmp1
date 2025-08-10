package dc;

import android.app.Activity;
import android.content.Intent;
import com.wear.ui.longDistance.imagepicker.ui.ImagePickerActivity;
import java.util.ArrayList;

/* compiled from: ImagePicker.java */
/* loaded from: classes4.dex */
public class x83 {
    public static volatile x83 a;

    public static x83 b() {
        if (a == null) {
            synchronized (x83.class) {
                if (a == null) {
                    a = new x83();
                }
            }
        }
        return a;
    }

    public x83 a(boolean z) {
        f93.b().k(z);
        return a;
    }

    public x83 c(l93 l93Var) {
        f93.b().l(l93Var);
        return a;
    }

    public x83 d(ArrayList<String> arrayList) {
        f93.b().m(arrayList);
        return a;
    }

    public x83 e(int i) {
        f93.b().n(i);
        return a;
    }

    public x83 f(boolean z) {
        f93.b().t(z);
        return a;
    }

    public x83 g(String str) {
        f93.b().u(str);
        return a;
    }

    public x83 h(boolean z) {
        f93.b().p(z);
        return a;
    }

    public x83 i(boolean z) {
        f93.b().q(z);
        return a;
    }

    public x83 j(boolean z) {
        f93.b().r(z);
        return a;
    }

    public x83 k(boolean z) {
        f93.b().s(z);
        return a;
    }

    public void l(Activity activity, int i, int i2) {
        Intent intent = new Intent(activity, (Class<?>) ImagePickerActivity.class);
        intent.putExtra("chatType", i2);
        activity.startActivityForResult(intent, i);
    }
}
