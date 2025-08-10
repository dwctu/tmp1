package dc;

import dc.kq1;
import dc.oa0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyCmdBridgeSend+CmdWhen.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t\u001a\u0014\u0010\n\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u001a*\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t¨\u0006\r"}, d2 = {"cmdToMethodWhen", "", "Lcom/wear/component/dxtoy/command/common/bridge/ToyCmdBridgeSend;", "mac", "", "cmd", "cmdConstant", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "valueList", "", "findCmdConstant", "getCmdBean", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class nq1 {
    public static final boolean a(@NotNull mq1 mq1Var, @NotNull String mac, @NotNull String cmd, @NotNull la0 cmdConstant, @NotNull List<String> valueList) {
        Intrinsics.checkNotNullParameter(mq1Var, "<this>");
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(cmdConstant, "cmdConstant");
        Intrinsics.checkNotNullParameter(valueList, "valueList");
        try {
            pa0 pa0Var = pa0.a;
            if (Intrinsics.areEqual(cmdConstant, pa0Var.k())) {
                b30.b.g(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.j())) {
                y20.b.d(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.O())) {
                g20.b.d(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.f())) {
                u20.a.d(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.r())) {
                e30.b.d(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.k0())) {
                z00.a.e(mac, StringsKt__StringsJVMKt.equals(valueList.get(0), "on", true));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.z())) {
                z00.a.c(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.n())) {
                z00.a.a(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.q())) {
                z00.a.b(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.Z())) {
                z00.a.d(mac, StringsKt__StringsJVMKt.equals(valueList.get(0), "on", true));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.h())) {
                p10.a.a(mac, valueList.get(0));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.X())) {
                p10.a.b(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.e())) {
                c00.a.e(mac, StringsKt__StringsJVMKt.equals(valueList.get(0), "on", true), StringsKt__StringsJVMKt.equals(valueList.get(1), "on", true));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.p())) {
                c00.a.d(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.t())) {
                e00.a.c(mac, Integer.parseInt(valueList.get(0)));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.x())) {
                e00.a.d(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.U())) {
                e00.a.e(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.V())) {
                e00.a.f(mac, Integer.parseInt(valueList.get(0)));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.u())) {
                e00.a.b(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.c0())) {
                e00.a.h(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)), Integer.parseInt(valueList.get(2)), Integer.parseInt(valueList.get(3)));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.c())) {
                e00.a.a(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.d())) {
                e00.a.g(mac, valueList.get(0));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.Q())) {
                k20.a.j(mac, Integer.parseInt(valueList.get(0)), valueList.get(1));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.N())) {
                k20.a.i(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)), Integer.parseInt(valueList.get(2)), valueList.get(3));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.x0())) {
                k20.a.b(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.z0())) {
                k20.a.c(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.y0())) {
                k20.a.g(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.W())) {
                k20.a.h(mac, Integer.parseInt(valueList.get(0)));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.C())) {
                k20.a.d(mac, Integer.parseInt(valueList.get(0)));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.D())) {
                k20.a.a(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.M())) {
                k20.a.f(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.P())) {
                k20.a.e(mac, Integer.parseInt(valueList.get(0)));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.E())) {
                x10.a.a(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.o0()) || Intrinsics.areEqual(cmdConstant, pa0Var.p0())) {
                x10.a.c(mac, valueList.get(0));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.F())) {
                x10.a.b(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.q0()) || Intrinsics.areEqual(cmdConstant, pa0Var.r0())) {
                x10.a.d(mac, StringsKt__StringsJVMKt.equals(valueList.get(0), "1", true));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.L())) {
                w00.a.d(mac, Integer.parseInt(valueList.get(0)));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.y())) {
                w00.a.b(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.j0())) {
                w00.a.e(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.l0())) {
                w00.a.f(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.A())) {
                w00.a.c(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.m())) {
                w00.a.a(mac, Integer.parseInt(valueList.get(0)));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.a0())) {
                q30.a.c(mac, Integer.parseInt(valueList.get(0)));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.s())) {
                q30.a.a(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.g())) {
                q30.a.f(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.l())) {
                q30.a.g(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.G())) {
                q30.a.b(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.b0())) {
                q30.a.d(mac, StringsKt__StringsJVMKt.equals(valueList.get(0), "on", true));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.m0())) {
                q30.a.e(mac, Integer.parseInt(valueList.get(0)) == 1);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.H())) {
                u00.a.a(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.v0())) {
                u00.a.c(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.i0())) {
                u00.a.b(mac, Integer.parseInt(valueList.get(0)) == 1);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.t0())) {
                n00.a.f(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.T())) {
                n00.a.c(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.s0())) {
                n00.a.e(mac, Integer.parseInt(valueList.get(0)) == 1);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.S())) {
                n00.a.b(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.e0())) {
                n00.a.d(mac, Integer.parseInt(valueList.get(0)) == 1);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.R())) {
                n00.a.a(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.w0())) {
                h20.a.b(mac, Integer.parseInt(valueList.get(0)));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.J())) {
                h20.a.a(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.b())) {
                f10.a.b(mac, valueList.get(0));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.a())) {
                List<String> listChunked = StringsKt___StringsKt.chunked(valueList.get(0), 2);
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listChunked, 10));
                Iterator<T> it = listChunked.iterator();
                while (it.hasNext()) {
                    arrayList.add(Byte.valueOf((byte) Integer.parseInt((String) it.next(), CharsKt__CharJVMKt.checkRadix(16))));
                }
                byte[] byteArray = CollectionsKt___CollectionsKt.toByteArray(arrayList);
                f10.a.a(mac, byteArray[0], CollectionsKt__CollectionsJVMKt.listOf(ArraysKt___ArraysJvmKt.copyOfRange(byteArray, 2, byteArray.length - 1)));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.n0())) {
                r00.a.b(mac, StringsKt__StringsJVMKt.equals(valueList.get(0), "on", true));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.h0())) {
                r00.a.a(mac, Integer.parseInt(valueList.get(0)));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.A0())) {
                z30.a.b(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.B0())) {
                z30.a.c(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.g0())) {
                z30.a.a(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.Y())) {
                c10.a.c(mac, Integer.parseInt(valueList.get(0)));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.o())) {
                c10.a.a(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.d0())) {
                c10.a.d(mac, Integer.parseInt(valueList.get(0)));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.v())) {
                c10.a.b(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.B())) {
                a40.a.c(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.u0())) {
                a40.a.g(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.I())) {
                a40.a.e(mac, Integer.parseInt(valueList.get(0)));
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.C0())) {
                a40.a.a(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.K())) {
                a40.a.d(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.w())) {
                a40.a.b(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.f0())) {
                a40.a.f(mac, Integer.parseInt(valueList.get(0)) == 1);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.i())) {
                m00.b.d(mac, Integer.parseInt(valueList.get(0)) == 1);
            } else {
                ma0 ma0Var = ma0.a;
                if (Intrinsics.areEqual(cmdConstant, ma0Var.F())) {
                    new w80(mac, Integer.parseInt(valueList.get(0))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.G())) {
                    new t80(mac, Integer.parseInt(valueList.get(0))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.H())) {
                    new u80(mac, Integer.parseInt(valueList.get(0))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.I())) {
                    new v80(mac, Integer.parseInt(valueList.get(0))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.J())) {
                    new z80(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.K())) {
                    new x80(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.L())) {
                    new y80(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.v())) {
                    new g70(mac, Integer.parseInt(valueList.get(0))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.y())) {
                    new j70(mac, Integer.parseInt(valueList.get(0))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.x())) {
                    new i70(mac, Integer.parseInt(valueList.get(0))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.w())) {
                    new h70(mac).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.E())) {
                    new s80(mac, Integer.parseInt(valueList.get(0))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.b())) {
                    new t40(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.d())) {
                    new v40(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)), Integer.parseInt(valueList.get(2))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.e())) {
                    new w40(mac, Integer.parseInt(valueList.get(0))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.i())) {
                    new a50(mac, Integer.parseInt(valueList.get(0))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.f())) {
                    new x40(mac, Integer.parseInt(valueList.get(0))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.g())) {
                    new y40(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.h())) {
                    new z40(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.D())) {
                    new r80(mac, Integer.parseInt(valueList.get(0))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.a())) {
                    new p40(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.c())) {
                    new u40(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)), Integer.parseInt(valueList.get(2))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.C())) {
                    new p80(mac, Integer.parseInt(valueList.get(0))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.B())) {
                    new o80(mac, Integer.parseInt(valueList.get(0))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.m())) {
                    new n50(mac, Integer.parseInt(valueList.get(0))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.u())) {
                    new t60(mac, Integer.parseInt(valueList.get(0))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.z())) {
                    u10.a.b(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)));
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.o())) {
                    u10.a.a(mac);
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.j())) {
                    new h50(mac, Integer.parseInt(valueList.get(0))).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.l())) {
                    j30.a.a(mac, Integer.parseInt(valueList.get(0)));
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.p())) {
                    j30.a.b(mac);
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.A())) {
                    j30.a.d(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)));
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.q())) {
                    j30.a.c(mac);
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.t())) {
                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(valueList, 10));
                    Iterator<T> it2 = valueList.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(Integer.valueOf(Integer.parseInt((String) it2.next())));
                    }
                    int[] intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList2);
                    new s60(mac, Arrays.copyOf(intArray, intArray.length)).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.s())) {
                    ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(valueList, 10));
                    Iterator<T> it3 = valueList.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(Integer.valueOf(Integer.parseInt((String) it3.next())));
                    }
                    int[] intArray2 = CollectionsKt___CollectionsKt.toIntArray(arrayList3);
                    new r60(mac, Arrays.copyOf(intArray2, intArray2.length)).e();
                } else if (Intrinsics.areEqual(cmdConstant, ma0Var.n())) {
                    n10.b.d(mac);
                } else {
                    if (!Intrinsics.areEqual(cmdConstant, ma0Var.r())) {
                        return false;
                    }
                    ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(valueList, 10));
                    Iterator<T> it4 = valueList.iterator();
                    while (it4.hasNext()) {
                        arrayList4.add(Byte.valueOf((byte) Integer.parseInt((String) it4.next())));
                    }
                    new p60(mac, CollectionsKt___CollectionsKt.toByteArray(arrayList4)).e();
                }
            }
            return true;
        } catch (Exception e) {
            kq1.a aVar = kq1.f;
            aVar.b("ToyCmdBridgeSend cmdToMethod cmdConstant = " + cmdConstant + " mac = " + mac + " cmd = " + cmd + " valueList = " + valueList);
            aVar.b(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Nullable
    public static final la0 b(@NotNull mq1 mq1Var, @NotNull String cmd) {
        Intrinsics.checkNotNullParameter(mq1Var, "<this>");
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        pa0 pa0Var = pa0.a;
        if (d90.i(cmd, pa0Var.k().c())) {
            return pa0Var.k();
        }
        if (d90.i(cmd, pa0Var.j().c())) {
            return pa0Var.j();
        }
        if (d90.i(cmd, pa0Var.O().c())) {
            return pa0Var.O();
        }
        if (d90.i(cmd, pa0Var.f().c())) {
            return pa0Var.f();
        }
        if (d90.i(cmd, pa0Var.r().c())) {
            return pa0Var.r();
        }
        if (d90.i(cmd, pa0Var.k0().c())) {
            return pa0Var.k0();
        }
        if (d90.i(cmd, pa0Var.z().c())) {
            return pa0Var.z();
        }
        if (d90.i(cmd, pa0Var.n().c())) {
            return pa0Var.n();
        }
        if (d90.i(cmd, pa0Var.q().c())) {
            return pa0Var.q();
        }
        if (d90.i(cmd, pa0Var.Z().c())) {
            return pa0Var.Z();
        }
        if (d90.i(cmd, pa0Var.h().c())) {
            return pa0Var.h();
        }
        if (d90.i(cmd, pa0Var.X().c())) {
            return pa0Var.X();
        }
        if (d90.i(cmd, pa0Var.e().c())) {
            return pa0Var.e();
        }
        if (d90.i(cmd, pa0Var.p().c())) {
            return pa0Var.p();
        }
        if (d90.i(cmd, pa0Var.Q().c())) {
            return pa0Var.Q();
        }
        if (d90.i(cmd, pa0Var.N().c())) {
            return pa0Var.N();
        }
        if (d90.i(cmd, pa0Var.x0().c())) {
            return pa0Var.x0();
        }
        if (d90.i(cmd, pa0Var.z0().c())) {
            return pa0Var.z0();
        }
        if (d90.i(cmd, pa0Var.y0().c())) {
            return pa0Var.y0();
        }
        if (d90.i(cmd, pa0Var.W().c())) {
            return pa0Var.W();
        }
        if (d90.i(cmd, pa0Var.C().c())) {
            return pa0Var.C();
        }
        if (d90.i(cmd, pa0Var.D().c())) {
            return pa0Var.D();
        }
        if (d90.i(cmd, pa0Var.M().c())) {
            return pa0Var.M();
        }
        if (d90.i(cmd, pa0Var.P().c())) {
            return pa0Var.P();
        }
        if (d90.i(cmd, pa0Var.E().c())) {
            return pa0Var.E();
        }
        if (d90.i(cmd, pa0Var.o0().c())) {
            return pa0Var.o0();
        }
        if (d90.i(cmd, pa0Var.p0().c())) {
            return pa0Var.p0();
        }
        if (d90.i(cmd, pa0Var.F().c())) {
            return pa0Var.F();
        }
        if (d90.i(cmd, pa0Var.q0().c())) {
            return pa0Var.q0();
        }
        if (d90.i(cmd, pa0Var.r0().c())) {
            return pa0Var.r0();
        }
        if (d90.i(cmd, pa0Var.L().c())) {
            return pa0Var.L();
        }
        if (d90.i(cmd, pa0Var.y().c())) {
            return pa0Var.y();
        }
        if (d90.i(cmd, pa0Var.j0().c())) {
            return pa0Var.j0();
        }
        if (d90.i(cmd, pa0Var.l0().c())) {
            return pa0Var.l0();
        }
        if (d90.i(cmd, pa0Var.A().c())) {
            return pa0Var.A();
        }
        if (d90.i(cmd, pa0Var.m().c())) {
            return pa0Var.m();
        }
        if (d90.i(cmd, pa0Var.a0().c())) {
            return pa0Var.a0();
        }
        if (d90.i(cmd, pa0Var.s().c())) {
            return pa0Var.s();
        }
        if (d90.i(cmd, pa0Var.g().c())) {
            return pa0Var.g();
        }
        if (d90.i(cmd, pa0Var.l().c())) {
            return pa0Var.l();
        }
        if (d90.i(cmd, pa0Var.G().c())) {
            return pa0Var.G();
        }
        if (d90.i(cmd, pa0Var.b0().c())) {
            return pa0Var.b0();
        }
        if (d90.i(cmd, pa0Var.m0().c())) {
            return pa0Var.m0();
        }
        if (d90.i(cmd, pa0Var.H().c())) {
            return pa0Var.H();
        }
        if (d90.i(cmd, pa0Var.v0().c())) {
            return pa0Var.v0();
        }
        if (d90.i(cmd, pa0Var.i0().c())) {
            return pa0Var.i0();
        }
        if (d90.i(cmd, pa0Var.t0().c())) {
            return pa0Var.t0();
        }
        if (d90.i(cmd, pa0Var.T().c())) {
            return pa0Var.T();
        }
        if (d90.i(cmd, pa0Var.s0().c())) {
            return pa0Var.s0();
        }
        if (d90.i(cmd, pa0Var.S().c())) {
            return pa0Var.S();
        }
        if (d90.i(cmd, pa0Var.e0().c())) {
            return pa0Var.e0();
        }
        if (d90.i(cmd, pa0Var.R().c())) {
            return pa0Var.R();
        }
        if (d90.i(cmd, pa0Var.w0().c())) {
            return pa0Var.w0();
        }
        if (d90.i(cmd, pa0Var.J().c())) {
            return pa0Var.J();
        }
        if (d90.i(cmd, pa0Var.b().c())) {
            return pa0Var.b();
        }
        if (d90.i(cmd, pa0Var.a().c())) {
            return pa0Var.a();
        }
        if (d90.i(cmd, pa0Var.n0().c())) {
            return pa0Var.n0();
        }
        if (d90.i(cmd, pa0Var.h0().c())) {
            return pa0Var.h0();
        }
        if (d90.i(cmd, pa0Var.A0().c())) {
            return pa0Var.A0();
        }
        if (d90.i(cmd, pa0Var.B0().c())) {
            return pa0Var.B0();
        }
        if (d90.i(cmd, pa0Var.g0().c())) {
            return pa0Var.g0();
        }
        if (d90.i(cmd, pa0Var.Y().c())) {
            return pa0Var.Y();
        }
        if (d90.i(cmd, pa0Var.o().c())) {
            return pa0Var.o();
        }
        if (d90.i(cmd, pa0Var.d0().c())) {
            return pa0Var.d0();
        }
        if (d90.i(cmd, pa0Var.v().c())) {
            return pa0Var.v();
        }
        if (d90.i(cmd, pa0Var.B().c())) {
            return pa0Var.B();
        }
        if (d90.i(cmd, pa0Var.u0().c())) {
            return pa0Var.u0();
        }
        if (d90.i(cmd, pa0Var.I().c())) {
            return pa0Var.I();
        }
        if (d90.i(cmd, pa0Var.C0().c())) {
            return pa0Var.C0();
        }
        if (d90.i(cmd, pa0Var.K().c())) {
            return pa0Var.K();
        }
        if (d90.i(cmd, pa0Var.w().c())) {
            return pa0Var.w();
        }
        if (d90.i(cmd, pa0Var.f0().c())) {
            return pa0Var.f0();
        }
        ma0 ma0Var = ma0.a;
        if (d90.i(cmd, ma0Var.F().c())) {
            return ma0Var.F();
        }
        if (d90.i(cmd, ma0Var.G().c())) {
            return ma0Var.G();
        }
        if (d90.i(cmd, ma0Var.H().c())) {
            return ma0Var.H();
        }
        if (d90.i(cmd, ma0Var.I().c())) {
            return ma0Var.I();
        }
        if (d90.i(cmd, ma0Var.J().c())) {
            return ma0Var.J();
        }
        if (d90.i(cmd, ma0Var.K().c())) {
            return ma0Var.K();
        }
        if (d90.i(cmd, ma0Var.L().c())) {
            return ma0Var.L();
        }
        if (d90.i(cmd, ma0Var.y().c())) {
            return ma0Var.y();
        }
        if (d90.i(cmd, ma0Var.x().c())) {
            return ma0Var.x();
        }
        if (d90.i(cmd, ma0Var.w().c())) {
            return ma0Var.w();
        }
        if (d90.i(cmd, ma0Var.v().c())) {
            return ma0Var.v();
        }
        if (d90.i(cmd, ma0Var.E().c())) {
            return ma0Var.E();
        }
        if (d90.i(cmd, ma0Var.b().c())) {
            return ma0Var.b();
        }
        if (d90.i(cmd, ma0Var.d().c())) {
            return ma0Var.d();
        }
        if (d90.i(cmd, ma0Var.e().c())) {
            return ma0Var.e();
        }
        if (d90.i(cmd, ma0Var.i().c())) {
            return ma0Var.i();
        }
        if (d90.i(cmd, ma0Var.f().c())) {
            return ma0Var.f();
        }
        if (d90.i(cmd, ma0Var.g().c())) {
            return ma0Var.g();
        }
        if (d90.i(cmd, ma0Var.h().c())) {
            return ma0Var.h();
        }
        if (d90.i(cmd, ma0Var.D().c())) {
            return ma0Var.D();
        }
        if (d90.i(cmd, ma0Var.a().c())) {
            return ma0Var.a();
        }
        if (d90.i(cmd, ma0Var.c().c())) {
            return ma0Var.c();
        }
        if (d90.i(cmd, ma0Var.C().c())) {
            return ma0Var.C();
        }
        if (d90.i(cmd, ma0Var.B().c())) {
            return ma0Var.B();
        }
        if (d90.i(cmd, ma0Var.m().c())) {
            return ma0Var.m();
        }
        if (d90.i(cmd, ma0Var.u().c())) {
            return ma0Var.u();
        }
        if (d90.i(cmd, ma0Var.z().c())) {
            return ma0Var.z();
        }
        if (d90.i(cmd, ma0Var.o().c())) {
            return ma0Var.o();
        }
        if (d90.i(cmd, ma0Var.j().c())) {
            return ma0Var.j();
        }
        if (d90.i(cmd, ma0Var.l().c())) {
            return ma0Var.l();
        }
        if (d90.i(cmd, ma0Var.p().c())) {
            return ma0Var.p();
        }
        if (d90.i(cmd, ma0Var.A().c())) {
            return ma0Var.A();
        }
        if (d90.i(cmd, ma0Var.q().c())) {
            return ma0Var.q();
        }
        if (d90.i(cmd, ma0Var.t().c())) {
            return ma0Var.t();
        }
        if (d90.i(cmd, ma0Var.s().c())) {
            return ma0Var.s();
        }
        if (d90.i(cmd, ma0Var.n().c())) {
            return ma0Var.n();
        }
        if (d90.i(cmd, ma0Var.r().c())) {
            return ma0Var.r();
        }
        if (d90.i(cmd, pa0Var.t().c())) {
            return pa0Var.t();
        }
        if (d90.i(cmd, pa0Var.x().c())) {
            return pa0Var.x();
        }
        if (d90.i(cmd, pa0Var.U().c())) {
            return pa0Var.U();
        }
        if (d90.i(cmd, pa0Var.V().c())) {
            return pa0Var.V();
        }
        if (d90.i(cmd, pa0Var.u().c())) {
            return pa0Var.u();
        }
        if (d90.i(cmd, pa0Var.c0().c())) {
            return pa0Var.c0();
        }
        if (d90.i(cmd, pa0Var.d().c())) {
            return pa0Var.d();
        }
        if (d90.i(cmd, pa0Var.c().c())) {
            return pa0Var.c();
        }
        if (d90.i(cmd, pa0Var.i().c())) {
            return pa0Var.i();
        }
        return null;
    }

    @Nullable
    public static final b90 c(@NotNull mq1 mq1Var, @NotNull la0 cmdConstant, @NotNull String mac, @NotNull List<String> valueList) {
        b90 p60Var;
        b90 t50Var;
        b90 v60Var;
        Intrinsics.checkNotNullParameter(mq1Var, "<this>");
        Intrinsics.checkNotNullParameter(cmdConstant, "cmdConstant");
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(valueList, "valueList");
        try {
            pa0 pa0Var = pa0.a;
            if (Intrinsics.areEqual(cmdConstant, pa0Var.k())) {
                t50Var = new j50(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.j())) {
                t50Var = new i50(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.O())) {
                t50Var = new w60(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.f())) {
                t50Var = new d50(mac);
            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.r())) {
                t50Var = new r50(mac);
            } else {
                boolean z = true;
                if (Intrinsics.areEqual(cmdConstant, pa0Var.k0())) {
                    t50Var = new w70(mac, StringsKt__StringsJVMKt.equals(valueList.get(0), "on", true));
                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.z())) {
                    t50Var = new a60(mac);
                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.n())) {
                    t50Var = new o50(mac);
                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.q())) {
                    t50Var = new q50(mac);
                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.Z())) {
                    t50Var = new l70(mac, StringsKt__StringsJVMKt.equals(valueList.get(0), "on", true));
                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.h())) {
                    t50Var = new f50(mac, valueList.get(0));
                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.X())) {
                    t50Var = new f70(mac);
                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.e())) {
                    t50Var = new c50(mac, StringsKt__StringsJVMKt.equals(valueList.get(0), "on", true), StringsKt__StringsJVMKt.equals(valueList.get(1), "on", true));
                    t50Var.addSendType(new oa0.e(false, null, 2, null));
                    Unit unit = Unit.INSTANCE;
                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.p())) {
                    t50Var = new b50(mac);
                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.t())) {
                    t50Var = new u50(mac, Integer.parseInt(valueList.get(0)));
                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.x())) {
                    t50Var = new y50(mac);
                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.U())) {
                    t50Var = new c70(mac);
                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.V())) {
                    t50Var = new d70(mac, Integer.parseInt(valueList.get(0)));
                } else {
                    if (!Intrinsics.areEqual(cmdConstant, pa0Var.u())) {
                        if (Intrinsics.areEqual(cmdConstant, pa0Var.c0())) {
                            v60Var = new o70(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)), Integer.parseInt(valueList.get(2)), Integer.parseInt(valueList.get(3)));
                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.c())) {
                            t50Var = new q40(mac);
                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.d())) {
                            t50Var = new r40(mac, valueList.get(0));
                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.Q())) {
                            t50Var = new y60(mac, Integer.parseInt(valueList.get(0)), valueList.get(1));
                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.N())) {
                            v60Var = new v60(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)), Integer.parseInt(valueList.get(2)), valueList.get(3));
                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.x0())) {
                            t50Var = new j80(mac);
                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.z0())) {
                            t50Var = new l80(mac);
                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.y0())) {
                            t50Var = new k80(mac);
                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.W())) {
                            t50Var = new e70(mac, Integer.parseInt(valueList.get(0)));
                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.C())) {
                            t50Var = new e60(mac, Integer.parseInt(valueList.get(0)));
                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.D())) {
                            t50Var = new f60(mac);
                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.M())) {
                            t50Var = new u60(mac);
                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.P())) {
                            t50Var = new x60(mac, Integer.parseInt(valueList.get(0)));
                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.E())) {
                            t50Var = new g60(mac);
                        } else {
                            if (Intrinsics.areEqual(cmdConstant, pa0Var.o0()) ? true : Intrinsics.areEqual(cmdConstant, pa0Var.p0())) {
                                t50Var = new b80(mac, valueList.get(0));
                            } else if (Intrinsics.areEqual(cmdConstant, pa0Var.F())) {
                                t50Var = new h60(mac);
                            } else {
                                if (Intrinsics.areEqual(cmdConstant, pa0Var.q0()) ? true : Intrinsics.areEqual(cmdConstant, pa0Var.r0())) {
                                    t50Var = new c80(mac, StringsKt__StringsJVMKt.equals(valueList.get(0), "1", true));
                                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.L())) {
                                    t50Var = new q60(mac, Integer.parseInt(valueList.get(0)));
                                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.y())) {
                                    t50Var = new z50(mac);
                                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.j0())) {
                                    t50Var = new v70(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)));
                                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.l0())) {
                                    t50Var = new x70(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)));
                                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.A())) {
                                    t50Var = new b60(mac);
                                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.m())) {
                                    t50Var = new l50(mac, Integer.parseInt(valueList.get(0)));
                                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.a0())) {
                                    t50Var = new m70(mac, Integer.parseInt(valueList.get(0)));
                                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.s())) {
                                    t50Var = new s50(mac);
                                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.g())) {
                                    t50Var = new e50(mac);
                                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.l())) {
                                    t50Var = new k50(mac);
                                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.G())) {
                                    t50Var = new j60(mac);
                                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.b0())) {
                                    t50Var = new n70(mac, StringsKt__StringsJVMKt.equals(valueList.get(0), "on", true));
                                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.m0())) {
                                    if (Integer.parseInt(valueList.get(0)) != 1) {
                                        z = false;
                                    }
                                    t50Var = new y70(mac, z);
                                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.H())) {
                                    t50Var = new l60(mac);
                                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.v0())) {
                                    t50Var = new h80(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)));
                                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.i0())) {
                                    if (Integer.parseInt(valueList.get(0)) != 1) {
                                        z = false;
                                    }
                                    t50Var = new u70(mac, z);
                                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.t0())) {
                                    t50Var = new f80(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)));
                                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.T())) {
                                    t50Var = new b70(mac);
                                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.s0())) {
                                    if (Integer.parseInt(valueList.get(0)) != 1) {
                                        z = false;
                                    }
                                    t50Var = new d80(mac, z);
                                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.S())) {
                                    t50Var = new a70(mac);
                                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.e0())) {
                                    if (Integer.parseInt(valueList.get(0)) != 1) {
                                        z = false;
                                    }
                                    t50Var = new q70(mac, z);
                                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.R())) {
                                    t50Var = new z60(mac);
                                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.w0())) {
                                    t50Var = new i80(mac, Integer.parseInt(valueList.get(0)));
                                } else if (Intrinsics.areEqual(cmdConstant, pa0Var.J())) {
                                    t50Var = new n60(mac);
                                } else {
                                    if (!Intrinsics.areEqual(cmdConstant, pa0Var.b())) {
                                        if (Intrinsics.areEqual(cmdConstant, pa0Var.a())) {
                                            List<String> listChunked = StringsKt___StringsKt.chunked(valueList.get(0), 2);
                                            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listChunked, 10));
                                            Iterator<T> it = listChunked.iterator();
                                            while (it.hasNext()) {
                                                arrayList.add(Byte.valueOf((byte) Integer.parseInt((String) it.next(), CharsKt__CharJVMKt.checkRadix(16))));
                                            }
                                            byte[] byteArray = CollectionsKt___CollectionsKt.toByteArray(arrayList);
                                            p60Var = new o40(mac, byteArray[0], CollectionsKt__CollectionsJVMKt.listOf(ArraysKt___ArraysJvmKt.copyOfRange(byteArray, 2, byteArray.length - 1)));
                                            p60Var.addSendType(new oa0.c(0, 1, null));
                                            p60Var.addSendType(new oa0.e(false, null, 2, null));
                                            Unit unit2 = Unit.INSTANCE;
                                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.n0())) {
                                            t50Var = new z70(mac, StringsKt__StringsJVMKt.equals(valueList.get(0), "on", true));
                                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.h0())) {
                                            t50Var = new t70(mac, Integer.parseInt(valueList.get(0)));
                                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.A0())) {
                                            t50Var = new m80(mac);
                                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.B0())) {
                                            t50Var = new n80(mac);
                                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.g0())) {
                                            t50Var = new s70(mac);
                                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.Y())) {
                                            t50Var = new k70(mac, Integer.parseInt(valueList.get(0)));
                                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.o())) {
                                            t50Var = new p50(mac);
                                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.d0())) {
                                            t50Var = new p70(mac, Integer.parseInt(valueList.get(0)));
                                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.v())) {
                                            t50Var = new w50(mac);
                                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.B())) {
                                            t50Var = new c60(mac);
                                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.u0())) {
                                            t50Var = new g80(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)));
                                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.I())) {
                                            t50Var = new m60(mac, Integer.parseInt(valueList.get(0)));
                                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.C0())) {
                                            t50Var = new a90(mac);
                                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.K())) {
                                            t50Var = new o60(mac);
                                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.w())) {
                                            t50Var = new x50(mac);
                                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.f0())) {
                                            if (Integer.parseInt(valueList.get(0)) != 1) {
                                                z = false;
                                            }
                                            t50Var = new r70(mac, z);
                                        } else if (Intrinsics.areEqual(cmdConstant, pa0Var.i())) {
                                            if (Integer.parseInt(valueList.get(0)) != 1) {
                                                z = false;
                                            }
                                            t50Var = new g50(mac, z);
                                        } else {
                                            ma0 ma0Var = ma0.a;
                                            if (Intrinsics.areEqual(cmdConstant, ma0Var.F())) {
                                                t50Var = new w80(mac, Integer.parseInt(valueList.get(0)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.G())) {
                                                t50Var = new t80(mac, Integer.parseInt(valueList.get(0)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.H())) {
                                                t50Var = new u80(mac, Integer.parseInt(valueList.get(0)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.I())) {
                                                t50Var = new v80(mac, Integer.parseInt(valueList.get(0)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.J())) {
                                                t50Var = new z80(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.K())) {
                                                t50Var = new x80(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.L())) {
                                                t50Var = new y80(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.v())) {
                                                t50Var = new g70(mac, Integer.parseInt(valueList.get(0)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.y())) {
                                                t50Var = new j70(mac, Integer.parseInt(valueList.get(0)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.x())) {
                                                t50Var = new i70(mac, Integer.parseInt(valueList.get(0)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.w())) {
                                                t50Var = new h70(mac);
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.E())) {
                                                t50Var = new s80(mac, Integer.parseInt(valueList.get(0)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.b())) {
                                                t50Var = new t40(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.d())) {
                                                t50Var = new v40(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)), Integer.parseInt(valueList.get(2)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.e())) {
                                                t50Var = new w40(mac, Integer.parseInt(valueList.get(0)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.i())) {
                                                t50Var = new a50(mac, Integer.parseInt(valueList.get(0)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.f())) {
                                                t50Var = new x40(mac, Integer.parseInt(valueList.get(0)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.g())) {
                                                t50Var = new y40(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.h())) {
                                                t50Var = new z40(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.D())) {
                                                t50Var = new r80(mac, Integer.parseInt(valueList.get(0)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.a())) {
                                                t50Var = new p40(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.c())) {
                                                t50Var = new u40(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)), Integer.parseInt(valueList.get(2)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.C())) {
                                                t50Var = new p80(mac, Integer.parseInt(valueList.get(0)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.B())) {
                                                t50Var = new o80(mac, Integer.parseInt(valueList.get(0)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.m())) {
                                                t50Var = new n50(mac, Integer.parseInt(valueList.get(0)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.u())) {
                                                t50Var = new t60(mac, Integer.parseInt(valueList.get(0)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.z())) {
                                                t50Var = new a80(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.o())) {
                                                t50Var = new d60(mac);
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.j())) {
                                                t50Var = new h50(mac, Integer.parseInt(valueList.get(0)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.l())) {
                                                t50Var = new m50(mac, Integer.parseInt(valueList.get(0)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.p())) {
                                                t50Var = new i60(mac);
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.A())) {
                                                t50Var = new e80(mac, Integer.parseInt(valueList.get(0)), Integer.parseInt(valueList.get(1)));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.q())) {
                                                t50Var = new k60(mac);
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.t())) {
                                                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(valueList, 10));
                                                Iterator<T> it2 = valueList.iterator();
                                                while (it2.hasNext()) {
                                                    arrayList2.add(Integer.valueOf(Integer.parseInt((String) it2.next())));
                                                }
                                                int[] intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList2);
                                                p60Var = new s60(mac, Arrays.copyOf(intArray, intArray.length));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.s())) {
                                                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(valueList, 10));
                                                Iterator<T> it3 = valueList.iterator();
                                                while (it3.hasNext()) {
                                                    arrayList3.add(Integer.valueOf(Integer.parseInt((String) it3.next())));
                                                }
                                                int[] intArray2 = CollectionsKt___CollectionsKt.toIntArray(arrayList3);
                                                p60Var = new r60(mac, Arrays.copyOf(intArray2, intArray2.length));
                                            } else if (Intrinsics.areEqual(cmdConstant, ma0Var.n())) {
                                                t50Var = new t50(mac);
                                            } else {
                                                if (!Intrinsics.areEqual(cmdConstant, ma0Var.r())) {
                                                    return null;
                                                }
                                                ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(valueList, 10));
                                                Iterator<T> it4 = valueList.iterator();
                                                while (it4.hasNext()) {
                                                    arrayList4.add(Byte.valueOf((byte) Integer.parseInt((String) it4.next())));
                                                }
                                                p60Var = new p60(mac, CollectionsKt___CollectionsKt.toByteArray(arrayList4));
                                            }
                                        }
                                        return p60Var;
                                    }
                                    t50Var = new s40(mac, valueList.get(0));
                                }
                            }
                        }
                        return v60Var;
                    }
                    t50Var = new v50(mac);
                }
            }
            return t50Var;
        } catch (Exception e) {
            kq1.a aVar = kq1.f;
            aVar.b("ToyCmdBridgeSend getCmdBean cmdConstant = " + cmdConstant + " mac = " + mac + " valueList = " + valueList);
            aVar.b(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
