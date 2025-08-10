package dc;

import com.wear.bean.StrengthBean;
import com.wear.bean.Toy;
import dc.ToyControlBuilder;
import dc.j30;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: SolaceProControlUtil.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\"\u0010\u000f\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\"\u0010\u000f\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0014\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0016\u0010\u0015\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017J<\u0010\u0018\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u0012J \u0010\u001e\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/wear/main/toy/solacepro/SolaceProControlUtil;", "", "()V", "siteRange", "Lkotlin/ranges/IntRange;", "calculateStrength", "", "deviceId", "", "motorV", "calculateTranslate", "convertPosition", "toy", "Lcom/wear/bean/Toy;", "siteV", "fSetSite", "", "isPosition", "", MultipleAddresses.Address.ELEMENT, "getStroke", "sendPattern", "cmdByteArray", "", "setSpeed", "speedV", "minPosition", "maxPosition", "isTranslate", "isStrength", "setStroke", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class dk2 {

    @NotNull
    public static final dk2 a = new dk2();

    @NotNull
    public static final IntRange b = new IntRange(0, 20);

    public final int a(String str, int i) {
        if (str == null || i <= 0) {
            return i;
        }
        StrengthBean strengthBeanC = vu1.a.c(str);
        StrengthBean.Data data = strengthBeanC != null ? strengthBeanC.getData() : null;
        return (int) Math.ceil((((data != null ? data.getT() : null) == null ? 100 : r0.intValue()) / 100) * i);
    }

    public final int b(int i) {
        return i > 0 ? RangesKt___RangesKt.coerceAtLeast((b.getLast() * i) / 100, 1) : i;
    }

    public final int c(Toy toy, int i) {
        fk2 fk2Var = fk2.a;
        int iE = fk2Var.e(toy.getDeviceId());
        return i <= 0 ? iE : pu1.a(i, 0, 100, iE, fk2Var.d(toy.getDeviceId()));
    }

    public final void d(@Nullable Toy toy, int i, boolean z) {
        if (!(toy != null && toy.isBAToy())) {
            de0.l("Only SolacePro can support set site cmd");
            return;
        }
        if (mp1.a.b()) {
            rq1 rq1Var = rq1.d;
            String address = toy.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "toy.address");
            rq1Var.n(address, qb0.POSITION.getRawValue(), String.valueOf(i), new ToyControlBuilder(ToyControlBuilder.a.POSITION));
            return;
        }
        if (z) {
            i = c(toy, i);
        }
        int iCoerceAtMost = RangesKt___RangesKt.coerceAtMost(i, 100);
        de0.l("address:" + toy.getAddress() + " , FSetSite:" + iCoerceAtMost);
        pc1 pc1Var = pc1.a;
        String address2 = toy.getAddress();
        Intrinsics.checkNotNullExpressionValue(address2, "toy.address");
        pc1Var.e(address2, "FSetSite:" + iCoerceAtMost + ';');
    }

    public final void e(@Nullable String str, int i, boolean z) {
        if ((str == null || str.length() == 0) || i < 0) {
            return;
        }
        d(pc1.a.Q(str), i, z);
    }

    public final void f(@Nullable Toy toy) {
        if (toy != null && toy.isBAToy()) {
            de0.l("address:" + toy.getAddress() + " ,GetStroke;");
            if (mp1.a.b()) {
                j30.a aVar = j30.a;
                String address = toy.getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "toy.address");
                aVar.c(address);
                return;
            }
            pc1 pc1Var = pc1.a;
            String address2 = toy.getAddress();
            Intrinsics.checkNotNullExpressionValue(address2, "toy.address");
            pc1Var.e(address2, "GetStroke;");
        }
    }

    public final void g(@NotNull Toy toy, @NotNull byte[] cmdByteArray) {
        Intrinsics.checkNotNullParameter(toy, "toy");
        Intrinsics.checkNotNullParameter(cmdByteArray, "cmdByteArray");
        if (cmdByteArray.length == 0) {
            de0.l("SolacePro send pattern's value is empty");
            return;
        }
        if (!toy.isBAToy()) {
            de0.l("The toy of " + toy.getAddress() + " is not SolacePro");
            return;
        }
        pc1 pc1Var = pc1.a;
        String address = toy.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "toy.address");
        String strA = qd0.a(cmdByteArray);
        Intrinsics.checkNotNullExpressionValue(strA, "bytes2HexString(cmdByteArray)");
        pc1Var.e(address, strA);
        StringBuilder sb = new StringBuilder();
        sb.append("AA CMD 111: ");
        sb.append(qd0.a(cmdByteArray));
        sb.append(" \n");
        String string = Arrays.toString(cmdByteArray);
        Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
        sb.append(string);
        de0.l(sb.toString());
    }

    public final void h(@Nullable String str, int i, int i2, int i3, boolean z, boolean z2) {
        int i4;
        int i5;
        if ((str == null || str.length() == 0) || i < 0) {
            return;
        }
        pc1 pc1Var = pc1.a;
        Toy toyQ = pc1Var.Q(str);
        if (!(toyQ != null && toyQ.isBAToy())) {
            de0.l("Only SolacePro can support set speed cmd");
            return;
        }
        if (i2 > 0 && i3 > 0) {
            if (i2 > i3) {
                i5 = i2;
                i4 = i3;
            } else {
                i4 = i2;
                i5 = i3;
            }
            if (Math.abs(i3 - i2) < 4) {
                de0.l("maxPosit - minPosit < 3 , is not support!");
                return;
            } else {
                i2 = i4;
                i3 = i5;
            }
        }
        if (mp1.a.b()) {
            Map<String, Integer> mapMutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(qb0.THRUSTING.getRawValue(), Integer.valueOf(i)), TuplesKt.to(qb0.STROKE_START.getRawValue(), Integer.valueOf(i2)), TuplesKt.to(qb0.STROKE_END.getRawValue(), Integer.valueOf(i3)));
            de0.i("address:" + toyQ.getAddress() + " , setSpeed:" + mapMutableMapOf);
            rq1 rq1Var = rq1.d;
            String address = toyQ.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "toy.address");
            rq1Var.b(address, mapMutableMapOf, new ToyControlBuilder(z, z2, false, ToyControlBuilder.a.SPEED, 4, null));
            return;
        }
        if (i2 < 0) {
            i2 = 255;
        }
        if (i3 < 0) {
            i3 = 255;
        }
        if (z2) {
            i = a(toyQ.getDeviceId(), i);
        }
        if (z) {
            i = b(i);
        }
        int iCoerceAtMost = RangesKt___RangesKt.coerceAtMost(i, 20);
        de0.l("address:" + str + " , LVS:" + iCoerceAtMost + ',' + i2 + ',' + i3 + ';');
        StringBuilder sb = new StringBuilder();
        sb.append("LVS:");
        sb.append(iCoerceAtMost);
        sb.append(',');
        sb.append(i2);
        sb.append(',');
        sb.append(i3);
        sb.append(';');
        pc1Var.e(str, sb.toString());
    }

    public final void j(@Nullable Toy toy, int i, int i2) {
        if (toy != null && toy.isBAToy()) {
            de0.l("address:" + toy.getAddress() + " ,SetStroke:" + i + ':' + i2 + ';');
            if (mp1.a.b()) {
                j30.a aVar = j30.a;
                String address = toy.getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "toy.address");
                aVar.d(address, i, i2);
                return;
            }
            pc1 pc1Var = pc1.a;
            String address2 = toy.getAddress();
            Intrinsics.checkNotNullExpressionValue(address2, "toy.address");
            pc1Var.e(address2, "SetStroke:" + i + ':' + i2 + ';');
        }
    }
}
