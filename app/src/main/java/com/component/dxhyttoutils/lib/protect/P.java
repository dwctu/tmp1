package com.component.dxhyttoutils.lib.protect;

import android.content.Context;
import com.component.dxhyttoutils.lib.bean.HyttoLogContentBean;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import dc.gz;
import dc.mz;
import dc.pz;
import dc.xd0;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0086 J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007J\t\u0010\u000f\u001a\u00020\u000bH\u0086 J)\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\rH\u0086 J\b\u0010\u0013\u001a\u00020\u0014H\u0007¨\u0006\u0015"}, d2 = {"Lcom/component/dxhyttoutils/lib/protect/P;", "", "()V", "_free", "", "a", "", "e", GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, "", "_log", "", "eventId", "", "elementContent", "_malloc", "_rand", "Landroid/content/Context;", "c", "_strlen", "", "hytto-apps.android.components.base:dxhyttoutils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class P {

    @NotNull
    public static final P INSTANCE = new P();

    static {
        System.loadLibrary("dxp");
    }

    private P() {
    }

    @JvmStatic
    public static final void _log(@NotNull String eventId, @Nullable String elementContent) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        if (eventId.length() == 0) {
            return;
        }
        String content = xd0.h().toJson(new HyttoLogContentBean(eventId, elementContent));
        mz mzVarB = gz.a.b();
        Intrinsics.checkNotNullExpressionValue(content, "content");
        mzVarB.b("Z0002", content);
    }

    @JvmStatic
    public static final boolean _strlen() {
        return pz.a.e();
    }

    @Nullable
    public final native byte[] _free(int a, int e, long d);

    public final native void _malloc();

    @Nullable
    public final native String _rand(@Nullable Context e, @Nullable String c, @Nullable String d);
}
