package com.wear.activity.UIStandard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.activity.UIStandard.UIDemoColorActivity;
import com.wear.adapter.UIDemoColorAdapter;
import com.wear.bean.UIDemoColorBean;
import com.wear.databinding.ActivityUiDemoColorBinding;
import com.wear.util.MyApplication;
import dc.vl2;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UIDemoColorActivity.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/wear/activity/UIStandard/UIDemoColorActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "binding", "Lcom/wear/databinding/ActivityUiDemoColorBinding;", "colors", "", "Lcom/wear/bean/UIDemoColorBean;", "initData", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "updateSkinBtn", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class UIDemoColorActivity extends BaseActivity<vl2> {
    public ActivityUiDemoColorBinding a;

    @NotNull
    public List<UIDemoColorBean> b = new ArrayList();

    public static final void u4(UIDemoColorActivity this$0, View view) {
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
        ActivityUiDemoColorBinding activityUiDemoColorBinding = this$0.a;
        if (activityUiDemoColorBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUiDemoColorBinding = null;
        }
        RecyclerView.Adapter adapter = activityUiDemoColorBinding.c.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUiDemoColorBinding activityUiDemoColorBindingC = ActivityUiDemoColorBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityUiDemoColorBindingC, "inflate(layoutInflater)");
        this.a = activityUiDemoColorBindingC;
        if (activityUiDemoColorBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUiDemoColorBindingC = null;
        }
        setContentView(activityUiDemoColorBindingC.getRoot());
        s4();
        t4();
    }

    public final void s4() {
        this.b.add(new UIDemoColorBean("systemBrandRegular", R.color.lvs_ui_standard_systemBrandRegular, CollectionsKt__CollectionsKt.mutableListOf("#FF2D89"), CollectionsKt__CollectionsKt.mutableListOf("#F4378A")));
        this.b.add(new UIDemoColorBean("systemBrandTouch", R.color.lvs_ui_standard_systemBrandTouch, CollectionsKt__CollectionsKt.mutableListOf("#EB297E"), CollectionsKt__CollectionsKt.mutableListOf("#B22D6A")));
        this.b.add(new UIDemoColorBean("systemBrandDisable", R.color.lvs_ui_standard_systemBrandDisable, CollectionsKt__CollectionsKt.mutableListOf("#FFBFDB"), CollectionsKt__CollectionsKt.mutableListOf("#662445")));
        this.b.add(new UIDemoColorBean("systemBrandBackground", R.color.lvs_ui_standard_systemBrandBackground, CollectionsKt__CollectionsKt.mutableListOf("#FFEBF4"), CollectionsKt__CollectionsKt.mutableListOf("#2E1B24")));
        this.b.add(new UIDemoColorBean("systemBrandBackground2", R.color.lvs_ui_standard_systemBrandBackground2, CollectionsKt__CollectionsKt.mutableListOf("#FFF0F7"), CollectionsKt__CollectionsKt.mutableListOf("#FFEBF4")));
        this.b.add(new UIDemoColorBean("systemBrandBackground3", R.color.lvs_ui_standard_systemBrandBackground3, CollectionsKt__CollectionsKt.mutableListOf("#F5E6ED"), CollectionsKt__CollectionsKt.mutableListOf("#EBD8E1")));
        this.b.add(new UIDemoColorBean("systemBrandGradient", R.drawable.shape_lvs_ui_standard_brand_gradient, CollectionsKt__CollectionsKt.mutableListOf("#FA4BD4", "#FF2D89"), CollectionsKt__CollectionsKt.mutableListOf("#E535BF", "#F4378A")));
        this.b.add(new UIDemoColorBean("systemBrandGradientTouch", R.drawable.shape_lvs_ui_standard_brand_gradient_touch, CollectionsKt__CollectionsKt.mutableListOf("#FC66DB", "#FF4D9B"), CollectionsKt__CollectionsKt.mutableListOf("#A82C90", "#B22D6A")));
        this.b.add(new UIDemoColorBean("systemText", R.color.lvs_ui_standard_systemText, CollectionsKt__CollectionsKt.mutableListOf("#25252D"), CollectionsKt__CollectionsKt.mutableListOf("#D9FFFFFF")));
        this.b.add(new UIDemoColorBean("systemText2", R.color.lvs_ui_standard_systemText2, CollectionsKt__CollectionsKt.mutableListOf("#6C7273"), CollectionsKt__CollectionsKt.mutableListOf("#A6FFFFFF")));
        this.b.add(new UIDemoColorBean("systemText3", R.color.lvs_ui_standard_systemText3, CollectionsKt__CollectionsKt.mutableListOf("#ACB6B7"), CollectionsKt__CollectionsKt.mutableListOf("#73FFFFFF")));
        this.b.add(new UIDemoColorBean("systemText4", R.color.lvs_ui_standard_systemText4, CollectionsKt__CollectionsKt.mutableListOf("#CACCCC"), CollectionsKt__CollectionsKt.mutableListOf("#40FFFFFF")));
        this.b.add(new UIDemoColorBean("systemText5", R.color.lvs_ui_standard_systemText5, CollectionsKt__CollectionsKt.mutableListOf("#6C7273"), CollectionsKt__CollectionsKt.mutableListOf("#73FFFFFF")));
        this.b.add(new UIDemoColorBean("systemTextRegular", R.color.lvs_ui_standard_systemTextRegular, CollectionsKt__CollectionsKt.mutableListOf("#FF2D89"), CollectionsKt__CollectionsKt.mutableListOf("#F4378A")));
        this.b.add(new UIDemoColorBean("systemTextRegularDisable", R.color.lvs_ui_standard_systemTextRegularDisable, CollectionsKt__CollectionsKt.mutableListOf("#FFBFDB"), CollectionsKt__CollectionsKt.mutableListOf("#662554")));
        this.b.add(new UIDemoColorBean("systemTextAccent", R.color.lvs_ui_standard_systemTextAccent, CollectionsKt__CollectionsKt.mutableListOf("#FFFFFF"), CollectionsKt__CollectionsKt.mutableListOf("#D9FFFFFF")));
        this.b.add(new UIDemoColorBean("systemTextAccent2", R.color.lvs_ui_standard_systemTextAccent2, CollectionsKt__CollectionsKt.mutableListOf("#FFFFFF"), CollectionsKt__CollectionsKt.mutableListOf("#FFFFFF")));
        this.b.add(new UIDemoColorBean("systemTextAccent3", R.color.lvs_ui_standard_systemTextAccent3, CollectionsKt__CollectionsKt.mutableListOf("#6C7273"), CollectionsKt__CollectionsKt.mutableListOf("#D9FFFFFF")));
        this.b.add(new UIDemoColorBean("systemTextAccent4", R.color.lvs_ui_standard_systemTextAccent4, CollectionsKt__CollectionsKt.mutableListOf("#FF2D89"), CollectionsKt__CollectionsKt.mutableListOf("#D9FFFFFF")));
        this.b.add(new UIDemoColorBean("systemTextAccent5", R.color.lvs_ui_standard_systemTextAccent5, CollectionsKt__CollectionsKt.mutableListOf("#25252D"), CollectionsKt__CollectionsKt.mutableListOf("#73FFFFFF")));
        this.b.add(new UIDemoColorBean("systemLDText", R.color.lvs_ui_standard_systemLDText, CollectionsKt__CollectionsKt.mutableListOf("#D9FFFFFF"), CollectionsKt__CollectionsKt.mutableListOf("#D9FFFFFF")));
        this.b.add(new UIDemoColorBean("systemLDText2", R.color.lvs_ui_standard_systemLDText2, CollectionsKt__CollectionsKt.mutableListOf("#A6FFFFFF"), CollectionsKt__CollectionsKt.mutableListOf("#A6FFFFFF")));
        this.b.add(new UIDemoColorBean("systemLDText3", R.color.lvs_ui_standard_systemLDText3, CollectionsKt__CollectionsKt.mutableListOf("#73FFFFFF"), CollectionsKt__CollectionsKt.mutableListOf("#73FFFFFF")));
        this.b.add(new UIDemoColorBean("systemLDText4", R.color.lvs_ui_standard_systemLDText4, CollectionsKt__CollectionsKt.mutableListOf("#40FFFFFF"), CollectionsKt__CollectionsKt.mutableListOf("#40FFFFFF")));
        this.b.add(new UIDemoColorBean("systemLDText5", R.color.lvs_ui_standard_systemLDText5, CollectionsKt__CollectionsKt.mutableListOf("#25252D"), CollectionsKt__CollectionsKt.mutableListOf("#25252D")));
        this.b.add(new UIDemoColorBean("systemLDText6", R.color.lvs_ui_standard_systemLDText6, CollectionsKt__CollectionsKt.mutableListOf("#6C7273"), CollectionsKt__CollectionsKt.mutableListOf("#6C7273")));
        this.b.add(new UIDemoColorBean("systemLDText7", R.color.lvs_ui_standard_systemLDText7, CollectionsKt__CollectionsKt.mutableListOf("#909999"), CollectionsKt__CollectionsKt.mutableListOf("#909999")));
        this.b.add(new UIDemoColorBean("systemLDText8", R.color.lvs_ui_standard_systemLDText8, CollectionsKt__CollectionsKt.mutableListOf("#ACB6B7"), CollectionsKt__CollectionsKt.mutableListOf("#ACB6B7")));
        this.b.add(new UIDemoColorBean("systemLDFillStrong", R.color.lvs_ui_standard_systemLDFillStrong, CollectionsKt__CollectionsKt.mutableListOf("#1FFFFFFF"), CollectionsKt__CollectionsKt.mutableListOf("#1FFFFFFF")));
        this.b.add(new UIDemoColorBean("systemLDFillRegular", R.color.lvs_ui_standard_systemLDFillRegular, CollectionsKt__CollectionsKt.mutableListOf("#14FFFFFF"), CollectionsKt__CollectionsKt.mutableListOf("#14FFFFFF")));
        this.b.add(new UIDemoColorBean("systemLDFillWeak", R.color.lvs_ui_standard_systemLDFillWeak, CollectionsKt__CollectionsKt.mutableListOf("#0AFFFFFF"), CollectionsKt__CollectionsKt.mutableListOf("#0AFFFFFF")));
        this.b.add(new UIDemoColorBean("systemLDBackground7", R.color.lvs_ui_standard_systemLDBackground7, CollectionsKt__CollectionsKt.mutableListOf("#000004"), CollectionsKt__CollectionsKt.mutableListOf("#000004")));
        this.b.add(new UIDemoColorBean("systemFillRegular", R.color.lvs_ui_standard_systemFillRegular, CollectionsKt__CollectionsKt.mutableListOf("#F1F1F1"), CollectionsKt__CollectionsKt.mutableListOf("#14FFFFFF")));
        this.b.add(new UIDemoColorBean("systemFillStrong", R.color.lvs_ui_standard_systemFillStrong, CollectionsKt__CollectionsKt.mutableListOf("#DDDDDD"), CollectionsKt__CollectionsKt.mutableListOf("#1FFFFFFF")));
        this.b.add(new UIDemoColorBean("systemFillWeak", R.color.lvs_ui_standard_systemFillWeak, CollectionsKt__CollectionsKt.mutableListOf("#F7F7F7"), CollectionsKt__CollectionsKt.mutableListOf("#0AFFFFFF")));
        this.b.add(new UIDemoColorBean("systemFillSpecial", R.color.lvs_ui_standard_systemFillSpecial, CollectionsKt__CollectionsKt.mutableListOf("#FFFFFF"), CollectionsKt__CollectionsKt.mutableListOf("#D9FFFFFF")));
        this.b.add(new UIDemoColorBean("systemFillSpecial2", R.color.lvs_ui_standard_systemFillSpecial2, CollectionsKt__CollectionsKt.mutableListOf("#FFFFFF"), CollectionsKt__CollectionsKt.mutableListOf("#14FFFFFF")));
        this.b.add(new UIDemoColorBean("systemBackground", R.color.lvs_ui_standard_systemBackground, CollectionsKt__CollectionsKt.mutableListOf("#FFFFFF"), CollectionsKt__CollectionsKt.mutableListOf("#16171F")));
        this.b.add(new UIDemoColorBean("systemBackground2", R.color.lvs_ui_standard_systemBackground2, CollectionsKt__CollectionsKt.mutableListOf("#F7F8F9"), CollectionsKt__CollectionsKt.mutableListOf("#1E1F29")));
        this.b.add(new UIDemoColorBean("systemBackground3", R.color.lvs_ui_standard_systemBackground3, CollectionsKt__CollectionsKt.mutableListOf("#FFFFFF"), CollectionsKt__CollectionsKt.mutableListOf("#262633")));
        this.b.add(new UIDemoColorBean("systemBackground4", R.color.lvs_ui_standard_systemBackground4, CollectionsKt__CollectionsKt.mutableListOf("#FFFFFF"), CollectionsKt__CollectionsKt.mutableListOf("#1E1F29")));
        this.b.add(new UIDemoColorBean("systemBackground5", R.color.lvs_ui_standard_systemBackground5, CollectionsKt__CollectionsKt.mutableListOf("#F0F1F2"), CollectionsKt__CollectionsKt.mutableListOf("#262633")));
        this.b.add(new UIDemoColorBean("systemBackground6", R.color.lvs_ui_standard_systemBackground6, CollectionsKt__CollectionsKt.mutableListOf("#F0F1F2"), CollectionsKt__CollectionsKt.mutableListOf("#16171F")));
        this.b.add(new UIDemoColorBean("systemBackgroundTooltip", R.color.lvs_ui_standard_systemBackgroundTooltip, CollectionsKt__CollectionsKt.mutableListOf("#333333"), CollectionsKt__CollectionsKt.mutableListOf("#2D2D3D")));
        this.b.add(new UIDemoColorBean("systemBackgroundTooltip2", R.color.lvs_ui_standard_systemBackgroundTooltip2, CollectionsKt__CollectionsKt.mutableListOf("#FFFFFF"), CollectionsKt__CollectionsKt.mutableListOf("#2D2D3D")));
        this.b.add(new UIDemoColorBean("systemBackgroundClick", R.color.lvs_ui_standard_systemBackgroundClick, CollectionsKt__CollectionsKt.mutableListOf("#EBEBEB"), CollectionsKt__CollectionsKt.mutableListOf("#2C2C36")));
        this.b.add(new UIDemoColorBean("systemBackgroundClick2", R.color.lvs_ui_standard_systemBackgroundClick2, CollectionsKt__CollectionsKt.mutableListOf("#EBEBEB"), CollectionsKt__CollectionsKt.mutableListOf("#3A3A47")));
        this.b.add(new UIDemoColorBean("systemStrokeRegular", R.color.lvs_ui_standard_systemStrokeRegular, CollectionsKt__CollectionsKt.mutableListOf("#EBEBEB"), CollectionsKt__CollectionsKt.mutableListOf("#0FFFFFFF")));
        this.b.add(new UIDemoColorBean("systemStrokeStrong", R.color.lvs_ui_standard_systemStrokeStrong, CollectionsKt__CollectionsKt.mutableListOf("#DDDDDD"), CollectionsKt__CollectionsKt.mutableListOf("#1FFFFFFF")));
        this.b.add(new UIDemoColorBean("systemStrokeWeak", R.color.lvs_ui_standard_systemStrokeWeak, CollectionsKt__CollectionsKt.mutableListOf("#F0F1F2"), CollectionsKt__CollectionsKt.mutableListOf("#00FFFFFF")));
        this.b.add(new UIDemoColorBean("systemMaskAlert", R.color.lvs_ui_standard_systemMaskAlert, CollectionsKt__CollectionsKt.mutableListOf("#99000000"), CollectionsKt__CollectionsKt.mutableListOf("#99000000")));
        this.b.add(new UIDemoColorBean("systemMaskButton", R.color.lvs_ui_standard_systemMaskButton, CollectionsKt__CollectionsKt.mutableListOf("#66000000"), CollectionsKt__CollectionsKt.mutableListOf("#66000000")));
        this.b.add(new UIDemoColorBean("systemGreenRegular", R.color.lvs_ui_standard_systemGreenRegular, CollectionsKt__CollectionsKt.mutableListOf("#4CCD27"), CollectionsKt__CollectionsKt.mutableListOf("#00991D")));
        this.b.add(new UIDemoColorBean("systemGreenTouch", R.color.lvs_ui_standard_systemGreenTouch, CollectionsKt__CollectionsKt.mutableListOf("#46BD24"), CollectionsKt__CollectionsKt.mutableListOf("#07721E")));
        this.b.add(new UIDemoColorBean("systemGreenDisable", R.color.lvs_ui_standard_systemGreenDisable, CollectionsKt__CollectionsKt.mutableListOf("#B7EBA9"), CollectionsKt__CollectionsKt.mutableListOf("#1A4020")));
        this.b.add(new UIDemoColorBean("systemGreenBackground", R.color.lvs_ui_standard_systemGreenBackground, CollectionsKt__CollectionsKt.mutableListOf("#EBFFE5"), CollectionsKt__CollectionsKt.mutableListOf("#1B291D")));
        this.b.add(new UIDemoColorBean("systemYellowRegular", R.color.lvs_ui_standard_systemYellowRegular, CollectionsKt__CollectionsKt.mutableListOf("#EFAF00"), CollectionsKt__CollectionsKt.mutableListOf("#D99F00")));
        this.b.add(new UIDemoColorBean("systemYellowTouch", R.color.lvs_ui_standard_systemYellowTouch, CollectionsKt__CollectionsKt.mutableListOf("#DCA100"), CollectionsKt__CollectionsKt.mutableListOf("#9F7609")));
        this.b.add(new UIDemoColorBean("systemYellowDisable", R.color.lvs_ui_standard_systemYellowDisable, CollectionsKt__CollectionsKt.mutableListOf("#F9DE95"), CollectionsKt__CollectionsKt.mutableListOf("#40361A")));
        this.b.add(new UIDemoColorBean("systemYellowBackground", R.color.lvs_ui_standard_systemYellowBackground, CollectionsKt__CollectionsKt.mutableListOf("#FFF8E5"), CollectionsKt__CollectionsKt.mutableListOf("#292518")));
        this.b.add(new UIDemoColorBean("systemRedRegular", R.color.lvs_ui_standard_systemRedRegular, CollectionsKt__CollectionsKt.mutableListOf("#FA5152"), CollectionsKt__CollectionsKt.mutableListOf("#E04444")));
        this.b.add(new UIDemoColorBean("systemRedTouch", R.color.lvs_ui_standard_systemRedTouch, CollectionsKt__CollectionsKt.mutableListOf("#E64B4B"), CollectionsKt__CollectionsKt.mutableListOf("#A43739")));
        this.b.add(new UIDemoColorBean("systemRedDisable", R.color.lvs_ui_standard_systemRedDisable, CollectionsKt__CollectionsKt.mutableListOf("#FDB9BA"), CollectionsKt__CollectionsKt.mutableListOf("#381616")));
        this.b.add(new UIDemoColorBean("systemRedBackground", R.color.lvs_ui_standard_systemRedBackground, CollectionsKt__CollectionsKt.mutableListOf("#FFE5E5"), CollectionsKt__CollectionsKt.mutableListOf("#2B1919")));
        this.b.add(new UIDemoColorBean("systemBlueRegular", R.color.lvs_ui_standard_systemBlueRegular, CollectionsKt__CollectionsKt.mutableListOf("#00A3FF"), CollectionsKt__CollectionsKt.mutableListOf("#0B8ED9")));
        this.b.add(new UIDemoColorBean("systemBlueTouch", R.color.lvs_ui_standard_systemBlueTouch, CollectionsKt__CollectionsKt.mutableListOf("#0096EB"), CollectionsKt__CollectionsKt.mutableListOf("#0F6AA1")));
        this.b.add(new UIDemoColorBean("systemBlueDisable", R.color.lvs_ui_standard_systemBlueDisable, CollectionsKt__CollectionsKt.mutableListOf("#99DAFF"), CollectionsKt__CollectionsKt.mutableListOf("#1A3240")));
        this.b.add(new UIDemoColorBean("systemBlueBackground", R.color.lvs_ui_standard_systemBlueBackground, CollectionsKt__CollectionsKt.mutableListOf("#EBF8FF"), CollectionsKt__CollectionsKt.mutableListOf("#142129")));
        this.b.add(new UIDemoColorBean("systemPurpleRegular", R.color.lvs_ui_standard_systemPurpleRegular, CollectionsKt__CollectionsKt.mutableListOf("#E920DC"), CollectionsKt__CollectionsKt.mutableListOf("#E01FD4")));
        this.b.add(new UIDemoColorBean("systemPurpleTouch", R.color.lvs_ui_standard_systemPurpleTouch, CollectionsKt__CollectionsKt.mutableListOf("#D61DCA"), CollectionsKt__CollectionsKt.mutableListOf("#A41D9E")));
        this.b.add(new UIDemoColorBean("systemPurpleDisable", R.color.lvs_ui_standard_systemPurpleDisable, CollectionsKt__CollectionsKt.mutableListOf("#FF99F8"), CollectionsKt__CollectionsKt.mutableListOf("#381636")));
        this.b.add(new UIDemoColorBean("systemPurpleBackground", R.color.lvs_ui_standard_systemPurpleBackground, CollectionsKt__CollectionsKt.mutableListOf("#FFEBFE"), CollectionsKt__CollectionsKt.mutableListOf("#291828")));
    }

    public final void t4() {
        ActivityUiDemoColorBinding activityUiDemoColorBinding = this.a;
        ActivityUiDemoColorBinding activityUiDemoColorBinding2 = null;
        if (activityUiDemoColorBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUiDemoColorBinding = null;
        }
        RecyclerView recyclerView = activityUiDemoColorBinding.c;
        recyclerView.setAdapter(new UIDemoColorAdapter(this.b));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        w4();
        ActivityUiDemoColorBinding activityUiDemoColorBinding3 = this.a;
        if (activityUiDemoColorBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityUiDemoColorBinding2 = activityUiDemoColorBinding3;
        }
        Button yesBtn = activityUiDemoColorBinding2.b.getYesBtn();
        yesBtn.setVisibility(0);
        yesBtn.setOnClickListener(new View.OnClickListener() { // from class: dc.zi1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UIDemoColorActivity.u4(this.a, view);
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
            com.wear.databinding.ActivityUiDemoColorBinding r0 = r5.a
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
        throw new UnsupportedOperationException("Method not decompiled: com.wear.activity.UIStandard.UIDemoColorActivity.w4():void");
    }
}
