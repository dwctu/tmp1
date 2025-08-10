package dc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AndroidManifestInfo.java */
/* loaded from: classes2.dex */
public final class l51 {
    public String a;

    @Nullable
    public e b;
    public b d;

    @NonNull
    public final List<c> c = new ArrayList();

    @NonNull
    public final List<a> e = new ArrayList();

    @NonNull
    public final List<d> f = new ArrayList();

    /* compiled from: AndroidManifestInfo.java */
    public static final class a {
        public boolean a;
    }

    /* compiled from: AndroidManifestInfo.java */
    public static final class b {
        public boolean a;
    }

    /* compiled from: AndroidManifestInfo.java */
    public static final class c {
        public String a;
        public int b;
        public int c;

        public boolean a() {
            return (this.c & 65536) != 0;
        }
    }

    /* compiled from: AndroidManifestInfo.java */
    public static final class d {
        public String a;
        public String b;
    }

    /* compiled from: AndroidManifestInfo.java */
    public static final class e {
        public int a;
    }
}
