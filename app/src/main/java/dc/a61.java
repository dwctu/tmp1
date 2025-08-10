package dc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: PermissionDelegateImplV18.java */
@RequiresApi(api = 18)
/* loaded from: classes2.dex */
public class a61 extends z51 {
    @Override // dc.z51, dc.y51
    public boolean a(@NonNull Context context, @NonNull String str) {
        return m61.h(str, "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE") ? r51.b(context) : super.a(context, str);
    }

    @Override // dc.z51, dc.y51
    public boolean b(@NonNull Activity activity, @NonNull String str) {
        if (m61.h(str, "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE")) {
            return false;
        }
        return super.b(activity, str);
    }

    @Override // dc.z51, dc.y51
    public Intent c(@NonNull Context context, @NonNull String str) {
        return m61.h(str, "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE") ? r51.a(context) : super.c(context, str);
    }
}
