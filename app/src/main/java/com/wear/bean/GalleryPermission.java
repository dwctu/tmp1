package com.wear.bean;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: GalleryPermissionBean.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/wear/bean/GalleryPermission;", "", "()V", "isPermission", "", "()Ljava/lang/Boolean;", "setPermission", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "scope", "", "getScope", "()Ljava/lang/String;", "setScope", "(Ljava/lang/String;)V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class GalleryPermission {

    @Nullable
    private String scope = "";

    @Nullable
    private Boolean isPermission = Boolean.FALSE;

    @Nullable
    public final String getScope() {
        return this.scope;
    }

    @Nullable
    /* renamed from: isPermission, reason: from getter */
    public final Boolean getIsPermission() {
        return this.isPermission;
    }

    public final void setPermission(@Nullable Boolean bool) {
        this.isPermission = bool;
    }

    public final void setScope(@Nullable String str) {
        this.scope = str;
    }
}
