package dc;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: PermissionDelegateImplV28.java */
@RequiresApi(api = 28)
/* loaded from: classes2.dex */
public class f61 extends e61 {
    @Override // dc.e61, dc.d61, dc.c61, dc.b61, dc.a61, dc.z51, dc.y51
    public boolean a(@NonNull Context context, @NonNull String str) {
        return m61.h(str, "android.permission.ACCEPT_HANDOVER") ? m61.f(context, str) : super.a(context, str);
    }

    @Override // dc.e61, dc.d61, dc.c61, dc.b61, dc.a61, dc.z51, dc.y51
    public boolean b(@NonNull Activity activity, @NonNull String str) {
        return m61.h(str, "android.permission.ACCEPT_HANDOVER") ? (m61.f(activity, str) || m61.v(activity, str)) ? false : true : super.b(activity, str);
    }
}
