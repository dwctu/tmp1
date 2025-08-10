package com.wear.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: RouletteStatus.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/wear/bean/RouletteStatus;", "", "()V", "Idle", "MatchFailedGender", "MatchFailedOtherUserDeclined", "MatchFailedTimeoutAgree", "MatchFailedTimeoutNoUser", "MatchSuccess", "Matching", "Lcom/wear/bean/RouletteStatus$Idle;", "Lcom/wear/bean/RouletteStatus$MatchFailedGender;", "Lcom/wear/bean/RouletteStatus$MatchFailedOtherUserDeclined;", "Lcom/wear/bean/RouletteStatus$MatchFailedTimeoutAgree;", "Lcom/wear/bean/RouletteStatus$MatchFailedTimeoutNoUser;", "Lcom/wear/bean/RouletteStatus$MatchSuccess;", "Lcom/wear/bean/RouletteStatus$Matching;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class RouletteStatus {

    /* compiled from: RouletteStatus.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/wear/bean/RouletteStatus$Idle;", "Lcom/wear/bean/RouletteStatus;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Idle extends RouletteStatus {

        @NotNull
        public static final Idle INSTANCE = new Idle();

        private Idle() {
            super(null);
        }
    }

    /* compiled from: RouletteStatus.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/wear/bean/RouletteStatus$MatchFailedGender;", "Lcom/wear/bean/RouletteStatus;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class MatchFailedGender extends RouletteStatus {

        @NotNull
        public static final MatchFailedGender INSTANCE = new MatchFailedGender();

        private MatchFailedGender() {
            super(null);
        }
    }

    /* compiled from: RouletteStatus.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/wear/bean/RouletteStatus$MatchFailedOtherUserDeclined;", "Lcom/wear/bean/RouletteStatus;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class MatchFailedOtherUserDeclined extends RouletteStatus {

        @NotNull
        public static final MatchFailedOtherUserDeclined INSTANCE = new MatchFailedOtherUserDeclined();

        private MatchFailedOtherUserDeclined() {
            super(null);
        }
    }

    /* compiled from: RouletteStatus.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/wear/bean/RouletteStatus$MatchFailedTimeoutAgree;", "Lcom/wear/bean/RouletteStatus;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class MatchFailedTimeoutAgree extends RouletteStatus {

        @NotNull
        public static final MatchFailedTimeoutAgree INSTANCE = new MatchFailedTimeoutAgree();

        private MatchFailedTimeoutAgree() {
            super(null);
        }
    }

    /* compiled from: RouletteStatus.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/wear/bean/RouletteStatus$MatchFailedTimeoutNoUser;", "Lcom/wear/bean/RouletteStatus;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class MatchFailedTimeoutNoUser extends RouletteStatus {

        @NotNull
        public static final MatchFailedTimeoutNoUser INSTANCE = new MatchFailedTimeoutNoUser();

        private MatchFailedTimeoutNoUser() {
            super(null);
        }
    }

    /* compiled from: RouletteStatus.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/wear/bean/RouletteStatus$MatchSuccess;", "Lcom/wear/bean/RouletteStatus;", "findMatchUserBean", "Lcom/wear/bean/FindMatchUserBean;", "(Lcom/wear/bean/FindMatchUserBean;)V", "getFindMatchUserBean", "()Lcom/wear/bean/FindMatchUserBean;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class MatchSuccess extends RouletteStatus {

        @NotNull
        private final FindMatchUserBean findMatchUserBean;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MatchSuccess(@NotNull FindMatchUserBean findMatchUserBean) {
            super(null);
            Intrinsics.checkNotNullParameter(findMatchUserBean, "findMatchUserBean");
            this.findMatchUserBean = findMatchUserBean;
        }

        @NotNull
        public final FindMatchUserBean getFindMatchUserBean() {
            return this.findMatchUserBean;
        }
    }

    /* compiled from: RouletteStatus.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/wear/bean/RouletteStatus$Matching;", "Lcom/wear/bean/RouletteStatus;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Matching extends RouletteStatus {

        @NotNull
        public static final Matching INSTANCE = new Matching();

        private Matching() {
            super(null);
        }
    }

    private RouletteStatus() {
    }

    public /* synthetic */ RouletteStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
