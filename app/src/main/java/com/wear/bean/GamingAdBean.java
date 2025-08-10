package com.wear.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GamingAdBean.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/wear/bean/GamingAdBean;", "", "logo", "", "", "(Ljava/util/List;)V", "getLogo", "()Ljava/util/List;", "setLogo", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GamingAdBean {

    @Nullable
    private List<String> logo;

    public GamingAdBean(@Nullable List<String> list) {
        this.logo = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GamingAdBean copy$default(GamingAdBean gamingAdBean, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = gamingAdBean.logo;
        }
        return gamingAdBean.copy(list);
    }

    @Nullable
    public final List<String> component1() {
        return this.logo;
    }

    @NotNull
    public final GamingAdBean copy(@Nullable List<String> logo) {
        return new GamingAdBean(logo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GamingAdBean) && Intrinsics.areEqual(this.logo, ((GamingAdBean) other).logo);
    }

    @Nullable
    public final List<String> getLogo() {
        return this.logo;
    }

    public int hashCode() {
        List<String> list = this.logo;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final void setLogo(@Nullable List<String> list) {
        this.logo = list;
    }

    @NotNull
    public String toString() {
        return "GamingAdBean(logo=" + this.logo + ')';
    }
}
