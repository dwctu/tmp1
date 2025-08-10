package dc;

import com.component.dxtoy.core.commandcore.bean.ToyCommandBean;
import dc.oa0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandDiscardStrategy.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxtoy/core/commandcore/strategy/ToyCommandDiscardStrategy;", "", "()V", "Companion", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class za0 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyCommandDiscardStrategy.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u001c\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0006J\u001c\u0010\u0011\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e¨\u0006\u0012"}, d2 = {"Lcom/component/dxtoy/core/commandcore/strategy/ToyCommandDiscardStrategy$Companion;", "", "()V", "arrangeLVSCommand", "", "curCommand", "Lcom/component/dxtoy/core/commandcore/bean/ToyCommandBean;", "nextCommand", "arrangeMultiplyCommand", "canDeleteCurCommand", "", "inDiscardStrategy", "bean", "beanList", "", "isDiscardCommand", "command", "outDiscardStrategy", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {

        /* compiled from: ToyCommandDiscardStrategy.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "defaultValue", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: dc.za0$a$a, reason: collision with other inner class name */
        public static final class C0233a extends Lambda implements Function2<Object, Object, Boolean> {
            public static final C0233a a = new C0233a();

            public C0233a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(@NotNull Object it, @NotNull Object defaultValue) {
                Intrinsics.checkNotNullParameter(it, "it");
                Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
                return Boolean.valueOf((it instanceof Byte) && Intrinsics.areEqual(it, defaultValue));
            }
        }

        /* compiled from: ToyCommandDiscardStrategy.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "defaultValue", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class b extends Lambda implements Function2<Object, Object, Boolean> {
            public static final b a = new b();

            public b() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(@NotNull Object it, @NotNull Object defaultValue) {
                Intrinsics.checkNotNullParameter(it, "it");
                Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
                return Boolean.valueOf((it instanceof String) && Intrinsics.areEqual(it, defaultValue));
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(ToyCommandBean toyCommandBean, ToyCommandBean toyCommandBean2) {
            Object obj = toyCommandBean.getValueList().get(0);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.ByteArray");
            byte[] bArr = (byte[]) obj;
            Object obj2 = toyCommandBean2.getValueList().get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.ByteArray");
            byte[] bArr2 = (byte[]) obj2;
            int iMax = Math.max(bArr.length, bArr2.length);
            C0233a c0233a = C0233a.a;
            IntRange intRangeUntil = RangesKt___RangesKt.until(0, iMax);
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator<Integer> it = intRangeUntil.iterator();
            while (it.hasNext()) {
                int iNextInt = ((IntIterator) it).nextInt();
                byte b2 = (iNextInt < 0 || iNextInt > ArraysKt___ArraysKt.getLastIndex(bArr)) ? (byte) -1 : bArr[iNextInt];
                byte b3 = (iNextInt < 0 || iNextInt > ArraysKt___ArraysKt.getLastIndex(bArr2)) ? (byte) -1 : bArr2[iNextInt];
                if (c0233a.invoke(Byte.valueOf(b2), (byte) -1).booleanValue() || !c0233a.invoke(Byte.valueOf(b3), (byte) -1).booleanValue()) {
                    b2 = b3;
                }
                arrayList.add(Byte.valueOf(b2));
            }
            toyCommandBean2.getValueList().clear();
            toyCommandBean2.getValueList().add(CollectionsKt___CollectionsKt.toByteArray(arrayList));
        }

        public final void b(ToyCommandBean toyCommandBean, ToyCommandBean toyCommandBean2) {
            List<Object> valueList = toyCommandBean.getValueList();
            List<Object> valueList2 = toyCommandBean2.getValueList();
            int iMax = Math.max(valueList.size(), valueList2.size());
            b bVar = b.a;
            IntRange intRangeUntil = RangesKt___RangesKt.until(0, iMax);
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator<Integer> it = intRangeUntil.iterator();
            while (it.hasNext()) {
                int iNextInt = ((IntIterator) it).nextInt();
                Object obj = (iNextInt < 0 || iNextInt > CollectionsKt__CollectionsKt.getLastIndex(valueList)) ? "-1" : valueList.get(iNextInt);
                Object obj2 = (iNextInt < 0 || iNextInt > CollectionsKt__CollectionsKt.getLastIndex(valueList2)) ? "-1" : valueList2.get(iNextInt);
                if (bVar.invoke(obj, "-1").booleanValue() || !bVar.invoke(obj2, "-1").booleanValue()) {
                    obj = obj2;
                }
                arrayList.add(obj);
            }
            toyCommandBean2.getValueList().clear();
            toyCommandBean2.getValueList().addAll(arrayList);
        }

        public final boolean c(@NotNull ToyCommandBean curCommand, @NotNull ToyCommandBean nextCommand) {
            Intrinsics.checkNotNullParameter(curCommand, "curCommand");
            Intrinsics.checkNotNullParameter(nextCommand, "nextCommand");
            boolean z = false;
            if (e(curCommand) && e(nextCommand) && Intrinsics.areEqual(curCommand.getCommandConstant(), nextCommand.getCommandConstant())) {
                z = true;
                if (nextCommand.isMply() || nextCommand.isMultiply()) {
                    if (nextCommand.getIsAllMultiSupport()) {
                        return true;
                    }
                    b(curCommand, nextCommand);
                    fb0.a.b(nextCommand);
                } else if (nextCommand.isLVS() || nextCommand.isFLVS()) {
                    if (nextCommand.getIsAllMultiSupport()) {
                        return true;
                    }
                    a(curCommand, nextCommand);
                    fb0.a.a(nextCommand);
                }
            }
            return z;
        }

        public final void d(@NotNull ToyCommandBean bean, @NotNull List<ToyCommandBean> beanList) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            Intrinsics.checkNotNullParameter(beanList, "beanList");
            if (e(bean)) {
                LinkedList linkedList = new LinkedList();
                for (ToyCommandBean toyCommandBean : beanList) {
                    if (!Intrinsics.areEqual(bean, toyCommandBean) && za0.a.c(toyCommandBean, bean)) {
                        linkedList.add(toyCommandBean);
                    }
                }
                beanList.removeAll(linkedList);
            }
        }

        public final boolean e(@NotNull ToyCommandBean command) {
            Intrinsics.checkNotNullParameter(command, "command");
            for (oa0 oa0Var : command.getSendTypeList$core_release()) {
                if (oa0Var instanceof oa0.a) {
                    return ((oa0.a) oa0Var).getA();
                }
            }
            return false;
        }

        @NotNull
        public final ToyCommandBean f(@NotNull ToyCommandBean bean, @NotNull List<ToyCommandBean> beanList) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            Intrinsics.checkNotNullParameter(beanList, "beanList");
            if (!e(bean)) {
                return bean;
            }
            LinkedList linkedList = new LinkedList();
            for (ToyCommandBean toyCommandBean : beanList) {
                if (!Intrinsics.areEqual(bean, toyCommandBean) && za0.a.c(bean, toyCommandBean)) {
                    linkedList.add(toyCommandBean);
                    bean = toyCommandBean;
                }
            }
            beanList.removeAll(linkedList);
            return bean;
        }
    }
}
