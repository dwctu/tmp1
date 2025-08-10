package dc;

import com.component.dxtoy.core.toy.bean.ToyConfigBean;
import com.component.dxtoy.core.toy.bean.ToyConfigInfoBean;
import com.component.dxtoy.core.toy.bean.ToyConfigRespBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyConfigManager.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004J\u000e\u0010 \u001a\u00020!2\u0006\u0010\b\u001a\u00020\tJ\b\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020!H\u0002J\u0012\u0010$\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010&\u001a\u00020!2\u0006\u0010%\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/component/dxtoy/core/datacenter/ToyConfigManager;", "", "()V", "MMKV_KEY_SUFFIX_DEV", "", "MMKV_KEY_SUFFIX_RES", "MMKV_KEY_TOY_CONFIG", "MMKV_KEY_TOY_CONFIG_VERSION", "isDebug", "", "()Z", "setDebug", "(Z)V", "toyConfigList", "Ljava/util/ArrayList;", "Lcom/component/dxtoy/core/toy/bean/ToyConfigInfoBean;", "Lkotlin/collections/ArrayList;", "generateType", "type", "getConfigBySymbol", "symbol", "getConfigByType", "getKey", "key", "getNameBySymbol", "getToyConfigData", "getToyConfigList", "", "getToyConfigVersion", "", "getTypeByName", "name", "init", "", "loadConfigFromLocal", "refreshToyCache", "setToyConfig", "encryptData", "updateToyConfig", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class gb0 {

    @NotNull
    public static final gb0 a = new gb0();

    @NotNull
    public static ArrayList<ToyConfigInfoBean> b = new ArrayList<>();
    public static boolean c;

    /* JADX WARN: Removed duplicated region for block: B:34:0x0051 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[LOOP:0: B:13:0x0018->B:37:?, LOOP_END, SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.component.dxtoy.core.toy.bean.ToyConfigInfoBean a(@org.jetbrains.annotations.Nullable java.lang.String r8) {
        /*
            r7 = this;
            r0 = 1
            r1 = 0
            if (r8 == 0) goto Ld
            int r2 = r8.length()
            if (r2 != 0) goto Lb
            goto Ld
        Lb:
            r2 = 0
            goto Le
        Ld:
            r2 = 1
        Le:
            r3 = 0
            if (r2 == 0) goto L12
            return r3
        L12:
            java.util.ArrayList<com.component.dxtoy.core.toy.bean.ToyConfigInfoBean> r2 = dc.gb0.b
            java.util.Iterator r2 = r2.iterator()
        L18:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L52
            java.lang.Object r4 = r2.next()
            r5 = r4
            com.component.dxtoy.core.toy.bean.ToyConfigInfoBean r5 = (com.component.dxtoy.core.toy.bean.ToyConfigInfoBean) r5
            java.util.List r5 = r5.getSymbol()
            if (r5 == 0) goto L4e
            boolean r6 = r5 instanceof java.util.Collection
            if (r6 == 0) goto L36
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto L36
            goto L4e
        L36:
            java.util.Iterator r5 = r5.iterator()
        L3a:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L4e
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            boolean r6 = kotlin.text.StringsKt__StringsJVMKt.equals(r8, r6, r0)
            if (r6 == 0) goto L3a
            r5 = 1
            goto L4f
        L4e:
            r5 = 0
        L4f:
            if (r5 == 0) goto L18
            r3 = r4
        L52:
            com.component.dxtoy.core.toy.bean.ToyConfigInfoBean r3 = (com.component.dxtoy.core.toy.bean.ToyConfigInfoBean) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.gb0.a(java.lang.String):com.component.dxtoy.core.toy.bean.ToyConfigInfoBean");
    }

    public final String b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(c ? "_dev" : "_res");
        return sb.toString();
    }

    @Nullable
    public final String c() {
        return qx.a(xb0.d.g(b("mmkv_key_toy_config")));
    }

    @NotNull
    public final List<ToyConfigInfoBean> d() {
        return b;
    }

    public final int e() {
        return xb0.d.e(b("mmkv_key_toy_config_version"), 1);
    }

    public final void f(boolean z) {
        de0.v("init object, load data openDebug: " + z);
        c = z && gd0.i();
        h();
    }

    public final boolean g() {
        return c;
    }

    public final void h() {
        xb0 xb0Var = xb0.d;
        String strG = xb0Var.g(b("mmkv_key_toy_config"));
        if (strG.length() == 0) {
            strG = je0.a(c ? "ToyConfigDev.txt" : "ToyConfigRes.txt");
            Intrinsics.checkNotNullExpressionValue(strG, "readAssets2String(if (is… else \"ToyConfigRes.txt\")");
            if (strG.length() == 0) {
                return;
            } else {
                xb0Var.j(b("mmkv_key_toy_config"), strG);
            }
        }
        j(strG);
    }

    public final void i() {
        StringBuilder sb = new StringBuilder();
        sb.append("refreshToyCache cacheToyMap size = ");
        hb0 hb0Var = hb0.a;
        sb.append(hb0Var.d().size());
        de0.i(sb.toString());
        if (hb0Var.d().isEmpty()) {
            return;
        }
        for (Map.Entry<String, nb0> entry : hb0Var.d().entrySet()) {
            ToyConfigInfoBean toyConfigInfoBeanA = a.a(entry.getValue().f());
            if (toyConfigInfoBeanA != null) {
                entry.getValue().u(toyConfigInfoBeanA);
            }
        }
    }

    public final void j(String str) {
        ToyConfigBean data;
        List<ToyConfigInfoBean> configList;
        Integer dv;
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            ToyConfigRespBean toyConfigRespBean = (ToyConfigRespBean) xd0.d(qx.a(str), ToyConfigRespBean.class);
            int iIntValue = (toyConfigRespBean == null || (dv = toyConfigRespBean.getDv()) == null) ? 1 : dv.intValue();
            int iE = e();
            de0.v("current config version = " + iIntValue + " , last version = " + iE + ' ');
            if (iE < iIntValue) {
                xb0.d.i(b("mmkv_key_toy_config_version"), iIntValue);
            }
            if (toyConfigRespBean == null || (data = toyConfigRespBean.getData()) == null || (configList = data.getConfigList()) == null) {
                return;
            }
            b.clear();
            b.addAll(configList);
        } catch (Throwable th) {
            th.printStackTrace();
            de0.l(th.getMessage());
        }
    }

    public final void k(@NotNull String encryptData) {
        Intrinsics.checkNotNullParameter(encryptData, "encryptData");
        xb0.d.j(b("mmkv_key_toy_config"), encryptData);
        j(encryptData);
        i();
    }
}
