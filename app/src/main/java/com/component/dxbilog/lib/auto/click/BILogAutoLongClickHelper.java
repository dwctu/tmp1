package com.component.dxbilog.lib.auto.click;

import android.view.View;
import androidx.annotation.Keep;
import com.component.dxbilog.lib.auto.click.BILogAutoClickHelperExit;
import com.component.dxbilog.lib.bean.BILogContentBean;
import dc.is;
import dc.js;
import dc.ks;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogAutoLongClickHelper.kt */
@Keep
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxbilog/lib/auto/click/BILogAutoLongClickHelper;", "", "()V", "Companion", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BILogAutoLongClickHelper {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: BILogAutoLongClickHelper.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\u000b"}, d2 = {"Lcom/component/dxbilog/lib/auto/click/BILogAutoLongClickHelper$Companion;", "", "()V", "isIntercept", "", "view", "isWithRepeat", "trackViewOnLongClickEnter", "", "Landroid/view/View;", "trackViewOnLongClickExit", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ boolean b(Companion companion, Object obj, boolean z, int i, Object obj2) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.a(obj, z);
        }

        public final boolean a(Object obj, boolean z) {
            return !ks.a.e() || (z && is.a.h(obj)) || js.a.e(obj);
        }

        @JvmStatic
        @Keep
        public final void trackViewOnLongClickEnter(@Nullable View view) {
            if (view == null) {
                return;
            }
            try {
                if (a(view, true)) {
                    return;
                }
                is.a.j(view);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @JvmStatic
        @Keep
        public final void trackViewOnLongClickExit(@Nullable View view) {
            if (view == null) {
                return;
            }
            try {
                if (b(this, view, false, 2, null)) {
                    return;
                }
                BILogContentBean bILogContentBeanA = js.a.a(view);
                String event_type = bILogContentBeanA.getEvent_type();
                if (event_type == null) {
                    event_type = "long_click";
                }
                bILogContentBeanA.setEvent_type(event_type);
                BILogAutoClickHelperExit.Companion.e(BILogAutoClickHelperExit.INSTANCE, view, bILogContentBeanA, false, 4, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @JvmStatic
    @Keep
    public static final void trackViewOnLongClickEnter(@Nullable View view) {
        INSTANCE.trackViewOnLongClickEnter(view);
    }

    @JvmStatic
    @Keep
    public static final void trackViewOnLongClickExit(@Nullable View view) {
        INSTANCE.trackViewOnLongClickExit(view);
    }
}
