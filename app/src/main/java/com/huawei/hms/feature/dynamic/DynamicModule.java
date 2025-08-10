package com.huawei.hms.feature.dynamic;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.IDynamicInstall;
import com.huawei.hms.feature.dynamic.IDynamicLoader;
import com.huawei.hms.feature.dynamic.a.d;
import com.huawei.hms.feature.dynamic.a.e;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public class DynamicModule {
    private static final int b = 256;
    private static final int c = -100;
    private static int h = 0;
    private static final int i = 1;
    private static final int j = 2;
    private Context g;
    public static final VersionPolicy PREFER_REMOTE = new e();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new com.huawei.hms.feature.dynamic.a.c();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new d();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new e();
    private static final String a = DynamicModule.class.getSimpleName();
    private static final ThreadLocal<HashMap<String, Boolean>> d = new ThreadLocal<>();
    private static final ThreadLocal<HashMap<String, String>> e = new ThreadLocal<>();
    private static final ThreadLocal<HashMap<String, IDynamicLoader>> f = new ThreadLocal<>();

    public static class DynamicLoaderClassLoader {
        private static HashMap<String, ClassLoader> a = new HashMap<>();

        public static ClassLoader getsClassLoader(String str) {
            return a.get(str);
        }

        public static void setsClassLoader(String str, ClassLoader classLoader) {
            a.put(str, classLoader);
        }
    }

    public static class LoadingException extends Exception {
        private Bundle a;

        private LoadingException(String str) {
            super(str);
        }

        public /* synthetic */ LoadingException(String str, byte b) {
            this(str);
        }

        private LoadingException(String str, Bundle bundle) {
            super(str);
            this.a = bundle;
        }

        public /* synthetic */ LoadingException(String str, Bundle bundle, byte b) {
            this(str, bundle);
        }

        public Bundle getBundle() {
            return this.a;
        }
    }

    public interface VersionPolicy {
        Bundle getModuleInfo(Context context, String str) throws LoadingException;
    }

    public static class a extends Exception {
        private a(String str) {
            super(str);
        }

        public /* synthetic */ a(String str, byte b) {
            this(str);
        }
    }

    private DynamicModule(Context context) {
        this.g = context;
    }

    public static Set<String> GetInstalledModuleInfo() {
        return c.a().a;
    }

    private static Context a(Context context, String str, Bundle bundle, IDynamicLoader iDynamicLoader) throws LoadingException {
        try {
            IObjectWrapper iObjectWrapperLoad = iDynamicLoader.load(ObjectWrapper.wrap(context), str, bundle.getInt(b.j), ObjectWrapper.wrap(bundle));
            if (ObjectWrapper.unwrap(iObjectWrapperLoad) == null) {
                Logger.w(a, "Get remote context is null.");
                return null;
            }
            if (ObjectWrapper.unwrap(iObjectWrapperLoad) instanceof Context) {
                Logger.i(a, "Get context success.");
                return (Context) ObjectWrapper.unwrap(iObjectWrapperLoad);
            }
            if (!ObjectWrapper.unwrap(iObjectWrapperLoad).getClass().getName().equals(LoadingException.class.getName())) {
                return null;
            }
            Bundle bundle2 = (Bundle) ObjectWrapper.unwrap(iObjectWrapperLoad).getClass().getDeclaredMethod("getBundle", new Class[0]).invoke(ObjectWrapper.unwrap(iObjectWrapperLoad), new Object[0]);
            Logger.w(a, "Successfully get the bundle in exception.");
            throw new LoadingException("Failed to load, please check the bundle in exception.", bundle2, (byte) 0);
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception e3) {
            Logger.w(a, "Failed to get remote module context.", e3);
            return null;
        }
    }

    private static Bundle a(Context context, String str) throws a, LoadingException {
        byte b2 = 0;
        try {
            Bundle bundleD = d(context, str);
            String string = bundleD.getString(b.p);
            if (TextUtils.isEmpty(string) || !new File(string).exists()) {
                Logger.w(a, "The loader_path:" + string + " is not available.");
                throw new LoadingException("The loader_path in queryBundle is empty or not exist.", b2);
            }
            Logger.i(a, "Query HMS module:" + str + " info success.");
            return bundleD;
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception unused) {
            throw new a("failed to get :" + str + " info.", b2);
        }
    }

    private static DynamicModule a(Context context, String str, Bundle bundle) throws LoadingException {
        Boolean bool;
        IDynamicLoader iDynamicLoader;
        byte b2 = 0;
        try {
            synchronized (DynamicModule.class) {
                HashMap<String, Boolean> map = d.get();
                Objects.requireNonNull(map);
                bool = map.get(str);
                HashMap<String, IDynamicLoader> map2 = f.get();
                Objects.requireNonNull(map2);
                iDynamicLoader = map2.get(str);
            }
            if (bool == null || iDynamicLoader == null) {
                throw new LoadingException("The loader for " + str + " was not prepared.", b2);
            }
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            Context contextA = a(context, str, bundle, iDynamicLoader);
            if (contextA != null) {
                return new DynamicModule(contextA);
            }
            throw new LoadingException("Failed to get remote module context: null", b2);
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception unused) {
            throw new LoadingException("Load Module Error.", b2);
        }
    }

    private static IDynamicInstall a(Context context) throws LoadingException {
        int i2;
        int localVersion;
        byte b2 = 0;
        String string = null;
        try {
            Bundle bundleA = a(context, b.d);
            string = bundleA.getString(b.p);
            i2 = bundleA.getInt(b.o);
        } catch (Exception e2) {
            Logger.w(a, "Cannot get remote HMS dynamicLoader.", e2);
            i2 = 0;
        }
        try {
            localVersion = getLocalVersion(context, b.d);
        } catch (Exception e3) {
            Logger.w(a, "Cannot find local dynamicLoader fallback.", e3);
            localVersion = 0;
        }
        String str = a;
        Logger.i(str, "DynamicLoader remoteHMSVersion:" + i2 + ", hmsLoaderPath:" + string + ", localLoaderVersion:" + localVersion);
        int i3 = i2 > localVersion ? i2 : localVersion;
        if (i3 > 10009300) {
            if (i2 > localVersion) {
                Logger.i(str, "Choose hms dynamicLoader: ".concat(String.valueOf(string)));
                h = 1;
                return a(string);
            }
            Logger.i(str, "Choose local dynamicLoader fallback: ");
            h = 2;
            return b(context);
        }
        Logger.w(str, "The current version:" + i3 + " is too low.");
        throw new LoadingException("The loader version:" + i3 + " is too low to support HFF.", b2);
    }

    private static IDynamicInstall a(String str) throws LoadingException {
        byte b2 = 0;
        if (str != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return IDynamicInstall.Stub.asInterface((IBinder) new com.huawei.hms.feature.dynamic.a.a(str, ClassLoader.getSystemClassLoader()).loadClass(b.f).getConstructor(new Class[0]).newInstance(new Object[0]));
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
                throw new LoadingException("getHMSDynamicInstaller: failed to instantiate dynamic loader:" + e2.getMessage(), b2);
            }
        }
        throw new LoadingException("Failed to get dynamicLoader path.", b2);
    }

    private static void a(String str, ClassLoader classLoader) throws LoadingException {
        byte b2 = 0;
        try {
            f.set(new HashMap<String, IDynamicLoader>(str, (IBinder) classLoader.loadClass(b.e).getConstructor(new Class[0]).newInstance(new Object[0])) { // from class: com.huawei.hms.feature.dynamic.DynamicModule.3
                public final /* synthetic */ String a;
                public final /* synthetic */ IBinder b;

                {
                    this.a = str;
                    this.b = iBinder;
                    put(str, IDynamicLoader.Stub.asInterface(iBinder));
                }
            });
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new LoadingException("Failed to get loader interface:" + e2.getMessage(), b2);
        }
    }

    private static Bundle b(Context context, String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, LoadingException, InvocationTargetException {
        Method declaredMethod;
        ClassLoader classLoader;
        boolean z = true;
        try {
            try {
                Class<?> clsLoadClass = (context.getApplicationContext() == null ? context : context.getApplicationContext()).getClassLoader().loadClass(DynamicLoaderClassLoader.class.getName());
                Method declaredMethod2 = clsLoadClass.getDeclaredMethod("getsClassLoader", String.class);
                declaredMethod = clsLoadClass.getDeclaredMethod("setsClassLoader", String.class, ClassLoader.class);
                classLoader = (ClassLoader) declaredMethod2.invoke(null, str);
            } catch (Exception e2) {
                Logger.w(a, "failed to load.", e2);
            }
            if (classLoader == null) {
                try {
                    String str2 = a;
                    Logger.i(str2, "No available cached loader, query remote.");
                    Bundle bundleC = c(context, str);
                    synchronized (DynamicModule.class) {
                        HashMap<String, String> map = e.get();
                        Objects.requireNonNull(map);
                        String str3 = map.get(str);
                        if (TextUtils.isEmpty(str3)) {
                            return bundleC;
                        }
                        if (Build.VERSION.SDK_INT < 21) {
                            Logger.i(str2, "The android version is below android 5.");
                            com.huawei.hms.feature.dynamic.a.b bVar = new com.huawei.hms.feature.dynamic.a.b(str3, context.getFilesDir().getAbsolutePath(), ClassLoader.getSystemClassLoader());
                            a(str, bVar);
                            declaredMethod.invoke(null, str, bVar);
                        } else {
                            com.huawei.hms.feature.dynamic.a.a aVar = new com.huawei.hms.feature.dynamic.a.a(str3, ClassLoader.getSystemClassLoader());
                            a(str, aVar);
                            declaredMethod.invoke(null, str, aVar);
                        }
                        d.set(new HashMap<String, Boolean>(str) { // from class: com.huawei.hms.feature.dynamic.DynamicModule.1
                            public final /* synthetic */ String a;

                            {
                                this.a = str;
                                put(str, Boolean.TRUE);
                            }
                        });
                        return bundleC;
                    }
                } catch (a unused) {
                }
            } else if (classLoader != ClassLoader.getSystemClassLoader()) {
                Logger.i(a, "Cached loader is available, ready to use it.");
                try {
                    a(str, classLoader);
                } catch (LoadingException e3) {
                    Logger.w(a, "Get loader interface failed.", e3);
                }
                HashMap<String, Boolean> map2 = new HashMap<>();
                map2.put(str, Boolean.valueOf(z));
                d.set(map2);
                return new Bundle();
            }
            z = false;
            HashMap<String, Boolean> map22 = new HashMap<>();
            map22.put(str, Boolean.valueOf(z));
            d.set(map22);
            return new Bundle();
        } catch (LoadingException e4) {
            throw e4;
        }
    }

    private static IDynamicInstall b(Context context) throws LoadingException {
        try {
            return (IDynamicInstall) context.getClassLoader().loadClass(b.f).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            throw new LoadingException("getLocalLoaderFallback: failed to instantiate dynamic loader: " + e2.getMessage(), (byte) 0);
        }
    }

    private static Bundle c(Context context, String str) throws a, LoadingException {
        try {
            Bundle bundleD = d(context, str);
            String string = bundleD.getString(b.p);
            if (!TextUtils.isEmpty(string) && new File(string).exists()) {
                e.set(new HashMap<String, String>(str, string) { // from class: com.huawei.hms.feature.dynamic.DynamicModule.2
                    public final /* synthetic */ String a;
                    public final /* synthetic */ String b;

                    {
                        this.a = str;
                        this.b = string;
                        put(str, string);
                    }
                });
                Logger.i(a, "Query remote version by module name:" + str + " success.");
                return bundleD;
            }
            Logger.w(a, "The loader_path:" + string + " in query bundle is not available,change the module version to:-100");
            bundleD.putInt(b.j, -100);
            return bundleD;
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception unused) {
            throw new a("failed to Query remote version.", (byte) 0);
        }
    }

    private static Bundle d(Context context, String str) throws a, LoadingException {
        byte b2 = 0;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null) {
                throw new a("Query remote version failed: null contentResolver.", b2);
            }
            Bundle bundleCall = contentResolver.call(Uri.parse(b.a), str, (String) null, (Bundle) null);
            if (bundleCall == null) {
                Logger.w(a, "Failed to get bundle info:null.");
                throw new a("Query remote version failed: null bundle info.", b2);
            }
            int i2 = bundleCall.getInt(b.g);
            String string = bundleCall.getString(b.p);
            String str2 = a;
            Logger.i(str2, "bundle info: errorCode:" + i2 + ", moduleVersion:" + bundleCall.getInt(b.j) + ", modulePath:" + bundleCall.getString(b.l) + ", loader_version:" + bundleCall.getInt(b.o) + ", loaderPath:" + string + ", armeabiType:" + bundleCall.getInt(b.q));
            if (i2 == 0) {
                return bundleCall;
            }
            Logger.w(str2, "Failed to get " + str + " bundle info, errcode:" + i2);
            throw new LoadingException("Query " + str + " unavailable, errorCode:" + i2, bundleCall, b2);
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception unused) {
            throw new a("failed to get :" + str + " info.", b2);
        }
    }

    public static Bundle getLocalModuleInfo(Context context, String str) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException {
        int localVersion = getLocalVersion(context, str);
        Bundle bundle = new Bundle();
        bundle.putString(b.i, str);
        bundle.putInt(b.k, localVersion);
        return bundle;
    }

    public static int getLocalVersion(Context context, String str) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException {
        if (context == null || str.length() == 0 || str.length() > 256) {
            Logger.e(a, "Invalid context or moduleName.");
            return 0;
        }
        try {
            String str2 = "com.huawei.hms.feature.dynamic.descriptors." + str + ".ModuleDescriptor";
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            return context.getClassLoader().loadClass(str2).getDeclaredField("MODULE_VERSION").getInt(null);
        } catch (ClassNotFoundException unused) {
            Logger.w(a, "Cannot find the class of module descriptor for ".concat(String.valueOf(str)));
            return 0;
        } catch (Exception e2) {
            Logger.w(a, "Get local module info failed.", e2);
            return 0;
        }
    }

    public static Bundle getRemoteModuleInfo(Context context, String str) throws LoadingException {
        try {
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception e3) {
            Logger.w(a, "Get remote module info for " + str + " failed.", e3);
        }
        synchronized (DynamicModule.class) {
            ThreadLocal<HashMap<String, Boolean>> threadLocal = d;
            if (threadLocal.get() == null || threadLocal.get().get(str) == null || !threadLocal.get().get(str).booleanValue()) {
                Bundle bundleB = b(context, str);
                if (bundleB.getInt(b.j) > 0) {
                    return bundleB;
                }
            }
            if (threadLocal.get().get(str).booleanValue()) {
                try {
                    return c(context, str);
                } catch (a e4) {
                    Logger.w(a, "Query remote module info in HMS failed.", e4);
                }
            }
            return new Bundle();
        }
    }

    public static int getRemoteVersion(Context context, String str) throws LoadingException {
        byte b2 = 0;
        try {
            Bundle bundleC = c(context, str);
            if (bundleC != null && !bundleC.isEmpty()) {
                return bundleC.getInt(b.j);
            }
            Logger.w(a, "Query remote module:" + str + " info failed.");
            throw new LoadingException("Query remote module info failed: null or empty.", b2);
        } catch (a e2) {
            Logger.w(a, "Query remote module:" + str + " exception:" + e2);
            return 0;
        }
    }

    public static void install(Context context) throws LoadingException {
        if (context == null) {
            Logger.e(a, "The input context is null.");
            return;
        }
        byte b2 = 0;
        try {
            IDynamicInstall iDynamicInstallA = a(context);
            if (iDynamicInstallA == null) {
                throw new LoadingException("Get dynamicInstaller failed.", b2);
            }
            Bundle bundleInstall = iDynamicInstallA.install(ObjectWrapper.wrap(context), new Bundle());
            if (bundleInstall == null) {
                throw new LoadingException("Get install info failed: moduleBundle is null.", b2);
            }
            c.a().a(bundleInstall);
            Logger.i(a, "Install module success.");
        } catch (RemoteException | LoadingException | NullPointerException e2) {
            if (h == 2 || getLocalVersion(context, b.d) <= 0) {
                Logger.w(a, "Install module failed.", e2);
                return;
            }
            String str = a;
            Logger.i(str, "Ready to use local loader-fallback to retry:");
            try {
                Bundle bundleInstall2 = b(context).install(ObjectWrapper.wrap(context), new Bundle());
                if (bundleInstall2 == null) {
                    throw new LoadingException("Retry: get install info failed: moduleBundle is null.", b2);
                }
                c.a().a(bundleInstall2);
                Logger.i(str, "Retry install module with local loader-fallback success.");
            } catch (RemoteException | LoadingException | NullPointerException e3) {
                Logger.w(a, "Retry failed with local loader-fallback.", e3);
            }
        }
    }

    public static DynamicModule load(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        byte b2 = 0;
        if (context == null || versionPolicy == null || str == null || str.length() == 0 || str.length() > 256) {
            throw new LoadingException("Null param, please check it.", b2);
        }
        try {
            try {
                Bundle moduleInfo = versionPolicy.getModuleInfo(context, str);
                if (moduleInfo.getInt(b.j) <= 0) {
                    if (moduleInfo.getInt(b.k) <= 0) {
                        throw new LoadingException("Query remote version and local version failed.", b2);
                    }
                    Logger.i(a, "Remote version is invalid, use local context.");
                    return new DynamicModule(context.getApplicationContext());
                }
                try {
                    return a(context, str, moduleInfo);
                } catch (LoadingException e2) {
                    Logger.w(a, "Failed to load remote module.", e2);
                    if (getLocalVersion(context, str) <= 0) {
                        return null;
                    }
                    Logger.d(a, "Local module version is valid, use local fallback.");
                    return new DynamicModule(context.getApplicationContext());
                }
            } catch (LoadingException e3) {
                throw e3;
            }
        } catch (Exception e4) {
            Logger.e(a, "Other exception:".concat(String.valueOf(e4)));
            throw new LoadingException("Load failed.", b2);
        }
    }

    public final Context getModuleContext() {
        return this.g;
    }
}
