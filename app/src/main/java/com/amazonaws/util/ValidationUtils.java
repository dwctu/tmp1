package com.amazonaws.util;

/* loaded from: classes.dex */
public class ValidationUtils {
    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }
}
