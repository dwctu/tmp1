package dc;

import android.text.TextUtils;
import android.util.Base64;
import com.wear.widget.control.FingImageLayout;
import dc.uz;
import java.nio.charset.Charset;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DXAESUtil.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0003J\u0014\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J(\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010\u001f\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010 \u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010!\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010\"\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010#\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\fH\u0007J(\u0010$\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0007R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006%"}, d2 = {"Lcom/component/dxhyttoutils/lib/utils/dxaes/DXAESUtil;", "Lcom/component/dxhyttoutils/lib/utils/dxaes/DXAESBaseUtils;", "()V", "bouncyCastleProvider", "Lorg/bouncycastle/jce/provider/BouncyCastleProvider;", "getBouncyCastleProvider", "()Lorg/bouncycastle/jce/provider/BouncyCastleProvider;", "bouncyCastleProvider$delegate", "Lkotlin/Lazy;", "decryptBase64", "", "data", "", "decryptChat", "decryptData", "decryptDatabaseLocal", "decryptEmail", "decryptFromService", "decryptInstall", "decryptLocal", "decryptToken", "decryptXYService", "x", FingImageLayout.ObjectAnimatorY, "encryptCamIOPublic", "encryptCamIOTest", "encryptChat", "encryptData", "encryptDatabaseLocal", "encryptEmail", "encryptException", "encryptFromService", "encryptLocal", "encryptNewLog", "encryptToService", "encryptToken", "encryptXYService", "hytto-apps.android.components.base:dxhyttoutils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class vz extends uz {

    @NotNull
    public static final vz C = new vz();

    @NotNull
    public static final Lazy D = LazyKt__LazyJVMKt.lazy(a.a);

    /* compiled from: DXAESUtil.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lorg/bouncycastle/jce/provider/BouncyCastleProvider;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function0<BouncyCastleProvider> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BouncyCastleProvider invoke() {
            return new BouncyCastleProvider();
        }
    }

    @JvmStatic
    public static final byte[] A(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            if (!StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "/", false, 2, (Object) null) && !StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "=", false, 2, (Object) null) && !StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "+", false, 2, (Object) null)) {
                return Base64.decode(str, 8);
            }
            return Base64.decode(str, 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final String B(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            uz.g gVar = uz.x;
            byte[] bArrDecode = Base64.decode(str, 0);
            vz vzVar = C;
            return qd0.c(gVar.c(bArrDecode, gVar.g(vzVar.g()), gVar.f(vzVar.h())));
        } catch (Exception e) {
            de0.l(uz.x.j(), e.getMessage());
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final String C(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            uz.g gVar = uz.x;
            vz vzVar = C;
            return qd0.c(gVar.c(A(str), gVar.g(vzVar.i()), gVar.f(vzVar.j())));
        } catch (Exception unused) {
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final String D(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        try {
            uz.g gVar = uz.x;
            byte[] bArrDecode = Base64.decode(str, 0);
            vz vzVar = C;
            return qd0.c(gVar.c(bArrDecode, gVar.g(vzVar.p()), gVar.f(vzVar.q())));
        } catch (Exception unused) {
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final String E(@Nullable String str) {
        byte[] bArrC;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "/", false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "=", false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "+", false, 2, (Object) null)) {
                uz.g gVar = uz.x;
                byte[] bArrDecode = Base64.decode(str, 0);
                vz vzVar = C;
                bArrC = gVar.c(bArrDecode, gVar.g(vzVar.m()), gVar.f(vzVar.n()));
            } else {
                uz.g gVar2 = uz.x;
                byte[] bArrDecode2 = Base64.decode(str, 8);
                vz vzVar2 = C;
                bArrC = gVar2.c(bArrDecode2, gVar2.g(vzVar2.m()), gVar2.f(vzVar2.n()));
            }
            return qd0.c(bArrC);
        } catch (Exception e) {
            e.printStackTrace();
            de0.l(uz.x.j(), e.getMessage());
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final String F(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            uz.g gVar = uz.x;
            byte[] bArrDecode = Base64.decode(str, 0);
            vz vzVar = C;
            return qd0.c(gVar.c(bArrDecode, gVar.g(vzVar.r()), gVar.f(vzVar.s())));
        } catch (Exception unused) {
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final String G(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            uz.g gVar = uz.x;
            byte[] bArrDecode = Base64.decode(str, 0);
            vz vzVar = C;
            return qd0.c(gVar.c(bArrDecode, gVar.g(vzVar.v()), gVar.f(vzVar.w())));
        } catch (Exception e) {
            e.printStackTrace();
            de0.l(uz.x.j(), e.getMessage());
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final String H(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        gz gzVar = gz.a;
        if (TextUtils.isEmpty(gzVar.c().getX()) || TextUtils.isEmpty(gzVar.c().getY())) {
            return null;
        }
        return I(str, gzVar.c().getX(), gzVar.c().getY());
    }

    @JvmStatic
    @Nullable
    public static final String I(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        byte[] bArrC;
        if (!(str == null || str.length() == 0)) {
            if (!(str2 == null || str2.length() == 0)) {
                if (!(str3 == null || str3.length() == 0)) {
                    try {
                        if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "/", false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "=", false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "+", false, 2, (Object) null)) {
                            uz.g gVar = uz.x;
                            bArrC = gVar.c(Base64.decode(str, 0), gVar.g(str2), gVar.f(str3));
                        } else {
                            uz.g gVar2 = uz.x;
                            bArrC = gVar2.c(Base64.decode(str, 8), gVar2.g(str2), gVar2.f(str3));
                        }
                        return qd0.c(bArrC);
                    } catch (Exception e) {
                        e.printStackTrace();
                        de0.l(uz.x.j(), e.getMessage());
                    }
                }
            }
        }
        return null;
    }

    @JvmStatic
    @Nullable
    public static final String J(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            uz.g gVar = uz.x;
            Charset charset = Charsets.UTF_8;
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            vz vzVar = C;
            byte[] bArrEncode = Base64.encode(gVar.e(bytes, gVar.g(vzVar.g()), gVar.f(vzVar.h())), 2);
            Intrinsics.checkNotNullExpressionValue(bArrEncode, "encode(encryptedData, Base64.NO_WRAP)");
            return new String(bArrEncode, charset);
        } catch (Exception e) {
            de0.l(uz.x.j(), e.getMessage());
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final String K(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            uz.g gVar = uz.x;
            Charset charset = Charsets.UTF_8;
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            vz vzVar = C;
            byte[] bArrEncode = Base64.encode(gVar.e(bytes, gVar.g(vzVar.i()), gVar.f(vzVar.j())), 2);
            Intrinsics.checkNotNullExpressionValue(bArrEncode, "encode(encryptedData, Base64.NO_WRAP)");
            return new String(bArrEncode, charset);
        } catch (Exception unused) {
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final String L(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        try {
            uz.g gVar = uz.x;
            Charset charset = Charsets.UTF_8;
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            vz vzVar = C;
            byte[] bArrEncode = Base64.encode(gVar.e(bytes, gVar.g(vzVar.p()), gVar.f(vzVar.q())), 2);
            Intrinsics.checkNotNullExpressionValue(bArrEncode, "encode(encryptedData, Base64.NO_WRAP)");
            return new String(bArrEncode, charset);
        } catch (Exception e) {
            de0.l(uz.x.j(), e.getMessage());
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final String M(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            uz.g gVar = uz.x;
            Charset charset = Charsets.UTF_8;
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            vz vzVar = C;
            byte[] bArrEncode = Base64.encode(gVar.e(bytes, gVar.g(vzVar.m()), gVar.f(vzVar.n())), 8);
            Intrinsics.checkNotNullExpressionValue(bArrEncode, "encode(encryptedData, Base64.URL_SAFE)");
            return new String(bArrEncode, charset);
        } catch (Exception e) {
            de0.l(uz.x.j(), e.getMessage());
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final String N(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            uz.g gVar = uz.x;
            Charset charset = Charsets.UTF_8;
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            vz vzVar = C;
            byte[] bArrEncode = Base64.encode(gVar.e(bytes, gVar.g(vzVar.k()), gVar.f(vzVar.l())), 2);
            Intrinsics.checkNotNullExpressionValue(bArrEncode, "encode(encryptedData, Base64.NO_WRAP)");
            return new String(bArrEncode, charset);
        } catch (Exception e) {
            de0.l(uz.x.j(), e.getMessage());
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final String O(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            uz.g gVar = uz.x;
            Charset charset = Charsets.UTF_8;
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            vz vzVar = C;
            byte[] bArrEncode = Base64.encode(gVar.e(bytes, gVar.g(vzVar.m()), gVar.f(vzVar.n())), 0);
            Intrinsics.checkNotNullExpressionValue(bArrEncode, "encode(encryptedData, Base64.DEFAULT)");
            return new String(bArrEncode, charset);
        } catch (Exception e) {
            de0.l(uz.x.j(), e.getMessage());
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final String P(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            uz.g gVar = uz.x;
            Charset charset = Charsets.UTF_8;
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            vz vzVar = C;
            byte[] bArrEncode = Base64.encode(gVar.e(bytes, gVar.g(vzVar.r()), gVar.f(vzVar.s())), 2);
            Intrinsics.checkNotNullExpressionValue(bArrEncode, "encode(encryptedData, Base64.NO_WRAP)");
            return new String(bArrEncode, charset);
        } catch (Exception e) {
            de0.l(uz.x.j(), e.getMessage());
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final String Q(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        try {
            uz.g gVar = uz.x;
            Charset charset = Charsets.UTF_8;
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            vz vzVar = C;
            byte[] bArrEncode = Base64.encode(gVar.e(bytes, gVar.g(vzVar.t()), gVar.f(vzVar.u())), 2);
            Intrinsics.checkNotNullExpressionValue(bArrEncode, "encode(encryptedData, Base64.NO_WRAP)");
            return new String(bArrEncode, charset);
        } catch (Exception e) {
            de0.l(uz.x.j(), e.getMessage());
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final String R(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        gz gzVar = gz.a;
        String x = gzVar.c().getX();
        String y = gzVar.c().getY();
        if (!(x == null || x.length() == 0)) {
            if (!(y == null || y.length() == 0)) {
                try {
                    uz.g gVar = uz.x;
                    Charset charset = Charsets.UTF_8;
                    byte[] bytes = str.getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    byte[] bArrEncode = Base64.encode(gVar.e(bytes, gVar.g(x), gVar.f(y)), 8);
                    Intrinsics.checkNotNullExpressionValue(bArrEncode, "encode(encryptedData, Base64.URL_SAFE)");
                    return new String(bArrEncode, charset);
                } catch (Exception e) {
                    de0.l(uz.x.j(), e.getMessage());
                }
            }
        }
        return null;
    }

    @JvmStatic
    @Nullable
    public static final String S(@NotNull String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            uz.g gVar = uz.x;
            Charset charset = Charsets.UTF_8;
            byte[] bytes = data.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            vz vzVar = C;
            byte[] bArrEncode = Base64.encode(gVar.e(bytes, gVar.g(vzVar.v()), gVar.f(vzVar.w())), 2);
            Intrinsics.checkNotNullExpressionValue(bArrEncode, "encode(encryptedData, Base64.NO_WRAP)");
            return new String(bArrEncode, charset);
        } catch (Exception e) {
            de0.l(uz.x.j(), e.getMessage());
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final String T(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        if (!(str == null || str.length() == 0)) {
            if (!(str2 == null || str2.length() == 0)) {
                if (!(str3 == null || str3.length() == 0)) {
                    try {
                        uz.g gVar = uz.x;
                        Charset charset = Charsets.UTF_8;
                        byte[] bytes = str.getBytes(charset);
                        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                        byte[] bArrEncode = Base64.encode(gVar.e(bytes, gVar.g(str2), gVar.f(str3)), 2);
                        Intrinsics.checkNotNullExpressionValue(bArrEncode, "encode(encryptedData, Base64.NO_WRAP)");
                        return new String(bArrEncode, charset);
                    } catch (Exception e) {
                        de0.l(uz.x.j(), e.getMessage());
                    }
                }
            }
        }
        return null;
    }

    @NotNull
    public final BouncyCastleProvider U() {
        return (BouncyCastleProvider) D.getValue();
    }
}
