package dc;

import com.wear.bean.Toy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* compiled from: NewBtData.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011H\u0016J\u0018\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0013j\b\u0012\u0004\u0012\u00020\u000f`\u0014H\u0016J\u0018\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0013j\b\u0012\u0004\u0012\u00020\u000f`\u0014H\u0016J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u0018\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0013j\b\u0012\u0004\u0012\u00020\u000f`\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u001f"}, d2 = {"Lcom/wear/component/dxtoy/bluetooth/data/NewBtData;", "Lcom/wear/component/dxtoy/bluetooth/data/IBtData;", "()V", "connectToyMap", "Lcom/wear/component/dxtoy/bluetooth/data/NewBtData$SynchronizedMap;", "getConnectToyMap", "()Lcom/wear/component/dxtoy/bluetooth/data/NewBtData$SynchronizedMap;", "connectToyMap$delegate", "Lkotlin/Lazy;", "scanToyMap", "getScanToyMap", "scanToyMap$delegate", "getNowLinkedToysMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/wear/bean/Toy;", "getNowToyAddress", "", "getNowToys", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getNowToysSelectedList", "getSearchLinkToyMap", "getSearchToy", MultipleAddresses.Address.ELEMENT, "getSearchToys", "removeAllSearchToys", "", "removeSearchToy", "toy", "SynchronizedMap", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class xp1 implements up1 {

    @NotNull
    public final Lazy a = LazyKt__LazyJVMKt.lazy(b.a);

    @NotNull
    public final Lazy b = LazyKt__LazyJVMKt.lazy(c.a);

    /* compiled from: NewBtData.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0001¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/wear/component/dxtoy/bluetooth/data/NewBtData$SynchronizedMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/wear/bean/Toy;", "internalMap", "Lcom/component/dxtoy/core/toy/ToyInfo;", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "isSynchronize", "", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/util/concurrent/locks/ReentrantLock;", "clear", "", "put", "key", "value", DiscoverItems.Item.REMOVE_ACTION, "synchronizeMaps", "synchronizeToyInfo", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends ConcurrentHashMap<String, Toy> {

        @NotNull
        private final ConcurrentHashMap<String, nb0> internalMap;
        private boolean isSynchronize;

        @NotNull
        private final ReentrantLock lock;

        public a(@NotNull ConcurrentHashMap<String, nb0> internalMap) {
            Intrinsics.checkNotNullParameter(internalMap, "internalMap");
            this.internalMap = internalMap;
            this.lock = new ReentrantLock();
        }

        public /* bridge */ boolean a(String str) {
            return super.containsKey(str);
        }

        public /* bridge */ boolean b(Toy toy) {
            return super.containsValue(toy);
        }

        public /* bridge */ Toy c(String str) {
            return (Toy) super.get(str);
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (!this.isSynchronize) {
                    this.internalMap.clear();
                }
                super.clear();
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof String) {
                return a((String) obj);
            }
            return false;
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof Toy) {
                return b((Toy) obj);
            }
            return false;
        }

        public /* bridge */ Set<Map.Entry<String, Toy>> d() {
            return super.entrySet();
        }

        public /* bridge */ Set<String> e() {
            return super.keySet();
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, Toy>> entrySet() {
            return d();
        }

        public /* bridge */ Toy f(String str, Toy toy) {
            return (Toy) super.getOrDefault(str, toy);
        }

        public /* bridge */ int g() {
            return super.size();
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof String) {
                return c((String) obj);
            }
            return null;
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof String) ? obj2 : f((String) obj, (Toy) obj2);
        }

        public /* bridge */ Collection<Toy> h() {
            return super.values();
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        @Nullable
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Toy put(@NotNull String key, @NotNull Toy value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                nb0 nb0VarI3 = value.toyProxy.I3();
                if (nb0VarI3 != null) {
                    this.internalMap.put(key, nb0VarI3);
                }
                return (Toy) super.put(key, value);
            } finally {
                reentrantLock.unlock();
            }
        }

        @Nullable
        public Toy j(@NotNull String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                this.internalMap.remove(key);
                return (Toy) super.remove(key);
            } finally {
                reentrantLock.unlock();
            }
        }

        public /* bridge */ boolean k(String str, Toy toy) {
            return super.remove(str, toy);
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return e();
        }

        @NotNull
        public final ConcurrentHashMap<String, Toy> l() {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                this.isSynchronize = true;
                ConcurrentHashMap<String, Toy> concurrentHashMapM = m();
                clear();
                putAll(concurrentHashMapM);
                this.isSynchronize = false;
                return this;
            } finally {
                reentrantLock.unlock();
            }
        }

        public final ConcurrentHashMap<String, Toy> m() {
            Unit unit;
            ConcurrentHashMap<String, Toy> concurrentHashMap = new ConcurrentHashMap<>();
            for (Map.Entry<String, nb0> entry : this.internalMap.entrySet()) {
                Toy toy = (Toy) get(entry.getKey());
                if (toy != null) {
                    toy.toyProxy.M3(entry.getValue());
                    String key = entry.getKey();
                    Intrinsics.checkNotNullExpressionValue(toy, "toy");
                    concurrentHashMap.put(key, toy);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    concurrentHashMap.put(entry.getKey(), new Toy(entry.getValue()));
                }
            }
            return concurrentHashMap;
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof String) {
                return j((String) obj);
            }
            return null;
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return g();
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<Toy> values() {
            return h();
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof String) && (obj2 instanceof Toy)) {
                return k((String) obj, (Toy) obj2);
            }
            return false;
        }
    }

    /* compiled from: NewBtData.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/component/dxtoy/bluetooth/data/NewBtData$SynchronizedMap;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<a> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a invoke() {
            return new a(yb0.f());
        }
    }

    /* compiled from: NewBtData.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/component/dxtoy/bluetooth/data/NewBtData$SynchronizedMap;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<a> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a invoke() {
            return new a(yb0.g());
        }
    }

    public final a a() {
        return (a) this.a.getValue();
    }

    public final a b() {
        return (a) this.b.getValue();
    }

    @Override // dc.wp1
    @NotNull
    public ConcurrentHashMap<String, Toy> d() {
        a aVarB = b();
        aVarB.l();
        return aVarB;
    }

    @Override // dc.vp1
    @NotNull
    public ConcurrentHashMap<String, Toy> g() {
        a aVarA = a();
        aVarA.l();
        return aVarA;
    }

    @Override // dc.wp1
    public void h() {
        d().clear();
    }

    @Override // dc.vp1
    @NotNull
    public List<String> m() {
        return new ArrayList(g().keySet());
    }

    @Override // dc.wp1
    @Nullable
    public Toy n(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return d().get(address);
    }

    @Override // dc.vp1
    @NotNull
    public ArrayList<Toy> o() {
        return new ArrayList<>(g().values());
    }

    @Override // dc.vp1
    @NotNull
    public ArrayList<Toy> p() {
        Collection<Toy> collectionValues = g().values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "getNowLinkedToysMap().values");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((Toy) obj).isSelect()) {
                arrayList.add(obj);
            }
        }
        return new ArrayList<>(arrayList);
    }

    @Override // dc.wp1
    @NotNull
    public ArrayList<Toy> q() {
        return new ArrayList<>(d().values());
    }

    @Override // dc.wp1
    public void s(@NotNull Toy toy) {
        Intrinsics.checkNotNullParameter(toy, "toy");
        d().remove(toy.getAddress());
    }
}
