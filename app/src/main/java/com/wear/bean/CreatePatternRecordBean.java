package com.wear.bean;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CreatePatternRecordBean.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J3\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0002\u0010\u001aJ\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/wear/bean/CreatePatternRecordBean;", "", "count", "", "groups", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(ILjava/util/ArrayList;)V", "getCount", "()I", "setCount", "(I)V", "getGroups", "()Ljava/util/ArrayList;", "setGroups", "(Ljava/util/ArrayList;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "reset", "", "(Ljava/lang/Integer;Ljava/util/ArrayList;)V", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CreatePatternRecordBean {
    private int count;

    @NotNull
    private ArrayList<String> groups;

    public CreatePatternRecordBean(int i, @NotNull ArrayList<String> groups) {
        Intrinsics.checkNotNullParameter(groups, "groups");
        this.count = i;
        this.groups = groups;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreatePatternRecordBean copy$default(CreatePatternRecordBean createPatternRecordBean, int i, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = createPatternRecordBean.count;
        }
        if ((i2 & 2) != 0) {
            arrayList = createPatternRecordBean.groups;
        }
        return createPatternRecordBean.copy(i, arrayList);
    }

    public static /* synthetic */ void reset$default(CreatePatternRecordBean createPatternRecordBean, Integer num, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            num = 0;
        }
        createPatternRecordBean.reset(num, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    @NotNull
    public final ArrayList<String> component2() {
        return this.groups;
    }

    @NotNull
    public final CreatePatternRecordBean copy(int count, @NotNull ArrayList<String> groups) {
        Intrinsics.checkNotNullParameter(groups, "groups");
        return new CreatePatternRecordBean(count, groups);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreatePatternRecordBean)) {
            return false;
        }
        CreatePatternRecordBean createPatternRecordBean = (CreatePatternRecordBean) other;
        return this.count == createPatternRecordBean.count && Intrinsics.areEqual(this.groups, createPatternRecordBean.groups);
    }

    public final int getCount() {
        return this.count;
    }

    @NotNull
    public final ArrayList<String> getGroups() {
        return this.groups;
    }

    public int hashCode() {
        return (this.count * 31) + this.groups.hashCode();
    }

    public final void reset(@Nullable Integer count, @Nullable ArrayList<String> groups) {
        this.count = count != null ? count.intValue() : 0;
        this.groups.clear();
        if (groups != null) {
            this.groups.addAll(groups);
        }
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final void setGroups(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.groups = arrayList;
    }

    @NotNull
    public String toString() {
        return "CreatePatternRecordBean(count=" + this.count + ", groups=" + this.groups + ')';
    }
}
