package dc;

import com.component.dxtoy.core.toy.bean.ProgramBean;
import com.component.dxtoy.core.toy.bean.ToyConfigInfoBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyInfo+Program.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001a\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\u0002¨\u0006\t"}, d2 = {"getProgramDefaultLevel", "", "Lcom/component/dxtoy/core/toy/ToyInfo;", "getProgramDefaultPattern", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getProgramSpeed", "", "toy_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class l20 {
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0039 A[SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int[] a(@org.jetbrains.annotations.NotNull dc.nb0 r12) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 3
            int[] r0 = new int[r0]
            r0 = {x00a8: FILL_ARRAY_DATA , data: [5, 12, 20} // fill-array
            com.component.dxtoy.core.toy.bean.ToyConfigInfoBean r1 = r12.g()
            if (r1 == 0) goto La6
            java.util.List r2 = r1.getProgram()
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L22
            boolean r5 = r2.isEmpty()
            if (r5 == 0) goto L20
            goto L22
        L20:
            r5 = 0
            goto L23
        L22:
            r5 = 1
        L23:
            if (r5 != 0) goto La6
            java.lang.String r5 = r12.h()
            java.lang.String r1 = r1.getType()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r1)
            if (r1 != 0) goto L35
            goto La6
        L35:
            java.util.Iterator r1 = r2.iterator()
        L39:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto La6
            java.lang.Object r2 = r1.next()
            com.component.dxtoy.core.toy.bean.ProgramBean r2 = (com.component.dxtoy.core.toy.bean.ProgramBean) r2
            int r5 = r2.getMinv()
            int r6 = r2.getMaxv()
            int r7 = r12.getVersion()
            if (r5 > r7) goto L57
            if (r7 > r6) goto L57
            r5 = 1
            goto L58
        L57:
            r5 = 0
        L58:
            if (r5 == 0) goto L39
            java.lang.String r6 = r2.getL()
            if (r6 == 0) goto L94
            java.lang.String r2 = ","
            java.lang.String[] r7 = new java.lang.String[]{r2}
            r8 = 0
            r9 = 0
            r10 = 6
            r11 = 0
            java.util.List r2 = kotlin.text.StringsKt__StringsKt.split$default(r6, r7, r8, r9, r10, r11)
            if (r2 == 0) goto L94
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r2 = r2.iterator()
        L79:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L8f
            java.lang.Object r6 = r2.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Integer r6 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r6)
            if (r6 == 0) goto L79
            r5.add(r6)
            goto L79
        L8f:
            int[] r2 = kotlin.collections.CollectionsKt___CollectionsKt.toIntArray(r5)
            goto L95
        L94:
            r2 = 0
        L95:
            if (r2 == 0) goto La2
            int r5 = r2.length
            if (r5 != 0) goto L9c
            r5 = 1
            goto L9d
        L9c:
            r5 = 0
        L9d:
            r5 = r5 ^ r4
            if (r5 != r4) goto La2
            r5 = 1
            goto La3
        La2:
            r5 = 0
        La3:
            if (r5 == 0) goto L39
            return r2
        La6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.l20.a(dc.nb0):int[]");
    }

    @NotNull
    public static final ArrayList<String> b(@NotNull nb0 nb0Var) {
        ArrayList arrayList;
        List listSplit$default;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ArrayList<String> arrayListArrayListOf = CollectionsKt__CollectionsKt.arrayListOf("90", "346797643", "3456990", "34596990");
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG != null) {
            List<ProgramBean> program = toyConfigInfoBeanG.getProgram();
            boolean z = false;
            if (!(program == null || program.isEmpty()) && Intrinsics.areEqual(nb0Var.h(), toyConfigInfoBeanG.getType())) {
                Iterator<T> it = program.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ProgramBean programBean = (ProgramBean) it.next();
                    int minv = programBean.getMinv();
                    int maxv = programBean.getMaxv();
                    int version = nb0Var.getVersion();
                    if (minv <= version && version <= maxv) {
                        String p = programBean.getP();
                        if (p == null || (listSplit$default = StringsKt__StringsKt.split$default((CharSequence) p, new String[]{","}, false, 0, 6, (Object) null)) == null) {
                            arrayList = null;
                        } else {
                            arrayList = new ArrayList();
                            for (Object obj : listSplit$default) {
                                if (((String) obj).length() > 0) {
                                    arrayList.add(obj);
                                }
                            }
                        }
                        if (arrayList != null && (!arrayList.isEmpty())) {
                            z = true;
                        }
                        if (z) {
                            arrayListArrayListOf.clear();
                            arrayListArrayListOf.addAll(arrayList);
                        }
                    }
                }
            }
        }
        return arrayListArrayListOf;
    }

    public static final int c(@NotNull nb0 nb0Var) {
        List<ProgramBean> program;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null) {
            return 500;
        }
        List<ProgramBean> program2 = toyConfigInfoBeanG.getProgram();
        if ((program2 == null || program2.isEmpty()) || !Intrinsics.areEqual(nb0Var.h(), toyConfigInfoBeanG.getType()) || (program = toyConfigInfoBeanG.getProgram()) == null) {
            return 500;
        }
        for (ProgramBean programBean : program) {
            int minv = programBean.getMinv();
            int maxv = programBean.getMaxv();
            int version = nb0Var.getVersion();
            if (minv <= version && version <= maxv) {
                return programBean.getFast() ? 100 : 500;
            }
        }
        return 500;
    }
}
