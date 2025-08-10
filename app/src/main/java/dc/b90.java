package dc;

import com.component.dxtoy.core.commandcore.bean.ToyCommandBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyCommandCode.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0010\u0006\u001a\u00020\u0007\"\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020!H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR!\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0011j\b\u0012\u0004\u0012\u00020\b`\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lcom/component/dxtoy/command/code/ToyCommandCode;", "Lcom/component/dxtoy/core/commandcore/bean/ToyCommandBean;", "commandConstant", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "mac", "", "args", "", "", "(Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;Ljava/lang/String;[I)V", "getCommandConstant", "()Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "getMac", "()Ljava/lang/String;", "tag", "getTag", "tempValueArray", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTempValueArray", "()Ljava/util/ArrayList;", "valueRanges", "", "Lkotlin/ranges/IntRange;", "getValueRanges", "()Ljava/util/List;", "setValueRanges", "(Ljava/util/List;)V", "getToy", "Lcom/component/dxtoy/core/toy/ToyInfo;", "send", "", "verifyValues", "", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public class b90 extends ToyCommandBean {

    @NotNull
    public final la0 a;

    @NotNull
    public final String b;

    @Nullable
    public final String c;

    @NotNull
    public final ArrayList<Integer> d;

    @NotNull
    public List<IntRange> e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b90(@NotNull la0 commandConstant, @NotNull String mac, @NotNull int... args) {
        super(mac, commandConstant);
        Intrinsics.checkNotNullParameter(commandConstant, "commandConstant");
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(args, "args");
        this.a = commandConstant;
        this.b = mac;
        this.c = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.d = arrayList;
        arrayList.addAll(ArraysKt___ArraysJvmKt.asList(args));
        this.e = CollectionsKt__CollectionsKt.listOf((Object[]) new IntRange[]{new IntRange(0, 20), new IntRange(0, 300)});
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getC() {
        return this.c;
    }

    @NotNull
    public final ArrayList<Integer> b() {
        return this.d;
    }

    @Nullable
    public final nb0 c() {
        return hb0.a.e().get(getB());
    }

    @NotNull
    public final List<IntRange> d() {
        return this.e;
    }

    public final void e() {
        b00.a.f(this);
    }

    public final void f(@NotNull List<IntRange> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.e = list;
    }

    public boolean g() {
        if (this.d.isEmpty()) {
            return true;
        }
        if (this.d.size() > this.e.size()) {
            onError(mt.ILLEGAL_ARGUMENT, "values size can not over ranges size");
            return false;
        }
        Iterator<Integer> it = this.d.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            if (!this.e.get(i).contains(it.next().intValue())) {
                onError(mt.ILLEGAL_ARGUMENT, "invalidValue, values is over ranges");
                return false;
            }
            i = i2;
        }
        ArrayList<Integer> arrayList = this.d;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        Iterator<T> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(String.valueOf(((Number) it2.next()).intValue()));
        }
        String[] strArr = (String[]) arrayList2.toArray(new String[0]);
        setValues(Arrays.copyOf(strArr, strArr.length));
        return true;
    }

    @Override // com.component.dxtoy.core.commandcore.bean.ToyCommandBean, com.component.dxtoy.core.commandcore.bean.BaseToyCommandBean
    @NotNull
    /* renamed from: getCommandConstant, reason: from getter */
    public la0 getA() {
        return this.a;
    }

    @Override // com.component.dxtoy.core.commandcore.bean.ToyCommandBean
    @NotNull
    /* renamed from: getMac, reason: from getter */
    public String getB() {
        return this.b;
    }
}
