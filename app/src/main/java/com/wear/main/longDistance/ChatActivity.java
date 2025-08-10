package com.wear.main.longDistance;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.airbnb.lottie.LottieAnimationView;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.tencent.qgame.animplayer.AnimView;
import com.wear.activity.qrcode.QRCodeActivity;
import com.wear.adapter.longdistance.MessageNewAdapter;
import com.wear.bean.Account;
import com.wear.bean.BlockClose;
import com.wear.bean.FirebasePrivateChatInfo;
import com.wear.bean.SyncWsProtocol;
import com.wear.bean.User;
import com.wear.bean.UserSetting;
import com.wear.bean.UserSettingsBean;
import com.wear.bean.event.BlockFinishEvent;
import com.wear.bean.event.BurnAfterReadEvent;
import com.wear.bean.event.ChatBurnRecallEvent;
import com.wear.bean.event.ChatPictureEvent;
import com.wear.bean.event.ClearChatViewFriendIdEvent;
import com.wear.bean.event.EndChatEvent;
import com.wear.bean.event.FinishChatPageEvent;
import com.wear.bean.event.ForwardMessageEvent;
import com.wear.bean.event.InDateActivityEvent;
import com.wear.bean.event.InputResizeEvent;
import com.wear.bean.event.MessageResendEvent;
import com.wear.bean.event.MessageSendEvent;
import com.wear.bean.event.PatternRecEvent;
import com.wear.bean.event.PatternRecEvent1;
import com.wear.bean.event.ReSendPatternEvent;
import com.wear.bean.event.SystemEvent;
import com.wear.bean.event.UserUpdateEvent;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.socketio.controlLink.response.ControlLinkAwaken;
import com.wear.broadcast.ChatMessageBroadcastReceiver;
import com.wear.dao.CommunMessageDao;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.main.MainActivity;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.closeRange.alarm.AlarmCreateActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.longDistance.ChatActivity;
import com.wear.main.longDistance.control.ChatGroupControl;
import com.wear.main.longDistance.control.ChatLiveControl;
import com.wear.main.longDistance.control.ChatSyncControl;
import com.wear.main.longDistance.control.ChatVideoControl;
import com.wear.main.patterns.DialogPatternsActivity;
import com.wear.main.toy.ToyActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.phonertc.RequestPermissionActivity;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.ContainBean;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntityAlarm;
import com.wear.protocol.EntityAudio;
import com.wear.protocol.EntityBurnPicture;
import com.wear.protocol.EntityBurnShortVideo;
import com.wear.protocol.EntityChat;
import com.wear.protocol.EntityLive;
import com.wear.protocol.EntityPattern;
import com.wear.protocol.EntityPicture;
import com.wear.protocol.EntityShortVideo;
import com.wear.protocol.EntitySync;
import com.wear.protocol.EntitySystem;
import com.wear.protocol.EntityUnSupport;
import com.wear.protocol.EntityVideo;
import com.wear.protocol.MessageType;
import com.wear.ui.chat.fragment.ChatActionMenuFragmentBottom;
import com.wear.ui.longDistance.controlLink.ControlLinkEndActivity;
import com.wear.ui.longDistance.imagepicker.data.MediaFile;
import com.wear.ui.longDistance.video.VideoPlayerActivity;
import com.wear.util.MyApplication;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import com.wear.widget.ChatEditText;
import com.wear.widget.EmojisToastView;
import com.wear.widget.MyActionBar;
import com.wear.widget.RadiuImageView;
import com.wear.widget.chatMic.ChatEmojisPanel;
import com.wear.widget.chatMic.ChatInputPanel;
import com.wear.widget.chatMic.ChatInputPanelPto;
import com.wear.widget.chatMic.ChatMorePanel;
import com.wear.widget.chatMic.VoiceMessagePanelView;
import com.wear.widget.control.CoustomLinearLayout;
import com.wear.widget.dialog.LoveEmojisDialog;
import com.wear.widget.dialog.PhotoCameraDialog;
import com.wear.widget.iwatcher.ImageWatcher;
import com.wear.widget.velvo.VelvoPreviewView;
import dc.ah0;
import dc.ah3;
import dc.ah4;
import dc.aq2;
import dc.be3;
import dc.bo3;
import dc.c83;
import dc.ce3;
import dc.cg3;
import dc.ch3;
import dc.cs3;
import dc.db2;
import dc.df3;
import dc.dh1;
import dc.dh3;
import dc.di1;
import dc.dq2;
import dc.e82;
import dc.eg3;
import dc.ep1;
import dc.eu3;
import dc.f42;
import dc.ff3;
import dc.fh0;
import dc.fk3;
import dc.gg3;
import dc.gp1;
import dc.gu3;
import dc.h12;
import dc.hf3;
import dc.hh0;
import dc.hu3;
import dc.ie3;
import dc.ip1;
import dc.is3;
import dc.iv1;
import dc.jv1;
import dc.ke3;
import dc.kg3;
import dc.kn3;
import dc.ku1;
import dc.l22;
import dc.me3;
import dc.n82;
import dc.na2;
import dc.nd3;
import dc.ng1;
import dc.nz1;
import dc.ob2;
import dc.od3;
import dc.pc1;
import dc.pf3;
import dc.pj3;
import dc.q61;
import dc.qe3;
import dc.qf3;
import dc.rf3;
import dc.sa2;
import dc.sg3;
import dc.so3;
import dc.sz1;
import dc.tg3;
import dc.th4;
import dc.tn2;
import dc.tz1;
import dc.u51;
import dc.ue3;
import dc.vd0;
import dc.vg3;
import dc.w83;
import dc.x83;
import dc.xb2;
import dc.xe2;
import dc.xe3;
import dc.y12;
import dc.ye3;
import dc.zb2;
import dc.zn2;
import dc.zt3;
import io.agora.rtc2.internal.CommonUtility;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smack.packet.Presence;
import pl.droidsonroids.gif.GifImageView;

/* loaded from: classes3.dex */
public class ChatActivity extends QRCodeActivity implements MessageNewAdapter.t0, View.OnClickListener, ImageWatcher.j, sa2, ie3.m, xb2, jv1, tz1, ah3, eu3, l22.i, VoiceMessagePanelView.b, ChatActionMenuFragmentBottom.d {
    public Account A;
    public ArrayList<String> A0;
    public ChatLiveControl B;
    public ArrayList<MediaFile> B0;
    public ChatSyncControl C;
    public int C0;
    public ChatVideoControl D;
    public CommunMessage D0;
    public e82 E;
    public List<String> E0;
    public int F;
    public boolean F0;
    public kn3 G;
    public int G0;
    public View H0;
    public TextView I0;
    public LinearLayout J0;
    public View K0;
    public ViewGroup L;
    public CommunMessage L0;
    public LinearLayoutManager M;
    public TextView M0;
    public TextView N0;
    public TextView O0;
    public RadiuImageView P0;
    public RadiuImageView Q0;
    public CommunMessage R;
    public RelativeLayout R0;
    public CommunMessage S;
    public LinearLayout S0;
    public long T;
    public View T0;
    public h1 U;
    public VelvoPreviewView U0;
    public File V;
    public LottieAnimationView V0;
    public Uri W;
    public boolean W0;
    public ImageView X;
    public int X0;
    public View Y;
    public int Y0;
    public ChatInputPanel Z;
    public boolean Z0;
    public ImageView a0;
    public long a1;
    public ImageView b0;
    public ChatActionMenuFragmentBottom b1;
    public ImageView c0;
    public boolean c1;
    public View d0;
    public Object d1;
    public ChatMorePanel e0;
    public CountDownTimer e1;
    public ChatEmojisPanel f0;
    public CommunMessage f1;
    public MessageNewAdapter g0;
    public boolean g1;
    public EmojisToastView h0;
    public boolean h1;
    public LottieAnimationView i0;
    public int i1;
    public LinkedList<CommunMessage> j0;
    public boolean j1;
    public List<CommunMessage> k0;
    public boolean k1;
    public int l0;
    public boolean l1;
    public View m;
    public ChatMessageBroadcastReceiver m0;
    public boolean m1;
    public MyActionBar n;
    public so3 n0;
    public CommunMessage n1;
    public ChatEditText o;
    public String o0;
    public CommunMessage o1;
    public RecyclerView p;
    public ImageWatcher p0;
    public boolean p1;
    public View q;
    public HashMap<String, String> q0;
    public boolean q1;
    public Handler r0;
    public long r1;
    public View s;
    public ie3 s0;
    public AnimView s1;
    public View t;
    public CommunMessage t0;
    public FrameLayout t1;
    public SubsamplingScaleImageView u;
    public View u0;
    public ImageView u1;
    public ProgressBar v;
    public TextView v0;
    public Dialog v1;
    public CoustomLinearLayout w;
    public boolean w0;
    public long w1;
    public String x;
    public ImageButton x0;
    public String y;
    public View y0;
    public User z;
    public TextView z0;
    public boolean K = true;
    public boolean N = false;
    public boolean O = true;
    public boolean P = true;
    public int Q = -1;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatActivity.this.t.setVisibility(8);
        }
    }

    public class a0 implements db2.s {
        public a0() {
        }

        @Override // dc.db2.s
        public void a() {
            ChatActivity.this.K6(R.id.chat_more_video);
        }
    }

    public class a1 implements dh1 {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ChatActivity.this.t1.setVisibility(0);
                ChatActivity.this.u1.setVisibility(0);
                ChatActivity.this.s1.setVisibility(0);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ChatActivity.this.t1.setVisibility(8);
                ChatActivity.this.u1.setVisibility(8);
                ChatActivity.this.s1.setVisibility(8);
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ChatActivity.this.t1.setVisibility(8);
                ChatActivity.this.u1.setVisibility(8);
                ChatActivity.this.s1.setVisibility(8);
            }
        }

        public a1() {
        }

        @Override // dc.dh1
        public void a() {
        }

        @Override // dc.dh1
        public void b() {
            ChatActivity.this.runOnUiThread(new b());
        }

        @Override // dc.dh1
        public void c(int i, @Nullable String str) {
            ChatActivity.this.runOnUiThread(new c());
        }

        @Override // dc.dh1
        public void d() {
        }

        @Override // dc.dh1
        public void e(int i, @Nullable ng1 ng1Var) {
        }

        @Override // dc.dh1
        public boolean f(@NonNull ng1 ng1Var) {
            ChatActivity.this.runOnUiThread(new a());
            return true;
        }
    }

    public class b implements ImageWatcher.i {

        public class a extends SimpleImageLoadingListener {
            public final /* synthetic */ ImageWatcher.g a;

            public a(b bVar, ImageWatcher.g gVar) {
                this.a = gVar;
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                this.a.b(bitmap);
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingStarted(String str, View view) {
                this.a.a(null);
            }
        }

        public b(ChatActivity chatActivity) {
        }

        @Override // com.wear.widget.iwatcher.ImageWatcher.i
        public void a(Context context, String str, ImageWatcher.g gVar) {
            ImageLoader.getInstance().loadImage(str, MyApplication.Y, new a(this, gVar));
        }
    }

    public class b0 implements db2.s {
        public b0() {
        }

        @Override // dc.db2.s
        public void a() {
            if (ChatActivity.this.isFinishing() || WearUtils.x.i.D(ChatActivity.this.y, true)) {
                return;
            }
            ChatActivity chatActivity = ChatActivity.this;
            MessageType messageType = MessageType.sync;
            chatActivity.P8(messageType);
            hu3.T();
            EntitySync entitySync = new EntitySync();
            entitySync.setType(EntitySync.SyncOPTType.request.toString());
            entitySync.setId(pj3.a());
            ChatActivity.this.t8(entitySync, messageType);
            ChatActivity.this.H6(entitySync.getId(), messageType);
            ChatActivity.this.E6(messageType);
        }
    }

    public class b1 implements View.OnTouchListener {
        public b1() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            ChatActivity.this.a8();
            ChatActivity.this.Z.o();
            return false;
        }
    }

    public class c implements is3.d {
        public c(ChatActivity chatActivity) {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            MyApplication.g0 = true;
        }
    }

    public class c0 implements db2.s {
        public c0() {
        }

        @Override // dc.db2.s
        public void a() {
            if (ChatActivity.this.isFinishing() || WearUtils.x.i.D(ChatActivity.this.y, true)) {
                return;
            }
            ChatActivity chatActivity = ChatActivity.this;
            MessageType messageType = MessageType.live;
            chatActivity.P8(messageType);
            hu3.T();
            EntityLive entityLive = new EntityLive();
            entityLive.setType(EntityLive.LiveOPTType.request.toString());
            entityLive.setId(pj3.a());
            ChatActivity.this.t8(entityLive, messageType);
            ChatActivity.this.H6(entityLive.getId(), messageType);
            ChatActivity.this.E6(messageType);
        }
    }

    public static /* synthetic */ class c1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MessageType.values().length];
            a = iArr;
            try {
                iArr[MessageType.chat.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[MessageType.shortvideo.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[MessageType.audio.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[MessageType.picture.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[MessageType.pattern.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[MessageType.burnpicture.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[MessageType.burnvideo.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public class d implements is3.c {
        public d(ChatActivity chatActivity) {
        }

        @Override // dc.is3.c
        public void doCancel() {
            DaoUtils.getTestValueDao().save(zt3.k, "1", TestValueDao.CHAT_NOTE);
        }
    }

    public class d0 implements u51 {

        public class a implements is3.d {
            public a() {
            }

            @Override // dc.is3.d
            public void doConfirm() {
                RequestPermissionActivity.s4(ChatActivity.this);
            }
        }

        public d0() {
        }

        @Override // dc.u51
        public void a(List<String> list, boolean z) {
            is3.b bVar = new is3.b(ChatActivity.this.activity);
            bVar.p(ah4.e(R.string.app_open_camera_permission));
            bVar.o(ah4.e(R.string.common_confirm));
            bVar.n(ah4.e(R.string.common_cancel));
            bVar.d(new a());
            cs3.h(bVar).show();
        }

        @Override // dc.u51
        public void b(List<String> list, boolean z) {
            if (z) {
                ChatActivity.this.e8();
            }
        }
    }

    public class d1 implements TextWatcher {
        public d1() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ChatActivity.this.Y7(charSequence.length() == 0);
            String str = "onTextChanged: 发送文字中=" + ((Object) charSequence) + " start=" + i + " before=" + i2 + " count=" + i3;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - ChatActivity.this.a1 > ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
                if ((charSequence.length() > 0 || i2 > 0) && ChatActivity.this.z.getOnline()) {
                    ChatActivity.this.a1 = jCurrentTimeMillis;
                    EntitySystem entitySystem = new EntitySystem();
                    entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C204.toString(), ah4.e(R.string.system_messages_typing));
                    ChatActivity.this.t8(entitySystem, MessageType.system);
                }
            }
        }
    }

    public class e implements is3.d {
        public e(ChatActivity chatActivity) {
        }

        @Override // dc.is3.d
        public void doConfirm() {
        }
    }

    public class e0 implements is3.d {
        public e0() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            ChatActivity.this.D6("1");
            if (ChatActivity.this.V.exists()) {
                ChatActivity.this.V.delete();
            }
            x83.b().g("标题").i(false).j(true).k(true).a(false).h(true).e(9).f(false).d(ChatActivity.this.A0).c(new w83()).l(ChatActivity.this, 23, 1);
        }
    }

    public class e1 implements CoustomLinearLayout.a {
        public e1() {
        }

        @Override // com.wear.widget.control.CoustomLinearLayout.a
        public void a(int i, int i2, int i3, int i4) {
            xe3.a("ChatActivity", "chat_live_layer:" + i + " " + i2);
            if (System.currentTimeMillis() - ChatActivity.this.r1 < 100) {
                return;
            }
            View viewFindViewById = ChatActivity.this.findViewById(R.id.v_chat_live_layer);
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = i2;
            viewFindViewById.setLayoutParams(layoutParams);
            viewFindViewById.invalidate();
            ChatActivity.this.m8();
            String str = "chatLiveSyncLayer onSizeChanged h: " + i2;
            if (i2 > 0) {
                ChatActivity.this.Y0 = i2;
                ChatActivity.this.Z.getLastPanelType();
                fh0 fh0Var = fh0.LAYER;
                ChatActivity.this.Z.m(true, i2);
            }
        }

        @Override // com.wear.widget.control.CoustomLinearLayout.a
        public void b(int i) {
        }
    }

    public class f implements zn2<String> {
        public final /* synthetic */ EntityAudio a;
        public final /* synthetic */ CommunMessage b;

        public class a implements Runnable {
            public final /* synthetic */ NormalResponse a;

            /* renamed from: com.wear.main.longDistance.ChatActivity$f$a$a, reason: collision with other inner class name */
            public class C0109a extends ff3 {
                public C0109a(a aVar) {
                }

                @Override // dc.ff3
                public void b(boolean z, Object obj) {
                }
            }

            public a(NormalResponse normalResponse) {
                this.a = normalResponse;
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.a.setUrl(this.a.getMessage());
                f fVar = f.this;
                fVar.b.sendEntity(fVar.a);
                if (ChatActivity.this.g0 != null) {
                    ChatActivity.this.g0.notifyItemChanged(ChatActivity.this.j0.indexOf(f.this.b));
                }
                f fVar2 = f.this;
                ChatActivity.this.y8(fVar2.b, MessageType.audio, false);
                WearUtils.E0(true, this.a.getMessage(), new C0109a(this));
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = f.this;
                ChatActivity.this.w8(fVar.b, false);
            }
        }

        public f(EntityAudio entityAudio, CommunMessage communMessage) {
            this.a = entityAudio;
            this.b = communMessage;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            NormalResponse normalResponse;
            String str2 = "uploadBitMap result----" + str;
            if (WearUtils.e1(str) || (normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class)) == null || !normalResponse.isResult()) {
                return;
            }
            ChatActivity.this.addAnalyticsEventId("chat_voice", null);
            ChatActivity.this.runOnUiThread(new a(normalResponse));
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            ChatActivity.this.runOnUiThread(new b());
        }
    }

    public class f0 implements is3.c {
        public f0() {
        }

        @Override // dc.is3.c
        public void doCancel() {
            ChatActivity.this.D6("2");
            ChatActivity chatActivity = ChatActivity.this;
            chatActivity.W = tg3.m(chatActivity, chatActivity.V, 32, 1);
        }
    }

    public class f1 implements View.OnTouchListener {
        public float a = 0.0f;
        public float b = 0.0f;

        public f1() {
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
                    ChatActivity.this.k1 = false;
                    ChatActivity.this.P6();
                } else {
                    ChatActivity.this.k1 = true;
                }
            }
            return false;
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatActivity chatActivity = ChatActivity.this;
            ue3.b(chatActivity.o, chatActivity.activity, false);
            ChatActivity chatActivity2 = ChatActivity.this;
            if (chatActivity2.y == null || chatActivity2.p1) {
                return;
            }
            if (ChatActivity.this.application.i.k(ChatActivity.this.y)) {
                DaoUtils.getCommunMessageDao().delDateDrafMessage(WearUtils.y.p(), ChatActivity.this.y);
                return;
            }
            CommunMessage communMessageFindDrafMessage = DaoUtils.getCommunMessageDao().findDrafMessage(WearUtils.y.p(), ChatActivity.this.y);
            if (communMessageFindDrafMessage == null || communMessageFindDrafMessage.getType() != MessageType.chat) {
                return;
            }
            String text = ((EntityChat) communMessageFindDrafMessage.syncDecryptBean()).getText();
            String replyData = communMessageFindDrafMessage.getReplyData();
            if (!WearUtils.e1(replyData)) {
                HashMap map = (HashMap) WearUtils.A.fromJson(replyData, HashMap.class);
                map.remove("replyData");
                map.remove("dataBean");
                CommunMessage communMessage = (CommunMessage) WearUtils.A.fromJson(WearUtils.A.toJson(map), CommunMessage.class);
                communMessage.setDataBean(communMessage.syncDecryptBean());
                if (communMessage != null) {
                    ChatActivity.this.A0(communMessage, -1);
                }
            }
            if (TextUtils.isEmpty(text)) {
                return;
            }
            ChatActivity.this.s0.j(ChatActivity.this.o, text, 22);
            ChatEditText chatEditText = ChatActivity.this.o;
            chatEditText.setSelection(chatEditText.getText().toString().length());
            if (na2.m().u(ChatActivity.this.z)) {
                ChatInputPanelPto.l = true;
                ChatActivity.this.P6();
                ChatActivity chatActivity3 = ChatActivity.this;
                ue3.d(chatActivity3.o, chatActivity3.activity);
                ChatActivity.this.Z.o();
                ChatActivity.this.o.setFocusable(true);
                ChatActivity.this.o.setFocusableInTouchMode(true);
                ChatActivity.this.o.requestFocus();
            }
        }
    }

    public class g0 implements View.OnClickListener {
        public g0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatActivity.this.O6();
        }
    }

    public class g1 extends RecyclerView.OnScrollListener {
        public g1() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            ChatActivity chatActivity = ChatActivity.this;
            chatActivity.K = false;
            if (i == 0) {
                if (chatActivity.M.findFirstCompletelyVisibleItemPosition() == 0) {
                    ChatActivity.this.F0 = true;
                    ChatActivity.this.K = true;
                    return;
                }
                return;
            }
            if (i == 1) {
                chatActivity.F0 = false;
                ChatActivity.this.a7();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int iFindFirstVisibleItemPosition = ChatActivity.this.M.findFirstVisibleItemPosition();
            ChatActivity chatActivity = ChatActivity.this;
            chatActivity.i1 = chatActivity.M.findLastVisibleItemPosition();
            if (ChatActivity.this.f1 != null && ChatActivity.this.g1 && iFindFirstVisibleItemPosition == 2 && i2 > 0 && !ChatActivity.this.h1) {
                ChatActivity.this.h1 = true;
                ChatActivity.this.S7();
            }
            if (iFindFirstVisibleItemPosition <= ChatActivity.this.G0) {
                ChatActivity.this.Z6(false);
                ChatActivity.this.G0 = -1;
            }
        }
    }

    public class h implements MyActionBar.f {
        public h() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            pj3.f(ChatActivity.this, ToyActivity.class);
        }
    }

    public class h0 implements Runnable {
        public final /* synthetic */ String a;

        public h0(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatActivity.this.t.setVisibility(8);
            ChatActivity.this.u.setVisibility(8);
            ChatActivity.this.v.setVisibility(8);
            sg3.l(WearUtils.e1(this.a) ? ah4.e(R.string.common_serverError) : this.a);
        }
    }

    public class h1 extends BroadcastReceiver {
        public h1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b() {
            for (int i = 0; i < 10; i++) {
                ChatActivity chatActivity = ChatActivity.this;
                if (chatActivity.R != null && MyApplication.P) {
                    Iterator it = chatActivity.j0.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            CommunMessage communMessage = (CommunMessage) it.next();
                            if (TextUtils.equals(communMessage.getId(), ChatActivity.this.R.getId())) {
                                ChatActivity.this.C2(communMessage);
                                ChatActivity.this.Z3();
                                ChatActivity.this.w0 = true;
                                ChatActivity.this.R = null;
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            if (networkInfo == null || networkInfo2 == null) {
                return;
            }
            if (networkInfo.isConnected() || networkInfo2.isConnected()) {
                new Handler().postDelayed(new Runnable() { // from class: dc.q42
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b();
                    }
                }, 3000L);
            }
        }

        public /* synthetic */ h1(ChatActivity chatActivity, k kVar) {
            this();
        }
    }

    public class i implements MyActionBar.f {

        public class a implements iv1 {
            public a() {
            }

            @Override // dc.iv1
            public void next() {
                ChatActivity chatActivity = ChatActivity.this;
                pj3.j(chatActivity, FriendProfileActivity.class, "userId", chatActivity.x);
            }
        }

        public i() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            ChatActivity.this.Q6(false);
            ChatActivity.this.J8(new a());
        }
    }

    public class i0 implements Runnable {
        public i0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatActivity.this.t.setVisibility(8);
            ChatActivity.this.u.setVisibility(8);
            ChatActivity.this.v.setVisibility(8);
        }
    }

    public class j implements iv1 {
        public j() {
        }

        @Override // dc.iv1
        public void next() {
            if (ChatActivity.this.j1) {
                pj3.k(ChatActivity.this, MainActivity.class, "isFinishToLongDistance", true);
            }
            ChatActivity.this.finish();
        }
    }

    public class j0 implements kn3.d {
        public j0() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            RequestPermissionActivity.s4(ChatActivity.this);
        }
    }

    public class k extends CountDownTimer {
        public k(long j, long j2) {
            super(j, j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b() {
            if (ChatActivity.this.j0 == null || ChatActivity.this.j0.isEmpty()) {
                return;
            }
            if (ChatActivity.this.j0.getFirst() != null && ((CommunMessage) ChatActivity.this.j0.getFirst()).getType() == MessageType.system) {
                EntitySystem entitySystem = (EntitySystem) ((CommunMessage) ChatActivity.this.j0.getFirst()).getDataBean();
                if (entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C204 && entitySystem.getFirstSysOPTType() == EntitySystem.SystemOPTType.T200) {
                    ChatActivity.this.j0.removeFirst();
                    ChatActivity.this.g0.notifyItemRemoved(0);
                }
            }
            if (ChatActivity.this.F0) {
                ChatActivity.this.m8();
            }
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ChatActivity.this.c1 = false;
            synchronized (ChatActivity.this.d1) {
                ChatActivity.this.runOnMainThread(new Runnable() { // from class: dc.k42
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b();
                    }
                });
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            String str = "onTick: 正在输入中" + (j / 1000) + "S....";
        }
    }

    public class k0 implements Runnable {
        public final /* synthetic */ File a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public class a implements zn2<String> {
            public final /* synthetic */ CommunMessage a;

            /* renamed from: com.wear.main.longDistance.ChatActivity$k0$a$a, reason: collision with other inner class name */
            public class RunnableC0110a implements Runnable {
                public final /* synthetic */ String a;

                public RunnableC0110a(String str) {
                    this.a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (WearUtils.e1(this.a)) {
                        a aVar = a.this;
                        ChatActivity.this.q8(null, aVar.a, 4);
                        ChatActivity.this.T7(ah4.e(R.string.common_serverError));
                        return;
                    }
                    NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(this.a, NormalResponse.class);
                    if (normalResponse.isResult()) {
                        ChatActivity.this.q8(normalResponse.getMessage(), a.this.a, 0);
                        return;
                    }
                    a aVar2 = a.this;
                    ChatActivity.this.q8(null, aVar2.a, 4);
                    ChatActivity.this.T7(normalResponse.getMessage());
                }
            }

            public a(CommunMessage communMessage) {
                this.a = communMessage;
            }

            @Override // dc.zn2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onSuccess(String str) {
                ChatActivity.this.r0.post(new RunnableC0110a(str));
            }

            @Override // dc.zn2
            public void onError(NetException netException) {
                ChatActivity.this.q8(null, this.a, 4);
                ChatActivity.this.T7(netException.getMessage());
            }
        }

        public k0(File file, boolean z, String str, int i, int i2, String str2, String str3) {
            this.a = file;
            this.b = z;
            this.c = str;
            this.d = i;
            this.e = i2;
            this.f = str2;
            this.g = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            File file = this.a;
            if (file == null || !file.exists()) {
                ChatActivity.this.P();
                return;
            }
            EntityPicture entityBurnPicture = this.b ? new EntityBurnPicture() : new EntityPicture();
            entityBurnPicture.setLocalUrl(this.c);
            entityBurnPicture.setH(this.d);
            entityBurnPicture.setW(this.e);
            if (!WearUtils.e1(this.f)) {
                entityBurnPicture.setType(this.f);
            }
            if (!WearUtils.e1(this.g)) {
                entityBurnPicture.setFileMd5(this.g);
            }
            if (!hf3.d(ChatActivity.this)) {
                sg3.i(ChatActivity.this, R.string.common_settingTip);
                ChatActivity.this.x8(entityBurnPicture);
                return;
            }
            if (!MyApplication.P || hu3.x() == null) {
                sg3.i(ChatActivity.this, R.string.message_send_error);
                ChatActivity.this.x8(entityBurnPicture);
                return;
            }
            CommunMessage communMessage = new CommunMessage();
            communMessage.setFrom(WearUtils.y.p());
            communMessage.setTo(ChatActivity.this.y);
            communMessage.setUserId(WearUtils.y.p());
            communMessage.sendEntity(entityBurnPicture);
            communMessage.setId(WearUtils.E());
            communMessage.setSendStatus(2);
            if (ChatActivity.this.U7(communMessage)) {
                DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
                ChatActivity.this.E0(communMessage);
            }
            try {
                HashMap map = new HashMap();
                map.put(PSOProgramService.VS_Key, "1");
                tn2.x(WearUtils.x).D("/wear/chat/sendPic", this.a, (WearUtils.e1(this.f) && WearUtils.e1(this.g)) ? "chat.jpg" : this.a.getName(), map, new a(communMessage));
            } catch (Exception e) {
                ChatActivity.this.q8(null, communMessage, 4);
                ChatActivity.this.T7(ah4.e(R.string.common_serverError));
                e.printStackTrace();
            }
        }
    }

    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup.LayoutParams layoutParams = ChatActivity.this.findViewById(R.id.v_chat_live_layer).getLayoutParams();
            ChatActivity chatActivity = ChatActivity.this;
            chatActivity.G8(layoutParams.height + chatActivity.J0.getHeight());
            ChatActivity.this.Z0 = true;
        }
    }

    public class l0 implements iv1 {
        public l0() {
        }

        @Override // dc.iv1
        public void next() {
            ChatActivity.this.finish();
        }
    }

    public class m extends SimpleImageLoadingListener {
        public m() {
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            ChatActivity.this.P0.setImageBitmap(bitmap);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    public class m0 implements Runnable {
        public final /* synthetic */ CommunMessage a;

        public m0(CommunMessage communMessage) {
            this.a = communMessage;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(View view) {
            ChatActivity chatActivity = ChatActivity.this;
            chatActivity.M.scrollToPositionWithOffset(chatActivity.G0, 100);
            ChatActivity.this.Z6(false);
            ChatActivity.this.G0 = -1;
        }

        @Override // java.lang.Runnable
        public void run() {
            EntityChat entityChat;
            if (ChatActivity.this.g0 == null) {
                return;
            }
            ChatActivity.this.j0.addFirst(this.a);
            if (ChatActivity.this.F0) {
                ChatActivity.this.m8();
                ChatActivity.this.Z6(false);
                ChatActivity.this.G0 = -1;
            } else if (this.a.getType() == MessageType.chat) {
                if (ChatActivity.this.G0 == -1) {
                    ChatActivity.this.G0 = 0;
                    ChatActivity.this.g0.b = 0;
                    ChatActivity.this.Z6(true);
                    ChatActivity.this.H0.setOnClickListener(new View.OnClickListener() { // from class: dc.m42
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.a.b(view);
                        }
                    });
                } else {
                    ChatActivity.M5(ChatActivity.this);
                    ChatActivity.this.g0.b = ChatActivity.this.G0;
                }
                ChatActivity.this.Z6(true);
                ChatActivity.this.T8();
                ChatActivity.this.g0.Q0();
            }
            ChatActivity.this.g0.notifyItemInserted(0);
            if (ChatActivity.this.y.equals(this.a.getFrom()) || this.a.getType() != MessageType.chat) {
                ChatActivity.this.H8(this.a);
            }
            if (this.a.getType() != MessageType.chat || (entityChat = (EntityChat) this.a.getDataBean()) == null) {
                return;
            }
            ChatActivity.this.Q8(entityChat.getText());
        }
    }

    public class n extends SimpleImageLoadingListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;

        public class a extends SimpleImageLoadingListener {
            public a() {
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                ChatActivity.this.P0.setImageBitmap(bitmap);
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingStarted(String str, View view) {
            }
        }

        public n(boolean z, String str) {
            this.a = z;
            this.b = str;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            ChatActivity.this.P0.setImageBitmap(bitmap);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ImageLoader imageLoader = ImageLoader.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append(WearUtils.e.replace("-api", ""));
            sb.append(this.a ? this.b.replace("thum_", "") : this.b);
            imageLoader.displayImage(sb.toString(), ChatActivity.this.P0, MyApplication.Y, new a());
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    public class n0 implements Runnable {
        public final /* synthetic */ CommunMessage a;

        public n0(CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ChatActivity.this.g0 == null) {
                return;
            }
            if (WearUtils.e1(ChatActivity.this.y) || this.a.getFrom().equals(ChatActivity.this.y) || this.a.getTo().equals(ChatActivity.this.y)) {
                if (ChatActivity.this.j0.indexOf(this.a) == 0) {
                    ChatActivity.this.g0.notifyItemChanged(ChatActivity.this.j0.indexOf(this.a));
                } else {
                    ChatActivity.this.g0.notifyItemRemoved(ChatActivity.this.j0.indexOf(this.a));
                    ChatActivity.this.j0.remove(this.a);
                    ChatActivity.this.j0.add(0, this.a);
                    ChatActivity.this.g0.notifyItemInserted(0);
                }
                ChatActivity.this.m8();
            }
        }
    }

    public class o extends SimpleImageLoadingListener {
        public o() {
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            ChatActivity.this.Q0.setImageBitmap(bitmap);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    public class o0 implements Runnable {
        public final /* synthetic */ int a;

        public o0(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatActivity.this.p.smoothScrollToPosition(this.a);
        }
    }

    public class p extends SimpleImageLoadingListener {
        public final /* synthetic */ String a;

        public class a extends SimpleImageLoadingListener {
            public a() {
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                ChatActivity.this.Q0.setImageBitmap(bitmap);
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingStarted(String str, View view) {
            }
        }

        public p(String str) {
            this.a = str;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            ChatActivity.this.Q0.setImageBitmap(bitmap);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ImageLoader.getInstance().displayImage(WearUtils.e.replace("-api", "") + this.a, ChatActivity.this.Q0, MyApplication.Y, new a());
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    public class p0 implements Runnable {
        public p0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ChatActivity.this.isFinishing() || ChatActivity.this.isDestroyed()) {
                return;
            }
            ChatActivity.this.g0.notifyDataSetChanged();
        }
    }

    public class q implements Runnable {
        public q() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatActivity.this.getWindow().clearFlags(8192);
        }
    }

    public class q0 implements View.OnClickListener {
        public q0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatActivity.this.S6();
        }
    }

    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatActivity.this.l8(true);
        }
    }

    public class r0 implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public r0(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ChatActivity.this.g0 == null) {
                return;
            }
            ChatActivity.this.g0.notifyItemRangeChanged(this.a, this.b);
            ChatActivity.this.g0.d = false;
        }
    }

    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatActivity.this.o();
        }
    }

    public class s0 implements Runnable {
        public s0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup.LayoutParams layoutParams = ChatActivity.this.findViewById(R.id.v_chat_live_layer).getLayoutParams();
            ChatActivity chatActivity = ChatActivity.this;
            chatActivity.F8(layoutParams.height - chatActivity.J0.getHeight());
            ChatActivity.this.Z0 = false;
        }
    }

    public class t extends SimpleImageLoadingListener {
        public t() {
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (bitmap != null) {
                ChatActivity.this.X.setImageBitmap(bitmap);
                ChatActivity.this.E8();
            }
        }
    }

    public class t0 implements Runnable {

        public class a extends HashMap<String, String> {
            public a() {
                String str;
                if (WearUtils.y.y() == null) {
                    str = "0";
                } else {
                    str = "" + WearUtils.y.y().size();
                }
                put("count", str);
            }
        }

        public t0() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(boolean z) {
            ChatActivity.this.dissDialog();
            if (z) {
                ChatActivity.this.d0.setVisibility(8);
                EventBus.getDefault().post(new BlockFinishEvent());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d(final boolean z) {
            ChatActivity.this.parentHandler.post(new Runnable() { // from class: dc.n42
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b(z);
                }
            });
        }

        @Override // java.lang.Runnable
        public void run() {
            WearUtils.x.q("longDistance_unblock_friend", new a());
            WearUtils.x.i.y(ChatActivity.this.y, new n82.d() { // from class: dc.o42
                @Override // dc.n82.d
                public final void a(boolean z) {
                    this.a.d(z);
                }
            });
        }
    }

    public class u implements is3.c {
        public final /* synthetic */ iv1 a;

        public u(iv1 iv1Var) {
            this.a = iv1Var;
        }

        @Override // dc.is3.c
        public void doCancel() {
            if (!c83.R1().r()) {
                ChatActivity.this.C.D1();
                ChatActivity.this.B.Z0();
            }
            iv1 iv1Var = this.a;
            if (iv1Var != null) {
                iv1Var.next();
            }
        }
    }

    public class u0 implements ip1 {
        public u0() {
        }

        @Override // dc.ip1
        public void G() {
            ChatActivity.this.dissDialog();
        }

        @Override // dc.ip1
        public void d() {
            ChatActivity.this.cancleDelay();
        }
    }

    public class v implements Animator.AnimatorListener {
        public v() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (ChatActivity.this.E0.isEmpty()) {
                ChatActivity.this.i0.setProgress(0.0f);
                ChatActivity.this.i0.setVisibility(8);
            } else {
                ChatActivity.this.t1.setVisibility(8);
                ChatActivity.this.s0.O(ChatActivity.this.i0, (String) ChatActivity.this.E0.get(0));
                ChatActivity.this.E0.remove(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public class v0 implements rf3.i {
        public final /* synthetic */ EntityPattern a;
        public final /* synthetic */ CommunMessage b;

        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(this.a, NormalResponse.class);
                if (normalResponse == null) {
                    sg3.i(ChatActivity.this, R.string.common_serverError);
                    return;
                }
                if (!normalResponse.isResult()) {
                    sg3.k(ChatActivity.this, normalResponse.getMessage());
                    v0 v0Var = v0.this;
                    ChatActivity.this.w8(v0Var.b, false);
                } else {
                    v0.this.a.setUrl(normalResponse.getMessage());
                    v0 v0Var2 = v0.this;
                    v0Var2.b.sendEntity(v0Var2.a);
                    v0 v0Var3 = v0.this;
                    ChatActivity.this.y8(v0Var3.b, MessageType.pattern, false);
                }
            }
        }

        public v0(EntityPattern entityPattern, CommunMessage communMessage) {
            this.a = entityPattern;
            this.b = communMessage;
        }

        @Override // dc.rf3.i
        public void onError(NetException netException) {
            ChatActivity.this.w8(this.b, false);
            ChatActivity.this.P();
        }

        @Override // dc.rf3.i
        public void onSuccess(String str) {
            ChatActivity.this.r0.postDelayed(new a(str), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }

    public class w implements is3.d {
        public final /* synthetic */ is3.c a;

        public w(is3.c cVar) {
            this.a = cVar;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            this.a.doCancel();
            od3.d(ChatActivity.this.activity);
        }
    }

    public class w0 implements Runnable {
        public w0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            sg3.e(ChatActivity.this, R.string.chat_message_item_save_error);
        }
    }

    public class x implements Runnable {
        public x() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b() {
            ChatActivity.this.m8();
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatActivity chatActivity = ChatActivity.this;
            ue3.d(chatActivity.o, chatActivity);
            ChatActivity chatActivity2 = ChatActivity.this;
            if (chatActivity2.K) {
                chatActivity2.parentHandler.postDelayed(new Runnable() { // from class: dc.l42
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b();
                    }
                }, 100L);
            }
        }
    }

    public class x0 implements rf3.i {
        public final /* synthetic */ EntityPattern a;

        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                ChatActivity.this.progressDialog.dismiss();
                NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(this.a, NormalResponse.class);
                if (normalResponse == null) {
                    sg3.i(ChatActivity.this, R.string.common_serverError);
                    return;
                }
                if (normalResponse.isResult()) {
                    x0.this.a.setUrl(normalResponse.getMessage());
                    x0 x0Var = x0.this;
                    ChatActivity.this.t8(x0Var.a, MessageType.pattern);
                } else {
                    sg3.k(ChatActivity.this, normalResponse.getMessage());
                    if (!MyApplication.P || hu3.x() == null) {
                        x0 x0Var2 = x0.this;
                        ChatActivity.this.x8(x0Var2.a);
                    }
                }
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ChatActivity.this.progressDialog.dismiss();
                x0 x0Var = x0.this;
                ChatActivity.this.x8(x0Var.a);
                ChatActivity.this.P();
            }
        }

        public x0(EntityPattern entityPattern) {
            this.a = entityPattern;
        }

        @Override // dc.rf3.i
        public void onError(NetException netException) {
            ChatActivity.this.r0.post(new b());
        }

        @Override // dc.rf3.i
        public void onSuccess(String str) {
            ChatActivity.this.r0.post(new a(str));
        }
    }

    public class y implements Runnable {
        public y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatActivity.this.f0.setVisibility(0);
            ChatActivity.this.q.setVisibility(0);
            ChatActivity.this.s.setVisibility(0);
        }
    }

    public class y0 implements Runnable {
        public final /* synthetic */ View a;

        public y0(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup viewGroup = (ViewGroup) this.a.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.a);
            }
            ChatActivity.this.w.setVisibility(0);
            ChatActivity.this.w.addView(this.a);
        }
    }

    public class z implements db2.s {
        public z() {
        }

        @Override // dc.db2.s
        public void a() {
            ChatActivity.this.K6(R.id.chat_more_voice);
        }
    }

    public class z0 implements kn3.d {
        public z0(ChatActivity chatActivity) {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
        }
    }

    public ChatActivity() {
        File fileE0 = WearUtils.e0("camera.jpg");
        this.V = fileE0;
        Uri.fromFile(fileE0);
        this.j0 = new LinkedList<>();
        this.k0 = new ArrayList();
        this.l0 = 0;
        this.n0 = new so3();
        this.q0 = null;
        this.s0 = new ie3();
        this.w0 = false;
        this.E0 = new ArrayList();
        this.F0 = true;
        this.G0 = -1;
        this.H0 = null;
        this.I0 = null;
        this.X0 = -1;
        this.a1 = System.currentTimeMillis();
        this.c1 = false;
        this.d1 = new Object();
        this.e1 = new k(3000L, 1000L);
        this.h1 = false;
        this.l1 = false;
        this.m1 = false;
        this.p1 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B7(List list) {
        int size = this.j0.size();
        this.j0.addAll(EntityUnSupport.filterMessages((List<CommunMessage>) list));
        W7(size, this.j0.size() - size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D7() {
        final List<CommunMessage> listFindBeforeMessage;
        if (this.f1 == null) {
            CommunMessageDao communMessageDao = DaoUtils.getCommunMessageDao();
            String strP = WearUtils.y.p();
            String str = this.y;
            int i2 = this.l0 + 1;
            this.l0 = i2;
            listFindBeforeMessage = communMessageDao.findByPage(strP, str, i2, 10);
        } else {
            listFindBeforeMessage = DaoUtils.getCommunMessageDao().findBeforeMessage(WearUtils.y.p(), this.y, this.j0.get(r4.size() - 1), 10);
        }
        if (listFindBeforeMessage == null || listFindBeforeMessage.isEmpty()) {
            return;
        }
        for (CommunMessage communMessage : listFindBeforeMessage) {
            if (be3.E(communMessage.getCreated(), communMessage.getSendStatus())) {
                communMessage.setSendStatus(4);
            }
            communMessage.setDataBean(communMessage.syncDecryptBean());
        }
        this.parentHandler.post(new Runnable() { // from class: dc.s42
            @Override // java.lang.Runnable
            public final void run() {
                this.a.B7(listFindBeforeMessage);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F7(String str) {
        MessageType messageType = MessageType.video;
        H6(str, messageType);
        E6(messageType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H7(String str) {
        MessageType messageType = MessageType.voice;
        H6(str, messageType);
        E6(messageType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J7() {
        this.K = true;
        LinearLayoutManager linearLayoutManager = this.M;
        if (linearLayoutManager == null || linearLayoutManager.getItemCount() <= 0 || this.p == null || this.g0.getItemCount() <= 0) {
            return;
        }
        this.p.scrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L7() {
        F8(findViewById(R.id.v_chat_live_layer).getLayoutParams().height - this.J0.getHeight());
        this.Z0 = false;
    }

    public static /* synthetic */ int M5(ChatActivity chatActivity) {
        int i2 = chatActivity.G0;
        chatActivity.G0 = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N7(ContainBean containBean, MessageType messageType, final CommunMessage communMessage) {
        hu3.f0(containBean);
        if (messageType != MessageType.toy) {
            this.parentHandler.post(new Runnable() { // from class: dc.t42
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.Q7(communMessage);
                }
            });
        }
    }

    public static /* synthetic */ void O7(ContainBean containBean, MessageType messageType, CommunMessage communMessage) {
        hu3.f0(containBean);
        MessageType messageType2 = MessageType.system;
        if (messageType == messageType2) {
            EntitySystem entitySystem = (EntitySystem) communMessage.getDataBean();
            if (entitySystem.getFirstSysOPTType() == EntitySystem.SystemOPTType.T300 && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C309) {
                return;
            }
        }
        if (messageType == messageType2) {
            EntitySystem entitySystem2 = (EntitySystem) communMessage.getDataBean();
            if ((entitySystem2.getFirstSysOPTType() != EntitySystem.SystemOPTType.T200 || entitySystem2.getFirstSysOPTCode() != EntitySystem.SystemOPTCode.C204) && entitySystem2.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C666) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q7(CommunMessage communMessage) {
        MessageNewAdapter messageNewAdapter;
        if (this.p == null || (messageNewAdapter = this.g0) == null) {
            return;
        }
        messageNewAdapter.notifyItemChanged(this.j0.indexOf(communMessage), "sendStatus");
        m8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l7() {
        this.Z.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n7() {
        G8(findViewById(R.id.v_chat_live_layer).getLayoutParams().height - this.J0.getHeight());
        this.Z0 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p7(int i2) {
        if (this.M.findLastVisibleItemPosition() < i2) {
            MessageNewAdapter messageNewAdapter = this.g0;
            messageNewAdapter.b = i2;
            messageNewAdapter.notifyItemChanged(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r7(View view) {
        U6(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t7(View view) {
        J8(new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v7(int i2) {
        gp1 gp1Var = new gp1(new t0(), new u0());
        showDialog();
        ep1.b().r(this, gp1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x7(List list) {
        this.j0.addAll(0, EntityUnSupport.filterMessages((List<CommunMessage>) list));
        this.g0.notifyItemRangeInserted(0, list.size());
        this.h1 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z7() {
        boolean z2 = false;
        final List<CommunMessage> listFindAfterMessage = DaoUtils.getCommunMessageDao().findAfterMessage(WearUtils.y.p(), this.y, this.j0.get(0), 10);
        if (listFindAfterMessage != null && listFindAfterMessage.size() == 10) {
            z2 = true;
        }
        this.g1 = z2;
        if (listFindAfterMessage == null || listFindAfterMessage.isEmpty()) {
            return;
        }
        for (CommunMessage communMessage : listFindAfterMessage) {
            if (be3.E(communMessage.getCreated(), communMessage.getSendStatus())) {
                communMessage.setSendStatus(4);
            }
            communMessage.setDataBean(communMessage.syncDecryptBean());
        }
        this.parentHandler.post(new Runnable() { // from class: dc.z42
            @Override // java.lang.Runnable
            public final void run() {
                this.a.x7(listFindAfterMessage);
            }
        });
    }

    @Override // dc.sa2
    public void A0(CommunMessage communMessage, int i2) {
        String showNickName;
        String str;
        addAnalyticsEventId("chat_reply", null);
        this.L0 = communMessage;
        if (communMessage == null) {
            return;
        }
        this.J0.setVisibility(0);
        String strG0 = WearUtils.g0(W6(this.L0.getFrom()));
        if (strG0.equals(this.A.getId())) {
            showNickName = this.A.getUserName();
        } else {
            User userV = ch3.n().v(strG0);
            showNickName = userV != null ? userV.getShowNickName() : "";
        }
        this.M0.setText(showNickName);
        int i3 = c1.a[this.L0.getType().ordinal()];
        if (i3 == 1) {
            this.s0.i(this.N0, ((EntityChat) this.L0.getDataBean()).getText());
            this.N0.setVisibility(0);
            this.P0.setVisibility(8);
            this.R0.setVisibility(8);
            this.S0.setVisibility(8);
        } else if (i3 == 2) {
            this.N0.setVisibility(8);
            this.P0.setVisibility(8);
            this.R0.setVisibility(0);
            this.S0.setVisibility(8);
            D8(communMessage);
        } else if (i3 == 3) {
            this.N0.setVisibility(8);
            this.P0.setVisibility(8);
            this.R0.setVisibility(8);
            this.S0.setVisibility(0);
            EntityAudio entityAudio = new EntityAudio(communMessage.getData());
            boolean zIsExpired = entityAudio.isExpired();
            TextView textView = this.O0;
            if (zIsExpired) {
                str = "[" + ah4.e(R.string.voice_message_expired) + "]";
            } else {
                str = entityAudio.getTime() + "''";
            }
            textView.setText(str);
            A8(this.V0, zIsExpired ? nz1.e().f().B() : nz1.e().f().o());
        } else if (i3 == 4) {
            this.N0.setVisibility(8);
            this.P0.setVisibility(0);
            this.R0.setVisibility(8);
            this.S0.setVisibility(8);
            C8(communMessage);
        }
        if (this.Z0) {
            return;
        }
        this.r0.postDelayed(new l(), 300L);
    }

    public final void A8(ImageView imageView, int i2) {
        imageView.setImageDrawable(th4.d(imageView.getContext(), i2));
    }

    public final void B8(int i2) {
        String str = "setMPadding bottomP:" + i2;
        if (i2 > 0) {
            if (this.J0.getVisibility() == 0 && !this.Z0) {
                i2 += this.J0.getHeight();
                this.Z0 = true;
            }
            if (this.J0.getVisibility() == 8 && this.Z0) {
                i2 -= this.J0.getHeight();
                this.Z0 = false;
            }
        } else {
            if (this.J0.getVisibility() == 0 && !this.Z0) {
                i2 += this.J0.getHeight();
                this.Z0 = true;
            }
            if (this.J0.getVisibility() == 8 && this.Z0) {
                i2 -= this.J0.getHeight();
                this.Z0 = false;
            }
        }
        int height = findViewById(R.id.v_chat_live_layer).getHeight() + i2;
        if (height >= this.Z.getPanelTypeHeight() * 2) {
            height -= i2;
        }
        F8(height);
        String str2 = "setMPadding bottom 1:" + height;
    }

    @Override // dc.sa2
    public IPeopleInfo C() {
        return this.z;
    }

    @Override // dc.sa2
    public void C2(CommunMessage communMessage) {
        if (communMessage == null || !TextUtils.equals(communMessage.getTo(), ch3.n().p())) {
            return;
        }
        HashMap map = new HashMap();
        if (communMessage.getType() == MessageType.burnpicture) {
            EntityBurnPicture entityBurnPicture = (EntityBurnPicture) communMessage.getDataBean();
            entityBurnPicture.setBurn(true);
            communMessage.sendEntity(entityBurnPicture);
            map.put("type", 1);
        }
        if (communMessage.getType() == MessageType.burnvideo) {
            EntityBurnShortVideo entityBurnShortVideo = (EntityBurnShortVideo) communMessage.getDataBean();
            entityBurnShortVideo.setBurn(true);
            communMessage.sendEntity(entityBurnShortVideo);
            map.put("type", 2);
        }
        DaoUtils.getCommunMessageDao().update((CommunMessageDao) communMessage);
        this.g0.notifyItemChanged(this.j0.indexOf(communMessage));
        String id = TextUtils.equals(communMessage.getFrom(), ch3.n().p()) ? communMessage.getId() : communMessage.getReceiveId();
        EntitySystem entitySystem = new EntitySystem();
        entitySystem.addDataToArray(EntitySystem.SystemOPTType.T300.toString(), EntitySystem.SystemOPTCode.C309.toString(), id);
        t8(entitySystem, MessageType.system);
        map.put("chat_type", 1);
        ye3.e("M0019", map);
    }

    public final void C8(CommunMessage communMessage) {
        EntityPicture entityPicture = new EntityPicture(communMessage.getData());
        String url = entityPicture.getUrl();
        String localUrl = entityPicture.getLocalUrl();
        String type = entityPicture.getType();
        boolean z2 = !WearUtils.e1(type) && type.equals("emoji");
        this.E.F(communMessage.getId());
        if (!WearUtils.e1(localUrl) && (WearUtils.c0(localUrl).exists() || WearUtils.Z(localUrl).exists() || WearUtils.a0(localUrl).exists())) {
            ImageLoader.getInstance().displayImage(Uri.fromFile(z2 ? WearUtils.Z(localUrl).exists() ? WearUtils.Z(localUrl) : WearUtils.a0(localUrl) : WearUtils.c0(localUrl)).toString(), this.P0, MyApplication.Y, new m());
            return;
        }
        if (WearUtils.e1(url)) {
            return;
        }
        ImageLoader imageLoader = ImageLoader.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append(WearUtils.e);
        sb.append(z2 ? url.replace("thum_", "") : url);
        imageLoader.displayImage(sb.toString(), this.P0, MyApplication.Y, new n(z2, url));
    }

    public final void D6(String str) {
        ku1.f("friend chatroom", "friend_chatroom_album_click", "friend_chatroom_album", "", str, 0);
    }

    public final void D8(CommunMessage communMessage) {
        EntityShortVideo entityShortVideo = new EntityShortVideo(communMessage.getData());
        String picUrl = entityShortVideo.getPicUrl();
        String picLocalUrl = entityShortVideo.getPicLocalUrl();
        this.E.F(communMessage.getId());
        if (!WearUtils.e1(picLocalUrl) && (WearUtils.c0(picLocalUrl).exists() || WearUtils.Z(picLocalUrl).exists() || WearUtils.a0(picLocalUrl).exists())) {
            ImageLoader.getInstance().displayImage(Uri.fromFile(WearUtils.c0(picLocalUrl)).toString(), this.Q0, MyApplication.Y, new o());
        } else {
            if (WearUtils.e1(picUrl)) {
                return;
            }
            ImageLoader.getInstance().displayImage(WearUtils.e + picUrl, this.Q0, MyApplication.Y, new p(picUrl));
        }
    }

    @Override // dc.sa2
    public boolean E() {
        if (this.D.r()) {
            if (this.A.getCurrentControlType() == MessageType.video) {
                sg3.l(ah4.e(R.string.chat_media_video_busy));
                return true;
            }
            if (this.A.getCurrentControlType() == MessageType.voice) {
                sg3.l(ah4.e(R.string.chat_media_voice_busy));
                return true;
            }
        }
        return false;
    }

    @Override // dc.xb2
    public void E0(CommunMessage communMessage) {
        Account accountU;
        if (TextUtils.isEmpty(this.y) || communMessage == null) {
            return;
        }
        if ((this.y.equals(communMessage.getFrom()) || this.y.equals(communMessage.getTo())) && (accountU = ch3.n().u()) != null) {
            boolean zEquals = WearUtils.X(communMessage.getFrom()).equals(accountU.getId());
            if (this.f1 == null || !this.g1) {
                if (zEquals) {
                    this.F0 = true;
                }
                R6(communMessage);
            } else if (zEquals) {
                i8(communMessage);
            }
        }
    }

    public void E6(MessageType messageType) {
        ye3.c("friend chatroom", messageType == MessageType.live ? "sponsor live control" : messageType == MessageType.sync ? "sponsor sync control" : messageType == MessageType.video ? "sponsor video control" : messageType == MessageType.voice ? "sponsor vioce control" : "", this.y);
    }

    public final void E8() {
        int i2 = MyApplication.m0;
        if (i2 == 0) {
            if (MyApplication.l0) {
                this.Y.setVisibility(0);
                return;
            } else {
                this.Y.setVisibility(8);
                return;
            }
        }
        if (i2 == 2) {
            this.Y.setVisibility(0);
        } else {
            this.Y.setVisibility(8);
        }
    }

    public void F6() {
        hu3.V(this.y);
    }

    public final void F8(int i2) {
        View viewFindViewById = findViewById(R.id.v_chat_live_layer);
        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = i2;
        viewFindViewById.setVisibility(0);
        viewFindViewById.setLayoutParams(layoutParams);
        viewFindViewById.invalidate();
        if ((this.f1 == null || !this.g1) && this.K) {
            m8();
        }
        this.r1 = System.currentTimeMillis();
        String str = "setMPadding setViewLayerHeight:" + i2;
    }

    public void G6(double d2, int i2, int i3) {
        HashMap map = new HashMap();
        map.put("receiver_jid", this.y);
        map.put("size", Double.valueOf(d2));
        map.put("times", Integer.valueOf(i2));
        map.put("source_type", Integer.valueOf(i3));
        ye3.d("F0018", WearUtils.A.toJson(map));
        addAnalyticsEventId("chat_sendVideo", null);
    }

    public final void G8(int i2) {
        View viewFindViewById = findViewById(R.id.v_chat_live_layer);
        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = i2;
        viewFindViewById.setVisibility(0);
        viewFindViewById.setLayoutParams(layoutParams);
        viewFindViewById.invalidate();
        this.r1 = System.currentTimeMillis();
        String str = "setMPadding setViewLayerHeight:" + i2;
    }

    @Override // dc.sa2
    public boolean H1(boolean z2) {
        View childAt;
        boolean z3 = (this.M.findLastVisibleItemPosition() == this.M.getItemCount() - 1 || this.M.findLastVisibleItemPosition() == this.M.getItemCount()) && ((childAt = this.p.getChildAt(this.M.findLastVisibleItemPosition() - this.M.findFirstVisibleItemPosition())) == null || this.p.getHeight() >= childAt.getBottom());
        if (z2) {
            if (this.M.getItemCount() >= 10) {
                if (!this.M.getStackFromEnd()) {
                    this.M.setStackFromEnd(true);
                }
            } else if (this.M.findLastVisibleItemPosition() == -1 || this.M.findFirstVisibleItemPosition() == 0) {
                this.M.setStackFromEnd(false);
            } else if (!z3 || this.M.findLastVisibleItemPosition() <= 0) {
                if (z3) {
                    this.M.setStackFromEnd(false);
                } else if (!this.M.getStackFromEnd()) {
                    this.M.setStackFromEnd(true);
                }
            } else if (!this.M.getStackFromEnd()) {
                this.M.setStackFromEnd(true);
            }
        }
        return z3;
    }

    @Override // dc.sa2
    public View H2(String str) {
        return this.g0.T(str);
    }

    @Override // dc.sa2
    public void H3(CommunMessage communMessage, EntityShortVideo entityShortVideo) {
        this.o1 = communMessage;
        ue3.b(this.o, this, false);
        this.u.setVisibility(8);
        this.v.setVisibility(8);
        this.t.setVisibility(8);
        W3();
        if (entityShortVideo instanceof EntityBurnShortVideo) {
            VideoPlayerActivity.w4(this, entityShortVideo, 24);
        } else {
            VideoPlayerActivity.u4(this, entityShortVideo);
        }
    }

    public void H6(String str, MessageType messageType) {
        int i2 = messageType == MessageType.live ? 26 : messageType == MessageType.sync ? 27 : messageType == MessageType.video ? 28 : messageType == MessageType.voice ? 29 : 0;
        if (i2 != 0) {
            HashMap map = new HashMap();
            map.put("control_id", str);
            map.put("receiver_jid", this.y);
            map.put("chat_type", Integer.valueOf(i2));
            ye3.d("F0030", WearUtils.A.toJson(map));
        }
    }

    public final void H8(CommunMessage communMessage) {
        String str = null;
        String strS = communMessage.getDataBean() instanceof EntityChat ? this.s0.s(((EntityChat) communMessage.getDataBean()).getText(), true) : null;
        if (TextUtils.isEmpty(strS)) {
            if (communMessage.getType() == MessageType.system) {
                EntitySystem entitySystem = (EntitySystem) communMessage.getDataBean();
                if (entitySystem.getFirstSysOPTType() == EntitySystem.SystemOPTType.T200 && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C204) {
                    return;
                }
            } else if (communMessage.getType() == MessageType.chat && WearUtils.R0(((EntityChat) communMessage.getDataBean()).getText())) {
                b8();
            }
            this.D0 = null;
            return;
        }
        if (!this.s0.B(strS)) {
            this.D0 = null;
        } else {
            if (this.l1) {
                this.n1 = communMessage;
                return;
            }
            CommunMessage communMessage2 = this.D0;
            if (communMessage2 != null) {
                String strS2 = this.s0.s(((EntityChat) communMessage2.getDataBean()).getText(), true);
                if (!TextUtils.equals(this.D0.getFrom(), communMessage.getFrom()) && TextUtils.equals(strS, strS2)) {
                    str = strS;
                }
            }
            this.D0 = communMessage;
            strS = str;
        }
        if (TextUtils.isEmpty(strS)) {
            return;
        }
        if (this.i0.o()) {
            this.E0.add(strS);
            return;
        }
        this.i0.setVisibility(0);
        this.t1.setVisibility(8);
        this.s0.O(this.i0, strS);
        communMessage.setShowEmojiAnim(false);
        DaoUtils.getCommunMessageDao().update((CommunMessageDao) communMessage);
    }

    public final void I6(String str) {
        ku1.f("friend chatroom", "friend_chatroom_function_menu_click", "friend_chatroom_function_menu", "", str, 0);
    }

    public final void I8() {
        J8(null);
    }

    public void J6() {
        runOnMainThread(new Runnable() { // from class: dc.p42
            @Override // java.lang.Runnable
            public final void run() {
                this.a.l7();
            }
        });
    }

    public final void J8(iv1 iv1Var) {
        u uVar = new u(iv1Var);
        if (MyApplication.i0 || od3.c(this.activity)) {
            uVar.doCancel();
            return;
        }
        if (!this.C.r() && !this.B.r()) {
            uVar.doCancel();
            return;
        }
        MyApplication.i0 = true;
        is3.b bVar = new is3.b(this.activity);
        bVar.p(ah4.e(R.string.enable_floating_window_des));
        bVar.o(ah4.e(R.string.common_ok));
        bVar.n(ah4.e(R.string.common_cancel));
        bVar.d(new w(uVar));
        bVar.c(uVar);
        bVar.q(ah4.e(R.string.enable_floating_window_title));
        cs3.h(bVar).show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void JUtilsEvent(hh0 hh0Var) {
        B8(hh0Var.b());
    }

    @Override // dc.sa2
    public void K() {
        J6();
    }

    @Override // com.wear.widget.iwatcher.ImageWatcher.j
    public void K3(ImageView imageView, String str, int i2) {
        this.E.P(imageView, str, i2);
    }

    @SuppressLint({"CheckResult"})
    public final void K6(int i2) {
        this.Q = i2;
        String[] strArr = i2 == R.id.chat_more_sendPicture ? new String[]{"android.permission.CAMERA", "android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO", "android.permission.RECORD_AUDIO"} : i2 == R.id.chat_more_video ? new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"} : i2 == R.id.chat_more_voice ? new String[]{"android.permission.RECORD_AUDIO"} : null;
        q61 q61VarM = q61.m(this);
        q61VarM.h(strArr);
        q61VarM.j(new d0());
    }

    public final void K8() {
        if (!MyApplication.P) {
            sg3.h(R.string.chat_login);
            return;
        }
        ue3.a(this.o, this);
        this.P = true;
        this.c0.setImageResource(R.drawable.chat_function_emojis);
        this.f0.setVisibility(8);
        this.q.setVisibility(0);
        this.s.setVisibility(8);
        this.w.setVisibility(0);
        O8();
    }

    @Override // dc.ah3
    public void L3(CommunMessage communMessage) {
        w8(communMessage, false);
    }

    public final void L6(boolean z2) {
        this.D0 = null;
        if (this.j0.isEmpty()) {
            return;
        }
        CommunMessage communMessage = this.j0.get(0);
        if (communMessage.getDataBean() instanceof EntityChat) {
            String strS = this.s0.s(((EntityChat) communMessage.getDataBean()).getText(), true);
            if (TextUtils.isEmpty(strS)) {
                return;
            }
            this.D0 = communMessage;
            if (communMessage.isShowEmojiAnim()) {
                if (!this.s0.B(strS)) {
                    if (z2) {
                        H8(communMessage);
                    }
                } else if (this.j0.size() != 1) {
                    CommunMessage communMessage2 = this.j0.get(1);
                    if (TextUtils.equals(communMessage.getFrom(), communMessage2.getFrom()) || !(communMessage2.getDataBean() instanceof EntityChat)) {
                        return;
                    }
                    if (TextUtils.equals(strS, this.s0.s(((EntityChat) communMessage2.getDataBean()).getText(), true))) {
                        this.D0 = communMessage2;
                        if (z2) {
                            H8(communMessage);
                        }
                    }
                }
            }
        }
    }

    public final void L8() {
        is3.b bVar = new is3.b(this);
        bVar.c(new f0());
        bVar.d(new e0());
        bVar.x(gg3.e(this.application));
        bVar.i(80);
        bVar.l(true);
        bVar.m(true);
        is3 is3VarI = cs3.i(bVar, PhotoCameraDialog.class);
        this.v1 = is3VarI;
        is3VarI.show();
    }

    @Override // dc.sa2
    public void M(EntityPattern entityPattern) {
        String strI = nd3.i(entityPattern.getLocalUrl());
        if (WearUtils.e1(strI)) {
            return;
        }
        File file = new File(strI);
        if (!file.exists()) {
            P();
        } else {
            this.progressDialog.show();
            rf3.s(file, new x0(entityPattern));
        }
    }

    public final boolean M6() {
        if (this.A != null) {
            return true;
        }
        ye3.I("wipeMemoryError", "chatActivity");
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
        } catch (Exception unused) {
            return false;
        }
    }

    public final kn3 M8(String str) {
        kn3 kn3Var = new kn3((Context) this, str, ah4.e(R.string.common_ok), false, false, (kn3.d) new z0(this), true);
        kn3Var.show();
        kn3Var.n();
        return kn3Var;
    }

    public final void N6() {
        if (this.z != null) {
            h7();
        } else {
            pj3.f(this, MainActivity.class);
            finish();
        }
    }

    public final void N8() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(500L);
        this.u0.startAnimation(translateAnimation);
        this.u0.setVisibility(0);
    }

    @Override // com.wear.widget.chatMic.VoiceMessagePanelView.b
    public void O() {
        String str = "cancelRecord: delete file :" + vd0.e(this.o0);
    }

    @Override // dc.xb2
    public boolean O3(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(this.y) || str.equals(this.x);
    }

    public final void O6() {
        this.L0 = null;
        this.J0.setVisibility(8);
        this.M0.setText("");
        this.N0.setText("");
        this.r0.postDelayed(new Runnable() { // from class: dc.c52
            @Override // java.lang.Runnable
            public final void run() {
                this.a.n7();
            }
        }, 300L);
    }

    public final void O8() {
        ChatLiveControl.q0().c1();
        ChatSyncControl.N0().H1();
    }

    @Override // dc.sa2
    public void P() {
        runOnUiThread(new w0());
    }

    public void P6() {
        Q6(true);
    }

    public final void P8(MessageType messageType) {
        UserSetting userSettingZ = WearUtils.y.z(this.x);
        String strE = String.format(ah4.e(R.string.chat_waitAcceptance), this.z.getShowNickName());
        if (userSettingZ.getPassiveAutoAccept().booleanValue()) {
            strE = ah4.e(R.string.chat_waiting_accep_tance_auto);
        }
        if (messageType == MessageType.sync) {
            this.C.L(this.z);
            this.C.J1(strE, null);
        } else {
            this.B.y0(this.z);
            this.B.g1(strE, null);
        }
        try {
            MusicControl.h0().S();
            y12.c.a().t();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // dc.sa2
    public void Q1(HashMap<String, String> map) {
        this.q0 = map;
    }

    public void Q6(boolean z2) {
        ue3.a(this.o, this);
        this.q.setVisibility(8);
        this.w.setVisibility(8);
        Y6();
        this.P = true;
        this.c0.setImageResource(R.drawable.chat_function_emojis);
        if (z2) {
            I8();
        }
        if (ChatInputPanelPto.l) {
            ChatInputPanelPto.l = false;
        } else {
            this.Z.g(false);
        }
    }

    public final void Q8(String str) {
        if (this.s0.D(str) && eg3.d(this.activity, "isFirstSend", true) && str.contains(this.s0.k)) {
            if (this.l1) {
                this.m1 = true;
            } else if (ke3.a("new_user", "isFirstSend")) {
                new LoveEmojisDialog(this.activity).show();
            }
        }
    }

    @Override // dc.sa2
    public void R2(int i2, CommunMessage communMessage) {
        LinkedList<CommunMessage> linkedList = this.j0;
        if (linkedList == null || linkedList.size() <= i2) {
            return;
        }
        if (!this.j0.get(i2).getId().equals(communMessage.getId())) {
            Iterator<CommunMessage> it = this.j0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                CommunMessage next = it.next();
                if (next.getId().equals(communMessage.getId())) {
                    next.sendEntity(communMessage.getDataBean());
                    CommunMessage communMessage2 = this.D0;
                    if (communMessage2 != null && next == communMessage2) {
                        this.D0 = null;
                    }
                }
            }
        } else {
            this.j0.get(i2).sendEntity(communMessage.getDataBean());
            if (this.D0 != null && this.j0.get(i2) == this.D0) {
                this.D0 = null;
            }
        }
        Iterator<CommunMessage> it2 = this.j0.iterator();
        while (it2.hasNext()) {
            CommunMessage next2 = it2.next();
            if (!WearUtils.e1(next2.getReplyData())) {
                HashMap map = (HashMap) WearUtils.A.fromJson(next2.getReplyData(), HashMap.class);
                Gson gson = WearUtils.A;
                map.remove("replyData");
                map.remove("dataBean");
                CommunMessage communMessage3 = (CommunMessage) WearUtils.A.fromJson(WearUtils.A.toJson(map), CommunMessage.class);
                if (communMessage3.getId().equals(communMessage.getId()) || communMessage3.getId().equals(communMessage.getReceiveId()) || ((!WearUtils.e1(communMessage3.getReceiveId()) && communMessage3.getReceiveId().equals(communMessage.getReceiveId())) || (!WearUtils.e1(communMessage3.getReceiveId()) && communMessage3.getReceiveId().equals(communMessage.getId())))) {
                    communMessage3.setType(MessageType.system);
                    communMessage3.setReplyData("recall");
                    next2.setReplyData(WearUtils.A.toJson(communMessage3));
                    DaoUtils.getCommunMessageDao().update((CommunMessageDao) next2);
                }
            }
        }
        notifyDataSetChanged();
        CommunMessage communMessage4 = this.L0;
        if (communMessage4 == null || !communMessage4.getId().equals(communMessage.getId())) {
            return;
        }
        O6();
    }

    public final void R6(CommunMessage communMessage) {
        if (communMessage.getType() != MessageType.system || ((EntitySystem) communMessage.getDataBean()).getFirstSysOPTType() != EntitySystem.SystemOPTType.T200 || ((EntitySystem) communMessage.getDataBean()).getFirstSysOPTCode() != EntitySystem.SystemOPTCode.C204) {
            if (this.c1) {
                this.e1.onFinish();
            }
            c8(communMessage);
        } else {
            if (!this.c1) {
                this.c1 = true;
                c8(communMessage);
            }
            this.e1.cancel();
            this.e1.start();
        }
    }

    public void R7(CommunMessage communMessage) {
        runOnMainThread(new n0(communMessage));
    }

    public void R8() {
        if (this.t0 == null) {
            return;
        }
        List<CommunMessage> listFindUnReadMessage = DaoUtils.getCommunMessageDao().findUnReadMessage(WearUtils.y.p(), this.y, 0, 10, this.t0.getCreated(), false);
        for (int i2 = 0; i2 < this.F && i2 <= listFindUnReadMessage.size() - 1; i2++) {
            CommunMessage communMessage = listFindUnReadMessage.get(i2);
            if (communMessage.getDataBean() == null) {
                communMessage.setDataBean(communMessage.syncDecryptBean());
            }
            if (communMessage.getType() == MessageType.chat) {
                if (communMessage.getDataBean() == null) {
                    communMessage.setDataBean(communMessage.syncDecryptBean());
                }
                if (WearUtils.R0(((EntityChat) communMessage.getDataBean()).getText())) {
                    b8();
                    return;
                }
            }
        }
    }

    public void S6() {
        runOnUiThread(new i0());
    }

    public void S7() {
        vg3.b().a(new Runnable() { // from class: dc.a52
            @Override // java.lang.Runnable
            public final void run() {
                this.a.z7();
            }
        });
    }

    public void S8(int i2, boolean z2) {
        this.b1.I(i2, z2);
    }

    @Override // dc.sa2
    public void T0(CommunMessage communMessage) {
        if (communMessage != null) {
            getWindow().setFlags(8192, 8192);
        }
    }

    public void T6(boolean z2) {
        if (this.B.r()) {
            this.B.a();
        }
        if (this.C.r()) {
            this.C.a();
        }
        if (this.D.r()) {
            this.D.X0(true, false, false);
        }
        if (z2) {
            finish();
        }
    }

    public final void T7(String str) {
        runOnUiThread(new h0(str));
    }

    public final void T8() {
        if (this.H0.getVisibility() == 0) {
            String str = (this.G0 + 1) + "";
            if (this.G0 >= 99) {
                str = "99+";
            }
            this.I0.setText(String.format(ah4.e(R.string.chat_new_message_icon), str));
        }
    }

    @Override // dc.sa2
    public HashMap<String, GifImageView> U3() {
        return this.g0.a;
    }

    public final void U6(boolean z2) {
        UserSetting userSettingZ;
        if (na2.m().i()) {
            T6(false);
        }
        ob2.o().H(0);
        if (z2) {
            ob2.o().k();
            this.application.q("date_end", null);
        }
        this.z.deleteFriendType(32);
        if (this.q1) {
            InDateActivityEvent inDateActivityEvent = new InDateActivityEvent();
            inDateActivityEvent.flag = 5;
            inDateActivityEvent.data = this.z;
            inDateActivityEvent.datingId = ob2.i;
            ob2.i = null;
            EventBus.getDefault().post(inDateActivityEvent);
        } else {
            ob2.i = null;
            if (this.z.isOnlyFriendType(4) && (userSettingZ = WearUtils.y.z(this.z.getId())) != null && !userSettingZ.isFriendsRequestClick()) {
                df3.e().a(this.z.getId());
            }
        }
        pj3.f(this, MainActivity.class);
        finish();
    }

    public final boolean U7(CommunMessage communMessage) {
        return zb2.O().l0(communMessage);
    }

    public void U8(TextView textView, Presence.Mode mode) {
        Drawable drawableD;
        if (mode == Presence.Mode.chat) {
            drawableD = th4.d(this, R.drawable.status_available);
        } else if (mode == Presence.Mode.dnd) {
            drawableD = th4.d(this, R.drawable.status_busy);
        } else {
            Presence.Mode mode2 = Presence.Mode.away;
            drawableD = null;
        }
        if (drawableD != null) {
            drawableD.setBounds(0, 0, ce3.a(this, 8.0f), ce3.a(this, 8.0f));
        }
        textView.setCompoundDrawables(null, null, drawableD, null);
    }

    public void V2() {
        if (!M6() || WearUtils.e1(this.x)) {
            return;
        }
        if (this.A == null) {
            Account accountU = WearUtils.y.u();
            this.A = accountU;
            if (accountU == null) {
                finish();
                return;
            }
        }
        this.w.setVisibility(8);
        X6();
        this.B.O0(this.z);
        this.C.e1(this.z);
        ChatGroupControl.o1().w2(this.z);
        d7();
    }

    public final void V6(CommunMessage communMessage) {
        if (communMessage == null) {
            return;
        }
        while (!this.W0) {
            for (int i2 = 0; i2 < this.j0.size(); i2++) {
                if (communMessage.getId().equals(this.j0.get(i2).getId()) || communMessage.getId().equals(this.j0.get(i2).getReceiveId()) || ((!WearUtils.e1(communMessage.getReceiveId()) && communMessage.getReceiveId().equals(this.j0.get(i2).getReceiveId())) || (!WearUtils.e1(communMessage.getReceiveId()) && communMessage.getReceiveId().equals(this.j0.get(i2).getId())))) {
                    this.W0 = true;
                    this.X0 = i2;
                    return;
                }
            }
            CommunMessageDao communMessageDao = DaoUtils.getCommunMessageDao();
            String strP = WearUtils.y.p();
            String str = this.y;
            int i3 = this.l0 + 1;
            this.l0 = i3;
            List<CommunMessage> listFindByPage = communMessageDao.findByPage(strP, str, i3, 10);
            if (listFindByPage == null || listFindByPage.size() == 0) {
                this.l0--;
                this.X0 = -1;
                sg3.l(ah4.e(R.string.quoted_content_deleted));
                return;
            }
            for (CommunMessage communMessage2 : listFindByPage) {
                if (be3.E(communMessage2.getCreated(), communMessage2.getSendStatus())) {
                    communMessage2.setSendStatus(4);
                }
                communMessage2.setDataBean(communMessage2.syncDecryptBean());
            }
            int size = this.j0.size();
            this.j0.addAll(EntityUnSupport.filterMessages(listFindByPage));
            W7(size, this.j0.size() - size);
            for (int i4 = 0; i4 < this.j0.size(); i4++) {
                if (communMessage.getId().equals(this.j0.get(i4).getId()) || communMessage.getId().equals(this.j0.get(i4).getReceiveId()) || ((!WearUtils.e1(communMessage.getReceiveId()) && communMessage.getReceiveId().equals(this.j0.get(i4).getReceiveId())) || (!WearUtils.e1(communMessage.getReceiveId()) && communMessage.getReceiveId().equals(this.j0.get(i4).getId())))) {
                    this.W0 = true;
                    this.X0 = i4;
                    return;
                }
            }
        }
    }

    public final void V7() {
        if (this.z.getChatType() != Presence.Type.unavailable) {
            return;
        }
        S8(1, false);
        S8(0, false);
    }

    @Override // com.wear.widget.chatMic.VoiceMessagePanelView.b
    public void W2() throws IllegalStateException, IOException {
        if (E()) {
            return;
        }
        this.w1 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(WearUtils.T("mic").getAbsolutePath());
        sb.append("/");
        sb.append(WearUtils.B(System.currentTimeMillis() + ".acc"));
        String string = sb.toString();
        this.o0 = string;
        boolean zW = this.n0.w(string);
        this.Z.p(this.n0.o());
        if (zW) {
            return;
        }
        sg3.i(this, R.string.chat_record_failure);
    }

    @Override // dc.sa2
    public void W3() {
        this.l1 = true;
    }

    public String W6(String str) {
        if (WearUtils.e1(str)) {
            return str;
        }
        String strF = nd3.f(str);
        return WearUtils.e1(strF) ? str : strF;
    }

    public final void W7(int i2, int i3) {
        runOnMainThread(new r0(i2, i3));
    }

    @Override // dc.sa2
    public void X2() {
        int iG = dh3.g(this.z);
        if (pc1.a.P().size() > 2) {
            CommunMessage communMessage = new CommunMessage();
            communMessage.setFrom(WearUtils.y.p());
            communMessage.setTo(this.y);
            communMessage.setUserId(ch3.n().p());
            if (iG == 1) {
                EntitySystem entitySystem = new EntitySystem();
                entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C666.toString(), ah4.e(R.string.update_app_notice3));
                communMessage.sendEntity(entitySystem);
                communMessage.setId(WearUtils.E());
                if (U7(communMessage)) {
                    DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
                    E0(communMessage);
                    return;
                }
                return;
            }
            if (iG == 2) {
                EntitySystem entitySystem2 = new EntitySystem();
                EntitySystem.SystemOPTType systemOPTType = EntitySystem.SystemOPTType.T200;
                String string = systemOPTType.toString();
                EntitySystem.SystemOPTCode systemOPTCode = EntitySystem.SystemOPTCode.C666;
                entitySystem2.addDataToArray(string, systemOPTCode.toString(), ah4.e(R.string.update_app_notice2));
                communMessage.sendEntity(entitySystem2);
                communMessage.setId(WearUtils.E());
                if (U7(communMessage)) {
                    DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
                    E0(communMessage);
                }
                CommunMessage communMessage2 = new CommunMessage();
                communMessage2.setFrom(WearUtils.y.p());
                communMessage2.setTo(this.y);
                communMessage2.setUserId(ch3.n().p());
                EntitySystem entitySystem3 = new EntitySystem();
                entitySystem3.addDataToArray(systemOPTType.toString(), systemOPTCode.toString(), ah4.e(R.string.update_app_notice1));
                communMessage2.sendEntity(entitySystem3);
                communMessage2.setId(WearUtils.E());
                v8(communMessage2, MessageType.system);
            }
        }
    }

    public final void X6() {
        ChatActionMenuFragmentBottom chatActionMenuFragmentBottom = this.b1;
        if (chatActionMenuFragmentBottom != null && chatActionMenuFragmentBottom.isVisible()) {
            this.b1.dismiss();
        }
        Dialog dialog = this.v1;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.v1.dismiss();
    }

    public final void X7(View view) {
        setVolumeControlStream(3);
        if (this.P) {
            Z7();
        } else {
            a8();
        }
    }

    public final void Y6() {
        ChatLiveControl.q0().v0();
        ChatSyncControl.N0().R0();
    }

    public final void Y7(boolean z2) {
        this.b0.setVisibility(z2 ? 0 : 8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Z.getChatMessageContainer().getLayoutParams();
        layoutParams.addRule(16, z2 ? R.id.chat_pictures : R.id.chat_send);
        this.Z.getChatMessageContainer().setLayoutParams(layoutParams);
        this.Z.getChat_voice().setVisibility(z2 ? 0 : 4);
        this.Z.getChatSend().setVisibility(z2 ? 8 : 0);
    }

    @Override // com.wear.adapter.longdistance.MessageNewAdapter.t0
    public void Z1() {
        vg3.b().a(new Runnable() { // from class: dc.r42
            @Override // java.lang.Runnable
            public final void run() {
                this.a.D7();
            }
        });
    }

    @Override // dc.sa2
    public void Z2() {
        this.delayHandler.postDelayed(new q(), 500L);
        CommunMessage communMessage = this.n1;
        if (communMessage != null) {
            H8(communMessage);
            this.n1 = null;
        }
    }

    @Override // dc.sa2
    public void Z3() {
        this.l1 = false;
        if (this.m1) {
            this.m1 = false;
            if (ke3.a("new_user", "isFirstSend")) {
                new LoveEmojisDialog(this.activity).show();
            }
        }
        CommunMessage communMessage = this.n1;
        if (communMessage != null) {
            H8(communMessage);
            this.n1 = null;
        }
    }

    public final void Z6(boolean z2) {
        if (z2) {
            this.H0.setVisibility(0);
        } else {
            this.H0.setVisibility(8);
        }
    }

    public final void Z7() {
        this.P = false;
        ue3.a(this.o, this);
        this.w.setVisibility(8);
        boolean z2 = this.O;
        if (!z2) {
            this.O = !z2;
            this.o.setVisibility(0);
        }
        this.c0.setImageResource(R.drawable.chat_function_keyboard);
        this.s0.I();
        this.o.requestFocus();
        this.f0.setVisibility(0);
        this.q.setVisibility(0);
        this.s.setVisibility(0);
        this.r0.postDelayed(new y(), 100L);
        I8();
        if (this.f1 != null && this.g1) {
            i8(null);
        } else if (this.K) {
            m8();
        }
    }

    @Override // com.wear.widget.chatMic.VoiceMessagePanelView.b
    public void a1() throws IllegalStateException {
        this.n0.H();
        long jCurrentTimeMillis = (System.currentTimeMillis() - this.w1) / 1000;
        if (jCurrentTimeMillis < 1) {
            sg3.i(this, R.string.chat_voice_timeShort);
            O();
            return;
        }
        if (!WearUtils.e1(this.o0) && new File(this.o0).exists()) {
            EntityAudio entityAudio = new EntityAudio();
            entityAudio.setLocalUrl(this.o0);
            if (jCurrentTimeMillis > 60) {
                jCurrentTimeMillis = 60;
            }
            entityAudio.setTime(jCurrentTimeMillis);
            CommunMessage communMessage = new CommunMessage();
            communMessage.setFrom(WearUtils.y.p());
            communMessage.setTo(this.y);
            communMessage.setUserId(WearUtils.y.p());
            communMessage.sendEntity(entityAudio);
            communMessage.setId(WearUtils.E());
            if (U7(communMessage)) {
                DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
                E0(communMessage);
            }
            p8(communMessage);
        }
    }

    public final void a7() {
        if (this.u0.getVisibility() == 0) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(250L);
            View view = this.u0;
            if (view != null) {
                view.startAnimation(alphaAnimation);
                this.u0.setVisibility(8);
            }
        }
    }

    public final void a8() {
        j8();
        if (this.f1 == null || !this.g1) {
            this.r0.postDelayed(new x(), 100L);
        }
    }

    @Override // dc.jv1
    public void addViewToActivity(View view) {
        if (System.currentTimeMillis() - this.T < 100) {
            return;
        }
        this.T = System.currentTimeMillis();
        this.w.removeAllViews();
        this.w.setVisibility(4);
        this.parentHandler.postDelayed(new y0(view), 10L);
    }

    @Override // dc.sa2
    public String b0() {
        String str = this.y;
        return str == null ? "" : str;
    }

    @Override // dc.ah3
    public void b3(String str, CommunMessage communMessage, int i2) {
        s8(str, communMessage, i2);
        if (i2 == 0) {
            G6(r2.getSize(), (communMessage.getDataBean() instanceof EntityBurnShortVideo ? (EntityBurnShortVideo) communMessage.getDataBean() : (EntityShortVideo) communMessage.getDataBean()).getDuration(), 2);
        }
    }

    public final void b7() {
        this.s1.setScaleType(di1.FIT_CENTER);
        this.s1.setAnimListener(new a1());
    }

    public final void b8() {
        File file = new File(WearUtils.b(this, "festival_animation.mp4"));
        if (!file.exists()) {
            sg3.l("文件播放错误");
            return;
        }
        this.i0.setVisibility(8);
        this.h0.setVisibility(8);
        this.t1.setVisibility(0);
        this.u1.setVisibility(0);
        this.s1.setVisibility(0);
        this.s1.k(file);
    }

    @Override // dc.xb2
    public void c0(String str, String str2) {
        Iterator<CommunMessage> it = this.j0.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            CommunMessage next = it.next();
            if (next.getId().equals(str2) && next.getType() == MessageType.pattern) {
                if (next.getDataBean() instanceof EntityPattern) {
                    ((EntityPattern) next.getDataBean()).setIsAutoPlay(true);
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override // dc.ah3
    public void c1(CommunMessage communMessage) {
        E0(communMessage);
    }

    public void c7() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        N6();
        if (this.z == null) {
            this.z = WearUtils.y.v(this.x);
        }
        if (this.z == null) {
            return;
        }
        UserSettingsBean userSettingsBeanG = WearUtils.x.i.g(WearUtils.i0(this.x));
        if (userSettingsBeanG != null) {
            if (WearUtils.e1(userSettingsBeanG.getRemark()) || WearUtils.e1(userSettingsBeanG.getRemark().trim())) {
                this.z.setRemark("");
            } else {
                this.z.setRemark(userSettingsBeanG.getRemark().trim());
            }
        }
        String showNickName = this.z.getShowNickName();
        this.n.setTitle(showNickName);
        this.n.setToy(null);
        TextView labelStatus = this.n.getLabelStatus();
        labelStatus.setVisibility(0);
        if (!this.z.isOnline()) {
            this.n.setTitle(showNickName);
            U8(labelStatus, null);
        } else if (WearUtils.y1(this.z.getToyStatus())) {
            this.n.setToy(this.z.getLinkedToys2());
        }
        if (this.z.isOnline()) {
            U8(labelStatus, this.z.getStatusMode());
        }
        if (pf3.d(this)) {
            eg3.j(this, "SearchChatTip_" + ch3.n().r(), true);
            return;
        }
        this.n.setNewMessagePoint(true ^ eg3.d(this, "SearchChatTip_" + ch3.n().r(), false));
    }

    public final void c8(CommunMessage communMessage) {
        runOnMainThread(new m0(communMessage));
    }

    @Override // dc.sa2
    public List<CommunMessage> d0() {
        return this.j0;
    }

    public final void d7() {
        User user;
        S8(0, false);
        S8(1, false);
        if (M6()) {
            N6();
            if (this.z == null) {
                return;
            }
            if (j7()) {
                S8(0, true);
            }
            if (this.A == null || !WearUtils.y1(this.z.getToyStatus()) || (user = this.z) == null || !user.isOnline() || this.application.G().P().size() <= 0) {
                return;
            }
            S8(1, true);
        }
    }

    public final void d8() {
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        h1 h1Var = new h1(this, null);
        this.U = h1Var;
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(h1Var, intentFilter, 2);
        } else {
            registerReceiver(h1Var, intentFilter);
        }
    }

    public final void e7(String str) {
        if (str == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("ACTION_TOY_UPDATE");
            try {
                if (this.m0 != null) {
                    LocalBroadcastManager.getInstance(WearUtils.x).unregisterReceiver(this.m0);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.m0 = new ChatMessageBroadcastReceiver(this, this.application);
            LocalBroadcastManager.getInstance(WearUtils.x).registerReceiver(this.m0, intentFilter);
        }
        this.F = 0;
        CommunMessage communMessageH = df3.e().h(this.y);
        this.t0 = communMessageH;
        if (communMessageH != null) {
            this.F = DaoUtils.getCommunMessageDao().findUnReadSize(WearUtils.y.p(), this.y, 0, 10, this.t0.getCreated(), false);
        }
        this.q0 = DaoUtils.getMessageHideDao().getHidesToMap(WearUtils.y.p(), this.y);
        f7();
        V2();
    }

    public void e8() {
        if (this.Q == R.id.chat_more_video) {
            if (!so3.J()) {
                M8(ah4.e(R.string.str_video_unavlidate));
                return;
            } else if (!WearUtils.x.i.D(this.y, true)) {
                if (this.D.z()) {
                    return;
                }
                this.D.L(this.z);
                this.D.V1(true, new ChatVideoControl.e0() { // from class: dc.e52
                    @Override // com.wear.main.longDistance.control.ChatVideoControl.e0
                    public final void a(String str) {
                        this.a.F7(str);
                    }
                });
            }
        }
        int i2 = this.Q;
        if (i2 != R.id.chat_more_voice) {
            if (i2 == R.id.chat_more_sendPicture) {
                L8();
            }
        } else if (!so3.J()) {
            M8(ah4.e(R.string.str_voice_unavlidate));
        } else {
            if (WearUtils.x.i.D(this.y, true) || this.D.z()) {
                return;
            }
            this.D.L(this.z);
            this.D.V1(false, new ChatVideoControl.e0() { // from class: dc.f52
                @Override // com.wear.main.longDistance.control.ChatVideoControl.e0
                public final void a(String str) {
                    this.a.H7(str);
                }
            });
        }
    }

    public final void f7() {
        User user;
        this.l0 = 0;
        ArrayList<CommunMessage> arrayList = new ArrayList();
        if (this.f1 == null) {
            List<CommunMessage> listFindByPage = DaoUtils.getCommunMessageDao().findByPage(WearUtils.y.p(), this.y, 0, 10);
            if (listFindByPage != null && listFindByPage.size() > 0) {
                arrayList.addAll(listFindByPage);
            }
        } else {
            List<CommunMessage> listFindAfterMessage = DaoUtils.getCommunMessageDao().findAfterMessage(WearUtils.y.p(), this.y, this.f1, 10);
            if (listFindAfterMessage != null && listFindAfterMessage.size() > 0) {
                arrayList.addAll(listFindAfterMessage);
            }
            this.g1 = arrayList.size() == 10;
            arrayList.add(this.f1);
        }
        for (CommunMessage communMessage : arrayList) {
            if (communMessage.getType() == MessageType.shortvideo || communMessage.getType() == MessageType.burnvideo) {
                new fk3(this.y, communMessage.syncDecryptBean() instanceof EntityBurnShortVideo, communMessage.getId()).I(this);
            } else if (be3.E(communMessage.getCreated(), communMessage.getSendStatus())) {
                communMessage.setSendStatus(4);
            }
            communMessage.setDataBean(communMessage.syncDecryptBean());
        }
        this.j0.clear();
        this.j0.addAll(EntityUnSupport.filterMessages(arrayList));
        if (this.F > 0) {
            R8();
            if (this.u0.getTag() == null && this.F > 10) {
                View view = this.u0;
                view.setTag(Integer.valueOf(view.getId()));
                String str = "" + this.F;
                if (this.F > 99) {
                    str = "99+";
                }
                this.v0.setText(String.format(ah4.e(R.string.chat_new_message_icon), str));
                N8();
                this.u0.setOnClickListener(new r());
            }
            List<CommunMessage> listFindUnReadByPage = DaoUtils.getCommunMessageDao().findUnReadByPage(WearUtils.y.p(), this.y, this.l0 + 1, 10, this.F);
            for (int i2 = 0; i2 < listFindUnReadByPage.size(); i2++) {
                CommunMessage communMessage2 = listFindUnReadByPage.get(i2);
                if (be3.E(communMessage2.getCreated(), communMessage2.getSendStatus())) {
                    communMessage2.setSendStatus(4);
                }
                communMessage2.setDataBean(communMessage2.syncDecryptBean());
            }
            this.j0.addAll(EntityUnSupport.filterMessages(listFindUnReadByPage));
            final int i3 = -1;
            int i4 = 0;
            while (true) {
                if (i4 >= this.j0.size()) {
                    break;
                }
                CommunMessage communMessage3 = this.j0.get(i4);
                CommunMessage communMessage4 = this.t0;
                if (communMessage4 != null && communMessage4.getId().equals(communMessage3.getId())) {
                    i3 = i4;
                    break;
                }
                i4++;
            }
            this.parentHandler.post(new Runnable() { // from class: dc.w42
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.p7(i3);
                }
            });
            this.l0 += (listFindUnReadByPage.size() / 10) + (listFindUnReadByPage.size() % 10 > 0 ? 1 : 0);
        }
        if (this.t0 != null && this.F > 0 && (user = this.z) != null && !user.isDateIng()) {
            df3.e().d(this.y);
        }
        if (this.F <= 10) {
            this.F = 0;
        }
        MessageNewAdapter messageNewAdapter = this.g0;
        messageNewAdapter.d = false;
        messageNewAdapter.notifyDataSetChanged();
        CommunMessage communMessage5 = this.f1;
        if (communMessage5 == null) {
            this.M.scrollToPosition(0);
        } else {
            o8(this.j0.indexOf(communMessage5));
        }
        L6(true);
    }

    public void f8(CommunMessage communMessage) {
        try {
            if (!hf3.d(this)) {
                sg3.i(this, R.string.common_settingTip);
                w8(communMessage, true);
                return;
            }
            if (MyApplication.P && hu3.x() != null) {
                switch (c1.a[communMessage.getType().ordinal()]) {
                    case 1:
                        y8(communMessage, MessageType.chat, true);
                        break;
                    case 2:
                    case 7:
                        EntityShortVideo entityShortVideo = (EntityShortVideo) DaoUtils.getCommunMessageDao().findById(communMessage.getId()).syncDecryptBean();
                        String videoLocalUrl = entityShortVideo.getVideoLocalUrl();
                        if (!WearUtils.e1(videoLocalUrl) && !new File(videoLocalUrl).exists() && !videoLocalUrl.startsWith(CommonUtility.PREFIX_URI)) {
                            sg3.e(this, R.string.chat_message_item_save_error);
                            break;
                        } else {
                            if (!WearUtils.e1(entityShortVideo.getPicUrl()) && !WearUtils.e1(entityShortVideo.getVideoUrl())) {
                                communMessage.setSendStatus(2);
                                communMessage.setCreated(be3.u());
                                DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
                                R7(communMessage);
                                s8("", communMessage, 0);
                                break;
                            }
                            fk3 fk3Var = new fk3(this.y, entityShortVideo instanceof EntityBurnShortVideo, communMessage.getId());
                            MediaFile mediaFile = new MediaFile();
                            mediaFile.m(videoLocalUrl);
                            mediaFile.h(entityShortVideo.getDuration());
                            fk3Var.I(this);
                            this.j0.remove(communMessage);
                            fk3Var.executeOnExecutor(vg3.b().c(), mediaFile);
                            communMessage.setSendStatus(2);
                            this.g0.notifyItemChanged(this.j0.indexOf(communMessage));
                            break;
                        }
                        break;
                    case 3:
                        p8(communMessage);
                        break;
                    case 4:
                    case 6:
                        EntityPicture entityPicture = (EntityPicture) DaoUtils.getCommunMessageDao().findById(communMessage.getId()).syncDecryptBean();
                        boolean zIsEmpty = TextUtils.isEmpty(entityPicture.getOriginalPath());
                        String localUrl = zIsEmpty ? entityPicture.getLocalUrl() : entityPicture.getOriginalPath();
                        if (!WearUtils.e1(localUrl) && WearUtils.e1(entityPicture.getUrl())) {
                            boolean z2 = entityPicture instanceof EntityBurnPicture;
                            File fileZ = zIsEmpty ? !WearUtils.e1(entityPicture.getType()) && entityPicture.getType().equals("emoji") ? WearUtils.Z(localUrl).exists() ? WearUtils.Z(localUrl) : WearUtils.a0(localUrl) : WearUtils.c0(localUrl) : new File(localUrl);
                            if (entityPicture instanceof EntityBurnPicture) {
                                ((EntityBurnPicture) entityPicture).setBurn(false);
                            }
                            fk3 fk3Var2 = new fk3(this.y, z2, communMessage.getId());
                            MediaFile mediaFile2 = new MediaFile();
                            mediaFile2.m(fileZ.getAbsolutePath());
                            mediaFile2.k(entityPicture.getMediaId());
                            fk3Var2.I(this);
                            this.j0.remove(communMessage);
                            fk3Var2.executeOnExecutor(vg3.b().c(), mediaFile2);
                            communMessage.setSendStatus(2);
                            break;
                        } else {
                            communMessage.setSendStatus(2);
                            communMessage.setCreated(be3.u());
                            DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
                            R7(communMessage);
                            q8(entityPicture.getUrl(), communMessage, 0);
                            break;
                        }
                        break;
                    case 5:
                        EntityPattern entityPattern = (EntityPattern) communMessage.getDataBean();
                        if (!WearUtils.e1(entityPattern.getLocalUrl())) {
                            File file = new File(nd3.i(entityPattern.getLocalUrl()));
                            if (!file.exists()) {
                                P();
                                break;
                            } else {
                                communMessage.setSendStatus(2);
                                communMessage.setCreated(be3.u());
                                DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
                                R7(communMessage);
                                rf3.s(file, new v0(entityPattern, communMessage));
                                break;
                            }
                        } else {
                            P();
                            break;
                        }
                }
                return;
            }
            sg3.i(this, R.string.message_send_error);
            w8(communMessage, true);
        } catch (Exception e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e2);
            sg3.e(this, R.string.chat_message_item_save_error);
        }
    }

    public final void g7(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intent intent = getIntent();
        this.j1 = intent.getBooleanExtra("isFinishToLongDistance", false);
        this.x = WearUtils.e1(str) ? intent.getStringExtra("userId") : str;
        String str2 = "userId2=====" + str;
        DaoUtils.getSensitiveWordDao().setChatRoomSensitive(DaoUtils.getChatRoomSensitiveDao().findItemByRoomId(this.x));
        String strI0 = WearUtils.i0(this.x);
        this.y = strI0;
        me3.c cVar = this.p1 ? me3.c.DATING_CHAT_UI_ENTER : me3.c.PRIVATE_CHAT_UI_ENTER;
        User user = this.z;
        me3.d(cVar, new FirebasePrivateChatInfo(strI0, user != null ? user.getLinkedToys2() : null).toString());
        ye3.c("friend chatroom", "into page", this.y);
        this.z = WearUtils.y.v(this.x);
        N6();
        if (this.z == null) {
            return;
        }
        c7();
        this.z.setAddMessage(false);
        if (!this.z.isDateIng()) {
            this.p1 = false;
            df3.e().c(this.x);
            this.n.setCanterShowFriendToy(false);
            this.n.setIconAction(Integer.valueOf(R.drawable.nav_profile_selector), new i());
            this.n.setBackAction(new MyActionBar.f() { // from class: dc.u42
                @Override // com.wear.widget.MyActionBar.f
                public final void performAction(View view) {
                    this.a.t7(view);
                }
            });
            return;
        }
        this.p1 = true;
        this.x0.setVisibility(8);
        this.z0.setVisibility(0);
        this.z0.setOnClickListener(new View.OnClickListener() { // from class: dc.d52
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.r7(view);
            }
        });
        if (ob2.i == null) {
            this.z.deleteFriendType(32);
            finish();
        }
        this.n.setCanterShowFriendToy(true);
        this.n.setToysAction(new h(), false, this);
        this.n.n();
        ob2.o().l(this.z.getId());
    }

    public final void g8(CommunMessage communMessage) {
        try {
            this.j0.remove(communMessage);
            DaoUtils.getCommunMessageDao().delT(communMessage);
            notifyDataSetChanged();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // dc.tz1
    public int getPriority() {
        User user = this.z;
        if (user == null || this.A == null || !user.isDateIng()) {
            return 0;
        }
        return na2.m().i() ? 24 : 8;
    }

    @Override // dc.sa2
    public String getUserName() {
        return this.z.getShowNickName();
    }

    @Override // dc.ah3
    public void h0(String str, CommunMessage communMessage, int i2) {
        q8(str, communMessage, i2);
    }

    public void h7() {
        User user = this.z;
        if (user == null || !user.isOnline()) {
            S8(4, false);
            S8(5, false);
        } else if (dh3.e(this.z)) {
            S8(4, true);
            S8(5, true);
        } else {
            S8(4, false);
            S8(5, false);
        }
    }

    public void h8(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        MyApplication.v0(null);
        g7(str);
        e7(str);
        this.parentHandler.postDelayed(new g(), 200L);
    }

    @Override // dc.ah3
    public void i1(CommunMessage communMessage, int i2) {
        int iIndexOf;
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition;
        if (this.p == null || (iIndexOf = this.j0.indexOf(communMessage)) < 0 || (viewHolderFindViewHolderForAdapterPosition = this.p.findViewHolderForAdapterPosition(iIndexOf)) == null) {
            return;
        }
        if (viewHolderFindViewHolderForAdapterPosition instanceof MessageNewAdapter.ShortVideoSelfViewHolder) {
            String str = "position = " + iIndexOf + " ====== video progress = " + i2;
            ((MessageNewAdapter.ShortVideoSelfViewHolder) viewHolderFindViewHolderForAdapterPosition).e().setProgress(i2);
        } else if (viewHolderFindViewHolderForAdapterPosition instanceof MessageNewAdapter.PictureSelfViewHolder) {
            String str2 = "position = " + iIndexOf + " ====== picture progress = " + i2;
            ((MessageNewAdapter.PictureSelfViewHolder) viewHolderFindViewHolderForAdapterPosition).e().setProgress(i2);
        }
        if (i2 == 100) {
            this.g0.notifyItemChanged(iIndexOf, "sendStatus");
        }
    }

    public final boolean i7(CommunMessage communMessage) {
        String strS = communMessage.getDataBean() instanceof EntityChat ? this.s0.s(((EntityChat) communMessage.getDataBean()).getText(), true) : null;
        if (TextUtils.isEmpty(strS)) {
            return false;
        }
        if (!this.s0.B(strS)) {
            return true;
        }
        CommunMessage communMessage2 = this.D0;
        if (communMessage2 != null) {
            return !TextUtils.equals(this.D0.getFrom(), communMessage.getFrom()) && TextUtils.equals(strS, this.s0.s(((EntityChat) communMessage2.getDataBean()).getText(), true));
        }
        return false;
    }

    public final void i8(CommunMessage communMessage) {
        this.f1 = null;
        this.l0 = 0;
        List<CommunMessage> listFindByPage = DaoUtils.getCommunMessageDao().findByPage(WearUtils.y.p(), this.y, 0, 10);
        if (listFindByPage == null) {
            listFindByPage = new ArrayList<>();
        }
        int iIndexOf = -1;
        for (CommunMessage communMessage2 : listFindByPage) {
            if (be3.E(communMessage2.getCreated(), communMessage2.getSendStatus())) {
                communMessage2.setSendStatus(4);
            }
            communMessage2.setDataBean(communMessage2.syncDecryptBean());
            if (communMessage != null && TextUtils.equals(communMessage.getId(), communMessage2.getId())) {
                iIndexOf = listFindByPage.indexOf(communMessage2);
            }
        }
        if (iIndexOf != -1) {
            listFindByPage.set(iIndexOf, communMessage);
        }
        this.j0.clear();
        this.j0.addAll(EntityUnSupport.filterMessages(listFindByPage));
        this.g0.notifyDataSetChanged();
        m8();
    }

    public final boolean j7() {
        User user = this.z;
        if (user == null || !user.isOnline()) {
            return false;
        }
        return dh3.b(this.z) ? this.application.G().P().size() > 0 || WearUtils.y1(this.z.getToyStatus()) : WearUtils.y1(this.z.getToyStatus());
    }

    public final void j8() {
        this.P = true;
        this.c0.setImageResource(R.drawable.chat_function_emojis);
        I8();
        this.O = true;
        this.o.setVisibility(0);
        this.o.requestFocus();
        Y6();
        this.Z.n();
    }

    public void k8(int i2) {
        this.f0.setHeight(i2);
        this.e0.setHeight(i2);
    }

    @Override // dc.jv1
    public void l(IPeopleInfo iPeopleInfo) {
        if (iPeopleInfo == null || !TextUtils.equals(iPeopleInfo.getUserJid(), this.y)) {
            return;
        }
        K8();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void l8(boolean r11) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.main.longDistance.ChatActivity.l8(boolean):void");
    }

    @Override // dc.sa2
    public void m2(CommunMessage communMessage) {
        V6(communMessage);
        int i2 = this.X0;
        if (i2 != -1 && this.i1 < i2) {
            n8(i2);
        }
        this.X0 = -1;
        this.W0 = false;
    }

    public final void m8() {
        Z6(false);
        this.G0 = -1;
        this.F0 = true;
        this.parentHandler.postDelayed(new Runnable() { // from class: dc.b52
            @Override // java.lang.Runnable
            public final void run() {
                this.a.J7();
            }
        }, 100L);
    }

    @Override // dc.sa2
    public void n() {
        if (na2.m().h(this.z, MessageType.voice)) {
            String strF = dh3.f(this.z);
            if (!WearUtils.e1(strF)) {
                M8(strF);
                return;
            }
            db2.A().q(new z());
            hu3.T();
        }
    }

    @Override // com.wear.ui.chat.fragment.ChatActionMenuFragmentBottom.d
    public void n1(int i2) {
        if (i2 == 0) {
            I6("live");
            X2();
            v();
            return;
        }
        if (i2 == 1) {
            I6(SyncWsProtocol.DataBean.CONTROL_STATUS_SYNC_TYPE_KEY);
            X2();
            t();
            return;
        }
        if (i2 == 3) {
            I6("patterns");
            if (WearUtils.x.i.D(this.y, false)) {
                return;
            }
            startActivityForResult(new Intent(this, (Class<?>) PatternSendActivity.class), 18);
            return;
        }
        if (i2 == 4) {
            I6("video");
            if (!MyApplication.P) {
                sg3.k(this, ah4.e(R.string.common_settingTip));
                return;
            } else {
                X2();
                q();
                return;
            }
        }
        if (i2 == 5) {
            I6(EntityVideo.CHANGE_VOICE_MODEL_KEY);
            if (!MyApplication.P) {
                sg3.k(this, ah4.e(R.string.common_settingTip));
                return;
            } else {
                X2();
                n();
                return;
            }
        }
        if (i2 == 6) {
            I6(NotificationCompat.CATEGORY_ALARM);
            pj3.j(this, AlarmCreateActivity.class, "userId", this.x);
        } else {
            if (i2 != 7) {
                return;
            }
            I6("playback");
            Intent intent = new Intent(this, (Class<?>) DialogPatternsActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("userId", this.x);
            intent.putExtras(bundle);
            pj3.d(intent);
            startActivityForResult(intent, 18);
        }
    }

    public final void n8(int i2) {
        this.F0 = false;
        o8(i2);
    }

    @Override // dc.sa2, dc.xb2
    public void notifyDataSetChanged() {
        runOnMainThread(new p0());
    }

    @Override // dc.sa2
    public boolean o() {
        if (!WearUtils.x.i.k(this.y) && !WearUtils.x.i.p(this.y)) {
            this.d0.setVisibility(8);
            return false;
        }
        bo3 bo3Var = new bo3(this, R.layout.view_unblock_friends_tip);
        bo3Var.show();
        bo3Var.d(R.id.tv_unblock, new bo3.d() { // from class: dc.v42
            @Override // dc.bo3.d
            public final void a(int i2) {
                this.a.v7(i2);
            }
        });
        bo3Var.d(R.id.tv_cancel, null);
        return true;
    }

    @Override // dc.ie3.m
    public void o2(File file, String str, String str2, String str3) {
        Bitmap bitmapDecodeFile;
        if (o() || file == null || !file.exists() || (bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath())) == null) {
            return;
        }
        r8(bitmapDecodeFile.getHeight(), bitmapDecodeFile.getWidth(), str3, str, str2, file, false);
    }

    public void o8(int i2) {
        runOnMainThread(new o0(i2));
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        CommunMessage communMessage;
        List list;
        super.onActivityResult(i2, i3, intent);
        try {
            if (i2 == 18) {
                if (intent != null) {
                    String stringExtra = intent.getStringExtra(ImagesContract.URL);
                    String stringExtra2 = intent.getStringExtra("time");
                    String stringExtra3 = intent.getStringExtra("name");
                    String stringExtra4 = intent.getStringExtra("toyFunc");
                    String stringExtra5 = intent.getStringExtra("patternId");
                    String stringExtra6 = intent.getStringExtra("localUrl");
                    String stringExtra7 = intent.getStringExtra("toyVersion");
                    int intExtra = intent.getIntExtra("isFromChat", 0);
                    if (rf3.c(stringExtra5)) {
                        if (intExtra == 1) {
                            xe2.L0().b(xe2.L0().K(stringExtra5));
                        }
                        EntityPattern entityPattern = new EntityPattern();
                        entityPattern.setFeature(stringExtra4);
                        entityPattern.setUrl(stringExtra);
                        entityPattern.setLocalUrl(nd3.u(stringExtra6));
                        entityPattern.setTime(CommunMessage.getTimeToSecond(stringExtra2));
                        entityPattern.setToyVersion(stringExtra7);
                        if (WearUtils.e1(stringExtra3)) {
                            stringExtra3 = ah4.e(R.string.chat_pattern_by_create_default_name);
                        }
                        entityPattern.setName(stringExtra3);
                        if (!WearUtils.e1(stringExtra)) {
                            addAnalyticsEventId("chat_pattern", null);
                        }
                        u8(entityPattern, MessageType.pattern, WearUtils.e1(stringExtra));
                        return;
                    }
                    return;
                }
                return;
            }
            if (i2 == 19) {
                if (i3 == -1 && intent != null && (communMessage = this.S) != null) {
                    g8(communMessage);
                }
                this.S = null;
                return;
            }
            if (i2 == 23) {
                if (intent == null) {
                    return;
                }
                this.A0 = intent.getStringArrayListExtra("selectItems");
                this.B0 = intent.getParcelableArrayListExtra("selectMediaFile");
                boolean booleanExtra = intent.getBooleanExtra("isBurnAfterReading", false);
                Iterator<MediaFile> it = this.B0.iterator();
                while (it.hasNext()) {
                    MediaFile next = it.next();
                    fk3 fk3Var = new fk3(this.y, booleanExtra, WearUtils.E());
                    fk3Var.I(this);
                    fk3Var.executeOnExecutor(vg3.b().c(), next);
                }
                ArrayList<MediaFile> arrayList = this.B0;
                if (arrayList == null || arrayList.size() <= 1) {
                    return;
                }
                Iterator<MediaFile> it2 = this.B0.iterator();
                while (it2.hasNext()) {
                    if (it2.next().b() == 0) {
                        this.C0++;
                    }
                }
                if (this.C0 > 1) {
                    F6();
                    this.C0 = 0;
                    return;
                }
                return;
            }
            if (i2 == 24) {
                C2(this.o1);
                Z3();
                this.w0 = true;
                return;
            }
            if (i2 == 32) {
                if (i3 == -1) {
                    int intExtra2 = intent.getIntExtra("takeType", 0);
                    boolean booleanExtra2 = intent.getBooleanExtra("isBurnAfterReading", false);
                    if (intExtra2 == 0) {
                        String stringExtra8 = intent.getStringExtra("imagePath");
                        MediaFile mediaFile = new MediaFile();
                        mediaFile.m(stringExtra8);
                        fk3 fk3Var2 = new fk3(this.y, booleanExtra2, WearUtils.E());
                        fk3Var2.I(this);
                        fk3Var2.execute(mediaFile);
                        return;
                    }
                    String stringExtra9 = intent.getStringExtra("recordFilePath");
                    int intExtra3 = intent.getIntExtra(TypedValues.TransitionType.S_DURATION, 0);
                    MediaFile mediaFile2 = new MediaFile();
                    mediaFile2.m(stringExtra9);
                    mediaFile2.h(intExtra3);
                    fk3 fk3Var3 = new fk3(this.y, booleanExtra2, WearUtils.E());
                    fk3Var3.I(this);
                    fk3Var3.execute(mediaFile2);
                    return;
                }
                return;
            }
            if (i2 == 545) {
                this.s0.K();
                return;
            }
            if (i2 == 888) {
                if (intent == null || intent.getExtras() == null || intent.getSerializableExtra("communMessage") == null) {
                    return;
                }
                CommunMessage communMessage2 = (CommunMessage) intent.getSerializableExtra("communMessage");
                this.R = communMessage2;
                if (communMessage2 != null) {
                    Iterator<CommunMessage> it3 = this.j0.iterator();
                    while (it3.hasNext()) {
                        CommunMessage next2 = it3.next();
                        if (TextUtils.equals(next2.getId(), communMessage2.getId())) {
                            C2(next2);
                            Z3();
                            this.w0 = true;
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            if (i2 != 999) {
                if (i2 != 1088) {
                    if (i2 != 28784) {
                        return;
                    }
                    this.w0 = true;
                    return;
                } else {
                    if (i3 == -1) {
                        boolean booleanExtra3 = intent.getBooleanExtra("grant_all", false);
                        intent.getIntArrayExtra("grant_results");
                        if (booleanExtra3) {
                            return;
                        }
                        new kn3((Context) this, ah4.e(R.string.app_open_must_permission), ah4.e(R.string.common_confirm), ah4.e(R.string.common_cancel), true, (kn3.d) new j0()).show();
                        return;
                    }
                    return;
                }
            }
            if (i3 == -1) {
                if (intent.getBooleanExtra("delect", false) && intent.getSerializableExtra("communMessage") != null && (list = (List) intent.getSerializableExtra("communMessage")) != null && list.size() > 0) {
                    for (int i4 = 0; i4 < this.j0.size(); i4++) {
                        for (int i5 = 0; i5 < list.size(); i5++) {
                            if (((CommunMessage) list.get(i5)).toString().equals(this.j0.get(i4).toString())) {
                                DaoUtils.getCommunMessageDao().delT(this.j0.get(i4));
                                this.j0.remove(i4);
                                this.g0.notifyDataSetChanged();
                                this.g0.notifyItemChanged(i4);
                            }
                        }
                    }
                }
                if (intent.getBooleanExtra("recall", false) && intent.getSerializableExtra("recallCommunMessage") != null) {
                    List list2 = (List) intent.getSerializableExtra("recallCommunMessage");
                    if (list2 != null && list2.size() > 0) {
                        for (int i6 = 0; i6 < this.j0.size(); i6++) {
                            for (int i7 = 0; i7 < list2.size(); i7++) {
                                if (((CommunMessage) list2.get(i7)).toString().equals(this.j0.get(i6).toString())) {
                                    EntitySystem entitySystem = new EntitySystem();
                                    entitySystem.addDataToArray(EntitySystem.SystemOPTType.T300.toString(), EntitySystem.SystemOPTCode.C320.toString(), this.j0.get(i6).getId());
                                    this.j0.get(i6).sendEntity(entitySystem);
                                    DaoUtils.getCommunMessageDao().update((CommunMessageDao) this.j0.get(i6));
                                    DaoUtils.getReCallDao().delById(this.j0.get(i6).getId());
                                    if (this.j0.get(i6).isFromGroup()) {
                                        CommunMessage communMessage3 = new CommunMessage();
                                        communMessage3.setFrom(WearUtils.y.p());
                                        communMessage3.setTo(this.j0.get(i6).getTo());
                                        communMessage3.sendEntity(entitySystem);
                                        communMessage3.setId(WearUtils.E());
                                        zb2.O().G0(communMessage3.getTo(), communMessage3, false, null);
                                    } else {
                                        zb2.O().F0(WearUtils.x, this.j0.get(i6).getTo(), entitySystem);
                                    }
                                }
                            }
                        }
                    }
                    this.g0.notifyDataSetChanged();
                }
                if (!intent.getBooleanExtra("hide", false) || intent.getSerializableExtra("hideMap") == null) {
                    return;
                }
                Map<? extends String, ? extends String> map = (Map) intent.getSerializableExtra("hideMap");
                this.q0.clear();
                this.q0.putAll(map);
                this.g0.notifyDataSetChanged();
            }
        } catch (Exception e2) {
            if (16 == i2 || 18 == i2) {
                sg3.i(this, R.string.send_failure);
            }
            e2.printStackTrace();
        }
    }

    @Override // com.wear.xmpp.FragmentStateLossActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.t.getVisibility() == 0) {
            this.t.setVisibility(8);
        } else {
            if (this.z.isDateIng()) {
                return;
            }
            if (this.j1) {
                pj3.k(this, MainActivity.class, "isFinishToLongDistance", true);
            }
            J8(new l0());
        }
    }

    @Override // com.wear.BaseActivity, dc.cs3.b
    public void onCancel() {
        super.onCancel();
        ep1.b().m(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Y6();
        switch (view.getId()) {
            case R.id.chat_emojis /* 2131362311 */:
                if (!ah0.a) {
                    this.Z.f();
                    X7(view);
                    break;
                }
                break;
            case R.id.chat_more /* 2131362327 */:
                if (!ah0.a && !o()) {
                    this.b1.show(getSupportFragmentManager(), "chatActionMenuFragmentBottom");
                    break;
                }
                break;
            case R.id.chat_pictures /* 2131362338 */:
                I6("album");
                if (!WearUtils.x.i.D(this.y, false)) {
                    K6(R.id.chat_more_sendPicture);
                    break;
                }
                break;
            case R.id.chat_send /* 2131362343 */:
                z8();
                break;
        }
    }

    @Override // com.wear.activity.qrcode.QRCodeActivity, com.wear.xmpp.FragmentStateLossActivity, com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"ClickableViewAccessibility"})
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        getWindow().setFlags(Integer.MIN_VALUE, Integer.MIN_VALUE);
        setContentView(R.layout.long_chat);
        be3.J();
        setCurrentScreen(this, "long_distance_chat_screen_view", ChatActivity.class.getSimpleName());
        EventBus.getDefault().register(this);
        zb2.O().q(this);
        sz1.d().n(this);
        d8();
        this.H0 = findViewById(R.id.new_message_bar);
        this.I0 = (TextView) findViewById(R.id.new_message_notice);
        this.m = findViewById(R.id.screan_root_layout);
        MyActionBar myActionBar = (MyActionBar) findViewById(R.id.actionbar);
        this.n = myActionBar;
        myActionBar.setParentBackgroundColor(th4.b(this, R.color.lvs_ui_standard_systemBackground));
        this.z0 = (TextView) this.n.findViewById(R.id.tv_back);
        this.x0 = (ImageButton) this.n.findViewById(R.id.actionbar_back);
        View viewFindViewById = this.n.findViewById(R.id.rl_actionbar_back);
        this.y0 = viewFindViewById;
        viewFindViewById.setVisibility(0);
        ChatInputPanel chatInputPanel = (ChatInputPanel) findViewById(R.id.ac_chat_chatinputpanel);
        this.Z = chatInputPanel;
        this.a0 = chatInputPanel.getChat_more();
        this.b0 = this.Z.getChatPicture();
        this.c0 = this.Z.getChat_emojis();
        this.o = this.Z.getChat_message();
        this.d0 = this.Z.getV_block_tip();
        this.U0 = (VelvoPreviewView) findViewById(R.id.velvo_preview);
        this.e0 = (ChatMorePanel) findViewById(R.id.ac_chat_chatmorepanel);
        ChatEmojisPanel chatEmojisPanel = (ChatEmojisPanel) findViewById(R.id.chat_emojis_panel);
        this.f0 = chatEmojisPanel;
        chatEmojisPanel.setVisibility(8);
        this.s = findViewById(R.id.chat_more_layer);
        this.L = (ViewGroup) findViewById(R.id.ac_chat_msg_container);
        this.s1 = (AnimView) findViewById(R.id.player_view);
        this.t1 = (FrameLayout) findViewById(R.id.fl_full_screen_animation);
        this.u1 = (ImageView) findViewById(R.id.iv_full_screen_animation);
        this.A = WearUtils.y.u();
        if (M6()) {
            this.s0.w(this, this, findViewById(R.id.chat_emojis_panel), this.o, (EmojisToastView) findViewById(R.id.chat_emojis_tosat_layer));
            e82 e82Var = new e82(this, this, this.n0, this.s0);
            this.E = e82Var;
            MessageNewAdapter messageNewAdapter = new MessageNewAdapter(this.j0, this, this, this.n0, e82Var, this.s0, this.o);
            this.g0 = messageNewAdapter;
            messageNewAdapter.setHasStableIds(true);
            this.g0.c = this;
            this.X = (ImageView) findViewById(R.id.chat_background);
            this.Y = findViewById(R.id.v_glass);
            this.c0.setTag(null);
            this.o.setHorizontallyScrolling(false);
            this.o.setMaxLines(5);
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.chat_message_list);
            this.p = recyclerView;
            try {
                RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
                Objects.requireNonNull(itemAnimator);
                ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
                this.p.getItemAnimator().setChangeDuration(0L);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.q = findViewById(R.id.chat_bottom_layer);
            EmojisToastView emojisToastView = (EmojisToastView) findViewById(R.id.chat_emojis_tosat_layer);
            this.h0 = emojisToastView;
            emojisToastView.setVisibility(8);
            this.i0 = (LottieAnimationView) findViewById(R.id.lottie_view);
            if (this.b1 == null) {
                this.b1 = ChatActionMenuFragmentBottom.E(0);
            }
            this.b1.F(this);
            this.i0.e(new v());
            b7();
            this.J0 = this.Z.getLl_reply();
            this.M0 = this.Z.getTv_reply_name();
            this.N0 = this.Z.getTv_reply_content();
            this.K0 = this.Z.getIv_close_reply();
            this.P0 = this.Z.getMiv_reply_user_picture();
            this.Q0 = this.Z.getMiv_reply_user_video_picture();
            this.O0 = this.Z.getReply_voice_time();
            this.R0 = this.Z.getRl_reply_video();
            this.S0 = this.Z.getLl_reply_voice();
            this.V0 = this.Z.getReply_voice_icon();
            this.K0.setOnClickListener(new g0());
            this.t = findViewById(R.id.pic_view_layer);
            this.u0 = findViewById(R.id.unread_bar);
            this.v0 = (TextView) findViewById(R.id.unread_notice);
            this.u = (SubsamplingScaleImageView) findViewById(R.id.pic_big_view);
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.pic_big_loading);
            this.v = progressBar;
            progressBar.setOnClickListener(new q0());
            this.o.setOnTouchListener(new b1());
            this.o.addTextChangedListener(new d1());
            this.o.setEmojisUtils(this.s0);
            this.a0.setOnClickListener(this);
            this.b0.setOnClickListener(this);
            this.c0.setOnClickListener(this);
            this.Z.getChatSend().setOnClickListener(this);
            CoustomLinearLayout coustomLinearLayout = (CoustomLinearLayout) findViewById(R.id.chat_live_sync_layer);
            this.w = coustomLinearLayout;
            coustomLinearLayout.setListener(new e1());
            View viewFindViewById2 = findViewById(R.id.v_top_line);
            this.T0 = viewFindViewById2;
            viewFindViewById2.bringToFront();
            ChatLiveControl chatLiveControlQ0 = ChatLiveControl.q0();
            this.B = chatLiveControlQ0;
            chatLiveControlQ0.X0(this.U0);
            ChatSyncControl chatSyncControlN0 = ChatSyncControl.N0();
            this.C = chatSyncControlN0;
            chatSyncControlN0.A1(this.U0);
            this.C.w(this);
            this.B.w(this);
            this.D = ChatVideoControl.a1();
            this.M = cg3.e(this.p, this.g0);
            this.p.setOnTouchListener(new f1());
            this.p.addOnScrollListener(new g1());
            this.u.setOnClickListener(new a());
            String str = "userId5555555=====" + getIntent().getStringExtra("userId");
            h8(null);
            String str2 = "userId1=====" + getIntent().getStringExtra("userId");
            ImageWatcher imageWatcher = (ImageWatcher) findViewById(R.id.v_image_watcher);
            this.p0 = imageWatcher;
            imageWatcher.setTranslucentStatus(gg3.g(this));
            this.p0.setErrorImageRes(R.drawable.error_picture);
            this.p0.setOnPictureLongPressListener(this);
            this.p0.setLoader(new b(this));
            this.r0 = new Handler(Looper.getMainLooper());
            if (WearUtils.e1(DaoUtils.getTestValueDao().getValue(zt3.k, TestValueDao.CHAT_NOTE)) && !MyApplication.g0) {
                is3.b bVar = new is3.b(this.activity);
                bVar.n(ah4.e(R.string.dont_remind_button));
                bVar.o(ah4.e(R.string.common_ok));
                bVar.p(ah4.e(R.string.send_messgae_note));
                bVar.k(R.layout.dialog_chating_security);
                bVar.d(new c(this));
                bVar.c(new d(this));
                cs3.h(bVar).show();
            }
            l22.n().w(this);
            keyboardHelperInit(this.m, this.q, this.Z, this.f0, this.e0);
            this.Z.q(this);
            this.Z.s(this.L);
        }
    }

    @Override // com.wear.activity.qrcode.QRCodeActivity, com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() throws IllegalStateException {
        me3.c(me3.c.PRIVATE_CHAT_UI_EXIT);
        EventBus.getDefault().unregister(this);
        zb2.O().t0(this);
        sz1.d().s(this);
        this.n.s();
        if (this.m0 != null) {
            LocalBroadcastManager.getInstance(WearUtils.x).unregisterReceiver(this.m0);
        }
        if (!qf3.a || this.application.o) {
            qf3.t(null);
        } else {
            qf3.v(null, null);
        }
        this.j0.clear();
        ChatSyncControl.N0().O(null);
        ChatLiveControl.q0().O(null);
        CoustomLinearLayout coustomLinearLayout = this.w;
        if (coustomLinearLayout != null) {
            coustomLinearLayout.removeAllViews();
        }
        so3 so3Var = this.n0;
        if (so3Var != null && so3Var.s()) {
            h12.D.isPlayAudio = false;
            this.n0.G();
            this.n0.x();
            this.n0.F();
            if (!na2.m().i()) {
                this.application.G().u0();
            }
        }
        Handler handler = this.r0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        File file = this.V;
        if (file != null && file.exists()) {
            this.V.delete();
        }
        if (qe3.b.exists()) {
            qe3.b.delete();
        }
        this.V = null;
        this.g0 = null;
        this.p = null;
        unregisterReceiver(this.U);
        l22.n().w(null);
        super.onDestroy();
    }

    @Override // com.wear.xmpp.FragmentStateLossActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!this.p0.isShown() || i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        this.p0.B();
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(ReSendPatternEvent reSendPatternEvent) {
        this.g0.D1(reSendPatternEvent.getMessage(), reSendPatternEvent.getEntity());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(BlockClose blockClose) {
        if (blockClose == null || !blockClose.getEmail().equals(this.x)) {
            return;
        }
        this.N = true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEventCl(InputResizeEvent inputResizeEvent) {
        String str = "setMPadding InputResizeEvent ResizeHeight:" + inputResizeEvent.getResizeHeight();
        if (inputResizeEvent.getFlag() == 1) {
            this.Z.j(inputResizeEvent.getResizeHeight());
        } else if (inputResizeEvent.getFlag() == 2) {
            k8(inputResizeEvent.getResizeHeight());
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String stringExtra;
        super.onNewIntent(intent);
        this.A = WearUtils.y.u();
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        this.o.setText("");
        this.j1 = intent.getBooleanExtra("isFinishToLongDistance", false);
        if (intent.getExtras() != null) {
            stringExtra = intent.getExtras().getString("userId");
            this.f1 = (CommunMessage) intent.getExtras().getSerializable("searchMessage");
        } else {
            stringExtra = intent.getStringExtra("userId");
        }
        String str = "userId66666=====" + stringExtra;
        h8(stringExtra);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.p0.B();
        J6();
        if (this.o.isFocused()) {
            ((ViewGroup) this.o.getParent()).requestFocus();
            ue3.a(this.o, this);
        }
        if (this.p1) {
            return;
        }
        if (WearUtils.e1(this.o.getText().toString()) && this.L0 == null) {
            DaoUtils.getCommunMessageDao().delDateDrafMessage(WearUtils.y.p(), this.y);
        } else {
            DaoUtils.getCommunMessageDao().upDateDrafMessage(WearUtils.y.p(), this.y, this.o.getText().toString(), null, this.L0);
        }
    }

    @Override // com.wear.xmpp.FragmentStateLossActivity, com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        User user;
        boolean z2;
        super.onResume();
        if (this.C == null) {
            this.C = ChatSyncControl.N0();
        }
        this.C.w(this);
        if (this.B == null) {
            this.B = ChatLiveControl.q0();
        }
        this.B.w(this);
        if (WearUtils.x.i.k(WearUtils.i0(this.x))) {
            if (this.N) {
                finish();
                return;
            }
            this.n.getYesBtn().setVisibility(8);
            this.n.getYesImageBtn().setVisibility(8);
            this.d0.setVisibility(0);
            this.d0.setOnClickListener(new s());
        }
        if (Build.VERSION.SDK_INT >= 23) {
            kg3.k(this, WearUtils.Y0());
        }
        this.application.r0(this.x);
        if (this.k0.size() > 0) {
            for (CommunMessage communMessage : this.k0) {
                communMessage.setDataBean(communMessage.syncDecryptBean());
            }
            for (CommunMessage communMessage2 : this.k0) {
                Iterator<CommunMessage> it = this.j0.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().getId().equals(communMessage2.getId())) {
                            z2 = true;
                            break;
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                }
                if (!z2) {
                    this.j0.add(communMessage2);
                }
            }
            this.g0.notifyDataSetChanged();
            this.k0.clear();
        }
        d7();
        c7();
        File fileN = WearUtils.N(WearUtils.y.v(this.x));
        if (!fileN.exists() || (user = this.z) == null || user.isDateIng()) {
            nz1.e().k(this.X);
            E8();
        } else {
            ImageLoader.getInstance().loadImage(Uri.fromFile(fileN).toString(), new ImageSize(gg3.e(this), gg3.c(this)), new t());
        }
        if (this.g0 != null) {
            notifyDataSetChanged();
            if (!this.w0) {
                if (this.f1 != null && this.g1) {
                    return;
                } else {
                    m8();
                }
            }
        }
        this.w0 = false;
        aq2.j().v();
        MyApplication.N().q0(this);
        gu3.x(this);
    }

    @Override // com.wear.BaseActivity
    public void onSoftKeyboardOpened() {
        j8();
    }

    @Override // dc.l22.i
    public void p0(ControlLinkAwaken.Awaken awaken, Map<String, String> map) {
        dissDialog();
        ku1.a("Control Link", "remote_chatroom_control_link_click", "click", map.get("linkId") != null ? map.get("linkId") : "", "1", map.get("elementContent") != null ? map.get("elementContent") : "", null, null);
        if (awaken.isResult()) {
            dq2.w().G(awaken.getLinkId(), 4, this);
            return;
        }
        if (awaken.getConflict().booleanValue()) {
            na2.m().t();
            return;
        }
        String errorCode = awaken.getErrorCode();
        if (TextUtils.equals("5009106", errorCode)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("control_link_error_code", errorCode);
        pj3.g(this.activity, ControlLinkEndActivity.class, bundle);
    }

    public final void p8(CommunMessage communMessage) {
        EntityAudio entityAudio = (EntityAudio) communMessage.getDataBean();
        String localUrl = entityAudio.getLocalUrl();
        if (!WearUtils.e1(localUrl) && new File(localUrl).exists()) {
            if (!hf3.d(this)) {
                sg3.i(this, R.string.common_settingTip);
                w8(communMessage, true);
            } else {
                communMessage.setSendStatus(2);
                tn2.x(WearUtils.x).A("/wear/chat/saveFile/audio", new File(localUrl), new HashMap(), new f(entityAudio, communMessage));
            }
        }
    }

    @Override // dc.tz1
    public void pauseConnon(int i2) {
    }

    @Override // dc.sa2
    public void q() {
        if (na2.m().h(this.z, MessageType.video)) {
            db2.A().q(new a0());
            hu3.T();
        }
    }

    public final void q8(String str, CommunMessage communMessage, int i2) {
        communMessage.setUserId(communMessage.getFrom());
        if (i2 != 0) {
            w8(communMessage, false);
            return;
        }
        EntityPicture entityPicture = (EntityPicture) communMessage.getDataBean();
        entityPicture.setUrl(str);
        communMessage.setSendStatus(2);
        communMessage.sendEntity(entityPicture);
        DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
        if (this.z.isDateIng()) {
            communMessage.setSendType(2);
        }
        v8(communMessage, communMessage.getType());
    }

    @Override // dc.sa2
    public HashMap<String, String> r() {
        return this.q0;
    }

    public final void r8(int i2, int i3, String str, String str2, String str3, File file, boolean z2) {
        this.r0.post(new k0(file, z2, str, i2, i3, str2, str3));
    }

    @Override // dc.tz1
    public void recovery() {
    }

    @Override // dc.sa2
    public void s3(CommunMessage communMessage) {
        ue3.a(this.o, this);
        this.u.setVisibility(8);
        this.v.setVisibility(8);
        this.t.setVisibility(8);
        if (communMessage.getType() == MessageType.picture) {
            Intent intent = new Intent(this, (Class<?>) LongPictureEnlargeActivity.class);
            intent.putExtra("extras_friend_id", this.z.getId());
            intent.putExtra("extras_massage_id", communMessage.getId());
            intent.putExtra("can_long_click", true);
            startActivityForResult(intent, 999);
            return;
        }
        if (communMessage.getType() == MessageType.burnpicture) {
            Intent intent2 = new Intent(this, (Class<?>) BurnPictureEnlargeActivity.class);
            intent2.putExtra("burn_commun_message", communMessage);
            startActivityForResult(intent2, 888);
        }
    }

    public final void s8(String str, CommunMessage communMessage, int i2) {
        communMessage.setUserId(communMessage.getFrom());
        if (i2 != 0) {
            w8(communMessage, false);
            return;
        }
        EntityShortVideo entityShortVideo = communMessage.getDataBean() instanceof EntityBurnShortVideo ? (EntityBurnShortVideo) communMessage.getDataBean() : (EntityShortVideo) communMessage.getDataBean();
        communMessage.setSendStatus(2);
        communMessage.sendEntity(entityShortVideo);
        DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
        if (this.z.isDateIng()) {
            communMessage.setSendType(2);
        }
        v8(communMessage, communMessage.getType());
        if (WearUtils.e1(entityShortVideo.getVideoUrl())) {
            FirebaseCrashlytics.getInstance().recordException(new Throwable("videourl sendChatVideoMessage null Millis:" + System.currentTimeMillis()));
        }
    }

    @Override // com.wear.BaseActivity
    public void settingBarColor() {
        super.settingBarColor();
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        Window window = getWindow();
        int i2 = MyApplication.m0;
        if (i2 == 0) {
            if (MyApplication.l0) {
                window.setNavigationBarColor(Color.parseColor("#1E1F29"));
                return;
            } else {
                window.setNavigationBarColor(Color.parseColor("#F7F8F9"));
                return;
            }
        }
        if (i2 == 2) {
            window.setNavigationBarColor(Color.parseColor("#1E1F29"));
        } else {
            window.setNavigationBarColor(Color.parseColor("#F7F8F9"));
        }
    }

    @Override // dc.tz1
    public void stop(int i2) {
        User user = this.z;
        if (user == null || !user.isDateIng()) {
            return;
        }
        this.q1 = false;
        U6(true);
    }

    @Override // dc.sa2
    public void t() {
        if (na2.m().h(this.z, MessageType.sync)) {
            if (this.application.G().P().size() < 1) {
                sg3.i(this, R.string.tip_toy_notConnect);
            } else if (WearUtils.y1(this.z.getToyStatus())) {
                db2.A().q(new b0());
            } else {
                sg3.i(this, R.string.chat_friend_noToy);
            }
        }
    }

    public void t8(DataEntityAbstract dataEntityAbstract, MessageType messageType) {
        u8(dataEntityAbstract, messageType, false);
    }

    public final void u8(DataEntityAbstract dataEntityAbstract, MessageType messageType, boolean z2) {
        if (!hf3.d(this)) {
            sg3.i(this, R.string.common_settingTip);
            x8(dataEntityAbstract);
            return;
        }
        if (!MyApplication.P || hu3.x() == null || z2) {
            sg3.i(this, R.string.message_send_error);
            x8(dataEntityAbstract);
            return;
        }
        if (!zb2.O().B(messageType)) {
            sg3.l(ah4.e(R.string.operate_frequently));
            return;
        }
        CommunMessage communMessage = new CommunMessage();
        communMessage.setFrom(WearUtils.y.p());
        communMessage.setTo(this.y);
        communMessage.sendEntity(dataEntityAbstract);
        communMessage.setId(WearUtils.E());
        communMessage.setUserId(communMessage.getFrom());
        if (this.z.isDateIng()) {
            communMessage.setSendType(2);
        }
        MessageType messageType2 = MessageType.chat;
        if (messageType == messageType2) {
            String text = ((EntityChat) dataEntityAbstract).getText();
            this.s0.M(text);
            communMessage.setShowEmojiAnim(!TextUtils.isEmpty(this.s0.s(text, false)));
            communMessage.setEmojiLogType(this.s0.t(text, i7(communMessage)));
        }
        CommunMessage communMessage2 = this.L0;
        if (communMessage2 != null && messageType == messageType2) {
            communMessage2.setUnEncryptFrom(communMessage2.getFrom());
            CommunMessage communMessage3 = this.L0;
            communMessage3.setUnEncryptRealFrom(communMessage3.getRealFrom());
            CommunMessage communMessage4 = this.L0;
            communMessage4.setUnEncryptTo(communMessage4.getTo());
            communMessage.setReplyData(WearUtils.A.toJson(this.L0));
            this.L0 = null;
            this.J0.setVisibility(8);
            this.M0.setText("");
            if (this.Z0) {
                this.r0.postDelayed(new Runnable() { // from class: dc.g52
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.L7();
                    }
                }, 300L);
            }
            addAnalyticsEventId("chat_reply_send", null);
        }
        if (U7(communMessage)) {
            DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
            E0(communMessage);
        }
        v8(communMessage, messageType);
    }

    @Override // dc.sa2
    public void v() {
        if (na2.m().h(this.z, MessageType.live)) {
            if (j7()) {
                db2.A().q(new c0());
                return;
            }
            if (!dh3.b(this.z)) {
                sg3.i(this, R.string.str_chatroom_partner_no_toy);
                return;
            }
            User user = this.z;
            if (user == null || !user.isOnline()) {
                sg3.k(this, String.format(ah4.e(R.string.str_chatroom_partner_offline), this.z.getShowNickName()));
            } else {
                sg3.i(this, R.string.str_chatroom_no_toy);
            }
        }
    }

    @Override // dc.sa2
    public void v1(CommunMessage communMessage) {
        CommunMessage communMessage2 = this.D0;
        if (communMessage2 != null && communMessage == communMessage2) {
            L6(false);
        }
        Iterator<CommunMessage> it = this.j0.iterator();
        while (it.hasNext()) {
            CommunMessage next = it.next();
            if (!WearUtils.e1(next.getReplyData())) {
                HashMap map = (HashMap) WearUtils.A.fromJson(next.getReplyData(), HashMap.class);
                Gson gson = WearUtils.A;
                map.remove("replyData");
                map.remove("dataBean");
                CommunMessage communMessage3 = (CommunMessage) WearUtils.A.fromJson(WearUtils.A.toJson(map), CommunMessage.class);
                if (communMessage3.getId().equals(communMessage.getId())) {
                    communMessage3.setType(MessageType.system);
                    communMessage3.setReplyData("delete");
                    next.setReplyData(WearUtils.A.toJson(communMessage3));
                    DaoUtils.getCommunMessageDao().update((CommunMessageDao) next);
                }
            }
        }
        notifyDataSetChanged();
        CommunMessage communMessage4 = this.L0;
        if (communMessage4 == null || !communMessage4.getId().equals(communMessage.getId())) {
            return;
        }
        O6();
    }

    public final void v8(final CommunMessage communMessage, final MessageType messageType) {
        User userV = ch3.n().v(WearUtils.g0(this.y));
        if (userV == null) {
            finish();
            return;
        }
        if (!zb2.O().B(messageType)) {
            sg3.l(ah4.e(R.string.operate_frequently));
            return;
        }
        if (userV.isDeleteByFriend() && !userV.isDateIng()) {
            hu3.m(communMessage, true);
            CommunMessage communMessageJ = hu3.j(communMessage);
            communMessage.sendFail();
            if (communMessageJ != null) {
                E0(communMessageJ);
                return;
            }
            return;
        }
        if (!WearUtils.x.i.D(this.y, true)) {
            if (userV.canSendMsg()) {
                final ContainBean containBean = new ContainBean(communMessage);
                vg3.b().a(new Runnable() { // from class: dc.y42
                    @Override // java.lang.Runnable
                    public final void run() {
                        ChatActivity.O7(containBean, messageType, communMessage);
                    }
                });
                return;
            }
            return;
        }
        CommunMessage communMessageI = hu3.i(communMessage);
        if (communMessageI != null) {
            MessageType messageType2 = MessageType.system;
            if (messageType == messageType2) {
                EntitySystem entitySystem = (EntitySystem) communMessage.getDataBean();
                if (entitySystem.getFirstSysOPTType() == EntitySystem.SystemOPTType.T300 && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C309) {
                    return;
                }
            }
            if (messageType == messageType2) {
                EntitySystem entitySystem2 = (EntitySystem) communMessage.getDataBean();
                if (entitySystem2.getFirstSysOPTType() == EntitySystem.SystemOPTType.T200 && entitySystem2.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C204) {
                    return;
                }
            }
            E0(communMessageI);
        }
        final ContainBean containBean2 = new ContainBean(communMessage);
        vg3.b().a(new Runnable() { // from class: dc.x42
            @Override // java.lang.Runnable
            public final void run() {
                this.a.N7(containBean2, messageType, communMessage);
            }
        });
    }

    @Override // dc.eu3
    public void w0(int i2) {
        so3 so3Var = this.n0;
        if (so3Var == null || !so3Var.s()) {
            return;
        }
        this.n0.I();
    }

    public void w8(CommunMessage communMessage, boolean z2) {
        try {
            communMessage.setSendStatus(4);
            if (z2) {
                communMessage.setCreated(be3.u());
            }
            if (U7(communMessage)) {
                DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
                R7(communMessage);
            }
        } catch (Exception e2) {
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    @Override // dc.sa2
    public void x3(CommunMessage communMessage, Bitmap bitmap, ImageView imageView) {
        ue3.a(this.o, this);
        this.u.setVisibility(8);
        this.v.setVisibility(8);
        this.t.setVisibility(8);
        Intent intent = new Intent(this, (Class<?>) LongPictureEnlargeActivity.class);
        intent.putExtra("extras_friend_id", this.z.getId());
        intent.putExtra("extras_massage_id", communMessage.getId());
        intent.putExtra("can_long_click", false);
        startActivityForResult(intent, 999);
    }

    public void x8(DataEntityAbstract dataEntityAbstract) {
        CommunMessage communMessage = new CommunMessage();
        communMessage.setFrom(WearUtils.y.p());
        communMessage.setTo(this.y);
        communMessage.sendEntity(dataEntityAbstract);
        communMessage.setId(WearUtils.E());
        communMessage.setUserId(communMessage.getFrom());
        if (this.z.isDateIng()) {
            communMessage.setSendType(2);
        }
        if (this.L0 != null && communMessage.getType() == MessageType.chat) {
            String from = this.L0.getFrom();
            String to = this.L0.getTo();
            this.L0.setUnEncryptFrom(from);
            this.L0.setUnEncryptRealFrom(from);
            this.L0.setUnEncryptTo(to);
            communMessage.setReplyData(WearUtils.A.toJson(this.L0));
            this.L0 = null;
            this.J0.setVisibility(8);
            this.M0.setText("");
            if (this.Z0) {
                this.r0.postDelayed(new s0(), 300L);
            }
        }
        communMessage.setSendStatus(4);
        if (dataEntityAbstract instanceof EntityChat) {
            this.s0.M(((EntityChat) dataEntityAbstract).getText());
            communMessage.setShowEmojiAnim(!TextUtils.isEmpty(this.s0.s(r6, false)));
        }
        if (U7(communMessage)) {
            DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
            E0(communMessage);
        }
    }

    @Override // dc.jv1
    public void y(IPeopleInfo iPeopleInfo) {
        if (iPeopleInfo == null || !TextUtils.equals(iPeopleInfo.getUserJid(), this.y)) {
            return;
        }
        P6();
    }

    public final void y8(CommunMessage communMessage, MessageType messageType, boolean z2) {
        if (this.g0 == null) {
            return;
        }
        communMessage.setSendStatus(2);
        if (z2) {
            communMessage.setCreated(be3.u());
        }
        if (messageType == MessageType.chat) {
            String text = ((EntityChat) communMessage.getDataBean()).getText();
            this.s0.M(text);
            communMessage.setShowEmojiAnim(!TextUtils.isEmpty(this.s0.s(text, false)));
            communMessage.setEmojiLogType(this.s0.t(text, i7(communMessage)));
        }
        this.g0.notifyDataSetChanged();
        v8(communMessage, messageType);
    }

    public final void z8() {
        String strTrim = this.o.getText().toString().trim();
        if (o()) {
            return;
        }
        if (strTrim == null || strTrim.equals("")) {
            is3.b bVar = new is3.b(this.activity);
            bVar.p(ah4.e(R.string.chat_unable_send_blank_message));
            bVar.o(ah4.e(R.string.common_ok));
            bVar.d(new e(this));
            bVar.b(false);
            cs3.h(bVar).show();
        } else {
            EntityChat entityChat = new EntityChat();
            entityChat.setText(strTrim);
            t8(entityChat, MessageType.chat);
            addAnalyticsEventId("chat_text", null);
        }
        this.o.setText("");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EndChatEvent endChatEvent) {
        if (endChatEvent == null || !endChatEvent.endChat) {
            return;
        }
        Account accountU = WearUtils.y.u();
        this.A = accountU;
        if (accountU == null || accountU.getCurrentControlType() == null) {
            return;
        }
        if (this.A.getCurrentControlType() != MessageType.video && this.A.getCurrentControlType() != MessageType.voice) {
            if (this.A.getCurrentControlType() == MessageType.live) {
                this.B.a();
                return;
            } else {
                this.C.a();
                return;
            }
        }
        this.D.X0(true, false, false);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ClearChatViewFriendIdEvent clearChatViewFriendIdEvent) {
        String str = this.x;
        if (str == null || !str.equals(clearChatViewFriendIdEvent.clearChatViewFriendId)) {
            return;
        }
        this.j0.clear();
        this.k0.clear();
        if (this.f1 != null) {
            this.f1 = null;
        }
        this.g0.notifyDataSetChanged();
        this.F0 = true;
        f7();
        this.D0 = null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ForwardMessageEvent forwardMessageEvent) {
        String str;
        if (forwardMessageEvent == null || (str = this.x) == null || !str.equals(forwardMessageEvent.friendId) || forwardMessageEvent.userMessage == null) {
            return;
        }
        if (this.z.isDateIng()) {
            forwardMessageEvent.userMessage.setSendType(2);
        }
        if (U7(forwardMessageEvent.userMessage)) {
            E0(forwardMessageEvent.userMessage);
        }
        E0(forwardMessageEvent.blockMessage);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(UserUpdateEvent userUpdateEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String str = userUpdateEvent.message;
        if (WearUtils.e1(str) || !str.equals(this.x)) {
            return;
        }
        c7();
        h7();
        if (this.z.isOnline()) {
            if (this.z.isDateIng() && !MyApplication.P) {
                V7();
            }
        } else {
            V7();
        }
        d7();
        if (!this.D.r() && this.C.r() && this.B.r()) {
            return;
        }
        String supportType = this.z.getSupportType();
        xe3.a("Message==>", "好友SocketIo:" + supportType);
        if (TextUtils.isEmpty(supportType) || "openfire#socketio_1".equals(supportType) || !zb2.O().Y()) {
            return;
        }
        zb2.O().U0(false, this.x);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(InDateActivityEvent inDateActivityEvent) {
        User user;
        int i2 = inDateActivityEvent.flag;
        if (i2 == 1) {
            U6(true);
            return;
        }
        if (i2 == 2) {
            if (!this.q1) {
                sg3.l(String.format(ah4.e(R.string.str_dating_has_joined), this.z.getShowNickName()));
            }
            this.q1 = true;
            notifyDataSetChanged();
            return;
        }
        if (i2 == 3) {
            this.q1 = false;
            notifyDataSetChanged();
            return;
        }
        if (i2 == 4) {
            U6(false);
            return;
        }
        if (i2 == 6) {
            notifyDataSetChanged();
            if (!WearUtils.N(WearUtils.y.v(this.x)).exists() || (user = this.z) == null || user.isDateIng()) {
                nz1.e().k(this.X);
                E8();
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageResendEvent messageResendEvent) {
        CommunMessage message = messageResendEvent.getMessage();
        if (message.getType() != MessageType.alarm) {
            f8(message);
            return;
        }
        this.S = message;
        Intent intent = new Intent(this, (Class<?>) AlarmCreateActivity.class);
        intent.putExtra("userId", this.x);
        intent.putExtra("alarm_item_id", ((EntityAlarm) message.getDataBean()).getId());
        startActivityForResult(intent, 19);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageSendEvent messageSendEvent) {
        if (messageSendEvent.msg == null) {
            return;
        }
        for (int i2 = 0; i2 < this.j0.size(); i2++) {
            CommunMessage communMessage = this.j0.get(i2);
            if (communMessage.getId().equals(messageSendEvent.msg.getId())) {
                communMessage.setSendStatus(messageSendEvent.msg.getSendStatus());
                this.g0.notifyItemChanged(i2, "sendStatus");
            }
        }
        for (CommunMessage communMessage2 : this.k0) {
            if (communMessage2.getId().equals(messageSendEvent.msg.getId())) {
                communMessage2.setSendStatus(messageSendEvent.msg.getSendStatus());
            }
        }
        H8(messageSendEvent.msg);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(SystemEvent systemEvent) {
        CommunMessage communMessage;
        int i2 = systemEvent.flag;
        if (i2 != 0) {
            if (i2 != 1 || (communMessage = systemEvent.message) == null) {
                return;
            }
            R2(0, communMessage);
            return;
        }
        this.application.G().u0();
        this.application.G().W(0);
        TextView labelStatus = this.n.getLabelStatus();
        if (this.z.isOnline()) {
            return;
        }
        U8(labelStatus, null);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(PatternRecEvent patternRecEvent) {
        if (patternRecEvent.play) {
            sg3.k(this, String.format(ah4.e(R.string.playing_pattern_automatically), this.z.getUserName()));
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(PatternRecEvent1 patternRecEvent1) {
        boolean z2 = true;
        int i2 = 0;
        if (patternRecEvent1.play) {
            sg3.k(this, String.format(ah4.e(R.string.playing_pattern_automatically), this.z.getUserName()));
        }
        int size = this.j0.size() - 1;
        while (true) {
            if (size < 0) {
                z2 = false;
                break;
            }
            CommunMessage communMessage = this.j0.get(size);
            if (communMessage.getType() == MessageType.pattern) {
                EntityPattern entityPattern = (EntityPattern) (communMessage.getDataBean() == null ? communMessage.syncDecryptBean() : communMessage.getDataBean());
                if (entityPattern.getUrl().equals(patternRecEvent1.patternEntity.getUrl())) {
                    entityPattern.setIsAutoPlay(patternRecEvent1.play);
                    qf3.b = null;
                    qf3.w(null);
                    i2 = size;
                    break;
                }
            }
            size--;
        }
        if (z2) {
            this.p.scrollToPosition(i2);
            notifyDataSetChanged();
        } else {
            DaoUtils.getCommunMessageDao().add(patternRecEvent1.userMessage);
            E0(patternRecEvent1.userMessage);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ChatPictureEvent chatPictureEvent) {
        if (chatPictureEvent != null) {
            boolean zIsAddEmojis = chatPictureEvent.isAddEmojis();
            ArrayList<String> delIds = chatPictureEvent.getDelIds();
            if (zIsAddEmojis) {
                this.s0.A();
            }
            if (delIds == null || delIds.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            synchronized (this.j0) {
                Iterator<String> it = delIds.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    Iterator<CommunMessage> it2 = this.j0.iterator();
                    while (it2.hasNext()) {
                        CommunMessage next2 = it2.next();
                        if (next2.getId().equals(next)) {
                            arrayList.add(next2);
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        CommunMessage communMessage = (CommunMessage) it3.next();
                        this.E.j0(communMessage);
                        this.E.x(communMessage);
                    }
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(BurnAfterReadEvent burnAfterReadEvent) {
        if (burnAfterReadEvent != null) {
            CommunMessage message = burnAfterReadEvent.getMessage();
            if ((TextUtils.equals(message.getFrom(), ch3.n().p()) && TextUtils.equals(message.getTo(), this.y)) || (TextUtils.equals(message.getTo(), ch3.n().p()) && TextUtils.equals(message.getFrom(), this.y))) {
                Iterator<CommunMessage> it = this.j0.iterator();
                while (it.hasNext()) {
                    CommunMessage next = it.next();
                    if (TextUtils.equals(next.getId(), message.getId())) {
                        next.sendEntity(message.getDataBean());
                        this.g0.notifyItemChanged(this.j0.indexOf(next));
                        return;
                    }
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(FinishChatPageEvent finishChatPageEvent) {
        if (finishChatPageEvent.flag == 0) {
            finish();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ChatBurnRecallEvent chatBurnRecallEvent) {
        if (chatBurnRecallEvent != null) {
            this.E.a0(true);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(f42 f42Var) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (f42Var != null) {
            String str = "userId===" + this.x + "-----OldEmail====" + f42Var.b();
            if (f42Var.b().equals(this.x)) {
                this.x = f42Var.a();
                g7(f42Var.a());
                e7(f42Var.a());
                this.g0.notifyDataSetChanged();
            }
        }
    }
}
