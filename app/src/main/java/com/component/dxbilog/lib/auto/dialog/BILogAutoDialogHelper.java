package com.component.dxbilog.lib.auto.dialog;

import android.app.Dialog;
import androidx.annotation.Keep;
import androidx.core.graphics.drawable.IconCompat;
import dc.sr;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogAutoDialogHelper.kt */
@Keep
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxbilog/lib/auto/dialog/BILogAutoDialogHelper;", "", "()V", "Companion", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BILogAutoDialogHelper {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: BILogAutoDialogHelper.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0007J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\u0007"}, d2 = {"Lcom/component/dxbilog/lib/auto/dialog/BILogAutoDialogHelper$Companion;", "", "()V", "trackDialogStart", "", IconCompat.EXTRA_OBJ, "trackDialogStop", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Keep
        public final void trackDialogStart(@Nullable Object obj) {
            if (obj == null || !(obj instanceof Dialog)) {
                return;
            }
            sr.a.b((Dialog) obj);
        }

        @JvmStatic
        @Keep
        public final void trackDialogStop(@Nullable Object obj) {
            if (obj == null || !(obj instanceof Dialog)) {
                return;
            }
            sr.a.c((Dialog) obj);
        }
    }

    @JvmStatic
    @Keep
    public static final void trackDialogStart(@Nullable Object obj) {
        INSTANCE.trackDialogStart(obj);
    }

    @JvmStatic
    @Keep
    public static final void trackDialogStop(@Nullable Object obj) {
        INSTANCE.trackDialogStop(obj);
    }
}
