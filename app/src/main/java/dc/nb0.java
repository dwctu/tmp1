package dc;

import androidx.room.Ignore;
import com.component.dxtoy.core.toy.bean.ToyLvsInfoBean;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyInfo.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001a\u0010\"\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u001a\u0010$\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001e\u0010'\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R \u0010-\u001a\u0004\u0018\u00010.8\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001e\u00106\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\u001e\u00109\u001a\u00020:8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0018\"\u0004\bA\u0010\u001aR\u001e\u0010B\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR\u001a\u0010E\u001a\u00020:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010<\"\u0004\bG\u0010>¨\u0006L"}, d2 = {"Lcom/component/dxtoy/core/toy/ToyInfo;", "Lcom/component/dxtoy/core/toy/BaseToy;", "()V", "battery", "", "getBattery", "()I", "setBattery", "(I)V", "connectPriority", "Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$ConnectPriority;", "getConnectPriority", "()Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$ConnectPriority;", "setConnectPriority", "(Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$ConnectPriority;)V", "connectState", "Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$ToyConnectState;", "getConnectState", "()Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$ToyConnectState;", "setConnectState", "(Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$ToyConnectState;)V", "formApp", "", "getFormApp", "()Ljava/lang/String;", "setFormApp", "(Ljava/lang/String;)V", "isLedOpen", "", "()Z", "setLedOpen", "(Z)V", "isRotateForward", "setRotateForward", "isUIInMyToyList", "setUIInMyToyList", "ledColor", "getLedColor", "setLedColor", "longRange", "Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$LongRangeState;", "getLongRange", "()Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$LongRangeState;", "setLongRange", "(Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$LongRangeState;)V", "lvsConfig", "Lcom/component/dxtoy/core/toy/bean/ToyLvsInfoBean;", "getLvsConfig$core_release", "()Lcom/component/dxtoy/core/toy/bean/ToyLvsInfoBean;", "setLvsConfig$core_release", "(Lcom/component/dxtoy/core/toy/bean/ToyLvsInfoBean;)V", "otherAppConnectState", "getOtherAppConnectState", "setOtherAppConnectState", "reconnectCount", "getReconnectCount", "setReconnectCount", "reconnectTime", "", "getReconnectTime", "()J", "setReconnectTime", "(J)V", "rmId", "getRmId", "setRmId", "rssi", "getRssi", "setRssi", "updateTime", "getUpdateTime", "setUpdateTime", "setLvsData", "", "data", "", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class nb0 extends mb0 {

    @Ignore
    public transient int b;

    @Ignore
    public transient int c;

    @Nullable
    private String formApp;

    @Ignore
    public transient int g;

    @Ignore
    public transient long h;
    private boolean isUIInMyToyList;

    @Ignore
    @Nullable
    public transient ToyLvsInfoBean j;

    @Nullable
    private String rmId;
    private long updateTime;
    private boolean isLedOpen = true;
    private int ledColor = 7;
    private int otherAppConnectState = -1;

    @Ignore
    public transient boolean d = true;

    @Ignore
    @NotNull
    public transient pb0 e = pb0.NOT_INIT;

    @Ignore
    @NotNull
    public transient sb0 f = sb0.NOT_CONNECT;

    @Ignore
    @NotNull
    public transient ob0 i = ob0.NORMAL;

    /* renamed from: A, reason: from getter */
    public final int getC() {
        return this.c;
    }

    @NotNull
    /* renamed from: B, reason: from getter */
    public final ob0 getI() {
        return this.i;
    }

    @NotNull
    /* renamed from: C, reason: from getter */
    public final sb0 getF() {
        return this.f;
    }

    @Nullable
    /* renamed from: D, reason: from getter */
    public final String getFormApp() {
        return this.formApp;
    }

    /* renamed from: E, reason: from getter */
    public final int getLedColor() {
        return this.ledColor;
    }

    @NotNull
    /* renamed from: F, reason: from getter */
    public final pb0 getE() {
        return this.e;
    }

    @Nullable
    /* renamed from: G, reason: from getter */
    public final ToyLvsInfoBean getJ() {
        return this.j;
    }

    /* renamed from: H, reason: from getter */
    public final int getOtherAppConnectState() {
        return this.otherAppConnectState;
    }

    /* renamed from: J, reason: from getter */
    public final int getG() {
        return this.g;
    }

    /* renamed from: K, reason: from getter */
    public final long getH() {
        return this.h;
    }

    /* renamed from: L, reason: from getter */
    public final int getB() {
        return this.b;
    }

    /* renamed from: M, reason: from getter */
    public final long getUpdateTime() {
        return this.updateTime;
    }

    /* renamed from: N, reason: from getter */
    public final boolean getIsLedOpen() {
        return this.isLedOpen;
    }

    /* renamed from: P, reason: from getter */
    public final boolean getD() {
        return this.d;
    }

    /* renamed from: Q, reason: from getter */
    public final boolean getIsUIInMyToyList() {
        return this.isUIInMyToyList;
    }

    public final void R(int i) {
        this.c = i;
    }

    public final void S(@NotNull ob0 ob0Var) {
        Intrinsics.checkNotNullParameter(ob0Var, "<set-?>");
        this.i = ob0Var;
    }

    public final void T(@NotNull sb0 sb0Var) {
        Intrinsics.checkNotNullParameter(sb0Var, "<set-?>");
        this.f = sb0Var;
    }

    public final void U(@Nullable String str) {
        this.formApp = str;
    }

    public final void W(int i) {
        this.ledColor = i;
    }

    public final void X(boolean z) {
        this.isLedOpen = z;
    }

    public final void Y(@NotNull pb0 pb0Var) {
        Intrinsics.checkNotNullParameter(pb0Var, "<set-?>");
        this.e = pb0Var;
    }

    public final void Z(@NotNull byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ToyLvsInfoBean toyLvsInfoBean = this.j;
        if (Arrays.equals(toyLvsInfoBean != null ? toyLvsInfoBean.getLvsData() : null, data)) {
            return;
        }
        this.j = new ToyLvsInfoBean(data);
    }

    public final void a0(int i) {
        this.otherAppConnectState = i;
    }

    public final void b0(int i) {
        this.g = i;
    }

    public final void c0(long j) {
        this.h = j;
    }

    public final void d0(@Nullable String str) {
        this.rmId = str;
    }

    public final void e0(boolean z) {
        this.d = z;
    }

    public final void f0(int i) {
        this.b = i;
    }

    public final void g0(boolean z) {
        this.isUIInMyToyList = z;
    }

    public final void h0(long j) {
        this.updateTime = j;
    }
}
