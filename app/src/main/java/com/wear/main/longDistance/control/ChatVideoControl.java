package com.wear.main.longDistance.control;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.bean.Account;
import com.wear.bean.ControlIdBean;
import com.wear.bean.KeepScreenSetting;
import com.wear.bean.MediaPattern;
import com.wear.bean.RateFeature;
import com.wear.bean.RecallToyControl;
import com.wear.bean.Toy;
import com.wear.bean.ToyBean;
import com.wear.bean.User;
import com.wear.bean.UserRoulette;
import com.wear.bean.controlmutlitoys.Ball2CurveEventBean;
import com.wear.bean.event.NetworkInfoEvent;
import com.wear.bean.event.WebRtcStatusEvent;
import com.wear.bean.event.XmppReconctionSuccessEvent;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.network.presenter.bean.AgoraTokenBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntitySystem;
import com.wear.protocol.EntityToy;
import com.wear.protocol.EntityVideo;
import com.wear.protocol.EntityVoice;
import com.wear.protocol.MessageType;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.FloatingNewControlView;
import com.wear.widget.HotView;
import com.wear.widget.control.NewLDRPanel;
import com.wear.widget.control.multiToys.MultiControlPanel;
import com.wear.widget.control.multiToys.MultiCurveLineView;
import com.wear.widget.dialog.VideoVoiceShowDialog;
import com.wear.widget.velvo.VelvoPreviewView;
import dc.ah4;
import dc.aq2;
import dc.bd2;
import dc.ce3;
import dc.ch3;
import dc.cs3;
import dc.de0;
import dc.dh3;
import dc.ek2;
import dc.ev1;
import dc.fk2;
import dc.fv1;
import dc.gu3;
import dc.hf3;
import dc.hu3;
import dc.is3;
import dc.jp3;
import dc.jv1;
import dc.ka2;
import dc.kf;
import dc.kn3;
import dc.lg4;
import dc.me3;
import dc.mk2;
import dc.nd3;
import dc.od3;
import dc.oj3;
import dc.ou3;
import dc.pa2;
import dc.pc1;
import dc.pd3;
import dc.pj3;
import dc.q61;
import dc.qf3;
import dc.qo;
import dc.rq1;
import dc.sg3;
import dc.so3;
import dc.sz1;
import dc.th4;
import dc.tn2;
import dc.u51;
import dc.ua2;
import dc.ve0;
import dc.xe3;
import dc.y12;
import dc.ye3;
import dc.yf3;
import dc.yn2;
import dc.zb2;
import io.agora.rtc2.ChannelMediaOptions;
import io.agora.rtc2.IRtcEngineEventHandler;
import io.agora.rtc2.RtcEngine;
import io.agora.rtc2.RtcEngineConfig;
import io.agora.rtc2.video.VideoCanvas;
import io.agora.rtc2.video.VideoEncoderConfiguration;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smack.packet.Presence;
import org.webrtc.EglBase;
import org.webrtc.RendererCommon;
import org.webrtc.SurfaceViewRenderer;

/* loaded from: classes3.dex */
public class ChatVideoControl extends ka2<User, jv1> implements View.OnClickListener, aq2.d, pd3.b {
    public AlphaAnimation A;
    public AlphaAnimation B;
    public boolean C;
    public EntityToy D;
    public boolean E;
    public boolean F;
    public Dialog G;
    public String K;
    public boolean L;
    public boolean M;
    public ViewGroup N;
    public View O;
    public Timer P;
    public long Q;
    public Timer R;
    public Handler S;
    public boolean T;
    public boolean U;
    public boolean V;
    public Map<String, RecallToyControl> W;
    public boolean X;
    public RtcEngine Y;
    public jp3 Z;
    public Runnable a0;
    public final IRtcEngineEventHandler b0;

    @BindView(R.id.chat_video_channel_voice)
    public ImageView chatVideoChannelVoice;

    @BindView(R.id.chat_video_collect)
    public ImageView chatVideoCollect;

    @BindView(R.id.chat_video_record_time_hit)
    public HotView chatVideoRecordTimeHit;

    @BindView(R.id.chat_video_record_time_layout)
    public LinearLayout chatVideoRecordTimeLayout;

    @BindView(R.id.chat_video_record_time_time)
    public TextView chatVideoRecordTimeTime;

    @BindView(R.id.chat_video_switch_camera)
    public ImageView chatVideoSwitchCamera;

    @BindView(R.id.chat_video_switch_record)
    public ImageView chatVideoSwitchRecord;

    @BindView(R.id.chat_voice_sound_model)
    public ImageView chatVoiceSoundModel;

    @BindView(R.id.fl_dlr_layout)
    public FrameLayout flDlrLayout;

    @BindView(R.id.fl_rtc_root_view)
    public FrameLayout flRtcRootView;

    @BindView(R.id.iv_accept)
    public ImageView ivAccept;

    @BindView(R.id.iv_cancel)
    public ImageView ivCancel;

    @BindView(R.id.iv_friend_avatar)
    public RoundedImageView ivFriendAvatar;

    @BindView(R.id.iv_ldr_control)
    public ImageView ivLdrControl;

    @BindView(R.id.iv_reject)
    public ImageView ivReject;

    @BindView(R.id.iv_voice_bg)
    public ImageView ivVoiceBg;

    @BindView(R.id.layout_receive)
    public ConstraintLayout layoutReceive;

    @BindView(R.id.ldr_panel)
    public NewLDRPanel ldrPanel;

    @BindView(R.id.ldr_sensitivity)
    public SeekBar ldrSensitivity;

    @BindView(R.id.ldr_sensitivity_layout)
    public LinearLayout ldrSensitivityLayout;

    @BindView(R.id.ll_ldr_control)
    public LinearLayout llLdrControl;

    @BindView(R.id.max_view)
    public SurfaceViewRenderer maxView;

    @BindView(R.id.min_view)
    public SurfaceViewRenderer minView;

    @BindView(R.id.multi_control_panel)
    public MultiControlPanel multiControlPanel;
    public Handler n;
    public pa2 o;
    public boolean p;
    public List<Toy> q;
    public Dialog r;

    @BindView(R.id.root_touch_layout)
    public View rootTouchLayout;

    @BindView(R.id.rv_friend)
    public RecyclerView rvFriend;

    @BindView(R.id.rv_self)
    public RecyclerView rvSelf;
    public aq2 s;
    public bd2 t;

    @BindView(R.id.tochange_switch_control_layout)
    public LinearLayout tochangeSwitchControlLayout;

    @BindView(R.id.touch_panel)
    public ConstraintLayout touchPanel;

    @BindView(R.id.tv_accept)
    public TextView tvAccept;

    @BindView(R.id.tv_cancel)
    public TextView tvCancel;

    @BindView(R.id.tv_ldr_control)
    public TextView tvLdrControl;

    @BindView(R.id.tv_linked_toy_notice)
    public TextView tvLinkedToyNotice;

    @BindView(R.id.tv_reject)
    public TextView tvReject;

    @BindView(R.id.tv_request_friend_name)
    public TextView tvRequestFriendName;

    @BindView(R.id.tv_tochange_video_control_dlr)
    public TextView tvTochangeVideoControlDlr;

    @BindView(R.id.tv_tochange_video_control_remote)
    public TextView tvTochangeVideoControlRemote;
    public long u;

    @BindView(R.id.user_avatar_layout)
    public LinearLayout userAvatarLayout;
    public View v;

    @BindView(R.id.velvo_preview)
    public VelvoPreviewView velvoPreviewView;

    @BindView(R.id.video_bottom_control_layout)
    public LinearLayout videoBottomControlLayout;
    public int w;

    @BindView(R.id.webrtc_close)
    public ImageView webrtcClose;

    @BindView(R.id.webrtc_control_layout)
    public LinearLayout webrtcControlLayout;

    @BindView(R.id.webrtc_control_times)
    public TextView webrtcControlTimes;

    @BindView(R.id.webrtc_flash)
    public TextView webrtcFlash;
    public boolean x;
    public boolean y;
    public double z;

    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            ChatVideoControl chatVideoControl = ChatVideoControl.this;
            if (!chatVideoControl.e || chatVideoControl.O == null) {
                return false;
            }
            ChatVideoControl chatVideoControl2 = ChatVideoControl.this;
            chatVideoControl2.A1(chatVideoControl2.O);
            return false;
        }
    }

    public class a0 implements is3.c {
        public a0() {
        }

        @Override // dc.is3.c
        public void doCancel() {
            if (ChatVideoControl.this.r()) {
                ChatVideoControl chatVideoControl = ChatVideoControl.this;
                chatVideoControl.e = false;
                chatVideoControl.E1(false);
            }
        }
    }

    public class b implements fv1 {
        public b() {
        }

        @Override // dc.fv1
        public void a() {
            if (ChatVideoControl.this.t.g()) {
                return;
            }
            ChatVideoControl.this.v.setBackgroundResource(R.drawable.minimize_drag);
        }

        @Override // dc.fv1
        public void b(boolean z) {
            if (ChatVideoControl.this.t.g()) {
                return;
            }
            if (z) {
                ChatVideoControl.this.v.setBackgroundResource(R.drawable.minimize_left_bg);
            } else {
                ChatVideoControl.this.v.setBackgroundResource(R.drawable.minimize_right_bg);
            }
        }
    }

    public class b0 implements is3.d {
        public final /* synthetic */ Activity a;

        public b0(Activity activity) {
            this.a = activity;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            if (ChatVideoControl.this.r()) {
                ChatVideoControl chatVideoControl = ChatVideoControl.this;
                chatVideoControl.e = false;
                chatVideoControl.E1(false);
            }
            od3.d(this.a);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) "loaded");
            ChatVideoControl.this.I1(jSONObject);
        }
    }

    public class c0 implements Runnable {
        public c0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatVideoControl.this.chatVideoSwitchCamera.setEnabled(true);
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ String b;

        public d(JSONObject jSONObject, String str) {
            this.a = jSONObject;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if ("loaded".equals(this.a.getString("type"))) {
                ChatVideoControl.this.i1();
            }
            ChatVideoControl chatVideoControl = ChatVideoControl.this;
            if (chatVideoControl.L) {
                return;
            }
            chatVideoControl.s.q(this.b);
        }
    }

    public class d0 implements Runnable {
        public d0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatVideoControl.this.chatVoiceSoundModel.setEnabled(true);
            ChatVideoControl chatVideoControl = ChatVideoControl.this;
            if (chatVideoControl.L) {
                chatVideoControl.Y.setEnableSpeakerphone(ChatVideoControl.this.y);
            } else {
                WearUtils.x.w0(chatVideoControl.y);
            }
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatVideoControl.this.O = null;
            ChatVideoControl.this.touchPanel.setVisibility(8);
        }
    }

    public interface e0 {
        void a(String str);
    }

    public class f implements u51 {
        public f() {
        }

        @Override // dc.u51
        public void a(List<String> list, boolean z) {
            ChatVideoControl.this.t.c();
            ChatVideoControl.this.X0(false, true, true);
            gu3.j.setAvailable(ControlIdBean.Status.accept);
            Account accountU = WearUtils.y.u();
            String acceptVideoRequestJid = accountU != null ? accountU.getAcceptVideoRequestJid() : "";
            if (ChatVideoControl.this.t.g()) {
                EntityVideo entityVideo = new EntityVideo();
                entityVideo.setType(EntityVideo.VideoOPTType.accept.toString());
                entityVideo.setId(gu3.j.getControlId());
                hu3.g0(entityVideo, acceptVideoRequestJid, MessageType.video, EntityVideo.VideoOPTType.reject.toString(), null, null);
                return;
            }
            EntityVoice entityVoice = new EntityVoice();
            entityVoice.setType(EntityVoice.VoiceOPTType.accept.toString());
            entityVoice.setId(gu3.j.getControlId());
            hu3.g0(entityVoice, acceptVideoRequestJid, MessageType.voice, EntityVoice.VoiceOPTType.reject.toString(), null, null);
        }

        @Override // dc.u51
        public void b(List<String> list, boolean z) {
            if (z) {
                ChatVideoControl.this.e0();
            }
        }
    }

    public static class f0 {
        public static final ChatVideoControl a = new ChatVideoControl(null);
    }

    public class g implements kn3.d {
        public g(ChatVideoControl chatVideoControl) {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ boolean a;

        public h(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatVideoControl chatVideoControl = ChatVideoControl.this;
            boolean z = this.a;
            chatVideoControl.e = z;
            if (z) {
                chatVideoControl.F();
                ChatVideoControl.this.R0();
                return;
            }
            Dialog dialog = chatVideoControl.r;
            if (dialog != null) {
                dialog.dismiss();
            }
            if (ChatVideoControl.this.t.g()) {
                ViewGroup viewGroup = (ViewGroup) ChatVideoControl.this.maxView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(ChatVideoControl.this.maxView);
                }
                ChatVideoControl.this.a.removeAllViews();
                ChatVideoControl chatVideoControl2 = ChatVideoControl.this;
                chatVideoControl2.a.addView(chatVideoControl2.maxView);
            } else {
                ViewGroup viewGroup2 = (ViewGroup) ChatVideoControl.this.v.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(ChatVideoControl.this.v);
                }
                ChatVideoControl.this.a.removeAllViews();
                ChatVideoControl chatVideoControl3 = ChatVideoControl.this;
                chatVideoControl3.a.addView(chatVideoControl3.v);
            }
            ChatVideoControl.this.W();
            ChatVideoControl chatVideoControl4 = ChatVideoControl.this;
            chatVideoControl4.a.setWidthAndHeight(chatVideoControl4.I(), ChatVideoControl.this.getMinWidth(), ChatVideoControl.this.getMinHeight());
            ChatVideoControl.this.a.b();
        }
    }

    public class i implements Runnable {
        public final /* synthetic */ boolean a;

        public i(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            ChatVideoControl chatVideoControl = ChatVideoControl.this;
            chatVideoControl.u = 0L;
            chatVideoControl.T1();
            ChatVideoControl chatVideoControl2 = ChatVideoControl.this;
            chatVideoControl2.multiControlPanel.l0(chatVideoControl2.p ? Integer.MAX_VALUE : 4);
            ChatVideoControl chatVideoControl3 = ChatVideoControl.this;
            if (chatVideoControl3.p) {
                chatVideoControl3.o.b0(true);
                ChatVideoControl.this.o.u0(true, this.a);
                ChatVideoControl.this.c1();
                return;
            }
            chatVideoControl3.o.u0(false, this.a);
            ChatVideoControl chatVideoControl4 = ChatVideoControl.this;
            if (chatVideoControl4.o.g == null) {
                chatVideoControl4.W0();
            }
            ChatVideoControl chatVideoControl5 = ChatVideoControl.this;
            chatVideoControl5.Y1(chatVideoControl5.touchPanel, chatVideoControl5.flDlrLayout);
            ChatVideoControl.this.S1();
        }
    }

    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatVideoControl.this.g.G().u0();
            ou3.w(ChatVideoControl.this.c);
        }
    }

    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatVideoControl.this.O1();
        }
    }

    public class l extends IRtcEngineEventHandler {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ChatVideoControl.this.d2(3);
            }
        }

        public l() {
        }

        @Override // io.agora.rtc2.IRtcEngineEventHandler, io.agora.rtc2.IAgoraEventHandler
        public void onError(int i) {
            super.onError(i);
        }

        @Override // io.agora.rtc2.IRtcEngineEventHandler
        public void onJoinChannelSuccess(String str, int i, int i2) {
            super.onJoinChannelSuccess(str, i, i2);
            ChatVideoControl.this.U(new a());
        }

        @Override // io.agora.rtc2.IRtcEngineEventHandler, io.agora.rtc2.IAgoraEventHandler
        public void onLocalUserRegistered(int i, String str) {
            super.onLocalUserRegistered(i, str);
            de0.l(Integer.valueOf(i), str);
        }

        @Override // io.agora.rtc2.IRtcEngineEventHandler
        public void onUserJoined(int i, int i2) {
            super.onUserJoined(i, i2);
            ChatVideoControl.this.Y.setupRemoteVideo(new VideoCanvas(ChatVideoControl.this.maxView, 1, i));
        }
    }

    public class m implements Runnable {
        public final /* synthetic */ MessageType a;
        public final /* synthetic */ DataEntityAbstract b;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (ChatVideoControl.this.a.c()) {
                    ChatVideoControl.this.v.setBackgroundResource(R.drawable.minimize_drag);
                }
            }
        }

        public m(MessageType messageType, DataEntityAbstract dataEntityAbstract) {
            this.a = messageType;
            this.b = dataEntityAbstract;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a == MessageType.video) {
                String data = ((EntityVideo) this.b).getData();
                if (WearUtils.e1(data) || !data.equals(EntityVideo.CHANGE_VOICE_MODEL_KEY)) {
                    return;
                }
                ChatVideoControl.this.I0(false);
                ChatVideoControl chatVideoControl = ChatVideoControl.this;
                boolean z = chatVideoControl.e;
                if (!z) {
                    chatVideoControl.E1(z);
                }
                ChatVideoControl chatVideoControl2 = ChatVideoControl.this;
                chatVideoControl2.a.setWidthAndHeight(chatVideoControl2.I(), ChatVideoControl.this.getMinWidth(), ChatVideoControl.this.getMinHeight());
                ChatVideoControl.this.a.post(new a());
            }
        }
    }

    public class n extends TimerTask {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ChatVideoControl.l0(ChatVideoControl.this);
                if (ChatVideoControl.this.Q >= 3599) {
                    if (ChatVideoControl.this.Q % 4 == 0) {
                        sg3.h(R.string.record_max_size_notice);
                    }
                    ChatVideoControl.this.chatVideoRecordTimeTime.setText(WearUtils.I0(3599));
                    ChatVideoControl.this.chatVideoRecordTimeHit.setVisibility(0);
                    if (ChatVideoControl.this.Q % 2 == 0) {
                        ChatVideoControl chatVideoControl = ChatVideoControl.this;
                        chatVideoControl.chatVideoRecordTimeLayout.setAnimation(chatVideoControl.A);
                        ChatVideoControl.this.A.start();
                        return;
                    } else {
                        ChatVideoControl chatVideoControl2 = ChatVideoControl.this;
                        chatVideoControl2.chatVideoRecordTimeLayout.setAnimation(chatVideoControl2.B);
                        ChatVideoControl.this.B.start();
                        return;
                    }
                }
                if (ChatVideoControl.this.Q % 2 == 0) {
                    ChatVideoControl.this.chatVideoRecordTimeHit.setVisibility(4);
                } else {
                    ChatVideoControl.this.chatVideoRecordTimeHit.setVisibility(0);
                }
                ChatVideoControl chatVideoControl3 = ChatVideoControl.this;
                chatVideoControl3.chatVideoRecordTimeTime.setText(WearUtils.J0(chatVideoControl3.Q));
                if (ChatVideoControl.this.Q == 5) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = ChatVideoControl.this.W.entrySet().iterator();
                    while (it.hasNext()) {
                        MediaPattern mediaPattern = ((RecallToyControl) ((Map.Entry) it.next()).getValue()).getMediaPattern();
                        if (mediaPattern != null) {
                            mediaPattern.updatePatternJson();
                            arrayList.add(mediaPattern);
                        }
                    }
                    if (arrayList.size() > 0) {
                        DaoUtils.getTestValueDao().setDataList(TestValueDao.SAVE_KEY_VIDEOTOY_RECORD_KEY, arrayList, "1");
                    }
                }
            }
        }

        public n() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            ChatVideoControl chatVideoControl = ChatVideoControl.this;
            if (chatVideoControl.C) {
                if (chatVideoControl.z % 10.0d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    chatVideoControl.U(new a());
                }
                ChatVideoControl chatVideoControl2 = ChatVideoControl.this;
                chatVideoControl2.z += 1.0d;
                Iterator it = chatVideoControl2.W.entrySet().iterator();
                while (it.hasNext()) {
                    ((RecallToyControl) ((Map.Entry) it.next()).getValue()).recallTimer100();
                }
            }
        }
    }

    public class o implements ka2.k {
        public o(ChatVideoControl chatVideoControl) {
        }

        @Override // dc.ka2.k
        public void a() {
        }
    }

    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatVideoControl.this.d2(3);
        }
    }

    public class q implements Runnable {
        public q() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatVideoControl.this.d2(2);
        }
    }

    public class r implements kn3.d {
        public r(ChatVideoControl chatVideoControl) {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
        }
    }

    public class s implements ev1 {
        public s() {
        }

        @Override // dc.ev1
        public void a(ViewGroup viewGroup) {
            viewGroup.removeView(ChatVideoControl.this.N);
            ChatVideoControl.this.t.h();
            ChatVideoControl.this.r = null;
        }

        @Override // dc.ev1
        public void b(ViewGroup viewGroup) {
            viewGroup.removeView(ChatVideoControl.this.N);
            viewGroup.addView(ChatVideoControl.this.N, 0);
            ChatVideoControl chatVideoControl = ChatVideoControl.this;
            if (chatVideoControl.L) {
                return;
            }
            if (chatVideoControl.t.i()) {
                ChatVideoControl chatVideoControl2 = ChatVideoControl.this;
                chatVideoControl2.s.A(chatVideoControl2.maxView);
                ChatVideoControl chatVideoControl3 = ChatVideoControl.this;
                chatVideoControl3.s.B(chatVideoControl3.minView);
                return;
            }
            ChatVideoControl chatVideoControl4 = ChatVideoControl.this;
            chatVideoControl4.s.A(chatVideoControl4.minView);
            ChatVideoControl chatVideoControl5 = ChatVideoControl.this;
            chatVideoControl5.s.B(chatVideoControl5.maxView);
        }
    }

    public class t implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ MessageType c;

        public t(boolean z, String str, MessageType messageType) {
            this.a = z;
            this.b = str;
            this.c = messageType;
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            if (ChatVideoControl.this.E0()) {
                ChatVideoControl.this.t.j();
                ChatVideoControl chatVideoControl = ChatVideoControl.this;
                chatVideoControl.L1(chatVideoControl.velvoPreviewView);
                ChatVideoControl.this.d2(0);
                ChatVideoControl.this.g1(this.a);
                pc1.a.F();
                if (ch3.n().v(WearUtils.X(((User) ChatVideoControl.this.c).getUserJid())).isEnableAgoraIO() && ch3.n().o().isEnableAgoraIO()) {
                    ChatVideoControl chatVideoControl2 = ChatVideoControl.this;
                    if (!chatVideoControl2.M) {
                        chatVideoControl2.Y0(this.b);
                        MessageType messageType = this.c;
                        MessageType messageType2 = MessageType.video;
                        if (messageType == messageType2) {
                            ChatVideoControl.this.b.setCurrentControlType(messageType2);
                        } else {
                            ChatVideoControl.this.b.setCurrentControlType(MessageType.voice);
                        }
                    }
                } else {
                    ChatVideoControl.this.h(lg4.b().getEglBaseContext());
                    ChatVideoControl.this.L = false;
                }
                ChatVideoControl.this.T0(this.a);
                ChatVideoControl.this.O0();
                ChatVideoControl chatVideoControl3 = ChatVideoControl.this;
                chatVideoControl3.a.setWidthAndHeight(chatVideoControl3.I(), ChatVideoControl.this.getMinWidth(), ChatVideoControl.this.getMinHeight());
                ChatVideoControl.this.a.b();
                me3.e(ChatVideoControl.this.t.g() ? me3.a.PRIVATE_CHAT_VIDEO_CONTROL : me3.a.PRIVATE_CHAT_VOICE_CONTROL);
                me3.d(ChatVideoControl.this.t.g() ? me3.c.PRIVATE_CHAT_VIDEO_CONTROL_REMOTE_BEGIN : me3.c.PRIVATE_CHAT_VOICE_CONTROL_REMOTE_BEGIN, me3.a());
                ye3.c("friend chatroom", ChatVideoControl.this.t.g() ? "begin video control" : "begin voice control", ((User) ChatVideoControl.this.c).getUserJid());
                sz1.d().r(8);
            }
        }
    }

    public class u implements yn2<AgoraTokenBean> {
        public final /* synthetic */ String a;

        public u(String str) {
            this.a = str;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(AgoraTokenBean agoraTokenBean) {
            if (agoraTokenBean == null || !agoraTokenBean.isResult()) {
                ChatVideoControl.this.L = false;
                return;
            }
            ChatVideoControl chatVideoControl = ChatVideoControl.this;
            chatVideoControl.L = true;
            chatVideoControl.Q0(agoraTokenBean.getData().getAppId(), agoraTokenBean.getData().getUid());
            if (WearUtils.e1(this.a)) {
                ChatVideoControl.this.l1(agoraTokenBean.getData().getToken(), ChatVideoControl.this.K, agoraTokenBean.getData().getUid());
            } else {
                ChatVideoControl.this.l1(agoraTokenBean.getData().getToken(), this.a, agoraTokenBean.getData().getUid());
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            netException.printStackTrace();
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public class v implements Runnable {
        public final /* synthetic */ User a;
        public final /* synthetic */ MessageType b;

        public class a implements u51 {
            public a() {
            }

            @Override // dc.u51
            public void a(List<String> list, boolean z) {
                ChatVideoControl.this.z1();
                ChatVideoControl.this.t.c();
                ChatVideoControl.this.X0(false, true, true);
                gu3.j.setAvailable(ControlIdBean.Status.accept);
                Account accountU = WearUtils.y.u();
                String acceptVideoRequestJid = accountU != null ? accountU.getAcceptVideoRequestJid() : "";
                if (ChatVideoControl.this.t.g()) {
                    EntityVideo entityVideo = new EntityVideo();
                    entityVideo.setType(EntityVideo.VideoOPTType.accept.toString());
                    entityVideo.setId(gu3.j.getControlId());
                    hu3.g0(entityVideo, acceptVideoRequestJid, MessageType.video, EntityVideo.VideoOPTType.reject.toString(), null, null);
                    return;
                }
                EntityVoice entityVoice = new EntityVoice();
                entityVoice.setType(EntityVoice.VoiceOPTType.accept.toString());
                entityVoice.setId(gu3.j.getControlId());
                hu3.g0(entityVoice, acceptVideoRequestJid, MessageType.voice, EntityVoice.VoiceOPTType.reject.toString(), null, null);
            }

            @Override // dc.u51
            public void b(List<String> list, boolean z) {
                if (z) {
                    v vVar = v.this;
                    ChatVideoControl.this.L(vVar.a);
                    v vVar2 = v.this;
                    bd2 bd2Var = ChatVideoControl.this.t;
                    MessageType messageType = vVar2.b;
                    MessageType messageType2 = MessageType.video;
                    bd2Var.a(messageType == messageType2);
                    if (ch3.n().o().isEnableAgoraIO() && v.this.a.isEnableAgoraIO()) {
                        ChatVideoControl chatVideoControl = ChatVideoControl.this;
                        chatVideoControl.M = true;
                        chatVideoControl.K = UUID.randomUUID().toString();
                        ChatVideoControl chatVideoControl2 = ChatVideoControl.this;
                        chatVideoControl2.Y0(chatVideoControl2.K);
                        v vVar3 = v.this;
                        ChatVideoControl chatVideoControl3 = ChatVideoControl.this;
                        chatVideoControl3.L = true;
                        if (vVar3.b == messageType2) {
                            chatVideoControl3.b.setCurrentControlType(messageType2);
                        } else {
                            chatVideoControl3.b.setCurrentControlType(MessageType.voice);
                        }
                    } else {
                        ChatVideoControl.this.L = false;
                    }
                    v vVar4 = v.this;
                    ChatVideoControl chatVideoControl4 = ChatVideoControl.this;
                    if (!chatVideoControl4.L) {
                        chatVideoControl4.s.x(vVar4.b == messageType2);
                    }
                    ChatVideoControl.this.R0();
                    v vVar5 = v.this;
                    ChatVideoControl.this.U1(true, "", vVar5.b);
                    ChatVideoControl.this.B0();
                }
            }
        }

        public v(User user, MessageType messageType) {
            this.a = user;
            this.b = messageType;
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] strArr = ChatVideoControl.this.t.g() ? new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"} : new String[]{"android.permission.RECORD_AUDIO"};
            q61 q61VarM = q61.m(MyApplication.H());
            q61VarM.h(strArr);
            q61VarM.j(new a());
        }
    }

    public class w implements Runnable {
        public final /* synthetic */ String a;

        public class a implements DialogInterface.OnDismissListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                ChatVideoControl.this.G = null;
            }
        }

        public w(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Dialog dialog = ChatVideoControl.this.G;
            if (dialog != null && dialog.isShowing()) {
                ChatVideoControl.this.G.dismiss();
            }
            ChatVideoControl chatVideoControl = ChatVideoControl.this;
            chatVideoControl.G = cs3.j(chatVideoControl.I(), this.a);
            if (ChatVideoControl.this.I() != null) {
                ChatVideoControl.this.G.show();
                ChatVideoControl.this.G.setOnDismissListener(new a());
            }
        }
    }

    public class x implements Runnable {
        public x() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatVideoControl.this.j1();
        }
    }

    public class y extends TimerTask {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (ChatVideoControl.this.V) {
                    return;
                }
                ChatVideoControl chatVideoControl = ChatVideoControl.this;
                long j = chatVideoControl.u + 1;
                chatVideoControl.u = j;
                if (j % 8 == 0) {
                    chatVideoControl.d1(chatVideoControl.O);
                }
            }
        }

        public y() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (ChatVideoControl.this.O != null) {
                ChatVideoControl.this.U(new a());
            }
        }
    }

    public class z implements Runnable {
        public z(ChatVideoControl chatVideoControl) {
        }

        @Override // java.lang.Runnable
        public void run() {
            rq1.d.q();
        }
    }

    public /* synthetic */ ChatVideoControl(k kVar) {
        this();
    }

    public static ChatVideoControl a1() {
        return f0.a;
    }

    public static /* synthetic */ long l0(ChatVideoControl chatVideoControl) {
        long j2 = chatVideoControl.Q;
        chatVideoControl.Q = 1 + j2;
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o1(boolean z2, boolean z3) throws Resources.NotFoundException {
        Account account = this.b;
        if (account == null) {
            return;
        }
        account.setLiveStatus(0);
        this.b.setLiveFriendId(null);
        this.b.setCurrentControlType(null);
        T t2 = this.c;
        if (t2 != 0) {
            ((User) t2).setSupportLdrTouchPanel(false);
            ((User) this.c).setSupportLDRFillOrder(false);
            ((User) this.c).setSupportSolaceTapButtonControl(false);
        }
        if (z2) {
            String string = (z3 ? EntityVideo.VideoOPTType.cancel : EntityVideo.VideoOPTType.end).toString();
            if (this.t.g()) {
                EntityVideo entityVideo = new EntityVideo();
                entityVideo.setType(string);
                entityVideo.setId(gu3.j.getControlId());
                entityVideo.setControlTime(this.webrtcControlTimes.getText().toString());
                if (gu3.j.isCreate()) {
                    ou3.m(entityVideo, this.c);
                } else {
                    ou3.u(entityVideo, this.c);
                }
                zb2.O().L0(TtmlNode.END, ((User) this.c).getId());
                yf3.i.a().s(RateFeature.Video, Integer.valueOf(WearUtils.C0(Z0())));
            } else {
                EntityVoice entityVoice = new EntityVoice();
                entityVoice.setType(string);
                entityVoice.setId(gu3.j.getControlId());
                entityVoice.setControlTime(this.webrtcControlTimes.getText().toString());
                if (gu3.j.isCreate()) {
                    ou3.m(entityVoice, this.c);
                } else {
                    ou3.u(entityVoice, this.c);
                }
                yf3.i.a().s(RateFeature.Voice, Integer.valueOf(WearUtils.C0(Z0())));
            }
            yf3.i.a().n();
        }
        N0();
        F0();
        this.velvoPreviewView.o();
        jp3.h.a();
        jp3 jp3Var = this.Z;
        if (jp3Var != null) {
            jp3Var.e();
        }
        this.o.u0(false, z2);
        this.o.f();
        this.ldrPanel.b();
        W0();
        ou3.w(this.c);
        U0();
        this.F = false;
        this.T = false;
        gu3.j.setAvailable(ControlIdBean.Status.end);
        pc1.a.I();
        zb2.O().R0();
        this.S.postDelayed(new Runnable() { // from class: dc.y92
            @Override // java.lang.Runnable
            public final void run() {
                rq1.d.q();
            }
        }, 200L);
        V0();
        if (this.t.d()) {
            me3.e(me3.a.OTHERS);
            me3.d(k1() ? me3.c.PRIVATE_CHAT_VIDEO_CONTROL_END : me3.c.PRIVATE_CHAT_VOICE_CONTROL_END, String.valueOf(this.w));
            if (z2) {
                ye3.c(null, k1() ? "end video control" : "end voice control", ((User) this.c).getUserJid());
            }
            ye3.c(null, k1() ? "ended video control" : "ended voice control", ((User) this.c).getUserJid());
            sz1.d().o();
        }
        this.t.c();
        this.w = 0;
        E();
        G();
        if (mk2.P().h0()) {
            mk2.P().n0(false);
        }
        z1();
        this.maxView.release();
        this.minView.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q1(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.V = true;
        }
        if (motionEvent.getAction() == 1) {
            this.V = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s1() {
        if (this.o.h0(true)) {
            pa2 pa2Var = this.o;
            if (pa2Var.g == null) {
                if (pa2Var.i() == 0) {
                    P1();
                } else {
                    this.multiControlPanel.m0(this.o.i());
                }
            }
            if (k1()) {
                EntityVideo entityVideo = new EntityVideo();
                entityVideo.setType(EntityVideo.VideoOPTType.swapLDRControl.toString());
                ou3.m(entityVideo, this.c);
            } else {
                EntityVoice entityVoice = new EntityVoice();
                entityVoice.setType(EntityVoice.VoiceOPTType.swapLDRControl.toString());
                ou3.m(entityVoice, this.c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u1(List list) throws NumberFormatException {
        if (this.c != 0) {
            boolean z2 = this.p;
            if (!z2 || this.o.g == null) {
                if (z2 && this.o.n == 2) {
                    return;
                }
                jp3 jp3Var = this.Z;
                if (jp3Var != null) {
                    jp3Var.k(list);
                }
                if (this.t.d()) {
                    MessageType messageType = this.t.g() ? MessageType.video : MessageType.voice;
                    String function = "";
                    if (this.o.e) {
                        Iterator it = list.iterator();
                        String groups = "";
                        while (it.hasNext()) {
                            Ball2CurveEventBean ball2CurveEventBean = (Ball2CurveEventBean) it.next();
                            if (ball2CurveEventBean != null) {
                                if (!WearUtils.e1(ball2CurveEventBean.getFunction())) {
                                    function = WearUtils.e1(function) ? ball2CurveEventBean.getFunction() : function + "," + ball2CurveEventBean.getFunction();
                                }
                                if (!WearUtils.e1(ball2CurveEventBean.getGroups())) {
                                    groups = WearUtils.e1(groups) ? ball2CurveEventBean.getGroups() : groups + "," + ball2CurveEventBean.getGroups();
                                }
                            }
                        }
                        String strChangeSinglefuncLineToTayValue = Toy.changeSinglefuncLineToTayValue(function, groups);
                        if (ou3.a(function, strChangeSinglefuncLineToTayValue)) {
                            ou3.x((User) this.c, function, strChangeSinglefuncLineToTayValue, false);
                            c2(function.split(","), strChangeSinglefuncLineToTayValue.split(","), true);
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        Ball2CurveEventBean ball2CurveEventBean2 = (Ball2CurveEventBean) it2.next();
                        if (!arrayList.contains(ball2CurveEventBean2.getToyAddress())) {
                            arrayList.add(ball2CurveEventBean2.getToyAddress());
                        }
                    }
                    ArrayList<Ball2CurveEventBean> arrayList2 = new ArrayList();
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        String str = (String) it3.next();
                        Ball2CurveEventBean ball2CurveEventBean3 = new Ball2CurveEventBean(str);
                        StringBuilder sb = new StringBuilder();
                        StringBuilder sb2 = new StringBuilder();
                        Iterator it4 = list.iterator();
                        while (it4.hasNext()) {
                            Ball2CurveEventBean ball2CurveEventBean4 = (Ball2CurveEventBean) it4.next();
                            if (TextUtils.equals(ball2CurveEventBean4.getToyAddress(), str)) {
                                sb.append(ball2CurveEventBean4.getFunction());
                                sb.append(",");
                                sb2.append(ball2CurveEventBean4.getGroups());
                                sb2.append(",");
                            }
                            if (ball2CurveEventBean4.isRotateChange()) {
                                ball2CurveEventBean3.setRotateChange(ball2CurveEventBean4.isRotateChange());
                            }
                        }
                        ball2CurveEventBean3.setFunction(sb.substring(0, sb.length() - 1));
                        ball2CurveEventBean3.setGroups(sb2.substring(0, sb2.length() - 1));
                        arrayList2.add(ball2CurveEventBean3);
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (Ball2CurveEventBean ball2CurveEventBean5 : arrayList2) {
                        String strChangeSinglefuncLineToTayValue2 = Toy.changeSinglefuncLineToTayValue(ball2CurveEventBean5.getFunction(), ball2CurveEventBean5.getGroups());
                        if (ou3.b(ball2CurveEventBean5.getToyAddress(), strChangeSinglefuncLineToTayValue2, "") || ball2CurveEventBean5.isRotateChange()) {
                            Ball2CurveEventBean ball2CurveEventBean6 = new Ball2CurveEventBean(ball2CurveEventBean5.getToyAddress(), ball2CurveEventBean5.getFunction(), strChangeSinglefuncLineToTayValue2, ball2CurveEventBean5.isRotateChange());
                            ball2CurveEventBean6.setSymbol(ball2CurveEventBean5.getSymbol());
                            arrayList3.add(ball2CurveEventBean6);
                        }
                    }
                    if (arrayList3.size() > 0) {
                        ou3.r((User) this.c, messageType, arrayList3);
                        W1(true);
                        b2(arrayList3);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w1(String str) {
        this.Z.m(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y1() {
        if (this.F && this.E) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) "loaded");
            this.s.q(jSONObject.toString());
        }
    }

    public final void A1(View view) {
        if (this.F) {
            this.u = 1L;
            if (view != null && view.getVisibility() == 8) {
                view.setVisibility(0);
                S1();
                oj3 oj3Var = new oj3(I(), R.anim.translate_up_current);
                oj3Var.a();
                oj3Var.b(view);
            }
            T1();
        }
    }

    @Override // dc.ka2
    public void B() {
        Dialog dialog = this.r;
        if (dialog != null && dialog.isShowing()) {
            this.r.dismiss();
        }
        gu3.j.setAvailable(ControlIdBean.Status.cancel);
        X0(true, true, false);
    }

    public final void B0() {
        this.videoBottomControlLayout.setVisibility(4);
        this.webrtcControlLayout.setVisibility(0);
        this.userAvatarLayout.setVisibility(0);
        this.layoutReceive.setVisibility(8);
        this.webrtcFlash.setVisibility(0);
        this.webrtcFlash.setText(ah4.e(R.string.chat_video_connecting));
        this.maxView.setVisibility(0);
        this.minView.setVisibility(0);
        if (this.t.g()) {
            this.ivVoiceBg.setVisibility(8);
            this.chatVideoChannelVoice.setVisibility(0);
        } else {
            this.ivVoiceBg.setVisibility(0);
            this.chatVideoChannelVoice.setVisibility(8);
        }
        this.tvRequestFriendName.setText(((User) this.c).getShowNickName());
        e1();
        this.U = false;
    }

    public final void B1(boolean z2, boolean z3) {
        C1(z2, z3, this.t.g(), (User) this.c);
    }

    public final void C0() {
        this.V = false;
        this.u = 0L;
        Timer timer = this.P;
        if (timer != null) {
            timer.cancel();
        }
        Timer timer2 = new Timer();
        this.P = timer2;
        timer2.schedule(new y(), 1000L, 1000L);
    }

    public final void C1(boolean z2, boolean z3, boolean z4, User user) {
        if (user == null || user.isControlLink() || (user instanceof UserRoulette)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("oppo_jid", (Object) user.getUserJid());
        ArrayList arrayList = new ArrayList(user.getLinkedToys2());
        ArrayList<Toy> arrayListP = pc1.a.P();
        new Gson();
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.add(Z((Toy) it.next()));
        }
        jSONObject.put("oppo_toy", (Object) jSONArray);
        JSONArray jSONArray2 = new JSONArray();
        if (arrayListP != null) {
            Iterator<Toy> it2 = arrayListP.iterator();
            while (it2.hasNext()) {
                jSONArray2.add(Z(it2.next()));
            }
        }
        jSONObject.put("toy", (Object) jSONArray2);
        int i2 = 1;
        jSONObject.put("controller_type", (Object) 1);
        int i3 = z4 ? 21 : 3;
        if (this.T) {
            i3 = 22;
        }
        jSONObject.put("control_type", (Object) (i3 + ""));
        if (z3) {
            i2 = 5;
        } else if (z2) {
            i2 = 4;
        } else if (!this.U) {
            i2 = 0;
        }
        jSONObject.put("control_end_type", (Object) Integer.valueOf(i2));
        jSONObject.put("control_duration", (Object) Integer.valueOf(this.w));
        jSONObject.put("control_id", (Object) gu3.j.getControlId());
        ye3.d("F0013", jSONObject.toString());
    }

    public boolean D0(String str) {
        T t2 = this.c;
        return t2 != 0 && ((User) t2).getUserJid().equals(str) && r();
    }

    public void D1(boolean z2, boolean z3, boolean z4, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C1(z2, z3, z4, ch3.n().v(WearUtils.X(str)));
    }

    public boolean E0() {
        return this.t.f() || this.t.e();
    }

    public void E1(boolean z2) {
        U(new h(z2));
    }

    public void F0() {
        MultiControlPanel multiControlPanel = this.multiControlPanel;
        if (multiControlPanel != null) {
            multiControlPanel.U();
        }
        this.S.removeCallbacksAndMessages(null);
        this.C = false;
        if (DaoUtils.getTestValueDao().getExistKey(nd3.u(TestValueDao.SAVE_KEY_KEEP_SCREEN_KEY), TestValueDao.SAVE_KEY_KEEP_SCREEN_TYPE) == null) {
            EventBus.getDefault().post(new KeepScreenSetting(false));
        }
    }

    public synchronized void F1(EntityToy entityToy, boolean z2) {
        boolean z3 = this.C;
        if (!z3) {
            this.D = entityToy;
        }
        if ((z2 || (z3 && this.R != null)) && this.W.size() > 0) {
            this.D = entityToy;
            if (entityToy.getToyOPTType() == EntityToy.ToyOPTType.id) {
                HashMap<String, ToyBean> id = entityToy.getId();
                if (id != null) {
                    for (Map.Entry<String, ToyBean> entry : id.entrySet()) {
                        if (this.W.get(entry.getKey()) != null) {
                            this.W.get(entry.getKey()).pushCommand(entry.getValue());
                        }
                    }
                }
            } else if (entityToy.getToyOPTType() == EntityToy.ToyOPTType.all) {
                ToyBean all = entityToy.getAll();
                Iterator<Map.Entry<String, RecallToyControl>> it = this.W.entrySet().iterator();
                while (it.hasNext()) {
                    it.next().getValue().pushCommand(all);
                }
            }
        }
    }

    public void G0() {
        this.Y.muteLocalVideoStream(true);
        this.Y.muteAllRemoteVideoStreams(true);
        this.Y.disableVideo();
        this.chatVideoSwitchCamera.setVisibility(8);
        this.chatVideoChannelVoice.setVisibility(8);
        this.chatVoiceSoundModel.setVisibility(8);
        this.userAvatarLayout.setVisibility(0);
        this.maxView.setVisibility(8);
        this.minView.setVisibility(8);
        this.b.setCurrentControlType(MessageType.voice);
        this.t.b();
        EntityVideo entityVideo = new EntityVideo();
        entityVideo.setType(EntityVideo.VideoOPTType.changeModel.toString());
        entityVideo.setData(EntityVideo.CHANGE_VOICE_MODEL_KEY);
        zb2.O().z0(((User) this.c).getUserJid(), entityVideo);
        J0();
        WearUtils.x.q("chat_video_change_voice", null);
        K1();
    }

    public final void G1() {
        this.videoBottomControlLayout.setVisibility(4);
        this.webrtcControlLayout.setVisibility(8);
        this.userAvatarLayout.setVisibility(0);
        this.layoutReceive.setVisibility(0);
        this.webrtcFlash.setVisibility(0);
        this.webrtcFlash.setText(ah4.e(R.string.chat_waitAcceptance_notice));
        String avatar = ((User) this.c).getAvatar();
        if (!avatar.startsWith("http")) {
            avatar = WearUtils.e + avatar;
        }
        kf.w(this.ivFriendAvatar.getContext()).v(avatar).a(new qo().h(R.drawable.chat_avatar_default).X(R.drawable.chat_avatar_default)).A0(this.ivFriendAvatar);
        this.maxView.setVisibility(0);
        this.minView.setVisibility(0);
        if (this.t.g()) {
            this.ivVoiceBg.setVisibility(8);
            this.chatVideoChannelVoice.setVisibility(0);
        } else {
            this.ivVoiceBg.setVisibility(0);
            this.chatVideoChannelVoice.setVisibility(8);
        }
        this.tvRequestFriendName.setText(((User) this.c).getShowNickName());
        this.U = false;
    }

    public void H0(MessageType messageType, DataEntityAbstract dataEntityAbstract) {
        U(new m(messageType, dataEntityAbstract));
    }

    public final void H1(DataEntityAbstract dataEntityAbstract) {
        ou3.s(dataEntityAbstract, this.c);
    }

    public void I0(boolean z2) {
        this.T = true;
        me3.d(me3.c.PRIVATE_CHAT_VOICE_CONTROL_REMOTE_BEGIN, me3.a());
        this.chatVideoSwitchCamera.setVisibility(8);
        this.chatVideoChannelVoice.setVisibility(8);
        this.chatVoiceSoundModel.setVisibility(8);
        this.userAvatarLayout.setVisibility(0);
        this.maxView.setVisibility(8);
        this.minView.setVisibility(8);
        this.b.setCurrentControlType(MessageType.voice);
        this.t.b();
        if (z2) {
            EntityVideo entityVideo = new EntityVideo();
            entityVideo.setType(EntityVideo.VideoOPTType.changeModel.toString());
            entityVideo.setData(EntityVideo.CHANGE_VOICE_MODEL_KEY);
            zb2.O().z0(((User) this.c).getUserJid(), entityVideo);
        }
        this.s.d();
        J0();
        if (z2) {
            sg3.h(R.string.chat_change_model_pasivity);
            WearUtils.x.q("chat_video_change_voice", null);
        } else {
            sg3.l(String.format(ah4.e(R.string.chat_change_model), ((User) this.c).getShowNickName()));
            WearUtils.x.q("chat_voiceCall", null);
        }
        K1();
    }

    public final void I1(JSONObject jSONObject) {
        xe3.a("webRtcMessage", "==Send==" + jSONObject.toString());
        if (MyApplication.P) {
            if (this.t.g()) {
                EntityVideo entityVideo = new EntityVideo();
                entityVideo.setType(EntityVideo.VideoOPTType.rtc.toString());
                entityVideo.setData(jSONObject.toString());
                zb2.O().z0(((User) this.c).getUserJid(), entityVideo);
                return;
            }
            EntityVoice entityVoice = new EntityVoice();
            entityVoice.setType(EntityVoice.VoiceOPTType.rtc.toString());
            entityVoice.setData(jSONObject.toString());
            zb2.O().z0(((User) this.c).getUserJid(), entityVoice);
        }
    }

    public void J0() {
        this.userAvatarLayout.setVisibility(0);
        if (this.t.g() && this.F) {
            this.userAvatarLayout.setVisibility(8);
        }
    }

    public final void J1() {
        if (dh3.i((User) this.c)) {
            kn3 kn3Var = new kn3((Context) I(), this.t.g() ? String.format(ah4.e(R.string.str_webrtc_old_android_video), ((User) this.c).getUserName()) : String.format(ah4.e(R.string.str_webrtc_old_android_voice), ((User) this.c).getUserName()), ah4.e(R.string.common_ok), false, false, (kn3.d) new g(this));
            kn3Var.show();
            kn3Var.n();
        } else if (dh3.j((User) this.c)) {
            EntitySystem entitySystem = new EntitySystem();
            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T201.toString(), EntitySystem.SystemOPTCode.C202.toString(), this.t.g() ? ah4.e(R.string.str_webrtc_old_ios_video) : ah4.e(R.string.str_webrtc_old_ios_voice));
            zb2.O().z0(((User) this.c).getUserJid(), entitySystem);
        }
    }

    public void K0() {
        if (this.o.r() == 0 && this.F) {
            this.tochangeSwitchControlLayout.setVisibility(0);
            this.x = true;
        } else {
            this.tochangeSwitchControlLayout.setVisibility(8);
            this.x = false;
        }
    }

    public final void K1() {
        if (this.t.g()) {
            this.chatVideoSwitchCamera.setVisibility(0);
            this.chatVideoChannelVoice.setVisibility(0);
            this.chatVoiceSoundModel.setVisibility(8);
            this.chatVideoCollect.setVisibility(0);
            this.ivVoiceBg.setVisibility(8);
        } else {
            this.chatVideoSwitchCamera.setVisibility(8);
            this.chatVideoChannelVoice.setVisibility(8);
            this.chatVoiceSoundModel.setVisibility(0);
            this.chatVideoCollect.setVisibility(0);
            this.ivVoiceBg.setVisibility(0);
        }
        Map<String, RecallToyControl> map = this.W;
        if (map == null || map.size() <= 0) {
            return;
        }
        this.chatVideoSwitchRecord.setVisibility(0);
    }

    @SuppressLint({"CheckResult"})
    public final void L0() {
        if (MyApplication.H().isFinishing() || MyApplication.H().isDestroyed()) {
            return;
        }
        String[] strArr = this.t.g() ? new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"} : new String[]{"android.permission.RECORD_AUDIO"};
        q61 q61VarM = q61.m(MyApplication.H());
        q61VarM.h(strArr);
        q61VarM.j(new f());
    }

    public void L1(VelvoPreviewView velvoPreviewView) {
        if (velvoPreviewView == null) {
            return;
        }
        velvoPreviewView.setDarkMode();
        this.Z = new jp3(this.multiControlPanel, velvoPreviewView, this.t.g() ? "CHAT_VIDEO_CONTROL" : "CHAT_VOICE_CONTROL");
        this.multiControlPanel.u(new MultiCurveLineView.a() { // from class: dc.v92
            @Override // com.wear.widget.control.multiToys.MultiCurveLineView.a
            public final void a(String str) {
                this.a.w1(str);
            }
        });
    }

    public final void M1() {
        C0();
        P0();
        if (this.e) {
            this.webrtcControlLayout.setVisibility(0);
            if (this.t.g()) {
                this.chatVideoChannelVoice.setVisibility(0);
            } else {
                this.chatVideoChannelVoice.setVisibility(8);
            }
        } else {
            this.webrtcControlLayout.setVisibility(8);
        }
        if (WearUtils.y1(((User) this.c).getToyStatus())) {
            ConstraintLayout constraintLayout = this.touchPanel;
            this.O = constraintLayout;
            constraintLayout.setVisibility(0);
            jp3 jp3Var = this.Z;
            if (jp3Var != null) {
                jp3Var.r();
            }
            this.multiControlPanel.g0();
        } else {
            U(new e());
        }
        this.t.k();
        this.webrtcControlTimes.setVisibility(0);
    }

    public final void N0() {
        Dialog dialog = this.r;
        if (dialog != null) {
            dialog.dismiss();
            this.r = null;
        }
    }

    public void O0() {
        e1();
        this.layoutReceive.setVisibility(8);
        this.videoBottomControlLayout.setVisibility(4);
        this.webrtcFlash.setText(ah4.e(R.string.chat_video_connecting));
        T1();
        this.flDlrLayout.setVisibility(8);
        this.webrtcControlLayout.setVisibility(0);
        this.webrtcClose.setVisibility(0);
        this.webrtcControlTimes.setVisibility(8);
    }

    public final void O1() {
        String strE = ah4.e(R.string.message_user_voice_offline);
        if (r()) {
            strE = !this.t.g() ? String.format(ah4.e(R.string.message_poor_network), ah4.e(R.string.chat_voice)) : String.format(ah4.e(R.string.message_poor_network), ah4.e(R.string.chat_video));
        }
        if (!MyApplication.P || !hf3.d(this.g)) {
            strE = ah4.e(R.string.message_user_voice_offline);
        }
        R1(strE);
        if (this.F) {
            if (gu3.j.isCreate()) {
                if (this.t.g()) {
                    EntityVideo entityVideo = new EntityVideo();
                    entityVideo.setType(EntityVideo.VideoOPTType.end.toString());
                    entityVideo.setId(gu3.j.getControlId());
                    entityVideo.setControlTime(this.webrtcControlTimes.getText().toString());
                    hu3.u(entityVideo, WearUtils.y.p(), ((User) this.c).getUserJid());
                    zb2.O().L0(TtmlNode.END, ((User) this.c).getId());
                } else {
                    EntityVoice entityVoice = new EntityVoice();
                    entityVoice.setType(EntityVoice.VoiceOPTType.end.toString());
                    entityVoice.setId(gu3.j.getControlId());
                    entityVoice.setControlTime(this.webrtcControlTimes.getText().toString());
                    hu3.u(entityVoice, WearUtils.y.p(), ((User) this.c).getUserJid());
                }
            } else if (this.t.g()) {
                EntityVideo entityVideo2 = new EntityVideo();
                entityVideo2.setType(EntityVideo.VideoOPTType.end.toString());
                entityVideo2.setId(gu3.j.getControlId());
                entityVideo2.setControlTime(this.webrtcControlTimes.getText().toString());
                hu3.u(entityVideo2, ((User) this.c).getUserJid(), WearUtils.y.p());
                zb2.O().L0(TtmlNode.END, ((User) this.c).getId());
            } else {
                EntityVoice entityVoice2 = new EntityVoice();
                entityVoice2.setType(EntityVoice.VoiceOPTType.end.toString());
                entityVoice2.setId(gu3.j.getControlId());
                entityVoice2.setControlTime(this.webrtcControlTimes.getText().toString());
                hu3.u(entityVoice2, ((User) this.c).getUserJid(), WearUtils.y.p());
            }
        } else if (gu3.j.isCreate()) {
            if (this.t.g()) {
                EntityVideo entityVideo3 = new EntityVideo();
                entityVideo3.setType(EntityVideo.VideoOPTType.networkError.toString());
                entityVideo3.setId(gu3.j.getControlId());
                hu3.u(entityVideo3, WearUtils.y.p(), ((User) this.c).getUserJid());
                zb2.O().L0(TtmlNode.END, ((User) this.c).getId());
            } else {
                EntityVoice entityVoice3 = new EntityVoice();
                entityVoice3.setType(EntityVoice.VoiceOPTType.networkError.toString());
                entityVoice3.setId(gu3.j.getControlId());
                hu3.u(entityVoice3, WearUtils.y.p(), ((User) this.c).getUserJid());
            }
        } else if (this.t.g()) {
            EntityVideo entityVideo4 = new EntityVideo();
            entityVideo4.setType(EntityVideo.VideoOPTType.networkError.toString());
            entityVideo4.setId(gu3.j.getControlId());
            hu3.u(entityVideo4, ((User) this.c).getUserJid(), WearUtils.y.p());
            zb2.O().L0(TtmlNode.END, ((User) this.c).getId());
        } else {
            EntityVoice entityVoice4 = new EntityVoice();
            entityVoice4.setType(EntityVoice.VoiceOPTType.networkError.toString());
            entityVoice4.setId(gu3.j.getControlId());
            hu3.u(entityVoice4, ((User) this.c).getUserJid(), WearUtils.y.p());
        }
        gu3.j.setAvailable(ControlIdBean.Status.end);
        WearUtils.K1(false, null);
        this.S.removeCallbacksAndMessages(null);
        X0(false, false, false);
    }

    @Override // dc.ka2
    public void P() {
        String str;
        if (((User) this.c).getChatType() != Presence.Type.unavailable) {
            return;
        }
        z1();
        if (this.t.d()) {
            sg3.e(this.g, R.string.message_poor_network_webrtc);
            this.U = true;
            X0(false, false, false);
            return;
        }
        if (this.t.f()) {
            WearUtils.z2();
            if (this.t.g()) {
                str = String.format(ah4.e(R.string.message_poor_network), ah4.e(R.string.chat_video));
                EntityVideo entityVideo = new EntityVideo();
                entityVideo.setType(EntityVideo.VideoOPTType.noAnswer.toString());
                entityVideo.setId(gu3.j.getControlId());
                hu3.u(entityVideo, WearUtils.y.p(), ((User) this.c).getUserJid());
            } else {
                str = String.format(ah4.e(R.string.message_poor_network), ah4.e(R.string.chat_voice));
                EntityVoice entityVoice = new EntityVoice();
                entityVoice.setType(EntityVoice.VoiceOPTType.noAnswer.toString());
                entityVoice.setId(gu3.j.getControlId());
                hu3.u(entityVoice, WearUtils.y.p(), ((User) this.c).getUserJid());
            }
            is3 is3VarJ = cs3.j(I(), str);
            this.G = is3VarJ;
            is3VarJ.show();
            this.t.c();
            gu3.j.setAvailable(ControlIdBean.Status.cancel);
            Dialog dialog = this.r;
            if (dialog != null) {
                dialog.dismiss();
            }
            this.s.i();
        }
    }

    public final void P0() {
        this.w = 0;
    }

    public void P1() {
        if (this.ldrPanel.getVisibility() == 8) {
            this.ldrPanel.setVisibility(0);
            this.ldrPanel.e((User) this.c);
            this.ldrPanel.setIvLdrControlStates(Integer.valueOf(R.drawable.chat_sync_direction_interactive));
            this.ldrPanel.setBackground(R.color.transparent);
            this.ldrPanel.setDividerBackground(th4.d(this.a.getContext(), R.color.multi_toys_select_line_dark));
            this.ldrPanel.setLeftViewBackground(R.drawable.gradual_left_bg);
            this.ldrPanel.setRightViewBackground(R.drawable.gradual_right_bg);
            this.flDlrLayout.setVisibility(8);
            this.multiControlPanel.J(true, this.q);
            this.multiControlPanel.setVisibility(0);
            this.multiControlPanel.setCurvePanelVisible(8);
            this.multiControlPanel.setSelectPanelVisible(4);
            this.multiControlPanel.setDividerVisible(false);
            this.multiControlPanel.setControllingBtnVisible(true);
            this.multiControlPanel.setSlidingPaneLayoutTouchEnable(false);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.multiControlPanel.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).height = this.g.getResources().getDimensionPixelSize(R.dimen.mutli_toys_voice_controlball_panel_height);
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.g.getResources().getDimensionPixelOffset(R.dimen.multi_toy_ldr_margin_top);
            this.multiControlPanel.setLayoutParams(layoutParams);
            this.multiControlPanel.setPanelPercent(0.0f);
            this.multiControlPanel.setMultiToysCurveShowMode(true);
            this.multiControlPanel.j0(true, true);
            this.multiControlPanel.m0(this.o.i());
        }
    }

    @Override // dc.ka2
    public void Q(Activity activity) {
        this.e = true;
        E1(true);
    }

    public void Q0(String str, int i2) {
        RtcEngine rtcEngine = this.Y;
        if (rtcEngine != null) {
            rtcEngine.stopPreview();
            this.Y.leaveChannel();
            this.Y.removeHandler(this.b0);
            this.Y = null;
        }
        try {
            RtcEngineConfig rtcEngineConfig = new RtcEngineConfig();
            rtcEngineConfig.mContext = ve0.a();
            rtcEngineConfig.mAppId = str;
            rtcEngineConfig.mEventHandler = this.b0;
            RtcEngine rtcEngineCreate = RtcEngine.create(rtcEngineConfig);
            this.Y = rtcEngineCreate;
            rtcEngineCreate.setVideoEncoderConfiguration(new VideoEncoderConfiguration(VideoEncoderConfiguration.VD_1280x720, VideoEncoderConfiguration.FRAME_RATE.FRAME_RATE_FPS_60, 0, VideoEncoderConfiguration.ORIENTATION_MODE.ORIENTATION_MODE_ADAPTIVE));
            this.Y.enableVideo();
            this.Y.enableAudio();
            this.Y.setEnableSpeakerphone(true);
            this.Y.setupLocalVideo(new VideoCanvas(this.minView, 1, i2));
        } catch (Exception unused) {
            throw new RuntimeException("Check the error.");
        }
    }

    public final void Q1(String str) {
        FragmentActivity fragmentActivityI = I();
        if (fragmentActivityI == null || !fragmentActivityI.isDestroyed() || fragmentActivityI.isFinishing()) {
            return;
        }
        kn3 kn3Var = new kn3((Context) fragmentActivityI, str, ah4.e(R.string.common_ok), false, false, (kn3.d) new r(this), true);
        kn3Var.show();
        kn3Var.n();
    }

    @Override // dc.ka2
    public void R() {
        if (this.e || !r()) {
            return;
        }
        Q(I());
    }

    public final void R0() {
        FragmentActivity fragmentActivityI = I();
        ViewGroup viewGroup = (ViewGroup) this.N.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.N);
        }
        ViewGroup viewGroup2 = (ViewGroup) this.maxView.getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(this.maxView);
        }
        this.flRtcRootView.addView(this.maxView, 0);
        Dialog dialog = this.r;
        if (dialog != null) {
            dialog.dismiss();
        }
        if (this.t.g()) {
            this.ivVoiceBg.setVisibility(8);
        } else {
            this.ivVoiceBg.setVisibility(0);
        }
        is3 is3VarI = cs3.i(new is3.b(fragmentActivityI), VideoVoiceShowDialog.class);
        this.r = is3VarI;
        ((VideoVoiceShowDialog) is3VarI).setICreateRootView(new s());
        this.r.show();
    }

    public void R1(String str) {
        U(new w(str));
    }

    public final void S0() {
        h1();
        this.A.setDuration(700L);
        this.A.setFillAfter(true);
        this.B.setDuration(700L);
        this.B.setFillAfter(true);
        this.Q = 0L;
        this.z = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        DaoUtils.getTestValueDao().delete(TestValueDao.SAVE_KEY_VIDEOTOY_RECORD_KEY, "1");
        Timer timer = new Timer();
        this.R = timer;
        timer.schedule(new n(), 100L, 100L);
    }

    public void S1() {
        jp3 jp3Var;
        if (!r() || (jp3Var = this.Z) == null || this.p) {
            return;
        }
        jp3Var.s();
    }

    public final void T0(boolean z2) {
        if (!z2) {
            try {
                this.n.postDelayed(new c(), 500L);
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        i1();
    }

    public final void T1() {
        if (this.x && this.F) {
            this.tochangeSwitchControlLayout.setVisibility(0);
            this.x = true;
        } else {
            this.tochangeSwitchControlLayout.setVisibility(8);
            this.x = false;
        }
        if (this.p) {
            this.tvTochangeVideoControlRemote.setSelected(false);
            this.tvTochangeVideoControlDlr.setSelected(true);
        } else {
            this.tvTochangeVideoControlRemote.setSelected(true);
            this.tvTochangeVideoControlDlr.setSelected(false);
        }
        J0();
    }

    public final void U0() {
        Timer timer = this.R;
        if (timer != null) {
            timer.cancel();
            this.R = null;
        }
        if (this.Q >= 5) {
            Iterator<Map.Entry<String, RecallToyControl>> it = this.W.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().closeSaveFile();
            }
        }
    }

    public void U1(boolean z2, String str, MessageType messageType) {
        this.L = ch3.n().o().isEnableAgoraIO();
        U(new t(z2, str, messageType));
    }

    public void V0() {
        this.s.i();
    }

    public void V1(boolean z2, e0 e0Var) {
        this.t.l(z2);
        if (!ch3.n().o().isEnableAgoraIO()) {
            this.s.x(z2);
        }
        R0();
        WearUtils.z2();
        WearUtils.L1(true, null);
        if (z2) {
            EntityVideo entityVideo = new EntityVideo();
            entityVideo.setType(EntityVideo.VideoOPTType.request.toString());
            entityVideo.setId(pj3.a());
            H1(entityVideo);
            if (e0Var != null) {
                e0Var.a(entityVideo.getId());
            }
        } else {
            EntityVoice entityVoice = new EntityVoice();
            entityVoice.setType(EntityVoice.VoiceOPTType.request.toString());
            entityVoice.setId(pj3.a());
            H1(entityVoice);
            if (e0Var != null) {
                e0Var.a(entityVoice.getId());
            }
        }
        G1();
        try {
            MusicControl.h0().S();
            y12.c.a().t();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void W0() throws Resources.NotFoundException {
        if (this.ldrPanel.getVisibility() == 0) {
            this.ldrPanel.setVisibility(8);
            this.multiControlPanel.J(false, this.q);
            this.multiControlPanel.setVisibility(0);
            this.multiControlPanel.setCurvePanelVisible(0);
            this.multiControlPanel.setSelectPanelVisible(0);
            this.multiControlPanel.setDividerVisible(true);
            this.multiControlPanel.setControllingBtnVisible(false);
            this.multiControlPanel.setSlidingPaneLayoutTouchEnable(true);
            int dimensionPixelSize = this.multiControlPanel.getContext().getResources().getDimensionPixelSize(R.dimen.mutli_toys_curve_item_height);
            this.multiControlPanel.setPanelHeight(this.multiControlPanel.getContext().getResources().getDimensionPixelSize(R.dimen.mutli_toys_voice_controlball_panel_height), dimensionPixelSize, this.q.size());
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.multiControlPanel.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
            this.multiControlPanel.setLayoutParams(layoutParams);
        }
    }

    public final void W1(boolean z2) {
        if (z2) {
            qf3.C();
        }
    }

    public void X0(final boolean z2, final boolean z3, boolean z4) {
        WearUtils.z2();
        if (z2 || this.U) {
            B1(z3, z4);
        }
        U(new Runnable() { // from class: dc.u92
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                this.a.o1(z2, z3);
            }
        });
    }

    public void X1(boolean z2) {
        if (z2) {
            if (this.t.g()) {
                EntityVideo entityVideo = new EntityVideo();
                entityVideo.setType(EntityVideo.VideoOPTType.swap.toString());
                H1(entityVideo);
            } else {
                EntityVoice entityVoice = new EntityVoice();
                entityVoice.setType(EntityVoice.VoiceOPTType.swap.toString());
                H1(entityVoice);
            }
        }
        boolean z3 = !this.p;
        this.p = z3;
        this.o.e = !r1.e;
        if (this.T) {
            me3.d(z3 ? me3.c.PRIVATE_CHAT_VOICE_CONTROL_SENCE_BEGIN : me3.c.PRIVATE_CHAT_VOICE_CONTROL_REMOTE_BEGIN, me3.a());
        } else {
            me3.d(z3 ? me3.c.PRIVATE_CHAT_VIDEO_CONTROL_SENCE_BEGIN : me3.c.PRIVATE_CHAT_VIDEO_CONTROL_REMOTE_BEGIN, me3.a());
        }
        sz1.d().r(8);
        ou3.a = "";
        ou3.c = "";
        U(new i(z2));
        this.n.postDelayed(new j(), 600L);
    }

    public final void Y0(String str) {
        if (!WearUtils.e1(str)) {
            this.K = str;
        }
        tn2.x(I()).d("/api/remote/agora_token?channelName=" + this.K, new u(str));
    }

    public void Y1(View view, View view2) {
        if (view2.getVisibility() == 0) {
            d1(view2);
        }
        if (view.getVisibility() != 0) {
            this.O = view;
            A1(view);
        }
    }

    public String Z0() {
        return (WearUtils.e1(this.webrtcControlTimes.getText().toString()) || this.webrtcControlTimes.getText().toString().equals("00:00")) ? "00:00" : this.webrtcControlTimes.getText().toString();
    }

    public void Z1(int i2) {
        this.ldrPanel.n(i2);
    }

    @Override // dc.ra2
    public void a() {
        X0(true, false, false);
    }

    public void a2(ToyBean toyBean, boolean z2) throws NumberFormatException {
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Field field : ToyBean.class.getDeclaredFields()) {
                if (!TextUtils.equals(field.getName(), "time")) {
                    field.setAccessible(true);
                    int iIntValue = ((Integer) field.get(toyBean)).intValue();
                    if (iIntValue != -1) {
                        arrayList.add(field.getName());
                        arrayList2.add(String.valueOf(iIntValue));
                    }
                }
            }
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            String[] strArr2 = (String[]) arrayList2.toArray(new String[arrayList.size()]);
            this.o.n0(null, strArr, strArr2);
            c2(strArr, strArr2, z2);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    @Override // dc.ka2
    public void b0() {
        List<Toy> listToys = this.multiControlPanel.getListToys();
        ArrayList<Toy> linkedToys2 = ((User) this.c).getLinkedToys2();
        if (listToys == null || linkedToys2 == null) {
            return;
        }
        if (listToys.size() < linkedToys2.size()) {
            this.multiControlPanel.q0(linkedToys2);
            return;
        }
        HashMap map = new HashMap();
        if (linkedToys2.size() == 0) {
            Iterator<Toy> it = listToys.iterator();
            while (it.hasNext()) {
                map.put(it.next().getDeviceId(), Boolean.FALSE);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            for (Toy toy : listToys) {
                Iterator<Toy> it2 = linkedToys2.iterator();
                while (it2.hasNext()) {
                    if (TextUtils.equals(toy.getDeviceId(), it2.next().getDeviceId())) {
                        arrayList.add(toy);
                    }
                }
            }
            for (Toy toy2 : listToys) {
                if (!arrayList.contains(toy2)) {
                    map.put(toy2.getDeviceId(), Boolean.FALSE);
                } else if (!toy2.isConnected()) {
                    map.put(toy2.getDeviceId(), Boolean.TRUE);
                }
            }
        }
        if (map.size() > 0) {
            for (Map.Entry entry : map.entrySet()) {
                this.multiControlPanel.p0((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue());
            }
        }
    }

    public User b1() {
        return (User) this.c;
    }

    public void b2(List<Ball2CurveEventBean> list) {
        if (this.o.e && this.ldrPanel.getVisibility() == 0 && this.o.i() == 0) {
            for (Ball2CurveEventBean ball2CurveEventBean : list) {
                if (ball2CurveEventBean != null && !TextUtils.isEmpty(ball2CurveEventBean.getGroups())) {
                    String[] strArrSplit = ball2CurveEventBean.getGroups().split(",");
                    if (strArrSplit.length > 0) {
                        this.ldrPanel.q(Integer.parseInt(strArrSplit[0]) / 5, true);
                    }
                }
            }
        }
    }

    public final void c0(MessageType messageType, User user) {
        U(new v(user, messageType));
    }

    public void c1() {
        if (this.Z == null || !r()) {
            return;
        }
        this.Z.f();
    }

    public void c2(String[] strArr, String[] strArr2, boolean z2) throws NumberFormatException {
        if (this.ldrPanel.getVisibility() == 0 && this.o.i() == 0) {
            this.ldrPanel.t(null, strArr, strArr2, z2);
        }
    }

    @Override // dc.aq2.d
    public boolean connectSuc() {
        EventBus.getDefault().post(new WebRtcStatusEvent(1));
        U(new p());
        if (!this.L) {
            this.s.A(this.minView);
            this.s.B(this.maxView);
        }
        return this.F;
    }

    @Override // dc.aq2.d
    public void d(JSONObject jSONObject) {
        I1(jSONObject);
    }

    public void d0(MessageType messageType, User user) {
        if (MyApplication.H().isFinishing() || MyApplication.H().isDestroyed()) {
            return;
        }
        c0(messageType, user);
    }

    public final void d1(View view) {
        if (this.F) {
            FragmentActivity fragmentActivityI = I();
            if (fragmentActivityI != null) {
                oj3 oj3Var = new oj3(fragmentActivityI, R.anim.translate_down);
                oj3Var.a();
                oj3Var.b(view);
            }
            c1();
            ua2.a();
            view.setVisibility(8);
            this.tochangeSwitchControlLayout.setVisibility(8);
        }
    }

    public final void d2(int i2) {
        if (i2 == 0) {
            this.E = false;
            this.S.removeCallbacksAndMessages(null);
            this.S.postDelayed(this.a0, SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US);
            return;
        }
        if (i2 == 1) {
            if (this.F && this.E) {
                this.S.postDelayed(new Runnable() { // from class: dc.t92
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.y1();
                    }
                }, 10000L);
                return;
            }
            return;
        }
        if (i2 == 2) {
            if (this.E || !this.F) {
                return;
            }
            this.E = true;
            this.S.removeCallbacksAndMessages(null);
            this.S.postDelayed(this.a0, 30000L);
            return;
        }
        if (i2 == 3) {
            this.E = false;
            if (!this.F) {
                this.F = true;
                M1();
                this.o.o(this.c);
                K0();
                if (((User) this.c).getLinkedToys2().size() > 0) {
                    WearUtils.x.m0();
                }
                J1();
                this.videoBottomControlLayout.setVisibility(0);
                Y();
                ka2.C(false, ((User) this.c).getLinkedToys2(), new o(this));
            }
            if (this.t.g()) {
                this.userAvatarLayout.setVisibility(8);
            }
            this.webrtcFlash.setVisibility(8);
            this.S.removeCallbacksAndMessages(null);
            K1();
        }
    }

    @Override // dc.aq2.d
    public void e() {
        EventBus.getDefault().post(new WebRtcStatusEvent(0));
        U(new q());
    }

    public final void e0() {
        Account accountU = WearUtils.y.u();
        if (accountU != null) {
            String acceptVideoRequestJid = accountU.getAcceptVideoRequestJid();
            if (WearUtils.e1(acceptVideoRequestJid)) {
                return;
            }
            if (!TextUtils.isEmpty(gu3.j.getControlId()) && gu3.j.getAvailable() != ControlIdBean.Status.request) {
                this.b.setLiveStatus(0);
                X0(false, false, false);
                return;
            }
            if (!so3.J()) {
                Q1(!this.t.g() ? ah4.e(R.string.str_voice_unavlidate) : ah4.e(R.string.str_video_unavlidate));
                X0(true, true, false);
                return;
            }
            gu3.j.setAvailable(ControlIdBean.Status.accept);
            if (this.t.g()) {
                EntityVideo entityVideo = new EntityVideo();
                EntityVideo.VideoOPTType videoOPTType = EntityVideo.VideoOPTType.accept;
                entityVideo.setType(videoOPTType.toString());
                entityVideo.setId(gu3.j.getControlId());
                entityVideo.setChannelName(this.K);
                hu3.g0(entityVideo, acceptVideoRequestJid, MessageType.video, videoOPTType.toString(), null, null);
            } else {
                EntityVoice entityVoice = new EntityVoice();
                EntityVoice.VoiceOPTType voiceOPTType = EntityVoice.VoiceOPTType.accept;
                entityVoice.setType(voiceOPTType.toString());
                entityVoice.setId(gu3.j.getControlId());
                entityVoice.setChannelName(this.K);
                hu3.g0(entityVoice, acceptVideoRequestJid, MessageType.voice, voiceOPTType.toString(), null, null);
            }
            accountU.setAcceptVideoRequestJid(null);
            d2(0);
            if (this.L) {
                return;
            }
            this.s.w();
        }
    }

    public final void e1() {
        this.y = true;
        this.chatVideoSwitchCamera.setVisibility(8);
        this.chatVideoChannelVoice.setVisibility(8);
        this.chatVoiceSoundModel.setVisibility(8);
        this.chatVideoCollect.setVisibility(8);
        this.chatVideoSwitchRecord.setVisibility(8);
        this.chatVoiceSoundModel.setImageResource(R.drawable.content_icon_voice_speaker_normal);
    }

    public void e2(String str) {
        JSONObject jSONObject = (JSONObject) JSON.parseObject(str, JSONObject.class);
        if (jSONObject == null) {
            return;
        }
        U(new d(jSONObject, str));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void f1() throws Resources.NotFoundException {
        this.q = ((User) this.c).getLinkedToys2();
        this.multiControlPanel.setOnPanelTouchListener(new MultiControlPanel.s() { // from class: dc.w92
            @Override // com.wear.widget.control.multiToys.MultiControlPanel.s
            public final void a(MotionEvent motionEvent) {
                this.a.q1(motionEvent);
            }
        });
        this.multiControlPanel.setSwitchControlListener(new MultiControlPanel.n() { // from class: dc.x92
            @Override // com.wear.widget.control.multiToys.MultiControlPanel.n
            public final void a() {
                this.a.s1();
            }
        });
        this.multiControlPanel.X(new MultiControlPanel.r() { // from class: dc.s92
            @Override // com.wear.widget.control.multiToys.MultiControlPanel.r
            public /* synthetic */ void b(String str) {
                ip3.a(this, str);
            }

            @Override // com.wear.widget.control.multiToys.MultiControlPanel.r
            public final void f(List list) throws NumberFormatException {
                this.a.u1(list);
            }
        });
        this.multiControlPanel.setStyle();
        jp3 jp3Var = this.Z;
        if (jp3Var != null) {
            jp3Var.l(true);
        }
        this.multiControlPanel.N(false, this.t.g() ? "CHAT_VIDEO_CONTROL" : "CHAT_VOICE_CONTROL", this.q);
        this.multiControlPanel.setPanelHeight(this.multiControlPanel.getContext().getResources().getDimensionPixelSize(R.dimen.mutli_toys_voice_controlball_panel_height), this.multiControlPanel.getContext().getResources().getDimensionPixelSize(R.dimen.mutli_toys_curve_item_height), this.q.size());
    }

    @Override // dc.na2.b
    public void g() {
        if (r()) {
            int i2 = this.w + 1;
            this.w = i2;
            String strQ = WearUtils.Q(i2);
            this.webrtcControlTimes.setText(strQ);
            TextView textView = this.j;
            if (textView != null) {
                textView.setText(strQ);
            }
        }
    }

    public final void g1(boolean z2) throws Resources.NotFoundException {
        this.e = true;
        this.u = 0L;
        this.V = false;
        this.F = false;
        this.p = false;
        this.o.e = false;
        this.webrtcControlTimes.setText("");
        this.D = null;
        this.Q = 0L;
        this.chatVideoRecordTimeTime.setText(WearUtils.J0(0L));
        this.chatVideoRecordTimeLayout.setVisibility(8);
        this.chatVideoSwitchRecord.setImageResource(R.drawable.content_icon_record);
        f1();
        this.o.o(this.c);
        K0();
        this.V = true;
        if (z2) {
            L0();
            this.V = false;
        }
    }

    @Override // dc.ra2
    public int getMinHeight() {
        return this.t.g() ? ce3.a(this.g, 160.0f) : ce3.a(this.g, 60.0f);
    }

    @Override // dc.ra2
    public int getMinWidth() {
        return this.t.g() ? ce3.a(this.g, 120.0f) : ce3.a(this.g, 60.0f);
    }

    @Override // dc.aq2.d
    public void h(EglBase.Context context) {
        try {
            this.minView.init(context, null);
            this.maxView.init(context, null);
            this.minView.setMirror(true);
            SurfaceViewRenderer surfaceViewRenderer = this.minView;
            RendererCommon.ScalingType scalingType = RendererCommon.ScalingType.SCALE_ASPECT_FIT;
            surfaceViewRenderer.setScalingType(scalingType);
            this.minView.setZOrderOnTop(true);
            this.minView.setZOrderMediaOverlay(true);
            this.maxView.setMirror(false);
            this.maxView.setScalingType(scalingType);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void h1() {
        EntityToy entityToy = this.D;
        if (entityToy != null) {
            F1(entityToy, true);
        }
    }

    @Override // dc.aq2.d
    public boolean i() {
        return this.t.g();
    }

    public void i1() {
        String toyFunction;
        if (!this.L) {
            this.webrtcFlash.setVisibility(0);
        }
        this.tvLinkedToyNotice.setVisibility(8);
        if (((User) this.c).getLinkedToys2().size() > 0) {
            this.tvLinkedToyNotice.setVisibility(8);
        } else {
            this.tvLinkedToyNotice.setText(String.format(ah4.e(R.string.voice_friend_noToy), ((User) this.c).getShowNickName()));
            this.tvLinkedToyNotice.setVisibility(0);
        }
        if (this.t.g()) {
            this.tvLinkedToyNotice.setVisibility(8);
        }
        this.userAvatarLayout.setVisibility(0);
        ArrayList<Toy> arrayListP = this.g.G().P();
        this.W.clear();
        for (Toy toy : arrayListP) {
            Toy toy2 = new Toy();
            toy2.setName(toy.getName());
            toy2.synNameToType();
            if (toy.isBAToy()) {
                ek2 ek2VarC = fk2.a.c(toy.getAddress());
                ek2 ek2Var = ek2.POSITION;
                toyFunction = (ek2VarC == ek2Var ? ek2Var.ordinal() : ek2.SPEED.ordinal()) == ek2Var.ordinal() ? "pos" : "t";
            } else {
                toyFunction = Toy.getToyFunction(toy2.getType());
            }
            RecallToyControl recallToyControl = new RecallToyControl(ch3.n().u().getUserName());
            recallToyControl.setAddress(toy.getAddress());
            recallToyControl.setId(toy.getId());
            recallToyControl.setFunction(toyFunction);
            recallToyControl.setName(toy.getRealType());
            this.W.put(toy.getAndUpdateDeviceId(), recallToyControl);
        }
        if (this.L) {
            return;
        }
        this.s.w();
    }

    public final void j1() {
        aq2 aq2VarJ = aq2.j();
        this.s = aq2VarJ;
        aq2VarJ.p(this);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.g).inflate(R.layout.view_long_chat_video_layout, (ViewGroup) null);
        this.N = viewGroup;
        ButterKnife.bind(this, viewGroup);
        EventBus.getDefault().register(this);
        this.webrtcClose.setOnClickListener(this);
        this.chatVideoCollect.setOnClickListener(this);
        this.chatVideoSwitchCamera.setOnClickListener(this);
        this.chatVideoChannelVoice.setOnClickListener(this);
        this.chatVoiceSoundModel.setOnClickListener(this);
        this.chatVideoSwitchRecord.setOnClickListener(this);
        this.tvTochangeVideoControlDlr.setOnClickListener(this);
        this.tvTochangeVideoControlRemote.setOnClickListener(this);
        this.ivCancel.setOnClickListener(this);
        this.o = new pa2(this, this.flDlrLayout);
        this.rootTouchLayout.setOnTouchListener(new a());
        View viewInflate = LayoutInflater.from(this.g).inflate(R.layout.view_control, (ViewGroup) null);
        this.v = viewInflate;
        ((LottieAnimationView) viewInflate.findViewById(R.id.iv_small)).setAnimation("voice.json");
        this.j = (TextView) this.v.findViewById(R.id.tv_levitate_time);
        K(new FloatingNewControlView(this.g), null);
        this.h = R.drawable.full_control_voice;
        this.a.setListener(new b());
        if (ce3.c(this.g)) {
            WindowManager windowManager = (WindowManager) this.g.getSystemService("window");
            windowManager.getDefaultDisplay().getRectSize(new Rect());
            float fHeight = r1.height() * 0.7f;
            ViewGroup.LayoutParams layoutParams = this.multiControlPanel.getLayoutParams();
            layoutParams.height = (int) fHeight;
            this.multiControlPanel.setLayoutParams(layoutParams);
        }
        this.maxView.setZOrderMediaOverlay(true);
        this.minView.setZOrderMediaOverlay(true);
    }

    @Override // dc.na2.b
    public void k() {
    }

    public boolean k1() {
        return this.t.g();
    }

    public void l1(String str, String str2, int i2) {
        ChannelMediaOptions channelMediaOptions = new ChannelMediaOptions();
        channelMediaOptions.channelProfile = 1;
        channelMediaOptions.clientRoleType = 1;
        RtcEngine rtcEngine = this.Y;
        if (rtcEngine != null) {
            rtcEngine.enableAudio();
            this.Y.joinChannel(str, str2, i2, channelMediaOptions);
        }
    }

    @Override // dc.aq2.d
    public void o() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.chat_video_channel_voice /* 2131362344 */:
                String strF = dh3.f(this.c);
                if (!WearUtils.e1(strF)) {
                    Q1(strF);
                    break;
                } else {
                    if (this.L) {
                        G0();
                    } else {
                        I0(true);
                    }
                    zb2.O().L0(TtmlNode.END, WearUtils.X(((User) this.c).getUserJid()));
                    break;
                }
            case R.id.chat_video_collect /* 2131362345 */:
                FragmentActivity fragmentActivityI = I();
                if (fragmentActivityI != null) {
                    if (!od3.c(fragmentActivityI)) {
                        a0 a0Var = new a0();
                        is3.b bVar = new is3.b(fragmentActivityI);
                        bVar.p(ah4.e(R.string.enable_floating_window_des));
                        bVar.o(ah4.e(R.string.common_ok));
                        bVar.n(ah4.e(R.string.common_cancel));
                        bVar.d(new b0(fragmentActivityI));
                        bVar.c(a0Var);
                        bVar.q(ah4.e(R.string.enable_floating_window_title));
                        cs3.h(bVar).show();
                        break;
                    } else {
                        this.e = false;
                        E1(false);
                        break;
                    }
                }
                break;
            case R.id.chat_video_switch_camera /* 2131362349 */:
                this.chatVideoSwitchCamera.setEnabled(false);
                if (this.L) {
                    this.Y.switchCamera();
                } else {
                    this.s.C();
                }
                new Handler(Looper.getMainLooper()).postDelayed(new c0(), 1000L);
                break;
            case R.id.chat_video_switch_record /* 2131362350 */:
                boolean z2 = this.C;
                if (z2 && this.Q < 5) {
                    this.C = false;
                    this.chatVideoRecordTimeLayout.setVisibility(8);
                    this.chatVideoSwitchRecord.setImageResource(R.drawable.content_icon_record);
                    DaoUtils.getTestValueDao().delete(TestValueDao.SAVE_KEY_VIDEOTOY_RECORD_KEY, "1");
                    Timer timer = this.R;
                    if (timer != null) {
                        timer.cancel();
                        this.R = null;
                    }
                    sg3.i(this.g, R.string.chat_pattern_timeShort);
                    break;
                } else {
                    boolean z3 = !z2;
                    this.C = z3;
                    if (!z3) {
                        this.chatVideoRecordTimeLayout.setVisibility(8);
                        this.chatVideoSwitchRecord.setImageResource(R.drawable.content_icon_record);
                        DaoUtils.getTestValueDao().delete(TestValueDao.SAVE_KEY_VIDEOTOY_RECORD_KEY, "1");
                        U0();
                        break;
                    } else {
                        this.chatVideoRecordTimeLayout.setVisibility(0);
                        this.chatVideoSwitchRecord.setImageResource(R.drawable.chat_video_record_click);
                        this.Q = 0L;
                        this.chatVideoRecordTimeTime.setText(WearUtils.J0(0L));
                        Iterator<Map.Entry<String, RecallToyControl>> it = this.W.entrySet().iterator();
                        while (it.hasNext()) {
                            it.next().getValue().createHeadFile(((User) this.c).getId());
                        }
                        S0();
                        break;
                    }
                }
            case R.id.chat_voice_sound_model /* 2131362352 */:
                this.y = !this.y;
                this.chatVoiceSoundModel.setEnabled(false);
                new Handler(Looper.getMainLooper()).postDelayed(new d0(), 1000L);
                if (!this.y) {
                    this.chatVoiceSoundModel.setImageResource(R.drawable.content_icon_voice_ear_model);
                    break;
                } else {
                    this.chatVoiceSoundModel.setImageResource(R.drawable.content_icon_voice_speaker_normal);
                    break;
                }
            case R.id.iv_cancel /* 2131363108 */:
                B();
                z1();
                break;
            case R.id.tv_tochange_video_control_dlr /* 2131365378 */:
            case R.id.tv_tochange_video_control_remote /* 2131365379 */:
                if (!this.X) {
                    if (!this.p || view.getId() != R.id.tv_tochange_video_control_dlr) {
                        if (this.p || view.getId() != R.id.tv_tochange_video_control_remote) {
                            if (!this.p) {
                                WearUtils.x.q("chat_video_ldr", null);
                            }
                            this.X = true;
                            X1(true);
                            this.X = false;
                            break;
                        }
                    }
                }
                break;
            case R.id.webrtc_close /* 2131365669 */:
                X0(true, false, false);
                WearUtils.x.l.postDelayed(new z(this), 1500L);
                this.F = false;
                Dialog dialog = this.r;
                if (dialog != null) {
                    dialog.dismiss();
                }
                z1();
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(XmppReconctionSuccessEvent xmppReconctionSuccessEvent) {
        d2(1);
    }

    @Override // dc.ra2
    public boolean r() {
        return this.t.d();
    }

    @Override // dc.ka2
    public boolean z() {
        return r() || this.t.f();
    }

    public void z1() {
        RtcEngine rtcEngine = this.Y;
        if (rtcEngine != null) {
            rtcEngine.stopPreview();
            this.Y.leaveChannel();
            this.Y.disableVideo();
        }
        this.M = false;
    }

    public ChatVideoControl() {
        this.n = new Handler(Looper.getMainLooper());
        this.p = false;
        this.q = null;
        this.t = new bd2();
        this.u = 0L;
        this.w = 0;
        this.x = true;
        this.y = true;
        this.z = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.A = new AlphaAnimation(1.0f, 0.0f);
        this.B = new AlphaAnimation(0.0f, 1.0f);
        this.C = false;
        this.D = null;
        this.E = false;
        this.K = "";
        this.M = false;
        this.Q = 0L;
        this.S = new Handler(Looper.getMainLooper());
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = new HashMap();
        this.X = false;
        this.a0 = new k();
        this.b0 = new l();
        this.b = ch3.n().u();
        this.g = WearUtils.x;
        U(new x());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NetworkInfoEvent networkInfoEvent) {
        if (!r() || networkInfoEvent.isAvailable) {
            return;
        }
        X0(false, false, false);
        sg3.h(R.string.message_poor_network_webrtc);
        z1();
    }
}
