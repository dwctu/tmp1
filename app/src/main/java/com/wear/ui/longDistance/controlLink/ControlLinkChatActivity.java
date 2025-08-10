package com.wear.ui.longDistance.controlLink;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.fastjson.JSON;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.tencent.qgame.animplayer.AnimView;
import com.wear.adapter.longdistance.ControlLinkMessageAdapter;
import com.wear.bean.Account;
import com.wear.bean.ControlLinkBean;
import com.wear.bean.DpgEventConfigBean;
import com.wear.bean.NewDpgEventConfigBean;
import com.wear.bean.User;
import com.wear.bean.UserControlLink;
import com.wear.bean.event.AddFriendsAckClEvent;
import com.wear.bean.event.AddFriendsReqTcEvent;
import com.wear.bean.event.AddFriendsTimeEvent;
import com.wear.bean.event.ControlLinkChatControlEnd;
import com.wear.bean.event.ControlLinkDownTimeEvent;
import com.wear.bean.event.InputResizeEvent;
import com.wear.bean.event.RefreshOpenfireFriendTc;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.bean.socketio.controlLink.response.QueryUserOnlineResponse;
import com.wear.dao.ControlLinkCommunMessageDao;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.main.MainActivity;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.longDistance.control.ChatLiveControl;
import com.wear.main.longDistance.control.ChatSyncControl;
import com.wear.network.protocol.exception.NetException;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntityAudio;
import com.wear.protocol.EntityChat;
import com.wear.protocol.EntityControlLinkTimer;
import com.wear.protocol.EntityControllink;
import com.wear.protocol.EntityLive;
import com.wear.protocol.EntityPattern;
import com.wear.protocol.EntityPicture;
import com.wear.protocol.EntitySync;
import com.wear.protocol.EntitySystem;
import com.wear.protocol.MessageType;
import com.wear.protocol.controlLink.ControlLinkCommunMessage;
import com.wear.ui.chat.fragment.ChatActionMenuFragmentBottom;
import com.wear.ui.longDistance.controlLink.ControlLinkChatActivity;
import com.wear.util.MyApplication;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import com.wear.widget.ChatEditText;
import com.wear.widget.CustomSwipeRefreshLayout;
import com.wear.widget.EmojisToastView;
import com.wear.widget.FallingView;
import com.wear.widget.MyActionBar;
import com.wear.widget.chatMic.ChatEmojisPanel;
import com.wear.widget.chatMic.ChatInputPanel;
import com.wear.widget.chatMic.ChatInputPanelPto;
import com.wear.widget.chatMic.ChatMorePanel;
import com.wear.widget.chatMic.VoiceMessagePanelView;
import com.wear.widget.control.CoustomLinearLayout;
import com.wear.widget.dialog.LoveEmojisDialog;
import com.wear.widget.velvo.VelvoPreviewView;
import com.wear.xmpp.FragmentStateLossActivity;
import dc.ah0;
import dc.ah4;
import dc.be3;
import dc.bo3;
import dc.c83;
import dc.cg3;
import dc.cs3;
import dc.cv1;
import dc.d83;
import dc.dh1;
import dc.di1;
import dc.dq2;
import dc.eg3;
import dc.eq2;
import dc.fh0;
import dc.fq2;
import dc.gq2;
import dc.gu3;
import dc.h12;
import dc.hf3;
import dc.hh0;
import dc.hq2;
import dc.hu3;
import dc.ie3;
import dc.iq2;
import dc.is3;
import dc.iv1;
import dc.ke3;
import dc.l22;
import dc.lg3;
import dc.ma2;
import dc.me3;
import dc.mf2;
import dc.na2;
import dc.ng1;
import dc.od3;
import dc.pj3;
import dc.qe3;
import dc.qf3;
import dc.ro2;
import dc.sg3;
import dc.so3;
import dc.tn2;
import dc.ue3;
import dc.uj1;
import dc.vd0;
import dc.vg3;
import dc.xe3;
import dc.xr3;
import dc.ye3;
import dc.yn2;
import dc.z73;
import dc.zn2;
import dc.zt3;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* loaded from: classes4.dex */
public class ControlLinkChatActivity extends FragmentStateLossActivity implements ma2, ie3.m, View.OnClickListener, CustomSwipeRefreshLayout.a, ControlLinkMessageAdapter.x, cv1, VoiceMessagePanelView.b, ChatActionMenuFragmentBottom.d {
    public static long z0;
    public FallingView C;
    public ChatInputPanel G;
    public ImageView K;
    public ImageView L;
    public ChatEmojisPanel M;
    public ImageView N;
    public LinearLayout O;
    public TextView P;
    public CustomSwipeRefreshLayout Q;
    public EmojisToastView R;
    public LottieAnimationView S;
    public VelvoPreviewView T;
    public Handler V;
    public String Y;
    public ImageButton Z;
    public View a0;
    public View b;
    public TextView b0;
    public MyActionBar c;
    public Account c0;
    public ChatEditText d;
    public String d0;
    public RecyclerView e;
    public UserControlLink e0;
    public View f;
    public ControlLinkMessageAdapter f0;
    public View g;
    public ControlLinkBean g0;
    public View h;
    public ChatMorePanel i;
    public String i0;
    public View j;
    public String j0;
    public View k;
    public ControlLinkCommunMessage k0;
    public View l;
    public View m;
    public c83 m0;
    public View n;
    public int n0;
    public View o;
    public boolean o0;
    public ViewGroup p;
    public long p0;
    public CoustomLinearLayout q;
    public boolean q0;
    public AnimView r0;
    public View s;
    public FrameLayout s0;
    public SubsamplingScaleImageView t;
    public ImageView t0;
    public ProgressBar u;
    public ChatActionMenuFragmentBottom u0;
    public z73 v;
    public Runnable v0;
    public Runnable w0;
    public LinearLayoutManager x;
    public Runnable x0;
    public long y0;
    public long z;
    public boolean w = true;
    public boolean y = true;
    public xr3 A = null;
    public boolean B = false;
    public CountDownTimer D = null;
    public boolean E = false;
    public uj1 F = new uj1();
    public int U = 0;
    public ie3 W = new ie3();
    public so3 X = new so3();
    public boolean h0 = true;
    public List<String> l0 = new ArrayList();

    public class a implements Function1<Boolean, Unit> {
        public a(ControlLinkChatActivity controlLinkChatActivity) {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool) {
            if (bool.booleanValue()) {
                MyApplication.h0 = true;
                return null;
            }
            DaoUtils.getTestValueDao().save(zt3.k, "1", TestValueDao.CONTROL_LINK_CHAT_NOTE);
            return null;
        }
    }

    public class a0 implements zn2<String> {
        public final /* synthetic */ EntityAudio a;
        public final /* synthetic */ ControlLinkCommunMessage b;

        public class a implements Runnable {
            public final /* synthetic */ NormalResponse a;

            public a(NormalResponse normalResponse) {
                this.a = normalResponse;
            }

            @Override // java.lang.Runnable
            public void run() {
                a0.this.a.setUrl(this.a.getMessage());
                a0 a0Var = a0.this;
                a0Var.b.sendEntity(a0Var.a, ControlLinkChatActivity.this.g0.getX(), ControlLinkChatActivity.this.g0.getY());
                a0 a0Var2 = a0.this;
                ControlLinkChatActivity.this.X5(a0Var2.b, false);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a0 a0Var = a0.this;
                ControlLinkChatActivity.this.W5(a0Var.b, false);
            }
        }

        public a0(EntityAudio entityAudio, ControlLinkCommunMessage controlLinkCommunMessage) {
            this.a = entityAudio;
            this.b = controlLinkCommunMessage;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            NormalResponse normalResponse;
            if (WearUtils.e1(str) || (normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class)) == null || !normalResponse.isResult()) {
                return;
            }
            ControlLinkChatActivity.this.runOnUiThread(new a(normalResponse));
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            ControlLinkChatActivity.this.runOnUiThread(new b());
        }
    }

    public class b implements MyActionBar.f {
        public b() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            if (ControlLinkChatActivity.t5()) {
                ControlLinkChatActivity.this.finish();
            }
        }
    }

    public class b0 implements zn2<String> {
        public b0(ControlLinkChatActivity controlLinkChatActivity) {
        }

        public static /* synthetic */ void b(NewDpgEventConfigBean newDpgEventConfigBean) {
            Bitmap bitmapC2 = WearUtils.c2(newDpgEventConfigBean.getData().getAppEventImgUrl());
            if (bitmapC2 != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmapC2.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                c83.R1().G2(byteArrayOutputStream.toByteArray());
            }
        }

        @Override // dc.zn2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            final NewDpgEventConfigBean newDpgEventConfigBean = (NewDpgEventConfigBean) ro2.a(str, NewDpgEventConfigBean.class);
            if (!newDpgEventConfigBean.isResult() || newDpgEventConfigBean.getData() == null) {
                c83.R1().z2(null);
                return;
            }
            if (c83.R1().Y1() != null) {
                c83.R1().G2(null);
            }
            try {
                new Thread(new Runnable() { // from class: dc.u73
                    @Override // java.lang.Runnable
                    public final void run() {
                        ControlLinkChatActivity.b0.b(newDpgEventConfigBean);
                    }
                }).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            c83.R1().z2(newDpgEventConfigBean);
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            netException.getMessage();
        }
    }

    public class c implements is3.d {
        public c(ControlLinkChatActivity controlLinkChatActivity) {
        }

        @Override // dc.is3.d
        public void doConfirm() {
        }
    }

    public class c0 implements zn2<String> {
        public final /* synthetic */ ControlLinkCommunMessage a;

        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (WearUtils.e1(this.a)) {
                    c0 c0Var = c0.this;
                    ControlLinkChatActivity.this.R5(null, c0Var.a, 4);
                    ControlLinkChatActivity.this.y5(ah4.e(R.string.common_serverError));
                    return;
                }
                NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(this.a, NormalResponse.class);
                if (normalResponse.isResult()) {
                    ControlLinkChatActivity.this.R5(normalResponse.getMessage(), c0.this.a, 0);
                    return;
                }
                c0 c0Var2 = c0.this;
                ControlLinkChatActivity.this.R5(null, c0Var2.a, 4);
                ControlLinkChatActivity.this.y5(normalResponse.getMessage());
            }
        }

        public c0(ControlLinkCommunMessage controlLinkCommunMessage) {
            this.a = controlLinkCommunMessage;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            ControlLinkChatActivity.this.V.post(new a(str));
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            ControlLinkChatActivity.this.R5(null, this.a, 4);
            ControlLinkChatActivity.this.y5(netException.getMessage());
        }
    }

    public class d implements iv1 {
        public d() {
        }

        @Override // dc.iv1
        public void next() {
            ControlLinkChatActivity.this.finish();
        }
    }

    public class d0 implements bo3.d {
        public final /* synthetic */ ControlLinkCommunMessage a;

        public d0(ControlLinkCommunMessage controlLinkCommunMessage) {
            this.a = controlLinkCommunMessage;
        }

        @Override // dc.bo3.d
        public void a(int i) {
            ControlLinkChatActivity.this.I5(this.a);
        }
    }

    public class e implements is3.d {
        public e() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            ControlLinkChatActivity.this.m0.F2(true);
            ControlLinkChatActivity.this.m0.H1("manual", false);
            if (ControlLinkChatActivity.this.m0.r.r()) {
                ye3.c(null, "ended control link live control", ControlLinkChatActivity.this.d0);
            } else if (ControlLinkChatActivity.this.m0.s.r()) {
                ye3.c(null, "ended control link sync control", ControlLinkChatActivity.this.d0);
            }
        }
    }

    public class e0 implements Runnable {
        public final /* synthetic */ View a;

        public e0(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup viewGroup = (ViewGroup) this.a.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.a);
            }
            ControlLinkChatActivity.this.q.setVisibility(0);
            ControlLinkChatActivity.this.q.addView(this.a);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ControlLinkChatActivity.this.r6(false);
        }
    }

    public class f0 implements Animator.AnimatorListener {
        public f0() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (ControlLinkChatActivity.this.l0.isEmpty()) {
                ControlLinkChatActivity.this.S.setProgress(0.0f);
                ControlLinkChatActivity.this.S.setVisibility(8);
            } else {
                ControlLinkChatActivity.this.s0.setVisibility(8);
                ControlLinkChatActivity.this.W.O(ControlLinkChatActivity.this.S, (String) ControlLinkChatActivity.this.l0.get(0));
                ControlLinkChatActivity.this.l0.remove(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ControlLinkChatActivity controlLinkChatActivity = ControlLinkChatActivity.this;
            ue3.d(controlLinkChatActivity.d, controlLinkChatActivity);
        }
    }

    public class g0 implements iv1 {
        public g0() {
        }

        @Override // dc.iv1
        public void next() {
            ControlLinkChatActivity.this.finish();
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ControlLinkChatActivity.this.g.setVisibility(0);
            ControlLinkChatActivity.this.f.setVisibility(0);
            ControlLinkChatActivity.this.h.setVisibility(0);
        }
    }

    public class h0 implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ boolean b;

        public h0(int i, boolean z) {
            this.a = i;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ControlLinkCommunMessage next;
            if (ControlLinkChatActivity.this.m0.T1().isEmpty()) {
                next = null;
            } else {
                Iterator<ControlLinkCommunMessage> it = ControlLinkChatActivity.this.m0.T1().iterator();
                while (it.hasNext()) {
                    next = it.next();
                    if (next.getMsgType() == MessageType.controllinktimer) {
                        break;
                    }
                }
                next = null;
            }
            if (next == null) {
                ControlLinkCommunMessage controlLinkCommunMessageA5 = ControlLinkChatActivity.this.A5(this.a, this.b);
                ControlLinkChatActivity.this.m0.T1().add(controlLinkCommunMessageA5);
                ControlLinkChatActivity.this.a5(controlLinkCommunMessageA5, true);
                if (ControlLinkChatActivity.this.f0 != null) {
                    ControlLinkChatActivity.this.f0.notifyItemInserted(ControlLinkChatActivity.this.m0.T1().indexOf(controlLinkCommunMessageA5));
                }
                ControlLinkChatActivity.this.m0.R2(controlLinkCommunMessageA5.getId());
                return;
            }
            EntityControlLinkTimer entityControlLinkTimer = (EntityControlLinkTimer) next.getDataBean();
            if (this.a == -1) {
                entityControlLinkTimer.setCancel(true);
                ControlLinkChatActivity.this.m0.S2(next.getId());
            }
            if (ControlLinkChatActivity.this.f0 != null) {
                ControlLinkChatActivity.this.f0.notifyItemChanged(ControlLinkChatActivity.this.m0.T1().indexOf(next), "updateRemainTime");
            }
        }
    }

    public class i implements is3.c {
        public final /* synthetic */ iv1 a;

        public i(iv1 iv1Var) {
            this.a = iv1Var;
        }

        @Override // dc.is3.c
        public void doCancel() {
            ControlLinkChatActivity.this.m0.L2(false);
            iv1 iv1Var = this.a;
            if (iv1Var != null) {
                iv1Var.next();
            }
        }
    }

    public class i0 implements yn2<BaseResponseBeanNew> {
        public i0() {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBeanNew baseResponseBeanNew) {
            if (baseResponseBeanNew != null) {
                if (baseResponseBeanNew.result) {
                    ControlLinkChatActivity.this.m0.E2(1);
                } else {
                    ControlLinkChatActivity.this.m0.E2(2);
                }
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public class j implements is3.d {
        public final /* synthetic */ is3.c a;

        public j(is3.c cVar) {
            this.a = cVar;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            this.a.doCancel();
            od3.d(ControlLinkChatActivity.this.activity);
        }
    }

    public class j0 implements Runnable {
        public final /* synthetic */ int a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ControlLinkChatActivity controlLinkChatActivity = ControlLinkChatActivity.this;
                controlLinkChatActivity.A.G(controlLinkChatActivity.c);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ControlLinkChatActivity controlLinkChatActivity = ControlLinkChatActivity.this;
                controlLinkChatActivity.A.G(controlLinkChatActivity.c);
            }
        }

        public j0(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ControlLinkChatActivity controlLinkChatActivity = ControlLinkChatActivity.this;
            if (controlLinkChatActivity.A != null) {
                if (controlLinkChatActivity.m0.W1() == this.a) {
                    return;
                }
                ControlLinkChatActivity.this.A.d();
                ControlLinkChatActivity.this.A = null;
            }
            ControlLinkChatActivity controlLinkChatActivity2 = ControlLinkChatActivity.this;
            controlLinkChatActivity2.A = new xr3(controlLinkChatActivity2, controlLinkChatActivity2.g0);
            int i = this.a;
            if (i != 1) {
                if (i == 2) {
                    ControlLinkChatActivity.this.A.x();
                    ControlLinkChatActivity.this.c.post(new a());
                    ControlLinkChatActivity.this.g5();
                    ControlLinkChatActivity.this.B = true;
                } else if (i == 3) {
                    ControlLinkChatActivity.this.A.v();
                    ControlLinkChatActivity.this.c.post(new b());
                    ControlLinkChatActivity controlLinkChatActivity3 = ControlLinkChatActivity.this;
                    controlLinkChatActivity3.B = true;
                    controlLinkChatActivity3.z5(2);
                } else if (i == 4 && ControlLinkChatActivity.this.A.p()) {
                    ControlLinkChatActivity.this.A.d();
                }
            } else {
                if (d83.w().F().f() || d83.w().D().e()) {
                    d83.w().L(true);
                    return;
                }
                ControlLinkChatActivity.this.d6();
            }
            ControlLinkChatActivity.this.m0.D2(this.a);
        }
    }

    public class k implements TextWatcher {
        public k() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ControlLinkChatActivity.this.C5(charSequence.length() == 0);
        }
    }

    public class k0 extends CountDownTimer {
        public k0(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ControlLinkChatActivity.this.D.cancel();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            xr3 xr3Var;
            if (j != 0 || (xr3Var = ControlLinkChatActivity.this.A) == null) {
                return;
            }
            xr3Var.w();
        }
    }

    public class l implements is3.c {
        public l(ControlLinkChatActivity controlLinkChatActivity) {
        }

        @Override // dc.is3.c
        public void doCancel() {
        }
    }

    public class l0 implements FallingView.d {
        public l0() {
        }

        @Override // com.wear.widget.FallingView.d
        public void onStart() {
        }

        @Override // com.wear.widget.FallingView.d
        public void onStop() {
            ControlLinkChatActivity.this.C.setVisibility(8);
        }
    }

    public class m implements is3.d {
        public m() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            od3.d(ControlLinkChatActivity.this.activity);
        }
    }

    public class m0 implements dh1 {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ControlLinkChatActivity.this.s0.setVisibility(8);
                ControlLinkChatActivity.this.t0.setVisibility(8);
                ControlLinkChatActivity.this.r0.setVisibility(8);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ControlLinkChatActivity.this.s0.setVisibility(8);
                ControlLinkChatActivity.this.t0.setVisibility(8);
                ControlLinkChatActivity.this.r0.setVisibility(8);
            }
        }

        public m0() {
        }

        @Override // dc.dh1
        public void a() {
        }

        @Override // dc.dh1
        public void b() {
            ControlLinkChatActivity.this.runOnUiThread(new a());
        }

        @Override // dc.dh1
        public void c(int i, @Nullable String str) {
            ControlLinkChatActivity.this.runOnUiThread(new b());
        }

        @Override // dc.dh1
        public void d() {
        }

        @Override // dc.dh1
        public void e(int i, @Nullable ng1 ng1Var) {
        }

        @Override // dc.dh1
        public boolean f(@NonNull ng1 ng1Var) {
            return true;
        }
    }

    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ControlLinkChatActivity.this.r6(true);
        }
    }

    public class n0 implements Function1<Boolean, Unit> {
        public final /* synthetic */ d83.d a;

        public n0(d83.d dVar) {
            this.a = dVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool) {
            if (!bool.booleanValue()) {
                return null;
            }
            d83.w().g(d83.c.cancel, this.a, ControlLinkChatActivity.this.j0);
            d83.w().R();
            ye3.g("control_link_permission_cancel_click", "click", "control_link_permission_cancel", "button", "1", ControlLinkChatActivity.this.j0, JSON.toJSONString(WearUtils.x.G().m()));
            return null;
        }
    }

    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ControlLinkChatActivity.this.q6();
        }
    }

    public class o0 implements Runnable {
        public o0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ControlLinkChatActivity controlLinkChatActivity = ControlLinkChatActivity.this;
            controlLinkChatActivity.A.G(controlLinkChatActivity.c);
        }
    }

    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ControlLinkChatActivity.this.isFinishing() || ControlLinkChatActivity.this.isDestroyed() || ControlLinkChatActivity.this.f0 == null) {
                return;
            }
            ControlLinkChatActivity.this.f0.notifyDataSetChanged();
        }
    }

    public static /* synthetic */ class p0 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MessageType.values().length];
            a = iArr;
            try {
                iArr[MessageType.chat.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[MessageType.audio.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[MessageType.picture.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public class q implements Action1<Long> {
        public q() {
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Long l) {
            try {
                LinearLayoutManager linearLayoutManager = ControlLinkChatActivity.this.x;
                if (linearLayoutManager != null) {
                    if (linearLayoutManager.getItemCount() > 0) {
                        ControlLinkChatActivity.this.H1(true);
                    }
                    if (ControlLinkChatActivity.this.x.getItemCount() > 0) {
                        LinearLayoutManager linearLayoutManager2 = ControlLinkChatActivity.this.x;
                        linearLayoutManager2.scrollToPosition(linearLayoutManager2.getItemCount() - 1);
                    }
                }
            } catch (Exception e) {
                FirebaseCrashlytics.getInstance().recordException(e);
            }
        }
    }

    public class q0 implements View.OnClickListener {
        public q0(ControlLinkChatActivity controlLinkChatActivity) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class r implements mf2 {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ControlLinkChatActivity.this.dissDialog();
                if (ControlLinkChatActivity.this.m0.u) {
                    ControlLinkChatActivity.this.m0.q2();
                    if (!ControlLinkChatActivity.this.h0) {
                        ControlLinkChatActivity.this.m0.P2(ControlLinkChatActivity.this.e0, ControlLinkChatActivity.this.h0, ControlLinkChatActivity.this.c);
                    } else if (d83.w().I()) {
                        if (d83.w().l()) {
                            ControlLinkChatActivity.this.m0.P2(ControlLinkChatActivity.this.e0, ControlLinkChatActivity.this.h0, ControlLinkChatActivity.this.c);
                        } else {
                            ControlLinkChatActivity.this.k6(d83.c.request, d83.d.live_control, false);
                        }
                    }
                    HashMap map = new HashMap();
                    map.put(TtmlNode.ATTR_ID, ControlLinkChatActivity.this.j0);
                    ye3.d("F0024", WearUtils.A.toJson(map));
                    WearUtils.x.q("control_link_control_with_live_control", null);
                }
            }
        }

        public class b implements Runnable {
            public final /* synthetic */ String a;

            public b(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                ControlLinkChatActivity.this.dissDialog();
                if (ControlLinkChatActivity.this.m0.u) {
                    QueryUserOnlineResponse queryUserOnlineResponse = (QueryUserOnlineResponse) JSON.parseObject(this.a, QueryUserOnlineResponse.class);
                    if (ControlLinkChatActivity.this.h0) {
                        ControlLinkChatActivity.this.m0.q2();
                        if (!d83.w().I()) {
                            ControlLinkChatActivity.this.n6(true);
                            return;
                        } else if (d83.w().l()) {
                            ControlLinkChatActivity.this.n6(true);
                            return;
                        } else {
                            ControlLinkChatActivity.this.k6(d83.c.request, d83.d.live_control, false);
                            return;
                        }
                    }
                    if ((!queryUserOnlineResponse.isOnIos() && !queryUserOnlineResponse.isOnAndroid()) || !queryUserOnlineResponse.getAppPage().equals("control_link")) {
                        sg3.l(ah4.e(R.string.control_link_another_unavailable));
                        ControlLinkChatActivity.this.m0.r.T0(MessageType.live);
                    } else {
                        ControlLinkChatActivity.this.m0.q2();
                        if (ControlLinkChatActivity.this.m0.f2(queryUserOnlineResponse)) {
                            ControlLinkChatActivity.this.m0.P2(ControlLinkChatActivity.this.e0, ControlLinkChatActivity.this.h0, ControlLinkChatActivity.this.c);
                        }
                    }
                }
            }
        }

        public r() {
        }

        @Override // dc.mf2
        public void Q(String str) {
            ControlLinkChatActivity.this.runOnMainThread(new b(str));
        }

        @Override // dc.mf2
        public void a(Throwable th) {
            ControlLinkChatActivity.this.runOnMainThread(new a());
        }
    }

    public class r0 implements View.OnTouchListener {
        public r0() {
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            ControlLinkChatActivity.this.E5();
            ControlLinkChatActivity.this.G.o();
            return false;
        }
    }

    public class s implements mf2 {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ControlLinkChatActivity.this.dissDialog();
                if (ControlLinkChatActivity.this.m0.u) {
                    if (!ControlLinkChatActivity.this.h0) {
                        ControlLinkChatActivity.this.m0.Q2(ControlLinkChatActivity.this.e0, ControlLinkChatActivity.this.h0, ControlLinkChatActivity.this.c);
                    } else if (d83.w().I()) {
                        if (d83.w().m()) {
                            ControlLinkChatActivity.this.m0.Q2(ControlLinkChatActivity.this.e0, ControlLinkChatActivity.this.h0, ControlLinkChatActivity.this.c);
                        } else {
                            ControlLinkChatActivity.this.k6(d83.c.request, d83.d.sync_control, false);
                        }
                    }
                    HashMap map = new HashMap();
                    map.put(TtmlNode.ATTR_ID, ControlLinkChatActivity.this.j0);
                    ye3.d("F0025", WearUtils.A.toJson(map));
                    WearUtils.x.q("control_link_control_with_sync_control", null);
                }
            }
        }

        public class b implements Runnable {
            public final /* synthetic */ String a;

            public b(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                ControlLinkChatActivity.this.dissDialog();
                if (ControlLinkChatActivity.this.m0.u) {
                    QueryUserOnlineResponse queryUserOnlineResponse = (QueryUserOnlineResponse) JSON.parseObject(this.a, QueryUserOnlineResponse.class);
                    if (!ControlLinkChatActivity.this.h0) {
                        if ((queryUserOnlineResponse.isOnIos() || queryUserOnlineResponse.isOnAndroid()) && queryUserOnlineResponse.getAppPage().equals("control_link")) {
                            ControlLinkChatActivity.this.m0.s2();
                            return;
                        } else {
                            sg3.l(ah4.e(R.string.control_link_another_unavailable));
                            ControlLinkChatActivity.this.m0.s.k1(MessageType.sync);
                            return;
                        }
                    }
                    ControlLinkChatActivity.this.m0.s2();
                    if (d83.w().I()) {
                        if (d83.w().m()) {
                            ControlLinkChatActivity.this.m0.Q2(ControlLinkChatActivity.this.e0, ControlLinkChatActivity.this.h0, ControlLinkChatActivity.this.c);
                        } else {
                            ControlLinkChatActivity.this.k6(d83.c.request, d83.d.sync_control, false);
                        }
                    }
                    HashMap map = new HashMap();
                    map.put(TtmlNode.ATTR_ID, ControlLinkChatActivity.this.j0);
                    ye3.d("F0025", WearUtils.A.toJson(map));
                    WearUtils.x.q("control_link_control_with_sync_control", null);
                }
            }
        }

        public s() {
        }

        @Override // dc.mf2
        public void Q(String str) {
            ControlLinkChatActivity.this.runOnMainThread(new b(str));
        }

        @Override // dc.mf2
        public void a(Throwable th) {
            ControlLinkChatActivity.this.runOnMainThread(new a());
        }
    }

    public class s0 implements View.OnTouchListener {
        public float a = 0.0f;
        public float b = 0.0f;

        public s0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.a = motionEvent.getY();
            } else if (action == 1) {
                float y = motionEvent.getY();
                this.b = y;
                if (this.a <= y) {
                    ControlLinkChatActivity.this.o0 = false;
                    ControlLinkChatActivity.this.f5();
                } else {
                    ControlLinkChatActivity.this.o0 = true;
                }
            }
            return false;
        }
    }

    public class t implements mf2 {
        public t(ControlLinkChatActivity controlLinkChatActivity) {
        }

        @Override // dc.mf2
        public void Q(String str) {
        }

        @Override // dc.mf2
        public void a(Throwable th) {
        }
    }

    public class t0 extends RecyclerView.OnScrollListener {
        public t0() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            LinearLayoutManager linearLayoutManager;
            ControlLinkChatActivity controlLinkChatActivity = ControlLinkChatActivity.this;
            controlLinkChatActivity.w = false;
            if (i == 0 && (linearLayoutManager = controlLinkChatActivity.x) != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == ControlLinkChatActivity.this.x.getItemCount() - 1) {
                ControlLinkChatActivity.this.w = true;
            }
        }
    }

    public class u implements mf2 {
        public u(ControlLinkChatActivity controlLinkChatActivity) {
        }

        @Override // dc.mf2
        public void Q(String str) {
        }

        @Override // dc.mf2
        public void a(Throwable th) {
        }
    }

    public class u0 implements SwipeRefreshLayout.OnRefreshListener {
        public u0() {
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            ControlLinkChatActivity.this.Q.setRefreshing(true);
            ControlLinkChatActivity.this.l5();
        }
    }

    public class v implements CoustomLinearLayout.a {
        public v() {
        }

        @Override // com.wear.widget.control.CoustomLinearLayout.a
        public void a(int i, int i2, int i3, int i4) {
            xe3.a("ControlLinkChatActivity", "chat_live_layer:" + i + " " + i2);
            if (System.currentTimeMillis() - ControlLinkChatActivity.this.p0 < 100) {
                return;
            }
            View viewFindViewById = ControlLinkChatActivity.this.findViewById(R.id.v_chat_live_layer);
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = i2;
            viewFindViewById.setLayoutParams(layoutParams);
            viewFindViewById.invalidate();
            ControlLinkChatActivity.this.M5();
            String str = "chatLiveSyncLayer onSizeChanged h: " + i2;
            if (i2 > 0) {
                ControlLinkChatActivity.this.n0 = i2;
                ControlLinkChatActivity.this.G.getLastPanelType();
                fh0 fh0Var = fh0.LAYER;
                ControlLinkChatActivity.this.G.m(true, i2);
            }
        }

        @Override // com.wear.widget.control.CoustomLinearLayout.a
        public void b(int i) {
        }
    }

    public class v0 implements View.OnClickListener {
        public v0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ControlLinkChatActivity.this.s.setVisibility(8);
        }
    }

    public class w implements Runnable {
        public final /* synthetic */ List a;

        public w(ControlLinkChatActivity controlLinkChatActivity, List list) {
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            DaoUtils.getControlLinkCommunMessageDao().update(this.a);
        }
    }

    public class x implements Runnable {
        public final /* synthetic */ long a;

        public x(long j) {
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ControlLinkChatActivity.this.P == null) {
                return;
            }
            long[] jArrK = be3.K((int) this.a);
            ControlLinkChatActivity.this.P.setText(be3.z((int) jArrK[0], (int) jArrK[1], (int) jArrK[2]));
        }
    }

    public class y implements Runnable {
        public final /* synthetic */ File a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public class a implements zn2<String> {
            public final /* synthetic */ ControlLinkCommunMessage a;

            /* renamed from: com.wear.ui.longDistance.controlLink.ControlLinkChatActivity$y$a$a, reason: collision with other inner class name */
            public class RunnableC0151a implements Runnable {
                public final /* synthetic */ String a;

                public RunnableC0151a(String str) {
                    this.a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (WearUtils.e1(this.a)) {
                        a aVar = a.this;
                        ControlLinkChatActivity.this.P5(null, aVar.a, 4);
                        ControlLinkChatActivity.this.y5(ah4.e(R.string.common_serverError));
                        return;
                    }
                    NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(this.a, NormalResponse.class);
                    if (normalResponse.isResult()) {
                        ControlLinkChatActivity.this.P5(normalResponse.getMessage(), a.this.a, 0);
                        return;
                    }
                    a aVar2 = a.this;
                    ControlLinkChatActivity.this.P5(null, aVar2.a, 4);
                    ControlLinkChatActivity.this.y5(normalResponse.getMessage());
                }
            }

            public a(ControlLinkCommunMessage controlLinkCommunMessage) {
                this.a = controlLinkCommunMessage;
            }

            @Override // dc.zn2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onSuccess(String str) {
                ControlLinkChatActivity.this.V.post(new RunnableC0151a(str));
            }

            @Override // dc.zn2
            public void onError(NetException netException) {
                ControlLinkChatActivity.this.P5(null, this.a, 4);
                ControlLinkChatActivity.this.y5(netException.getMessage());
            }
        }

        public y(File file, String str, int i, int i2, String str2, String str3) {
            this.a = file;
            this.b = str;
            this.c = i;
            this.d = i2;
            this.e = str2;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            File file = this.a;
            if (file == null || !file.exists()) {
                ControlLinkChatActivity.this.P();
                return;
            }
            EntityPicture entityPicture = new EntityPicture();
            entityPicture.setLocalUrl(this.b);
            entityPicture.setH(this.c);
            entityPicture.setW(this.d);
            if (!WearUtils.e1(this.e)) {
                entityPicture.setType(this.e);
            }
            if (!WearUtils.e1(this.f)) {
                entityPicture.setFileMd5(this.f);
            }
            if (!hf3.d(ControlLinkChatActivity.this)) {
                sg3.i(ControlLinkChatActivity.this, R.string.common_settingTip);
                ControlLinkChatActivity.this.V5(entityPicture);
                return;
            }
            if (!MyApplication.P || hu3.x() == null) {
                sg3.i(ControlLinkChatActivity.this, R.string.common_timeout_error);
                ControlLinkChatActivity.this.V5(entityPicture);
                return;
            }
            ControlLinkCommunMessage controlLinkCommunMessage = new ControlLinkCommunMessage();
            controlLinkCommunMessage.setFromId(ControlLinkChatActivity.this.i0);
            controlLinkCommunMessage.setToId(ControlLinkChatActivity.this.d0);
            controlLinkCommunMessage.sendEntity(entityPicture, ControlLinkChatActivity.this.g0.getX(), ControlLinkChatActivity.this.g0.getY());
            controlLinkCommunMessage.setId(WearUtils.E());
            controlLinkCommunMessage.setSendStatus(2);
            controlLinkCommunMessage.setCreateTime(be3.r());
            controlLinkCommunMessage.setDateImType("control_link");
            controlLinkCommunMessage.setDateImTypeData(ControlLinkChatActivity.this.j0);
            DaoUtils.getControlLinkCommunMessageDao().updateOrAdd(controlLinkCommunMessage);
            try {
                HashMap map = new HashMap();
                map.put(PSOProgramService.VS_Key, "1");
                tn2.x(WearUtils.x).D("/wear/chat/sendPic", this.a, (WearUtils.e1(this.e) && WearUtils.e1(this.f)) ? "chat.jpg" : this.a.getName(), map, new a(controlLinkCommunMessage));
            } catch (Exception e) {
                ControlLinkChatActivity.this.P5(null, controlLinkCommunMessage, 4);
                ControlLinkChatActivity.this.y5(ah4.e(R.string.common_serverError));
                e.printStackTrace();
            }
        }
    }

    public class z implements Runnable {
        public final /* synthetic */ String a;

        public z(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ControlLinkChatActivity.this.s.setVisibility(8);
            ControlLinkChatActivity.this.t.setVisibility(8);
            ControlLinkChatActivity.this.u.setVisibility(8);
            sg3.l(WearUtils.e1(this.a) ? ah4.e(R.string.common_serverError) : this.a);
        }
    }

    public ControlLinkChatActivity() {
        new DpgEventConfigBean();
        this.q0 = false;
        this.v0 = new f();
        this.w0 = new n();
        this.x0 = new o();
    }

    public static boolean t5() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - z0 < 1000) {
            return true;
        }
        z0 = jCurrentTimeMillis;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v5() {
        this.G.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x5() {
        this.m0.m2(this.e0);
    }

    public final ControlLinkCommunMessage A5(int i2, boolean z2) {
        ControlLinkCommunMessage controlLinkCommunMessage = new ControlLinkCommunMessage();
        controlLinkCommunMessage.setToId(this.d0);
        controlLinkCommunMessage.setFromId(this.i0);
        EntityControlLinkTimer entityControlLinkTimer = new EntityControlLinkTimer();
        entityControlLinkTimer.setRemainTime(i2 == -1 ? 0 : i2);
        entityControlLinkTimer.setCancel(i2 == -1);
        entityControlLinkTimer.setReachMaxAbnormalCount(z2);
        controlLinkCommunMessage.sendEntity(entityControlLinkTimer);
        controlLinkCommunMessage.setId(WearUtils.E());
        controlLinkCommunMessage.setSendStatus(0);
        controlLinkCommunMessage.setDateImType("control_link");
        controlLinkCommunMessage.setDateImTypeData(this.j0);
        controlLinkCommunMessage.setCreateTime(be3.r());
        return controlLinkCommunMessage;
    }

    public final void B5(View view) {
        setVolumeControlStream(3);
        if (this.y) {
            D5();
        } else {
            E5();
        }
    }

    @Override // dc.ma2
    public IPeopleInfo C() {
        return this.e0;
    }

    public final void C5(boolean z2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.G.getChatMessageContainer().getLayoutParams();
        layoutParams.addRule(16, z2 ? R.id.chat_voice : R.id.chat_send);
        this.G.getChatMessageContainer().setLayoutParams(layoutParams);
        this.G.getChat_voice().setVisibility(z2 ? 0 : 4);
        this.G.getChatSend().setVisibility(z2 ? 8 : 0);
    }

    public final void D5() {
        this.y = false;
        ue3.a(this.d, this);
        this.q.setVisibility(8);
        this.L.setImageResource(R.drawable.chat_function_keyboard);
        this.W.I();
        this.d.requestFocus();
        this.V.postDelayed(new h(), 100L);
        g6();
        if (this.w) {
            M5();
        }
    }

    @Override // dc.ma2
    public boolean E() {
        return false;
    }

    @Override // com.wear.widget.CustomSwipeRefreshLayout.a
    public boolean E2() {
        return false;
    }

    @Override // dc.cv1
    public void E3(long j2) {
        runOnMainThread(new x(j2));
    }

    public final void E5() {
        K5();
        if (this.w) {
            M5();
        }
        this.V.postDelayed(new g(), 100L);
    }

    public final void F5() {
        File file = new File(WearUtils.b(this, "festival_animation.mp4"));
        if (!file.exists()) {
            sg3.l("文件播放错误");
            return;
        }
        this.S.setVisibility(8);
        this.C.setVisibility(8);
        this.R.setVisibility(8);
        this.s0.setVisibility(0);
        this.t0.setVisibility(0);
        this.r0.setVisibility(0);
        this.r0.k(file);
    }

    public void G5() {
        HashMap map = new HashMap();
        map.put("otherUserId", n5());
        this.m0.C2(n5());
        map.put("linkId", c83.R1().S1());
        tn2.x(WearUtils.x).g("/app/long_time_control_link/query_friend_relation", map, new i0());
    }

    public boolean H1(boolean z2) {
        RecyclerView recyclerView;
        View childAt;
        boolean z3 = (this.x.findLastVisibleItemPosition() == this.x.getItemCount() - 1 || this.x.findLastVisibleItemPosition() == this.x.getItemCount()) && (recyclerView = this.e) != null && ((childAt = recyclerView.getChildAt(this.x.findLastVisibleItemPosition() - this.x.findFirstVisibleItemPosition())) == null || this.e.getHeight() >= childAt.getBottom());
        if (z2) {
            if (this.x.getItemCount() >= 10) {
                if (!this.x.getStackFromEnd()) {
                    this.x.setStackFromEnd(true);
                }
            } else if (this.x.findLastVisibleItemPosition() == -1 || this.x.findFirstVisibleItemPosition() == 0) {
                this.x.setStackFromEnd(false);
            } else if (!z3 || this.x.findLastVisibleItemPosition() <= 0) {
                if (z3) {
                    this.x.setStackFromEnd(false);
                } else if (!this.x.getStackFromEnd()) {
                    this.x.setStackFromEnd(true);
                }
            } else if (!this.x.getStackFromEnd()) {
                this.x.setStackFromEnd(true);
            }
        }
        return z3;
    }

    public final void H5() {
    }

    @Override // com.wear.widget.CustomSwipeRefreshLayout.a
    public boolean I2(MotionEvent motionEvent) {
        return true;
    }

    public void I5(ControlLinkCommunMessage controlLinkCommunMessage) {
        try {
            boolean z2 = true;
            if (!hf3.d(this)) {
                sg3.i(this, R.string.common_settingTip);
                W5(controlLinkCommunMessage, true);
                return;
            }
            if (MyApplication.P && hu3.x() != null) {
                if (WearUtils.e1(controlLinkCommunMessage.getMsgSendData()) && controlLinkCommunMessage.getDataBean() != null) {
                    controlLinkCommunMessage.setMsgSendData(controlLinkCommunMessage.getDataBean(), this.g0.getX(), this.g0.getY());
                }
                int i2 = p0.a[controlLinkCommunMessage.getMsgType().ordinal()];
                if (i2 == 1) {
                    X5(controlLinkCommunMessage, true);
                    return;
                }
                if (i2 == 2) {
                    N5(controlLinkCommunMessage);
                    return;
                }
                if (i2 != 3) {
                    return;
                }
                EntityPicture entityPicture = (EntityPicture) controlLinkCommunMessage.getDataBean();
                String localUrl = entityPicture.getLocalUrl();
                if (WearUtils.e1(localUrl)) {
                    P();
                    return;
                }
                if (WearUtils.e1(entityPicture.getType()) || !entityPicture.getType().equals("emoji")) {
                    z2 = false;
                }
                File fileZ = z2 ? WearUtils.Z(localUrl).exists() ? WearUtils.Z(localUrl) : WearUtils.a0(localUrl) : WearUtils.c0(localUrl);
                controlLinkCommunMessage.setSendStatus(2);
                controlLinkCommunMessage.setCreated(be3.u());
                DaoUtils.getControlLinkCommunMessageDao().updateOrAdd(controlLinkCommunMessage);
                notifyDataSetChanged();
                M5();
                try {
                    HashMap map = new HashMap();
                    map.put(PSOProgramService.VS_Key, "1");
                    tn2.x(WearUtils.x).D("/wear/chat/sendPic", fileZ, (WearUtils.e1(entityPicture.getType()) && WearUtils.e1(entityPicture.getFileMd5())) ? "chat.jpg" : fileZ.getName(), map, new c0(controlLinkCommunMessage));
                    return;
                } catch (Exception e2) {
                    R5(null, controlLinkCommunMessage, 4);
                    y5(ah4.e(R.string.common_serverError));
                    e2.printStackTrace();
                    return;
                }
            }
            sg3.i(this, R.string.common_timeout_error);
            W5(controlLinkCommunMessage, true);
        } catch (Exception e3) {
            e3.printStackTrace();
            sg3.i(this, R.string.chat_message_item_save_error);
        }
    }

    @Override // dc.cv1
    public void J2(int i2, boolean z2) {
        runOnMainThread(new h0(i2, z2));
    }

    public void J5() {
        MyApplication.v0(null);
        r5();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void JUtilsEvent(hh0 hh0Var) {
        b6(hh0Var.b());
    }

    @Override // dc.ma2
    public void K() {
        b5();
    }

    public final void K5() {
        this.y = true;
        this.K.setImageResource(R.drawable.chat_function_openfunction);
        this.L.setImageResource(R.drawable.chat_function_emojis);
        g6();
        this.d.setVisibility(0);
        this.d.requestFocus();
        p5();
    }

    public void L5(int i2) {
        this.M.setHeight(i2);
        this.i.setHeight(i2);
    }

    @Override // dc.ma2
    public void M(EntityPattern entityPattern) {
    }

    public final void M5() {
        Observable.timer(100L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new q());
    }

    public final void N5(ControlLinkCommunMessage controlLinkCommunMessage) {
        EntityAudio entityAudio = (EntityAudio) controlLinkCommunMessage.getDataBean();
        String localUrl = entityAudio.getLocalUrl();
        if (!WearUtils.e1(localUrl) && new File(localUrl).exists()) {
            if (!hf3.d(this)) {
                sg3.i(this, R.string.common_settingTip);
                W5(controlLinkCommunMessage, true);
                return;
            }
            p6();
            c83.R1().y1(4);
            controlLinkCommunMessage.setSendStatus(2);
            tn2.x(WearUtils.x).A("/wear/chat/saveFile/audio", new File(localUrl), new HashMap(), new a0(entityAudio, controlLinkCommunMessage));
        }
    }

    @Override // com.wear.widget.chatMic.VoiceMessagePanelView.b
    public void O() {
        String str = "cancelRecord: delete file :" + vd0.e(this.Y);
    }

    public final void O5(String str) {
        EntityChat entityChat = new EntityChat();
        entityChat.setText(str);
        T5(entityChat);
    }

    @Override // dc.ma2
    public void P() {
    }

    public final void P5(String str, ControlLinkCommunMessage controlLinkCommunMessage, int i2) {
        if (i2 != 0) {
            W5(controlLinkCommunMessage, false);
            return;
        }
        EntityPicture entityPicture = (EntityPicture) controlLinkCommunMessage.getDataBean();
        entityPicture.setUrl(str);
        controlLinkCommunMessage.setSendStatus(2);
        controlLinkCommunMessage.sendEntity(entityPicture, this.g0.getX(), this.g0.getY());
        DaoUtils.getControlLinkCommunMessageDao().updateOrAdd(controlLinkCommunMessage);
        a5(controlLinkCommunMessage, true);
        if (dq2.w().y(controlLinkCommunMessage)) {
            this.m0.T1().add(controlLinkCommunMessage);
            ControlLinkMessageAdapter controlLinkMessageAdapter = this.f0;
            if (controlLinkMessageAdapter != null) {
                controlLinkMessageAdapter.notifyDataSetChanged();
            }
            M5();
        }
        dq2.w().D(controlLinkCommunMessage, this.j0);
    }

    public final void Q5(int i2, int i3, String str, String str2, String str3, File file) {
        this.V.post(new y(file, str, i2, i3, str2, str3));
    }

    public final void R5(String str, ControlLinkCommunMessage controlLinkCommunMessage, int i2) {
        if (i2 != 0) {
            W5(controlLinkCommunMessage, false);
            return;
        }
        EntityPicture entityPicture = (EntityPicture) controlLinkCommunMessage.getDataBean();
        entityPicture.setUrl(str);
        controlLinkCommunMessage.setSendStatus(2);
        controlLinkCommunMessage.sendEntity(entityPicture, this.g0.getX(), this.g0.getY());
        DaoUtils.getControlLinkCommunMessageDao().updateOrAdd(controlLinkCommunMessage);
        a5(controlLinkCommunMessage, true);
        if (dq2.w().y(controlLinkCommunMessage)) {
            this.m0.T1().remove(controlLinkCommunMessage);
            this.m0.T1().add(controlLinkCommunMessage);
            ControlLinkMessageAdapter controlLinkMessageAdapter = this.f0;
            if (controlLinkMessageAdapter != null) {
                controlLinkMessageAdapter.notifyDataSetChanged();
            }
            M5();
        }
        dq2.w().D(controlLinkCommunMessage, this.j0);
    }

    public final void S5() {
        if (DaoUtils.getControlLinkCommunMessageDao().findStartMessage(this.j0)) {
            this.m0.B2(2);
            return;
        }
        this.m0.B2(1);
        if (this.g0.isJoinerFirstTime()) {
            EntityControllink entityControllink = new EntityControllink();
            entityControllink.setControlLinkBean(this.g0);
            ControlLinkCommunMessage controlLinkCommunMessage = new ControlLinkCommunMessage();
            controlLinkCommunMessage.setToId(this.d0);
            controlLinkCommunMessage.setFromId(this.i0);
            controlLinkCommunMessage.sendEntity(entityControllink, this.g0.getX(), this.g0.getY());
            controlLinkCommunMessage.setId(WearUtils.E());
            controlLinkCommunMessage.setSendStatus(2);
            controlLinkCommunMessage.setCreateTime(be3.r());
            controlLinkCommunMessage.setDateImType("control_link");
            controlLinkCommunMessage.setDateImTypeData(this.j0);
            a5(controlLinkCommunMessage, true);
            this.m0.T1().add(controlLinkCommunMessage);
            ControlLinkMessageAdapter controlLinkMessageAdapter = this.f0;
            if (controlLinkMessageAdapter != null) {
                controlLinkMessageAdapter.notifyDataSetChanged();
            }
            M5();
            dq2.w().D(controlLinkCommunMessage, this.j0);
            WearUtils.x.q("control_link_controller_enter_remote", null);
        }
    }

    public void T5(DataEntityAbstract dataEntityAbstract) {
        c83.R1().y1(2);
        U5(dataEntityAbstract, MessageType.chat);
    }

    @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.x
    public void U1(ControlLinkCommunMessage controlLinkCommunMessage) {
        ue3.a(this.d, this);
        bo3 bo3Var = new bo3(this, R.layout.bottom_sheet_resend_message);
        bo3Var.show();
        bo3Var.d(R.id.resend_message, new d0(controlLinkCommunMessage));
        bo3Var.d(R.id.cancel_resend, null);
    }

    public final void U5(DataEntityAbstract dataEntityAbstract, MessageType messageType) {
        if (!hf3.d(this)) {
            sg3.i(this, R.string.common_settingTip);
            V5(dataEntityAbstract);
            return;
        }
        if (!MyApplication.P) {
            sg3.i(this, R.string.common_timeout_error);
            V5(dataEntityAbstract);
            return;
        }
        if (!this.m0.r()) {
            sg3.i(this, R.string.message_send_error);
            finish();
            return;
        }
        ControlLinkCommunMessage controlLinkCommunMessage = new ControlLinkCommunMessage();
        controlLinkCommunMessage.setFromId(this.i0);
        controlLinkCommunMessage.setToId(this.d0);
        ControlLinkBean controlLinkBean = this.g0;
        if (controlLinkBean != null) {
            controlLinkCommunMessage.sendEntity(dataEntityAbstract, controlLinkBean.getX(), this.g0.getY());
        }
        controlLinkCommunMessage.setId(WearUtils.E());
        controlLinkCommunMessage.setSendStatus(2);
        controlLinkCommunMessage.setCreateTime(be3.r());
        controlLinkCommunMessage.setDateImType("control_link");
        controlLinkCommunMessage.setDateImTypeData(this.j0);
        if (messageType == MessageType.chat) {
            this.W.M(((EntityChat) dataEntityAbstract).getText());
            controlLinkCommunMessage.setShowEmojiAnim(!TextUtils.isEmpty(this.W.s(r4, false)));
        }
        a5(controlLinkCommunMessage, true);
        if (dq2.w().y(controlLinkCommunMessage)) {
            this.m0.T1().add(controlLinkCommunMessage);
            ControlLinkMessageAdapter controlLinkMessageAdapter = this.f0;
            if (controlLinkMessageAdapter != null) {
                controlLinkMessageAdapter.notifyDataSetChanged();
            }
            M5();
        }
        dq2.w().D(controlLinkCommunMessage, this.j0);
        p6();
    }

    @Override // dc.cv1
    public void V2() {
        if (!e5() || WearUtils.e1(this.d0)) {
            return;
        }
        if (this.c0 == null) {
            Account accountU = WearUtils.y.u();
            this.c0 = accountU;
            if (accountU == null) {
                finish();
                return;
            }
        }
        this.q.setVisibility(8);
        o5();
        this.V.postDelayed(new Runnable() { // from class: dc.w73
            @Override // java.lang.Runnable
            public final void run() {
                this.a.x5();
            }
        }, 300L);
    }

    public void V5(DataEntityAbstract dataEntityAbstract) {
        ControlLinkCommunMessage controlLinkCommunMessage = new ControlLinkCommunMessage();
        controlLinkCommunMessage.setFromId(this.i0);
        controlLinkCommunMessage.setToId(this.d0);
        controlLinkCommunMessage.sendEntity(dataEntityAbstract, this.g0.getX(), this.g0.getY());
        controlLinkCommunMessage.setId(WearUtils.E());
        controlLinkCommunMessage.setSendStatus(4);
        controlLinkCommunMessage.setCreateTime(be3.r());
        controlLinkCommunMessage.setDateImType("control_link");
        controlLinkCommunMessage.setDateImTypeData(this.j0);
        if (dataEntityAbstract instanceof EntityChat) {
            this.W.M(((EntityChat) dataEntityAbstract).getText());
            controlLinkCommunMessage.setShowEmojiAnim(!TextUtils.isEmpty(this.W.s(r5, false)));
        }
        a5(controlLinkCommunMessage, true);
        if (dq2.w().y(controlLinkCommunMessage)) {
            this.m0.T1().add(controlLinkCommunMessage);
            ControlLinkMessageAdapter controlLinkMessageAdapter = this.f0;
            if (controlLinkMessageAdapter != null) {
                controlLinkMessageAdapter.notifyDataSetChanged();
            }
            M5();
        }
    }

    @Override // com.wear.widget.chatMic.VoiceMessagePanelView.b
    public void W2() throws IllegalStateException, IOException {
        if (E()) {
            return;
        }
        this.y0 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(WearUtils.T("mic").getAbsolutePath());
        sb.append("/");
        sb.append(WearUtils.B(System.currentTimeMillis() + ".acc"));
        String string = sb.toString();
        this.Y = string;
        boolean zW = this.X.w(string);
        this.G.p(this.X.o());
        if (zW) {
            return;
        }
        sg3.i(this, R.string.chat_record_failure);
    }

    public void W5(ControlLinkCommunMessage controlLinkCommunMessage, boolean z2) {
        try {
            controlLinkCommunMessage.sendFail();
            if (z2) {
                controlLinkCommunMessage.setCreateTime(be3.r());
            }
            if (controlLinkCommunMessage.getDataBean() instanceof EntityChat) {
                String text = ((EntityChat) controlLinkCommunMessage.getDataBean()).getText();
                this.W.M(text);
                controlLinkCommunMessage.setShowEmojiAnim(TextUtils.isEmpty(this.W.s(text, false)) ? false : true);
            }
            DaoUtils.getControlLinkCommunMessageDao().update((ControlLinkCommunMessageDao) controlLinkCommunMessage);
            this.m0.T1().remove(controlLinkCommunMessage);
            this.m0.T1().add(controlLinkCommunMessage);
            ControlLinkMessageAdapter controlLinkMessageAdapter = this.f0;
            if (controlLinkMessageAdapter != null) {
                controlLinkMessageAdapter.notifyDataSetChanged();
            }
            M5();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // dc.cv1
    public void X() {
        dissDialog();
    }

    public final void X5(ControlLinkCommunMessage controlLinkCommunMessage, boolean z2) {
        controlLinkCommunMessage.setSendStatus(2);
        if (z2) {
            controlLinkCommunMessage.setCreateTime(be3.r());
        }
        if (controlLinkCommunMessage.getMsgType() == MessageType.chat) {
            this.W.M(((EntityChat) controlLinkCommunMessage.getDataBean()).getText());
            controlLinkCommunMessage.setShowEmojiAnim(!TextUtils.isEmpty(this.W.s(r4, false)));
        }
        this.m0.T1().remove(controlLinkCommunMessage);
        this.m0.T1().add(controlLinkCommunMessage);
        ControlLinkMessageAdapter controlLinkMessageAdapter = this.f0;
        if (controlLinkMessageAdapter != null) {
            controlLinkMessageAdapter.notifyDataSetChanged();
        }
        M5();
        dq2.w().D(controlLinkCommunMessage, this.j0);
        a5(controlLinkCommunMessage, false);
    }

    public final void Y5() {
        String strTrim = this.d.getText().toString().trim();
        if (strTrim == null || strTrim.equals("")) {
            is3.b bVar = new is3.b(this.activity);
            bVar.p(ah4.e(R.string.chat_unable_send_blank_message));
            bVar.o(ah4.e(R.string.common_ok));
            bVar.d(new c(this));
            bVar.b(false);
            cs3.h(bVar).show();
        } else {
            O5(strTrim);
        }
        this.d.setText("");
    }

    public void Z5(boolean z2) {
        c83 c83Var = this.m0;
        if (c83Var != null) {
            c83Var.v2(z2);
        }
    }

    @Override // com.wear.widget.chatMic.VoiceMessagePanelView.b
    public void a1() throws IllegalStateException {
        this.X.H();
        long jCurrentTimeMillis = (System.currentTimeMillis() - this.y0) / 1000;
        if (jCurrentTimeMillis < 1) {
            sg3.i(this, R.string.chat_voice_timeShort);
            O();
            return;
        }
        if (!WearUtils.e1(this.Y) && new File(this.Y).exists()) {
            EntityAudio entityAudio = new EntityAudio();
            entityAudio.setLocalUrl(this.Y);
            if (jCurrentTimeMillis > 60) {
                jCurrentTimeMillis = 60;
            }
            entityAudio.setTime(jCurrentTimeMillis);
            ControlLinkCommunMessage controlLinkCommunMessage = new ControlLinkCommunMessage();
            controlLinkCommunMessage.setToId(this.d0);
            controlLinkCommunMessage.setFromId(this.i0);
            controlLinkCommunMessage.sendEntity(entityAudio, this.g0.getX(), this.g0.getY());
            controlLinkCommunMessage.setId(WearUtils.E());
            controlLinkCommunMessage.setSendStatus(2);
            controlLinkCommunMessage.setCreateTime(be3.r());
            controlLinkCommunMessage.setDateImType("control_link");
            controlLinkCommunMessage.setDateImTypeData(this.j0);
            a5(controlLinkCommunMessage, true);
            this.m0.T1().add(controlLinkCommunMessage);
            ControlLinkMessageAdapter controlLinkMessageAdapter = this.f0;
            if (controlLinkMessageAdapter != null) {
                controlLinkMessageAdapter.notifyDataSetChanged();
            }
            M5();
            N5(controlLinkCommunMessage);
        }
    }

    public final void a5(ControlLinkCommunMessage controlLinkCommunMessage, boolean z2) {
        if (dq2.w().x(controlLinkCommunMessage)) {
            if (z2) {
                controlLinkCommunMessage.setFromId(this.i0);
                controlLinkCommunMessage.setToId(this.d0);
            }
            DaoUtils.getControlLinkCommunMessageDao().updateOrAdd(controlLinkCommunMessage);
        }
    }

    public void a6() {
        c83 c83Var = this.m0;
        if (c83Var != null) {
            c83Var.D2(4);
        }
    }

    @Override // dc.cv1, dc.jv1
    public synchronized void addViewToActivity(View view) {
        if (System.currentTimeMillis() - this.z < 100) {
            return;
        }
        this.q.removeAllViews();
        this.q.setVisibility(4);
        this.parentHandler.postDelayed(new e0(view), 10L);
    }

    public void b5() {
        runOnMainThread(new Runnable() { // from class: dc.v73
            @Override // java.lang.Runnable
            public final void run() {
                this.a.v5();
            }
        });
    }

    public final void b6(int i2) {
        String str = "setMPadding bottomP:" + i2;
        int height = findViewById(R.id.v_chat_live_layer).getHeight() + i2;
        int i3 = this.n0;
        if ((i3 > 0 && height >= i3 * 2) || height >= this.G.getPanelTypeHeight() * 2) {
            height -= i2;
        }
        c6(height);
        String str2 = "setMPadding bottom 1:" + height;
    }

    public void c5(String str) {
        this.m0.S2(str);
        dq2.w().i(this.j0, new u(this));
    }

    public final void c6(int i2) {
        View viewFindViewById = findViewById(R.id.v_chat_live_layer);
        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = i2;
        viewFindViewById.setVisibility(0);
        viewFindViewById.setLayoutParams(layoutParams);
        viewFindViewById.invalidate();
        if (this.w) {
            M5();
        }
        this.p0 = System.currentTimeMillis();
        String str = "setMPadding setViewLayerHeight:" + i2;
    }

    public List<ControlLinkCommunMessage> d0() {
        return this.m0.T1();
    }

    public final void d5() {
        List<ControlLinkCommunMessage> listD0 = d0();
        if (listD0.isEmpty()) {
            return;
        }
        ControlLinkCommunMessage controlLinkCommunMessage = listD0.get(listD0.size() - 1);
        if (controlLinkCommunMessage.getDataBean() instanceof EntityChat) {
            EntityChat entityChat = (EntityChat) controlLinkCommunMessage.getDataBean();
            String strS = this.W.s(entityChat.getText(), true);
            boolean zR0 = WearUtils.R0(entityChat.getText());
            if (!TextUtils.isEmpty(strS) || zR0) {
                this.k0 = controlLinkCommunMessage;
                if (controlLinkCommunMessage.isShowEmojiAnim() || zR0) {
                    if (strS != null && !this.W.B(strS)) {
                        f6(controlLinkCommunMessage);
                        return;
                    }
                    if (zR0) {
                        f6(controlLinkCommunMessage);
                        return;
                    }
                    if (listD0.size() != 1) {
                        ControlLinkCommunMessage controlLinkCommunMessage2 = listD0.get(listD0.size() - 2);
                        if (TextUtils.equals(controlLinkCommunMessage.getFromId(), controlLinkCommunMessage2.getFromId()) || !(controlLinkCommunMessage2.getDataBean() instanceof EntityChat)) {
                            return;
                        }
                        if (TextUtils.equals(strS, this.W.s(((EntityChat) controlLinkCommunMessage2.getDataBean()).getText(), true))) {
                            this.k0 = controlLinkCommunMessage2;
                            f6(controlLinkCommunMessage);
                        }
                    }
                }
            }
        }
    }

    public void d6() {
        xr3 xr3Var = this.A;
        if (xr3Var == null || xr3Var.p()) {
            return;
        }
        this.A.w();
        this.c.post(new o0());
        this.B = true;
        z5(1);
    }

    public final boolean e5() {
        if (this.c0 != null) {
            return true;
        }
        ye3.I("wipeMemoryError", "ControlLinkChatActivity");
        if (MyApplication.N) {
            Intent intent = new Intent(this.application, (Class<?>) LoginActivity.class);
            pj3.d(intent);
            intent.addFlags(268468224);
            this.application.startActivity(intent);
        } else {
            Intent intent2 = new Intent(this.application, (Class<?>) MainActivity.class);
            intent2.addFlags(268468224);
            this.application.startActivity(intent2);
        }
        try {
            finish();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void e6(int i2) {
        runOnMainThread(new j0(i2));
    }

    public void f5() {
        ue3.a(this.d, this);
        this.f.setVisibility(8);
        this.q.setVisibility(8);
        p5();
        this.y = true;
        this.K.setImageResource(R.drawable.chat_function_openfunction);
        this.L.setImageResource(R.drawable.chat_function_emojis);
        g6();
        if (ChatInputPanelPto.l) {
            ChatInputPanelPto.l = false;
        } else {
            this.G.g(false);
        }
    }

    public final void f6(ControlLinkCommunMessage controlLinkCommunMessage) {
        if (controlLinkCommunMessage.getMsgType() == MessageType.controllink) {
            return;
        }
        String str = null;
        String strS = controlLinkCommunMessage.getDataBean() instanceof EntityChat ? this.W.s(((EntityChat) controlLinkCommunMessage.getDataBean()).getText(), true) : null;
        if (TextUtils.isEmpty(strS)) {
            if (controlLinkCommunMessage.getMsgType() != MessageType.chat || controlLinkCommunMessage.isRead()) {
                return;
            }
            if (controlLinkCommunMessage.getDataBean() == null) {
                controlLinkCommunMessage.setDataBean(controlLinkCommunMessage.syncDecryptBean());
            }
            if (WearUtils.R0(((EntityChat) controlLinkCommunMessage.getDataBean()).getText())) {
                F5();
            }
            this.k0 = null;
            return;
        }
        if (this.W.B(strS)) {
            ControlLinkCommunMessage controlLinkCommunMessage2 = this.k0;
            if (controlLinkCommunMessage2 != null) {
                String strS2 = this.W.s(((EntityChat) controlLinkCommunMessage2.getDataBean()).getText(), true);
                if (!TextUtils.equals(this.k0.getFromId(), controlLinkCommunMessage.getFromId()) && TextUtils.equals(strS, strS2)) {
                    str = strS;
                }
            }
            this.k0 = controlLinkCommunMessage;
            strS = str;
        } else {
            this.k0 = null;
        }
        if (TextUtils.isEmpty(strS)) {
            return;
        }
        if (this.S.o()) {
            this.l0.add(strS);
            return;
        }
        this.S.setVisibility(0);
        this.s0.setVisibility(8);
        this.W.O(this.S, strS);
    }

    public void g5() {
        k0 k0Var = new k0(5000L, 1000L);
        this.D = k0Var;
        k0Var.start();
    }

    public final void g6() {
        h6(null);
    }

    @Override // dc.ma2
    public String getUserName() {
        return null;
    }

    @Override // dc.cv1
    public void h2() {
        EntityChat entityChat;
        ControlLinkMessageAdapter controlLinkMessageAdapter = this.f0;
        if (controlLinkMessageAdapter != null) {
            controlLinkMessageAdapter.notifyDataSetChanged();
        }
        M5();
        ArrayList arrayList = new ArrayList();
        for (ControlLinkCommunMessage controlLinkCommunMessage : d0()) {
            if (!controlLinkCommunMessage.isRead()) {
                f6(controlLinkCommunMessage);
                controlLinkCommunMessage.setRead(true);
                arrayList.add(controlLinkCommunMessage);
            }
        }
        if (d0().size() > 0 && d0().get(d0().size() - 1).getMsgType() == MessageType.chat && (entityChat = (EntityChat) d0().get(d0().size() - 1).getDataBean()) != null) {
            o6(entityChat.getText());
        }
        if (arrayList.isEmpty()) {
            return;
        }
        vg3.b().a(new w(this, arrayList));
    }

    public final void h5() {
        if (d83.w().I() && this.h0 && !d83.w().i()) {
            showDialog();
            this.m0.u = true;
        } else {
            m6(true);
        }
        dq2.w().t(this.j0, this.d0, new r(), 5L);
    }

    public final void h6(iv1 iv1Var) {
        i iVar = new i(iv1Var);
        boolean zC = od3.c(this.activity);
        if (MyApplication.i0 || zC) {
            iVar.doCancel();
            return;
        }
        if (!this.m0.O1()) {
            iVar.doCancel();
            return;
        }
        MyApplication.i0 = true;
        is3.b bVar = new is3.b(this.activity);
        bVar.p(ah4.e(R.string.enable_floating_window_des));
        bVar.o(ah4.e(R.string.common_ok));
        bVar.n(ah4.e(R.string.common_cancel));
        bVar.d(new j(iVar));
        bVar.c(iVar);
        bVar.q(ah4.e(R.string.enable_floating_window_title));
        cs3.h(bVar).show();
    }

    public final void i5() {
        if (d83.w().I() && this.h0 && !d83.w().m()) {
            showDialog();
            this.m0.u = true;
        } else {
            m6(false);
        }
        dq2.w().t(this.j0, this.d0, new s(), 5L);
    }

    public final void i6(iv1 iv1Var) {
        l lVar = new l(this);
        if (od3.c(this.activity)) {
            this.m0.L2(true);
            if (iv1Var != null) {
                iv1Var.next();
                return;
            }
            return;
        }
        is3.b bVar = new is3.b(this.activity);
        bVar.p(ah4.e(R.string.enable_floating_window_des2));
        bVar.o(ah4.e(R.string.button_go_to_settings));
        bVar.n(ah4.e(R.string.common_cancel));
        bVar.d(new m());
        bVar.c(lVar);
        bVar.q(ah4.e(R.string.enable_floating_window_title));
        cs3.h(bVar).show();
    }

    @Override // dc.cv1
    public void j2(ControlLinkBean controlLinkBean, UserControlLink userControlLink, boolean z2, String str, String str2, boolean z3, int i2, boolean z4) {
        xr3 xr3Var;
        this.g0 = controlLinkBean;
        this.e0 = userControlLink;
        userControlLink.setPlatform(controlLinkBean.getPlatform());
        if (TextUtils.equals(this.e0.getPlatform(), "connect") || TextUtils.equals(this.e0.getPlatform(), "vibemate") || TextUtils.equals(this.e0.getPlatform(), "tophy")) {
            this.e0.setSupportLdrTouchPanel(true);
            this.e0.setSupportLDRFillOrder(true);
            this.e0.setSupportSolaceTapButtonControl(false);
        }
        this.h0 = z2;
        this.i0 = str;
        this.d0 = str2;
        if (this.f0 == null) {
            ControlLinkMessageAdapter controlLinkMessageAdapter = new ControlLinkMessageAdapter(this.m0.T1(), this, this, this.X, this.v, this.W, str, z2, this.d);
            this.f0 = controlLinkMessageAdapter;
            RecyclerView recyclerView = this.e;
            if (recyclerView != null) {
                this.x = cg3.f(recyclerView, controlLinkMessageAdapter);
                this.f0.V(this);
            }
        }
        if (!z4) {
            if (!z2) {
                if (i2 == 2) {
                    this.V.postDelayed(this.w0, 1500L);
                } else {
                    this.V.postDelayed(this.v0, 1500L);
                }
            }
            if (z2) {
                HashMap map = new HashMap();
                if (TextUtils.isEmpty(l22.n().i)) {
                    map.put("type", "1");
                } else {
                    map.put("type", "2");
                }
                map.put(TtmlNode.ATTR_ID, this.j0);
                ye3.d("F0021", WearUtils.A.toJson(map));
                d83.w().p(controlLinkBean.getControlPermission());
                if (d83.w().n() && d83.w().j()) {
                    this.V.postDelayed(this.x0, 1500L);
                }
            }
            s5();
            if (z2 && !z3 && controlLinkBean.isJoinerFirstTime()) {
                S5();
            }
            H5();
        }
        if ((this.m0 == null || c83.R1().g2()) && controlLinkBean.getMakeFriend() != null) {
            if (controlLinkBean.getMakeFriend().getExistOtherAddReq()) {
                e6(this.m0.W1() != 0 ? this.m0.W1() : 1);
                this.A.v();
            }
            if (!controlLinkBean.getMakeFriend().getOtherAcceptAddReq() || (xr3Var = this.A) == null) {
                return;
            }
            if (xr3Var.p()) {
                this.A.d();
            }
            if (this.m0.W1() == 4) {
                return;
            }
            this.m0.D2(4);
            synchronized (new Object()) {
                if (!this.q0) {
                    EntitySystem entitySystem = new EntitySystem();
                    entitySystem.addDataToArray(EntitySystem.SystemOPTType.T400.toString(), EntitySystem.SystemOPTCode.C704.toString(), ah4.e(R.string.control_link_friend_request_success));
                    this.m0.w1(entitySystem);
                    this.q0 = true;
                }
            }
            j5();
        }
    }

    @Override // dc.cv1
    public void j3() {
        showDialog();
    }

    public void j5() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 20; i2++) {
            arrayList.add(Integer.valueOf(i2));
        }
        this.C.setVisibility(0);
        this.F.i(arrayList);
        this.C.setAdapter(this.F);
        this.C.setOnFallingListener(new l0());
        this.S.setVisibility(8);
        this.s0.setVisibility(8);
        this.C.e();
    }

    public void j6() {
        ue3.a(this.d, this);
        this.y = true;
        this.L.setImageResource(R.drawable.chat_function_emojis);
        this.g.setVisibility(8);
        this.f.setVisibility(0);
        this.h.setVisibility(8);
        this.q.setVisibility(0);
        l6();
    }

    public final void k5(String str, ControlLinkBean controlLinkBean) {
        this.m0.M1(str, controlLinkBean);
    }

    public final void k6(d83.c cVar, d83.d dVar, boolean z2) {
        ye3.g("control_link_permission_popup_exposure", "exposure", "control_link_permission_popup", "popup", dVar == d83.d.live_control ? "1" : "2", this.j0, JSON.toJSONString(WearUtils.x.G().m()));
        d83.w().N(cVar, dVar, this.j0, this.c, z2, new n0(dVar));
    }

    @Override // dc.cv1, dc.jv1
    public void l(IPeopleInfo iPeopleInfo) {
        if ((iPeopleInfo instanceof User) && ((User) iPeopleInfo).getId().equals(this.d0)) {
            j6();
        }
    }

    public final void l5() {
        List<ControlLinkCommunMessage> listFindByPage = DaoUtils.getControlLinkCommunMessageDao().findByPage(this.j0, this.U, 10);
        if (listFindByPage == null) {
            try {
                listFindByPage = new ArrayList<>();
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        Collections.reverse(listFindByPage);
        for (ControlLinkCommunMessage controlLinkCommunMessage : listFindByPage) {
            if (be3.E(controlLinkCommunMessage.getCreated(), controlLinkCommunMessage.getSendStatus())) {
                controlLinkCommunMessage.setSendStatus(4);
            }
            controlLinkCommunMessage.setDataBean(controlLinkCommunMessage.syncDecryptBean());
        }
        this.m0.T1().addAll(0, listFindByPage);
        this.Q.setRefreshing(false);
        notifyDataSetChanged();
        if (listFindByPage.size() < 10) {
            this.Q.setEnabled(false);
            this.e.scrollToPosition(listFindByPage.size() - 1);
        } else {
            this.e.scrollToPosition(9);
        }
        this.U++;
        d5();
        for (int i2 = 0; i2 < listFindByPage.size(); i2++) {
            listFindByPage.get(i2).setRead(true);
        }
        DaoUtils.getControlLinkCommunMessageDao().update(listFindByPage);
    }

    public final void l6() {
        c83.R1().N2();
    }

    public final void m5() {
        HashMap map = new HashMap();
        map.put("lang", lg3.b(this));
        map.put("creator", Boolean.valueOf(!this.h0));
        map.put("isClickVibemate", Boolean.valueOf(eg3.d(this, "sp_is_close", false)));
        tn2.x(this).l("/get_remote_control_link_event_resource", map, new b0(this));
    }

    public void m6(boolean z2) {
        String strE;
        if (!z2) {
            this.m0.O2(this.h0 ? ah4.e(R.string.chat_waiting_accep_tance_auto) : String.format(ah4.f(R.string.chat_waitAcceptance, this.e0.getShowNickName()), new Object[0]), MessageType.sync);
            return;
        }
        if (this.h0) {
            strE = ah4.e(R.string.chat_waiting_accep_tance_auto);
        } else {
            Object[] objArr = new Object[1];
            UserControlLink userControlLink = this.e0;
            objArr[0] = userControlLink == null ? null : userControlLink.getShowNickName();
            strE = String.format(ah4.f(R.string.chat_waitAcceptance, objArr), new Object[0]);
        }
        this.m0.O2(strE, MessageType.live);
    }

    @Override // dc.ma2
    public void n() {
    }

    @Override // com.wear.ui.chat.fragment.ChatActionMenuFragmentBottom.d
    public void n1(int i2) {
        if (i2 == 0) {
            v();
            ye3.c("control link chatroom", "sponsor control link live control", this.d0);
            p6();
        } else {
            if (i2 != 1) {
                return;
            }
            t();
            ye3.c("control link chatroom", "sponsor control link sync control", this.d0);
            p6();
        }
    }

    public String n5() {
        return TextUtils.equals(c83.R1().L1().getCreator().getUserId(), c83.R1().L1().getSelfId()) ? c83.R1().L1().getJoiner().getUserId() : c83.R1().L1().getCreator().getUserId();
    }

    public void n6(boolean z2) {
        if (!z2) {
            if (!this.h0) {
                c83.R1().B1();
                return;
            } else {
                ChatSyncControl.N0().L(this.e0);
                ChatSyncControl.N0().I1(MessageType.sync);
                return;
            }
        }
        boolean z3 = this.h0;
        if (!z3) {
            ChatLiveControl.q0().y0(this.e0);
            ChatLiveControl.q0().f1(MessageType.live, this.h0);
            return;
        }
        this.m0.P2(this.e0, z3, this.c);
        HashMap map = new HashMap();
        map.put(TtmlNode.ATTR_ID, this.j0);
        ye3.d("F0024", WearUtils.A.toJson(map));
        WearUtils.x.q("control_link_control_with_live_control", null);
    }

    public void notifyDataSetChanged() {
        runOnMainThread(new p());
    }

    @Override // dc.ma2
    public boolean o() {
        return false;
    }

    @Override // dc.ie3.m
    public void o2(File file, String str, String str2, String str3) {
        Bitmap bitmapDecodeFile;
        if (file == null || !file.exists() || (bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath())) == null) {
            return;
        }
        Q5(bitmapDecodeFile.getHeight(), bitmapDecodeFile.getWidth(), str3, str, str2, file);
    }

    public void o5() {
        ChatActionMenuFragmentBottom chatActionMenuFragmentBottom = this.u0;
        if (chatActionMenuFragmentBottom == null || !chatActionMenuFragmentBottom.isVisible()) {
            return;
        }
        this.u0.dismiss();
    }

    public final void o6(String str) {
        if (this.W.D(str) && eg3.d(this.activity, "isFirstSend", true) && str.contains(this.W.k) && ke3.a("new_user", "isFirstSend")) {
            new LoveEmojisDialog(this.activity).show();
        }
    }

    @Override // com.wear.xmpp.FragmentStateLossActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        i6(new g0());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p5();
        switch (view.getId()) {
            case R.id.actionbar_back /* 2131362006 */:
            case R.id.tv_back /* 2131364943 */:
                i6(new d());
                break;
            case R.id.chat_emojis /* 2131362311 */:
                if (!ah0.a) {
                    this.G.f();
                    B5(view);
                    break;
                }
                break;
            case R.id.chat_more /* 2131362327 */:
                if (!ah0.a && !o()) {
                    this.u0.show(getSupportFragmentManager(), "chatActionMenuFragmentBottom");
                    break;
                }
                break;
            case R.id.chat_send /* 2131362343 */:
                Y5();
                break;
            case R.id.control_end /* 2131362443 */:
                is3.b bVar = new is3.b(this);
                bVar.p(ah4.e(R.string.message_control_end));
                bVar.n(ah4.e(R.string.common_cancel));
                bVar.o(ah4.e(R.string.common_ok));
                bVar.d(new e());
                cs3.h(bVar).show();
                break;
            case R.id.iv_report /* 2131363282 */:
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(WearUtils.l + "report?linkId=" + this.j0 + "&role=" + (!this.h0 ? 1 : 0))));
                break;
        }
    }

    @Override // com.wear.xmpp.FragmentStateLossActivity, com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"ClickableViewAccessibility"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(Integer.MIN_VALUE, Integer.MIN_VALUE);
        setContentView(R.layout.control_link_chat_activity);
        be3.J();
        EventBus.getDefault().register(this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String string = extras.getString("linkId");
            this.j0 = string;
            if (WearUtils.e1(string)) {
                ControlLinkBean controlLinkBean = (ControlLinkBean) extras.getSerializable("userBean");
                this.g0 = controlLinkBean;
                if (controlLinkBean == null) {
                    if (c83.R1().r()) {
                        this.j0 = c83.R1().S1();
                    }
                    if (WearUtils.e1(this.j0) && !WearUtils.e1(WearUtils.y.i())) {
                        this.j0 = WearUtils.y.i();
                    }
                    if (WearUtils.e1(this.j0)) {
                        finish();
                        return;
                    }
                } else {
                    this.j0 = controlLinkBean.getLinkId();
                    this.d0 = extras.getString("userId");
                    this.i0 = extras.getString("selfId");
                    this.h0 = extras.getBoolean("isJoiner", true);
                    DaoUtils.getSensitiveWordDao().setChatRoomSensitive(DaoUtils.getChatRoomSensitiveDao().findItemByRoomId(this.j0));
                    WearUtils.y.T(this.i0);
                    if (this.h0) {
                        ControlLinkBean.JoinerBean joinerBean = new ControlLinkBean.JoinerBean();
                        joinerBean.setNewVersion(true);
                        joinerBean.setUserId(this.i0);
                        this.g0.setJoiner(joinerBean);
                    }
                    dq2.w().F(this.g0.getLinkId(), this.g0.getX(), this.g0.getY());
                }
            } else {
                this.j0 = extras.getString("linkId");
                this.h0 = false;
            }
        }
        this.b = findViewById(R.id.screan_root_layout);
        MyActionBar myActionBar = (MyActionBar) findViewById(R.id.actionbar);
        this.c = myActionBar;
        myActionBar.setTitle(ah4.e(R.string.create_link_pop));
        this.N = (ImageView) findViewById(R.id.iv_report);
        this.O = (LinearLayout) findViewById(R.id.control_end);
        this.P = (TextView) findViewById(R.id.control_time);
        TextView textView = (TextView) this.c.findViewById(R.id.tv_back);
        this.b0 = textView;
        textView.setOnClickListener(this);
        ImageButton imageButton = (ImageButton) this.c.findViewById(R.id.actionbar_back);
        this.Z = imageButton;
        imageButton.setOnClickListener(this);
        View viewFindViewById = this.c.findViewById(R.id.rl_actionbar_back);
        this.a0 = viewFindViewById;
        viewFindViewById.setVisibility(0);
        ChatEditText chatEditText = (ChatEditText) findViewById(R.id.chat_message);
        this.d = chatEditText;
        chatEditText.addTextChangedListener(new k());
        this.c0 = WearUtils.y.u();
        if (e5()) {
            ChatInputPanel chatInputPanel = (ChatInputPanel) findViewById(R.id.ac_chat_controllink_chatinputpanel);
            this.G = chatInputPanel;
            chatInputPanel.setChatPictureHidden();
            this.i = (ChatMorePanel) findViewById(R.id.ac_chat_controllink_chatmorepanel);
            this.M = (ChatEmojisPanel) findViewById(R.id.ac_chat_controllink_emojis_panel);
            this.W.w(this, this, findViewById(R.id.chat_emojis_panel_layout), this.d, (EmojisToastView) findViewById(R.id.chat_emojis_tosat_layer));
            this.K = (ImageView) findViewById(R.id.chat_more);
            ImageView imageView = (ImageView) findViewById(R.id.chat_emojis);
            this.L = imageView;
            imageView.setTag(null);
            this.j = findViewById(R.id.chat_more_sendPattern);
            this.k = findViewById(R.id.chat_more_video);
            this.l = findViewById(R.id.chat_more_voice);
            this.m = findViewById(R.id.chat_more_dialog);
            this.n = findViewById(R.id.chat_more_alarm);
            this.o = findViewById(R.id.chat_more_sendPicture);
            this.C = (FallingView) findViewById(R.id.falling_view);
            this.p = (ViewGroup) findViewById(R.id.ac_chat_msg_container);
            this.r0 = (AnimView) findViewById(R.id.player_view);
            this.s0 = (FrameLayout) findViewById(R.id.fl_full_screen_animation);
            this.t0 = (ImageView) findViewById(R.id.iv_full_screen_animation);
            this.T = (VelvoPreviewView) findViewById(R.id.velvo_preview);
            this.k.setVisibility(4);
            this.l.setVisibility(4);
            this.m.setVisibility(4);
            this.n.setVisibility(4);
            this.o.setVisibility(4);
            this.j.setVisibility(4);
            this.j.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            View view = this.n;
            if (view != null) {
                view.setOnClickListener(this);
            }
            this.o.setOnClickListener(this);
            this.G.getChatSend().setOnClickListener(this);
            CoustomLinearLayout coustomLinearLayout = (CoustomLinearLayout) findViewById(R.id.chat_live_sync_layer);
            this.q = coustomLinearLayout;
            coustomLinearLayout.setListener(new v());
            this.N.setOnClickListener(this);
            this.O.setOnClickListener(this);
            this.K.setOnClickListener(this);
            this.d.setHorizontallyScrolling(false);
            this.d.setMaxLines(5);
            this.e = (RecyclerView) findViewById(R.id.chat_message_list);
            this.Q = (CustomSwipeRefreshLayout) findViewById(R.id.swipe_refresh_message);
            this.f = findViewById(R.id.chat_bottom_layer);
            EmojisToastView emojisToastView = (EmojisToastView) findViewById(R.id.chat_emojis_tosat_layer);
            this.R = emojisToastView;
            emojisToastView.setVisibility(8);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.lottie_view);
            this.S = lottieAnimationView;
            lottieAnimationView.e(new f0());
            View viewFindViewById2 = findViewById(R.id.chat_emojis_panel_layout);
            this.g = viewFindViewById2;
            viewFindViewById2.setVisibility(8);
            this.h = findViewById(R.id.chat_more_layer);
            this.s = findViewById(R.id.pic_view_layer);
            findViewById(R.id.unread_bar);
            this.t = (SubsamplingScaleImageView) findViewById(R.id.pic_big_view);
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.pic_big_loading);
            this.u = progressBar;
            progressBar.setOnClickListener(new q0(this));
            this.d.setOnTouchListener(new r0());
            this.Q.setListener(this);
            this.d.setEmojisUtils(this.W);
            this.L.setOnClickListener(this);
            this.v = new z73(this, this, this.X, this.W);
            c83 c83VarR1 = c83.R1();
            this.m0 = c83VarR1;
            if (c83VarR1 != null) {
                c83VarR1.v1(this);
            }
            this.e.setOnTouchListener(new s0());
            this.e.addOnScrollListener(new t0());
            this.Q.setOnRefreshListener(new u0());
            this.Q.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);
            this.t.setOnClickListener(new v0());
            this.V = new Handler(Looper.getMainLooper());
            if (WearUtils.e1(DaoUtils.getTestValueDao().getValue(zt3.k, TestValueDao.CONTROL_LINK_CHAT_NOTE)) && !MyApplication.h0) {
                d83.w().c0(this, ah4.e(R.string.control_link_privacy_warining), true, new a(this));
            }
            k5(this.j0, this.g0);
            eq2.f().d();
            keyboardHelperInit(this.b, this.f, this.G, this.M, this.i);
            me3.d(me3.c.CONTROL_LINK_CHAT_UI_ENTER, me3.a());
            ye3.c("control link chatroom", "into page", this.d0);
            m5();
            this.c.setBackAction(new b());
            q5();
            c83.R1().I2(this.T);
            this.G.q(this);
            this.G.s(this.p);
            if (this.u0 == null) {
                this.u0 = ChatActionMenuFragmentBottom.E(2);
            }
            this.u0.F(this);
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        xr3 xr3Var = this.A;
        if (xr3Var != null && xr3Var.p()) {
            this.A.d();
        }
        try {
            EventBus.getDefault().unregister(this);
            DaoUtils.getChatRoomSensitiveDao().deleteItemByRoomId(this.j0);
            super.onDestroy();
            me3.c(me3.c.CONTROL_LINK_CHAT_UI_EXIT);
            c83 c83Var = this.m0;
            if (c83Var != null) {
                c83Var.e0(false);
            }
            MyActionBar myActionBar = this.c;
            if (myActionBar != null) {
                myActionBar.s();
            }
            if (!qf3.a || this.application.o) {
                qf3.t(null);
            } else {
                qf3.v(null, null);
            }
            ChatSyncControl.N0().O(null);
            ChatLiveControl.q0().O(null);
            CoustomLinearLayout coustomLinearLayout = this.q;
            if (coustomLinearLayout != null) {
                coustomLinearLayout.removeAllViews();
            }
            so3 so3Var = this.X;
            if (so3Var != null && so3Var.s()) {
                MusicControl.h0();
                h12.D.isPlayAudio = false;
                this.X.G();
                this.X.x();
                this.X.F();
                this.application.G().u0();
            }
            Handler handler = this.V;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            if (qe3.b.exists()) {
                qe3.b.delete();
            }
            c83 c83Var2 = this.m0;
            if (c83Var2 == null || !c83Var2.r()) {
                this.application.G().u0();
            }
            this.f0 = null;
            this.e = null;
            System.gc();
            c83 c83Var3 = this.m0;
            if (c83Var3 != null) {
                c83Var3.v1(null);
            }
            d83.w().M();
        } catch (Exception e2) {
            e2.printStackTrace();
            c83 c83Var4 = this.m0;
            if (c83Var4 != null) {
                c83Var4.v1(null);
            }
            FirebaseCrashlytics.getInstance().setCustomKey("controlDestroy", "control link destroy error");
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(gq2 gq2Var) {
        ControlLinkCommunMessage controlLinkCommunMessageA = gq2Var.a();
        a5(controlLinkCommunMessageA, true);
        if (dq2.w().y(controlLinkCommunMessageA)) {
            this.m0.T1().add(controlLinkCommunMessageA);
            ControlLinkMessageAdapter controlLinkMessageAdapter = this.f0;
            if (controlLinkMessageAdapter != null) {
                controlLinkMessageAdapter.notifyDataSetChanged();
            }
            M5();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEventCl(InputResizeEvent inputResizeEvent) {
        String str = "setMPadding InputResizeEvent ResizeHeight:" + inputResizeEvent.getResizeHeight();
        if (inputResizeEvent.getFlag() == 1) {
            this.G.j(inputResizeEvent.getResizeHeight());
        } else if (inputResizeEvent.getFlag() == 2) {
            L5(inputResizeEvent.getResizeHeight());
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.c0 = WearUtils.y.u();
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String string = extras.getString("linkId");
            if (!WearUtils.e1(string) && !this.j0.equals(string)) {
                this.j0 = string;
                k5(string, null);
            }
        }
        J5();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ue3.a(this.d, this);
        b5();
    }

    @Override // com.wear.BaseActivity
    public void onSoftKeyboardOpened() {
        K5();
    }

    public final void p5() {
        c83.R1().b2();
    }

    public final void p6() {
        if (this.h0) {
            ControlLinkCommunMessage controlLinkCommunMessage = null;
            if (!this.m0.T1().isEmpty()) {
                Iterator<ControlLinkCommunMessage> it = this.m0.T1().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ControlLinkCommunMessage next = it.next();
                    if (next.getMsgType() == MessageType.controllinktimer) {
                        controlLinkCommunMessage = next;
                        break;
                    }
                }
            }
            if (controlLinkCommunMessage == null) {
                return;
            }
            EntityControlLinkTimer entityControlLinkTimer = (EntityControlLinkTimer) controlLinkCommunMessage.getDataBean();
            entityControlLinkTimer.setCancel(true);
            c5(controlLinkCommunMessage.getId());
            controlLinkCommunMessage.sendEntity(entityControlLinkTimer);
            ControlLinkMessageAdapter controlLinkMessageAdapter = this.f0;
            if (controlLinkMessageAdapter != null) {
                controlLinkMessageAdapter.notifyItemChanged(this.m0.T1().indexOf(controlLinkCommunMessage), "updateRemainTime");
            }
        }
    }

    @Override // dc.ma2
    public void q() {
    }

    @Override // dc.ma2
    public void q0(String str) {
        this.m0.S2(str);
        dq2.w().h(this.j0, new t(this));
    }

    public final void q5() {
        this.r0.setScaleType(di1.FIT_CENTER);
        this.r0.setAnimListener(new m0());
    }

    public final void q6() {
        d83.d dVar;
        boolean creatorExistUntreatedSyncControlRequest;
        if (!d83.w().I() || d83.w().J()) {
            this.V.removeCallbacks(this.x0);
            return;
        }
        if (d83.w().i()) {
            ControlLinkBean.ControlPermissionResponse controlPermissionResponseZ = d83.w().getA();
            Objects.requireNonNull(controlPermissionResponseZ);
            creatorExistUntreatedSyncControlRequest = controlPermissionResponseZ.getCreatorExistUntreatedLiveControlRequest();
            dVar = d83.d.live_control;
        } else if (d83.w().k()) {
            dVar = d83.d.sync_control;
            ControlLinkBean.ControlPermissionResponse controlPermissionResponseZ2 = d83.w().getA();
            Objects.requireNonNull(controlPermissionResponseZ2);
            creatorExistUntreatedSyncControlRequest = controlPermissionResponseZ2.getCreatorExistUntreatedSyncControlRequest();
        } else {
            dVar = d83.d.live_control;
            creatorExistUntreatedSyncControlRequest = false;
        }
        if (creatorExistUntreatedSyncControlRequest) {
            if (dVar == d83.d.live_control) {
                if (d83.w().l()) {
                    n6(true);
                    return;
                } else {
                    k6(d83.c.request, dVar, true);
                    return;
                }
            }
            if (d83.w().m()) {
                n6(false);
            } else {
                k6(d83.c.request, dVar, true);
            }
        }
    }

    @Override // dc.ma2
    public HashMap<String, String> r() {
        return null;
    }

    @Override // dc.cv1
    public void r2() {
        finish();
    }

    public final void r5() {
        s5();
        V2();
    }

    public final void r6(boolean z2) {
        if (z2) {
            if (d83.w().getA() == null) {
                return;
            }
            if (!(Objects.equals(d83.w().getB(), d83.d.live_control.name()) ? d83.w().getA().getCreatorExistUntreatedLiveControlRequest() : d83.w().getA().getCreatorExistUntreatedSyncControlRequest()) && !d83.w().getT()) {
                return;
            } else {
                c83.R1().K2(this.c, d83.w().getB());
            }
        }
        this.V.removeCallbacks(this.v0);
        this.m0.T2(z2);
    }

    public final void s5() {
        this.U = 0;
        this.m0.T1().clear();
        l5();
        dq2.w().H();
    }

    @Override // dc.ma2
    public void t() {
        if (na2.m().g(this.e0, MessageType.sync) && !isFinishing()) {
            if (!hf3.d(this)) {
                sg3.i(this, R.string.common_settingTip);
                return;
            }
            if (!MyApplication.P) {
                sg3.i(this, R.string.common_timeout_error);
                return;
            }
            if (this.m0.U1() == 2) {
                sg3.l(ah4.e(R.string.long_distance_update_partner_app));
                return;
            }
            if (this.h0 && this.application.G().P().size() <= 0) {
                sg3.l(ah4.e(R.string.str_chatroom_you_no_toy));
                return;
            }
            if (!this.h0) {
                if (this.m0.K1() >= 2) {
                    sg3.l(ah4.e(R.string.control_link_another_unavailable));
                    return;
                } else if (this.e0.getLinkedToys2().size() <= 0) {
                    sg3.l(ah4.e(R.string.str_chatroom_partner_no_toy));
                    return;
                }
            }
            if (d83.w().g0(this.h0)) {
                return;
            }
            if (this.h0) {
                d83.w().V(d83.d.sync_control);
            }
            i5();
        }
    }

    @Override // dc.ma2
    public void v() {
        if (na2.m().g(this.e0, MessageType.live) && !isFinishing()) {
            if (!hf3.d(this)) {
                sg3.i(this, R.string.common_settingTip);
                return;
            }
            if (!MyApplication.P) {
                sg3.i(this, R.string.common_timeout_error);
                return;
            }
            if (!this.h0 && this.m0.K1() >= 2) {
                sg3.l(ah4.e(R.string.control_link_another_unavailable));
            } else {
                if (d83.w().g0(this.h0)) {
                    return;
                }
                if (this.h0) {
                    d83.w().V(d83.d.live_control);
                }
                h5();
            }
        }
    }

    @Override // dc.ma2
    public void v2(ControlLinkCommunMessage controlLinkCommunMessage) {
    }

    @Override // dc.cv1, dc.jv1
    public void y(IPeopleInfo iPeopleInfo) {
        if (iPeopleInfo == null || !iPeopleInfo.getUserJid().equals(this.d0)) {
            return;
        }
        f5();
    }

    public final void y5(String str) {
        runOnUiThread(new z(str));
    }

    public void z5(int i2) {
        HashMap map = new HashMap();
        if (i2 == 1) {
            map.put("event_id", "send_friend_request_popup_exposure");
            map.put("element_id", "send_friend_request_popup");
        }
        if (i2 == 2) {
            map.put("event_id", "accept_friend_request_popup_exposure");
            map.put("element_id", "accept_friend_request_popup");
        }
        map.put("page_name", "control link chatroom");
        map.put("event_type", "exposure");
        map.put("element_type", "popup");
        map.put("element_name", this.g0.getLinkId());
        map.put("toys", WearUtils.x.G().m());
        ye3.e("S0009", map);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(hq2 hq2Var) {
        EntityChat entityChat;
        ControlLinkCommunMessage controlLinkCommunMessageA = hq2Var.a();
        if (dq2.w().y(controlLinkCommunMessageA)) {
            ControlLinkMessageAdapter controlLinkMessageAdapter = this.f0;
            if (controlLinkMessageAdapter != null) {
                controlLinkMessageAdapter.notifyItemChanged(this.m0.T1().indexOf(controlLinkCommunMessageA), "sendStatus");
            }
            f6(controlLinkCommunMessageA);
            if (controlLinkCommunMessageA.getMsgType() == MessageType.chat && (entityChat = (EntityChat) controlLinkCommunMessageA.getDataBean()) != null) {
                o6(entityChat.getText());
            }
            controlLinkCommunMessageA.setRead(true);
            DaoUtils.getControlLinkCommunMessageDao().update((ControlLinkCommunMessageDao) controlLinkCommunMessageA);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ControlLinkChatControlEnd controlLinkChatControlEnd) {
        if (controlLinkChatControlEnd.getUserId().equals(this.d0)) {
            if (controlLinkChatControlEnd.getMessageType().equals(MessageType.live)) {
                EntityLive entityLive = new EntityLive();
                entityLive.setType(EntityLive.LiveOPTType.end.toString());
                entityLive.setId(gu3.j.getControlId());
                entityLive.setControlTime(controlLinkChatControlEnd.getControlTime());
                ControlLinkCommunMessage controlLinkCommunMessage = new ControlLinkCommunMessage();
                controlLinkCommunMessage.setFromId(WearUtils.y.j());
                controlLinkCommunMessage.setToId(this.d0);
                controlLinkCommunMessage.sendEntity(entityLive, this.g0.getX(), this.g0.getY());
                controlLinkCommunMessage.setId(WearUtils.E());
                controlLinkCommunMessage.setDateImType("control_link");
                controlLinkCommunMessage.setDateImTypeData(this.j0);
                a5(controlLinkCommunMessage, true);
                dq2.w().D(controlLinkCommunMessage, this.j0);
                return;
            }
            EntitySync entitySync = new EntitySync();
            entitySync.setType(EntitySync.SyncOPTType.end.toString());
            entitySync.setId(gu3.j.getControlId());
            entitySync.setControlTime(controlLinkChatControlEnd.getControlTime());
            ControlLinkCommunMessage controlLinkCommunMessage2 = new ControlLinkCommunMessage();
            controlLinkCommunMessage2.setFromId(WearUtils.y.j());
            controlLinkCommunMessage2.setToId(this.d0);
            controlLinkCommunMessage2.sendEntity(entitySync, this.g0.getX(), this.g0.getY());
            controlLinkCommunMessage2.setId(WearUtils.E());
            controlLinkCommunMessage2.setDateImType("control_link");
            controlLinkCommunMessage2.setDateImTypeData(this.j0);
            a5(controlLinkCommunMessage2, true);
            dq2.w().D(controlLinkCommunMessage2, this.j0);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(iq2 iq2Var) {
        iq2Var.a();
        throw null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(fq2 fq2Var) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        finish();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ControlLinkDownTimeEvent controlLinkDownTimeEvent) {
        for (int i2 = 0; i2 < this.m0.T1().size(); i2++) {
            ControlLinkCommunMessage controlLinkCommunMessage = this.m0.T1().get(i2);
            if (TextUtils.equals(controlLinkCommunMessage.getId(), controlLinkDownTimeEvent.getId())) {
                EntityControlLinkTimer entityControlLinkTimer = (EntityControlLinkTimer) controlLinkCommunMessage.getDataBean();
                entityControlLinkTimer.setRemainTime(controlLinkDownTimeEvent.getTime());
                entityControlLinkTimer.setCancel(controlLinkDownTimeEvent.getTime() <= 0);
                controlLinkCommunMessage.sendEntity(entityControlLinkTimer);
                ControlLinkMessageAdapter controlLinkMessageAdapter = this.f0;
                if (controlLinkMessageAdapter != null) {
                    controlLinkMessageAdapter.notifyItemChanged(i2, "updateRemainTime");
                    return;
                }
                return;
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(AddFriendsTimeEvent addFriendsTimeEvent) {
        c83 c83Var;
        if (this.m0 == null || !c83.R1().g2()) {
            return;
        }
        if (!TextUtils.equals(this.m0.V1(), n5())) {
            G5();
            return;
        }
        if (this.m0.X1() == 1) {
            if (addFriendsTimeEvent.getTime() < (WearUtils.B ? 10 : 180) || (c83Var = this.m0) == null || this.B || c83Var.W1() == 4) {
                return;
            }
            e6(this.m0.W1() != 0 ? this.m0.W1() : 1);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(AddFriendsAckClEvent addFriendsAckClEvent) {
        this.E = true;
        this.m0.D2(2);
        CountDownTimer countDownTimer = this.D;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(AddFriendsReqTcEvent addFriendsReqTcEvent) {
        xr3 xr3Var = this.A;
        if (xr3Var != null && xr3Var.p()) {
            this.A.d();
        }
        if (this.E) {
            return;
        }
        if (this.m0 == null || c83.R1().g2()) {
            e6(3);
            this.A.v();
            EntitySystem entitySystem = new EntitySystem();
            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T400.toString(), EntitySystem.SystemOPTCode.C704.toString(), ah4.e(R.string.control_link_friend_request_sent_hint));
            this.m0.w1(entitySystem);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(RefreshOpenfireFriendTc refreshOpenfireFriendTc) {
        if (this.A.p()) {
            this.A.d();
        }
        this.m0.D2(4);
        synchronized (new Object()) {
            EntitySystem entitySystem = new EntitySystem();
            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T400.toString(), EntitySystem.SystemOPTCode.C704.toString(), ah4.e(R.string.control_link_friend_request_success));
            this.m0.w1(entitySystem);
            this.q0 = true;
        }
        this.C.setVisibility(0);
        j5();
    }
}
