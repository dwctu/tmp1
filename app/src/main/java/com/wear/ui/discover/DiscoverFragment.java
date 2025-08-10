package com.wear.ui.discover;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.lovense.wear.R;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import com.wear.bean.AdListBean;
import com.wear.bean.EntryPoint;
import com.wear.bean.ThemeChangeEvent;
import com.wear.bean.Toy;
import com.wear.bean.WishListContribution;
import com.wear.bean.data.ChatGPTConfigData;
import com.wear.bean.event.ChangeDiscoverEvent;
import com.wear.bean.event.DiscoverRouletteNewTagHiddenEvent;
import com.wear.bean.event.DownloadModelEvent;
import com.wear.bean.event.GiftCardEvent;
import com.wear.bean.event.LoginOrOfflineEvent;
import com.wear.bean.event.LoginStatusActionEvent;
import com.wear.bean.event.SetSyncCommonDataEvent;
import com.wear.bean.event.WishListDisappearRedDotEvent;
import com.wear.bean.response.BaseResponseStringBean;
import com.wear.main.BaseFragment;
import com.wear.main.MainActivity;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.closeRange.alarm.AlarmListActivity;
import com.wear.main.game.ui.NewGameModeActivity;
import com.wear.main.longDistance.control.ChatVideoControl;
import com.wear.main.longDistance.controllink.ControlLinkIntroduceActivity;
import com.wear.main.longDistance.controllink.ControlLinkNewActivity;
import com.wear.main.toy.ToyActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.ui.discover.chatgpt.ChatGPTActivity;
import com.wear.ui.discover.gaming.GalleryListActivity;
import com.wear.ui.discover.giftCard.GiftCardActivity;
import com.wear.ui.discover.pattern.PatternStoreActivity;
import com.wear.ui.discover.roulette.ToyRouletteActivity;
import com.wear.ui.discover.speedMode.SpeedModeActivity;
import com.wear.ui.discover.speedMode.SpeedModeControl;
import com.wear.ui.discover.speedMode.SpeedModeGuideActivity;
import com.wear.ui.discover.voicecontrol.VoiceControlActivity;
import com.wear.ui.discover.wishlist.WishListCreatGuildActivity;
import com.wear.ui.discover.wishlist.WishListViewActivity;
import com.wear.ui.home.sound.SoundPlayActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.vibematevideo.ui.InteractiveVideoActivity;
import com.wear.widget.dialog.SpeedModeTipDialog;
import dc.ah4;
import dc.be3;
import dc.cm2;
import dc.cs3;
import dc.eg3;
import dc.hg3;
import dc.is3;
import dc.ke3;
import dc.kf;
import dc.ku1;
import dc.lg3;
import dc.ll3;
import dc.me3;
import dc.mf3;
import dc.mk3;
import dc.na2;
import dc.nk3;
import dc.pg3;
import dc.pj3;
import dc.sg3;
import dc.sk3;
import dc.tn2;
import dc.we3;
import dc.x03;
import dc.xc1;
import dc.y12;
import dc.ye3;
import dc.yn2;
import dc.yo2;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class DiscoverFragment extends BaseFragment<cm2, yo2> implements yo2 {

    @BindView(R.id.app_bar_layout)
    public AppBarLayout appBarLayout;

    @BindView(R.id.coordinator_layout)
    public CoordinatorLayout coordinatorLayout;

    @BindView(R.id.cpv_download_progress)
    public CircularProgressBar downloadProgress;

    @BindView(R.id.game_mode_layout)
    public LinearLayout game_mode_layout;

    @BindView(R.id.gaming_layout)
    public RelativeLayout gaming_layout;

    @BindView(R.id.gaming_new)
    public TextView gaming_new;

    @BindView(R.id.gift_card_contribute_text)
    public TextView giftCardContributeText;

    @BindView(R.id.gift_card_red_dot_layout)
    public RelativeLayout giftCardRedDotLayout;

    @BindView(R.id.gift_card_icon)
    public ImageView gift_card_icon;

    @BindView(R.id.iv_download_error)
    public ImageView ivDownloadError;

    @BindView(R.id.iv_not_toy)
    public ImageView ivNotToy;

    @BindView(R.id.iv_discover_banner)
    public ImageView iv_discover_banner;

    @BindView(R.id.iv_discover_banner_low)
    public ImageView iv_discover_banner_low;
    public MyApplication k;
    public cm2 l;

    @BindView(R.id.ll_discover)
    public LinearLayout llDiscover;

    @BindView(R.id.ll_discover_list)
    public LinearLayout ll_discover_list;

    @BindView(R.id.ll_toy)
    public RelativeLayout ll_toy;
    public View m;

    @BindView(R.id.alarm_layout)
    public LinearLayout mLlAlarmLayout;

    @BindView(R.id.sound_layout)
    public LinearLayout mLlSoundLayout;

    @BindView(R.id.nsv_discover)
    public NestedScrollView nestedScrollView;
    public int q;
    public boolean r;

    @BindView(R.id.wish_list_red_dot_layout)
    public RelativeLayout red_dot_layout;

    @BindView(R.id.rl_toy_1)
    public TextView rlToy1;

    @BindView(R.id.rl_toy_2)
    public TextView rlToy2;

    @BindView(R.id.rl_chat_gpt)
    public RelativeLayout rl_chat_gpt;

    @BindView(R.id.rl_mall)
    public RelativeLayout rl_mall;

    @BindView(R.id.roulette_layout)
    public RelativeLayout rouletteLayout;

    @BindView(R.id.title_add)
    public ImageView titleAdd;

    @BindView(R.id.toys_number_text)
    public TextView toysNumber;

    @BindView(R.id.tv_download_progress)
    public TextView tvDownloadProgress;

    @BindView(R.id.tv_title)
    public TextView tvTitle;

    @BindView(R.id.tv_pattern_special)
    public TextView tv_pattern_special;

    @BindView(R.id.videos_icon)
    public ImageView videosIcon;

    @BindView(R.id.videos_layout)
    public RelativeLayout videosLayout;

    @BindView(R.id.videos_new_count)
    public TextView videosNewCount;

    @BindView(R.id.voice_control)
    public View voiceControl;

    @BindView(R.id.wish_list_layout)
    public LinearLayout wishListLayout;

    @BindView(R.id.wish_list_contribute_text)
    public TextView wish_list_contribute_text;
    public boolean x;
    public List<AdListBean.DataBean> n = new ArrayList();
    public int o = -1;
    public boolean p = false;
    public final Handler s = new a(Looper.getMainLooper());
    public final x03.a t = new b();
    public boolean u = true;
    public boolean v = mf3.a.booleanValue();
    public WishListContribution w = null;
    public int y = 0;
    public AdListBean.DataBean z = new AdListBean.DataBean();
    public int A = -1;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                DiscoverFragment.this.ivDownloadError.setVisibility(8);
                DiscoverFragment.this.downloadProgress.setVisibility(0);
                DiscoverFragment.this.tvDownloadProgress.setVisibility(0);
                return;
            }
            if (i != 2) {
                if (i == 3) {
                    DiscoverFragment.this.r = true;
                    return;
                } else {
                    if (i != 4) {
                        return;
                    }
                    DiscoverFragment.this.tvDownloadProgress.setVisibility(8);
                    DiscoverFragment.this.ivDownloadError.setVisibility(0);
                    return;
                }
            }
            int i2 = message.arg1;
            DiscoverFragment.this.downloadProgress.setProgress(i2);
            DiscoverFragment.this.tvDownloadProgress.setText(i2 + "%");
        }
    }

    public class b implements x03.a {
        public b() {
        }

        @Override // dc.x03.a
        public void a(int i) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 2;
            messageObtain.arg1 = i;
            DiscoverFragment.this.s.sendMessage(messageObtain);
        }

        @Override // dc.x03.a
        public void onComplete() {
            DiscoverFragment.this.s.sendEmptyMessage(3);
        }

        @Override // dc.x03.a
        public void onError(String str) {
            DiscoverFragment.this.s.sendEmptyMessage(4);
        }

        @Override // dc.x03.a
        public void onStart() {
            DiscoverFragment.this.s.sendEmptyMessage(1);
        }
    }

    public class c implements yn2<AdListBean> {
        public c() {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(AdListBean adListBean) {
            try {
                DiscoverFragment.this.q = 0;
                if (adListBean == null || WearUtils.g1(adListBean.getData())) {
                    DiscoverFragment.this.iv_discover_banner.setVisibility(8);
                    DiscoverFragment.this.iv_discover_banner_low.setVisibility(8);
                    DiscoverFragment.this.tvTitle.setAlpha(1.0f);
                    DiscoverFragment.this.a1();
                    return;
                }
                List<AdListBean.DataBean> list = DiscoverFragment.this.n;
                if (list != null && !list.isEmpty()) {
                    DiscoverFragment.this.n.clear();
                }
                String str = "获取到的广告数据" + adListBean.getData().size();
                DiscoverFragment.this.n = adListBean.getData();
                DiscoverFragment.this.g1(true);
            } catch (Exception e) {
                DiscoverFragment.this.iv_discover_banner.setVisibility(8);
                DiscoverFragment.this.iv_discover_banner_low.setVisibility(8);
                DiscoverFragment.this.tvTitle.setAlpha(1.0f);
                DiscoverFragment.this.a1();
                e.printStackTrace();
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            try {
                DiscoverFragment.this.iv_discover_banner.setVisibility(8);
                DiscoverFragment.this.iv_discover_banner_low.setVisibility(8);
                DiscoverFragment.this.a1();
                DiscoverFragment.this.tvTitle.setAlpha(1.0f);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public class d implements AppBarLayout.OnOffsetChangedListener {
        public d() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float fAbs = Math.abs(i) / appBarLayout.getTotalScrollRange();
            float f = 1.0f - fAbs;
            appBarLayout.setAlpha(f);
            DiscoverFragment.this.iv_discover_banner.setAlpha(f);
            DiscoverFragment.this.tvTitle.setAlpha(fAbs);
        }
    }

    public class e implements is3.d {
        public e() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            na2.m().w();
            ChatVideoControl.a1().X0(true, false, false);
            pj3.f(DiscoverFragment.this.getActivity(), NewGameModeActivity.class);
            DiscoverFragment.this.d0();
        }
    }

    public class f implements yn2<BaseResponseStringBean> {
        public f() {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseStringBean baseResponseStringBean) {
        }

        @Override // dc.yn2
        public void onCompleted() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            DiscoverFragment.this.p1();
            DiscoverFragment.this.y();
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            sg3.k(DiscoverFragment.this.getActivity(), netException.getMessage());
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E0(View view) {
        if (MyApplication.P) {
            return;
        }
        pj3.f(getContext(), LoginActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K0(View view) {
        ye3.d("M0005", "");
        if (!this.w.isWishList()) {
            pj3.f(getContext(), WishListCreatGuildActivity.class);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("contribute_num", this.w.getNewContributionsCount());
        pj3.g(getContext(), WishListViewActivity.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P0(View view) {
        if (MyApplication.P) {
            return;
        }
        pj3.f(getContext(), LoginActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R0() {
        if (MyApplication.P) {
            this.l.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T0(View view) {
        pj3.f(getContext(), ToyActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l0(List list, View view) {
        ku1.a("Discover", "discover_dynamic_ads_click", "click", "discover_dynamic_ads", "picture", "", ((AdListBean.DataBean) list.get(this.o)).getId(), null);
        if (WearUtils.e1(((AdListBean.DataBean) list.get(this.o)).getCommand()) || this.tvTitle.getAlpha() == 1.0f) {
            return;
        }
        we3.q(getActivity(), ((AdListBean.DataBean) list.get(this.o)).getCommand(), EntryPoint.Discover);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r0(View view) {
        if (WearUtils.y.u() == null) {
            V(R.string.common_login_first);
        } else {
            new hg3().h(this.ivNotToy, getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u0(View view) {
        pj3.f(getActivity(), ToyActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w0(View view) {
        pj3.f(getActivity(), ToyActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y0(View view) {
        pj3.f(getActivity(), ToyActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A0(View view) {
        if (MyApplication.P) {
            return;
        }
        pj3.f(getContext(), LoginActivity.class);
    }

    @Override // com.wear.main.BaseFragment
    public void D() {
        super.D();
        this.g.d(this);
        this.h = this.l;
    }

    @Override // dc.yo2
    public void G0(WishListContribution wishListContribution) {
        this.w = wishListContribution;
        this.u = !wishListContribution.isWishList();
        this.wishListLayout.setEnabled(true);
        this.wishListLayout.setOnClickListener(new View.OnClickListener() { // from class: dc.iv2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.K0(view);
            }
        });
        String str = wishListContribution.getNewContributionsCount() + "";
        if (wishListContribution.getNewContributionsCount() > 99) {
            str = "99+";
        }
        if (wishListContribution.getNewContributionsCount() > 0) {
            this.red_dot_layout.setVisibility(0);
        } else {
            this.red_dot_layout.setVisibility(8);
        }
        this.wish_list_contribute_text.setText(str);
        l1(true);
    }

    @Override // com.wear.main.BaseFragment
    public void I() {
    }

    @Override // com.wear.main.BaseFragment
    public void J() {
        me3.c(me3.c.DISCOVER_UI_ENTER);
        t("menu_discover", null);
        ye3.c("discover", "into page", null);
        ll3.E().e0("Discover", "open", null, null, null);
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
        } else {
            if (i == 2) {
                this.rlToy1.setVisibility(0);
                this.rlToy2.setVisibility(0);
                this.toysNumber.setVisibility(8);
                return;
            }
            this.rlToy1.setVisibility(8);
            this.rlToy2.setVisibility(8);
            this.toysNumber.setVisibility(0);
            this.toysNumber.setOnClickListener(new View.OnClickListener() { // from class: dc.bv2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.T0(view);
                }
            });
            this.toysNumber.setText(String.format(ah4.c(R.string.multiple_toys), Integer.valueOf(i)));
        }
    }

    public void U0(LoginOrOfflineEvent loginOrOfflineEvent) {
        if (isAdded()) {
            f0();
        }
    }

    public final void W0() {
        ll3.E().e0("Discover", "click", "", null, this.videosNewCount.getVisibility() == 0 ? "1" : "0");
    }

    public final void a1() {
        if (getContext() == null) {
            return;
        }
        if (this.x) {
            ku1.a("Discover", "voice_control_entrance_exposure", "exposure", "voice_control_entrance", "button", "1", null, null);
            this.voiceControl.setVisibility(0);
            return;
        }
        boolean zEquals = "en".equals(lg3.f(WearUtils.x));
        if (j0() && zEquals) {
            ku1.a("Discover", "voice_control_entrance_exposure", "exposure", "voice_control_entrance", "button", "1", null, null);
            this.voiceControl.setVisibility(0);
            this.x = true;
        }
    }

    public final void c1() {
        this.tv_pattern_special.setVisibility(8);
        this.gift_card_icon.setVisibility(0);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void changeDiscoverEvent(ChangeDiscoverEvent changeDiscoverEvent) {
        if (be3.D()) {
            q1();
        } else {
            c1();
        }
    }

    public final void d0() {
        ye3.i("Discover", "discover_game_mode_click", "click", "game_mode", "button");
    }

    public final void e0() {
        TextView textView = this.videosNewCount;
        mk3 mk3Var = mk3.a;
        textView.setVisibility(mk3Var.v() ? 0 : 8);
        this.videosNewCount.setText("+" + mk3Var.j());
    }

    public final void f0() {
        try {
            if (this.m == null) {
                FirebaseCrashlytics.getInstance().recordException(new Throwable("view is null"));
                return;
            }
            String strC = lg3.c(lg3.e(WearUtils.x));
            TimeZone timeZone = TimeZone.getDefault();
            tn2.x(WearUtils.x).d("/wear/ad/list?version=" + WearUtils.q + "&pf=android&lang=" + strC + "&userTimezoneUtcOffset=" + timeZone.getOffset(Calendar.getInstance(timeZone).getTimeInMillis()), new c());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public final void n0() {
        HashMap map = new HashMap();
        map.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, ye3.s());
        map.put("appType", "Remote");
        map.put("mobileType", "1");
        map.put("systemType", Build.VERSION.SDK_INT + "");
        map.put(RemoteConfigConstants.RequestFieldKey.APP_ID, eg3.h(getActivity(), "log_session", ""));
        map.put("isAgree", "1");
        map.put("offlineEmail", "");
        tn2.x(getActivity()).p("/speedmode/saveUserAgreeAgreement", map, new f());
    }

    public final int g0(boolean z) {
        return ((MyApplication.m0 == 0 && MyApplication.l0) || MyApplication.m0 == 2) ? z ? R.drawable.discover_gift_selector : R.drawable.discover_item_selector : z ? R.drawable.discover_gift_light_selector : R.drawable.discover_item_light_selector;
    }

    public final void g1(boolean z) {
        if (z) {
            List<AdListBean.DataBean> list = this.n;
            if (list != null && !list.isEmpty() && !WearUtils.s1()) {
                Iterator<AdListBean.DataBean> it = this.n.iterator();
                while (it.hasNext()) {
                    if ("x26vvHwmCzesfIrnLNaAAw".equals(it.next().getId())) {
                        it.remove();
                    }
                }
            }
        } else if (WearUtils.s1()) {
            AdListBean.DataBean dataBean = this.z;
            if (dataBean != null && !WearUtils.e1(dataBean.getId())) {
                int i = this.A;
                if (i != -1) {
                    this.n.add(i, this.z);
                } else {
                    this.n.add(this.z);
                }
            }
        } else {
            Iterator<AdListBean.DataBean> it2 = this.n.iterator();
            while (it2.hasNext()) {
                AdListBean.DataBean next = it2.next();
                if ("x26vvHwmCzesfIrnLNaAAw".equals(next.getId())) {
                    this.A = this.n.indexOf(next);
                    this.z = next;
                    it2.remove();
                }
            }
        }
        List<AdListBean.DataBean> list2 = this.n;
        if (list2 != null) {
            if (list2.isEmpty()) {
                this.p = false;
                this.iv_discover_banner.setVisibility(8);
                this.iv_discover_banner_low.setVisibility(8);
                a1();
                this.tvTitle.setAlpha(1.0f);
                this.nestedScrollView.scrollTo(0, 0);
                return;
            }
            this.o = 0;
            this.p = true;
            this.iv_discover_banner.setVisibility(0);
            this.iv_discover_banner_low.setVisibility(0);
            a1();
            h0(this.n);
        }
    }

    @Override // dc.yo2
    public void g3() {
        this.c.removeCallbacksAndMessages(null);
        this.c.postDelayed(new Runnable() { // from class: dc.gv2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.R0();
            }
        }, 5000L);
    }

    public final void h0(final List<AdListBean.DataBean> list) {
        String str = "list的长度" + list.size();
        String str2 = "count===" + this.o;
        if (WearUtils.g1(list) || this.o == -1) {
            return;
        }
        String dark = WearUtils.Y0() ? list.get(this.o).getSource().getDark() : list.get(this.o).getSource().getLight();
        String str3 = "adsUrl===" + dark;
        String str4 = "MyApplication.statusBarFlag===" + MyApplication.m0;
        kf.w(requireContext()).v(dark).A0(this.iv_discover_banner);
        this.iv_discover_banner.setOnClickListener(new View.OnClickListener() { // from class: dc.hv2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.l0(list, view);
            }
        });
    }

    public final void i0() {
        f0();
        this.nestedScrollView.bringToFront();
    }

    public final void i1() {
        boolean zEquals = "zh".equals(lg3.f(WearUtils.x));
        if (WearUtils.D || zEquals) {
            this.rouletteLayout.setVisibility(8);
        } else {
            this.rouletteLayout.setVisibility(0);
        }
        this.videosLayout.setVisibility(mk3.a.u() ? 0 : 8);
    }

    public final boolean j0() {
        ArrayList<Toy> arrayListP = this.k.G().P();
        if (arrayListP.isEmpty()) {
            return false;
        }
        Iterator<Toy> it = arrayListP.iterator();
        while (it.hasNext()) {
            String showName = it.next().getShowName();
            if (showName.contains("Lush") || showName.contains("Max") || showName.contains("Domi")) {
                return true;
            }
        }
        return false;
    }

    public final void l1(boolean z) {
        if (z) {
            WishListContribution wishListContribution = this.w;
            newContributionsCount = (wishListContribution != null ? 0 + wishListContribution.getNewContributionsCount() : 0) + this.y;
        }
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity != null) {
            mainActivity.f8(newContributionsCount);
        }
    }

    public final void m1() {
        this.gaming_new.setVisibility(8);
    }

    public final void n1() {
        boolean z = MyApplication.Z;
        boolean zD = eg3.d(requireContext(), "close_discover_mall", false);
        boolean zA = pg3.h().a();
        boolean zEquals = "zh".equals(lg3.f(WearUtils.x));
        if (z || zD || !zA || WearUtils.D || zEquals) {
            this.rl_mall.setVisibility(8);
        } else {
            this.rl_mall.setVisibility(0);
        }
        this.game_mode_layout.setVisibility((WearUtils.D || zEquals) ? 8 : 0);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onChatGPTEvent(ChatGPTConfigData chatGPTConfigData) {
        this.rl_chat_gpt.setVisibility(chatGPTConfigData.getEnableShow() ? 0 : 8);
    }

    @OnClick({R.id.ll_patterns, R.id.ll_speed_mode, R.id.ll_control_link, R.id.wish_list_layout, R.id.voice_control, R.id.game_mode_layout, R.id.gift_card_layout, R.id.gaming_layout, R.id.videos_layout, R.id.rl_chat_gpt, R.id.roulette_layout, R.id.sound_layout, R.id.alarm_layout, R.id.iv_website, R.id.iv_close_mall})
    public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        switch (view.getId()) {
            case R.id.alarm_layout /* 2131362048 */:
                pj3.f(getActivity(), AlarmListActivity.class);
                break;
            case R.id.game_mode_layout /* 2131362823 */:
                if (!na2.m().i()) {
                    pj3.f(getActivity(), NewGameModeActivity.class);
                    d0();
                    break;
                } else {
                    is3.b bVar = new is3.b(getActivity());
                    bVar.p(ah4.e(R.string.game_mode_noti));
                    bVar.d(new e());
                    cs3.h(bVar).show();
                    break;
                }
            case R.id.gaming_layout /* 2131362825 */:
                ye3.j("discover", "game_click", "click", "discover_game", "button", "game", "", -1L);
                pj3.f(getActivity(), GalleryListActivity.class);
                break;
            case R.id.gift_card_layout /* 2131362841 */:
                ye3.d("M0012", "");
                pj3.o(getActivity(), GiftCardActivity.class, GiftCardActivity.i);
                break;
            case R.id.iv_close_mall /* 2131363117 */:
                this.rl_mall.setVisibility(8);
                eg3.j(requireContext(), "close_discover_mall", true);
                ye3.j("discover", "discover_lovense_store_close_click", "click", "discover_lovense_store_close", "button", "", "", -1L);
                break;
            case R.id.iv_website /* 2131363349 */:
                String strC = pg3.h().c();
                if (!TextUtils.isEmpty(strC)) {
                    ye3.j("discover", "discover_lovense_store_click", "click", "discover_lovense_store", "button", "", "", -1L);
                    pj3.w(requireContext(), strC);
                    break;
                }
                break;
            case R.id.ll_control_link /* 2131363474 */:
                if (MyApplication.Z) {
                    V(R.string.offline_control_link);
                } else if (eg3.d(getActivity(), "control_link_introduce", true)) {
                    pj3.f(getActivity(), ControlLinkIntroduceActivity.class);
                    eg3.j(getActivity(), "control_link_introduce", false);
                } else {
                    WearUtils.x.q("controlLink", null);
                    Intent intent = new Intent(getActivity(), (Class<?>) ControlLinkNewActivity.class);
                    pj3.d(intent);
                    getActivity().startActivity(intent);
                }
                HashMap map = new HashMap();
                map.put("type", 2);
                ye3.d("M0011", WearUtils.A.toJson(map));
                break;
            case R.id.ll_patterns /* 2131363555 */:
                if (MyApplication.Z && !this.v) {
                    V(R.string.common_login_first);
                    break;
                } else {
                    pj3.f(getActivity(), PatternStoreActivity.class);
                    break;
                }
                break;
            case R.id.ll_speed_mode /* 2131363592 */:
                if (!na2.m().i()) {
                    if (y12.c.a().s(y12.c.TYPE_SPEED_MODE)) {
                        is3.b bVar2 = new is3.b(getActivity());
                        bVar2.d(new is3.d() { // from class: dc.fv2
                            @Override // dc.is3.d
                            public final void doConfirm() {
                                this.a.n0();
                            }
                        });
                        bVar2.c(new is3.c() { // from class: dc.jv2
                            @Override // dc.is3.c
                            public final void doCancel() {
                                SpeedModeControl.C().a0();
                            }
                        });
                        bVar2.n(getString(R.string.common_cancel));
                        bVar2.o(getString(R.string.common_agree));
                        bVar2.q(getString(R.string.common_warning));
                        ((SpeedModeTipDialog) cs3.i(bVar2, SpeedModeTipDialog.class)).show();
                        break;
                    }
                } else {
                    na2.m().t();
                    break;
                }
                break;
            case R.id.rl_chat_gpt /* 2131364251 */:
                if (!MyApplication.Z) {
                    pj3.f(requireContext(), ChatGPTActivity.class);
                    ye3.i("discover", "chatgpt_pleasure_click", "click", "chatgpt_pleasure", "button");
                    break;
                } else {
                    V(R.string.common_login_first);
                    break;
                }
            case R.id.roulette_layout /* 2131364346 */:
                EventBus.getDefault().post(DiscoverRouletteNewTagHiddenEvent.INSTANCE);
                ToyRouletteActivity.b.a(requireContext());
                ku1.f("Discover", "discover_control_roulette_click", "discover_control_roulette", "control roulette", "control roulette", null);
                break;
            case R.id.sound_layout /* 2131364584 */:
                if (!na2.m().i()) {
                    pj3.f(getActivity(), SoundPlayActivity.class);
                    break;
                } else {
                    na2.m().t();
                    break;
                }
            case R.id.videos_layout /* 2131365604 */:
                W0();
                eg3.j(WearUtils.x, "discover_click_videos", true);
                mk3.a.H();
                e0();
                pj3.f(getActivity(), InteractiveVideoActivity.class);
                ke3.c("videopatterns");
                break;
            case R.id.voice_control /* 2131365644 */:
                if (this.r) {
                    this.downloadProgress.setVisibility(8);
                    this.tvDownloadProgress.setVisibility(8);
                }
                if (!na2.m().i()) {
                    if (y12.c.a().s(y12.c.TYPE_VOICE_CONTROL)) {
                        ku1.a("Discover", "voice_control_entrance_click", "click", "voice_control_entrance", "button", "1", null, null);
                        pj3.f(getActivity(), VoiceControlActivity.class);
                        break;
                    }
                } else {
                    na2.m().t();
                    break;
                }
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        MyApplication myApplication = (MyApplication) getActivity().getApplication();
        this.k = myApplication;
        M(myApplication);
        View viewInflate = layoutInflater.inflate(R.layout.discover_fragment_new, (ViewGroup) null, false);
        this.m = viewInflate;
        ButterKnife.bind(this, viewInflate);
        EventBus.getDefault().register(this);
        this.ll_discover_list.bringToFront();
        this.ivNotToy.bringToFront();
        this.titleAdd.bringToFront();
        this.tvTitle.setAlpha(0.0f);
        this.tvTitle.setText(ah4.e(R.string.main_menu_discover));
        if (be3.D()) {
            q1();
        } else {
            c1();
        }
        this.titleAdd.setOnClickListener(new View.OnClickListener() { // from class: dc.xu2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.r0(view);
            }
        });
        this.ivNotToy.setOnClickListener(new View.OnClickListener() { // from class: dc.yu2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.u0(view);
            }
        });
        this.rlToy1.setOnClickListener(new View.OnClickListener() { // from class: dc.ev2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.w0(view);
            }
        });
        this.rlToy2.setOnClickListener(new View.OnClickListener() { // from class: dc.av2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.y0(view);
            }
        });
        this.rl_chat_gpt.setVisibility(eg3.d(requireContext(), "chatGPTConfig", false) ? 0 : 8);
        e0();
        n1();
        x03.a.k(this.t);
        i0();
        nk3.c();
        return this.m;
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        x03.a.m(this.t);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDiscoverRouletteNewTagHiddenEvent(DiscoverRouletteNewTagHiddenEvent discoverRouletteNewTagHiddenEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (eg3.d(WearUtils.x, "discover_show_roulette", true)) {
            eg3.j(WearUtils.x, "discover_show_roulette", false);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDownloadEvent(DownloadModelEvent downloadModelEvent) {
        this.downloadProgress.setVisibility(8);
        this.tvDownloadProgress.setVisibility(8);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(SetSyncCommonDataEvent setSyncCommonDataEvent) {
        i1();
        n1();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        m1();
        if (!MyApplication.P) {
            this.red_dot_layout.setVisibility(8);
            l1(false);
            this.wishListLayout.setOnClickListener(new View.OnClickListener() { // from class: dc.dv2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.P0(view);
                }
            });
        } else if (this.u) {
            this.l.l();
            this.wishListLayout.setEnabled(false);
        }
        if (this.p) {
            int i = this.o + 1;
            this.o = i;
            if (i > this.n.size() - 1) {
                this.o = 0;
            }
            h0(this.n);
        }
        List<AdListBean.DataBean> list = this.n;
        if (list != null && list.size() > 0 && isVisible()) {
            ku1.a("Discover", "discover_dynamic_ads_exposure", "exposure", "discover_dynamic_ads", "picture", "", this.n.get(this.o).getId(), null);
        }
        a1();
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new d());
    }

    public void p1() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (getContext() == null) {
            return;
        }
        if (eg3.f(getContext(), "guide_speed_mode", 0) != 0) {
            pj3.f(getContext(), SpeedModeActivity.class);
        } else {
            pj3.f(getContext(), SpeedModeGuideActivity.class);
            eg3.k(getContext(), "guide_speed_mode", 1);
        }
    }

    public final void q1() {
        this.tv_pattern_special.setText(ah4.e(R.string.patterns_vday_special));
        this.tv_pattern_special.setVisibility(0);
        this.gift_card_icon.setVisibility(8);
        for (int i = 0; i < this.ll_discover_list.getChildCount(); i++) {
            View childAt = this.ll_discover_list.getChildAt(i);
            boolean z = true;
            if (i != this.ll_discover_list.getChildCount() - 1) {
                z = false;
            }
            childAt.setBackgroundResource(g0(z));
        }
    }

    @Override // com.wear.main.BaseFragment, dc.ul2
    public void showErrorMsg(String str, boolean z) {
        super.showErrorMsg(str, z);
        sg3.l(str);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void vbTipConfigChangeEvent(sk3 sk3Var) {
        e0();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(xc1 xc1Var) {
        Q();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ThemeChangeEvent themeChangeEvent) {
        g1(false);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(LoginOrOfflineEvent loginOrOfflineEvent) {
        this.u = true;
        if (MyApplication.P) {
            this.l.l();
            this.wishListLayout.setEnabled(false);
        } else {
            this.red_dot_layout.setVisibility(8);
            l1(false);
            this.wishListLayout.setOnClickListener(new View.OnClickListener() { // from class: dc.cv2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.E0(view);
                }
            });
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(LoginStatusActionEvent loginStatusActionEvent) {
        this.u = true;
        if (MyApplication.P) {
            this.l.l();
            this.wishListLayout.setEnabled(false);
        } else {
            this.red_dot_layout.setVisibility(8);
            l1(false);
            this.wishListLayout.setOnClickListener(new View.OnClickListener() { // from class: dc.zu2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.A0(view);
                }
            });
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(WishListDisappearRedDotEvent wishListDisappearRedDotEvent) {
        this.red_dot_layout.setVisibility(8);
        this.w.setNewContributionsCount(0);
        l1(true);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(GiftCardEvent giftCardEvent) {
        if (eg3.d(getContext(), GiftCardActivity.h, true)) {
            this.y = 0;
        } else {
            this.y = giftCardEvent.getAcceptedNum();
            this.giftCardRedDotLayout.setVisibility(giftCardEvent.getAcceptedNum() <= 0 ? 8 : 0);
            this.giftCardContributeText.setText(String.valueOf(giftCardEvent.getAcceptedNum()));
        }
        l1(true);
    }
}
