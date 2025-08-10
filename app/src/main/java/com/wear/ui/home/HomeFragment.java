package com.wear.ui.home;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.broadcom.bt.util.io.IOUtils;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.wear.BaseActivity;
import com.wear.activity.discord.DiscordControl;
import com.wear.activity.discord.DiscordEvent;
import com.wear.activity.orgySetting.OrgySettingEvent;
import com.wear.bean.Account;
import com.wear.bean.AlarmListItems;
import com.wear.bean.HomeMusicBean;
import com.wear.bean.HomepageArrangeBean;
import com.wear.bean.LanApiControlEvent;
import com.wear.bean.Music;
import com.wear.bean.MusicAPPBean;
import com.wear.bean.Pattern;
import com.wear.bean.ScanQRDataBean;
import com.wear.bean.SyncWsProtocol;
import com.wear.bean.Toy;
import com.wear.bean.event.AlarmShowEvent;
import com.wear.bean.event.LoginOrOfflineEvent;
import com.wear.bean.event.LoginStatusActionEvent;
import com.wear.bean.event.MusicNotificationEvent;
import com.wear.bean.event.PatternDownloadEvent;
import com.wear.bean.event.RefreshControlLinkList;
import com.wear.bean.event.SetSyncCommonDataEvent;
import com.wear.bean.event.VideoPatternControlEvent;
import com.wear.bean.socketio.controlLink.response.ControlLinkListResponse;
import com.wear.broadcast.AlarmMessagingService;
import com.wear.dao.AlarmListDao;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.main.BaseFragment;
import com.wear.main.MainActivity;
import com.wear.main.account.HomepageSettingsActivity;
import com.wear.main.closeRange.PatternPlayActivity;
import com.wear.main.closeRange.RemoteMultiControlActivity;
import com.wear.main.closeRange.alarm.AlarmListActivity;
import com.wear.main.closeRange.alarm.ShowAlarmPopwindow;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.longDistance.controllink.ControlLinkIntroduceActivity;
import com.wear.main.longDistance.controllink.ControlLinkNewActivity;
import com.wear.main.longDistance.controllink.CreateControlLinkActivity;
import com.wear.main.patterns.CreatePatternActivity;
import com.wear.main.toy.newtoy.NewToyActivity;
import com.wear.phonertc.RequestPermissionActivity;
import com.wear.protocol.EntityAlarm;
import com.wear.protocol.EntitySystem;
import com.wear.protocol.MessageType;
import com.wear.ui.home.HomeFragment;
import com.wear.ui.home.music.NewMusicActivity;
import com.wear.ui.home.pattern.NewPatternActivity;
import com.wear.ui.home.sound.SoundPlayActivity;
import com.wear.util.HomePatternPlayUtil;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MediumBoldTextView;
import com.wear.widget.RecyclerViewNoBugLinearLayoutManager;
import com.wear.widget.llong.CircularProgressView;
import dc.ah4;
import dc.be3;
import dc.bg3;
import dc.ce3;
import dc.cs3;
import dc.db2;
import dc.eg3;
import dc.ff2;
import dc.ff3;
import dc.g12;
import dc.h32;
import dc.hg3;
import dc.hu3;
import dc.i12;
import dc.is3;
import dc.k12;
import dc.kd0;
import dc.ke3;
import dc.kn3;
import dc.l22;
import dc.lg3;
import dc.me3;
import dc.mk2;
import dc.mn3;
import dc.my2;
import dc.na2;
import dc.ng3;
import dc.pc1;
import dc.pj3;
import dc.q61;
import dc.qf3;
import dc.r71;
import dc.rd3;
import dc.rf3;
import dc.sg3;
import dc.sr3;
import dc.sz1;
import dc.t51;
import dc.t71;
import dc.th4;
import dc.tz1;
import dc.u51;
import dc.u71;
import dc.v71;
import dc.ve3;
import dc.w71;
import dc.xc1;
import dc.xn3;
import dc.y12;
import dc.ye3;
import dc.zt3;
import de.hdodenhof.circleimageview.CircleImageView;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class HomeFragment extends BaseFragment implements ShowAlarmPopwindow.b, tz1, MusicControl.h, l22.k {
    public static final List<AlarmListItems> D = new ArrayList();
    public static int E = 0;
    public static String F;
    public static Handler G;
    public static AlarmListItems K;
    public PopupWindow A;
    public Runnable C;

    @BindView(R.id.alarm_space_layout)
    public LinearLayout alarmSpaceLayout;

    @BindView(R.id.home_fra_compose_layout)
    public LinearLayout composeLayout;

    @BindView(R.id.home_fragment_root_layout)
    public LinearLayout homeFragmentRootLayout;

    @BindView(R.id.home_fragment_title_layout)
    public LinearLayout homeFragmentTitleLayout;

    @BindView(R.id.home_pattern_ll_type)
    public LinearLayout homePatternLlType;

    @BindView(R.id.home_pattern_next)
    public ImageView homePatternNext;

    @BindView(R.id.home_pattern_play)
    public ImageView homePatternPlay;

    @BindView(R.id.home_pattern_previous)
    public ImageView homePatternPrevious;

    @BindView(R.id.home_pattern_title)
    public MediumBoldTextView homePatternTitle;

    @BindView(R.id.home_pattern_toy_type_1)
    public ImageView homePatternToyType1;

    @BindView(R.id.home_pattern_toy_type_2)
    public ImageView homePatternToyType2;

    @BindView(R.id.iv_banner)
    public ImageView ivBanner;

    @BindView(R.id.iv_close)
    public ImageView ivClose;

    @BindView(R.id.iv_not_toy)
    public ImageView ivNotToy;

    @BindView(R.id.home_pattern_add)
    public ImageView ivPatternAdd;
    public g12 l;

    @BindView(R.id.lan_api_control)
    public LinearLayout lanApiControl;

    @BindView(R.id.lan_api_control_stop)
    public TextView lanApiControlStop;

    @BindView(R.id.lan_api_control_update)
    public TextView lanApiControlUpdate;

    @BindView(R.id.link_lly)
    public LinearLayout link_lly;

    @BindView(R.id.ll_video_pattern_control)
    public LinearLayout llVideoPatternControl;
    public HomePatternPlayUtil m;

    @BindView(R.id.home_controllink_add)
    public ImageView mIvHomeControlLinkAdd;

    @BindView(R.id.home_item_control_link_operate)
    public ImageView mIvHomeItemControlLinkOperate;

    @BindView(R.id.ll_control_link_state)
    public LinearLayout mLlControlLinkState;

    @BindView(R.id.ll_home_control_link_activate)
    public LinearLayout mLlHomeControlLinkActivate;

    @BindView(R.id.home_control_link_countdown)
    public TextView mTvHomeControlLinkCountdown;

    @BindView(R.id.home_control_link_state)
    public TextView mTvHomeControlLinkState;

    @BindView(R.id.home_control_link_title)
    public TextView mTvHomeControlLinkTitle;

    @BindView(R.id.home_item_control_link)
    public LinearLayout mTvHomeItemControlLink;

    @BindView(R.id.home_item_control_link_function)
    public TextView mTvHomeItemControlLinkFunction;

    @BindView(R.id.view_state)
    public CircleImageView mViewState;

    @BindView(R.id.minimize_alart_close)
    public ImageView minimizeAlartClose;

    @BindView(R.id.minimize_alart_layout)
    public LinearLayout minimizeAlartLayout;

    @BindView(R.id.minimize_alart_notice)
    public TextView minimizeAlartNotice;

    @BindView(R.id.home_music_cpv)
    public CircularProgressView musicCPV;

    @BindView(R.id.home_item_music_ll_content)
    public LinearLayout musicContent;

    @BindView(R.id.home_music_next)
    public ImageView musicIvNext;

    @BindView(R.id.home_music_play_pic)
    public ImageView musicIvPic;

    @BindView(R.id.home_music_play_pic_mask)
    public View musicIvPicMask;

    @BindView(R.id.home_music_play)
    public ImageView musicIvPlay;

    @BindView(R.id.home_music_previous)
    public ImageView musicIvPrevious;

    @BindView(R.id.home_item_music_content)
    public TextView musicMsg;

    @BindView(R.id.home_item_music_ll_pure)
    public LinearLayout musicPure;

    @BindView(R.id.home_music_ll)
    public LinearLayout musicSpaceLayout;

    @BindView(R.id.home_item_music_title)
    public TextView musicTitle;
    public RecyclerViewNoBugLinearLayoutManager o;
    public View p;

    @BindView(R.id.home_pattern_ll_content)
    public LinearLayout paternContent;

    @BindView(R.id.home_pattern_ll_pure)
    public LinearLayout paternPure;

    @BindView(R.id.home_pattern_cpv)
    public CircularProgressView patternCPV;

    @BindView(R.id.home_pattern_ll)
    public LinearLayout patternSpaceLayout;

    @BindView(R.id.remoteControl)
    public LinearLayout remoteControl;

    @BindView(R.id.rl_home_top)
    public RelativeLayout rlHomeTop;

    @BindView(R.id.rl_toy_1)
    public AppCompatTextView rlToy1;

    @BindView(R.id.rl_toy_2)
    public AppCompatTextView rlToy2;
    public FragmentActivity s;

    @BindView(R.id.sound_space_layout)
    public LinearLayout soundSpaceLayout;

    @BindView(R.id.title_add)
    public ImageView titleAdd;

    @BindView(R.id.toy_alart_tip)
    public LinearLayout toyAlartTip;

    @BindView(R.id.toy_disconnected_tip)
    public RelativeLayout toyDisconnectedTip;

    @BindView(R.id.toys_number_text)
    public AppCompatTextView toysNumber;

    @BindView(R.id.tv_connect_tip)
    public TextView tvConnectTip;

    @BindView(R.id.tv_lan_api_platform)
    public TextView tvLanApiPlatform;

    @BindView(R.id.tv_video_pattern_control_tip)
    public TextView tvVideoPatternControlTip;

    @BindView(R.id.tv_video_pattern_control_unsync)
    public TextView tvVideoPatternControlUnsync;
    public MyApplication u;
    public xn3 v;
    public mn3 w;
    public ShowAlarmPopwindow y;

    @SuppressLint({"ClickableViewAccessibility"})
    public final View.OnTouchListener k = new View.OnTouchListener() { // from class: dc.l33
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return HomeFragment.P0(view, motionEvent);
        }
    };
    public int n = -1;
    public boolean q = false;
    public boolean r = true;
    public CountDownTimer t = null;
    public boolean x = false;
    public boolean z = false;
    public Handler B = new Handler();

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
            HomeFragment.this.lanApiControl.setVisibility(8);
            EventBus.getDefault().post(new LanApiControlEvent(false));
        }
    }

    public class b implements u51 {
        public final /* synthetic */ View a;

        public class a implements kn3.d {
            public a() {
            }

            @Override // dc.kn3.d
            public void doCancel() {
            }

            @Override // dc.kn3.d
            public void doConfirm() {
                RequestPermissionActivity.s4(HomeFragment.this.getActivity());
            }
        }

        public b(View view) {
            this.a = view;
        }

        @Override // dc.u51
        public void a(List<String> list, boolean z) {
            t51.a(this, list, z);
            if (z) {
                new kn3((Context) HomeFragment.this.getActivity(), ah4.e(R.string.app_open_must_permission), ah4.e(R.string.common_confirm), ah4.e(R.string.common_cancel), true, (kn3.d) new a()).show();
            }
        }

        @Override // dc.u51
        public void b(List<String> list, boolean z) throws IllegalStateException {
            if (!z || MusicControl.h0().L()) {
                return;
            }
            if (na2.m().i()) {
                na2.m().t();
                return;
            }
            if (HomeFragment.this.x) {
                HomeFragment.this.u2();
                return;
            }
            if (this.a.getId() != R.id.home_music_play) {
                if (MusicControl.h0().f != null && MusicControl.h0().f.getMusicType() != 2) {
                    MusicControl.h0().r = true;
                    MusicControl.h0().J(HomeFragment.this.getActivity());
                    MusicControl.h0().Z(HomeFragment.this.getActivity(), null);
                }
            } else if (rd3.f().p(HomeFragment.this.getActivity()) && !MusicControl.h0().O()) {
                MusicControl.h0().r = true;
                MusicControl.h0().Z(HomeFragment.this.getActivity(), null);
                MusicControl.h0().J(HomeFragment.this.getActivity());
            }
            switch (this.a.getId()) {
                case R.id.home_music_next /* 2131362922 */:
                    if (MusicControl.h0().f != null && MusicControl.h0().f.getMusicType() == 2) {
                        sg3.h(R.string.notification_switch_songs);
                        return;
                    } else {
                        MusicControl.h0().W();
                        HomeFragment.this.musicCPV.setProgress(0);
                        break;
                    }
                case R.id.home_music_play /* 2131362923 */:
                    if (MusicControl.h0().f != null && MusicControl.h0().f.getMusicType() == 2) {
                        if (!rd3.f().p(HomeFragment.this.getActivity())) {
                            HomeFragment.this.u2();
                            break;
                        } else {
                            MusicControl.h0().X();
                            break;
                        }
                    } else {
                        MusicControl.h0().u0(Boolean.TRUE);
                        break;
                    }
                    break;
                case R.id.home_music_previous /* 2131362926 */:
                    if (MusicControl.h0().f != null && MusicControl.h0().f.getMusicType() == 2) {
                        sg3.h(R.string.notification_switch_songs);
                        return;
                    } else {
                        MusicControl.h0().Y();
                        HomeFragment.this.musicCPV.setProgress(0);
                        break;
                    }
            }
            if (MusicControl.h0().f == null || MusicControl.h0().f.getMusicType() != 2) {
                return;
            }
            HomeFragment.this.h0();
        }
    }

    public class c implements ImageLoadingListener {
        public c() {
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            ((ImageView) view).setImageBitmap(bitmap);
            HomeFragment.this.musicIvPic.setImageBitmap(bitmap);
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ((ImageView) view).setImageResource(R.drawable.content_icon_music_cover);
            HomeFragment.this.musicIvPic.setImageResource(R.drawable.content_icon_music_cover);
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    public class d extends HashMap<String, String> {
        public final /* synthetic */ AlarmListItems val$alarmItem;

        public d(AlarmListItems alarmListItems) {
            this.val$alarmItem = alarmListItems;
            put(TypedValues.TransitionType.S_DURATION, alarmListItems.getTime());
            if (alarmListItems.getNotify() == -1) {
                put("type", ImagesContract.LOCAL);
            } else {
                put("type", "longDistance");
            }
        }
    }

    public class e extends ff3 {
        public e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void f(long j, String str) {
            HomeFragment homeFragment = HomeFragment.this;
            if (!homeFragment.q) {
                homeFragment.q = true;
            } else if (j - WearUtils.K0(str) == 1) {
                WearUtils.x.l.postDelayed(new Runnable() { // from class: dc.v23
                    @Override // java.lang.Runnable
                    public final void run() {
                        iq1.e();
                    }
                }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void h() {
            HomeFragment.this.g(2);
        }

        @Override // dc.ff3
        public void c(boolean z, Object obj, String str) {
            super.c(z, obj, str);
            if (z) {
                return;
            }
            HomeFragment.G.postDelayed(new Runnable() { // from class: dc.c33
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.h();
                }
            }, 1000L);
        }

        @Override // dc.ff3
        public void d(boolean z, Object obj, String str, final String str2, final long j) {
            if (MyApplication.H() != null) {
                MyApplication.H().runOnUiThread(new Runnable() { // from class: dc.b33
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.f(j, str2);
                    }
                });
            }
        }
    }

    public class f extends CountDownTimer {
        public final /* synthetic */ ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(long j, long j2, ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO) {
            super(j, j2);
            this.a = longTimeControlLinkListDTO;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            String strValueOf;
            if (this.a.getNextOnWaitingTimestamp() != 0) {
                int nextOnWaitingTimestamp = (int) (((this.a.getNextOnWaitingTimestamp() - MyApplication.N().h) - System.currentTimeMillis()) / 1000);
                if (this.a.getCurrentStatus().equals(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.WAITING)) {
                    nextOnWaitingTimestamp = -1;
                }
                if (nextOnWaitingTimestamp <= 0) {
                    HomeFragment.this.mTvHomeControlLinkState.setText(ah4.e(R.string.common_state_waiting));
                    HomeFragment.this.mTvHomeControlLinkState.setVisibility(0);
                    HomeFragment.this.v0();
                    HomeFragment homeFragment = HomeFragment.this;
                    FragmentActivity fragmentActivity = homeFragment.s;
                    if (fragmentActivity != null) {
                        homeFragment.mViewState.setBackground(th4.d(fragmentActivity, R.drawable.icon_control_link_state_waiting));
                        HomeFragment homeFragment2 = HomeFragment.this;
                        homeFragment2.mIvHomeItemControlLinkOperate.setImageDrawable(th4.d(homeFragment2.s, R.drawable.home_share_new));
                    }
                    HomeFragment.this.mTvHomeItemControlLinkFunction.setText(ah4.e(R.string.common_share));
                    HomeFragment.this.mLlHomeControlLinkActivate.setVisibility(0);
                    HomeFragment.this.S2();
                    return;
                }
                strValueOf = String.valueOf(nextOnWaitingTimestamp);
            } else {
                strValueOf = "29";
            }
            String str = String.format(ah4.e(R.string.control_link_auto_reactivate_countdown), strValueOf);
            int iIndexOf = str.indexOf(strValueOf);
            SpannableString spannableString = new SpannableString(str);
            new SpannableString(str);
            if (iIndexOf != -1 && HomeFragment.this.isAdded()) {
                spannableString.setSpan(new ForegroundColorSpan(HomeFragment.this.getResources().getColor(R.color.lvs_ui_standard_systemTextRegular)), iIndexOf, str.length(), 33);
            }
            HomeFragment homeFragment3 = HomeFragment.this;
            homeFragment3.mTvHomeControlLinkCountdown.setText(homeFragment3.w0(strValueOf));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D1(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        n0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J0(sr3 sr3Var, Toy toy) {
        kd0.b("extras_toy", toy);
        Intent intent = new Intent(getActivity(), (Class<?>) CreatePatternActivity.class);
        intent.putExtra("is_recording_pattern", 1);
        intent.putExtra("is_create_home", true);
        startActivity(intent);
        if (sr3Var.isShowing()) {
            sr3Var.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F1(View view) {
        m0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H1(View view) {
        pj3.f(getActivity(), NewToyActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K1(View view) {
        pj3.f(getActivity(), NewToyActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M0() {
        R();
        mk2.P().K0(true, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O1(View view) {
        pj3.f(getActivity(), NewToyActivity.class);
    }

    public static /* synthetic */ boolean P0(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            view.setAlpha(0.8f);
            return false;
        }
        if (action != 1) {
            return false;
        }
        view.setAlpha(1.0f);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q1(View view) {
        r0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R0(View view) {
        this.n = view.getId();
        t("closeRange_alarm", null);
        E2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T1(View view) {
        q0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T0(View view) {
        if (na2.m().i()) {
            na2.m().t();
            return;
        }
        ArrayList<Toy> arrayListP = this.u.G().P();
        t("closeRange_remoteControl", null);
        if (arrayListP != null && arrayListP.size() > 0) {
            pj3.f(getActivity(), RemoteMultiControlActivity.class);
            return;
        }
        String str = "popIsShow===" + this.z;
        PopupWindow popupWindow = this.A;
        if (popupWindow == null || popupWindow.isShowing()) {
            return;
        }
        N2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W0() {
        this.B.removeCallbacks(this.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X1(View view) {
        K2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z1(View view) {
        pj3.f(getActivity(), NewToyActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean c1(View view, MotionEvent motionEvent) {
        PopupWindow popupWindow = this.A;
        if (popupWindow != null && popupWindow.isShowing() && motionEvent.getAction() == 0) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            int[] iArr = new int[2];
            this.remoteControl.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int width = this.remoteControl.getWidth();
            int height = this.remoteControl.getHeight();
            if (rawX < i || rawX > i + width || rawY < i2 || rawY > i2 + height) {
                this.A.dismiss();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c2(String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        startActivity(Intent.createChooser(intent, ah4.e(R.string.control_link_title)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e2(View view) {
        pj3.f(getContext(), NewToyActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g1(View view) {
        this.n = view.getId();
        t("closeRange_myPatterns", null);
        E2();
    }

    public static /* synthetic */ void h2(DialogInterface dialogInterface) {
        if (MyApplication.H() instanceof PatternPlayActivity) {
            MyApplication.H().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l1(View view) {
        this.n = view.getId();
        t("closeRange_music", null);
        l0(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l2(r71 r71Var, View view) {
        r71Var.a();
        pj3.f(getActivity(), NewToyActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n1(View view) {
        this.n = view.getId();
        t("closeRange_sound", null);
        C2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ u71 n2(View view, w71 w71Var, List list) {
        u71.a aVar = new u71.a();
        aVar.d(R.id.iv_not_toy);
        aVar.f(view);
        aVar.e(new v71(ce3.a(getActivity(), 20.0f), 0, ce3.a(getActivity(), -4.0f), 0));
        aVar.c(w71Var);
        aVar.b(list);
        return aVar.getA();
    }

    public static /* synthetic */ Unit o2(Integer num) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q1(View view) {
        pj3.f(getActivity(), NewToyActivity.class);
    }

    public static /* synthetic */ Unit p2() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t1(View view) {
        u0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s2() {
        String str = "我执行了" + this.z;
        this.A.dismiss();
    }

    public static /* synthetic */ String t2(AlarmListItems alarmListItems) {
        return alarmListItems.getNotify() == -1 ? alarmListItems.getSoundurl() : alarmListItems.getSoundFileath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w1(View view) {
        if (getActivity() == null) {
            return;
        }
        pj3.w(getActivity(), "https://www.lovense.com/magnetic-panty-vibrator");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A1(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        p0();
    }

    public final void A0() {
        MusicControl.h0().w0(this);
    }

    public final void A2() {
        if (WearUtils.x.G().N() == null) {
            this.minimizeAlartLayout.setVisibility(8);
            this.toyAlartTip.setVisibility(8);
        }
        if (WearUtils.e1(F)) {
            return;
        }
        this.toyAlartTip.setVisibility(0);
        this.minimizeAlartLayout.setVisibility(0);
        this.minimizeAlartNotice.setText(F);
    }

    public final boolean C0() {
        String str = "结果===" + WearUtils.D;
        return (WearUtils.D || "zh".equals(lg3.f(WearUtils.x))) ? false : true;
    }

    @SuppressLint({"CheckResult"})
    public final void C2() {
        e0(getActivity());
    }

    @SuppressLint({"CheckResult"})
    public final void E2() {
        l0(getActivity());
    }

    public final void F2(AlarmListItems alarmListItems) throws ParseException {
        if (!"customer".equals(alarmListItems.getFrequency())) {
            AlarmMessagingService.d(alarmListItems.getId(), false);
            alarmListItems.setHaveSnoozeCount(0);
            DaoUtils.getAlarmListDao().update((AlarmListDao) alarmListItems);
            zt3.t(getActivity(), alarmListItems.getId(), false, false, alarmListItems.getReceiveFlag() != 1);
            return;
        }
        alarmListItems.setRingTime(null);
        alarmListItems.setIsSelected(0);
        alarmListItems.setHaveSnoozeCount(0);
        DaoUtils.getAlarmListDao().update((AlarmListDao) alarmListItems);
        AlarmMessagingService.d(alarmListItems.getId(), false);
    }

    public void G2() {
        this.link_lly.setVisibility(C0() ? 0 : 8);
    }

    public void H2() {
        if (this.x) {
            this.musicIvPlay.setImageDrawable(MusicControl.h0().O() ? th4.d(this.u, R.drawable.music_icon_pause_transparent) : th4.d(this.u, R.drawable.home_play_new));
        } else {
            this.musicIvPlay.setImageDrawable(MusicControl.h0().O() ? th4.d(this.u, R.drawable.music_icon_pause_transparent) : th4.d(this.u, R.drawable.music_icon_play_transparent));
        }
        this.musicCPV.setBackColor(th4.b(this.u, R.color.transparent));
        this.musicCPV.setProgColor(th4.b(this.u, R.color.lvs_ui_standard_systemBrandRegular));
        this.musicCPV.bringToFront();
        this.patternCPV.setBackColor(th4.b(this.u, R.color.transparent));
        this.patternCPV.setProgColor(th4.b(this.u, R.color.lvs_ui_standard_systemBrandRegular));
        this.patternCPV.bringToFront();
    }

    public final void I2(AlarmListItems alarmListItems) throws ParseException {
        boolean z;
        String path = WearUtils.x0(alarmListItems.getPatternId()).getPath();
        if (new File(path).exists() || alarmListItems.getReceiveFlag() != 1) {
            z = true;
        } else if (WearUtils.e1(alarmListItems.getReveiveFilePath())) {
            path = alarmListItems.getPatternId();
            z = false;
        } else {
            path = alarmListItems.getReveiveFilePath();
            z = true;
        }
        if (z) {
            if (!new File(path).exists()) {
                return;
            }
            Pattern pattern = new Pattern();
            pattern.setData(WearUtils.N1(path));
            if (WearUtils.e1(pattern.getData())) {
                return;
            }
        }
        String alarmTitle = alarmListItems.getAlarmTitle();
        if (WearUtils.x.G().P().size() <= 0) {
            sg3.i(getActivity(), R.string.chat_alarm_execute_no_toy);
            t("alarm_miss", null);
            K = alarmListItems;
            AlarmMessagingService.d(alarmListItems.getId(), false);
            F = null;
            if (K.getFrequency().equals("customer")) {
                K.setRingTime(null);
                K.setIsSelected(0);
                K.setHaveSnoozeCount(0);
                DaoUtils.getAlarmListDao().update((AlarmListDao) K);
                g(2);
            } else {
                K.setHaveSnoozeCount(0);
                DaoUtils.getAlarmListDao().update((AlarmListDao) K);
                zt3.t(getActivity(), K.getId(), false, false, K.getReceiveFlag() != 1);
                g(2);
            }
            this.u.o = false;
            return;
        }
        this.u.o = true;
        if (WearUtils.e1(alarmTitle)) {
            alarmTitle = ah4.e(R.string.app_company_name);
        }
        F = alarmTitle;
        if (alarmListItems.getNotify() == 1) {
            Account accountU = WearUtils.y.u();
            StringBuilder sb = new StringBuilder();
            sb.append(accountU == null ? "" : accountU.getUserName());
            sb.append(zt3.i);
            sb.append(alarmListItems.getTime());
            String str = zt3.j + zt3.f + zt3.i + alarmListItems.getReceiveAlarmId() + zt3.i + sb.toString();
            EntitySystem entitySystem = new EntitySystem();
            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C202.toString(), str);
            hu3.g0(entitySystem, WearUtils.i0(alarmListItems.getFriendEmail()), MessageType.system, str, null, null);
        }
        WearUtils.x.q("alarm_play", new d(alarmListItems));
        ShowAlarmPopwindow showAlarmPopwindow = this.y;
        if (showAlarmPopwindow != null) {
            showAlarmPopwindow.dismiss();
        }
        ShowAlarmPopwindow showAlarmPopwindow2 = new ShowAlarmPopwindow(MyApplication.H(), F, alarmListItems, this);
        this.y = showAlarmPopwindow2;
        showAlarmPopwindow2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: dc.n33
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                HomeFragment.h2(dialogInterface);
            }
        });
        this.y.show();
        Handler handler = G;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        } else {
            G = new Handler(Looper.getMainLooper());
        }
        G.postDelayed(new Runnable() { // from class: dc.a43
            @Override // java.lang.Runnable
            public final void run() {
                EventBus.getDefault().post(new AlarmShowEvent(-1));
            }
        }, alarmListItems.getDuration() * 1000);
        K = alarmListItems;
        x2();
        R2(path, alarmListItems, z);
    }

    @Override // com.wear.main.BaseFragment
    public void J() {
        super.J();
        me3.c(me3.c.HOME_UI_ENTER);
        ye3.c("home", "into page", null);
        t("menu_home", null);
    }

    public final void J2() {
        final ArrayList arrayList = new ArrayList();
        arrayList.add(t71.i.a);
        arrayList.add(t71.e.a);
        final View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.second_pop_window, (ViewGroup) null);
        final r71 r71VarA = r71.b.a(this);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: dc.e33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.l2(r71VarA, view);
            }
        });
        final w71 w71Var = new w71();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        w71Var.e(paint);
        r71VarA.c(new Function0() { // from class: dc.k33
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.a.n2(viewInflate, w71Var, arrayList);
            }
        });
        r71VarA.b(th4.b(getContext(), R.color.lvs_ui_standard_systemMaskAlert));
        r71VarA.e(new Function1() { // from class: dc.u33
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HomeFragment.o2((Integer) obj);
            }
        });
        r71VarA.d(new Function0() { // from class: dc.t33
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeFragment.p2();
            }
        });
        r71VarA.f();
        new Handler().postDelayed(new Runnable() { // from class: dc.d43
            @Override // java.lang.Runnable
            public final void run() {
                r71VarA.a();
            }
        }, 10000);
    }

    @Override // com.wear.main.BaseFragment
    public void K(Intent intent) {
        MyApplication myApplication;
        if (!"ACTION_TOY_UPDATE".equals(intent.getAction()) || (myApplication = WearUtils.x) == null || this.toyDisconnectedTip == null) {
            return;
        }
        if (myApplication.G().N() == null) {
            this.toyDisconnectedTip.setVisibility(0);
        } else {
            this.toyDisconnectedTip.setVisibility(8);
            A2();
        }
    }

    public final void K2() {
        kn3 kn3Var = new kn3((Context) getActivity(), String.format(ah4.e(R.string.lan_api_stop), MyApplication.G.getTransPf()), ah4.e(R.string.common_ok), ah4.e(R.string.common_cancel), true, (kn3.d) new a());
        kn3Var.show();
        kn3Var.p();
    }

    public void M2() {
        Music music;
        if (MusicControl.h0().f == null) {
            MusicControl.h0().g = 0;
            if (MusicControl.h0().d.h.size() > 0) {
                MusicControl.h0().F(null, MusicControl.h0().d.h);
                music = MusicControl.h0().d.h.get(0);
                MusicControl.h0().f = MusicControl.h0().d.h.get(0);
            } else if (MusicControl.h0().e.i.size() > 0) {
                MusicControl.h0().F(null, MusicControl.h0().e.i);
                music = MusicControl.h0().e.i.get(0);
                MusicControl.h0().f = MusicControl.h0().e.i.get(0);
            } else {
                music = null;
            }
        } else {
            music = MusicControl.h0().f;
        }
        if (music != null && music.getMusicType() != 2 && MusicControl.h0().d.h.size() == 0 && MusicControl.h0().e.i.size() == 0) {
            music = null;
        }
        if (music == null) {
            this.x = true;
            this.musicCPV.setProgress(0);
            this.musicTitle.setText(ah4.e(R.string.music_all_no));
            this.musicMsg.setVisibility(8);
            this.musicIvPlay.setImageDrawable(th4.d(this.u, R.drawable.home_play_new));
            return;
        }
        this.x = false;
        this.musicTitle.setText(music.getTitle());
        this.musicMsg.setVisibility(0);
        if (music.getMusicType() != 2 || TextUtils.isEmpty(eg3.h(getContext(), rd3.n, ""))) {
            this.musicMsg.setText(music.getArtist());
        } else {
            this.musicMsg.setText(ng3.e(((MusicAPPBean) new Gson().fromJson(eg3.h(getContext(), rd3.n, ""), MusicAPPBean.class)).getLabel()));
        }
        if (MusicControl.h0().f == null || MusicControl.h0().f.getMusicType() != 2) {
            this.musicIvPrevious.setImageResource(R.drawable.btn_music_previous_selector);
            this.musicIvNext.setImageResource(R.drawable.icon_next_new);
        } else {
            this.musicIvPrevious.setImageResource(R.drawable.music_icon_previous_disable);
            this.musicIvNext.setImageResource(R.drawable.music_icon_next_disable);
        }
        String imageUrl = "content://media/external/audio/albumart/" + music.getAlbumId();
        if (music.getMusicType() == 1) {
            imageUrl = music.getImageUrl();
        }
        if (!WearUtils.e1(imageUrl) && music.getAlbumId() > 0) {
            ImageLoader.getInstance().displayImage(imageUrl, this.musicIvPic, new c());
        } else if (music.getBitmap() != null) {
            this.musicIvPic.setImageBitmap(music.getBitmap());
        } else {
            this.musicIvPic.setImageResource(R.drawable.content_icon_music_cover);
            this.musicIvPicMask.setVisibility(0);
        }
        if (MusicControl.h0().f.getMusicType() == 0) {
            this.musicIvPlay.setImageDrawable(MusicControl.h0().d.h() ? th4.d(this.u, R.drawable.music_icon_pause_transparent) : th4.d(this.u, R.drawable.music_icon_play_transparent));
        } else if (MusicControl.h0().f.getMusicType() == 2) {
            this.musicIvPlay.setImageDrawable(rd3.f().o() ? th4.d(this.u, R.drawable.music_icon_pause_transparent) : th4.d(this.u, R.drawable.music_icon_play_transparent));
        } else if (MusicControl.h0().f.getMusicType() == 1) {
            this.musicIvPlay.setImageDrawable(MusicControl.h0().e.P() ? th4.d(this.u, R.drawable.music_icon_pause_transparent) : th4.d(this.u, R.drawable.music_icon_play_transparent));
        }
        if (!MusicControl.h0().O()) {
            this.musicTitle.setEllipsize(TextUtils.TruncateAt.END);
            this.musicMsg.setEllipsize(TextUtils.TruncateAt.END);
            return;
        }
        this.musicTitle.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.musicMsg.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        Gson gson = new Gson();
        if (music.getBitmap() != null) {
            music.setBitmap(null);
        }
        eg3.i(this.u, "musicPrevious", gson.toJson(music));
    }

    public final void N2() {
        this.A.showAsDropDown(this.ivNotToy, 0, 0, 0);
        Runnable runnable = new Runnable() { // from class: dc.w23
            @Override // java.lang.Runnable
            public final void run() {
                this.a.s2();
            }
        };
        this.C = runnable;
        this.B.postDelayed(runnable, 3000);
        ye3.j("home", "connect_newbie_guide_exposure", "exposure", "connect toys newbie guide", "", "", "", -1L);
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
            this.toysNumber.setOnClickListener(new View.OnClickListener() { // from class: dc.g43
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.e2(view);
                }
            });
            this.toysNumber.setVisibility(0);
            this.toysNumber.setText(String.format(ah4.c(R.string.multiple_toys), Integer.valueOf(i)));
        }
    }

    public final void R2(String str, final AlarmListItems alarmListItems, boolean z) {
        String str2 = "startAlarmPlay:" + str;
        this.q = false;
        qf3.A(str, z, alarmListItems.getId(), alarmListItems.getPatternId(), new e());
        if (EntityAlarm.AlarmNotiType.fromString(alarmListItems.getNotiType()) == EntityAlarm.AlarmNotiType.sound) {
            WearUtils.z2();
            WearUtils.L1(false, new bg3.c() { // from class: dc.x23
                @Override // dc.bg3.c
                public final String getFilePath() {
                    return HomeFragment.t2(alarmListItems);
                }
            });
        }
    }

    public final void S2() {
        CountDownTimer countDownTimer = this.t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.t = null;
        }
        if (this.mTvHomeControlLinkCountdown.getVisibility() == 0) {
            this.mTvHomeControlLinkCountdown.setVisibility(8);
        }
    }

    public final void V2(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO, String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList<Toy> arrayListP = pc1.a.P();
        if (longTimeControlLinkListDTO.getToys() != null && longTimeControlLinkListDTO.getToys().size() > 0) {
            for (ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.ToysDTO toysDTO : longTimeControlLinkListDTO.getToys()) {
                if (!arrayListP.contains(pc1.a.R(toysDTO.getToyId()))) {
                    arrayList.add(toysDTO.getToyName());
                }
            }
        }
        z2(arrayList, str);
    }

    public void W2() {
        M2();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void arrangeLayout(HomepageArrangeBean homepageArrangeBean) {
        List list;
        MyApplication myApplicationN = MyApplication.N();
        Boolean bool = Boolean.FALSE;
        boolean zBooleanValue = ((Boolean) eg3.b(myApplicationN, "hpspp", bool)).booleanValue();
        boolean zBooleanValue2 = ((Boolean) eg3.b(MyApplication.N(), "hpspm", bool)).booleanValue();
        if (zBooleanValue) {
            this.paternContent.setVisibility(8);
            this.paternPure.setVisibility(0);
        } else {
            this.paternContent.setVisibility(0);
            this.paternPure.setVisibility(8);
        }
        if (zBooleanValue2) {
            this.musicContent.setVisibility(8);
            this.musicPure.setVisibility(0);
        } else {
            this.musicContent.setVisibility(0);
            this.musicPure.setVisibility(8);
        }
        String strH = eg3.h(MyApplication.N(), "homepageSettings", "");
        if (WearUtils.e1(strH) || (list = (List) new Gson().fromJson(strH, List.class)) == null || list.size() == 0) {
            return;
        }
        list.contains(HomepageSettingsActivity.m);
        if (!list.contains(HomepageSettingsActivity.l)) {
            list.add(3, HomepageSettingsActivity.l);
        }
        int childCount = this.composeLayout.getChildCount();
        HashMap map = new HashMap();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.composeLayout.getChildAt(i);
            switch (childAt.getId()) {
                case R.id.home_fra_compose_as /* 2131362905 */:
                    map.put(HomepageSettingsActivity.m, childAt);
                    break;
                case R.id.home_fra_compose_music /* 2131362907 */:
                    map.put(HomepageSettingsActivity.k, childAt);
                    break;
                case R.id.home_fra_compose_pattern /* 2131362908 */:
                    map.put(HomepageSettingsActivity.j, childAt);
                    break;
                case R.id.home_fra_compose_remote /* 2131362909 */:
                    map.put(HomepageSettingsActivity.i, childAt);
                    break;
                case R.id.home_fra_control_link /* 2131362910 */:
                    map.put(HomepageSettingsActivity.l, childAt);
                    break;
            }
        }
        this.composeLayout.removeAllViews();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.composeLayout.addView((View) map.get((String) it.next()));
        }
        map.clear();
    }

    @Override // com.wear.main.closeRange.alarm.ShowAlarmPopwindow.b
    public void c(AlarmListItems alarmListItems) throws ParseException {
        if (alarmListItems == null) {
            return;
        }
        g(1);
        F2(alarmListItems);
        int i = 0;
        while (true) {
            List<AlarmListItems> list = D;
            if (i >= list.size()) {
                list.clear();
                return;
            }
            AlarmListItems alarmListItemsFindById = DaoUtils.getAlarmListDao().findById(list.get(i).getId());
            if (alarmListItemsFindById != null) {
                F2(alarmListItemsFindById);
            }
            i++;
        }
    }

    @OnClick({R.id.home_music_previous, R.id.home_music_play, R.id.home_music_next})
    public void doClick(View view) {
        q61 q61VarN = q61.n(this);
        q61VarN.h("android.permission.READ_MEDIA_AUDIO");
        q61VarN.j(new b(view));
    }

    public void e0(Activity activity) {
        int i = this.n;
        if (i == R.id.sound_space_layout) {
            if (na2.m().i()) {
                na2.m().t();
                return;
            } else {
                pj3.f(activity, SoundPlayActivity.class);
                return;
            }
        }
        if (i == R.id.home_pattern_ll && MyApplication.Z) {
            rf3.l(false);
        }
        l0(activity);
    }

    @Override // com.wear.main.closeRange.music.MusicControl.h
    public void e1(i12 i12Var) {
        int iB = i12Var.b();
        if (iB != 1 && iB != 2) {
            if (iB == 3) {
                int iA = 0;
                try {
                    if (MusicControl.h0().f != null && MusicControl.h0().f.getDuration() > 0) {
                        iA = (i12Var.a() * 100) / MusicControl.h0().f.getDuration();
                    }
                    if (iA > E) {
                        E = iA;
                        this.musicCPV.setProgress(iA);
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    FirebaseCrashlytics.getInstance().recordException(e2);
                    return;
                }
            }
            if (iB != 7) {
                return;
            }
        }
        M2();
    }

    public final void f0(int i) {
        HashMap map = new HashMap();
        map.put("type", Integer.valueOf(i));
        ArrayList arrayList = new ArrayList();
        Iterator<Toy> it = pc1.a.P().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getDeviceId());
        }
        map.put("toy_mac", arrayList);
        ye3.d("M0047", WearUtils.A.toJson(map));
    }

    @Override // com.wear.main.closeRange.alarm.ShowAlarmPopwindow.b
    public void g(int i) {
        Handler handler = G;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        WearUtils.z2();
        qf3.C();
        WearUtils.x.G().u0();
        this.u.o = false;
        F = null;
        K = null;
        x2();
        f0(i);
    }

    public void g0() {
    }

    @Override // dc.tz1
    public int getPriority() {
        return 4;
    }

    public final void h0() {
        if (MusicControl.h0().f != null) {
            if (MusicControl.h0().i == null) {
                if (MusicControl.h0().f.getMusicType() == 1) {
                    MusicControl.h0().F(null, MusicControl.h0().e.i);
                } else {
                    MusicControl.h0().F(null, MusicControl.h0().d.h);
                }
            }
            if (MusicControl.h0().f.getMusicType() != 1 || MainActivity.d0) {
                return;
            }
            EventBus.getDefault().post(new HomeMusicBean(3));
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void homeMusic(HomeMusicBean homeMusicBean) {
        if (homeMusicBean == null || homeMusicBean.getType() != 1) {
            if (homeMusicBean != null && homeMusicBean.getType() == 2) {
                this.musicIvPlay.setImageDrawable(homeMusicBean.isPlaying() ? th4.d(this.u, R.drawable.music_icon_pause_transparent) : th4.d(this.u, R.drawable.music_icon_play_transparent));
                if (!homeMusicBean.isPlaying()) {
                    this.musicMsg.setEllipsize(TextUtils.TruncateAt.END);
                    return;
                }
                this.musicTitle.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                this.musicMsg.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                this.musicTitle.setEllipsize(TextUtils.TruncateAt.END);
                return;
            }
            if (homeMusicBean != null && homeMusicBean.getType() == 5) {
                MainActivity.d0 = true;
                MusicControl.h0().e.Q();
                if (k12.q) {
                    return;
                }
                MusicControl.h0().x(true);
                return;
            }
            if (homeMusicBean != null && homeMusicBean.getType() == 6) {
                x0();
                return;
            }
            if (homeMusicBean != null && homeMusicBean.getType() == 7) {
                this.musicIvPlay.setImageDrawable(MusicControl.h0().O() ? th4.d(this.u, R.drawable.music_icon_pause_transparent) : th4.d(this.u, R.drawable.music_icon_play_transparent));
                if (!MusicControl.h0().O()) {
                    this.musicTitle.setEllipsize(TextUtils.TruncateAt.END);
                    this.musicMsg.setEllipsize(TextUtils.TruncateAt.END);
                    return;
                }
                this.musicTitle.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                this.musicMsg.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                if (MusicControl.h0().f != null) {
                    if (MusicControl.h0().f.getBitmap() != null) {
                        MusicControl.h0().f.setBitmap(null);
                    }
                    eg3.i(this.u, "musicPrevious", new Gson().toJson(MusicControl.h0().f));
                    return;
                }
                return;
            }
            if (homeMusicBean != null && homeMusicBean.getType() == 8) {
                x0();
                return;
            }
            if (homeMusicBean != null && homeMusicBean.getType() == 9) {
                MainActivity.d0 = false;
                MusicControl.h0().e.i.clear();
                x0();
            } else if (homeMusicBean != null && homeMusicBean.getType() == 11) {
                x0();
            } else {
                if (homeMusicBean == null || homeMusicBean.getType() != 13) {
                    return;
                }
                W2();
            }
        }
    }

    public final void i0() {
        if (WearUtils.x.G().N() == null) {
            this.toyDisconnectedTip.setVisibility(0);
        } else {
            this.toyDisconnectedTip.setVisibility(8);
            A2();
        }
    }

    @Override // dc.l22.k
    public void j() {
        y();
        v2();
    }

    public final void j0(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO) {
        if (longTimeControlLinkListDTO == null) {
            return;
        }
        S2();
        if (this.mTvHomeControlLinkCountdown.getVisibility() == 8) {
            this.mTvHomeControlLinkCountdown.setVisibility(0);
        }
        if (this.mTvHomeControlLinkState.getVisibility() == 0) {
            this.mTvHomeControlLinkState.setVisibility(8);
        }
        f fVar = new f(28000L, 1000L, longTimeControlLinkListDTO);
        this.t = fVar;
        fVar.start();
    }

    public void k0() {
        if (getActivity() == null) {
            return;
        }
        final sr3 sr3Var = new sr3(getActivity());
        sr3Var.j(new sr3.c() { // from class: dc.m33
            @Override // dc.sr3.c
            public final void a(Toy toy) {
                this.a.J0(sr3Var, toy);
            }
        });
        sr3Var.show();
    }

    public final void l0(Activity activity) {
        int i = this.n;
        if (i != -1) {
            if (i == R.id.alarm_space_layout) {
                pj3.f(activity, AlarmListActivity.class);
                return;
            }
            if (i == R.id.home_pattern_ll) {
                pj3.f(activity, NewPatternActivity.class);
            } else if (i == R.id.home_music_ll || i == R.id.home_music_play) {
                u2();
            }
        }
    }

    public final void m0() {
        ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTOM = l22.n().m();
        if (longTimeControlLinkListDTOM == null) {
            return;
        }
        if (longTimeControlLinkListDTOM.getCurrentStatus().equals(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.EXPIRED)) {
            R();
            l22.n().u(longTimeControlLinkListDTOM.getLongTimeControlLinkId());
            return;
        }
        if (longTimeControlLinkListDTOM.getCurrentStatus().equals(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.WAITING)) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(longTimeControlLinkListDTOM.getDescription())) {
                sb.append(longTimeControlLinkListDTOM.getDescription());
                sb.append(" ");
            }
            if (longTimeControlLinkListDTOM.getToys() != null && longTimeControlLinkListDTOM.getToys().size() > 0) {
                if (longTimeControlLinkListDTOM.getToys().size() > 1) {
                    sb.append("[");
                    sb.append(longTimeControlLinkListDTOM.getToys().get(0).getToyName());
                    sb.append(", ");
                    sb.append(longTimeControlLinkListDTOM.getToys().get(1).getToyName());
                    sb.append("] ");
                } else {
                    sb.append("[");
                    sb.append(longTimeControlLinkListDTOM.getToys().get(0).getToyName());
                    sb.append("] ");
                }
            }
            if (longTimeControlLinkListDTOM.getHashTags() != null && longTimeControlLinkListDTOM.getHashTags().size() > 0) {
                sb.append("[");
                int i = 0;
                for (String str : longTimeControlLinkListDTOM.getHashTags()) {
                    if (i == 0) {
                        sb.append(str);
                    }
                    if (i == 1) {
                        sb.append("] ");
                        sb.append("[");
                        sb.append(str);
                    }
                    if (i == 2) {
                        sb.append("] ");
                        sb.append("[");
                        sb.append(str);
                    }
                    i++;
                }
                sb.append("] ");
            }
            long[] jArrK = be3.K(longTimeControlLinkListDTOM.getDuration());
            String strZ = be3.z((int) jArrK[0], (int) jArrK[1], (int) jArrK[2]);
            sb.append("[");
            sb.append(strZ);
            sb.append("] ");
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            sb.append(longTimeControlLinkListDTOM.getLongTimeControlLinkUrl());
            V2(longTimeControlLinkListDTOM, sb.toString());
        }
    }

    public final void n0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (MyApplication.Z) {
            V(R.string.offline_control_link);
            return;
        }
        if (getActivity() == null) {
            return;
        }
        if (eg3.d(getActivity(), "control_link_introduce", true)) {
            pj3.f(getActivity(), ControlLinkIntroduceActivity.class);
            eg3.j(getActivity(), "control_link_introduce", false);
            return;
        }
        WearUtils.x.q("controlLink", null);
        Intent intent = new Intent(getActivity(), (Class<?>) CreateControlLinkActivity.class);
        intent.putExtra("isHome", "home");
        pj3.d(intent);
        getActivity().startActivity(intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.alarmSpaceLayout.setOnClickListener(new View.OnClickListener() { // from class: dc.s33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.R0(view);
            }
        });
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: dc.z33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.T0(view);
            }
        };
        this.A = new PopupWindow(LayoutInflater.from(getContext()).inflate(R.layout.first_pop_window, (ViewGroup) null), -2, -2);
        new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f).setDuration(200L);
        this.A.setAnimationStyle(R.style.PopupAnimation);
        this.A.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: dc.p33
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                this.a.W0();
            }
        });
        this.homeFragmentRootLayout.setOnTouchListener(new View.OnTouchListener() { // from class: dc.i33
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.a.c1(view, motionEvent);
            }
        });
        this.remoteControl.setOnClickListener(onClickListener);
        this.patternSpaceLayout.setOnClickListener(new View.OnClickListener() { // from class: dc.z23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.g1(view);
            }
        });
        this.musicSpaceLayout.setOnClickListener(new View.OnClickListener() { // from class: dc.v33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.l1(view);
            }
        });
        this.soundSpaceLayout.setOnClickListener(new View.OnClickListener() { // from class: dc.h33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.n1(view);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.u = MyApplication.N();
        EventBus.getDefault().register(this);
        M(this.u);
        me3.c(me3.c.HOME_UI_ENTER);
        ye3.c("home", "into page", null);
        View viewInflate = layoutInflater.inflate(R.layout.home_fragment, (ViewGroup) null, false);
        this.p = viewInflate;
        ButterKnife.bind(this, viewInflate);
        this.l = k12.m;
        MusicControl.h0().d.a();
        MusicControl.h0().e.a();
        this.s = getActivity();
        this.ivNotToy.setOnClickListener(new View.OnClickListener() { // from class: dc.r33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.q1(view);
            }
        });
        this.rlToy1.setOnClickListener(new View.OnClickListener() { // from class: dc.f33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.H1(view);
            }
        });
        this.rlToy2.setOnClickListener(new View.OnClickListener() { // from class: dc.g33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.K1(view);
            }
        });
        this.titleAdd.setOnClickListener(new View.OnClickListener() { // from class: dc.b43
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.M1(view);
            }
        });
        this.toyDisconnectedTip.setOnClickListener(new View.OnClickListener() { // from class: dc.f43
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.O1(view);
            }
        });
        this.ivPatternAdd.setOnClickListener(new View.OnClickListener() { // from class: dc.a33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Q1(view);
            }
        });
        sz1.d().n(this);
        this.minimizeAlartLayout.setOnClickListener(new View.OnClickListener() { // from class: dc.e43
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.T1(view);
            }
        });
        this.v = new xn3(getActivity(), this.p.findViewById(R.id.oray_bar));
        this.w = new mn3(getContext(), this.p.findViewById(R.id.discord_bar));
        this.lanApiControlStop.setOnClickListener(new View.OnClickListener() { // from class: dc.c43
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.X1(view);
            }
        });
        this.lanApiControlUpdate.setOnClickListener(new View.OnClickListener() { // from class: dc.y23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Z1(view);
            }
        });
        this.tvVideoPatternControlUnsync.setOnClickListener(new View.OnClickListener() { // from class: dc.y33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.t1(view);
            }
        });
        arrangeLayout(null);
        this.ivBanner.setOnClickListener(new View.OnClickListener() { // from class: dc.o33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.w1(view);
            }
        });
        this.mTvHomeItemControlLink.setOnClickListener(new View.OnClickListener() { // from class: dc.q33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                this.a.A1(view);
            }
        });
        this.mIvHomeControlLinkAdd.setOnClickListener(new View.OnClickListener() { // from class: dc.d33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                this.a.D1(view);
            }
        });
        this.mLlHomeControlLinkActivate.setOnClickListener(new View.OnClickListener() { // from class: dc.w33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.F1(view);
            }
        });
        HomePatternPlayUtil homePatternPlayUtil = new HomePatternPlayUtil((BaseActivity) getActivity(), this.u, this.l, this.p);
        this.m = homePatternPlayUtil;
        homePatternPlayUtil.e();
        RecyclerViewNoBugLinearLayoutManager recyclerViewNoBugLinearLayoutManager = new RecyclerViewNoBugLinearLayoutManager(getContext());
        this.o = recyclerViewNoBugLinearLayoutManager;
        recyclerViewNoBugLinearLayoutManager.setOrientation(1);
        z0();
        y0();
        v2();
        l22.n().z(this);
        return this.p;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        EventBus.getDefault().unregister(this);
        sz1.d().s(this);
        MusicControl.h0().K0(this);
        HomePatternPlayUtil homePatternPlayUtil = this.m;
        if (homePatternPlayUtil != null) {
            homePatternPlayUtil.f();
        }
        super.onDestroyView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MusicNotificationEvent musicNotificationEvent) {
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(xc1 xc1Var) {
        Q();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.m.g();
        PopupWindow popupWindow = this.A;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.A.dismiss();
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        be3.J();
        i0();
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
        xn3 xn3Var = this.v;
        if (xn3Var != null) {
            xn3Var.a();
        }
        if (DiscordControl.getInstance().isJoin()) {
            DiscordControl.getInstance().getActivityStatus("");
        }
        this.m.c();
        this.m.h();
        M2();
        H2();
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (ke3.a("new_user", "pop_tips")) {
            J2();
        }
    }

    public final void p0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (getActivity() == null) {
            return;
        }
        if (eg3.d(getActivity(), "control_link_introduce", true)) {
            pj3.f(getActivity(), ControlLinkIntroduceActivity.class);
            eg3.j(getActivity(), "control_link_introduce", false);
        } else {
            WearUtils.x.q("controlLink", null);
            Intent intent = new Intent(getActivity(), (Class<?>) ControlLinkNewActivity.class);
            pj3.d(intent);
            getActivity().startActivity(intent);
        }
    }

    @Override // dc.tz1
    public void pauseConnon(int i) {
    }

    public final void q0() {
        if (K == null || F == null) {
            K = null;
            F = null;
            g(1);
        } else {
            ShowAlarmPopwindow showAlarmPopwindow = this.y;
            if (showAlarmPopwindow != null) {
                showAlarmPopwindow.dismiss();
            }
            ShowAlarmPopwindow showAlarmPopwindow2 = new ShowAlarmPopwindow(MyApplication.H(), F, K, this);
            this.y = showAlarmPopwindow2;
            showAlarmPopwindow2.show();
        }
    }

    public final void r0() {
        if (na2.m().i()) {
            na2.m().t();
        } else if (y12.c.a().s(y12.c.TYPE_PATTERN)) {
            k0();
        }
    }

    @Override // dc.tz1
    public void recovery() {
        this.r = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        xn3 xn3Var;
        super.setUserVisibleHint(z);
        if (!z || (xn3Var = this.v) == null) {
            return;
        }
        xn3Var.a();
    }

    @Override // dc.tz1
    public void stop(int i) throws ParseException {
        this.r = false;
        ShowAlarmPopwindow showAlarmPopwindow = this.y;
        if (showAlarmPopwindow != null) {
            showAlarmPopwindow.dismiss();
            this.y = null;
        }
        c(K);
    }

    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public final void M1(View view) {
        if (WearUtils.y.u() == null) {
            V(R.string.common_login_first);
        } else {
            new hg3().h(this.titleAdd, getContext());
        }
    }

    public final void u0() {
        if (!TextUtils.equals("1", mk2.P().V())) {
            mk2.P().K0(true, 1);
            return;
        }
        is3.b bVar = new is3.b(getContext());
        bVar.p(mk2.P().O());
        bVar.o(getString(R.string.common_yes));
        bVar.d(new is3.d() { // from class: dc.x33
            @Override // dc.is3.d
            public final void doConfirm() {
                this.a.M0();
            }
        });
        cs3.h(bVar).show();
    }

    public final void u2() {
        startActivityForResult(new Intent(requireContext(), (Class<?>) NewMusicActivity.class), 111);
    }

    public final void v0() {
        if (getActivity() != null) {
            this.s = getActivity();
        } else {
            this.s = MyApplication.H();
        }
    }

    public void v2() {
        if (l22.n().k().size() <= 0 || !MyApplication.O) {
            this.mTvHomeControlLinkState.setText(ah4.e(R.string.control_link_no_data));
            this.mTvHomeControlLinkState.setTextColor(th4.b(this.s, R.color.lvs_ui_standard_systemText2));
            this.mTvHomeControlLinkState.setVisibility(0);
            this.mLlHomeControlLinkActivate.setVisibility(8);
            this.mViewState.setVisibility(8);
            S2();
            return;
        }
        ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTOM = l22.n().m();
        if (longTimeControlLinkListDTOM == null) {
            return;
        }
        this.mTvHomeControlLinkTitle.setText(ah4.e(R.string.control_link_brief));
        this.mLlControlLinkState.setVisibility(0);
        this.mViewState.setVisibility(0);
        if (longTimeControlLinkListDTOM.getCurrentStatus().equals(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.EXPIRED)) {
            this.mTvHomeItemControlLinkFunction.setText(ah4.e(R.string.button_reactivate));
            v0();
            FragmentActivity fragmentActivity = this.s;
            if (fragmentActivity != null) {
                this.mViewState.setBackground(th4.d(fragmentActivity, R.drawable.icon_control_link_state_expired));
                this.mIvHomeItemControlLinkOperate.setImageDrawable(th4.d(this.s, R.drawable.icon_reactivate));
            }
            this.mLlHomeControlLinkActivate.setVisibility(0);
            if (longTimeControlLinkListDTOM.isRewaiting()) {
                j0(longTimeControlLinkListDTOM);
            } else {
                S2();
                this.mTvHomeControlLinkState.setText(ah4.e(R.string.common_state_expired));
                if (this.mTvHomeControlLinkState.getVisibility() != 0) {
                    this.mTvHomeControlLinkState.setVisibility(0);
                }
            }
            this.mTvHomeControlLinkState.setTextColor(th4.b(this.s, R.color.lvs_ui_standard_systemText2));
            return;
        }
        if (!longTimeControlLinkListDTOM.getCurrentStatus().equals(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.WAITING)) {
            this.mTvHomeControlLinkState.setText(ah4.e(R.string.auto_tip_state_runing));
            if (this.mTvHomeControlLinkState.getVisibility() != 0) {
                this.mTvHomeControlLinkState.setVisibility(0);
            }
            v0();
            FragmentActivity fragmentActivity2 = this.s;
            if (fragmentActivity2 != null) {
                this.mViewState.setBackground(th4.d(fragmentActivity2, R.drawable.icon_control_link_state_active));
            }
            this.mTvHomeControlLinkState.setTextColor(th4.b(this.s, R.color.lvs_ui_standard_systemText));
            this.mLlHomeControlLinkActivate.setVisibility(8);
            this.mTvHomeControlLinkCountdown.setVisibility(8);
            return;
        }
        if (!TextUtils.equals(this.mTvHomeControlLinkState.getText(), ah4.e(R.string.common_state_waiting))) {
            this.mTvHomeControlLinkState.setText(ah4.e(R.string.common_state_waiting));
        }
        if (this.mTvHomeControlLinkState.getVisibility() != 0) {
            this.mTvHomeControlLinkState.setVisibility(0);
        }
        v0();
        FragmentActivity fragmentActivity3 = this.s;
        if (fragmentActivity3 != null) {
            this.mViewState.setBackground(th4.d(fragmentActivity3, R.drawable.icon_control_link_state_waiting));
            this.mIvHomeItemControlLinkOperate.setImageDrawable(th4.d(this.s, R.drawable.home_share_new));
        }
        this.mTvHomeItemControlLinkFunction.setText(ah4.e(R.string.common_share));
        S2();
        if (this.mLlHomeControlLinkActivate.getVisibility() != 0) {
            this.mLlHomeControlLinkActivate.setVisibility(0);
        }
        this.mTvHomeControlLinkState.setTextColor(th4.b(this.s, R.color.lvs_ui_standard_systemText2));
    }

    public SpannableString w0(String str) {
        String str2 = String.format(ah4.e(R.string.control_link_auto_reactivate_countdown), str);
        int iIndexOf = str2.indexOf(str);
        SpannableString spannableString = new SpannableString(str2);
        if (iIndexOf != -1 && isAdded()) {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.lvs_ui_standard_systemTextRegular)), iIndexOf, str2.length(), 33);
        }
        return spannableString;
    }

    public void w2(LoginOrOfflineEvent loginOrOfflineEvent) {
        if (!loginOrOfflineEvent.isLogin()) {
            xn3 xn3Var = this.v;
            if (xn3Var != null) {
                xn3Var.d(null);
            }
            mn3 mn3Var = this.w;
            if (mn3Var != null) {
                mn3Var.b(null);
            }
            v2();
        }
        this.m.j();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void x0() {
        /*
            Method dump skipped, instructions count: 402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.home.HomeFragment.x0():void");
    }

    public void x2() {
        if (WearUtils.e1(F)) {
            F = null;
            this.minimizeAlartLayout.setVisibility(8);
            this.toyAlartTip.setVisibility(8);
            i0();
            this.minimizeAlartLayout.setTag(null);
        } else {
            this.toyAlartTip.setVisibility(0);
            this.minimizeAlartLayout.setVisibility(0);
            this.minimizeAlartNotice.setText(F);
        }
        AlarmListItems alarmListItems = K;
        if (alarmListItems == null || WearUtils.e1(alarmListItems.getTime())) {
            F = null;
            this.minimizeAlartLayout.setVisibility(8);
            this.toyAlartTip.setVisibility(8);
            i0();
            this.minimizeAlartLayout.setTag(null);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void y0() {
        this.musicIvPlay.setOnTouchListener(this.k);
        this.musicIvPrevious.setOnTouchListener(this.k);
        this.musicIvNext.setOnTouchListener(this.k);
        this.ivPatternAdd.setOnTouchListener(this.k);
        this.homePatternPrevious.setOnTouchListener(this.k);
        this.homePatternPlay.setOnTouchListener(this.k);
        this.homePatternNext.setOnTouchListener(this.k);
    }

    public final void z0() {
        EventBus.getDefault().post(new HomeMusicBean(4));
        A0();
        x0();
    }

    public void z2(List<String> list, final String str) {
        String strSubstring;
        StringBuilder sb = new StringBuilder();
        if (list == null || list.size() <= 0) {
            strSubstring = "";
        } else {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
            strSubstring = sb.substring(0, sb.length() - 1);
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        if (list.size() != 0) {
            cs3.c(getActivity(), list.size() > 1 ? String.format(ah4.e(R.string.notification_toys_disconnected), strSubstring) : String.format(ah4.e(R.string.notification_toy_disconnected), strSubstring), ah4.e(R.string.common_share), ah4.e(R.string.common_cancel), new is3.d() { // from class: dc.j33
                @Override // dc.is3.d
                public final void doConfirm() {
                    this.a.c2(str);
                }
            }).show();
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        startActivity(Intent.createChooser(intent, ah4.e(R.string.control_link_title)));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(OrgySettingEvent orgySettingEvent) {
        xn3 xn3Var = this.v;
        if (xn3Var != null) {
            xn3Var.d(orgySettingEvent);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(DiscordEvent discordEvent) {
        mn3 mn3Var = this.w;
        if (mn3Var != null) {
            mn3Var.b(discordEvent);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(AlarmShowEvent alarmShowEvent) {
        if (alarmShowEvent == null) {
            return;
        }
        ShowAlarmPopwindow showAlarmPopwindow = this.y;
        if (showAlarmPopwindow != null) {
            showAlarmPopwindow.dismiss();
        }
        zt3.r(this.u, K);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(AlarmListItems alarmListItems) throws ParseException {
        AlarmListItems alarmListItems2;
        if (alarmListItems == null) {
            return;
        }
        if (!this.r) {
            c(alarmListItems);
            return;
        }
        if (na2.m().f() || h32.i().l() || my2.i.a().getB()) {
            return;
        }
        MusicControl.h0().S();
        y12.c.a().t();
        if (this.u.o && (alarmListItems2 = K) != null) {
            c(alarmListItems2);
            I2(alarmListItems);
        } else {
            D.clear();
            I2(alarmListItems);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(LoginStatusActionEvent loginStatusActionEvent) {
        if (MyApplication.Z) {
            v2();
        } else {
            l22.n().s(false, true);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(RefreshControlLinkList refreshControlLinkList) {
        v2();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(SetSyncCommonDataEvent setSyncCommonDataEvent) {
        G2();
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
    public void onMessageEvent(PatternDownloadEvent patternDownloadEvent) {
        this.m.k();
    }
}
