package dc;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: StartActivityManager.java */
/* loaded from: classes2.dex */
public final class o61 {

    /* compiled from: StartActivityManager.java */
    public interface b {
        void startActivityForResult(@NonNull Intent intent, int i);
    }

    /* compiled from: StartActivityManager.java */
    public static class c implements b {
        public final Activity a;

        @Override // dc.o61.b
        public void startActivityForResult(@NonNull Intent intent, int i) {
            this.a.startActivityForResult(intent, i);
        }

        public c(@NonNull Activity activity) {
            this.a = activity;
        }
    }

    /* compiled from: StartActivityManager.java */
    public static class d implements b {
        public final Fragment a;

        @Override // dc.o61.b
        public void startActivityForResult(@NonNull Intent intent, int i) {
            this.a.startActivityForResult(intent, i);
        }

        public d(@NonNull Fragment fragment) {
            this.a = fragment;
        }
    }

    public static Intent a(@Nullable Intent intent, @Nullable Intent intent2) {
        if (intent == null && intent2 != null) {
            return intent2;
        }
        if (intent2 == null) {
            return intent;
        }
        b(intent).putExtra("sub_intent_key", intent2);
        return intent;
    }

    public static Intent b(@NonNull Intent intent) {
        Intent intentC = c(intent);
        return intentC != null ? b(intentC) : intent;
    }

    public static Intent c(@NonNull Intent intent) {
        return n51.f() ? (Intent) intent.getParcelableExtra("sub_intent_key", Intent.class) : (Intent) intent.getParcelableExtra("sub_intent_key");
    }

    public static boolean d(@NonNull Activity activity, @NonNull Intent intent, int i) {
        return f(new c(activity), intent, i);
    }

    public static boolean e(@NonNull Fragment fragment, @NonNull Intent intent, int i) {
        return f(new d(fragment), intent, i);
    }

    public static boolean f(@NonNull b bVar, @NonNull Intent intent, int i) {
        try {
            bVar.startActivityForResult(intent, i);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Intent intentC = c(intent);
            if (intentC == null) {
                return false;
            }
            return f(bVar, intentC, i);
        }
    }
}
