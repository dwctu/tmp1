package com.wear.bean.chat;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import org.jetbrains.annotations.NotNull;

/* compiled from: SignalingType.kt */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/wear/bean/chat/SignalingType;", "", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD, AnnotationTarget.FUNCTION})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes3.dex */
public @interface SignalingType {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @NotNull
    public static final String TYPE_LIVE_CONTROL = "LiveControl";

    @NotNull
    public static final String TYPE_SWITCH_CONTROLLER = "SwitchControlMode";

    @NotNull
    public static final String TYPE_SWITCH_CONTROL_TOY = "SwitchControlToy";

    @NotNull
    public static final String TYPE_SWITCH_SYNC_MODE = "SwitchPanelMode";

    @NotNull
    public static final String TYPE_SYNC_CONTROL = "SyncControl";

    /* compiled from: SignalingType.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/wear/bean/chat/SignalingType$Companion;", "", "()V", "TYPE_LIVE_CONTROL", "", "TYPE_SWITCH_CONTROLLER", "TYPE_SWITCH_CONTROL_TOY", "TYPE_SWITCH_SYNC_MODE", "TYPE_SYNC_CONTROL", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String TYPE_LIVE_CONTROL = "LiveControl";

        @NotNull
        public static final String TYPE_SWITCH_CONTROLLER = "SwitchControlMode";

        @NotNull
        public static final String TYPE_SWITCH_CONTROL_TOY = "SwitchControlToy";

        @NotNull
        public static final String TYPE_SWITCH_SYNC_MODE = "SwitchPanelMode";

        @NotNull
        public static final String TYPE_SYNC_CONTROL = "SyncControl";

        private Companion() {
        }
    }
}
