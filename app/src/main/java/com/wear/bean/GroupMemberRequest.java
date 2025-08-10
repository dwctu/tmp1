package com.wear.bean;

import com.epicgames.unreal.psoservices.PSOProgramService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IGroupMember.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/wear/bean/GroupMemberRequest;", "Lcom/wear/bean/IGroupMember;", PSOProgramService.JobID_Key, "", "name", "avatar", "type", "", "inviteBy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getInviteBy", "itemViewType", "getItemViewType", "()I", "getJid", "getName", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/wear/bean/GroupMemberRequest;", "equals", "", "other", "", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GroupMemberRequest implements IGroupMember {

    @Nullable
    private final String avatar;

    @Nullable
    private final String inviteBy;

    @Nullable
    private final String jid;

    @Nullable
    private final String name;

    @Nullable
    private final Integer type;

    public GroupMemberRequest(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable String str4) {
        this.jid = str;
        this.name = str2;
        this.avatar = str3;
        this.type = num;
        this.inviteBy = str4;
    }

    public static /* synthetic */ GroupMemberRequest copy$default(GroupMemberRequest groupMemberRequest, String str, String str2, String str3, Integer num, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = groupMemberRequest.jid;
        }
        if ((i & 2) != 0) {
            str2 = groupMemberRequest.name;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = groupMemberRequest.avatar;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            num = groupMemberRequest.type;
        }
        Integer num2 = num;
        if ((i & 16) != 0) {
            str4 = groupMemberRequest.inviteBy;
        }
        return groupMemberRequest.copy(str, str5, str6, num2, str4);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getJid() {
        return this.jid;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getInviteBy() {
        return this.inviteBy;
    }

    @NotNull
    public final GroupMemberRequest copy(@Nullable String jid, @Nullable String name, @Nullable String avatar, @Nullable Integer type, @Nullable String inviteBy) {
        return new GroupMemberRequest(jid, name, avatar, type, inviteBy);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupMemberRequest)) {
            return false;
        }
        GroupMemberRequest groupMemberRequest = (GroupMemberRequest) other;
        return Intrinsics.areEqual(this.jid, groupMemberRequest.jid) && Intrinsics.areEqual(this.name, groupMemberRequest.name) && Intrinsics.areEqual(this.avatar, groupMemberRequest.avatar) && Intrinsics.areEqual(this.type, groupMemberRequest.type) && Intrinsics.areEqual(this.inviteBy, groupMemberRequest.inviteBy);
    }

    @Nullable
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getInviteBy() {
        return this.inviteBy;
    }

    @Override // com.wear.bean.IGroupMember
    public int getItemViewType() {
        return 2;
    }

    @Nullable
    public final String getJid() {
        return this.jid;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.jid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.avatar;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.type;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.inviteBy;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "GroupMemberRequest(jid=" + this.jid + ", name=" + this.name + ", avatar=" + this.avatar + ", type=" + this.type + ", inviteBy=" + this.inviteBy + ')';
    }
}
