package com.huawei.hms.feature.dynamic.a;

import dalvik.system.DexClassLoader;

/* loaded from: classes.dex */
public final class b extends DexClassLoader {
    private static final String a = b.class.getSimpleName();

    public b(String str, String str2, ClassLoader classLoader) {
        super(str, str2, null, classLoader);
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        if (!str.startsWith("java.") && !str.startsWith("android.")) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException unused) {
                "Cannot find The class:".concat(String.valueOf(str));
            }
        }
        return super.loadClass(str, z);
    }
}
