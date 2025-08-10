package com.wear.ui.me;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.lovense.wear.R;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;
import com.wear.BaseActivity;
import com.wear.adapter.patterns.PatternsHiddenAdapter;
import com.wear.bean.Pattern;
import com.wear.bean.PatternHiddenShowSuccBean;
import com.wear.bean.event.PatternDownloadEvent;
import com.wear.bean.event.PatternFavoriteChangeEvent;
import com.wear.bean.event.ReportSuccEvent;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.ui.discover.pattern.ReportReasonActivity;
import com.wear.ui.home.pattern.control.PatternPlayManagerImpl;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.cg3;
import dc.cn2;
import dc.ff3;
import dc.h12;
import dc.hf3;
import dc.hv1;
import dc.jp2;
import dc.pj3;
import dc.rf3;
import dc.sg3;
import dc.tn2;
import dc.tz1;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes4.dex */
public class PatternsHiddenActivity extends BaseActivity implements PatternsHiddenAdapter.f, jp2, tz1, hv1 {
    public cn2 a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public PatternsHiddenAdapter b;
    public ArrayList<Pattern> c;
    public PatternsHiddenAdapter.PatternViewHolder d;
    public LinearLayoutManager e;
    public boolean f;

    @BindView(R.id.pattern_recylerview)
    public RecyclerView mRecyclerView;

    @BindView(R.id.swipe_refresh_pattern)
    public SwipyRefreshLayout mSwipeRefreshPattern;

    @BindView(R.id.pattern_list_empty)
    public RelativeLayout mllEmpty;

    @BindView(R.id.pattern_list_empty_text)
    public TextView pattern_list_empty_text;

    public class a extends ff3 {
        public final /* synthetic */ Pattern a;
        public final /* synthetic */ int b;

        public a(Pattern pattern, int i) {
            this.a = pattern;
            this.b = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void f(int i, String str) {
            if (PatternsHiddenActivity.this.c.size() < i) {
                return;
            }
            for (int size = PatternsHiddenActivity.this.c.size() - 1; size >= 0; size--) {
                if (((Pattern) PatternsHiddenActivity.this.c.get(size)).getId().equals(str)) {
                    RecyclerView recyclerView = PatternsHiddenActivity.this.mRecyclerView;
                    if (recyclerView == null || recyclerView.getAdapter() == null) {
                        return;
                    }
                    if (PatternsHiddenActivity.this.mRecyclerView.getAdapter().getItemCount() > size) {
                        PatternsHiddenActivity.this.b.notifyItemChanged(size, "getServerFile");
                        return;
                    } else {
                        PatternsHiddenActivity.this.b.notifyDataSetChanged();
                        return;
                    }
                }
            }
        }

        @Override // dc.ff3
        public void b(boolean z, Object obj) throws Throwable {
            if (z) {
                try {
                    this.a.setDataNoCheckFormat(WearUtils.N1(((File) obj).getPath()));
                    final String id = this.a.getId();
                    PatternsHiddenActivity patternsHiddenActivity = PatternsHiddenActivity.this;
                    final int i = this.b;
                    patternsHiddenActivity.runOnUiThread(new Runnable() { // from class: dc.lb3
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.f(i, id);
                        }
                    });
                } catch (Exception unused) {
                    PatternsHiddenActivity.this.notifyDataSetChanged();
                }
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = PatternsHiddenActivity.this.mRecyclerView;
            if (recyclerView == null || recyclerView.getAdapter() == null) {
                return;
            }
            PatternsHiddenActivity.this.b.notifyDataSetChanged();
            PatternsHiddenActivity patternsHiddenActivity = PatternsHiddenActivity.this;
            patternsHiddenActivity.mSwipeRefreshPattern.setVisibility(patternsHiddenActivity.c.size() == 0 ? 8 : 0);
            PatternsHiddenActivity patternsHiddenActivity2 = PatternsHiddenActivity.this;
            patternsHiddenActivity2.mRecyclerView.setVisibility(patternsHiddenActivity2.c.size() == 0 ? 8 : 0);
            PatternsHiddenActivity patternsHiddenActivity3 = PatternsHiddenActivity.this;
            patternsHiddenActivity3.mllEmpty.setVisibility(patternsHiddenActivity3.c.size() == 0 ? 0 : 8);
        }
    }

    public class c extends ff3 {
        public final /* synthetic */ Pattern a;

        public c(Pattern pattern) {
            this.a = pattern;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void f(Pattern pattern) {
            PatternPlayManagerImpl.O().X(PatternsHiddenActivity.this.c, 1);
            PatternPlayManagerImpl.O().G0(pattern);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void h() {
            PatternPlayManagerImpl.O().U0();
            sg3.i(PatternsHiddenActivity.this, R.string.file_notfound);
        }

        @Override // dc.ff3
        public void b(boolean z, Object obj) throws Throwable {
            if (!z) {
                PatternsHiddenActivity.this.runOnUiThread(new Runnable() { // from class: dc.nb3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.h();
                    }
                });
                return;
            }
            String strN1 = WearUtils.N1(((File) obj).getPath());
            if (rf3.o(strN1)) {
                strN1 = rf3.r(strN1);
                WearUtils.m2(strN1, this.a.getId());
            }
            this.a.setData(strN1);
            PatternsHiddenActivity patternsHiddenActivity = PatternsHiddenActivity.this;
            final Pattern pattern = this.a;
            patternsHiddenActivity.runOnUiThread(new Runnable() { // from class: dc.mb3
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.f(pattern);
                }
            });
            HashMap map = new HashMap();
            map.put(TtmlNode.ATTR_ID, this.a.getId());
            map.put("platform", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
            tn2.x(WearUtils.x).l("/wear/pattern/play", map, null);
            WearUtils.x.q("pattern_cloud_play", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C4(String str) {
        try {
            sg3.l(str);
            SwipyRefreshLayout swipyRefreshLayout = this.mSwipeRefreshPattern;
            int i = 0;
            if (swipyRefreshLayout != null) {
                swipyRefreshLayout.setRefreshing(false);
            }
            this.mSwipeRefreshPattern.setVisibility(this.c.size() == 0 ? 8 : 0);
            this.mRecyclerView.setVisibility(this.c.size() == 0 ? 8 : 0);
            RelativeLayout relativeLayout = this.mllEmpty;
            if (this.c.size() != 0) {
                i = 8;
            }
            relativeLayout.setVisibility(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y4(SwipyRefreshLayoutDirection swipyRefreshLayoutDirection) {
        if (swipyRefreshLayoutDirection != SwipyRefreshLayoutDirection.TOP) {
            D4(true);
        } else {
            this.f = false;
            D4(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A4(View view) {
        ArrayList<Pattern> arrayList;
        if (hf3.d(this) && (arrayList = this.c) != null && arrayList.size() == 0) {
            D4(false);
        }
    }

    @Override // dc.hv1
    public void A3(Pattern pattern, int i) {
        View viewFindViewByPosition;
        F4();
        this.d = null;
        if (pattern.getPatternStoreTag() != null && pattern.getPatternStoreTag().endsWith("Hidden") && this.c.contains(pattern)) {
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                if (this.c.get(i2).getPatternStoreTag().equals(pattern.getPatternStoreTag()) && (viewFindViewByPosition = this.e.findViewByPosition(i2)) != null) {
                    this.d = (PatternsHiddenAdapter.PatternViewHolder) this.mRecyclerView.getChildViewHolder(viewFindViewByPosition);
                }
            }
        }
    }

    @Override // dc.hv1
    public void B3(String str) {
    }

    @Override // com.wear.adapter.patterns.PatternsHiddenAdapter.f
    public void C0(PatternsHiddenAdapter.PatternViewHolder patternViewHolder, Pattern pattern) {
        PatternPlayManagerImpl.O().G(this);
        MusicControl.h0().S();
        if (PatternPlayManagerImpl.O().f0(pattern) > 0) {
            PatternPlayManagerImpl.O().E0();
            WearUtils.x.q("pattern_cloud_play_duation", null);
            h12.D.isPlayPatternOnHomePattern = false;
            return;
        }
        String path = pattern.getPath();
        if (pattern.getData() != null && pattern.getData().contains("result")) {
            PatternPlayManagerImpl.O().U0();
            sg3.i(this, R.string.file_notfound);
            return;
        }
        h12.D.isPlayPatternOnHomePattern = true;
        if (MusicControl.h0().O()) {
            EventBus.getDefault().post(h12.D);
        }
        if (WearUtils.e1(pattern.getData())) {
            WearUtils.E0(true, path, new c(pattern));
        } else {
            PatternPlayManagerImpl.O().X(this.c, 1);
            PatternPlayManagerImpl.O().G0(pattern);
        }
        patternViewHolder.patternSingleTitle.setVisibility(0);
    }

    @Override // dc.hv1
    public void D2(Pattern pattern, int i) {
        PatternsHiddenAdapter.PatternViewHolder patternViewHolder = this.d;
        if (patternViewHolder != null) {
            if (i == 0) {
                F4();
                this.d = null;
            } else {
                patternViewHolder.patternPlay.setImageResource(R.drawable.home_pattern_pause);
                this.d.patternPlayCurve.b();
            }
        }
    }

    public void D4(boolean z) {
        if (this.f) {
            this.mSwipeRefreshPattern.setRefreshing(false);
            return;
        }
        HashMap map = new HashMap();
        this.mSwipeRefreshPattern.setRefreshing(true);
        this.a.h(false, map);
    }

    public void E4(Pattern pattern) {
        String id = pattern.getId();
        Bundle bundle = new Bundle();
        bundle.putString(TtmlNode.ATTR_ID, id);
        bundle.putString("hidePatternId", pattern.getHidePatternId());
        pj3.g(this, ReportReasonActivity.class, bundle);
    }

    public final void F4() {
        PatternsHiddenAdapter.PatternViewHolder patternViewHolder = this.d;
        if (patternViewHolder != null) {
            Pattern pattern = patternViewHolder.b;
            if (pattern != null) {
                if (!WearUtils.e1(pattern.getData())) {
                    if (this.d.b.getHead() == null) {
                        PatternsHiddenAdapter.PatternViewHolder patternViewHolder2 = this.d;
                        patternViewHolder2.patternPlayCurve.setInitData(null, patternViewHolder2.b.getData().split(","), true);
                    } else {
                        PatternsHiddenAdapter.PatternViewHolder patternViewHolder3 = this.d;
                        patternViewHolder3.patternPlayCurve.setInitData(patternViewHolder3.b.getHead(), this.d.b.getData().split(";"), false);
                    }
                }
                if ((WearUtils.e1(this.d.b.getIsShowReview()) || !this.d.b.getIsShowReview().equals("1")) && (WearUtils.e1(this.d.b.getStatus()) || !this.d.b.getStatus().equals(AppMeasurementSdk.ConditionalUserProperty.ACTIVE))) {
                    this.d.iv_under_preview.setVisibility(8);
                    PatternsHiddenAdapter.PatternViewHolder patternViewHolder4 = this.d;
                    patternViewHolder4.patternSingleTitle.setText(TextUtils.isEmpty(patternViewHolder4.b.getName()) ? "" : this.d.b.getName());
                } else {
                    this.d.iv_under_preview.setVisibility(0);
                    this.d.patternSingleTitle.setText(R.string.patterns_under_review);
                }
                PatternsHiddenAdapter.PatternViewHolder patternViewHolder5 = this.d;
                patternViewHolder5.patternTimes.setText(patternViewHolder5.b.getTimer());
            }
            this.d.patternPlay.setImageResource(R.drawable.home_pattern_play);
        }
    }

    public final void G4(Pattern pattern, int i) {
        if (WearUtils.e1(pattern.getData())) {
            WearUtils.E0(false, pattern.getCdnPath(), new a(pattern, i));
        }
    }

    public void H4(Pattern pattern) {
        HashMap map = new HashMap();
        map.put(TtmlNode.ATTR_ID, pattern.getHidePatternId());
        this.mSwipeRefreshPattern.setRefreshing(true);
        this.a.i(false, map, pattern.getId());
    }

    @Override // dc.jp2
    public void L2(boolean z, PatternHiddenShowSuccBean patternHiddenShowSuccBean) {
        v4(patternHiddenShowSuccBean.getData().getPatternId());
    }

    @Override // dc.hv1
    public void O2(int i, Pattern pattern, String[] strArr) {
        PatternsHiddenAdapter.PatternViewHolder patternViewHolder = this.d;
        if (patternViewHolder != null) {
            patternViewHolder.patternPlayCurve.a(i, pattern, strArr);
        }
    }

    @Override // dc.jp2
    public void P3(boolean z, List<Pattern> list) {
        if (list != null) {
            this.c.clear();
            for (Pattern pattern : list) {
                pattern.setPatternStoreTag(pattern.getId() + "#Hidden");
                this.c.add(pattern);
                G4(pattern, list.size());
            }
            this.f = list.size() < 50;
            notifyDataSetChanged();
        }
    }

    @Override // dc.hv1
    public void T3(String str, int i, String str2) {
        View viewFindViewByPosition;
        PatternsHiddenAdapter.PatternViewHolder patternViewHolder = this.d;
        if (patternViewHolder != null) {
            if (patternViewHolder.b.getPatternStoreTag().equals(str2)) {
                this.d.patternPlayCurve.setBothLinePoint(str);
            }
        } else if (i == 1 && str2 != null && str2.endsWith("Hidden")) {
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                if (this.c.get(i2).getPatternStoreTag().equals(str2) && (viewFindViewByPosition = this.e.findViewByPosition(i2)) != null) {
                    PatternsHiddenAdapter.PatternViewHolder patternViewHolder2 = (PatternsHiddenAdapter.PatternViewHolder) this.mRecyclerView.getChildViewHolder(viewFindViewByPosition);
                    this.d = patternViewHolder2;
                    patternViewHolder2.patternPlay.setImageResource(R.drawable.home_pattern_pause);
                    this.d.patternPlayCurve.setBothLinePoint(str);
                }
            }
        }
    }

    @Override // dc.hv1
    public void V1(boolean z, int i) {
        if (i == 0) {
            F4();
            this.d = null;
            return;
        }
        PatternsHiddenAdapter.PatternViewHolder patternViewHolder = this.d;
        if (patternViewHolder != null) {
            if (z) {
                patternViewHolder.patternPlay.setImageResource(R.drawable.home_pattern_play);
            } else {
                patternViewHolder.patternPlay.setImageResource(R.drawable.home_pattern_pause);
            }
        }
    }

    @Override // dc.hv1
    public void X3(String str, int i, int i2, String str2) {
        PatternsHiddenAdapter.PatternViewHolder patternViewHolder = this.d;
        if (patternViewHolder == null || !patternViewHolder.b.getPatternStoreTag().equals(str2)) {
            return;
        }
        this.d.patternTimes.setText(str);
    }

    @Override // com.wear.adapter.patterns.PatternsHiddenAdapter.f
    public void g(Pattern pattern) {
        H4(pattern);
    }

    @Override // dc.tz1
    public int getPriority() {
        return 4;
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        this.mActivityComponent.g(this);
        this.mPresenter = this.a;
    }

    @Override // com.wear.adapter.patterns.PatternsHiddenAdapter.f
    public void k(Pattern pattern) {
        E4(pattern);
    }

    public final void notifyDataSetChanged() {
        runOnUiThread(new b());
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_patterns_hidden);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        w4();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(ReportSuccEvent reportSuccEvent) {
        if (!reportSuccEvent.getIsHidePattern()) {
            v4(reportSuccEvent.getPatternId());
            return;
        }
        if (this.c == null || this.b == null || this.mRecyclerView == null) {
            return;
        }
        for (int i = 0; i < this.c.size(); i++) {
            if (this.c.get(i).getId().equals(reportSuccEvent.getPatternId())) {
                this.c.get(i).setIsShowReview(reportSuccEvent.getIsShowReview());
                this.c.get(i).setStatus(reportSuccEvent.getStatus());
                this.b.notifyItemChanged(i);
                return;
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(PatternDownloadEvent patternDownloadEvent) {
        if (this.c == null || this.b == null || this.mRecyclerView == null) {
            return;
        }
        for (int i = 0; i < this.c.size(); i++) {
            if (this.c.get(i).getId().equals(patternDownloadEvent.getPatternId())) {
                this.c.get(i).setLikeCount(this.c.get(i).getLikeCount() + 1);
                this.b.notifyItemChanged(i, Pattern.DOWNLOAD);
                return;
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        PatternPlayManagerImpl.O().G(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        PatternPlayManagerImpl.O().N0(this);
        PatternsHiddenAdapter.PatternViewHolder patternViewHolder = this.d;
        if (patternViewHolder != null) {
            Pattern pattern = patternViewHolder.b;
            if (pattern != null) {
                if (!WearUtils.e1(pattern.getData())) {
                    if (this.d.b.getHead() == null) {
                        PatternsHiddenAdapter.PatternViewHolder patternViewHolder2 = this.d;
                        patternViewHolder2.patternPlayCurve.setInitData(null, patternViewHolder2.b.getData().split(","), true);
                    } else {
                        PatternsHiddenAdapter.PatternViewHolder patternViewHolder3 = this.d;
                        patternViewHolder3.patternPlayCurve.setInitData(patternViewHolder3.b.getHead(), this.d.b.getData().split(";"), false);
                    }
                }
                PatternsHiddenAdapter.PatternViewHolder patternViewHolder4 = this.d;
                patternViewHolder4.patternSingleTitle.setText(patternViewHolder4.b.getName());
                PatternsHiddenAdapter.PatternViewHolder patternViewHolder5 = this.d;
                patternViewHolder5.patternTimes.setText(patternViewHolder5.b.getTimer());
            }
            this.d.patternPlay.setImageResource(R.drawable.home_pattern_play);
            this.d = null;
        }
    }

    @Override // dc.tz1
    public void pauseConnon(int i) {
    }

    @Override // dc.tz1
    public void recovery() {
    }

    @Override // com.wear.BaseActivity, dc.ul2
    public void showErrorMsg(final String str, boolean z) {
        runOnUiThread(new Runnable() { // from class: dc.ob3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.C4(str);
            }
        });
    }

    @Override // dc.tz1
    public void stop(int i) {
        PatternPlayManagerImpl.O().U0();
    }

    @Override // dc.hv1
    public void u3(boolean z) {
        PatternsHiddenAdapter.PatternViewHolder patternViewHolder = this.d;
        if (patternViewHolder != null) {
            patternViewHolder.patternPlayCurve.setShowBothLine(z);
        }
    }

    public final void v4(String str) {
        Integer num;
        Pattern pattern;
        int i = 0;
        while (true) {
            num = null;
            if (i >= this.c.size()) {
                pattern = null;
                break;
            }
            if (str.equals(this.c.get(i).getId())) {
                Pattern pattern2 = this.c.get(i);
                Integer numValueOf = Integer.valueOf(i);
                ArrayList<Pattern> arrayList = this.c;
                arrayList.remove(arrayList.get(i));
                notifyDataSetChanged();
                num = numValueOf;
                pattern = pattern2;
                break;
            }
            i++;
        }
        PatternPlayManagerImpl.O().K(this.c, num, pattern);
    }

    public final void w4() {
        ArrayList<Pattern> arrayList = new ArrayList<>();
        this.c = arrayList;
        PatternsHiddenAdapter patternsHiddenAdapter = new PatternsHiddenAdapter(arrayList, this);
        this.b = patternsHiddenAdapter;
        patternsHiddenAdapter.P(this);
        this.e = cg3.f(this.mRecyclerView, this.b);
        this.mSwipeRefreshPattern.setColorSchemeResources(R.color.color_accent_second, R.color.pink, R.color.pink_stroke, R.color.color_accent);
        this.mSwipeRefreshPattern.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() { // from class: dc.qb3
            @Override // com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout.OnRefreshListener
            public final void onRefresh(SwipyRefreshLayoutDirection swipyRefreshLayoutDirection) {
                this.a.y4(swipyRefreshLayoutDirection);
            }
        });
        this.mllEmpty.setOnClickListener(new View.OnClickListener() { // from class: dc.pb3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.A4(view);
            }
        });
        D4(false);
    }

    @Override // dc.hv1
    public void z1() {
        F4();
    }

    @Override // dc.hv1
    public void z3(float f) {
        PatternsHiddenAdapter.PatternViewHolder patternViewHolder = this.d;
        if (patternViewHolder != null) {
            patternViewHolder.patternPlayCurve.setFirstLinePoint(f);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(PatternFavoriteChangeEvent patternFavoriteChangeEvent) {
        int i = 0;
        if (patternFavoriteChangeEvent.isStart()) {
            while (i < this.c.size()) {
                if (this.c.get(i).getId().equals(patternFavoriteChangeEvent.getPatternId())) {
                    this.b.notifyItemChanged(i);
                    return;
                }
                i++;
            }
            return;
        }
        if (patternFavoriteChangeEvent.isFail()) {
            while (i < this.c.size()) {
                if (this.c.get(i).getId().equals(patternFavoriteChangeEvent.getPatternId())) {
                    this.b.notifyItemChanged(i);
                    return;
                }
                i++;
            }
            return;
        }
        if (this.c == null || this.b == null || this.mRecyclerView == null) {
            return;
        }
        while (i < this.c.size()) {
            if (this.c.get(i).getId().equals(patternFavoriteChangeEvent.getPatternId())) {
                this.c.get(i).setFavorite(patternFavoriteChangeEvent.getIsFavorite());
                if (patternFavoriteChangeEvent.getIsFavorite()) {
                    this.c.get(i).setFavoritesCount(this.c.get(i).getFavoritesCount() + 1);
                } else {
                    this.c.get(i).setFavoritesCount(this.c.get(i).getFavoritesCount() - 1);
                }
                this.b.notifyItemChanged(i, "like");
                return;
            }
            i++;
        }
    }
}
