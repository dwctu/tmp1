package com.wear.ui.longDistance;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.lifecycle.Observer;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.adapter.longdistance.FriendShowOnLineAdapter;
import com.wear.adapter.longdistance.NewUserAdapter;
import com.wear.bean.Group;
import com.wear.bean.LanApiControlEvent;
import com.wear.bean.ScanQRDataBean;
import com.wear.bean.SyncWsProtocol;
import com.wear.bean.Toy;
import com.wear.bean.TypingBean;
import com.wear.bean.User;
import com.wear.bean.UserActionMenuBean;
import com.wear.bean.UserSetting;
import com.wear.bean.UserSettingsBean;
import com.wear.bean.event.AddFriendsRefreshList;
import com.wear.bean.event.AddFriendsRequestEvent;
import com.wear.bean.event.ClearAllMessageEvent;
import com.wear.bean.event.DiscoverRouletteNewTagHiddenEvent;
import com.wear.bean.event.LoginOrOfflineEvent;
import com.wear.bean.event.LoginStatusActionEvent;
import com.wear.bean.event.TypingEvent;
import com.wear.bean.event.UserUpdateEvent;
import com.wear.bean.event.VideoPatternControlEvent;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.official.OfficialAcount;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.dao.UserSettingDao;
import com.wear.main.BaseFragment;
import com.wear.main.MainActivity;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.longDistance.AddFriendActivity;
import com.wear.main.longDistance.ChatActivity;
import com.wear.main.longDistance.ChatRoomActivity;
import com.wear.main.toy.ToyActivity;
import com.wear.protocol.CommunMessage;
import com.wear.ui.discover.roulette.ToyRouletteActivity;
import com.wear.ui.longDistance.ConnectionsActivity;
import com.wear.ui.longDistance.LongFragment;
import com.wear.ui.longDistance.fragment.LongUserActionMenuFragmentBottom;
import com.wear.ui.longDistance.officialaccount.OfficialAccountActivity;
import com.wear.ui.longDistance.officialaccount.OfficialaCountModel;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MediumBoldTextView;
import com.wear.widget.roundwidget.SkinRoundImageView;
import dc.ah4;
import dc.cg3;
import dc.ch3;
import dc.cs3;
import dc.db2;
import dc.df3;
import dc.eg3;
import dc.ep1;
import dc.f42;
import dc.ff2;
import dc.hf3;
import dc.hg3;
import dc.is3;
import dc.kf;
import dc.kn3;
import dc.ku1;
import dc.lg3;
import dc.me3;
import dc.mk2;
import dc.mu3;
import dc.pg3;
import dc.pj3;
import dc.qo;
import dc.t12;
import dc.vd3;
import dc.ve3;
import dc.xc1;
import dc.yb2;
import dc.ye3;
import dc.zb2;
import dc.zd3;
import dc.zt3;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class LongFragment extends BaseFragment implements yb2, ep1.b {
    public ObservableEmitter<Object> A;
    public final Observable<Object> B;

    @BindView(R.id.btn_add)
    public ImageView btnAdd;

    @BindView(R.id.cl_request)
    public RelativeLayout clRequest;

    @BindView(R.id.control_roulette)
    public TextView controlRoulette;

    @BindView(R.id.frameLayout)
    public FrameLayout frameLayout;

    @BindView(R.id.iv_not_toy)
    public ImageView ivNotToy;

    @BindView(R.id.iv_search)
    public ImageView ivSearch;
    public List<IPeopleInfo> k = Collections.synchronizedList(new ArrayList());
    public ArrayList<IPeopleInfo> l = new ArrayList<>();

    @BindView(R.id.lan_api_control)
    public LinearLayout lanApiControl;

    @BindView(R.id.lan_api_control_stop)
    public TextView lanApiControlStop;

    @BindView(R.id.lan_api_control_update)
    public TextView lanApiControlUpdate;

    @BindView(R.id.ll_video_pattern_control)
    public LinearLayout llVideoPatternControl;

    @BindView(R.id.login_long_distance)
    public LinearLayout loginLongDistance;

    @BindView(R.id.long_distance_des)
    public TextView longDistanceDes;
    public FriendShowOnLineAdapter m;

    @BindView(R.id.ll_search)
    public ViewGroup mLlSearch;

    @BindView(R.id.mtv_title)
    public MediumBoldTextView mtvTitle;
    public qo n;
    public LinearLayoutManager o;

    @BindView(R.id.offline_login)
    public TextView offlineLogin;

    @BindView(R.id.offline_long_distance)
    public LinearLayout offlineLongDistance;
    public boolean p;

    @BindView(R.id.pb_login_ing)
    public ProgressBar pbLoginIng;
    public t12 q;
    public MyApplication r;

    @BindView(R.id.riv_request_photo)
    public SkinRoundImageView rivRequestPhoto;

    @BindView(R.id.rl_toy_1)
    public AppCompatTextView rlToy1;

    @BindView(R.id.rl_toy_2)
    public AppCompatTextView rlToy2;

    @BindView(R.id.rv_online)
    public RecyclerView rvOnline;
    public RecyclerView s;
    public NewUserAdapter t;

    @BindView(R.id.toys_number_text)
    public AppCompatTextView toysNumber;

    @BindView(R.id.tv_lan_api_platform)
    public TextView tvLanApiPlatform;

    @BindView(R.id.tv_request_count)
    public TextView tvRequestCount;

    @BindView(R.id.tv_video_pattern_control_tip)
    public TextView tvVideoPatternControlTip;

    @BindView(R.id.tv_video_pattern_control_unsync)
    public TextView tvVideoPatternControlUnsync;
    public LinearLayout u;
    public boolean v;
    public LongUserActionMenuFragmentBottom w;
    public Disposable x;
    public ObservableEmitter<Object> y;
    public Disposable z;

    public class a implements kn3.d {
        public a() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            db2.A().b.s(SyncWsProtocol.LAN_API_UN_BIND_NOTICE);
            DaoUtils.getTestValueDao().delete(zt3.k, TestValueDao.LAN_API_DATA_TYPE);
            ff2.d = false;
            ff2.f = false;
            ff2.e = false;
            ff2.n().C();
            MyApplication.G.send3dxConnectStop();
            MyApplication.G.onCancelReportToService();
            MyApplication.G = null;
            db2.A().s();
            LongFragment.this.lanApiControl.setVisibility(8);
            EventBus.getDefault().post(new LanApiControlEvent(false));
        }
    }

    public class b implements NewUserAdapter.b {
        public b() {
        }

        public static /* synthetic */ void c(IPeopleInfo iPeopleInfo) {
            if (iPeopleInfo instanceof Group) {
                ((Group) iPeopleInfo).setStatus(2);
            }
        }

        @Override // com.wear.adapter.longdistance.NewUserAdapter.b
        public void a(IPeopleInfo iPeopleInfo) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (iPeopleInfo.isShowInFriendsList()) {
                if (iPeopleInfo.isGroup()) {
                    eg3.j(LongFragment.this.requireContext(), WearUtils.k0(iPeopleInfo.getId()), false);
                    pj3.j(LongFragment.this.getActivity(), ChatRoomActivity.class, "roomId", iPeopleInfo.getId());
                } else if (!(iPeopleInfo instanceof OfficialAcount)) {
                    pj3.j(LongFragment.this.getActivity(), ChatActivity.class, "userId", iPeopleInfo.getId());
                } else {
                    ku1.h("Long Distance", "remote_official_account_click", "remote_official_account", String.valueOf(OfficialaCountModel.g.a().t() > 0 ? 1 : 0), null, null);
                    pj3.f(LongFragment.this.getActivity(), OfficialAccountActivity.class);
                }
            }
        }

        @Override // com.wear.adapter.longdistance.NewUserAdapter.b
        public void b(final IPeopleInfo iPeopleInfo) {
            LongFragment.this.w = new LongUserActionMenuFragmentBottom();
            Bundle bundle = new Bundle();
            bundle.putParcelable("argument_user_action_menu", LongFragment.this.e0(iPeopleInfo));
            LongFragment.this.w.setArguments(bundle);
            LongFragment.this.w.i0(new LongUserActionMenuFragmentBottom.b() { // from class: dc.g63
                @Override // com.wear.ui.longDistance.fragment.LongUserActionMenuFragmentBottom.b
                public final void a() {
                    LongFragment.b.c(iPeopleInfo);
                }
            });
            LongFragment.this.w.show(LongFragment.this.getChildFragmentManager(), "LongUserActionMenuFragmentBottom");
        }
    }

    public class c extends HashMap<String, String> {
        public c() {
            put("count", "" + ch3.i.size());
        }
    }

    public LongFragment() {
        new Handler(Looper.getMainLooper());
        this.q = new t12();
        this.v = false;
        this.B = Observable.create(new ObservableOnSubscribe() { // from class: dc.c73
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) throws Exception {
                this.a.w0(observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C1(ObservableEmitter observableEmitter) throws Exception {
        this.y = observableEmitter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E0(View view) {
        j0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E1(Object obj) throws Exception {
        String str = "notifyDataSetChanged sort,Thread=" + Thread.currentThread().getName() + this.t.b.size();
        vd3.b(this.k, this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G1(Object obj) throws Exception {
        String str = "notifyDataSetChanged -1: " + this.t.b.size();
        this.t.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J1(View view) {
        pj3.f(getContext(), ToyActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K0(View view) {
        U1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L1() {
        R();
        mk2.P().K0(true, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q0(View view) {
        m0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S0(View view) {
        m0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U0(View view) {
        m0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a1(View view) {
        P1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f1(View view) {
        ConnectionsActivity.P4(requireContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i1(IPeopleInfo iPeopleInfo, int i, View view) {
        if (iPeopleInfo.isGroup()) {
            pj3.j(getActivity(), ChatRoomActivity.class, "roomId", iPeopleInfo.getId());
        } else {
            pj3.j(getActivity(), ChatActivity.class, "userId", iPeopleInfo.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m1(View view) {
        Q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p1(View view) {
        m0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r1(int i) {
        NewUserAdapter newUserAdapter = this.t;
        if (newUserAdapter != null) {
            newUserAdapter.notifyItemChanged(i, Integer.valueOf(R.id.user_message));
            this.t.notifyItemChanged(i, Integer.valueOf(R.id.user_msg_type));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u0() {
        this.v = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v1(OfficialAcount officialAcount) {
        int iIndexOf = this.t.b.indexOf(officialAcount);
        if (officialAcount == null) {
            if (iIndexOf != -1) {
                this.t.r(iIndexOf);
            }
        } else {
            X1(officialAcount);
            if (OfficialaCountModel.g.a().k(this.t.b, officialAcount)) {
                return;
            }
            O1();
            this.r.i.F("lovenseRemoteOfficial", officialAcount.getMuteFlag());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w0(ObservableEmitter observableEmitter) throws Exception {
        this.A = observableEmitter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y1(Object obj) throws Exception {
        c0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y0() {
        if (getActivity() == null || this.s == null) {
            return;
        }
        f0();
        boolean z = this.k.size() == 0 && mu3.c == 0;
        this.loginLongDistance.setVisibility(z ? 8 : 0);
        boolean z2 = WearUtils.D;
        boolean zEquals = "zh".equals(lg3.f(WearUtils.x));
        if (!MyApplication.O) {
            this.controlRoulette.setVisibility(8);
            return;
        }
        if (z2 || zEquals || !pg3.h().j()) {
            this.controlRoulette.setVisibility(8);
            return;
        }
        this.controlRoulette.setVisibility(z ? 0 : 8);
        String str = "1111===" + z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A0(View view) {
        if (this.offlineLogin.getText().equals(ah4.e(R.string.welcome_login))) {
            l0();
        } else {
            i0();
        }
    }

    @Override // com.wear.main.BaseFragment
    public void J() {
        super.J();
        me3.c(me3.c.LONG_DISTANCE_UI_ENTER);
        ye3.c("long_distance", "into page", null);
        t("menu_longDistance", null);
        if (MyApplication.K instanceof MainActivity) {
            b0(new Object());
        }
    }

    @Override // com.wear.main.BaseFragment
    public synchronized void K(Intent intent) {
        if ("com.wear.messageTip".equals(intent.getAction())) {
            O1();
        }
    }

    public void M1(LoginOrOfflineEvent loginOrOfflineEvent) {
        if (loginOrOfflineEvent.isLogin()) {
            this.offlineLongDistance.setVisibility(8);
            this.loginLongDistance.setVisibility(0);
            this.ivSearch.setVisibility(0);
            b0(loginOrOfflineEvent);
        } else {
            this.offlineLongDistance.setVisibility(0);
            this.loginLongDistance.setVisibility(8);
            this.ivSearch.setVisibility(8);
            this.clRequest.setVisibility(8);
            LongUserActionMenuFragmentBottom longUserActionMenuFragmentBottom = this.w;
            if (longUserActionMenuFragmentBottom != null) {
                longUserActionMenuFragmentBottom.dismissAllowingStateLoss();
            }
            this.k.clear();
            this.t.notifyDataSetChanged();
            this.l.clear();
            this.m.notifyDataSetChanged();
        }
        N1();
    }

    public final void N1() {
        if (isAdded()) {
            this.u.setVisibility(8);
            if (!hf3.d(getActivity())) {
                this.u.setVisibility(0);
                this.mtvTitle.setText(ah4.e(R.string.not_connect));
                this.pbLoginIng.setVisibility(8);
                return;
            }
            if (MyApplication.Z) {
                this.pbLoginIng.setVisibility(8);
                this.mtvTitle.setText(ah4.e(R.string.system_people_text));
                return;
            }
            if (MyApplication.P) {
                this.pbLoginIng.setVisibility(8);
                if (ep1.b().c() == 1) {
                    this.pbLoginIng.setVisibility(0);
                    this.mtvTitle.setText(ah4.e(R.string.common_retrieving));
                } else if (ep1.b().c() == 2) {
                    this.mtvTitle.setText(ah4.e(R.string.system_people_text));
                }
            } else {
                this.pbLoginIng.setVisibility(0);
                this.mtvTitle.setText(ah4.e(R.string.common_connecting));
            }
            if (MyApplication.Q == 0) {
                this.u.setVisibility(0);
                this.pbLoginIng.setVisibility(8);
            }
        }
    }

    public final void O1() {
        L(new Runnable() { // from class: dc.s63
            @Override // java.lang.Runnable
            public final void run() {
                this.a.y0();
            }
        });
    }

    public final void P1() {
        if (hf3.d(getActivity())) {
            return;
        }
        hf3.e(getActivity());
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
            this.toysNumber.setVisibility(8);
            this.ivNotToy.setVisibility(0);
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < arrayListO.size(); i2++) {
            Toy toy = arrayListO.get(i2);
            if (toy != null && toy.isConnected()) {
                if (i == 0) {
                    this.rlToy1.setVisibility(0);
                    this.rlToy1.setText(toy.getToyUINameSpecialForMiniXMachine(2));
                } else {
                    this.rlToy2.setVisibility(0);
                    this.rlToy2.setText(toy.getToyUINameSpecialForMiniXMachine(2));
                }
                i++;
                this.ivNotToy.setVisibility(8);
            }
        }
        if (i == 0) {
            this.rlToy1.setVisibility(8);
            this.rlToy2.setVisibility(8);
            this.ivNotToy.setVisibility(0);
            this.toysNumber.setVisibility(8);
            return;
        }
        if (i == 1) {
            this.rlToy1.setVisibility(0);
            this.rlToy2.setVisibility(8);
            this.toysNumber.setVisibility(8);
        } else if (i == 2) {
            this.rlToy1.setVisibility(0);
            this.rlToy2.setVisibility(0);
            this.toysNumber.setVisibility(8);
        } else {
            this.rlToy1.setVisibility(8);
            this.rlToy2.setVisibility(8);
            this.toysNumber.setOnClickListener(new View.OnClickListener() { // from class: dc.w63
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.J1(view);
                }
            });
            this.toysNumber.setVisibility(0);
            this.toysNumber.setText(String.format(ah4.c(R.string.multiple_toys), Integer.valueOf(i)));
        }
    }

    public final void Q1() {
        kn3 kn3Var = new kn3((Context) getActivity(), String.format(ah4.e(R.string.lan_api_stop), MyApplication.G.getTransPf()), ah4.e(R.string.common_ok), ah4.e(R.string.common_cancel), true, (kn3.d) new a());
        kn3Var.show();
        kn3Var.p();
    }

    public final void R1(View view) {
        if (WearUtils.y.u() == null) {
            V(R.string.common_login_first);
        } else {
            new hg3().h(this.ivNotToy, getContext());
        }
    }

    public final void T1() {
        this.y.onNext(new Object());
    }

    public final void U1() {
        if (!TextUtils.equals("1", mk2.P().V())) {
            mk2.P().K0(true, 1);
            return;
        }
        is3.b bVar = new is3.b(getContext());
        bVar.p(mk2.P().O());
        bVar.o(ah4.e(R.string.common_yes));
        bVar.d(new is3.d() { // from class: dc.j63
            @Override // dc.is3.d
            public final void doConfirm() {
                this.a.L1();
            }
        });
        cs3.h(bVar).show();
    }

    public final void X1(OfficialAcount officialAcount) {
        if (getActivity() == null || !(getActivity() instanceof MainActivity)) {
            return;
        }
        if (officialAcount.getMuteFlag() < 1) {
            ((MainActivity) getActivity()).w8(officialAcount.getUnreadMessagesNumber());
        } else {
            ((MainActivity) getActivity()).w8(0);
        }
    }

    public final void b0(Object obj) {
        this.A.onNext(obj);
    }

    public final void c0() {
        Map<String, IPeopleInfo> mapH = WearUtils.y.h();
        ch3.i.clear();
        int iF = df3.e().f();
        if (mapH.size() != 0) {
            iF = 0;
        }
        for (String str : mapH.keySet()) {
            IPeopleInfo iPeopleInfo = mapH.get(str);
            if (iPeopleInfo != null && (!TextUtils.isEmpty(iPeopleInfo.getUserName()) || !TextUtils.isEmpty(iPeopleInfo.getAvatar()))) {
                UserSettingsBean userSettingsBeanG = WearUtils.x.i.g(WearUtils.j0(iPeopleInfo.getId()));
                if (userSettingsBeanG != null) {
                    if (userSettingsBeanG.getSetTop() > 0) {
                        iPeopleInfo.setSetTop(userSettingsBeanG.getSetTop());
                    } else {
                        iPeopleInfo.setSetTop(0L);
                    }
                    if (WearUtils.e1(userSettingsBeanG.getRemark()) || WearUtils.e1(userSettingsBeanG.getRemark().trim())) {
                        iPeopleInfo.setRemark("");
                    } else {
                        iPeopleInfo.setRemark(userSettingsBeanG.getRemark().trim());
                    }
                }
                for (User user : new ArrayList(ch3.j)) {
                    if (ch3.i.contains(user) && user.isFriend()) {
                        synchronized (ch3.h) {
                            ch3.j.remove(user);
                            int i = mu3.c;
                            if (i > 0) {
                                mu3.c = i - 1;
                            } else if (i < 0) {
                                mu3.c = 0;
                            }
                            UserSetting userSettingZ = WearUtils.y.z(user.getId());
                            userSettingZ.setFriendsRequestClick(false);
                            DaoUtils.getUserSettingDao().update((UserSettingDao) userSettingZ);
                        }
                    }
                }
                if (!ch3.i.contains(iPeopleInfo) && iPeopleInfo.isShowInFriendsList()) {
                    if (!WearUtils.x.i.k(WearUtils.j0(str))) {
                        if (!WearUtils.w1(iPeopleInfo.getId())) {
                            ch3.i.add(iPeopleInfo);
                        }
                    }
                }
                iF += df3.e().g(str);
            }
        }
        zb2.O().Q0(new ArrayList(ch3.i), this);
        int i2 = mu3.c;
        df3.e().n(iF);
        LocalBroadcastManager.getInstance(WearUtils.x).sendBroadcast(new Intent("com.wear.messageTip"));
        O1();
        N1();
        if (((Boolean) eg3.b(this.r, "crash_handler", Boolean.FALSE)).booleanValue()) {
            eg3.m(this.r, "crash_handler");
        }
        ch3.n().Q();
        ch3.n().N();
        String avatar = "";
        synchronized (ch3.h) {
            Iterator<User> it = ch3.j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                User next = it.next();
                UserSetting userSettingZ2 = WearUtils.y.z(next.getId());
                if (!this.r.i.q(WearUtils.i0(next.getId())) && !userSettingZ2.isFriendsRequestClick()) {
                    avatar = next.getAvatar();
                    break;
                }
            }
        }
        d0(i2, avatar);
    }

    @Override // dc.yb2
    public void d() {
        O1();
    }

    public final void d0(int i, String str) {
        if (i <= 0) {
            this.clRequest.setVisibility(8);
            return;
        }
        this.clRequest.setVisibility(0);
        this.tvRequestCount.setText("" + i);
        if (TextUtils.isEmpty(str)) {
            this.rivRequestPhoto.setImageResource(R.drawable.icon_default_new);
            return;
        }
        if (!str.startsWith("http")) {
            str = WearUtils.e + str;
        }
        kf.y(this).v(str).h(R.drawable.icon_default_new).a(this.n).A0(this.rivRequestPhoto);
    }

    public final UserActionMenuBean e0(IPeopleInfo iPeopleInfo) {
        int i = iPeopleInfo.isGroup() ? 1 : iPeopleInfo instanceof OfficialAcount ? 2 : 0;
        UserActionMenuBean userActionMenuBean = new UserActionMenuBean(iPeopleInfo.getId(), iPeopleInfo.getShowNickName(), i == 1 ? ((Group) iPeopleInfo).getUrl() : iPeopleInfo.getAvatar(), i);
        if (iPeopleInfo instanceof Group) {
            userActionMenuBean.setLeaveGroup(iPeopleInfo.isExit());
        }
        return userActionMenuBean;
    }

    public final void f0() {
        OfficialAcount officialAcountP;
        this.k.clear();
        if (ch3.i.size() > 0) {
            for (IPeopleInfo iPeopleInfo : ch3.i) {
                if (iPeopleInfo instanceof User) {
                    ((User) iPeopleInfo).setTyping(false);
                }
            }
        }
        this.k.addAll(ch3.i);
        if (MyApplication.O && (officialAcountP = OfficialaCountModel.g.a().p()) != null && !this.k.contains(officialAcountP)) {
            this.k.add(officialAcountP);
        }
        T1();
        this.l.clear();
        for (IPeopleInfo iPeopleInfo2 : this.k) {
            if (iPeopleInfo2 != null && !iPeopleInfo2.isGroup() && iPeopleInfo2.isOnline()) {
                this.l.add(iPeopleInfo2);
            }
        }
        if (this.k.size() <= 10 || this.l.size() <= 0) {
            this.rvOnline.setVisibility(8);
        } else {
            this.rvOnline.setVisibility(0);
        }
        this.m.notifyDataSetChanged();
    }

    public final void g0() {
        if (!WearUtils.e1(zd3.b(MyApplication.N(), "xmpp_password"))) {
            this.offlineLongDistance.setVisibility(8);
            this.ivSearch.setVisibility(0);
            return;
        }
        this.offlineLongDistance.setVisibility(0);
        this.controlRoulette.setVisibility(8);
        this.loginLongDistance.setVisibility(8);
        this.ivSearch.setVisibility(8);
        this.clRequest.setVisibility(8);
        this.offlineLogin.setText(ah4.e(R.string.welcome_login));
        this.longDistanceDes.setText(ah4.e(R.string.long_distance_des2));
    }

    public final void h0(View view) {
        this.s = (RecyclerView) view.findViewById(R.id.people_list);
        this.k.clear();
        this.n = new qo().h(R.drawable.icon_default_new).X(R.drawable.icon_default_new);
        this.t = new NewUserAdapter(this.k, R.layout.long_user_item);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.o = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.s.setLayoutManager(this.o);
        this.s.setAdapter(this.t);
        this.t.H(new b());
    }

    public final void i0() {
        if (MyApplication.Z) {
            V(R.string.offline_add_people);
            return;
        }
        WearUtils.x.q("longDistance_add_friend", new c());
        Intent intent = new Intent(getActivity(), (Class<?>) AddFriendActivity.class);
        pj3.d(intent);
        getActivity().startActivity(intent);
    }

    public final void j0() {
        EventBus.getDefault().post(DiscoverRouletteNewTagHiddenEvent.INSTANCE);
        ToyRouletteActivity.b.a(requireContext());
        ku1.f("Long Distance", "long_distance_control_roulette_click", "long_distance_control_roulette", "control roulette", "control roulette", null);
    }

    public final void k0() {
        Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(requireActivity(), this.mLlSearch, "editTransition").toBundle();
        if (bundle == null) {
            bundle = new Bundle();
        }
        FriendsSearchSingleActivity.t4(requireContext(), bundle);
    }

    public final void l0() {
        pj3.t(getActivity(), LoginActivity.class, 1);
    }

    public final void m0() {
        pj3.f(getActivity(), ToyActivity.class);
    }

    public void n0() {
        if (!this.v) {
            new Handler().postDelayed(new Runnable() { // from class: dc.i63
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.u0();
                }
            }, 500L);
            this.v = true;
        } else if (isAdded()) {
            for (int i = 0; i < this.k.size(); i++) {
                if (!WearUtils.e1(this.k.get(i).getId()) && df3.e().g(this.k.get(i).getId()) > 0 && this.k.get(i).isFriend()) {
                    this.o.scrollToPositionWithOffset(i, 0);
                    return;
                }
            }
        }
    }

    @Override // com.wear.main.BaseFragment, dc.cs3.b
    public void onCancel() {
        super.onCancel();
        ep1.b().m(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onClearMessageEvent(ClearAllMessageEvent clearAllMessageEvent) {
        df3.e().j();
        df3.e().n(0);
        if (this.t != null) {
            T1();
        }
    }

    public final void onClick(View view) {
        k0();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        MyApplication myApplication = WearUtils.x;
        this.r = myApplication;
        M(myApplication);
        View viewInflate = layoutInflater.inflate(R.layout.long_fragment, (ViewGroup) null, false);
        ButterKnife.bind(this, viewInflate);
        g0();
        this.offlineLogin.setOnClickListener(new View.OnClickListener() { // from class: dc.z63
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.A0(view);
            }
        });
        this.btnAdd.setOnClickListener(new View.OnClickListener() { // from class: dc.t63
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.R1(view);
            }
        });
        this.controlRoulette.setOnClickListener(new View.OnClickListener() { // from class: dc.f73
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.E0(view);
            }
        });
        this.ivNotToy.setOnClickListener(new View.OnClickListener() { // from class: dc.b73
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Q0(view);
            }
        });
        this.rlToy1.setOnClickListener(new View.OnClickListener() { // from class: dc.d73
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.S0(view);
            }
        });
        this.rlToy2.setOnClickListener(new View.OnClickListener() { // from class: dc.p63
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.U0(view);
            }
        });
        this.mLlSearch.setOnClickListener(new View.OnClickListener() { // from class: dc.u63
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.onClick(view);
            }
        });
        h0(viewInflate);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.xmpp_connect_status_layout);
        this.u = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: dc.y63
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.a1(view);
            }
        });
        this.ivSearch.setOnClickListener(new View.OnClickListener() { // from class: dc.e73
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.f1(view);
            }
        });
        ep1.b().o(this);
        N1();
        FriendShowOnLineAdapter friendShowOnLineAdapter = new FriendShowOnLineAdapter(this.l, R.layout.item_friends_show_online);
        this.m = friendShowOnLineAdapter;
        cg3.d(this.rvOnline, friendShowOnLineAdapter);
        this.m.s(new BaseAdapter.b() { // from class: dc.a73
            @Override // com.wear.adapter.BaseAdapter.b
            public final void a0(Object obj, int i, View view) {
                this.a.i1((IPeopleInfo) obj, i, view);
            }
        });
        this.lanApiControlStop.setOnClickListener(new View.OnClickListener() { // from class: dc.k63
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.m1(view);
            }
        });
        this.lanApiControlUpdate.setOnClickListener(new View.OnClickListener() { // from class: dc.v63
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.p1(view);
            }
        });
        this.tvVideoPatternControlUnsync.setOnClickListener(new View.OnClickListener() { // from class: dc.m63
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.K0(view);
            }
        });
        this.clRequest.setOnClickListener(new View.OnClickListener() { // from class: dc.r63
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConnectionsActivity.P4(view.getContext());
            }
        });
        EventBus.getDefault().register(this);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
        Disposable disposable = this.z;
        if (disposable != null && !disposable.isDisposed()) {
            this.z.dispose();
        }
        Disposable disposable2 = this.x;
        if (disposable2 == null || disposable2.isDisposed()) {
            return;
        }
        this.x.dispose();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(LoginStatusActionEvent loginStatusActionEvent) {
        O1();
        N1();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.p = true;
        super.onPause();
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.p = false;
        if (!MyApplication.Z) {
            b0(new Object());
            if (ff2.d && ff2.e && MyApplication.G != null) {
                this.tvLanApiPlatform.setText(String.format(ah4.e(R.string.lan_api_control), MyApplication.G.getTransPf()));
                this.lanApiControl.setVisibility(0);
                if (ve3.d().e()) {
                    this.lanApiControlUpdate.setVisibility(0);
                } else {
                    this.lanApiControlUpdate.setVisibility(8);
                }
            } else {
                this.lanApiControl.setVisibility(8);
            }
            if (!mk2.P().h0() || getContext() == null) {
                this.llVideoPatternControl.setVisibility(8);
            } else {
                this.tvVideoPatternControlTip.setText(mk2.P().S(getContext()));
                this.llVideoPatternControl.setVisibility(0);
            }
            if (OfficialaCountModel.g.a().t() > 0) {
                ku1.i("Long Distance", "remote_official_account_exposure", "exposure", "remote_official_account", null);
            }
        }
        if (MyApplication.O) {
            OfficialaCountModel.g.a().H(true);
        }
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        OfficialaCountModel.g.a().o().observe(getViewLifecycleOwner(), new Observer() { // from class: dc.n63
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.a.v1((OfficialAcount) obj);
            }
        });
        this.z = this.B.debounce(1L, TimeUnit.SECONDS, AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: dc.o63
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.a.y1(obj);
            }
        });
        this.x = Observable.create(new ObservableOnSubscribe() { // from class: dc.q63
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) throws Exception {
                this.a.C1(observableEmitter);
            }
        }).debounce(500L, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).observeOn(Schedulers.computation()).doOnNext(new Consumer() { // from class: dc.x63
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.a.E1(obj);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: dc.h63
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.a.G1(obj);
            }
        });
    }

    @Override // dc.ep1.b
    public void r(int i) {
        L(new Runnable() { // from class: dc.l63
            @Override // java.lang.Runnable
            public final void run() {
                this.a.N1();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(f42 f42Var) {
        if (f42Var != null) {
            this.t.notifyDataSetChanged();
            this.m.notifyDataSetChanged();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(CommunMessage communMessage) {
        IPeopleInfo next;
        String strG0 = WearUtils.g0(communMessage.getFrom());
        Iterator<IPeopleInfo> it = ch3.i.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next.getId().equals(strG0)) {
                next.setLastMessage(communMessage);
                break;
            }
        }
        if (next != null) {
            O1();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(TypingEvent typingEvent) {
        List<TypingBean> list;
        List<IPeopleInfo> list2 = this.k;
        if (list2 == null || list2.size() <= 0 || (list = ch3.k) == null || list.size() <= 0) {
            return;
        }
        for (final int i = 0; i < this.k.size(); i++) {
            for (TypingBean typingBean : ch3.k) {
                IPeopleInfo iPeopleInfo = this.k.get(i);
                if (iPeopleInfo instanceof User) {
                    User user = (User) iPeopleInfo;
                    if (TextUtils.equals(typingBean.getFromJid(), user.getUserJid()) && user.isTyping() != typingBean.isTyping()) {
                        user.setTyping(typingBean.isTyping());
                        L(new Runnable() { // from class: dc.f63
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.r1(i);
                            }
                        });
                    }
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(UserUpdateEvent userUpdateEvent) {
        if (this.p || !(MyApplication.K instanceof MainActivity)) {
            return;
        }
        b0(userUpdateEvent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(AddFriendsRefreshList addFriendsRefreshList) {
        b0(addFriendsRefreshList);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(LanApiControlEvent lanApiControlEvent) {
        ScanQRDataBean scanQRDataBean;
        if (lanApiControlEvent.isOpen()) {
            if (ff2.d && ff2.e && (scanQRDataBean = MyApplication.G) != null) {
                String transPf = scanQRDataBean.getTransPf();
                if (WearUtils.e1(transPf)) {
                    return;
                }
                this.tvLanApiPlatform.setText(String.format(ah4.e(R.string.lan_api_control), transPf));
                this.lanApiControl.setVisibility(0);
                if (ve3.d().e()) {
                    this.lanApiControlUpdate.setVisibility(0);
                    return;
                } else {
                    this.lanApiControlUpdate.setVisibility(8);
                    return;
                }
            }
            this.lanApiControl.setVisibility(8);
            return;
        }
        this.lanApiControl.setVisibility(8);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(VideoPatternControlEvent videoPatternControlEvent) {
        if (videoPatternControlEvent.getType() != 2 && videoPatternControlEvent.getType() != 4) {
            if (videoPatternControlEvent.getType() == 3) {
                y();
                if (videoPatternControlEvent.isSuccess()) {
                    this.llVideoPatternControl.setVisibility(8);
                    return;
                }
                return;
            }
            return;
        }
        if (videoPatternControlEvent.isSuccess()) {
            this.llVideoPatternControl.setVisibility(0);
            this.tvVideoPatternControlTip.setText(mk2.P().S(getContext()));
            this.tvVideoPatternControlUnsync.setText(mk2.P().U(getContext()));
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(AddFriendsRequestEvent addFriendsRequestEvent) {
        User user;
        String avatar;
        if (addFriendsRequestEvent == null || (user = addFriendsRequestEvent.user) == null) {
            return;
        }
        int i = addFriendsRequestEvent.flag;
        if (i == 2) {
            d0(mu3.c, user.getAvatar());
            return;
        }
        if (i == 3) {
            UserSetting userSettingZ = WearUtils.y.z(user.getId());
            if (this.r.i.q(WearUtils.i0(addFriendsRequestEvent.user.getId())) || userSettingZ.isFriendsRequestClick()) {
                return;
            }
            int i2 = mu3.c - 1;
            mu3.c = i2;
            avatar = "";
            if (i2 > 0) {
                synchronized (ch3.h) {
                    int size = ch3.j.size();
                    avatar = size > 0 ? ch3.j.get(size - 1).getAvatar() : "";
                }
            }
            d0(i2, avatar);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(xc1 xc1Var) {
        Q();
    }
}
