package dc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ManifestParser.java */
@Deprecated
/* loaded from: classes.dex */
public final class bo {
    public final Context a;

    public bo(Context context) {
        this.a = context;
    }

    public static zn b(String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName(str);
            try {
                Object objNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (objNewInstance instanceof zn) {
                    return (zn) objNewInstance;
                }
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + objNewInstance);
            } catch (IllegalAccessException e) {
                c(cls, e);
                throw null;
            } catch (InstantiationException e2) {
                c(cls, e2);
                throw null;
            } catch (NoSuchMethodException e3) {
                c(cls, e3);
                throw null;
            } catch (InvocationTargetException e4) {
                c(cls, e4);
                throw null;
            }
        } catch (ClassNotFoundException e5) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e5);
        }
    }

    public static void c(Class<?> cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }

    public List<zn> a() throws PackageManager.NameNotFoundException {
        Log.isLoggable("ManifestParser", 3);
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                Log.isLoggable("ManifestParser", 3);
                return arrayList;
            }
            if (Log.isLoggable("ManifestParser", 2)) {
                String str = "Got app info metadata: " + applicationInfo.metaData;
            }
            for (String str2 : applicationInfo.metaData.keySet()) {
                if ("GlideModule".equals(applicationInfo.metaData.get(str2))) {
                    arrayList.add(b(str2));
                    if (Log.isLoggable("ManifestParser", 3)) {
                        String str3 = "Loaded Glide module: " + str2;
                    }
                }
            }
            Log.isLoggable("ManifestParser", 3);
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
        }
    }
}
