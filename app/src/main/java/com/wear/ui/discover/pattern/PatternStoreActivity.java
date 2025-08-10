package com.wear.ui.discover.pattern;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.patterns.PatternGalleryAdapter;
import com.wear.bean.Toy;
import com.wear.bean.event.PatternFavoriteChangeEvent;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.toy.ToyActivity;
import com.wear.ui.home.pattern.control.PatternPlayManagerImpl;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MediumBoldTextView;
import dc.ah4;
import dc.cg3;
import dc.js3;
import dc.me3;
import dc.mf3;
import dc.pj3;
import dc.sz1;
import dc.th4;
import dc.tz1;
import dc.xc1;
import dc.ye3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class PatternStoreActivity extends BaseActivity implements View.OnClickListener, tz1 {
    public static Map<String, String> l = new HashMap();
    public MyApplication a;
    public boolean f;
    public PatternGalleryAdapter g;
    public js3 i;

    @BindView(R.id.iv_back)
    public ImageView ivBack;

    @BindView(R.id.iv_not_toy)
    public ImageView ivNotToy;

    @BindView(R.id.iv_pattern_search)
    public ImageView ivPatternSearch;

    @BindView(R.id.login_patterns)
    public LinearLayout loginPattern;

    @BindView(R.id.offline_login)
    public MediumBoldTextView offlineLogin;

    @BindView(R.id.offline_patterns)
    public LinearLayout offlinePattern;

    @BindView(R.id.pattern_filter)
    public ImageView patternFilter;

    @BindView(R.id.patterns_viewpager)
    public ViewPager patternsViewpager;

    @BindView(R.id.rl_toy_1)
    public AppCompatTextView rlToy1;

    @BindView(R.id.rl_toy_2)
    public AppCompatTextView rlToy2;

    @BindView(R.id.rv_toytype_horizontal)
    public RecyclerView rvToytypeHorizontal;

    @BindView(R.id.toys_number_text)
    public AppCompatTextView toysNumber;

    @BindView(R.id.tv_title)
    public TextView tvTitle;
    public String b = null;
    public String c = null;
    public String d = null;
    public String e = null;
    public List<PatternsItemFragment> h = new ArrayList();
    public boolean j = mf3.b.booleanValue();
    public int k = 0;

    public class a implements View.OnClickListener {

        /* renamed from: com.wear.ui.discover.pattern.PatternStoreActivity$a$a, reason: collision with other inner class name */
        public class C0142a implements js3.i {
            public C0142a() {
            }

            @Override // dc.js3.i
            public void a(String str, String str2, String str3, String str4, boolean z) {
                PatternStoreActivity patternStoreActivity = PatternStoreActivity.this;
                patternStoreActivity.b = str;
                patternStoreActivity.c = str2;
                String str5 = "toyTag======" + str2;
                PatternStoreActivity patternStoreActivity2 = PatternStoreActivity.this;
                patternStoreActivity2.f = z;
                patternStoreActivity2.d = str3;
                patternStoreActivity2.e = str4;
                if (WearUtils.e1(str2) && WearUtils.e1(str3) && str4.equals("0")) {
                    PatternStoreActivity.this.patternFilter.setImageResource(R.drawable.patterns_menu_filter);
                } else {
                    PatternStoreActivity.this.patternFilter.setImageResource(R.drawable.patterns_menu_filter_click);
                }
                for (PatternsItemFragment patternsItemFragment : PatternStoreActivity.this.h) {
                    PatternStoreActivity patternStoreActivity3 = PatternStoreActivity.this;
                    if (patternStoreActivity3.b == null) {
                        patternStoreActivity3.b = "";
                    }
                    if (patternStoreActivity3.c == null) {
                        patternStoreActivity3.c = "";
                    }
                    patternsItemFragment.w0(true, patternStoreActivity3.b, patternStoreActivity3.c, TextUtils.isEmpty(str2));
                }
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PatternStoreActivity.this.i != null && !PatternStoreActivity.this.i.u()) {
                PatternStoreActivity.this.i.z();
                return;
            }
            PatternStoreActivity patternStoreActivity = PatternStoreActivity.this;
            patternStoreActivity.w4();
            patternStoreActivity.i = new js3(patternStoreActivity);
            PatternStoreActivity.this.i.z();
            PatternStoreActivity.this.i.w(new C0142a());
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PatternStoreActivity patternStoreActivity = PatternStoreActivity.this;
            patternStoreActivity.w4();
            pj3.f(patternStoreActivity, ToyActivity.class);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PatternStoreActivity patternStoreActivity = PatternStoreActivity.this;
            patternStoreActivity.w4();
            pj3.f(patternStoreActivity, ToyActivity.class);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PatternStoreActivity patternStoreActivity = PatternStoreActivity.this;
            patternStoreActivity.w4();
            pj3.f(patternStoreActivity, ToyActivity.class);
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PatternStoreActivity patternStoreActivity = PatternStoreActivity.this;
            patternStoreActivity.w4();
            pj3.f(patternStoreActivity, PatternSearchActivity.class);
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PatternStoreActivity patternStoreActivity = PatternStoreActivity.this;
            patternStoreActivity.w4();
            pj3.s(patternStoreActivity, LoginActivity.class);
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PatternPlayManagerImpl.O().g0()) {
                PatternPlayManagerImpl.O().B0();
            }
            PatternStoreActivity.this.finish();
        }
    }

    public class h extends FragmentPagerAdapter {
        public h(FragmentManager fragmentManager, int i) {
            super(fragmentManager, i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter, com.githang.viewpagerindicator.IconPagerAdapter
        public int getCount() {
            return PatternStoreActivity.this.h.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return (Fragment) PatternStoreActivity.this.h.get(i);
        }
    }

    public class i implements ViewPager.OnPageChangeListener {
        public i() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PatternStoreActivity.this.g.s(i);
            if (i == 1) {
                PatternStoreActivity.this.rvToytypeHorizontal.smoothScrollToPosition(0);
            } else if (i == 3) {
                PatternStoreActivity.this.rvToytypeHorizontal.smoothScrollToPosition(4);
            } else {
                PatternStoreActivity.this.rvToytypeHorizontal.smoothScrollToPosition(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B4(View view) {
        pj3.f(this, ToyActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z4(View view, PatternGalleryAdapter.c cVar, int i2) throws Resources.NotFoundException {
        this.patternsViewpager.setCurrentItem(i2);
    }

    public void C4() {
        MyApplication myApplication = WearUtils.x;
        if (myApplication == null || this.rlToy1 == null) {
            return;
        }
        ArrayList<Toy> arrayListO = myApplication.G().o();
        if (arrayListO.size() == 0) {
            this.rlToy1.setVisibility(8);
            this.rlToy2.setVisibility(8);
            this.toysNumber.setVisibility(8);
            this.ivNotToy.setVisibility(0);
            return;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < arrayListO.size(); i3++) {
            Toy toy = arrayListO.get(i3);
            if (toy != null && toy.isConnected()) {
                if (i2 == 0) {
                    this.rlToy1.setVisibility(0);
                    this.rlToy1.setBackgroundResource(Toy.getToyIconLinkedId(toy.getType(), i3, true));
                    this.rlToy1.setText(toy.getToyUINameSpecialForMiniXMachine(2));
                } else {
                    this.rlToy2.setVisibility(0);
                    this.rlToy2.setBackgroundResource(Toy.getToyIconLinkedId(toy.getType(), i3, true));
                    this.rlToy2.setText(toy.getToyUINameSpecialForMiniXMachine(2));
                }
                i2++;
                this.ivNotToy.setVisibility(8);
            }
        }
        if (i2 == 0) {
            this.rlToy1.setVisibility(8);
            this.rlToy2.setVisibility(8);
            this.ivNotToy.setVisibility(0);
            this.toysNumber.setVisibility(8);
            return;
        }
        if (i2 == 1) {
            this.rlToy1.setVisibility(0);
            this.rlToy2.setVisibility(8);
            this.toysNumber.setVisibility(8);
        } else {
            if (i2 == 2) {
                this.rlToy1.setVisibility(0);
                this.rlToy2.setVisibility(0);
                this.toysNumber.setVisibility(8);
                return;
            }
            this.rlToy1.setVisibility(8);
            this.rlToy2.setVisibility(8);
            this.toysNumber.setBackgroundDrawable(th4.d(this, R.drawable.toys_number_background));
            this.toysNumber.setOnClickListener(new View.OnClickListener() { // from class: dc.nx2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.B4(view);
                }
            });
            this.toysNumber.setVisibility(0);
            this.toysNumber.setText(String.format(ah4.c(R.string.multiple_toys), Integer.valueOf(i2)));
        }
    }

    @Override // dc.tz1
    public int getPriority() {
        return 4;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (PatternPlayManagerImpl.O().g0()) {
            PatternPlayManagerImpl.O().B0();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        me3.c(me3.c.PATTERN_STORE_UI_ENTER);
        ye3.c("pattern store", "into page", null);
        this.a = (MyApplication) getApplication();
        setContentView(R.layout.discover_pattern_store_activity);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        this.k = getIntent().getIntExtra("currentItem", 0);
        this.tvTitle.setText(ah4.e(R.string.main_patterns));
        if (!MyApplication.Z || this.j) {
            this.loginPattern.setVisibility(0);
            this.offlinePattern.setVisibility(8);
            x4();
        } else {
            this.loginPattern.setVisibility(8);
            this.offlinePattern.setVisibility(0);
        }
        sz1.d().n(this);
        if (WearUtils.g1(WearUtils.x.G().P())) {
            this.patternFilter.setImageResource(R.drawable.patterns_menu_filter);
        } else {
            this.patternFilter.setImageResource(R.drawable.patterns_menu_filter_click);
        }
        this.patternFilter.setOnClickListener(new a());
        this.ivNotToy.setOnClickListener(new b());
        this.rlToy1.setOnClickListener(new c());
        this.rlToy2.setOnClickListener(new d());
        this.ivPatternSearch.setOnClickListener(new e());
        this.offlineLogin.setOnClickListener(new f());
        this.ivBack.setOnClickListener(new g());
        addAnalyticsEventId("menu_patterns", null);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        me3.c(me3.c.PATTERN_STORE_UI_EXIT);
        sz1.d().s(this);
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(xc1 xc1Var) {
        C4();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C4();
    }

    @Override // dc.tz1
    public void pauseConnon(int i2) {
    }

    @Override // dc.tz1
    public void recovery() {
    }

    @Override // dc.tz1
    public void stop(int i2) {
        if (this.patternsViewpager == null || this.h.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < this.h.size(); i3++) {
            if (this.h.get(i3) != null) {
                this.h.get(i3).I();
            }
        }
    }

    public Activity w4() {
        return this;
    }

    public final void x4() throws Resources.NotFoundException {
        PatternGalleryAdapter patternGalleryAdapter = new PatternGalleryAdapter(this.a);
        this.g = patternGalleryAdapter;
        patternGalleryAdapter.t(new PatternGalleryAdapter.b() { // from class: dc.mx2
            @Override // com.wear.adapter.patterns.PatternGalleryAdapter.b
            public final void a(View view, PatternGalleryAdapter.c cVar, int i2) throws Resources.NotFoundException {
                this.a.z4(view, cVar, i2);
            }
        });
        cg3.d(this.rvToytypeHorizontal, this.g);
        for (int i2 = 0; i2 < this.g.getItemCount(); i2++) {
            PatternsItemFragment patternsItemFragment = new PatternsItemFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", this.g.p().get(i2).b());
            patternsItemFragment.setArguments(bundle);
            this.h.add(patternsItemFragment);
        }
        this.patternsViewpager.setAdapter(new h(getSupportFragmentManager(), 1));
        this.patternsViewpager.addOnPageChangeListener(new i());
        this.patternsViewpager.setOffscreenPageLimit(this.h.size());
        this.patternsViewpager.setCurrentItem(this.k);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(PatternFavoriteChangeEvent patternFavoriteChangeEvent) {
        List<PatternsItemFragment> list = this.h;
        if (list == null || list.size() <= 0) {
            return;
        }
        if (patternFavoriteChangeEvent.isStart()) {
            String str = "onMessageEvent add: " + patternFavoriteChangeEvent.getPatternId();
            l.put(patternFavoriteChangeEvent.getPatternId(), patternFavoriteChangeEvent.getPatternId());
            for (PatternsItemFragment patternsItemFragment : this.h) {
                if (patternsItemFragment != null) {
                    patternsItemFragment.u0(patternFavoriteChangeEvent);
                }
            }
            return;
        }
        if (patternFavoriteChangeEvent.isFail()) {
            l.remove(patternFavoriteChangeEvent.getPatternId());
            for (PatternsItemFragment patternsItemFragment2 : this.h) {
                if (patternsItemFragment2 != null) {
                    patternsItemFragment2.u0(patternFavoriteChangeEvent);
                }
            }
            return;
        }
        String str2 = "onMessageEvent remove: " + patternFavoriteChangeEvent.getPatternId();
        l.remove(patternFavoriteChangeEvent.getPatternId());
        for (PatternsItemFragment patternsItemFragment3 : this.h) {
            if (patternsItemFragment3 != null) {
                patternsItemFragment3.u0(patternFavoriteChangeEvent);
            }
        }
    }
}
