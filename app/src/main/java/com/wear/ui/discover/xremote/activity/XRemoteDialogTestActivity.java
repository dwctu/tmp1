package com.wear.ui.discover.xremote.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.wear.BaseActivity;
import com.wear.bean.CheckProtocolBean;
import com.wear.bean.CheckProtocolData;
import com.wear.bean.XRemoteAppUserBean;
import com.wear.databinding.ActivityXremoteDialogTestBinding;
import com.wear.ui.discover.xremote.activity.XRemoteDialogTestActivity;
import com.wear.util.WearUtils;
import com.wear.widget.XRemoteDevDialog;
import com.wear.widget.dialog.ToyDialog;
import com.wear.widget.dialog.XRemoteAuthorizedLoginPop;
import com.wear.widget.dialog.XRemotePermissionPop;
import com.wear.widget.dialog.XRemotePolicyPop;
import dc.vl2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: XRemoteDialogTestActivity.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/wear/ui/discover/xremote/activity/XRemoteDialogTestActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "binding", "Lcom/wear/databinding/ActivityXremoteDialogTestBinding;", "dialog1", "Lcom/wear/widget/dialog/XRemotePolicyPop;", "dialog2", "Lcom/wear/widget/dialog/XRemoteAuthorizedLoginPop;", "dialog3", "Lcom/wear/widget/dialog/XRemotePermissionPop;", "dialog4", "Lcom/wear/widget/dialog/ToyDialog;", "dialog5", "Lcom/wear/widget/XRemoteDevDialog;", "initView", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class XRemoteDialogTestActivity extends BaseActivity<vl2> {
    public ActivityXremoteDialogTestBinding a;

    @Nullable
    public XRemotePolicyPop b;

    @Nullable
    public XRemoteAuthorizedLoginPop c;

    @Nullable
    public XRemotePermissionPop d;

    @Nullable
    public ToyDialog e;

    @Nullable
    public XRemoteDevDialog f;

    public static final void t4(XRemoteDialogTestActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        XRemotePolicyPop xRemotePolicyPop = new XRemotePolicyPop(this$0, "https://test1.lovense.com/oss/remote-developer/xremote/application/img/20240612/thum_03b41a6c4a2540eca903ada59ce9655a.jpg", "Mission 2: Desire", new CheckProtocolBean(null, new CheckProtocolData("1", "https://www.baidu.com"), null, null, 13, null));
        this$0.b = xRemotePolicyPop;
        if (xRemotePolicyPop != null) {
            xRemotePolicyPop.show();
        }
    }

    public static final void u4(XRemoteDialogTestActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        XRemoteAuthorizedLoginPop xRemoteAuthorizedLoginPop = new XRemoteAuthorizedLoginPop(this$0, "", (XRemoteAppUserBean.DataBean) WearUtils.A.fromJson("{\"application\":{\"applicationIconUrl\":\"https://test1.lovense.com/oss/remote-developer/xremote/application/img/20240612/thum_03b41a6c4a2540eca903ada59ce9655a.jpg\",\"applicationId\":\"077890a012b44c51a0f824f740189895\",\"applicationName\":\"Mission 2: Desire\"},\"applicationAccountList\":[{\"accountType\":\"lovense_user_name\",\"applicationAccountId\":\"c2fcbf731ef8444a898f7f5f8a025f06\",\"username\":\"hu1003\"},{\"accountType\":\"custom_name\",\"applicationAccountId\":\"fafc20e1ec9447739c5f72301c4222de\",\"username\":\"huihui\"}],\"version\":\"2.0\"}", XRemoteAppUserBean.DataBean.class));
        this$0.c = xRemoteAuthorizedLoginPop;
        if (xRemoteAuthorizedLoginPop != null) {
            xRemoteAuthorizedLoginPop.show();
        }
    }

    public static final void v4(XRemoteDialogTestActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        XRemotePermissionPop xRemotePermissionPop = new XRemotePermissionPop(this$0, "https://test1.lovense.com/oss/remote-developer/xremote/application/img/20240612/thum_03b41a6c4a2540eca903ada59ce9655a.jpg", "Mission 2: Desire", "Requests to save images to your album.");
        this$0.d = xRemotePermissionPop;
        if (xRemotePermissionPop != null) {
            xRemotePermissionPop.show();
        }
    }

    public static final void w4(XRemoteDialogTestActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ToyDialog toyDialogA = ToyDialog.j.a();
        this$0.e = toyDialogA;
        if (toyDialogA != null) {
            toyDialogA.show(this$0.getSupportFragmentManager(), "");
        }
    }

    public static final void x4(XRemoteDialogTestActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        XRemoteDevDialog xRemoteDevDialog = new XRemoteDevDialog(this$0);
        this$0.f = xRemoteDevDialog;
        if (xRemoteDevDialog != null) {
            xRemoteDevDialog.show();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        XRemotePolicyPop xRemotePolicyPop = this.b;
        if (xRemotePolicyPop != null) {
            xRemotePolicyPop.c(newConfig.orientation);
        }
        XRemoteAuthorizedLoginPop xRemoteAuthorizedLoginPop = this.c;
        if (xRemoteAuthorizedLoginPop != null) {
            xRemoteAuthorizedLoginPop.c(newConfig.orientation);
        }
        XRemotePermissionPop xRemotePermissionPop = this.d;
        if (xRemotePermissionPop != null) {
            xRemotePermissionPop.c(newConfig.orientation);
        }
        XRemoteDevDialog xRemoteDevDialog = this.f;
        if (xRemoteDevDialog != null) {
            xRemoteDevDialog.c(newConfig.orientation);
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityXremoteDialogTestBinding activityXremoteDialogTestBindingC = ActivityXremoteDialogTestBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityXremoteDialogTestBindingC, "inflate(layoutInflater)");
        this.a = activityXremoteDialogTestBindingC;
        if (activityXremoteDialogTestBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityXremoteDialogTestBindingC = null;
        }
        setContentView(activityXremoteDialogTestBindingC.getRoot());
        setRequestedOrientation(10);
        s4();
    }

    public final void s4() {
        ActivityXremoteDialogTestBinding activityXremoteDialogTestBinding = this.a;
        ActivityXremoteDialogTestBinding activityXremoteDialogTestBinding2 = null;
        if (activityXremoteDialogTestBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityXremoteDialogTestBinding = null;
        }
        activityXremoteDialogTestBinding.b.setOnClickListener(new View.OnClickListener() { // from class: dc.o23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XRemoteDialogTestActivity.t4(this.a, view);
            }
        });
        ActivityXremoteDialogTestBinding activityXremoteDialogTestBinding3 = this.a;
        if (activityXremoteDialogTestBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityXremoteDialogTestBinding3 = null;
        }
        activityXremoteDialogTestBinding3.c.setOnClickListener(new View.OnClickListener() { // from class: dc.n23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XRemoteDialogTestActivity.u4(this.a, view);
            }
        });
        ActivityXremoteDialogTestBinding activityXremoteDialogTestBinding4 = this.a;
        if (activityXremoteDialogTestBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityXremoteDialogTestBinding4 = null;
        }
        activityXremoteDialogTestBinding4.d.setOnClickListener(new View.OnClickListener() { // from class: dc.k23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XRemoteDialogTestActivity.v4(this.a, view);
            }
        });
        ActivityXremoteDialogTestBinding activityXremoteDialogTestBinding5 = this.a;
        if (activityXremoteDialogTestBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityXremoteDialogTestBinding5 = null;
        }
        activityXremoteDialogTestBinding5.e.setOnClickListener(new View.OnClickListener() { // from class: dc.m23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XRemoteDialogTestActivity.w4(this.a, view);
            }
        });
        ActivityXremoteDialogTestBinding activityXremoteDialogTestBinding6 = this.a;
        if (activityXremoteDialogTestBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityXremoteDialogTestBinding2 = activityXremoteDialogTestBinding6;
        }
        activityXremoteDialogTestBinding2.f.setOnClickListener(new View.OnClickListener() { // from class: dc.l23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XRemoteDialogTestActivity.x4(this.a, view);
            }
        });
    }
}
