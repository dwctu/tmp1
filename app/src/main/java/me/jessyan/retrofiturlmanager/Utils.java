package me.jessyan.retrofiturlmanager;

import dc.rc4;
import java.util.Objects;

/* loaded from: classes5.dex */
public class Utils {
    private Utils() {
        throw new IllegalStateException("do not instantiation me");
    }

    public static <T> T checkNotNull(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static rc4 checkUrl(String str) {
        rc4 rc4VarS = rc4.s(str);
        if (rc4VarS != null) {
            return rc4VarS;
        }
        throw new InvalidUrlException(str);
    }
}
