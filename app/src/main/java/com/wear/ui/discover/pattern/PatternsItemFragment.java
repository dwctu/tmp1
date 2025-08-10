package com.wear.ui.discover.pattern;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;
import com.wear.adapter.patterns.PatternNewAdapter;
import com.wear.adapter.patterns.PatternViewHolder;
import com.wear.bean.Pattern;
import com.wear.bean.PatternDataBean;
import com.wear.bean.PatternHiddenSuccBean;
import com.wear.bean.Toy;
import com.wear.bean.ToyConfigInfoBean;
import com.wear.bean.event.ChangeToyEvent;
import com.wear.bean.event.HidePatternEvent;
import com.wear.bean.event.LoginOrOfflineEvent;
import com.wear.bean.event.PatternDownloadEvent;
import com.wear.bean.event.PatternFavoriteChangeEvent;
import com.wear.bean.event.ReportSuccEvent;
import com.wear.bean.event.TestEvent;
import com.wear.main.BaseFragment;
import com.wear.main.account.login.LoginActivity;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.ui.home.pattern.control.PatternPlayManagerImpl;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MediumBoldTextView;
import com.wear.widget.RecyclerViewNoBugLinearLayoutManager;
import com.wear.widget.SpaceItemDecoration;
import dc.ah4;
import dc.ce3;
import dc.cs3;
import dc.en2;
import dc.ff3;
import dc.gp2;
import dc.hf3;
import dc.hv1;
import dc.is3;
import dc.ke3;
import dc.pj3;
import dc.sg3;
import dc.sz1;
import dc.tn2;
import dc.tz1;
import dc.ug3;
import dc.uu1;
import dc.ye3;
import dc.zn2;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;

/* loaded from: classes3.dex */
public class PatternsItemFragment extends BaseFragment implements View.OnClickListener, gp2, tz1, hv1 {
    public static final String E = PatternsItemFragment.class.getSimpleName();
    public PatternNewAdapter A;
    public RecyclerViewNoBugLinearLayoutManager B;
    public boolean C;
    public boolean D;

    @BindView(R.id.pattern_list_empty)
    public LinearLayout emptyView;
    public Unbinder k;

    @BindView(R.id.login_patterns)
    public FrameLayout loginPattern;

    @BindView(R.id.tv_tip)
    public TextView mTv_tip;
    public MyApplication n;
    public PatternViewHolder o;

    @BindView(R.id.offline_login)
    public MediumBoldTextView offlineLogin;

    @BindView(R.id.offline_patterns)
    public LinearLayout offlinePattern;
    public Handler p;

    @BindView(R.id.pattern_recylerview)
    public RecyclerView patternRecylerview;

    @BindView(R.id.pattern_list_empty_text)
    public TextView pattern_list_empty_text;
    public String q;

    @BindView(R.id.swipe_refresh_pattern)
    public SwipyRefreshLayout swipeRefreshPattern;
    public en2 z;
    public String l = "Recommended";
    public int m = 1;
    public List<Pattern> r = Collections.synchronizedList(new ArrayList());
    public boolean s = false;
    public boolean t = false;
    public boolean u = false;
    public boolean v = false;
    public boolean w = false;
    public boolean x = false;
    public Handler y = new Handler();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PatternsItemFragment patternsItemFragment = PatternsItemFragment.this;
            patternsItemFragment.m = 1;
            patternsItemFragment.D = false;
            PatternsItemFragment.this.p0(false);
            PatternsItemFragment.this.s = true;
        }
    }

    public class b implements SwipyRefreshLayout.OnRefreshListener {
        public b() {
        }

        @Override // com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout.OnRefreshListener
        public void onRefresh(SwipyRefreshLayoutDirection swipyRefreshLayoutDirection) {
            SwipyRefreshLayoutDirection swipyRefreshLayoutDirection2 = SwipyRefreshLayoutDirection.TOP;
            if (swipyRefreshLayoutDirection == swipyRefreshLayoutDirection2) {
                PatternsItemFragment patternsItemFragment = PatternsItemFragment.this;
                patternsItemFragment.m = 1;
                patternsItemFragment.D = false;
                PatternsItemFragment.this.p0(false);
            } else {
                PatternsItemFragment.this.p0(true);
            }
            String unused = PatternsItemFragment.E;
            StringBuilder sb = new StringBuilder();
            sb.append("Refresh triggered chat_notification_at ");
            sb.append(swipyRefreshLayoutDirection == swipyRefreshLayoutDirection2 ? "top" : "bottom");
            sb.toString();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            pj3.s(PatternsItemFragment.this.getActivity(), LoginActivity.class);
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ String a;

        public d(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                sg3.l(this.a);
                SwipyRefreshLayout swipyRefreshLayout = PatternsItemFragment.this.swipeRefreshPattern;
                if (swipyRefreshLayout != null) {
                    swipyRefreshLayout.setRefreshing(false);
                }
                List<Pattern> list = PatternsItemFragment.this.r;
                if (list == null || list.size() == 0) {
                    PatternsItemFragment.this.emptyView.setVisibility(0);
                    if (PatternsItemFragment.this.l.equals("Mine")) {
                        PatternsItemFragment.this.pattern_list_empty_text.setText(ah4.e(R.string.patterns_mine_empty));
                    } else if (PatternsItemFragment.this.l.equals("Liked")) {
                        PatternsItemFragment.this.pattern_list_empty_text.setText(ah4.e(R.string.patterns_liked_empty));
                    } else if (PatternsItemFragment.this.l.equals("Pick")) {
                        PatternsItemFragment.this.pattern_list_empty_text.setText(ah4.e(R.string.pattern_lovense_picks_empty));
                    } else {
                        PatternsItemFragment.this.pattern_list_empty_text.setText(ah4.e(R.string.pattern_no));
                    }
                    if (hf3.d(PatternsItemFragment.this.getActivity())) {
                        return;
                    }
                    PatternsItemFragment.this.pattern_list_empty_text.setText(ah4.e(R.string.net_connect_error_tip));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class e extends ff3 {
        public final /* synthetic */ Pattern a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;

        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                if (!eVar.b) {
                    for (int i = 0; i < PatternsItemFragment.this.r.size(); i++) {
                        if (PatternsItemFragment.this.r.get(i).getId().equals(this.a)) {
                            RecyclerView recyclerView = PatternsItemFragment.this.patternRecylerview;
                            if (recyclerView == null || recyclerView.getAdapter() == null) {
                                return;
                            }
                            if (PatternsItemFragment.this.patternRecylerview.getAdapter().getItemCount() > i) {
                                PatternsItemFragment.this.A.notifyItemChanged(i, "getServerFile");
                                return;
                            } else {
                                PatternsItemFragment.this.h0();
                                PatternsItemFragment.this.A.notifyDataSetChanged();
                                return;
                            }
                        }
                    }
                    return;
                }
                int size = PatternsItemFragment.this.r.size();
                e eVar2 = e.this;
                if (size < eVar2.c) {
                    return;
                }
                for (int size2 = PatternsItemFragment.this.r.size() - 1; size2 >= 0; size2--) {
                    if (PatternsItemFragment.this.r.get(size2).getId().equals(this.a)) {
                        RecyclerView recyclerView2 = PatternsItemFragment.this.patternRecylerview;
                        if (recyclerView2 == null || recyclerView2.getAdapter() == null) {
                            return;
                        }
                        if (PatternsItemFragment.this.patternRecylerview.getAdapter().getItemCount() > size2) {
                            PatternsItemFragment.this.A.notifyItemChanged(size2, "getServerFile");
                            return;
                        } else {
                            PatternsItemFragment.this.h0();
                            PatternsItemFragment.this.A.notifyDataSetChanged();
                            return;
                        }
                    }
                }
            }
        }

        public e(Pattern pattern, boolean z, int i) {
            this.a = pattern;
            this.b = z;
            this.c = i;
        }

        @Override // dc.ff3
        public void b(boolean z, Object obj) throws Throwable {
            if (z) {
                try {
                    this.a.setDataNoCheckFormat(WearUtils.N1(((File) obj).getPath()));
                    String id = this.a.getId();
                    if (PatternsItemFragment.this.getActivity() != null) {
                        PatternsItemFragment.this.getActivity().runOnUiThread(new a(id));
                    }
                } catch (Exception unused) {
                    PatternsItemFragment.this.t0();
                }
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = PatternsItemFragment.this.patternRecylerview;
            if (recyclerView == null || recyclerView.getAdapter() == null) {
                return;
            }
            PatternsItemFragment.this.h0();
            PatternsItemFragment.this.A.notifyDataSetChanged();
        }
    }

    public class g implements zn2<PatternHiddenSuccBean> {
        public final /* synthetic */ PatternViewHolder a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g gVar = g.this;
                PatternsItemFragment.this.l0(gVar.a.a);
            }
        }

        public g(PatternViewHolder patternViewHolder) {
            this.a = patternViewHolder;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(PatternHiddenSuccBean patternHiddenSuccBean) {
            if (patternHiddenSuccBean.isResult()) {
                PatternsItemFragment.this.getActivity().runOnUiThread(new a());
                return;
            }
            if (patternHiddenSuccBean.getCode() != 400) {
                sg3.k(PatternsItemFragment.this.getActivity(), patternHiddenSuccBean.getMessage() + "");
                return;
            }
            sg3.j(PatternsItemFragment.this.getActivity(), R.string.operate_frequently, " [" + patternHiddenSuccBean.getCode() + "]");
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            sg3.k(PatternsItemFragment.this.getActivity(), netException.getMessage());
        }
    }

    public class h extends Handler {

        public class a implements PatternPlayManagerImpl.f {

            /* renamed from: com.wear.ui.discover.pattern.PatternsItemFragment$h$a$a, reason: collision with other inner class name */
            public class RunnableC0143a implements Runnable {
                public final /* synthetic */ Pattern a;
                public final /* synthetic */ boolean b;
                public final /* synthetic */ int c;
                public final /* synthetic */ String[] d;
                public final /* synthetic */ String e;
                public final /* synthetic */ String f;

                public RunnableC0143a(Pattern pattern, boolean z, int i, String[] strArr, String str, String str2) {
                    this.a = pattern;
                    this.b = z;
                    this.c = i;
                    this.d = strArr;
                    this.e = str;
                    this.f = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String patternStoreTag;
                    View viewFindViewByPosition;
                    PatternsItemFragment patternsItemFragment;
                    RecyclerView recyclerView;
                    PatternsItemFragment.this.A0();
                    PatternsItemFragment.this.o = null;
                    boolean zD0 = PatternPlayManagerImpl.O().d0();
                    Pattern pattern = this.a;
                    if (pattern == null || (patternStoreTag = pattern.getPatternStoreTag()) == null || !patternStoreTag.endsWith(PatternsItemFragment.this.l)) {
                        return;
                    }
                    for (int i = 0; i < PatternsItemFragment.this.r.size(); i++) {
                        if (!WearUtils.e1(PatternsItemFragment.this.r.get(i).getPatternStoreTag()) && !WearUtils.e1(this.a.getPatternStoreTag()) && PatternsItemFragment.this.r.get(i).getPatternStoreTag().equals(patternStoreTag) && (viewFindViewByPosition = PatternsItemFragment.this.B.findViewByPosition(i)) != null && (recyclerView = (patternsItemFragment = PatternsItemFragment.this).patternRecylerview) != null) {
                            patternsItemFragment.o = (PatternViewHolder) recyclerView.getChildViewHolder(viewFindViewByPosition);
                            PatternViewHolder patternViewHolder = PatternsItemFragment.this.o;
                            if (patternViewHolder != null) {
                                patternViewHolder.patternPlayCurve.setShowBothLine(this.b);
                                PatternsItemFragment.this.o.patternPlayCurve.a(this.c, this.a, this.d);
                                PatternsItemFragment.this.o.patternTimes.setText(this.e);
                                PatternsItemFragment.this.o.patternPlayCurve.setBothLinePoint(this.f);
                                if (zD0) {
                                    PatternsItemFragment.this.o.patternPlay.setImageResource(R.drawable.home_pattern_play);
                                } else {
                                    PatternsItemFragment.this.o.patternPlay.setImageResource(R.drawable.home_pattern_pause);
                                }
                            }
                        }
                    }
                }
            }

            public a() {
            }

            @Override // com.wear.ui.home.pattern.control.PatternPlayManagerImpl.f
            public void a(Pattern pattern, int i, boolean z, String str, String str2, int i2, String[] strArr) {
                PatternsItemFragment.this.p.post(new RunnableC0143a(pattern, z, i2, strArr, str, str2));
            }
        }

        public h() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 2) {
                return;
            }
            try {
                PatternsItemFragment.this.m++;
                PatternDataBean patternDataBean = (PatternDataBean) message.obj;
                if (patternDataBean.isPullToRefresh()) {
                    PatternsItemFragment.this.r.addAll(patternDataBean.getPatternDatas());
                } else {
                    PatternsItemFragment.this.r.clear();
                    PatternsItemFragment.this.r.addAll(patternDataBean.getPatternDatas());
                }
                RecyclerView recyclerView = PatternsItemFragment.this.patternRecylerview;
                if (recyclerView != null && recyclerView.getAdapter() != null) {
                    PatternsItemFragment.this.h0();
                    PatternsItemFragment.this.A.notifyDataSetChanged();
                }
                PatternsItemFragment.this.swipeRefreshPattern.setRefreshing(false);
                if (WearUtils.g1(PatternsItemFragment.this.r)) {
                    PatternsItemFragment.this.emptyView.setVisibility(0);
                    if (PatternsItemFragment.this.l.equals("Mine")) {
                        PatternsItemFragment.this.pattern_list_empty_text.setText(ah4.e(R.string.patterns_mine_empty));
                    } else if (PatternsItemFragment.this.l.equals("Liked")) {
                        PatternsItemFragment.this.pattern_list_empty_text.setText(ah4.e(R.string.patterns_liked_empty));
                    } else if (PatternsItemFragment.this.l.equals("Pick")) {
                        PatternsItemFragment.this.pattern_list_empty_text.setText(ah4.e(R.string.pattern_lovense_picks_empty));
                    } else {
                        PatternsItemFragment.this.pattern_list_empty_text.setText(ah4.e(R.string.pattern_no));
                    }
                    if (!hf3.d(PatternsItemFragment.this.getActivity())) {
                        PatternsItemFragment.this.pattern_list_empty_text.setText(ah4.e(R.string.net_connect_error_tip));
                    }
                } else {
                    PatternsItemFragment.this.emptyView.setVisibility(8);
                }
                if (patternDataBean.isPullToRefresh()) {
                    return;
                }
                PatternPlayManagerImpl.O().h0(PatternsItemFragment.this.l, new a());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n0() {
        SwipyRefreshLayout swipyRefreshLayout = this.swipeRefreshPattern;
        if (swipyRefreshLayout != null) {
            swipyRefreshLayout.setRefreshing(true);
        }
    }

    public final void A0() {
        PatternViewHolder patternViewHolder = this.o;
        if (patternViewHolder != null) {
            Pattern pattern = patternViewHolder.b;
            if (pattern != null) {
                if (!WearUtils.e1(pattern.getData())) {
                    if (this.o.b.getHead() == null) {
                        PatternViewHolder patternViewHolder2 = this.o;
                        patternViewHolder2.patternPlayCurve.setInitData(null, patternViewHolder2.b.getData().split(","), true);
                    } else {
                        PatternViewHolder patternViewHolder3 = this.o;
                        patternViewHolder3.patternPlayCurve.setInitData(patternViewHolder3.b.getHead(), this.o.b.getData().split(";"), false);
                    }
                }
                if ((WearUtils.e1(this.o.b.getIsShowReview()) || !this.o.b.getIsShowReview().equals("1")) && (WearUtils.e1(this.o.b.getStatus()) || !this.o.b.getStatus().equals(AppMeasurementSdk.ConditionalUserProperty.ACTIVE))) {
                    this.o.iv_under_preview.setVisibility(8);
                    PatternViewHolder patternViewHolder4 = this.o;
                    patternViewHolder4.patternSingleTitle.setText(TextUtils.isEmpty(patternViewHolder4.b.getName()) ? "" : this.o.b.getName());
                } else {
                    this.o.iv_under_preview.setVisibility(0);
                    this.o.patternSingleTitle.setText(R.string.patterns_under_review);
                }
                PatternViewHolder patternViewHolder5 = this.o;
                patternViewHolder5.patternTimes.setText(patternViewHolder5.b.getTimer());
            }
            this.o.patternPlay.setImageResource(R.drawable.home_pattern_play);
        }
    }

    @Override // dc.hv1
    public void A3(Pattern pattern, int i) {
        View viewFindViewByPosition;
        A0();
        this.o = null;
        if (pattern.getPatternStoreTag() != null && pattern.getPatternStoreTag().endsWith(this.l) && this.r.contains(pattern)) {
            for (int i2 = 0; i2 < this.r.size(); i2++) {
                if (!WearUtils.e1(this.r.get(i2).getPatternStoreTag()) && !WearUtils.e1(pattern.getPatternStoreTag()) && this.r.get(i2).getPatternStoreTag().equals(pattern.getPatternStoreTag()) && (viewFindViewByPosition = this.B.findViewByPosition(i2)) != null) {
                    this.o = (PatternViewHolder) this.patternRecylerview.getChildViewHolder(viewFindViewByPosition);
                }
            }
        }
    }

    @Override // dc.hv1
    public void B3(String str) {
    }

    public final void C0(Pattern pattern, boolean z, int i) {
        if (WearUtils.e1(pattern.getData())) {
            WearUtils.E0(false, pattern.getCdnPath(), new e(pattern, z, i));
        }
    }

    @Override // com.wear.main.BaseFragment
    public void D() {
        this.g.c(this);
        this.h = this.z;
    }

    @Override // dc.hv1
    public void D2(Pattern pattern, int i) {
        PatternViewHolder patternViewHolder = this.o;
        if (patternViewHolder != null) {
            if (i == 0) {
                A0();
            } else {
                patternViewHolder.patternPlay.setImageResource(R.drawable.home_pattern_pause);
                this.o.patternPlayCurve.b();
            }
        }
    }

    @Override // com.wear.main.BaseFragment
    public void I() {
        super.I();
    }

    @Override // com.wear.main.BaseFragment
    public void J() {
        super.J();
    }

    @Override // dc.hv1
    public void O2(int i, Pattern pattern, String[] strArr) {
        PatternViewHolder patternViewHolder = this.o;
        if (patternViewHolder != null) {
            patternViewHolder.patternPlayCurve.a(i, pattern, strArr);
        }
    }

    @Override // dc.hv1
    public void T3(String str, int i, String str2) {
        View viewFindViewByPosition;
        PatternViewHolder patternViewHolder = this.o;
        if (patternViewHolder != null) {
            if (patternViewHolder.b.getPatternStoreTag().equals(str2)) {
                this.o.patternPlayCurve.setBothLinePoint(str);
                return;
            }
            return;
        }
        if (i == 1 && str2 != null && str2.endsWith(this.l)) {
            for (int i2 = 0; i2 < this.r.size(); i2++) {
                if (!WearUtils.e1(this.r.get(i2).getPatternStoreTag()) && !WearUtils.e1(str2) && this.r.get(i2).getPatternStoreTag().equals(str2) && (viewFindViewByPosition = this.B.findViewByPosition(i2)) != null) {
                    PatternViewHolder patternViewHolder2 = (PatternViewHolder) this.patternRecylerview.getChildViewHolder(viewFindViewByPosition);
                    this.o = patternViewHolder2;
                    patternViewHolder2.patternPlay.setImageResource(R.drawable.home_pattern_pause);
                    this.o.patternPlayCurve.setBothLinePoint(str);
                }
            }
        }
    }

    @Override // dc.hv1
    public void V1(boolean z, int i) {
        if (i == 0) {
            A0();
            this.o = null;
            return;
        }
        PatternViewHolder patternViewHolder = this.o;
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
        PatternViewHolder patternViewHolder = this.o;
        if (patternViewHolder == null || !patternViewHolder.b.getPatternStoreTag().equals(str2)) {
            return;
        }
        this.o.patternTimes.setText(str);
    }

    public final void g0() {
        if (MyApplication.Z && (this.l.equals("Liked") || this.l.equals("Mine"))) {
            this.loginPattern.setVisibility(8);
            this.offlinePattern.setVisibility(0);
            this.C = false;
        } else {
            this.loginPattern.setVisibility(0);
            this.offlinePattern.setVisibility(8);
            this.C = true;
        }
        this.v = MyApplication.Z;
    }

    @Override // dc.tz1
    public int getPriority() {
        return 4;
    }

    public final void h0() {
        List<Pattern> list = this.r;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        Iterator<Pattern> it = this.r.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Pattern next = it.next();
            i++;
            if (arrayList.contains(next.getId())) {
                String str = "checkSameIds: " + next.getId();
                FirebaseCrashlytics.getInstance().recordException(new Throwable("PatternNewAdapter 相同项导致 Two different ViewHolders have the same stable ID :" + next.getId() + ", type:" + this.l + ", position:" + i));
                break;
            }
            arrayList.add(next.getId());
        }
        arrayList.clear();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long[] i0(java.lang.String r30) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.pattern.PatternsItemFragment.i0(java.lang.String):long[]");
    }

    public final long j0() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return jCurrentTimeMillis - ((TimeZone.getDefault().getRawOffset() + jCurrentTimeMillis) % 86400000);
    }

    public void k0(PatternViewHolder patternViewHolder) {
        HashMap map = new HashMap();
        map.put(TtmlNode.ATTR_ID, patternViewHolder.a);
        tn2.x(WearUtils.x).k("/hide-pattern/save", map, new g(patternViewHolder));
    }

    public final void l0(String str) {
        Integer num;
        Pattern pattern;
        int i = 0;
        if (ke3.a("new_user", "pattern_hidden_key")) {
            is3.b bVar = new is3.b(getActivity());
            bVar.o(ah4.e(R.string.common_ok));
            bVar.p(getString(R.string.notification_to_unhide_pattern));
            bVar.k(R.layout.dialog_first_hidden);
            bVar.m(false);
            cs3.h(bVar).show();
        }
        while (true) {
            num = null;
            if (i >= this.r.size()) {
                pattern = null;
                break;
            }
            if (str.equals(this.r.get(i).getId())) {
                Pattern pattern2 = this.r.get(i);
                Integer numValueOf = Integer.valueOf(i);
                List<Pattern> list = this.r;
                list.remove(list.get(i));
                t0();
                num = numValueOf;
                pattern = pattern2;
                break;
            }
            i++;
        }
        PatternPlayManagerImpl.O().K(this.r, num, pattern);
    }

    @Override // dc.gp2
    public void o0(boolean z, BaseResponseBean baseResponseBean) {
        List list;
        try {
            list = (List) baseResponseBean.getData();
        } catch (Exception unused) {
            list = null;
        }
        ArrayList arrayList = new ArrayList();
        if (!WearUtils.g1(list) && list.size() > 0) {
            int size = this.r.size();
            int size2 = list.size();
            this.D = size2 < 20;
            for (int i = 0; i < size2; i++) {
                Map map = (Map) list.get(i);
                Gson gson = WearUtils.A;
                Pattern pattern = (Pattern) gson.fromJson(gson.toJson(map), Pattern.class);
                long jLongValue = ((Double) map.get("createdTime")).longValue();
                String str = (String) map.get("isAnony");
                pattern.setCreated(new Date(jLongValue));
                if (pattern.getName() != null) {
                    pattern.setName(WearUtils.u(pattern.getName()));
                }
                if ("1".equals(str)) {
                    pattern.setAnony(true);
                    pattern.setAuthor(null);
                }
                pattern.setPatternStoreTag(pattern.getId() + "#" + this.l);
                C0(pattern, z, size);
                arrayList.add(pattern);
            }
        }
        Message message = new Message();
        message.what = 2;
        message.obj = new PatternDataBean(arrayList, z);
        this.p.sendMessage(message);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        MyApplication myApplication = (MyApplication) getActivity().getApplication();
        this.n = myApplication;
        M(myApplication);
        View viewInflate = layoutInflater.inflate(R.layout.pattern_fragment_list, (ViewGroup) null, false);
        this.k = ButterKnife.bind(this, viewInflate);
        this.p = new h();
        if (getArguments() != null) {
            this.l = getArguments().getString("type");
        }
        g0();
        y0();
        PatternNewAdapter patternNewAdapter = new PatternNewAdapter(this.r, this.n, getContext(), this);
        this.A = patternNewAdapter;
        patternNewAdapter.setHasStableIds(true);
        RecyclerViewNoBugLinearLayoutManager recyclerViewNoBugLinearLayoutManager = new RecyclerViewNoBugLinearLayoutManager(getContext());
        this.B = recyclerViewNoBugLinearLayoutManager;
        recyclerViewNoBugLinearLayoutManager.setOrientation(1);
        this.patternRecylerview.setLayoutManager(this.B);
        this.patternRecylerview.addItemDecoration(new SpaceItemDecoration(ce3.a(getActivity(), 12.0f)));
        this.patternRecylerview.setAdapter(this.A);
        this.swipeRefreshPattern.setColorSchemeResources(R.color.color_accent_second, R.color.pink, R.color.pink_stroke, R.color.color_accent);
        this.swipeRefreshPattern.setOnRefreshListener(new b());
        this.t = true;
        EventBus.getDefault().register(this);
        sz1.d().n(this);
        PatternPlayManagerImpl.O().G(this);
        this.offlineLogin.setOnClickListener(new c());
        return viewInflate;
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        PatternPlayManagerImpl.O().N0(this);
        PatternViewHolder patternViewHolder = this.o;
        if (patternViewHolder != null) {
            Pattern pattern = patternViewHolder.b;
            if (pattern != null) {
                if (!WearUtils.e1(pattern.getData())) {
                    if (this.o.b.getHead() == null) {
                        PatternViewHolder patternViewHolder2 = this.o;
                        patternViewHolder2.patternPlayCurve.setInitData(null, patternViewHolder2.b.getData().split(","), true);
                    } else {
                        PatternViewHolder patternViewHolder3 = this.o;
                        patternViewHolder3.patternPlayCurve.setInitData(patternViewHolder3.b.getHead(), this.o.b.getData().split(";"), false);
                    }
                }
                if ((WearUtils.e1(this.o.b.getIsShowReview()) || !this.o.b.getIsShowReview().equals("1")) && (WearUtils.e1(this.o.b.getStatus()) || !this.o.b.getStatus().equals(AppMeasurementSdk.ConditionalUserProperty.ACTIVE))) {
                    this.o.iv_under_preview.setVisibility(8);
                    PatternViewHolder patternViewHolder4 = this.o;
                    patternViewHolder4.patternSingleTitle.setText(TextUtils.isEmpty(patternViewHolder4.b.getName()) ? "" : this.o.b.getName());
                } else {
                    this.o.iv_under_preview.setVisibility(0);
                    this.o.patternSingleTitle.setText(R.string.patterns_under_review);
                }
                PatternViewHolder patternViewHolder5 = this.o;
                patternViewHolder5.patternTimes.setText(patternViewHolder5.b.getTimer());
            }
            this.o.patternPlay.setImageResource(R.drawable.home_pattern_play);
            this.o = null;
        }
        EventBus.getDefault().unregister(this);
        sz1.d().s(this);
        this.k.unbind();
        this.t = false;
        this.s = false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(ReportSuccEvent reportSuccEvent) {
        if (reportSuccEvent == null || WearUtils.e1(reportSuccEvent.getPatternId())) {
            return;
        }
        if (reportSuccEvent.getIsHidePattern()) {
            l0(reportSuccEvent.getPatternId());
            return;
        }
        if (this.r == null || this.A == null || this.patternRecylerview == null) {
            return;
        }
        for (int i = 0; i < this.r.size(); i++) {
            if (this.r.get(i).getId().equals(reportSuccEvent.getPatternId())) {
                this.r.get(i).setIsShowReview(reportSuccEvent.getIsShowReview());
                this.r.get(i).setStatus(reportSuccEvent.getStatus());
                this.A.notifyItemChanged(i);
                return;
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(HidePatternEvent hidePatternEvent) {
        l0(hidePatternEvent.getPatternId());
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        String str = "ttttttt onPause: " + this.l;
        this.u = false;
        x0();
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        String str = "ttttttt onResume: " + this.l;
        this.u = true;
        x0();
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void p0(boolean z) {
        if (getActivity() == null) {
            return;
        }
        if (WearUtils.y.u() != null || this.C) {
            if (this.D) {
                this.swipeRefreshPattern.setRefreshing(false);
                return;
            }
            StringBuilder sb = new StringBuilder();
            String str = "";
            if (!WearUtils.e1(((PatternStoreActivity) getActivity()).c)) {
                str = ((PatternStoreActivity) getActivity()).b;
                sb = new StringBuilder(((PatternStoreActivity) getActivity()).c);
                String str2 = "请求的toyTag=====" + ((PatternStoreActivity) getActivity()).b;
            } else if (this.n.G().P().size() > 0 && !this.x) {
                ArrayList arrayList = new ArrayList(this.n.G().P());
                ArrayList<String> arrayList2 = new ArrayList();
                HashSet hashSet = new HashSet();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Toy toy = (Toy) it.next();
                    if (toy != null && toy.getToyConfigDataBean() != null) {
                        ToyConfigInfoBean toyConfigDataBean = toy.getToyConfigDataBean();
                        List<String> symbol = toyConfigDataBean.getSymbol();
                        if (symbol != null) {
                            hashSet.addAll(symbol);
                        }
                        ToyConfigInfoBean.FuncBean func = toyConfigDataBean.getFunc();
                        if (func != null) {
                            String str3 = (!func.isV() || func.isV1() || toy.isF01Toy()) ? "" : PSOProgramService.VS_Key;
                            if (func.isV1()) {
                                str3 = WearUtils.e1(str3) ? "v1" : str3 + ",v1";
                            }
                            if (func.isV2()) {
                                str3 = WearUtils.e1(str3) ? "v2" : str3 + ",v2";
                            }
                            if (func.isV3()) {
                                str3 = WearUtils.e1(str3) ? "v3" : str3 + ",v3";
                            }
                            if (func.isR()) {
                                str3 = WearUtils.e1(str3) ? StreamManagement.AckRequest.ELEMENT : str3 + ",r";
                            }
                            if (func.isP()) {
                                str3 = WearUtils.e1(str3) ? "p" : str3 + ",p";
                            }
                            if (func.isS()) {
                                str3 = "s";
                            }
                            if (func.isF()) {
                                str3 = WearUtils.e1(str3) ? "f" : str3 + ",f";
                            }
                            if (func.isT()) {
                                if (toy.isBAToy()) {
                                    if (!arrayList2.contains("t")) {
                                        arrayList2.add("t");
                                    }
                                } else if (WearUtils.e1(str3)) {
                                    str3 = "t";
                                } else {
                                    str3 = str3 + ",t";
                                }
                            }
                            if (func.isD()) {
                                str3 = WearUtils.e1(str3) ? GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG : str3 + ",d";
                            }
                            if (func.isPos()) {
                                if (toy.isBAToy()) {
                                    if (!arrayList2.contains("pos")) {
                                        arrayList2.add("pos");
                                    }
                                } else if (WearUtils.e1(str3)) {
                                    str3 = "pos";
                                } else {
                                    str3 = str3 + ",pos";
                                }
                            }
                            if (!TextUtils.isEmpty(str3) && !arrayList2.contains(str3)) {
                                arrayList2.add(str3);
                            }
                        }
                    }
                }
                String str4 = null;
                for (String str5 : arrayList2) {
                    str4 = WearUtils.e1(str4) ? str5 : str4 + ";" + str5;
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    sb.append((String) it2.next());
                    sb.append(";");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                str = str4;
            }
            v0(z, str, sb.toString());
        }
    }

    @Override // dc.tz1
    public void pauseConnon(int i) {
    }

    public final void q0(String str, String str2) {
        if (getActivity() == null) {
            return;
        }
        if (WearUtils.y.u() != null || this.C) {
            if (this.D) {
                this.swipeRefreshPattern.setRefreshing(false);
            } else {
                v0(false, str, str2);
            }
        }
    }

    public void r0(LoginOrOfflineEvent loginOrOfflineEvent) {
        g0();
    }

    @Override // dc.tz1
    public void recovery() {
    }

    @Override // com.wear.main.BaseFragment, dc.ul2
    public void showErrorMsg(String str, boolean z) {
        if (getActivity() == null) {
            return;
        }
        getActivity().runOnUiThread(new d(str));
    }

    @Override // dc.tz1
    public void stop(int i) {
        PatternPlayManagerImpl.O().U0();
    }

    public final void t0() {
        if (getActivity() == null) {
            return;
        }
        getActivity().runOnUiThread(new f());
    }

    public void u0(PatternFavoriteChangeEvent patternFavoriteChangeEvent) {
        int i = 0;
        if (patternFavoriteChangeEvent.isStart()) {
            while (i < this.r.size()) {
                if (this.r.get(i).getId().equals(patternFavoriteChangeEvent.getPatternId())) {
                    this.A.notifyItemChanged(i);
                    return;
                }
                i++;
            }
            return;
        }
        if (patternFavoriteChangeEvent.isFail()) {
            while (i < this.r.size()) {
                if (this.r.get(i).getId().equals(patternFavoriteChangeEvent.getPatternId())) {
                    this.A.notifyItemChanged(i);
                    return;
                }
                i++;
            }
            return;
        }
        if (this.r == null || this.A == null || this.patternRecylerview == null) {
            return;
        }
        if (!this.l.equals("Liked")) {
            while (i < this.r.size()) {
                if (this.r.get(i).getId().equals(patternFavoriteChangeEvent.getPatternId())) {
                    this.r.get(i).setFavorite(patternFavoriteChangeEvent.getIsFavorite());
                    if (patternFavoriteChangeEvent.getIsFavorite()) {
                        this.r.get(i).setFavoritesCount(this.r.get(i).getFavoritesCount() + 1);
                    } else {
                        this.r.get(i).setFavoritesCount(this.r.get(i).getFavoritesCount() - 1);
                    }
                    this.A.notifyItemChanged(i, "like");
                    return;
                }
                i++;
            }
            return;
        }
        if (patternFavoriteChangeEvent.getIsFavorite()) {
            return;
        }
        while (i < this.r.size()) {
            if (this.r.get(i).getId().equals(patternFavoriteChangeEvent.getPatternId())) {
                List<Pattern> list = this.r;
                list.remove(list.get(i));
                h0();
                this.A.notifyDataSetChanged();
                return;
            }
            i++;
        }
    }

    @Override // dc.hv1
    public void u3(boolean z) {
        PatternViewHolder patternViewHolder = this.o;
        if (patternViewHolder != null) {
            patternViewHolder.patternPlayCurve.setShowBothLine(z);
        }
    }

    public final void v0(boolean z, String str, String str2) {
        HashMap map = new HashMap();
        if (!WearUtils.e1(str)) {
            map.put("toyTag", str);
        }
        map.put("type", this.l);
        if (this.l.equals("newYears")) {
            if (!z || WearUtils.e1(this.q)) {
                this.q = WearUtils.E();
            }
            map.put("uuid", this.q);
        }
        if (uu1.b(str2)) {
            map.put("toyFeature", Toy.TOY_FEATURE_XMACHINE);
        }
        long[] jArrI0 = i0(((PatternStoreActivity) getActivity()).d);
        map.put("rangeStartTime", Long.valueOf(jArrI0[0]));
        map.put("rangeEndTime", Long.valueOf(jArrI0[1]));
        if (!WearUtils.e1(((PatternStoreActivity) getActivity()).e) && !((PatternStoreActivity) getActivity()).e.equals("0")) {
            map.put(TypedValues.TransitionType.S_DURATION, ((PatternStoreActivity) getActivity()).e);
        }
        map.put("version", "2");
        map.put("platform", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        map.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, ye3.s());
        map.put(DataLayout.ELEMENT, Integer.valueOf(this.m));
        map.put("pageSize", 20);
        if (!WearUtils.e1(str2)) {
            map.put("toySymbol", str2);
        }
        this.swipeRefreshPattern.post(new Runnable() { // from class: dc.ox2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.n0();
            }
        });
        String str3 = "parmas=======" + map;
        this.z.h(z, map);
        this.s = true;
    }

    public void w0(boolean z, String str, String str2, boolean z2) {
        try {
            this.x = z2;
            if (!this.u || !this.s) {
                this.w = z;
                return;
            }
            this.m = 1;
            this.D = false;
            if (WearUtils.e1(str2)) {
                p0(false);
            } else {
                q0(str, str2);
            }
            this.s = true;
            this.w = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void x0() {
        if (this.u && this.t && (!this.s || this.w)) {
            this.m = 1;
            this.D = false;
            p0(false);
            this.w = false;
        }
        if (this.v != MyApplication.Z) {
            p0(false);
        }
    }

    public final void y0() {
        if (this.l.equals("Liked")) {
            this.mTv_tip.setText(R.string.pattern_store_liked_offline_tip);
        } else if (this.l.equals("Mine")) {
            this.mTv_tip.setText(R.string.pattern_store_me_offline_tip);
        } else {
            this.mTv_tip.setText("");
        }
    }

    public void z0(PatternViewHolder patternViewHolder) {
        String str = patternViewHolder.a;
        Bundle bundle = new Bundle();
        bundle.putString(TtmlNode.ATTR_ID, str);
        pj3.g(getActivity(), ReportReasonActivity.class, bundle);
    }

    @Override // dc.hv1
    public void z1() {
        A0();
    }

    @Override // dc.hv1
    public void z3(float f2) {
        PatternViewHolder patternViewHolder = this.o;
        if (patternViewHolder != null) {
            patternViewHolder.patternPlayCurve.setFirstLinePoint(f2);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(PatternDownloadEvent patternDownloadEvent) {
        if (this.r == null || this.A == null || this.patternRecylerview == null) {
            return;
        }
        for (int i = 0; i < this.r.size(); i++) {
            if (this.r.get(i).getId().equals(patternDownloadEvent.getPatternId())) {
                this.r.get(i).setLikeCount(this.r.get(i).getLikeCount() + 1);
                this.A.notifyItemChanged(i, Pattern.DOWNLOAD);
                return;
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(TestEvent testEvent) {
        if (testEvent.code == 1) {
            ug3.a(this.r);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ChangeToyEvent changeToyEvent) {
        if (this.u && this.t && this.s) {
            if (this.l.equals("Recommended") && WearUtils.e1(((PatternStoreActivity) getActivity()).b)) {
                this.y.removeCallbacksAndMessages(null);
                this.y.postDelayed(new a(), 500L);
                return;
            }
            return;
        }
        if (this.t && this.s && this.l.equals("Recommended") && WearUtils.e1(((PatternStoreActivity) getActivity()).b)) {
            this.w = true;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(LoginOrOfflineEvent loginOrOfflineEvent) {
        r0(loginOrOfflineEvent);
    }
}
