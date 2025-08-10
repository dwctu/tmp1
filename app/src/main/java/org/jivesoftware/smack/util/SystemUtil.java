package org.jivesoftware.smack.util;

import android.os.Build;

/* loaded from: classes5.dex */
public class SystemUtil {
    public static final String PROPERTY_JAVA_VENDOR = "java.vendor";

    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public static boolean onAndroid() {
        return System.getProperty(PROPERTY_JAVA_VENDOR).contains("Android");
    }
}
