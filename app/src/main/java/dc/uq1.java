package dc;

import com.wear.bean.B64Common;
import com.wear.bean.Toy;
import dc.ToyControlBuilder;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyControlB64.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/component/dxtoy/command/control/business/ToyControlB64;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class uq1 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyControlB64.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/wear/component/dxtoy/command/control/business/ToyControlB64$Companion;", "", "()V", "sendCommand", "", "cmdBean", "Lcom/wear/bean/B64Common$AllBean;", "toy", "Lcom/wear/bean/Toy;", "Lcom/wear/bean/B64Common$IdBean;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull B64Common.AllBean cmdBean) {
            Intrinsics.checkNotNullParameter(cmdBean, "cmdBean");
            HashMap map = new HashMap();
            map.put(qb0.VIBRATE.getRawValue(), Integer.valueOf(cmdBean.getV()));
            map.put(qb0.VIBRATE1.getRawValue(), Integer.valueOf(cmdBean.getV1()));
            map.put(qb0.VIBRATE2.getRawValue(), Integer.valueOf(cmdBean.getV2()));
            map.put(qb0.VIBRATE3.getRawValue(), Integer.valueOf(cmdBean.getV3()));
            map.put(qb0.ROTATE.getRawValue(), Integer.valueOf(cmdBean.getR()));
            map.put(qb0.SUCK.getRawValue(), Integer.valueOf(cmdBean.getS()));
            map.put(qb0.PUMP.getRawValue(), Integer.valueOf(cmdBean.getP()));
            map.put(qb0.THRUSTING.getRawValue(), Integer.valueOf(cmdBean.getT()));
            map.put(qb0.FINGERING.getRawValue(), Integer.valueOf(cmdBean.getF()));
            rq1.d.c(map, new ToyControlBuilder(ToyControlBuilder.a.SPEED));
        }

        @JvmStatic
        public final void b(@NotNull Toy toy, @NotNull B64Common.IdBean cmdBean) {
            Intrinsics.checkNotNullParameter(toy, "toy");
            Intrinsics.checkNotNullParameter(cmdBean, "cmdBean");
            HashMap map = new HashMap();
            map.put(qb0.VIBRATE.getRawValue(), Integer.valueOf(cmdBean.getV()));
            map.put(qb0.VIBRATE1.getRawValue(), Integer.valueOf(cmdBean.getV1()));
            map.put(qb0.VIBRATE2.getRawValue(), Integer.valueOf(cmdBean.getV2()));
            map.put(qb0.VIBRATE3.getRawValue(), Integer.valueOf(cmdBean.getV3()));
            map.put(qb0.ROTATE.getRawValue(), Integer.valueOf(cmdBean.getR()));
            map.put(qb0.SUCK.getRawValue(), Integer.valueOf(cmdBean.getS()));
            map.put(qb0.PUMP.getRawValue(), Integer.valueOf(cmdBean.getP()));
            map.put(qb0.THRUSTING.getRawValue(), Integer.valueOf(cmdBean.getT()));
            map.put(qb0.FINGERING.getRawValue(), Integer.valueOf(cmdBean.getF()));
            rq1 rq1Var = rq1.d;
            String address = toy.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "toy.address");
            rq1Var.b(address, map, new ToyControlBuilder(ToyControlBuilder.a.SPEED));
        }
    }

    @JvmStatic
    public static final void a(@NotNull B64Common.AllBean allBean) {
        a.a(allBean);
    }

    @JvmStatic
    public static final void b(@NotNull Toy toy, @NotNull B64Common.IdBean idBean) {
        a.b(toy, idBean);
    }
}
