package dc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: PermissionDelegateImplV30.java */
@RequiresApi(api = 30)
/* loaded from: classes2.dex */
public class h61 extends g61 {
    public static Intent t(@NonNull Context context) {
        Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
        intent.setData(m61.l(context));
        if (!m61.a(context, intent)) {
            intent = new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION");
        }
        return !m61.a(context, intent) ? l61.b(context) : intent;
    }

    public static boolean u() {
        return Environment.isExternalStorageManager();
    }

    @Override // dc.g61, dc.f61, dc.e61, dc.d61, dc.c61, dc.b61, dc.a61, dc.z51, dc.y51
    public boolean a(@NonNull Context context, @NonNull String str) {
        return m61.h(str, "android.permission.MANAGE_EXTERNAL_STORAGE") ? u() : super.a(context, str);
    }

    @Override // dc.g61, dc.f61, dc.e61, dc.d61, dc.c61, dc.b61, dc.a61, dc.z51, dc.y51
    public boolean b(@NonNull Activity activity, @NonNull String str) {
        if (m61.h(str, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
            return false;
        }
        return super.b(activity, str);
    }

    @Override // dc.e61, dc.d61, dc.c61, dc.b61, dc.a61, dc.z51, dc.y51
    public Intent c(@NonNull Context context, @NonNull String str) {
        return m61.h(str, "android.permission.MANAGE_EXTERNAL_STORAGE") ? t(context) : super.c(context, str);
    }
}
