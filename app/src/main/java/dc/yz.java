package dc;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: DXValueUtils+AesExt.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxhyttoutils/lib/utils/dxvalue/DXValueUtilsAesExt;", "", "()V", "Companion", "hytto-apps.android.components.base:dxhyttoutils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class yz {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: DXValueUtils+AesExt.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\bH\u0002J\f\u0010\n\u001a\u00020\b*\u00020\u0005H\u0007J\f\u0010\u000b\u001a\u00020\b*\u00020\u0005H\u0007J\f\u0010\f\u001a\u00020\b*\u00020\u0005H\u0007J\f\u0010\r\u001a\u00020\b*\u00020\u0005H\u0007J\f\u0010\u000e\u001a\u00020\b*\u00020\u0005H\u0007J\f\u0010\u000f\u001a\u00020\b*\u00020\u0005H\u0007J\f\u0010\u0010\u001a\u00020\b*\u00020\u0005H\u0007J\f\u0010\u0011\u001a\u00020\b*\u00020\u0005H\u0007J\f\u0010\u0012\u001a\u00020\b*\u00020\u0005H\u0007J\f\u0010\u0013\u001a\u00020\b*\u00020\u0005H\u0007J\f\u0010\u0014\u001a\u00020\b*\u00020\u0005H\u0007J\f\u0010\u0015\u001a\u00020\b*\u00020\u0005H\u0007J\f\u0010\u0016\u001a\u00020\b*\u00020\u0005H\u0007J\f\u0010\u0017\u001a\u00020\b*\u00020\u0005H\u0007J\f\u0010\u0018\u001a\u00020\b*\u00020\u0005H\u0007J\f\u0010\u0019\u001a\u00020\b*\u00020\u0005H\u0007J\u0018\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u0005H\u0007J\f\u0010\u001b\u001a\u00020\b*\u00020\u0005H\u0007J\f\u0010\u001c\u001a\u00020\b*\u00020\u0005H\u0007J\f\u0010\u001d\u001a\u00020\b*\u00020\u0005H\u0007J\f\u0010\u001e\u001a\u00020\b*\u00020\u0005H\u0007J\f\u0010\u001f\u001a\u00020\b*\u00020\u0005H\u0007J\f\u0010 \u001a\u00020\b*\u00020\u0005H\u0007¨\u0006!"}, d2 = {"Lcom/component/dxhyttoutils/lib/utils/dxvalue/DXValueUtilsAesExt$Companion;", "", "()V", "addAesMap", "", "Lcom/component/dxhyttoutils/lib/utils/dxvalue/DXValueUtils;", "map", "", "", "tokenKey", "getAesCamIoKeyPublic", "getAesCamIoKeyPublicIvy", "getAesCamIoKeyTest", "getAesCamIoKeyTestIvy", "getAesChatTransKey", "getAesChatTransKeyIvy", "getAesDateTransKey", "getAesDateTransKeyIvy", "getAesExceptionLogKey", "getAesExceptionLogKeyIvy", "getAesFromServerKey", "getAesFromServerKeyIvy", "getAesInstallAesKey", "getAesInstallAesKeyIvy", "getAesLocalDatabaseKey", "getAesLocalDatabaseKeyIvy", "getAesMap", "getAesNewLogKey", "getAesNewLogKeyIvy", "getAesToServerKey", "getAesToServerKeyIvy", "getAesTokenKey", "getAesTokenKeyIvy", "hytto-apps.android.components.base:dxhyttoutils"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(xz xzVar, Map<String, String> map, String str) {
            String strW = Intrinsics.areEqual(str, hz.a) ? w(xz.a) : Intrinsics.areEqual(str, hz.b) ? x(xz.a) : Intrinsics.areEqual(str, hz.c) ? l(xz.a) : Intrinsics.areEqual(str, hz.d) ? m(xz.a) : Intrinsics.areEqual(str, hz.e) ? u(xz.a) : Intrinsics.areEqual(str, hz.f) ? v(xz.a) : Intrinsics.areEqual(str, hz.g) ? f(xz.a) : Intrinsics.areEqual(str, hz.h) ? g(xz.a) : Intrinsics.areEqual(str, hz.i) ? h(xz.a) : Intrinsics.areEqual(str, hz.j) ? i(xz.a) : Intrinsics.areEqual(str, hz.k) ? j(xz.a) : Intrinsics.areEqual(str, hz.l) ? k(xz.a) : Intrinsics.areEqual(str, hz.m) ? p(xz.a) : Intrinsics.areEqual(str, hz.n) ? q(xz.a) : Intrinsics.areEqual(str, hz.o) ? s(xz.a) : Intrinsics.areEqual(str, hz.p) ? t(xz.a) : Intrinsics.areEqual(str, hz.q) ? n(xz.a) : Intrinsics.areEqual(str, hz.r) ? o(xz.a) : Intrinsics.areEqual(str, hz.s) ? d(xz.a) : Intrinsics.areEqual(str, hz.t) ? e(xz.a) : Intrinsics.areEqual(str, hz.u) ? b(xz.a) : Intrinsics.areEqual(str, hz.v) ? c(xz.a) : "";
            if (strW.length() == 0) {
                de0.l(Intrinsics.stringPlus("value is empty: ", str));
            } else {
                map.put(str, strW);
            }
        }

        @JvmStatic
        @NotNull
        public final String b(@NotNull xz xzVar) {
            Intrinsics.checkNotNullParameter(xzVar, "<this>");
            return xz.a.c(jz.CAM_IO_KEY_PUBLIC1.getValue(), jz.CAM_IO_KEY_PUBLIC2.getValue());
        }

        @JvmStatic
        @NotNull
        public final String c(@NotNull xz xzVar) {
            Intrinsics.checkNotNullParameter(xzVar, "<this>");
            return xz.a.c(jz.CAM_IO_KEY_PUBLIC_IVY1.getValue(), jz.CAM_IO_KEY_PUBLIC_IVY2.getValue());
        }

        @JvmStatic
        @NotNull
        public final String d(@NotNull xz xzVar) {
            Intrinsics.checkNotNullParameter(xzVar, "<this>");
            return xz.a.c(jz.CAM_IO_KEY_TEST1.getValue(), jz.CAM_IO_KEY_TEST2.getValue());
        }

        @JvmStatic
        @NotNull
        public final String e(@NotNull xz xzVar) {
            Intrinsics.checkNotNullParameter(xzVar, "<this>");
            return xz.a.c(jz.CAM_IO_KEY_TEST_IVY1.getValue(), jz.CAM_IO_KEY_TEST_IVY2.getValue());
        }

        @JvmStatic
        @NotNull
        public final String f(@NotNull xz xzVar) {
            Intrinsics.checkNotNullParameter(xzVar, "<this>");
            return xz.a.c(jz.CHAT_TRANS_KEY1.getValue(), jz.CHAT_TRANS_KEY2.getValue());
        }

        @JvmStatic
        @NotNull
        public final String g(@NotNull xz xzVar) {
            Intrinsics.checkNotNullParameter(xzVar, "<this>");
            return xz.a.c(jz.CHAT_TRANS_KEY_IVY1.getValue(), jz.CHAT_TRANS_KEY_IVY2.getValue());
        }

        @JvmStatic
        @NotNull
        public final String h(@NotNull xz xzVar) {
            Intrinsics.checkNotNullParameter(xzVar, "<this>");
            return xz.a.c(jz.DATE_TRANS_KEY1.getValue(), jz.DATE_TRANS_KEY2.getValue());
        }

        @JvmStatic
        @NotNull
        public final String i(@NotNull xz xzVar) {
            Intrinsics.checkNotNullParameter(xzVar, "<this>");
            return xz.a.c(jz.DATE_TRANS_KEY_IVY1.getValue(), jz.DATE_TRANS_KEY_IVY2.getValue());
        }

        @JvmStatic
        @NotNull
        public final String j(@NotNull xz xzVar) {
            Intrinsics.checkNotNullParameter(xzVar, "<this>");
            return xz.a.c(jz.EXCEPTION_LOG_KEY1.getValue(), jz.EXCEPTION_LOG_KEY2.getValue());
        }

        @JvmStatic
        @NotNull
        public final String k(@NotNull xz xzVar) {
            Intrinsics.checkNotNullParameter(xzVar, "<this>");
            return xz.a.c(jz.EXCEPTION_LOG_KEY_IVY1.getValue(), jz.EXCEPTION_LOG_KEY_IVY2.getValue());
        }

        @JvmStatic
        @NotNull
        public final String l(@NotNull xz xzVar) {
            Intrinsics.checkNotNullParameter(xzVar, "<this>");
            return xz.a.c(jz.FROM_SERVER_KEY1.getValue(), jz.FROM_SERVER_KEY2.getValue());
        }

        @JvmStatic
        @NotNull
        public final String m(@NotNull xz xzVar) {
            Intrinsics.checkNotNullParameter(xzVar, "<this>");
            return xz.a.c(jz.FROM_SERVER_KEY_IVY1.getValue(), jz.FROM_SERVER_KEY_IVY2.getValue());
        }

        @JvmStatic
        @NotNull
        public final String n(@NotNull xz xzVar) {
            Intrinsics.checkNotNullParameter(xzVar, "<this>");
            return xz.a.c(jz.INSTALL_AES_KEY1.getValue(), jz.INSTALL_AES_KEY2.getValue());
        }

        @JvmStatic
        @NotNull
        public final String o(@NotNull xz xzVar) {
            Intrinsics.checkNotNullParameter(xzVar, "<this>");
            return xz.a.c(jz.INSTALL_AES_KEY_IVY1.getValue(), jz.INSTALL_AES_KEY_IVY2.getValue());
        }

        @JvmStatic
        @NotNull
        public final String p(@NotNull xz xzVar) {
            Intrinsics.checkNotNullParameter(xzVar, "<this>");
            return xz.a.c(jz.LOCAL_DATABASE_KEY1.getValue(), jz.LOCAL_DATABASE_KEY2.getValue());
        }

        @JvmStatic
        @NotNull
        public final String q(@NotNull xz xzVar) {
            Intrinsics.checkNotNullParameter(xzVar, "<this>");
            return xz.a.c(jz.LOCAL_DATABASE_KEY_IVY1.getValue(), jz.LOCAL_DATABASE_KEY_IVY2.getValue());
        }

        @JvmStatic
        @NotNull
        public final Map<String, String> r(@NotNull xz xzVar) {
            Intrinsics.checkNotNullParameter(xzVar, "<this>");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            a(xzVar, linkedHashMap, hz.a);
            a(xzVar, linkedHashMap, hz.b);
            a(xzVar, linkedHashMap, hz.c);
            a(xzVar, linkedHashMap, hz.d);
            a(xzVar, linkedHashMap, hz.e);
            a(xzVar, linkedHashMap, hz.f);
            a(xzVar, linkedHashMap, hz.g);
            a(xzVar, linkedHashMap, hz.h);
            a(xzVar, linkedHashMap, hz.i);
            a(xzVar, linkedHashMap, hz.j);
            a(xzVar, linkedHashMap, hz.k);
            a(xzVar, linkedHashMap, hz.l);
            a(xzVar, linkedHashMap, hz.m);
            a(xzVar, linkedHashMap, hz.n);
            a(xzVar, linkedHashMap, hz.o);
            a(xzVar, linkedHashMap, hz.p);
            a(xzVar, linkedHashMap, hz.q);
            a(xzVar, linkedHashMap, hz.r);
            a(xzVar, linkedHashMap, hz.s);
            a(xzVar, linkedHashMap, hz.t);
            a(xzVar, linkedHashMap, hz.u);
            a(xzVar, linkedHashMap, hz.v);
            de0.l(Intrinsics.stringPlus("map.size: ", Integer.valueOf(linkedHashMap.size())));
            return linkedHashMap;
        }

        @JvmStatic
        @NotNull
        public final String s(@NotNull xz xzVar) {
            Intrinsics.checkNotNullParameter(xzVar, "<this>");
            return xz.a.c(jz.NEW_LOG_KEY1.getValue(), jz.NEW_LOG_KEY2.getValue());
        }

        @JvmStatic
        @NotNull
        public final String t(@NotNull xz xzVar) {
            Intrinsics.checkNotNullParameter(xzVar, "<this>");
            return xz.a.c(jz.NEW_LOG_KEY_IVY1.getValue(), jz.NEW_LOG_KEY_IVY2.getValue());
        }

        @JvmStatic
        @NotNull
        public final String u(@NotNull xz xzVar) {
            Intrinsics.checkNotNullParameter(xzVar, "<this>");
            return xz.a.c(jz.TO_SERVER_KEY1.getValue(), jz.TO_SERVER_KEY2.getValue());
        }

        @JvmStatic
        @NotNull
        public final String v(@NotNull xz xzVar) {
            Intrinsics.checkNotNullParameter(xzVar, "<this>");
            return xz.a.c(jz.TO_SERVER_KEY_IVY1.getValue(), jz.TO_SERVER_KEY_IVY2.getValue());
        }

        @JvmStatic
        @NotNull
        public final String w(@NotNull xz xzVar) {
            Intrinsics.checkNotNullParameter(xzVar, "<this>");
            return xz.a.c(jz.TOKEN_KEY1.getValue(), jz.TOKEN_KEY2.getValue());
        }

        @JvmStatic
        @NotNull
        public final String x(@NotNull xz xzVar) {
            Intrinsics.checkNotNullParameter(xzVar, "<this>");
            return xz.a.c(jz.TOKEN_KEY_IVY1.getValue(), jz.TOKEN_KEY_IVY2.getValue());
        }
    }
}
