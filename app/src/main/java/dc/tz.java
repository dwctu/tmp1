package dc;

import android.os.Build;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.sun.jna.Callback;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HyttoIdUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxhyttoutils/lib/utils/HyttoIdUtils;", "", "()V", "Companion", "hytto-apps.android.components.base:dxhyttoutils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class tz {

    @NotNull
    public static final a a = new a(null);
    public static int b = 5;

    @Nullable
    public static String c = "";

    @Nullable
    public static String d = "";

    @Nullable
    public static String e = "";

    /* compiled from: HyttoIdUtils.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0007J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0003J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/component/dxhyttoutils/lib/utils/HyttoIdUtils$Companion;", "", "()V", "OAID_RETURN_IGNORE", "", "SP_DEVICE_ID", "SP_SESSION_ID", "deviceId", "deviceNullCount", "", "openId", "sessionId", "createDeviceId", "", Callback.METHOD_NAME, "Lcom/component/dxhyttoutils/lib/listener/DeviceIdCallback;", "getDeviceId", "getOpenId", "getSessionId", "init", "isIgnore", "", "isSaveDeviceId", "setDeviceId", TtmlNode.ATTR_ID, "setSessionId", "hytto-apps.android.components.base:dxhyttoutils"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {

        /* compiled from: HyttoIdUtils.kt */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010\u0007\u001a\u00020\u00032\n\u0010\b\u001a\u00060\tj\u0002`\nH\u0016¨\u0006\u000b"}, d2 = {"com/component/dxhyttoutils/lib/utils/HyttoIdUtils$Companion$createDeviceId$1", "Lcom/github/gzuliyujiang/oaid/IGetter;", "onOAID", "", "result", "", "onOAIDGetComplete", "onOAIDGetError", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "hytto-apps.android.components.base:dxhyttoutils"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* renamed from: dc.tz$a$a, reason: collision with other inner class name */
        public static final class C0221a implements vh0 {
            public final /* synthetic */ lz a;

            public C0221a(lz lzVar) {
                this.a = lzVar;
            }

            @Override // dc.vh0
            public void a(@Nullable String str) {
                c(str);
            }

            @Override // dc.vh0
            public void b(@NotNull Exception error) {
                Intrinsics.checkNotNullParameter(error, "error");
                c(null);
            }

            public final void c(String str) {
                if ((str == null || str.length() == 0) || StringsKt__StringsJVMKt.startsWith$default(str, "0000", false, 2, null)) {
                    str = rz.b(ve0.a());
                    if (TextUtils.equals(str, "rvtlar")) {
                        str = Intrinsics.stringPlus(str, tz.a.f());
                    }
                }
                lz lzVar = this.a;
                if (lzVar == null) {
                    return;
                }
                if (str == null) {
                    str = "";
                }
                lzVar.a(str);
            }
        }

        /* compiled from: HyttoIdUtils.kt */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/component/dxhyttoutils/lib/utils/HyttoIdUtils$Companion$getDeviceId$1", "Lcom/component/dxhyttoutils/lib/listener/DeviceIdCallback;", "done", "", TtmlNode.ATTR_ID, "", "hytto-apps.android.components.base:dxhyttoutils"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class b implements lz {
            public final /* synthetic */ Ref.ObjectRef<String> a;

            public b(Ref.ObjectRef<String> objectRef) {
                this.a = objectRef;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // dc.lz
            public void a(@NotNull String id) {
                Intrinsics.checkNotNullParameter(id, "id");
                this.a.element = id;
            }
        }

        /* compiled from: HyttoIdUtils.kt */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/component/dxhyttoutils/lib/utils/HyttoIdUtils$Companion$getDeviceId$2", "Lcom/component/dxhyttoutils/lib/listener/DeviceIdCallback;", "done", "", TtmlNode.ATTR_ID, "", "hytto-apps.android.components.base:dxhyttoutils"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class c implements lz {
            public final /* synthetic */ lz a;

            public c(lz lzVar) {
                this.a = lzVar;
            }

            @Override // dc.lz
            public void a(@NotNull String id) {
                Intrinsics.checkNotNullParameter(id, "id");
                if (tz.a.i(id)) {
                    tz.c = id;
                    ne0.d().m("sp_hytto_device_id", id);
                }
                lz lzVar = this.a;
                if (lzVar == null) {
                    return;
                }
                lzVar.a(id);
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final synchronized void b(lz lzVar) {
            if (h()) {
                String strB = rz.b(ve0.a());
                if (TextUtils.equals(strB, "rvtlar")) {
                    strB = Intrinsics.stringPlus(strB, f());
                }
                if (lzVar != null) {
                    if (strB == null) {
                        strB = "";
                    }
                    lzVar.a(strB);
                }
            } else {
                uh0.a(ve0.a(), new C0221a(lzVar));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.String] */
        @JvmStatic
        @Nullable
        public final synchronized String c() {
            String str;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = tz.c;
            d(new b(objectRef));
            str = (String) objectRef.element;
            if (str == null) {
                str = "";
            }
            return str;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
        @kotlin.jvm.JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final synchronized void d(@org.jetbrains.annotations.Nullable dc.lz r6) {
            /*
                r5 = this;
                monitor-enter(r5)
                java.lang.String r0 = dc.tz.a()     // Catch: java.lang.Throwable -> L53
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L12
                int r0 = r0.length()     // Catch: java.lang.Throwable -> L53
                if (r0 != 0) goto L10
                goto L12
            L10:
                r0 = 0
                goto L13
            L12:
                r0 = 1
            L13:
                if (r0 == 0) goto L40
                dc.ne0 r0 = dc.ne0.d()     // Catch: java.lang.Throwable -> L53
                java.lang.String r3 = "sp_hytto_device_id"
                java.lang.String r4 = ""
                java.lang.String r0 = r0.h(r3, r4)     // Catch: java.lang.Throwable -> L53
                dc.tz.e(r0)     // Catch: java.lang.Throwable -> L53
                java.lang.String r0 = dc.tz.a()     // Catch: java.lang.Throwable -> L53
                if (r0 == 0) goto L34
                int r0 = r0.length()     // Catch: java.lang.Throwable -> L53
                if (r0 != 0) goto L32
                goto L34
            L32:
                r0 = 0
                goto L35
            L34:
                r0 = 1
            L35:
                if (r0 == 0) goto L40
                dc.tz$a$c r0 = new dc.tz$a$c     // Catch: java.lang.Throwable -> L53
                r0.<init>(r6)     // Catch: java.lang.Throwable -> L53
                r5.b(r0)     // Catch: java.lang.Throwable -> L53
                goto L41
            L40:
                r1 = 0
            L41:
                if (r1 != 0) goto L51
                if (r6 != 0) goto L46
                goto L51
            L46:
                java.lang.String r0 = dc.tz.a()     // Catch: java.lang.Throwable -> L53
                if (r0 != 0) goto L4e
                java.lang.String r0 = ""
            L4e:
                r6.a(r0)     // Catch: java.lang.Throwable -> L53
            L51:
                monitor-exit(r5)
                return
            L53:
                r6 = move-exception
                monitor-exit(r5)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: dc.tz.a.d(dc.lz):void");
        }

        @JvmStatic
        @Nullable
        public final synchronized String e() {
            String str;
            String str2 = tz.e;
            if (str2 == null || str2.length() == 0) {
                tz.e = rd0.d();
            }
            str = tz.e;
            if (str == null) {
                str = "";
            }
            return str;
        }

        @JvmStatic
        @Nullable
        public final synchronized String f() {
            String str;
            String str2 = tz.d;
            if (str2 == null || str2.length() == 0) {
                tz.d = ne0.d().h("sp_hytto_session_id", "");
                String str3 = tz.d;
                if (str3 == null || str3.length() == 0) {
                    tz.d = rd0.d();
                    ne0.d().m("sp_hytto_session_id", tz.d);
                }
            }
            str = tz.d;
            if (str == null) {
                str = "";
            }
            return str;
        }

        @JvmStatic
        public final synchronized void g(@Nullable String str) {
            j(str);
            f();
            c();
            e();
        }

        public final boolean h() {
            return gz.a.c().c().contains(Build.MODEL);
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final synchronized boolean i(java.lang.String r5) {
            /*
                r4 = this;
                monitor-enter(r4)
                boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L27
                r1 = 0
                if (r0 != 0) goto L25
                java.lang.String r0 = "rvtlar"
                r2 = 2
                r3 = 0
                boolean r5 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r5, r0, r1, r2, r3)     // Catch: java.lang.Throwable -> L27
                r0 = 1
                if (r5 == 0) goto L22
                int r5 = dc.tz.b()     // Catch: java.lang.Throwable -> L27
                int r5 = r5 + (-1)
                dc.tz.f(r5)     // Catch: java.lang.Throwable -> L27
                int r5 = dc.tz.b()     // Catch: java.lang.Throwable -> L27
                if (r5 != 0) goto L23
            L22:
                r1 = 1
            L23:
                monitor-exit(r4)
                return r1
            L25:
                monitor-exit(r4)
                return r1
            L27:
                r5 = move-exception
                monitor-exit(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: dc.tz.a.i(java.lang.String):boolean");
        }

        @JvmStatic
        public final synchronized void j(String str) {
            boolean z;
            if (str != null) {
                try {
                    z = str.length() == 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!z) {
                tz.d = str;
                ne0.d().m("sp_hytto_session_id", str);
            }
        }
    }

    @JvmStatic
    @Nullable
    public static final synchronized String i() {
        return a.c();
    }

    @JvmStatic
    public static final synchronized void j(@Nullable lz lzVar) {
        a.d(lzVar);
    }

    @JvmStatic
    public static final synchronized void k(@Nullable String str) {
        a.g(str);
    }
}
