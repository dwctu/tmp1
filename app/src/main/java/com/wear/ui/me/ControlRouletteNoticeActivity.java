package com.wear.ui.me;

import android.os.Build;
import android.os.Bundle;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.databinding.ActivityControlRouletteNoticeBinding;
import com.wear.util.WearUtils;
import dc.kg3;
import dc.th4;
import dc.vl2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: ControlRouletteNoticeActivity.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/wear/ui/me/ControlRouletteNoticeActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "binding", "Lcom/wear/databinding/ActivityControlRouletteNoticeBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class ControlRouletteNoticeActivity extends BaseActivity<vl2> {
    public ActivityControlRouletteNoticeBinding a;

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityControlRouletteNoticeBinding activityControlRouletteNoticeBindingC = ActivityControlRouletteNoticeBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityControlRouletteNoticeBindingC, "inflate(layoutInflater)");
        this.a = activityControlRouletteNoticeBindingC;
        ActivityControlRouletteNoticeBinding activityControlRouletteNoticeBinding = null;
        if (activityControlRouletteNoticeBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityControlRouletteNoticeBindingC = null;
        }
        setContentView(activityControlRouletteNoticeBindingC.getRoot());
        ActivityControlRouletteNoticeBinding activityControlRouletteNoticeBinding2 = this.a;
        if (activityControlRouletteNoticeBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityControlRouletteNoticeBinding = activityControlRouletteNoticeBinding2;
        }
        activityControlRouletteNoticeBinding.b.setParentBackgroundColor(th4.b(this, R.color.lvs_ui_standard_systemBackground6));
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 23) {
            kg3.k(this, WearUtils.Y0());
        }
    }
}
