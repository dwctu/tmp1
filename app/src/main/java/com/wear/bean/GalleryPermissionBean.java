package com.wear.bean;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: GalleryPermissionBean.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/wear/bean/GalleryPermissionBean;", "", "()V", "galleryAccountId", "", "getGalleryAccountId", "()Ljava/lang/String;", "setGalleryAccountId", "(Ljava/lang/String;)V", "galleryPermission", "", "Lcom/wear/bean/GalleryPermission;", "getGalleryPermission", "()Ljava/util/List;", "setGalleryPermission", "(Ljava/util/List;)V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class GalleryPermissionBean {

    @Nullable
    private String galleryAccountId = "";

    @Nullable
    private List<GalleryPermission> galleryPermission = new ArrayList();

    @Nullable
    public final String getGalleryAccountId() {
        return this.galleryAccountId;
    }

    @Nullable
    public final List<GalleryPermission> getGalleryPermission() {
        return this.galleryPermission;
    }

    public final void setGalleryAccountId(@Nullable String str) {
        this.galleryAccountId = str;
    }

    public final void setGalleryPermission(@Nullable List<GalleryPermission> list) {
        this.galleryPermission = list;
    }
}
