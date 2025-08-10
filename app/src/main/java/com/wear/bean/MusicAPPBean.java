package com.wear.bean;

import android.graphics.drawable.Drawable;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: MusicAPPBean.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001aR\u001c\u0010 \u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\u001c\u0010#\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\b¨\u0006&"}, d2 = {"Lcom/wear/bean/MusicAPPBean;", "", "()V", "className", "", "getClassName", "()Ljava/lang/String;", "setClassName", "(Ljava/lang/String;)V", "iconLogo", "", "getIconLogo", "()Ljava/lang/Integer;", "setIconLogo", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "imageLogo", "Landroid/graphics/drawable/Drawable;", "getImageLogo", "()Landroid/graphics/drawable/Drawable;", "setImageLogo", "(Landroid/graphics/drawable/Drawable;)V", "isCheck", "", "()Ljava/lang/Boolean;", "setCheck", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isInstalled", "setInstalled", "isSupport", "setSupport", Constants.ScionAnalytics.PARAM_LABEL, "getLabel", "setLabel", "packageName", "getPackageName", "setPackageName", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class MusicAPPBean {

    @Nullable
    private Drawable imageLogo;

    @Nullable
    private Boolean isCheck;

    @Nullable
    private Boolean isInstalled;

    @Nullable
    private Boolean isSupport;

    @Nullable
    private String packageName = "";

    @Nullable
    private String className = "";

    @Nullable
    private String label = "";

    @Nullable
    private Integer iconLogo = 0;

    public MusicAPPBean() {
        Boolean bool = Boolean.FALSE;
        this.isCheck = bool;
        this.isSupport = bool;
        this.isInstalled = bool;
    }

    @Nullable
    public final String getClassName() {
        return this.className;
    }

    @Nullable
    public final Integer getIconLogo() {
        return this.iconLogo;
    }

    @Nullable
    public final Drawable getImageLogo() {
        return this.imageLogo;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    public final String getPackageName() {
        return this.packageName;
    }

    @Nullable
    /* renamed from: isCheck, reason: from getter */
    public final Boolean getIsCheck() {
        return this.isCheck;
    }

    @Nullable
    /* renamed from: isInstalled, reason: from getter */
    public final Boolean getIsInstalled() {
        return this.isInstalled;
    }

    @Nullable
    /* renamed from: isSupport, reason: from getter */
    public final Boolean getIsSupport() {
        return this.isSupport;
    }

    public final void setCheck(@Nullable Boolean bool) {
        this.isCheck = bool;
    }

    public final void setClassName(@Nullable String str) {
        this.className = str;
    }

    public final void setIconLogo(@Nullable Integer num) {
        this.iconLogo = num;
    }

    public final void setImageLogo(@Nullable Drawable drawable) {
        this.imageLogo = drawable;
    }

    public final void setInstalled(@Nullable Boolean bool) {
        this.isInstalled = bool;
    }

    public final void setLabel(@Nullable String str) {
        this.label = str;
    }

    public final void setPackageName(@Nullable String str) {
        this.packageName = str;
    }

    public final void setSupport(@Nullable Boolean bool) {
        this.isSupport = bool;
    }
}
