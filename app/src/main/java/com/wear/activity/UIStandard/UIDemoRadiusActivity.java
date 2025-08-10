package com.wear.activity.UIStandard;

import android.os.Bundle;
import com.wear.BaseActivity;
import com.wear.databinding.ActivityUiDemoRadiusBinding;
import dc.vl2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: UIDemoRadiusActivity.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/wear/activity/UIStandard/UIDemoRadiusActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "binding", "Lcom/wear/databinding/ActivityUiDemoRadiusBinding;", "initData", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class UIDemoRadiusActivity extends BaseActivity<vl2> {
    public ActivityUiDemoRadiusBinding a;

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUiDemoRadiusBinding activityUiDemoRadiusBindingC = ActivityUiDemoRadiusBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityUiDemoRadiusBindingC, "inflate(layoutInflater)");
        this.a = activityUiDemoRadiusBindingC;
        if (activityUiDemoRadiusBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUiDemoRadiusBindingC = null;
        }
        setContentView(activityUiDemoRadiusBindingC.getRoot());
        s4();
        t4();
    }

    public final void s4() {
    }

    public final void t4() {
    }
}
