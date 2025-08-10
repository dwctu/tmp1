package dc;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: ApplicationVersionSignature.java */
/* loaded from: classes.dex */
public final class kp {
    public static final ConcurrentMap<String, xg> a = new ConcurrentHashMap();

    @Nullable
    public static PackageInfo a(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            String str = "Cannot resolve info for" + context.getPackageName();
            return null;
        }
    }

    @NonNull
    public static String b(@Nullable PackageInfo packageInfo) {
        return packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString();
    }

    @NonNull
    public static xg c(@NonNull Context context) {
        String packageName = context.getPackageName();
        ConcurrentMap<String, xg> concurrentMap = a;
        xg xgVar = concurrentMap.get(packageName);
        if (xgVar != null) {
            return xgVar;
        }
        xg xgVarD = d(context);
        xg xgVarPutIfAbsent = concurrentMap.putIfAbsent(packageName, xgVarD);
        return xgVarPutIfAbsent == null ? xgVarD : xgVarPutIfAbsent;
    }

    @NonNull
    public static xg d(@NonNull Context context) {
        return new mp(b(a(context)));
    }
}
