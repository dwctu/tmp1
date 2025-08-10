package com.wear.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InviteLink.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/wear/bean/InviteLink;", "", "inviteLinkUrl", "", "(Ljava/lang/String;)V", "getInviteLinkUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class InviteLink {

    @Nullable
    private final String inviteLinkUrl;

    public InviteLink() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public InviteLink(@Nullable String str) {
        this.inviteLinkUrl = str;
    }

    public static /* synthetic */ InviteLink copy$default(InviteLink inviteLink, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inviteLink.inviteLinkUrl;
        }
        return inviteLink.copy(str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getInviteLinkUrl() {
        return this.inviteLinkUrl;
    }

    @NotNull
    public final InviteLink copy(@Nullable String inviteLinkUrl) {
        return new InviteLink(inviteLinkUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof InviteLink) && Intrinsics.areEqual(this.inviteLinkUrl, ((InviteLink) other).inviteLinkUrl);
    }

    @Nullable
    public final String getInviteLinkUrl() {
        return this.inviteLinkUrl;
    }

    public int hashCode() {
        String str = this.inviteLinkUrl;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "InviteLink(inviteLinkUrl=" + this.inviteLinkUrl + ')';
    }

    public /* synthetic */ InviteLink(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }
}
