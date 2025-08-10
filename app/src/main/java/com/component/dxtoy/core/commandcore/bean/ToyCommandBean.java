package com.component.dxtoy.core.commandcore.bean;

import androidx.core.app.NotificationCompat;
import dc.de0;
import dc.fw;
import dc.la0;
import dc.mt;
import dc.na0;
import dc.va0;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: ToyCommandBean.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 H2\u00020\u0001:\u0001HB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010:\u001a\u00020\bJ\u0018\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0003J\u001d\u0010@\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\b\u0010A\u001a\u0004\u0018\u00010/¢\u0006\u0002\u0010BJ\u0016\u0010C\u001a\u00020<2\u0006\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020/J\u0006\u0010F\u001a\u00020<J\u0006\u0010G\u001a\u00020<R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R$\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R$\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010 \"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u000f\"\u0004\b'\u0010\u0011R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u000f\"\u0004\b6\u0010\u0011R\u001a\u00107\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u000f\"\u0004\b9\u0010\u0011¨\u0006I"}, d2 = {"Lcom/component/dxtoy/core/commandcore/bean/ToyCommandBean;", "Lcom/component/dxtoy/core/commandcore/bean/BaseToyCommandBean;", "mac", "", "commandConstant", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "(Ljava/lang/String;Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;)V", "_isWaitCallback", "", "Ljava/lang/Boolean;", "getCommandConstant", "()Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "createTime", "", "getCreateTime$core_release", "()J", "setCreateTime$core_release", "(J)V", "isAllMultiSupport", "isAllMultiSupport$core_release", "()Z", "setAllMultiSupport$core_release", "(Z)V", "isLongCommand", "setLongCommand", "value", "isStopCommand", "isStopCommand$core_release", "setStopCommand$core_release", "isWaitCallback", "setWaitCallback", "getMac", "()Ljava/lang/String;", "receiveCommand", "getReceiveCommand$core_release", "setReceiveCommand$core_release", "(Ljava/lang/String;)V", "receiveTime", "getReceiveTime$core_release", "setReceiveTime$core_release", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleWriteResponse;", "getResponse", "()Lcom/component/dxbluetooth/lib/response/BleWriteResponse;", "setResponse", "(Lcom/component/dxbluetooth/lib/response/BleWriteResponse;)V", "sendCount", "", "getSendCount$core_release", "()I", "setSendCount$core_release", "(I)V", "sendResponseTime", "getSendResponseTime$core_release", "setSendResponseTime$core_release", "sendTime", "getSendTime$core_release", "setSendTime$core_release", "isIllegal", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "onResponse", "data", "(Lcom/component/dxbluetooth/lib/data/BleEum$Result;Ljava/lang/Integer;)V", "setReceiveCommand", "command", "tagNumber", "setSendOnResponseTime", "setSendTime", "Companion", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public class ToyCommandBean extends BaseToyCommandBean {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static WeakReference<va0> _responseAll;

    @Nullable
    private Boolean _isWaitCallback;

    @NotNull
    private final la0 commandConstant;
    private long createTime;
    private boolean isAllMultiSupport;
    private boolean isLongCommand;
    private boolean isStopCommand;

    @NotNull
    private final String mac;

    @NotNull
    private String receiveCommand;
    private long receiveTime;

    @Nullable
    private fw response;
    private int sendCount;
    private long sendResponseTime;
    private long sendTime;

    /* compiled from: ToyCommandBean.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/component/dxtoy/core/commandcore/bean/ToyCommandBean$Companion;", "", "()V", "_responseAll", "Ljava/lang/ref/WeakReference;", "Lcom/component/dxtoy/core/commandcore/listenter/IToyCommandBeanAllResponse;", "value", "responseAll", "getResponseAll", "()Lcom/component/dxtoy/core/commandcore/listenter/IToyCommandBeanAllResponse;", "setResponseAll", "(Lcom/component/dxtoy/core/commandcore/listenter/IToyCommandBeanAllResponse;)V", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final va0 getResponseAll() {
            WeakReference weakReference = ToyCommandBean._responseAll;
            if (weakReference != null) {
                return (va0) weakReference.get();
            }
            return null;
        }

        public final void setResponseAll(@Nullable va0 va0Var) {
            ToyCommandBean._responseAll = new WeakReference(va0Var);
        }
    }

    /* compiled from: ToyCommandBean.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[na0.values().length];
            iArr[na0.UNKNOWN.ordinal()] = 1;
            iArr[na0.NORMAL.ordinal()] = 2;
            iArr[na0.CTRL_SINGLE.ordinal()] = 3;
            iArr[na0.CTRL_MULTI.ordinal()] = 4;
            iArr[na0.CTRL_LVS.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToyCommandBean(@NotNull String mac, @NotNull la0 commandConstant) {
        super(commandConstant);
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(commandConstant, "commandConstant");
        this.mac = mac;
        this.commandConstant = commandConstant;
        this.receiveCommand = "";
        this.createTime = System.currentTimeMillis();
    }

    @Override // com.component.dxtoy.core.commandcore.bean.BaseToyCommandBean
    @NotNull
    public la0 getCommandConstant() {
        return this.commandConstant;
    }

    /* renamed from: getCreateTime$core_release, reason: from getter */
    public final long getCreateTime() {
        return this.createTime;
    }

    @NotNull
    public String getMac() {
        return this.mac;
    }

    @NotNull
    /* renamed from: getReceiveCommand$core_release, reason: from getter */
    public final String getReceiveCommand() {
        return this.receiveCommand;
    }

    /* renamed from: getReceiveTime$core_release, reason: from getter */
    public final long getReceiveTime() {
        return this.receiveTime;
    }

    @Nullable
    public final fw getResponse() {
        return this.response;
    }

    /* renamed from: getSendCount$core_release, reason: from getter */
    public final int getSendCount() {
        return this.sendCount;
    }

    /* renamed from: getSendResponseTime$core_release, reason: from getter */
    public final long getSendResponseTime() {
        return this.sendResponseTime;
    }

    /* renamed from: getSendTime$core_release, reason: from getter */
    public final long getSendTime() {
        return this.sendTime;
    }

    /* renamed from: isAllMultiSupport$core_release, reason: from getter */
    public final boolean getIsAllMultiSupport() {
        return this.isAllMultiSupport;
    }

    public final boolean isIllegal() {
        if (getMac().length() == 0) {
            return true;
        }
        if (isMply() || isMultiply() || getLevel() == na0.UNKNOWN || getFormatSize() == getValueList().size()) {
            return false;
        }
        de0.l("ToyCommandBean isIllegal format size = " + getFormatSize() + "  value size = " + getValueList().size() + ' ');
        return true;
    }

    /* renamed from: isLongCommand, reason: from getter */
    public final boolean getIsLongCommand() {
        return this.isLongCommand;
    }

    /* renamed from: isStopCommand$core_release, reason: from getter */
    public final boolean getIsStopCommand() {
        return this.isStopCommand;
    }

    public final synchronized boolean isWaitCallback() {
        Boolean bool;
        Boolean bool2;
        if (this._isWaitCallback == null) {
            int i = WhenMappings.$EnumSwitchMapping$0[getCommandConstant().getD().ordinal()];
            if (i == 1 || i == 2) {
                bool2 = Boolean.TRUE;
            } else {
                if (i != 3 && i != 4 && i != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                bool2 = Boolean.FALSE;
            }
            this._isWaitCallback = bool2;
            Unit unit = Unit.INSTANCE;
        }
        bool = this._isWaitCallback;
        Intrinsics.checkNotNull(bool, "null cannot be cast to non-null type kotlin.Boolean");
        return bool.booleanValue();
    }

    public final void onError(@NotNull mt code, @Nullable String str) {
        Intrinsics.checkNotNullParameter(code, "code");
        fw fwVar = this.response;
        if (fwVar != null) {
            fwVar.b(code, str);
        }
        va0 responseAll = INSTANCE.getResponseAll();
        if (responseAll != null) {
            responseAll.a(getMac(), getCommandByHeadValues(), code, str);
        }
    }

    public final void onResponse(@NotNull mt code, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(code, "code");
        setSendOnResponseTime();
        fw fwVar = this.response;
        if (fwVar != null) {
            fwVar.a(code, num);
        }
        va0 responseAll = INSTANCE.getResponseAll();
        if (responseAll != null) {
            responseAll.b(getMac(), getCommandByHeadValues(), code, num);
        }
    }

    public final void setAllMultiSupport$core_release(boolean z) {
        this.isAllMultiSupport = z;
    }

    public final void setCreateTime$core_release(long j) {
        this.createTime = j;
    }

    public final void setLongCommand(boolean z) {
        this.isLongCommand = z;
    }

    public final void setReceiveCommand(@NotNull String command, int tagNumber) {
        Intrinsics.checkNotNullParameter(command, "command");
        this.receiveTime = System.currentTimeMillis();
        this.receiveCommand = command;
    }

    public final void setReceiveCommand$core_release(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.receiveCommand = str;
    }

    public final void setReceiveTime$core_release(long j) {
        this.receiveTime = j;
    }

    public final void setResponse(@Nullable fw fwVar) {
        this.response = fwVar;
    }

    public final void setSendCount$core_release(int i) {
        this.sendCount = i;
    }

    public final void setSendOnResponseTime() {
        this.sendResponseTime = System.currentTimeMillis();
    }

    public final void setSendResponseTime$core_release(long j) {
        this.sendResponseTime = j;
    }

    public final void setSendTime() {
        this.sendCount++;
        this.sendTime = System.currentTimeMillis();
    }

    public final void setSendTime$core_release(long j) {
        this.sendTime = j;
    }

    public final void setStopCommand$core_release(boolean z) {
        if (z) {
            addSendType(BaseToyCommandBean.INSTANCE.getDefaultResend());
        }
        this.isStopCommand = z;
    }

    public final synchronized void setWaitCallback(boolean z) {
        this._isWaitCallback = Boolean.valueOf(z);
    }
}
