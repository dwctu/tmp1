package com.wear.ui.discover.pattern;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.patterns.PatternSearchAdapter;
import com.wear.adapter.patterns.PatternViewHolder;
import com.wear.bean.Pattern;
import com.wear.bean.PatternHiddenSuccDataBean;
import com.wear.bean.event.PatternDownloadEvent;
import com.wear.bean.event.PatternFavoriteChangeEvent;
import com.wear.bean.event.ReportSuccEvent;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.toy.AddVirtualToyActivity;
import com.wear.ui.home.pattern.control.PatternPlayManagerImpl;
import com.wear.util.WearUtils;
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
import dc.nv1;
import dc.pj3;
import dc.rf3;
import dc.sg3;
import dc.tn2;
import dc.tz1;
import dc.ue3;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class PatternSearchActivity extends BaseActivity implements PatternSearchAdapter.f, hp2, tz1, hv1 {
    public an2 a;
    public String b;
    public boolean c;
    public PatternSearchAdapter d;
    public List e;

    @BindView(R.id.et_search)
    public EditText et_search;
    public ArrayList<String> f;
    public ArrayList<Pattern> g;
    public PatternViewHolder h;
    public String i = "Search";

    @BindView(R.id.iv_delete)
    public ImageView iv_delete;
    public LinearLayoutManager j;

    @BindView(R.id.recyclerView)
    public RecyclerView recyclerView;

    @BindView(R.id.tv_no_result)
    public TextView tv_no_result;

    public class a implements View.OnKeyListener {
        public a() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 66 && keyEvent.getAction() == 1) {
                PatternSearchActivity patternSearchActivity = PatternSearchActivity.this;
                patternSearchActivity.b = patternSearchActivity.et_search.getText().toString().trim();
                if (PatternSearchActivity.this.b.equals("test_active_virtual_toy_fs3r323")) {
                    WearUtils.C = true;
                    sg3.l("开发者模式启动.");
                    pj3.f(PatternSearchActivity.this, AddVirtualToyActivity.class);
                    return false;
                }
                PatternSearchActivity patternSearchActivity2 = PatternSearchActivity.this;
                ue3.a(patternSearchActivity2.et_search, patternSearchActivity2);
                PatternSearchActivity.this.H4();
            }
            return false;
        }
    }

    public class b extends nv1 {
        public b() {
        }

        @Override // dc.nv1, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            PatternSearchActivity.this.iv_delete.setVisibility(TextUtils.isEmpty(editable) ? 8 : 0);
            PatternSearchActivity.this.G4();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PatternSearchActivity.this.dissDialog();
            PatternSearchActivity.this.I4(true);
            PatternSearchActivity.this.d.Q(PatternSearchActivity.this.b);
            PatternSearchActivity.this.d.notifyDataSetChanged();
            if (PatternSearchActivity.this.e.isEmpty()) {
                return;
            }
            String str = "run: pattern 数量=" + PatternSearchActivity.this.e.size();
            PatternSearchActivity.this.recyclerView.scrollToPosition(0);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PatternSearchActivity.this.dissDialog();
            PatternSearchActivity.this.I4(true);
            PatternSearchActivity.this.d.Q(PatternSearchActivity.this.b);
            PatternSearchActivity.this.d.notifyDataSetChanged();
            if (PatternSearchActivity.this.e.isEmpty()) {
                return;
            }
            PatternSearchActivity.this.recyclerView.scrollToPosition(0);
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ PatternHiddenSuccDataBean a;

        public e(PatternHiddenSuccDataBean patternHiddenSuccDataBean) {
            this.a = patternHiddenSuccDataBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            PatternSearchActivity.this.D4(this.a.getPatternId());
        }
    }

    public class f extends ff3 {
        public final /* synthetic */ Pattern a;
        public final /* synthetic */ int b;

        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                int size = PatternSearchActivity.this.g.size();
                f fVar = f.this;
                if (size < fVar.b) {
                    return;
                }
                for (int size2 = PatternSearchActivity.this.g.size() - 1; size2 >= 0; size2--) {
                    if (((Pattern) PatternSearchActivity.this.g.get(size2)).getId().equals(this.a)) {
                        RecyclerView recyclerView = PatternSearchActivity.this.recyclerView;
                        if (recyclerView == null || recyclerView.getAdapter() == null) {
                            return;
                        }
                        if (PatternSearchActivity.this.recyclerView.getAdapter().getItemCount() > size2) {
                            PatternSearchActivity.this.d.notifyItemChanged(PatternSearchActivity.this.e.indexOf(PatternSearchActivity.this.g.get(size2)), "getServerFile");
                            return;
                        } else {
                            PatternSearchActivity.this.d.notifyDataSetChanged();
                            return;
                        }
                    }
                }
            }
        }

        public f(Pattern pattern, int i) {
            this.a = pattern;
            this.b = i;
        }

        @Override // dc.ff3
        public void b(boolean z, Object obj) throws Throwable {
            if (z) {
                try {
                    this.a.setDataNoCheckFormat(WearUtils.N1(((File) obj).getPath()));
                    PatternSearchActivity.this.runOnUiThread(new a(this.a.getId()));
                } catch (Exception unused) {
                    PatternSearchActivity.this.notifyDataSetChanged();
                }
            }
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = PatternSearchActivity.this.recyclerView;
            if (recyclerView == null || recyclerView.getAdapter() == null) {
                return;
            }
            PatternSearchActivity.this.d.notifyDataSetChanged();
        }
    }

    public class h extends ff3 {
        public final /* synthetic */ Pattern a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PatternPlayManagerImpl.O().X(PatternSearchActivity.this.g, 1);
                PatternPlayManagerImpl.O().G0(h.this.a);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PatternPlayManagerImpl.O().U0();
                sg3.i(PatternSearchActivity.this, R.string.file_notfound);
            }
        }

        public h(Pattern pattern) {
            this.a = pattern;
        }

        @Override // dc.ff3
        public void b(boolean z, Object obj) throws Throwable {
            if (!z) {
                PatternSearchActivity.this.runOnUiThread(new b());
                return;
            }
            String strN1 = WearUtils.N1(((File) obj).getPath());
            if (rf3.o(strN1)) {
                strN1 = rf3.r(strN1);
                WearUtils.m2(strN1, this.a.getId());
            }
            this.a.setData(strN1);
            PatternSearchActivity.this.runOnUiThread(new a());
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
        K4();
        this.h = null;
        if (pattern.getPatternStoreTag() != null && pattern.getPatternStoreTag().endsWith(this.i) && this.e.contains(pattern)) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                if ((this.e.get(i2) instanceof Pattern) && ((Pattern) this.e.get(i2)).getPatternStoreTag().equals(pattern.getPatternStoreTag()) && (viewFindViewByPosition = this.j.findViewByPosition(i2)) != null && (this.recyclerView.getChildViewHolder(viewFindViewByPosition) instanceof PatternViewHolder)) {
                    this.h = (PatternViewHolder) this.recyclerView.getChildViewHolder(viewFindViewByPosition);
                }
            }
        }
    }

    @Override // dc.hp2
    public void B0(boolean z, List<Pattern> list) {
        this.e.clear();
        if (!this.f.isEmpty()) {
            this.e.add(Integer.valueOf(this.f.size() <= 3 ? 1 : 3));
            if (this.f.size() <= 3 || list.isEmpty()) {
                this.e.addAll(this.f);
            } else {
                this.e.addAll(this.f.subList(0, 3));
            }
        }
        this.g.clear();
        if (list != null) {
            for (Pattern pattern : list) {
                pattern.setPatternStoreTag(pattern.getId() + "#" + this.i);
                this.g.add(pattern);
            }
            if (!list.isEmpty()) {
                this.e.add(2);
                this.e.addAll(list);
            }
        }
        Iterator<Pattern> it = list.iterator();
        while (it.hasNext()) {
            L4(it.next(), list.size());
        }
        runOnMainThread(new d());
    }

    @Override // dc.hv1
    public void B3(String str) {
    }

    public void C4(Pattern pattern) {
        HashMap map = new HashMap();
        map.put(TtmlNode.ATTR_ID, pattern.getId());
        this.a.h(false, map);
    }

    @Override // dc.hv1
    public void D2(Pattern pattern, int i) {
        PatternViewHolder patternViewHolder = this.h;
        if (patternViewHolder != null) {
            if (i == 0) {
                K4();
            } else {
                patternViewHolder.patternPlay.setImageResource(R.drawable.home_pattern_pause);
                this.h.patternPlayCurve.b();
            }
        }
    }

    public final void D4(String str) {
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
            if (i >= this.g.size()) {
                pattern = null;
                break;
            }
            if (str.equals(this.g.get(i).getId())) {
                Pattern pattern2 = this.g.get(i);
                Integer numValueOf = Integer.valueOf(i);
                this.e.remove(pattern2);
                this.g.remove(pattern2);
                notifyDataSetChanged();
                num = numValueOf;
                pattern = pattern2;
                break;
            }
            i++;
        }
        PatternPlayManagerImpl.O().K(this.g, num, pattern);
    }

    public final void E4() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f = extras.getStringArrayList("users");
            this.b = extras.getString("keyword");
            this.c = true;
        }
        if (!TextUtils.isEmpty(this.b)) {
            this.et_search.setText(this.b);
            this.iv_delete.setVisibility(0);
        }
        this.et_search.setHint(ah4.e(this.c ? R.string.signup_name_hint : R.string.patterns_search_hint));
        this.et_search.setOnKeyListener(new a());
        this.et_search.addTextChangedListener(new b());
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.g = new ArrayList<>();
        this.e = new ArrayList();
        if (!this.f.isEmpty()) {
            this.e.addAll(this.f);
        }
        this.d = new PatternSearchAdapter(this, this.e);
        if (!TextUtils.isEmpty(this.b)) {
            this.d.Q(this.b);
        }
        this.d.R(this);
        this.j = cg3.f(this.recyclerView, this.d);
        I4(false);
    }

    public boolean F4(View view, MotionEvent motionEvent) {
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return motionEvent.getX() <= ((float) i) || motionEvent.getX() >= ((float) (view.getWidth() + i)) || motionEvent.getY() <= ((float) i2) || motionEvent.getY() >= ((float) (view.getHeight() + i2));
    }

    public final void G4() {
        if (this.e.isEmpty()) {
            return;
        }
        this.f.clear();
        this.g.clear();
        this.e.clear();
        this.d.Q("");
        this.d.notifyDataSetChanged();
        I4(false);
    }

    public final void H4() {
        showDialog();
        HashMap map = new HashMap();
        map.put("keyword", this.b);
        this.a.i(false, map);
        this.et_search.clearFocus();
    }

    public final void I4(boolean z) {
        this.tv_no_result.setVisibility((this.e.isEmpty() && z) ? 0 : 8);
        this.recyclerView.setVisibility(this.e.isEmpty() ? 8 : 0);
    }

    public void J4(Pattern pattern) {
        String id = pattern.getId();
        Bundle bundle = new Bundle();
        bundle.putString(TtmlNode.ATTR_ID, id);
        pj3.g(this, ReportReasonActivity.class, bundle);
    }

    public final void K4() {
        PatternViewHolder patternViewHolder = this.h;
        if (patternViewHolder != null) {
            Pattern pattern = patternViewHolder.b;
            if (pattern != null) {
                if (!WearUtils.e1(pattern.getData())) {
                    if (this.h.b.getHead() == null) {
                        PatternViewHolder patternViewHolder2 = this.h;
                        patternViewHolder2.patternPlayCurve.setInitData(null, patternViewHolder2.b.getData().split(","), true);
                    } else {
                        PatternViewHolder patternViewHolder3 = this.h;
                        patternViewHolder3.patternPlayCurve.setInitData(patternViewHolder3.b.getHead(), this.h.b.getData().split(";"), false);
                    }
                }
                if ((WearUtils.e1(this.h.b.getIsShowReview()) || !this.h.b.getIsShowReview().equals("1")) && (WearUtils.e1(this.h.b.getStatus()) || !this.h.b.getStatus().equals(AppMeasurementSdk.ConditionalUserProperty.ACTIVE))) {
                    this.h.iv_under_preview.setVisibility(8);
                    PatternViewHolder patternViewHolder4 = this.h;
                    patternViewHolder4.patternSingleTitle.setText(TextUtils.isEmpty(patternViewHolder4.b.getName()) ? "" : this.h.b.getName());
                } else {
                    this.h.iv_under_preview.setVisibility(0);
                    this.h.patternSingleTitle.setText(R.string.patterns_under_review);
                }
                PatternViewHolder patternViewHolder5 = this.h;
                patternViewHolder5.patternTimes.setText(patternViewHolder5.b.getTimer());
            }
            this.h.patternPlay.setImageResource(R.drawable.home_pattern_play);
        }
    }

    public final void L4(Pattern pattern, int i) {
        if (WearUtils.e1(pattern.getData())) {
            WearUtils.E0(false, pattern.getCdnPath(), new f(pattern, i));
        }
    }

    @Override // dc.hp2
    public void N3(boolean z, List<String> list) {
        this.f.clear();
        if (list != null) {
            this.f.addAll(list);
        }
        if (!this.c) {
            HashMap map = new HashMap();
            map.put("keyword", this.b);
            this.a.k(false, map);
        } else {
            this.e.clear();
            if (!this.f.isEmpty()) {
                this.e.addAll(list);
            }
            runOnMainThread(new c());
        }
    }

    @Override // dc.hv1
    public void O2(int i, Pattern pattern, String[] strArr) {
        PatternViewHolder patternViewHolder = this.h;
        if (patternViewHolder != null) {
            patternViewHolder.patternPlayCurve.a(i, pattern, strArr);
        }
    }

    @Override // com.wear.adapter.patterns.PatternSearchAdapter.f
    public void S0(PatternViewHolder patternViewHolder, Pattern pattern) {
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
            WearUtils.E0(true, path, new h(pattern));
        } else {
            PatternPlayManagerImpl.O().X(this.g, 1);
            PatternPlayManagerImpl.O().G0(pattern);
        }
        patternViewHolder.patternSingleTitle.setVisibility(0);
    }

    @Override // dc.hv1
    public void T3(String str, int i, String str2) {
        View viewFindViewByPosition;
        PatternViewHolder patternViewHolder = this.h;
        if (patternViewHolder != null) {
            if (patternViewHolder.b.getPatternStoreTag().equals(str2)) {
                this.h.patternPlayCurve.setBothLinePoint(str);
                return;
            }
            return;
        }
        if (i == 1 && str2 != null && str2.endsWith(this.i)) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                if ((this.e.get(i2) instanceof Pattern) && ((Pattern) this.e.get(i2)).getPatternStoreTag().equals(str2) && (viewFindViewByPosition = this.j.findViewByPosition(i2)) != null && (this.recyclerView.getChildViewHolder(viewFindViewByPosition) instanceof PatternViewHolder)) {
                    PatternViewHolder patternViewHolder2 = (PatternViewHolder) this.recyclerView.getChildViewHolder(viewFindViewByPosition);
                    this.h = patternViewHolder2;
                    patternViewHolder2.patternPlay.setImageResource(R.drawable.home_pattern_pause);
                    this.h.patternPlayCurve.setBothLinePoint(str);
                }
            }
        }
    }

    @Override // dc.hv1
    public void V1(boolean z, int i) {
        if (i == 0) {
            K4();
            this.h = null;
            return;
        }
        PatternViewHolder patternViewHolder = this.h;
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
        PatternViewHolder patternViewHolder = this.h;
        if (patternViewHolder == null || !patternViewHolder.b.getPatternStoreTag().equals(str2)) {
            return;
        }
        this.h.patternTimes.setText(str);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return getWindow().superDispatchTouchEvent(motionEvent) || onTouchEvent(motionEvent);
        }
        if (F4(this.et_search, motionEvent) && ((InputMethodManager) getSystemService("input_method")) != null) {
            ue3.a(this.et_search, this);
            EditText editText = this.et_search;
            if (editText != null) {
                editText.clearFocus();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.wear.adapter.patterns.PatternSearchAdapter.f
    public void g(Pattern pattern) {
        C4(pattern);
    }

    @Override // dc.tz1
    public int getPriority() {
        return 4;
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        this.mActivityComponent.h(this);
        this.mPresenter = this.a;
    }

    @Override // com.wear.adapter.patterns.PatternSearchAdapter.f
    public void k(Pattern pattern) {
        J4(pattern);
    }

    @Override // dc.hp2
    public void k3(boolean z, PatternHiddenSuccDataBean patternHiddenSuccDataBean) {
        runOnUiThread(new e(patternHiddenSuccDataBean));
    }

    public final void notifyDataSetChanged() {
        runOnUiThread(new g());
    }

    @Override // dc.hp2
    public void o1(boolean z, List<Pattern> list) {
    }

    @OnClick({R.id.iv_delete, R.id.tv_cancel})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_delete) {
            this.et_search.setText("");
        } else {
            if (id != R.id.tv_cancel) {
                return;
            }
            finish();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.discover_pattern_search_activity);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        E4();
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
            D4(reportSuccEvent.getPatternId());
            return;
        }
        if (this.g == null || this.d == null || this.recyclerView == null) {
            return;
        }
        for (int i = 0; i < this.g.size(); i++) {
            if (this.g.get(i).getId().equals(reportSuccEvent.getPatternId())) {
                this.g.get(i).setIsShowReview(reportSuccEvent.getIsShowReview());
                this.g.get(i).setStatus(reportSuccEvent.getStatus());
                this.d.notifyItemChanged(this.e.indexOf(this.g.get(i)));
                return;
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(PatternFavoriteChangeEvent patternFavoriteChangeEvent) {
        int i = 0;
        if (patternFavoriteChangeEvent.isStart()) {
            while (i < this.g.size()) {
                if (this.g.get(i).getId().equals(patternFavoriteChangeEvent.getPatternId())) {
                    this.d.notifyItemChanged(this.e.indexOf(this.g.get(i)));
                    return;
                }
                i++;
            }
            return;
        }
        if (patternFavoriteChangeEvent.isFail()) {
            while (i < this.g.size()) {
                if (this.g.get(i).getId().equals(patternFavoriteChangeEvent.getPatternId())) {
                    this.d.notifyItemChanged(this.e.indexOf(this.g.get(i)));
                    return;
                }
                i++;
            }
            return;
        }
        if (this.g == null || this.d == null || this.recyclerView == null) {
            return;
        }
        while (i < this.g.size()) {
            if (this.g.get(i).getId().equals(patternFavoriteChangeEvent.getPatternId())) {
                this.g.get(i).setFavorite(patternFavoriteChangeEvent.getIsFavorite());
                if (patternFavoriteChangeEvent.getIsFavorite()) {
                    this.g.get(i).setFavoritesCount(this.g.get(i).getFavoritesCount() + 1);
                } else {
                    this.g.get(i).setFavoritesCount(this.g.get(i).getFavoritesCount() - 1);
                }
                this.d.notifyItemChanged(this.e.indexOf(this.g.get(i)), "like");
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
        PatternViewHolder patternViewHolder = this.h;
        if (patternViewHolder != null) {
            Pattern pattern = patternViewHolder.b;
            if (pattern != null) {
                if (!WearUtils.e1(pattern.getData())) {
                    if (this.h.b.getHead() == null) {
                        PatternViewHolder patternViewHolder2 = this.h;
                        patternViewHolder2.patternPlayCurve.setInitData(null, patternViewHolder2.b.getData().split(","), true);
                    } else {
                        PatternViewHolder patternViewHolder3 = this.h;
                        patternViewHolder3.patternPlayCurve.setInitData(patternViewHolder3.b.getHead(), this.h.b.getData().split(";"), false);
                    }
                }
                PatternViewHolder patternViewHolder4 = this.h;
                patternViewHolder4.patternSingleTitle.setText(patternViewHolder4.b.getName());
                PatternViewHolder patternViewHolder5 = this.h;
                patternViewHolder5.patternTimes.setText(patternViewHolder5.b.getTimer());
            }
            this.h.patternPlay.setImageResource(R.drawable.home_pattern_play);
            this.h = null;
        }
    }

    @Override // com.wear.adapter.patterns.PatternSearchAdapter.f
    public void p2() {
        Bundle bundle = new Bundle();
        bundle.putString("keyword", this.b);
        bundle.putStringArrayList("users", this.f);
        pj3.g(this, PatternSearchActivity.class, bundle);
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
        PatternViewHolder patternViewHolder = this.h;
        if (patternViewHolder != null) {
            patternViewHolder.patternPlayCurve.setShowBothLine(z);
        }
    }

    @Override // dc.hv1
    public void z1() {
        K4();
    }

    @Override // dc.hv1
    public void z3(float f2) {
        PatternViewHolder patternViewHolder = this.h;
        if (patternViewHolder != null) {
            patternViewHolder.patternPlayCurve.setFirstLinePoint(f2);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(PatternDownloadEvent patternDownloadEvent) {
        if (this.g == null || this.d == null || this.recyclerView == null) {
            return;
        }
        for (int i = 0; i < this.g.size(); i++) {
            if (this.g.get(i).getId().equals(patternDownloadEvent.getPatternId())) {
                this.g.get(i).setLikeCount(this.g.get(i).getLikeCount() + 1);
                this.d.notifyItemChanged(this.e.indexOf(this.g.get(i)), Pattern.DOWNLOAD);
                return;
            }
        }
    }
}
