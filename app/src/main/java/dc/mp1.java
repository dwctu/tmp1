package dc;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.component.dxtoy.data.bean.OuterToyData;
import com.wear.bean.Toy;
import com.wear.bean.ToyType;
import com.wear.dao.DaoUtils;
import com.wear.util.WearUtils;
import dc.g90;
import dc.jp1;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyInit.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\u0006\u0010\u0007\u001a\u00020\u0004J\b\u0010\b\u001a\u00020\u0004H\u0002¨\u0006\n"}, d2 = {"Lcom/wear/component/dxtoy/ToyInit;", "", "()V", "exportToyData", "", "importToyData", "init", "initToyConfig", "setToyConfig", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class mp1 {

    @NotNull
    public static final b a = new b(null);
    public static final boolean b = sx.k("toy_components", false);

    @NotNull
    public static final Lazy<Boolean> c = LazyKt__LazyJVMKt.lazy(a.a);

    /* compiled from: ToyInit.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<Boolean> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            jp1.a aVar = jp1.a;
            return Boolean.valueOf((aVar.a("sp_key_feature_config_switch") || !gd0.i()) ? mp1.a.a() : aVar.a("sp_key_toy_switch") && gd0.i());
        }
    }

    /* compiled from: ToyInit.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0007R!\u0010\b\u001a\u00020\u00068FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\b\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/wear/component/dxtoy/ToyInit$Companion;", "", "()V", "NEW_TOY", "", "isNewToyFromConfig", "", "()Z", "isUseNew", "isUseNew$annotations", "isUseNew$delegate", "Lkotlin/Lazy;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return mp1.b;
        }

        public final boolean b() {
            return ((Boolean) mp1.c.getValue()).booleanValue();
        }
    }

    /* compiled from: ToyInit.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/wear/component/dxtoy/ToyInit$init$1", "Lcom/component/dxtoy/core/api/engine/IToyAppEngine;", "isPingCodeIntercept", "", "mac", "", "uuid", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements g90 {
        @Override // dc.g90
        public boolean a(@NotNull String mac, @Nullable String str) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            return pp1.e(mac, str);
        }

        @Override // dc.g90
        public boolean b() {
            return g90.a.a(this);
        }
    }

    /* compiled from: ToyInit.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<Unit> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            mp1.this.i();
        }
    }

    public static final boolean h() {
        return a.b();
    }

    public final void d() {
        if (ps1.d.n()) {
            de0.i(" ===Has exported Toy Data === ");
            return;
        }
        de0.i(" === Export Toy Data === ");
        List<nb0> listC = jb0.e.c();
        if (!(listC == null || listC.isEmpty())) {
            DaoUtils.getToyDao().clearTable();
            DaoUtils.getToyTypeDao().clearTable();
            for (nb0 nb0Var : listC) {
                if (!nb0Var.getIsUIInMyToyList() || nb0Var.getIsVirtualToy()) {
                    de0.i(" eeee : " + nb0Var.getIsUIInMyToyList() + " nmame:" + nb0Var.e());
                } else {
                    Toy toyA = np1.a(nb0Var);
                    if (toyA != null) {
                        DaoUtils.getToyDao().add(toyA);
                    }
                    DaoUtils.getToyTypeDao().add(np1.b(nb0Var));
                }
            }
        }
        ps1.d.o();
        yb0.b();
        List<ToyType> listFindAll = DaoUtils.getToyTypeDao().findAll();
        List<Toy> listFindAll2 = DaoUtils.getToyDao().findAll();
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("ToyType size = ");
        sb.append(listFindAll != null ? listFindAll.size() : 0);
        objArr[0] = sb.toString();
        de0.i(objArr);
        Object[] objArr2 = new Object[1];
        StringBuilder sb2 = new StringBuilder();
        sb2.append("toyAll size = ");
        sb2.append(listFindAll2 != null ? listFindAll2.size() : 0);
        objArr2[0] = sb2.toString();
        de0.i(objArr2);
    }

    public final void e() {
        LinkedHashMap linkedHashMap;
        OuterToyData outerToyData;
        if (yb0.i()) {
            de0.i(" === Has imported Toy Data === ");
            return;
        }
        List<ToyType> listFindAll = new os1().findAll();
        ArrayList arrayList = null;
        if (listFindAll != null) {
            linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(listFindAll, 10)), 16));
            for (Object obj : listFindAll) {
                linkedHashMap.put(((ToyType) obj).getAddress(), obj);
            }
        } else {
            linkedHashMap = null;
        }
        List<ws1> listFindAll2 = new ns1().findAll();
        if (listFindAll2 != null) {
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listFindAll2, 10));
            for (ws1 ws1Var : listFindAll2) {
                ToyType toyType = linkedHashMap != null ? (ToyType) linkedHashMap.get(ws1Var.getAddress()) : null;
                Integer numN0 = ws1Var.n0();
                Intrinsics.checkNotNullExpressionValue(numN0, "oldToy.ledSetting");
                boolean zBooleanValue = numN0.intValue() >= 1;
                if (Intrinsics.areEqual(ws1Var.getType(), "domi") || Intrinsics.areEqual(ws1Var.getType(), "gemini")) {
                    Boolean autoLightOn = toyType != null ? toyType.getAutoLightOn() : null;
                    if (autoLightOn != null) {
                        Intrinsics.checkNotNullExpressionValue(autoLightOn, "toyType?.autoLightOn ?: isLedOpen");
                        zBooleanValue = autoLightOn.booleanValue();
                    }
                }
                boolean z = zBooleanValue;
                if (TextUtils.isEmpty(ws1Var.d1())) {
                    outerToyData = null;
                } else {
                    String id = ws1Var.getId();
                    String strD1 = ws1Var.d1();
                    Intrinsics.checkNotNullExpressionValue(strD1, "oldToy.uuid");
                    Integer numE1 = ws1Var.e1();
                    Intrinsics.checkNotNullExpressionValue(numE1, "oldToy.version");
                    int iIntValue = numE1.intValue();
                    String address = ws1Var.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address, "oldToy.address");
                    outerToyData = new OuterToyData(id, strD1, iIntValue, address, ws1Var.getDeviceType(), ws1Var.isVirtualToy(), ws1Var.P1(), z, toyType != null ? toyType.getaColor() : 7, ws1Var.getUpdateTime(), ws1Var.getFormApp());
                }
                arrayList2.add(outerToyData);
            }
            arrayList = arrayList2;
        }
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("newToyData size = ");
        sb.append(arrayList != null ? arrayList.size() : -1);
        sb.append("， data = ");
        sb.append(arrayList);
        objArr[0] = sb.toString();
        de0.i(objArr);
        yb0.h(arrayList);
        ps1.d.m();
    }

    @WorkerThread
    public final void f() {
        e();
        g();
        b00.a.d(new c());
        n40.a();
        g30 g30Var = g30.a;
    }

    public final void g() {
        a00.g(WearUtils.v);
        i();
        a00.f(new d());
    }

    public final void i() {
        String strD = a00.d();
        if (strD != null) {
            at1.b.L(strD);
        }
    }
}
