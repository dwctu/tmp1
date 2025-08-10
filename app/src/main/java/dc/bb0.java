package dc;

import com.component.dxtoy.core.commandcore.bean.ToyCommandBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandPriorityStrategy.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxtoy/core/commandcore/strategy/ToyCommandPriorityStrategy;", "", "()V", "Companion", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class bb0 {

    @NotNull
    public static final b a = new b(null);

    @NotNull
    public static final Lazy<ConcurrentHashMap<String, HashMap<String, Long>>> b = LazyKt__LazyJVMKt.lazy(a.a);

    /* compiled from: ToyCommandPriorityStrategy.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a*\u0012\u0004\u0012\u00020\u0002\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u00050\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<ConcurrentHashMap<String, HashMap<String, Long>>> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ConcurrentHashMap<String, HashMap<String, Long>> invoke() {
            return new ConcurrentHashMap<>();
        }
    }

    /* compiled from: ToyCommandPriorityStrategy.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0002J\u001c\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010J \u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0002J2\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u0006j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e`\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0002RC\u0010\u0003\u001a*\u0012\u0004\u0012\u00020\u0005\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007`\b0\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/component/dxtoy/core/commandcore/strategy/ToyCommandPriorityStrategy$Companion;", "", "()V", "toysSingleHashMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getToysSingleHashMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "toysSingleHashMap$delegate", "Lkotlin/Lazy;", "findCmdBeanByNormal", "Lcom/component/dxtoy/core/commandcore/bean/ToyCommandBean;", "cmdList", "", "findCmdBeanByPriority", "mac", "findCmdBeanBySingle", "getFunctionCmdBeanMap", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ToyCommandBean a(List<ToyCommandBean> list) {
            return list.remove(0);
        }

        @NotNull
        public final ToyCommandBean b(@NotNull String mac, @NotNull List<ToyCommandBean> cmdList) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(cmdList, "cmdList");
            ToyCommandBean toyCommandBean = cmdList.get(0);
            if (toyCommandBean.getCommandConstant().getD() != na0.CTRL_SINGLE || !za0.a.e(toyCommandBean)) {
                return a(cmdList);
            }
            ToyCommandBean toyCommandBeanC = c(mac, cmdList);
            return toyCommandBeanC == null ? a(cmdList) : toyCommandBeanC;
        }

        public final ToyCommandBean c(String str, List<ToyCommandBean> list) {
            Object next;
            HashMap<String, Long> mapPutIfAbsent;
            HashMap<String, ToyCommandBean> mapD = d(list);
            ConcurrentHashMap<String, HashMap<String, Long>> concurrentHashMapE = e();
            HashMap<String, Long> map = concurrentHashMapE.get(str);
            if (map == null && (mapPutIfAbsent = concurrentHashMapE.putIfAbsent(str, (map = new HashMap<>()))) != null) {
                map = mapPutIfAbsent;
            }
            HashMap<String, Long> singleMap = map;
            Iterator<T> it = mapD.entrySet().iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    Long l = singleMap.get((String) ((Map.Entry) next).getKey());
                    if (l == null) {
                        l = 0L;
                    }
                    Intrinsics.checkNotNullExpressionValue(l, "singleMap[key] ?: 0");
                    long jLongValue = l.longValue();
                    do {
                        Object next2 = it.next();
                        Long l2 = singleMap.get((String) ((Map.Entry) next2).getKey());
                        if (l2 == null) {
                            l2 = 0L;
                        }
                        Intrinsics.checkNotNullExpressionValue(l2, "singleMap[key] ?: 0");
                        long jLongValue2 = l2.longValue();
                        if (jLongValue > jLongValue2) {
                            next = next2;
                            jLongValue = jLongValue2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            Map.Entry entry = (Map.Entry) next;
            ToyCommandBean toyCommandBean = entry != null ? (ToyCommandBean) entry.getValue() : null;
            if (toyCommandBean != null) {
                list.remove(toyCommandBean);
                Intrinsics.checkNotNullExpressionValue(singleMap, "singleMap");
                singleMap.put(toyCommandBean.getCommandConstant().getA(), Long.valueOf(System.currentTimeMillis()));
            }
            return toyCommandBean;
        }

        public final HashMap<String, ToyCommandBean> d(List<ToyCommandBean> list) {
            HashMap<String, ToyCommandBean> map = new HashMap<>();
            for (ToyCommandBean toyCommandBean : list) {
                if (toyCommandBean.getCommandConstant().getD() == na0.CTRL_SINGLE && !map.containsKey(toyCommandBean.getCommandConstant().getA()) && za0.a.e(toyCommandBean)) {
                    map.put(toyCommandBean.getCommandConstant().getA(), toyCommandBean);
                }
            }
            return map;
        }

        @NotNull
        public final ConcurrentHashMap<String, HashMap<String, Long>> e() {
            return (ConcurrentHashMap) bb0.b.getValue();
        }
    }
}
