package com.component.dxbluetooth.lib.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.component.dxbluetooth.lib.receiver.BleReceiver;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dc.av;
import dc.fv;
import dc.rw;
import dc.sw;
import dc.vu;
import dc.wu;
import dc.xu;
import dc.yu;
import dc.zu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.iqregister.packet.Registration;

/* compiled from: BleReceiver.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010\u0013H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR/\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00120\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\t\u001a\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lcom/component/dxbluetooth/lib/receiver/BleReceiver;", "Landroid/content/BroadcastReceiver;", "Lcom/component/dxbluetooth/lib/receiver/listener/IBleReceiver;", "()V", "dispatcher", "Lcom/component/dxbluetooth/lib/receiver/listener/IReceiverDispatcher;", "getDispatcher", "()Lcom/component/dxbluetooth/lib/receiver/listener/IReceiverDispatcher;", "dispatcher$delegate", "Lkotlin/Lazy;", "intentFilter", "Landroid/content/IntentFilter;", "getIntentFilter", "()Landroid/content/IntentFilter;", "intentFilter$delegate", "listenerMap", "", "", "", "Lcom/component/dxbluetooth/lib/receiver/listener/BaseBleReceiverListener;", "getListenerMap", "()Ljava/util/Map;", "listenerMap$delegate", "receiverArray", "", "Lcom/component/dxbluetooth/lib/receiver/BaseBleReceiver;", "getReceiverArray", "()[Lcom/component/dxbluetooth/lib/receiver/BaseBleReceiver;", "receiverArray$delegate", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", Registration.Feature.ELEMENT, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BleReceiver extends BroadcastReceiver {

    @NotNull
    public static final BleReceiver a;

    @NotNull
    public static final Lazy b;

    @NotNull
    public static final Lazy c;

    @NotNull
    public static final Lazy d;

    @NotNull
    public static final Lazy e;

    /* compiled from: BleReceiver.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxbluetooth/lib/receiver/listener/IReceiverDispatcher;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function0<fv> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        public static final List b(Class clazz) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            return (List) BleReceiver.a.f().get(clazz.getSimpleName());
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final fv invoke() {
            return new fv() { // from class: dc.su
                @Override // dc.fv
                public final List a(Class cls) {
                    return BleReceiver.a.b(cls);
                }
            };
        }
    }

    /* compiled from: BleReceiver.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/content/IntentFilter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class b extends Lambda implements Function0<IntentFilter> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IntentFilter invoke() {
            IntentFilter intentFilter = new IntentFilter();
            vu[] vuVarArrG = BleReceiver.a.g();
            int length = vuVarArrG.length;
            int i = 0;
            while (i < length) {
                vu vuVar = vuVarArrG[i];
                i++;
                Iterator<String> it = vuVar.b().iterator();
                while (it.hasNext()) {
                    intentFilter.addAction(it.next());
                }
            }
            return intentFilter;
        }
    }

    /* compiled from: BleReceiver.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a.\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00030\u0001j\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003`\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Ljava/util/HashMap;", "", "", "Lcom/component/dxbluetooth/lib/receiver/listener/BaseBleReceiverListener;", "Lkotlin/collections/HashMap;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class c extends Lambda implements Function0<HashMap<String, List<av>>> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final HashMap<String, List<av>> invoke() {
            return new HashMap<>();
        }
    }

    /* compiled from: BleReceiver.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lcom/component/dxbluetooth/lib/receiver/BaseBleReceiver;", "invoke", "()[Lcom/component/dxbluetooth/lib/receiver/BaseBleReceiver;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class d extends Lambda implements Function0<vu[]> {
        public static final d a = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final vu[] invoke() {
            zu.a aVar = zu.c;
            BleReceiver bleReceiver = BleReceiver.a;
            return new vu[]{aVar.a(bleReceiver.d()), yu.c.a(bleReceiver.d()), xu.c.a(bleReceiver.d()), wu.c.a(bleReceiver.d())};
        }
    }

    static {
        BleReceiver bleReceiver = new BleReceiver();
        a = bleReceiver;
        b = LazyKt__LazyJVMKt.lazy(c.a);
        c = LazyKt__LazyJVMKt.lazy(a.a);
        d = LazyKt__LazyJVMKt.lazy(d.a);
        e = LazyKt__LazyJVMKt.lazy(b.a);
        sw.a.j(bleReceiver, bleReceiver.e());
    }

    private BleReceiver() {
    }

    public final fv d() {
        return (fv) c.getValue();
    }

    public final IntentFilter e() {
        return (IntentFilter) e.getValue();
    }

    public final Map<String, List<av>> f() {
        return (Map) b.getValue();
    }

    public final vu[] g() {
        return (vu[]) d.getValue();
    }

    public synchronized void h(@Nullable av avVar) {
        if (avVar != null) {
            List<av> linkedList = f().get(avVar.getName());
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                f().put(avVar.getName(), linkedList);
            }
            linkedList.add(avVar);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @Nullable Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        int i = 0;
        if (action == null || action.length() == 0) {
            return;
        }
        rw.a.d(Intrinsics.stringPlus("BluetoothReceiver onReceive: ", action));
        vu[] vuVarArrG = g();
        int length = vuVarArrG.length;
        while (i < length) {
            vu vuVar = vuVarArrG[i];
            i++;
            if (vuVar.a(action) && vuVar.d(context, intent)) {
                return;
            }
        }
    }
}
