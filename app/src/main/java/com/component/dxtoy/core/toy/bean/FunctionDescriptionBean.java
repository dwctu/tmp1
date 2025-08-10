package com.component.dxtoy.core.toy.bean;

import com.epicgames.unreal.psoservices.PSOProgramService;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyConfigInfoBean.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/component/dxtoy/core/toy/bean/FunctionDescriptionBean;", "Lcom/component/dxtoy/core/toy/bean/RangeBean;", "()V", "fullNames", "", "", "getFullNames", "()[Ljava/lang/String;", "setFullNames", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "shortNames", "getShortNames", "setShortNames", PSOProgramService.VS_Key, "getV", "()Ljava/lang/String;", "setV", "(Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class FunctionDescriptionBean extends RangeBean {

    @Nullable
    private String[] fullNames;

    @Nullable
    private String[] shortNames;

    @Nullable
    private String v;

    @Nullable
    public final String[] getFullNames() {
        return this.fullNames;
    }

    @Nullable
    public final String[] getShortNames() {
        return this.shortNames;
    }

    @Nullable
    public final String getV() {
        return this.v;
    }

    public final void setFullNames(@Nullable String[] strArr) {
        this.fullNames = strArr;
    }

    public final void setShortNames(@Nullable String[] strArr) {
        this.shortNames = strArr;
    }

    public final void setV(@Nullable String str) {
        this.v = str;
    }
}
