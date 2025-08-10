package com.component.dxbilog.lib.auto.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Keep;
import androidx.core.graphics.drawable.IconCompat;
import dc.ur;
import dc.xr;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogAutoFragmentHelper.kt */
@Keep
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxbilog/lib/auto/fragment/BILogAutoFragmentHelper;", "", "()V", "Companion", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BILogAutoFragmentHelper {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: BILogAutoFragmentHelper.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0007J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0007J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0007J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0007J\u001a\u0010\u0011\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0012\u001a\u00020\u000eH\u0007¨\u0006\u0013"}, d2 = {"Lcom/component/dxbilog/lib/auto/fragment/BILogAutoFragmentHelper$Companion;", "", "()V", "onFragmentViewCreated", "", IconCompat.EXTRA_OBJ, "rootView", "Landroid/view/View;", "bundle", "Landroid/os/Bundle;", "trackFragmentPause", "trackFragmentResume", "trackFragmentSetUserVisibleHint", "isVisibleToUser", "", "trackFragmentStart", "trackFragmentStop", "trackOnHiddenChanged", "hidden", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Keep
        public final void onFragmentViewCreated(@Nullable Object obj, @Nullable View rootView, @Nullable Bundle bundle) {
            if (xr.e(obj)) {
                ur.a aVar = ur.a;
                Intrinsics.checkNotNull(obj);
                Intrinsics.checkNotNull(rootView);
                aVar.g(obj, rootView, bundle);
            }
        }

        @JvmStatic
        @Keep
        public final void trackFragmentPause(@Nullable Object obj) {
            if (xr.e(obj)) {
                ur.a aVar = ur.a;
                Intrinsics.checkNotNull(obj);
                aVar.c(obj);
            }
        }

        @JvmStatic
        @Keep
        public final void trackFragmentResume(@Nullable Object obj) {
            if (xr.e(obj)) {
                ur.a aVar = ur.a;
                Intrinsics.checkNotNull(obj);
                aVar.d(obj);
            }
        }

        @JvmStatic
        @Keep
        public final void trackFragmentSetUserVisibleHint(@Nullable Object obj, boolean isVisibleToUser) {
            if (xr.e(obj)) {
                ur.a aVar = ur.a;
                Intrinsics.checkNotNull(obj);
                aVar.h(obj, isVisibleToUser);
            }
        }

        @JvmStatic
        @Keep
        public final void trackFragmentStart(@Nullable Object obj) {
            if (xr.e(obj)) {
                ur.a.e(obj);
            }
        }

        @JvmStatic
        @Keep
        public final void trackFragmentStop(@Nullable Object obj) {
            if (xr.e(obj)) {
                ur.a.f(obj);
            }
        }

        @JvmStatic
        @Keep
        public final void trackOnHiddenChanged(@Nullable Object obj, boolean hidden) {
            if (xr.e(obj)) {
                ur.a aVar = ur.a;
                Intrinsics.checkNotNull(obj);
                aVar.b(obj, hidden);
            }
        }
    }

    @JvmStatic
    @Keep
    public static final void onFragmentViewCreated(@Nullable Object obj, @Nullable View view, @Nullable Bundle bundle) {
        INSTANCE.onFragmentViewCreated(obj, view, bundle);
    }

    @JvmStatic
    @Keep
    public static final void trackFragmentPause(@Nullable Object obj) {
        INSTANCE.trackFragmentPause(obj);
    }

    @JvmStatic
    @Keep
    public static final void trackFragmentResume(@Nullable Object obj) {
        INSTANCE.trackFragmentResume(obj);
    }

    @JvmStatic
    @Keep
    public static final void trackFragmentSetUserVisibleHint(@Nullable Object obj, boolean z) {
        INSTANCE.trackFragmentSetUserVisibleHint(obj, z);
    }

    @JvmStatic
    @Keep
    public static final void trackFragmentStart(@Nullable Object obj) {
        INSTANCE.trackFragmentStart(obj);
    }

    @JvmStatic
    @Keep
    public static final void trackFragmentStop(@Nullable Object obj) {
        INSTANCE.trackFragmentStop(obj);
    }

    @JvmStatic
    @Keep
    public static final void trackOnHiddenChanged(@Nullable Object obj, boolean z) {
        INSTANCE.trackOnHiddenChanged(obj, z);
    }
}
