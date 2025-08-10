package dc;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Objects;

/* compiled from: ImageSource.java */
/* loaded from: classes.dex */
public final class ig0 {
    public final Uri a;
    public final Bitmap b;
    public final Integer c;
    public boolean d;
    public int e;
    public int f;
    public Rect g;
    public boolean h;

    public ig0(Uri uri) {
        String string = uri.toString();
        if (string.startsWith("file:///") && !new File(string.substring(7)).exists()) {
            try {
                uri = Uri.parse(URLDecoder.decode(string, "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
            }
        }
        this.b = null;
        this.a = uri;
        this.c = null;
        this.d = true;
    }

    public static ig0 a(String str) {
        Objects.requireNonNull(str, "Asset name must not be null");
        return m("file:///android_asset/" + str);
    }

    public static ig0 j(int i) {
        return new ig0(i);
    }

    public static ig0 m(String str) {
        Objects.requireNonNull(str, "Uri must not be null");
        if (!str.contains("://")) {
            if (str.startsWith("/")) {
                str = str.substring(1);
            }
            str = "file:///" + str;
        }
        return new ig0(Uri.parse(str));
    }

    public final Bitmap b() {
        return this.b;
    }

    public final Integer c() {
        return this.c;
    }

    public final int d() {
        return this.f;
    }

    public final Rect e() {
        return this.g;
    }

    public final int f() {
        return this.e;
    }

    public final boolean g() {
        return this.d;
    }

    public final Uri h() {
        return this.a;
    }

    public final boolean i() {
        return this.h;
    }

    public ig0 k(boolean z) {
        this.d = z;
        return this;
    }

    public ig0 l() {
        k(true);
        return this;
    }

    public ig0(int i) {
        this.b = null;
        this.a = null;
        this.c = Integer.valueOf(i);
        this.d = true;
    }
}
