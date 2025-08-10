package dc;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DbQuery.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 92\u00020\u0001:\u00029:B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0000J\u0016\u0010%\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0001J\u0016\u0010'\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0001J\u0011\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)¢\u0006\u0002\u0010+J\u0016\u0010,\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0001J%\u0010-\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00042\u0010\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010)¢\u0006\u0002\u0010/J\u0016\u00100\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0001J\u0016\u00101\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0001J\u0016\u00102\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0001J\u0016\u00103\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0001J%\u00104\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00042\u0010\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010)¢\u0006\u0002\u0010/J\u000e\u00105\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0000J#\u00106\u001a\u0002072\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040)¢\u0006\u0002\u00108R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001aj\b\u0012\u0004\u0012\u00020\u0004`\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006¨\u0006;"}, d2 = {"Lcom/component/dxdatabase/lib/DbQuery;", "", "()V", "groupBy", "", "getGroupBy", "()Ljava/lang/String;", "setGroupBy", "(Ljava/lang/String;)V", "having", "getHaving", "setHaving", "limit", "", "getLimit", "()Ljava/lang/Integer;", "setLimit", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", TypedValues.CycleType.S_WAVE_OFFSET, "getOffset", "setOffset", "orderBy", "getOrderBy", "setOrderBy", "whereArgs", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "<set-?>", "whereClause", "getWhereClause", "addSort", "paramString", "paramSortOrder", "Lcom/component/dxdatabase/lib/DbQuery$SortOrder;", "and", "storageQuery", "eq", "paramObject", "ge", "getWhereArgs", "", "Ljava/lang/Object;", "()[Ljava/lang/Object;", "gt", "in", "paramArrayOfObject", "(Ljava/lang/String;[Ljava/lang/Object;)Lcom/component/dxdatabase/lib/DbQuery;", "le", "like", "lt", "neq", "notIn", "or", "setWhereClause", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "Companion", "SortOrder", "hytto-apps.android.components.base.dxdatabase"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class tw {

    @Nullable
    public String a = "";

    @NotNull
    public ArrayList<String> b = new ArrayList<>();

    @Nullable
    public String c;

    @Nullable
    public String d;

    @Nullable
    public String e;

    @Nullable
    public Integer f;

    @Nullable
    public Integer g;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getD() {
        return this.d;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getC() {
        return this.c;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Integer getF() {
        return this.f;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final Integer getG() {
        return this.g;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getE() {
        return this.e;
    }

    @NotNull
    public final Object[] f() {
        Object[] array = this.b.toArray();
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<java.lang.Object>");
        return array;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final String getA() {
        return this.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00ae  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final dc.tw h(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.Nullable java.lang.Object[] r6) {
        /*
            r4 = this;
            java.lang.String r0 = "paramString"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = r4.a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L22
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r4.a
            r0.append(r1)
            java.lang.String r1 = " and "
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r4.a = r0
        L22:
            r0 = 32
            if (r6 == 0) goto Lae
            int r1 = r6.length
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L2d
            r1 = 1
            goto L2e
        L2d:
            r1 = 0
        L2e:
            r1 = r1 ^ r3
            if (r1 == 0) goto Lae
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = r4.a
            r1.append(r3)
            r1.append(r0)
            r1.append(r5)
            java.lang.String r5 = " in ( "
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r4.a = r5
            int r5 = r6.length
        L4d:
            if (r2 >= r5) goto L7e
            if (r2 == 0) goto L66
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r4.a
            r0.append(r1)
            java.lang.String r1 = " , "
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r4.a = r0
        L66:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r4.a
            r0.append(r1)
            java.lang.String r1 = " ? "
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r4.a = r0
            int r2 = r2 + 1
            goto L4d
        L7e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = r4.a
            r5.append(r0)
            java.lang.String r0 = " ) "
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            r4.a = r5
            java.util.Iterator r5 = kotlin.jvm.internal.ArrayIteratorKt.iterator(r6)
        L97:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto Lc4
            java.lang.Object r6 = r5.next()
            java.util.ArrayList<java.lang.String> r0 = r4.b
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.String"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r1)
            java.lang.String r6 = (java.lang.String) r6
            r0.add(r6)
            goto L97
        Lae:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r1 = r4.a
            r6.append(r1)
            r6.append(r0)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            r4.a = r5
        Lc4:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.tw.h(java.lang.String, java.lang.Object[]):dc.tw");
    }

    @NotNull
    public final tw i(@NotNull String paramString, @NotNull Object paramObject) {
        Intrinsics.checkNotNullParameter(paramString, "paramString");
        Intrinsics.checkNotNullParameter(paramObject, "paramObject");
        if (!TextUtils.isEmpty(this.a)) {
            this.a += " and ";
        }
        this.a += ' ' + paramString + " <= ? ";
        this.b.add(paramObject.toString());
        return this;
    }

    public final void j(@Nullable Integer num) {
        this.f = num;
    }
}
