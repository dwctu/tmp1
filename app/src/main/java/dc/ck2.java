package dc;

import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.wear.bean.Toy;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: PatternPlayerManager.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J$\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u001c\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/wear/main/toy/solacepro/PatternPlayerManager;", "", "()V", "patternPlayerHash", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/wear/main/toy/solacepro/pattern/SolaceProPatternPlayer;", "continuePlay", "", "toyAddress", "initDataAndPlay", "toy", "Lcom/wear/bean/Toy;", "cmdList", "", "", "isRange100", "", "insertData", "pausePlay", "stopAndRelease", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ck2 {

    @NotNull
    public static final b b = new b(null);

    @NotNull
    public static final Lazy<ck2> c = LazyKt__LazyJVMKt.lazy(a.a);

    @NotNull
    public final ConcurrentHashMap<String, ik2> a = new ConcurrentHashMap<>();

    /* compiled from: PatternPlayerManager.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/main/toy/solacepro/PatternPlayerManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<ck2> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ck2 invoke() {
            return new ck2();
        }
    }

    /* compiled from: PatternPlayerManager.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R!\u0010\u0005\u001a\u00020\u00068FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/wear/main/toy/solacepro/PatternPlayerManager$Companion;", "", "()V", "BATCH_SIZE", "", DefaultSettingsSpiCall.INSTANCE_PARAM, "Lcom/wear/main/toy/solacepro/PatternPlayerManager;", "getInstance$annotations", "getInstance", "()Lcom/wear/main/toy/solacepro/PatternPlayerManager;", "instance$delegate", "Lkotlin/Lazy;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ck2 a() {
            return (ck2) ck2.c.getValue();
        }
    }

    @NotNull
    public static final ck2 b() {
        return b.a();
    }

    public final void c(@NotNull Toy toy, @NotNull List<Integer> cmdList, boolean z) {
        Intrinsics.checkNotNullParameter(toy, "toy");
        Intrinsics.checkNotNullParameter(cmdList, "cmdList");
        if (!toy.isBAToy() || cmdList.isEmpty()) {
            return;
        }
        de0.v("zbf", "init data and play , data size = " + cmdList.size());
        de0.v("zbf", "data = " + CollectionsKt___CollectionsKt.joinToString$default(cmdList, ",", null, null, 0, null, null, 62, null));
        ik2 ik2VarRemove = this.a.remove(toy.getAddress());
        if (ik2VarRemove != null) {
            ik2VarRemove.j();
            ik2VarRemove.f();
        }
        kk2 kk2Var = new kk2(30, z);
        kk2Var.d(cmdList);
        ik2 ik2Var = new ik2(kk2Var, toy);
        ConcurrentHashMap<String, ik2> concurrentHashMap = this.a;
        String address = toy.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "toy.address");
        concurrentHashMap.put(address, ik2Var);
        ik2Var.i();
    }

    public final void d(@NotNull String toyAddress, @NotNull List<Integer> cmdList) {
        ik2 ik2Var;
        kk2 a2;
        Intrinsics.checkNotNullParameter(toyAddress, "toyAddress");
        Intrinsics.checkNotNullParameter(cmdList, "cmdList");
        if (cmdList.isEmpty() || (ik2Var = this.a.get(toyAddress)) == null || (a2 = ik2Var.getA()) == null) {
            return;
        }
        a2.d(cmdList);
    }

    public final void e(@NotNull String toyAddress) {
        Intrinsics.checkNotNullParameter(toyAddress, "toyAddress");
        ik2 ik2VarRemove = this.a.remove(toyAddress);
        if (ik2VarRemove != null) {
            ik2VarRemove.j();
            ik2VarRemove.f();
        }
    }
}
