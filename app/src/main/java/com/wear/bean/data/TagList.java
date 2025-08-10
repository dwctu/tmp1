package com.wear.bean.data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.bean.BaseEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AudioBookTagBean.kt */
@DatabaseTable(tableName = "tb_audio_book_tag")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J0\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/wear/bean/data/TagList;", "Lcom/wear/bean/BaseEntity;", "name", "", "canSelect", "", "select", "", "(Ljava/lang/String;Ljava/lang/Integer;Z)V", "getCanSelect", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getSelect", "()Z", "setSelect", "(Z)V", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Z)Lcom/wear/bean/data/TagList;", "equals", "other", "", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TagList extends BaseEntity {

    @Nullable
    private final Integer canSelect;

    @DatabaseField
    @Nullable
    private final String name;
    private boolean select;

    public TagList() {
        this(null, null, false, 7, null);
    }

    public /* synthetic */ TagList(String str, Integer num, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 1 : num, (i & 4) != 0 ? false : z);
    }

    public static /* synthetic */ TagList copy$default(TagList tagList, String str, Integer num, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tagList.name;
        }
        if ((i & 2) != 0) {
            num = tagList.canSelect;
        }
        if ((i & 4) != 0) {
            z = tagList.select;
        }
        return tagList.copy(str, num, z);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getCanSelect() {
        return this.canSelect;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getSelect() {
        return this.select;
    }

    @NotNull
    public final TagList copy(@Nullable String name, @Nullable Integer canSelect, boolean select) {
        return new TagList(name, canSelect, select);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TagList)) {
            return false;
        }
        TagList tagList = (TagList) other;
        return Intrinsics.areEqual(this.name, tagList.name) && Intrinsics.areEqual(this.canSelect, tagList.canSelect) && this.select == tagList.select;
    }

    @Nullable
    public final Integer getCanSelect() {
        return this.canSelect;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public final boolean getSelect() {
        return this.select;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.canSelect;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 31;
        boolean z = this.select;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode2 + i;
    }

    public final void setSelect(boolean z) {
        this.select = z;
    }

    @NotNull
    public String toString() {
        return "TagList(name=" + this.name + ", canSelect=" + this.canSelect + ", select=" + this.select + ')';
    }

    public TagList(@Nullable String str, @Nullable Integer num, boolean z) {
        this.name = str;
        this.canSelect = num;
        this.select = z;
    }
}
