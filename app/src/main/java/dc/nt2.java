package dc;

import android.content.Context;
import android.view.Window;
import com.koushikdutta.async.http.cache.ResponseCacheMiddleware;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DeviceRuntime.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001f\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0019\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001a\u0010\u001b\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/wear/ui/chat/pancel/helper/device/DeviceRuntime;", "", "context", "Landroid/content/Context;", "window", "Landroid/view/Window;", "(Landroid/content/Context;Landroid/view/Window;)V", "getContext", "()Landroid/content/Context;", "deviceInfoL", "Lcom/wear/ui/chat/pancel/helper/device/DeviceInfo;", "getDeviceInfoL", "()Lcom/wear/ui/chat/pancel/helper/device/DeviceInfo;", "setDeviceInfoL", "(Lcom/wear/ui/chat/pancel/helper/device/DeviceInfo;)V", "deviceInfoP", "getDeviceInfoP", "setDeviceInfoP", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "isNavigationBarShow", "setNavigationBarShow", "isPad", "setPad", "isPortrait", "setPortrait", "getWindow", "()Landroid/view/Window;", "getDeviceInfoByOrientation", ResponseCacheMiddleware.CACHE, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class nt2 {

    @NotNull
    public final Context a;

    @NotNull
    public final Window b;

    @Nullable
    public DeviceInfo c;

    @Nullable
    public DeviceInfo d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;

    public nt2(@NotNull Context context, @NotNull Window window) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(window, "window");
        this.a = context;
        this.b = window;
        this.g = (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        this.f = bu2.q(context);
        this.e = bu2.p(context, window);
        this.h = bu2.n(window);
    }

    public static /* synthetic */ DeviceInfo b(nt2 nt2Var, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return nt2Var.a(z);
    }

    @NotNull
    public final DeviceInfo a(boolean z) {
        DeviceInfo deviceInfo;
        DeviceInfo deviceInfo2;
        this.f = bu2.q(this.a);
        this.e = bu2.p(this.a, this.b);
        this.h = bu2.n(this.b);
        if (z) {
            boolean z2 = this.f;
            if (z2 && (deviceInfo2 = this.c) != null) {
                Intrinsics.checkNotNull(deviceInfo2);
                return deviceInfo2;
            }
            if (!z2 && (deviceInfo = this.d) != null) {
                Intrinsics.checkNotNull(deviceInfo);
                return deviceInfo;
            }
        }
        int iE = bu2.e(this.a, this.b);
        int iJ = bu2.j(this.b);
        int iK = bu2.k(this.b);
        int i = iK == iJ ? 0 : iK;
        int i2 = bu2.a.i(this.b);
        int iH = bu2.h(this.b);
        int iG = bu2.g(this.a);
        if (this.f) {
            DeviceInfo deviceInfo3 = new DeviceInfo(this.b, true, iJ, iE, i, i2, iH, iG);
            this.c = deviceInfo3;
            Intrinsics.checkNotNull(deviceInfo3);
            return deviceInfo3;
        }
        DeviceInfo deviceInfo4 = new DeviceInfo(this.b, false, iJ, iE, i, i2, iH, iG);
        this.d = deviceInfo4;
        Intrinsics.checkNotNull(deviceInfo4);
        return deviceInfo4;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final Window getB() {
        return this.b;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getH() {
        return this.h;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getE() {
        return this.e;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getG() {
        return this.g;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getF() {
        return this.f;
    }
}
