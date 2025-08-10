package com.wear.ui.longDistance;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.transition.ChangeBounds;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.widget.MediumBoldRadioButton;
import dc.nv1;
import dc.th4;
import dc.ue3;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class FriendsSearchListActivity extends BaseActivity {
    public AllFriendsFragment a;
    public RequestFriendsListFragment b;
    public BlockListFragment c;

    @BindView(R.id.et_search)
    public EditText etSearch;

    @BindView(R.id.iv_clear)
    public ImageView ivClear;

    @BindView(R.id.all_order)
    public LinearLayout mLlAllOrder;

    @BindView(R.id.rb_block)
    public MediumBoldRadioButton rbBlock;

    @BindView(R.id.rb_friends)
    public MediumBoldRadioButton rbFriends;

    @BindView(R.id.rb_request)
    public MediumBoldRadioButton rbRequest;

    @BindView(R.id.v_block_red_dot)
    public View vBlockRedDot;

    @BindView(R.id.v_friends_red_dot)
    public View vFriendsRedDot;

    @BindView(R.id.v_request_red_dot)
    public View vRequestRedDot;

    @BindView(R.id.view_pager)
    public ViewPager viewPager;
    public FragmentManager d = getSupportFragmentManager();
    public List<Fragment> e = new ArrayList();
    public int f = 0;
    public int g = 0;

    public class a extends FragmentPagerAdapter {
        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.PagerAdapter, com.githang.viewpagerindicator.IconPagerAdapter
        public int getCount() {
            return FriendsSearchListActivity.this.e.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return (Fragment) FriendsSearchListActivity.this.e.get(i);
        }
    }

    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 0) {
                FriendsSearchListActivity.this.rbFriends.setChecked(true);
                FriendsSearchListActivity.this.rbRequest.setChecked(false);
                FriendsSearchListActivity.this.rbBlock.setChecked(false);
                FriendsSearchListActivity.this.vFriendsRedDot.setVisibility(0);
                FriendsSearchListActivity.this.vRequestRedDot.setVisibility(8);
                FriendsSearchListActivity.this.vBlockRedDot.setVisibility(8);
                return;
            }
            if (i == 1) {
                FriendsSearchListActivity.this.rbFriends.setChecked(false);
                FriendsSearchListActivity.this.rbRequest.setChecked(true);
                FriendsSearchListActivity.this.rbBlock.setChecked(false);
                FriendsSearchListActivity.this.vFriendsRedDot.setVisibility(8);
                FriendsSearchListActivity.this.vRequestRedDot.setVisibility(0);
                FriendsSearchListActivity.this.vBlockRedDot.setVisibility(8);
                return;
            }
            FriendsSearchListActivity.this.rbFriends.setChecked(false);
            FriendsSearchListActivity.this.rbRequest.setChecked(false);
            FriendsSearchListActivity.this.rbBlock.setChecked(true);
            FriendsSearchListActivity.this.vFriendsRedDot.setVisibility(8);
            FriendsSearchListActivity.this.vRequestRedDot.setVisibility(8);
            FriendsSearchListActivity.this.vBlockRedDot.setVisibility(0);
        }
    }

    public class c extends nv1 {
        public c() {
        }

        @Override // dc.nv1, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int i = TextUtils.isEmpty(editable) ? 4 : 0;
            FriendsSearchListActivity.this.ivClear.setVisibility(i);
            FriendsSearchListActivity.this.viewPager.setVisibility(i);
            AllFriendsFragment allFriendsFragment = FriendsSearchListActivity.this.a;
            if (allFriendsFragment != null) {
                allFriendsFragment.a0(editable.toString(), FriendsSearchListActivity.this.g);
            }
            FriendsSearchListActivity friendsSearchListActivity = FriendsSearchListActivity.this;
            if (friendsSearchListActivity.g != 999) {
                RequestFriendsListFragment requestFriendsListFragment = friendsSearchListActivity.b;
                if (requestFriendsListFragment != null) {
                    requestFriendsListFragment.X(editable.toString());
                }
                BlockListFragment blockListFragment = FriendsSearchListActivity.this.c;
                if (blockListFragment != null) {
                    blockListFragment.W(editable.toString());
                }
            }
        }
    }

    public class d implements TextView.OnEditorActionListener {
        public d(FriendsSearchListActivity friendsSearchListActivity) {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            return keyEvent == null || keyEvent.getKeyCode() == 66;
        }
    }

    @OnClick({R.id.back, R.id.rb_friends, R.id.rb_request, R.id.rb_block, R.id.iv_clear})
    public void onClick(View view) throws Resources.NotFoundException {
        int id = view.getId();
        if (id == R.id.back) {
            finishAfterTransition();
        }
        if (id == R.id.iv_clear) {
            this.etSearch.setText("");
            return;
        }
        switch (id) {
            case R.id.rb_block /* 2131364168 */:
                this.viewPager.setCurrentItem(2);
                break;
            case R.id.rb_friends /* 2131364169 */:
                this.viewPager.setCurrentItem(0);
                break;
            case R.id.rb_request /* 2131364170 */:
                this.viewPager.setCurrentItem(1);
                break;
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(200L);
        getWindow().setSharedElementEnterTransition(changeBounds);
        super.onCreate(bundle);
        setContentView(R.layout.activity_friends_request_list);
        getWindow().getDecorView().getRootView().setBackgroundColor(th4.b(this, R.color.bg));
        ButterKnife.bind(this);
        t4(bundle);
        this.f = getIntent().getIntExtra("currentItem", 0);
        this.g = getIntent().getIntExtra(FirebaseAnalytics.Event.SEARCH, 0);
        this.viewPager.setAdapter(new a(this.d));
        this.viewPager.addOnPageChangeListener(new b());
        this.viewPager.setOffscreenPageLimit(this.e.size());
        this.viewPager.setCurrentItem(this.f);
        this.etSearch.addTextChangedListener(new c());
        this.etSearch.setOnEditorActionListener(new d(this));
        if (this.g != 999) {
            this.mLlAllOrder.setVisibility(0);
            return;
        }
        this.mLlAllOrder.setVisibility(8);
        this.viewPager.setVisibility(4);
        this.etSearch.requestFocus();
        ue3.d(this.etSearch, this);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ue3.a(this.etSearch, this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        AllFriendsFragment allFriendsFragment = this.a;
        if (allFriendsFragment != null && allFriendsFragment.isAdded()) {
            this.d.putFragment(bundle, this.a.getClass().getSimpleName(), this.a);
        }
        RequestFriendsListFragment requestFriendsListFragment = this.b;
        if (requestFriendsListFragment != null && requestFriendsListFragment.isAdded()) {
            this.d.putFragment(bundle, this.b.getClass().getSimpleName(), this.b);
        }
        BlockListFragment blockListFragment = this.c;
        if (blockListFragment == null || !blockListFragment.isAdded()) {
            return;
        }
        this.d.putFragment(bundle, this.c.getClass().getSimpleName(), this.c);
    }

    public final void t4(Bundle bundle) {
        if (bundle != null) {
            this.a = (AllFriendsFragment) this.d.getFragment(bundle, AllFriendsFragment.class.getSimpleName());
            this.b = (RequestFriendsListFragment) this.d.getFragment(bundle, RequestFriendsListFragment.class.getSimpleName());
            this.c = (BlockListFragment) this.d.getFragment(bundle, BlockListFragment.class.getSimpleName());
        }
        if (this.a == null) {
            this.a = new AllFriendsFragment();
        }
        if (this.b == null) {
            this.b = new RequestFriendsListFragment();
        }
        if (this.c == null) {
            this.c = new BlockListFragment();
        }
        this.e.clear();
        this.e.add(this.a);
        this.e.add(this.b);
        this.e.add(this.c);
    }
}
