package com.wear.main.longDistance;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.fastjson.JSON;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.tencent.qgame.animplayer.AnimView;
import com.wear.activity.qrcode.QRCodeActivity;
import com.wear.adapter.longdistance.FriendControlBannarAdapter;
import com.wear.adapter.longdistance.MessageNewAdapter;
import com.wear.bean.Account;
import com.wear.bean.AlarmListItems;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.bean.Pattern;
import com.wear.bean.SurveyInfoBean;
import com.wear.bean.SyncLinkToy;
import com.wear.bean.Toy;
import com.wear.bean.event.ChatBurnRecallEvent;
import com.wear.bean.event.ChatPictureEvent;
import com.wear.bean.event.ChatRoomMessageReflashEvent;
import com.wear.bean.event.ClearChatViewFriendIdEvent;
import com.wear.bean.event.FinishChatPageEvent;
import com.wear.bean.event.GroupBanEvent;
import com.wear.bean.event.GroupInvitationEvent;
import com.wear.bean.event.GroupMessageEvent;
import com.wear.bean.event.GroupNameChangeEvent;
import com.wear.bean.event.GroupProhibitedEvent;
import com.wear.bean.event.GroupStatusEvent;
import com.wear.bean.event.InputResizeEvent;
import com.wear.bean.event.MessageResendEvent;
import com.wear.bean.event.PatternOrAlarmSaveEvent;
import com.wear.bean.event.PatternRecEvent;
import com.wear.bean.event.ReSendPatternEvent;
import com.wear.bean.event.SystemEvent;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.socketio.controlLink.response.ControlLinkAwaken;
import com.wear.bean.socketio.msg.response.AckCreateMultiToOneInfoResponse;
import com.wear.bean.socketio.msg.response.DSGroupInfoBean;
import com.wear.bean.socketio.msg.response.DSPlayerListBean;
import com.wear.bean.socketio.msg.response.ReceiveGroupMemberStateResponse;
import com.wear.bean.socketio.msg.response.RoomReceiveSyncResponse;
import com.wear.bean.socketio.msg.reuqest.GetGroupMemberStateRequest;
import com.wear.dao.CommunMessageDao;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.main.MainActivity;
import com.wear.main.closeRange.alarm.AlarmCreateActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.longDistance.control.ChatDSControl;
import com.wear.main.longDistance.control.ChatGroupControl;
import com.wear.main.longDistance.control.ChatLiveControl;
import com.wear.main.longDistance.control.ChatSyncControl;
import com.wear.main.longDistance.report.ReasonOptionActivity;
import com.wear.main.longDistance.report.ResultActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.phonertc.RequestPermissionActivity;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntityAlarm;
import com.wear.protocol.EntityAudio;
import com.wear.protocol.EntityBurnPicture;
import com.wear.protocol.EntityBurnShortVideo;
import com.wear.protocol.EntityChat;
import com.wear.protocol.EntityChatABean;
import com.wear.protocol.EntityPattern;
import com.wear.protocol.EntityPicture;
import com.wear.protocol.EntityShortVideo;
import com.wear.protocol.EntitySystem;
import com.wear.protocol.EntityUnSupport;
import com.wear.protocol.MessageType;
import com.wear.ui.chat.fragment.ChatActionMenuFragmentBottom;
import com.wear.ui.longDistance.controlLink.ControlLinkEndActivity;
import com.wear.ui.longDistance.imagepicker.data.MediaFile;
import com.wear.ui.longDistance.video.VideoPlayerActivity;
import com.wear.util.MyApplication;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import com.wear.widget.BaseImageButton;
import com.wear.widget.ChatEditText;
import com.wear.widget.CustomSwipeRefreshLayout;
import com.wear.widget.EmojisToastView;
import com.wear.widget.MyActionBar;
import com.wear.widget.RadiuImageView;
import com.wear.widget.chatMic.ChatEmojisPanel;
import com.wear.widget.chatMic.ChatInputPanelPto;
import com.wear.widget.chatMic.ChatRoomInputPanel;
import com.wear.widget.chatMic.ChatRoomMorePanel;
import com.wear.widget.chatMic.VoiceMessagePanelView;
import com.wear.widget.control.CoustomLinearLayout;
import com.wear.widget.dialog.LoveEmojisDialog;
import com.wear.widget.dialog.PhotoCameraDialog;
import com.wear.widget.iwatcher.ImageWatcher;
import com.wear.widget.velvo.VelvoPreviewView;
import dc.ah0;
import dc.ah3;
import dc.ah4;
import dc.be3;
import dc.cg3;
import dc.ch3;
import dc.cs3;
import dc.db2;
import dc.df3;
import dc.dh1;
import dc.di1;
import dc.dq2;
import dc.e82;
import dc.eg3;
import dc.ff3;
import dc.fh0;
import dc.fk3;
import dc.gg3;
import dc.gv1;
import dc.h12;
import dc.hf3;
import dc.hh0;
import dc.hu3;
import dc.ie3;
import dc.is3;
import dc.iv1;
import dc.ke3;
import dc.kg3;
import dc.kn3;
import dc.ku1;
import dc.kv1;
import dc.l22;
import dc.lg3;
import dc.me3;
import dc.mf2;
import dc.na2;
import dc.nd3;
import dc.nf3;
import dc.ng1;
import dc.nv1;
import dc.nz1;
import dc.od3;
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
import dc.u51;
import dc.ue3;
import dc.uf2;
import dc.vb2;
import dc.vd0;
import dc.vg3;
import dc.w83;
import dc.wg3;
import dc.wo2;
import dc.x83;
import dc.xb2;
import dc.xe2;
import dc.xe3;
import dc.y12;
import dc.ye3;
import dc.zb2;
import dc.zl2;
import dc.zn2;
import dc.zt3;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smackx.disco.bean.request.RequestMessageRecord;
import org.jivesoftware.smackx.disco.bean.request.RequestRoomControllerSub;
import org.jivesoftware.smackx.disco.bean.response.BaseResponse;
import org.jivesoftware.smackx.disco.bean.response.SubMessageBean;
import pl.droidsonroids.gif.GifImageView;

/* loaded from: classes3.dex */
public class ChatRoomActivity extends QRCodeActivity<zl2> implements wo2, MessageNewAdapter.t0, ie3.m, sa2, xb2, ImageWatcher.j, CustomSwipeRefreshLayout.a, gv1, ah3, l22.i, VoiceMessagePanelView.b, ChatActionMenuFragmentBottom.d {
    public boolean A0;
    public GroupMember B;
    public boolean B0;
    public boolean C0;
    public Timer D;
    public boolean D0;
    public GroupMember E;
    public boolean E0;
    public GroupMember F;
    public CommunMessage F0;
    public DSGroupInfoBean G;
    public String G0;
    public boolean H0;
    public CommunMessage I0;
    public long J0;
    public boolean K;
    public AnimView K0;
    public FrameLayout L0;
    public ImageView M0;
    public long N;
    public ChatActionMenuFragmentBottom N0;
    public ArrayList<String> O;
    public Dialog O0;
    public ArrayList<MediaFile> P;
    public long P0;
    public File Q;
    public Uri R;
    public String S;
    public ie3 T;
    public Activity U;
    public so3 V;
    public String W;
    public MessageNewAdapter X;
    public List<CommunMessage> Y;
    public int Z;
    public HashMap<String, String> a0;

    @BindView(R.id.ab_title)
    public MyActionBar abTitle;
    public CommunMessage b0;

    @BindView(R.id.btn_chat_emojis)
    public BaseImageButton btnChatEmojis;

    @BindView(R.id.btn_chat_more)
    public BaseImageButton btnChatMore;
    public LinkedList<String> c0;

    @BindView(R.id.chat_emojis_panel_layout)
    public LinearLayout chatEmojisPanel;

    @BindView(R.id.chat_emojis_tosat_layer)
    public EmojisToastView chatEmojisTosatLayer;

    @BindView(R.id.chat_live_sync_layer)
    public CoustomLinearLayout chatLiveSyncLayer;

    @BindView(R.id.chat_message)
    public ChatEditText chatMessage;

    @BindView(R.id.chat_message_list)
    public RecyclerView chatMessageList;

    @BindView(R.id.chat_more_layer)
    public FrameLayout chatMoreLayer;

    @BindView(R.id.chat_pictures)
    public ImageView chatPictures;

    @BindView(R.id.ac_chat_room_emojis_panel)
    public ChatEmojisPanel chatRoomEmojisPanel;

    @BindView(R.id.ac_chat_room_chatroominputpanel)
    public ChatRoomInputPanel chatRoomInputPanel;

    @BindView(R.id.ac_chat_room_chatmorepanel)
    public ChatRoomMorePanel chatRoomMorePanel;
    public int d0;
    public boolean e0;

    @BindView(R.id.emojis_image_panel)
    public RelativeLayout emojisImagePanel;
    public boolean f0;

    @BindView(R.id.favorite_image_panel)
    public RelativeLayout favoriteImagePanel;

    @BindView(R.id.fl_a)
    public FrameLayout flA;
    public CommunMessage g0;
    public List<String> h0;
    public int i0;

    @BindView(R.id.iv_chat_background)
    public ImageView ivChatBackground;

    @BindView(R.id.iv_survey_close)
    public ImageView ivSurveyClose;
    public LinearLayout j0;
    public View k0;
    public CommunMessage l0;

    @BindView(R.id.ac_chat_msg_container)
    public ViewGroup layoutMsg;

    @BindView(R.id.ll_bannar)
    public LinearLayout llBannar;

    @BindView(R.id.ll_bannar_bottom)
    public LinearLayout llBannarBottom;

    @BindView(R.id.ll_bannar_ds_bottom)
    public LinearLayout llBannarDSBottom;

    @BindView(R.id.ll_ds_bannar)
    public LinearLayout llDSBannar;

    @BindView(R.id.ll_survey)
    public LinearLayout llSurvey;

    @BindView(R.id.ll_unread_bar)
    public LinearLayout llUnreadBar;

    @BindView(R.id.lottie_view)
    public LottieAnimationView lottieView;
    public e82 m;
    public TextView m0;
    public int n;
    public TextView n0;

    @BindView(R.id.ll_new_message_bar)
    public LinearLayout newMessageBar;

    @BindView(R.id.tv_new_message_notice)
    public TextView newMessageNum;
    public TextView o0;
    public zl2 p;
    public RadiuImageView p0;
    public FriendControlBannarAdapter q;
    public RadiuImageView q0;
    public RelativeLayout r0;

    @BindView(R.id.rl_send_message)
    public RelativeLayout rlSendMessage;

    @BindView(R.id.rv_bannar)
    public RecyclerView rvBannar;

    @BindView(R.id.rv_ds_bannar)
    public RecyclerView rvDSBannar;
    public FriendControlBannarAdapter s;
    public LinearLayout s0;

    @BindView(R.id.screan_root_layout)
    public FrameLayout screanRootLayout;
    public LottieAnimationView t0;

    @BindView(R.id.tv_cancel)
    public TextView tvCancel;

    @BindView(R.id.tv_count)
    public TextView tvCount;

    @BindView(R.id.tv_ds_cancel)
    public TextView tvDSCancel;

    @BindView(R.id.tv_ds_join)
    public TextView tvDSJoin;

    @BindView(R.id.tv_exit_tip)
    public TextView tvExitTip;

    @BindView(R.id.tv_invitation_count)
    public TextView tvInvitationCount;

    @BindView(R.id.tv_join)
    public TextView tvJoin;

    @BindView(R.id.tv_show_bannar)
    public TextView tvShowBannar;

    @BindView(R.id.tv_show_ds_bannar)
    public TextView tvShowDSBannar;

    @BindView(R.id.tv_unread_notice)
    public TextView tvUnreadNotice;
    public Group u;
    public ImageView u0;
    public Account v;
    public boolean v0;

    @BindView(R.id.v_block_tip)
    public View vBlockTip;

    @BindView(R.id.long_chat_more_layout)
    public LinearLayout vChatRoomMenu;

    @BindView(R.id.v_glass)
    public View vGlass;

    @BindView(R.id.v_image_download)
    public ImageView vImageDownload;

    @BindView(R.id.v_image_watcher)
    public ImageWatcher vImageWatcher;

    @BindView(R.id.v_images_list)
    public ImageView vImagesList;

    @BindView(R.id.v_chat_live_layer)
    public View v_chat_live_layer;

    @BindView(R.id.velvo_preview)
    public VelvoPreviewView velvoPreviewView;
    public int w0;
    public boolean x0;
    public LinearLayoutManager y;
    public CommunMessage y0;
    public boolean z0;
    public boolean o = true;
    public ArrayList<GroupMember> t = new ArrayList<>();
    public ChatGroupControl w = ChatGroupControl.o1();
    public ChatDSControl x = ChatDSControl.r1();
    public vb2 z = vb2.b();
    public String A = "";
    public long C = 0;
    public boolean L = true;
    public boolean M = true;

    public class a implements MyActionBar.f {

        /* renamed from: com.wear.main.longDistance.ChatRoomActivity$a$a, reason: collision with other inner class name */
        public class C0111a implements iv1 {
            public C0111a() {
            }

            @Override // dc.iv1
            public void next() {
                ChatRoomActivity chatRoomActivity = ChatRoomActivity.this;
                pj3.j(chatRoomActivity, ChatRoomInfoActivity.class, "roomId", chatRoomActivity.S);
            }
        }

        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            ChatRoomActivity.this.y6(false);
            ChatRoomActivity.this.R8(new C0111a());
        }
    }

    public class a0 implements mf2 {
        public a0() {
        }

        @Override // dc.mf2
        public void Q(String str) {
            ChatRoomActivity chatRoomActivity = ChatRoomActivity.this;
            chatRoomActivity.x.p1(chatRoomActivity.S, true);
            ChatRoomActivity.this.llDSBannar.setVisibility(8);
        }

        @Override // dc.mf2
        public void a(Throwable th) {
        }
    }

    public class a1 implements dh1 {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ChatRoomActivity.this.L0.setVisibility(0);
                ChatRoomActivity.this.M0.setVisibility(0);
                ChatRoomActivity.this.K0.setVisibility(0);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ChatRoomActivity.this.L0.setVisibility(8);
                ChatRoomActivity.this.M0.setVisibility(8);
                ChatRoomActivity.this.K0.setVisibility(8);
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ChatRoomActivity.this.L0.setVisibility(8);
                ChatRoomActivity.this.M0.setVisibility(8);
                ChatRoomActivity.this.K0.setVisibility(8);
            }
        }

        public a1() {
        }

        @Override // dc.dh1
        public void a() {
        }

        @Override // dc.dh1
        public void b() {
            ChatRoomActivity.this.runOnUiThread(new b());
        }

        @Override // dc.dh1
        public void c(int i, @Nullable String str) {
            ChatRoomActivity.this.runOnUiThread(new c());
        }

        @Override // dc.dh1
        public void d() {
        }

        @Override // dc.dh1
        public void e(int i, @Nullable ng1 ng1Var) {
        }

        @Override // dc.dh1
        public boolean f(@NonNull ng1 ng1Var) {
            ChatRoomActivity.this.runOnUiThread(new a());
            return true;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup.LayoutParams layoutParams = ChatRoomActivity.this.findViewById(R.id.v_chat_live_layer).getLayoutParams();
            ChatRoomActivity chatRoomActivity = ChatRoomActivity.this;
            chatRoomActivity.M8(layoutParams.height + chatRoomActivity.j0.getHeight());
            ChatRoomActivity.this.x0 = true;
        }
    }

    public class b0 implements mf2 {
        public b0() {
        }

        @Override // dc.mf2
        public void Q(String str) {
            ChatRoomActivity chatRoomActivity = ChatRoomActivity.this;
            chatRoomActivity.w.l1(chatRoomActivity.S, true);
            ChatRoomActivity.this.llBannar.setVisibility(8);
        }

        @Override // dc.mf2
        public void a(Throwable th) {
        }
    }

    public static /* synthetic */ class b1 {
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

    public class c extends SimpleImageLoadingListener {
        public c() {
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            ChatRoomActivity.this.p0.setImageBitmap(bitmap);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    public class c0 implements Runnable {
        public c0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            sg3.e(ChatRoomActivity.this, R.string.chat_message_item_save_error);
        }
    }

    public class c1 implements is3.c {
        public c1(ChatRoomActivity chatRoomActivity) {
        }

        @Override // dc.is3.c
        public void doCancel() {
            DaoUtils.getTestValueDao().save(zt3.k, "1", TestValueDao.CHAT_NOTE);
        }
    }

    public class d extends SimpleImageLoadingListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;

        public class a extends SimpleImageLoadingListener {
            public a() {
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                ChatRoomActivity.this.p0.setImageBitmap(bitmap);
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingStarted(String str, View view) {
            }
        }

        public d(boolean z, String str) {
            this.a = z;
            this.b = str;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            ChatRoomActivity.this.p0.setImageBitmap(bitmap);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ImageLoader imageLoader = ImageLoader.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append(WearUtils.e.replace("-api", ""));
            sb.append(this.a ? this.b.replace("thum_", "") : this.b);
            imageLoader.displayImage(sb.toString(), ChatRoomActivity.this.p0, MyApplication.Y, new a());
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    public class d0 implements Runnable {
        public final /* synthetic */ String a;

        public d0(ChatRoomActivity chatRoomActivity, String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            sg3.l(WearUtils.e1(this.a) ? ah4.e(R.string.common_serverError) : this.a);
        }
    }

    public class d1 implements View.OnClickListener {
        public d1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatRoomActivity.this.w6();
        }
    }

    public class e extends SimpleImageLoadingListener {
        public e() {
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            ChatRoomActivity.this.q0.setImageBitmap(bitmap);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    public class e0 implements Runnable {
        public final /* synthetic */ File a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public class a implements zn2<String> {
            public final /* synthetic */ CommunMessage a;

            /* renamed from: com.wear.main.longDistance.ChatRoomActivity$e0$a$a, reason: collision with other inner class name */
            public class RunnableC0112a implements Runnable {
                public final /* synthetic */ String a;

                public RunnableC0112a(String str) {
                    this.a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (WearUtils.e1(this.a)) {
                        a aVar = a.this;
                        ChatRoomActivity.this.v8(null, aVar.a, 4);
                        ChatRoomActivity.this.O7(ah4.e(R.string.common_serverError));
                        return;
                    }
                    NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(this.a, NormalResponse.class);
                    if (normalResponse.isResult()) {
                        ChatRoomActivity.this.v8(normalResponse.getMessage(), a.this.a, 0);
                        return;
                    }
                    a aVar2 = a.this;
                    ChatRoomActivity.this.v8(null, aVar2.a, 4);
                    ChatRoomActivity.this.O7(normalResponse.getMessage());
                }
            }

            public a(CommunMessage communMessage) {
                this.a = communMessage;
            }

            @Override // dc.zn2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onSuccess(String str) {
                ChatRoomActivity.this.parentHandler.post(new RunnableC0112a(str));
            }

            @Override // dc.zn2
            public void onError(NetException netException) {
                ChatRoomActivity.this.v8(null, this.a, 4);
                ChatRoomActivity.this.O7(netException.getMessage());
            }
        }

        public e0(File file, boolean z, String str, int i, int i2, String str2, String str3) {
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
                ChatRoomActivity.this.P();
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
            if (!hf3.d(ChatRoomActivity.this.U)) {
                sg3.i(ChatRoomActivity.this.U, R.string.common_settingTip);
                ChatRoomActivity.this.B8(entityBurnPicture);
                return;
            }
            if (!MyApplication.P || hu3.x() == null) {
                sg3.i(ChatRoomActivity.this.U, R.string.message_send_error);
                ChatRoomActivity.this.B8(entityBurnPicture);
                return;
            }
            CommunMessage communMessage = new CommunMessage();
            communMessage.setFrom(WearUtils.y.p());
            communMessage.setTo(WearUtils.k0(ChatRoomActivity.this.S));
            communMessage.setUserId(WearUtils.y.p());
            communMessage.sendEntity(entityBurnPicture);
            communMessage.setId(WearUtils.E());
            communMessage.setRealFrom(communMessage.getFrom());
            communMessage.setSendStatus(2);
            if (ChatRoomActivity.this.P7(communMessage)) {
                DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
                ChatRoomActivity.this.E0(communMessage);
            }
            try {
                HashMap map = new HashMap();
                map.put(PSOProgramService.VS_Key, "1");
                tn2.x(WearUtils.x).D("/wear/chat/sendPic", this.a, (WearUtils.e1(this.f) && WearUtils.e1(this.g)) ? "chat.jpg" : this.a.getName(), map, new a(communMessage));
            } catch (Exception e) {
                ChatRoomActivity.this.v8(null, communMessage, 4);
                ChatRoomActivity.this.O7(ah4.e(R.string.common_serverError));
                e.printStackTrace();
            }
        }
    }

    public class e1 implements CoustomLinearLayout.a {
        public e1() {
        }

        @Override // com.wear.widget.control.CoustomLinearLayout.a
        public void a(int i, int i2, int i3, int i4) {
            xe3.a("ChatRoomActivity", "chat_live_layer:" + i + " " + i2);
            View viewFindViewById = ChatRoomActivity.this.findViewById(R.id.v_chat_live_layer);
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            if (System.currentTimeMillis() - ChatRoomActivity.this.J0 >= 100 || (i2 > 0 && layoutParams.height <= 0)) {
                layoutParams.width = -1;
                layoutParams.height = i2;
                viewFindViewById.setLayoutParams(layoutParams);
                viewFindViewById.invalidate();
                ChatRoomActivity.this.r8();
                String str = "chatLiveSyncLayer onSizeChanged h: " + i2;
                if (i2 > 0) {
                    ChatRoomActivity.this.i0 = i2;
                    ChatRoomActivity.this.chatRoomInputPanel.getLastPanelType();
                    fh0 fh0Var = fh0.LAYER;
                    ChatRoomActivity.this.chatRoomInputPanel.m(true, i2);
                }
            }
        }

        @Override // com.wear.widget.control.CoustomLinearLayout.a
        public void b(int i) {
            ChatRoomActivity.this.w.q2(i);
        }
    }

    public class f extends SimpleImageLoadingListener {
        public final /* synthetic */ String a;

        public class a extends SimpleImageLoadingListener {
            public a() {
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                ChatRoomActivity.this.q0.setImageBitmap(bitmap);
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingStarted(String str, View view) {
            }
        }

        public f(String str) {
            this.a = str;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            ChatRoomActivity.this.q0.setImageBitmap(bitmap);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ImageLoader.getInstance().displayImage(WearUtils.e.replace("-api", "") + this.a, ChatRoomActivity.this.q0, MyApplication.Y, new a());
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    public class f0 implements zn2<String> {
        public final /* synthetic */ EntityAudio a;
        public final /* synthetic */ CommunMessage b;

        public class a implements Runnable {
            public final /* synthetic */ NormalResponse a;

            /* renamed from: com.wear.main.longDistance.ChatRoomActivity$f0$a$a, reason: collision with other inner class name */
            public class C0113a extends ff3 {
                public C0113a(a aVar) {
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
                f0.this.a.setUrl(this.a.getMessage());
                f0 f0Var = f0.this;
                f0Var.b.sendEntity(f0Var.a);
                ChatRoomActivity.this.f0 = true;
                f0 f0Var2 = f0.this;
                ChatRoomActivity.this.D8(f0Var2.b, MessageType.audio, false);
                WearUtils.E0(true, this.a.getMessage(), new C0113a(this));
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f0 f0Var = f0.this;
                ChatRoomActivity.this.A8(f0Var.b, false);
            }
        }

        public f0(EntityAudio entityAudio, CommunMessage communMessage) {
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
            ChatRoomActivity.this.addAnalyticsEventId("chat_voice", null);
            ChatRoomActivity.this.runOnUiThread(new a(normalResponse));
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            ChatRoomActivity.this.runOnUiThread(new b());
        }
    }

    public class f1 extends TimerTask {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ChatRoomActivity.this.F8();
            }
        }

        public f1() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            ChatRoomActivity.this.runOnMainThread(new a());
        }
    }

    public class g extends nv1 {
        public g() {
        }

        @Override // dc.nv1, android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ChatRoomActivity.this.W7(charSequence.length() == 0);
            if (i3 == 1 && charSequence.charAt(i) == "@".charAt(0)) {
                Intent intent = new Intent(ChatRoomActivity.this.U, (Class<?>) ChatMemberActivity.class);
                intent.putExtra("roomId", ChatRoomActivity.this.S);
                ChatRoomActivity.this.startActivityForResult(intent, 153);
            }
        }
    }

    public class g0 implements Runnable {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ boolean b;

        public g0(CommunMessage communMessage, boolean z) {
            this.a = communMessage;
            this.b = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(View view) {
            ChatRoomActivity chatRoomActivity = ChatRoomActivity.this;
            chatRoomActivity.y.scrollToPositionWithOffset(chatRoomActivity.d0, 100);
            ChatRoomActivity.this.newMessageBar.setVisibility(4);
            ChatRoomActivity.this.d0 = -1;
        }

        @Override // java.lang.Runnable
        public void run() {
            EntityChat entityChat;
            try {
                if (ChatRoomActivity.this.X == null) {
                    return;
                }
                ((LinkedList) ChatRoomActivity.this.Y).addFirst(this.a);
                if (ChatRoomActivity.this.e0) {
                    ChatRoomActivity.this.r8();
                } else {
                    if (this.b) {
                        return;
                    }
                    if (ChatRoomActivity.this.d0 == -1) {
                        ChatRoomActivity.this.d0 = 0;
                        ChatRoomActivity.this.X.b = 0;
                        ChatRoomActivity.this.P6(true);
                        ChatRoomActivity.this.newMessageBar.setOnClickListener(new View.OnClickListener() { // from class: dc.k52
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                this.a.b(view);
                            }
                        });
                    } else {
                        ChatRoomActivity.I5(ChatRoomActivity.this);
                        ChatRoomActivity.this.X.b = ChatRoomActivity.this.d0;
                    }
                    ChatRoomActivity.this.a9();
                    ChatRoomActivity.this.X.Q0();
                }
                ChatRoomActivity.this.X.notifyItemInserted(0);
                if (this.a.getSendStatus() != 4) {
                    ChatRoomActivity.this.P8(this.a);
                }
                if (this.a.getType() != MessageType.chat || (entityChat = (EntityChat) this.a.getDataBean()) == null) {
                    return;
                }
                ChatRoomActivity.this.Y8(entityChat.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class g1 implements Runnable {
        public g1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CommunMessage communMessageFindDrafMessage = DaoUtils.getCommunMessageDao().findDrafMessage(WearUtils.y.p(), ChatRoomActivity.this.u.getUserJid());
            if (communMessageFindDrafMessage == null || communMessageFindDrafMessage.getType() != MessageType.chat) {
                return;
            }
            EntityChat entityChat = (EntityChat) communMessageFindDrafMessage.syncDecryptBean();
            String text = entityChat.getText();
            String replyData = communMessageFindDrafMessage.getReplyData();
            if (!WearUtils.e1(replyData)) {
                HashMap map = (HashMap) WearUtils.A.fromJson(replyData, HashMap.class);
                map.remove("replyData");
                map.remove("dataBean");
                CommunMessage communMessage = (CommunMessage) WearUtils.A.fromJson(WearUtils.A.toJson(map), CommunMessage.class);
                communMessage.setDataBean(communMessage.syncDecryptBean());
                if (communMessage != null) {
                    ChatRoomActivity.this.A0(communMessage, -1);
                }
            }
            if (TextUtils.isEmpty(text)) {
                return;
            }
            ChatRoomActivity.this.T.k(ChatRoomActivity.this.chatMessage, text, 20, entityChat.getPeopleData());
            ChatEditText chatEditText = ChatRoomActivity.this.chatMessage;
            chatEditText.setSelection(chatEditText.getText().toString().length());
            if (na2.m().u(ChatRoomActivity.this.u)) {
                ChatInputPanelPto.l = true;
                ChatRoomActivity.this.x6();
                ChatRoomActivity chatRoomActivity = ChatRoomActivity.this;
                ue3.d(chatRoomActivity.chatMessage, chatRoomActivity);
                ChatRoomActivity.this.chatRoomInputPanel.o();
                ChatRoomActivity.this.chatMessage.setFocusable(true);
                ChatRoomActivity.this.chatMessage.setFocusableInTouchMode(true);
                ChatRoomActivity.this.chatMessage.requestFocus();
            }
        }
    }

    public class h extends SimpleImageLoadingListener {
        public final /* synthetic */ ImageWatcher.g a;

        public h(ChatRoomActivity chatRoomActivity, ImageWatcher.g gVar) {
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

    public class h0 implements Runnable {
        public final /* synthetic */ CommunMessage a;

        public h0(CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ChatRoomActivity.this.Y.indexOf(this.a) == 0) {
                ChatRoomActivity.this.X.notifyItemChanged(ChatRoomActivity.this.Y.indexOf(this.a));
            } else {
                ChatRoomActivity.this.X.notifyItemRemoved(ChatRoomActivity.this.Y.indexOf(this.a));
                ChatRoomActivity.this.Y.remove(this.a);
                ChatRoomActivity.this.Y.add(0, this.a);
                ChatRoomActivity.this.X.notifyItemInserted(0);
            }
            ChatRoomActivity.this.r8();
        }
    }

    public class i implements View.OnTouchListener {
        public float a = 0.0f;
        public float b = 0.0f;

        public i() {
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
                    ChatRoomActivity.this.C0 = false;
                    ChatRoomActivity.this.x6();
                } else {
                    ChatRoomActivity.this.C0 = true;
                }
            }
            return false;
        }
    }

    public class i0 extends ClickableSpan {
        public i0() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            ChatRoomActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://hyttoapps.bandnana.com/remote/terms-and-conditions?pf=" + wg3.a() + "&lang=" + lg3.c(lg3.e(ChatRoomActivity.this)))));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    public class j extends RecyclerView.OnScrollListener {
        public j() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            ChatRoomActivity chatRoomActivity = ChatRoomActivity.this;
            chatRoomActivity.o = false;
            if (i == 0) {
                if (chatRoomActivity.y.findFirstCompletelyVisibleItemPosition() == 0) {
                    ChatRoomActivity.this.e0 = true;
                    ChatRoomActivity.this.o = true;
                }
                ChatRoomActivity.this.d7();
                return;
            }
            if (i == 1) {
                chatRoomActivity.e0 = false;
                ChatRoomActivity.this.Q6();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int iFindFirstVisibleItemPosition = ChatRoomActivity.this.y.findFirstVisibleItemPosition();
            if (ChatRoomActivity.this.y0 != null && ChatRoomActivity.this.z0 && iFindFirstVisibleItemPosition == 2 && i2 > 0 && !ChatRoomActivity.this.A0) {
                ChatRoomActivity.this.A0 = true;
                ChatRoomActivity.this.N7();
            }
            if (iFindFirstVisibleItemPosition <= ChatRoomActivity.this.d0) {
                ChatRoomActivity.this.P6(false);
                ChatRoomActivity.this.d0 = 0;
            }
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
            ChatRoomActivity.this.finish();
        }
    }

    public class k implements Animator.AnimatorListener {
        public k() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (ChatRoomActivity.this.h0.isEmpty()) {
                ChatRoomActivity.this.lottieView.setProgress(0.0f);
                ChatRoomActivity.this.lottieView.setVisibility(8);
                return;
            }
            ChatRoomActivity.this.L0.setVisibility(8);
            ie3 ie3Var = ChatRoomActivity.this.T;
            ChatRoomActivity chatRoomActivity = ChatRoomActivity.this;
            ie3Var.O(chatRoomActivity.lottieView, (String) chatRoomActivity.h0.get(0));
            ChatRoomActivity.this.h0.remove(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public class k0 implements rf3.i {
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
                    sg3.i(ChatRoomActivity.this.U, R.string.common_serverError);
                    return;
                }
                if (!normalResponse.isResult()) {
                    sg3.k(ChatRoomActivity.this.U, normalResponse.getMessage());
                    k0 k0Var = k0.this;
                    ChatRoomActivity.this.A8(k0Var.b, false);
                } else {
                    k0.this.a.setUrl(normalResponse.getMessage());
                    k0 k0Var2 = k0.this;
                    k0Var2.b.sendEntity(k0Var2.a);
                    k0 k0Var3 = k0.this;
                    ChatRoomActivity.this.D8(k0Var3.b, MessageType.pattern, false);
                }
            }
        }

        public k0(EntityPattern entityPattern, CommunMessage communMessage) {
            this.a = entityPattern;
            this.b = communMessage;
        }

        @Override // dc.rf3.i
        public void onError(NetException netException) {
            ChatRoomActivity.this.A8(this.b, false);
            ChatRoomActivity.this.P();
        }

        @Override // dc.rf3.i
        public void onSuccess(String str) {
            ChatRoomActivity.this.parentHandler.postDelayed(new a(str), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }

    public class l implements View.OnClickListener {

        public class a implements iv1 {
            public a() {
            }

            @Override // dc.iv1
            public void next() {
                ChatRoomActivity chatRoomActivity = ChatRoomActivity.this;
                pj3.j(chatRoomActivity, ChatRoomInfoActivity.class, "roomId", chatRoomActivity.S);
            }
        }

        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatRoomActivity.this.R8(new a());
        }
    }

    public class l0 implements Runnable {
        public final /* synthetic */ PatternOrAlarmSaveEvent a;
        public final /* synthetic */ CommunMessage b;

        public class a implements nf3.d {
            public final /* synthetic */ EntityPattern a;

            /* renamed from: com.wear.main.longDistance.ChatRoomActivity$l0$a$a, reason: collision with other inner class name */
            public class RunnableC0114a implements Runnable {
                public RunnableC0114a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    ChatRoomActivity.this.notifyDataSetChanged();
                    ChatRoomActivity.this.progressDialog.dismiss();
                }
            }

            public a(EntityPattern entityPattern) {
                this.a = entityPattern;
            }

            @Override // dc.nf3.d
            public void onRequestComplete(String str) throws IOException {
                if (WearUtils.e1(str) || str.contains("result")) {
                    sg3.i(ChatRoomActivity.this, R.string.file_notfound);
                } else {
                    String strReplace = str.replace("\r", "");
                    String status = l0.this.b.getStatus();
                    if (WearUtils.e1(status)) {
                        status = WearUtils.E();
                    }
                    if (rf3.o(strReplace)) {
                        strReplace = rf3.r(strReplace);
                    }
                    WearUtils.m2(strReplace, status);
                    Pattern pattern = new Pattern(status);
                    pattern.setName(this.a.getName());
                    pattern.setData(strReplace);
                    pattern.setCreator(WearUtils.y.r());
                    pattern.setEmail(WearUtils.y.r());
                    pattern.setAuthor(WearUtils.y.u().getUserName());
                    pattern.setTimer(WearUtils.Q(this.a.getTime()));
                    pattern.setToyFunc(this.a.getFeature());
                    if (pattern.getHead() != null && !WearUtils.e1(pattern.getHead().getToys()) && pattern.getHead().getToys().equalsIgnoreCase(Toy.TOY_XMACHINE)) {
                        pattern.setToyFeature(Toy.TOY_FEATURE_XMACHINE);
                    }
                    pattern.setAnony(true);
                    xe2.L0().t(pattern, true);
                    l0.this.b.setStatus(pattern.getId());
                    CommunMessage communMessageFindById = DaoUtils.getCommunMessageDao().findById(l0.this.b.getId());
                    if (communMessageFindById != null) {
                        communMessageFindById.setStatus(pattern.getId());
                        DaoUtils.getCommunMessageDao().updateOrAdd(communMessageFindById);
                        if (WearUtils.e1(DaoUtils.getCommunMessageDao().findById(l0.this.b.getId()).getStatus())) {
                            l0.this.b.setStatus(null);
                            sg3.i(ChatRoomActivity.this, R.string.chat_save_pattern_failed);
                        }
                    }
                }
                ChatRoomActivity.this.parentHandler.post(new RunnableC0114a());
            }
        }

        public l0(PatternOrAlarmSaveEvent patternOrAlarmSaveEvent, CommunMessage communMessage) {
            this.a = patternOrAlarmSaveEvent;
            this.b = communMessage;
        }

        @Override // java.lang.Runnable
        public void run() throws ParseException {
            if (this.a.getType() != 2) {
                if (this.a.getType() == 1) {
                    EntityPattern entityPattern = (EntityPattern) this.b.getDataBean();
                    nf3.b(entityPattern.getUrl(), new a(entityPattern));
                    return;
                }
                return;
            }
            EntityAlarm entityAlarm = (EntityAlarm) this.b.getDataBean();
            String id = entityAlarm.getId();
            entityAlarm.setId(WearUtils.E());
            this.b.setStatus(AlarmListItems.ALARM_STATUS_ACCEPT + id);
            this.b.sendEntity(entityAlarm);
            DaoUtils.getCommunMessageDao().update((CommunMessageDao) this.b);
            ChatRoomActivity.this.notifyDataSetChanged();
            AlarmListItems alarmListItemsFindAlarmByreceiveAlarmId = DaoUtils.getAlarmListDao().findAlarmByreceiveAlarmId(id);
            if (alarmListItemsFindAlarmByreceiveAlarmId != null) {
                alarmListItemsFindAlarmByreceiveAlarmId.setAccept(1);
                alarmListItemsFindAlarmByreceiveAlarmId.setIsSelected(1);
                DaoUtils.getAlarmListDao().updateOrAdd(alarmListItemsFindAlarmByreceiveAlarmId);
                zt3.t(ChatRoomActivity.this, alarmListItemsFindAlarmByreceiveAlarmId.getId(), false, true, false);
            }
            ChatRoomActivity.this.progressDialog.dismiss();
            ChatRoomActivity.this.notifyDataSetChanged();
        }
    }

    public class m extends SimpleImageLoadingListener {
        public m() {
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (bitmap != null) {
                ChatRoomActivity.this.ivChatBackground.setImageBitmap(bitmap);
                ChatRoomActivity.this.K8();
            }
            System.out.println(str);
        }
    }

    public class m0 implements kv1 {
        public final /* synthetic */ Runnable a;

        public class a implements Runnable {
            public final /* synthetic */ BaseResponse a;

            public a(BaseResponse baseResponse) {
                this.a = baseResponse;
            }

            @Override // java.lang.Runnable
            public void run() {
                ChatRoomActivity.this.progressDialog.dismiss();
                sg3.l(this.a.msg);
            }
        }

        public m0(Runnable runnable, PatternOrAlarmSaveEvent patternOrAlarmSaveEvent) {
            this.a = runnable;
        }

        @Override // dc.kv1
        public void a(String str) {
            try {
                BaseResponse baseResponse = (BaseResponse) JSON.parseObject(str, BaseResponse.class);
                if (baseResponse.getCode() == 1) {
                    ChatRoomActivity.this.parentHandler.post(this.a);
                } else {
                    ChatRoomActivity.this.parentHandler.post(new a(baseResponse));
                }
            } catch (Exception e) {
                e.printStackTrace();
                ChatRoomActivity.this.progressDialog.dismiss();
            }
        }

        @Override // dc.kv1
        public void onError(Exception exc) {
            exc.printStackTrace();
            ChatRoomActivity.this.progressDialog.dismiss();
        }
    }

    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatRoomActivity.this.q8(true);
        }
    }

    public class n0 implements mf2 {
        public n0() {
        }

        @Override // dc.mf2
        public void Q(String str) {
            ReceiveGroupMemberStateResponse receiveGroupMemberStateResponse = (ReceiveGroupMemberStateResponse) JSON.parseObject(str, ReceiveGroupMemberStateResponse.class);
            ChatRoomActivity.this.progressDialog.dismiss();
            for (ReceiveGroupMemberStateResponse.PlayerJidListBean playerJidListBean : receiveGroupMemberStateResponse.getPlayerJidList()) {
                GroupMember memberByJid = ChatRoomActivity.this.u.getMemberByJid(playerJidListBean.getJid());
                if (memberByJid != null) {
                    memberByJid.setOnLine(playerJidListBean.getOnLine() == 1);
                    memberByJid.setOpenfireStatus(playerJidListBean.getOpenfireStatus());
                    memberByJid.setScStatus(playerJidListBean.getScStatus());
                    memberByJid.setSupportMultiToOne(playerJidListBean.isSupportMultiToOne());
                    SyncLinkToy syncLinkToy = !TextUtils.isEmpty(playerJidListBean.getToyJson()) ? (SyncLinkToy) JSON.parseObject(CommunMessage.decrypt(playerJidListBean.getToyJson()), SyncLinkToy.class) : null;
                    if (syncLinkToy == null || syncLinkToy.getToys() == null) {
                        memberByJid.setToys(null);
                    } else {
                        memberByJid.setToys(syncLinkToy.getToys());
                    }
                }
            }
            Bundle bundle = new Bundle();
            bundle.putInt("flag", 3);
            bundle.putString("roomId", ChatRoomActivity.this.S);
            pj3.p(ChatRoomActivity.this, CreateChatRoomActivity.class, 20, bundle);
        }

        @Override // dc.mf2
        public void a(Throwable th) {
            ChatRoomActivity.this.progressDialog.dismiss();
        }
    }

    public class o implements u51 {

        public class a implements is3.d {
            public a() {
            }

            @Override // dc.is3.d
            public void doConfirm() {
                RequestPermissionActivity.s4(ChatRoomActivity.this);
            }
        }

        public o() {
        }

        @Override // dc.u51
        public void a(List<String> list, boolean z) {
            is3.b bVar = new is3.b(ChatRoomActivity.this.U);
            bVar.p(ah4.e(R.string.app_open_camera_permission));
            bVar.o(ah4.e(R.string.common_confirm));
            bVar.n(ah4.e(R.string.common_cancel));
            bVar.d(new a());
            cs3.h(bVar).show();
        }

        @Override // dc.u51
        public void b(List<String> list, boolean z) {
            if (z) {
                ChatRoomActivity.this.l8();
            }
        }
    }

    public class o0 implements mf2 {
        public o0() {
        }

        @Override // dc.mf2
        public void Q(String str) {
            ChatRoomActivity chatRoomActivity = ChatRoomActivity.this;
            chatRoomActivity.w.l1(chatRoomActivity.S, true);
            ChatRoomActivity.this.llBannar.setVisibility(8);
        }

        @Override // dc.mf2
        public void a(Throwable th) {
        }
    }

    public class p implements is3.d {
        public p() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            if (ChatRoomActivity.this.Q.exists()) {
                ChatRoomActivity.this.Q.delete();
            }
            x83.b().g("标题").i(false).j(true).k(true).a(false).h(true).e(9).f(false).d(ChatRoomActivity.this.O).c(new w83()).l(ChatRoomActivity.this, 23, 2);
        }
    }

    public class p0 implements mf2 {
        public p0() {
        }

        @Override // dc.mf2
        public void Q(String str) {
            ChatRoomActivity chatRoomActivity = ChatRoomActivity.this;
            chatRoomActivity.x.p1(chatRoomActivity.S, true);
            ChatRoomActivity.this.llDSBannar.setVisibility(8);
            me3.e(me3.a.GROUP_CHAT_DS_CONTROL);
            me3.d(me3.c.GROUP_CHAT_DS_CONTROL_BEGIN, me3.a());
            sz1.d().r(8);
            ye3.c("friend chatroom", "begin group D&S control", ChatRoomActivity.this.S);
        }

        @Override // dc.mf2
        public void a(Throwable th) {
        }
    }

    public class q implements is3.c {
        public q() {
        }

        @Override // dc.is3.c
        public void doCancel() {
            ChatRoomActivity chatRoomActivity = ChatRoomActivity.this;
            chatRoomActivity.R = tg3.m(chatRoomActivity, chatRoomActivity.Q, 32, 2);
        }
    }

    public class q0 implements mf2 {
        public q0() {
        }

        @Override // dc.mf2
        public void Q(String str) {
            ChatRoomActivity chatRoomActivity = ChatRoomActivity.this;
            chatRoomActivity.x.p1(chatRoomActivity.S, true);
            ChatRoomActivity.this.llDSBannar.setVisibility(8);
            me3.e(me3.a.GROUP_CHAT_DS_CONTROL);
            me3.d(me3.c.GROUP_CHAT_DS_CONTROL_BEGIN, me3.a());
            ye3.c("friend chatroom", "begin group D&S control", ChatRoomActivity.this.S);
            sz1.d().r(8);
        }

        @Override // dc.mf2
        public void a(Throwable th) {
        }
    }

    public class r implements Runnable {
        public r() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b() {
            ChatRoomActivity.this.r8();
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatRoomActivity chatRoomActivity = ChatRoomActivity.this;
            ue3.d(chatRoomActivity.chatMessage, chatRoomActivity);
            ChatRoomActivity chatRoomActivity2 = ChatRoomActivity.this;
            if (chatRoomActivity2.o) {
                chatRoomActivity2.parentHandler.postDelayed(new Runnable() { // from class: dc.j52
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b();
                    }
                }, 100L);
            }
        }
    }

    public class r0 implements is3.d {
        public r0(ChatRoomActivity chatRoomActivity) {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            MyApplication.g0 = true;
        }
    }

    public class s implements Runnable {
        public s() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatRoomActivity.this.chatMoreLayer.setVisibility(0);
            ChatRoomActivity.this.chatEmojisPanel.setVisibility(0);
        }
    }

    public class s0 implements db2.s {
        public s0() {
        }

        @Override // dc.db2.s
        public void a() {
            if (ChatRoomActivity.this.isFinishing()) {
                return;
            }
            ChatRoomActivity.this.W8();
        }
    }

    public class t implements is3.c {
        public final /* synthetic */ iv1 a;

        public t(iv1 iv1Var) {
            this.a = iv1Var;
        }

        @Override // dc.is3.c
        public void doCancel() {
            ChatRoomActivity.this.w.o3();
            ChatRoomActivity.this.x.w2();
            iv1 iv1Var = this.a;
            if (iv1Var != null) {
                iv1Var.next();
            }
        }
    }

    public class t0 implements is3.d {
        public t0() {
        }

        @Override // dc.is3.d
        public void doConfirm() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            ChatRoomActivity.this.llSurvey.setVisibility(8);
            eg3.j(ChatRoomActivity.this, "show_survey_group", false);
        }
    }

    public class u implements is3.d {
        public final /* synthetic */ is3.c a;

        public u(is3.c cVar) {
            this.a = cVar;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            this.a.doCancel();
            od3.d(ChatRoomActivity.this.U);
        }
    }

    public class u0 implements mf2 {
        public u0() {
        }

        @Override // dc.mf2
        public void Q(String str) {
            ReceiveGroupMemberStateResponse receiveGroupMemberStateResponse = (ReceiveGroupMemberStateResponse) JSON.parseObject(str, ReceiveGroupMemberStateResponse.class);
            ChatRoomActivity.this.progressDialog.dismiss();
            for (ReceiveGroupMemberStateResponse.PlayerJidListBean playerJidListBean : receiveGroupMemberStateResponse.getPlayerJidList()) {
                GroupMember memberByJid = ChatRoomActivity.this.u.getMemberByJid(playerJidListBean.getJid());
                if (memberByJid != null) {
                    memberByJid.setOnLine(playerJidListBean.getOnLine() == 1);
                    memberByJid.setOpenfireStatus(playerJidListBean.getOpenfireStatus());
                    memberByJid.setScStatus(playerJidListBean.getScStatus());
                    memberByJid.setSupportMultiToOne(playerJidListBean.isSupportMultiToOne());
                    SyncLinkToy syncLinkToy = !TextUtils.isEmpty(playerJidListBean.getToyJson()) ? (SyncLinkToy) JSON.parseObject(CommunMessage.decrypt(playerJidListBean.getToyJson()), SyncLinkToy.class) : null;
                    if (syncLinkToy == null || syncLinkToy.getToys() == null) {
                        memberByJid.setToys(null);
                    } else {
                        memberByJid.setToys(syncLinkToy.getToys());
                    }
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString("roomId", ChatRoomActivity.this.S);
            pj3.p(ChatRoomActivity.this, GroupDsControlSelectsubPeopleActivity.class, 21, bundle);
        }

        @Override // dc.mf2
        public void a(Throwable th) {
            ChatRoomActivity.this.progressDialog.dismiss();
        }
    }

    public class v implements is3.d {
        public final /* synthetic */ is3.c a;

        public v(is3.c cVar) {
            this.a = cVar;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            this.a.doCancel();
            od3.d(ChatRoomActivity.this.U);
        }
    }

    public class v0 implements is3.d {
        public v0() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            ChatRoomActivity.this.tvJoin.performClick();
        }
    }

    public class w implements MyActionBar.f {

        public class a implements iv1 {
            public a() {
            }

            @Override // dc.iv1
            public void next() {
                if (ChatRoomActivity.this.B0) {
                    pj3.k(ChatRoomActivity.this, MainActivity.class, "isFinishToLongDistance", true);
                }
                ChatRoomActivity.this.finish();
            }
        }

        public w() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            ChatRoomActivity.this.R8(new a());
        }
    }

    public class w0 implements is3.d {
        public w0() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            ChatRoomActivity.this.tvDSJoin.performClick();
        }
    }

    public class x implements Runnable {
        public x() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatRoomActivity.this.X.notifyDataSetChanged();
            ChatRoomActivity.this.X.d = false;
        }
    }

    public class x0 implements Runnable {
        public final /* synthetic */ int a;

        public x0(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatRoomActivity.this.chatMessageList.scrollToPosition(this.a);
        }
    }

    public class y implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public y(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatRoomActivity.this.X.notifyItemRangeChanged(this.a, this.b);
            ChatRoomActivity.this.X.d = false;
        }
    }

    public class y0 implements rf3.i {
        public final /* synthetic */ EntityPattern a;

        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                ChatRoomActivity.this.progressDialog.dismiss();
                NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(this.a, NormalResponse.class);
                if (normalResponse == null) {
                    sg3.i(ChatRoomActivity.this, R.string.common_serverError);
                    return;
                }
                if (normalResponse.isResult()) {
                    y0.this.a.setUrl(normalResponse.getMessage());
                    y0 y0Var = y0.this;
                    ChatRoomActivity.this.y8(y0Var.a, MessageType.pattern);
                } else {
                    sg3.k(ChatRoomActivity.this, normalResponse.getMessage());
                    if (!MyApplication.P || hu3.x() == null) {
                        y0 y0Var2 = y0.this;
                        ChatRoomActivity.this.B8(y0Var2.a);
                    }
                }
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ChatRoomActivity.this.progressDialog.dismiss();
                y0 y0Var = y0.this;
                ChatRoomActivity.this.B8(y0Var.a);
                ChatRoomActivity.this.P();
            }
        }

        public y0(EntityPattern entityPattern) {
            this.a = entityPattern;
        }

        @Override // dc.rf3.i
        public void onError(NetException netException) {
            ChatRoomActivity.this.parentHandler.post(new b());
        }

        @Override // dc.rf3.i
        public void onSuccess(String str) {
            ChatRoomActivity.this.parentHandler.post(new a(str));
        }
    }

    public class z implements kn3.d {
        public z() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            RequestPermissionActivity.s4(ChatRoomActivity.this);
        }
    }

    public class z0 implements Runnable {
        public final /* synthetic */ View a;

        public z0(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup viewGroup = (ViewGroup) this.a.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.a);
            }
            ChatRoomActivity.this.V8();
            ChatRoomActivity.this.chatLiveSyncLayer.setVisibility(0);
            ChatRoomActivity.this.chatLiveSyncLayer.addView(this.a);
        }
    }

    public ChatRoomActivity() {
        File fileE0 = WearUtils.e0("camera.jpg");
        this.Q = fileE0;
        Uri.fromFile(fileE0);
        this.S = "";
        this.T = new ie3();
        this.U = this;
        this.V = new so3();
        this.Y = new LinkedList();
        this.Z = 0;
        this.a0 = null;
        this.c0 = new LinkedList<>();
        this.d0 = -1;
        this.e0 = true;
        this.f0 = false;
        this.h0 = new ArrayList();
        this.w0 = -1;
        this.A0 = false;
        this.D0 = false;
        this.E0 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B7(List list) {
        int size = this.Y.size();
        this.Y.addAll(EntityUnSupport.filterMessages((List<CommunMessage>) list));
        Q7(size, this.Y.size() - size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D7() {
        final ArrayList<CommunMessage> arrayList = new ArrayList();
        if (this.y0 == null) {
            CommunMessageDao communMessageDao = DaoUtils.getCommunMessageDao();
            String strP = WearUtils.y.p();
            String strK0 = WearUtils.k0(this.S);
            int i2 = this.Z + 1;
            this.Z = i2;
            arrayList.addAll(communMessageDao.findByPage(strP, strK0, i2, 10));
        } else {
            arrayList.addAll(DaoUtils.getCommunMessageDao().findBeforeMessage(WearUtils.y.p(), WearUtils.k0(this.S), this.Y.get(r5.size() - 1), 10));
        }
        for (CommunMessage communMessage : arrayList) {
            if (be3.E(communMessage.getCreated(), communMessage.getSendStatus())) {
                communMessage.setSendStatus(4);
            }
            communMessage.setDataBean(communMessage.syncDecryptBean());
        }
        runOnMainThread(new Runnable() { // from class: dc.n52
            @Override // java.lang.Runnable
            public final void run() {
                this.a.B7(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F7() {
        if (this.B0) {
            pj3.k(this, MainActivity.class, "isFinishToLongDistance", true);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H7() {
        if (!isFinishing() && u6()) {
            GetGroupMemberStateRequest getGroupMemberStateRequest = new GetGroupMemberStateRequest();
            getGroupMemberStateRequest.setPlayerJidList(new ArrayList(this.u.getMembers().keySet()));
            getGroupMemberStateRequest.setAckId(WearUtils.E());
            this.progressDialog.show();
            this.z.a(getGroupMemberStateRequest, new n0());
        }
    }

    public static /* synthetic */ int I5(ChatRoomActivity chatRoomActivity) {
        int i2 = chatRoomActivity.d0;
        chatRoomActivity.d0 = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J7() {
        this.o = true;
        LinearLayoutManager linearLayoutManager = this.y;
        if (linearLayoutManager == null || linearLayoutManager.getItemCount() <= 0) {
            return;
        }
        this.y.scrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L7() {
        L8(findViewById(R.id.v_chat_live_layer).getLayoutParams().height - this.j0.getHeight());
        this.x0 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j7() {
        this.chatRoomInputPanel.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l7() {
        M8(findViewById(R.id.v_chat_live_layer).getLayoutParams().height - this.j0.getHeight());
        this.x0 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean n7(CommunMessage communMessage, EntityChat entityChat) {
        if (this.c0.size() == 0) {
            return false;
        }
        boolean zRemove = this.c0.remove(communMessage.getId());
        if (this.c0.size() > 0) {
            this.tvCount.setText("" + this.c0.size());
        } else {
            this.flA.setVisibility(8);
        }
        return zRemove;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean p7(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        i8();
        this.chatRoomInputPanel.o();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r7(Context context, String str, ImageWatcher.g gVar) {
        ImageLoader.getInstance().loadImage(str, MyApplication.Y, new h(this, gVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t7(int i2) {
        if (this.y.findLastVisibleItemPosition() < i2) {
            MessageNewAdapter messageNewAdapter = this.X;
            messageNewAdapter.b = i2;
            messageNewAdapter.notifyItemChanged(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v7(View view) {
        String first = this.c0.size() > 0 ? this.c0.getFirst() : "";
        if (TextUtils.isEmpty(first)) {
            this.flA.setVisibility(8);
            return;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.Y.size()) {
                i2 = -1;
                break;
            } else if (this.Y.get(i2).getId().equals(first)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            this.y.scrollToPositionWithOffset(i2, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x7(List list) {
        this.Y.addAll(0, EntityUnSupport.filterMessages((List<CommunMessage>) list));
        this.X.notifyItemRangeInserted(0, list.size());
        this.A0 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z7() {
        boolean z2 = false;
        final List<CommunMessage> listFindAfterMessage = DaoUtils.getCommunMessageDao().findAfterMessage(WearUtils.y.p(), WearUtils.k0(this.S), this.Y.get(0), 10);
        if (listFindAfterMessage != null && listFindAfterMessage.size() == 10) {
            z2 = true;
        }
        this.z0 = z2;
        if (listFindAfterMessage == null || listFindAfterMessage.isEmpty()) {
            return;
        }
        for (CommunMessage communMessage : listFindAfterMessage) {
            if (be3.E(communMessage.getCreated(), communMessage.getSendStatus())) {
                communMessage.setSendStatus(4);
            }
            communMessage.setDataBean(communMessage.syncDecryptBean());
        }
        this.parentHandler.post(new Runnable() { // from class: dc.x52
            @Override // java.lang.Runnable
            public final void run() {
                this.a.x7(listFindAfterMessage);
            }
        });
    }

    @Override // dc.sa2
    public void A0(CommunMessage communMessage, int i2) {
        String str;
        addAnalyticsEventId("chat_reply", null);
        this.l0 = communMessage;
        if (communMessage == null) {
            return;
        }
        this.j0.setVisibility(0);
        String realFromNickName = "";
        if (WearUtils.g0(A6(this.l0.getFrom())).equals(this.v.getId())) {
            if (!WearUtils.e1(this.v.getUserName())) {
                realFromNickName = this.v.getUserName();
            }
        } else if (!WearUtils.e1(this.l0.getRealFromNickName())) {
            realFromNickName = this.l0.getRealFromNickName();
        }
        this.m0.setText(realFromNickName);
        int i3 = b1.a[this.l0.getType().ordinal()];
        if (i3 == 1) {
            this.T.i(this.n0, ((EntityChat) this.l0.getDataBean()).getText());
            this.n0.setVisibility(0);
            this.p0.setVisibility(8);
            this.r0.setVisibility(8);
            this.s0.setVisibility(8);
        } else if (i3 == 2) {
            this.n0.setVisibility(8);
            this.p0.setVisibility(8);
            this.r0.setVisibility(0);
            this.s0.setVisibility(8);
            J8(communMessage);
        } else if (i3 == 3) {
            this.n0.setVisibility(8);
            this.p0.setVisibility(8);
            this.r0.setVisibility(8);
            this.s0.setVisibility(0);
            EntityAudio entityAudio = new EntityAudio(communMessage.getData());
            boolean zIsExpired = entityAudio.isExpired();
            TextView textView = this.o0;
            if (zIsExpired) {
                str = "[" + ah4.e(R.string.voice_message_expired) + "]";
            } else {
                str = entityAudio.getTime() + "''";
            }
            textView.setText(str);
            G8(this.t0, zIsExpired ? nz1.e().f().B() : nz1.e().f().o());
        } else if (i3 == 4) {
            this.n0.setVisibility(8);
            this.p0.setVisibility(0);
            this.r0.setVisibility(8);
            this.s0.setVisibility(8);
            I8(communMessage);
        }
        if (this.x0) {
            return;
        }
        this.parentHandler.postDelayed(new b(), 300L);
    }

    public String A6(String str) {
        if (WearUtils.e1(str)) {
            return str;
        }
        String strF = nd3.f(str);
        return WearUtils.e1(strF) ? str : strF;
    }

    public void A8(CommunMessage communMessage, boolean z2) {
        try {
            communMessage.setSendStatus(4);
            if (z2) {
                communMessage.setCreated(be3.u());
            }
            if (P7(communMessage)) {
                DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
                this.X.notifyDataSetChanged();
                r8();
            }
        } catch (Exception e2) {
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    public String B6() {
        return this.S;
    }

    public void B8(DataEntityAbstract dataEntityAbstract) {
        CommunMessage communMessage = new CommunMessage();
        communMessage.setFrom(WearUtils.y.p());
        communMessage.setTo(WearUtils.k0(this.S));
        communMessage.sendEntity(dataEntityAbstract);
        communMessage.setId(WearUtils.E());
        communMessage.setUserId(communMessage.getFrom());
        communMessage.setSendStatus(4);
        if (dataEntityAbstract instanceof EntityChat) {
            this.T.M(((EntityChat) dataEntityAbstract).getText());
            communMessage.setShowEmojiAnim(!TextUtils.isEmpty(this.T.s(r4, false)));
        }
        if (P7(communMessage)) {
            DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
            E0(communMessage);
        }
    }

    @Override // dc.sa2
    public IPeopleInfo C() {
        return this.u;
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
        this.X.notifyItemChanged(this.Y.indexOf(communMessage));
        map.put("chat_type", 2);
        ye3.e("M0019", map);
    }

    public final void C6(int i2, Intent intent) {
        if (i2 == -1) {
            GroupMember groupMember = (GroupMember) intent.getSerializableExtra("groupMember");
            this.chatMessage.d(null, groupMember.getRealNickName(), groupMember.getJid());
            ue3.d(this.chatMessage, this);
            this.chatRoomInputPanel.e();
        }
    }

    public final void C8(CommunMessage communMessage) {
        if (zb2.O().B(communMessage.getType())) {
            zb2.O().G0(WearUtils.k0(this.S), communMessage, false, null);
        } else {
            sg3.l(ah4.e(R.string.operate_frequently));
        }
    }

    public final void D6(int i2, Intent intent) {
        if (i2 == -1) {
            int intExtra = intent.getIntExtra("status", 0);
            if (intExtra == 0) {
                AckCreateMultiToOneInfoResponse ackCreateMultiToOneInfoResponse = (AckCreateMultiToOneInfoResponse) intent.getSerializableExtra("data");
                this.x.L(this.u);
                this.x.K2(this, this.S, ackCreateMultiToOneInfoResponse);
            } else if (intExtra == 1) {
                this.x.K1(new a0());
            } else if (intExtra == 2) {
                this.w.U1(this.S, new b0());
            }
            try {
                MusicControl.h0().S();
                y12.c.a().t();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void D8(CommunMessage communMessage, MessageType messageType, boolean z2) {
        communMessage.setSendStatus(2);
        if (z2) {
            communMessage.setCreated(be3.u());
        }
        String strT = null;
        if (messageType == MessageType.chat) {
            String text = ((EntityChat) communMessage.getDataBean()).getText();
            this.T.M(text);
            communMessage.setShowEmojiAnim(!TextUtils.isEmpty(this.T.s(text, false)));
            strT = this.T.t(text, h7(communMessage.getDataBean()));
        }
        int iIndexOf = this.Y.indexOf(communMessage);
        this.Y.remove(communMessage);
        this.X.notifyItemRemoved(iIndexOf);
        if (zb2.O().B(communMessage.getType())) {
            zb2.O().G0(WearUtils.k0(this.S), communMessage, true, strT);
        }
    }

    @Override // dc.sa2
    public boolean E() {
        return false;
    }

    @Override // dc.xb2
    public void E0(CommunMessage communMessage) {
        Account accountU;
        String strK0 = WearUtils.k0(this.S);
        if (TextUtils.isEmpty(strK0) || communMessage == null) {
            return;
        }
        if ((strK0.equals(communMessage.getFrom()) || strK0.equals(communMessage.getTo())) && (accountU = ch3.n().u()) != null) {
            boolean zEquals = WearUtils.X(communMessage.getFrom()).equals(accountU.getId());
            if (this.y0 != null && this.z0) {
                if (zEquals) {
                    n8(communMessage);
                }
            } else {
                if (zEquals) {
                    if (!this.f0) {
                        this.e0 = true;
                    }
                    this.f0 = false;
                }
                runOnMainThread(new g0(communMessage, zEquals));
            }
        }
    }

    @Override // com.wear.widget.CustomSwipeRefreshLayout.a
    public boolean E2() {
        if (!this.o) {
            return true;
        }
        g8();
        return false;
    }

    public final void E6(int i2, Intent intent) {
        if (i2 != -1 || intent == null) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("isAddEmojis", false);
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("delIds");
        if (booleanExtra) {
            this.T.A();
        }
        if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.Y) {
            Iterator<String> it = stringArrayListExtra.iterator();
            while (it.hasNext()) {
                String next = it.next();
                for (CommunMessage communMessage : this.Y) {
                    if (communMessage.getId().equals(next)) {
                        arrayList.add(communMessage);
                    }
                }
            }
            if (arrayList.size() > 0) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    CommunMessage communMessage2 = (CommunMessage) it2.next();
                    this.m.j0(communMessage2);
                    this.m.x(communMessage2);
                }
            }
        }
    }

    public final void E8() {
        String strTrim = this.chatMessage.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim)) {
            is3.b bVar = new is3.b(this.U);
            bVar.p(ah4.e(R.string.chat_unable_send_blank_message));
            bVar.o(ah4.e(R.string.common_ok));
            bVar.b(false);
            cs3.h(bVar).show();
        } else {
            EntityChat entityChat = new EntityChat();
            entityChat.setText(strTrim);
            entityChat.setPeopleData(this.chatMessage.getUserBean());
            y8(entityChat, MessageType.chat);
            addAnalyticsEventId("chat_text", null);
        }
        this.chatMessage.setText("");
    }

    public final void F6(int i2, Intent intent) {
        if (i2 == -1) {
            boolean booleanExtra = intent.getBooleanExtra("grant_all", false);
            intent.getIntArrayExtra("grant_results");
            if (booleanExtra) {
                l8();
            } else {
                new kn3((Context) this, ah4.e(R.string.app_open_camera_permission), ah4.e(R.string.common_confirm), ah4.e(R.string.common_cancel), true, (kn3.d) new z()).show();
            }
        }
    }

    public final void F8() {
        String str;
        try {
            DSGroupInfoBean dSGroupInfoBean = this.G;
            if (dSGroupInfoBean == null) {
                this.llDSBannar.setVisibility(8);
                this.llBannarDSBottom.setVisibility(8);
                Timer timer = this.D;
                if (timer != null) {
                    timer.cancel();
                    this.D = null;
                    return;
                }
                return;
            }
            if (dSGroupInfoBean.isStart()) {
                this.tvDSJoin.setAlpha(1.0f);
                this.F = this.u.getMemberByJid(this.G.getCurrentPlayerJid());
                this.C = this.G.getControlStartTime();
            } else {
                if (this.K) {
                    this.tvDSJoin.setAlpha(1.0f);
                } else {
                    this.tvDSJoin.setAlpha(0.4f);
                }
                long createTime = this.G.getCreateTime();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (65000 + createTime < jCurrentTimeMillis) {
                    this.llDSBannar.setVisibility(8);
                    this.llBannarDSBottom.setVisibility(8);
                    Timer timer2 = this.D;
                    if (timer2 != null) {
                        timer2.cancel();
                        this.D = null;
                        return;
                    }
                    return;
                }
                this.C = 60 - ((jCurrentTimeMillis - createTime) / 1000);
            }
            if (!this.G.isStart()) {
                if (this.E == null) {
                    this.llDSBannar.setVisibility(8);
                    this.llBannarDSBottom.setVisibility(8);
                    Timer timer3 = this.D;
                    if (timer3 != null) {
                        timer3.cancel();
                        this.D = null;
                        return;
                    }
                    return;
                }
                long j2 = this.C;
                if (j2 < 0) {
                    j2 = 0;
                }
                if (this.llBannarDSBottom.getVisibility() != 0) {
                    str = this.K ? String.format(ah4.e(R.string.ds_controlling_bar_folded4), this.E.getNickName(), WearUtils.J0(j2)) : String.format(ah4.e(R.string.ds_controlling_bar_folded1), this.E.getNickName(), WearUtils.J0(j2));
                } else if (this.K) {
                    str = String.format(ah4.e(R.string.ds_controlling_bar_unfolded2), this.E.getNickName(), this.t.size() + "");
                } else {
                    str = String.format(ah4.e(R.string.ds_controlling_bar_unfolded1), this.E.getNickName());
                }
                this.tvShowDSBannar.setText(str);
                return;
            }
            long jCurrentTimeMillis2 = (System.currentTimeMillis() - this.C) / 1000;
            if (this.F == null) {
                this.llDSBannar.setVisibility(8);
                this.llBannarDSBottom.setVisibility(8);
                Timer timer4 = this.D;
                if (timer4 != null) {
                    timer4.cancel();
                    this.D = null;
                    return;
                }
                return;
            }
            if (this.llBannarDSBottom.getVisibility() == 0) {
                this.tvShowDSBannar.setText(String.format(ah4.e(R.string.ds_controlling_bar_unfolded2), this.E.getNickName(), this.t.size() + ""));
            } else {
                String strJ0 = WearUtils.J0(jCurrentTimeMillis2);
                String str2 = String.format(ah4.e(R.string.ds_controlling_bar_folded2), this.F.getNickName(), this.E.getNickName(), strJ0);
                SpannableString spannableString = new SpannableString(str2);
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(th4.b(this, R.color.ds_color));
                int iIndexOf = str2.indexOf(this.F.getNickName());
                int iIndexOf2 = str2.indexOf(strJ0);
                if (iIndexOf != -1) {
                    spannableString.setSpan(CharacterStyle.wrap(foregroundColorSpan), iIndexOf, this.F.getNickName().length() + iIndexOf, 34);
                }
                if (iIndexOf2 != -1) {
                    spannableString.setSpan(CharacterStyle.wrap(foregroundColorSpan), iIndexOf2, strJ0.length() + iIndexOf2, 34);
                }
                this.tvShowDSBannar.setText(spannableString);
            }
            this.s.notifyDataSetChanged();
        } catch (Exception e2) {
            e2.printStackTrace();
            this.llDSBannar.setVisibility(8);
            this.llBannarDSBottom.setVisibility(8);
            Timer timer5 = this.D;
            if (timer5 != null) {
                timer5.cancel();
                this.D = null;
            }
        }
    }

    public final void G6(int i2, Intent intent) {
        List list;
        if (i2 == -1) {
            if (intent.getBooleanExtra("delect", false) && intent.getSerializableExtra("communMessage") != null && (list = (List) intent.getSerializableExtra("communMessage")) != null && list.size() > 0) {
                for (int i3 = 0; i3 < this.Y.size(); i3++) {
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        if (((CommunMessage) list.get(i4)).toString().equals(this.Y.get(i3).toString())) {
                            DaoUtils.getCommunMessageDao().delT(this.Y.get(i3));
                            this.Y.remove(i3);
                            this.X.notifyDataSetChanged();
                            this.X.notifyItemChanged(i3);
                        }
                    }
                }
            }
            if (intent.getBooleanExtra("recall", false) && intent.getSerializableExtra("recallCommunMessage") != null) {
                List list2 = (List) intent.getSerializableExtra("recallCommunMessage");
                if (list2 != null && list2.size() > 0) {
                    for (int i5 = 0; i5 < this.Y.size(); i5++) {
                        for (int i6 = 0; i6 < list2.size(); i6++) {
                            if (((CommunMessage) list2.get(i6)).toString().equals(this.Y.get(i5).toString())) {
                                EntitySystem entitySystem = new EntitySystem();
                                entitySystem.addDataToArray(EntitySystem.SystemOPTType.T300.toString(), EntitySystem.SystemOPTCode.C320.toString(), this.Y.get(i5).getId());
                                this.Y.get(i5).sendEntity(entitySystem);
                                DaoUtils.getCommunMessageDao().update((CommunMessageDao) this.Y.get(i5));
                                DaoUtils.getReCallDao().delById(this.Y.get(i5).getId());
                                if (this.Y.get(i5).isFromGroup()) {
                                    CommunMessage communMessage = new CommunMessage();
                                    communMessage.setFrom(WearUtils.y.p());
                                    communMessage.setTo(this.Y.get(i5).getTo());
                                    communMessage.sendEntity(entitySystem);
                                    communMessage.setId(WearUtils.E());
                                    zb2.O().G0(communMessage.getTo(), communMessage, false, null);
                                } else {
                                    zb2.O().F0(WearUtils.x, this.Y.get(i5).getTo(), entitySystem);
                                }
                            }
                        }
                    }
                }
                this.X.notifyDataSetChanged();
            }
            if (!intent.getBooleanExtra("hide", false) || intent.getExtras().getSerializable("hideMap") == null) {
                return;
            }
            Map<? extends String, ? extends String> map = (Map) intent.getExtras().getSerializable("hideMap");
            this.a0.clear();
            this.a0.putAll(map);
            this.X.notifyDataSetChanged();
        }
    }

    public final void G8(ImageView imageView, int i2) {
        imageView.setImageDrawable(th4.d(imageView.getContext(), i2));
    }

    @Override // dc.sa2
    public boolean H1(boolean z2) {
        View childAt;
        boolean z3 = (this.y.findLastVisibleItemPosition() == this.y.getItemCount() - 1 || this.y.findLastVisibleItemPosition() == this.y.getItemCount()) && ((childAt = this.chatMessageList.getChildAt(this.y.findLastVisibleItemPosition() - this.y.findFirstVisibleItemPosition())) == null || this.chatMessageList.getHeight() >= childAt.getBottom());
        if (z2) {
            if (this.y.getItemCount() >= 10) {
                if (!this.y.getStackFromEnd()) {
                    this.y.setStackFromEnd(true);
                }
            } else if (this.y.findLastVisibleItemPosition() == -1 || this.y.findFirstVisibleItemPosition() == 0) {
                this.y.setStackFromEnd(false);
            } else if (!z3 || this.y.findLastVisibleItemPosition() <= 0) {
                if (z3) {
                    this.y.setStackFromEnd(false);
                } else if (!this.y.getStackFromEnd()) {
                    this.y.setStackFromEnd(true);
                }
            } else if (!this.y.getStackFromEnd()) {
                this.y.setStackFromEnd(true);
            }
        }
        return z3;
    }

    @Override // dc.sa2
    public View H2(String str) {
        return this.X.T(str);
    }

    @Override // dc.sa2
    public void H3(CommunMessage communMessage, EntityShortVideo entityShortVideo) {
        this.I0 = communMessage;
        ue3.a(this.chatMessage, this);
        W3();
        if (entityShortVideo instanceof EntityBurnShortVideo) {
            VideoPlayerActivity.w4(this, entityShortVideo, 24);
        } else {
            VideoPlayerActivity.u4(this, entityShortVideo);
        }
    }

    public final void H6(Intent intent) {
        if (intent == null) {
            return;
        }
        this.O = intent.getStringArrayListExtra("selectItems");
        this.P = intent.getParcelableArrayListExtra("selectMediaFile");
        boolean booleanExtra = intent.getBooleanExtra("isBurnAfterReading", false);
        Iterator<MediaFile> it = this.P.iterator();
        while (it.hasNext()) {
            MediaFile next = it.next();
            fk3 fk3Var = new fk3(WearUtils.k0(this.S), booleanExtra, WearUtils.E());
            fk3Var.I(this);
            fk3Var.executeOnExecutor(vg3.b().c(), next);
        }
    }

    public final void H8(int i2) {
        String str = "setMPadding bottomP:" + i2;
        if (i2 > 0) {
            if (this.j0.getVisibility() == 0 && !this.x0) {
                i2 += this.j0.getHeight();
                this.x0 = true;
            }
            if (this.j0.getVisibility() == 8 && this.x0) {
                i2 -= this.j0.getHeight();
                this.x0 = false;
            }
        } else {
            if (this.j0.getVisibility() == 0 && !this.x0) {
                i2 += this.j0.getHeight();
                this.x0 = true;
            }
            if (this.j0.getVisibility() == 8 && this.x0) {
                i2 -= this.j0.getHeight();
                this.x0 = false;
            }
        }
        int height = this.v_chat_live_layer.getHeight() + i2;
        int i3 = this.i0;
        if ((i3 > 0 && height >= i3 * 2) || height >= this.chatRoomInputPanel.getPanelTypeHeight() * 2) {
            height -= i2;
        }
        String str2 = "setMPadding bottom 1:" + height;
        L8(height);
    }

    @Override // com.wear.widget.CustomSwipeRefreshLayout.a
    public boolean I2(MotionEvent motionEvent) {
        if (!g7(this.chatMessage, motionEvent)) {
            return true;
        }
        x6();
        return false;
    }

    public final void I6(CommunMessage communMessage) {
        C2(communMessage);
        Z3();
    }

    public final void I8(CommunMessage communMessage) {
        EntityPicture entityPicture = new EntityPicture(communMessage.getData());
        String url = entityPicture.getUrl();
        String localUrl = entityPicture.getLocalUrl();
        String type = entityPicture.getType();
        boolean z2 = !WearUtils.e1(type) && type.equals("emoji");
        this.m.F(communMessage.getId());
        if (!WearUtils.e1(localUrl) && (WearUtils.c0(localUrl).exists() || WearUtils.Z(localUrl).exists() || WearUtils.a0(localUrl).exists())) {
            ImageLoader.getInstance().displayImage(Uri.fromFile(z2 ? WearUtils.Z(localUrl).exists() ? WearUtils.Z(localUrl) : WearUtils.a0(localUrl) : WearUtils.c0(localUrl)).toString(), this.p0, MyApplication.Y, new c());
            return;
        }
        if (WearUtils.e1(url)) {
            return;
        }
        ImageLoader imageLoader = ImageLoader.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append(WearUtils.e);
        sb.append(z2 ? url.replace("thum_", "") : url);
        imageLoader.displayImage(sb.toString(), this.p0, MyApplication.Y, new d(z2, url));
    }

    public final void J6(Intent intent) {
        CommunMessage communMessage;
        if (intent == null || intent.getExtras() == null || intent.getExtras().getSerializable("communMessage") == null || (communMessage = (CommunMessage) intent.getExtras().getSerializable("communMessage")) == null) {
            return;
        }
        for (CommunMessage communMessage2 : this.Y) {
            if (TextUtils.equals(communMessage2.getId(), communMessage.getId())) {
                I6(communMessage2);
                return;
            }
        }
    }

    public final void J8(CommunMessage communMessage) {
        EntityShortVideo entityShortVideo = new EntityShortVideo(communMessage.getData());
        String picUrl = entityShortVideo.getPicUrl();
        String picLocalUrl = entityShortVideo.getPicLocalUrl();
        this.m.F(communMessage.getId());
        if (!WearUtils.e1(picLocalUrl) && (WearUtils.c0(picLocalUrl).exists() || WearUtils.Z(picLocalUrl).exists() || WearUtils.a0(picLocalUrl).exists())) {
            ImageLoader.getInstance().displayImage(Uri.fromFile(WearUtils.c0(picLocalUrl)).toString(), this.q0, MyApplication.Y, new e());
        } else {
            if (WearUtils.e1(picUrl)) {
                return;
            }
            ImageLoader.getInstance().displayImage(WearUtils.e + picUrl, this.q0, MyApplication.Y, new f(picUrl));
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void JUtilsEvent(hh0 hh0Var) {
        if (hh0Var.a() != 1) {
            H8(hh0Var.b());
            return;
        }
        this.chatRoomMorePanel.setVisibility(0);
        this.vChatRoomMenu.setVisibility(0);
        ue3.a(this.chatMessage, this);
        this.L = true;
        this.btnChatEmojis.setImageResource(R.drawable.chat_function_emojis);
        this.btnChatMore.setImageResource(R.drawable.chat_function_openfunction);
        this.chatRoomInputPanel.m(false, 0);
    }

    @Override // dc.sa2
    public void K() {
        s6();
    }

    @Override // com.wear.widget.iwatcher.ImageWatcher.j
    public void K3(ImageView imageView, String str, int i2) {
        this.m.P(imageView, str, i2);
    }

    public final void K6(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(ImagesContract.URL);
            String stringExtra2 = intent.getStringExtra("time");
            String stringExtra3 = intent.getStringExtra("name");
            String stringExtra4 = intent.getStringExtra("toyFunc");
            intent.getStringExtra("toyFeature");
            String stringExtra5 = intent.getStringExtra("patternId");
            String stringExtra6 = intent.getStringExtra("localUrl");
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
                if (WearUtils.e1(stringExtra3)) {
                    stringExtra3 = ah4.e(R.string.chat_pattern_by_create_default_name);
                }
                entityPattern.setName(stringExtra3);
                if (!WearUtils.e1(stringExtra)) {
                    addAnalyticsEventId("chat_pattern", null);
                }
                z8(entityPattern, WearUtils.e1(stringExtra));
            }
        }
    }

    public final void K8() {
    }

    @Override // dc.ah3
    public void L3(CommunMessage communMessage) {
        A8(communMessage, false);
    }

    public final void L6(int i2, Intent intent) {
        if (i2 == -1) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("data");
            this.w.L(this.u);
            this.w.D3(this, this.S, stringArrayListExtra);
        }
    }

    public final void L8(int i2) {
        ViewGroup.LayoutParams layoutParams = this.v_chat_live_layer.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = i2;
        this.v_chat_live_layer.setVisibility(0);
        this.v_chat_live_layer.setLayoutParams(layoutParams);
        this.v_chat_live_layer.invalidate();
        if ((this.y0 == null || !this.z0) && this.o) {
            r8();
        }
        this.J0 = System.currentTimeMillis();
        String str = "setMPadding setViewLayerHeight:" + i2;
    }

    @Override // dc.sa2
    public void M(EntityPattern entityPattern) {
        if (WearUtils.e1(entityPattern.getLocalUrl())) {
            return;
        }
        File file = new File(nd3.i(entityPattern.getLocalUrl()));
        if (!file.exists()) {
            P();
        } else {
            this.progressDialog.show();
            rf3.s(file, new y0(entityPattern));
        }
    }

    @Override // dc.gv1
    public void M0() {
        JUtilsEvent(new hh0(1, 0));
    }

    public final void M6(int i2, Intent intent) {
        if (i2 == -1) {
            int intExtra = intent.getIntExtra("takeType", 0);
            boolean booleanExtra = intent.getBooleanExtra("isBurnAfterReading", false);
            if (intExtra == 0) {
                String stringExtra = intent.getStringExtra("imagePath");
                MediaFile mediaFile = new MediaFile();
                mediaFile.m(stringExtra);
                fk3 fk3Var = new fk3(WearUtils.k0(this.S), booleanExtra, WearUtils.E());
                fk3Var.I(this);
                fk3Var.execute(mediaFile);
                return;
            }
            String stringExtra2 = intent.getStringExtra("recordFilePath");
            int intExtra2 = intent.getIntExtra(TypedValues.TransitionType.S_DURATION, 0);
            MediaFile mediaFile2 = new MediaFile();
            mediaFile2.m(stringExtra2);
            mediaFile2.h(intExtra2);
            fk3 fk3Var2 = new fk3(WearUtils.k0(this.S), booleanExtra, WearUtils.E());
            fk3Var2.I(this);
            fk3Var2.execute(mediaFile2);
        }
    }

    public final void M7(CommunMessage communMessage) {
        runOnMainThread(new h0(communMessage));
    }

    public final void M8(int i2) {
        ViewGroup.LayoutParams layoutParams = this.v_chat_live_layer.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = i2;
        this.v_chat_live_layer.setVisibility(0);
        this.v_chat_live_layer.setLayoutParams(layoutParams);
        this.v_chat_live_layer.invalidate();
        this.J0 = System.currentTimeMillis();
        String str = "setMPadding setViewLayerHeight:" + i2;
    }

    @Override // dc.gv1
    public void N1(IPeopleInfo iPeopleInfo, int i2) {
        if (iPeopleInfo.getUserJid().equals(this.u.getUserJid())) {
            X8(i2);
        }
    }

    public void N6() {
        ChatActionMenuFragmentBottom chatActionMenuFragmentBottom = this.N0;
        if (chatActionMenuFragmentBottom != null && chatActionMenuFragmentBottom.isVisible()) {
            this.N0.dismiss();
        }
        Dialog dialog = this.O0;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.O0.dismiss();
    }

    public void N7() {
        vg3.b().a(new Runnable() { // from class: dc.t52
            @Override // java.lang.Runnable
            public final void run() {
                this.a.z7();
            }
        });
    }

    public final void N8() {
        N6();
        this.chatMoreLayer.setVisibility(0);
        ue3.a(this.chatMessage, this);
        V8();
        this.L = true;
        this.btnChatEmojis.setImageResource(R.drawable.chat_function_emojis);
        this.chatEmojisPanel.setVisibility(8);
        this.chatLiveSyncLayer.setVisibility(0);
    }

    @Override // com.wear.widget.chatMic.VoiceMessagePanelView.b
    public void O() {
        String str = "cancelRecord: delete file :" + vd0.e(this.W);
    }

    @Override // dc.xb2
    public boolean O3(String str) {
        if (str.equals(this.S)) {
            return true;
        }
        return WearUtils.k0(this.S).equals(str);
    }

    public final void O6() {
        ChatGroupControl.o1().s1();
        ChatDSControl.r1().u1();
    }

    public final void O7(String str) {
        runOnMainThread(new d0(this, str));
    }

    public void O8() {
        N8();
        this.x.y2(this.u);
    }

    @Override // dc.sa2
    public void P() {
        runOnMainThread(new c0());
    }

    public final void P6(boolean z2) {
        if (z2) {
            this.newMessageBar.setVisibility(0);
        } else {
            this.newMessageBar.setVisibility(4);
        }
    }

    public final boolean P7(CommunMessage communMessage) {
        return zb2.O().l0(communMessage);
    }

    public final void P8(CommunMessage communMessage) {
        String str = null;
        String strS = communMessage.getDataBean() instanceof EntityChat ? this.T.s(((EntityChat) communMessage.getDataBean()).getText(), true) : null;
        if (TextUtils.isEmpty(strS)) {
            if (communMessage.getType() == MessageType.chat) {
                if (communMessage.getDataBean() == null) {
                    communMessage.setDataBean(communMessage.syncDecryptBean());
                }
                if (WearUtils.R0(((EntityChat) communMessage.getDataBean()).getText())) {
                    j8();
                }
                this.g0 = null;
                return;
            }
            return;
        }
        if (!this.T.B(strS)) {
            this.g0 = null;
        } else {
            if (this.D0) {
                this.F0 = communMessage;
                return;
            }
            CommunMessage communMessage2 = this.g0;
            if (communMessage2 != null) {
                String strS2 = this.T.s(((EntityChat) communMessage2.getDataBean()).getText(), true);
                if (!TextUtils.equals(this.g0.getRealFrom(), communMessage.getRealFrom()) && TextUtils.equals(strS, strS2)) {
                    str = strS;
                }
            }
            this.g0 = communMessage;
            strS = str;
        }
        if (TextUtils.isEmpty(strS)) {
            return;
        }
        if (this.lottieView.o()) {
            this.h0.add(strS);
            return;
        }
        this.lottieView.setVisibility(0);
        this.L0.setVisibility(8);
        this.T.O(this.lottieView, strS);
    }

    @Override // dc.sa2
    public void Q1(HashMap<String, String> map) {
    }

    public final void Q6() {
        LinearLayout linearLayout = this.llUnreadBar;
        if (linearLayout == null || linearLayout.getVisibility() != 0) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(250L);
        LinearLayout linearLayout2 = this.llUnreadBar;
        if (linearLayout2 == null || linearLayout2.getVisibility() != 0) {
            return;
        }
        this.llUnreadBar.startAnimation(alphaAnimation);
        this.llUnreadBar.setVisibility(8);
    }

    public final void Q7(int i2, int i3) {
        runOnMainThread(new y(i2, i3));
    }

    public final void Q8() {
        R8(null);
    }

    @Override // dc.sa2
    public void R2(int i2, CommunMessage communMessage) {
        List<CommunMessage> list = this.Y;
        if (list == null || list.size() <= i2) {
            return;
        }
        if (!this.Y.get(i2).getId().equals(communMessage.getId())) {
            Iterator<CommunMessage> it = this.Y.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                CommunMessage next = it.next();
                if (next.getId().equals(communMessage.getId())) {
                    next.sendEntity(communMessage.getDataBean());
                    CommunMessage communMessage2 = this.g0;
                    if (communMessage2 != null && next == communMessage2) {
                        this.g0 = null;
                    }
                }
            }
        } else {
            this.Y.get(i2).sendEntity(communMessage.getDataBean());
            if (this.g0 != null && this.Y.get(i2) == this.g0) {
                this.g0 = null;
            }
        }
        for (CommunMessage communMessage3 : this.Y) {
            if (!WearUtils.e1(communMessage3.getReplyData())) {
                HashMap map = (HashMap) WearUtils.A.fromJson(communMessage3.getReplyData(), HashMap.class);
                Gson gson = WearUtils.A;
                map.remove("replyData");
                map.remove("dataBean");
                CommunMessage communMessage4 = (CommunMessage) WearUtils.A.fromJson(WearUtils.A.toJson(map), CommunMessage.class);
                if (communMessage4.getId().equals(communMessage.getId()) || communMessage4.getId().equals(communMessage.getReceiveId()) || ((!WearUtils.e1(communMessage4.getReceiveId()) && communMessage4.getReceiveId().equals(communMessage.getReceiveId())) || (!WearUtils.e1(communMessage4.getReceiveId()) && communMessage4.getReceiveId().equals(communMessage.getId())))) {
                    communMessage4.setType(MessageType.system);
                    communMessage4.setReplyData("recall");
                    communMessage3.setReplyData(WearUtils.A.toJson(communMessage4));
                    DaoUtils.getCommunMessageDao().update((CommunMessageDao) communMessage3);
                }
            }
        }
        notifyDataSetChanged();
        CommunMessage communMessage5 = this.l0;
        if (communMessage5 == null || !communMessage5.getId().equals(communMessage.getId())) {
            return;
        }
        w6();
    }

    public final void R6() {
        this.K0.setScaleType(di1.FIT_CENTER);
        this.K0.setAnimListener(new a1());
    }

    public final void R7(View view) {
        if (ah0.a) {
            return;
        }
        this.chatRoomInputPanel.f();
        V7(view);
    }

    public final void R8(iv1 iv1Var) {
        t tVar = new t(iv1Var);
        if (MyApplication.i0 || od3.c(this.U)) {
            tVar.doCancel();
            return;
        }
        if (this.w.r()) {
            MyApplication.i0 = true;
            is3.b bVar = new is3.b(this.U);
            bVar.p(ah4.e(R.string.enable_floating_window_des));
            bVar.o(ah4.e(R.string.common_ok));
            bVar.n(ah4.e(R.string.common_cancel));
            bVar.d(new u(tVar));
            bVar.c(tVar);
            bVar.q(ah4.e(R.string.enable_floating_window_title));
            cs3.h(bVar).show();
            return;
        }
        if (!this.x.r()) {
            tVar.doCancel();
            return;
        }
        MyApplication.i0 = true;
        is3.b bVar2 = new is3.b(this.U);
        bVar2.p(this.application.getString(R.string.enable_floating_window_des));
        bVar2.o(this.application.getString(R.string.common_ok));
        bVar2.n(this.application.getString(R.string.common_cancel));
        bVar2.d(new v(tVar));
        bVar2.c(tVar);
        bVar2.q(this.application.getString(R.string.enable_floating_window_title));
        cs3.h(bVar2).show();
    }

    public final void S6() {
        this.X.J1(new MessageNewAdapter.u0() { // from class: dc.o52
            @Override // com.wear.adapter.longdistance.MessageNewAdapter.u0
            public final boolean a(CommunMessage communMessage, EntityChat entityChat) {
                return this.a.n7(communMessage, entityChat);
            }
        });
    }

    public final void S7() {
        pj3.j(this, AlarmCreateActivity.class, "userId", this.S);
    }

    public void S8() {
        N8();
        this.w.p3(this.u);
    }

    @Override // dc.sa2
    public void T0(CommunMessage communMessage) {
        if (communMessage != null) {
            getWindow().setFlags(8192, 8192);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void T6() {
        this.chatMessage.addTextChangedListener(new g());
        this.chatMessage.setOnTouchListener(new View.OnTouchListener() { // from class: dc.u52
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.a.p7(view, motionEvent);
            }
        });
    }

    public final void T7() {
        startActivityForResult(new Intent(this, (Class<?>) PatternSendActivity.class), 18);
    }

    public final void T8(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        String str3 = String.format(str, str2);
        int iIndexOf = str3.indexOf(str2);
        spannableStringBuilder.append((CharSequence) str3);
        if (iIndexOf != -1) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.pink)), iIndexOf, str2.length() + iIndexOf, 34);
            spannableStringBuilder.setSpan(new i0(), iIndexOf, str2.length() + iIndexOf, 34);
        }
        kn3 kn3Var = new kn3((Context) this.U, "", ah4.e(R.string.common_ok), false, false, (kn3.d) new j0());
        kn3Var.show();
        kn3Var.c().setText(spannableStringBuilder);
        kn3Var.c().setMovementMethod(new LinkMovementMethod());
        kn3Var.n();
    }

    @Override // dc.sa2
    public HashMap<String, GifImageView> U3() {
        return this.X.a;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void U6() {
        this.chatMessageList.setOnTouchListener(new i());
        this.chatMessageList.addOnScrollListener(new j());
    }

    public final void U7() {
        if (!uf2.v().q()) {
            uf2.v().B();
            sg3.k(this, ah4.e(R.string.common_settingTip));
        } else if (na2.m().h(this.u, MessageType.sync)) {
            db2.A().q(new db2.s() { // from class: dc.v52
                @Override // dc.db2.s
                public final void a() {
                    this.a.H7();
                }
            });
        }
    }

    public final void U8() {
        LinearLayout linearLayout = this.llUnreadBar;
        if (linearLayout == null || linearLayout.getVisibility() == 0) {
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(500L);
        this.llUnreadBar.startAnimation(translateAnimation);
        this.llUnreadBar.setVisibility(0);
    }

    public final void V6() {
        if (this.u.isExit()) {
            return;
        }
        this.parentHandler.postDelayed(new g1(), 200L);
    }

    public final void V7(View view) {
        setVolumeControlStream(3);
        if (this.L) {
            h8();
        } else {
            i8();
        }
    }

    public final void V8() {
        ChatGroupControl.o1().v3();
    }

    @Override // com.wear.widget.chatMic.VoiceMessagePanelView.b
    public void W2() throws IllegalStateException, IOException {
        if (E()) {
            return;
        }
        this.P0 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(WearUtils.T("mic").getAbsolutePath());
        sb.append("/");
        sb.append(WearUtils.B(System.currentTimeMillis() + ".acc"));
        String string = sb.toString();
        this.W = string;
        boolean zW = this.V.w(string);
        this.chatRoomInputPanel.p(this.V.o());
        if (zW) {
            return;
        }
        sg3.i(this, R.string.chat_record_failure);
    }

    @Override // dc.sa2
    public void W3() {
        this.D0 = true;
    }

    public final void W6() {
        if (this.u.isExit()) {
            if (this.u.getStatus() == 3) {
                finish();
            }
            this.rlSendMessage.setVisibility(8);
            this.tvInvitationCount.setVisibility(8);
            x6();
            if (this.u.isRoomDisbanded()) {
                this.tvExitTip.setText(String.format(ah4.e(R.string.notification_group_disbanded), ah4.e(R.string.terms_and_conditions)));
            }
            this.tvExitTip.setVisibility(0);
            X8(2);
            this.llBannarBottom.setVisibility(8);
            this.llBannar.setVisibility(8);
            if (this.w.r() && this.w.D(this.u.getId())) {
                this.w.i1(this.S, this, false, false);
            }
        } else if (this.u.isRoomProhibited()) {
            this.rlSendMessage.setVisibility(8);
            this.tvInvitationCount.setVisibility(8);
            x6();
            this.tvExitTip.setText(String.format(ah4.e(R.string.notification_group_words_prohibited), ah4.e(R.string.terms_and_conditions1)));
            this.tvExitTip.setVisibility(0);
            this.llBannarBottom.setVisibility(8);
            this.llBannar.setVisibility(8);
            if (this.w.r() && this.w.D(this.u.getId())) {
                this.w.i1(this.S, this, false, false);
            }
        } else {
            this.tvExitTip.setVisibility(8);
            this.rlSendMessage.setVisibility(0);
        }
        GroupMember memberByJid = this.u.getMemberByJid(ch3.n().p());
        if (memberByJid == null || memberByJid.isAdmin()) {
            return;
        }
        this.tvInvitationCount.setVisibility(8);
    }

    public final void W7(boolean z2) {
        this.u0.setVisibility(z2 ? 0 : 8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.chatRoomInputPanel.getChatMessageContainer().getLayoutParams();
        layoutParams.addRule(16, z2 ? R.id.chat_pictures : R.id.btn_chat_send);
        this.chatRoomInputPanel.getChatMessageContainer().setLayoutParams(layoutParams);
        this.chatRoomInputPanel.getChat_voice().setVisibility(z2 ? 0 : 4);
        this.chatRoomInputPanel.getChatSend().setVisibility(z2 ? 8 : 0);
    }

    public final void W8() {
        if (na2.m().h(this.u, MessageType.live) && u6()) {
            GetGroupMemberStateRequest getGroupMemberStateRequest = new GetGroupMemberStateRequest();
            getGroupMemberStateRequest.setPlayerJidList(new ArrayList(this.u.getMembers().keySet()));
            getGroupMemberStateRequest.setAckId(WearUtils.E());
            this.progressDialog.show();
            this.z.a(getGroupMemberStateRequest, new u0());
        }
    }

    @Override // dc.sa2
    public void X2() {
    }

    public final void X6() {
        this.vImageWatcher.setTranslucentStatus(gg3.g(this));
        this.vImageWatcher.setErrorImageRes(R.drawable.error_picture);
        this.vImageWatcher.setLoader(new ImageWatcher.i() { // from class: dc.l52
            @Override // com.wear.widget.iwatcher.ImageWatcher.i
            public final void a(Context context, String str, ImageWatcher.g gVar) {
                this.a.r7(context, str, gVar);
            }
        });
        this.vImageWatcher.setOnPictureLongPressListener(this);
    }

    public final void X7() {
        is3.b bVar = new is3.b(this);
        bVar.p(ah4.e(R.string.notification_close_survey));
        bVar.d(new t0());
        cs3.h(bVar).show();
    }

    public final void X8(int i2) {
        Group group = this.u;
        if (group == null || !group.isExit()) {
            RequestRoomControllerSub requestRoomControllerSub = new RequestRoomControllerSub();
            requestRoomControllerSub.setRoomId(this.S);
            requestRoomControllerSub.setSubType(i2);
            zb2.O().C0(requestRoomControllerSub, WearUtils.k0(this.S), null);
        }
    }

    public final void Y6() {
        T6();
        X6();
        U6();
        S6();
        f7();
        Z6();
    }

    public final void Y7() {
        if (uf2.v().q()) {
            db2.A().q(new s0());
        } else {
            uf2.v().B();
            sg3.k(this, ah4.e(R.string.common_settingTip));
        }
    }

    public final void Y8(String str) {
        if (this.T.D(str) && eg3.d(this.U, "isFirstSend", true) && str.contains(this.T.k)) {
            if (this.D0) {
                this.E0 = true;
            } else if (ke3.a("new_user", "isFirstSend")) {
                new LoveEmojisDialog(this.U).show();
            }
        }
    }

    @Override // com.wear.adapter.longdistance.MessageNewAdapter.t0
    public void Z1() {
        vg3.b().a(new Runnable() { // from class: dc.s52
            @Override // java.lang.Runnable
            public final void run() {
                this.a.D7();
            }
        });
    }

    @Override // dc.sa2
    public void Z2() {
        getWindow().clearFlags(8192);
    }

    @Override // dc.sa2
    public void Z3() {
        this.D0 = false;
        if (this.E0) {
            this.E0 = false;
            if (ke3.a("new_user", "isFirstSend")) {
                new LoveEmojisDialog(this).show();
            }
        }
        CommunMessage communMessage = this.F0;
        if (communMessage != null) {
            P8(communMessage);
            this.F0 = null;
        }
    }

    public final void Z6() {
        this.lottieView.e(new k());
    }

    public final void Z7() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (TextUtils.isEmpty(this.G0)) {
            return;
        }
        if (!this.H0) {
            eg3.j(this, "show_survey_close", true);
            this.H0 = true;
            this.ivSurveyClose.setVisibility(0);
            this.ivSurveyClose.setEnabled(true);
        }
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.G0)));
    }

    public void Z8() {
        List<CommunMessage> listFindUnReadMessage = DaoUtils.getCommunMessageDao().findUnReadMessage(WearUtils.y.p(), WearUtils.k0(this.S), 0, 10, this.b0.getCreated(), false);
        for (int i2 = 0; i2 < this.n && i2 <= listFindUnReadMessage.size() - 1; i2++) {
            CommunMessage communMessage = listFindUnReadMessage.get(i2);
            if (communMessage.getDataBean() == null) {
                communMessage.setDataBean(communMessage.syncDecryptBean());
            }
            if (communMessage.getType() == MessageType.chat && WearUtils.R0(((EntityChat) communMessage.getDataBean()).getText())) {
                j8();
                return;
            }
        }
    }

    @Override // com.wear.widget.chatMic.VoiceMessagePanelView.b
    public void a1() throws IllegalStateException {
        this.V.H();
        long jCurrentTimeMillis = (System.currentTimeMillis() - this.P0) / 1000;
        if (jCurrentTimeMillis < 1) {
            sg3.i(this, R.string.chat_voice_timeShort);
            O();
            return;
        }
        if (!WearUtils.e1(this.W) && new File(this.W).exists()) {
            EntityAudio entityAudio = new EntityAudio();
            entityAudio.setLocalUrl(this.W);
            if (jCurrentTimeMillis > 60) {
                jCurrentTimeMillis = 60;
            }
            entityAudio.setTime(jCurrentTimeMillis);
            CommunMessage communMessage = new CommunMessage();
            communMessage.setFrom(WearUtils.y.p());
            communMessage.setTo(WearUtils.k0(this.S));
            communMessage.setUserId(WearUtils.y.p());
            communMessage.sendEntity(entityAudio);
            communMessage.setRealFrom(communMessage.getFrom());
            communMessage.setId(WearUtils.E());
            if (P7(communMessage)) {
                DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
                E0(communMessage);
            }
            u8(communMessage);
        }
    }

    public final void a7() {
        this.Z = 0;
        ArrayList<CommunMessage> arrayList = new ArrayList();
        if (this.y0 == null) {
            List<CommunMessage> listFindByPage = DaoUtils.getCommunMessageDao().findByPage(WearUtils.y.p(), WearUtils.k0(this.S), 0, 10);
            if (listFindByPage != null && !listFindByPage.isEmpty()) {
                arrayList.addAll(listFindByPage);
            }
        } else {
            List<CommunMessage> listFindAfterMessage = DaoUtils.getCommunMessageDao().findAfterMessage(WearUtils.y.p(), WearUtils.k0(this.S), this.y0, 10);
            if (listFindAfterMessage != null && !listFindAfterMessage.isEmpty()) {
                arrayList.addAll(listFindAfterMessage);
            }
            this.z0 = arrayList.size() == 10;
            arrayList.add(this.y0);
        }
        for (CommunMessage communMessage : arrayList) {
            if (communMessage.getType() == MessageType.shortvideo || communMessage.getType() == MessageType.burnvideo) {
                new fk3(WearUtils.k0(this.S), communMessage.syncDecryptBean() instanceof EntityBurnShortVideo, communMessage.getId()).I(this);
            } else if (be3.E(communMessage.getCreated(), communMessage.getSendStatus())) {
                communMessage.setSendStatus(4);
            }
            communMessage.setDataBean(communMessage.syncDecryptBean());
        }
        CommunMessage communMessageH = df3.e().h(WearUtils.k0(this.S));
        this.b0 = communMessageH;
        this.n = 0;
        if (communMessageH != null) {
            this.n = DaoUtils.getCommunMessageDao().findUnReadSize(WearUtils.y.p(), WearUtils.k0(this.S), 0, 10, this.b0.getCreated(), false);
        }
        this.Y.clear();
        this.Y.addAll(EntityUnSupport.filterMessages(arrayList));
        this.c0.clear();
        if (this.n > 0) {
            Z8();
            if (this.llUnreadBar.getTag() == null && this.n > 10) {
                LinearLayout linearLayout = this.llUnreadBar;
                linearLayout.setTag(Integer.valueOf(linearLayout.getId()));
                String str = this.n + "";
                if (this.n > 99) {
                    str = "99+";
                }
                this.tvUnreadNotice.setText(String.format(ah4.e(R.string.chat_new_message_icon), str));
                U8();
                this.llUnreadBar.setOnClickListener(new n());
            }
            List<CommunMessage> listFindUnReadByPage = DaoUtils.getCommunMessageDao().findUnReadByPage(WearUtils.y.p(), WearUtils.k0(this.S), this.Z + 1, 10, this.n);
            this.Y.addAll(new ArrayList(EntityUnSupport.filterMessages(listFindUnReadByPage)));
            int size = this.n == 0 ? this.Y.size() : this.Y.size() - this.n;
            final int i2 = -1;
            for (int i3 = 0; i3 < this.Y.size(); i3++) {
                CommunMessage communMessage2 = this.Y.get(i3);
                if (be3.E(communMessage2.getCreated(), communMessage2.getSendStatus())) {
                    communMessage2.setSendStatus(4);
                }
                communMessage2.setDataBean(communMessage2.syncDecryptBean());
                if (i3 >= size && (communMessage2.getDataBean() instanceof EntityChat) && !communMessage2.getFrom().equals(this.v.getUserJid())) {
                    EntityChat entityChat = (EntityChat) communMessage2.getDataBean();
                    if (entityChat.getPeopleData() != null) {
                        Iterator<EntityChatABean> it = entityChat.getPeopleData().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (this.v.getUserJid().equals(it.next().getJid())) {
                                    this.c0.add(communMessage2.getId());
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
                if (this.b0.getId().equals(communMessage2.getId()) && i2 == -1) {
                    i2 = i3;
                }
            }
            this.Z += (listFindUnReadByPage.size() / 10) + (listFindUnReadByPage.size() % 10 > 0 ? 1 : 0);
            this.parentHandler.post(new Runnable() { // from class: dc.q52
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.t7(i2);
                }
            });
        }
        MessageNewAdapter messageNewAdapter = this.X;
        messageNewAdapter.d = false;
        messageNewAdapter.notifyDataSetChanged();
        if (this.c0.size() != 0) {
            this.tvCount.setText("" + this.c0.size());
            this.flA.setVisibility(0);
        } else {
            this.flA.setVisibility(8);
        }
        if (this.n <= 10) {
            this.n = 0;
        }
        CommunMessage communMessage3 = this.y0;
        if (communMessage3 == null) {
            this.y.scrollToPosition(0);
        } else {
            t8(this.Y.indexOf(communMessage3));
        }
        v6(true);
    }

    public final void a8() {
        if (this.B == null) {
            this.llBannar.setVisibility(8);
            this.llBannarBottom.setVisibility(8);
            return;
        }
        this.llBannarBottom.setVisibility(8);
        this.tvShowBannar.setText(String.format(ah4.e(R.string.group_chat_control_member), this.B.getNickName(), (this.t.size() - 1) + ""));
    }

    public final void a9() {
        String str;
        if (this.d0 >= 99) {
            str = "99+";
        } else {
            str = (this.d0 + 1) + "";
        }
        this.newMessageNum.setText(String.format(ah4.e(R.string.chat_new_message_icon), str));
    }

    @Override // dc.jv1
    public void addViewToActivity(View view) {
        if (System.currentTimeMillis() - this.N < 100) {
            return;
        }
        this.N = System.currentTimeMillis();
        this.chatLiveSyncLayer.removeAllViews();
        this.chatLiveSyncLayer.setVisibility(4);
        this.chatMoreLayer.setVisibility(0);
        this.parentHandler.postDelayed(new z0(view), 10L);
    }

    @Override // dc.sa2
    public String b0() {
        return WearUtils.k0(this.S);
    }

    @Override // dc.ah3
    public void b3(String str, CommunMessage communMessage, int i2) {
        int iIndexOf = this.Y.indexOf(communMessage);
        if (iIndexOf != -1) {
            this.Y.set(iIndexOf, communMessage);
        }
        x8(str, communMessage, i2);
    }

    public final void b7() {
        this.j0 = this.chatRoomInputPanel.getLl_reply();
        this.m0 = this.chatRoomInputPanel.getTv_reply_name();
        this.n0 = this.chatRoomInputPanel.getTv_reply_content();
        this.k0 = this.chatRoomInputPanel.getIv_close_reply();
        this.p0 = this.chatRoomInputPanel.getMiv_reply_user_picture();
        this.q0 = this.chatRoomInputPanel.getMiv_reply_user_video_picture();
        this.o0 = this.chatRoomInputPanel.getReply_voice_time();
        this.r0 = this.chatRoomInputPanel.getRl_reply_video();
        this.s0 = this.chatRoomInputPanel.getLl_reply_voice();
        this.t0 = this.chatRoomInputPanel.getReply_voice_icon();
        this.u0 = this.chatRoomInputPanel.getChatPicture();
        this.K0 = (AnimView) findViewById(R.id.player_view);
        this.L0 = (FrameLayout) findViewById(R.id.fl_full_screen_animation);
        this.M0 = (ImageView) findViewById(R.id.iv_full_screen_animation);
        this.k0.setOnClickListener(new d1());
        this.chatLiveSyncLayer.setListener(new e1());
        R6();
    }

    public final void b8() {
        if (this.E == null) {
            this.llDSBannar.setVisibility(8);
            this.llBannarDSBottom.setVisibility(8);
        } else {
            this.llBannarDSBottom.setVisibility(8);
            F8();
        }
    }

    @Override // dc.xb2
    public void c0(String str, String str2) {
    }

    @Override // dc.ah3
    public void c1(CommunMessage communMessage) {
        E0(communMessage);
    }

    public final void c7() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String showNickName = TextUtils.isEmpty(this.u.getRemark()) ? this.u.getShowNickName() : this.u.getRemark();
        String str = "(" + this.u.getMembers().size() + ")";
        StringBuilder sb = new StringBuilder();
        if (showNickName.length() > 16) {
            sb.append(showNickName.substring(0, 15));
            sb.append("...");
            sb.append(str);
        } else {
            sb.append(showNickName);
            sb.append(str);
        }
        this.abTitle.setTitle(sb.toString());
        if (pf3.d(this)) {
            eg3.j(this, "SearchChatTip_" + ch3.n().r(), true);
            return;
        }
        this.abTitle.setNewMessagePoint(true ^ eg3.d(this, "SearchChatTip_" + ch3.n().r(), false));
    }

    public final void c8() {
        DSGroupInfoBean dSGroupInfoBean = this.G;
        if (dSGroupInfoBean != null) {
            if (dSGroupInfoBean.isStart()) {
                this.x.K1(new p0());
            } else if (this.K) {
                this.x.K1(new q0());
            }
        }
    }

    @Override // dc.sa2
    public List<CommunMessage> d0() {
        return this.Y;
    }

    public final void d7() {
        if (this.b0 == null || this.n <= 0) {
            return;
        }
        int iFindFirstVisibleItemPosition = this.y.findFirstVisibleItemPosition();
        if (iFindFirstVisibleItemPosition < 0) {
            iFindFirstVisibleItemPosition = 0;
        }
        if (iFindFirstVisibleItemPosition >= this.Y.size()) {
            q8(false);
            return;
        }
        CommunMessage communMessage = this.Y.get(iFindFirstVisibleItemPosition);
        if (communMessage == null || !be3.C(this.b0.getCreated(), communMessage.getCreated(), 0)) {
            return;
        }
        q8(false);
    }

    public final void d8() {
        this.w.U1(this.S, new o0());
    }

    public final void e7() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.Y.clear();
        this.X.notifyDataSetChanged();
        this.a0 = DaoUtils.getMessageHideDao().getHidesToMap(WearUtils.y.p(), WearUtils.k0(this.S));
        a7();
        df3.e().c(this.u.getId());
        df3.e().d(this.u.getUserJid());
        this.u.clearAtMe();
        if (!this.u.isExit()) {
            hu3.z(this).r(this.u.getId(), null, true);
            if (this.u.iIsAdamin()) {
                zb2.O().Q(this.S);
            }
        }
        W6();
        c7();
        V6();
        this.llBannar.setVisibility(8);
        this.llBannarBottom.setVisibility(8);
        if (this.w.r()) {
            this.w.p3(this.u);
        } else {
            this.w.L(this.u);
            this.w.z1(this.S);
            this.w.l1(this.S, true);
        }
        this.w.A1();
        if (this.x.r()) {
            this.progressDialog.dismiss();
            this.x.y2(this.u);
        } else {
            this.x.L(this.u);
            this.x.A1(this.S);
            this.x.p1(this.S, true);
        }
        this.x.D1();
        ChatSyncControl.N0().e1(this.u);
        ChatLiveControl.q0().O0(this.u);
        ChatGroupControl.o1().w2(this.u);
        ChatDSControl.r1().W1(this.u);
        if (!this.u.isExit()) {
            X8(1);
        } else {
            this.progressDialog.dismiss();
            X8(2);
        }
    }

    public final void e8() {
        this.llBannarBottom.setVisibility(0);
        this.tvShowBannar.setText(String.format(ah4.e(R.string.group_chat_join_sync), this.t.size() + ""));
    }

    public final void f7() {
        this.flA.setOnClickListener(new View.OnClickListener() { // from class: dc.i52
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.v7(view);
            }
        });
    }

    public final void f8() {
        this.llBannarDSBottom.setVisibility(0);
        F8();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    public boolean g7(View view, MotionEvent motionEvent) {
        if (view == null || !(view instanceof EditText)) {
            return false;
        }
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        view.getHeight();
        view.getWidth();
        return motionEvent.getY() <= ((float) i3);
    }

    public final void g8() {
        if (this.u.isExit() || !this.u.isRoomActive()) {
            return;
        }
        ue3.a(this.chatMessage, this);
        this.chatEmojisPanel.setVisibility(8);
        this.btnChatEmojis.setImageResource(R.drawable.chat_function_emojis);
        this.L = true;
        this.vChatRoomMenu.setVisibility(0);
        this.chatMoreLayer.setVisibility(0);
        this.chatLiveSyncLayer.setVisibility(8);
        Q8();
        if (this.o) {
            r8();
        }
        this.chatRoomInputPanel.g(true);
    }

    @Override // dc.sa2
    public String getUserName() {
        return null;
    }

    @Override // dc.ah3
    public void h0(String str, CommunMessage communMessage, int i2) {
        v8(str, communMessage, i2);
    }

    public final boolean h7(DataEntityAbstract dataEntityAbstract) {
        String strS = dataEntityAbstract instanceof EntityChat ? this.T.s(((EntityChat) dataEntityAbstract).getText(), true) : null;
        if (TextUtils.isEmpty(strS)) {
            return false;
        }
        if (!this.T.B(strS)) {
            return true;
        }
        CommunMessage communMessage = this.g0;
        if (communMessage != null) {
            return !TextUtils.equals(this.g0.getFrom(), WearUtils.y.p()) && TextUtils.equals(strS, this.T.s(((EntityChat) communMessage.getDataBean()).getText(), true));
        }
        return false;
    }

    public final void h8() {
        this.L = false;
        ue3.a(this.chatMessage, this);
        this.chatLiveSyncLayer.setVisibility(8);
        boolean z2 = this.M;
        if (!z2) {
            this.M = !z2;
            this.chatMessage.setVisibility(0);
        }
        this.btnChatEmojis.setImageResource(R.drawable.chat_function_keyboard);
        this.T.I();
        this.chatMessage.requestFocus();
        this.parentHandler.postDelayed(new s(), 100L);
        Q8();
        if (this.y0 != null && this.z0) {
            n8(null);
        } else if (this.o) {
            r8();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handlerRoomReceiveSync(SubMessageBean subMessageBean) {
        if (subMessageBean.suc()) {
            Timer timer = this.D;
            if (timer != null) {
                timer.cancel();
                this.D = null;
            }
            if (subMessageBean.getControlType() == 0) {
                this.llDSBannar.setVisibility(8);
                this.llBannarDSBottom.setVisibility(8);
                if (SubMessageBean.ROOM_SYNC_CONTROL_ENDED.equals(subMessageBean.getAction()) || this.u.isExit()) {
                    this.llBannar.setVisibility(8);
                    this.llBannarBottom.setVisibility(8);
                    return;
                }
                RoomReceiveSyncResponse roomReceiveSyncResponse = (RoomReceiveSyncResponse) JSON.parseObject(WearUtils.A.toJson(subMessageBean.getData()), RoomReceiveSyncResponse.class);
                String strP = ch3.n().p();
                GroupMember memberByJid = this.u.getMemberByJid(roomReceiveSyncResponse.getMaster().getJid());
                this.B = memberByJid;
                if (memberByJid == null) {
                    this.llBannar.setVisibility(8);
                    this.llBannarBottom.setVisibility(8);
                    return;
                }
                this.t.clear();
                for (RoomReceiveSyncResponse.PlayerListBean playerListBean : roomReceiveSyncResponse.getPlayerList()) {
                    if (!strP.equals(playerListBean.getJid()) && (playerListBean.getStatus() == 2 || playerListBean.getStatus() == 1)) {
                        GroupMember memberByJid2 = this.u.getMemberByJid(playerListBean.getJid());
                        if (memberByJid2 != null) {
                            memberByJid2.setStatus(playerListBean.getStatus());
                            this.t.add(memberByJid2);
                        }
                    }
                }
                char c2 = 0;
                for (RoomReceiveSyncResponse.PlayerListBean playerListBean2 : roomReceiveSyncResponse.getPlayerList()) {
                    if (strP.equals(playerListBean2.getJid()) && playerListBean2.getStatus() == 2) {
                        c2 = 2;
                    }
                }
                if (strP.equals(roomReceiveSyncResponse.getMaster().getJid())) {
                    c2 = 1;
                } else {
                    this.t.add(0, this.B);
                }
                if (c2 == 1) {
                    this.llBannar.setVisibility(8);
                    return;
                }
                if (c2 == 2) {
                    this.llBannar.setVisibility(8);
                    return;
                }
                this.llBannar.setVisibility(0);
                if (this.llBannarBottom.getVisibility() == 0) {
                    this.tvShowBannar.setText(String.format(ah4.e(R.string.group_chat_join_sync), this.t.size() + ""));
                } else {
                    this.tvShowBannar.setText(String.format(ah4.e(R.string.group_chat_control_member), this.B.getNickName(), (this.t.size() - 1) + ""));
                }
                this.q.notifyDataSetChanged();
                return;
            }
            if (subMessageBean.getControlType() == 1) {
                this.llBannar.setVisibility(8);
                this.llBannarBottom.setVisibility(8);
                if (SubMessageBean.ROOM_DS_END.equals(subMessageBean.getAction()) || this.u.isExit()) {
                    this.llDSBannar.setVisibility(8);
                    this.llBannarDSBottom.setVisibility(8);
                    return;
                }
                this.G = (DSGroupInfoBean) JSON.parseObject(WearUtils.A.toJson(subMessageBean.getData()), DSGroupInfoBean.class);
                String strP2 = ch3.n().p();
                this.E = this.u.getMemberByJid(this.G.getTargeter().getJid());
                this.t.clear();
                char c3 = 0;
                for (DSPlayerListBean dSPlayerListBean : this.G.getPlayerList()) {
                    if (dSPlayerListBean.getStatus().intValue() != 3 && dSPlayerListBean.getStatus().intValue() != 0) {
                        GroupMember memberByJid3 = this.u.getMemberByJid(dSPlayerListBean.getJid());
                        if (memberByJid3 != null) {
                            memberByJid3.setDSStatus(dSPlayerListBean.getStatus().intValue());
                            this.t.add(memberByJid3);
                        }
                        if (strP2.equals(dSPlayerListBean.getJid())) {
                            c3 = 2;
                        }
                    }
                }
                if (strP2.equals(this.G.getTargeter().getJid())) {
                    c3 = 1;
                } else {
                    this.t.add(0, this.E);
                }
                if (c3 == 1) {
                    this.llDSBannar.setVisibility(8);
                    return;
                }
                if (c3 == 2) {
                    this.llDSBannar.setVisibility(8);
                    return;
                }
                this.llDSBannar.setVisibility(0);
                this.K = this.G.getCreatorJid().equals(this.G.getTargeter().getJid());
                if (this.G.isStart()) {
                    this.tvDSJoin.setAlpha(1.0f);
                    this.F = this.u.getMemberByJid(this.G.getCurrentPlayerJid());
                    this.C = this.G.getControlStartTime();
                    String str = "handlerRoomReceiveSync: " + System.currentTimeMillis() + "   " + this.G.getControlStartTime() + "   " + (System.currentTimeMillis() - this.G.getControlStartTime());
                } else {
                    if (this.K) {
                        this.tvDSJoin.setAlpha(1.0f);
                    } else {
                        this.tvDSJoin.setAlpha(0.4f);
                    }
                    long createTime = this.G.getCreateTime();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (65000 + createTime < jCurrentTimeMillis) {
                        this.llDSBannar.setVisibility(8);
                        this.llBannarDSBottom.setVisibility(8);
                        return;
                    }
                    this.C = 60 - ((jCurrentTimeMillis - createTime) / 1000);
                }
                Timer timer2 = new Timer();
                this.D = timer2;
                timer2.schedule(new f1(), 0L, 1000L);
            }
        }
    }

    @Override // dc.ah3
    public void i1(CommunMessage communMessage, int i2) {
        int iIndexOf;
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition;
        if (this.chatMessageList == null || (iIndexOf = this.Y.indexOf(communMessage)) < 0 || (viewHolderFindViewHolderForAdapterPosition = this.chatMessageList.findViewHolderForAdapterPosition(iIndexOf)) == null) {
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
            String str3 = "messageSending = " + communMessage.getSendStatus();
            this.X.notifyItemChanged(iIndexOf, "sendStatus");
        }
    }

    public final void i8() {
        o8();
        if (this.y0 == null || !this.z0) {
            this.parentHandler.postDelayed(new r(), 100L);
        }
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        super.initInject();
        this.mActivityComponent.l(this);
        this.mPresenter = this.p;
    }

    public final void j8() {
        File file = new File(WearUtils.b(this, "festival_animation.mp4"));
        if (!file.exists()) {
            sg3.l("文件播放错误");
            return;
        }
        this.lottieView.setVisibility(8);
        this.chatEmojisTosatLayer.setVisibility(8);
        this.L0.setVisibility(0);
        this.M0.setVisibility(0);
        this.K0.setVisibility(0);
        this.K0.k(file);
    }

    public void k8(String str, String str2) {
        this.p.m(str);
        this.A = str2;
        showDialog();
    }

    @Override // dc.jv1
    public void l(IPeopleInfo iPeopleInfo) {
        if (iPeopleInfo.getUserJid().equals(this.u.getUserJid())) {
            S8();
        }
    }

    @Override // dc.gv1
    public void l2(IPeopleInfo iPeopleInfo) {
        if (iPeopleInfo.getUserJid().equals(this.u.getUserJid())) {
            this.llBannarBottom.setVisibility(8);
        }
    }

    public final void l8() {
        is3.b bVar = new is3.b(this);
        bVar.c(new q());
        bVar.d(new p());
        bVar.x(gg3.e(this.application));
        bVar.i(80);
        bVar.l(true);
        bVar.m(true);
        is3 is3VarI = cs3.i(bVar, PhotoCameraDialog.class);
        this.O0 = is3VarI;
        is3VarI.show();
    }

    @Override // dc.wo2
    public void m(SurveyInfoBean surveyInfoBean) {
        if (surveyInfoBean == null || surveyInfoBean.getOpenStatus() != 1) {
            return;
        }
        this.llSurvey.setVisibility(0);
        boolean zD = eg3.d(this, "show_survey_close", false);
        this.H0 = zD;
        this.ivSurveyClose.setVisibility(zD ? 0 : 4);
        this.ivSurveyClose.setEnabled(this.H0);
        this.G0 = surveyInfoBean.getOnlineUrl();
    }

    @Override // dc.sa2
    public void m2(CommunMessage communMessage) {
        z6(communMessage);
        int i2 = this.w0;
        if (i2 != -1) {
            s8(i2);
        }
    }

    public void m8(CommunMessage communMessage) {
        try {
            if (!hf3.d(this)) {
                sg3.i(this, R.string.common_settingTip);
                A8(communMessage, true);
                return;
            }
            if (MyApplication.P && hu3.x() != null) {
                switch (b1.a[communMessage.getType().ordinal()]) {
                    case 1:
                        D8(communMessage, MessageType.chat, true);
                        break;
                    case 2:
                    case 7:
                        EntityShortVideo entityShortVideo = (EntityShortVideo) DaoUtils.getCommunMessageDao().findById(communMessage.getId()).syncDecryptBean();
                        communMessage.setDataBean(entityShortVideo);
                        if (!WearUtils.e1(entityShortVideo.getVideoLocalUrl()) && !new File(entityShortVideo.getVideoLocalUrl()).exists()) {
                            sg3.e(this, R.string.chat_message_item_save_error);
                            break;
                        } else {
                            if (!WearUtils.e1(entityShortVideo.getPicUrl()) && !WearUtils.e1(entityShortVideo.getVideoUrl())) {
                                communMessage.setSendStatus(2);
                                communMessage.setCreated(be3.u());
                                DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
                                M7(communMessage);
                                x8("", communMessage, 0);
                                break;
                            }
                            fk3 fk3Var = new fk3(WearUtils.k0(this.S), entityShortVideo instanceof EntityBurnShortVideo, communMessage.getId());
                            if (fk3Var.getStatus() == AsyncTask.Status.PENDING) {
                                MediaFile mediaFile = new MediaFile();
                                mediaFile.m(entityShortVideo.getVideoLocalUrl());
                                mediaFile.h(entityShortVideo.getDuration());
                                fk3Var.I(this);
                                this.Y.remove(communMessage);
                                fk3Var.executeOnExecutor(vg3.b().c(), mediaFile);
                            } else {
                                communMessage.setSendStatus(2);
                                fk3Var.I(this);
                            }
                            this.X.notifyItemChanged(this.Y.indexOf(communMessage));
                            break;
                        }
                        break;
                    case 3:
                        u8(communMessage);
                        break;
                    case 4:
                    case 6:
                        EntityPicture entityPicture = (EntityPicture) DaoUtils.getCommunMessageDao().findById(communMessage.getId()).syncDecryptBean();
                        String localUrl = entityPicture.getLocalUrl();
                        if (!WearUtils.e1(localUrl) && WearUtils.e1(entityPicture.getUrl())) {
                            boolean z2 = entityPicture instanceof EntityBurnPicture;
                            File fileZ = !WearUtils.e1(entityPicture.getType()) && entityPicture.getType().equals("emoji") ? WearUtils.Z(localUrl).exists() ? WearUtils.Z(localUrl) : WearUtils.a0(localUrl) : WearUtils.c0(localUrl);
                            if (entityPicture instanceof EntityBurnPicture) {
                                ((EntityBurnPicture) entityPicture).setBurn(false);
                            }
                            fk3 fk3Var2 = new fk3(WearUtils.k0(this.S), z2, communMessage.getId());
                            if (fk3Var2.getStatus() == AsyncTask.Status.PENDING) {
                                MediaFile mediaFile2 = new MediaFile();
                                mediaFile2.m(fileZ.getAbsolutePath());
                                fk3Var2.I(this);
                                this.Y.remove(communMessage);
                                fk3Var2.executeOnExecutor(vg3.b().c(), mediaFile2);
                            } else {
                                communMessage.setSendStatus(2);
                                fk3Var2.I(this);
                            }
                            this.X.notifyItemChanged(this.Y.indexOf(communMessage));
                            break;
                        } else {
                            communMessage.setSendStatus(2);
                            communMessage.setCreated(be3.u());
                            DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
                            M7(communMessage);
                            v8(entityPicture.getUrl(), communMessage, 0);
                            break;
                        }
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
                                M7(communMessage);
                                rf3.s(file, new k0(entityPattern, communMessage));
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
            A8(communMessage, true);
        } catch (Exception e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e2);
            sg3.e(this, R.string.chat_message_item_save_error);
        }
    }

    @Override // dc.sa2
    public void n() {
    }

    @Override // dc.gv1
    public void n0(IPeopleInfo iPeopleInfo, View view) {
        if (iPeopleInfo.getUserJid().equals(this.u.getUserJid())) {
            addViewToActivity(view);
        }
    }

    @Override // com.wear.ui.chat.fragment.ChatActionMenuFragmentBottom.d
    public void n1(int i2) {
        if (i2 == 1) {
            U7();
            return;
        }
        if (i2 == 2) {
            Y7();
        } else if (i2 == 3) {
            T7();
        } else {
            if (i2 != 6) {
                return;
            }
            S7();
        }
    }

    public final void n8(CommunMessage communMessage) {
        this.y0 = null;
        this.Z = 0;
        List<CommunMessage> listFindByPage = DaoUtils.getCommunMessageDao().findByPage(WearUtils.y.p(), WearUtils.k0(this.S), 0, 10);
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
        this.Y.clear();
        this.Y.addAll(EntityUnSupport.filterMessages(listFindByPage));
        this.X.notifyDataSetChanged();
        r8();
    }

    @Override // dc.sa2, dc.xb2
    public void notifyDataSetChanged() {
        runOnMainThread(new x());
    }

    @Override // dc.sa2
    public boolean o() {
        return false;
    }

    @Override // dc.ie3.m
    public void o2(File file, String str, String str2, String str3) {
        Bitmap bitmapDecodeFile;
        if (file == null || !file.exists() || (bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath())) == null) {
            return;
        }
        w8(bitmapDecodeFile.getHeight(), bitmapDecodeFile.getWidth(), str3, str, str2, file, false);
    }

    public final void o8() {
        this.vChatRoomMenu.setVisibility(8);
        this.chatEmojisPanel.setVisibility(8);
        O6();
        this.L = true;
        this.btnChatMore.setImageResource(R.drawable.chat_function_openfunction);
        this.btnChatEmojis.setImageResource(R.drawable.chat_function_emojis);
        Q8();
        this.M = true;
        this.chatMessage.setVisibility(0);
        this.chatMessage.requestFocus();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 18) {
            K6(intent);
            return;
        }
        if (i2 == 32) {
            M6(i3, intent);
            return;
        }
        if (i2 == 153) {
            C6(i3, intent);
            return;
        }
        if (i2 == 545) {
            this.T.K();
            return;
        }
        if (i2 == 888) {
            F6(i3, intent);
            return;
        }
        if (i2 == 999) {
            G6(i3, intent);
            return;
        }
        if (i2 == 1010) {
            J6(intent);
            return;
        }
        if (i2 == 28784) {
            E6(i3, intent);
            return;
        }
        if (i2 == 20) {
            L6(i3, intent);
            return;
        }
        if (i2 == 21) {
            D6(i3, intent);
        } else if (i2 == 23) {
            H6(intent);
        } else {
            if (i2 != 24) {
                return;
            }
            I6(this.I0);
        }
    }

    @Override // com.wear.xmpp.FragmentStateLossActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.m.w();
        R8(new iv1() { // from class: dc.m52
            @Override // dc.iv1
            public final void next() {
                this.a.F7();
            }
        });
    }

    @Override // com.wear.activity.qrcode.QRCodeActivity, com.wear.xmpp.FragmentStateLossActivity, com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R.layout.activity_chat_room);
        ButterKnife.bind(this);
        b7();
        EventBus.getDefault().register(this);
        zb2.O().q(this);
        this.B0 = getIntent().getBooleanExtra("isFinishToLongDistance", false);
        this.S = getIntent().getStringExtra("roomId");
        this.u = ch3.n().k(WearUtils.A0(this.S));
        DaoUtils.getSensitiveWordDao().setChatRoomSensitive(DaoUtils.getChatRoomSensitiveDao().findItemByRoomId(this.S));
        if (this.u == null) {
            if (ch3.n().u() == null) {
                ye3.I("wipeMemoryError", "ChatRoomActivity");
            }
            finish();
            return;
        }
        this.v = ch3.n().u();
        me3.d(me3.c.GROUP_CHAT_UI_ENTER, nd3.p(WearUtils.k0(this.S)));
        ye3.c("group chatroom", "into page", this.S);
        this.w.w(this);
        this.w.m3(this.velvoPreviewView);
        this.x.w(this);
        this.x.u2(this.velvoPreviewView);
        FriendControlBannarAdapter friendControlBannarAdapter = new FriendControlBannarAdapter(this.t, R.layout.item_friends_control_horizontal);
        this.q = friendControlBannarAdapter;
        cg3.d(this.rvBannar, friendControlBannarAdapter);
        FriendControlBannarAdapter friendControlBannarAdapter2 = new FriendControlBannarAdapter(this.t, R.layout.item_ds_friends_control_horizontal);
        this.s = friendControlBannarAdapter2;
        cg3.d(this.rvDSBannar, friendControlBannarAdapter2);
        this.T.w(this, this, this.chatEmojisPanel, this.chatMessage, this.chatEmojisTosatLayer);
        this.chatMessage.setHorizontallyScrolling(false);
        this.chatMessage.setMaxLines(5);
        this.chatMessage.setEmojisUtils(this.T);
        e82 e82Var = new e82(this, this, this.V, this.T);
        this.m = e82Var;
        MessageNewAdapter messageNewAdapter = new MessageNewAdapter(this.Y, this, this, this.V, e82Var, this.T, this.chatMessage);
        this.X = messageNewAdapter;
        messageNewAdapter.c = this;
        this.y = cg3.e(this.chatMessageList, messageNewAdapter);
        keyboardHelperInit(this.screanRootLayout, this.chatMoreLayer, this.chatRoomInputPanel, this.chatRoomEmojisPanel, this.chatRoomMorePanel);
        e7();
        this.abTitle.setIconAction(Integer.valueOf(R.drawable.nav_profile_selector), new a());
        this.tvInvitationCount.setOnClickListener(new l());
        this.abTitle.setBackAction(new w());
        this.abTitle.setParentBackgroundColor(th4.b(this, R.color.lvs_ui_standard_systemBackground));
        Y6();
        if (WearUtils.e1(DaoUtils.getTestValueDao().getValue(zt3.k, TestValueDao.CHAT_NOTE)) && !MyApplication.g0) {
            is3.b bVar = new is3.b(this.U);
            bVar.n(ah4.e(R.string.dont_remind_button));
            bVar.o(ah4.e(R.string.common_ok));
            bVar.p(ah4.e(R.string.send_messgae_note));
            bVar.k(R.layout.dialog_chating_security);
            bVar.d(new r0(this));
            bVar.c(new c1(this));
            cs3.h(bVar).show();
        }
        if (eg3.d(this, "show_survey_group", true) && !this.u.isExit()) {
            this.p.l("GROUP_CHAT");
        }
        l22.n().w(this);
        if (this.N0 == null) {
            this.N0 = ChatActionMenuFragmentBottom.E(1);
        }
        this.N0.F(this);
        this.chatRoomInputPanel.q(this);
        this.chatRoomInputPanel.s(this.layoutMsg);
    }

    @Override // com.wear.activity.qrcode.QRCodeActivity, com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() throws IllegalStateException {
        me3.c(me3.c.GROUP_CHAT_UI_EXIT);
        zb2.O().t0(this);
        X8(2);
        if (qf3.a && !this.application.o) {
            qf3.v(null, null);
        }
        File file = this.Q;
        if (file != null && file.exists()) {
            this.Q.delete();
        }
        so3 so3Var = this.V;
        if (so3Var != null && so3Var.s()) {
            MusicControl.h0();
            h12.D.isPlayAudio = false;
            this.V.G();
            this.V.x();
            this.V.F();
            this.application.G().u0();
        }
        if (qe3.b.exists()) {
            qe3.b.delete();
        }
        Timer timer = this.D;
        if (timer != null) {
            timer.cancel();
            this.D = null;
        }
        this.w.O(this);
        EventBus.getDefault().unregister(this);
        CoustomLinearLayout coustomLinearLayout = this.chatLiveSyncLayer;
        if (coustomLinearLayout != null) {
            coustomLinearLayout.removeAllViews();
        }
        l22.n().w(null);
        super.onDestroy();
    }

    @Override // com.wear.xmpp.FragmentStateLossActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!this.vImageWatcher.isShown() || i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        this.vImageWatcher.B();
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(ReSendPatternEvent reSendPatternEvent) {
        this.X.D1(reSendPatternEvent.getMessage(), reSendPatternEvent.getEntity());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(FinishChatPageEvent finishChatPageEvent) {
        if (finishChatPageEvent.flag == 1) {
            finish();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(GroupMessageEvent groupMessageEvent) {
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEventCl(InputResizeEvent inputResizeEvent) {
        String str = "setMPadding InputResizeEvent ResizeHeight:" + inputResizeEvent.getResizeHeight();
        if (inputResizeEvent.getFlag() == 1) {
            this.chatRoomInputPanel.j(inputResizeEvent.getResizeHeight());
        } else if (inputResizeEvent.getFlag() == 2) {
            p8(inputResizeEvent.getResizeHeight());
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onNewIntent(intent);
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        X8(2);
        this.B0 = intent.getBooleanExtra("isFinishToLongDistance", false);
        if (intent.getExtras() != null) {
            this.S = intent.getExtras().getString("roomId");
            this.y0 = (CommunMessage) intent.getExtras().getSerializable("searchMessage");
        } else {
            this.S = intent.getStringExtra("roomId");
        }
        this.u = ch3.n().k(WearUtils.A0(this.S));
        DaoUtils.getSensitiveWordDao().setChatRoomSensitive(DaoUtils.getChatRoomSensitiveDao().findItemByRoomId(this.S));
        if (this.u != null) {
            this.v = ch3.n().u();
            e7();
        } else {
            if (ch3.n().u() == null) {
                ye3.I("wipeMemoryError", "ChatRoomActivity");
            }
            finish();
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.vImageWatcher.B();
        s6();
        if (this.chatMessage.isFocused()) {
            ((ViewGroup) this.chatMessage.getParent()).requestFocus();
            ue3.a(this.chatMessage, this);
        }
        if (WearUtils.e1(this.chatMessage.getText().toString()) && this.l0 == null) {
            DaoUtils.getCommunMessageDao().delDateDrafMessage(WearUtils.y.p(), this.u.getUserJid());
        } else {
            DaoUtils.getCommunMessageDao().upDateDrafMessage(WearUtils.y.p(), this.u.getUserJid(), this.chatMessage.getText().toString(), this.chatMessage.getUserBean(), this.l0);
        }
    }

    @Override // com.wear.xmpp.FragmentStateLossActivity, com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onResume();
        this.w.w(this);
        this.x.w(this);
        this.x.n1();
        File fileN = WearUtils.N(this.u);
        if (!fileN.exists() || this.u == null) {
            nz1.e().k(this.ivChatBackground);
            K8();
        } else {
            ImageLoader.getInstance().loadImage(Uri.fromFile(fileN).toString(), new ImageSize(gg3.e(this), gg3.c(this)), new m());
        }
        if (Build.VERSION.SDK_INT >= 23) {
            kg3.k(this, WearUtils.Y0());
        }
        W6();
        c7();
    }

    @Override // com.wear.xmpp.FragmentStateLossActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.wear.BaseActivity
    public void onSoftKeyboardOpened() {
        o8();
    }

    @OnClick({R.id.btn_chat_more, R.id.btn_chat_emojis, R.id.chat_pictures, R.id.tv_show_bannar, R.id.tv_cancel, R.id.tv_join, R.id.tv_show_ds_bannar, R.id.tv_ds_cancel, R.id.tv_ds_join, R.id.ll_survey, R.id.iv_survey_close, R.id.btn_chat_send})
    public void onViewClicked(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        O6();
        switch (view.getId()) {
            case R.id.btn_chat_emojis /* 2131362225 */:
                R7(view);
                break;
            case R.id.btn_chat_more /* 2131362226 */:
                this.N0.show(getSupportFragmentManager(), "chatActionMenuFragmentBottom");
                break;
            case R.id.btn_chat_send /* 2131362227 */:
                E8();
                break;
            case R.id.chat_pictures /* 2131362338 */:
                t6(R.id.chat_more_sendPicture);
                break;
            case R.id.iv_survey_close /* 2131363318 */:
                X7();
                break;
            case R.id.ll_survey /* 2131363597 */:
                Z7();
                break;
            case R.id.tv_cancel /* 2131364956 */:
                a8();
                break;
            case R.id.tv_ds_cancel /* 2131365062 */:
                b8();
                break;
            case R.id.tv_ds_join /* 2131365063 */:
                c8();
                break;
            case R.id.tv_join /* 2131365141 */:
                d8();
                break;
            case R.id.tv_show_bannar /* 2131365311 */:
                e8();
                break;
            case R.id.tv_show_ds_bannar /* 2131365312 */:
                f8();
                break;
        }
    }

    @Override // dc.l22.i
    public void p0(ControlLinkAwaken.Awaken awaken, Map<String, String> map) {
        dissDialog();
        ku1.a("Control Link", "remote_chatroom_control_link_click", "click", map.get("linkId") != null ? map.get("linkId") : "", "2", map.get("elementContent") != null ? map.get("elementContent") : "", null, null);
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
        pj3.g(this.U, ControlLinkEndActivity.class, bundle);
    }

    public void p8(int i2) {
        this.chatRoomEmojisPanel.setHeight(i2);
        this.chatRoomMorePanel.setHeight(i2);
    }

    @Override // dc.sa2
    public void q() {
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void q8(boolean r11) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.main.longDistance.ChatRoomActivity.q8(boolean):void");
    }

    @Override // dc.sa2
    public HashMap<String, String> r() {
        return this.a0;
    }

    @Override // dc.gv1
    public void r3(IPeopleInfo iPeopleInfo, boolean z2) {
        if (iPeopleInfo.getUserJid().equals(this.u.getUserJid())) {
            if (z2) {
                this.progressDialog.show();
            } else {
                this.progressDialog.dismiss();
            }
        }
    }

    public final void r8() {
        P6(false);
        this.d0 = -1;
        this.e0 = true;
        this.parentHandler.postDelayed(new Runnable() { // from class: dc.w52
            @Override // java.lang.Runnable
            public final void run() {
                this.a.J7();
            }
        }, 100L);
    }

    @Override // dc.sa2
    public void s3(CommunMessage communMessage) {
        ue3.a(this.chatMessage, this);
        if (communMessage.getType() == MessageType.picture) {
            Intent intent = new Intent(this, (Class<?>) LongPictureEnlargeActivity.class);
            intent.putExtra("extras_friend_id", this.S);
            intent.putExtra("extras_massage_id", communMessage.getId());
            intent.putExtra("can_long_click", true);
            startActivityForResult(intent, 999);
            return;
        }
        if (communMessage.getType() == MessageType.burnpicture) {
            Intent intent2 = new Intent(this, (Class<?>) BurnPictureEnlargeActivity.class);
            intent2.putExtra("burn_commun_message", communMessage);
            startActivityForResult(intent2, 1010);
        }
    }

    public void s6() {
        runOnMainThread(new Runnable() { // from class: dc.r52
            @Override // java.lang.Runnable
            public final void run() {
                this.a.j7();
            }
        });
    }

    public final void s8(int i2) {
        this.e0 = false;
        t8(i2);
        this.v0 = false;
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

    @Override // dc.sa2
    public void t() {
    }

    public final void t6(int i2) {
        q61 q61VarM = q61.m(this);
        q61VarM.h("android.permission.CAMERA", "android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO", "android.permission.RECORD_AUDIO");
        q61VarM.j(new o());
    }

    public void t8(int i2) {
        runOnMainThread(new x0(i2));
    }

    public final boolean u6() {
        if (this.llBannar.getVisibility() == 0) {
            is3.b bVar = new is3.b(this);
            bVar.p(ah4.e(R.string.group_sync_control_is_on));
            bVar.o(ah4.e(R.string.common_join));
            bVar.d(new v0());
            cs3.h(bVar).show();
            return false;
        }
        if (this.llDSBannar.getVisibility() != 0) {
            return true;
        }
        is3.b bVar2 = new is3.b(this);
        if (this.G.isStart() || this.K) {
            bVar2.p(ah4.e(R.string.group_ds_control_is_on));
            bVar2.o(ah4.e(R.string.common_join));
            bVar2.d(new w0());
        } else {
            bVar2.q(this.u.getShowNickName());
            bVar2.s(true);
            bVar2.p(String.format(ah4.e(R.string.group_ds_control_is_on_1), this.E.getNickName()));
            bVar2.b(false);
        }
        cs3.h(bVar2).show();
        return false;
    }

    public final void u8(CommunMessage communMessage) {
        EntityAudio entityAudio = (EntityAudio) communMessage.getDataBean();
        String localUrl = entityAudio.getLocalUrl();
        if (!WearUtils.e1(localUrl) && new File(localUrl).exists()) {
            if (!hf3.d(this)) {
                sg3.i(this, R.string.common_settingTip);
                A8(communMessage, true);
            } else {
                communMessage.setSendStatus(2);
                tn2.x(WearUtils.x).A("/wear/chat/saveFile/audio", new File(localUrl), new HashMap(), new f0(entityAudio, communMessage));
            }
        }
    }

    @Override // dc.sa2
    public void v() {
    }

    @Override // dc.sa2
    public void v1(CommunMessage communMessage) {
        CommunMessage communMessage2 = this.g0;
        if (communMessage2 != null && communMessage == communMessage2) {
            v6(false);
        }
        for (CommunMessage communMessage3 : this.Y) {
            if (!WearUtils.e1(communMessage3.getReplyData())) {
                HashMap map = (HashMap) WearUtils.A.fromJson(communMessage3.getReplyData(), HashMap.class);
                Gson gson = WearUtils.A;
                map.remove("replyData");
                map.remove("dataBean");
                CommunMessage communMessage4 = (CommunMessage) WearUtils.A.fromJson(WearUtils.A.toJson(map), CommunMessage.class);
                if (communMessage4.getId().equals(communMessage.getId())) {
                    communMessage4.setType(MessageType.system);
                    communMessage4.setReplyData("delete");
                    communMessage3.setReplyData(WearUtils.A.toJson(communMessage4));
                    DaoUtils.getCommunMessageDao().update((CommunMessageDao) communMessage3);
                }
            }
        }
        notifyDataSetChanged();
        CommunMessage communMessage5 = this.l0;
        if (communMessage5 == null || !communMessage5.getId().equals(communMessage.getId())) {
            return;
        }
        w6();
    }

    public final void v6(boolean z2) {
        this.g0 = null;
        if (this.Y.isEmpty()) {
            return;
        }
        CommunMessage communMessage = this.Y.get(0);
        if (communMessage.getDataBean() instanceof EntityChat) {
            String strS = this.T.s(((EntityChat) communMessage.getDataBean()).getText(), true);
            if (TextUtils.isEmpty(strS)) {
                return;
            }
            this.g0 = communMessage;
            if (communMessage.isShowEmojiAnim()) {
                if (!this.T.B(strS)) {
                    if (z2) {
                        P8(communMessage);
                    }
                } else if (this.Y.size() != 1) {
                    CommunMessage communMessage2 = this.Y.get(1);
                    if (TextUtils.equals(communMessage.getRealFrom(), communMessage2.getRealFrom()) || !(communMessage2.getDataBean() instanceof EntityChat)) {
                        return;
                    }
                    if (TextUtils.equals(strS, this.T.s(((EntityChat) communMessage2.getDataBean()).getText(), true))) {
                        this.g0 = communMessage2;
                        if (z2) {
                            P8(communMessage);
                        }
                    }
                }
            }
        }
    }

    public final void v8(String str, CommunMessage communMessage, int i2) {
        communMessage.setUserId(communMessage.getFrom());
        if (i2 != 0) {
            A8(communMessage, false);
            return;
        }
        EntityPicture entityPicture = (EntityPicture) communMessage.getDataBean();
        entityPicture.setUrl(str);
        communMessage.setSendStatus(0);
        communMessage.sendEntity(entityPicture);
        DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
        C8(communMessage);
        this.X.notifyDataSetChanged();
    }

    public final void w6() {
        this.l0 = null;
        this.j0.setVisibility(8);
        this.m0.setText("");
        this.n0.setText("");
        this.parentHandler.postDelayed(new Runnable() { // from class: dc.h52
            @Override // java.lang.Runnable
            public final void run() {
                this.a.l7();
            }
        }, 300L);
    }

    public final void w8(int i2, int i3, String str, String str2, String str3, File file, boolean z2) {
        this.parentHandler.post(new e0(file, z2, str, i2, i3, str2, str3));
    }

    @Override // dc.sa2
    public void x3(CommunMessage communMessage, Bitmap bitmap, ImageView imageView) {
        ue3.a(this.chatMessage, this);
        Intent intent = new Intent(this, (Class<?>) LongPictureEnlargeActivity.class);
        intent.putExtra("extras_room_id", this.S);
        intent.putExtra("extras_massage_id", communMessage.getId());
        intent.putExtra("can_long_click", false);
        startActivity(intent);
    }

    public void x6() {
        y6(true);
    }

    public final void x8(String str, CommunMessage communMessage, int i2) {
        communMessage.setUserId(communMessage.getFrom());
        if (i2 != 0) {
            A8(communMessage, false);
            return;
        }
        EntityShortVideo entityShortVideo = (EntityShortVideo) communMessage.getDataBean();
        communMessage.setSendStatus(0);
        communMessage.sendEntity(entityShortVideo);
        DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
        C8(communMessage);
        this.X.notifyDataSetChanged();
        if (WearUtils.e1(entityShortVideo.getVideoUrl())) {
            FirebaseCrashlytics.getInstance().recordException(new Throwable("videourl room sendChatVideoMessage null Millis:" + System.currentTimeMillis()));
        }
    }

    @Override // dc.jv1
    public void y(IPeopleInfo iPeopleInfo) {
        if (iPeopleInfo.getUserJid().equals(this.u.getUserJid())) {
            x6();
        }
    }

    public void y6(boolean z2) {
        ue3.a(this.chatMessage, this);
        O6();
        this.chatMoreLayer.setVisibility(8);
        this.chatLiveSyncLayer.setVisibility(8);
        this.L = true;
        this.btnChatMore.setImageResource(R.drawable.chat_function_openfunction);
        this.btnChatEmojis.setImageResource(R.drawable.chat_function_emojis);
        if (z2) {
            Q8();
        }
        if (ChatInputPanelPto.l) {
            ChatInputPanelPto.l = false;
        } else {
            this.chatRoomInputPanel.g(false);
        }
    }

    public final void y8(DataEntityAbstract dataEntityAbstract, MessageType messageType) {
        if (!hf3.d(this)) {
            sg3.i(this, R.string.common_settingTip);
            B8(dataEntityAbstract);
            return;
        }
        if (!MyApplication.P || hu3.x() == null) {
            sg3.i(this, R.string.message_send_error);
            B8(dataEntityAbstract);
            return;
        }
        if (!zb2.O().B(messageType)) {
            sg3.l(ah4.e(R.string.operate_frequently));
            return;
        }
        String strT = dataEntityAbstract instanceof EntityChat ? this.T.t(((EntityChat) dataEntityAbstract).getText(), h7(dataEntityAbstract)) : null;
        CommunMessage communMessage = this.l0;
        if (communMessage != null && messageType == MessageType.chat) {
            communMessage.setUnEncryptFrom(communMessage.getFrom());
            CommunMessage communMessage2 = this.l0;
            communMessage2.setUnEncryptRealFrom(communMessage2.getRealFrom());
            CommunMessage communMessage3 = this.l0;
            communMessage3.setUnEncryptTo(communMessage3.getTo());
            zb2.O().P0(WearUtils.A.toJson(this.l0));
            this.l0 = null;
            this.j0.setVisibility(8);
            this.m0.setText("");
            this.parentHandler.postDelayed(new Runnable() { // from class: dc.p52
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.L7();
                }
            }, 300L);
            addAnalyticsEventId("chat_reply_send", null);
        }
        zb2.O().H0(WearUtils.k0(this.S), dataEntityAbstract, true, true, strT);
    }

    @Override // dc.wo2
    public void z(boolean z2, String str, String str2) {
        dissDialog();
        Bundle bundle = new Bundle();
        bundle.putString("user_id", WearUtils.g0(str2));
        bundle.putString(FirebaseAnalytics.Param.GROUP_ID, this.S);
        bundle.putString("user_img", this.A);
        if (!str.equals("pending")) {
            pj3.g(this, ReasonOptionActivity.class, bundle);
        } else {
            bundle.putInt("status", 1);
            pj3.g(this, ResultActivity.class, bundle);
        }
    }

    public final void z6(CommunMessage communMessage) {
        if (communMessage == null) {
            return;
        }
        while (!this.v0) {
            for (int i2 = 0; i2 < this.Y.size(); i2++) {
                if (communMessage.getId().equals(this.Y.get(i2).getId()) || communMessage.getId().equals(this.Y.get(i2).getReceiveId()) || ((!WearUtils.e1(communMessage.getReceiveId()) && communMessage.getReceiveId().equals(this.Y.get(i2).getReceiveId())) || (!WearUtils.e1(communMessage.getReceiveId()) && communMessage.getReceiveId().equals(this.Y.get(i2).getId())))) {
                    this.v0 = true;
                    this.w0 = i2;
                    return;
                }
            }
            CommunMessageDao communMessageDao = DaoUtils.getCommunMessageDao();
            String strP = WearUtils.y.p();
            String strK0 = WearUtils.k0(this.S);
            int i3 = this.Z + 1;
            this.Z = i3;
            List<CommunMessage> listFindByPage = communMessageDao.findByPage(strP, strK0, i3, 10);
            if (listFindByPage == null || listFindByPage.size() == 0) {
                this.Z--;
                this.w0 = -1;
                sg3.l(ah4.e(R.string.quoted_content_deleted));
                return;
            }
            for (CommunMessage communMessage2 : listFindByPage) {
                if (be3.E(communMessage2.getCreated(), communMessage2.getSendStatus())) {
                    communMessage2.setSendStatus(4);
                }
                communMessage2.setDataBean(communMessage2.syncDecryptBean());
            }
            int size = this.Y.size();
            this.Y.addAll(EntityUnSupport.filterMessages(listFindByPage));
            Q7(size, this.Y.size() - size);
            for (int i4 = 0; i4 < this.Y.size(); i4++) {
                if (communMessage.getId().equals(this.Y.get(i4).getId()) || communMessage.getId().equals(this.Y.get(i4).getReceiveId()) || ((!WearUtils.e1(communMessage.getReceiveId()) && communMessage.getReceiveId().equals(this.Y.get(i4).getReceiveId())) || (!WearUtils.e1(communMessage.getReceiveId()) && communMessage.getReceiveId().equals(this.Y.get(i4).getId())))) {
                    this.v0 = true;
                    this.w0 = i4;
                    return;
                }
            }
        }
    }

    public final void z8(DataEntityAbstract dataEntityAbstract, boolean z2) {
        if (!hf3.d(this.U)) {
            sg3.i(this.U, R.string.common_settingTip);
            B8(dataEntityAbstract);
            return;
        }
        if (!MyApplication.P || hu3.x() == null || z2) {
            sg3.i(this, R.string.message_send_error);
            B8(dataEntityAbstract);
            return;
        }
        CommunMessage communMessage = new CommunMessage();
        communMessage.setFrom(WearUtils.y.p());
        communMessage.setTo(WearUtils.k0(this.S));
        communMessage.sendEntity(dataEntityAbstract);
        communMessage.setId(WearUtils.E());
        communMessage.setUserId(communMessage.getFrom());
        communMessage.setRealFrom(communMessage.getFrom());
        if (P7(communMessage)) {
            DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
            E0(communMessage);
        }
        C8(communMessage);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ChatBurnRecallEvent chatBurnRecallEvent) {
        if (chatBurnRecallEvent != null) {
            this.m.a0(true);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(GroupNameChangeEvent groupNameChangeEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.S.equals(groupNameChangeEvent.roomId)) {
            c7();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(GroupProhibitedEvent groupProhibitedEvent) {
        if (this.S.equals(groupProhibitedEvent.getRoomId())) {
            W6();
            if (groupProhibitedEvent.getStatus().equals("prohibited")) {
                T8(ah4.e(R.string.notification_group_words_prohibited), ah4.e(R.string.terms_and_conditions1));
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ClearChatViewFriendIdEvent clearChatViewFriendIdEvent) {
        String str = this.S;
        if (str == null || !str.equals(clearChatViewFriendIdEvent.clearChatViewFriendId)) {
            return;
        }
        this.Y.clear();
        if (this.y0 != null) {
            this.y0 = null;
        }
        this.X.notifyDataSetChanged();
        this.e0 = true;
        a7();
        this.g0 = null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(GroupStatusEvent groupStatusEvent) {
        String str = this.S;
        if (str == null || !str.equals(groupStatusEvent.roomId)) {
            return;
        }
        W6();
        notifyDataSetChanged();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(GroupBanEvent groupBanEvent) {
        String str = this.S;
        if (str == null || !str.equals(groupBanEvent.getRoomId())) {
            return;
        }
        T8(ah4.e(R.string.notification_group_disbanded), ah4.e(R.string.terms_and_conditions1));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(GroupInvitationEvent groupInvitationEvent) {
        String str = this.S;
        if (str == null || !str.equals(groupInvitationEvent.roomId)) {
            return;
        }
        int size = this.u.getInvitationList().size();
        if (size > 0) {
            this.tvInvitationCount.setText("" + size);
            this.tvInvitationCount.setVisibility(0);
            this.abTitle.setNewMessagePoint(false);
            return;
        }
        this.tvInvitationCount.setVisibility(8);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ChatRoomMessageReflashEvent chatRoomMessageReflashEvent) {
        a7();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageResendEvent messageResendEvent) {
        CommunMessage message = messageResendEvent.getMessage();
        if (message.getType() != MessageType.alarm) {
            m8(message);
            return;
        }
        Intent intent = new Intent(this, (Class<?>) AlarmCreateActivity.class);
        intent.putExtra("userId", this.S);
        intent.putExtra("alarm_item_id", ((EntityAlarm) message.getDataBean()).getId());
        startActivityForResult(intent, 19);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(SystemEvent systemEvent) {
        CommunMessage communMessage;
        if (systemEvent.flag != 1 || (communMessage = systemEvent.message) == null) {
            return;
        }
        R2(0, communMessage);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(PatternOrAlarmSaveEvent patternOrAlarmSaveEvent) {
        CommunMessage communMessageFindById;
        CommunMessage communMessage = patternOrAlarmSaveEvent.getCommunMessage();
        if (communMessage == null) {
            this.progressDialog.dismiss();
            return;
        }
        if (WearUtils.e1(communMessage.getMsgId()) && (communMessageFindById = DaoUtils.getCommunMessageDao().findById(communMessage.getId())) != null) {
            communMessage.setMsgId(communMessageFindById.getMsgId());
        }
        l0 l0Var = new l0(patternOrAlarmSaveEvent, communMessage);
        if (this.u.isExit() && patternOrAlarmSaveEvent.getType() == 2) {
            notifyDataSetChanged();
        } else {
            this.progressDialog.show();
            zb2.O().C0(new RequestMessageRecord(patternOrAlarmSaveEvent.getRoomId(), communMessage.getMsgId(), patternOrAlarmSaveEvent.getType()), WearUtils.j0(patternOrAlarmSaveEvent.getRoomId()), new m0(l0Var, patternOrAlarmSaveEvent));
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(PatternRecEvent patternRecEvent) {
        Group group;
        CommunMessage communMessage;
        GroupMember memberByJid;
        if (!patternRecEvent.play || (group = this.u) == null || (communMessage = patternRecEvent.userMessage) == null || (memberByJid = group.getMemberByJid(communMessage.getRealFrom())) == null) {
            return;
        }
        sg3.l(String.format(ah4.e(R.string.playing_pattern_automatically), memberByJid.getShowNickName()));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ChatPictureEvent chatPictureEvent) {
        if (chatPictureEvent != null) {
            boolean zIsAddEmojis = chatPictureEvent.isAddEmojis();
            ArrayList<String> delIds = chatPictureEvent.getDelIds();
            if (zIsAddEmojis) {
                this.T.A();
            }
            if (delIds == null || delIds.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            synchronized (this.Y) {
                Iterator<String> it = delIds.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    for (CommunMessage communMessage : this.Y) {
                        if (communMessage.getId().equals(next)) {
                            arrayList.add(communMessage);
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        CommunMessage communMessage2 = (CommunMessage) it2.next();
                        this.m.j0(communMessage2);
                        this.m.x(communMessage2);
                    }
                }
            }
        }
    }
}
