package com.wear.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: RouletteStatus.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/wear/bean/RouletteRequestStatus;", "", "()V", "BanInfo", "Loading", "LoadingFailed", "LoadingSuccess", "Lcom/wear/bean/RouletteRequestStatus$BanInfo;", "Lcom/wear/bean/RouletteRequestStatus$Loading;", "Lcom/wear/bean/RouletteRequestStatus$LoadingFailed;", "Lcom/wear/bean/RouletteRequestStatus$LoadingSuccess;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class RouletteRequestStatus {

    /* compiled from: RouletteStatus.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/wear/bean/RouletteRequestStatus$BanInfo;", "Lcom/wear/bean/RouletteRequestStatus;", "rouletteBan", "Lcom/wear/bean/RouletteBan;", "(Lcom/wear/bean/RouletteBan;)V", "getRouletteBan", "()Lcom/wear/bean/RouletteBan;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class BanInfo extends RouletteRequestStatus {

        @NotNull
        private final RouletteBan rouletteBan;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BanInfo(@NotNull RouletteBan rouletteBan) {
            super(null);
            Intrinsics.checkNotNullParameter(rouletteBan, "rouletteBan");
            this.rouletteBan = rouletteBan;
        }

        @NotNull
        public final RouletteBan getRouletteBan() {
            return this.rouletteBan;
        }
    }

    /* compiled from: RouletteStatus.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/wear/bean/RouletteRequestStatus$Loading;", "Lcom/wear/bean/RouletteRequestStatus;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Loading extends RouletteRequestStatus {

        @NotNull
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(null);
        }
    }

    /* compiled from: RouletteStatus.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/wear/bean/RouletteRequestStatus$LoadingFailed;", "Lcom/wear/bean/RouletteRequestStatus;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class LoadingFailed extends RouletteRequestStatus {

        @NotNull
        public static final LoadingFailed INSTANCE = new LoadingFailed();

        private LoadingFailed() {
            super(null);
        }
    }

    /* compiled from: RouletteStatus.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/wear/bean/RouletteRequestStatus$LoadingSuccess;", "Lcom/wear/bean/RouletteRequestStatus;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class LoadingSuccess extends RouletteRequestStatus {

        @NotNull
        public static final LoadingSuccess INSTANCE = new LoadingSuccess();

        private LoadingSuccess() {
            super(null);
        }
    }

    private RouletteRequestStatus() {
    }

    public /* synthetic */ RouletteRequestStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
