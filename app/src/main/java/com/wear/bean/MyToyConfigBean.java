package com.wear.bean;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MyToyConfigBean.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/wear/bean/MyToyConfigBean;", "", "()V", "config", "Lcom/wear/bean/ToyStrength;", "getConfig", "()Lcom/wear/bean/ToyStrength;", "setConfig", "(Lcom/wear/bean/ToyStrength;)V", "configType", "", "getConfigType", "()I", "setConfigType", "(I)V", "funName", "", "getFunName", "()Ljava/lang/String;", "setFunName", "(Ljava/lang/String;)V", "tfunIcon", "getTfunIcon", "setTfunIcon", "toy", "Lcom/wear/bean/Toy;", "getToy", "()Lcom/wear/bean/Toy;", "setToy", "(Lcom/wear/bean/Toy;)V", "toyStrength", "", "getToyStrength", "()Ljava/lang/Float;", "setToyStrength", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "ToyConfigType", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class MyToyConfigBean {

    @Nullable
    private ToyStrength config;
    private int configType;
    private int tfunIcon;

    @Nullable
    private Toy toy;

    @Nullable
    private String funName = "Unknown";

    @Nullable
    private Float toyStrength = Float.valueOf(0.0f);

    /* compiled from: MyToyConfigBean.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/wear/bean/MyToyConfigBean$ToyConfigType;", "", "()V", "SPEED", "", "getSPEED", "()I", "STRENGTH", "getSTRENGTH", "STROKE", "getSTROKE", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ToyConfigType {
        private static final int STRENGTH = 0;

        @NotNull
        public static final ToyConfigType INSTANCE = new ToyConfigType();
        private static final int STROKE = 1;
        private static final int SPEED = 2;

        private ToyConfigType() {
        }

        public final int getSPEED() {
            return SPEED;
        }

        public final int getSTRENGTH() {
            return STRENGTH;
        }

        public final int getSTROKE() {
            return STROKE;
        }
    }

    @Nullable
    public final ToyStrength getConfig() {
        return this.config;
    }

    public final int getConfigType() {
        return this.configType;
    }

    @Nullable
    public final String getFunName() {
        return this.funName;
    }

    public final int getTfunIcon() {
        return this.tfunIcon;
    }

    @Nullable
    public final Toy getToy() {
        return this.toy;
    }

    @Nullable
    public final Float getToyStrength() {
        return this.toyStrength;
    }

    public final void setConfig(@Nullable ToyStrength toyStrength) {
        this.config = toyStrength;
    }

    public final void setConfigType(int i) {
        this.configType = i;
    }

    public final void setFunName(@Nullable String str) {
        this.funName = str;
    }

    public final void setTfunIcon(int i) {
        this.tfunIcon = i;
    }

    public final void setToy(@Nullable Toy toy) {
        this.toy = toy;
    }

    public final void setToyStrength(@Nullable Float f) {
        this.toyStrength = f;
    }
}
