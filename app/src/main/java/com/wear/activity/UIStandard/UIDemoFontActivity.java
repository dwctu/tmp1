package com.wear.activity.UIStandard;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.UIDemoFontAdapter;
import com.wear.bean.UIDemoFontBean;
import com.wear.databinding.ActivityUiDemoFontBinding;
import dc.vl2;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UIDemoFontActivity.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/wear/activity/UIStandard/UIDemoFontActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "binding", "Lcom/wear/databinding/ActivityUiDemoFontBinding;", "fonts", "", "Lcom/wear/bean/UIDemoFontBean;", "initData", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class UIDemoFontActivity extends BaseActivity<vl2> {
    public ActivityUiDemoFontBinding a;

    @NotNull
    public List<UIDemoFontBean> b = new ArrayList();

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUiDemoFontBinding activityUiDemoFontBindingC = ActivityUiDemoFontBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityUiDemoFontBindingC, "inflate(layoutInflater)");
        this.a = activityUiDemoFontBindingC;
        if (activityUiDemoFontBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUiDemoFontBindingC = null;
        }
        setContentView(activityUiDemoFontBindingC.getRoot());
        s4();
        t4();
    }

    public final void s4() {
        this.b.add(new UIDemoFontBean("文字样式", "字重", "组件名称", R.style.lvs_ui_standard_text_caption));
        this.b.add(new UIDemoFontBean("Remote", "SemiBold", "largeTitle", R.style.lvs_ui_standard_text_largeTitle));
        this.b.add(new UIDemoFontBean("Remote", "SemiBold", "largeTitle2", R.style.lvs_ui_standard_text_largeTitle2));
        this.b.add(new UIDemoFontBean("Remote", "SemiBold", MessageBundle.TITLE_ENTRY, R.style.lvs_ui_standard_text_title));
        this.b.add(new UIDemoFontBean("Remote", "SemiBold", "title2", R.style.lvs_ui_standard_text_title2));
        this.b.add(new UIDemoFontBean("Remote", "Regular", "body", R.style.lvs_ui_standard_text_body));
        this.b.add(new UIDemoFontBean("Remote", "Regular", "caption", R.style.lvs_ui_standard_text_caption));
        this.b.add(new UIDemoFontBean("Remote", "Regular", "caption2", R.style.lvs_ui_standard_text_caption2));
        this.b.add(new UIDemoFontBean("Remote", "Medium", "footnote", R.style.lvs_ui_standard_text_footnote));
        this.b.add(new UIDemoFontBean("Remote", "Medium", "footnote2", R.style.lvs_ui_standard_text_footnote2));
    }

    public final void t4() {
        ActivityUiDemoFontBinding activityUiDemoFontBinding = this.a;
        if (activityUiDemoFontBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUiDemoFontBinding = null;
        }
        RecyclerView recyclerView = activityUiDemoFontBinding.b;
        recyclerView.setAdapter(new UIDemoFontAdapter(this.b));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}
