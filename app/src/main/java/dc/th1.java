package dc;

import android.graphics.Bitmap;
import androidx.core.os.EnvironmentCompat;
import com.google.android.gms.common.internal.ImagesContract;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: Src.kt */
/* loaded from: classes3.dex */
public final class th1 {

    @NotNull
    public String a;
    public int b;
    public int c;
    public int d;
    public int e;

    @NotNull
    public c f;

    @NotNull
    public b g;

    @NotNull
    public String h;

    @NotNull
    public String i;

    @NotNull
    public d j;
    public int k;

    @NotNull
    public a l;
    public int m;

    @Nullable
    public Bitmap n;

    /* compiled from: Src.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"dc/th1$a", "", "Ldc/th1$a;", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "FIT_XY", "CENTER_FULL", "animplayer_release"}, k = 1, mv = {1, 4, 0})
    public enum a {
        FIT_XY("fitXY"),
        CENTER_FULL("centerFull");


        @NotNull
        private final String type;

        a(String str) {
            this.type = str;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }

    /* compiled from: Src.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"dc/th1$b", "", "Ldc/th1$b;", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", GrsBaseInfo.CountryCodeSource.UNKNOWN, "NET", "LOCAL", "animplayer_release"}, k = 1, mv = {1, 4, 0})
    public enum b {
        UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN),
        NET("net"),
        LOCAL(ImagesContract.LOCAL);


        @NotNull
        private final String type;

        b(String str) {
            this.type = str;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }

    /* compiled from: Src.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"dc/th1$c", "", "Ldc/th1$c;", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", GrsBaseInfo.CountryCodeSource.UNKNOWN, "IMG", "TXT", "animplayer_release"}, k = 1, mv = {1, 4, 0})
    public enum c {
        UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN),
        IMG(XHTMLText.IMG),
        TXT("txt");


        @NotNull
        private final String type;

        c(String str) {
            this.type = str;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }

    /* compiled from: Src.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"dc/th1$d", "", "Ldc/th1$d;", "", "style", "Ljava/lang/String;", "getStyle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "DEFAULT", "BOLD", "animplayer_release"}, k = 1, mv = {1, 4, 0})
    public enum d {
        DEFAULT("default"),
        BOLD("b");


        @NotNull
        private final String style;

        d(String str) {
            this.style = str;
        }

        @NotNull
        public final String getStyle() {
            return this.style;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007e A[PHI: r7
  0x007e: PHI (r7v10 dc.th1$c) = (r7v5 dc.th1$c), (r7v6 dc.th1$c) binds: [B:10:0x007c, B:13:0x008a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a1 A[PHI: r5
  0x00a1: PHI (r5v17 dc.th1$b) = (r5v14 dc.th1$b), (r5v15 dc.th1$b) binds: [B:16:0x009f, B:19:0x00ad] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public th1(@org.jetbrains.annotations.NotNull org.json.JSONObject r10) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.th1.<init>(org.json.JSONObject):void");
    }

    public final void a(Bitmap bitmap) {
        int i;
        int i2;
        int width = bitmap != null ? bitmap.getWidth() : this.b;
        int height = bitmap != null ? bitmap.getHeight() : this.c;
        this.d = width;
        this.e = height;
        if (this.l != a.CENTER_FULL || (i = this.b) == 0 || (i2 = this.c) == 0) {
            return;
        }
        float f = width / height;
        if (f >= i / i2) {
            this.e = i2;
            this.d = (int) (i2 * f);
        } else {
            this.d = i;
            this.e = (int) (i / f);
        }
    }

    @Nullable
    public final Bitmap b() {
        return this.n;
    }

    public final int c() {
        return this.k;
    }

    public final int d() {
        return this.e;
    }

    public final int e() {
        return this.d;
    }

    @NotNull
    public final a f() {
        return this.l;
    }

    public final int g() {
        return this.c;
    }

    @NotNull
    public final b h() {
        return this.g;
    }

    @NotNull
    public final String i() {
        return this.a;
    }

    @NotNull
    public final String j() {
        return this.h;
    }

    public final int k() {
        return this.m;
    }

    @NotNull
    public final c l() {
        return this.f;
    }

    @NotNull
    public final d m() {
        return this.j;
    }

    @NotNull
    public final String n() {
        return this.i;
    }

    public final int o() {
        return this.b;
    }

    public final void p(@Nullable Bitmap bitmap) {
        this.n = bitmap;
        a(bitmap);
    }

    public final void q(int i) {
        this.m = i;
    }

    public final void r(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.i = str;
    }

    @NotNull
    public String toString() {
        return "Src(srcId='" + this.a + "', srcType=" + this.f + ", loadType=" + this.g + ", srcTag='" + this.h + "', bitmap=" + this.n + ", txt='" + this.i + "')";
    }
}
