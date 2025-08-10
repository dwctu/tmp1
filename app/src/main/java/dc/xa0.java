package dc;

import androidx.core.app.NotificationCompat;
import com.component.dxtoy.core.commandcore.bean.ToyCommandBean;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: ToyCommandQueueSchedule.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/component/dxtoy/core/commandcore/queue/ToyCommandQueueSchedule;", "Lcom/component/dxtoy/core/api/schedule/base/BaseCoroutineScopeLoop;", "()V", "getLoopDelayTime", "", "loopBody", "", "Companion", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class xa0 extends r90 {

    @NotNull
    public static final a c = new a(null);

    /* compiled from: ToyCommandQueueSchedule.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/component/dxtoy/core/commandcore/queue/ToyCommandQueueSchedule$Companion;", "", "()V", "sendCommand", "", "command", "Lcom/component/dxtoy/core/commandcore/bean/ToyCommandBean;", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleWriteResponse;", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull ToyCommandBean command, @Nullable fw fwVar) {
            Intrinsics.checkNotNullParameter(command, "command");
            String command2 = command.getCommand();
            if (command.getIsLongCommand()) {
                if (!command.isAA()) {
                    ia0.a.f().d(command.getB(), command2, fwVar, command.isWaitCallback());
                    return;
                }
                ka0 ka0VarF = ia0.a.f();
                String b = command.getB();
                byte[] bArrG = qd0.g(command2);
                Intrinsics.checkNotNullExpressionValue(bArrG, "hexString2Bytes(commandCode)");
                ka0VarF.c(b, bArrG, fwVar, command.isWaitCallback());
                return;
            }
            if (!command.isLVS() && !command.isFLVS()) {
                ia0.a.f().b(command.getB(), command2, fwVar, command.isWaitCallback());
                return;
            }
            ka0 ka0VarF2 = ia0.a.f();
            String b2 = command.getB();
            byte[] bArrG2 = qd0.g(command2);
            Intrinsics.checkNotNullExpressionValue(bArrG2, "hexString2Bytes(commandCode)");
            ka0VarF2.c(b2, bArrG2, fwVar, command.isWaitCallback());
        }
    }

    /* compiled from: ToyCommandQueueSchedule.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/component/dxtoy/core/commandcore/queue/ToyCommandQueueSchedule$loopBody$1$1$1", "Lcom/component/dxbluetooth/lib/response/BleWriteResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "", "(Lcom/component/dxbluetooth/lib/data/BleEum$Result;Ljava/lang/Integer;)V", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements fw {
        public final /* synthetic */ Ref.ObjectRef<ToyCommandBean> a;

        public b(Ref.ObjectRef<ToyCommandBean> objectRef) {
            this.a = objectRef;
        }

        @Override // dc.qt
        public void b(@NotNull mt code, @Nullable String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            this.a.element.onError(code, str);
        }

        @Override // dc.qt
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull mt code, @Nullable Integer num) {
            Intrinsics.checkNotNullParameter(code, "code");
            this.a.element.onResponse(code, num);
        }
    }

    public xa0() {
        super(xz3.a(n04.b()));
    }

    @Override // dc.r90
    public long a() {
        return 100L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [T, com.component.dxtoy.core.commandcore.bean.ToyCommandBean] */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, com.component.dxtoy.core.commandcore.bean.ToyCommandBean] */
    @Override // dc.r90
    public void b() {
        ia0 ia0Var = ia0.a;
        synchronized (ia0Var.d().getA()) {
            for (Map.Entry<String, LinkedList<ToyCommandBean>> entry : ia0Var.d().h().entrySet()) {
                String key = entry.getKey();
                LinkedList<ToyCommandBean> value = entry.getValue();
                if (value.size() > 0) {
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    ?? B = bb0.a.b(key, value);
                    objectRef.element = B;
                    ?? F = za0.a.f((ToyCommandBean) B, value);
                    objectRef.element = F;
                    if (!ab0.a.c((ToyCommandBean) F)) {
                        ia0.a.d().a((ToyCommandBean) objectRef.element);
                        if (!cb0.a.d((ToyCommandBean) objectRef.element)) {
                            c.a((ToyCommandBean) objectRef.element, new b(objectRef));
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
