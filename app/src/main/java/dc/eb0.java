package dc;

import com.component.dxtoy.core.commandcore.bean.BaseToyCommandBean;
import com.component.dxtoy.core.commandcore.bean.ToyCommandBean;
import dc.oa0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandTagStrategy.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxtoy/core/commandcore/strategy/ToyCommandTagStrategy;", "", "()V", "Companion", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class eb0 {

    @NotNull
    public static final a a = new a(null);

    @NotNull
    public static volatile Map<String, Integer> b = new LinkedHashMap();

    /* compiled from: ToyCommandTagStrategy.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tJ \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u001c\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\t0\u00182\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\t0\u00182\u0006\u0010\u001a\u001a\u00020\tJ\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u000e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J0\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\t0!2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010#\u001a\u00020\"J\u0016\u0010$\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tJ\u0012\u0010%\u001a\u00020\u0019*\u00020&2\u0006\u0010\u001a\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006'"}, d2 = {"Lcom/component/dxtoy/core/commandcore/strategy/ToyCommandTagStrategy$Companion;", "", "()V", "COMMAND_LENGTH", "", "TAG_NUMBER_MAX", "TAG_NUMBER_NULL", "tagNumberMap", "", "", "getTagNumberMap", "()Ljava/util/Map;", "setTagNumberMap", "(Ljava/util/Map;)V", "addOne", "tagNumber", "addTagNumber", "mac", "tag", "addTagStr", "", "bean", "Lcom/component/dxtoy/core/commandcore/bean/ToyCommandBean;", "checkTag", "Lkotlin/Pair;", "", "command", "checkTagSuffix", "getTagNumber", "initTagHandle", "isIgnoreNumber", "number", "maybeTagReceiveHandle", "Lkotlin/Triple;", "", "bytes", "removeCmdTag", "checkCmdLengthWithTag", "Lcom/component/dxtoy/core/commandcore/bean/BaseToyCommandBean;", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(int i) {
            if (i == 255) {
                i = 0;
            }
            int i2 = i + 1;
            return j(i2) ? a(i2) : i2;
        }

        public final synchronized int b(@NotNull String mac, @NotNull String tag) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(tag, "tag");
            if (tag.length() > 0) {
                return 0;
            }
            int iA = a(g(mac));
            h().put(mac, Integer.valueOf(iA));
            return iA;
        }

        public final void c(ToyCommandBean toyCommandBean, int i, String str) {
            if (toyCommandBean.getTagNumber() != 0) {
                toyCommandBean.setTagStr(String.valueOf((char) i));
                return;
            }
            if (str.length() > 0) {
                toyCommandBean.setTagStr(str);
            }
        }

        public final boolean d(@NotNull BaseToyCommandBean baseToyCommandBean, @NotNull String command) {
            Intrinsics.checkNotNullParameter(baseToyCommandBean, "<this>");
            Intrinsics.checkNotNullParameter(command, "command");
            return (command.length() + baseToyCommandBean.getTagStr().length()) + 1 > 20;
        }

        public final Pair<Boolean, String> e(ToyCommandBean toyCommandBean) {
            if (toyCommandBean.getIsLongCommand()) {
                return new Pair<>(Boolean.FALSE, "");
            }
            for (oa0 oa0Var : toyCommandBean.getSendTypeList$core_release()) {
                if (oa0Var instanceof oa0.e) {
                    oa0.e eVar = (oa0.e) oa0Var;
                    return new Pair<>(Boolean.valueOf(eVar.getA()), eVar.getB());
                }
            }
            return new Pair<>(Boolean.FALSE, "");
        }

        @NotNull
        public final Pair<Boolean, String> f(@NotNull String command) {
            String strRemoveSuffix;
            Intrinsics.checkNotNullParameter(command, "command");
            List listSplit$default = StringsKt__StringsKt.split$default((CharSequence) command, new String[]{","}, false, 0, 6, (Object) null);
            boolean z = true;
            if (listSplit$default.size() > 1) {
                strRemoveSuffix = StringsKt__StringsKt.removeSuffix(StringsKt__StringsKt.removeSuffix((String) listSplit$default.get(listSplit$default.size() - 1), (CharSequence) ";"), (CharSequence) ";");
            } else {
                z = false;
                strRemoveSuffix = "";
            }
            return new Pair<>(Boolean.valueOf(z), strRemoveSuffix);
        }

        public final int g(String str) {
            Integer num = h().get(str);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }

        @NotNull
        public final Map<String, Integer> h() {
            return eb0.b;
        }

        public final void i(@NotNull ToyCommandBean bean) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            Pair<Boolean, String> pairE = e(bean);
            boolean zBooleanValue = pairE.component1().booleanValue();
            String strComponent2 = pairE.component2();
            if (zBooleanValue) {
                a aVar = eb0.a;
                int iB = aVar.b(bean.getB(), strComponent2);
                bean.setTagNumber$core_release(iB);
                aVar.c(bean, iB, strComponent2);
            }
        }

        public final boolean j(int i) {
            return i == 44 || i == 59 || i == 58 || i == 32 || i == 0 || i == 10;
        }

        @NotNull
        public final Triple<String, byte[], String> k(@NotNull String mac, @NotNull String command, @NotNull byte[] bytes) {
            String command2;
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(command, "command");
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            String str = "";
            Pair<Boolean, String> pairF = f(command);
            boolean zBooleanValue = pairF.component1().booleanValue();
            String strComponent2 = pairF.component2();
            if (zBooleanValue) {
                ia0 ia0Var = ia0.a;
                synchronized (ia0Var.d().getA()) {
                    LinkedList<ToyCommandBean> linkedList = ia0Var.d().e().get(mac);
                    if (linkedList != null) {
                        Iterator<ToyCommandBean> itDescendingIterator = linkedList.descendingIterator();
                        while (true) {
                            if (!itDescendingIterator.hasNext()) {
                                break;
                            }
                            ToyCommandBean next = itDescendingIterator.next();
                            if (Intrinsics.areEqual(next.getTagStr(), strComponent2)) {
                                if (next.getTagNumber() != 0) {
                                    command = eb0.a.l(command, strComponent2);
                                    bytes = command.getBytes(Charsets.UTF_8);
                                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                                    command2 = next.getCommandByHeadValues();
                                } else {
                                    command2 = next.getCommand();
                                }
                                str = command2;
                                next.setReceiveCommand(command, next.getTagNumber());
                                de0.i("maybeTagReceiveHandle tag = " + next.getTagStr());
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
            return new Triple<>(command, bytes, str);
        }

        @NotNull
        public final String l(@NotNull String command, @NotNull String tag) {
            Intrinsics.checkNotNullParameter(command, "command");
            Intrinsics.checkNotNullParameter(tag, "tag");
            StringBuilder sb = new StringBuilder();
            sb.append(StringsKt__StringsKt.removeSuffix(StringsKt__StringsKt.removeSuffix(StringsKt__StringsKt.removeSuffix(command, (CharSequence) ";"), (CharSequence) ";"), (CharSequence) (',' + tag)));
            sb.append(';');
            return sb.toString();
        }
    }
}
