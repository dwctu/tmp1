package com.wear.bean;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: GalleryAccount.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/wear/bean/GalleryAccount;", "", "()V", "galleryAccountAvatar", "", "getGalleryAccountAvatar", "()Ljava/lang/String;", "setGalleryAccountAvatar", "(Ljava/lang/String;)V", "galleryAccountName", "getGalleryAccountName", "setGalleryAccountName", "galleryRemoteAccountId", "getGalleryRemoteAccountId", "setGalleryRemoteAccountId", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class GalleryAccount {

    @Nullable
    private String galleryAccountName = "";

    @Nullable
    private String galleryAccountAvatar = "";

    @Nullable
    private String galleryRemoteAccountId = "";

    @Nullable
    public final String getGalleryAccountAvatar() {
        return this.galleryAccountAvatar;
    }

    @Nullable
    public final String getGalleryAccountName() {
        return this.galleryAccountName;
    }

    @Nullable
    public final String getGalleryRemoteAccountId() {
        return this.galleryRemoteAccountId;
    }

    public final void setGalleryAccountAvatar(@Nullable String str) {
        this.galleryAccountAvatar = str;
    }

    public final void setGalleryAccountName(@Nullable String str) {
        this.galleryAccountName = str;
    }

    public final void setGalleryRemoteAccountId(@Nullable String str) {
        this.galleryRemoteAccountId = str;
    }
}
