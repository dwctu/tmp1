package com.wear.bean;

import com.google.android.gms.common.internal.ImagesContract;
import dc.tq;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ReportChooseImageBean.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/wear/bean/ReportChooseImageBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "itemType", "", "(I)V", "getItemType", "()I", ImagesContract.URL, "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ReportChooseImageBean implements tq {
    private final int itemType;

    @NotNull
    private String url = "";

    public ReportChooseImageBean(int i) {
        this.itemType = i;
    }

    @Override // dc.tq
    public int getItemType() {
        return this.itemType;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }
}
