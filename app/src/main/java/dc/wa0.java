package dc;

import com.component.dxtoy.core.commandcore.bean.ToyCommandBean;
import dc.db0;
import dc.za0;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.aspectj.lang.JoinPoint;
import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandQueue.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007J\u0006\u0010\u001c\u001a\u00020\u0018J\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0005J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0007R-\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0011\u0010\f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R-\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0015\u0010\t¨\u0006\""}, d2 = {"Lcom/component/dxtoy/core/commandcore/queue/ToyCommandQueue;", "", "()V", "alreadySendCommandMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/LinkedList;", "Lcom/component/dxtoy/core/commandcore/bean/ToyCommandBean;", "getAlreadySendCommandMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "alreadySendCommandMap$delegate", "Lkotlin/Lazy;", JoinPoint.SYNCHRONIZATION_LOCK, "getLock", "()Ljava/lang/Object;", "schedule", "Lcom/component/dxtoy/core/commandcore/queue/ToyCommandQueueSchedule;", "getSchedule", "()Lcom/component/dxtoy/core/commandcore/queue/ToyCommandQueueSchedule;", "schedule$delegate", "waitSendCommandMap", "getWaitSendCommandMap", "waitSendCommandMap$delegate", "addAlreadySendCommand", "", "commandBean", "addCommand", "addCommandByResend", "cancelAll", "mac", "onMessageEvent", "event", "Lcom/component/dxtoy/core/api/event/ToyConnectEvent;", "Companion", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class wa0 {

    @NotNull
    public final Object a = new Object();

    @NotNull
    public final Lazy b = LazyKt__LazyJVMKt.lazy(c.a);

    @NotNull
    public final Lazy c = LazyKt__LazyJVMKt.lazy(a.a);

    @NotNull
    public final Lazy d = LazyKt__LazyJVMKt.lazy(b.a);

    /* compiled from: ToyCommandQueue.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/LinkedList;", "Lcom/component/dxtoy/core/commandcore/bean/ToyCommandBean;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<ConcurrentHashMap<String, LinkedList<ToyCommandBean>>> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ConcurrentHashMap<String, LinkedList<ToyCommandBean>> invoke() {
            return new ConcurrentHashMap<>();
        }
    }

    /* compiled from: ToyCommandQueue.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/queue/ToyCommandQueueSchedule;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<xa0> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final xa0 invoke() {
            return new xa0();
        }
    }

    /* compiled from: ToyCommandQueue.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/LinkedList;", "Lcom/component/dxtoy/core/commandcore/bean/ToyCommandBean;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<ConcurrentHashMap<String, LinkedList<ToyCommandBean>>> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ConcurrentHashMap<String, LinkedList<ToyCommandBean>> invoke() {
            return new ConcurrentHashMap<>();
        }
    }

    public wa0() {
        g().c();
        wb0.a.b(this);
    }

    public final void a(@NotNull ToyCommandBean commandBean) {
        Intrinsics.checkNotNullParameter(commandBean, "commandBean");
        synchronized (this.a) {
            commandBean.setSendTime();
            if (e().get(commandBean.getB()) == null) {
                e().put(commandBean.getB(), new LinkedList<>());
            }
            LinkedList<ToyCommandBean> linkedList = e().get(commandBean.getB());
            if (linkedList != null) {
                if (linkedList.size() >= 100) {
                    linkedList.remove(0);
                }
                linkedList.add(commandBean);
            }
        }
    }

    public final void b(@NotNull ToyCommandBean commandBean) {
        Intrinsics.checkNotNullParameter(commandBean, "commandBean");
        synchronized (this.a) {
            ya0.a.a(commandBean);
            fb0.a.e(commandBean);
            if (h().get(commandBean.getB()) == null) {
                h().put(commandBean.getB(), new LinkedList<>());
            }
            eb0.a.i(commandBean);
            LinkedList<ToyCommandBean> it = h().get(commandBean.getB());
            if (it != null) {
                db0.a aVar = db0.a;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                aVar.b(commandBean, it);
            }
            LinkedList<ToyCommandBean> it2 = h().get(commandBean.getB());
            if (it2 != null) {
                za0.a aVar2 = za0.a;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                aVar2.d(commandBean, it2);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void c(@NotNull ToyCommandBean commandBean) {
        Intrinsics.checkNotNullParameter(commandBean, "commandBean");
        synchronized (this.a) {
            LinkedList<ToyCommandBean> linkedList = e().get(commandBean.getB());
            if (linkedList != null) {
                linkedList.remove(commandBean);
            }
            eb0.a.i(commandBean);
            LinkedList<ToyCommandBean> it = h().get(commandBean.getB());
            if (it != null) {
                db0.a aVar = db0.a;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                aVar.b(commandBean, it);
            }
            LinkedList<ToyCommandBean> it2 = h().get(commandBean.getB());
            if (it2 != null) {
                za0.a aVar2 = za0.a;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                aVar2.d(commandBean, it2);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void d(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        synchronized (this.a) {
            LinkedList<ToyCommandBean> linkedList = h().get(mac);
            if (linkedList != null) {
                linkedList.clear();
            }
            LinkedList<ToyCommandBean> linkedList2 = e().get(mac);
            if (linkedList2 != null) {
                linkedList2.clear();
            }
            ba0.a.a(mac, 2);
            Unit unit = Unit.INSTANCE;
        }
    }

    @NotNull
    public final ConcurrentHashMap<String, LinkedList<ToyCommandBean>> e() {
        return (ConcurrentHashMap) this.c.getValue();
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final Object getA() {
        return this.a;
    }

    public final xa0 g() {
        return (xa0) this.d.getValue();
    }

    @NotNull
    public final ConcurrentHashMap<String, LinkedList<ToyCommandBean>> h() {
        return (ConcurrentHashMap) this.b.getValue();
    }

    @Subscribe
    public final void onMessageEvent(@NotNull i90 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getB() == sb0.NOT_CONNECT) {
            d(event.getA());
        }
    }
}
