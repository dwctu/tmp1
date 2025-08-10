package dc;

import android.os.Debug;
import com.component.dxhyttoutils.lib.protect.P;
import dc.pz;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: DXCheckUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxhyttoutils/lib/utils/DXCheckUtils;", "", "()V", "Companion", "hytto-apps.android.components.base:dxhyttoutils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class pz {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: DXCheckUtils.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/component/dxhyttoutils/lib/utils/DXCheckUtils$Companion;", "", "()V", "checkAppKeyStoreSign", "", "init", "strlen", "", "hytto-apps.android.components.base:dxhyttoutils"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final void b() throws Exception {
            gz.a.a();
            String str_rand = P.INSTANCE._rand(ve0.a(), xz.h(), xz.i());
            if (Intrinsics.areEqual(str_rand, "success")) {
                return;
            }
            P._log("exit_app_key_store", Intrinsics.stringPlus("check: ", str_rand));
            gd0.a();
        }

        @JvmStatic
        public final void a() {
            se0.g(new Runnable() { // from class: dc.oz
                @Override // java.lang.Runnable
                public final void run() throws Exception {
                    pz.a.b();
                }
            }, 100L);
        }

        @JvmStatic
        public final void c() throws Exception {
            gz.a.a();
            P.INSTANCE._malloc();
            a();
        }

        @JvmStatic
        public final boolean e() {
            return Debug.isDebuggerConnected();
        }
    }

    @JvmStatic
    public static final void a() {
        a.a();
    }
}
