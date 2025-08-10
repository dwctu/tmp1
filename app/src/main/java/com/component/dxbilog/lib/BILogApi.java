package com.component.dxbilog.lib;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.graphics.drawable.IconCompat;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.component.dxbilog.lib.bean.BILogConfig;
import com.google.firebase.analytics.FirebaseAnalytics;
import dc.as;
import dc.pd;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogApi.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u0006H\u0007J\b\u0010\u000f\u001a\u00020\u0006H\u0007J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J$\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0007J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u001fH\u0007J\u001a\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$H\u0007J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010#\u001a\u00020$H\u0007J\u001a\u0010%\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$H\u0007J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$H\u0007J\u001a\u0010&\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010#\u001a\u00020$H\u0007J\u001a\u0010&\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010#\u001a\u00020$H\u0007J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$H\u0007J\u001a\u0010+\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010#\u001a\u00020$H\u0007J\u001a\u0010+\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010#\u001a\u00020$H\u0007J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$H\u0007J\u001a\u0010,\u001a\u00020\u00062\b\u0010-\u001a\u0004\u0018\u00010\u00012\u0006\u0010#\u001a\u00020$H\u0007R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/component/dxbilog/lib/BILogApi;", "", "()V", "biLogProvider", "Lcom/component/dxbilog/lib/IBILogProvider;", "add", "", "logNo", "", FirebaseAnalytics.Param.CONTENT, "Lcom/component/dxbilog/lib/listener/IBILogContentBean;", "init", "logConfig", "Lcom/component/dxbilog/lib/bean/BILogConfig;", "initHttpConfig", "initUserConfig", "send", "setAppActionEngine", "logDataEngine", "Lcom/component/dxbilog/lib/listener/IBILogAppActionEngine;", "setAppDataEngine", "Lcom/component/dxbilog/lib/listener/IBILogAppDataEngine;", "setHttpConfigDefault", "config", "Lcom/component/dxbilog/lib/bean/BILogHttpConfigDefault;", "setParam", IconCompat.EXTRA_OBJ, "key", "", "value", "setUserConfig", "Lcom/component/dxbilog/lib/bean/BILogUserConfig;", "trackClick", "view", "Landroid/view/View;", "contentBean", "Lcom/component/dxbilog/lib/bean/BILogContentBean;", "trackLongClick", "trackPageHide", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "trackPageShow", "trackS0009", "element", "dxRouter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BILogApi {

    @NotNull
    public static final BILogApi a;

    @Autowired
    @JvmField
    @Nullable
    public static IBILogProvider biLogProvider;

    static {
        BILogApi bILogApi = new BILogApi();
        a = bILogApi;
        pd.c().e(bILogApi);
    }

    @JvmStatic
    public static final void a(@NotNull BILogConfig logConfig) {
        Intrinsics.checkNotNullParameter(logConfig, "logConfig");
        IBILogProvider iBILogProvider = biLogProvider;
        if (iBILogProvider == null) {
            return;
        }
        iBILogProvider.a(logConfig);
    }

    @JvmStatic
    public static final void b(@NotNull as logDataEngine) {
        Intrinsics.checkNotNullParameter(logDataEngine, "logDataEngine");
        IBILogProvider iBILogProvider = biLogProvider;
        if (iBILogProvider == null) {
            return;
        }
        iBILogProvider.b(logDataEngine);
    }
}
