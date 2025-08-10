package com.wear.activity.UIStandard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.activity.UIStandard.UIDemoShadowActivity;
import com.wear.adapter.UIDemoShadowAdapter;
import com.wear.bean.UIDemoShadowBean;
import com.wear.databinding.ActivityUiDemoShadowBinding;
import com.wear.util.MyApplication;
import dc.vl2;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UIDemoShadowActivity.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/wear/activity/UIStandard/UIDemoShadowActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "binding", "Lcom/wear/databinding/ActivityUiDemoShadowBinding;", "shaodws", "", "Lcom/wear/bean/UIDemoShadowBean;", "initData", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "updateSkinBtn", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class UIDemoShadowActivity extends BaseActivity<vl2> {
    public ActivityUiDemoShadowBinding a;

    @NotNull
    public List<UIDemoShadowBean> b = new ArrayList();

    public static final void u4(UIDemoShadowActivity this$0, View view) {
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
        ActivityUiDemoShadowBinding activityUiDemoShadowBinding = this$0.a;
        if (activityUiDemoShadowBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUiDemoShadowBinding = null;
        }
        RecyclerView.Adapter adapter = activityUiDemoShadowBinding.c.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUiDemoShadowBinding activityUiDemoShadowBindingC = ActivityUiDemoShadowBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityUiDemoShadowBindingC, "inflate(layoutInflater)");
        this.a = activityUiDemoShadowBindingC;
        if (activityUiDemoShadowBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUiDemoShadowBindingC = null;
        }
        setContentView(activityUiDemoShadowBindingC.getRoot());
        s4();
        t4();
    }

    public final void s4() {
        this.b.add(new UIDemoShadowBean("systemShadowDownSmall", R.style.lvs_ui_standard_systemShadowDownSmall));
        this.b.add(new UIDemoShadowBean("systemShadowDownMedium", R.style.lvs_ui_standard_systemShadowDownMedium));
        this.b.add(new UIDemoShadowBean("systemShadowDownLarge", R.style.lvs_ui_standard_systemShadowDownLarge));
        this.b.add(new UIDemoShadowBean("systemShadowUpSmall", R.style.lvs_ui_standard_systemShadowUpSmall));
        this.b.add(new UIDemoShadowBean("systemShadowUpMedium", R.style.lvs_ui_standard_systemShadowUpMedium));
        this.b.add(new UIDemoShadowBean("systemShadowUpLarge", R.style.lvs_ui_standard_systemShadowUpLarge));
        this.b.add(new UIDemoShadowBean("systemShadowMiddleSmall", R.style.lvs_ui_standard_systemShadowMiddleSmall));
        this.b.add(new UIDemoShadowBean("systemShadowMiddleMedium", R.style.lvs_ui_standard_systemShadowMiddleMedium));
        this.b.add(new UIDemoShadowBean("systemShadowMiddleLarge", R.style.lvs_ui_standard_systemShadowMiddleLarge));
    }

    public final void t4() {
        ActivityUiDemoShadowBinding activityUiDemoShadowBinding = this.a;
        ActivityUiDemoShadowBinding activityUiDemoShadowBinding2 = null;
        if (activityUiDemoShadowBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUiDemoShadowBinding = null;
        }
        RecyclerView recyclerView = activityUiDemoShadowBinding.c;
        recyclerView.setAdapter(new UIDemoShadowAdapter(this.b));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        w4();
        ActivityUiDemoShadowBinding activityUiDemoShadowBinding3 = this.a;
        if (activityUiDemoShadowBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityUiDemoShadowBinding2 = activityUiDemoShadowBinding3;
        }
        Button yesBtn = activityUiDemoShadowBinding2.b.getYesBtn();
        yesBtn.setVisibility(0);
        yesBtn.setOnClickListener(new View.OnClickListener() { // from class: dc.aj1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UIDemoShadowActivity.u4(this.a, view);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void w4() {
        /*
            r5 = this;
            com.wear.databinding.ActivityUiDemoShadowBinding r0 = r5.a
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
        throw new UnsupportedOperationException("Method not decompiled: com.wear.activity.UIStandard.UIDemoShadowActivity.w4():void");
    }
}
