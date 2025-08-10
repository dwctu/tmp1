package dc;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: DXValueUtils.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\b\fJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/component/dxhyttoutils/lib/utils/dxvalue/DXValueUtils;", "Lcom/component/dxhyttoutils/lib/utils/dxvalue/DXValueBaseUtils;", "()V", "getCertSSLData", "", "getCertSSLKey", "getDBPwd", "getKeyStore", "getKeyStore2", "getKeyStore2WithCode", "appCode", "Lcom/component/dxhyttoutils/lib/data/HyttoEum$AppCode;", "getKeyStore2WithCode$hytto_apps_android_components_base_dxhyttoutils", "getKeyStoreWithCode", "getKeyStoreWithCode$hytto_apps_android_components_base_dxhyttoutils", "hytto-apps.android.components.base:dxhyttoutils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class xz extends wz {

    @NotNull
    public static final xz a = new xz();

    @JvmStatic
    @NotNull
    public static final String e() {
        return a.c(jz.SSL_DATA1.getValue(), jz.SSL_DATA2.getValue());
    }

    @JvmStatic
    @NotNull
    public static final String f() {
        return a.c(jz.SSL_KEY1.getValue(), jz.SSL_KEY2.getValue());
    }

    @JvmStatic
    @NotNull
    public static final String g() {
        return a.c(jz.COMMON_DB_PWD_KEY1.getValue(), jz.COMMON_DB_PWD_KEY2.getValue());
    }

    @JvmStatic
    @NotNull
    public static final String h() {
        return a.c(jz.KEY_STORE1.getValue(), jz.KEY_STORE2.getValue());
    }

    @JvmStatic
    @NotNull
    public static final String i() {
        return a.c(jz.KEY2_STORE1.getValue(), jz.KEY2_STORE2.getValue());
    }
}
