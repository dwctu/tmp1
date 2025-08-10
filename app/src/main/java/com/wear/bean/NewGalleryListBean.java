package com.wear.bean;

import dc.of1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: NewGalleryListBean.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JD\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/wear/bean/NewGalleryListBean;", "Ljava/io/Serializable;", XHTMLText.CODE, "", "message", "", "result", "", "data", "", "Lcom/wear/bean/NewGalleryList;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getData", "()Ljava/util/List;", "getMessage", "()Ljava/lang/String;", "getResult", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)Lcom/wear/bean/NewGalleryListBean;", "equals", "other", "", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@of1(generateAdapter = true)
/* loaded from: classes3.dex */
public final /* data */ class NewGalleryListBean implements Serializable {

    @Nullable
    private final Integer code;

    @Nullable
    private final List<NewGalleryList> data;

    @Nullable
    private final String message;

    @Nullable
    private final Boolean result;

    public NewGalleryListBean() {
        this(null, null, null, null, 15, null);
    }

    public NewGalleryListBean(@Nullable Integer num, @Nullable String str, @Nullable Boolean bool, @Nullable List<NewGalleryList> list) {
        this.code = num;
        this.message = str;
        this.result = bool;
        this.data = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NewGalleryListBean copy$default(NewGalleryListBean newGalleryListBean, Integer num, String str, Boolean bool, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            num = newGalleryListBean.code;
        }
        if ((i & 2) != 0) {
            str = newGalleryListBean.message;
        }
        if ((i & 4) != 0) {
            bool = newGalleryListBean.result;
        }
        if ((i & 8) != 0) {
            list = newGalleryListBean.data;
        }
        return newGalleryListBean.copy(num, str, bool, list);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Boolean getResult() {
        return this.result;
    }

    @Nullable
    public final List<NewGalleryList> component4() {
        return this.data;
    }

    @NotNull
    public final NewGalleryListBean copy(@Nullable Integer code, @Nullable String message, @Nullable Boolean result, @Nullable List<NewGalleryList> data) {
        return new NewGalleryListBean(code, message, result, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewGalleryListBean)) {
            return false;
        }
        NewGalleryListBean newGalleryListBean = (NewGalleryListBean) other;
        return Intrinsics.areEqual(this.code, newGalleryListBean.code) && Intrinsics.areEqual(this.message, newGalleryListBean.message) && Intrinsics.areEqual(this.result, newGalleryListBean.result) && Intrinsics.areEqual(this.data, newGalleryListBean.data);
    }

    @Nullable
    public final Integer getCode() {
        return this.code;
    }

    @Nullable
    public final List<NewGalleryList> getData() {
        return this.data;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final Boolean getResult() {
        return this.result;
    }

    public int hashCode() {
        Integer num = this.code;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.message;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.result;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        List<NewGalleryList> list = this.data;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "NewGalleryListBean(code=" + this.code + ", message=" + this.message + ", result=" + this.result + ", data=" + this.data + ')';
    }

    public /* synthetic */ NewGalleryListBean(Integer num, String str, Boolean bool, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? Boolean.FALSE : bool, (i & 8) != 0 ? new ArrayList() : list);
    }
}
