package com.wear.ui.discover.pattern;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.adapter.patterns.PatternGalleryAdapter;
import com.wear.bean.Toy;
import com.wear.bean.event.PatternFavoriteChangeEvent;
import com.wear.main.BaseFragment;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.toy.ToyActivity;
import com.wear.ui.home.pattern.control.PatternPlayManagerImpl;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MediumBoldTextView;
import dc.ah4;
import dc.cg3;
import dc.js3;
import dc.pj3;
import dc.sn3;
import dc.sz1;
import dc.tz1;
import dc.xc1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class PatternFragment extends BaseFragment implements View.OnClickListener, tz1 {
    public static String p;
    public static String q;
    public static String r;
    public static Map<String, String> s = new HashMap();

    @BindView(R.id.iv_back)
    public ImageView ivBack;

    @BindView(R.id.iv_not_toy)
    public ImageView ivNotToy;

    @BindView(R.id.iv_pattern_search)
    public ImageView ivPatternSearch;
    public MyApplication k;
    public PatternGalleryAdapter l;

    @BindView(R.id.login_patterns)
    public LinearLayout loginPattern;
    public List<PatternsItemFragment> m = new ArrayList();
    public js3 n;
    public sn3 o;

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

    @BindView(R.id.title_add)
    public ImageView titleAdd;

    @BindView(R.id.tv_title)
    public TextView tvTitle;

    public class a implements View.OnClickListener {

        /* renamed from: com.wear.ui.discover.pattern.PatternFragment$a$a, reason: collision with other inner class name */
        public class C0141a implements js3.i {
            public C0141a() {
            }

            @Override // dc.js3.i
            public void a(String str, String str2, String str3, String str4, boolean z) {
                String str5 = "tags====" + str2;
                PatternFragment.p = str;
                PatternFragment.q = str3;
                PatternFragment.r = str4;
                if (WearUtils.e1(str) && WearUtils.e1(str3) && str4.equals("0")) {
                    PatternFragment.this.patternFilter.setImageResource(R.drawable.patterns_menu_filter);
                } else {
                    PatternFragment.this.patternFilter.setImageResource(R.drawable.patterns_menu_filter_click);
                }
                for (PatternsItemFragment patternsItemFragment : PatternFragment.this.m) {
                    if (str == null) {
                        str = "";
                    }
                    patternsItemFragment.w0(true, str, str2, TextUtils.isEmpty(str2));
                }
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PatternFragment.this.n != null && !PatternFragment.this.n.u()) {
                PatternFragment.this.n.z();
                return;
            }
            PatternFragment patternFragment = PatternFragment.this;
            patternFragment.n = new js3(patternFragment.getActivity());
            PatternFragment.this.n.z();
            PatternFragment.this.n.w(new C0141a());
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PatternFragment.this.o == null) {
                PatternFragment patternFragment = PatternFragment.this;
                patternFragment.o = new sn3(patternFragment.getActivity());
            }
            PatternFragment.this.o.e(view);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            pj3.f(PatternFragment.this.getActivity(), ToyActivity.class);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            pj3.f(PatternFragment.this.getActivity(), ToyActivity.class);
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            pj3.f(PatternFragment.this.getActivity(), ToyActivity.class);
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            pj3.f(PatternFragment.this.getActivity(), PatternSearchActivity.class);
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            pj3.s(PatternFragment.this.getActivity(), LoginActivity.class);
        }
    }

    public class h extends FragmentPagerAdapter {
        public h(FragmentManager fragmentManager, int i) {
            super(fragmentManager, i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter, com.githang.viewpagerindicator.IconPagerAdapter
        public int getCount() {
            return PatternFragment.this.m.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return (Fragment) PatternFragment.this.m.get(i);
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
            PatternFragment.this.l.s(i);
            if (i == 1) {
                PatternFragment.this.rvToytypeHorizontal.smoothScrollToPosition(0);
            } else if (i == 3) {
                PatternFragment.this.rvToytypeHorizontal.smoothScrollToPosition(4);
            } else {
                PatternFragment.this.rvToytypeHorizontal.smoothScrollToPosition(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g0(View view, PatternGalleryAdapter.c cVar, int i2) throws Resources.NotFoundException {
        this.patternsViewpager.setCurrentItem(i2);
    }

    @Override // com.wear.main.BaseFragment
    public void I() {
        if (this.patternsViewpager != null && this.m.size() > 0) {
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                if (this.m.get(i2) != null) {
                    this.m.get(i2).I();
                }
            }
        }
        if (PatternPlayManagerImpl.O().g0()) {
            PatternPlayManagerImpl.O().B0();
        }
    }

    @Override // com.wear.main.BaseFragment
    public void J() {
        if (this.patternsViewpager != null && this.m.size() > 0) {
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                if (this.m.get(i2) != null) {
                    this.m.get(i2).J();
                }
            }
        }
        PatternGalleryAdapter patternGalleryAdapter = this.l;
        if (patternGalleryAdapter != null) {
            patternGalleryAdapter.notifyDataSetChanged();
        }
        t("menu_patterns", null);
    }

    @Override // com.wear.main.BaseFragment
    public void Q() {
        MyApplication myApplication = WearUtils.x;
        if (myApplication == null || this.rlToy1 == null) {
            return;
        }
        ArrayList<Toy> arrayListO = myApplication.G().o();
        if (arrayListO.size() == 0) {
            this.rlToy1.setVisibility(8);
            this.rlToy2.setVisibility(8);
            this.ivNotToy.setVisibility(0);
            return;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < arrayListO.size() && i2 < 2; i3++) {
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
        } else if (i2 == 1) {
            this.rlToy1.setVisibility(0);
            this.rlToy2.setVisibility(8);
        } else {
            this.rlToy1.setVisibility(0);
            this.rlToy2.setVisibility(0);
        }
    }

    public final void e0() throws Resources.NotFoundException {
        PatternGalleryAdapter patternGalleryAdapter = new PatternGalleryAdapter(this.k);
        this.l = patternGalleryAdapter;
        patternGalleryAdapter.t(new PatternGalleryAdapter.b() { // from class: dc.lx2
            @Override // com.wear.adapter.patterns.PatternGalleryAdapter.b
            public final void a(View view, PatternGalleryAdapter.c cVar, int i2) throws Resources.NotFoundException {
                this.a.g0(view, cVar, i2);
            }
        });
        cg3.d(this.rvToytypeHorizontal, this.l);
        for (int i2 = 0; i2 < this.l.getItemCount(); i2++) {
            PatternsItemFragment patternsItemFragment = new PatternsItemFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", this.l.p().get(i2).b());
            patternsItemFragment.setArguments(bundle);
            this.m.add(patternsItemFragment);
        }
        this.patternsViewpager.setAdapter(new h(getChildFragmentManager(), 1));
        this.patternsViewpager.addOnPageChangeListener(new i());
        this.patternsViewpager.setOffscreenPageLimit(this.m.size());
        this.patternsViewpager.setCurrentItem(0);
    }

    @Override // dc.tz1
    public int getPriority() {
        return 4;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) throws Resources.NotFoundException {
        MyApplication myApplication = (MyApplication) getActivity().getApplication();
        this.k = myApplication;
        M(myApplication);
        View viewInflate = layoutInflater.inflate(R.layout.pattern_fragment, (ViewGroup) null, false);
        ButterKnife.bind(this, viewInflate);
        EventBus.getDefault().register(this);
        this.tvTitle.setText(ah4.e(R.string.main_patterns));
        this.loginPattern.setVisibility(0);
        this.offlinePattern.setVisibility(8);
        this.ivPatternSearch.setVisibility(0);
        e0();
        sz1.d().n(this);
        this.patternFilter.setOnClickListener(new a());
        this.titleAdd.setOnClickListener(new b());
        this.ivNotToy.setOnClickListener(new c());
        this.rlToy1.setOnClickListener(new d());
        this.rlToy2.setOnClickListener(new e());
        this.ivPatternSearch.setOnClickListener(new f());
        this.offlineLogin.setOnClickListener(new g());
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        sz1.d().s(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(xc1 xc1Var) {
        Q();
    }

    @Override // dc.tz1
    public void pauseConnon(int i2) {
    }

    @Override // dc.tz1
    public void recovery() {
    }

    @Override // dc.tz1
    public void stop(int i2) {
        I();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(PatternFavoriteChangeEvent patternFavoriteChangeEvent) {
        List<PatternsItemFragment> list = this.m;
        if (list == null || list.size() <= 0) {
            return;
        }
        if (patternFavoriteChangeEvent.isStart()) {
            String str = "onMessageEvent add: " + patternFavoriteChangeEvent.getPatternId();
            s.put(patternFavoriteChangeEvent.getPatternId(), patternFavoriteChangeEvent.getPatternId());
            for (PatternsItemFragment patternsItemFragment : this.m) {
                if (patternsItemFragment != null) {
                    patternsItemFragment.u0(patternFavoriteChangeEvent);
                }
            }
            return;
        }
        if (patternFavoriteChangeEvent.isFail()) {
            s.remove(patternFavoriteChangeEvent.getPatternId());
            for (PatternsItemFragment patternsItemFragment2 : this.m) {
                if (patternsItemFragment2 != null) {
                    patternsItemFragment2.u0(patternFavoriteChangeEvent);
                }
            }
            return;
        }
        String str2 = "onMessageEvent remove: " + patternFavoriteChangeEvent.getPatternId();
        s.remove(patternFavoriteChangeEvent.getPatternId());
        for (PatternsItemFragment patternsItemFragment3 : this.m) {
            if (patternsItemFragment3 != null) {
                patternsItemFragment3.u0(patternFavoriteChangeEvent);
            }
        }
    }
}
