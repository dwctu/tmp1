package com.wear.ui.discover.pattern;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.patterns.UserPatternAdapter;
import com.wear.bean.Pattern;
import com.wear.bean.PatternHiddenSuccDataBean;
import com.wear.bean.event.PatternDownloadEvent;
import com.wear.bean.event.PatternFavoriteChangeEvent;
import com.wear.bean.event.ReportSuccEvent;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.ui.home.pattern.control.PatternPlayManagerImpl;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.an2;
import dc.cg3;
import dc.cs3;
import dc.ff3;
import dc.h12;
import dc.hp2;
import dc.hv1;
import dc.is3;
import dc.ke3;
import dc.pj3;
import dc.rf3;
import dc.sg3;
import dc.tn2;
import dc.tz1;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class PatternUserActivity extends BaseActivity implements hp2, UserPatternAdapter.f, tz1, hv1 {
    public an2 a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public String b;
    public List<Pattern> c;
    public UserPatternAdapter d;
    public UserPatternAdapter.PatternViewHolder e;
    public String f = "UserPattern";
    public LinearLayoutManager g;

    @BindView(R.id.recyclerView)
    public RecyclerView recyclerView;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PatternUserActivity.this.d.notifyDataSetChanged();
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ PatternHiddenSuccDataBean a;

        public b(PatternHiddenSuccDataBean patternHiddenSuccDataBean) {
            this.a = patternHiddenSuccDataBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            PatternUserActivity.this.x4(this.a.getPatternId());
        }
    }

    public class c extends ff3 {
        public final /* synthetic */ Pattern a;
        public final /* synthetic */ int b;

        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                int size = PatternUserActivity.this.c.size();
                c cVar = c.this;
                if (size < cVar.b) {
                    return;
                }
                for (int size2 = PatternUserActivity.this.c.size() - 1; size2 >= 0; size2--) {
                    if (((Pattern) PatternUserActivity.this.c.get(size2)).getId().equals(this.a)) {
                        RecyclerView recyclerView = PatternUserActivity.this.recyclerView;
                        if (recyclerView == null || recyclerView.getAdapter() == null) {
                            return;
                        }
                        if (PatternUserActivity.this.recyclerView.getAdapter().getItemCount() > size2) {
                            PatternUserActivity.this.d.notifyItemChanged(size2, "getServerFile");
                            return;
                        } else {
                            PatternUserActivity.this.d.notifyDataSetChanged();
                            return;
                        }
                    }
                }
            }
        }

        public c(Pattern pattern, int i) {
            this.a = pattern;
            this.b = i;
        }

        @Override // dc.ff3
        public void b(boolean z, Object obj) throws Throwable {
            if (z) {
                try {
                    this.a.setDataNoCheckFormat(WearUtils.N1(((File) obj).getPath()));
                    PatternUserActivity.this.runOnUiThread(new a(this.a.getId()));
                } catch (Exception unused) {
                    PatternUserActivity.this.notifyDataSetChanged();
                }
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = PatternUserActivity.this.recyclerView;
            if (recyclerView == null || recyclerView.getAdapter() == null) {
                return;
            }
            PatternUserActivity.this.d.notifyDataSetChanged();
        }
    }

    public class e extends ff3 {
        public final /* synthetic */ Pattern a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PatternPlayManagerImpl.O().X(PatternUserActivity.this.c, 1);
                PatternPlayManagerImpl.O().G0(e.this.a);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PatternPlayManagerImpl.O().U0();
                sg3.i(PatternUserActivity.this, R.string.file_notfound);
            }
        }

        public e(Pattern pattern) {
            this.a = pattern;
        }

        @Override // dc.ff3
        public void b(boolean z, Object obj) throws Throwable {
            if (!z) {
                PatternUserActivity.this.runOnUiThread(new b());
                return;
            }
            String strN1 = WearUtils.N1(((File) obj).getPath());
            if (rf3.o(strN1)) {
                strN1 = rf3.r(strN1);
                WearUtils.m2(strN1, this.a.getId());
            }
            this.a.setData(strN1);
            PatternUserActivity.this.runOnUiThread(new a());
            HashMap map = new HashMap();
            map.put(TtmlNode.ATTR_ID, this.a.getId());
            map.put("platform", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
            tn2.x(WearUtils.x).l("/wear/pattern/play", map, null);
            WearUtils.x.q("pattern_cloud_play", null);
        }
    }

    @Override // dc.hv1
    public void A3(Pattern pattern, int i) {
        View viewFindViewByPosition;
        B4();
        this.e = null;
        if (pattern.getPatternStoreTag() != null && pattern.getPatternStoreTag().endsWith(this.f) && this.c.contains(pattern)) {
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                if (this.c.get(i2).getPatternStoreTag().equals(pattern.getPatternStoreTag()) && (viewFindViewByPosition = this.g.findViewByPosition(i2)) != null) {
                    this.e = (UserPatternAdapter.PatternViewHolder) this.recyclerView.getChildViewHolder(viewFindViewByPosition);
                }
            }
        }
    }

    public void A4(Pattern pattern) {
        String id = pattern.getId();
        Bundle bundle = new Bundle();
        bundle.putString(TtmlNode.ATTR_ID, id);
        pj3.g(this, ReportReasonActivity.class, bundle);
    }

    @Override // dc.hp2
    public void B0(boolean z, List<Pattern> list) {
    }

    @Override // dc.hv1
    public void B3(String str) {
    }

    public final void B4() {
        UserPatternAdapter.PatternViewHolder patternViewHolder = this.e;
        if (patternViewHolder != null) {
            Pattern pattern = patternViewHolder.b;
            if (pattern != null) {
                if (!WearUtils.e1(pattern.getData())) {
                    if (this.e.b.getHead() == null) {
                        UserPatternAdapter.PatternViewHolder patternViewHolder2 = this.e;
                        patternViewHolder2.patternPlayCurve.setInitData(null, patternViewHolder2.b.getData().split(","), true);
                    } else {
                        UserPatternAdapter.PatternViewHolder patternViewHolder3 = this.e;
                        patternViewHolder3.patternPlayCurve.setInitData(patternViewHolder3.b.getHead(), this.e.b.getData().split(";"), false);
                    }
                }
                if ((WearUtils.e1(this.e.b.getIsShowReview()) || !this.e.b.getIsShowReview().equals("1")) && (WearUtils.e1(this.e.b.getStatus()) || !this.e.b.getStatus().equals(AppMeasurementSdk.ConditionalUserProperty.ACTIVE))) {
                    this.e.iv_under_preview.setVisibility(8);
                    UserPatternAdapter.PatternViewHolder patternViewHolder4 = this.e;
                    patternViewHolder4.patternSingleTitle.setText(TextUtils.isEmpty(patternViewHolder4.b.getName()) ? "" : this.e.b.getName());
                } else {
                    this.e.iv_under_preview.setVisibility(0);
                    this.e.patternSingleTitle.setText(R.string.patterns_under_review);
                }
                UserPatternAdapter.PatternViewHolder patternViewHolder5 = this.e;
                patternViewHolder5.patternSingleTitle.setText(patternViewHolder5.b.getName());
                UserPatternAdapter.PatternViewHolder patternViewHolder6 = this.e;
                patternViewHolder6.patternTimes.setText(patternViewHolder6.b.getTimer());
            }
            this.e.patternPlay.setImageResource(R.drawable.home_pattern_play);
        }
    }

    public final void C4(Pattern pattern, int i) {
        if (WearUtils.e1(pattern.getData())) {
            WearUtils.E0(false, pattern.getCdnPath(), new c(pattern, i));
        }
    }

    @Override // dc.hv1
    public void D2(Pattern pattern, int i) {
        UserPatternAdapter.PatternViewHolder patternViewHolder = this.e;
        if (patternViewHolder != null) {
            if (i == 0) {
                B4();
                this.e = null;
            } else {
                patternViewHolder.patternPlay.setImageResource(R.drawable.home_pattern_pause);
                this.e.patternPlayCurve.b();
            }
        }
    }

    @Override // dc.hp2
    public void N3(boolean z, List<String> list) {
    }

    @Override // dc.hv1
    public void O2(int i, Pattern pattern, String[] strArr) {
        UserPatternAdapter.PatternViewHolder patternViewHolder = this.e;
        if (patternViewHolder != null) {
            patternViewHolder.patternPlayCurve.a(i, pattern, strArr);
        }
    }

    @Override // dc.hv1
    public void T3(String str, int i, String str2) {
        View viewFindViewByPosition;
        UserPatternAdapter.PatternViewHolder patternViewHolder = this.e;
        if (patternViewHolder != null) {
            if (patternViewHolder.b.getPatternStoreTag().equals(str2)) {
                this.e.patternPlayCurve.setBothLinePoint(str);
            }
        } else if (i == 1 && str2 != null && str2.endsWith(this.f)) {
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                if (this.c.get(i2).getPatternStoreTag().equals(str2) && (viewFindViewByPosition = this.g.findViewByPosition(i2)) != null) {
                    UserPatternAdapter.PatternViewHolder patternViewHolder2 = (UserPatternAdapter.PatternViewHolder) this.recyclerView.getChildViewHolder(viewFindViewByPosition);
                    this.e = patternViewHolder2;
                    patternViewHolder2.patternPlay.setImageResource(R.drawable.home_pattern_pause);
                    this.e.patternPlayCurve.setBothLinePoint(str);
                }
            }
        }
    }

    @Override // dc.hv1
    public void V1(boolean z, int i) {
        if (i == 0) {
            B4();
            this.e = null;
            return;
        }
        UserPatternAdapter.PatternViewHolder patternViewHolder = this.e;
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
        UserPatternAdapter.PatternViewHolder patternViewHolder = this.e;
        if (patternViewHolder == null || !patternViewHolder.b.getPatternStoreTag().equals(str2)) {
            return;
        }
        this.e.patternTimes.setText(str);
    }

    @Override // com.wear.adapter.patterns.UserPatternAdapter.f
    public void g(Pattern pattern) {
        w4(pattern);
    }

    @Override // dc.tz1
    public int getPriority() {
        return 4;
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        this.mActivityComponent.p(this);
        this.mPresenter = this.a;
    }

    @Override // com.wear.adapter.patterns.UserPatternAdapter.f
    public void k(Pattern pattern) {
        A4(pattern);
    }

    @Override // dc.hp2
    public void k3(boolean z, PatternHiddenSuccDataBean patternHiddenSuccDataBean) {
        runOnUiThread(new b(patternHiddenSuccDataBean));
    }

    public final void notifyDataSetChanged() {
        runOnUiThread(new d());
    }

    @Override // dc.hp2
    public void o1(boolean z, List<Pattern> list) {
        if (list != null) {
            this.c.clear();
            for (Pattern pattern : list) {
                pattern.setPatternStoreTag(pattern.getId() + "#" + this.f);
                this.c.add(pattern);
            }
            Iterator<Pattern> it = list.iterator();
            while (it.hasNext()) {
                C4(it.next(), list.size());
            }
            runOnMainThread(new a());
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.discover_pattern_user_activity);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        y4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(ReportSuccEvent reportSuccEvent) {
        if (reportSuccEvent == null || WearUtils.e1(reportSuccEvent.getPatternId())) {
            return;
        }
        if (reportSuccEvent.getIsHidePattern()) {
            x4(reportSuccEvent.getPatternId());
            return;
        }
        if (this.c == null || this.d == null || this.recyclerView == null) {
            return;
        }
        for (int i = 0; i < this.c.size(); i++) {
            if (this.c.get(i).getId().equals(reportSuccEvent.getPatternId())) {
                this.c.get(i).setIsShowReview(reportSuccEvent.getIsShowReview());
                this.c.get(i).setStatus(reportSuccEvent.getStatus());
                this.d.notifyItemChanged(i);
                return;
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(PatternFavoriteChangeEvent patternFavoriteChangeEvent) {
        int i = 0;
        if (patternFavoriteChangeEvent.isStart()) {
            while (i < this.c.size()) {
                if (this.c.get(i).getId().equals(patternFavoriteChangeEvent.getPatternId())) {
                    this.d.notifyItemChanged(i);
                    return;
                }
                i++;
            }
            return;
        }
        if (patternFavoriteChangeEvent.isFail()) {
            while (i < this.c.size()) {
                if (this.c.get(i).getId().equals(patternFavoriteChangeEvent.getPatternId())) {
                    this.d.notifyItemChanged(i);
                    return;
                }
                i++;
            }
            return;
        }
        if (this.c == null || this.d == null || this.recyclerView == null) {
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
                this.d.notifyItemChanged(i, "like");
                return;
            }
            i++;
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
        UserPatternAdapter.PatternViewHolder patternViewHolder = this.e;
        if (patternViewHolder != null) {
            Pattern pattern = patternViewHolder.b;
            if (pattern != null) {
                if (!WearUtils.e1(pattern.getData())) {
                    if (this.e.b.getHead() == null) {
                        UserPatternAdapter.PatternViewHolder patternViewHolder2 = this.e;
                        patternViewHolder2.patternPlayCurve.setInitData(null, patternViewHolder2.b.getData().split(","), true);
                    } else {
                        UserPatternAdapter.PatternViewHolder patternViewHolder3 = this.e;
                        patternViewHolder3.patternPlayCurve.setInitData(patternViewHolder3.b.getHead(), this.e.b.getData().split(";"), false);
                    }
                }
                UserPatternAdapter.PatternViewHolder patternViewHolder4 = this.e;
                patternViewHolder4.patternSingleTitle.setText(patternViewHolder4.b.getName());
                UserPatternAdapter.PatternViewHolder patternViewHolder5 = this.e;
                patternViewHolder5.patternTimes.setText(patternViewHolder5.b.getTimer());
            }
            this.e.patternPlay.setImageResource(R.drawable.home_pattern_play);
            this.e = null;
        }
    }

    @Override // dc.tz1
    public void pauseConnon(int i) {
    }

    @Override // dc.tz1
    public void recovery() {
    }

    @Override // dc.tz1
    public void stop(int i) {
        PatternPlayManagerImpl.O().U0();
    }

    @Override // dc.hv1
    public void u3(boolean z) {
        UserPatternAdapter.PatternViewHolder patternViewHolder = this.e;
        if (patternViewHolder != null) {
            patternViewHolder.patternPlayCurve.setShowBothLine(z);
        }
    }

    public void w4(Pattern pattern) {
        HashMap map = new HashMap();
        map.put(TtmlNode.ATTR_ID, pattern.getId());
        this.a.h(false, map);
    }

    public final void x4(String str) {
        Integer num;
        Pattern pattern;
        int i = 0;
        if (ke3.a("new_user", "pattern_hidden_key")) {
            is3.b bVar = new is3.b(this);
            bVar.o(ah4.e(R.string.common_ok));
            bVar.p(getString(R.string.notification_to_unhide_pattern));
            bVar.k(R.layout.dialog_first_hidden);
            bVar.m(false);
            cs3.h(bVar).show();
        }
        while (true) {
            num = null;
            if (i >= this.c.size()) {
                pattern = null;
                break;
            }
            if (str.equals(this.c.get(i).getId())) {
                Pattern pattern2 = this.c.get(i);
                Integer numValueOf = Integer.valueOf(i);
                List<Pattern> list = this.c;
                list.remove(list.get(i));
                notifyDataSetChanged();
                num = numValueOf;
                pattern = pattern2;
                break;
            }
            i++;
        }
        PatternPlayManagerImpl.O().K(this.c, num, pattern);
    }

    @Override // com.wear.adapter.patterns.UserPatternAdapter.f
    public void y0(UserPatternAdapter.PatternViewHolder patternViewHolder, Pattern pattern) {
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
            WearUtils.E0(true, path, new e(pattern));
        } else {
            PatternPlayManagerImpl.O().X(this.c, 1);
            PatternPlayManagerImpl.O().G0(pattern);
        }
        patternViewHolder.patternSingleTitle.setVisibility(0);
    }

    public final void y4() {
        String string = getIntent().getExtras().getString("userName");
        this.b = string;
        this.actionbar.setTitle(string);
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        UserPatternAdapter userPatternAdapter = new UserPatternAdapter(arrayList, this);
        this.d = userPatternAdapter;
        userPatternAdapter.P(this);
        this.g = cg3.f(this.recyclerView, this.d);
        z4();
    }

    @Override // dc.hv1
    public void z1() {
        B4();
    }

    @Override // dc.hv1
    public void z3(float f) {
        UserPatternAdapter.PatternViewHolder patternViewHolder = this.e;
        if (patternViewHolder != null) {
            patternViewHolder.patternPlayCurve.setFirstLinePoint(f);
        }
    }

    public final void z4() {
        HashMap map = new HashMap();
        map.put("keyword", this.b);
        this.a.j(false, map);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(PatternDownloadEvent patternDownloadEvent) {
        if (this.c == null || this.d == null || this.recyclerView == null) {
            return;
        }
        for (int i = 0; i < this.c.size(); i++) {
            if (this.c.get(i).getId().equals(patternDownloadEvent.getPatternId())) {
                this.c.get(i).setLikeCount(this.c.get(i).getLikeCount() + 1);
                this.d.notifyItemChanged(i, Pattern.DOWNLOAD);
                return;
            }
        }
    }
}
