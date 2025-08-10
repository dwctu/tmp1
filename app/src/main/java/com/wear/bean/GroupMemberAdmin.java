package com.wear.bean;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: IGroupMember.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0006\u0010\fR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/wear/bean/GroupMemberAdmin;", "Lcom/wear/bean/IGroupMember;", TtmlNode.ATTR_ID, "", "name", "avatar", "isOwner", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAvatar", "()Ljava/lang/String;", "getId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "itemViewType", "", "getItemViewType", "()I", "getName", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class GroupMemberAdmin implements IGroupMember {

    @Nullable
    private final String avatar;

    @Nullable
    private final String id;

    @Nullable
    private final Boolean isOwner;

    @Nullable
    private final String name;

    public GroupMemberAdmin(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool) {
        this.id = str;
        this.name = str2;
        this.avatar = str3;
        this.isOwner = bool;
    }

    @Nullable
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Override // com.wear.bean.IGroupMember
    public int getItemViewType() {
        return 1;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: isOwner, reason: from getter */
    public final Boolean getIsOwner() {
        return this.isOwner;
    }
}
