package com.wear.activity.UIStandard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.wear.BaseActivity;
import com.wear.activity.UIStandard.UIDemoButtonActivity;
import com.wear.databinding.ActivityUiDemoButtonBinding;
import com.wear.util.MyApplication;
import dc.vl2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: UIDemoButtonActivity.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/wear/activity/UIStandard/UIDemoButtonActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "binding", "Lcom/wear/databinding/ActivityUiDemoButtonBinding;", "initData", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "updateSkinBtn", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class UIDemoButtonActivity extends BaseActivity<vl2> {
    public ActivityUiDemoButtonBinding a;

    public static final void u4(UIDemoButtonActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = MyApplication.m0;
        if (i == 0) {
            this$0.initTheme(MyApplication.l0 ? 1 : 2, true);
        } else if (i == 1) {
            this$0.initTheme(2, true);
        } else if (i == 2) {
            this$0.initTheme(1, true);
        }
        this$0.w4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUiDemoButtonBinding activityUiDemoButtonBindingC = ActivityUiDemoButtonBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityUiDemoButtonBindingC, "inflate(layoutInflater)");
        this.a = activityUiDemoButtonBindingC;
        if (activityUiDemoButtonBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUiDemoButtonBindingC = null;
        }
        setContentView(activityUiDemoButtonBindingC.getRoot());
        s4();
        t4();
    }

    public final void s4() {
    }

    public final void t4() {
        ActivityUiDemoButtonBinding activityUiDemoButtonBinding = this.a;
        if (activityUiDemoButtonBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUiDemoButtonBinding = null;
        }
        Button yesBtn = activityUiDemoButtonBinding.b.getYesBtn();
        yesBtn.setVisibility(0);
        yesBtn.setOnClickListener(new View.OnClickListener() { // from class: dc.yi1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UIDemoButtonActivity.u4(this.a, view);
            }
        });
        w4();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void w4() {
        /*
            r5 = this;
            com.wear.databinding.ActivityUiDemoButtonBinding r0 = r5.a
            if (r0 != 0) goto La
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = 0
        La:
            com.wear.widget.MyActionBar r0 = r0.b
            android.widget.Button r0 = r0.getYesBtn()
            int r1 = com.wear.util.MyApplication.m0
            java.lang.String r2 = "light"
            java.lang.String r3 = "dark"
            if (r1 == 0) goto L23
            r4 = 1
            if (r1 == r4) goto L21
            r3 = 2
            if (r1 == r3) goto L27
            java.lang.String r2 = ""
            goto L27
        L21:
            r2 = r3
            goto L27
        L23:
            boolean r1 = com.wear.util.MyApplication.l0
            if (r1 == 0) goto L21
        L27:
            r0.setText(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.activity.UIStandard.UIDemoButtonActivity.w4():void");
    }
}
