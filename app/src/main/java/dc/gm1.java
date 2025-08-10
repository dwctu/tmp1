package dc;

import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.wear.adapter.BaseAdapter;
import com.wear.adapter.mutlitoys.MutliSelectAdapter;
import com.wear.bean.MutliSelectWrapperBean;
import com.wear.bean.controlmutlitoys.MultiToyOFunBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: MutliSelectAdapterFunction.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J.\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tJ$\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016J\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007J\u001a\u0010\u0018\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u001a\u001a\u00020\u0005H\u0002R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/wear/adapter/mutlitoys/MutliSelectAdapterFunction;", "", "()V", "cacheFunctionNames", "", "", "invokeFunction", "Lcom/wear/adapter/mutlitoys/MutliSelectAdapterFunction$InvokeFunction;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/wear/adapter/mutlitoys/MutliSelectAdapter$Listener;", "bindDataByFunctionName", "", "supportWrapperBeans", "Lcom/wear/bean/MutliSelectWrapperBean;", "functionName", "multiToyOFunBean", "Lcom/wear/bean/controlmutlitoys/MultiToyOFunBean;", "viewHolder", "Lcom/wear/adapter/BaseAdapter$ViewHolder;", "bindListener", "dispatcher", "functions", "", "setInvokeFunction", "support", "", "function", "InvokeFunction", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class gm1 {

    @Nullable
    public List<String> a;

    @Nullable
    public a b;

    @Nullable
    public MutliSelectAdapter.a c;

    /* compiled from: MutliSelectAdapterFunction.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH&J,\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH&J,\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH&J,\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH&J*\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH&J,\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH&J*\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH&J,\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH&J,\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH&J6\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH&J,\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH&¨\u0006\u0018"}, d2 = {"Lcom/wear/adapter/mutlitoys/MutliSelectAdapterFunction$InvokeFunction;", "", "invokeD", "", "viewHolder", "Lcom/wear/adapter/BaseAdapter$ViewHolder;", "toyAddress", "", "isVisible", "", "isSelf", "invokeF", "invokeP", "invokePos", "invokeR", "multiToyOFunBean", "Lcom/wear/bean/controlmutlitoys/MultiToyOFunBean;", "invokeS", "invokeT", "invokeV2", "invokeV3", "invokeVAndV1", "functionName", "invokeW", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {

        /* compiled from: MutliSelectAdapterFunction.kt */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: dc.gm1$a$a, reason: collision with other inner class name */
        public static final class C0180a {
            public static /* synthetic */ void a(a aVar, BaseAdapter.ViewHolder viewHolder, String str, boolean z, boolean z2, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeD");
                }
                if ((i & 8) != 0) {
                    z2 = false;
                }
                aVar.h(viewHolder, str, z, z2);
            }

            public static /* synthetic */ void b(a aVar, BaseAdapter.ViewHolder viewHolder, String str, boolean z, boolean z2, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeF");
                }
                if ((i & 8) != 0) {
                    z2 = false;
                }
                aVar.f(viewHolder, str, z, z2);
            }

            public static /* synthetic */ void c(a aVar, BaseAdapter.ViewHolder viewHolder, String str, boolean z, boolean z2, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeP");
                }
                if ((i & 8) != 0) {
                    z2 = false;
                }
                aVar.a(viewHolder, str, z, z2);
            }

            public static /* synthetic */ void d(a aVar, BaseAdapter.ViewHolder viewHolder, String str, boolean z, boolean z2, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokePos");
                }
                if ((i & 8) != 0) {
                    z2 = false;
                }
                aVar.d(viewHolder, str, z, z2);
            }

            public static /* synthetic */ void e(a aVar, BaseAdapter.ViewHolder viewHolder, MultiToyOFunBean multiToyOFunBean, boolean z, boolean z2, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeR");
                }
                if ((i & 8) != 0) {
                    z2 = false;
                }
                aVar.i(viewHolder, multiToyOFunBean, z, z2);
            }

            public static /* synthetic */ void f(a aVar, BaseAdapter.ViewHolder viewHolder, String str, boolean z, boolean z2, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeS");
                }
                if ((i & 8) != 0) {
                    z2 = false;
                }
                aVar.j(viewHolder, str, z, z2);
            }

            public static /* synthetic */ void g(a aVar, BaseAdapter.ViewHolder viewHolder, MultiToyOFunBean multiToyOFunBean, boolean z, boolean z2, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeT");
                }
                if ((i & 8) != 0) {
                    z2 = false;
                }
                aVar.g(viewHolder, multiToyOFunBean, z, z2);
            }

            public static /* synthetic */ void h(a aVar, BaseAdapter.ViewHolder viewHolder, String str, boolean z, boolean z2, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeV2");
                }
                if ((i & 8) != 0) {
                    z2 = false;
                }
                aVar.c(viewHolder, str, z, z2);
            }

            public static /* synthetic */ void i(a aVar, BaseAdapter.ViewHolder viewHolder, String str, boolean z, boolean z2, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeV3");
                }
                if ((i & 8) != 0) {
                    z2 = false;
                }
                aVar.b(viewHolder, str, z, z2);
            }

            public static /* synthetic */ void j(a aVar, BaseAdapter.ViewHolder viewHolder, String str, String str2, boolean z, boolean z2, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeVAndV1");
                }
                aVar.k(viewHolder, str, str2, z, (i & 16) != 0 ? false : z2);
            }

            public static /* synthetic */ void k(a aVar, BaseAdapter.ViewHolder viewHolder, String str, boolean z, boolean z2, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeW");
                }
                if ((i & 8) != 0) {
                    z2 = false;
                }
                aVar.e(viewHolder, str, z, z2);
            }
        }

        void a(@NotNull BaseAdapter.ViewHolder viewHolder, @Nullable String str, boolean z, boolean z2);

        void b(@NotNull BaseAdapter.ViewHolder viewHolder, @Nullable String str, boolean z, boolean z2);

        void c(@NotNull BaseAdapter.ViewHolder viewHolder, @Nullable String str, boolean z, boolean z2);

        void d(@NotNull BaseAdapter.ViewHolder viewHolder, @Nullable String str, boolean z, boolean z2);

        void e(@NotNull BaseAdapter.ViewHolder viewHolder, @Nullable String str, boolean z, boolean z2);

        void f(@NotNull BaseAdapter.ViewHolder viewHolder, @Nullable String str, boolean z, boolean z2);

        void g(@NotNull BaseAdapter.ViewHolder viewHolder, @NotNull MultiToyOFunBean multiToyOFunBean, boolean z, boolean z2);

        void h(@NotNull BaseAdapter.ViewHolder viewHolder, @Nullable String str, boolean z, boolean z2);

        void i(@NotNull BaseAdapter.ViewHolder viewHolder, @NotNull MultiToyOFunBean multiToyOFunBean, boolean z, boolean z2);

        void j(@NotNull BaseAdapter.ViewHolder viewHolder, @Nullable String str, boolean z, boolean z2);

        void k(@NotNull BaseAdapter.ViewHolder viewHolder, @Nullable String str, @Nullable String str2, boolean z, boolean z2);
    }

    public final void a(List<MutliSelectWrapperBean> list, String str, MultiToyOFunBean multiToyOFunBean, BaseAdapter.ViewHolder viewHolder) {
        a aVar;
        a aVar2;
        a aVar3;
        a aVar4;
        a aVar5;
        a aVar6;
        a aVar7;
        a aVar8;
        a aVar9;
        a aVar10;
        a aVar11;
        a aVar12;
        a aVar13;
        a aVar14;
        a aVar15;
        a aVar16;
        a aVar17;
        a aVar18;
        String toyAddress = multiToyOFunBean.getToyAddress();
        if (!e(list, str)) {
            int iHashCode = str.hashCode();
            if (iHashCode == 100) {
                if (str.equals(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG) && (aVar = this.b) != null) {
                    a.C0180a.a(aVar, viewHolder, toyAddress, false, false, 8, null);
                    return;
                }
                return;
            }
            if (iHashCode == 102) {
                if (str.equals("f") && (aVar2 = this.b) != null) {
                    a.C0180a.b(aVar2, viewHolder, toyAddress, false, false, 8, null);
                    return;
                }
                return;
            }
            if (iHashCode == 112) {
                if (str.equals("p") && (aVar3 = this.b) != null) {
                    a.C0180a.c(aVar3, viewHolder, toyAddress, false, false, 8, null);
                    return;
                }
                return;
            }
            if (iHashCode == 119) {
                if (str.equals("w") && (aVar4 = this.b) != null) {
                    a.C0180a.k(aVar4, viewHolder, toyAddress, false, false, 8, null);
                    return;
                }
                return;
            }
            if (iHashCode == 111188) {
                if (str.equals("pos") && (aVar5 = this.b) != null) {
                    a.C0180a.d(aVar5, viewHolder, toyAddress, false, false, 8, null);
                    return;
                }
                return;
            }
            if (iHashCode == 114) {
                if (str.equals(StreamManagement.AckRequest.ELEMENT) && (aVar6 = this.b) != null) {
                    a.C0180a.e(aVar6, viewHolder, multiToyOFunBean, false, false, 8, null);
                    return;
                }
                return;
            }
            if (iHashCode == 115) {
                if (str.equals("s") && (aVar7 = this.b) != null) {
                    a.C0180a.f(aVar7, viewHolder, toyAddress, false, false, 8, null);
                    return;
                }
                return;
            }
            if (iHashCode == 3708) {
                if (str.equals("v2") && (aVar8 = this.b) != null) {
                    a.C0180a.h(aVar8, viewHolder, toyAddress, false, false, 8, null);
                    return;
                }
                return;
            }
            if (iHashCode == 3709 && str.equals("v3") && (aVar9 = this.b) != null) {
                a.C0180a.i(aVar9, viewHolder, toyAddress, false, false, 8, null);
                return;
            }
            return;
        }
        MutliSelectAdapter.a aVar19 = this.c;
        boolean zA = aVar19 != null ? aVar19.a(toyAddress, str, true) : false;
        int iHashCode2 = str.hashCode();
        if (iHashCode2 == 100) {
            if (str.equals(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG) && (aVar10 = this.b) != null) {
                aVar10.h(viewHolder, toyAddress, true, zA);
                return;
            }
            return;
        }
        if (iHashCode2 == 102) {
            if (str.equals("f") && (aVar11 = this.b) != null) {
                aVar11.f(viewHolder, toyAddress, true, zA);
                return;
            }
            return;
        }
        if (iHashCode2 == 112) {
            if (str.equals("p") && (aVar12 = this.b) != null) {
                aVar12.a(viewHolder, toyAddress, true, zA);
                return;
            }
            return;
        }
        if (iHashCode2 == 119) {
            if (str.equals("w") && (aVar13 = this.b) != null) {
                aVar13.e(viewHolder, toyAddress, true, zA);
                return;
            }
            return;
        }
        if (iHashCode2 == 111188) {
            if (str.equals("pos") && (aVar14 = this.b) != null) {
                aVar14.d(viewHolder, toyAddress, true, zA);
                return;
            }
            return;
        }
        if (iHashCode2 == 114) {
            if (str.equals(StreamManagement.AckRequest.ELEMENT) && (aVar15 = this.b) != null) {
                aVar15.i(viewHolder, multiToyOFunBean, true, zA);
                return;
            }
            return;
        }
        if (iHashCode2 == 115) {
            if (str.equals("s") && (aVar16 = this.b) != null) {
                aVar16.j(viewHolder, toyAddress, true, zA);
                return;
            }
            return;
        }
        if (iHashCode2 == 3708) {
            if (str.equals("v2") && (aVar17 = this.b) != null) {
                aVar17.c(viewHolder, toyAddress, true, zA);
                return;
            }
            return;
        }
        if (iHashCode2 == 3709 && str.equals("v3") && (aVar18 = this.b) != null) {
            aVar18.b(viewHolder, toyAddress, true, zA);
        }
    }

    public final void b(@NotNull MutliSelectAdapter.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.c = listener;
    }

    public final void c(@NotNull BaseAdapter.ViewHolder viewHolder, @NotNull MultiToyOFunBean multiToyOFunBean, @NotNull List<String> functions) {
        a aVar;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(multiToyOFunBean, "multiToyOFunBean");
        Intrinsics.checkNotNullParameter(functions, "functions");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(functions, 10));
        for (String str : functions) {
            arrayList.add(new MutliSelectWrapperBean(str, functions.contains(str)));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((MutliSelectWrapperBean) obj).isSupport()) {
                arrayList2.add(obj);
            }
        }
        this.a = null;
        String toyAddress = multiToyOFunBean.getToyAddress();
        if (e(arrayList2, PSOProgramService.VS_Key) || e(arrayList2, "v1")) {
            String str2 = e(arrayList2, "v1") ? "v1" : PSOProgramService.VS_Key;
            if (e(arrayList2, "s")) {
                a aVar2 = this.b;
                if (aVar2 != null) {
                    a.C0180a.j(aVar2, viewHolder, toyAddress, str2, false, false, 16, null);
                }
            } else if (!multiToyOFunBean.isXMachine() || multiToyOFunBean.isFunction()) {
                MutliSelectAdapter.a aVar3 = this.c;
                boolean zA = aVar3 != null ? aVar3.a(toyAddress, str2, true) : false;
                a aVar4 = this.b;
                if (aVar4 != null) {
                    aVar4.k(viewHolder, toyAddress, str2, true, zA);
                }
            } else {
                MutliSelectAdapter.a aVar5 = this.c;
                boolean zA2 = aVar5 != null ? aVar5.a(toyAddress, PSOProgramService.VS_Key, true) : false;
                a aVar6 = this.b;
                if (aVar6 != null) {
                    aVar6.g(viewHolder, multiToyOFunBean, true, zA2);
                }
            }
        } else {
            a aVar7 = this.b;
            if (aVar7 != null) {
                a.C0180a.j(aVar7, viewHolder, toyAddress, null, false, false, 16, null);
            }
        }
        a(arrayList2, "v2", multiToyOFunBean, viewHolder);
        a(arrayList2, "v3", multiToyOFunBean, viewHolder);
        a(arrayList2, StreamManagement.AckRequest.ELEMENT, multiToyOFunBean, viewHolder);
        a(arrayList2, "p", multiToyOFunBean, viewHolder);
        a(arrayList2, "s", multiToyOFunBean, viewHolder);
        a(arrayList2, "w", multiToyOFunBean, viewHolder);
        if (e(arrayList2, "t")) {
            MutliSelectAdapter.a aVar8 = this.c;
            boolean zA3 = aVar8 != null ? aVar8.a(toyAddress, "t", true) : false;
            a aVar9 = this.b;
            if (aVar9 != null) {
                aVar9.g(viewHolder, multiToyOFunBean, true, zA3);
            }
        } else if (!multiToyOFunBean.isXMachine() && (aVar = this.b) != null) {
            a.C0180a.g(aVar, viewHolder, multiToyOFunBean, false, false, 8, null);
        }
        a(arrayList2, "f", multiToyOFunBean, viewHolder);
        a(arrayList2, GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, multiToyOFunBean, viewHolder);
        a(arrayList2, "pos", multiToyOFunBean, viewHolder);
    }

    public final void d(@NotNull a invokeFunction) {
        Intrinsics.checkNotNullParameter(invokeFunction, "invokeFunction");
        this.b = invokeFunction;
    }

    public final boolean e(List<MutliSelectWrapperBean> list, String str) {
        List<String> list2 = this.a;
        if (list2 != null) {
            Intrinsics.checkNotNull(list2);
            return list2.contains(str);
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((MutliSelectWrapperBean) it.next()).getFunctionName());
        }
        this.a = arrayList;
        return arrayList.contains(str);
    }
}
