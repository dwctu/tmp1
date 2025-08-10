package com.wear.main.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.fastjson.JSON;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.lovense.wear.R;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;
import com.wear.BaseActivity;
import com.wear.adapter.FAQAdapter;
import com.wear.bean.FaqResponeItems;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.em2;
import dc.lg3;
import dc.zo2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;

/* loaded from: classes3.dex */
public class FAQActivity extends BaseActivity implements zo2 {

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public View e;

    @BindView(R.id.pattern_list_empty)
    public LinearLayout emptyView;
    public em2 f;

    @BindView(R.id.loading_layer)
    public LinearLayout loading_layer;

    @BindView(R.id.pattern_list_empty_text)
    public TextView patternListEmptyText;

    @BindView(R.id.pattern_list_empty_tip)
    public TextView patternListEmptyTip;

    @BindView(R.id.pattern_list)
    public ListView pattern_list;

    @BindView(R.id.swipe_refresh_pattern)
    public SwipyRefreshLayout swipeRefreshLayout;
    public int a = 1;
    public boolean b = true;
    public FAQAdapter c = null;
    public List<FaqResponeItems> d = new ArrayList();

    public class a implements SwipyRefreshLayout.OnRefreshListener {
        public a() {
        }

        @Override // com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout.OnRefreshListener
        public void onRefresh(SwipyRefreshLayoutDirection swipyRefreshLayoutDirection) {
            SwipyRefreshLayoutDirection swipyRefreshLayoutDirection2 = SwipyRefreshLayoutDirection.TOP;
            if (swipyRefreshLayoutDirection == swipyRefreshLayoutDirection2) {
                FAQActivity.this.b = true;
                FAQActivity.this.a = 1;
                FAQActivity.this.v4();
            } else {
                FAQActivity.this.b = false;
                FAQActivity.this.v4();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Refresh triggered chat_notification_at ");
            sb.append(swipyRefreshLayoutDirection == swipyRefreshLayoutDirection2 ? "top" : "bottom");
            sb.toString();
        }
    }

    @Override // dc.zo2
    public void g2(boolean z, BaseResponseBean baseResponseBean) {
        this.swipeRefreshLayout.setRefreshing(false);
        if (baseResponseBean != null && baseResponseBean.getData() != null) {
            List array = JSON.parseArray(baseResponseBean.getData().toString(), FaqResponeItems.class);
            if (!WearUtils.g1(array)) {
                this.a++;
                if (this.b) {
                    this.d.clear();
                    this.c.d();
                }
                this.d.addAll(array);
                this.c.notifyDataSetChanged();
                if (array.size() < 30) {
                    this.pattern_list.removeFooterView(this.e);
                    this.pattern_list.addFooterView(this.e);
                    this.swipeRefreshLayout.setDirection(SwipyRefreshLayoutDirection.TOP);
                } else {
                    this.swipeRefreshLayout.setDirection(SwipyRefreshLayoutDirection.BOTH);
                    this.pattern_list.removeFooterView(this.e);
                }
            }
        }
        this.loading_layer.setVisibility(8);
        if (WearUtils.g1(this.d)) {
            this.swipeRefreshLayout.setVisibility(8);
            this.pattern_list.setVisibility(8);
            this.emptyView.setVisibility(0);
        } else {
            this.emptyView.setVisibility(8);
            this.pattern_list.setVisibility(0);
            this.swipeRefreshLayout.setVisibility(0);
        }
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        this.mActivityComponent.y(this);
        this.mPresenter = this.f;
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_faq_activity);
        ButterKnife.bind(this);
        this.swipeRefreshLayout.setColorSchemeResources(R.color.color_accent_second, R.color.pink, R.color.pink_stroke, R.color.color_accent);
        this.pattern_list.setEmptyView(this.emptyView);
        FAQAdapter fAQAdapter = new FAQAdapter(this);
        this.c = fAQAdapter;
        this.pattern_list.setAdapter((ListAdapter) fAQAdapter);
        this.swipeRefreshLayout.setOnRefreshListener(new a());
        this.e = LayoutInflater.from(this).inflate(R.layout.view_nomore_data, (ViewGroup) null);
        v4();
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public final void v4() {
        List<FaqResponeItems> list = this.d;
        if (list != null && list.size() == 0) {
            this.loading_layer.setVisibility(0);
        }
        this.emptyView.setVisibility(8);
        HashMap map = new HashMap();
        map.put("platform", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        map.put("language", lg3.b(this));
        map.put("appType", "remote");
        map.put(DataLayout.ELEMENT, Integer.valueOf(this.a));
        map.put("pageSize", 30);
        this.f.h(false, map);
    }
}
