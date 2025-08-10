package dc;

import com.epicgames.unreal.psoservices.PSOProgramService;
import dc.lc1;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: ToyControlBusiness.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/component/dxtoy/command/control/business/ToyControlBusiness;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class vq1 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyControlBusiness.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lcom/wear/component/dxtoy/command/control/business/ToyControlBusiness$Companion;", "", "()V", "sendAllToyInStarControl", "", "value", "", "sendAllToyOnSocketEvent", PSOProgramService.VS_Key, StreamManagement.AckRequest.ELEMENT, "p", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(int i) {
            int i2 = i <= 0 ? 0 : i < 6 ? 1 : i < 10 ? 2 : 3;
            if (!mp1.a.b()) {
                lc1.a aVar = lc1.a;
                aVar.b(PSOProgramService.VS_Key, i);
                aVar.b(StreamManagement.AckRequest.ELEMENT, i);
                aVar.b("p", i2);
                return;
            }
            HashMap map = new HashMap();
            map.put(PSOProgramService.VS_Key, Integer.valueOf(i));
            map.put(StreamManagement.AckRequest.ELEMENT, Integer.valueOf(i));
            map.put("p", Integer.valueOf(i2));
            rq1.d.l(map);
        }

        @JvmStatic
        public final void b(int i, int i2, int i3) {
            if (!mp1.a.b()) {
                for (Pair pair : CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(PSOProgramService.VS_Key, Integer.valueOf(i)), TuplesKt.to(StreamManagement.AckRequest.ELEMENT, Integer.valueOf(i2)), TuplesKt.to("p", Integer.valueOf(i3))})) {
                    String str = (String) pair.component1();
                    int iIntValue = ((Number) pair.component2()).intValue();
                    if (iIntValue != -1) {
                        lc1.a.b(str, iIntValue);
                    }
                }
                return;
            }
            HashMap map = new HashMap();
            for (Pair pair2 : CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(PSOProgramService.VS_Key, Integer.valueOf(i)), TuplesKt.to(StreamManagement.AckRequest.ELEMENT, Integer.valueOf(i2)), TuplesKt.to("p", Integer.valueOf(i3))})) {
                String str2 = (String) pair2.component1();
                int iIntValue2 = ((Number) pair2.component2()).intValue();
                if (iIntValue2 != -1) {
                    map.put(str2, Integer.valueOf(iIntValue2));
                }
            }
            rq1.d.l(map);
        }
    }

    @JvmStatic
    public static final void a(int i) {
        a.a(i);
    }

    @JvmStatic
    public static final void b(int i, int i2, int i3) {
        a.b(i, i2, i3);
    }
}
