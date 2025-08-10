package com.component.dxhyttoutils.lib.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HyttoLogContentBean.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/component/dxhyttoutils/lib/bean/HyttoLogContentBean;", "", "event_id", "", "element_content", "(Ljava/lang/String;Ljava/lang/String;)V", "getElement_content", "()Ljava/lang/String;", "setElement_content", "(Ljava/lang/String;)V", "getEvent_id", "setEvent_id", "hytto-apps.android.components.base:dxhyttoutils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HyttoLogContentBean {

    @Nullable
    private String element_content;

    @NotNull
    private String event_id;

    public HyttoLogContentBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public HyttoLogContentBean(@NotNull String event_id, @Nullable String str) {
        Intrinsics.checkNotNullParameter(event_id, "event_id");
        this.event_id = event_id;
        this.element_content = str;
    }

    @Nullable
    public final String getElement_content() {
        return this.element_content;
    }

    @NotNull
    public final String getEvent_id() {
        return this.event_id;
    }

    public final void setElement_content(@Nullable String str) {
        this.element_content = str;
    }

    public final void setEvent_id(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.event_id = str;
    }

    public /* synthetic */ HyttoLogContentBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : str2);
    }
}
