package dc;

import com.epicgames.unreal.psoservices.PSOProgramService;
import com.wear.bean.Toy;
import com.wear.bean.ToyBean;
import com.wear.main.longDistance.control.LDRControl;
import com.wear.protocol.EntityToy;
import com.wear.util.WearUtils;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: ReceiveManage.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/wear/ui/chat/manager/ReceiveManage;", "", "()V", "ischick", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getIschick", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setIschick", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "receive", "", "entityData", "Lcom/wear/protocol/EntityToy;", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class it2 {

    @NotNull
    public static final b b = new b(null);

    @NotNull
    public static final Lazy<it2> c = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) a.a);

    @NotNull
    public AtomicBoolean a = new AtomicBoolean(false);

    /* compiled from: ReceiveManage.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/ui/chat/manager/ReceiveManage;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<it2> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final it2 invoke() {
            return new it2();
        }
    }

    /* compiled from: ReceiveManage.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/wear/ui/chat/manager/ReceiveManage$Companion;", "", "()V", "sIntance", "Lcom/wear/ui/chat/manager/ReceiveManage;", "getSIntance", "()Lcom/wear/ui/chat/manager/ReceiveManage;", "sIntance$delegate", "Lkotlin/Lazy;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final it2 a() {
            return (it2) it2.c.getValue();
        }
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final AtomicBoolean getA() {
        return this.a;
    }

    public final void c(@NotNull EntityToy entityData) {
        ToyBean all;
        int v;
        Intrinsics.checkNotNullParameter(entityData, "entityData");
        if (na2.m().i()) {
            if (entityData.getToyOPTType() == EntityToy.ToyOPTType.all) {
                LDRControl lDRControlO = na2.m().o();
                if (lDRControlO == null || !lDRControlO.e) {
                    ToyBean all2 = entityData.getAll();
                    if (all2 != null) {
                        if (all2.getV() == -1 && all2.getV1() != -1) {
                            all2.setV(all2.getV1());
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(all2.getV());
                        sb.append(' ');
                        sb.append(all2.getR());
                        sb.append(' ');
                        sb.append(all2.getP());
                        sb.append(' ');
                        sb.append(all2.getT());
                        sb.append(' ');
                        sb.append(all2.getS());
                        sb.append(' ');
                        sb.append(all2.getF());
                        xe3.a("ToyCommanMsg", sb.toString());
                        int t = all2.getT();
                        if (entityData.getVersion() == 0) {
                            t = all2.getV();
                        }
                        int i = t;
                        int s = all2.getS();
                        if (entityData.getVersion() < 2) {
                            s = all2.getV();
                        }
                        na2.m().s(all2.getV(), all2.getR(), all2.getP(), i, s, all2.getF(), all2.getD(), all2.getPos());
                    }
                } else {
                    if (entityData.getAll() == null) {
                        all = du3.e().p(entityData);
                        v = all.getV();
                    } else {
                        all = entityData.getAll();
                        v = entityData.getAll().getV();
                    }
                    na2.m().y(null, all, false);
                    if (lDRControlO.h != null && !lDRControlO.c.isSupportLDRFillOrder()) {
                        Iterator<Toy> it = lDRControlO.a.iterator();
                        while (it.hasNext()) {
                            Toy next = it.next();
                            String toyFunction = Toy.getToyFunction(next.getType());
                            if (!WearUtils.e1(next.getType()) && next.isSupportV1V2()) {
                                toyFunction = PSOProgramService.VS_Key;
                            }
                            entityData.addLdrId(next.getAndUpdateDeviceId(), toyFunction, v);
                        }
                        entityData.setCate(EntityToy.ToyOPTType.all.toString());
                    }
                }
            }
            ou3.l(entityData, false);
        }
    }
}
