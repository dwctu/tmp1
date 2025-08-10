package dc;

import dc.oa0;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCmdBridgeSend.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\"B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J6\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0002J(\u0010\u0011\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000f\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u000b\u001a\u00020\nJ6\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0002J.\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000fH\u0002J6\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0002J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001c\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\n0\u00182\u0006\u0010\u000b\u001a\u00020\nH\u0002J&\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\nH\u0002J\u0018\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0002J\u0016\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000fH\u0002J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002J$\u0010\u001f\u001a\u00020\u0019*\u00020 2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\nH\u0002J$\u0010!\u001a\u00020\u0019*\u00020 2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\nH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006#"}, d2 = {"Lcom/wear/component/dxtoy/command/common/bridge/ToyCmdBridgeSend;", "", "mode", "Lcom/wear/component/dxtoy/command/common/bridge/ToyCmdBridgeSend$ConvertMode;", "(Lcom/wear/component/dxtoy/command/common/bridge/ToyCmdBridgeSend$ConvertMode;)V", "getMode", "()Lcom/wear/component/dxtoy/command/common/bridge/ToyCmdBridgeSend$ConvertMode;", "cmdConvert", "", "mac", "", "cmd", "cmdConstant", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "valueList", "", "tag", "cmdParser", "Lkotlin/Triple;", "cmdToBean", "cmdToMethod", "cmdToMix", "cmdUnknown", "findCmdTag", "Lkotlin/Pair;", "", "findValueList", "isIgnoreTag", "sendCommand", "valueListHandler", "valueSplit", "checkCmdBeanIllegal", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "checkCmdNotEquals", "ConvertMode", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class mq1 {

    @NotNull
    public final a a;

    /* compiled from: ToyCmdBridgeSend.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/wear/component/dxtoy/command/common/bridge/ToyCmdBridgeSend$ConvertMode;", "", "(Ljava/lang/String;I)V", "METHOD", "BEAN", "MIX", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum a {
        METHOD,
        BEAN,
        MIX
    }

    /* compiled from: ToyCmdBridgeSend.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            iArr[a.MIX.ordinal()] = 1;
            iArr[a.METHOD.ordinal()] = 2;
            iArr[a.BEAN.ordinal()] = 3;
            a = iArr;
        }
    }

    public mq1() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public mq1(@NotNull a mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.a = mode;
    }

    public final boolean a(b90 b90Var, String str, la0 la0Var, String str2) {
        if (!b90Var.g()) {
            kq1.f.b("cmdToBean verifyValues false cmd = " + str + " cmdBean = " + b90Var.getCommand());
            return true;
        }
        if (str2.length() > 0) {
            b90Var.addSendType(new oa0.e(false, str2, 1, null));
            eb0.a.i(b90Var);
        }
        ma0 ma0Var = ma0.a;
        if (!Intrinsics.areEqual(la0Var, ma0Var.r()) && !Intrinsics.areEqual(la0Var, ma0Var.s()) && !Intrinsics.areEqual(la0Var, ma0Var.t()) && !Intrinsics.areEqual(la0Var, ma0Var.j()) && !Intrinsics.areEqual(la0Var, ma0Var.G()) && !Intrinsics.areEqual(la0Var, ma0Var.H()) && !Intrinsics.areEqual(la0Var, ma0Var.B())) {
            pa0 pa0Var = pa0.a;
            if (!Intrinsics.areEqual(la0Var, pa0Var.h()) && !Intrinsics.areEqual(la0Var, pa0Var.o0()) && !Intrinsics.areEqual(la0Var, pa0Var.p0()) && !Intrinsics.areEqual(la0Var, pa0Var.q0()) && !Intrinsics.areEqual(la0Var, pa0Var.r0()) && b(b90Var, str, la0Var, str2)) {
                kq1.f.b("cmdToBean != false cmd = " + str + " cmdBean = " + b90Var.getCommand());
                return true;
            }
        }
        return false;
    }

    public final boolean b(b90 b90Var, String str, la0 la0Var, String str2) {
        String command = b90Var.getCommand();
        if (str2.length() == 0) {
            if (!Intrinsics.areEqual(str, command)) {
                return true;
            }
        } else if (!Intrinsics.areEqual(str, command) && !StringsKt__StringsJVMKt.startsWith$default(str, StringsKt__StringsJVMKt.replace$default(command, ";", "", false, 4, (Object) null), false, 2, null)) {
            return true;
        }
        return false;
    }

    public final void c(String str, String str2, la0 la0Var, List<String> list, String str3) {
        int i = b.a[this.a.ordinal()];
        if (i == 1) {
            g(str, str2, la0Var, list, str3);
        } else if (i == 2) {
            f(str, str2, la0Var, list);
        } else {
            if (i != 3) {
                return;
            }
            e(str, str2, la0Var, list, str3);
        }
    }

    @NotNull
    public final Triple<la0, List<String>, String> d(@NotNull String cmd) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        la0 la0VarB = nq1.b(this, cmd);
        if (la0VarB == null) {
            return new Triple<>(null, CollectionsKt__CollectionsKt.emptyList(), "");
        }
        Pair<Boolean, String> pairI = i(cmd);
        pairI.component1().booleanValue();
        String strComponent2 = pairI.component2();
        return new Triple<>(la0VarB, j(cmd, la0VarB, strComponent2), strComponent2);
    }

    public final void e(String str, String str2, la0 la0Var, List<String> list, String str3) {
        b90 b90VarC = nq1.c(this, la0Var, str, list);
        if (b90VarC == null) {
            h(str, str2);
        } else {
            if (a(b90VarC, str2, la0Var, str3)) {
                return;
            }
            b90VarC.e();
        }
    }

    public final void f(String str, String str2, la0 la0Var, List<String> list) {
        if (nq1.a(this, str, str2, la0Var, list)) {
            return;
        }
        h(str, str2);
    }

    public final void g(String str, String str2, la0 la0Var, List<String> list, String str3) {
        if (str3.length() == 0) {
            f(str, str2, la0Var, list);
        } else {
            e(str, str2, la0Var, list, str3);
        }
    }

    public final void h(String str, String str2) {
        kq1.f.d("unknownLog:\nmac = " + str + "\ncmd = " + str2);
        new q80(str, str2).e();
    }

    public final Pair<Boolean, String> i(String str) {
        Pair<Boolean, String> pairF = eb0.a.f(str);
        boolean zBooleanValue = pairF.component1().booleanValue();
        String strComponent2 = pairF.component2();
        return (!zBooleanValue || k(str, strComponent2)) ? new Pair<>(Boolean.FALSE, "") : new Pair<>(Boolean.TRUE, strComponent2);
    }

    public final List<String> j(String str, la0 la0Var, String str2) {
        int iA;
        if (Intrinsics.areEqual(la0Var.getC(), "%s")) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<String> listM = m(la0Var, d90.c(str, la0Var.c(), str2, n(la0Var)));
        if (!(!listM.isEmpty()) || la0Var.getD() != na0.NORMAL || (iA = jq1.a(la0Var.getC(), "%s")) == listM.size()) {
            return listM;
        }
        kq1.f.b("findValueList: cmd = " + str + " cmdConstant = " + la0Var + " valueCount = " + iA + " valueList = " + listM);
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public final boolean k(String str, String str2) throws NumberFormatException {
        boolean z;
        if (d90.i(str, ma0.a.r().c())) {
            return true;
        }
        int iA = jq1.a(str, ",");
        try {
            Integer.parseInt(str2);
            z = true;
        } catch (NumberFormatException unused) {
            z = false;
        }
        boolean z2 = iA > 1 && z;
        if (z2) {
            kq1.f.b("isIgnoreTag: cmd = " + str + " tag = " + str2);
        }
        return z2;
    }

    public final void l(@NotNull String mac, @NotNull String cmd) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Triple<la0, List<String>, String> tripleD = d(cmd);
        la0 la0VarComponent1 = tripleD.component1();
        List<String> listComponent2 = tripleD.component2();
        String strComponent3 = tripleD.component3();
        if (la0VarComponent1 == null) {
            kq1.f.b("sendCommand: cmd = " + cmd + " cmdConstant is null");
            h(mac, cmd);
            return;
        }
        kq1.f.c("sendLog: mac = " + mac + " cmd = " + cmd + " tag = " + strComponent3, cmd);
        c(mac, cmd, la0VarComponent1, listComponent2, strComponent3);
    }

    public final List<String> m(la0 la0Var, List<String> list) {
        List list2 = list;
        if (Intrinsics.areEqual(la0Var, pa0.a.N())) {
            List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
            boolean z = !mutableList.isEmpty();
            list2 = mutableList;
            if (z) {
                int size = mutableList.size();
                list2 = mutableList;
                if (size > 1) {
                    boolean zContains$default = StringsKt__StringsKt.contains$default((CharSequence) mutableList.get(1), (CharSequence) "/", false, 2, (Object) null);
                    list2 = mutableList;
                    if (zContains$default) {
                        List listSplit$default = StringsKt__StringsKt.split$default((CharSequence) mutableList.get(1), new String[]{"/"}, false, 0, 6, (Object) null);
                        mutableList.set(1, listSplit$default.get(0));
                        mutableList.add(2, listSplit$default.get(1));
                        list2 = mutableList;
                    }
                }
            }
        }
        return list2;
    }

    public final String n(la0 la0Var) {
        return Intrinsics.areEqual(la0Var, ma0.a.r()) ? "," : SignatureImpl.INNER_SEP;
    }

    public /* synthetic */ mq1(a aVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? a.MIX : aVar);
    }
}
