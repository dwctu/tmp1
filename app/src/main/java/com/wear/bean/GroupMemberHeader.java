package com.wear.bean;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IGroupMember.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/wear/bean/GroupMemberHeader;", "Lcom/wear/bean/IGroupMember;", "count", "", "(I)V", "getCount", "()I", "setCount", "itemViewType", "getItemViewType", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GroupMemberHeader implements IGroupMember {
    private int count;

    public GroupMemberHeader(int i) {
        this.count = i;
    }

    public static /* synthetic */ GroupMemberHeader copy$default(GroupMemberHeader groupMemberHeader, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = groupMemberHeader.count;
        }
        return groupMemberHeader.copy(i);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    @NotNull
    public final GroupMemberHeader copy(int count) {
        return new GroupMemberHeader(count);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GroupMemberHeader) && this.count == ((GroupMemberHeader) other).count;
    }

    public final int getCount() {
        return this.count;
    }

    @Override // com.wear.bean.IGroupMember
    public int getItemViewType() {
        return 0;
    }

    public int hashCode() {
        return this.count;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    @NotNull
    public String toString() {
        return "GroupMemberHeader(count=" + this.count + ')';
    }
}
