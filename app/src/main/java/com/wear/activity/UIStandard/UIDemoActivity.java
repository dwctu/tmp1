package com.wear.activity.UIStandard;

import android.os.Bundle;
import android.view.View;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.databinding.ActivityUiDemoBinding;
import dc.pj3;
import dc.vl2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UIDemoActivity.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0017J\u0012\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/wear/activity/UIStandard/UIDemoActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "Landroid/view/View$OnClickListener;", "()V", "binding", "Lcom/wear/databinding/ActivityUiDemoBinding;", "initView", "", "onClick", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class UIDemoActivity extends BaseActivity<vl2> implements View.OnClickListener {
    public ActivityUiDemoBinding a;

    @Override // android.view.View.OnClickListener
    @OnClick({R.id.btn_color, R.id.btn_font, R.id.btn_shadow, R.id.btn_radius, R.id.btn_button})
    public void onClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        switch (view.getId()) {
            case R.id.btn_button /* 2131362222 */:
                pj3.f(this, UIDemoButtonActivity.class);
                break;
            case R.id.btn_color /* 2131362230 */:
                pj3.f(this, UIDemoColorActivity.class);
                break;
            case R.id.btn_font /* 2131362250 */:
                pj3.f(this, UIDemoFontActivity.class);
                break;
            case R.id.btn_radius /* 2131362254 */:
                pj3.f(this, UIDemoRadiusActivity.class);
                break;
            case R.id.btn_shadow /* 2131362258 */:
                pj3.f(this, UIDemoShadowActivity.class);
                break;
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUiDemoBinding activityUiDemoBindingC = ActivityUiDemoBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityUiDemoBindingC, "inflate(layoutInflater)");
        this.a = activityUiDemoBindingC;
        if (activityUiDemoBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUiDemoBindingC = null;
        }
        setContentView(activityUiDemoBindingC.getRoot());
        s4();
    }

    public final void s4() {
        ActivityUiDemoBinding activityUiDemoBinding = this.a;
        if (activityUiDemoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUiDemoBinding = null;
        }
        activityUiDemoBinding.c.setOnClickListener(new View.OnClickListener() { // from class: dc.xi1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.onClick(view);
            }
        });
        activityUiDemoBinding.d.setOnClickListener(new View.OnClickListener() { // from class: dc.xi1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.onClick(view);
            }
        });
        activityUiDemoBinding.f.setOnClickListener(new View.OnClickListener() { // from class: dc.xi1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.onClick(view);
            }
        });
        activityUiDemoBinding.e.setOnClickListener(new View.OnClickListener() { // from class: dc.xi1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.onClick(view);
            }
        });
        activityUiDemoBinding.b.setOnClickListener(new View.OnClickListener() { // from class: dc.xi1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.onClick(view);
            }
        });
    }
}
