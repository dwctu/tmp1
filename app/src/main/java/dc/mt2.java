package dc;

import android.view.Window;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DeviceInfo.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001J\u0013\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0016\u0010#\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005J\t\u0010%\u001a\u00020\u0007HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006("}, d2 = {"Lcom/wear/ui/chat/pancel/helper/device/DeviceInfo;", "", "window", "Landroid/view/Window;", "isPortrait", "", "statusBarH", "", "navigationBarH", "toolbarH", "screenH", "screenWithoutSystemUiH", "screenWithoutNavigationH", "(Landroid/view/Window;ZIIIIII)V", "()Z", "getNavigationBarH", "()I", "getScreenH", "getScreenWithoutNavigationH", "getScreenWithoutSystemUiH", "getStatusBarH", "getToolbarH", "getWindow", "()Landroid/view/Window;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "getCurrentNavigationBarHeightWhenVisible", "isPad", "hashCode", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: dc.mt2, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class DeviceInfo {

    /* renamed from: a, reason: from toString */
    @NotNull
    public final Window window;

    /* renamed from: b, reason: from toString */
    public final boolean isPortrait;

    /* renamed from: c, reason: from toString */
    public final int statusBarH;

    /* renamed from: d, reason: from toString */
    public final int navigationBarH;

    /* renamed from: e, reason: from toString */
    public final int toolbarH;

    /* renamed from: f, reason: from toString */
    public final int screenH;

    /* renamed from: g, reason: from toString */
    public final int screenWithoutSystemUiH;

    /* renamed from: h, reason: from toString */
    public final int screenWithoutNavigationH;

    public DeviceInfo(@NotNull Window window, boolean z, int i, int i2, int i3, int i4, int i5, int i6) {
        Intrinsics.checkNotNullParameter(window, "window");
        this.window = window;
        this.isPortrait = z;
        this.statusBarH = i;
        this.navigationBarH = i2;
        this.toolbarH = i3;
        this.screenH = i4;
        this.screenWithoutSystemUiH = i5;
        this.screenWithoutNavigationH = i6;
    }

    public final int a(boolean z, boolean z2) {
        if (z) {
            return this.navigationBarH;
        }
        if (z2) {
            return this.navigationBarH;
        }
        return 0;
    }

    /* renamed from: b, reason: from getter */
    public final int getNavigationBarH() {
        return this.navigationBarH;
    }

    /* renamed from: c, reason: from getter */
    public final int getScreenH() {
        return this.screenH;
    }

    /* renamed from: d, reason: from getter */
    public final int getStatusBarH() {
        return this.statusBarH;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) other;
        return Intrinsics.areEqual(this.window, deviceInfo.window) && this.isPortrait == deviceInfo.isPortrait && this.statusBarH == deviceInfo.statusBarH && this.navigationBarH == deviceInfo.navigationBarH && this.toolbarH == deviceInfo.toolbarH && this.screenH == deviceInfo.screenH && this.screenWithoutSystemUiH == deviceInfo.screenWithoutSystemUiH && this.screenWithoutNavigationH == deviceInfo.screenWithoutNavigationH;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = this.window.hashCode() * 31;
        boolean z = this.isPortrait;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((((((((((((iHashCode + i) * 31) + this.statusBarH) * 31) + this.navigationBarH) * 31) + this.toolbarH) * 31) + this.screenH) * 31) + this.screenWithoutSystemUiH) * 31) + this.screenWithoutNavigationH;
    }

    @NotNull
    public String toString() {
        return "DeviceInfo(window=" + this.window + ", isPortrait=" + this.isPortrait + ", statusBarH=" + this.statusBarH + ", navigationBarH=" + this.navigationBarH + ", toolbarH=" + this.toolbarH + ", screenH=" + this.screenH + ", screenWithoutSystemUiH=" + this.screenWithoutSystemUiH + ", screenWithoutNavigationH=" + this.screenWithoutNavigationH + ')';
    }
}
