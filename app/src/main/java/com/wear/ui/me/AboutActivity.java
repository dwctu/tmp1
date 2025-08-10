package com.wear.ui.me;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.Gson;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.AccountSetting;
import com.wear.bean.PolicyListBean;
import com.wear.bean.UpdateVersionBean;
import com.wear.bean.event.VersionUpdataEvent;
import com.wear.dao.AccountSettingDao;
import com.wear.dao.DaoUtils;
import com.wear.main.VersionHistoryActivity;
import com.wear.main.account.UpdateActivity;
import com.wear.main.account.WebViewActivity;
import com.wear.ui.me.AboutActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.HotView;
import dc.ah4;
import dc.eg3;
import dc.lg3;
import dc.me3;
import dc.pg3;
import dc.pj3;
import dc.vl2;
import dc.wg3;
import dc.ye3;
import dc.zt3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.Nullable;

/* compiled from: AboutActivity.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0015J\b\u0010\u0013\u001a\u00020\u0010H\u0014J\u0012\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0012\u0010\u0017\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/wear/ui/me/AboutActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "about_eula", "Landroid/widget/RelativeLayout;", "about_group_chat", "about_license", "about_privacy", "about_update", "app_version", "Landroid/widget/TextView;", "hotView", "Lcom/wear/widget/HotView;", "version_history", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onMessageEvent", "hotDot", "Lcom/wear/bean/event/VersionUpdataEvent;", "setAppUpdataHotView", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class AboutActivity extends BaseActivity<vl2> {
    public RelativeLayout a;
    public RelativeLayout b;
    public RelativeLayout c;
    public RelativeLayout d;
    public RelativeLayout e;
    public TextView f;
    public HotView g;
    public RelativeLayout h;

    public static final void A4(AboutActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        pj3.f(this$0, VersionHistoryActivity.class);
    }

    public static final void B4(View view) {
    }

    public static final void C4(PolicyListBean policyListBean, String str, AboutActivity this$0, View view) {
        String str2;
        List<PolicyListBean.DataDTO> data;
        Object next;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bundle bundle = new Bundle();
        bundle.putString(MessageBundle.TITLE_ENTRY, ah4.e(R.string.privacy_policy));
        String url = null;
        if (policyListBean != null && (data = policyListBean.getData()) != null) {
            Iterator<T> it = data.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual(((PolicyListBean.DataDTO) next).getPolicyType(), "remote_privacy")) {
                        break;
                    }
                }
            }
            PolicyListBean.DataDTO dataDTO = (PolicyListBean.DataDTO) next;
            if (dataDTO != null) {
                url = dataDTO.getUrl();
            }
        }
        if (url == null || url.length() == 0) {
            str2 = "https://hyttoapps.bandnana.com/remote/privacy-policy?pf=" + wg3.a() + "&lang=" + str;
        } else {
            str2 = url + "?pf=" + wg3.a() + "&lang=" + str;
        }
        bundle.putString(ImagesContract.URL, str2);
        pj3.g(this$0, WebViewActivity.class, bundle);
    }

    public static final void D4(AboutActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String strC = lg3.c(lg3.e(this$0.activity));
        Intrinsics.checkNotNullExpressionValue(strC, "getLangParms(locale)");
        String strF = pg3.h().f();
        Intrinsics.checkNotNullExpressionValue(strF, "getInstance().groupChatGuideline");
        Bundle bundle = new Bundle();
        bundle.putString(MessageBundle.TITLE_ENTRY, ah4.e(R.string.group_chat_guidelines_title));
        if (WearUtils.e1(strF)) {
            strF = "https://c.lovense.com/remote-web/group-chat-guidelines";
        }
        bundle.putString(ImagesContract.URL, strF + "?lang=" + strC);
        pj3.g(this$0.activity, WebViewActivity.class, bundle);
    }

    public static final void E4(PolicyListBean policyListBean, String str, AboutActivity this$0, View view) {
        String str2;
        List<PolicyListBean.DataDTO> data;
        Object next;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bundle bundle = new Bundle();
        bundle.putString(MessageBundle.TITLE_ENTRY, ah4.e(R.string.terms_and_conditions));
        String url = null;
        if (policyListBean != null && (data = policyListBean.getData()) != null) {
            Iterator<T> it = data.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual(((PolicyListBean.DataDTO) next).getPolicyType(), "remote_terms")) {
                        break;
                    }
                }
            }
            PolicyListBean.DataDTO dataDTO = (PolicyListBean.DataDTO) next;
            if (dataDTO != null) {
                url = dataDTO.getUrl();
            }
        }
        if (url == null || url.length() == 0) {
            str2 = "https://hyttoapps.bandnana.com/remote/terms-and-conditions?pf=" + wg3.a() + "&lang=" + str;
        } else {
            str2 = url + "?pf=" + wg3.a() + "&lang=" + str;
        }
        bundle.putString(ImagesContract.URL, str2);
        pj3.g(this$0, WebViewActivity.class, bundle);
    }

    public static final void F4(PolicyListBean policyListBean, String str, AboutActivity this$0, View view) {
        String str2;
        List<PolicyListBean.DataDTO> data;
        Object next;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bundle bundle = new Bundle();
        bundle.putString(MessageBundle.TITLE_ENTRY, ah4.e(R.string.wokin_eula));
        String url = null;
        if (policyListBean != null && (data = policyListBean.getData()) != null) {
            Iterator<T> it = data.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual(((PolicyListBean.DataDTO) next).getPolicyType(), "remote_end_user_license")) {
                        break;
                    }
                }
            }
            PolicyListBean.DataDTO dataDTO = (PolicyListBean.DataDTO) next;
            if (dataDTO != null) {
                url = dataDTO.getUrl();
            }
        }
        if (url == null || url.length() == 0) {
            str2 = "https://hyttoapps.bandnana.com/remote/end-user-license-agreement?pf=" + wg3.a() + "&lang=" + str;
        } else {
            str2 = url + "?pf=" + wg3.a() + "&lang=" + str;
        }
        bundle.putString(ImagesContract.URL, str2);
        pj3.g(this$0, WebViewActivity.class, bundle);
    }

    public static final void G4(AboutActivity this$0, View view) {
        UpdateVersionBean updateVersionBean;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VersionUpdataEvent versionUpdataEvent = MyApplication.S;
        if (versionUpdataEvent != null && (updateVersionBean = versionUpdataEvent.versionBean) != null) {
            String version = updateVersionBean.getVersion();
            AccountSetting accountSetting = DaoUtils.getAccountSettingDao().getAccountSetting(zt3.k, version);
            if (accountSetting == null) {
                AccountSetting accountSetting2 = new AccountSetting();
                accountSetting2.setUserId(zt3.k);
                accountSetting2.setVersion(version);
                accountSetting2.setTip(true);
                DaoUtils.getAccountSettingDao().add((AccountSettingDao) accountSetting2);
            } else {
                accountSetting.setTip(true);
                DaoUtils.getAccountSettingDao().update((AccountSettingDao) accountSetting);
            }
            MyApplication.S.isShowHotView = false;
            EventBus.getDefault().post(MyApplication.S);
        }
        pj3.f(this$0, UpdateActivity.class);
    }

    public static final void H4(View view) {
    }

    public final void I4(VersionUpdataEvent versionUpdataEvent) {
        HotView hotView = this.g;
        HotView hotView2 = null;
        if (hotView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hotView");
            hotView = null;
        }
        hotView.setVisibility(8);
        if (versionUpdataEvent == null || !versionUpdataEvent.isShowHotView) {
            return;
        }
        HotView hotView3 = this.g;
        if (hotView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hotView");
        } else {
            hotView2 = hotView3;
        }
        hotView2.setVisibility(0);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetTextI18n"})
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_about);
        me3.c(me3.c.ME_ABOUT_UI_ENTER);
        TextView textView = null;
        ye3.c("about", "into page", null);
        setCurrentScreen(this, "setting_about_screen_view", AboutActivity.class.getSimpleName());
        ArrayList arrayList = new ArrayList();
        final String strC = lg3.c(lg3.e(this));
        final PolicyListBean policyListBean = (PolicyListBean) new Gson().fromJson(eg3.h(this, "new_argement_list", ""), PolicyListBean.class);
        if (policyListBean != null && policyListBean.getData() != null && policyListBean.getData().size() > 0) {
            int size = policyListBean.getData().size();
            for (int i = 0; i < size; i++) {
                String url = policyListBean.getData().get(i).getUrl();
                Intrinsics.checkNotNullExpressionValue(url, "dataDTO.data[i].url");
                arrayList.add(url);
            }
        }
        View viewFindViewById = findViewById(R.id.version_history);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) viewFindViewById;
        this.d = relativeLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("version_history");
            relativeLayout = null;
        }
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: dc.ra3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutActivity.A4(this.a, view);
            }
        });
        View viewFindViewById2 = findViewById(R.id.about_privacy);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout2 = (RelativeLayout) viewFindViewById2;
        this.a = relativeLayout2;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("about_privacy");
            relativeLayout2 = null;
        }
        relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: dc.pa3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutActivity.C4(policyListBean, strC, this, view);
            }
        });
        View viewFindViewById3 = findViewById(R.id.about_group_chat);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout3 = (RelativeLayout) viewFindViewById3;
        this.h = relativeLayout3;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("about_group_chat");
            relativeLayout3 = null;
        }
        relativeLayout3.setOnClickListener(new View.OnClickListener() { // from class: dc.sa3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutActivity.D4(this.a, view);
            }
        });
        View viewFindViewById4 = findViewById(R.id.about_license);
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout4 = (RelativeLayout) viewFindViewById4;
        this.b = relativeLayout4;
        if (relativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("about_license");
            relativeLayout4 = null;
        }
        relativeLayout4.setOnClickListener(new View.OnClickListener() { // from class: dc.oa3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutActivity.E4(policyListBean, strC, this, view);
            }
        });
        View viewFindViewById5 = findViewById(R.id.about_eula);
        Intrinsics.checkNotNull(viewFindViewById5, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout5 = (RelativeLayout) viewFindViewById5;
        this.e = relativeLayout5;
        if (relativeLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("about_eula");
            relativeLayout5 = null;
        }
        relativeLayout5.setOnClickListener(new View.OnClickListener() { // from class: dc.va3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutActivity.F4(policyListBean, strC, this, view);
            }
        });
        View viewFindViewById6 = findViewById(R.id.about_update);
        Intrinsics.checkNotNull(viewFindViewById6, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.c = (RelativeLayout) viewFindViewById6;
        View viewFindViewById7 = findViewById(R.id.hot_check_update);
        Intrinsics.checkNotNull(viewFindViewById7, "null cannot be cast to non-null type com.wear.widget.HotView");
        this.g = (HotView) viewFindViewById7;
        RelativeLayout relativeLayout6 = this.c;
        if (relativeLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("about_update");
            relativeLayout6 = null;
        }
        relativeLayout6.setOnClickListener(new View.OnClickListener() { // from class: dc.ta3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutActivity.G4(this.a, view);
            }
        });
        View viewFindViewById8 = findViewById(R.id.app_version);
        Intrinsics.checkNotNull(viewFindViewById8, "null cannot be cast to non-null type android.widget.TextView");
        this.f = (TextView) viewFindViewById8;
        if (WearUtils.e1(WearUtils.q)) {
            WearUtils.q = MyApplication.Q(this) == null ? "" : MyApplication.Q(this).versionName;
        }
        TextView textView2 = this.f;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("app_version");
            textView2 = null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ah4.e(R.string.app_name));
        sb.append(' ');
        sb.append(WearUtils.q);
        sb.append(WearUtils.v ? "_t_" + Build.CPU_ABI : "");
        sb.append(WearUtils.w != OrmLiteConfigUtil.RESOURCE_DIR_NAME ? '_' + WearUtils.w : "");
        textView2.setText(sb.toString());
        View viewFindViewById9 = findViewById(R.id.remote_logo);
        Intrinsics.checkNotNull(viewFindViewById9, "null cannot be cast to non-null type android.widget.ImageView");
        ((ImageView) viewFindViewById9).setOnClickListener(new View.OnClickListener() { // from class: dc.ua3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutActivity.H4(view);
            }
        });
        TextView textView3 = this.f;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("app_version");
        } else {
            textView = textView3;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: dc.qa3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutActivity.B4(view);
            }
        });
        I4(MyApplication.S);
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        me3.c(me3.c.ME_ABOUT_UI_EXIT);
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(@Nullable VersionUpdataEvent hotDot) {
        I4(hotDot);
    }
}
