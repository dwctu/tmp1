package com.huawei.hms.feature.dynamic.a;

import dalvik.system.PathClassLoader;

/* loaded from: classes.dex */
public final class a extends PathClassLoader {
    private static final String a = a.class.getSimpleName();

    public a(String str, ClassLoader classLoader) {
        super(str, classLoader);
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
