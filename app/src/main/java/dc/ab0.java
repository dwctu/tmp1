package dc;

import com.component.dxtoy.core.commandcore.bean.ToyCommandBean;
import dc.oa0;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandLastSendSameStrategy.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxtoy/core/commandcore/strategy/ToyCommandLastSendSameStrategy;", "", "()V", "Companion", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ab0 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyCommandLastSendSameStrategy.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/component/dxtoy/core/commandcore/strategy/ToyCommandLastSendSameStrategy$Companion;", "", "()V", "checkLastSendSame", "Lkotlin/Pair;", "", "", "command", "Lcom/component/dxtoy/core/commandcore/bean/ToyCommandBean;", "findLastSameConstantCommand", "bean", "isLastSendSameWithTime", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Pair<Boolean, Long> a(ToyCommandBean toyCommandBean) {
            for (oa0 oa0Var : toyCommandBean.getSendTypeList$core_release()) {
                if (oa0Var instanceof oa0.b) {
                    return new Pair<>(Boolean.TRUE, Long.valueOf(((oa0.b) oa0Var).getA()));
                }
            }
            return new Pair<>(Boolean.FALSE, 0L);
        }

        public final ToyCommandBean b(ToyCommandBean toyCommandBean) {
            LinkedList<ToyCommandBean> linkedList = ia0.a.d().e().get(toyCommandBean.getB());
            if (linkedList == null) {
                return null;
            }
            Iterator<ToyCommandBean> itDescendingIterator = linkedList.descendingIterator();
            while (itDescendingIterator.hasNext()) {
                ToyCommandBean next = itDescendingIterator.next();
                if (Intrinsics.areEqual(next.getCommandConstant(), toyCommandBean.getCommandConstant())) {
                    return next;
                }
            }
            return null;
        }

        public final boolean c(@NotNull ToyCommandBean bean) {
            ToyCommandBean toyCommandBeanB;
            Intrinsics.checkNotNullParameter(bean, "bean");
            Pair<Boolean, Long> pairA = a(bean);
            boolean zBooleanValue = pairA.component1().booleanValue();
            long jLongValue = pairA.component2().longValue();
            if (zBooleanValue && (toyCommandBeanB = ab0.a.b(bean)) != null && Intrinsics.areEqual(bean.getCommandByHeadValues(), toyCommandBeanB.getCommandByHeadValues())) {
                long jCurrentTimeMillis = System.currentTimeMillis() - toyCommandBeanB.getSendTime();
                if (0 <= jCurrentTimeMillis && jCurrentTimeMillis <= jLongValue) {
                    return true;
                }
            }
            return false;
        }
    }
}
