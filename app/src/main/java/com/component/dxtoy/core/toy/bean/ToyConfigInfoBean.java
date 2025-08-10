package com.component.dxtoy.core.toy.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyConfigInfoBean.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010L\u001a\u0004\u0018\u00010\u000eR\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR(\u0010\u001d\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR\"\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\tR\"\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR\"\u0010'\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0010\"\u0004\b3\u0010\u0012R\"\u00104\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR\"\u00107\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0007\"\u0004\b:\u0010\tR\"\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0007\"\u0004\b=\u0010\tR\"\u0010>\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0007\"\u0004\bA\u0010\tR\"\u0010B\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0007\"\u0004\bD\u0010\tR\"\u0010E\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0007\"\u0004\bH\u0010\tR\u001e\u0010I\u001a\u0004\u0018\u00010\u000e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0010\"\u0004\bK\u0010\u0012¨\u0006M"}, d2 = {"Lcom/component/dxtoy/core/toy/bean/ToyConfigInfoBean;", "Ljava/io/Serializable;", "()V", "changeName", "", "Lcom/component/dxtoy/core/toy/bean/RangeBean;", "getChangeName", "()Ljava/util/List;", "setChangeName", "(Ljava/util/List;)V", "feedbackModeSupport", "getFeedbackModeSupport", "setFeedbackModeSupport", "fullName", "", "getFullName", "()Ljava/lang/String;", "setFullName", "(Ljava/lang/String;)V", "func", "Lcom/component/dxtoy/core/toy/bean/FuncBean;", "getFunc", "()Lcom/component/dxtoy/core/toy/bean/FuncBean;", "setFunc", "(Lcom/component/dxtoy/core/toy/bean/FuncBean;)V", "functionDescription", "Lcom/component/dxtoy/core/toy/bean/FunctionDescriptionBean;", "getFunctionDescription", "setFunctionDescription", "motors", "getMotors", "setMotors", "notSupport", "Lcom/component/dxtoy/core/toy/bean/NotSupport;", "getNotSupport", "setNotSupport", "pinCodeSupport", "getPinCodeSupport", "setPinCodeSupport", "program", "Lcom/component/dxtoy/core/toy/bean/ProgramBean;", "getProgram", "setProgram", "selling", "", "getSelling", "()Z", "setSelling", "(Z)V", "showName", "getShowName", "setShowName", "supportLEDColor", "getSupportLEDColor", "setSupportLEDColor", "supportLanPattern", "Lcom/component/dxtoy/core/toy/bean/SupportLanPattern;", "getSupportLanPattern", "setSupportLanPattern", "supportMotherboradLEDColor", "getSupportMotherboradLEDColor", "setSupportMotherboradLEDColor", "supportMultiply", "Lcom/component/dxtoy/core/toy/bean/SupportMultiply;", "getSupportMultiply", "setSupportMultiply", "symbol", "getSymbol", "setSymbol", "tv", "Lcom/component/dxtoy/core/toy/bean/TvBean;", "getTv", "setTv", "type", "getType", "setType", "getRealType", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ToyConfigInfoBean implements Serializable {

    @Nullable
    private List<? extends RangeBean> changeName;

    @Nullable
    private List<? extends RangeBean> feedbackModeSupport;

    @Nullable
    private String fullName;

    @Nullable
    private FuncBean func;

    @Nullable
    private List<FunctionDescriptionBean> functionDescription;

    @Nullable
    private List<? extends List<String>> motors = new ArrayList();

    @Nullable
    private List<NotSupport> notSupport;

    @Nullable
    private List<? extends RangeBean> pinCodeSupport;

    @Nullable
    private List<ProgramBean> program;
    private boolean selling;

    @Nullable
    private String showName;

    @Nullable
    private List<? extends RangeBean> supportLEDColor;

    @Nullable
    private List<SupportLanPattern> supportLanPattern;

    @Nullable
    private List<? extends RangeBean> supportMotherboradLEDColor;

    @Nullable
    private List<SupportMultiply> supportMultiply;

    @Nullable
    private List<String> symbol;

    @Nullable
    private List<TvBean> tv;

    @Nullable
    private String type;

    @Nullable
    public final List<RangeBean> getChangeName() {
        return this.changeName;
    }

    @Nullable
    public final List<RangeBean> getFeedbackModeSupport() {
        return this.feedbackModeSupport;
    }

    @Nullable
    public final String getFullName() {
        return this.fullName;
    }

    @Nullable
    public final FuncBean getFunc() {
        return this.func;
    }

    @Nullable
    public final List<FunctionDescriptionBean> getFunctionDescription() {
        return this.functionDescription;
    }

    @Nullable
    public final List<List<String>> getMotors() {
        return this.motors;
    }

    @Nullable
    public final List<NotSupport> getNotSupport() {
        return this.notSupport;
    }

    @Nullable
    public final List<RangeBean> getPinCodeSupport() {
        return this.pinCodeSupport;
    }

    @Nullable
    public final List<ProgramBean> getProgram() {
        return this.program;
    }

    @Nullable
    public final String getRealType() {
        return getType();
    }

    public final boolean getSelling() {
        return this.selling;
    }

    @Nullable
    public final String getShowName() {
        return this.showName;
    }

    @Nullable
    public final List<RangeBean> getSupportLEDColor() {
        return this.supportLEDColor;
    }

    @Nullable
    public final List<SupportLanPattern> getSupportLanPattern() {
        return this.supportLanPattern;
    }

    @Nullable
    public final List<RangeBean> getSupportMotherboradLEDColor() {
        return this.supportMotherboradLEDColor;
    }

    @Nullable
    public final List<SupportMultiply> getSupportMultiply() {
        return this.supportMultiply;
    }

    @Nullable
    public final List<String> getSymbol() {
        return this.symbol;
    }

    @Nullable
    public final List<TvBean> getTv() {
        return this.tv;
    }

    @Nullable
    public final String getType() {
        String str = this.type;
        if (str == null) {
            return null;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    public final void setChangeName(@Nullable List<? extends RangeBean> list) {
        this.changeName = list;
    }

    public final void setFeedbackModeSupport(@Nullable List<? extends RangeBean> list) {
        this.feedbackModeSupport = list;
    }

    public final void setFullName(@Nullable String str) {
        this.fullName = str;
    }

    public final void setFunc(@Nullable FuncBean funcBean) {
        this.func = funcBean;
    }

    public final void setFunctionDescription(@Nullable List<FunctionDescriptionBean> list) {
        this.functionDescription = list;
    }

    public final void setMotors(@Nullable List<? extends List<String>> list) {
        this.motors = list;
    }

    public final void setNotSupport(@Nullable List<NotSupport> list) {
        this.notSupport = list;
    }

    public final void setPinCodeSupport(@Nullable List<? extends RangeBean> list) {
        this.pinCodeSupport = list;
    }

    public final void setProgram(@Nullable List<ProgramBean> list) {
        this.program = list;
    }

    public final void setSelling(boolean z) {
        this.selling = z;
    }

    public final void setShowName(@Nullable String str) {
        this.showName = str;
    }

    public final void setSupportLEDColor(@Nullable List<? extends RangeBean> list) {
        this.supportLEDColor = list;
    }

    public final void setSupportLanPattern(@Nullable List<SupportLanPattern> list) {
        this.supportLanPattern = list;
    }

    public final void setSupportMotherboradLEDColor(@Nullable List<? extends RangeBean> list) {
        this.supportMotherboradLEDColor = list;
    }

    public final void setSupportMultiply(@Nullable List<SupportMultiply> list) {
        this.supportMultiply = list;
    }

    public final void setSymbol(@Nullable List<String> list) {
        this.symbol = list;
    }

    public final void setTv(@Nullable List<TvBean> list) {
        this.tv = list;
    }

    public final void setType(@Nullable String str) {
        this.type = str;
    }
}
