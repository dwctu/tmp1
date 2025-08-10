package com.wear.adapter.longdistance;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.fastjson.JSON;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.wear.BaseActivity;
import com.wear.adapter.longdistance.MessageNewAdapter;
import com.wear.bean.Account;
import com.wear.bean.AlarmListItems;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.bean.Pattern;
import com.wear.bean.PictureBean;
import com.wear.bean.Toy;
import com.wear.bean.User;
import com.wear.bean.event.MessageResendEvent;
import com.wear.bean.event.PatternOrAlarmSaveEvent;
import com.wear.bean.handlerbean.IGroupMember;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.broadcast.AlarmMessagingService;
import com.wear.dao.CommunMessageDao;
import com.wear.dao.DaoUtils;
import com.wear.main.closeRange.PatternPlayActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.longDistance.ChatActivity;
import com.wear.main.longDistance.ChatMsgDetailActivity;
import com.wear.main.longDistance.ChatRoomActivity;
import com.wear.main.longDistance.alarm.GroupAlarmInfoActivity;
import com.wear.main.longDistance.alarm.SetAlarmActivity;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntityAlarm;
import com.wear.protocol.EntityAudio;
import com.wear.protocol.EntityBurnPicture;
import com.wear.protocol.EntityBurnShortVideo;
import com.wear.protocol.EntityChat;
import com.wear.protocol.EntityGiftCard;
import com.wear.protocol.EntityLive;
import com.wear.protocol.EntityPattern;
import com.wear.protocol.EntityPicture;
import com.wear.protocol.EntityShortVideo;
import com.wear.protocol.EntitySync;
import com.wear.protocol.EntitySystem;
import com.wear.protocol.EntityVMShareCard;
import com.wear.protocol.EntityVideo;
import com.wear.protocol.EntityVoice;
import com.wear.protocol.EntityWishList;
import com.wear.protocol.MessageType;
import com.wear.util.HttpTextView;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.ChatBurnLayout;
import com.wear.widget.ChatBurnedLayout;
import com.wear.widget.ChatEditText;
import com.wear.widget.GlassText;
import com.wear.widget.MyImageView;
import com.wear.widget.RadiuImageView;
import com.wear.widget.dialog.LinkJumpDialog;
import com.wear.widget.dialog.ManagerGroupMemberInfoDialog;
import com.wear.widget.llong.CircularProgressView;
import com.wear.widget.roundwidget.SkinRoundAutoLinearLayout;
import com.wear.widget.roundwidget.SkinRoundConstraintLayout;
import dc.ToyControlBuilder;
import dc.ah4;
import dc.av1;
import dc.be3;
import dc.ce3;
import dc.ch3;
import dc.cs3;
import dc.cu3;
import dc.db2;
import dc.e82;
import dc.ff3;
import dc.gg3;
import dc.h12;
import dc.hu3;
import dc.ie3;
import dc.ii;
import dc.is3;
import dc.jg3;
import dc.k22;
import dc.kf;
import dc.kn3;
import dc.kv1;
import dc.l22;
import dc.mp1;
import dc.mz1;
import dc.na2;
import dc.nd3;
import dc.nf3;
import dc.nz1;
import dc.pc1;
import dc.pj3;
import dc.qf3;
import dc.qo;
import dc.qx3;
import dc.rf3;
import dc.rq1;
import dc.sa2;
import dc.sd3;
import dc.sg3;
import dc.so3;
import dc.th4;
import dc.u51;
import dc.ue3;
import dc.uf2;
import dc.vg3;
import dc.vo;
import dc.xe2;
import dc.xo;
import dc.y12;
import dc.ye3;
import dc.zb2;
import dc.zt3;
import io.agora.rtm2.RtmConstants;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.qiujuer.genius.graphics.Blur;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smackx.disco.bean.request.InviteBean;
import org.jivesoftware.smackx.disco.bean.request.RequestMemberInvite;
import org.jivesoftware.smackx.disco.bean.request.RequestMembersRemove;
import org.jivesoftware.smackx.disco.bean.response.BaseResponse;
import org.jivesoftware.smackx.disco.bean.response.ResponseCreateChatRoom;
import org.jivesoftware.smackx.vcardtemp.VCardManager;
import org.jivesoftware.smackx.vcardtemp.packet.VCard;
import pl.droidsonroids.gif.GifImageView;

/* loaded from: classes3.dex */
public class MessageNewAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    public List<CommunMessage> e;
    public Activity f;
    public sa2 g;
    public qo i;
    public u0 j;
    public LinkJumpDialog l;
    public String o;
    public Account p;
    public e82 q;
    public so3 r;
    public ie3 s;
    public ChatEditText t;
    public HashMap<String, GifImageView> a = new HashMap<>();
    public int b = -1;
    public t0 c = null;
    public boolean d = false;
    public int h = -1;
    public Handler k = new Handler(Looper.getMainLooper());
    public HashMap<String, View> m = new HashMap<>();
    public HashMap<Integer, ImageView> n = new HashMap<>();
    public HashMap<String, String> u = new HashMap<>();
    public View v = null;
    public boolean w = true;
    public Handler x = new Handler(Looper.getMainLooper());

    public class AlarmFriendViewHolder extends AlarmViewHolder {

        @BindView(R.id.alarm_accept)
        public TextView alarmAccept;

        @BindView(R.id.alarm_action)
        public LinearLayout alarmAction;

        @BindView(R.id.alarm_action_layout)
        public LinearLayout alarmActionLayout;

        @BindView(R.id.alarm_auto_play)
        public TextView alarmAutoPlay;

        @BindView(R.id.alarm_auto_play_icon)
        public ImageView alarmAutoPlayIcon;

        @BindView(R.id.alarm_decline)
        public TextView alarmDecline;

        @BindView(R.id.alarm_message)
        public LinearLayout alarmMessage;

        @BindView(R.id.alarm_vertical_line)
        public View alarmVerticalLine;

        public AlarmFriendViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(messageNewAdapter, view);
        }
    }

    public class AlarmFriendViewHolder_ViewBinding extends AlarmViewHolder_ViewBinding {
        public AlarmFriendViewHolder c;

        @UiThread
        public AlarmFriendViewHolder_ViewBinding(AlarmFriendViewHolder alarmFriendViewHolder, View view) {
            super(alarmFriendViewHolder, view);
            this.c = alarmFriendViewHolder;
            alarmFriendViewHolder.alarmAutoPlay = (TextView) Utils.findRequiredViewAsType(view, R.id.alarm_auto_play, "field 'alarmAutoPlay'", TextView.class);
            alarmFriendViewHolder.alarmAutoPlayIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.alarm_auto_play_icon, "field 'alarmAutoPlayIcon'", ImageView.class);
            alarmFriendViewHolder.alarmDecline = (TextView) Utils.findRequiredViewAsType(view, R.id.alarm_decline, "field 'alarmDecline'", TextView.class);
            alarmFriendViewHolder.alarmAccept = (TextView) Utils.findRequiredViewAsType(view, R.id.alarm_accept, "field 'alarmAccept'", TextView.class);
            alarmFriendViewHolder.alarmActionLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.alarm_action_layout, "field 'alarmActionLayout'", LinearLayout.class);
            alarmFriendViewHolder.alarmAction = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.alarm_action, "field 'alarmAction'", LinearLayout.class);
            alarmFriendViewHolder.alarmMessage = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.alarm_message, "field 'alarmMessage'", LinearLayout.class);
            alarmFriendViewHolder.alarmVerticalLine = Utils.findRequiredView(view, R.id.alarm_vertical_line, "field 'alarmVerticalLine'");
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.AlarmViewHolder_ViewBinding, com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            AlarmFriendViewHolder alarmFriendViewHolder = this.c;
            if (alarmFriendViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.c = null;
            alarmFriendViewHolder.alarmAutoPlay = null;
            alarmFriendViewHolder.alarmAutoPlayIcon = null;
            alarmFriendViewHolder.alarmDecline = null;
            alarmFriendViewHolder.alarmAccept = null;
            alarmFriendViewHolder.alarmActionLayout = null;
            alarmFriendViewHolder.alarmAction = null;
            alarmFriendViewHolder.alarmMessage = null;
            alarmFriendViewHolder.alarmVerticalLine = null;
            super.unbind();
        }
    }

    public class AlarmSelfViewHolder extends AlarmViewHolder {

        @BindView(R.id.block_sync)
        public ImageView blockSync;

        @BindView(R.id.loading)
        public ProgressBar loading;

        public AlarmSelfViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(messageNewAdapter, view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public ImageView a() {
            return this.blockSync;
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View b() {
            return this.loading;
        }
    }

    public class AlarmSelfViewHolder_ViewBinding extends AlarmViewHolder_ViewBinding {
        public AlarmSelfViewHolder c;

        @UiThread
        public AlarmSelfViewHolder_ViewBinding(AlarmSelfViewHolder alarmSelfViewHolder, View view) {
            super(alarmSelfViewHolder, view);
            this.c = alarmSelfViewHolder;
            alarmSelfViewHolder.loading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.loading, "field 'loading'", ProgressBar.class);
            alarmSelfViewHolder.blockSync = (ImageView) Utils.findRequiredViewAsType(view, R.id.block_sync, "field 'blockSync'", ImageView.class);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.AlarmViewHolder_ViewBinding, com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            AlarmSelfViewHolder alarmSelfViewHolder = this.c;
            if (alarmSelfViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.c = null;
            alarmSelfViewHolder.loading = null;
            alarmSelfViewHolder.blockSync = null;
            super.unbind();
        }
    }

    public class AlarmViewHolder extends BaseViewHolder {

        @BindView(R.id.alarm_message)
        public LinearLayout alarmMessage;

        @BindView(R.id.alarm_requency)
        public TextView alarmRequency;

        @BindView(R.id.alarm_time)
        public TextView alarmTime;

        @BindView(R.id.iv_alarm)
        public ImageView ivAlarm;

        @BindView(R.id.ll_root_anima)
        public LinearLayout llRootAnima;

        @BindView(R.id.user_img)
        public RoundedImageView userImg;

        public AlarmViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View c() {
            return this.alarmMessage;
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View d() {
            return this.alarmMessage;
        }
    }

    public class AlarmViewHolder_ViewBinding extends BaseViewHolder_ViewBinding {
        public AlarmViewHolder b;

        @UiThread
        public AlarmViewHolder_ViewBinding(AlarmViewHolder alarmViewHolder, View view) {
            super(alarmViewHolder, view);
            this.b = alarmViewHolder;
            alarmViewHolder.ivAlarm = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_alarm, "field 'ivAlarm'", ImageView.class);
            alarmViewHolder.alarmTime = (TextView) Utils.findRequiredViewAsType(view, R.id.alarm_time, "field 'alarmTime'", TextView.class);
            alarmViewHolder.alarmRequency = (TextView) Utils.findRequiredViewAsType(view, R.id.alarm_requency, "field 'alarmRequency'", TextView.class);
            alarmViewHolder.alarmMessage = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.alarm_message, "field 'alarmMessage'", LinearLayout.class);
            alarmViewHolder.userImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.user_img, "field 'userImg'", RoundedImageView.class);
            alarmViewHolder.llRootAnima = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_root_anima, "field 'llRootAnima'", LinearLayout.class);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            AlarmViewHolder alarmViewHolder = this.b;
            if (alarmViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            alarmViewHolder.ivAlarm = null;
            alarmViewHolder.alarmTime = null;
            alarmViewHolder.alarmRequency = null;
            alarmViewHolder.alarmMessage = null;
            alarmViewHolder.userImg = null;
            alarmViewHolder.llRootAnima = null;
            super.unbind();
        }
    }

    public class AudioFriendViewHolder extends AudioViewHolder {
        public AudioFriendViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(messageNewAdapter, view);
        }
    }

    public class AudioSelfViewHolder extends AudioViewHolder {

        @BindView(R.id.block_sync)
        public ImageView blockSync;

        @BindView(R.id.loading)
        public ProgressBar loading;

        public AudioSelfViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(messageNewAdapter, view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public ImageView a() {
            return this.blockSync;
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View b() {
            return this.loading;
        }
    }

    public class AudioSelfViewHolder_ViewBinding extends AudioViewHolder_ViewBinding {
        public AudioSelfViewHolder c;

        @UiThread
        public AudioSelfViewHolder_ViewBinding(AudioSelfViewHolder audioSelfViewHolder, View view) {
            super(audioSelfViewHolder, view);
            this.c = audioSelfViewHolder;
            audioSelfViewHolder.loading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.loading, "field 'loading'", ProgressBar.class);
            audioSelfViewHolder.blockSync = (ImageView) Utils.findRequiredViewAsType(view, R.id.block_sync, "field 'blockSync'", ImageView.class);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.AudioViewHolder_ViewBinding, com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            AudioSelfViewHolder audioSelfViewHolder = this.c;
            if (audioSelfViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.c = null;
            audioSelfViewHolder.loading = null;
            audioSelfViewHolder.blockSync = null;
            super.unbind();
        }
    }

    public class AudioViewHolder extends BaseViewHolder {

        @BindView(R.id.ll_root_anima)
        public LinearLayout llRootAnima;

        @BindView(R.id.ll_voice)
        public SkinRoundAutoLinearLayout llVoice;

        @BindView(R.id.tv_expired)
        public TextView tvExpired;

        @BindView(R.id.user_img)
        public RoundedImageView userImg;

        @BindView(R.id.v_guideline)
        public View vGuideline;

        @BindView(R.id.voice_icon)
        public LottieAnimationView voiceIcon;

        @BindView(R.id.voice_play)
        public SkinRoundConstraintLayout voicePlay;

        @BindView(R.id.voice_time)
        public TextView voiceTime;

        public AudioViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View c() {
            return this.voicePlay;
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View d() {
            return this.voicePlay;
        }
    }

    public class AudioViewHolder_ViewBinding extends BaseViewHolder_ViewBinding {
        public AudioViewHolder b;

        @UiThread
        public AudioViewHolder_ViewBinding(AudioViewHolder audioViewHolder, View view) {
            super(audioViewHolder, view);
            this.b = audioViewHolder;
            audioViewHolder.voiceTime = (TextView) Utils.findRequiredViewAsType(view, R.id.voice_time, "field 'voiceTime'", TextView.class);
            audioViewHolder.voiceIcon = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.voice_icon, "field 'voiceIcon'", LottieAnimationView.class);
            audioViewHolder.llVoice = (SkinRoundAutoLinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_voice, "field 'llVoice'", SkinRoundAutoLinearLayout.class);
            audioViewHolder.voicePlay = (SkinRoundConstraintLayout) Utils.findRequiredViewAsType(view, R.id.voice_play, "field 'voicePlay'", SkinRoundConstraintLayout.class);
            audioViewHolder.userImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.user_img, "field 'userImg'", RoundedImageView.class);
            audioViewHolder.tvExpired = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_expired, "field 'tvExpired'", TextView.class);
            audioViewHolder.llRootAnima = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_root_anima, "field 'llRootAnima'", LinearLayout.class);
            audioViewHolder.vGuideline = Utils.findRequiredView(view, R.id.v_guideline, "field 'vGuideline'");
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            AudioViewHolder audioViewHolder = this.b;
            if (audioViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            audioViewHolder.voiceTime = null;
            audioViewHolder.voiceIcon = null;
            audioViewHolder.llVoice = null;
            audioViewHolder.voicePlay = null;
            audioViewHolder.userImg = null;
            audioViewHolder.tvExpired = null;
            audioViewHolder.llRootAnima = null;
            audioViewHolder.vGuideline = null;
            super.unbind();
        }
    }

    public static abstract class BaseViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.chat_item_time_create)
        public TextView chatItemTimeCreate;

        @BindView(R.id.long_chat_create_layout)
        public View longChatCreateLayout;

        @BindView(R.id.new_message_notice_bar)
        public RelativeLayout newMessageBar;

        @BindView(R.id.time_layout)
        public RelativeLayout timeLayout;

        public BaseViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public ImageView a() {
            return null;
        }

        public View b() {
            return null;
        }

        public abstract View c();

        public abstract View d();
    }

    public class BaseViewHolder_ViewBinding implements Unbinder {
        public BaseViewHolder a;

        @UiThread
        public BaseViewHolder_ViewBinding(BaseViewHolder baseViewHolder, View view) {
            this.a = baseViewHolder;
            baseViewHolder.chatItemTimeCreate = (TextView) Utils.findRequiredViewAsType(view, R.id.chat_item_time_create, "field 'chatItemTimeCreate'", TextView.class);
            baseViewHolder.longChatCreateLayout = Utils.findRequiredView(view, R.id.long_chat_create_layout, "field 'longChatCreateLayout'");
            baseViewHolder.timeLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.time_layout, "field 'timeLayout'", RelativeLayout.class);
            baseViewHolder.newMessageBar = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.new_message_notice_bar, "field 'newMessageBar'", RelativeLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            BaseViewHolder baseViewHolder = this.a;
            if (baseViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            baseViewHolder.chatItemTimeCreate = null;
            baseViewHolder.longChatCreateLayout = null;
            baseViewHolder.timeLayout = null;
            baseViewHolder.newMessageBar = null;
        }
    }

    public class ChatFriendViewHolder extends ChatViewHolder {
        public ChatFriendViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(messageNewAdapter, view);
        }
    }

    public class ChatSelfViewHolder extends ChatViewHolder {

        @BindView(R.id.block_sync)
        public ImageView blockSync;

        @BindView(R.id.loading)
        public ProgressBar loading;

        public ChatSelfViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(messageNewAdapter, view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public ImageView a() {
            return this.blockSync;
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View b() {
            return this.loading;
        }
    }

    public class ChatSelfViewHolder_ViewBinding extends ChatViewHolder_ViewBinding {
        public ChatSelfViewHolder c;

        @UiThread
        public ChatSelfViewHolder_ViewBinding(ChatSelfViewHolder chatSelfViewHolder, View view) {
            super(chatSelfViewHolder, view);
            this.c = chatSelfViewHolder;
            chatSelfViewHolder.loading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.loading, "field 'loading'", ProgressBar.class);
            chatSelfViewHolder.blockSync = (ImageView) Utils.findRequiredViewAsType(view, R.id.block_sync, "field 'blockSync'", ImageView.class);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.ChatViewHolder_ViewBinding, com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            ChatSelfViewHolder chatSelfViewHolder = this.c;
            if (chatSelfViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.c = null;
            chatSelfViewHolder.loading = null;
            chatSelfViewHolder.blockSync = null;
            super.unbind();
        }
    }

    public class ChatViewHolder extends BaseViewHolder implements Animator.AnimatorListener {

        @BindView(R.id.cl_reply)
        public ConstraintLayout cl_reply;

        @BindView(R.id.fl_user_message)
        public FrameLayout flUserMessage;

        @BindView(R.id.fl_emoji)
        public FrameLayout fl_emoji;

        @BindView(R.id.img_expired)
        public ImageView imgExpired;

        @BindView(R.id.iv_emoji)
        public ImageView iv_emoji;

        @BindView(R.id.ll_root_anima)
        public View llRootAnima;

        @BindView(R.id.ll_reply_voice)
        public RelativeLayout ll_reply_voice;

        @BindView(R.id.ll_user_message)
        public LinearLayout ll_user_message;

        @BindView(R.id.lottie_view)
        public LottieAnimationView lottieView;

        @BindView(R.id.message_blur)
        public ImageView messageBlur;

        @BindView(R.id.message_glass)
        public ImageView messageGlass;

        @BindView(R.id.miv_reply_user_picture)
        public RadiuImageView miv_reply_user_picture;

        @BindView(R.id.miv_reply_user_video_picture)
        public RadiuImageView miv_reply_user_video_picture;

        @BindView(R.id.reply_voice_icon)
        public LottieAnimationView reply_voice_icon;

        @BindView(R.id.reply_voice_time)
        public TextView reply_voice_time;

        @BindView(R.id.rl_reply_video)
        public RelativeLayout rl_reply_video;

        @BindView(R.id.tv_reply_from_name)
        public TextView tv_reply_from_name;

        @BindView(R.id.tv_reply_msg)
        public GlassText tv_reply_msg;

        @BindView(R.id.user_img)
        public RoundedImageView userImg;

        @BindView(R.id.user_message)
        public HttpTextView userMessage;

        @BindView(R.id.v_left)
        public View vLeft;

        @BindView(R.id.v_line_bottom)
        public View vLineBottom;

        public ChatViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(view);
            this.lottieView.e(this);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View c() {
            return this.flUserMessage;
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View d() {
            return this.fl_emoji.getVisibility() == 0 ? this.fl_emoji : this.userMessage;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.lottieView.getVisibility() == 0) {
                this.lottieView.setVisibility(8);
                this.lottieView.setProgress(0.0f);
                this.iv_emoji.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public class ChatViewHolder_ViewBinding extends BaseViewHolder_ViewBinding {
        public ChatViewHolder b;

        @UiThread
        public ChatViewHolder_ViewBinding(ChatViewHolder chatViewHolder, View view) {
            super(chatViewHolder, view);
            this.b = chatViewHolder;
            chatViewHolder.userMessage = (HttpTextView) Utils.findRequiredViewAsType(view, R.id.user_message, "field 'userMessage'", HttpTextView.class);
            chatViewHolder.messageBlur = (ImageView) Utils.findRequiredViewAsType(view, R.id.message_blur, "field 'messageBlur'", ImageView.class);
            chatViewHolder.messageGlass = (ImageView) Utils.findRequiredViewAsType(view, R.id.message_glass, "field 'messageGlass'", ImageView.class);
            chatViewHolder.flUserMessage = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_user_message, "field 'flUserMessage'", FrameLayout.class);
            chatViewHolder.userImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.user_img, "field 'userImg'", RoundedImageView.class);
            chatViewHolder.llRootAnima = Utils.findRequiredView(view, R.id.ll_root_anima, "field 'llRootAnima'");
            chatViewHolder.fl_emoji = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_emoji, "field 'fl_emoji'", FrameLayout.class);
            chatViewHolder.lottieView = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.lottie_view, "field 'lottieView'", LottieAnimationView.class);
            chatViewHolder.iv_emoji = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_emoji, "field 'iv_emoji'", ImageView.class);
            chatViewHolder.ll_user_message = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_user_message, "field 'll_user_message'", LinearLayout.class);
            chatViewHolder.cl_reply = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.cl_reply, "field 'cl_reply'", ConstraintLayout.class);
            chatViewHolder.tv_reply_from_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_reply_from_name, "field 'tv_reply_from_name'", TextView.class);
            chatViewHolder.tv_reply_msg = (GlassText) Utils.findRequiredViewAsType(view, R.id.tv_reply_msg, "field 'tv_reply_msg'", GlassText.class);
            chatViewHolder.miv_reply_user_picture = (RadiuImageView) Utils.findRequiredViewAsType(view, R.id.miv_reply_user_picture, "field 'miv_reply_user_picture'", RadiuImageView.class);
            chatViewHolder.rl_reply_video = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_reply_video, "field 'rl_reply_video'", RelativeLayout.class);
            chatViewHolder.miv_reply_user_video_picture = (RadiuImageView) Utils.findRequiredViewAsType(view, R.id.miv_reply_user_video_picture, "field 'miv_reply_user_video_picture'", RadiuImageView.class);
            chatViewHolder.ll_reply_voice = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.ll_reply_voice, "field 'll_reply_voice'", RelativeLayout.class);
            chatViewHolder.reply_voice_icon = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.reply_voice_icon, "field 'reply_voice_icon'", LottieAnimationView.class);
            chatViewHolder.reply_voice_time = (TextView) Utils.findRequiredViewAsType(view, R.id.reply_voice_time, "field 'reply_voice_time'", TextView.class);
            chatViewHolder.imgExpired = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_expired, "field 'imgExpired'", ImageView.class);
            chatViewHolder.vLeft = Utils.findRequiredView(view, R.id.v_left, "field 'vLeft'");
            chatViewHolder.vLineBottom = Utils.findRequiredView(view, R.id.v_line_bottom, "field 'vLineBottom'");
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            ChatViewHolder chatViewHolder = this.b;
            if (chatViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            chatViewHolder.userMessage = null;
            chatViewHolder.messageBlur = null;
            chatViewHolder.messageGlass = null;
            chatViewHolder.flUserMessage = null;
            chatViewHolder.userImg = null;
            chatViewHolder.llRootAnima = null;
            chatViewHolder.fl_emoji = null;
            chatViewHolder.lottieView = null;
            chatViewHolder.iv_emoji = null;
            chatViewHolder.ll_user_message = null;
            chatViewHolder.cl_reply = null;
            chatViewHolder.tv_reply_from_name = null;
            chatViewHolder.tv_reply_msg = null;
            chatViewHolder.miv_reply_user_picture = null;
            chatViewHolder.rl_reply_video = null;
            chatViewHolder.miv_reply_user_video_picture = null;
            chatViewHolder.ll_reply_voice = null;
            chatViewHolder.reply_voice_icon = null;
            chatViewHolder.reply_voice_time = null;
            chatViewHolder.imgExpired = null;
            chatViewHolder.vLeft = null;
            chatViewHolder.vLineBottom = null;
            super.unbind();
        }
    }

    public class ControlFriendViewHolder extends ControlViewHolder {
        public ControlFriendViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(messageNewAdapter, view);
        }
    }

    public class ControlSelfViewHolder extends ControlViewHolder {
        public ControlSelfViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(messageNewAdapter, view);
        }
    }

    public class ControlViewHolder extends BaseViewHolder {

        @BindView(R.id.control_bottom_layout)
        public LinearLayout controlBottomLayout;

        @BindView(R.id.control_message)
        public LinearLayout controlMessage;

        @BindView(R.id.icon_control)
        public ImageView iconControl;

        @BindView(R.id.ll_root_anima)
        public LinearLayout llRootAnima;

        @BindView(R.id.tv_control_again)
        public TextView tvControlAgain;

        @BindView(R.id.tv_control_content)
        public TextView tvControlContent;

        @BindView(R.id.tv_control_time)
        public TextView tvControlTime;

        @BindView(R.id.user_img)
        public RoundedImageView userImg;

        public ControlViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View c() {
            return this.controlMessage;
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View d() {
            return this.controlMessage;
        }
    }

    public class ControlViewHolder_ViewBinding extends BaseViewHolder_ViewBinding {
        public ControlViewHolder b;

        @UiThread
        public ControlViewHolder_ViewBinding(ControlViewHolder controlViewHolder, View view) {
            super(controlViewHolder, view);
            this.b = controlViewHolder;
            controlViewHolder.userImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.user_img, "field 'userImg'", RoundedImageView.class);
            controlViewHolder.iconControl = (ImageView) Utils.findRequiredViewAsType(view, R.id.icon_control, "field 'iconControl'", ImageView.class);
            controlViewHolder.tvControlContent = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_control_content, "field 'tvControlContent'", TextView.class);
            controlViewHolder.tvControlTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_control_time, "field 'tvControlTime'", TextView.class);
            controlViewHolder.tvControlAgain = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_control_again, "field 'tvControlAgain'", TextView.class);
            controlViewHolder.controlBottomLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.control_bottom_layout, "field 'controlBottomLayout'", LinearLayout.class);
            controlViewHolder.controlMessage = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.control_message, "field 'controlMessage'", LinearLayout.class);
            controlViewHolder.llRootAnima = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_root_anima, "field 'llRootAnima'", LinearLayout.class);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            ControlViewHolder controlViewHolder = this.b;
            if (controlViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            controlViewHolder.userImg = null;
            controlViewHolder.iconControl = null;
            controlViewHolder.tvControlContent = null;
            controlViewHolder.tvControlTime = null;
            controlViewHolder.tvControlAgain = null;
            controlViewHolder.controlBottomLayout = null;
            controlViewHolder.controlMessage = null;
            controlViewHolder.llRootAnima = null;
            super.unbind();
        }
    }

    public class DefalutViewHolder extends BaseViewHolder {
        public DefalutViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View c() {
            return null;
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View d() {
            return null;
        }
    }

    public class GiftCardFriendViewHolder extends GiftCardViewHolder {
        public GiftCardFriendViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(messageNewAdapter, view);
        }
    }

    public class GiftCardSelfViewHolder extends GiftCardViewHolder {
        public GiftCardSelfViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(messageNewAdapter, view);
        }
    }

    public class GiftCardViewHolder extends BaseViewHolder {

        @BindView(R.id.center_line)
        public TextView centerLine;

        @BindView(R.id.gift_card_icon)
        public ImageView giftCardIcon;

        @BindView(R.id.gift_card_image)
        public ImageView giftCardImage;

        @BindView(R.id.gift_card_layout)
        public RelativeLayout giftCardLayout;

        @BindView(R.id.gift_card_title)
        public TextView giftCardTitle;

        @BindView(R.id.ll_root_anima)
        public LinearLayout llRootAnima;

        @BindView(R.id.notice_text)
        public TextView noticeText;

        @BindView(R.id.user_img)
        public RoundedImageView userImg;

        public GiftCardViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View c() {
            return this.giftCardLayout;
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View d() {
            return this.giftCardLayout;
        }
    }

    public class GiftCardViewHolder_ViewBinding extends BaseViewHolder_ViewBinding {
        public GiftCardViewHolder b;

        @UiThread
        public GiftCardViewHolder_ViewBinding(GiftCardViewHolder giftCardViewHolder, View view) {
            super(giftCardViewHolder, view);
            this.b = giftCardViewHolder;
            giftCardViewHolder.userImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.user_img, "field 'userImg'", RoundedImageView.class);
            giftCardViewHolder.noticeText = (TextView) Utils.findRequiredViewAsType(view, R.id.notice_text, "field 'noticeText'", TextView.class);
            giftCardViewHolder.giftCardIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.gift_card_icon, "field 'giftCardIcon'", ImageView.class);
            giftCardViewHolder.giftCardTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.gift_card_title, "field 'giftCardTitle'", TextView.class);
            giftCardViewHolder.centerLine = (TextView) Utils.findRequiredViewAsType(view, R.id.center_line, "field 'centerLine'", TextView.class);
            giftCardViewHolder.giftCardImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.gift_card_image, "field 'giftCardImage'", ImageView.class);
            giftCardViewHolder.giftCardLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.gift_card_layout, "field 'giftCardLayout'", RelativeLayout.class);
            giftCardViewHolder.llRootAnima = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_root_anima, "field 'llRootAnima'", LinearLayout.class);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            GiftCardViewHolder giftCardViewHolder = this.b;
            if (giftCardViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            giftCardViewHolder.userImg = null;
            giftCardViewHolder.noticeText = null;
            giftCardViewHolder.giftCardIcon = null;
            giftCardViewHolder.giftCardTitle = null;
            giftCardViewHolder.centerLine = null;
            giftCardViewHolder.giftCardImage = null;
            giftCardViewHolder.giftCardLayout = null;
            giftCardViewHolder.llRootAnima = null;
            super.unbind();
        }
    }

    public class PatternFriendViewHolder extends PatternViewHolder {

        @BindView(R.id.ll_root_anima)
        public LinearLayout llRootAnima;

        @BindView(R.id.pattern_name)
        public TextView patternName;

        @BindView(R.id.pattern_play)
        public ImageView patternPlay;

        @BindView(R.id.pattern_time)
        public TextView patternTime;

        @BindView(R.id.pattern_time_play)
        public TextView patternTimePlay;

        @BindView(R.id.pattern_time_play_x)
        public TextView patternTimePlayX;

        public PatternFriendViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(messageNewAdapter, view);
        }
    }

    public class PatternFriendViewHolder_ViewBinding extends PatternViewHolder_ViewBinding {
        public PatternFriendViewHolder c;

        @UiThread
        public PatternFriendViewHolder_ViewBinding(PatternFriendViewHolder patternFriendViewHolder, View view) {
            super(patternFriendViewHolder, view);
            this.c = patternFriendViewHolder;
            patternFriendViewHolder.patternPlay = (ImageView) Utils.findRequiredViewAsType(view, R.id.pattern_play, "field 'patternPlay'", ImageView.class);
            patternFriendViewHolder.patternName = (TextView) Utils.findRequiredViewAsType(view, R.id.pattern_name, "field 'patternName'", TextView.class);
            patternFriendViewHolder.patternTimePlay = (TextView) Utils.findRequiredViewAsType(view, R.id.pattern_time_play, "field 'patternTimePlay'", TextView.class);
            patternFriendViewHolder.patternTime = (TextView) Utils.findRequiredViewAsType(view, R.id.pattern_time, "field 'patternTime'", TextView.class);
            patternFriendViewHolder.patternTimePlayX = (TextView) Utils.findRequiredViewAsType(view, R.id.pattern_time_play_x, "field 'patternTimePlayX'", TextView.class);
            patternFriendViewHolder.llRootAnima = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_root_anima, "field 'llRootAnima'", LinearLayout.class);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.PatternViewHolder_ViewBinding, com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            PatternFriendViewHolder patternFriendViewHolder = this.c;
            if (patternFriendViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.c = null;
            patternFriendViewHolder.patternPlay = null;
            patternFriendViewHolder.patternName = null;
            patternFriendViewHolder.patternTimePlay = null;
            patternFriendViewHolder.patternTime = null;
            patternFriendViewHolder.patternTimePlayX = null;
            patternFriendViewHolder.llRootAnima = null;
            super.unbind();
        }
    }

    public class PatternSelfViewHolder extends PatternViewHolder {

        @BindView(R.id.block_sync)
        public ImageView blockSync;

        @BindView(R.id.loading)
        public ProgressBar loading;

        @BindView(R.id.pattern_resend)
        public TextView patternResend;

        @BindView(R.id.pattern_time)
        public TextView patternTime;

        @BindView(R.id.pattern_vertical_line)
        public View patternVerticalLine;

        public PatternSelfViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(messageNewAdapter, view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public ImageView a() {
            return this.blockSync;
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View b() {
            return this.loading;
        }
    }

    public class PatternSelfViewHolder_ViewBinding extends PatternViewHolder_ViewBinding {
        public PatternSelfViewHolder c;

        @UiThread
        public PatternSelfViewHolder_ViewBinding(PatternSelfViewHolder patternSelfViewHolder, View view) {
            super(patternSelfViewHolder, view);
            this.c = patternSelfViewHolder;
            patternSelfViewHolder.loading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.loading, "field 'loading'", ProgressBar.class);
            patternSelfViewHolder.blockSync = (ImageView) Utils.findRequiredViewAsType(view, R.id.block_sync, "field 'blockSync'", ImageView.class);
            patternSelfViewHolder.patternResend = (TextView) Utils.findRequiredViewAsType(view, R.id.pattern_resend, "field 'patternResend'", TextView.class);
            patternSelfViewHolder.patternTime = (TextView) Utils.findRequiredViewAsType(view, R.id.pattern_time, "field 'patternTime'", TextView.class);
            patternSelfViewHolder.patternVerticalLine = Utils.findRequiredView(view, R.id.pattern_vertical_line, "field 'patternVerticalLine'");
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.PatternViewHolder_ViewBinding, com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            PatternSelfViewHolder patternSelfViewHolder = this.c;
            if (patternSelfViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.c = null;
            patternSelfViewHolder.loading = null;
            patternSelfViewHolder.blockSync = null;
            patternSelfViewHolder.patternResend = null;
            patternSelfViewHolder.patternTime = null;
            patternSelfViewHolder.patternVerticalLine = null;
            super.unbind();
        }
    }

    public class PatternViewHolder extends BaseViewHolder {
        public String a;

        @BindView(R.id.ll_pattern_button)
        public LinearLayout llPatternButton;

        @BindView(R.id.ll_root_anima)
        public LinearLayout llRootAnima;

        @BindView(R.id.pattern_message)
        public LinearLayout patternMessage;

        @BindView(R.id.pattern_name)
        public TextView patternName;

        @BindView(R.id.pattern_play_icon)
        public GifImageView patternPlayIcon;

        @BindView(R.id.pattern_save)
        public TextView patternSave;

        @BindView(R.id.pattern_time)
        public TextView patternTime;

        @BindView(R.id.user_img)
        public RoundedImageView userImg;

        public PatternViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View c() {
            return this.patternMessage;
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View d() {
            return this.patternMessage;
        }
    }

    public class PatternViewHolder_ViewBinding extends BaseViewHolder_ViewBinding {
        public PatternViewHolder b;

        @UiThread
        public PatternViewHolder_ViewBinding(PatternViewHolder patternViewHolder, View view) {
            super(patternViewHolder, view);
            this.b = patternViewHolder;
            patternViewHolder.patternMessage = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.pattern_message, "field 'patternMessage'", LinearLayout.class);
            patternViewHolder.userImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.user_img, "field 'userImg'", RoundedImageView.class);
            patternViewHolder.patternPlayIcon = (GifImageView) Utils.findRequiredViewAsType(view, R.id.pattern_play_icon, "field 'patternPlayIcon'", GifImageView.class);
            patternViewHolder.patternName = (TextView) Utils.findRequiredViewAsType(view, R.id.pattern_name, "field 'patternName'", TextView.class);
            patternViewHolder.patternTime = (TextView) Utils.findRequiredViewAsType(view, R.id.pattern_time, "field 'patternTime'", TextView.class);
            patternViewHolder.patternSave = (TextView) Utils.findRequiredViewAsType(view, R.id.pattern_save, "field 'patternSave'", TextView.class);
            patternViewHolder.llRootAnima = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_root_anima, "field 'llRootAnima'", LinearLayout.class);
            patternViewHolder.llPatternButton = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_pattern_button, "field 'llPatternButton'", LinearLayout.class);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            PatternViewHolder patternViewHolder = this.b;
            if (patternViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            patternViewHolder.patternMessage = null;
            patternViewHolder.userImg = null;
            patternViewHolder.patternPlayIcon = null;
            patternViewHolder.patternName = null;
            patternViewHolder.patternTime = null;
            patternViewHolder.patternSave = null;
            patternViewHolder.llRootAnima = null;
            patternViewHolder.llPatternButton = null;
            super.unbind();
        }
    }

    public class PictureFriendViewHolder extends PictureViewHolder {
        public PictureFriendViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(messageNewAdapter, view);
        }
    }

    public class PictureSelfViewHolder extends PictureViewHolder {

        @BindView(R.id.block_sync)
        public ImageView blockSync;

        @BindView(R.id.fl_chat_progress)
        public FrameLayout flChatProgress;

        @BindView(R.id.loading)
        public ProgressBar loading;

        @BindView(R.id.video_progress_bar)
        public CircularProgressView videoProgressBar;

        public PictureSelfViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(messageNewAdapter, view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public ImageView a() {
            return this.blockSync;
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View b() {
            return this.loading;
        }

        public CircularProgressView e() {
            return this.videoProgressBar;
        }
    }

    public class PictureSelfViewHolder_ViewBinding extends PictureViewHolder_ViewBinding {
        public PictureSelfViewHolder c;

        @UiThread
        public PictureSelfViewHolder_ViewBinding(PictureSelfViewHolder pictureSelfViewHolder, View view) {
            super(pictureSelfViewHolder, view);
            this.c = pictureSelfViewHolder;
            pictureSelfViewHolder.loading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.loading, "field 'loading'", ProgressBar.class);
            pictureSelfViewHolder.blockSync = (ImageView) Utils.findRequiredViewAsType(view, R.id.block_sync, "field 'blockSync'", ImageView.class);
            pictureSelfViewHolder.flChatProgress = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_chat_progress, "field 'flChatProgress'", FrameLayout.class);
            pictureSelfViewHolder.videoProgressBar = (CircularProgressView) Utils.findRequiredViewAsType(view, R.id.video_progress_bar, "field 'videoProgressBar'", CircularProgressView.class);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.PictureViewHolder_ViewBinding, com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            PictureSelfViewHolder pictureSelfViewHolder = this.c;
            if (pictureSelfViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.c = null;
            pictureSelfViewHolder.loading = null;
            pictureSelfViewHolder.blockSync = null;
            pictureSelfViewHolder.flChatProgress = null;
            pictureSelfViewHolder.videoProgressBar = null;
            super.unbind();
        }
    }

    public class PictureViewHolder extends BaseViewHolder {

        @BindView(R.id.chat_burn_bg)
        public ChatBurnLayout chatBurnBg;

        @BindView(R.id.chat_burned_bg)
        public ChatBurnedLayout chatBurnedBg;

        @BindView(R.id.frameLayout)
        public RelativeLayout frameLayout;

        @BindView(R.id.ll_root_anima)
        public LinearLayout llRootAnima;

        @BindView(R.id.user_img)
        public RoundedImageView userImg;

        @BindView(R.id.user_picture)
        public MyImageView userPicture;

        public PictureViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View c() {
            return this.userPicture;
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View d() {
            return this.frameLayout;
        }
    }

    public class PictureViewHolder_ViewBinding extends BaseViewHolder_ViewBinding {
        public PictureViewHolder b;

        @UiThread
        public PictureViewHolder_ViewBinding(PictureViewHolder pictureViewHolder, View view) {
            super(pictureViewHolder, view);
            this.b = pictureViewHolder;
            pictureViewHolder.frameLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.frameLayout, "field 'frameLayout'", RelativeLayout.class);
            pictureViewHolder.userPicture = (MyImageView) Utils.findRequiredViewAsType(view, R.id.user_picture, "field 'userPicture'", MyImageView.class);
            pictureViewHolder.userImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.user_img, "field 'userImg'", RoundedImageView.class);
            pictureViewHolder.chatBurnBg = (ChatBurnLayout) Utils.findRequiredViewAsType(view, R.id.chat_burn_bg, "field 'chatBurnBg'", ChatBurnLayout.class);
            pictureViewHolder.chatBurnedBg = (ChatBurnedLayout) Utils.findRequiredViewAsType(view, R.id.chat_burned_bg, "field 'chatBurnedBg'", ChatBurnedLayout.class);
            pictureViewHolder.llRootAnima = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_root_anima, "field 'llRootAnima'", LinearLayout.class);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            PictureViewHolder pictureViewHolder = this.b;
            if (pictureViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            pictureViewHolder.frameLayout = null;
            pictureViewHolder.userPicture = null;
            pictureViewHolder.userImg = null;
            pictureViewHolder.chatBurnBg = null;
            pictureViewHolder.chatBurnedBg = null;
            pictureViewHolder.llRootAnima = null;
            super.unbind();
        }
    }

    public class ShortVideoFriendViewHolder extends ShortVideoViewHolder {
        public ShortVideoFriendViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(messageNewAdapter, view);
        }
    }

    public class ShortVideoSelfViewHolder extends ShortVideoViewHolder {

        @BindView(R.id.block_sync)
        public ImageView blockSync;

        @BindView(R.id.fl_chat_progress)
        public FrameLayout flChatProgress;

        @BindView(R.id.video_progress_bar)
        public CircularProgressView videoProgressBar;

        public ShortVideoSelfViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(messageNewAdapter, view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public ImageView a() {
            return this.blockSync;
        }

        public CircularProgressView e() {
            return this.videoProgressBar;
        }
    }

    public class ShortVideoSelfViewHolder_ViewBinding extends ShortVideoViewHolder_ViewBinding {
        public ShortVideoSelfViewHolder c;

        @UiThread
        public ShortVideoSelfViewHolder_ViewBinding(ShortVideoSelfViewHolder shortVideoSelfViewHolder, View view) {
            super(shortVideoSelfViewHolder, view);
            this.c = shortVideoSelfViewHolder;
            shortVideoSelfViewHolder.blockSync = (ImageView) Utils.findRequiredViewAsType(view, R.id.block_sync, "field 'blockSync'", ImageView.class);
            shortVideoSelfViewHolder.flChatProgress = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_chat_progress, "field 'flChatProgress'", FrameLayout.class);
            shortVideoSelfViewHolder.videoProgressBar = (CircularProgressView) Utils.findRequiredViewAsType(view, R.id.video_progress_bar, "field 'videoProgressBar'", CircularProgressView.class);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.ShortVideoViewHolder_ViewBinding, com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            ShortVideoSelfViewHolder shortVideoSelfViewHolder = this.c;
            if (shortVideoSelfViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.c = null;
            shortVideoSelfViewHolder.blockSync = null;
            shortVideoSelfViewHolder.flChatProgress = null;
            shortVideoSelfViewHolder.videoProgressBar = null;
            super.unbind();
        }
    }

    public class ShortVideoViewHolder extends BaseViewHolder {

        @BindView(R.id.ll_root_anima)
        public View llRootAnima;

        @BindView(R.id.parentRelative)
        public RelativeLayout parentRelative;

        @BindView(R.id.play_icon)
        public ImageView playIcon;

        @BindView(R.id.user_img)
        public RoundedImageView userImg;

        @BindView(R.id.user_picture)
        public ImageView userPicture;

        @BindView(R.id.chat_burned_bg)
        public ChatBurnedLayout videoBurnedLayout;

        public ShortVideoViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View c() {
            return this.userPicture;
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View d() {
            return this.parentRelative;
        }
    }

    public class ShortVideoViewHolder_ViewBinding extends BaseViewHolder_ViewBinding {
        public ShortVideoViewHolder b;

        @UiThread
        public ShortVideoViewHolder_ViewBinding(ShortVideoViewHolder shortVideoViewHolder, View view) {
            super(shortVideoViewHolder, view);
            this.b = shortVideoViewHolder;
            shortVideoViewHolder.parentRelative = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.parentRelative, "field 'parentRelative'", RelativeLayout.class);
            shortVideoViewHolder.userPicture = (ImageView) Utils.findRequiredViewAsType(view, R.id.user_picture, "field 'userPicture'", ImageView.class);
            shortVideoViewHolder.userImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.user_img, "field 'userImg'", RoundedImageView.class);
            shortVideoViewHolder.playIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.play_icon, "field 'playIcon'", ImageView.class);
            shortVideoViewHolder.videoBurnedLayout = (ChatBurnedLayout) Utils.findRequiredViewAsType(view, R.id.chat_burned_bg, "field 'videoBurnedLayout'", ChatBurnedLayout.class);
            shortVideoViewHolder.llRootAnima = Utils.findRequiredView(view, R.id.ll_root_anima, "field 'llRootAnima'");
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            ShortVideoViewHolder shortVideoViewHolder = this.b;
            if (shortVideoViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            shortVideoViewHolder.parentRelative = null;
            shortVideoViewHolder.userPicture = null;
            shortVideoViewHolder.userImg = null;
            shortVideoViewHolder.playIcon = null;
            shortVideoViewHolder.videoBurnedLayout = null;
            shortVideoViewHolder.llRootAnima = null;
            super.unbind();
        }
    }

    public class SystemViewHolder extends BaseViewHolder {

        @BindView(R.id.ll_root_anima)
        public LinearLayout llRootAnima;

        @BindView(R.id.parentLinear)
        public LinearLayout parentLinear;

        @BindView(R.id.sync_message_layout)
        public LinearLayout syncMessageLayout;

        @BindView(R.id.tv_sync_message)
        public TextView tvSyncMessage;

        @BindView(R.id.typingAnimation)
        public LottieAnimationView typingAnimation;

        @BindView(R.id.typingLinear)
        public LinearLayout typingLinear;

        @BindView(R.id.user_img)
        public RoundedImageView userImg;

        public SystemViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View c() {
            return null;
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View d() {
            return null;
        }
    }

    public class SystemViewHolder_ViewBinding extends BaseViewHolder_ViewBinding {
        public SystemViewHolder b;

        @UiThread
        public SystemViewHolder_ViewBinding(SystemViewHolder systemViewHolder, View view) {
            super(systemViewHolder, view);
            this.b = systemViewHolder;
            systemViewHolder.tvSyncMessage = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_sync_message, "field 'tvSyncMessage'", TextView.class);
            systemViewHolder.syncMessageLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.sync_message_layout, "field 'syncMessageLayout'", LinearLayout.class);
            systemViewHolder.userImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.user_img, "field 'userImg'", RoundedImageView.class);
            systemViewHolder.typingLinear = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.typingLinear, "field 'typingLinear'", LinearLayout.class);
            systemViewHolder.typingAnimation = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.typingAnimation, "field 'typingAnimation'", LottieAnimationView.class);
            systemViewHolder.parentLinear = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.parentLinear, "field 'parentLinear'", LinearLayout.class);
            systemViewHolder.llRootAnima = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_root_anima, "field 'llRootAnima'", LinearLayout.class);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            SystemViewHolder systemViewHolder = this.b;
            if (systemViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            systemViewHolder.tvSyncMessage = null;
            systemViewHolder.syncMessageLayout = null;
            systemViewHolder.userImg = null;
            systemViewHolder.typingLinear = null;
            systemViewHolder.typingAnimation = null;
            systemViewHolder.parentLinear = null;
            systemViewHolder.llRootAnima = null;
            super.unbind();
        }
    }

    public class UnsupportFriendViewHolder extends UnsupportViewHolder {
        public UnsupportFriendViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(messageNewAdapter, view);
        }
    }

    public class UnsupportSelfViewHolder extends UnsupportViewHolder {

        @BindView(R.id.block_sync)
        public ImageView blockSync;

        @BindView(R.id.loading)
        public ProgressBar loading;

        public UnsupportSelfViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(messageNewAdapter, view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public ImageView a() {
            return this.blockSync;
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View b() {
            return this.loading;
        }
    }

    public class UnsupportSelfViewHolder_ViewBinding extends UnsupportViewHolder_ViewBinding {
        public UnsupportSelfViewHolder c;

        @UiThread
        public UnsupportSelfViewHolder_ViewBinding(UnsupportSelfViewHolder unsupportSelfViewHolder, View view) {
            super(unsupportSelfViewHolder, view);
            this.c = unsupportSelfViewHolder;
            unsupportSelfViewHolder.loading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.loading, "field 'loading'", ProgressBar.class);
            unsupportSelfViewHolder.blockSync = (ImageView) Utils.findRequiredViewAsType(view, R.id.block_sync, "field 'blockSync'", ImageView.class);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.UnsupportViewHolder_ViewBinding, com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            UnsupportSelfViewHolder unsupportSelfViewHolder = this.c;
            if (unsupportSelfViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.c = null;
            unsupportSelfViewHolder.loading = null;
            unsupportSelfViewHolder.blockSync = null;
            super.unbind();
        }
    }

    public class UnsupportViewHolder extends BaseViewHolder {

        @BindView(R.id.fl_user_message)
        public FrameLayout flUserMessage;

        @BindView(R.id.ll_root_anima)
        public View llRootAnima;

        @BindView(R.id.message_blur)
        public ImageView messageBlur;

        @BindView(R.id.message_glass)
        public ImageView messageGlass;

        @BindView(R.id.user_img)
        public RoundedImageView userImg;

        @BindView(R.id.user_message)
        public GlassText userMessage;

        public UnsupportViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View c() {
            return this.userMessage;
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View d() {
            return this.userMessage;
        }
    }

    public class UnsupportViewHolder_ViewBinding extends BaseViewHolder_ViewBinding {
        public UnsupportViewHolder b;

        @UiThread
        public UnsupportViewHolder_ViewBinding(UnsupportViewHolder unsupportViewHolder, View view) {
            super(unsupportViewHolder, view);
            this.b = unsupportViewHolder;
            unsupportViewHolder.userMessage = (GlassText) Utils.findRequiredViewAsType(view, R.id.user_message, "field 'userMessage'", GlassText.class);
            unsupportViewHolder.messageBlur = (ImageView) Utils.findRequiredViewAsType(view, R.id.message_blur, "field 'messageBlur'", ImageView.class);
            unsupportViewHolder.messageGlass = (ImageView) Utils.findRequiredViewAsType(view, R.id.message_glass, "field 'messageGlass'", ImageView.class);
            unsupportViewHolder.flUserMessage = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_user_message, "field 'flUserMessage'", FrameLayout.class);
            unsupportViewHolder.userImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.user_img, "field 'userImg'", RoundedImageView.class);
            unsupportViewHolder.llRootAnima = Utils.findRequiredView(view, R.id.ll_root_anima, "field 'llRootAnima'");
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            UnsupportViewHolder unsupportViewHolder = this.b;
            if (unsupportViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            unsupportViewHolder.userMessage = null;
            unsupportViewHolder.messageBlur = null;
            unsupportViewHolder.messageGlass = null;
            unsupportViewHolder.flUserMessage = null;
            unsupportViewHolder.userImg = null;
            unsupportViewHolder.llRootAnima = null;
            super.unbind();
        }
    }

    public class VMCardViewHolder extends BaseViewHolder {

        @BindView(R.id.iv_img)
        public ImageView iv_img;

        @BindView(R.id.ll_root_anima)
        public LinearLayout llRootAnima;

        @BindView(R.id.lly_vm)
        public LinearLayout llyVm;

        @BindView(R.id.tv_des)
        public TextView tvDes;

        @BindView(R.id.tv_title)
        public TextView tvTitle;

        @BindView(R.id.user_img)
        public RoundedImageView userImg;

        public VMCardViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View c() {
            return this.llyVm;
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View d() {
            return this.llyVm;
        }
    }

    public class VMCardViewHolder_ViewBinding extends BaseViewHolder_ViewBinding {
        public VMCardViewHolder b;

        @UiThread
        public VMCardViewHolder_ViewBinding(VMCardViewHolder vMCardViewHolder, View view) {
            super(vMCardViewHolder, view);
            this.b = vMCardViewHolder;
            vMCardViewHolder.iv_img = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_img, "field 'iv_img'", ImageView.class);
            vMCardViewHolder.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
            vMCardViewHolder.tvDes = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_des, "field 'tvDes'", TextView.class);
            vMCardViewHolder.llyVm = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lly_vm, "field 'llyVm'", LinearLayout.class);
            vMCardViewHolder.userImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.user_img, "field 'userImg'", RoundedImageView.class);
            vMCardViewHolder.llRootAnima = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_root_anima, "field 'llRootAnima'", LinearLayout.class);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            VMCardViewHolder vMCardViewHolder = this.b;
            if (vMCardViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            vMCardViewHolder.iv_img = null;
            vMCardViewHolder.tvTitle = null;
            vMCardViewHolder.tvDes = null;
            vMCardViewHolder.llyVm = null;
            vMCardViewHolder.userImg = null;
            vMCardViewHolder.llRootAnima = null;
            super.unbind();
        }
    }

    public class WishListSelfViewHolder extends WishListViewHolder {
        public WishListSelfViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(messageNewAdapter, view);
        }
    }

    public class WishListViewHolder extends BaseViewHolder {

        @BindView(R.id.center_line)
        public TextView giftCardLine;

        @BindView(R.id.message_glass)
        public ImageView glassView;

        @BindView(R.id.ll_root_anima)
        public LinearLayout llRootAnima;

        @BindView(R.id.wish_list_layout)
        public RelativeLayout rootView;

        @BindView(R.id.user_img)
        public RoundedImageView userImg;

        @BindView(R.id.wish_list_description)
        public TextView wishListDescription;

        @BindView(R.id.wish_list_name)
        public TextView wishListName;

        public WishListViewHolder(@NonNull MessageNewAdapter messageNewAdapter, View view) {
            super(view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View c() {
            return this.rootView;
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder
        public View d() {
            return this.rootView;
        }
    }

    public class WishListViewHolder_ViewBinding extends BaseViewHolder_ViewBinding {
        public WishListViewHolder b;

        @UiThread
        public WishListViewHolder_ViewBinding(WishListViewHolder wishListViewHolder, View view) {
            super(wishListViewHolder, view);
            this.b = wishListViewHolder;
            wishListViewHolder.giftCardLine = (TextView) Utils.findRequiredViewAsType(view, R.id.center_line, "field 'giftCardLine'", TextView.class);
            wishListViewHolder.userImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.user_img, "field 'userImg'", RoundedImageView.class);
            wishListViewHolder.wishListName = (TextView) Utils.findRequiredViewAsType(view, R.id.wish_list_name, "field 'wishListName'", TextView.class);
            wishListViewHolder.wishListDescription = (TextView) Utils.findRequiredViewAsType(view, R.id.wish_list_description, "field 'wishListDescription'", TextView.class);
            wishListViewHolder.rootView = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.wish_list_layout, "field 'rootView'", RelativeLayout.class);
            wishListViewHolder.glassView = (ImageView) Utils.findRequiredViewAsType(view, R.id.message_glass, "field 'glassView'", ImageView.class);
            wishListViewHolder.llRootAnima = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_root_anima, "field 'llRootAnima'", LinearLayout.class);
        }

        @Override // com.wear.adapter.longdistance.MessageNewAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            WishListViewHolder wishListViewHolder = this.b;
            if (wishListViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            wishListViewHolder.giftCardLine = null;
            wishListViewHolder.userImg = null;
            wishListViewHolder.wishListName = null;
            wishListViewHolder.wishListDescription = null;
            wishListViewHolder.rootView = null;
            wishListViewHolder.glassView = null;
            wishListViewHolder.llRootAnima = null;
            super.unbind();
        }
    }

    public class a implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ EntityPattern b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ PatternViewHolder d;

        public a(CommunMessage communMessage, EntityPattern entityPattern, boolean z, PatternViewHolder patternViewHolder) {
            this.a = communMessage;
            this.b = entityPattern;
            this.c = z;
            this.d = patternViewHolder;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(CommunMessage communMessage, EntityPattern entityPattern, boolean z, PatternViewHolder patternViewHolder) {
            if (qf3.a) {
                qf3.u(0);
                qf3.C();
            }
            MusicControl.h0().S();
            y12.c.a().t();
            MessageNewAdapter messageNewAdapter = MessageNewAdapter.this;
            Activity activity = messageNewAdapter.f;
            if (activity instanceof ChatRoomActivity) {
                messageNewAdapter.y1(communMessage, entityPattern, z);
            } else if (activity instanceof ChatActivity) {
                messageNewAdapter.x1(communMessage, entityPattern, patternViewHolder);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageNewAdapter.this.g.K();
            if (na2.m().t()) {
                return;
            }
            final CommunMessage communMessage = this.a;
            final EntityPattern entityPattern = this.b;
            final boolean z = this.c;
            final PatternViewHolder patternViewHolder = this.d;
            db2.A().q(new db2.s() { // from class: dc.tk1
                @Override // dc.db2.s
                public final void a() {
                    this.a.b(communMessage, entityPattern, z, patternViewHolder);
                }
            });
        }
    }

    public class a0 implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ EntityShortVideo b;

        public a0(CommunMessage communMessage, EntityShortVideo entityShortVideo) {
            this.a = communMessage;
            this.b = entityShortVideo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (m0.a[this.a.getType().ordinal()] != 11) {
                return;
            }
            MessageNewAdapter.this.g.H3(this.a, this.b);
        }
    }

    public class b extends ff3 {
        public final /* synthetic */ EntityPattern a;
        public final /* synthetic */ CommunMessage b;

        public b(EntityPattern entityPattern, CommunMessage communMessage) {
            this.a = entityPattern;
            this.b = communMessage;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void f(boolean z, Object obj, EntityPattern entityPattern, CommunMessage communMessage) {
            if (!z) {
                sg3.i(MessageNewAdapter.this.f, R.string.file_notfound);
                return;
            }
            File file = (File) obj;
            if (MessageNewAdapter.this.L(file)) {
                Pattern patternM = MessageNewAdapter.this.M(file, entityPattern);
                MessageNewAdapter.this.B1(patternM);
                MessageNewAdapter messageNewAdapter = MessageNewAdapter.this;
                messageNewAdapter.U(patternM, communMessage, entityPattern, messageNewAdapter.g.C().getId(), "group_chat");
            }
        }

        @Override // dc.ff3
        public void b(final boolean z, final Object obj) {
            Handler handler = MessageNewAdapter.this.k;
            final EntityPattern entityPattern = this.a;
            final CommunMessage communMessage = this.b;
            handler.post(new Runnable() { // from class: dc.uk1
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.f(z, obj, entityPattern, communMessage);
                }
            });
        }
    }

    public class b0 extends SimpleImageLoadingListener {
        public final /* synthetic */ ChatViewHolder a;

        public b0(MessageNewAdapter messageNewAdapter, ChatViewHolder chatViewHolder) {
            this.a = chatViewHolder;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            this.a.miv_reply_user_video_picture.setImageBitmap(bitmap);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    public class c extends ff3 {
        public c() {
        }

        @Override // dc.ff3
        public void d(boolean z, Object obj, String str, String str2, long j) {
            MessageNewAdapter.this.X1(z, obj, str2);
        }
    }

    public class c0 extends SimpleImageLoadingListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ ChatViewHolder b;

        public class a extends SimpleImageLoadingListener {
            public a() {
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                c0.this.b.miv_reply_user_video_picture.setImageBitmap(bitmap);
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingStarted(String str, View view) {
            }
        }

        public c0(MessageNewAdapter messageNewAdapter, String str, ChatViewHolder chatViewHolder) {
            this.a = str;
            this.b = chatViewHolder;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            this.b.miv_reply_user_video_picture.setImageBitmap(bitmap);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ImageLoader.getInstance().displayImage(WearUtils.e.replace("-api", "") + this.a, this.b.miv_reply_user_video_picture, MyApplication.Y, new a());
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ EntityPattern a;
        public final /* synthetic */ PatternFriendViewHolder b;
        public final /* synthetic */ CommunMessage c;

        public class a implements kn3.d {

            /* renamed from: com.wear.adapter.longdistance.MessageNewAdapter$d$a$a, reason: collision with other inner class name */
            public class C0074a extends ff3 {
                public C0074a() {
                }

                @Override // dc.ff3
                public void d(boolean z, Object obj, String str, String str2, long j) {
                    MessageNewAdapter.this.X1(z, obj, str2);
                }
            }

            public a() {
            }

            @Override // dc.kn3.d
            public void doCancel() {
                db2.A().w(false);
                cu3.h(d.this.c.getFrom(), d.this.a.getMsgId());
                String url = d.this.a.getUrl();
                d dVar = d.this;
                qf3.y(url, false, 0, dVar.b.a, dVar.a.getMsgId(), d.this.b, new C0074a());
            }

            @Override // dc.kn3.d
            public void doConfirm() {
            }
        }

        public class b extends ff3 {
            public b() {
            }

            @Override // dc.ff3
            public void d(boolean z, Object obj, String str, String str2, long j) {
                MessageNewAdapter.this.X1(z, obj, str2);
            }
        }

        public d(EntityPattern entityPattern, PatternFriendViewHolder patternFriendViewHolder, CommunMessage communMessage) {
            this.a = entityPattern;
            this.b = patternFriendViewHolder;
            this.c = communMessage;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageNewAdapter.this.g.K();
            if (na2.m().t()) {
                return;
            }
            if (qf3.n(this.a.getUrl(), this.b.a)) {
                qf3.u(0);
                qf3.C();
                return;
            }
            h12.D.playPatternPause = true;
            if (MusicControl.h0().O()) {
                EventBus.getDefault().post(h12.D);
            }
            k22 k22Var = (k22) y12.c.a().i(y12.c.TYPE_VOICE_BOOK);
            if (k22Var != null) {
                k22Var.B();
            }
            if (na2.m().i()) {
                na2.m().t();
                return;
            }
            if (db2.A().D()) {
                kn3 kn3Var = new kn3((Context) MessageNewAdapter.this.f, ah4.e(R.string.play_pattern_exist_controllink_notice), ah4.e(R.string.common_cancel), ah4.e(R.string.common_play), false, (kn3.d) new a());
                kn3Var.show();
                kn3Var.k();
                kn3Var.q();
                return;
            }
            cu3.h(this.c.getFrom(), this.a.getMsgId());
            this.b.patternTimePlay.setText("00:00");
            this.b.patternTime.setVisibility(0);
            this.b.patternTimePlay.setVisibility(0);
            this.b.patternTimePlayX.setVisibility(0);
            qf3.y(this.a.getUrl(), false, 0, this.b.a, this.a.getMsgId(), this.b, new b());
        }
    }

    public class d0 implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ DataEntityAbstract b;

        public d0(CommunMessage communMessage, DataEntityAbstract dataEntityAbstract) {
            this.a = communMessage;
            this.b = dataEntityAbstract;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.a.getType() == MessageType.burnvideo && ((EntityBurnShortVideo) this.b).isBurn()) {
                return;
            }
            MessageNewAdapter.this.g.H3(this.a, (EntityShortVideo) this.b);
        }
    }

    public class e implements View.OnClickListener {
        public final /* synthetic */ EntityPattern a;
        public final /* synthetic */ CommunMessage b;
        public final /* synthetic */ PatternFriendViewHolder c;

        public class a implements nf3.d {

            /* renamed from: com.wear.adapter.longdistance.MessageNewAdapter$e$a$a, reason: collision with other inner class name */
            public class RunnableC0075a implements Runnable {
                public RunnableC0075a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    e.this.c.patternSave.setEnabled(false);
                    e.this.c.patternSave.setText(ah4.e(R.string.common_saved));
                }
            }

            public a() {
            }

            @Override // dc.nf3.d
            public void onRequestComplete(String str) throws IOException {
                if (WearUtils.e1(str) || str.contains("result")) {
                    sg3.i(MessageNewAdapter.this.f, R.string.file_notfound);
                    return;
                }
                String strReplace = str.replace("\r", "");
                String status = e.this.b.getStatus();
                if (WearUtils.e1(status)) {
                    status = WearUtils.E();
                }
                if (rf3.o(strReplace)) {
                    strReplace = rf3.r(strReplace);
                }
                WearUtils.m2(strReplace, status);
                Pattern pattern = new Pattern(status);
                pattern.setName(e.this.a.getName());
                pattern.setToyVersion(e.this.a.getToyVersion());
                pattern.setData(strReplace);
                pattern.setCreator(WearUtils.y.r());
                pattern.setEmail(WearUtils.y.r());
                pattern.setAuthor(WearUtils.y.u().getUserName());
                pattern.setTimer(WearUtils.Q(e.this.a.getTime()));
                pattern.setToyFunc(e.this.a.getFeature());
                if (pattern.getHead() != null && !WearUtils.e1(pattern.getHead().getToys()) && pattern.getHead().getToys().equalsIgnoreCase(Toy.TOY_XMACHINE)) {
                    pattern.setToyFeature(Toy.TOY_FEATURE_XMACHINE);
                }
                xe2.L0().t(pattern, true);
                e.this.b.setStatus(pattern.getId());
                CommunMessage communMessageFindById = DaoUtils.getCommunMessageDao().findById(e.this.b.getId());
                if (communMessageFindById != null) {
                    communMessageFindById.setStatus(pattern.getId());
                    DaoUtils.getCommunMessageDao().updateOrAdd(communMessageFindById);
                    if (!WearUtils.e1(DaoUtils.getCommunMessageDao().findById(e.this.b.getId()).getStatus())) {
                        MessageNewAdapter.this.f.runOnUiThread(new RunnableC0075a());
                    } else {
                        e.this.b.setStatus(null);
                        sg3.i(MessageNewAdapter.this.f, R.string.chat_save_pattern_failed);
                    }
                }
            }
        }

        public e(EntityPattern entityPattern, CommunMessage communMessage, PatternFriendViewHolder patternFriendViewHolder) {
            this.a = entityPattern;
            this.b = communMessage;
            this.c = patternFriendViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WearUtils.e1(this.a.getUrl())) {
                MessageNewAdapter.this.g.P();
            } else if (MessageNewAdapter.this.f instanceof ChatRoomActivity) {
                EventBus.getDefault().post(new PatternOrAlarmSaveEvent(this.b, 1, MessageNewAdapter.this.g.C().getId()));
            } else {
                nf3.b(this.a.getUrl(), new a());
            }
        }
    }

    public class e0 extends vo {
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ CommunMessage k;
        public final /* synthetic */ ShortVideoFriendViewHolder l;
        public final /* synthetic */ boolean m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e0(ImageView imageView, String str, String str2, CommunMessage communMessage, ShortVideoFriendViewHolder shortVideoFriendViewHolder, boolean z) {
            super(imageView);
            this.i = str;
            this.j = str2;
            this.k = communMessage;
            this.l = shortVideoFriendViewHolder;
            this.m = z;
        }

        @Override // dc.vo, dc.yo
        /* renamed from: q */
        public void o(@Nullable Bitmap bitmap) {
            super.o(bitmap);
            MessageNewAdapter messageNewAdapter = MessageNewAdapter.this;
            String str = this.i;
            T t = this.b;
            String str2 = this.j;
            messageNewAdapter.t1(str, t, bitmap, str2, this.k, str2, false, this.l, this.m);
        }
    }

    public class f implements kn3.d {
        public final /* synthetic */ EntityPattern a;

        public f(EntityPattern entityPattern) {
            this.a = entityPattern;
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            EntityPattern entityPattern = new EntityPattern();
            entityPattern.setName(this.a.getName());
            entityPattern.setToyVersion(this.a.getToyVersion());
            entityPattern.setFeature(this.a.getFeature());
            entityPattern.setUrl(this.a.getUrl());
            entityPattern.setTime(this.a.getTime());
            entityPattern.setLocalUrl(this.a.getLocalUrl());
            if (WearUtils.e1(this.a.getLocalUrl())) {
                return;
            }
            MessageNewAdapter.this.g.M(entityPattern);
            sg3.i(MyApplication.K, R.string.chat_pattern_resend);
        }
    }

    public class f0 extends vo {
        public final /* synthetic */ File i;
        public final /* synthetic */ ShortVideoViewHolder j;
        public final /* synthetic */ String k;
        public final /* synthetic */ CommunMessage l;
        public final /* synthetic */ String m;
        public final /* synthetic */ boolean n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f0(ImageView imageView, File file, ShortVideoViewHolder shortVideoViewHolder, String str, CommunMessage communMessage, String str2, boolean z) {
            super(imageView);
            this.i = file;
            this.j = shortVideoViewHolder;
            this.k = str;
            this.l = communMessage;
            this.m = str2;
            this.n = z;
        }

        @Override // dc.vo, dc.yo
        /* renamed from: q */
        public void o(Bitmap bitmap) {
            super.o(bitmap);
            MessageNewAdapter messageNewAdapter = MessageNewAdapter.this;
            String string = Uri.fromFile(this.i).toString();
            ShortVideoViewHolder shortVideoViewHolder = this.j;
            messageNewAdapter.t1(string, shortVideoViewHolder.userPicture, bitmap, this.k, this.l, this.m, false, shortVideoViewHolder, this.n);
        }
    }

    public class g implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ EntityPattern b;

        public class a implements kn3.d {
            public a() {
            }

            @Override // dc.kn3.d
            public void doCancel() {
            }

            @Override // dc.kn3.d
            public void doConfirm() {
                EntityPattern entityPattern = new EntityPattern();
                entityPattern.setName(g.this.b.getName());
                entityPattern.setToyVersion(g.this.b.getToyVersion());
                entityPattern.setFeature(g.this.b.getFeature());
                entityPattern.setUrl(g.this.b.getUrl());
                entityPattern.setTime(g.this.b.getTime());
                entityPattern.setLocalUrl(g.this.b.getLocalUrl());
                if (WearUtils.e1(g.this.b.getLocalUrl())) {
                    return;
                }
                MessageNewAdapter.this.g.M(entityPattern);
                sg3.i(MessageNewAdapter.this.f, R.string.chat_pattern_resend);
            }
        }

        public g(CommunMessage communMessage, EntityPattern entityPattern) {
            this.a = communMessage;
            this.b = entityPattern;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IPeopleInfo iPeopleInfoC = MessageNewAdapter.this.g.C();
            if ((iPeopleInfoC instanceof Group) && ((Group) iPeopleInfoC).isExit()) {
                sg3.l(ah4.e(R.string.group_chat_exited1));
                return;
            }
            if (this.a.getSendStatus() == 2) {
                MessageNewAdapter.this.g.P();
            } else {
                if (WearUtils.e1(this.b.getUrl())) {
                    MessageNewAdapter.this.g.P();
                    return;
                }
                kn3 kn3Var = new kn3((Context) MessageNewAdapter.this.f, ah4.e(R.string.chat_pattern_resend_notices), ah4.e(R.string.common_yes), ah4.e(R.string.common_no), true, (kn3.d) new a());
                kn3Var.show();
                kn3Var.p();
            }
        }
    }

    public class g0 implements View.OnTouchListener {
        public g0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 5) {
                return false;
            }
            MessageNewAdapter.this.q.y();
            return false;
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ Object a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    MessageNewAdapter.this.notifyDataSetChanged();
                } catch (Exception e) {
                    FirebaseCrashlytics.getInstance().recordException(e);
                }
            }
        }

        public h(Object obj, boolean z, String str) {
            this.a = obj;
            this.b = z;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a instanceof PatternFriendViewHolder) {
                String str = qf3.b;
                String strO = qf3.o();
                if (str == null) {
                    return;
                }
                mz1 mz1VarF = nz1.e().f();
                PatternFriendViewHolder patternFriendViewHolder = (PatternFriendViewHolder) this.a;
                if ((str + "#" + strO).equals(patternFriendViewHolder.patternPlay.getTag())) {
                    if (this.b) {
                        MessageNewAdapter.this.I1(patternFriendViewHolder.patternPlay, mz1VarF.q());
                    } else {
                        MessageNewAdapter.this.I1(patternFriendViewHolder.patternPlay, mz1VarF.A());
                        try {
                            MessageNewAdapter.this.k.post(new a());
                        } catch (Exception e) {
                            FirebaseCrashlytics.getInstance().recordException(e);
                        }
                    }
                    patternFriendViewHolder.patternTimePlay.setText(this.c);
                }
            }
        }
    }

    public class h0 extends vo {
        public final /* synthetic */ String i;
        public final /* synthetic */ ShortVideoViewHolder j;
        public final /* synthetic */ String k;
        public final /* synthetic */ CommunMessage l;
        public final /* synthetic */ String m;
        public final /* synthetic */ boolean n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h0(ImageView imageView, String str, ShortVideoViewHolder shortVideoViewHolder, String str2, CommunMessage communMessage, String str3, boolean z) {
            super(imageView);
            this.i = str;
            this.j = shortVideoViewHolder;
            this.k = str2;
            this.l = communMessage;
            this.m = str3;
            this.n = z;
        }

        @Override // dc.yo, dc.dp, dc.uo, dc.cp
        public void a(@Nullable Drawable drawable) {
            super.a(drawable);
        }

        @Override // dc.yo, dc.uo, dc.cp
        public void h(@Nullable Drawable drawable) {
            super.h(drawable);
        }

        @Override // dc.vo, dc.yo
        /* renamed from: q */
        public void o(Bitmap bitmap) {
            super.o(bitmap);
            MessageNewAdapter messageNewAdapter = MessageNewAdapter.this;
            String str = this.i;
            ShortVideoViewHolder shortVideoViewHolder = this.j;
            messageNewAdapter.t1(str, shortVideoViewHolder.userPicture, bitmap, this.k, this.l, this.m, false, shortVideoViewHolder, this.n);
        }
    }

    public class i implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ EntityAlarm b;

        public i(CommunMessage communMessage, EntityAlarm entityAlarm) {
            this.a = communMessage;
            this.b = entityAlarm;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws ParseException {
            if (MessageNewAdapter.this.f instanceof ChatRoomActivity) {
                this.a.setStatus(AlarmListItems.ALARM_STATUS_REJECT);
                DaoUtils.getCommunMessageDao().update((CommunMessageDao) this.a);
                MessageNewAdapter.this.notifyDataSetChanged();
                AlarmListItems alarmListItemsFindAlarmByreceiveAlarmId = DaoUtils.getAlarmListDao().findAlarmByreceiveAlarmId(this.b.getId());
                if (alarmListItemsFindAlarmByreceiveAlarmId != null) {
                    alarmListItemsFindAlarmByreceiveAlarmId.setAccept(2);
                    DaoUtils.getAlarmListDao().updateOrAdd(alarmListItemsFindAlarmByreceiveAlarmId);
                    zt3.t(MessageNewAdapter.this.f, alarmListItemsFindAlarmByreceiveAlarmId.getId(), true, true, false);
                    return;
                }
                return;
            }
            this.a.setStatus(AlarmListItems.ALARM_STATUS_REJECT);
            DaoUtils.getCommunMessageDao().update((CommunMessageDao) this.a);
            MessageNewAdapter.this.notifyDataSetChanged();
            String strG0 = WearUtils.g0(this.a.getFrom());
            if (strG0.contains("@")) {
                strG0 = strG0.substring(0, strG0.indexOf("@"));
            }
            try {
                VCard vCardLoadVCard = VCardManager.getInstanceFor(hu3.o).loadVCard(this.a.getFrom());
                if (vCardLoadVCard != null && !WearUtils.e1(vCardLoadVCard.getNickName())) {
                    strG0 = vCardLoadVCard.getNickName();
                }
            } catch (Exception unused) {
            }
            String str = zt3.j + zt3.g + zt3.i + this.b.getId() + zt3.i + (strG0 + zt3.i + this.b.getPattern().getTime());
            EntitySystem entitySystem = new EntitySystem();
            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C202.toString(), str);
            hu3.g0(entitySystem, this.a.getFrom(), MessageType.system, str, null, null);
            AlarmListItems alarmListItemsFindAlarmByreceiveAlarmId2 = DaoUtils.getAlarmListDao().findAlarmByreceiveAlarmId(this.b.getId());
            if (alarmListItemsFindAlarmByreceiveAlarmId2 != null) {
                alarmListItemsFindAlarmByreceiveAlarmId2.setAccept(2);
                DaoUtils.getAlarmListDao().updateOrAdd(alarmListItemsFindAlarmByreceiveAlarmId2);
                zt3.t(MessageNewAdapter.this.f, alarmListItemsFindAlarmByreceiveAlarmId2.getId(), true, true, false);
            }
        }
    }

    public class i0 implements Runnable {
        public i0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MessageNewAdapter.this.w = true;
        }
    }

    public class j implements View.OnClickListener {
        public final /* synthetic */ EntityAlarm a;
        public final /* synthetic */ CommunMessage b;

        public j(EntityAlarm entityAlarm, CommunMessage communMessage) {
            this.a = entityAlarm;
            this.b = communMessage;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(EntityAlarm entityAlarm, CommunMessage communMessage, List list, boolean z) throws ParseException {
            if (z) {
                MessageNewAdapter.this.O(entityAlarm, communMessage);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws ParseException {
            if (zt3.f()) {
                MessageNewAdapter.this.O(this.a, this.b);
                return;
            }
            Activity activity = MessageNewAdapter.this.f;
            final EntityAlarm entityAlarm = this.a;
            final CommunMessage communMessage = this.b;
            zt3.v(activity, new u51() { // from class: dc.vk1
                @Override // dc.u51
                public /* synthetic */ void a(List list, boolean z) {
                    t51.a(this, list, z);
                }

                @Override // dc.u51
                public final void b(List list, boolean z) throws ParseException {
                    this.a.b(entityAlarm, communMessage, list, z);
                }
            });
        }
    }

    public class j0 implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;

        public j0(CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ue3.a(MessageNewAdapter.this.t, MessageNewAdapter.this.f);
            IPeopleInfo iPeopleInfoC = MessageNewAdapter.this.g.C();
            if (iPeopleInfoC instanceof Group) {
                Group group = (Group) iPeopleInfoC;
                String realFrom = this.a.getRealFrom();
                User userV = ch3.n().v(WearUtils.X(realFrom));
                GroupMember memberByJid = group.getMemberByJid(ch3.n().p());
                if (memberByJid == null) {
                    memberByJid = new GroupMember();
                    memberByJid.setJid(ch3.n().p());
                    memberByJid.setAffiliation(30);
                    memberByJid.setNickName(ch3.n().u().getUserName());
                    memberByJid.setPhoto(ch3.n().u().getAvatar());
                }
                GroupMember memberByJid2 = group.getMemberByJid(realFrom);
                if (memberByJid2 == null) {
                    memberByJid2 = new GroupMember();
                    memberByJid2.setJid(realFrom);
                    memberByJid2.setAffiliation(30);
                    memberByJid2.setNickName(this.a.getRealFromNickName());
                    memberByJid2.setPhoto(this.a.getRealFromPhoto());
                }
                MessageNewAdapter.this.U1(new ManagerGroupMemberInfoDialog.h(group, memberByJid2, memberByJid, userV), group);
            }
        }
    }

    public class k implements View.OnLongClickListener {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ int b;

        public k(CommunMessage communMessage, int i) {
            this.a = communMessage;
            this.b = i;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            MessageNewAdapter.this.q.g0(view, this.a, this.b);
            return false;
        }
    }

    public class k0 implements ManagerGroupMemberInfoDialog.j {
        public final /* synthetic */ ManagerGroupMemberInfoDialog a;

        public k0(ManagerGroupMemberInfoDialog managerGroupMemberInfoDialog) {
            this.a = managerGroupMemberInfoDialog;
        }

        @Override // com.wear.widget.dialog.ManagerGroupMemberInfoDialog.j
        public void a(IGroupMember iGroupMember) {
            String strI0 = WearUtils.i0(iGroupMember.getId());
            Activity activity = MessageNewAdapter.this.f;
            if (activity instanceof ChatRoomActivity) {
                ((ChatRoomActivity) activity).k8(strI0, iGroupMember.getAvatar());
            }
            this.a.dismiss();
        }
    }

    public class l implements View.OnClickListener {
        public final /* synthetic */ EntityAlarm a;
        public final /* synthetic */ String b;
        public final /* synthetic */ CommunMessage c;
        public final /* synthetic */ String d;

        public l(EntityAlarm entityAlarm, String str, CommunMessage communMessage, String str2) {
            this.a = entityAlarm;
            this.b = str;
            this.c = communMessage;
            this.d = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity = MessageNewAdapter.this.f;
            if (!(activity instanceof ChatActivity)) {
                Intent intent = new Intent(MessageNewAdapter.this.f, (Class<?>) GroupAlarmInfoActivity.class);
                intent.putExtra("message", this.c);
                intent.putExtra("avatar", this.d);
                intent.putExtra("roomId", MessageNewAdapter.this.g.C().getId());
                MessageNewAdapter.this.f.startActivity(intent);
                return;
            }
            View viewInflate = LayoutInflater.from(activity).inflate(R.layout.alarm_info_dialog, (ViewGroup) null, false);
            TextView textView = (TextView) viewInflate.findViewById(R.id.alarm_time);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.alarm_type);
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.alarm_name);
            TextView textView4 = (TextView) viewInflate.findViewById(R.id.alarm_repeat);
            textView.setText(be3.c(this.a.getPattern().getTime(), WearUtils.x));
            String strE = "pattern";
            if (this.a.getNotiType().equals("pattern")) {
                strE = ah4.e(R.string.message_notification_type_pattern);
                String str = "onClick alarmItemAlarm: " + this.a.getPattern().toString();
            } else if (this.a.getNotiType().equals("sound")) {
                strE = ah4.e(R.string.closeRange_sound);
            }
            textView2.setText(strE);
            textView3.setText(this.a.getName());
            textView4.setText(this.b);
            kn3 kn3Var = new kn3((Context) MessageNewAdapter.this.f, (String) null, "", "", true, 320, 0, (kn3.d) null);
            kn3Var.show();
            kn3Var.h(viewInflate);
            kn3Var.e(8);
            kn3Var.i(R.color.transparent);
        }
    }

    public class l0 implements ManagerGroupMemberInfoDialog.i {
        public final /* synthetic */ Group a;

        public class a implements kv1 {
            public final /* synthetic */ IGroupMember a;

            public a(l0 l0Var, IGroupMember iGroupMember) {
                this.a = iGroupMember;
            }

            @Override // dc.kv1
            public void a(String str) {
                if (((BaseResponse) JSON.parseObject(str, BaseResponse.class)).suc()) {
                    this.a.setPermission(30);
                }
            }

            @Override // dc.kv1
            public void onError(Exception exc) {
            }
        }

        public class b implements kv1 {
            public final /* synthetic */ IGroupMember a;

            public b(l0 l0Var, IGroupMember iGroupMember) {
                this.a = iGroupMember;
            }

            @Override // dc.kv1
            public void a(String str) {
                if (((ResponseCreateChatRoom) JSON.parseObject(str, ResponseCreateChatRoom.class)).suc()) {
                    this.a.setPermission(20);
                }
            }

            @Override // dc.kv1
            public void onError(Exception exc) {
            }
        }

        public class c implements kv1 {
            public final /* synthetic */ IGroupMember a;

            public c(IGroupMember iGroupMember) {
                this.a = iGroupMember;
            }

            @Override // dc.kv1
            public void a(String str) {
                if (((BaseResponse) JSON.parseObject(str, BaseResponse.class)).suc()) {
                    l0.this.a.removeMemberByJid(WearUtils.i0(this.a.getId()));
                }
            }

            @Override // dc.kv1
            public void onError(Exception exc) {
            }
        }

        public l0(MessageNewAdapter messageNewAdapter, Group group) {
            this.a = group;
        }

        @Override // com.wear.widget.dialog.ManagerGroupMemberInfoDialog.i
        public void a(IGroupMember iGroupMember) {
            RequestMembersRemove requestMembersRemove = new RequestMembersRemove();
            requestMembersRemove.setRoomId(this.a.getId());
            requestMembersRemove.setType(1);
            requestMembersRemove.setJid(WearUtils.i0(iGroupMember.getId()));
            zb2.O().C0(requestMembersRemove, WearUtils.k0(this.a.getId()), new c(iGroupMember));
        }

        @Override // com.wear.widget.dialog.ManagerGroupMemberInfoDialog.i
        public void b(IGroupMember iGroupMember) {
            RequestMembersRemove requestMembersRemove = new RequestMembersRemove();
            requestMembersRemove.setRoomId(this.a.getId());
            requestMembersRemove.setType(2);
            requestMembersRemove.setJid(WearUtils.i0(iGroupMember.getId()));
            zb2.O().C0(requestMembersRemove, WearUtils.k0(this.a.getId()), new a(this, iGroupMember));
        }

        @Override // com.wear.widget.dialog.ManagerGroupMemberInfoDialog.i
        public void c(IGroupMember iGroupMember) {
            RequestMemberInvite requestMemberInvite = new RequestMemberInvite();
            ArrayList arrayList = new ArrayList();
            InviteBean inviteBean = new InviteBean();
            inviteBean.setJid(WearUtils.i0(iGroupMember.getId()));
            inviteBean.setNickName(iGroupMember.getNickName());
            arrayList.add(inviteBean);
            requestMemberInvite.setInvite(arrayList);
            requestMemberInvite.setRoomId(this.a.getId());
            requestMemberInvite.setSetAffiliation(20);
            zb2.O().C0(requestMemberInvite, WearUtils.k0(this.a.getId()), new b(this, iGroupMember));
        }
    }

    public class m implements View.OnClickListener {
        public final /* synthetic */ int a;

        public m(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!MyApplication.P) {
                sg3.k(MessageNewAdapter.this.f, ah4.e(R.string.common_settingTip));
                return;
            }
            MessageNewAdapter.this.g.K();
            MessageNewAdapter.this.g.X2();
            int i = this.a;
            if (i == 0) {
                MessageNewAdapter.this.g.v();
                return;
            }
            if (i == 1) {
                MessageNewAdapter.this.g.t();
            } else if (i == 2) {
                MessageNewAdapter.this.g.q();
            } else if (i == 3) {
                MessageNewAdapter.this.g.n();
            }
        }
    }

    public static /* synthetic */ class m0 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MessageType.values().length];
            a = iArr;
            try {
                iArr[MessageType.chat.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[MessageType.live.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[MessageType.sync.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[MessageType.alarm.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[MessageType.audio.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[MessageType.video.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[MessageType.voice.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[MessageType.system.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[MessageType.pattern.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[MessageType.picture.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[MessageType.shortvideo.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[MessageType.wishlist.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[MessageType.giftcard.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[MessageType.vmsharecard.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[MessageType.unsupport.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[MessageType.burnpicture.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[MessageType.burnvideo.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public class n extends ClickableSpan {
        public n() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            MessageNewAdapter messageNewAdapter = MessageNewAdapter.this;
            messageNewAdapter.I(messageNewAdapter.g.C().getId());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    public class n0 implements View.OnLayoutChangeListener {
        public final /* synthetic */ WishListViewHolder a;
        public final /* synthetic */ CommunMessage b;

        public n0(WishListViewHolder wishListViewHolder, CommunMessage communMessage) {
            this.a = wishListViewHolder;
            this.b = communMessage;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(CommunMessage communMessage, WishListViewHolder wishListViewHolder) {
            if (MessageNewAdapter.this.q.F(communMessage.getId())) {
                MessageNewAdapter.this.Y1(wishListViewHolder);
            } else {
                wishListViewHolder.glassView.setVisibility(8);
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.a.rootView.removeOnLayoutChangeListener(this);
            final WishListViewHolder wishListViewHolder = this.a;
            RelativeLayout relativeLayout = wishListViewHolder.rootView;
            final CommunMessage communMessage = this.b;
            relativeLayout.post(new Runnable() { // from class: dc.zk1
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b(communMessage, wishListViewHolder);
                }
            });
        }
    }

    public class o extends av1 {
        public o(String str, String str2) {
            super(str, str2);
        }

        @Override // dc.av1
        public void a(String str, String str2) {
            MessageNewAdapter.this.I(WearUtils.X(str2));
        }
    }

    public class o0 implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;

        public o0(MessageNewAdapter messageNewAdapter, CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventBus.getDefault().post(new MessageResendEvent(this.a));
        }
    }

    public class p implements Runnable {
        public final /* synthetic */ CommunMessage a;

        public p(MessageNewAdapter messageNewAdapter, CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // java.lang.Runnable
        public void run() {
            DaoUtils.getCommunMessageDao().update((CommunMessageDao) this.a);
        }
    }

    public class p0 implements View.OnClickListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ mz1 b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ AudioViewHolder d;
        public final /* synthetic */ int e;

        public class a extends ff3 {

            /* renamed from: com.wear.adapter.longdistance.MessageNewAdapter$p0$a$a, reason: collision with other inner class name */
            public class C0076a extends ff3 {
                public final /* synthetic */ boolean a;

                /* renamed from: com.wear.adapter.longdistance.MessageNewAdapter$p0$a$a$a, reason: collision with other inner class name */
                public class RunnableC0077a implements Runnable {
                    public RunnableC0077a() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        MessageNewAdapter.this.n.clear();
                        p0.this.d.voiceIcon.q();
                        p0.this.d.voiceIcon.clearAnimation();
                        p0 p0Var = p0.this;
                        if (p0Var.c) {
                            MessageNewAdapter.this.I1(p0Var.d.voiceIcon, p0Var.b.i0());
                        } else {
                            MessageNewAdapter.this.I1(p0Var.d.voiceIcon, p0Var.b.o());
                        }
                    }
                }

                public C0076a(boolean z) {
                    this.a = z;
                }

                @Override // dc.ff3
                public void b(boolean z, Object obj) throws IllegalStateException {
                    int iIntValue = obj != null ? ((Integer) obj).intValue() : -1;
                    System.out.println("temp." + iIntValue);
                    if (iIntValue == -1) {
                        MusicControl.h0();
                        h12.D.isPlayAudio = false;
                        MessageNewAdapter messageNewAdapter = MessageNewAdapter.this;
                        messageNewAdapter.h = -1;
                        if (this.a) {
                            messageNewAdapter.r.G();
                            MessageNewAdapter.this.r.x();
                            pc1.a.u0();
                        }
                        MessageNewAdapter.this.f.runOnUiThread(new RunnableC0077a());
                        return;
                    }
                    if (this.a) {
                        int i = (iIntValue * 80) / 100;
                        if (mp1.h()) {
                            rq1.d.e(i, new ToyControlBuilder(ToyControlBuilder.a.SPEED));
                            return;
                        }
                        pc1 pc1Var = pc1.a;
                        int i2 = i * 5;
                        pc1Var.W(i2);
                        pc1Var.Y(i2);
                    }
                }
            }

            public class b implements Runnable {
                public b() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    p0 p0Var = p0.this;
                    p0Var.d.voiceIcon.setAnimation(p0Var.b.U(p0Var.c));
                    StringBuilder sb = new StringBuilder();
                    sb.append("voice_play: ");
                    p0 p0Var2 = p0.this;
                    sb.append(p0Var2.b.U(p0Var2.c));
                    sb.toString();
                    p0.this.d.voiceIcon.p(true);
                    p0.this.d.voiceIcon.r();
                }
            }

            public a() {
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0033  */
            @Override // dc.ff3
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void b(boolean r6, java.lang.Object r7) throws java.lang.IllegalStateException {
                /*
                    r5 = this;
                    if (r6 == 0) goto Ld5
                    java.io.File r7 = (java.io.File) r7
                    dc.ch3 r6 = com.wear.util.WearUtils.y
                    com.wear.adapter.longdistance.MessageNewAdapter$p0 r0 = com.wear.adapter.longdistance.MessageNewAdapter.p0.this
                    com.wear.adapter.longdistance.MessageNewAdapter r0 = com.wear.adapter.longdistance.MessageNewAdapter.this
                    dc.sa2 r0 = r0.g
                    com.wear.bean.handlerbean.IPeopleInfo r0 = r0.C()
                    java.lang.String r0 = r0.getId()
                    com.wear.bean.UserSetting r6 = r6.z(r0)
                    r0 = 0
                    if (r6 == 0) goto L33
                    java.lang.Boolean r6 = r6.getAudioVibration()
                    boolean r6 = r6.booleanValue()
                    com.wear.adapter.longdistance.MessageNewAdapter$p0 r1 = com.wear.adapter.longdistance.MessageNewAdapter.p0.this
                    com.wear.adapter.longdistance.MessageNewAdapter r1 = com.wear.adapter.longdistance.MessageNewAdapter.this
                    dc.sa2 r1 = r1.g
                    com.wear.bean.handlerbean.IPeopleInfo r1 = r1.C()
                    boolean r1 = r1.isDateIng()
                    if (r1 == 0) goto L34
                L33:
                    r6 = 0
                L34:
                    r1 = 1
                    if (r6 != r1) goto L5f
                    dc.na2 r2 = dc.na2.m()
                    boolean r2 = r2.i()
                    if (r2 == 0) goto L42
                    r6 = 0
                L42:
                    if (r6 != r1) goto L5f
                    com.wear.adapter.longdistance.MessageNewAdapter$p0 r2 = com.wear.adapter.longdistance.MessageNewAdapter.p0.this
                    com.wear.adapter.longdistance.MessageNewAdapter r2 = com.wear.adapter.longdistance.MessageNewAdapter.this
                    dc.so3 r2 = com.wear.adapter.longdistance.MessageNewAdapter.C(r2)
                    r2.G()
                    com.wear.adapter.longdistance.MessageNewAdapter$p0 r2 = com.wear.adapter.longdistance.MessageNewAdapter.p0.this
                    com.wear.adapter.longdistance.MessageNewAdapter r2 = com.wear.adapter.longdistance.MessageNewAdapter.this
                    dc.so3 r2 = com.wear.adapter.longdistance.MessageNewAdapter.C(r2)
                    r2.x()
                    dc.pc1 r2 = dc.pc1.a
                    r2.u0()
                L5f:
                    com.wear.adapter.longdistance.MessageNewAdapter$p0 r2 = com.wear.adapter.longdistance.MessageNewAdapter.p0.this
                    com.wear.adapter.longdistance.MessageNewAdapter r2 = com.wear.adapter.longdistance.MessageNewAdapter.this
                    dc.so3 r2 = com.wear.adapter.longdistance.MessageNewAdapter.C(r2)
                    r2.F()
                    com.wear.adapter.longdistance.MessageNewAdapter$p0 r2 = com.wear.adapter.longdistance.MessageNewAdapter.p0.this
                    com.wear.adapter.longdistance.MessageNewAdapter r3 = com.wear.adapter.longdistance.MessageNewAdapter.this
                    int r4 = r3.h
                    int r2 = r2.e
                    if (r4 != r2) goto L7f
                    r6 = -1
                    r3.h = r6
                    com.wear.main.closeRange.music.MusicControl.h0()
                    com.wear.bean.event.MusicPlayEvent r6 = dc.h12.D
                    r6.isPlayAudio = r0
                    return
                L7f:
                    com.wear.main.closeRange.music.MusicControl r0 = com.wear.main.closeRange.music.MusicControl.h0()
                    boolean r0 = r0.O()
                    if (r0 == 0) goto L9c
                    com.wear.main.closeRange.music.MusicControl.h0()
                    com.wear.bean.event.MusicPlayEvent r0 = dc.h12.D
                    r0.isPlayAudio = r1
                    org.greenrobot.eventbus.EventBus r0 = org.greenrobot.eventbus.EventBus.getDefault()
                    com.wear.main.closeRange.music.MusicControl.h0()
                    com.wear.bean.event.MusicPlayEvent r1 = dc.h12.D
                    r0.post(r1)
                L9c:
                    dc.y12$b r0 = dc.y12.c
                    dc.y12 r0 = r0.a()
                    dc.y12$c r1 = dc.y12.c.TYPE_VOICE_BOOK
                    dc.x12 r0 = r0.i(r1)
                    dc.k22 r0 = (dc.k22) r0
                    if (r0 == 0) goto Laf
                    r0.B()
                Laf:
                    com.wear.adapter.longdistance.MessageNewAdapter$p0 r0 = com.wear.adapter.longdistance.MessageNewAdapter.p0.this
                    com.wear.adapter.longdistance.MessageNewAdapter r1 = com.wear.adapter.longdistance.MessageNewAdapter.this
                    int r0 = r0.e
                    r1.h = r0
                    dc.so3 r0 = com.wear.adapter.longdistance.MessageNewAdapter.C(r1)
                    java.lang.String r7 = r7.getAbsolutePath()
                    com.wear.adapter.longdistance.MessageNewAdapter$p0$a$a r1 = new com.wear.adapter.longdistance.MessageNewAdapter$p0$a$a
                    r1.<init>(r6)
                    r0.E(r7, r1, r6)
                    com.wear.adapter.longdistance.MessageNewAdapter$p0 r6 = com.wear.adapter.longdistance.MessageNewAdapter.p0.this
                    com.wear.adapter.longdistance.MessageNewAdapter r6 = com.wear.adapter.longdistance.MessageNewAdapter.this
                    android.app.Activity r6 = r6.f
                    com.wear.adapter.longdistance.MessageNewAdapter$p0$a$b r7 = new com.wear.adapter.longdistance.MessageNewAdapter$p0$a$b
                    r7.<init>()
                    r6.runOnUiThread(r7)
                Ld5:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.wear.adapter.longdistance.MessageNewAdapter.p0.a.b(boolean, java.lang.Object):void");
            }
        }

        public p0(boolean z, mz1 mz1Var, boolean z2, AudioViewHolder audioViewHolder, int i) {
            this.a = z;
            this.b = mz1Var;
            this.c = z2;
            this.d = audioViewHolder;
            this.e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageNewAdapter.this.g.K();
            if (this.a) {
                return;
            }
            if (MessageNewAdapter.this.g.E()) {
                MessageNewAdapter.this.h = -1;
                return;
            }
            if (MessageNewAdapter.this.n.get(0) != null) {
                MessageNewAdapter messageNewAdapter = MessageNewAdapter.this;
                messageNewAdapter.I1((ImageView) messageNewAdapter.n.get(0), this.b.i0());
            }
            if (MessageNewAdapter.this.n.get(1) != null) {
                MessageNewAdapter messageNewAdapter2 = MessageNewAdapter.this;
                messageNewAdapter2.I1((ImageView) messageNewAdapter2.n.get(1), this.b.o());
            }
            MessageNewAdapter.this.n.clear();
            MessageNewAdapter.this.n.put(Integer.valueOf(!this.c ? 1 : 0), this.d.voiceIcon);
            WearUtils.E0(true, (String) view.getTag(), new a());
        }
    }

    public class q implements View.OnLongClickListener {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ int b;

        public q(CommunMessage communMessage, int i) {
            this.a = communMessage;
            this.b = i;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            MessageNewAdapter.this.q.e0(view, this.a, this.b);
            return false;
        }
    }

    public class q0 implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ DataEntityAbstract b;

        public q0(CommunMessage communMessage, DataEntityAbstract dataEntityAbstract) {
            this.a = communMessage;
            this.b = dataEntityAbstract;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.a.getType() == MessageType.burnpicture && ((EntityBurnPicture) this.b).isBurn()) {
                return;
            }
            MessageNewAdapter.this.g.s3(this.a);
        }
    }

    public class r implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;

        public r(CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            pj3.j(MessageNewAdapter.this.f, ChatMsgDetailActivity.class, "chat", new EntityChat(this.a.getData()).getText());
        }
    }

    public class r0 extends xo {
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ CommunMessage k;
        public final /* synthetic */ ViewGroup.LayoutParams l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r0(ImageView imageView, String str, String str2, CommunMessage communMessage, ViewGroup.LayoutParams layoutParams) {
            super(imageView);
            this.i = str;
            this.j = str2;
            this.k = communMessage;
            this.l = layoutParams;
        }

        @Override // dc.xo, dc.yo
        /* renamed from: q */
        public void o(@Nullable Drawable drawable) {
            super.o(drawable);
            MessageNewAdapter messageNewAdapter = MessageNewAdapter.this;
            String str = this.i;
            T t = this.b;
            String str2 = this.j;
            messageNewAdapter.s1(str, t, drawable, str2, this.k, str2, this.l);
        }
    }

    public class s extends ff3 {
        public final /* synthetic */ int a;
        public final /* synthetic */ ChatViewHolder b;
        public final /* synthetic */ boolean c;

        public s(int i, ChatViewHolder chatViewHolder, boolean z) {
            this.a = i;
            this.b = chatViewHolder;
            this.c = z;
        }

        public static /* synthetic */ void e(ChatViewHolder chatViewHolder, boolean z) {
            chatViewHolder.reply_voice_icon.setAnimation(nz1.e().f().H(z));
            chatViewHolder.reply_voice_icon.p(true);
            chatViewHolder.reply_voice_icon.r();
        }

        @Override // dc.ff3
        public void b(boolean z, Object obj) throws IllegalStateException {
            if (z) {
                File file = (File) obj;
                MessageNewAdapter.this.J();
                MessageNewAdapter messageNewAdapter = MessageNewAdapter.this;
                if (messageNewAdapter.h == this.a) {
                    messageNewAdapter.h = -1;
                    h12.D.isPlayAudio = false;
                    return;
                }
                if (MusicControl.h0().O()) {
                    h12.D.isPlayAudio = true;
                    EventBus.getDefault().post(h12.D);
                }
                k22 k22Var = (k22) y12.c.a().i(y12.c.TYPE_VOICE_BOOK);
                if (k22Var != null) {
                    k22Var.B();
                }
                MessageNewAdapter messageNewAdapter2 = MessageNewAdapter.this;
                messageNewAdapter2.h = this.a;
                Handler handler = messageNewAdapter2.k;
                final ChatViewHolder chatViewHolder = this.b;
                final boolean z2 = this.c;
                handler.post(new Runnable() { // from class: dc.xk1
                    @Override // java.lang.Runnable
                    public final void run() {
                        MessageNewAdapter.s.e(chatViewHolder, z2);
                    }
                });
                MessageNewAdapter.this.C1(file.getAbsolutePath(), this.b, this.c);
            }
        }

        @Override // dc.ff3
        public void c(boolean z, Object obj, String str) {
            super.c(z, obj, str);
        }
    }

    public class s0 extends xo {
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ CommunMessage k;
        public final /* synthetic */ ViewGroup.LayoutParams l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s0(ImageView imageView, String str, String str2, CommunMessage communMessage, ViewGroup.LayoutParams layoutParams) {
            super(imageView);
            this.i = str;
            this.j = str2;
            this.k = communMessage;
            this.l = layoutParams;
        }

        @Override // dc.xo, dc.yo
        /* renamed from: q */
        public void o(@Nullable Drawable drawable) {
            super.o(drawable);
            MessageNewAdapter messageNewAdapter = MessageNewAdapter.this;
            String str = this.i;
            T t = this.b;
            String str2 = this.j;
            messageNewAdapter.s1(str, t, drawable, str2, this.k, str2, this.l);
        }
    }

    public class t extends ff3 {
        public final /* synthetic */ ChatViewHolder a;
        public final /* synthetic */ boolean b;

        public t(ChatViewHolder chatViewHolder, boolean z) {
            this.a = chatViewHolder;
            this.b = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void f(ChatViewHolder chatViewHolder, boolean z) {
            MessageNewAdapter.this.n.clear();
            chatViewHolder.reply_voice_icon.q();
            chatViewHolder.reply_voice_icon.clearAnimation();
            mz1 mz1VarF = nz1.e().f();
            MessageNewAdapter.this.I1(chatViewHolder.reply_voice_icon, z ? mz1VarF.V() : mz1VarF.S());
        }

        @Override // dc.ff3
        public void b(boolean z, Object obj) throws IllegalStateException {
            int iIntValue = obj != null ? ((Integer) obj).intValue() : -1;
            System.out.println("temp." + iIntValue);
            if (iIntValue == -1) {
                h12.D.isPlayAudio = false;
                MessageNewAdapter messageNewAdapter = MessageNewAdapter.this;
                messageNewAdapter.h = -1;
                messageNewAdapter.J();
                Handler handler = MessageNewAdapter.this.k;
                final ChatViewHolder chatViewHolder = this.a;
                final boolean z2 = this.b;
                handler.post(new Runnable() { // from class: dc.yk1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.f(chatViewHolder, z2);
                    }
                });
                return;
            }
            if (MessageNewAdapter.this.U0()) {
                int i = (iIntValue * 80) / 100;
                if (mp1.h()) {
                    rq1.d.e(i, new ToyControlBuilder(ToyControlBuilder.a.SPEED));
                    return;
                }
                pc1 pc1Var = pc1.a;
                int i2 = i * 5;
                pc1Var.W(i2);
                pc1Var.Y(i2);
            }
        }
    }

    public interface t0 {
        void Z1();
    }

    public class u extends SimpleImageLoadingListener {
        public final /* synthetic */ ChatViewHolder a;
        public final /* synthetic */ CommunMessage b;

        public class a implements View.OnClickListener {
            public final /* synthetic */ Bitmap a;

            public a(Bitmap bitmap) {
                this.a = bitmap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                u uVar = u.this;
                MessageNewAdapter.this.g.x3(uVar.b, this.a, uVar.a.miv_reply_user_picture);
            }
        }

        public class b implements View.OnClickListener {
            public final /* synthetic */ Bitmap a;

            public b(Bitmap bitmap) {
                this.a = bitmap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m0.a[u.this.b.getType().ordinal()] != 10) {
                    return;
                }
                u uVar = u.this;
                MessageNewAdapter.this.g.x3(uVar.b, this.a, uVar.a.miv_reply_user_picture);
            }
        }

        public u(ChatViewHolder chatViewHolder, CommunMessage communMessage) {
            this.a = chatViewHolder;
            this.b = communMessage;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            this.a.miv_reply_user_picture.setImageBitmap(bitmap);
            this.a.miv_reply_user_picture.setOnClickListener(new a(bitmap));
            this.a.cl_reply.setOnClickListener(new b(bitmap));
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    public interface u0 {
        boolean a(CommunMessage communMessage, EntityChat entityChat);
    }

    public class v implements View.OnTouchListener {
        public v() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 5) {
                return false;
            }
            MessageNewAdapter.this.q.y();
            return false;
        }
    }

    public interface v0 {
        void a(Pattern pattern);
    }

    public class w extends SimpleImageLoadingListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ChatViewHolder c;
        public final /* synthetic */ CommunMessage d;

        public class a extends SimpleImageLoadingListener {
            public a() {
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                w wVar = w.this;
                MessageNewAdapter.this.A1(wVar.c, wVar.d, bitmap);
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingStarted(String str, View view) {
            }
        }

        public w(boolean z, String str, ChatViewHolder chatViewHolder, CommunMessage communMessage) {
            this.a = z;
            this.b = str;
            this.c = chatViewHolder;
            this.d = communMessage;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            MessageNewAdapter.this.A1(this.c, this.d, bitmap);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ImageLoader imageLoader = ImageLoader.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append(WearUtils.e.replace("-api", ""));
            sb.append(this.a ? this.b.replace("thum_", "") : this.b);
            imageLoader.displayImage(sb.toString(), this.c.miv_reply_user_picture, MyApplication.Y, new a());
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    public class x implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ Bitmap b;
        public final /* synthetic */ ChatViewHolder c;

        public x(CommunMessage communMessage, Bitmap bitmap, ChatViewHolder chatViewHolder) {
            this.a = communMessage;
            this.b = bitmap;
            this.c = chatViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageNewAdapter.this.g.x3(this.a, this.b, this.c.miv_reply_user_picture);
        }
    }

    public class y implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ Bitmap b;
        public final /* synthetic */ ChatViewHolder c;

        public y(CommunMessage communMessage, Bitmap bitmap, ChatViewHolder chatViewHolder) {
            this.a = communMessage;
            this.b = bitmap;
            this.c = chatViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (m0.a[this.a.getType().ordinal()] != 10) {
                return;
            }
            MessageNewAdapter.this.g.x3(this.a, this.b, this.c.miv_reply_user_picture);
        }
    }

    public class z implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ EntityShortVideo b;

        public z(CommunMessage communMessage, EntityShortVideo entityShortVideo) {
            this.a = communMessage;
            this.b = entityShortVideo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageNewAdapter.this.g.H3(this.a, this.b);
        }
    }

    public MessageNewAdapter(List<CommunMessage> list, Activity activity, sa2 sa2Var, so3 so3Var, e82 e82Var, ie3 ie3Var, ChatEditText chatEditText) {
        this.e = list;
        this.t = chatEditText;
        this.f = activity;
        this.g = sa2Var;
        Account accountU = ch3.n().u();
        this.p = accountU;
        this.o = accountU.getId();
        this.r = so3Var;
        this.q = e82Var;
        this.s = ie3Var;
        this.i = new qo().h(R.drawable.chat_avatar_default).X(R.drawable.chat_avatar_default);
    }

    public static /* synthetic */ void V0(PatternViewHolder patternViewHolder) {
        patternViewHolder.patternSave.setEnabled(false);
        patternViewHolder.patternSave.setText(ah4.e(R.string.common_saved));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X0(CommunMessage communMessage, EntityPattern entityPattern, final PatternViewHolder patternViewHolder, v0 v0Var, String str) throws IOException {
        if (WearUtils.e1(str) || str.contains("result")) {
            sg3.i(this.f, R.string.file_notfound);
            return;
        }
        String strReplace = str.replace("\r", "");
        String status = communMessage.getStatus();
        if (WearUtils.e1(status)) {
            status = WearUtils.E();
        }
        if (rf3.o(strReplace)) {
            strReplace = rf3.r(strReplace);
        }
        WearUtils.m2(strReplace, status);
        Pattern patternN = N(status, strReplace, entityPattern);
        xe2.L0().t(patternN, true);
        communMessage.setStatus(patternN.getId());
        CommunMessage communMessageFindById = DaoUtils.getCommunMessageDao().findById(communMessage.getId());
        if (communMessageFindById != null) {
            communMessageFindById.setStatus(patternN.getId());
            DaoUtils.getCommunMessageDao().updateOrAdd(communMessageFindById);
            if (WearUtils.e1(DaoUtils.getCommunMessageDao().findById(communMessage.getId()).getStatus())) {
                communMessage.setStatus(null);
                sg3.i(this.f, R.string.chat_save_pattern_failed);
            } else {
                this.k.post(new Runnable() { // from class: dc.el1
                    @Override // java.lang.Runnable
                    public final void run() {
                        MessageNewAdapter.V0(patternViewHolder);
                    }
                });
            }
        }
        if (v0Var != null) {
            v0Var.a(patternN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z0(CommunMessage communMessage, ChatViewHolder chatViewHolder, int i2, String str, int i3, int i4) {
        if (this.q.F(communMessage.getId())) {
            W1(chatViewHolder, i2, chatViewHolder.userMessage.getWidth(), chatViewHolder.userMessage.getHeight(), str);
            chatViewHolder.messageGlass.setVisibility(0);
        } else {
            chatViewHolder.messageBlur.setVisibility(8);
            chatViewHolder.messageGlass.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b1(EntityGiftCard entityGiftCard, boolean z2, View view) {
        String str;
        HashMap map = new HashMap();
        String cardLink = entityGiftCard.getCardLink();
        if (WearUtils.v) {
            str = cardLink + "?_utm_pro=2203032057";
        } else {
            str = cardLink + "?_utm_pro=2203032511";
        }
        map.put(DownloadService.KEY_CONTENT_ID, str);
        map.put("type", Integer.valueOf(z2 ? 1 : 2));
        ye3.d("M0016", WearUtils.A.toJson(map));
        MyApplication.y0(this.f, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d1(EntityPattern entityPattern, CommunMessage communMessage, PatternViewHolder patternViewHolder, View view) {
        if (WearUtils.e1(entityPattern.getUrl())) {
            this.g.P();
        } else if (this.f instanceof ChatRoomActivity) {
            EventBus.getDefault().post(new PatternOrAlarmSaveEvent(communMessage, 1, this.g.C().getId()));
        } else {
            P(communMessage, entityPattern, patternViewHolder, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f1(EntityVMShareCard entityVMShareCard, View view) {
        ye3.j(this.f instanceof ChatRoomActivity ? "group chatroom" : "friend chatroom", "vibemate_share_link_click", "click", "vibemate_share_link", "link", entityVMShareCard.getUrl(), "", -1L);
        this.f.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(entityVMShareCard.getUrl())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h1(EntityWishList entityWishList, WishListViewHolder wishListViewHolder, View view) {
        String wishListUrl = entityWishList.getWishListUrl();
        this.f.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(wishListUrl + (!WearUtils.v ? "?_utm_pro=2112141049" : "?_utm_pro=2201181285"))));
        HashMap map = new HashMap();
        map.put(DownloadService.KEY_CONTENT_ID, wishListUrl);
        if (wishListViewHolder instanceof WishListSelfViewHolder) {
            map.put("type", 1);
        } else {
            map.put("type", 2);
        }
        ye3.d("M0008", WearUtils.A.toJson(map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j1(CommunMessage communMessage, EntityPattern entityPattern, Pattern pattern) {
        B1(pattern);
        U(pattern, communMessage, entityPattern, null, "ChatActivity");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l1(ChatViewHolder chatViewHolder, EntityAudio entityAudio, int i2, boolean z2, View view) {
        E1(chatViewHolder, entityAudio, i2, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n1(CommunMessage communMessage, ChatViewHolder chatViewHolder, EntityAudio entityAudio, int i2, boolean z2, View view) {
        if (communMessage.getType() == MessageType.audio) {
            E1(chatViewHolder, entityAudio, i2, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p1(String str) {
        MyApplication.y0(this.f, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r1(boolean z2, boolean z3, String str) {
        if (z3) {
            if (this.l == null) {
                this.l = new LinkJumpDialog(this.f, new LinkJumpDialog.b() { // from class: dc.hl1
                    @Override // com.wear.widget.dialog.LinkJumpDialog.b
                    public final void a(String str2) {
                        this.a.p1(str2);
                    }
                });
            }
            ue3.a(this.t, this.f);
            this.l.d(str);
            return;
        }
        if (!l22.p(str)) {
            MyApplication.y0(this.f, str);
            return;
        }
        if (!uf2.v().q()) {
            sg3.l(ah4.e(R.string.net_connect_error_tip));
            return;
        }
        Activity activity = this.f;
        if (activity != null && (activity instanceof BaseActivity)) {
            ((BaseActivity) activity).showDialog();
        }
        int iIndexOf = str.indexOf("t2/");
        String strSubstring = iIndexOf > 0 ? str.substring(iIndexOf + 3) : "";
        if (TextUtils.isEmpty(strSubstring)) {
            return;
        }
        if (na2.m().i()) {
            na2.m().t();
            ((BaseActivity) this.f).dissDialog();
        } else {
            ((BaseActivity) this.f).dissDialog();
            l22.n().f(strSubstring, z2);
        }
    }

    public final void A0(SystemViewHolder systemViewHolder) {
        systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.notification_system_message));
    }

    public final void A1(ChatViewHolder chatViewHolder, CommunMessage communMessage, Bitmap bitmap) {
        chatViewHolder.miv_reply_user_picture.setImageBitmap(bitmap);
        chatViewHolder.miv_reply_user_picture.setOnClickListener(new x(communMessage, bitmap, chatViewHolder));
        chatViewHolder.cl_reply.setOnClickListener(new y(communMessage, bitmap, chatViewHolder));
    }

    public final void B0(SystemViewHolder systemViewHolder, EntitySystem entitySystem) {
        systemViewHolder.tvSyncMessage.setText(entitySystem.getSystemMessage());
    }

    public final void B1(Pattern pattern) {
        xe2 xe2Var = (xe2) xe2.L0();
        ArrayList arrayList = new ArrayList();
        arrayList.add(pattern);
        xe2Var.J1(arrayList);
    }

    public final void C0(AlarmViewHolder alarmViewHolder, CommunMessage communMessage, DataEntityAbstract dataEntityAbstract, int i2, boolean z2) {
        mz1 mz1VarF = nz1.e().f();
        EntityAlarm entityAlarm = (EntityAlarm) dataEntityAbstract;
        alarmViewHolder.alarmTime.setText(be3.c(entityAlarm.getPattern().getTime(), WearUtils.x));
        String strK4 = SetAlarmActivity.K4(entityAlarm.getPattern().getFrequency(), entityAlarm.getPattern().getDates() == null ? null : WearUtils.A.toJson(entityAlarm.getPattern().getDates()));
        alarmViewHolder.alarmRequency.setText(strK4);
        boolean z3 = alarmViewHolder instanceof AlarmSelfViewHolder;
        String strV1 = V1(alarmViewHolder.userImg, communMessage, z3 ? this.p : this.g.C());
        if (z3) {
            I1(alarmViewHolder.ivAlarm, mz1VarF.j());
            alarmViewHolder.alarmMessage.setBackgroundResource(mz1VarF.h());
            alarmViewHolder.alarmTime.setTextColor(mz1VarF.n());
            alarmViewHolder.alarmRequency.setTextColor(mz1VarF.k());
        } else {
            I1(alarmViewHolder.ivAlarm, mz1VarF.x());
            alarmViewHolder.alarmMessage.setBackgroundResource(mz1VarF.c0());
            alarmViewHolder.alarmTime.setTextColor(mz1VarF.b());
            alarmViewHolder.alarmRequency.setTextColor(mz1VarF.M());
        }
        if (!z3) {
            AlarmFriendViewHolder alarmFriendViewHolder = (AlarmFriendViewHolder) alarmViewHolder;
            alarmFriendViewHolder.alarmDecline.setTextColor(mz1VarF.n());
            alarmFriendViewHolder.alarmAccept.setTextColor(mz1VarF.n());
            alarmFriendViewHolder.alarmActionLayout.setVisibility(0);
            alarmFriendViewHolder.alarmAction.setVisibility(0);
            alarmFriendViewHolder.alarmDecline.setEnabled(true);
            alarmFriendViewHolder.alarmAccept.setEnabled(true);
            alarmFriendViewHolder.alarmVerticalLine.setBackgroundColor(mz1VarF.Y());
            String status = communMessage.getStatus();
            alarmFriendViewHolder.alarmAutoPlayIcon.setVisibility(8);
            alarmFriendViewHolder.alarmMessage.setAlpha(1.0f);
            if (WearUtils.e1(status)) {
                alarmFriendViewHolder.alarmActionLayout.setVisibility(0);
                alarmFriendViewHolder.alarmAction.setVisibility(0);
            } else if (status.startsWith(AlarmListItems.ALARM_STATUS_AUTO)) {
                alarmFriendViewHolder.alarmAutoPlay.setVisibility(0);
                alarmFriendViewHolder.alarmAction.setVisibility(8);
                alarmFriendViewHolder.alarmAutoPlay.setText(ah4.e(R.string.alarm_status_automatic));
                if (AlarmMessagingService.b(entityAlarm)) {
                    alarmFriendViewHolder.alarmAutoPlay.setText(ah4.e(R.string.alarm_status_expired));
                    alarmFriendViewHolder.alarmAutoPlayIcon.setVisibility(0);
                }
            } else {
                alarmFriendViewHolder.alarmAutoPlay.setVisibility(8);
                if (status.startsWith(AlarmListItems.ALARM_STATUS_WAIT)) {
                    if (AlarmMessagingService.b(entityAlarm)) {
                        alarmFriendViewHolder.alarmAction.setVisibility(8);
                        alarmFriendViewHolder.alarmDecline.setEnabled(false);
                        alarmFriendViewHolder.alarmAccept.setEnabled(false);
                        alarmFriendViewHolder.alarmAutoPlay.setVisibility(0);
                        alarmFriendViewHolder.alarmAutoPlay.setText(ah4.e(R.string.alarm_status_expired));
                        alarmFriendViewHolder.alarmAutoPlayIcon.setVisibility(0);
                    }
                    IPeopleInfo iPeopleInfoC = this.g.C();
                    if (iPeopleInfoC.isGroup() && ((Group) iPeopleInfoC).isExit()) {
                        alarmFriendViewHolder.alarmDecline.setEnabled(false);
                        alarmFriendViewHolder.alarmAccept.setEnabled(false);
                        alarmFriendViewHolder.alarmAutoPlay.setVisibility(0);
                        alarmFriendViewHolder.alarmAutoPlay.setText(ah4.e(R.string.alarm_status_expired));
                        alarmFriendViewHolder.alarmAutoPlayIcon.setVisibility(0);
                    }
                } else {
                    alarmFriendViewHolder.alarmAction.setVisibility(8);
                    alarmFriendViewHolder.alarmDecline.setEnabled(false);
                    alarmFriendViewHolder.alarmAccept.setEnabled(false);
                    if (status.startsWith(AlarmListItems.ALARM_STATUS_ACCEPT)) {
                        alarmFriendViewHolder.alarmAutoPlay.setVisibility(0);
                        alarmFriendViewHolder.alarmAutoPlay.setText(ah4.e(R.string.alarm_status_accept));
                    } else if (status.startsWith(AlarmListItems.ALARM_STATUS_REJECT)) {
                        alarmFriendViewHolder.alarmAutoPlay.setVisibility(0);
                        alarmFriendViewHolder.alarmAutoPlay.setText(ah4.e(R.string.alarm_status_rejected));
                    }
                }
            }
            alarmFriendViewHolder.alarmDecline.setOnClickListener(new i(communMessage, entityAlarm));
            alarmFriendViewHolder.alarmAccept.setOnClickListener(new j(entityAlarm, communMessage));
        }
        alarmViewHolder.alarmMessage.setOnClickListener(new l(entityAlarm, strK4, communMessage, strV1));
        V1(alarmViewHolder.userImg, communMessage, z2 ? this.p : this.g.C());
        S1(i2, alarmViewHolder.userImg, alarmViewHolder.llRootAnima, z2, alarmViewHolder.timeLayout, false);
    }

    public final void C1(String str, ChatViewHolder chatViewHolder, boolean z2) {
        this.r.F();
        this.r.E(str, new t(chatViewHolder, z2), U0());
    }

    public final void D0(AudioViewHolder audioViewHolder, CommunMessage communMessage, DataEntityAbstract dataEntityAbstract, int i2, boolean z2) {
        mz1 mz1VarF = nz1.e().f();
        EntityAudio entityAudio = (EntityAudio) dataEntityAbstract;
        boolean zIsExpired = entityAudio.isExpired();
        audioViewHolder.voiceTime.setText(entityAudio.getTime() + "''");
        if (z2) {
            audioViewHolder.voiceTime.setTextColor(mz1VarF.X());
        }
        audioViewHolder.voicePlay.setTag(entityAudio.getUrl());
        int dimensionPixelSize = this.f.getResources().getDimensionPixelSize(R.dimen.activity_msg_max_lenth) - this.f.getResources().getDimensionPixelSize(R.dimen.activity_msg_min_lenth);
        int i3 = dimensionPixelSize / 60;
        ce3.a(this.f, 11.0f);
        if (zIsExpired) {
            ce3.a(this.f, 46.0f);
            audioViewHolder.tvExpired.setVisibility(0);
        } else {
            dimensionPixelSize = (int) (i3 * entityAudio.getTime());
            ce3.a(this.f, 11.0f);
            audioViewHolder.tvExpired.setVisibility(8);
        }
        if (z2) {
            audioViewHolder.llVoice.setPadding(dimensionPixelSize, 0, 0, 0);
            G1(audioViewHolder.voicePlay, mz1VarF.y());
            audioViewHolder.voiceTime.setTextColor(mz1VarF.K());
            I1(audioViewHolder.voiceIcon, zIsExpired ? mz1VarF.a0() : mz1VarF.i0());
            audioViewHolder.vGuideline.setBackgroundResource(mz1VarF.L());
            audioViewHolder.tvExpired.setTextColor(mz1VarF.f());
            audioViewHolder.tvExpired.setBackgroundResource(mz1VarF.r());
        } else {
            audioViewHolder.llVoice.setPadding(0, 0, dimensionPixelSize, 0);
            G1(audioViewHolder.voicePlay, mz1VarF.g0());
            audioViewHolder.voiceTime.setTextColor(mz1VarF.h0());
            I1(audioViewHolder.voiceIcon, zIsExpired ? mz1VarF.d0() : mz1VarF.o());
            audioViewHolder.vGuideline.setBackgroundResource(mz1VarF.e0());
            audioViewHolder.tvExpired.setTextColor(mz1VarF.p());
            audioViewHolder.tvExpired.setBackgroundResource(mz1VarF.O());
        }
        V1(audioViewHolder.userImg, communMessage, z2 ? this.p : this.g.C());
        audioViewHolder.voicePlay.setOnClickListener(new p0(zIsExpired, mz1VarF, z2, audioViewHolder, i2));
        S1(i2, audioViewHolder.userImg, audioViewHolder.llRootAnima, z2, audioViewHolder.timeLayout, false);
    }

    public void D1(CommunMessage communMessage, EntityPattern entityPattern) {
        if (communMessage.getSendStatus() == 2) {
            this.g.P();
        } else {
            if (WearUtils.e1(entityPattern.getUrl())) {
                this.g.P();
                return;
            }
            kn3 kn3Var = new kn3((Context) MyApplication.K, ah4.e(R.string.chat_pattern_resend_notices), ah4.e(R.string.common_yes), ah4.e(R.string.common_no), true, (kn3.d) new f(entityPattern));
            kn3Var.show();
            kn3Var.p();
        }
    }

    public final void E0(ChatViewHolder chatViewHolder, CommunMessage communMessage, DataEntityAbstract dataEntityAbstract, int i2, boolean z2) {
        u0 u0Var;
        V1(chatViewHolder.userImg, communMessage, z2 ? this.p : this.g.C());
        EntityChat entityChat = (EntityChat) dataEntityAbstract;
        V(chatViewHolder, communMessage, entityChat, i2, z2);
        if (!z2 && (u0Var = this.j) != null) {
            if (u0Var.a(communMessage, entityChat)) {
                if (chatViewHolder.llRootAnima.getTag() instanceof ValueAnimator) {
                    ((ValueAnimator) chatViewHolder.llRootAnima.getTag()).end();
                }
                ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(chatViewHolder.llRootAnima, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, -1381654, 15395562);
                objectAnimatorOfInt.setDuration(3000L);
                objectAnimatorOfInt.setEvaluator(new ArgbEvaluator());
                objectAnimatorOfInt.start();
                chatViewHolder.llRootAnima.setTag(objectAnimatorOfInt);
            } else if (chatViewHolder.llRootAnima.getTag() instanceof ValueAnimator) {
                ((ValueAnimator) chatViewHolder.llRootAnima.getTag()).end();
            }
        }
        T1(chatViewHolder, communMessage, entityChat, z2);
        if (WearUtils.e1(communMessage.getReplyData())) {
            chatViewHolder.cl_reply.setVisibility(8);
            chatViewHolder.ll_reply_voice.setVisibility(8);
            chatViewHolder.rl_reply_video.setVisibility(8);
        } else {
            W(chatViewHolder, communMessage, i2, z2);
        }
        S1(i2, chatViewHolder.userImg, chatViewHolder.llRootAnima, z2, chatViewHolder.timeLayout, false);
    }

    public final void E1(ChatViewHolder chatViewHolder, EntityAudio entityAudio, int i2, boolean z2) {
        if (T0(entityAudio)) {
            return;
        }
        if (this.g.E()) {
            this.h = -1;
            return;
        }
        mz1 mz1VarF = nz1.e().f();
        ImageView imageView = this.n.get(0);
        if (imageView != null) {
            I1(imageView, mz1VarF.i0());
        }
        ImageView imageView2 = this.n.get(1);
        if (imageView2 != null) {
            I1(imageView2, mz1VarF.E());
        }
        this.n.clear();
        this.n.put(1, chatViewHolder.reply_voice_icon);
        Q(chatViewHolder, entityAudio.getUrl(), i2, z2);
    }

    public final void F0(ControlViewHolder controlViewHolder, CommunMessage communMessage, DataEntityAbstract dataEntityAbstract, int i2, boolean z2) {
        V1(controlViewHolder.userImg, communMessage, z2 ? this.p : this.g.C());
        mz1 mz1VarF = nz1.e().f();
        if (z2) {
            G1(controlViewHolder.controlMessage, mz1VarF.h());
            controlViewHolder.tvControlAgain.setTextColor(mz1VarF.m());
            controlViewHolder.tvControlContent.setTextColor(mz1VarF.n());
        } else {
            G1(controlViewHolder.controlMessage, mz1VarF.c0());
            controlViewHolder.tvControlAgain.setTextColor(mz1VarF.J());
            controlViewHolder.tvControlContent.setTextColor(mz1VarF.b());
        }
        int i3 = m0.a[communMessage.getType().ordinal()];
        if (i3 == 2) {
            EntityLive entityLive = (EntityLive) dataEntityAbstract;
            H1(communMessage.getType(), controlViewHolder, !z2 ? 1 : 0, entityLive.getLiveOPTType().equals(EntityLive.LiveOPTType.cancel) ? 0 : entityLive.getLiveOPTType().equals(EntityLive.LiveOPTType.reject) ? 1 : entityLive.getLiveOPTType().equals(EntityLive.LiveOPTType.end) ? 2 : entityLive.getLiveOPTType().equals(EntityLive.LiveOPTType.networkError) ? 3 : entityLive.getLiveOPTType().equals(EntityLive.LiveOPTType.noAnswer) ? 4 : -1, ah4.e(R.string.str_chatroom_live), entityLive.getControlTime(), 0, !z2 ? mz1VarF.F() : mz1VarF.d());
        } else if (i3 == 3) {
            EntitySync entitySync = (EntitySync) dataEntityAbstract;
            H1(communMessage.getType(), controlViewHolder, !z2 ? 1 : 0, entitySync.getSyncOPTType().equals(EntitySync.SyncOPTType.cancel) ? 0 : entitySync.getSyncOPTType().equals(EntitySync.SyncOPTType.reject) ? 1 : entitySync.getSyncOPTType().equals(EntitySync.SyncOPTType.end) ? 2 : entitySync.getSyncOPTType().equals(EntitySync.SyncOPTType.networkError) ? 3 : entitySync.getSyncOPTType().equals(EntitySync.SyncOPTType.noAnswer) ? 4 : -1, ah4.e(R.string.str_chatroom_sync), entitySync.getControlTime(), 1, !z2 ? mz1VarF.z() : mz1VarF.R());
        } else if (i3 == 6) {
            EntityVideo entityVideo = (EntityVideo) dataEntityAbstract;
            H1(communMessage.getType(), controlViewHolder, !z2 ? 1 : 0, entityVideo.getVideoOPTType().equals(EntityVideo.VideoOPTType.cancel) ? 0 : entityVideo.getVideoOPTType().equals(EntityVideo.VideoOPTType.reject) ? 1 : entityVideo.getVideoOPTType().equals(EntityVideo.VideoOPTType.end) ? 2 : entityVideo.getVideoOPTType().equals(EntityVideo.VideoOPTType.networkError) ? 3 : entityVideo.getVideoOPTType().equals(EntityVideo.VideoOPTType.noAnswer) ? 4 : -1, ah4.e(R.string.str_chatroom_videocall), entityVideo.getControlTime(), 2, !z2 ? mz1VarF.b0() : mz1VarF.T());
        } else if (i3 == 7) {
            EntityVoice entityVoice = (EntityVoice) dataEntityAbstract;
            H1(communMessage.getType(), controlViewHolder, !z2 ? 1 : 0, entityVoice.getVoiceOPTType().equals(EntityVoice.VoiceOPTType.cancel) ? 0 : entityVoice.getVoiceOPTType().equals(EntityVoice.VoiceOPTType.reject) ? 1 : entityVoice.getVoiceOPTType().equals(EntityVoice.VoiceOPTType.end) ? 2 : entityVoice.getVoiceOPTType().equals(EntityVoice.VoiceOPTType.networkError) ? 3 : entityVoice.getVoiceOPTType().equals(EntityVoice.VoiceOPTType.noAnswer) ? 4 : -1, ah4.e(R.string.str_chatroom_voicecall), entityVoice.getControlTime(), 3, !z2 ? mz1VarF.c() : mz1VarF.Q());
        }
        S1(i2, controlViewHolder.userImg, controlViewHolder.llRootAnima, z2, controlViewHolder.timeLayout, false);
    }

    public final void F1(EntityAlarm entityAlarm, CommunMessage communMessage) throws ParseException {
        String id = entityAlarm.getId();
        entityAlarm.setId(WearUtils.E());
        communMessage.setStatus(AlarmListItems.ALARM_STATUS_ACCEPT + id);
        communMessage.sendEntity(entityAlarm);
        DaoUtils.getCommunMessageDao().update((CommunMessageDao) communMessage);
        notifyDataSetChanged();
        AlarmListItems alarmListItemsFindAlarmByreceiveAlarmId = DaoUtils.getAlarmListDao().findAlarmByreceiveAlarmId(id);
        if (alarmListItemsFindAlarmByreceiveAlarmId != null) {
            alarmListItemsFindAlarmByreceiveAlarmId.setAccept(1);
            alarmListItemsFindAlarmByreceiveAlarmId.setIsSelected(1);
            DaoUtils.getAlarmListDao().updateOrAdd(alarmListItemsFindAlarmByreceiveAlarmId);
            zt3.t(this.f, alarmListItemsFindAlarmByreceiveAlarmId.getId(), false, true, false);
        }
    }

    public final void G0(GiftCardViewHolder giftCardViewHolder, CommunMessage communMessage, DataEntityAbstract dataEntityAbstract, int i2, final boolean z2) {
        final EntityGiftCard entityGiftCard = (EntityGiftCard) dataEntityAbstract;
        mz1 mz1VarF = nz1.e().f();
        V1(giftCardViewHolder.userImg, communMessage, z2 ? this.p : this.g.C());
        kf.v(this.f).v(entityGiftCard.getCardImage()).X(R.drawable.gift_card_bg).A0(giftCardViewHolder.giftCardImage);
        if (entityGiftCard.getStatus() == 3) {
            giftCardViewHolder.giftCardLayout.setAlpha(0.6f);
            giftCardViewHolder.giftCardTitle.setText(ah4.e(R.string.common_accepted));
        } else {
            giftCardViewHolder.giftCardLayout.setAlpha(1.0f);
            giftCardViewHolder.giftCardTitle.setText(ah4.e(R.string.gift_card_click));
        }
        if (z2) {
            giftCardViewHolder.giftCardLayout.setBackgroundResource(mz1VarF.h());
            giftCardViewHolder.centerLine.setBackgroundResource(mz1VarF.L());
        } else {
            giftCardViewHolder.giftCardLayout.setBackgroundResource(mz1VarF.c0());
            giftCardViewHolder.centerLine.setBackgroundResource(mz1VarF.h());
            giftCardViewHolder.centerLine.setBackgroundResource(mz1VarF.e0());
        }
        giftCardViewHolder.giftCardTitle.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        giftCardViewHolder.giftCardTitle.setSingleLine(true);
        giftCardViewHolder.giftCardTitle.setSelected(true);
        giftCardViewHolder.giftCardTitle.setFocusable(true);
        giftCardViewHolder.giftCardTitle.setFocusableInTouchMode(true);
        giftCardViewHolder.giftCardTitle.setHorizontallyScrolling(true);
        giftCardViewHolder.giftCardLayout.setOnClickListener(new View.OnClickListener() { // from class: dc.fl1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.b1(entityGiftCard, z2, view);
            }
        });
        S1(i2, giftCardViewHolder.userImg, giftCardViewHolder.llRootAnima, z2, giftCardViewHolder.timeLayout, false);
    }

    public final void G1(View view, int i2) {
        int paddingLeft = view.getPaddingLeft();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingBottom = view.getPaddingBottom();
        view.setBackground(th4.d(view.getContext(), i2));
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void H0(com.wear.adapter.longdistance.MessageNewAdapter.PatternFriendViewHolder r5, com.wear.protocol.CommunMessage r6, dc.mz1 r7, com.wear.protocol.EntityPattern r8) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.adapter.longdistance.MessageNewAdapter.H0(com.wear.adapter.longdistance.MessageNewAdapter$PatternFriendViewHolder, com.wear.protocol.CommunMessage, dc.mz1, com.wear.protocol.EntityPattern):void");
    }

    @SuppressLint({"StringFormatMatches"})
    public final void H1(MessageType messageType, ControlViewHolder controlViewHolder, int i2, int i3, String str, String str2, int i4, int i5) {
        if (i3 == -1) {
            return;
        }
        I1(controlViewHolder.iconControl, i5);
        controlViewHolder.tvControlTime.setVisibility(8);
        mz1 mz1VarF = nz1.e().f();
        if (i2 == 0) {
            controlViewHolder.tvControlTime.setTextColor(mz1VarF.M());
        } else {
            controlViewHolder.tvControlTime.setTextColor(mz1VarF.M());
        }
        String userName = this.g.getUserName();
        if (i3 == 0) {
            if (i2 == 0) {
                controlViewHolder.tvControlContent.setText(String.format(ah4.e(R.string.str_you_cancel_control_request), str));
            } else {
                controlViewHolder.tvControlContent.setText(String.format(ah4.e(R.string.str_partner_cancel_control_request), str, userName));
            }
        } else if (i3 == 1) {
            if (i2 == 0) {
                controlViewHolder.tvControlContent.setText(String.format(ah4.e(R.string.str_partner_decline_control_request), userName, str));
            } else {
                controlViewHolder.tvControlContent.setText(String.format(ah4.e(R.string.str_you_decline_control_request), str));
            }
        } else if (i3 == 2) {
            controlViewHolder.tvControlTime.setVisibility(0);
            if (WearUtils.e1(str2)) {
                controlViewHolder.tvControlTime.setVisibility(8);
            } else {
                controlViewHolder.tvControlTime.setText(str2);
            }
            if (i2 == 0) {
                controlViewHolder.tvControlContent.setText(String.format(ah4.e(R.string.str_you_started_control_session), str));
            } else {
                controlViewHolder.tvControlContent.setText(String.format(ah4.e(R.string.str_partner_started_control_session), userName, str));
            }
        } else if (i3 == 3) {
            if (i2 == 0) {
                controlViewHolder.tvControlContent.setText(ah4.e(R.string.str_chatroom_connection_error));
            } else {
                controlViewHolder.tvControlContent.setText(ah4.e(R.string.str_chatroom_connection_error));
            }
        } else if (i3 == 4) {
            if (i2 == 0) {
                controlViewHolder.tvControlContent.setText(String.format(ah4.e(R.string.str_control_request_timeout), str));
            } else {
                controlViewHolder.tvControlContent.setText(String.format(ah4.e(R.string.str_control_request_timeout), str));
            }
        }
        controlViewHolder.controlMessage.setOnClickListener(new m(i4));
    }

    public final void I(String str) {
        if (this.w) {
            this.w = false;
            this.x.postDelayed(new i0(), 500L);
            if (this.g.o()) {
                return;
            }
            User userV = ch3.n().v(str);
            if (userV != null && userV.isFriend()) {
                sg3.i(this.f, R.string.add_friend_user_exist);
                return;
            }
            if (userV != null && userV.addSendToMe()) {
                sg3.k(this.f, String.format(ah4.e(R.string.add_friend_user_requested), userV.getUserName()));
                return;
            }
            if (userV == null) {
                userV = new User(str);
            }
            if (hu3.k(str)) {
                userV.addFriendType(2);
                sg3.i(this.f, R.string.user_add_success);
            }
        }
    }

    public final void I0(PatternSelfViewHolder patternSelfViewHolder, CommunMessage communMessage, EntityPattern entityPattern) {
        patternSelfViewHolder.patternTime.setTextColor(nz1.e().f().k());
        TextView textView = patternSelfViewHolder.patternResend;
        if (textView != null) {
            textView.setOnClickListener(new g(communMessage, entityPattern));
        }
        if (patternSelfViewHolder.loading != null) {
            if (communMessage.isSendIng()) {
                patternSelfViewHolder.loading.setVisibility(0);
            } else {
                patternSelfViewHolder.loading.setVisibility(8);
            }
        }
    }

    public final void I1(ImageView imageView, int i2) {
        imageView.setImageDrawable(th4.d(imageView.getContext(), i2));
    }

    public final void J() throws IllegalStateException {
        if (U0()) {
            this.r.G();
            this.r.x();
            pc1.a.u0();
        }
    }

    public final void J0(final PatternViewHolder patternViewHolder, final CommunMessage communMessage, DataEntityAbstract dataEntityAbstract, int i2, boolean z2) {
        mz1 mz1VarF = nz1.e().f();
        final EntityPattern entityPattern = (EntityPattern) dataEntityAbstract;
        patternViewHolder.patternName.setText(entityPattern.getName().trim());
        patternViewHolder.patternTime.setText(WearUtils.Q(entityPattern.getTime()));
        V1(patternViewHolder.userImg, communMessage, z2 ? this.p : this.g.C());
        boolean z3 = patternViewHolder instanceof PatternFriendViewHolder;
        if (z3) {
            patternViewHolder.patternMessage.setBackgroundResource(mz1VarF.c0());
            patternViewHolder.llPatternButton.setBackgroundResource(mz1VarF.e());
        } else {
            patternViewHolder.patternMessage.setBackgroundResource(mz1VarF.h());
            patternViewHolder.llPatternButton.setBackgroundResource(mz1VarF.W());
        }
        patternViewHolder.patternMessage.setOnClickListener(new a(communMessage, entityPattern, z2, patternViewHolder));
        String status = communMessage.getStatus();
        if (WearUtils.e1(status) || xe2.L0().K(status) == null) {
            patternViewHolder.patternSave.setEnabled(true);
            patternViewHolder.patternSave.setText(ah4.e(R.string.common_save));
            patternViewHolder.patternSave.setTextColor(mz1VarF.a());
            patternViewHolder.patternSave.setOnClickListener(new View.OnClickListener() { // from class: dc.il1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.d1(entityPattern, communMessage, patternViewHolder, view);
                }
            });
        } else {
            patternViewHolder.patternSave.setEnabled(false);
            patternViewHolder.patternSave.setText(ah4.e(R.string.common_saved));
            patternViewHolder.patternSave.setTextColor(mz1VarF.u());
        }
        if (z3) {
            H0((PatternFriendViewHolder) patternViewHolder, communMessage, mz1VarF, entityPattern);
        } else {
            I0((PatternSelfViewHolder) patternViewHolder, communMessage, entityPattern);
        }
        S1(i2, patternViewHolder.userImg, patternViewHolder.llRootAnima, z2, patternViewHolder.timeLayout, false);
    }

    public void J1(u0 u0Var) {
        this.j = u0Var;
    }

    public final boolean K(String str, int i2) {
        if (i2 < getItemCount() - 1) {
            CommunMessage communMessage = this.e.get(i2 + 1);
            if (communMessage.getDataBean() != null && communMessage.getType() == MessageType.system) {
                EntitySystem entitySystem = (EntitySystem) communMessage.getDataBean();
                if (entitySystem.getFirstSysOPTType() == EntitySystem.SystemOPTType.T200 && ((entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C325 || entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C326 || entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C203 || entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C10000 || entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C10001) && !WearUtils.e1(entitySystem.getFirstString()) && entitySystem.getFirstString().indexOf(str) > 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void K0(PictureViewHolder pictureViewHolder, CommunMessage communMessage, DataEntityAbstract dataEntityAbstract, int i2, boolean z2) {
        int i3;
        boolean z3;
        if (dataEntityAbstract == null) {
            return;
        }
        EntityPicture entityPicture = (EntityPicture) dataEntityAbstract;
        String type = entityPicture.getType();
        boolean z4 = false;
        boolean z5 = !WearUtils.e1(type) && type.equals("emoji");
        String url = entityPicture.getUrl();
        String localUrl = entityPicture.getLocalUrl();
        MessageType type2 = communMessage.getType();
        MessageType messageType = MessageType.burnpicture;
        boolean z6 = type2 == messageType;
        V1(pictureViewHolder.userImg, communMessage, z2 ? this.p : this.g.C());
        pictureViewHolder.userPicture.setOnClickListener(new q0(communMessage, dataEntityAbstract));
        pictureViewHolder.userPicture.setEmoji(z5 && !z6);
        PictureBean pictureBean = null;
        if (pictureViewHolder.userPicture.getTag() != null && (pictureViewHolder.userPicture.getTag() instanceof PictureBean)) {
            pictureBean = (PictureBean) pictureViewHolder.userPicture.getTag();
        }
        PictureBean pictureBean2 = pictureBean;
        boolean zF = this.q.F(communMessage.getId());
        pictureViewHolder.chatBurnBg.setVisibility(8);
        pictureViewHolder.chatBurnedBg.setVisibility(8);
        pictureViewHolder.userPicture.setVisibility(0);
        ViewGroup.LayoutParams layoutParamsS0 = S0(pictureViewHolder.userPicture, z5, z6, (int) entityPicture.getW(), (int) entityPicture.getH());
        if (communMessage.getType() == messageType) {
            boolean zIsBurn = ((EntityBurnPicture) dataEntityAbstract).isBurn();
            if (zIsBurn) {
                pictureViewHolder.chatBurnedBg.setVisibility(0);
                pictureViewHolder.userPicture.setVisibility(8);
                S1(i2, pictureViewHolder.userImg, pictureViewHolder.llRootAnima, z2, pictureViewHolder.timeLayout, false);
                return;
            } else {
                pictureViewHolder.chatBurnBg.setVisibility(0);
                pictureViewHolder.userPicture.setVisibility(0);
                z4 = zIsBurn;
                z3 = zF;
                i3 = 8;
            }
        } else {
            i3 = 8;
            z3 = zF;
        }
        qo qoVarJ0 = (z3 || z6) ? new qo().W((int) entityPicture.getW(), (int) entityPicture.getH()).j0(new qx3(25, 4)) : new qo().W((int) entityPicture.getW(), (int) entityPicture.getH());
        if (pictureViewHolder instanceof PictureFriendViewHolder) {
            if (!WearUtils.e1(url) && (pictureBean2 == null || !url.equals(pictureBean2.url) || z3 != pictureBean2.isHide || z4 != pictureBean2.isBurn)) {
                StringBuilder sb = new StringBuilder();
                sb.append(WearUtils.e);
                sb.append(z5 ? url.replace("thum_", "") : url);
                u1(pictureViewHolder, communMessage, z5, url, layoutParamsS0, qoVarJ0, sb.toString());
            }
        } else {
            PictureSelfViewHolder pictureSelfViewHolder = (PictureSelfViewHolder) pictureViewHolder;
            if (WearUtils.e1(localUrl) || !(WearUtils.c0(localUrl).exists() || WearUtils.Z(localUrl).exists() || WearUtils.a0(localUrl).exists())) {
                if (WearUtils.e1(url)) {
                    pictureSelfViewHolder.userPicture.setImageResource(R.drawable.ic_picture_placeholder);
                    pictureSelfViewHolder.loading.setVisibility(i3);
                    this.m.put(url, pictureViewHolder.userPicture);
                } else if (pictureBean2 == null || !url.equals(pictureBean2.url) || z3 != pictureBean2.isHide || z4 != pictureBean2.isBurn) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(WearUtils.e);
                    sb2.append(z5 ? url.replace("thum_", "") : url);
                    u1(pictureViewHolder, communMessage, z5, url, layoutParamsS0, qoVarJ0, sb2.toString());
                }
            } else if (pictureBean2 == null || !localUrl.equals(pictureBean2.localUrl) || z3 != pictureBean2.isHide || z4 != pictureBean2.isBurn) {
                if (z5) {
                    File fileZ = WearUtils.Z(localUrl).exists() ? WearUtils.Z(localUrl) : WearUtils.a0(localUrl);
                    Uri.fromFile(fileZ).toString();
                    kf.v(this.f).s(fileZ).X(R.drawable.ic_picture_placeholder).f(ii.d).a(qoVarJ0).A0(pictureViewHolder.userPicture);
                } else {
                    File fileC0 = WearUtils.c0(localUrl);
                    kf.v(this.f).s(fileC0).X(R.drawable.ic_picture_placeholder).a(qoVarJ0).x0(new r0(pictureViewHolder.userPicture, Uri.fromFile(fileC0).toString(), url, communMessage, layoutParamsS0));
                }
            }
        }
        S1(i2, pictureViewHolder.userImg, pictureViewHolder.llRootAnima, z2, pictureViewHolder.timeLayout, false);
    }

    public final void K1(final CommunMessage communMessage, final ChatViewHolder chatViewHolder, final int i2, final boolean z2) {
        StringBuilder sb;
        String str;
        mz1 mz1VarF = nz1.e().f();
        chatViewHolder.tv_reply_msg.setVisibility(8);
        chatViewHolder.miv_reply_user_picture.setVisibility(8);
        chatViewHolder.rl_reply_video.setVisibility(8);
        chatViewHolder.ll_reply_voice.setVisibility(0);
        final EntityAudio entityAudio = new EntityAudio(communMessage.getData());
        boolean zT0 = T0(entityAudio);
        if (zT0) {
            chatViewHolder.imgExpired.setVisibility(0);
        } else {
            chatViewHolder.imgExpired.setVisibility(8);
        }
        TextView textView = chatViewHolder.reply_voice_time;
        if (zT0) {
            sb = new StringBuilder();
            sb.append("[");
            sb.append(ah4.e(R.string.voice_message_expired));
            str = "]";
        } else {
            sb = new StringBuilder();
            sb.append(entityAudio.getTime());
            str = "''";
        }
        sb.append(str);
        textView.setText(sb.toString());
        Q1(entityAudio, chatViewHolder.ll_reply_voice);
        I1(chatViewHolder.reply_voice_icon, S(zT0, z2));
        chatViewHolder.ll_reply_voice.setOnClickListener(new View.OnClickListener() { // from class: dc.cl1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.l1(chatViewHolder, entityAudio, i2, z2, view);
            }
        });
        chatViewHolder.cl_reply.setOnClickListener(new View.OnClickListener() { // from class: dc.jl1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.n1(communMessage, chatViewHolder, entityAudio, i2, z2, view);
            }
        });
        if (z2) {
            chatViewHolder.vLeft.setBackgroundColor(mz1VarF.P());
            chatViewHolder.vLineBottom.setBackgroundColor(mz1VarF.P());
            chatViewHolder.reply_voice_time.setTextColor(mz1VarF.i());
        } else {
            chatViewHolder.vLeft.setBackgroundColor(mz1VarF.I());
            chatViewHolder.vLineBottom.setBackgroundColor(mz1VarF.I());
            chatViewHolder.reply_voice_time.setTextColor(mz1VarF.j0());
        }
    }

    public final boolean L(File file) throws Throwable {
        boolean z2;
        if (file.exists()) {
            String strN1 = WearUtils.N1(file.getPath());
            if (TextUtils.isEmpty(strN1) || strN1.contains("result")) {
                file.delete();
                z2 = false;
            } else {
                z2 = true;
            }
        } else {
            z2 = false;
        }
        if (!z2) {
            sg3.h(R.string.file_notfound);
        }
        return z2;
    }

    public final void L0(ShortVideoViewHolder shortVideoViewHolder, CommunMessage communMessage, DataEntityAbstract dataEntityAbstract, int i2, boolean z2) {
        boolean z3;
        if (dataEntityAbstract == null) {
            return;
        }
        EntityShortVideo entityShortVideo = (EntityShortVideo) dataEntityAbstract;
        String picUrl = entityShortVideo.getPicUrl();
        String picLocalUrl = entityShortVideo.getPicLocalUrl();
        V1(shortVideoViewHolder.userImg, communMessage, z2 ? this.p : this.g.C());
        shortVideoViewHolder.userPicture.setOnClickListener(new d0(communMessage, dataEntityAbstract));
        PictureBean pictureBean = null;
        if (shortVideoViewHolder.userPicture.getTag() != null && (shortVideoViewHolder.userPicture.getTag() instanceof PictureBean)) {
            pictureBean = (PictureBean) shortVideoViewHolder.userPicture.getTag();
        }
        shortVideoViewHolder.videoBurnedLayout.setVisibility(8);
        if (communMessage.getType() != MessageType.burnvideo) {
            z3 = false;
        } else if (((EntityBurnShortVideo) dataEntityAbstract).isBurn()) {
            shortVideoViewHolder.playIcon.setVisibility(8);
            shortVideoViewHolder.userPicture.setVisibility(8);
            shortVideoViewHolder.videoBurnedLayout.setVisibility(0);
            return;
        } else {
            shortVideoViewHolder.playIcon.setVisibility(0);
            shortVideoViewHolder.userPicture.setVisibility(0);
            z3 = true;
        }
        boolean zF = this.q.F(communMessage.getId());
        if (shortVideoViewHolder instanceof ShortVideoFriendViewHolder) {
            ShortVideoFriendViewHolder shortVideoFriendViewHolder = (ShortVideoFriendViewHolder) shortVideoViewHolder;
            if (pictureBean == null || WearUtils.e1(picUrl) || !picUrl.equals(pictureBean.url) || zF != pictureBean.isHide) {
                String str = WearUtils.e + picUrl;
                kf.v(this.f).j().J0(str).a(new qo()).X(R.drawable.ic_picture_placeholder).x0(new e0(shortVideoViewHolder.userPicture, str, picUrl, communMessage, shortVideoFriendViewHolder, z3));
            }
        } else {
            ShortVideoSelfViewHolder shortVideoSelfViewHolder = (ShortVideoSelfViewHolder) shortVideoViewHolder;
            File file = new File(picLocalUrl);
            if (file.exists()) {
                kf.v(this.f).j().G0(file).a(new qo()).X(R.drawable.ic_picture_placeholder).x0(new f0(shortVideoViewHolder.userPicture, file, shortVideoViewHolder, picLocalUrl, communMessage, picUrl, z3));
            } else if (WearUtils.e1(picUrl)) {
                shortVideoSelfViewHolder.userPicture.setImageResource(R.drawable.ic_picture_placeholder);
                this.m.put(picUrl, shortVideoViewHolder.userPicture);
            } else if (pictureBean == null || !picUrl.equals(pictureBean.url) || zF != pictureBean.isHide) {
                String str2 = WearUtils.e + picUrl;
                kf.v(this.f).j().J0(str2).a(new qo()).X(R.drawable.ic_picture_placeholder).x0(new h0(shortVideoViewHolder.userPicture, str2, shortVideoViewHolder, picLocalUrl, communMessage, picUrl, z3));
            }
        }
        S1(i2, shortVideoViewHolder.userImg, shortVideoViewHolder.llRootAnima, z2, shortVideoViewHolder.timeLayout, false);
    }

    public final void L1(ChatViewHolder chatViewHolder, CommunMessage communMessage) {
        chatViewHolder.cl_reply.setOnClickListener(new r(communMessage));
        chatViewHolder.tv_reply_msg.setVisibility(0);
        chatViewHolder.miv_reply_user_picture.setVisibility(8);
        chatViewHolder.rl_reply_video.setVisibility(8);
        EntityChat entityChat = new EntityChat(communMessage.getData());
        this.s.l(chatViewHolder.tv_reply_msg, entityChat.getText() + "", 18);
        chatViewHolder.ll_reply_voice.setVisibility(8);
    }

    public final Pattern M(File file, EntityPattern entityPattern) {
        Pattern pattern = new Pattern();
        pattern.setId(WearUtils.E());
        pattern.setData(WearUtils.N1(file.getPath()));
        pattern.setName(entityPattern.getName());
        pattern.setToyVersion(entityPattern.getToyVersion());
        pattern.setCreator(WearUtils.y.r());
        pattern.setEmail(WearUtils.y.r());
        pattern.setAuthor(WearUtils.y.u().getUserName());
        pattern.setTimer(WearUtils.Q(entityPattern.getTime()));
        pattern.setToyFunc(entityPattern.getFeature());
        if (pattern.getHead() != null && !WearUtils.e1(pattern.getHead().getToys()) && pattern.getHead().getToys().equalsIgnoreCase(Toy.TOY_XMACHINE)) {
            pattern.setToyFeature(Toy.TOY_FEATURE_XMACHINE);
        }
        return pattern;
    }

    public final void M0(SystemViewHolder systemViewHolder, CommunMessage communMessage, DataEntityAbstract dataEntityAbstract, int i2, boolean z2) {
        mz1 mz1VarF = nz1.e().f();
        try {
        } catch (Exception e2) {
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
        systemViewHolder.tvSyncMessage.setTextColor(mz1VarF.f0());
        systemViewHolder.typingLinear.setVisibility(8);
        systemViewHolder.parentLinear.setGravity(17);
        systemViewHolder.userImg.setVisibility(8);
        systemViewHolder.syncMessageLayout.setVisibility(0);
        EntitySystem entitySystem = (EntitySystem) dataEntityAbstract;
        EntitySystem.SystemOPTType firstSysOPTType = entitySystem.getFirstSysOPTType();
        EntitySystem.SystemOPTType systemOPTType = EntitySystem.SystemOPTType.T200;
        if (firstSysOPTType == systemOPTType && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C200) {
            p0(systemViewHolder, z2);
        } else if (entitySystem.getFirstSysOPTType() == systemOPTType && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C202) {
            q0(systemViewHolder, entitySystem);
        } else if (entitySystem.getFirstSysOPTType() == systemOPTType && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C203) {
            r0(systemViewHolder, entitySystem);
        } else if (entitySystem.getFirstSysOPTType() == systemOPTType && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C325) {
            w0(systemViewHolder, communMessage);
        } else if (entitySystem.getFirstSysOPTType() == systemOPTType && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C326) {
            x0(systemViewHolder);
        } else if (entitySystem.getFirstSysOPTType() == systemOPTType && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C327) {
            y0(systemViewHolder, communMessage);
        } else if (entitySystem.getFirstSysOPTType() == systemOPTType && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C328) {
            z0(systemViewHolder);
        } else if (entitySystem.getFirstSysOPTType() == systemOPTType && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C666) {
            B0(systemViewHolder, entitySystem);
        } else {
            EntitySystem.SystemOPTType firstSysOPTType2 = entitySystem.getFirstSysOPTType();
            EntitySystem.SystemOPTType systemOPTType2 = EntitySystem.SystemOPTType.T300;
            if (firstSysOPTType2 == systemOPTType2 && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C320) {
                v0(systemViewHolder, communMessage, z2);
            } else if (entitySystem.getFirstSysOPTType() == systemOPTType2 && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C308) {
                u0(systemViewHolder, entitySystem);
            } else if (entitySystem.getFirstSysOPTType() == systemOPTType && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C204) {
                s0(systemViewHolder, communMessage, i2, z2);
            } else if (entitySystem.getFirstSysOPTType() == systemOPTType && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C205) {
                t0(systemViewHolder, communMessage);
            } else if (entitySystem.getFirstSysOPTType() == systemOPTType && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C329) {
                A0(systemViewHolder);
            } else if (entitySystem.getFirstSysOPTType() == systemOPTType && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C10000) {
                n0(systemViewHolder);
            } else if (entitySystem.getFirstSysOPTType() == systemOPTType && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C10001) {
                o0(systemViewHolder, entitySystem);
            }
        }
        S1(i2, systemViewHolder.userImg, systemViewHolder.llRootAnima, z2, systemViewHolder.timeLayout, true);
    }

    public final void M1(ChatViewHolder chatViewHolder) {
        chatViewHolder.tv_reply_msg.setVisibility(8);
        chatViewHolder.miv_reply_user_picture.setVisibility(8);
        chatViewHolder.rl_reply_video.setVisibility(8);
        chatViewHolder.ll_reply_voice.setVisibility(8);
    }

    public final Pattern N(String str, String str2, EntityPattern entityPattern) {
        Pattern pattern = new Pattern(str);
        pattern.setName(entityPattern.getName());
        if (!TextUtils.isEmpty(str2)) {
            pattern.setData(str2);
        }
        pattern.setToyVersion(entityPattern.getToyVersion());
        pattern.setCreator(WearUtils.y.r());
        pattern.setEmail(WearUtils.y.r());
        pattern.setAuthor(WearUtils.y.u().getUserName());
        pattern.setTimer(WearUtils.Q(entityPattern.getTime()));
        pattern.setToyFunc(entityPattern.getFeature());
        if (pattern.getHead() != null && !WearUtils.e1(pattern.getHead().getToys()) && pattern.getHead().getToys().equalsIgnoreCase(Toy.TOY_XMACHINE)) {
            pattern.setToyFeature(Toy.TOY_FEATURE_XMACHINE);
        }
        return pattern;
    }

    public final void N0(UnsupportViewHolder unsupportViewHolder, CommunMessage communMessage, DataEntityAbstract dataEntityAbstract, int i2, boolean z2) {
        unsupportViewHolder.messageBlur.setVisibility(8);
        unsupportViewHolder.messageGlass.setVisibility(8);
        mz1 mz1VarF = nz1.e().f();
        if (z2) {
            G1(unsupportViewHolder.userMessage, mz1VarF.y());
            unsupportViewHolder.userMessage.setTextColor(mz1VarF.K());
        } else {
            G1(unsupportViewHolder.userMessage, mz1VarF.g0());
            unsupportViewHolder.userMessage.setTextColor(mz1VarF.h0());
        }
        if (this.q.F(communMessage.getId())) {
            unsupportViewHolder.userMessage.setOneUpdateToDraw(true);
        }
        unsupportViewHolder.userMessage.setText("\u3000  " + ah4.e(R.string.chat_message_old_version_tip));
        unsupportViewHolder.userMessage.invalidate();
        unsupportViewHolder.flUserMessage.invalidate();
        V1(unsupportViewHolder.userImg, communMessage, z2 ? this.p : this.g.C());
        if (z2 || this.j == null || !(unsupportViewHolder.llRootAnima.getTag() instanceof ValueAnimator)) {
            return;
        }
        ((ValueAnimator) unsupportViewHolder.llRootAnima.getTag()).end();
    }

    public final void N1(CommunMessage communMessage, ChatViewHolder chatViewHolder) {
        chatViewHolder.tv_reply_msg.setVisibility(8);
        chatViewHolder.miv_reply_user_picture.setVisibility(0);
        chatViewHolder.rl_reply_video.setVisibility(8);
        chatViewHolder.ll_reply_voice.setVisibility(8);
        EntityPicture entityPicture = new EntityPicture(communMessage.getData());
        String url = entityPicture.getUrl();
        String localUrl = entityPicture.getLocalUrl();
        String str = "setReplyPicture url: " + entityPicture.getUrl();
        String str2 = "setReplyPicture url: " + entityPicture.getLocalUrl();
        String type = entityPicture.getType();
        boolean z2 = !WearUtils.e1(type) && type.equals("emoji");
        this.q.F(communMessage.getId());
        if (!WearUtils.e1(localUrl) && (WearUtils.c0(localUrl).exists() || WearUtils.Z(localUrl).exists() || WearUtils.a0(localUrl).exists())) {
            ImageLoader.getInstance().displayImage(Uri.fromFile(z2 ? WearUtils.Z(localUrl).exists() ? WearUtils.Z(localUrl) : WearUtils.a0(localUrl) : WearUtils.c0(localUrl)).toString(), chatViewHolder.miv_reply_user_picture, MyApplication.Y, new u(chatViewHolder, communMessage));
            return;
        }
        if (WearUtils.e1(url)) {
            return;
        }
        ImageLoader imageLoader = ImageLoader.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append(WearUtils.e);
        sb.append(z2 ? url.replace("thum_", "") : url);
        imageLoader.displayImage(sb.toString(), chatViewHolder.miv_reply_user_picture, MyApplication.Y, new w(z2, url, chatViewHolder, communMessage));
    }

    public final void O(EntityAlarm entityAlarm, CommunMessage communMessage) throws ParseException {
        if (this.f instanceof ChatRoomActivity) {
            EventBus.getDefault().post(new PatternOrAlarmSaveEvent(communMessage, 2, this.g.C().getId()));
        } else {
            F1(entityAlarm, communMessage);
        }
    }

    public final void O0(VMCardViewHolder vMCardViewHolder, CommunMessage communMessage, DataEntityAbstract dataEntityAbstract, int i2, boolean z2) {
        final EntityVMShareCard entityVMShareCard = (EntityVMShareCard) dataEntityAbstract;
        mz1 mz1VarF = nz1.e().f();
        kf.v(this.f).v(entityVMShareCard.getCover()).A0(vMCardViewHolder.iv_img);
        vMCardViewHolder.tvTitle.setText(entityVMShareCard.getTitle());
        vMCardViewHolder.tvDes.setText(entityVMShareCard.getSubTitle());
        V1(vMCardViewHolder.userImg, communMessage, z2 ? this.p : this.g.C());
        if (z2) {
            G1(vMCardViewHolder.llyVm, mz1VarF.h());
            vMCardViewHolder.tvTitle.setTextColor(mz1VarF.n());
        } else {
            G1(vMCardViewHolder.llyVm, mz1VarF.c0());
            vMCardViewHolder.tvTitle.setTextColor(mz1VarF.b());
        }
        vMCardViewHolder.llyVm.setOnClickListener(new View.OnClickListener() { // from class: dc.wk1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.f1(entityVMShareCard, view);
            }
        });
        S1(i2, vMCardViewHolder.userImg, vMCardViewHolder.llRootAnima, z2, vMCardViewHolder.timeLayout, false);
    }

    public final void O1(CommunMessage communMessage, ChatViewHolder chatViewHolder) {
        chatViewHolder.tv_reply_msg.setVisibility(8);
        chatViewHolder.miv_reply_user_picture.setVisibility(8);
        chatViewHolder.rl_reply_video.setVisibility(0);
        chatViewHolder.ll_reply_voice.setVisibility(8);
        EntityShortVideo entityShortVideo = new EntityShortVideo(communMessage.getData());
        String picUrl = entityShortVideo.getPicUrl();
        String picLocalUrl = entityShortVideo.getPicLocalUrl();
        chatViewHolder.miv_reply_user_video_picture.setOnClickListener(new z(communMessage, entityShortVideo));
        chatViewHolder.cl_reply.setOnClickListener(new a0(communMessage, entityShortVideo));
        ViewGroup.LayoutParams layoutParams = chatViewHolder.miv_reply_user_video_picture.getLayoutParams();
        if (entityShortVideo.getPicH() > entityShortVideo.getPicW()) {
            layoutParams.height = ce3.a(this.f, 70.0f);
            layoutParams.width = ce3.a(this.f, 39.0f);
            chatViewHolder.miv_reply_user_video_picture.setLayoutParams(layoutParams);
        }
        this.q.F(communMessage.getId());
        if (!WearUtils.e1(picLocalUrl) && (WearUtils.c0(picLocalUrl).exists() || WearUtils.Z(picLocalUrl).exists() || WearUtils.a0(picLocalUrl).exists())) {
            ImageLoader.getInstance().displayImage(Uri.fromFile(WearUtils.c0(picLocalUrl)).toString(), chatViewHolder.miv_reply_user_video_picture, MyApplication.Y, new b0(this, chatViewHolder));
        } else {
            if (WearUtils.e1(picUrl)) {
                return;
            }
            ImageLoader.getInstance().displayImage(WearUtils.e + picUrl, chatViewHolder.miv_reply_user_video_picture, MyApplication.Y, new c0(this, picUrl, chatViewHolder));
        }
    }

    public final void P(final CommunMessage communMessage, final EntityPattern entityPattern, final PatternViewHolder patternViewHolder, final v0 v0Var) {
        nf3.b(entityPattern.getUrl(), new nf3.d() { // from class: dc.bl1
            @Override // dc.nf3.d
            public final void onRequestComplete(String str) throws IOException {
                this.a.X0(communMessage, entityPattern, patternViewHolder, v0Var, str);
            }
        });
    }

    public final void P0(final WishListViewHolder wishListViewHolder, CommunMessage communMessage, DataEntityAbstract dataEntityAbstract, int i2, boolean z2) {
        final EntityWishList entityWishList = (EntityWishList) dataEntityAbstract;
        mz1 mz1VarF = nz1.e().f();
        V1(wishListViewHolder.userImg, communMessage, z2 ? this.p : this.g.C());
        String str = String.format(ah4.e(R.string.wish_list_titile), entityWishList.getWishListName());
        if (WearUtils.e1(entityWishList.getWishListDesc())) {
            wishListViewHolder.giftCardLine.setVisibility(4);
            wishListViewHolder.wishListDescription.setVisibility(8);
        } else {
            wishListViewHolder.wishListDescription.setText(entityWishList.getWishListDesc());
        }
        if (z2) {
            wishListViewHolder.rootView.setBackgroundResource(mz1VarF.h());
            wishListViewHolder.giftCardLine.setBackgroundResource(mz1VarF.L());
        } else {
            wishListViewHolder.rootView.setBackgroundResource(mz1VarF.c0());
            wishListViewHolder.giftCardLine.setBackgroundResource(mz1VarF.e0());
            wishListViewHolder.wishListDescription.setTextColor(mz1VarF.M());
        }
        wishListViewHolder.wishListName.setText(str);
        wishListViewHolder.rootView.setOnClickListener(new View.OnClickListener() { // from class: dc.dl1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.h1(entityWishList, wishListViewHolder, view);
            }
        });
        wishListViewHolder.rootView.addOnLayoutChangeListener(new n0(wishListViewHolder, communMessage));
        S1(i2, wishListViewHolder.userImg, wishListViewHolder.llRootAnima, z2, wishListViewHolder.timeLayout, false);
    }

    public final void P1(CommunMessage communMessage, ChatViewHolder chatViewHolder) {
        if (WearUtils.e1(communMessage.getReplyData())) {
            return;
        }
        chatViewHolder.cl_reply.setOnClickListener(null);
        if (communMessage.getReplyData().equals("delete")) {
            chatViewHolder.tv_reply_msg.setVisibility(0);
            chatViewHolder.miv_reply_user_picture.setVisibility(8);
            chatViewHolder.rl_reply_video.setVisibility(8);
            chatViewHolder.tv_reply_msg.setText(R.string.notification_reply_content_deleted);
            chatViewHolder.ll_reply_voice.setVisibility(8);
        }
        if (communMessage.getReplyData().equals("recall")) {
            chatViewHolder.tv_reply_msg.setVisibility(0);
            chatViewHolder.miv_reply_user_picture.setVisibility(8);
            chatViewHolder.rl_reply_video.setVisibility(8);
            chatViewHolder.tv_reply_msg.setText(R.string.notification_reply_content_recalled);
            chatViewHolder.ll_reply_voice.setVisibility(8);
        }
    }

    public final void Q(ChatViewHolder chatViewHolder, String str, int i2, boolean z2) {
        WearUtils.E0(true, str, new s(i2, chatViewHolder, z2));
    }

    public void Q0() {
        View view = this.v;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public final void Q1(EntityAudio entityAudio, View view) {
        view.setPadding(0, 0, !T0(entityAudio) ? (int) (((this.f.getResources().getDimensionPixelSize(R.dimen.activity_msg_max_lenth) - this.f.getResources().getDimensionPixelSize(R.dimen.activity_msg_min_lenth)) / 60) * entityAudio.getTime()) : 0, 0);
    }

    public final String R(String str) {
        if (WearUtils.e1(str)) {
            return str;
        }
        String strF = nd3.f(str);
        return WearUtils.e1(strF) ? str : strF;
    }

    public final void R0(mz1 mz1Var, BaseViewHolder baseViewHolder, boolean z2) {
    }

    public final void R1(BaseViewHolder baseViewHolder, CommunMessage communMessage, int i2, int i3) {
        R0(nz1.e().f(), baseViewHolder, 1024 == i3);
        if (1024 == i3) {
            if (baseViewHolder instanceof ShortVideoSelfViewHolder) {
                ShortVideoSelfViewHolder shortVideoSelfViewHolder = (ShortVideoSelfViewHolder) baseViewHolder;
                String str = "isSending = " + communMessage.isSendIng() + "& status " + communMessage.getSendStatus();
                shortVideoSelfViewHolder.flChatProgress.setVisibility(communMessage.isSendIng() ? 0 : 8);
                shortVideoSelfViewHolder.videoProgressBar.setVisibility(communMessage.isSendIng() ? 0 : 8);
                shortVideoSelfViewHolder.playIcon.setVisibility(communMessage.isSendIng() ? 8 : 0);
            } else if (baseViewHolder instanceof PictureSelfViewHolder) {
                PictureSelfViewHolder pictureSelfViewHolder = (PictureSelfViewHolder) baseViewHolder;
                pictureSelfViewHolder.flChatProgress.setVisibility(communMessage.isSendIng() ? 0 : 8);
                pictureSelfViewHolder.videoProgressBar.setVisibility(communMessage.isSendIng() ? 0 : 8);
            } else {
                View viewB = baseViewHolder.b();
                if (viewB != null) {
                    if (communMessage.isSendIng()) {
                        viewB.setVisibility(0);
                    } else {
                        viewB.setVisibility(8);
                    }
                }
            }
            ImageView imageViewA = baseViewHolder.a();
            if (imageViewA != null) {
                imageViewA.setVisibility(8);
                if (K(communMessage.getId(), i2)) {
                    imageViewA.setVisibility(0);
                    imageViewA.setOnClickListener(null);
                    return;
                }
                if (communMessage.getSendStatus() == 4) {
                    if (communMessage.getType().equals(MessageType.live) || communMessage.getType().equals(MessageType.sync) || communMessage.getType().equals(MessageType.video) || communMessage.getType().equals(MessageType.voice)) {
                        imageViewA.setVisibility(8);
                        imageViewA.setOnClickListener(null);
                    } else {
                        imageViewA.setVisibility(0);
                        imageViewA.setOnClickListener(new o0(this, communMessage));
                    }
                }
            }
        }
    }

    public final int S(boolean z2, boolean z3) {
        mz1 mz1VarF = nz1.e().f();
        return z2 ? z3 ? mz1VarF.g() : mz1VarF.B() : z3 ? mz1VarF.V() : mz1VarF.S();
    }

    public final ViewGroup.LayoutParams S0(View view, boolean z2, boolean z3, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams;
        if (!z2 || z3) {
            int iA = ce3.a(this.f, z3 ? 122.0f : 180.0f);
            int iA2 = ce3.a(this.f, z3 ? 91.0f : 80.0f);
            if (z3) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA, iA2);
                view.setLayoutParams(layoutParams2);
                return layoutParams2;
            }
            if (i2 >= i3) {
                if (i2 >= iA) {
                    int i4 = (i3 * iA) / i2;
                    layoutParams = i4 < iA2 ? new RelativeLayout.LayoutParams(iA, iA2) : new RelativeLayout.LayoutParams(iA, i4);
                } else {
                    layoutParams = i3 <= iA2 ? new RelativeLayout.LayoutParams((i2 * iA2) / i3, iA2) : new RelativeLayout.LayoutParams(i2, i3);
                }
            } else if (i3 >= iA) {
                int i5 = (i2 * iA) / i3;
                layoutParams = i5 < iA2 ? new RelativeLayout.LayoutParams(iA2, iA) : new RelativeLayout.LayoutParams(i5, iA);
            } else {
                layoutParams = i2 <= iA2 ? new RelativeLayout.LayoutParams(iA2, (i3 * iA2) / i2) : new RelativeLayout.LayoutParams(i2, i3);
            }
        } else {
            int iA3 = ce3.a(this.f, 122.0f);
            int iA4 = ce3.a(this.f, 90.0f);
            layoutParams = i2 > iA3 ? new RelativeLayout.LayoutParams(iA3, (i3 * iA3) / i2) : i2 < iA4 ? new RelativeLayout.LayoutParams(iA4, i3 * Math.round((iA4 * 1.0f) / i2)) : new RelativeLayout.LayoutParams(i2, i3);
        }
        view.setLayoutParams(layoutParams);
        return layoutParams;
    }

    public void S1(int i2, ImageView imageView, View view, boolean z2, RelativeLayout relativeLayout, boolean z3) {
        List<CommunMessage> list = this.e;
        if (list == null || list.size() == 0) {
            return;
        }
        if (i2 < this.e.size() - 1) {
            int itemViewType = getItemViewType(i2);
            int i3 = i2 + 1;
            int itemViewType2 = getItemViewType(i3);
            String realFrom = this.e.get(i2).getRealFrom();
            String realFrom2 = this.e.get(i3).getRealFrom();
            MessageType type = this.e.get(i2).getType();
            MessageType messageType = MessageType.system;
            boolean z4 = type == messageType;
            boolean z5 = this.e.get(i3).getType() == messageType;
            int i4 = itemViewType & 3072;
            int i5 = itemViewType2 & 3072;
            if (z4) {
                if (z5) {
                    view.setPadding(0, ce3.a(this.f, 3.0f), 0, 0);
                    return;
                } else {
                    view.setPadding(0, ce3.a(this.f, 16.0f), 0, 0);
                    return;
                }
            }
            if (z5) {
                view.setPadding(0, ce3.a(this.f, 16.0f), 0, 0);
                return;
            }
            if (i4 != i5) {
                if (z2) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setVisibility(0);
                }
                view.setPadding(0, ce3.a(this.f, 16.0f), 0, 0);
            } else if (z2) {
                imageView.setVisibility(8);
                view.setPadding(0, ce3.a(this.f, 3.0f), 0, 0);
            } else if (relativeLayout.getVisibility() == 0) {
                imageView.setVisibility(0);
                view.setPadding(0, ce3.a(this.f, 16.0f), 0, 0);
            } else if (itemViewType == itemViewType2 || itemViewType2 != 2056) {
                Activity activity = this.f;
                if (activity == null || !(activity instanceof ChatRoomActivity)) {
                    imageView.setVisibility(4);
                    view.setPadding(0, ce3.a(this.f, 3.0f), 0, 0);
                } else if (WearUtils.e1(realFrom) || WearUtils.e1(realFrom2) || !realFrom.equals(realFrom2)) {
                    imageView.setVisibility(0);
                    view.setPadding(0, ce3.a(this.f, 16.0f), 0, 0);
                } else {
                    imageView.setVisibility(4);
                    view.setPadding(0, ce3.a(this.f, 3.0f), 0, 0);
                }
            } else {
                imageView.setVisibility(0);
                view.setPadding(0, ce3.a(this.f, 16.0f), 0, 0);
            }
        } else if (z2) {
            imageView.setVisibility(8);
            view.setPadding(0, ce3.a(this.f, 16.0f), 0, 0);
        } else {
            imageView.setVisibility(0);
            view.setPadding(0, ce3.a(this.f, 16.0f), 0, 0);
        }
        if (z3) {
            imageView.setVisibility(8);
        }
    }

    public View T(String str) {
        return this.m.get(str);
    }

    public final boolean T0(EntityAudio entityAudio) {
        boolean zIsExpired = entityAudio.isExpired();
        if (zIsExpired) {
            if (WearUtils.h(true, entityAudio.getUrl())) {
                return false;
            }
            return zIsExpired;
        }
        if (WearUtils.h(true, entityAudio.getUrl())) {
            return zIsExpired;
        }
        return true;
    }

    public final void T1(ChatViewHolder chatViewHolder, CommunMessage communMessage, EntityChat entityChat, final boolean z2) {
        if (!this.s.D(entityChat.getText()) || !WearUtils.e1(communMessage.getReplyData())) {
            chatViewHolder.fl_emoji.setVisibility(8);
            chatViewHolder.flUserMessage.setVisibility(0);
            chatViewHolder.userMessage.setUrlText(this.s, entityChat.getText(), z2, new HttpTextView.a() { // from class: dc.sk1
                @Override // com.wear.util.HttpTextView.a
                public final void a(boolean z3, String str) {
                    this.a.r1(z2, z3, str);
                }
            });
            return;
        }
        chatViewHolder.fl_emoji.setVisibility(0);
        chatViewHolder.flUserMessage.setVisibility(8);
        File fileR = this.s.r(entityChat.getText());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) chatViewHolder.fl_emoji.getLayoutParams();
        if (fileR == null || !fileR.exists()) {
            chatViewHolder.iv_emoji.setImageBitmap(this.s.F(entityChat.getText()));
            layoutParams.width = ce3.a(this.f, 28.0f);
            layoutParams.height = ce3.a(this.f, 28.0f);
        } else {
            kf.v(this.f).s(fileR).A0(chatViewHolder.iv_emoji);
            layoutParams.width = ce3.a(this.f, 68.0f);
            layoutParams.height = ce3.a(this.f, 68.0f);
        }
        chatViewHolder.fl_emoji.setLayoutParams(layoutParams);
        String strS = this.s.s(entityChat.getText(), false);
        chatViewHolder.lottieView.g();
        if (TextUtils.isEmpty(strS) || !communMessage.isShowEmojiAnim()) {
            chatViewHolder.iv_emoji.setVisibility(0);
            chatViewHolder.lottieView.setVisibility(8);
            return;
        }
        chatViewHolder.iv_emoji.setVisibility(8);
        chatViewHolder.lottieView.setVisibility(0);
        this.s.O(chatViewHolder.lottieView, strS);
        communMessage.setShowEmojiAnim(false);
        vg3.b().a(new p(this, communMessage));
    }

    public final void U(Pattern pattern, CommunMessage communMessage, EntityPattern entityPattern, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("pattern", pattern);
        if (!WearUtils.e1(str)) {
            bundle.putString("roomId", str);
        }
        if (TextUtils.equals("group_chat", str2)) {
            bundle.putString("msgId", communMessage.getMsgId());
        }
        bundle.putString("from", str2);
        bundle.putSerializable("message", communMessage);
        bundle.putSerializable("itemPattern", entityPattern);
        pj3.g(this.f, PatternPlayActivity.class, bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean U0() {
        /*
            r3 = this;
            dc.ch3 r0 = com.wear.util.WearUtils.y
            dc.sa2 r1 = r3.g
            com.wear.bean.handlerbean.IPeopleInfo r1 = r1.C()
            java.lang.String r1 = r1.getId()
            com.wear.bean.UserSetting r0 = r0.z(r1)
            r1 = 0
            if (r0 == 0) goto L27
            java.lang.Boolean r0 = r0.getAudioVibration()
            boolean r0 = r0.booleanValue()
            dc.sa2 r2 = r3.g
            com.wear.bean.handlerbean.IPeopleInfo r2 = r2.C()
            boolean r2 = r2.isDateIng()
            if (r2 == 0) goto L28
        L27:
            r0 = 0
        L28:
            if (r0 == 0) goto L35
            dc.na2 r2 = dc.na2.m()
            boolean r2 = r2.i()
            if (r2 == 0) goto L35
            goto L36
        L35:
            r1 = r0
        L36:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.adapter.longdistance.MessageNewAdapter.U0():boolean");
    }

    public final void U1(ManagerGroupMemberInfoDialog.h hVar, Group group) {
        is3.b bVar = new is3.b(this.f);
        bVar.e(hVar);
        bVar.x(gg3.e(this.f));
        bVar.i(80);
        ManagerGroupMemberInfoDialog managerGroupMemberInfoDialog = (ManagerGroupMemberInfoDialog) cs3.i(bVar, ManagerGroupMemberInfoDialog.class);
        managerGroupMemberInfoDialog.show();
        managerGroupMemberInfoDialog.setReportListener(new k0(managerGroupMemberInfoDialog));
        managerGroupMemberInfoDialog.setListener(new l0(this, group));
    }

    public final void V(final ChatViewHolder chatViewHolder, final CommunMessage communMessage, EntityChat entityChat, final int i2, boolean z2) {
        chatViewHolder.messageBlur.setVisibility(8);
        chatViewHolder.messageGlass.setVisibility(8);
        final String text = entityChat.getText();
        mz1 mz1VarF = nz1.e().f();
        if (z2) {
            G1(chatViewHolder.ll_user_message, mz1VarF.y());
            chatViewHolder.userMessage.setTextColor(mz1VarF.K());
        } else {
            G1(chatViewHolder.ll_user_message, mz1VarF.g0());
            chatViewHolder.userMessage.setTextColor(mz1VarF.h0());
        }
        chatViewHolder.userMessage.setOnDrawFinish(new GlassText.a() { // from class: dc.gl1
            @Override // com.wear.widget.GlassText.a
            public final void a(int i3, int i4) {
                this.a.Z0(communMessage, chatViewHolder, i2, text, i3, i4);
            }
        });
        if (this.q.F(communMessage.getId())) {
            chatViewHolder.userMessage.setOneUpdateToDraw(true);
        }
    }

    public final String V1(RoundedImageView roundedImageView, CommunMessage communMessage, IPeopleInfo iPeopleInfo) {
        if (iPeopleInfo == null) {
            return "";
        }
        String strM = zb2.O().M(iPeopleInfo.getUserJid());
        if (iPeopleInfo instanceof Group) {
            strM = zb2.O().M(communMessage.getRealFrom());
            if (TextUtils.isEmpty(strM)) {
                strM = communMessage.getRealFromPhoto();
            }
        }
        if (!TextUtils.isEmpty(strM) && !strM.startsWith("http")) {
            strM = WearUtils.e + strM;
        }
        kf.v(this.f).v(strM).a(this.i).A0(roundedImageView);
        roundedImageView.setOnClickListener(new j0(communMessage));
        return strM;
    }

    public final void W(ChatViewHolder chatViewHolder, CommunMessage communMessage, int i2, boolean z2) {
        String showNickName;
        chatViewHolder.cl_reply.setVisibility(0);
        HashMap map = (HashMap) WearUtils.A.fromJson(communMessage.getReplyData(), HashMap.class);
        map.remove("dataBean");
        CommunMessage communMessage2 = (CommunMessage) WearUtils.A.fromJson(WearUtils.A.toJson(map), CommunMessage.class);
        chatViewHolder.cl_reply.setOnLongClickListener(new q(communMessage2, i2));
        String strG0 = WearUtils.g0(R(communMessage2.getFrom()));
        if (strG0.equals(this.p.getId())) {
            showNickName = this.p.getUserName();
        } else {
            String realFromNickName = (WearUtils.e1(communMessage2.getRealFromNickName()) || WearUtils.e1(communMessage2.getRealFromNickName())) ? "" : communMessage2.getRealFromNickName();
            User userV = ch3.n().v(strG0);
            showNickName = userV != null ? WearUtils.e1(userV.getShowNickName()) ? "" : userV.getShowNickName() : realFromNickName;
        }
        mz1 mz1VarF = nz1.e().f();
        if (z2) {
            chatViewHolder.vLeft.setBackgroundColor(mz1VarF.i());
            chatViewHolder.tv_reply_msg.setTextColor(mz1VarF.i());
            chatViewHolder.vLineBottom.setBackgroundColor(mz1VarF.i());
            chatViewHolder.tv_reply_from_name.setTextColor(mz1VarF.C());
        } else {
            chatViewHolder.vLeft.setBackgroundColor(mz1VarF.j0());
            chatViewHolder.vLineBottom.setBackgroundColor(mz1VarF.j0());
            chatViewHolder.tv_reply_msg.setTextColor(mz1VarF.j0());
            chatViewHolder.tv_reply_from_name.setTextColor(mz1VarF.w());
        }
        chatViewHolder.tv_reply_from_name.setText(showNickName);
        int i3 = m0.a[communMessage2.getType().ordinal()];
        if (i3 == 1) {
            L1(chatViewHolder, communMessage2);
            return;
        }
        if (i3 == 5) {
            K1(communMessage2, chatViewHolder, i2, z2);
            return;
        }
        if (i3 == 8) {
            P1(communMessage2, chatViewHolder);
            return;
        }
        if (i3 == 10) {
            N1(communMessage2, chatViewHolder);
        } else if (i3 != 11) {
            M1(chatViewHolder);
        } else {
            O1(communMessage2, chatViewHolder);
        }
    }

    public final void W1(ChatViewHolder chatViewHolder, int i2, int i3, int i4, String str) {
        chatViewHolder.ll_user_message.setDrawingCacheEnabled(true);
        chatViewHolder.ll_user_message.buildDrawingCache();
        try {
            Bitmap drawingCache = chatViewHolder.ll_user_message.getDrawingCache();
            if (drawingCache != null) {
                sd3.a(chatViewHolder.ll_user_message.getContext(), drawingCache.copy(drawingCache.getConfig(), true), chatViewHolder.ll_user_message, 10, chatViewHolder.messageGlass);
                chatViewHolder.messageGlass.setVisibility(0);
            } else {
                chatViewHolder.messageBlur.setVisibility(8);
            }
        } catch (Exception unused) {
        }
    }

    public final void X(SystemViewHolder systemViewHolder, EntitySystem.C10001Json c10001Json) {
        Iterator<EntitySystem.C10001Json.WhoBean> it = c10001Json.getWhos().iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + it.next().getWhoNickName() + "，";
        }
        systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_decline_invitation1), str.substring(0, str.length() - 1)));
    }

    public final void X1(boolean z2, Object obj, String str) {
        this.f.runOnUiThread(new h(obj, z2, str));
    }

    public final void Y(SystemViewHolder systemViewHolder, mz1 mz1Var, EntitySystem.C10001Json c10001Json) {
        Iterator<EntitySystem.C10001Json.WhoBean> it = c10001Json.getWhos().iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + it.next().getWhoNickName() + "，";
        }
        String strSubstring = str.substring(0, str.length() - 1);
        String str2 = String.format(ah4.e(R.string.group_chat_decline_invitation2), strSubstring);
        systemViewHolder.tvSyncMessage.setText(str2);
        SpannableString spannableString = new SpannableString(str2);
        int iIndexOf = str2.indexOf(strSubstring);
        if (iIndexOf != -1) {
            spannableString.setSpan(new ForegroundColorSpan(mz1Var.G()), iIndexOf, strSubstring.length() + iIndexOf, 17);
        }
        for (EntitySystem.C10001Json.WhoBean whoBean : c10001Json.getWhos()) {
            String whoNickName = whoBean.getWhoNickName();
            int iIndexOf2 = str2.indexOf(whoNickName);
            if (iIndexOf2 != -1) {
                spannableString.setSpan(new o(whoNickName, whoBean.getWho()), iIndexOf2, whoNickName.length() + iIndexOf2, 17);
            }
        }
        systemViewHolder.tvSyncMessage.setMovementMethod(LinkMovementMethod.getInstance());
        systemViewHolder.tvSyncMessage.setText(spannableString);
    }

    public final void Y1(WishListViewHolder wishListViewHolder) {
        wishListViewHolder.rootView.setDrawingCacheEnabled(true);
        wishListViewHolder.rootView.buildDrawingCache();
        try {
            Bitmap drawingCache = wishListViewHolder.rootView.getDrawingCache();
            if (drawingCache != null) {
                sd3.a(wishListViewHolder.rootView.getContext(), drawingCache.copy(drawingCache.getConfig(), true), wishListViewHolder.rootView, 10, wishListViewHolder.glassView);
                wishListViewHolder.glassView.setVisibility(0);
            } else {
                wishListViewHolder.glassView.setVisibility(8);
            }
        } catch (Exception unused) {
        }
    }

    public final void Z(SystemViewHolder systemViewHolder, EntitySystem.C10001Json c10001Json) {
        Iterator<EntitySystem.C10001Json.WhoBean> it = c10001Json.getWhos().iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + it.next().getWhoNickName() + "，";
        }
        systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_wrong_version), str.substring(0, str.length() - 1)));
    }

    public final void a0(SystemViewHolder systemViewHolder, EntitySystem.C10001Json c10001Json) {
        Iterator<EntitySystem.C10001Json.WhoBean> it = c10001Json.getWhos().iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + it.next().getWhoNickName() + "，";
        }
        systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_user_unavailable), str.substring(0, str.length() - 1)));
    }

    public final void b0(SystemViewHolder systemViewHolder, EntitySystem.C10001Json c10001Json) {
        String whoNickName = c10001Json.getWhos().get(0).getWhoNickName();
        String str = String.format(ah4.e(R.string.group_chat_added_member2), c10001Json.getByWhoNickName(), whoNickName);
        String str2 = String.format(ah4.e(R.string.group_chat_stranger_member), whoNickName);
        systemViewHolder.tvSyncMessage.setText(str + " . " + str2);
    }

    public final void c0(SystemViewHolder systemViewHolder, EntitySystem.C10001Json c10001Json) {
        String whoNickName = c10001Json.getWhos().get(0).getWhoNickName();
        String str = String.format(ah4.e(R.string.group_chat_joined), whoNickName);
        String str2 = String.format(ah4.e(R.string.group_chat_stranger_member), whoNickName);
        systemViewHolder.tvSyncMessage.setText(str + str2);
    }

    public final void d0(SystemViewHolder systemViewHolder, EntitySystem.C10001Json c10001Json) {
        if (c10001Json.getByWho().equals(ch3.n().p())) {
            systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.group_chat_created2));
        } else {
            systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_created1), c10001Json.getByWhoNickName()));
        }
    }

    public final void e0(SystemViewHolder systemViewHolder, EntitySystem.C10001Json c10001Json) {
        EntitySystem.C10001Json.WhoBean whoBean = c10001Json.getWhos().get(0);
        if (whoBean.getWho().equals(ch3.n().p())) {
            systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_make_admin1), c10001Json.getByWhoNickName()));
        } else {
            systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_make_admin2), c10001Json.getByWhoNickName(), whoBean.getWhoNickName()));
        }
    }

    public final void f0(SystemViewHolder systemViewHolder, EntitySystem.C10001Json c10001Json) {
        EntitySystem.C10001Json.WhoBean whoBean = c10001Json.getWhos().get(0);
        if (whoBean.getWho().equals(ch3.n().p())) {
            systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_dismiss_admin1), c10001Json.getByWhoNickName()));
        } else {
            systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_dismiss_admin2), c10001Json.getByWhoNickName(), whoBean.getWhoNickName()));
        }
    }

    public final void g0(SystemViewHolder systemViewHolder, EntitySystem.C10001Json c10001Json) {
        EntitySystem.C10001Json.WhoBean whoBean = c10001Json.getWhos().get(0);
        if (whoBean.getWho().equals(ch3.n().p())) {
            systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_removed1), c10001Json.getByWhoNickName()));
        } else {
            systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_removed2), c10001Json.getByWhoNickName(), whoBean.getWhoNickName()));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        return this.e.get(i2).getRealId().hashCode();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        CommunMessage communMessage = this.e.get(i2);
        int i3 = !this.o.equals(WearUtils.X(communMessage.getFrom())) ? 2048 : 1024;
        if (communMessage.getType() != null) {
            switch (m0.a[communMessage.getType().ordinal()]) {
                case 1:
                    return i3 + 1;
                case 2:
                    return i3 + 2;
                case 3:
                    return i3 + 3;
                case 4:
                    return i3 + 4;
                case 5:
                    return i3 + 5;
                case 6:
                    return i3 + 6;
                case 7:
                    return i3 + 7;
                case 8:
                    return i3 + 8;
                case 9:
                    return i3 + 9;
                case 10:
                    return i3 + 10;
                case 11:
                    return i3 + 11;
                case 12:
                    return i3 + 12;
                case 13:
                    return i3 + 16;
                case 14:
                    return i3 + 17;
                case 15:
                    return i3 + 13;
                case 16:
                    return i3 + 14;
                case 17:
                    return i3 + 15;
            }
        }
        return i3 + 0;
    }

    public final void h0(SystemViewHolder systemViewHolder, EntitySystem.C10001Json c10001Json) {
        EntitySystem.C10001Json.WhoBean whoBean = c10001Json.getWhos().get(0);
        if (whoBean.getWho().equals(ch3.n().p())) {
            systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_added_member1), c10001Json.getByWhoNickName()));
        } else {
            systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_added_member2), c10001Json.getByWhoNickName(), whoBean.getWhoNickName()));
        }
    }

    public final void i0(SystemViewHolder systemViewHolder, EntitySystem.C10001Json c10001Json) {
        systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_joined), c10001Json.getWhos().get(0).getWhoNickName()));
    }

    public final void j0(SystemViewHolder systemViewHolder, EntitySystem.C10001Json c10001Json) {
        if (c10001Json.getWhos().get(0).getWho().equals(ch3.n().p())) {
            systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.group_chat_left_note1));
        } else {
            systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_left_note2), c10001Json.getByWhoNickName()));
        }
    }

    public final void k0(SystemViewHolder systemViewHolder, EntitySystem.C10001Json c10001Json) {
        systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_left_note3), c10001Json.getByWhoNickName(), c10001Json.getWhos().get(0).getWhoNickName(), c10001Json.getByWhoNickName()));
    }

    public final void l0(SystemViewHolder systemViewHolder, EntitySystem.C10001Json c10001Json) {
        systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_left_note2), c10001Json.getByWhoNickName()));
    }

    public final void m0(SystemViewHolder systemViewHolder, EntitySystem.C10001Json c10001Json) {
        String strD = nd3.d(c10001Json.getShowList());
        if (WearUtils.e1(strD)) {
            return;
        }
        List array = JSON.parseArray(strD, String.class);
        for (int i2 = 0; i2 < array.size(); i2++) {
            if (!WearUtils.e1(ch3.n().p()) && ch3.n().p().equals(array.get(i2))) {
                jg3.a.a().b(String.format(ah4.e(R.string.group_chat_toast_guidelines), ah4.e(R.string.group_chat_toast_guidelines_link)), ah4.e(R.string.group_chat_toast_guidelines_link), systemViewHolder.tvSyncMessage, this.f);
                systemViewHolder.tvSyncMessage.setGravity(3);
                return;
            }
        }
    }

    public final void n0(SystemViewHolder systemViewHolder) {
        if (TextUtils.isEmpty(this.g.getUserName())) {
            return;
        }
        mz1 mz1VarF = nz1.e().f();
        String str = String.format(ah4.e(R.string.delete_frends_message_tip_1), this.g.getUserName());
        String strE = ah4.e(R.string.delete_frends_message_tip_2);
        SpannableString spannableString = new SpannableString(str + strE + ah4.e(R.string.delete_frends_message_tip_3));
        spannableString.setSpan(new ForegroundColorSpan(mz1VarF.G()), str.length(), str.length() + strE.length(), 17);
        spannableString.setSpan(new n(), str.length(), str.length() + strE.length(), 17);
        systemViewHolder.tvSyncMessage.setMovementMethod(LinkMovementMethod.getInstance());
        systemViewHolder.tvSyncMessage.setText(spannableString);
    }

    public final void o0(SystemViewHolder systemViewHolder, EntitySystem entitySystem) {
        try {
            systemViewHolder.parentLinear.setVisibility(0);
            mz1 mz1VarF = nz1.e().f();
            EntitySystem.C10001Json objectFromJson = entitySystem.getObjectFromJson();
            systemViewHolder.tvSyncMessage.setGravity(17);
            int operationType = objectFromJson.getOperationType();
            if (operationType == 110) {
                d0(systemViewHolder, objectFromJson);
            } else if (operationType == 301) {
                j0(systemViewHolder, objectFromJson);
            } else if (operationType == 304) {
                k0(systemViewHolder, objectFromJson);
            } else if (operationType == 306) {
                l0(systemViewHolder, objectFromJson);
            } else if (operationType != 601) {
                switch (operationType) {
                    case 201:
                        e0(systemViewHolder, objectFromJson);
                        break;
                    case 202:
                        f0(systemViewHolder, objectFromJson);
                        break;
                    case 203:
                        g0(systemViewHolder, objectFromJson);
                        break;
                    case 204:
                        h0(systemViewHolder, objectFromJson);
                        break;
                    case 205:
                        i0(systemViewHolder, objectFromJson);
                        break;
                    default:
                        switch (operationType) {
                            case 10000:
                                X(systemViewHolder, objectFromJson);
                                break;
                            case 10001:
                                Y(systemViewHolder, mz1VarF, objectFromJson);
                                break;
                            case RtmConstants.RTM_ERR_EXCEED_JOIN_TOPIC_LIMITATION /* 10002 */:
                                Z(systemViewHolder, objectFromJson);
                                break;
                            case RtmConstants.RTM_ERR_INVALID_TOPIC_NAME /* 10003 */:
                                a0(systemViewHolder, objectFromJson);
                                break;
                            case RtmConstants.RTM_ERR_PUBLISH_TOPIC_MESSAGE_FAILED /* 10004 */:
                                b0(systemViewHolder, objectFromJson);
                                break;
                            case RtmConstants.RTM_ERR_EXCEED_SUBSCRIBE_TOPIC_LIMITATION /* 10005 */:
                                c0(systemViewHolder, objectFromJson);
                                break;
                        }
                }
            } else {
                m0(systemViewHolder, objectFromJson);
            }
        } catch (Exception e2) {
            systemViewHolder.tvSyncMessage.setVisibility(8);
            e2.printStackTrace();
        }
    }

    public final void p0(SystemViewHolder systemViewHolder, boolean z2) {
        if (z2) {
            systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.chat_pattern_sync_own_notice));
        } else {
            systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.chat_pattern_sync_notice));
        }
    }

    public final void q0(SystemViewHolder systemViewHolder, EntitySystem entitySystem) {
        systemViewHolder.tvSyncMessage.setText(WearUtils.e1(entitySystem.getFirstString()) ? "" : entitySystem.getFirstString());
    }

    public final void r0(SystemViewHolder systemViewHolder, EntitySystem entitySystem) {
        String firstString = entitySystem.getFirstString();
        if (!WearUtils.e1(firstString) && firstString.contains("#")) {
            firstString = firstString.substring(0, firstString.indexOf("#"));
        }
        systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.block_frends_message_tip), firstString));
    }

    public final void s0(SystemViewHolder systemViewHolder, CommunMessage communMessage, int i2, boolean z2) {
        mz1 mz1VarF = nz1.e().f();
        systemViewHolder.typingLinear.setVisibility(0);
        systemViewHolder.parentLinear.setGravity(3);
        systemViewHolder.userImg.setVisibility(0);
        systemViewHolder.syncMessageLayout.setVisibility(8);
        G1(systemViewHolder.typingLinear, mz1VarF.g0());
        V1(systemViewHolder.userImg, communMessage, this.g.C());
        String str = "typing/dark/data.json";
        if (MyApplication.m0 == 0 && !MyApplication.l0) {
            str = "typing/light/data.json";
        }
        systemViewHolder.typingAnimation.setAnimation(str);
        systemViewHolder.typingAnimation.r();
        S1(i2, systemViewHolder.userImg, systemViewHolder.parentLinear, z2, systemViewHolder.timeLayout, false);
    }

    public final void s1(String str, View view, Drawable drawable, String str2, CommunMessage communMessage, String str3, ViewGroup.LayoutParams layoutParams) {
        PictureBean pictureBean = new PictureBean();
        pictureBean.url = str3;
        pictureBean.localUrl = str2;
        pictureBean.isHide = this.q.F(communMessage.getId());
        if (communMessage.getType() == MessageType.burnpicture) {
            pictureBean.isBurn = ((EntityBurnPicture) communMessage.getDataBean()).isBurn();
        }
        view.setTag(pictureBean);
        GifImageView gifImageView = new GifImageView(this.f);
        gifImageView.setImageDrawable(drawable);
        gifImageView.setLayoutParams(layoutParams);
        this.a.put(str, gifImageView);
        this.m.put(str, view);
    }

    public final void t0(SystemViewHolder systemViewHolder, CommunMessage communMessage) {
        String showNickName;
        IPeopleInfo iPeopleInfoC = this.g.C();
        showNickName = "";
        if (iPeopleInfoC instanceof Group) {
            GroupMember memberByJid = ((Group) iPeopleInfoC).getMemberByJid(communMessage.getRealFrom());
            showNickName = memberByJid != null ? memberByJid.getNickName() : "";
            if (TextUtils.isEmpty(showNickName)) {
                showNickName = communMessage.getRealFromNickName();
            }
        } else if (this.f != null && this.g.C() != null) {
            showNickName = this.g.C().getShowNickName();
        }
        systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.notification_take_screenshot2), showNickName));
    }

    public final void t1(String str, View view, Bitmap bitmap, String str2, CommunMessage communMessage, String str3, boolean z2, BaseViewHolder baseViewHolder, boolean z3) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if ((baseViewHolder instanceof PictureViewHolder) || (baseViewHolder instanceof ShortVideoViewHolder)) {
            PictureBean pictureBean = new PictureBean();
            pictureBean.url = str3;
            pictureBean.localUrl = str2;
            pictureBean.isHide = this.q.F(communMessage.getId());
            view.setTag(pictureBean);
            if (bitmap == null) {
                ((ImageView) view).setImageResource(R.drawable.ic_picture_placeholder);
                return;
            }
            if (z3) {
                layoutParams2 = new RelativeLayout.LayoutParams(ce3.a(this.f, 140.0f), ce3.a(this.f, 78.0f));
            } else {
                int iA = ce3.a(this.f, 180.0f);
                int iA2 = ce3.a(this.f, 80.0f);
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                ImageSize imageSizeA = MyApplication.X.a(str);
                if (imageSizeA != null && (imageSizeA.getWidth() != width || imageSizeA.getHeight() != height)) {
                    width = imageSizeA.getWidth();
                    height = imageSizeA.getHeight();
                }
                if (width >= height) {
                    if (width >= iA) {
                        int i2 = (height * iA) / width;
                        layoutParams2 = i2 < iA2 ? new RelativeLayout.LayoutParams(iA, iA2) : new RelativeLayout.LayoutParams(iA, i2);
                    } else {
                        layoutParams = height <= iA2 ? new RelativeLayout.LayoutParams((width * iA2) / height, iA2) : new RelativeLayout.LayoutParams(width, height);
                        layoutParams2 = layoutParams;
                    }
                } else if (height >= iA) {
                    int i3 = (width * iA) / height;
                    layoutParams2 = i3 < iA2 ? new RelativeLayout.LayoutParams(iA2, iA) : new RelativeLayout.LayoutParams(i3, iA);
                } else {
                    layoutParams = width <= iA2 ? new RelativeLayout.LayoutParams(iA2, (height * iA2) / width) : new RelativeLayout.LayoutParams(width, height);
                    layoutParams2 = layoutParams;
                }
            }
            if (pictureBean.isHide || z3) {
                Bitmap bitmapCopy = bitmap.copy(bitmap.getConfig(), true);
                int i4 = z3 ? 100 : 25;
                int width2 = bitmapCopy.getWidth();
                int height2 = bitmapCopy.getHeight();
                int[] iArr = new int[width2 * height2];
                bitmapCopy.getPixels(iArr, 0, width2, 0, 0, width2, height2);
                Blur.c(iArr, width2, height2, i4);
                bitmapCopy.setPixels(iArr, 0, width2, 0, 0, width2, height2);
                Blur.b(bitmapCopy, i4);
                ((ImageView) view).setImageBitmap(bitmapCopy);
            }
            ((ImageView) view).setScaleType(z3 ? ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_XY);
            GifImageView gifImageView = new GifImageView(this.f);
            gifImageView.setImageBitmap(bitmap);
            gifImageView.setLayoutParams(layoutParams2);
            this.a.put(str, gifImageView);
            this.u.put(communMessage.getId(), layoutParams2.width + SignatureImpl.INNER_SEP + layoutParams2.height);
            view.setLayoutParams(layoutParams2);
            this.m.put(str, view);
        }
    }

    public final void u0(SystemViewHolder systemViewHolder, EntitySystem entitySystem) {
        String firstSysText = entitySystem.getFirstSysText();
        if (TextUtils.isEmpty(firstSysText)) {
            return;
        }
        systemViewHolder.tvSyncMessage.setText(firstSysText);
    }

    public final void u1(PictureViewHolder pictureViewHolder, CommunMessage communMessage, boolean z2, String str, ViewGroup.LayoutParams layoutParams, qo qoVar, String str2) {
        if (z2) {
            kf.v(this.f).v(str2).X(R.drawable.ic_picture_placeholder).a(qoVar).A0(pictureViewHolder.userPicture);
        } else {
            kf.v(this.f).v(str2).X(R.drawable.ic_picture_placeholder).i0(AsyncHttpRequest.DEFAULT_TIMEOUT).a(qoVar).x0(new s0(pictureViewHolder.userPicture, str2, str, communMessage, layoutParams));
        }
    }

    public final void v0(SystemViewHolder systemViewHolder, CommunMessage communMessage, boolean z2) {
        String showNickName;
        if (z2) {
            systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.chat_sync_recall_owner));
            return;
        }
        showNickName = "";
        IPeopleInfo iPeopleInfoC = this.g.C();
        if (iPeopleInfoC instanceof Group) {
            GroupMember memberByJid = ((Group) iPeopleInfoC).getMemberByJid(communMessage.getRealFrom());
            showNickName = memberByJid != null ? memberByJid.getNickName() : "";
            if (TextUtils.isEmpty(showNickName)) {
                showNickName = communMessage.getRealFromNickName();
            }
        } else if (this.f != null && this.g.C() != null) {
            showNickName = this.g.C().getShowNickName();
        }
        systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.chat_sync_recall_pattern), showNickName));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: v1, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, @SuppressLint({RecyclerView.TAG}) int i2) {
        int i3;
        if (this.c != null && getItemCount() - i2 <= 4 && !this.d) {
            this.c.Z1();
            this.d = true;
        }
        int itemViewType = getItemViewType(i2) & 3072;
        CommunMessage communMessage = this.e.get(i2);
        DataEntityAbstract dataBean = communMessage.getDataBean();
        if (be3.G(communMessage.getCreated())) {
            if (i2 == this.e.size() - 1 || (i2 < this.e.size() - 2 && !be3.B(this.e.get(i2 + 1).getCreated(), communMessage.getCreated(), 1))) {
                baseViewHolder.timeLayout.setVisibility(0);
                baseViewHolder.chatItemTimeCreate.setText(WearUtils.u0(communMessage.getCreated()));
                i3 = 0;
            } else {
                baseViewHolder.timeLayout.setVisibility(8);
                i3 = 8;
            }
        } else if (i2 == this.e.size() - 1 || (i2 < this.e.size() - 2 && !be3.B(this.e.get(i2 + 1).getCreated(), communMessage.getCreated(), 1))) {
            baseViewHolder.timeLayout.setVisibility(0);
            baseViewHolder.chatItemTimeCreate.setText(WearUtils.u0(communMessage.getCreated()));
            i3 = 0;
        } else {
            baseViewHolder.timeLayout.setVisibility(8);
            i3 = 8;
        }
        if (this.b == i2) {
            View view = this.v;
            if (view != null) {
                view.setVisibility(8);
            }
            baseViewHolder.newMessageBar.setVisibility(0);
            this.b = -1;
            this.v = baseViewHolder.newMessageBar;
            i3 = 0;
        } else {
            baseViewHolder.newMessageBar.setVisibility(8);
        }
        baseViewHolder.longChatCreateLayout.setVisibility(i3);
        if (baseViewHolder instanceof ChatViewHolder) {
            E0((ChatViewHolder) baseViewHolder, communMessage, dataBean, i2, 1024 == itemViewType);
        } else if (baseViewHolder instanceof SystemViewHolder) {
            M0((SystemViewHolder) baseViewHolder, communMessage, dataBean, i2, 1024 == itemViewType);
        } else if (baseViewHolder instanceof ControlViewHolder) {
            F0((ControlViewHolder) baseViewHolder, communMessage, dataBean, i2, 1024 == itemViewType);
        } else if (baseViewHolder instanceof AlarmViewHolder) {
            C0((AlarmViewHolder) baseViewHolder, communMessage, dataBean, i2, 1024 == itemViewType);
        } else if (baseViewHolder instanceof PatternViewHolder) {
            J0((PatternViewHolder) baseViewHolder, communMessage, dataBean, i2, 1024 == itemViewType);
        } else if (baseViewHolder instanceof PictureViewHolder) {
            K0((PictureViewHolder) baseViewHolder, communMessage, dataBean, i2, 1024 == itemViewType);
        } else if (baseViewHolder instanceof AudioViewHolder) {
            D0((AudioViewHolder) baseViewHolder, communMessage, dataBean, i2, 1024 == itemViewType);
        } else if (baseViewHolder instanceof ShortVideoViewHolder) {
            L0((ShortVideoViewHolder) baseViewHolder, communMessage, dataBean, i2, 1024 == itemViewType);
        } else if (baseViewHolder instanceof WishListViewHolder) {
            P0((WishListViewHolder) baseViewHolder, communMessage, dataBean, i2, 1024 == itemViewType);
        } else if (baseViewHolder instanceof GiftCardViewHolder) {
            G0((GiftCardViewHolder) baseViewHolder, communMessage, dataBean, i2, 1024 == itemViewType);
        } else if (baseViewHolder instanceof UnsupportViewHolder) {
            N0((UnsupportViewHolder) baseViewHolder, communMessage, dataBean, i2, 1024 == itemViewType);
        } else if (baseViewHolder instanceof VMCardViewHolder) {
            O0((VMCardViewHolder) baseViewHolder, communMessage, dataBean, i2, 1024 == itemViewType);
        }
        k kVar = new k(communMessage, i2);
        View viewD = baseViewHolder.d();
        if (viewD != null) {
            viewD.setOnLongClickListener(kVar);
        }
        if (viewD != null) {
            viewD.setOnTouchListener(new v());
        }
        View viewC = baseViewHolder.c();
        if (viewC != null) {
            viewC.setOnLongClickListener(kVar);
        }
        if (viewC != null) {
            viewC.setOnTouchListener(new g0());
        }
        R1(baseViewHolder, communMessage, i2, itemViewType);
    }

    public final void w0(SystemViewHolder systemViewHolder, CommunMessage communMessage) {
        systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_start_sync_sontrol), communMessage.getRealFromNickName()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: w1, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i2, @NonNull List<Object> list) {
        if (list.isEmpty()) {
            onBindViewHolder(baseViewHolder, i2);
            return;
        }
        int itemViewType = getItemViewType(i2) & 3072;
        CommunMessage communMessage = this.e.get(i2);
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals("sendStatus", it.next().toString())) {
                R1(baseViewHolder, communMessage, i2, itemViewType);
            }
        }
    }

    public final void x0(SystemViewHolder systemViewHolder) {
        systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.group_end_sync_control));
    }

    public final void x1(final CommunMessage communMessage, final EntityPattern entityPattern, PatternViewHolder patternViewHolder) {
        String status = communMessage.getStatus();
        if (WearUtils.e1(status) || xe2.L0().K(status) == null) {
            P(communMessage, entityPattern, patternViewHolder, new v0() { // from class: dc.al1
                @Override // com.wear.adapter.longdistance.MessageNewAdapter.v0
                public final void a(Pattern pattern) {
                    this.a.j1(communMessage, entityPattern, pattern);
                }
            });
            return;
        }
        Pattern patternN = N(status, null, entityPattern);
        B1(patternN);
        U(patternN, communMessage, entityPattern, null, "ChatActivity");
    }

    public final void y0(SystemViewHolder systemViewHolder, CommunMessage communMessage) {
        systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.ds_control_started), communMessage.getRealFromNickName()));
    }

    public final void y1(CommunMessage communMessage, EntityPattern entityPattern, boolean z2) {
        EntityPattern entityPattern2 = (EntityPattern) communMessage.getDataBean();
        if (!z2 || WearUtils.e1(entityPattern2.getLocalUrl())) {
            WearUtils.E0(true, entityPattern2.getUrl(), new b(entityPattern, communMessage));
            return;
        }
        String strI = nd3.i(entityPattern2.getLocalUrl());
        if (WearUtils.e1(strI)) {
            return;
        }
        File file = new File(strI);
        if (L(file)) {
            Pattern patternM = M(file, entityPattern);
            B1(patternM);
            U(patternM, communMessage, entityPattern, this.g.C().getId(), "group_chat");
        }
    }

    public final void z0(SystemViewHolder systemViewHolder) {
        systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.ds_control_ended));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: z1, reason: merged with bridge method [inline-methods] */
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        int i3 = i2 & 3072;
        switch (i2 & (-3073)) {
            case 1:
                return i3 == 1024 ? new ChatSelfViewHolder(this, LayoutInflater.from(this.f).inflate(R.layout.item_chat_self, viewGroup, false)) : new ChatFriendViewHolder(this, LayoutInflater.from(this.f).inflate(R.layout.item_chat_friend, viewGroup, false));
            case 2:
            case 3:
            case 6:
            case 7:
                return i3 == 1024 ? new ControlSelfViewHolder(this, LayoutInflater.from(this.f).inflate(R.layout.item_control_self, viewGroup, false)) : new ControlFriendViewHolder(this, LayoutInflater.from(this.f).inflate(R.layout.item_control_friend, viewGroup, false));
            case 4:
                return i3 == 1024 ? new AlarmSelfViewHolder(this, LayoutInflater.from(this.f).inflate(R.layout.item_alarm_self, viewGroup, false)) : new AlarmFriendViewHolder(this, LayoutInflater.from(this.f).inflate(R.layout.item_alarm_friend, viewGroup, false));
            case 5:
                return i3 == 1024 ? new AudioSelfViewHolder(this, LayoutInflater.from(this.f).inflate(R.layout.item_audio_self, viewGroup, false)) : new AudioFriendViewHolder(this, LayoutInflater.from(this.f).inflate(R.layout.item_audio_friend, viewGroup, false));
            case 8:
                return new SystemViewHolder(this, LayoutInflater.from(this.f).inflate(R.layout.item_system, viewGroup, false));
            case 9:
                return i3 == 1024 ? new PatternSelfViewHolder(this, LayoutInflater.from(this.f).inflate(R.layout.item_pattern_self, viewGroup, false)) : new PatternFriendViewHolder(this, LayoutInflater.from(this.f).inflate(R.layout.item_pattern_friend, viewGroup, false));
            case 10:
            case 14:
                return i3 == 1024 ? new PictureSelfViewHolder(this, LayoutInflater.from(this.f).inflate(R.layout.item_picture_self, viewGroup, false)) : new PictureFriendViewHolder(this, LayoutInflater.from(this.f).inflate(R.layout.item_picture_friend, viewGroup, false));
            case 11:
            case 15:
                return i3 == 1024 ? new ShortVideoSelfViewHolder(this, LayoutInflater.from(this.f).inflate(R.layout.item_short_video_self, viewGroup, false)) : new ShortVideoFriendViewHolder(this, LayoutInflater.from(this.f).inflate(R.layout.item_short_video_friend, viewGroup, false));
            case 12:
                return i3 == 1024 ? new WishListSelfViewHolder(this, LayoutInflater.from(this.f).inflate(R.layout.item_wishlist_self, viewGroup, false)) : new WishListViewHolder(this, LayoutInflater.from(this.f).inflate(R.layout.item_wishlist_friend, viewGroup, false));
            case 13:
                return i3 == 1024 ? new UnsupportSelfViewHolder(this, LayoutInflater.from(this.f).inflate(R.layout.item_unsupport_self, viewGroup, false)) : new UnsupportFriendViewHolder(this, LayoutInflater.from(this.f).inflate(R.layout.item_unsupport_friend, viewGroup, false));
            case 16:
                return i3 == 1024 ? new GiftCardSelfViewHolder(this, LayoutInflater.from(this.f).inflate(R.layout.item_gift_card_self, viewGroup, false)) : new GiftCardFriendViewHolder(this, LayoutInflater.from(this.f).inflate(R.layout.item_gift_card_friend, viewGroup, false));
            case 17:
                return i3 == 1024 ? new VMCardViewHolder(this, LayoutInflater.from(this.f).inflate(R.layout.item_vm_card, viewGroup, false)) : new VMCardViewHolder(this, LayoutInflater.from(this.f).inflate(R.layout.item_vm_card_friend, viewGroup, false));
            default:
                return new DefalutViewHolder(this, LayoutInflater.from(this.f).inflate(R.layout.item_system, viewGroup, false));
        }
    }
}
