package com.huawei.hms.hmsscankit;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.IBinder;
import com.huawei.hms.common.Preconditions;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import java.lang.reflect.InvocationTargetException;

/* compiled from: RemoteViewInitializer.java */
/* loaded from: classes3.dex */
public class j {
    private static volatile Context a;

    public static void a(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        context.getClassLoader().loadClass(ScanUtil.CONTEXT_PATH).getDeclaredMethod(ScanUtil.CONTEXT_METHOD, Context.class).invoke(null, context);
    }

    public static IRemoteCreator b(Context context) throws IllegalAccessException, InstantiationException, IllegalArgumentException {
        Preconditions.checkNotNull(context);
        try {
            Context contextD = d(context);
            if (contextD == null) {
                return null;
            }
            Object objNewInstance = contextD.getClassLoader().loadClass(ScanUtil.CREATOR_PATH).newInstance();
            if (objNewInstance instanceof IBinder) {
                return IRemoteCreator.Stub.asInterface((IBinder) objNewInstance);
            }
            return null;
        } catch (ClassNotFoundException unused) {
            com.huawei.hms.scankit.util.a.b("exception", "ClassNotFoundException");
            return null;
        } catch (IllegalAccessException unused2) {
            com.huawei.hms.scankit.util.a.b("exception", "IllegalAccessException");
            return null;
        } catch (InstantiationException unused3) {
            com.huawei.hms.scankit.util.a.b("exception", "InstantiationException");
            return null;
        } catch (NoSuchMethodException unused4) {
            com.huawei.hms.scankit.util.a.b("exception", "NoSuchMethodException");
            return null;
        } catch (InvocationTargetException unused5) {
            com.huawei.hms.scankit.util.a.b("exception", "InvocationTargetException");
            return null;
        }
    }

    public static IRemoteCreator c(Context context) throws IllegalAccessException, InstantiationException {
        Preconditions.checkNotNull(context);
        try {
            Object objNewInstance = context.getClassLoader().loadClass(ScanUtil.CREATOR_PATH).newInstance();
            if (objNewInstance instanceof IBinder) {
                return IRemoteCreator.Stub.asInterface((IBinder) objNewInstance);
            }
        } catch (ClassNotFoundException unused) {
            com.huawei.hms.scankit.util.a.b("exception", "ClassNotFoundException");
        } catch (IllegalAccessException unused2) {
            com.huawei.hms.scankit.util.a.b("exception", "IllegalAccessException");
        } catch (InstantiationException unused3) {
            com.huawei.hms.scankit.util.a.b("exception", "InvocationTargetException");
        }
        return null;
    }

    public static Context d(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        a(context);
        if (a != null) {
            return a;
        }
        try {
            int remoteVersion = DynamicModule.getRemoteVersion(context.getApplicationContext(), ScanUtil.MODULE_SCANKIT);
            int iE = e(context);
            if (iE > remoteVersion) {
                StringBuilder sb = new StringBuilder();
                sb.append("local Version is Higher");
                sb.append(iE);
                sb.toString();
                a(context);
                return context;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("use remote scankit");
            sb2.append(remoteVersion);
            sb2.toString();
            a = DynamicModule.load(context.getApplicationContext(), DynamicModule.PREFER_REMOTE, ScanUtil.MODULE_SCANKIT).getModuleContext();
            return a;
        } catch (DynamicModule.LoadingException unused) {
            a(context);
            return context;
        } catch (ClassNotFoundException unused2) {
            a(context);
            return context;
        } catch (IllegalAccessException unused3) {
            a(context);
            return context;
        } catch (NoSuchMethodException unused4) {
            a(context);
            return context;
        } catch (RuntimeException unused5) {
            a(context);
            return context;
        } catch (InvocationTargetException unused6) {
            a(context);
            return context;
        } catch (Exception unused7) {
            a(context);
            return context;
        } catch (Throwable unused8) {
            a(context);
            return context;
        }
    }

    private static int e(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getInt(ScanUtil.MODULE_SCANKIT_LOCAL, Integer.MAX_VALUE);
        } catch (PackageManager.NameNotFoundException unused) {
            com.huawei.hms.scankit.util.a.b("exception", "NameNotFoundException");
            return Integer.MAX_VALUE;
        }
    }
}
