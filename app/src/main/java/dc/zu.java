package dc;

import android.content.Context;
import android.content.Intent;
import androidx.core.os.EnvironmentCompat;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: BluetoothStateReceiver.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/component/dxbluetooth/lib/receiver/BluetoothStateReceiver;", "Lcom/component/dxbluetooth/lib/receiver/BaseBleReceiver;", "dispatcher", "Lcom/component/dxbluetooth/lib/receiver/listener/IReceiverDispatcher;", "(Lcom/component/dxbluetooth/lib/receiver/listener/IReceiverDispatcher;)V", "actionList", "", "", "getActionList", "()Ljava/util/List;", "actionList$delegate", "Lkotlin/Lazy;", "getStateString", "state", "", "onBluetoothStateChanged", "", "previousState", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class zu extends vu {

    @NotNull
    public static final a c = new a(null);

    @NotNull
    public final Lazy b;

    /* compiled from: BluetoothStateReceiver.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/component/dxbluetooth/lib/receiver/BluetoothStateReceiver$Companion;", "", "()V", "newInstance", "Lcom/component/dxbluetooth/lib/receiver/BluetoothStateReceiver;", "dispatcher", "Lcom/component/dxbluetooth/lib/receiver/listener/IReceiverDispatcher;", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final zu a(@NotNull fv dispatcher) {
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            return new zu(dispatcher);
        }
    }

    /* compiled from: BluetoothStateReceiver.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class b extends Lambda implements Function0<List<? extends String>> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final List<? extends String> invoke() {
            return CollectionsKt__CollectionsJVMKt.listOf("android.bluetooth.adapter.action.STATE_CHANGED");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zu(@NotNull fv dispatcher) {
        super(dispatcher);
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.b = LazyKt__LazyJVMKt.lazy(b.a);
    }

    public static final void h(ev listener, int i, int i2) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.c(i, i2);
    }

    @Override // dc.vu
    @NotNull
    public List<String> b() {
        return (List) this.b.getValue();
    }

    @Override // dc.vu
    public boolean d(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
        int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 0);
        rw.a.d("state changed: " + e(intExtra2) + " -> " + e(intExtra));
        g(intExtra2, intExtra);
        return true;
    }

    public final String e(int i) {
        switch (i) {
            case 10:
                return "state_off";
            case 11:
                return "state_turning_on";
            case 12:
                return "state_on";
            case 13:
                return "state_turning_off";
            default:
                return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    public final void g(final int i, final int i2) {
        Iterator<av> it = c(ev.class).iterator();
        while (it.hasNext()) {
            final ev evVar = (ev) it.next();
            se0.f(new Runnable() { // from class: dc.uu
                @Override // java.lang.Runnable
                public final void run() {
                    zu.h(evVar, i, i2);
                }
            });
        }
    }
}
