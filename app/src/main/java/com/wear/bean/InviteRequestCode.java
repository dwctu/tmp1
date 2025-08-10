package com.wear.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: InviteFriendLink.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/wear/bean/InviteRequestCode;", "", XHTMLText.CODE, "", "(Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class InviteRequestCode {

    @Nullable
    private final String code;

    public InviteRequestCode(@Nullable String str) {
        this.code = str;
    }

    public static /* synthetic */ InviteRequestCode copy$default(InviteRequestCode inviteRequestCode, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inviteRequestCode.code;
        }
        return inviteRequestCode.copy(str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final InviteRequestCode copy(@Nullable String code) {
        return new InviteRequestCode(code);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof InviteRequestCode) && Intrinsics.areEqual(this.code, ((InviteRequestCode) other).code);
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    public int hashCode() {
        String str = this.code;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "InviteRequestCode(code=" + this.code + ')';
    }
}
