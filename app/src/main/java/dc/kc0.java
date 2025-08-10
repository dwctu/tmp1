package dc;

import com.component.dxhttp.NetException;
import com.component.dxhttp.bean.BaseResponse;
import com.component.dxtoy.update.bean.ToyDegradeReqBean;
import com.component.dxtoy.update.bean.ToyUpdateReqBean;
import com.component.dxtoy.update.bean.ToyUpdateRespBean;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: DXToyUpdateApi.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J \u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J4\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0010\u0010\t\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\nH\u0007J\u0018\u0010!\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u001bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/component/dxtoy/update/DXToyUpdateApi;", "", "()V", "degradeRequestUrl", "", "isFirmwareUpdate", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRequestUpdate", "isRetry", "openDebug", "", "toyUpdateData", "Ljava/util/HashMap;", "Lcom/component/dxtoy/update/bean/ToyUpdateRespBean;", "Lkotlin/collections/HashMap;", "updateRequestUrl", "checkFirmwareDegrade", "", "mac", "deviceType", "degradeVer", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/component/dxtoy/update/CheckToyUpdateListener;", "checkFirmwareUpdate", "checkToyDegrade", "checkToyUpdate", "doUpdateFirmware", "Lcom/component/dxtoy/update/UpdateListener;", "getToyUpdateResp", "handleCheckFirmwareUpdate", "updateResponse", "isSupportOTA", "isDebug", "updateFirmware", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class kc0 {

    @NotNull
    public static String b = "https://apps2.lovense-api.com/app/getUpdate/dfu/v2";

    @NotNull
    public static String c = "https://apps2.lovense-api.com/app/getHardWareDegrade/dfu";
    public static boolean d;

    @NotNull
    public static final kc0 a = new kc0();

    @NotNull
    public static final AtomicBoolean e = new AtomicBoolean(false);

    @NotNull
    public static final AtomicBoolean f = new AtomicBoolean(false);

    @NotNull
    public static final AtomicBoolean g = new AtomicBoolean(false);

    @NotNull
    public static final HashMap<String, ToyUpdateRespBean> h = new HashMap<>();

    /* compiled from: DXToyUpdateApi.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/component/dxtoy/update/DXToyUpdateApi$checkFirmwareDegrade$1", "Lcom/component/dxhttp/callback/ResponseCallback;", "Lcom/component/dxhttp/bean/BaseResponse;", "Lcom/component/dxtoy/update/bean/ToyUpdateRespBean;", "onError", "", "e", "Lcom/component/dxhttp/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends ny<BaseResponse<ToyUpdateRespBean>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ jc0 d;

        public a(String str, String str2, String str3, jc0 jc0Var) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = jc0Var;
        }

        @Override // dc.ny
        public void b(@Nullable NetException netException) {
            kc0.a.j(this.a, this.b, this.c, null, this.d);
        }

        @Override // dc.ny
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void d(@Nullable BaseResponse<ToyUpdateRespBean> baseResponse) {
            kc0.a.j(this.a, this.b, this.c, baseResponse != null ? baseResponse.getData() : null, this.d);
        }
    }

    /* compiled from: DXToyUpdateApi.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/component/dxtoy/update/DXToyUpdateApi$checkFirmwareUpdate$1", "Lcom/component/dxhttp/callback/ResponseCallback;", "Lcom/component/dxhttp/bean/BaseResponse;", "Lcom/component/dxtoy/update/bean/ToyUpdateRespBean;", "onError", "", "e", "Lcom/component/dxhttp/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends ny<BaseResponse<ToyUpdateRespBean>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ jc0 c;

        public b(String str, String str2, jc0 jc0Var) {
            this.a = str;
            this.b = str2;
            this.c = jc0Var;
        }

        @Override // dc.ny
        public void b(@Nullable NetException netException) {
            kc0.a.j(this.a, this.b, null, null, this.c);
        }

        @Override // dc.ny
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void d(@Nullable BaseResponse<ToyUpdateRespBean> baseResponse) {
            kc0.a.j(this.a, this.b, null, baseResponse != null ? baseResponse.getData() : null, this.c);
        }
    }

    /* compiled from: DXToyUpdateApi.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/component/dxtoy/update/DXToyUpdateApi$updateFirmware$innerUpdateListener$1", "Lcom/component/dxtoy/update/UpdateListener;", "onDownloadProgress", "", "progress", "", "onResult", "isSuccess", "", "errMsg", "", "onUpdateProgress", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements oc0 {
        public final /* synthetic */ oc0 a;
        public final /* synthetic */ String b;

        public c(oc0 oc0Var, String str) {
            this.a = oc0Var;
            this.b = str;
        }

        @Override // dc.oc0
        public void a(boolean z, @Nullable String str) {
            this.a.a(z, str);
            kc0.f.set(false);
            nc0.a.b();
            if (z) {
                kc0.h.remove(this.b);
            }
        }

        @Override // dc.oc0
        public void b(int i) {
            this.a.b(i);
        }

        @Override // dc.oc0
        public void c(int i) {
            this.a.c(i);
        }
    }

    @JvmStatic
    public static final void f(@NotNull String mac, @NotNull jc0 listener) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(listener, "listener");
        nb0 nb0VarF = nc0.a.f(mac);
        String deviceType = nb0VarF != null ? nb0VarF.getDeviceType() : null;
        if (nb0VarF != null) {
            if (!(deviceType == null || deviceType.length() == 0)) {
                if (e.compareAndSet(false, true)) {
                    a.e(mac, deviceType, listener);
                    return;
                }
                return;
            }
        }
        listener.a(false);
    }

    public static final void h(String mac, oc0 listener, boolean z) {
        Intrinsics.checkNotNullParameter(mac, "$mac");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        if (!z) {
            listener.a(false, "No need to update firmware");
            return;
        }
        ToyUpdateRespBean toyUpdateRespBean = h.get(mac);
        if (toyUpdateRespBean != null) {
            nc0.a.j(mac, toyUpdateRespBean, listener);
        }
    }

    @JvmStatic
    @Nullable
    public static final ToyUpdateRespBean i(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        return h.get(mac);
    }

    @JvmStatic
    public static final boolean k(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        return nc0.a.g(mac);
    }

    @JvmStatic
    public static final void m(boolean z) {
        d = z;
        b = (z && gd0.i()) ? "https://test10.lovense.com/app/getUpdate/dfu/v2" : "https://apps2.lovense-api.com/app/getUpdate/dfu/v2";
        c = gd0.i() ? "https://test10.lovense.com/app/getHardWareDegrade/dfu" : "";
    }

    @JvmStatic
    public static final void n(@NotNull String mac, @NotNull oc0 listener) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(listener, "listener");
        nb0 nb0VarF = nc0.a.f(mac);
        String deviceType = nb0VarF != null ? nb0VarF.getDeviceType() : null;
        if (nb0VarF != null) {
            if (!(deviceType == null || deviceType.length() == 0)) {
                if (f.compareAndSet(false, true)) {
                    a.g(mac, deviceType, new c(listener, mac));
                    return;
                }
                return;
            }
        }
        listener.a(false, "Device disconnect");
    }

    public final void d(String str, String str2, String str3, jc0 jc0Var) {
        ky.e(c, new ToyDegradeReqBean(str2, str3), null, new a(str, str2, str3, jc0Var));
    }

    public final void e(String str, String str2, jc0 jc0Var) {
        ky.e(b, new ToyUpdateReqBean(str2), null, new b(str, str2, jc0Var));
    }

    public final void g(final String str, String str2, final oc0 oc0Var) {
        ToyUpdateRespBean toyUpdateRespBean = h.get(str);
        if (toyUpdateRespBean == null) {
            e(str, str2, new jc0() { // from class: dc.gc0
                @Override // dc.jc0
                public final void a(boolean z) {
                    kc0.h(str, oc0Var, z);
                }
            });
        } else if (Intrinsics.areEqual(toyUpdateRespBean.getHasUpdate(), Boolean.TRUE)) {
            nc0.a.j(str, toyUpdateRespBean, oc0Var);
        } else {
            oc0Var.a(false, "No need to update firmware");
        }
    }

    public final void j(String str, String str2, String str3, ToyUpdateRespBean toyUpdateRespBean, jc0 jc0Var) {
        boolean z = true;
        if (toyUpdateRespBean != null) {
            if (!(str == null || str.length() == 0)) {
                String strA = qx.a(toyUpdateRespBean.getUrl());
                de0.v("firmware url decrypt == " + strA);
                if (strA != null && strA.length() != 0) {
                    z = false;
                }
                if (!z) {
                    toyUpdateRespBean.setUrl(strA);
                    h.put(str, toyUpdateRespBean);
                }
                g.set(false);
                e.set(false);
                Boolean hasUpdate = toyUpdateRespBean.getHasUpdate();
                jc0Var.a(hasUpdate != null ? hasUpdate.booleanValue() : false);
                return;
            }
        }
        AtomicBoolean atomicBoolean = g;
        if (!atomicBoolean.compareAndSet(false, true)) {
            atomicBoolean.set(false);
            e.set(false);
            jc0Var.a(false);
            return;
        }
        if (str3 != null && str3.length() != 0) {
            z = false;
        }
        if (z) {
            e(str, str2, jc0Var);
        } else {
            d(str, str2, str3, jc0Var);
        }
    }
}
