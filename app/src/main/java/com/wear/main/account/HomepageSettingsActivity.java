package com.wear.main.account;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.setting.HomepageSettingsAdapter;
import com.wear.bean.HomepageArrangeBean;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ce3;
import dc.cg3;
import dc.eg3;
import dc.lg3;
import dc.th4;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class HomepageSettingsActivity extends BaseActivity {
    public static String i = "Remote";
    public static String j = "My Patterns";
    public static String k = "Music";
    public static String l = "Control Link";
    public static String m = "AS";
    public List<String> a;
    public HomepageSettingsAdapter b;
    public ItemTouchHelper c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public String h;

    @BindView(R.id.ac_homepage_settings_music_content)
    public ImageView ivMusicContent;

    @BindView(R.id.ac_homepage_settings_music_content_select)
    public ImageView ivMusicContentSel;

    @BindView(R.id.ac_homepage_settings_music_pure)
    public ImageView ivMusicPure;

    @BindView(R.id.ac_homepage_settings_music_pure_select)
    public ImageView ivMusicPureSel;

    @BindView(R.id.ac_homepage_settings_pattern_content)
    public ImageView ivPatternContent;

    @BindView(R.id.ac_homepage_settings_pattern_content_select)
    public ImageView ivPatternContentSel;

    @BindView(R.id.ac_homepage_settings_pattern_pure)
    public ImageView ivPatternPure;

    @BindView(R.id.ac_homepage_settings_pattern_pure_select)
    public ImageView ivPatternPureSel;

    @BindView(R.id.ac_homepage_settings_rcv)
    public RecyclerView recyclerView;

    public class MyItemTouchHelperCallback extends ItemTouchHelper.Callback {
        public final HomepageSettingsAdapter a;

        public MyItemTouchHelperCallback(HomepageSettingsAdapter homepageSettingsAdapter) {
            this.a = homepageSettingsAdapter;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            super.clearView(recyclerView, viewHolder);
            LinearLayout linearLayout = (LinearLayout) viewHolder.itemView.findViewById(R.id.item_homepage_settings_p);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.setMargins(ce3.a(HomepageSettingsActivity.this.application, 16.0f), ce3.a(HomepageSettingsActivity.this.application, 8.0f), ce3.a(HomepageSettingsActivity.this.application, 16.0f), ce3.a(HomepageSettingsActivity.this.application, 8.0f));
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setBackground(th4.d(HomepageSettingsActivity.this.application, R.drawable.item_homepage_settings_normal_bg));
            this.a.z(viewHolder);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            int i;
            int i2;
            if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                i = 15;
                i2 = 0;
            } else {
                i = 2;
                i2 = 3;
            }
            return ItemTouchHelper.Callback.makeFlag(i, i2);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2) {
            this.a.A(viewHolder.getLayoutPosition(), viewHolder2.getLayoutPosition());
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int i) {
            super.onSelectedChanged(viewHolder, i);
            if (i != 0) {
                LinearLayout linearLayout = (LinearLayout) viewHolder.itemView.findViewById(R.id.item_homepage_settings_p);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.setMargins(ce3.a(HomepageSettingsActivity.this.application, 8.0f), ce3.a(HomepageSettingsActivity.this.application, 8.0f), ce3.a(HomepageSettingsActivity.this.application, 8.0f), ce3.a(HomepageSettingsActivity.this.application, 8.0f));
                linearLayout.setLayoutParams(layoutParams);
                linearLayout.setBackground(th4.d(HomepageSettingsActivity.this.application, R.drawable.item_homepage_settings_transport_bg));
                this.a.B(viewHolder);
            }
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        }
    }

    public final boolean C4() {
        return (TextUtils.equals("zh", lg3.f(WearUtils.x)) || WearUtils.D) ? false : true;
    }

    public void D4() {
        if (this.g) {
            this.ivMusicContent.setBackground(null);
            this.ivMusicContentSel.setVisibility(4);
            this.ivMusicPure.setBackground(th4.d(this.application, R.drawable.item_homepage_style_select_bg));
            this.ivMusicPureSel.setVisibility(0);
        } else {
            this.ivMusicPure.setBackground(null);
            this.ivMusicPureSel.setVisibility(4);
            this.ivMusicContent.setBackground(th4.d(this.application, R.drawable.item_homepage_style_select_bg));
            this.ivMusicContentSel.setVisibility(0);
        }
        eg3.i(MyApplication.N(), "hpspm", Boolean.valueOf(this.g));
    }

    public void E4() {
        if (this.f) {
            this.ivPatternContent.setBackground(null);
            this.ivPatternContentSel.setVisibility(4);
            this.ivPatternPure.setBackground(th4.d(this.application, R.drawable.item_homepage_style_select_bg));
            this.ivPatternPureSel.setVisibility(0);
        } else {
            this.ivPatternContent.setBackground(th4.d(this.application, R.drawable.item_homepage_style_select_bg));
            this.ivPatternContentSel.setVisibility(0);
            this.ivPatternPure.setBackground(null);
            this.ivPatternPureSel.setVisibility(4);
        }
        eg3.i(MyApplication.N(), "hpspp", Boolean.valueOf(this.f));
    }

    public void doClick(View view) {
        switch (view.getId()) {
            case R.id.ac_homepage_settings_music_content /* 2131361850 */:
                this.g = false;
                addAnalyticsEventId("music_style_2_functional", null);
                D4();
                break;
            case R.id.ac_homepage_settings_music_pure /* 2131361852 */:
                this.g = true;
                addAnalyticsEventId("music_style_2_minimalist", null);
                D4();
                break;
            case R.id.ac_homepage_settings_pattern_content /* 2131361854 */:
                this.f = false;
                addAnalyticsEventId("pattern_style_1_functional", null);
                E4();
                break;
            case R.id.ac_homepage_settings_pattern_pure /* 2131361856 */:
                this.f = true;
                addAnalyticsEventId("pattern_style_2_minimalist", null);
                E4();
                break;
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_homepage_settings);
        ButterKnife.bind(this);
        this.application = (MyApplication) getApplication();
        this.h = eg3.h(MyApplication.N(), "homepageSettings", "");
        Gson gson = new Gson();
        if (WearUtils.e1(this.h)) {
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            arrayList.add(i);
            this.a.add(j);
            if (C4()) {
                this.a.add(l);
            }
            this.a.add(k);
            this.h = gson.toJson(this.a);
        } else {
            List<String> list = (List) gson.fromJson(this.h, List.class);
            this.a = list;
            list.remove(m);
            if (this.a.contains(l)) {
                if (!C4()) {
                    this.a.remove(l);
                }
            } else if (C4()) {
                this.a.add(2, l);
            }
        }
        HomepageSettingsAdapter homepageSettingsAdapter = new HomepageSettingsAdapter(this.a, R.layout.item_homepage_settings);
        this.b = homepageSettingsAdapter;
        cg3.f(this.recyclerView, homepageSettingsAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new MyItemTouchHelperCallback(this.b));
        this.c = itemTouchHelper;
        itemTouchHelper.attachToRecyclerView(this.recyclerView);
        MyApplication myApplicationN = MyApplication.N();
        Boolean bool = Boolean.FALSE;
        this.d = ((Boolean) eg3.b(myApplicationN, "hpspp", bool)).booleanValue();
        boolean zBooleanValue = ((Boolean) eg3.b(MyApplication.N(), "hpspm", bool)).booleanValue();
        this.e = zBooleanValue;
        this.f = this.d;
        this.g = zBooleanValue;
        E4();
        D4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (!this.h.equals(new Gson().toJson(this.a)) || this.g != this.e || this.f != this.d) {
            EventBus.getDefault().post(new HomepageArrangeBean());
        }
        super.onDestroy();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }
}
