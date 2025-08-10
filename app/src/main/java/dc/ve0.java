package dc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import java.util.Objects;

/* compiled from: Utils.java */
/* loaded from: classes.dex */
public final class ve0 {

    @SuppressLint({"StaticFieldLeak"})
    public static Application a;

    /* compiled from: Utils.java */
    public static class a {
        public void a(@NonNull Activity activity) {
        }

        public void b(@NonNull Activity activity) {
        }

        public void c(@NonNull Activity activity) {
        }

        public void d(@NonNull Activity activity) {
        }

        public void e(@NonNull Activity activity) {
        }

        public void f(@NonNull Activity activity) {
        }

        public void g(@NonNull Activity activity, Lifecycle.Event event) {
        }
    }

    /* compiled from: Utils.java */
    public interface b<T> {
        void accept(T t);
    }

    /* compiled from: Utils.java */
    public interface c {
        void a(Activity activity);

        void b(Activity activity);
    }

    public static Application a() {
        Application application = a;
        if (application != null) {
            return application;
        }
        b(xe0.o());
        Objects.requireNonNull(a, "reflect failed.");
        de0.v("Utils", xe0.p() + " reflect app success.");
        return a;
    }

    public static void b(Application application) {
        if (application == null) {
            de0.l("Utils", "app is null.");
            return;
        }
        Application application2 = a;
        if (application2 == null) {
            a = application;
            xe0.B(application);
            xe0.M();
        } else {
            if (application2.equals(application)) {
                return;
            }
            xe0.T(a);
            a = application;
            xe0.B(application);
        }
    }
}
