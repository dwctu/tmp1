package com.component.dxbilog.lib;

import android.content.Context;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.graphics.drawable.IconCompat;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.component.dxbilog.lib.bean.BILogConfig;
import com.google.firebase.analytics.FirebaseAnalytics;
import dc.as;
import dc.ks;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: _BILogProviderImpl.kt */
@Route(path = "/dxRouter/BILogProviderImpl")
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J$\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020!H\u0016J\u001a\u0010\"\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&H\u0016J\u001a\u0010'\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&H\u0016J\u001a\u0010(\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010%\u001a\u00020&H\u0016J\u001a\u0010(\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&H\u0016J\u001a\u0010-\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010%\u001a\u00020&H\u0016J\u001a\u0010-\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&H\u0016J\u001a\u0010.\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010\u001c2\u0006\u0010%\u001a\u00020&H\u0016¨\u00060"}, d2 = {"Lcom/component/dxbilog/lib/_BILogProviderImpl;", "Lcom/component/dxbilog/lib/IBILogProvider;", "()V", "add", "", "logNo", "", FirebaseAnalytics.Param.CONTENT, "Lcom/component/dxbilog/lib/listener/IBILogContentBean;", "init", "context", "Landroid/content/Context;", "logConfig", "Lcom/component/dxbilog/lib/bean/BILogConfig;", "initHttpConfig", "initUserConfig", "send", "setAppActionEngine", "appActionEngine", "Lcom/component/dxbilog/lib/listener/IBILogAppActionEngine;", "setAppDataEngine", "appDataEngine", "Lcom/component/dxbilog/lib/listener/IBILogAppDataEngine;", "setHttpConfigDefault", "config", "Lcom/component/dxbilog/lib/bean/BILogHttpConfigDefault;", "setParam", IconCompat.EXTRA_OBJ, "", "key", "", "value", "setUserConfig", "Lcom/component/dxbilog/lib/bean/BILogUserConfig;", "trackClick", "view", "Landroid/view/View;", "contentBean", "Lcom/component/dxbilog/lib/bean/BILogContentBean;", "trackLongClick", "trackPageHide", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "trackPageShow", "trackS0009", "element", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class _BILogProviderImpl implements IBILogProvider {
    @Override // com.component.dxbilog.lib.IBILogProvider
    public void a(@NotNull BILogConfig logConfig) {
        Intrinsics.checkNotNullParameter(logConfig, "logConfig");
        ks.a.c(logConfig);
    }

    @Override // com.component.dxbilog.lib.IBILogProvider
    public void b(@NotNull as appActionEngine) {
        Intrinsics.checkNotNullParameter(appActionEngine, "appActionEngine");
        ks.a.a().e(appActionEngine);
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(@Nullable Context context) {
    }
}
