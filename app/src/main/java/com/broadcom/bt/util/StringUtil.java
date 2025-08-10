package com.broadcom.bt.util;

/* loaded from: classes.dex */
public class StringUtil {
    public static int parseInt(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

    public static String toNonNullString(String str) {
        return str == null ? "" : str;
    }
}
