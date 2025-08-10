package com.wear.adapter.longdistance;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.wear.bean.AlarmListItems;
import com.wear.bean.ControlLinkBean;
import com.wear.bean.ControlLinkCreatorToyBean;
import com.wear.bean.Group;
import com.wear.bean.Pattern;
import com.wear.bean.PictureBean;
import com.wear.bean.Toy;
import com.wear.bean.User;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.broadcast.AlarmMessagingService;
import com.wear.dao.ControlLinkCommunMessageDao;
import com.wear.dao.DaoUtils;
import com.wear.main.longDistance.alarm.SetAlarmActivity;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntityAlarm;
import com.wear.protocol.EntityAudio;
import com.wear.protocol.EntityChat;
import com.wear.protocol.EntityControlLinkTimer;
import com.wear.protocol.EntityControllink;
import com.wear.protocol.EntityLive;
import com.wear.protocol.EntityPattern;
import com.wear.protocol.EntityPicture;
import com.wear.protocol.EntitySync;
import com.wear.protocol.EntitySystem;
import com.wear.protocol.EntityVideo;
import com.wear.protocol.EntityVoice;
import com.wear.protocol.MessageType;
import com.wear.protocol.controlLink.ControlLinkCommunMessage;
import com.wear.util.HttpTextView;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.ChatEditText;
import com.wear.widget.GlassText;
import com.wear.widget.MyImageView;
import com.wear.widget.dialog.LinkJumpDialog;
import com.wear.widget.roundwidget.SkinRoundAutoLinearLayout;
import com.wear.widget.roundwidget.SkinRoundConstraintLayout;
import dc.ToyControlBuilder;
import dc.ah4;
import dc.be3;
import dc.ce3;
import dc.ch3;
import dc.cu3;
import dc.db2;
import dc.ff3;
import dc.h12;
import dc.hu3;
import dc.ie3;
import dc.kf;
import dc.kn3;
import dc.l22;
import dc.ma2;
import dc.mp1;
import dc.mz1;
import dc.na2;
import dc.nf3;
import dc.nz1;
import dc.pc1;
import dc.qf3;
import dc.qo;
import dc.rf3;
import dc.rq1;
import dc.sd3;
import dc.sg3;
import dc.so3;
import dc.th4;
import dc.ue3;
import dc.uu1;
import dc.vg3;
import dc.xe2;
import dc.z73;
import dc.zt3;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import net.qiujuer.genius.graphics.Blur;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.vcardtemp.VCardManager;
import org.jivesoftware.smackx.vcardtemp.packet.VCard;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/* loaded from: classes3.dex */
public class ControlLinkMessageAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    public final String a;
    public final z73 b;
    public final so3 c;
    public final ie3 d;
    public final ChatEditText e;
    public final boolean g;
    public List<ControlLinkCommunMessage> l;
    public Activity m;
    public ma2 n;
    public w p;
    public x r;
    public LinkJumpDialog s;
    public final HashMap<String, String> f = new HashMap<>();
    public final Handler h = new Handler(Looper.getMainLooper());
    public HashMap<String, GifImageView> i = new HashMap<>();
    public HashMap<String, View> j = new HashMap<>();
    public HashMap<Integer, ImageView> k = new HashMap<>();
    public int o = -1;
    public Handler q = new Handler(Looper.getMainLooper());
    public boolean t = true;

    public class AlarmFriendViewHolder extends AlarmViewHolder {

        @BindView(R.id.alarm_accept)
        public TextView alarmAccept;

        @BindView(R.id.alarm_action_layout)
        public LinearLayout alarmActionLayout;

        @BindView(R.id.alarm_auto_play)
        public TextView alarmAutoPlay;

        @BindView(R.id.alarm_decline)
        public TextView alarmDecline;

        @BindView(R.id.alarm_message)
        public LinearLayout alarmMessage;

        @BindView(R.id.alarm_vertical_line)
        public View alarmVerticalLine;

        public AlarmFriendViewHolder(@NonNull ControlLinkMessageAdapter controlLinkMessageAdapter, View view) {
            super(controlLinkMessageAdapter, view);
        }
    }

    public class AlarmFriendViewHolder_ViewBinding extends AlarmViewHolder_ViewBinding {
        public AlarmFriendViewHolder c;

        @UiThread
        public AlarmFriendViewHolder_ViewBinding(AlarmFriendViewHolder alarmFriendViewHolder, View view) {
            super(alarmFriendViewHolder, view);
            this.c = alarmFriendViewHolder;
            alarmFriendViewHolder.alarmAutoPlay = (TextView) Utils.findRequiredViewAsType(view, R.id.alarm_auto_play, "field 'alarmAutoPlay'", TextView.class);
            alarmFriendViewHolder.alarmDecline = (TextView) Utils.findRequiredViewAsType(view, R.id.alarm_decline, "field 'alarmDecline'", TextView.class);
            alarmFriendViewHolder.alarmAccept = (TextView) Utils.findRequiredViewAsType(view, R.id.alarm_accept, "field 'alarmAccept'", TextView.class);
            alarmFriendViewHolder.alarmActionLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.alarm_action_layout, "field 'alarmActionLayout'", LinearLayout.class);
            alarmFriendViewHolder.alarmMessage = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.alarm_message, "field 'alarmMessage'", LinearLayout.class);
            alarmFriendViewHolder.alarmVerticalLine = Utils.findRequiredView(view, R.id.alarm_vertical_line, "field 'alarmVerticalLine'");
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.AlarmViewHolder_ViewBinding, com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            AlarmFriendViewHolder alarmFriendViewHolder = this.c;
            if (alarmFriendViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.c = null;
            alarmFriendViewHolder.alarmAutoPlay = null;
            alarmFriendViewHolder.alarmDecline = null;
            alarmFriendViewHolder.alarmAccept = null;
            alarmFriendViewHolder.alarmActionLayout = null;
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

        public AlarmSelfViewHolder(@NonNull ControlLinkMessageAdapter controlLinkMessageAdapter, View view) {
            super(controlLinkMessageAdapter, view);
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder
        public ImageView a() {
            return this.blockSync;
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder
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

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.AlarmViewHolder_ViewBinding, com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
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

        @BindView(R.id.user_img)
        public RoundedImageView userImg;

        public AlarmViewHolder(@NonNull ControlLinkMessageAdapter controlLinkMessageAdapter, View view) {
            super(view);
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
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
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
            super.unbind();
        }
    }

    public class AudioFriendViewHolder extends AudioViewHolder {
        public AudioFriendViewHolder(@NonNull ControlLinkMessageAdapter controlLinkMessageAdapter, View view) {
            super(controlLinkMessageAdapter, view);
        }
    }

    public class AudioSelfViewHolder extends AudioViewHolder {

        @BindView(R.id.block_sync)
        public ImageView blockSync;

        @BindView(R.id.loading)
        public ProgressBar loading;

        public AudioSelfViewHolder(@NonNull ControlLinkMessageAdapter controlLinkMessageAdapter, View view) {
            super(controlLinkMessageAdapter, view);
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder
        public ImageView a() {
            return this.blockSync;
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder
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

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.AudioViewHolder_ViewBinding, com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
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

        @BindView(R.id.user_img)
        public RoundedImageView userImg;

        @BindView(R.id.voice_icon)
        public LottieAnimationView voiceIcon;

        @BindView(R.id.voice_play)
        public SkinRoundConstraintLayout voicePlay;

        @BindView(R.id.voice_time)
        public TextView voiceTime;

        public AudioViewHolder(@NonNull ControlLinkMessageAdapter controlLinkMessageAdapter, View view) {
            super(view);
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
            audioViewHolder.llRootAnima = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_root_anima, "field 'llRootAnima'", LinearLayout.class);
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
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
            audioViewHolder.llRootAnima = null;
            super.unbind();
        }
    }

    public static abstract class BaseViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.chat_item_time_create)
        public TextView chatItemTimeCreate;

        @BindView(R.id.long_chat_create_layout)
        public View longChatCreateLayout;

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
    }

    public class BaseViewHolder_ViewBinding implements Unbinder {
        public BaseViewHolder a;

        @UiThread
        public BaseViewHolder_ViewBinding(BaseViewHolder baseViewHolder, View view) {
            this.a = baseViewHolder;
            baseViewHolder.chatItemTimeCreate = (TextView) Utils.findRequiredViewAsType(view, R.id.chat_item_time_create, "field 'chatItemTimeCreate'", TextView.class);
            baseViewHolder.longChatCreateLayout = Utils.findRequiredView(view, R.id.long_chat_create_layout, "field 'longChatCreateLayout'");
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
        }
    }

    public class ChatFriendViewHolder extends ChatViewHolder {
        public ChatFriendViewHolder(@NonNull ControlLinkMessageAdapter controlLinkMessageAdapter, View view) {
            super(controlLinkMessageAdapter, view);
        }
    }

    public class ChatSelfViewHolder extends ChatViewHolder {

        @BindView(R.id.block_sync)
        public ImageView blockSync;

        @BindView(R.id.loading)
        public ProgressBar loading;

        public ChatSelfViewHolder(@NonNull ControlLinkMessageAdapter controlLinkMessageAdapter, View view) {
            super(controlLinkMessageAdapter, view);
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder
        public ImageView a() {
            return this.blockSync;
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder
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

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.ChatViewHolder_ViewBinding, com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
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

        @BindView(R.id.fl_user_message)
        public FrameLayout flUserMessage;

        @BindView(R.id.fl_emoji)
        public FrameLayout fl_emoji;

        @BindView(R.id.iv_emoji)
        public ImageView iv_emoji;

        @BindView(R.id.ll_root_anima)
        public View llRootAnima;

        @BindView(R.id.lottie_view)
        public LottieAnimationView lottieView;

        @BindView(R.id.message_blur)
        public ImageView messageBlur;

        @BindView(R.id.message_glass)
        public ImageView messageGlass;

        @BindView(R.id.user_img)
        public RoundedImageView userImg;

        @BindView(R.id.user_message)
        public HttpTextView userMessage;

        public ChatViewHolder(@NonNull ControlLinkMessageAdapter controlLinkMessageAdapter, View view) {
            super(view);
            this.lottieView.e(this);
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
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
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
            super.unbind();
        }
    }

    public class ControlFriendViewHolder extends ControlViewHolder {
        public ControlFriendViewHolder(@NonNull ControlLinkMessageAdapter controlLinkMessageAdapter, View view) {
            super(controlLinkMessageAdapter, view);
        }
    }

    public class ControlLinkFriendViewHolder extends ControlLinkViewHolder {
        public ControlLinkFriendViewHolder(@NonNull ControlLinkMessageAdapter controlLinkMessageAdapter, View view) {
            super(controlLinkMessageAdapter, view);
        }
    }

    public class ControlLinkSelfViewHolder extends ControlLinkViewHolder {

        @BindView(R.id.block_sync)
        public ImageView blockSync;

        @BindView(R.id.loading)
        public ProgressBar loading;

        public ControlLinkSelfViewHolder(@NonNull ControlLinkMessageAdapter controlLinkMessageAdapter, View view) {
            super(controlLinkMessageAdapter, view);
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder
        public ImageView a() {
            return this.blockSync;
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder
        public View b() {
            return this.loading;
        }
    }

    public class ControlLinkSelfViewHolder_ViewBinding extends ControlLinkViewHolder_ViewBinding {
        public ControlLinkSelfViewHolder c;

        @UiThread
        public ControlLinkSelfViewHolder_ViewBinding(ControlLinkSelfViewHolder controlLinkSelfViewHolder, View view) {
            super(controlLinkSelfViewHolder, view);
            this.c = controlLinkSelfViewHolder;
            controlLinkSelfViewHolder.loading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.loading, "field 'loading'", ProgressBar.class);
            controlLinkSelfViewHolder.blockSync = (ImageView) Utils.findRequiredViewAsType(view, R.id.block_sync, "field 'blockSync'", ImageView.class);
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.ControlLinkViewHolder_ViewBinding, com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            ControlLinkSelfViewHolder controlLinkSelfViewHolder = this.c;
            if (controlLinkSelfViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.c = null;
            controlLinkSelfViewHolder.loading = null;
            controlLinkSelfViewHolder.blockSync = null;
            super.unbind();
        }
    }

    public class ControlLinkTimerViewHolder extends BaseViewHolder {

        @BindView(R.id.tv_stop)
        public TextView tvStop;

        @BindView(R.id.tv_timer)
        public TextView tvTimer;

        @BindView(R.id.tv_timer_tip)
        public TextView tvTimerTip;

        public ControlLinkTimerViewHolder(@NonNull @NotNull ControlLinkMessageAdapter controlLinkMessageAdapter, View view) {
            super(view);
        }
    }

    public class ControlLinkTimerViewHolder_ViewBinding extends BaseViewHolder_ViewBinding {
        public ControlLinkTimerViewHolder b;

        @UiThread
        public ControlLinkTimerViewHolder_ViewBinding(ControlLinkTimerViewHolder controlLinkTimerViewHolder, View view) {
            super(controlLinkTimerViewHolder, view);
            this.b = controlLinkTimerViewHolder;
            controlLinkTimerViewHolder.tvTimer = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_timer, "field 'tvTimer'", TextView.class);
            controlLinkTimerViewHolder.tvStop = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_stop, "field 'tvStop'", TextView.class);
            controlLinkTimerViewHolder.tvTimerTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_timer_tip, "field 'tvTimerTip'", TextView.class);
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            ControlLinkTimerViewHolder controlLinkTimerViewHolder = this.b;
            if (controlLinkTimerViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            controlLinkTimerViewHolder.tvTimer = null;
            controlLinkTimerViewHolder.tvStop = null;
            controlLinkTimerViewHolder.tvTimerTip = null;
            super.unbind();
        }
    }

    public class ControlLinkViewHolder extends BaseViewHolder {

        @BindView(R.id.control_message)
        public LinearLayout control_message;

        @BindView(R.id.rl_toy_0)
        public AppCompatTextView rl_toy_0;

        @BindView(R.id.rl_toy_1)
        public AppCompatTextView rl_toy_1;

        @BindView(R.id.rl_toy_2)
        public AppCompatTextView rl_toy_2;

        @BindView(R.id.tv_control_link_duration)
        public AppCompatTextView tv_control_link_duration;

        @BindView(R.id.tv_control_link_toys)
        public AppCompatTextView tv_control_link_toys;

        @BindView(R.id.user_img)
        public RoundedImageView userImg;

        public ControlLinkViewHolder(@NonNull ControlLinkMessageAdapter controlLinkMessageAdapter, View view) {
            super(view);
        }
    }

    public class ControlLinkViewHolder_ViewBinding extends BaseViewHolder_ViewBinding {
        public ControlLinkViewHolder b;

        @UiThread
        public ControlLinkViewHolder_ViewBinding(ControlLinkViewHolder controlLinkViewHolder, View view) {
            super(controlLinkViewHolder, view);
            this.b = controlLinkViewHolder;
            controlLinkViewHolder.userImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.user_img, "field 'userImg'", RoundedImageView.class);
            controlLinkViewHolder.tv_control_link_toys = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.tv_control_link_toys, "field 'tv_control_link_toys'", AppCompatTextView.class);
            controlLinkViewHolder.tv_control_link_duration = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.tv_control_link_duration, "field 'tv_control_link_duration'", AppCompatTextView.class);
            controlLinkViewHolder.rl_toy_0 = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.rl_toy_0, "field 'rl_toy_0'", AppCompatTextView.class);
            controlLinkViewHolder.rl_toy_1 = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.rl_toy_1, "field 'rl_toy_1'", AppCompatTextView.class);
            controlLinkViewHolder.rl_toy_2 = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.rl_toy_2, "field 'rl_toy_2'", AppCompatTextView.class);
            controlLinkViewHolder.control_message = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.control_message, "field 'control_message'", LinearLayout.class);
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            ControlLinkViewHolder controlLinkViewHolder = this.b;
            if (controlLinkViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            controlLinkViewHolder.userImg = null;
            controlLinkViewHolder.tv_control_link_toys = null;
            controlLinkViewHolder.tv_control_link_duration = null;
            controlLinkViewHolder.rl_toy_0 = null;
            controlLinkViewHolder.rl_toy_1 = null;
            controlLinkViewHolder.rl_toy_2 = null;
            controlLinkViewHolder.control_message = null;
            super.unbind();
        }
    }

    public class ControlSelfViewHolder extends ControlViewHolder {
        public ControlSelfViewHolder(@NonNull ControlLinkMessageAdapter controlLinkMessageAdapter, View view) {
            super(controlLinkMessageAdapter, view);
        }
    }

    public class ControlViewHolder extends BaseViewHolder {

        @BindView(R.id.chat_item_time_create)
        public TextView chatItemTimeCreate;

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

        public ControlViewHolder(@NonNull ControlLinkMessageAdapter controlLinkMessageAdapter, View view) {
            super(view);
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
            controlViewHolder.chatItemTimeCreate = (TextView) Utils.findRequiredViewAsType(view, R.id.chat_item_time_create, "field 'chatItemTimeCreate'", TextView.class);
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
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
            controlViewHolder.chatItemTimeCreate = null;
            super.unbind();
        }
    }

    public class DefalutViewHolder extends BaseViewHolder {
        public DefalutViewHolder(@NonNull ControlLinkMessageAdapter controlLinkMessageAdapter, View view) {
            super(view);
        }
    }

    public class PatternFriendViewHolder extends PatternViewHolder {

        @BindView(R.id.pattern_name)
        public TextView patternName;

        @BindView(R.id.pattern_play)
        public ImageView patternPlay;

        @BindView(R.id.pattern_time_play)
        public TextView patternTimePlay;

        @BindView(R.id.pattern_time_play_x)
        public TextView patternTimePlayX;

        public PatternFriendViewHolder(@NonNull ControlLinkMessageAdapter controlLinkMessageAdapter, View view) {
            super(controlLinkMessageAdapter, view);
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
            patternFriendViewHolder.patternTimePlayX = (TextView) Utils.findRequiredViewAsType(view, R.id.pattern_time_play_x, "field 'patternTimePlayX'", TextView.class);
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.PatternViewHolder_ViewBinding, com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            PatternFriendViewHolder patternFriendViewHolder = this.c;
            if (patternFriendViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.c = null;
            patternFriendViewHolder.patternPlay = null;
            patternFriendViewHolder.patternName = null;
            patternFriendViewHolder.patternTimePlay = null;
            patternFriendViewHolder.patternTimePlayX = null;
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

        @BindView(R.id.pattern_vertical_line)
        public View patternVerticalLine;

        public PatternSelfViewHolder(@NonNull ControlLinkMessageAdapter controlLinkMessageAdapter, View view) {
            super(controlLinkMessageAdapter, view);
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder
        public ImageView a() {
            return this.blockSync;
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder
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
            patternSelfViewHolder.patternVerticalLine = Utils.findRequiredView(view, R.id.pattern_vertical_line, "field 'patternVerticalLine'");
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.PatternViewHolder_ViewBinding, com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            PatternSelfViewHolder patternSelfViewHolder = this.c;
            if (patternSelfViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.c = null;
            patternSelfViewHolder.loading = null;
            patternSelfViewHolder.blockSync = null;
            patternSelfViewHolder.patternResend = null;
            patternSelfViewHolder.patternVerticalLine = null;
            super.unbind();
        }
    }

    public class PatternViewHolder extends BaseViewHolder {
        public String a;

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

        public PatternViewHolder(@NonNull ControlLinkMessageAdapter controlLinkMessageAdapter, View view) {
            super(view);
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
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
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
            super.unbind();
        }
    }

    public class PictureFriendViewHolder extends PictureViewHolder {
        public PictureFriendViewHolder(@NonNull ControlLinkMessageAdapter controlLinkMessageAdapter, View view) {
            super(controlLinkMessageAdapter, view);
        }
    }

    public class PictureSelfViewHolder extends PictureViewHolder {

        @BindView(R.id.block_sync)
        public ImageView blockSync;

        @BindView(R.id.loading)
        public ProgressBar loading;

        public PictureSelfViewHolder(@NonNull ControlLinkMessageAdapter controlLinkMessageAdapter, View view) {
            super(controlLinkMessageAdapter, view);
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder
        public ImageView a() {
            return this.blockSync;
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder
        public View b() {
            return this.loading;
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
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.PictureViewHolder_ViewBinding, com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            PictureSelfViewHolder pictureSelfViewHolder = this.c;
            if (pictureSelfViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.c = null;
            pictureSelfViewHolder.loading = null;
            pictureSelfViewHolder.blockSync = null;
            super.unbind();
        }
    }

    public class PictureViewHolder extends BaseViewHolder {

        @BindView(R.id.user_img)
        public RoundedImageView userImg;

        @BindView(R.id.user_picture)
        public MyImageView userPicture;

        public PictureViewHolder(@NonNull ControlLinkMessageAdapter controlLinkMessageAdapter, View view) {
            super(view);
        }
    }

    public class PictureViewHolder_ViewBinding extends BaseViewHolder_ViewBinding {
        public PictureViewHolder b;

        @UiThread
        public PictureViewHolder_ViewBinding(PictureViewHolder pictureViewHolder, View view) {
            super(pictureViewHolder, view);
            this.b = pictureViewHolder;
            pictureViewHolder.userPicture = (MyImageView) Utils.findRequiredViewAsType(view, R.id.user_picture, "field 'userPicture'", MyImageView.class);
            pictureViewHolder.userImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.user_img, "field 'userImg'", RoundedImageView.class);
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            PictureViewHolder pictureViewHolder = this.b;
            if (pictureViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            pictureViewHolder.userPicture = null;
            pictureViewHolder.userImg = null;
            super.unbind();
        }
    }

    public class SystemViewHolder extends BaseViewHolder {

        @BindView(R.id.sync_message_layout)
        public LinearLayout syncMessageLayout;

        @BindView(R.id.tv_sync_message)
        public TextView tvSyncMessage;

        public SystemViewHolder(@NonNull ControlLinkMessageAdapter controlLinkMessageAdapter, View view) {
            super(view);
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
        }

        @Override // com.wear.adapter.longdistance.ControlLinkMessageAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            SystemViewHolder systemViewHolder = this.b;
            if (systemViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            systemViewHolder.tvSyncMessage = null;
            systemViewHolder.syncMessageLayout = null;
            super.unbind();
        }
    }

    public class a implements View.OnClickListener {
        public final /* synthetic */ EntityPattern a;
        public final /* synthetic */ PatternFriendViewHolder b;
        public final /* synthetic */ ControlLinkCommunMessage c;

        /* renamed from: com.wear.adapter.longdistance.ControlLinkMessageAdapter$a$a, reason: collision with other inner class name */
        public class C0069a implements kn3.d {
            public C0069a(a aVar) {
            }

            @Override // dc.kn3.d
            public void doCancel() {
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
                ControlLinkMessageAdapter.this.b0(z, obj, str2);
            }
        }

        public a(EntityPattern entityPattern, PatternFriendViewHolder patternFriendViewHolder, ControlLinkCommunMessage controlLinkCommunMessage) {
            this.a = entityPattern;
            this.b = patternFriendViewHolder;
            this.c = controlLinkCommunMessage;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (qf3.n(this.a.getUrl(), this.b.a)) {
                qf3.u(0);
                qf3.C();
                return;
            }
            if (na2.m().l()) {
                na2.m().t();
                return;
            }
            if (db2.A().D()) {
                kn3 kn3Var = new kn3((Context) ControlLinkMessageAdapter.this.m, ah4.e(R.string.play_pattern_exist_controllink_notice), ah4.e(R.string.common_cancel), ah4.e(R.string.common_play), false, (kn3.d) new C0069a(this));
                kn3Var.show();
                kn3Var.k();
                kn3Var.q();
                return;
            }
            cu3.h(this.c.getFromId(), this.a.getMsgId());
            this.b.patternTimePlay.setText("00:00");
            this.b.patternTimePlay.setVisibility(0);
            this.b.patternTimePlayX.setVisibility(0);
            qf3.y(this.a.getUrl(), false, 0, this.b.a, this.a.getMsgId(), this.b, new b());
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ EntityPattern a;
        public final /* synthetic */ ControlLinkCommunMessage b;
        public final /* synthetic */ PatternFriendViewHolder c;

        public class a implements nf3.d {

            /* renamed from: com.wear.adapter.longdistance.ControlLinkMessageAdapter$b$a$a, reason: collision with other inner class name */
            public class RunnableC0070a implements Runnable {
                public RunnableC0070a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    b.this.c.patternSave.setEnabled(false);
                    b.this.c.patternSave.setText(ah4.e(R.string.common_saved));
                }
            }

            public a() {
            }

            @Override // dc.nf3.d
            public void onRequestComplete(String str) throws IOException {
                if (WearUtils.e1(str) || str.contains("result")) {
                    sg3.i(ControlLinkMessageAdapter.this.m, R.string.file_notfound);
                    return;
                }
                String strReplace = str.replace("\r", "");
                String status = b.this.b.getStatus();
                if (WearUtils.e1(status)) {
                    status = WearUtils.E();
                }
                if (rf3.o(strReplace)) {
                    strReplace = rf3.r(strReplace);
                }
                WearUtils.m2(strReplace, status);
                Pattern pattern = new Pattern(status);
                pattern.setName(b.this.a.getName());
                pattern.setData(strReplace);
                pattern.setCreator(WearUtils.y.r());
                pattern.setEmail(WearUtils.y.r());
                pattern.setAuthor(WearUtils.y.u().getUserName());
                pattern.setTimer(WearUtils.Q(b.this.a.getTime()));
                pattern.setToyFunc(b.this.a.getFeature());
                if (pattern.getHead() != null && !WearUtils.e1(pattern.getHead().getToys()) && pattern.getHead().getToys().equalsIgnoreCase(Toy.TOY_XMACHINE)) {
                    pattern.setToyFeature(Toy.TOY_FEATURE_XMACHINE);
                }
                xe2.L0().t(pattern, true);
                b.this.b.setStatus(pattern.getId());
                ControlLinkCommunMessage controlLinkCommunMessageFindById = DaoUtils.getControlLinkCommunMessageDao().findById(b.this.b.getId());
                if (controlLinkCommunMessageFindById != null) {
                    controlLinkCommunMessageFindById.setStatus(pattern.getId());
                    DaoUtils.getControlLinkCommunMessageDao().updateOrAdd(controlLinkCommunMessageFindById);
                    if (!WearUtils.e1(DaoUtils.getCommunMessageDao().findById(b.this.b.getId()).getStatus())) {
                        ControlLinkMessageAdapter.this.m.runOnUiThread(new RunnableC0070a());
                    } else {
                        b.this.b.setStatus(null);
                        sg3.i(ControlLinkMessageAdapter.this.m, R.string.chat_save_pattern_failed);
                    }
                }
            }
        }

        public b(EntityPattern entityPattern, ControlLinkCommunMessage controlLinkCommunMessage, PatternFriendViewHolder patternFriendViewHolder) {
            this.a = entityPattern;
            this.b = controlLinkCommunMessage;
            this.c = patternFriendViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WearUtils.e1(this.a.getUrl())) {
                ControlLinkMessageAdapter.this.n.P();
            } else {
                nf3.b(this.a.getUrl(), new a());
            }
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ ControlLinkCommunMessage a;
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
                entityPattern.setName(c.this.b.getName());
                entityPattern.setFeature(c.this.b.getFeature());
                entityPattern.setUrl(c.this.b.getUrl());
                entityPattern.setTime(c.this.b.getTime());
                entityPattern.setLocalUrl(c.this.b.getLocalUrl());
                if (WearUtils.e1(c.this.b.getLocalUrl())) {
                    return;
                }
                ControlLinkMessageAdapter.this.n.M(entityPattern);
                sg3.i(ControlLinkMessageAdapter.this.m, R.string.chat_pattern_resend);
            }
        }

        public c(ControlLinkCommunMessage controlLinkCommunMessage, EntityPattern entityPattern) {
            this.a = controlLinkCommunMessage;
            this.b = entityPattern;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IPeopleInfo iPeopleInfoC = ControlLinkMessageAdapter.this.n.C();
            if ((iPeopleInfoC instanceof Group) && ((Group) iPeopleInfoC).isExit()) {
                sg3.l(ah4.e(R.string.group_chat_exited1));
                return;
            }
            if (this.a.getSendStatus() == 2) {
                ControlLinkMessageAdapter.this.n.P();
            } else {
                if (WearUtils.e1(this.b.getUrl())) {
                    ControlLinkMessageAdapter.this.n.P();
                    return;
                }
                kn3 kn3Var = new kn3((Context) ControlLinkMessageAdapter.this.m, ah4.e(R.string.chat_pattern_resend_notices), ah4.e(R.string.common_yes), ah4.e(R.string.common_no), true, (kn3.d) new a());
                kn3Var.show();
                kn3Var.p();
            }
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ Object a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    ControlLinkMessageAdapter.this.notifyDataSetChanged();
                } catch (Exception e) {
                    FirebaseCrashlytics.getInstance().recordException(e);
                }
            }
        }

        public d(Object obj, boolean z, String str) {
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
                mz1 mz1VarD = nz1.e().d();
                PatternFriendViewHolder patternFriendViewHolder = (PatternFriendViewHolder) this.a;
                String str2 = "getView: " + patternFriendViewHolder.patternPlay.getTag() + "    " + str + "#" + strO;
                if ((str + "#" + strO).equals(patternFriendViewHolder.patternPlay.getTag())) {
                    if (this.b) {
                        ControlLinkMessageAdapter.this.U(patternFriendViewHolder.patternPlay, mz1VarD.q());
                    } else {
                        ControlLinkMessageAdapter.this.U(patternFriendViewHolder.patternPlay, mz1VarD.A());
                        try {
                            ControlLinkMessageAdapter.this.q.post(new a());
                        } catch (Exception e) {
                            FirebaseCrashlytics.getInstance().recordException(e);
                        }
                    }
                    patternFriendViewHolder.patternTimePlay.setText(this.c);
                }
            }
        }
    }

    public class e implements View.OnClickListener {
        public final /* synthetic */ ControlLinkCommunMessage a;
        public final /* synthetic */ EntityAlarm b;

        public e(ControlLinkCommunMessage controlLinkCommunMessage, EntityAlarm entityAlarm) {
            this.a = controlLinkCommunMessage;
            this.b = entityAlarm;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws ParseException {
            this.a.setStatus(AlarmListItems.ALARM_STATUS_REJECT);
            DaoUtils.getControlLinkCommunMessageDao().update((ControlLinkCommunMessageDao) this.a);
            ControlLinkMessageAdapter.this.notifyDataSetChanged();
            String strG0 = WearUtils.g0(this.a.getFromId());
            if (strG0.contains("@")) {
                strG0 = strG0.substring(0, strG0.indexOf("@"));
            }
            try {
                VCard vCardLoadVCard = VCardManager.getInstanceFor(hu3.o).loadVCard(this.a.getFromId());
                if (vCardLoadVCard != null && !WearUtils.e1(vCardLoadVCard.getNickName())) {
                    strG0 = vCardLoadVCard.getNickName();
                }
            } catch (Exception unused) {
            }
            String str = zt3.j + zt3.g + zt3.i + this.b.getId() + zt3.i + (strG0 + zt3.i + this.b.getPattern().getTime());
            EntitySystem entitySystem = new EntitySystem();
            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C202.toString(), str);
            hu3.g0(entitySystem, this.a.getFromId(), MessageType.system, str, null, null);
            AlarmListItems alarmListItemsFindAlarmByreceiveAlarmId = DaoUtils.getAlarmListDao().findAlarmByreceiveAlarmId(this.b.getId());
            if (alarmListItemsFindAlarmByreceiveAlarmId != null) {
                alarmListItemsFindAlarmByreceiveAlarmId.setAccept(2);
                DaoUtils.getAlarmListDao().updateOrAdd(alarmListItemsFindAlarmByreceiveAlarmId);
                zt3.t(ControlLinkMessageAdapter.this.m, alarmListItemsFindAlarmByreceiveAlarmId.getId(), true, true, false);
            }
        }
    }

    public class f implements View.OnClickListener {
        public f(ControlLinkMessageAdapter controlLinkMessageAdapter) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class g implements View.OnClickListener {
        public final /* synthetic */ EntityAlarm a;
        public final /* synthetic */ String b;

        public g(EntityAlarm entityAlarm, String str) {
            this.a = entityAlarm;
            this.b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View viewInflate = LayoutInflater.from(ControlLinkMessageAdapter.this.m).inflate(R.layout.alarm_info_dialog, (ViewGroup) null, false);
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
            kn3 kn3Var = new kn3((Context) ControlLinkMessageAdapter.this.m, (String) null, "", "", true, 320, 0, (kn3.d) null);
            kn3Var.show();
            kn3Var.h(viewInflate);
            kn3Var.e(8);
            kn3Var.i(R.color.transparent);
        }
    }

    public class h implements View.OnClickListener {
        public final /* synthetic */ int a;

        public h(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!MyApplication.P) {
                sg3.k(ControlLinkMessageAdapter.this.m, ah4.e(R.string.common_settingTip));
                return;
            }
            int i = this.a;
            if (i == 0) {
                ControlLinkMessageAdapter.this.n.v();
                return;
            }
            if (i == 1) {
                ControlLinkMessageAdapter.this.n.t();
            } else if (i == 2) {
                ControlLinkMessageAdapter.this.n.q();
            } else if (i == 3) {
                ControlLinkMessageAdapter.this.n.n();
            }
        }
    }

    public class i extends ClickableSpan {
        public i() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            ControlLinkMessageAdapter controlLinkMessageAdapter = ControlLinkMessageAdapter.this;
            controlLinkMessageAdapter.v(controlLinkMessageAdapter.n.C().getId());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    public class j implements GlassText.a {
        public final /* synthetic */ ControlLinkCommunMessage a;
        public final /* synthetic */ ChatViewHolder b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        public j(ControlLinkCommunMessage controlLinkCommunMessage, ChatViewHolder chatViewHolder, int i, String str) {
            this.a = controlLinkCommunMessage;
            this.b = chatViewHolder;
            this.c = i;
            this.d = str;
        }

        @Override // com.wear.widget.GlassText.a
        public void a(int i, int i2) {
            if (!ControlLinkMessageAdapter.this.b.a(this.a.getId())) {
                this.b.messageBlur.setVisibility(8);
                this.b.messageGlass.setVisibility(8);
            } else {
                ControlLinkMessageAdapter controlLinkMessageAdapter = ControlLinkMessageAdapter.this;
                ChatViewHolder chatViewHolder = this.b;
                controlLinkMessageAdapter.Z(chatViewHolder, this.c, chatViewHolder.userMessage.getWidth(), this.b.userMessage.getHeight(), this.d);
                this.b.messageGlass.setVisibility(0);
            }
        }
    }

    public class k implements View.OnClickListener {
        public final /* synthetic */ ControlLinkCommunMessage a;

        public k(ControlLinkCommunMessage controlLinkCommunMessage) {
            this.a = controlLinkCommunMessage;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ControlLinkMessageAdapter.this.r != null) {
                ControlLinkMessageAdapter.this.r.U1(this.a);
            }
        }
    }

    public class l implements View.OnClickListener {
        public final /* synthetic */ mz1 a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ AudioViewHolder c;
        public final /* synthetic */ int d;

        public class a extends ff3 {

            /* renamed from: com.wear.adapter.longdistance.ControlLinkMessageAdapter$l$a$a, reason: collision with other inner class name */
            public class C0071a extends ff3 {
                public final /* synthetic */ boolean a;

                /* renamed from: com.wear.adapter.longdistance.ControlLinkMessageAdapter$l$a$a$a, reason: collision with other inner class name */
                public class RunnableC0072a implements Runnable {
                    public RunnableC0072a() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        ControlLinkMessageAdapter.this.k.clear();
                        l.this.c.voiceIcon.q();
                        l.this.c.voiceIcon.clearAnimation();
                        l lVar = l.this;
                        if (lVar.b) {
                            ControlLinkMessageAdapter.this.U(lVar.c.voiceIcon, lVar.a.i0());
                        } else {
                            ControlLinkMessageAdapter.this.U(lVar.c.voiceIcon, lVar.a.o());
                        }
                    }
                }

                public C0071a(boolean z) {
                    this.a = z;
                }

                @Override // dc.ff3
                public void b(boolean z, Object obj) throws IllegalStateException {
                    int iIntValue = obj != null ? ((Integer) obj).intValue() : -1;
                    System.out.println("temp." + iIntValue);
                    if (iIntValue == -1) {
                        h12.D.isPlayAudio = false;
                        ControlLinkMessageAdapter controlLinkMessageAdapter = ControlLinkMessageAdapter.this;
                        controlLinkMessageAdapter.o = -1;
                        if (this.a) {
                            controlLinkMessageAdapter.c.G();
                            ControlLinkMessageAdapter.this.c.x();
                            pc1.a.u0();
                        }
                        ControlLinkMessageAdapter.this.m.runOnUiThread(new RunnableC0072a());
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
                    l lVar = l.this;
                    lVar.c.voiceIcon.setAnimation(lVar.a.U(lVar.b));
                    StringBuilder sb = new StringBuilder();
                    sb.append("voice_play: ");
                    l lVar2 = l.this;
                    sb.append(lVar2.a.U(lVar2.b));
                    sb.toString();
                    l.this.c.voiceIcon.p(true);
                    l.this.c.voiceIcon.r();
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
            public void b(boolean r5, java.lang.Object r6) throws java.lang.IllegalStateException {
                /*
                    r4 = this;
                    if (r5 == 0) goto Lb9
                    java.io.File r6 = (java.io.File) r6
                    dc.ch3 r5 = com.wear.util.WearUtils.y
                    com.wear.adapter.longdistance.ControlLinkMessageAdapter$l r0 = com.wear.adapter.longdistance.ControlLinkMessageAdapter.l.this
                    com.wear.adapter.longdistance.ControlLinkMessageAdapter r0 = com.wear.adapter.longdistance.ControlLinkMessageAdapter.this
                    dc.ma2 r0 = r0.n
                    com.wear.bean.handlerbean.IPeopleInfo r0 = r0.C()
                    java.lang.String r0 = r0.getId()
                    com.wear.bean.UserSetting r5 = r5.z(r0)
                    r0 = 0
                    if (r5 == 0) goto L33
                    java.lang.Boolean r5 = r5.getAudioVibration()
                    boolean r5 = r5.booleanValue()
                    com.wear.adapter.longdistance.ControlLinkMessageAdapter$l r1 = com.wear.adapter.longdistance.ControlLinkMessageAdapter.l.this
                    com.wear.adapter.longdistance.ControlLinkMessageAdapter r1 = com.wear.adapter.longdistance.ControlLinkMessageAdapter.this
                    dc.ma2 r1 = r1.n
                    com.wear.bean.handlerbean.IPeopleInfo r1 = r1.C()
                    boolean r1 = r1.isDateIng()
                    if (r1 == 0) goto L34
                L33:
                    r5 = 0
                L34:
                    if (r5 == 0) goto L5e
                    dc.na2 r1 = dc.na2.m()
                    boolean r1 = r1.l()
                    if (r1 == 0) goto L41
                    r5 = 0
                L41:
                    if (r5 == 0) goto L5e
                    com.wear.adapter.longdistance.ControlLinkMessageAdapter$l r1 = com.wear.adapter.longdistance.ControlLinkMessageAdapter.l.this
                    com.wear.adapter.longdistance.ControlLinkMessageAdapter r1 = com.wear.adapter.longdistance.ControlLinkMessageAdapter.this
                    dc.so3 r1 = com.wear.adapter.longdistance.ControlLinkMessageAdapter.n(r1)
                    r1.G()
                    com.wear.adapter.longdistance.ControlLinkMessageAdapter$l r1 = com.wear.adapter.longdistance.ControlLinkMessageAdapter.l.this
                    com.wear.adapter.longdistance.ControlLinkMessageAdapter r1 = com.wear.adapter.longdistance.ControlLinkMessageAdapter.this
                    dc.so3 r1 = com.wear.adapter.longdistance.ControlLinkMessageAdapter.n(r1)
                    r1.x()
                    dc.pc1 r1 = dc.pc1.a
                    r1.u0()
                L5e:
                    com.wear.adapter.longdistance.ControlLinkMessageAdapter$l r1 = com.wear.adapter.longdistance.ControlLinkMessageAdapter.l.this
                    com.wear.adapter.longdistance.ControlLinkMessageAdapter r1 = com.wear.adapter.longdistance.ControlLinkMessageAdapter.this
                    dc.so3 r1 = com.wear.adapter.longdistance.ControlLinkMessageAdapter.n(r1)
                    r1.F()
                    com.wear.adapter.longdistance.ControlLinkMessageAdapter$l r1 = com.wear.adapter.longdistance.ControlLinkMessageAdapter.l.this
                    com.wear.adapter.longdistance.ControlLinkMessageAdapter r2 = com.wear.adapter.longdistance.ControlLinkMessageAdapter.this
                    int r3 = r2.o
                    int r1 = r1.d
                    if (r3 != r1) goto L7b
                    r5 = -1
                    r2.o = r5
                    com.wear.bean.event.MusicPlayEvent r5 = dc.h12.D
                    r5.isPlayAudio = r0
                    return
                L7b:
                    com.wear.main.closeRange.music.MusicControl r0 = com.wear.main.closeRange.music.MusicControl.h0()
                    boolean r0 = r0.O()
                    if (r0 == 0) goto L93
                    com.wear.bean.event.MusicPlayEvent r0 = dc.h12.D
                    r1 = 1
                    r0.isPlayAudio = r1
                    org.greenrobot.eventbus.EventBus r0 = org.greenrobot.eventbus.EventBus.getDefault()
                    com.wear.bean.event.MusicPlayEvent r1 = dc.h12.D
                    r0.post(r1)
                L93:
                    com.wear.adapter.longdistance.ControlLinkMessageAdapter$l r0 = com.wear.adapter.longdistance.ControlLinkMessageAdapter.l.this
                    com.wear.adapter.longdistance.ControlLinkMessageAdapter r1 = com.wear.adapter.longdistance.ControlLinkMessageAdapter.this
                    int r0 = r0.d
                    r1.o = r0
                    dc.so3 r0 = com.wear.adapter.longdistance.ControlLinkMessageAdapter.n(r1)
                    java.lang.String r6 = r6.getAbsolutePath()
                    com.wear.adapter.longdistance.ControlLinkMessageAdapter$l$a$a r1 = new com.wear.adapter.longdistance.ControlLinkMessageAdapter$l$a$a
                    r1.<init>(r5)
                    r0.E(r6, r1, r5)
                    com.wear.adapter.longdistance.ControlLinkMessageAdapter$l r5 = com.wear.adapter.longdistance.ControlLinkMessageAdapter.l.this
                    com.wear.adapter.longdistance.ControlLinkMessageAdapter r5 = com.wear.adapter.longdistance.ControlLinkMessageAdapter.this
                    android.app.Activity r5 = r5.m
                    com.wear.adapter.longdistance.ControlLinkMessageAdapter$l$a$b r6 = new com.wear.adapter.longdistance.ControlLinkMessageAdapter$l$a$b
                    r6.<init>()
                    r5.runOnUiThread(r6)
                Lb9:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.wear.adapter.longdistance.ControlLinkMessageAdapter.l.a.b(boolean, java.lang.Object):void");
            }
        }

        public l(mz1 mz1Var, boolean z, AudioViewHolder audioViewHolder, int i) {
            this.a = mz1Var;
            this.b = z;
            this.c = audioViewHolder;
            this.d = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ControlLinkMessageAdapter.this.n.E()) {
                ControlLinkMessageAdapter.this.o = -1;
                return;
            }
            ControlLinkMessageAdapter.this.n.K();
            if (ControlLinkMessageAdapter.this.k.get(0) != null) {
                ControlLinkMessageAdapter controlLinkMessageAdapter = ControlLinkMessageAdapter.this;
                controlLinkMessageAdapter.U(controlLinkMessageAdapter.k.get(0), this.a.i0());
            }
            if (ControlLinkMessageAdapter.this.k.get(1) != null) {
                ControlLinkMessageAdapter controlLinkMessageAdapter2 = ControlLinkMessageAdapter.this;
                controlLinkMessageAdapter2.U(controlLinkMessageAdapter2.k.get(1), this.a.o());
            }
            ControlLinkMessageAdapter.this.k.clear();
            ControlLinkMessageAdapter.this.k.put(Integer.valueOf(!this.b ? 1 : 0), this.c.voiceIcon);
            WearUtils.E0(true, (String) view.getTag(), new a());
        }
    }

    public class m implements Runnable {
        public final /* synthetic */ ControlLinkCommunMessage a;

        public m(ControlLinkMessageAdapter controlLinkMessageAdapter, ControlLinkCommunMessage controlLinkCommunMessage) {
            this.a = controlLinkCommunMessage;
        }

        @Override // java.lang.Runnable
        public void run() {
            DaoUtils.getControlLinkCommunMessageDao().update((ControlLinkCommunMessageDao) this.a);
        }
    }

    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ControlLinkMessageAdapter.this.t = true;
        }
    }

    public static /* synthetic */ class o {
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
                a[MessageType.controllink.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[MessageType.controllinktimer.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public class p implements View.OnClickListener {
        public final /* synthetic */ ControlLinkCommunMessage a;

        public p(ControlLinkCommunMessage controlLinkCommunMessage) {
            this.a = controlLinkCommunMessage;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ControlLinkMessageAdapter.this.n.v2(this.a);
        }
    }

    public class q extends SimpleImageLoadingListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ ControlLinkCommunMessage b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ PictureFriendViewHolder d;

        public q(String str, ControlLinkCommunMessage controlLinkCommunMessage, boolean z, PictureFriendViewHolder pictureFriendViewHolder) {
            this.a = str;
            this.b = controlLinkCommunMessage;
            this.c = z;
            this.d = pictureFriendViewHolder;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            ControlLinkMessageAdapter controlLinkMessageAdapter = ControlLinkMessageAdapter.this;
            String str2 = this.a;
            controlLinkMessageAdapter.N(str, view, bitmap, str2, this.b, str2, this.c, this.d);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
            ControlLinkMessageAdapter.this.j.put(this.a, view);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
            ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
        }
    }

    public class r extends SimpleImageLoadingListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ ControlLinkCommunMessage b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ PictureViewHolder e;

        public r(String str, ControlLinkCommunMessage controlLinkCommunMessage, String str2, boolean z, PictureViewHolder pictureViewHolder) {
            this.a = str;
            this.b = controlLinkCommunMessage;
            this.c = str2;
            this.d = z;
            this.e = pictureViewHolder;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            ControlLinkMessageAdapter.this.N(str, view, bitmap, this.a, this.b, this.c, this.d, this.e);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
            ControlLinkMessageAdapter.this.j.put(str, view);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
            ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
        }
    }

    public class s extends SimpleImageLoadingListener {
        public final /* synthetic */ PictureSelfViewHolder a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ControlLinkCommunMessage c;
        public final /* synthetic */ boolean d;

        public s(PictureSelfViewHolder pictureSelfViewHolder, String str, ControlLinkCommunMessage controlLinkCommunMessage, boolean z) {
            this.a = pictureSelfViewHolder;
            this.b = str;
            this.c = controlLinkCommunMessage;
            this.d = z;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            ControlLinkMessageAdapter controlLinkMessageAdapter = ControlLinkMessageAdapter.this;
            String str2 = this.b;
            controlLinkMessageAdapter.N(str, view, bitmap, str2, this.c, str2, this.d, this.a);
            this.a.loading.setVisibility(8);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
            this.a.loading.setVisibility(8);
            ControlLinkMessageAdapter.this.j.put(str, view);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
            ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
            this.a.loading.setVisibility(0);
        }
    }

    public class t implements View.OnClickListener {
        public final /* synthetic */ ControlLinkTimerViewHolder a;
        public final /* synthetic */ EntityControlLinkTimer b;
        public final /* synthetic */ ControlLinkCommunMessage c;

        public t(ControlLinkTimerViewHolder controlLinkTimerViewHolder, EntityControlLinkTimer entityControlLinkTimer, ControlLinkCommunMessage controlLinkCommunMessage) {
            this.a = controlLinkTimerViewHolder;
            this.b = entityControlLinkTimer;
            this.c = controlLinkCommunMessage;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ControlLinkMessageAdapter.this.T(this.a, this.b.getRemainTime(), true);
            ma2 ma2Var = ControlLinkMessageAdapter.this.n;
            if (ma2Var != null) {
                ma2Var.q0(this.c.getId());
            }
        }
    }

    public class u implements View.OnClickListener {
        public final /* synthetic */ EntityPattern a;
        public final /* synthetic */ ControlLinkCommunMessage b;
        public final /* synthetic */ PatternViewHolder c;

        public class a implements nf3.d {

            /* renamed from: com.wear.adapter.longdistance.ControlLinkMessageAdapter$u$a$a, reason: collision with other inner class name */
            public class RunnableC0073a implements Runnable {
                public RunnableC0073a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    u.this.c.patternSave.setEnabled(false);
                    u.this.c.patternSave.setText(ah4.e(R.string.common_saved));
                }
            }

            public a() {
            }

            @Override // dc.nf3.d
            public void onRequestComplete(String str) throws IOException {
                if (WearUtils.e1(str) || str.contains("result")) {
                    sg3.i(ControlLinkMessageAdapter.this.m, R.string.file_notfound);
                    return;
                }
                String strReplace = str.replace("\r", "");
                String status = u.this.b.getStatus();
                if (WearUtils.e1(status)) {
                    status = WearUtils.E();
                }
                if (rf3.o(strReplace)) {
                    strReplace = rf3.r(strReplace);
                }
                WearUtils.m2(strReplace, status);
                Pattern pattern = new Pattern(status);
                pattern.setName(u.this.a.getName());
                pattern.setData(strReplace);
                pattern.setCreator(WearUtils.y.r());
                pattern.setEmail(WearUtils.y.r());
                pattern.setAuthor(WearUtils.y.u().getUserName());
                pattern.setTimer(WearUtils.Q(u.this.a.getTime()));
                pattern.setToyFunc(u.this.a.getFeature());
                if (pattern.getHead() != null && !WearUtils.e1(pattern.getHead().getToys()) && pattern.getHead().getToys().equalsIgnoreCase(Toy.TOY_XMACHINE)) {
                    pattern.setToyFeature(Toy.TOY_FEATURE_XMACHINE);
                }
                xe2.L0().t(pattern, true);
                u.this.b.setStatus(pattern.getId());
                ControlLinkCommunMessage controlLinkCommunMessageFindById = DaoUtils.getControlLinkCommunMessageDao().findById(u.this.b.getId());
                if (controlLinkCommunMessageFindById != null) {
                    controlLinkCommunMessageFindById.setStatus(pattern.getId());
                    DaoUtils.getControlLinkCommunMessageDao().updateOrAdd(controlLinkCommunMessageFindById);
                    if (!WearUtils.e1(DaoUtils.getCommunMessageDao().findById(u.this.b.getId()).getStatus())) {
                        ControlLinkMessageAdapter.this.m.runOnUiThread(new RunnableC0073a());
                    } else {
                        u.this.b.setStatus(null);
                        sg3.i(ControlLinkMessageAdapter.this.m, R.string.chat_save_pattern_failed);
                    }
                }
            }
        }

        public u(EntityPattern entityPattern, ControlLinkCommunMessage controlLinkCommunMessage, PatternViewHolder patternViewHolder) {
            this.a = entityPattern;
            this.b = controlLinkCommunMessage;
            this.c = patternViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WearUtils.e1(this.a.getUrl())) {
                ControlLinkMessageAdapter.this.n.P();
            } else {
                nf3.b(this.a.getUrl(), new a());
            }
        }
    }

    public class v extends ff3 {
        public v() {
        }

        @Override // dc.ff3
        public void d(boolean z, Object obj, String str, String str2, long j) {
            ControlLinkMessageAdapter.this.b0(z, obj, str2);
        }
    }

    public interface w {
        boolean a(ControlLinkCommunMessage controlLinkCommunMessage, EntityChat entityChat);
    }

    public interface x {
        void U1(ControlLinkCommunMessage controlLinkCommunMessage);
    }

    public ControlLinkMessageAdapter(List<ControlLinkCommunMessage> list, Activity activity, ma2 ma2Var, so3 so3Var, z73 z73Var, ie3 ie3Var, String str, boolean z, ChatEditText chatEditText) {
        this.l = list;
        this.e = chatEditText;
        this.m = activity;
        this.n = ma2Var;
        ch3.n().u();
        this.a = str;
        this.g = z;
        this.c = so3Var;
        this.b = z73Var;
        this.d = ie3Var;
        new qo().h(R.drawable.chat_avatar_default).X(R.drawable.chat_avatar_default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K(String str) {
        MyApplication.y0(this.m, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M(boolean z, String str) {
        if (z) {
            if (this.s == null) {
                this.s = new LinkJumpDialog(this.m, new LinkJumpDialog.b() { // from class: dc.mk1
                    @Override // com.wear.widget.dialog.LinkJumpDialog.b
                    public final void a(String str2) {
                        this.a.K(str2);
                    }
                });
            }
            ue3.a(this.e, this.m);
            this.s.d(str);
            return;
        }
        if (l22.p(str)) {
            sg3.h(R.string.control_link_conflict_toast);
        } else {
            MyApplication.y0(this.m, str);
        }
    }

    public final void A(ControlLinkTimerViewHolder controlLinkTimerViewHolder, ControlLinkCommunMessage controlLinkCommunMessage, DataEntityAbstract dataEntityAbstract, boolean z) {
        EntityControlLinkTimer entityControlLinkTimer = (EntityControlLinkTimer) dataEntityAbstract;
        controlLinkTimerViewHolder.tvTimer.setText(WearUtils.Q(entityControlLinkTimer.getRemainTime()));
        controlLinkTimerViewHolder.tvTimerTip.setText(ah4.e(this.g ? entityControlLinkTimer.isReachMaxAbnormalCount() ? R.string.auto_disable_controller_des4 : R.string.auto_disable_controller_des3 : R.string.auto_disable_controllee_des2));
        controlLinkTimerViewHolder.tvStop.setVisibility(this.g ? 8 : 0);
        T(controlLinkTimerViewHolder, entityControlLinkTimer.getRemainTime(), entityControlLinkTimer.isCancel());
        controlLinkTimerViewHolder.tvStop.setOnClickListener(new t(controlLinkTimerViewHolder, entityControlLinkTimer, controlLinkCommunMessage));
    }

    public final void B(ControlLinkViewHolder controlLinkViewHolder, ControlLinkCommunMessage controlLinkCommunMessage, DataEntityAbstract dataEntityAbstract, boolean z) {
        Y(controlLinkViewHolder.userImg, z);
        if (dataEntityAbstract == null) {
            dataEntityAbstract = controlLinkCommunMessage.syncDecryptBean();
        }
        ControlLinkBean controlLinkBean = ((EntityControllink) dataEntityAbstract).getControlLinkBean();
        String str = "Toy(s): ";
        String strE = "00:00";
        if (controlLinkBean != null) {
            ControlLinkBean.CreatorBean creator = controlLinkBean.getCreator();
            if (creator != null) {
                List<ControlLinkCreatorToyBean> toys = creator.getToys();
                if (toys.size() > 1) {
                    ControlLinkCreatorToyBean controlLinkCreatorToyBean = toys.get(0);
                    ControlLinkCreatorToyBean controlLinkCreatorToyBean2 = toys.get(1);
                    str = "Toy(s): " + w(controlLinkCreatorToyBean.getType(), 1) + ", " + w(controlLinkCreatorToyBean2.getType(), 1);
                    controlLinkViewHolder.rl_toy_0.setVisibility(8);
                    controlLinkViewHolder.rl_toy_1.setVisibility(0);
                    controlLinkViewHolder.rl_toy_1.setText(w(controlLinkCreatorToyBean.getType(), 3));
                    controlLinkViewHolder.rl_toy_1.setMaxLines("Mini XMachine".equalsIgnoreCase(controlLinkCreatorToyBean.getType()) ? 2 : 1);
                    controlLinkViewHolder.rl_toy_2.setVisibility(0);
                    controlLinkViewHolder.rl_toy_2.setText(w(controlLinkCreatorToyBean2.getType(), 3));
                    controlLinkViewHolder.rl_toy_2.setMaxLines("Mini XMachine".equalsIgnoreCase(controlLinkCreatorToyBean2.getType()) ? 2 : 1);
                } else if (toys.size() > 0 && toys.get(0) != null) {
                    ControlLinkCreatorToyBean controlLinkCreatorToyBean3 = toys.get(0);
                    str = "Toy(s): " + w(controlLinkCreatorToyBean3.getType(), 1);
                    controlLinkViewHolder.rl_toy_0.setVisibility(0);
                    controlLinkViewHolder.rl_toy_0.setText(w(controlLinkCreatorToyBean3.getType(), 3));
                    controlLinkViewHolder.rl_toy_0.setMaxLines("Mini XMachine".equalsIgnoreCase(controlLinkCreatorToyBean3.getType()) ? 2 : 1);
                    controlLinkViewHolder.rl_toy_1.setVisibility(8);
                    controlLinkViewHolder.rl_toy_2.setVisibility(8);
                }
            }
            ControlLinkBean.LinkBean link = controlLinkBean.getLink();
            if (link != null) {
                if (link.getExpires() > 0) {
                    long[] jArrK = be3.K((int) link.getExpires());
                    strE = be3.z((int) jArrK[0], (int) jArrK[1], (int) jArrK[2]);
                } else {
                    strE = ah4.e(R.string.duration_unlimited);
                }
            }
        }
        controlLinkViewHolder.tv_control_link_toys.setText(str);
        controlLinkViewHolder.tv_control_link_duration.setText(ah4.e(R.string.str_duration) + ": " + strE);
    }

    public final void C(ControlViewHolder controlViewHolder, ControlLinkCommunMessage controlLinkCommunMessage, DataEntityAbstract dataEntityAbstract, boolean z, int i2) {
        Y(controlViewHolder.userImg, z);
        mz1 mz1VarD = nz1.e().d();
        if (z) {
            R(controlViewHolder.controlMessage, mz1VarD.v());
            controlViewHolder.tvControlAgain.setTextColor(mz1VarD.m());
            controlViewHolder.tvControlContent.setTextColor(mz1VarD.n());
        } else {
            R(controlViewHolder.controlMessage, mz1VarD.t());
            controlViewHolder.tvControlAgain.setTextColor(mz1VarD.J());
            controlViewHolder.tvControlContent.setTextColor(mz1VarD.b());
        }
        int i3 = o.a[controlLinkCommunMessage.getMsgType().ordinal()];
        int i4 = -1;
        if (i3 == 2) {
            EntityLive entityLive = (EntityLive) dataEntityAbstract;
            if (entityLive.getLiveOPTType().equals(EntityLive.LiveOPTType.cancel)) {
                i4 = 0;
            } else if (entityLive.getLiveOPTType().equals(EntityLive.LiveOPTType.reject)) {
                i4 = 1;
            } else if (entityLive.getLiveOPTType().equals(EntityLive.LiveOPTType.end)) {
                i4 = 2;
            } else if (entityLive.getLiveOPTType().equals(EntityLive.LiveOPTType.networkError)) {
                i4 = 3;
            } else if (entityLive.getLiveOPTType().equals(EntityLive.LiveOPTType.noAnswer)) {
                i4 = 4;
            }
            S(controlLinkCommunMessage.getMsgType(), controlViewHolder, !z ? 1 : 0, i4, ah4.e(R.string.str_chatroom_live), entityLive.getControlTime(), 0, !z ? mz1VarD.F() : mz1VarD.d());
        } else if (i3 == 3) {
            EntitySync entitySync = (EntitySync) dataEntityAbstract;
            if (entitySync.getSyncOPTType().equals(EntitySync.SyncOPTType.cancel)) {
                i4 = 0;
            } else if (entitySync.getSyncOPTType().equals(EntitySync.SyncOPTType.reject)) {
                i4 = 1;
            } else if (entitySync.getSyncOPTType().equals(EntitySync.SyncOPTType.end)) {
                i4 = 2;
            } else if (entitySync.getSyncOPTType().equals(EntitySync.SyncOPTType.networkError)) {
                i4 = 3;
            } else if (entitySync.getSyncOPTType().equals(EntitySync.SyncOPTType.noAnswer)) {
                i4 = 4;
            }
            S(controlLinkCommunMessage.getMsgType(), controlViewHolder, !z ? 1 : 0, i4, ah4.e(R.string.str_chatroom_sync), entitySync.getControlTime(), 1, !z ? mz1VarD.z() : mz1VarD.R());
        } else if (i3 == 6) {
            EntityVideo entityVideo = (EntityVideo) dataEntityAbstract;
            if (entityVideo.getVideoOPTType().equals(EntityVideo.VideoOPTType.cancel)) {
                i4 = 0;
            } else if (entityVideo.getVideoOPTType().equals(EntityVideo.VideoOPTType.reject)) {
                i4 = 1;
            } else if (entityVideo.getVideoOPTType().equals(EntityVideo.VideoOPTType.end)) {
                i4 = 2;
            } else if (entityVideo.getVideoOPTType().equals(EntityVideo.VideoOPTType.networkError)) {
                i4 = 3;
            } else if (entityVideo.getVideoOPTType().equals(EntityVideo.VideoOPTType.noAnswer)) {
                i4 = 4;
            }
            S(controlLinkCommunMessage.getMsgType(), controlViewHolder, !z ? 1 : 0, i4, ah4.e(R.string.str_chatroom_videocall), entityVideo.getControlTime(), 2, !z ? mz1VarD.b0() : mz1VarD.T());
        } else if (i3 == 7) {
            EntityVoice entityVoice = (EntityVoice) dataEntityAbstract;
            if (entityVoice.getVoiceOPTType().equals(EntityVoice.VoiceOPTType.cancel)) {
                i4 = 0;
            } else if (entityVoice.getVoiceOPTType().equals(EntityVoice.VoiceOPTType.reject)) {
                i4 = 1;
            } else if (entityVoice.getVoiceOPTType().equals(EntityVoice.VoiceOPTType.end)) {
                i4 = 2;
            } else if (entityVoice.getVoiceOPTType().equals(EntityVoice.VoiceOPTType.networkError)) {
                i4 = 3;
            } else if (entityVoice.getVoiceOPTType().equals(EntityVoice.VoiceOPTType.noAnswer)) {
                i4 = 4;
            }
            S(controlLinkCommunMessage.getMsgType(), controlViewHolder, !z ? 1 : 0, i4, ah4.e(R.string.str_chatroom_voicecall), entityVoice.getControlTime(), 3, !z ? mz1VarD.c() : mz1VarD.Q());
        }
        X(i2, controlViewHolder.userImg, controlViewHolder.llRootAnima, z, controlViewHolder.chatItemTimeCreate);
    }

    public final void D(PatternFriendViewHolder patternFriendViewHolder, ControlLinkCommunMessage controlLinkCommunMessage, mz1 mz1Var, EntityPattern entityPattern) {
        patternFriendViewHolder.patternPlay.setTag(entityPattern.getUrl() + "#" + patternFriendViewHolder.a);
        U(patternFriendViewHolder.patternPlay, mz1Var.A());
        patternFriendViewHolder.patternTimePlay.setTextColor(mz1Var.s());
        if (qf3.n(entityPattern.getUrl(), patternFriendViewHolder.a)) {
            patternFriendViewHolder.patternTimePlay.setText(qf3.p() + "/");
            U(patternFriendViewHolder.patternPlay, mz1Var.q());
            patternFriendViewHolder.patternTimePlay.setTextColor(mz1Var.l());
            patternFriendViewHolder.patternTimePlay.setVisibility(0);
            patternFriendViewHolder.patternTimePlayX.setVisibility(0);
            qf3.v(patternFriendViewHolder, new v());
        } else {
            patternFriendViewHolder.patternTimePlay.setVisibility(8);
            patternFriendViewHolder.patternTimePlayX.setVisibility(8);
        }
        patternFriendViewHolder.patternPlay.setOnClickListener(new a(entityPattern, patternFriendViewHolder, controlLinkCommunMessage));
        User userV = ch3.n().v(this.n.C().getId());
        if (entityPattern.getIsAutoPlay() && userV != null && !userV.isDateIng()) {
            entityPattern.setIsAutoPlay(false);
            if (qf3.a || WearUtils.e1(qf3.b) || !qf3.b.equals(entityPattern.getUrl()) || WearUtils.e1(qf3.o()) || !qf3.o().equals(patternFriendViewHolder.a)) {
                if (qf3.n(entityPattern.getUrl(), patternFriendViewHolder.a)) {
                    System.out.println();
                } else {
                    patternFriendViewHolder.patternPlay.performClick();
                }
            }
        }
        if (patternFriendViewHolder.patternSave != null) {
            String status = controlLinkCommunMessage.getStatus();
            if (!WearUtils.e1(status) && xe2.L0().K(status) != null) {
                patternFriendViewHolder.patternSave.setEnabled(false);
                patternFriendViewHolder.patternSave.setText(ah4.e(R.string.common_saved));
            } else {
                patternFriendViewHolder.patternSave.setEnabled(true);
                patternFriendViewHolder.patternSave.setText(ah4.e(R.string.common_save));
                patternFriendViewHolder.patternSave.setOnClickListener(new b(entityPattern, controlLinkCommunMessage, patternFriendViewHolder));
            }
        }
    }

    public final void E(PatternSelfViewHolder patternSelfViewHolder, ControlLinkCommunMessage controlLinkCommunMessage, EntityPattern entityPattern) {
        mz1 mz1VarD = nz1.e().d();
        TextView textView = patternSelfViewHolder.patternResend;
        if (textView != null) {
            textView.setTextColor(mz1VarD.s());
        }
        patternSelfViewHolder.patternVerticalLine.setBackgroundColor(mz1VarD.Y());
        TextView textView2 = patternSelfViewHolder.patternResend;
        if (textView2 != null) {
            textView2.setOnClickListener(new c(controlLinkCommunMessage, entityPattern));
        }
        if (patternSelfViewHolder.loading != null) {
            if (controlLinkCommunMessage.isSendIng()) {
                patternSelfViewHolder.loading.setVisibility(0);
            } else {
                patternSelfViewHolder.loading.setVisibility(8);
            }
        }
    }

    public final void F(PatternViewHolder patternViewHolder, ControlLinkCommunMessage controlLinkCommunMessage, DataEntityAbstract dataEntityAbstract, int i2, boolean z) {
        mz1 mz1VarD = nz1.e().d();
        EntityPattern entityPattern = (EntityPattern) dataEntityAbstract;
        patternViewHolder.patternName.setText(entityPattern.getName().trim());
        patternViewHolder.patternTime.setText(WearUtils.Q(entityPattern.getTime()));
        if (WearUtils.e1(entityPattern.getUrl())) {
            return;
        }
        Y(patternViewHolder.userImg, z);
        String status = controlLinkCommunMessage.getStatus();
        if (WearUtils.e1(status) || xe2.L0().K(status) == null) {
            patternViewHolder.patternSave.setEnabled(true);
            patternViewHolder.patternSave.setText(ah4.e(R.string.common_save));
            patternViewHolder.patternSave.setTextColor(mz1VarD.s());
            patternViewHolder.patternSave.setOnClickListener(new u(entityPattern, controlLinkCommunMessage, patternViewHolder));
        } else {
            patternViewHolder.patternSave.setEnabled(false);
            patternViewHolder.patternSave.setText(ah4.e(R.string.common_saved));
            patternViewHolder.patternSave.setTextColor(mz1VarD.s());
        }
        if (patternViewHolder instanceof PatternFriendViewHolder) {
            D((PatternFriendViewHolder) patternViewHolder, controlLinkCommunMessage, mz1VarD, entityPattern);
        } else {
            E((PatternSelfViewHolder) patternViewHolder, controlLinkCommunMessage, entityPattern);
        }
    }

    public final void G(PictureViewHolder pictureViewHolder, ControlLinkCommunMessage controlLinkCommunMessage, DataEntityAbstract dataEntityAbstract, boolean z) {
        EntityPicture entityPicture = (EntityPicture) dataEntityAbstract;
        String type = entityPicture.getType();
        boolean z2 = !WearUtils.e1(type) && type.equals("emoji");
        String url = entityPicture.getUrl();
        String localUrl = entityPicture.getLocalUrl();
        Y(pictureViewHolder.userImg, z);
        pictureViewHolder.userPicture.setOnClickListener(new p(controlLinkCommunMessage));
        pictureViewHolder.userPicture.setEmoji(z2);
        PictureBean pictureBean = null;
        if (pictureViewHolder.userPicture.getTag() != null && (pictureViewHolder.userPicture.getTag() instanceof PictureBean)) {
            pictureBean = (PictureBean) pictureViewHolder.userPicture.getTag();
        }
        boolean zA = this.b.a(controlLinkCommunMessage.getId());
        if (pictureViewHolder instanceof PictureFriendViewHolder) {
            PictureFriendViewHolder pictureFriendViewHolder = (PictureFriendViewHolder) pictureViewHolder;
            if (pictureBean != null && url.equals(pictureBean.url) && zA == pictureBean.isHide) {
                return;
            }
            ImageLoader imageLoader = ImageLoader.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append(WearUtils.e);
            sb.append(z2 ? url.replace("thum_", "") : url);
            imageLoader.displayImage(sb.toString(), pictureViewHolder.userPicture, MyApplication.Y, new q(url, controlLinkCommunMessage, z2, pictureFriendViewHolder));
            return;
        }
        PictureSelfViewHolder pictureSelfViewHolder = (PictureSelfViewHolder) pictureViewHolder;
        if (!WearUtils.e1(localUrl) && (WearUtils.c0(localUrl).exists() || WearUtils.Z(localUrl).exists() || WearUtils.a0(localUrl).exists())) {
            if (pictureBean != null && localUrl.equals(pictureBean.localUrl) && zA == pictureBean.isHide) {
                return;
            }
            ImageLoader.getInstance().displayImage(Uri.fromFile(z2 ? WearUtils.Z(localUrl).exists() ? WearUtils.Z(localUrl) : WearUtils.a0(localUrl) : WearUtils.c0(localUrl)).toString(), pictureViewHolder.userPicture, MyApplication.Y, new r(localUrl, controlLinkCommunMessage, url, z2, pictureViewHolder));
            return;
        }
        if (WearUtils.e1(url)) {
            pictureSelfViewHolder.userPicture.setImageResource(R.drawable.content_icon_picture_loading);
            pictureSelfViewHolder.loading.setVisibility(8);
            this.j.put(url, pictureViewHolder.userPicture);
        } else {
            if (pictureBean != null && url.equals(pictureBean.url) && zA == pictureBean.isHide) {
                return;
            }
            ImageLoader imageLoader2 = ImageLoader.getInstance();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(WearUtils.e);
            sb2.append(z2 ? url.replace("thum_", "") : url);
            imageLoader2.displayImage(sb2.toString(), pictureViewHolder.userPicture, MyApplication.Y, new s(pictureSelfViewHolder, url, controlLinkCommunMessage, z2));
        }
    }

    public final void H(SystemViewHolder systemViewHolder, ControlLinkCommunMessage controlLinkCommunMessage, DataEntityAbstract dataEntityAbstract, int i2, boolean z) {
        String showNickName;
        mz1 mz1VarD = nz1.e().d();
        try {
            ((GradientDrawable) systemViewHolder.syncMessageLayout.getBackground()).setColor(mz1VarD.N());
        } catch (Exception e2) {
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
        systemViewHolder.tvSyncMessage.setTextColor(mz1VarD.f0());
        EntitySystem entitySystem = (EntitySystem) dataEntityAbstract;
        EntitySystem.SystemOPTType firstSysOPTType = entitySystem.getFirstSysOPTType();
        EntitySystem.SystemOPTType systemOPTType = EntitySystem.SystemOPTType.T200;
        if (firstSysOPTType == systemOPTType && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C200) {
            if (z) {
                systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.chat_pattern_sync_own_notice));
                return;
            } else {
                systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.chat_pattern_sync_notice));
                return;
            }
        }
        showNickName = "";
        if (entitySystem.getFirstSysOPTType() == systemOPTType && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C202) {
            systemViewHolder.tvSyncMessage.setText(WearUtils.e1(entitySystem.getFirstString()) ? "" : entitySystem.getFirstString());
            return;
        }
        if (entitySystem.getFirstSysOPTType() == systemOPTType && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C203) {
            String firstString = entitySystem.getFirstString();
            if (!WearUtils.e1(firstString) && firstString.indexOf("#") >= 0) {
                firstString = firstString.substring(0, firstString.indexOf("#"));
            }
            systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.block_frends_message_tip), firstString));
            return;
        }
        if (entitySystem.getFirstSysOPTType() == systemOPTType && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C10000) {
            String str = String.format(ah4.e(R.string.delete_frends_message_tip_1), this.n.getUserName());
            String strE = ah4.e(R.string.delete_frends_message_tip_2);
            SpannableString spannableString = new SpannableString(str + strE + ah4.e(R.string.delete_frends_message_tip_3));
            spannableString.setSpan(new ForegroundColorSpan(mz1VarD.G()), str.length(), str.length() + strE.length(), 17);
            spannableString.setSpan(new i(), str.length(), str.length() + strE.length(), 17);
            systemViewHolder.tvSyncMessage.setMovementMethod(LinkMovementMethod.getInstance());
            systemViewHolder.tvSyncMessage.setText(spannableString);
            return;
        }
        if (entitySystem.getFirstSysOPTType() == systemOPTType && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C666) {
            systemViewHolder.tvSyncMessage.setText(entitySystem.getSystemMessage());
            return;
        }
        EntitySystem.SystemOPTType firstSysOPTType2 = entitySystem.getFirstSysOPTType();
        EntitySystem.SystemOPTType systemOPTType2 = EntitySystem.SystemOPTType.T300;
        if (firstSysOPTType2 == systemOPTType2 && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C320) {
            if (z) {
                systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.chat_sync_recall_owner));
                return;
            }
            this.n.C();
            if (this.m != null && this.n.C() != null) {
                showNickName = this.n.C().getShowNickName();
            }
            systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.chat_sync_recall_pattern), showNickName));
            return;
        }
        EntitySystem.SystemOPTType firstSysOPTType3 = entitySystem.getFirstSysOPTType();
        EntitySystem.SystemOPTType systemOPTType3 = EntitySystem.SystemOPTType.T400;
        if (firstSysOPTType3 == systemOPTType3 && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C700) {
            systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.control_link_hasnt_join_chat2));
            return;
        }
        if (entitySystem.getFirstSysOPTType() == systemOPTType3 && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C701) {
            systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.control_link_join_chat1));
            return;
        }
        if (entitySystem.getFirstSysOPTType() == systemOPTType3 && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C702) {
            systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.control_link_left_chat2));
            return;
        }
        if (entitySystem.getFirstSysOPTType() == systemOPTType3 && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C703) {
            systemViewHolder.tvSyncMessage.setText(entitySystem.getFirstString());
            return;
        }
        if (entitySystem.getFirstSysOPTType() == systemOPTType3 && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C704) {
            systemViewHolder.tvSyncMessage.setText(entitySystem.getFirstString());
            return;
        }
        if (entitySystem.getFirstSysOPTType() == systemOPTType3 && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C705) {
            systemViewHolder.tvSyncMessage.setText(entitySystem.getFirstString());
            return;
        }
        if (entitySystem.getFirstSysOPTType() == systemOPTType3 && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C706) {
            systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.control_link_left_chat1));
            return;
        }
        if (entitySystem.getFirstSysOPTType() == systemOPTType3 && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C707) {
            systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.control_link_left_chat1));
            return;
        }
        if (entitySystem.getFirstSysOPTType() == systemOPTType3 && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C708) {
            systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.control_link_cancel_trigger));
            return;
        }
        if (entitySystem.getFirstSysOPTType() == systemOPTType3 && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C709) {
            systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.control_link_cancel_expired));
            return;
        }
        if (entitySystem.getFirstSysOPTType() == systemOPTType3 && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C710) {
            systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.control_link_cancel_declined));
            return;
        }
        if (entitySystem.getFirstSysOPTType() == systemOPTType2 && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C308) {
            String firstSysText = entitySystem.getFirstSysText();
            if (TextUtils.isEmpty(firstSysText)) {
                return;
            }
            systemViewHolder.tvSyncMessage.setText(firstSysText);
            return;
        }
        if (entitySystem.getFirstSysOPTType() == systemOPTType && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C329) {
            String firstSysText2 = entitySystem.getFirstSysText();
            if (TextUtils.isEmpty(firstSysText2)) {
                return;
            }
            systemViewHolder.tvSyncMessage.setText(firstSysText2);
        }
    }

    public final void I(mz1 mz1Var, BaseViewHolder baseViewHolder, boolean z) {
        baseViewHolder.chatItemTimeCreate.setTextColor(mz1Var.Z());
        try {
            ((GradientDrawable) baseViewHolder.chatItemTimeCreate.getBackground()).setColor(mz1Var.D());
        } catch (Exception e2) {
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    public final void N(String str, View view, Bitmap bitmap, String str2, ControlLinkCommunMessage controlLinkCommunMessage, String str3, boolean z, PictureViewHolder pictureViewHolder) {
        FrameLayout.LayoutParams layoutParams;
        FrameLayout.LayoutParams layoutParams2;
        PictureBean pictureBean = new PictureBean();
        pictureBean.url = str3;
        pictureBean.localUrl = str2;
        pictureBean.isHide = this.b.a(controlLinkCommunMessage.getId());
        view.setTag(pictureBean);
        if (bitmap == null) {
            ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
            return;
        }
        int iA = ce3.a(this.m, 180.0f);
        int iA2 = ce3.a(this.m, 80.0f);
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
                layoutParams2 = i2 < iA2 ? new FrameLayout.LayoutParams(iA, iA2) : new FrameLayout.LayoutParams(iA, i2);
            } else {
                layoutParams = height <= iA2 ? new FrameLayout.LayoutParams((width * iA2) / height, iA2) : new FrameLayout.LayoutParams(width, height);
                layoutParams2 = layoutParams;
            }
        } else if (height >= iA) {
            int i3 = (width * iA) / height;
            layoutParams2 = i3 < iA2 ? new FrameLayout.LayoutParams(iA2, iA) : new FrameLayout.LayoutParams(i3, iA);
        } else {
            layoutParams = width <= iA2 ? new FrameLayout.LayoutParams(iA2, (height * iA2) / width) : new FrameLayout.LayoutParams(width, height);
            layoutParams2 = layoutParams;
        }
        if (pictureBean.isHide) {
            Bitmap bitmapCopy = bitmap.copy(bitmap.getConfig(), true);
            int width2 = bitmapCopy.getWidth();
            int height2 = bitmapCopy.getHeight();
            int[] iArr = new int[width2 * height2];
            bitmapCopy.getPixels(iArr, 0, width2, 0, 0, width2, height2);
            Blur.c(iArr, width2, height2, 25);
            bitmapCopy.setPixels(iArr, 0, width2, 0, 0, width2, height2);
            Blur.b(bitmapCopy, 25);
            ((GifImageView) view).setImageBitmap(bitmapCopy);
        }
        GifImageView gifImageView = new GifImageView(this.m);
        gifImageView.setImageBitmap(bitmap);
        gifImageView.setLayoutParams(layoutParams2);
        this.i.put(str, gifImageView);
        this.f.put(controlLinkCommunMessage.getId(), layoutParams2.width + SignatureImpl.INNER_SEP + layoutParams2.height);
        view.setLayoutParams(layoutParams2);
        this.j.put(str, view);
        if (z) {
            File file = ImageLoader.getInstance().getDiskCache().get(str);
            if (file.exists()) {
                try {
                    pictureViewHolder.userPicture.setImageDrawable(new GifDrawable(file));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i2) {
        int itemViewType = getItemViewType(i2) & 3072;
        ControlLinkCommunMessage controlLinkCommunMessage = this.l.get(i2);
        DataEntityAbstract dataBean = controlLinkCommunMessage.getDataBean();
        if (be3.G(controlLinkCommunMessage.getCreated())) {
            if (i2 <= 0 || !be3.B(this.l.get(i2 - 1).getCreated(), controlLinkCommunMessage.getCreated(), 1)) {
                baseViewHolder.chatItemTimeCreate.setVisibility(0);
                baseViewHolder.chatItemTimeCreate.setText(WearUtils.u0(controlLinkCommunMessage.getCreated()));
            } else {
                baseViewHolder.chatItemTimeCreate.setVisibility(8);
            }
        } else if (i2 <= 0 || !be3.B(this.l.get(i2 - 1).getCreated(), controlLinkCommunMessage.getCreated(), 1)) {
            baseViewHolder.chatItemTimeCreate.setVisibility(0);
            baseViewHolder.chatItemTimeCreate.setText(WearUtils.u0(controlLinkCommunMessage.getCreated()));
        } else {
            baseViewHolder.chatItemTimeCreate.setVisibility(8);
        }
        baseViewHolder.longChatCreateLayout.setVisibility(baseViewHolder.chatItemTimeCreate.getVisibility());
        if (baseViewHolder instanceof ChatViewHolder) {
            z((ChatViewHolder) baseViewHolder, controlLinkCommunMessage, dataBean, i2, 1024 == itemViewType);
        } else if (baseViewHolder instanceof SystemViewHolder) {
            H((SystemViewHolder) baseViewHolder, controlLinkCommunMessage, dataBean, i2, 1024 == itemViewType);
        } else if (baseViewHolder instanceof ControlViewHolder) {
            C((ControlViewHolder) baseViewHolder, controlLinkCommunMessage, dataBean, 1024 == itemViewType, i2);
        } else if (baseViewHolder instanceof AlarmViewHolder) {
            x((AlarmViewHolder) baseViewHolder, controlLinkCommunMessage, dataBean, 1024 == itemViewType);
        } else if (baseViewHolder instanceof PatternViewHolder) {
            F((PatternViewHolder) baseViewHolder, controlLinkCommunMessage, dataBean, i2, 1024 == itemViewType);
        } else if (baseViewHolder instanceof PictureViewHolder) {
            G((PictureViewHolder) baseViewHolder, controlLinkCommunMessage, dataBean, 1024 == itemViewType);
        } else if (baseViewHolder instanceof AudioViewHolder) {
            y((AudioViewHolder) baseViewHolder, controlLinkCommunMessage, dataBean, 1024 == itemViewType, i2);
        } else if (baseViewHolder instanceof ControlLinkViewHolder) {
            B((ControlLinkViewHolder) baseViewHolder, controlLinkCommunMessage, dataBean, 1024 == itemViewType);
        } else if (baseViewHolder instanceof ControlLinkTimerViewHolder) {
            A((ControlLinkTimerViewHolder) baseViewHolder, controlLinkCommunMessage, dataBean, 1024 == itemViewType);
        }
        W(baseViewHolder, controlLinkCommunMessage, i2, itemViewType);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i2, @NonNull List<Object> list) {
        if (list.isEmpty()) {
            onBindViewHolder(baseViewHolder, i2);
            return;
        }
        int itemViewType = getItemViewType(i2) & 3072;
        ControlLinkCommunMessage controlLinkCommunMessage = this.l.get(i2);
        for (Object obj : list) {
            if (TextUtils.equals("sendStatus", obj.toString())) {
                W(baseViewHolder, controlLinkCommunMessage, i2, itemViewType);
            } else if (TextUtils.equals("updateRemainTime", obj.toString())) {
                a0(baseViewHolder, controlLinkCommunMessage);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        int i3 = i2 & 3072;
        int i4 = i2 & (-3073);
        if (i4 == 15) {
            return i3 == 1024 ? new ControlLinkSelfViewHolder(this, LayoutInflater.from(this.m).inflate(R.layout.item_control_link_self, viewGroup, false)) : new ControlLinkFriendViewHolder(this, LayoutInflater.from(this.m).inflate(R.layout.item_control_link_friend, viewGroup, false));
        }
        if (i4 == 16) {
            return new ControlLinkTimerViewHolder(this, LayoutInflater.from(this.m).inflate(R.layout.item_control_link_time, viewGroup, false));
        }
        switch (i4) {
            case 1:
                return i3 == 1024 ? new ChatSelfViewHolder(this, LayoutInflater.from(this.m).inflate(R.layout.item_chat_self, viewGroup, false)) : new ChatFriendViewHolder(this, LayoutInflater.from(this.m).inflate(R.layout.item_chat_friend, viewGroup, false));
            case 2:
            case 3:
            case 6:
            case 7:
                return i3 == 1024 ? new ControlSelfViewHolder(this, LayoutInflater.from(this.m).inflate(R.layout.item_control_self, viewGroup, false)) : new ControlFriendViewHolder(this, LayoutInflater.from(this.m).inflate(R.layout.item_control_friend, viewGroup, false));
            case 4:
                return i3 == 1024 ? new AlarmSelfViewHolder(this, LayoutInflater.from(this.m).inflate(R.layout.item_alarm_self, viewGroup, false)) : new AlarmFriendViewHolder(this, LayoutInflater.from(this.m).inflate(R.layout.item_alarm_friend, viewGroup, false));
            case 5:
                return i3 == 1024 ? new AudioSelfViewHolder(this, LayoutInflater.from(this.m).inflate(R.layout.item_audio_self, viewGroup, false)) : new AudioFriendViewHolder(this, LayoutInflater.from(this.m).inflate(R.layout.item_audio_friend, viewGroup, false));
            case 8:
            case 11:
                return new SystemViewHolder(this, LayoutInflater.from(this.m).inflate(R.layout.item_system, viewGroup, false));
            case 9:
                return i3 == 1024 ? new PatternSelfViewHolder(this, LayoutInflater.from(this.m).inflate(R.layout.item_pattern_self, viewGroup, false)) : new PatternFriendViewHolder(this, LayoutInflater.from(this.m).inflate(R.layout.item_pattern_friend, viewGroup, false));
            case 10:
                return i3 == 1024 ? new PictureSelfViewHolder(this, LayoutInflater.from(this.m).inflate(R.layout.item_picture_self, viewGroup, false)) : new PictureFriendViewHolder(this, LayoutInflater.from(this.m).inflate(R.layout.item_picture_friend, viewGroup, false));
            default:
                return new DefalutViewHolder(this, LayoutInflater.from(this.m).inflate(R.layout.item_system, viewGroup, false));
        }
    }

    public final void R(View view, int i2) {
        int paddingLeft = view.getPaddingLeft();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingBottom = view.getPaddingBottom();
        view.setBackground(th4.d(view.getContext(), i2));
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    @SuppressLint({"StringFormatMatches"})
    public final void S(MessageType messageType, ControlViewHolder controlViewHolder, int i2, int i3, String str, String str2, int i4, int i5) {
        if (i3 == -1) {
            return;
        }
        U(controlViewHolder.iconControl, i5);
        controlViewHolder.tvControlTime.setVisibility(8);
        String userName = this.n.getUserName();
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
        controlViewHolder.controlMessage.setOnClickListener(new h(i4));
    }

    public final void T(ControlLinkTimerViewHolder controlLinkTimerViewHolder, int i2, boolean z) {
        if (controlLinkTimerViewHolder.tvStop.getVisibility() == 8 && z && i2 > 0) {
            controlLinkTimerViewHolder.tvStop.setVisibility(0);
        }
        if (controlLinkTimerViewHolder.tvStop.isEnabled()) {
            controlLinkTimerViewHolder.tvStop.setText(ah4.e(z ? R.string.common_stopped : R.string.common_stop));
            controlLinkTimerViewHolder.tvStop.setEnabled(!z);
            controlLinkTimerViewHolder.tvStop.setTextColor(th4.b(this.m, z ? R.color.text_color_25 : R.color.control_link_timer_stop_text_color));
        }
    }

    public final void U(ImageView imageView, int i2) {
        imageView.setImageDrawable(th4.d(imageView.getContext(), i2));
    }

    public void V(x xVar) {
        this.r = xVar;
    }

    public final void W(BaseViewHolder baseViewHolder, ControlLinkCommunMessage controlLinkCommunMessage, int i2, int i3) {
        I(nz1.e().d(), baseViewHolder, 1024 == i3);
        if (1024 == i3) {
            View viewB = baseViewHolder.b();
            if (viewB != null) {
                if (controlLinkCommunMessage.isSendIng()) {
                    viewB.setVisibility(0);
                } else {
                    viewB.setVisibility(8);
                }
            }
            ImageView imageViewA = baseViewHolder.a();
            if (imageViewA != null) {
                imageViewA.setVisibility(8);
                if (controlLinkCommunMessage.getSendStatus() == 4) {
                    imageViewA.setVisibility(0);
                    imageViewA.setOnClickListener(new k(controlLinkCommunMessage));
                }
            }
        }
    }

    public void X(int i2, ImageView imageView, View view, boolean z, TextView textView) {
        List<ControlLinkCommunMessage> list = this.l;
        if (list == null || list.size() == 0) {
            return;
        }
        if (i2 <= 0) {
            if (z) {
                imageView.setVisibility(8);
                view.setPadding(0, ce3.a(this.m, 16.0f), 0, 0);
                return;
            } else {
                imageView.setVisibility(0);
                view.setPadding(0, ce3.a(this.m, 16.0f), 0, 0);
                return;
            }
        }
        int itemViewType = getItemViewType(i2 - 1);
        int itemViewType2 = getItemViewType(i2);
        if ((itemViewType & 3072) != (itemViewType2 & 3072)) {
            if (z) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
            }
            view.setPadding(0, ce3.a(this.m, 16.0f), 0, 0);
            return;
        }
        if (z) {
            imageView.setVisibility(8);
            view.setPadding(0, ce3.a(this.m, 6.0f), 0, 0);
            return;
        }
        if (textView.getVisibility() == 0) {
            imageView.setVisibility(0);
            view.setPadding(0, ce3.a(this.m, 16.0f), 0, 0);
        } else if (itemViewType == itemViewType2 || itemViewType2 != 2056) {
            imageView.setVisibility(4);
            view.setPadding(0, ce3.a(this.m, 6.0f), 0, 0);
        } else {
            imageView.setVisibility(0);
            view.setPadding(0, ce3.a(this.m, 16.0f), 0, 0);
        }
    }

    public final void Y(RoundedImageView roundedImageView, boolean z) {
        int i2 = R.drawable.avatar_2;
        if (z) {
            if (this.g) {
                i2 = R.drawable.avatar_1;
            }
            roundedImageView.setImageResource(i2);
        } else {
            if (!this.g) {
                i2 = R.drawable.avatar_1;
            }
            roundedImageView.setImageResource(i2);
        }
    }

    public final void Z(ChatViewHolder chatViewHolder, int i2, int i3, int i4, String str) {
        chatViewHolder.userMessage.setDrawingCacheEnabled(true);
        chatViewHolder.userMessage.buildDrawingCache();
        try {
            Bitmap drawingCache = chatViewHolder.userMessage.getDrawingCache();
            if (drawingCache != null) {
                sd3.a(chatViewHolder.userMessage.getContext(), drawingCache.copy(drawingCache.getConfig(), true), chatViewHolder.userMessage, 10, chatViewHolder.messageGlass);
                chatViewHolder.messageGlass.setVisibility(0);
            } else {
                chatViewHolder.messageBlur.setVisibility(8);
            }
        } catch (Exception unused) {
        }
    }

    public final void a0(BaseViewHolder baseViewHolder, ControlLinkCommunMessage controlLinkCommunMessage) {
        if (baseViewHolder instanceof ControlLinkTimerViewHolder) {
            ControlLinkTimerViewHolder controlLinkTimerViewHolder = (ControlLinkTimerViewHolder) baseViewHolder;
            EntityControlLinkTimer entityControlLinkTimer = (EntityControlLinkTimer) controlLinkCommunMessage.getDataBean();
            controlLinkTimerViewHolder.tvTimer.setText(WearUtils.Q(entityControlLinkTimer.getRemainTime()));
            T(controlLinkTimerViewHolder, entityControlLinkTimer.getRemainTime(), entityControlLinkTimer.isCancel());
        }
    }

    public final void b0(boolean z, Object obj, String str) {
        this.m.runOnUiThread(new d(obj, z, str));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.l.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        ControlLinkCommunMessage controlLinkCommunMessage = this.l.get(i2);
        int i3 = !this.a.equals(controlLinkCommunMessage.getFromId()) ? 2048 : 1024;
        if (controlLinkCommunMessage.getMsgType() != null) {
            switch (o.a[controlLinkCommunMessage.getMsgType().ordinal()]) {
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
                    return i3 + 15;
                case 12:
                    return i3 + 16;
            }
        }
        return i3 + 0;
    }

    public final void v(String str) {
        if (this.t) {
            this.t = false;
            this.h.postDelayed(new n(), 500L);
            if (this.n.o()) {
                return;
            }
            User userV = ch3.n().v(str);
            if (userV != null && userV.isFriend()) {
                sg3.i(this.m, R.string.add_friend_user_exist);
                return;
            }
            if (userV != null && userV.addSendToMe()) {
                sg3.k(this.m, String.format(ah4.e(R.string.add_friend_user_requested), userV.getUserName()));
                return;
            }
            if (userV == null) {
                userV = new User(str);
            }
            if (hu3.k(str)) {
                userV.addFriendType(2);
                sg3.i(this.m, R.string.user_add_success);
            }
        }
    }

    public final String w(String str, int i2) {
        return TextUtils.equals("Mini XMachine", str) ? uu1.a(str, i2) : Toy.NAME_MAP.get(str.toLowerCase());
    }

    public final void x(AlarmViewHolder alarmViewHolder, ControlLinkCommunMessage controlLinkCommunMessage, DataEntityAbstract dataEntityAbstract, boolean z) {
        mz1 mz1VarD = nz1.e().d();
        EntityAlarm entityAlarm = (EntityAlarm) dataEntityAbstract;
        alarmViewHolder.alarmTime.setText(be3.c(entityAlarm.getPattern().getTime(), WearUtils.x));
        String strK4 = SetAlarmActivity.K4(entityAlarm.getPattern().getFrequency(), entityAlarm.getPattern().getDates() == null ? null : WearUtils.A.toJson(entityAlarm.getPattern().getDates()));
        alarmViewHolder.alarmRequency.setText(strK4);
        boolean z2 = alarmViewHolder instanceof AlarmSelfViewHolder;
        Y(alarmViewHolder.userImg, z);
        U(alarmViewHolder.ivAlarm, mz1VarD.j());
        if (!z2) {
            AlarmFriendViewHolder alarmFriendViewHolder = (AlarmFriendViewHolder) alarmViewHolder;
            alarmFriendViewHolder.alarmAutoPlay.setTextColor(mz1VarD.s());
            alarmFriendViewHolder.alarmDecline.setTextColor(mz1VarD.s());
            alarmFriendViewHolder.alarmAccept.setTextColor(mz1VarD.s());
            alarmFriendViewHolder.alarmActionLayout.setVisibility(0);
            alarmFriendViewHolder.alarmDecline.setEnabled(true);
            alarmFriendViewHolder.alarmAccept.setEnabled(true);
            alarmFriendViewHolder.alarmVerticalLine.setBackgroundColor(mz1VarD.Y());
            String status = controlLinkCommunMessage.getStatus();
            alarmFriendViewHolder.alarmMessage.setAlpha(1.0f);
            if (WearUtils.e1(status)) {
                alarmFriendViewHolder.alarmActionLayout.setVisibility(0);
            } else if (status.startsWith(AlarmListItems.ALARM_STATUS_AUTO)) {
                alarmFriendViewHolder.alarmAutoPlay.setVisibility(0);
                alarmFriendViewHolder.alarmAutoPlay.setText(ah4.e(R.string.alarm_status_automatic));
                if (AlarmMessagingService.b(entityAlarm)) {
                    alarmFriendViewHolder.alarmAutoPlay.setText(ah4.e(R.string.alarm_status_expired));
                } else {
                    alarmFriendViewHolder.alarmMessage.setAlpha(0.6f);
                }
            } else {
                alarmFriendViewHolder.alarmAutoPlay.setVisibility(8);
                if (status.startsWith(AlarmListItems.ALARM_STATUS_WAIT)) {
                    if (AlarmMessagingService.b(entityAlarm)) {
                        alarmFriendViewHolder.alarmDecline.setEnabled(false);
                        alarmFriendViewHolder.alarmAccept.setEnabled(false);
                        alarmFriendViewHolder.alarmAutoPlay.setVisibility(0);
                        alarmFriendViewHolder.alarmAutoPlay.setText(ah4.e(R.string.alarm_status_expired));
                    }
                    IPeopleInfo iPeopleInfoC = this.n.C();
                    if (iPeopleInfoC.isGroup() && ((Group) iPeopleInfoC).isExit()) {
                        alarmFriendViewHolder.alarmDecline.setEnabled(false);
                        alarmFriendViewHolder.alarmAccept.setEnabled(false);
                        alarmFriendViewHolder.alarmAutoPlay.setVisibility(0);
                        alarmFriendViewHolder.alarmAutoPlay.setText(ah4.e(R.string.alarm_status_expired));
                    }
                } else {
                    alarmFriendViewHolder.alarmDecline.setEnabled(false);
                    alarmFriendViewHolder.alarmAccept.setEnabled(false);
                    if (status.startsWith(AlarmListItems.ALARM_STATUS_ACCEPT)) {
                        alarmFriendViewHolder.alarmAutoPlay.setVisibility(0);
                        alarmFriendViewHolder.alarmAutoPlay.setText(ah4.e(R.string.alarm_status_accept));
                        alarmFriendViewHolder.alarmMessage.setAlpha(0.6f);
                    } else if (status.startsWith(AlarmListItems.ALARM_STATUS_REJECT)) {
                        alarmFriendViewHolder.alarmAutoPlay.setVisibility(0);
                        alarmFriendViewHolder.alarmAutoPlay.setText(ah4.e(R.string.alarm_status_rejected));
                    }
                }
            }
            alarmFriendViewHolder.alarmDecline.setOnClickListener(new e(controlLinkCommunMessage, entityAlarm));
            alarmFriendViewHolder.alarmAccept.setOnClickListener(new f(this));
        }
        alarmViewHolder.alarmMessage.setOnClickListener(new g(entityAlarm, strK4));
        Y(alarmViewHolder.userImg, z);
    }

    public final void y(AudioViewHolder audioViewHolder, ControlLinkCommunMessage controlLinkCommunMessage, DataEntityAbstract dataEntityAbstract, boolean z, int i2) {
        mz1 mz1VarD = nz1.e().d();
        EntityAudio entityAudio = (EntityAudio) dataEntityAbstract;
        audioViewHolder.voiceTime.setText(entityAudio.getTime() + "'' ");
        if (z) {
            audioViewHolder.voiceTime.setTextColor(mz1VarD.X());
        }
        audioViewHolder.voicePlay.setTag(entityAudio.getUrl());
        int dimensionPixelSize = (this.m.getResources().getDimensionPixelSize(R.dimen.activity_msg_max_lenth) - this.m.getResources().getDimensionPixelSize(R.dimen.activity_msg_min_lenth)) / 60;
        ce3.a(this.m, 11.0f);
        if (z) {
            audioViewHolder.llVoice.setPadding((int) (dimensionPixelSize * entityAudio.getTime()), 0, 0, 0);
            R(audioViewHolder.llVoice, mz1VarD.y());
            audioViewHolder.voiceTime.setTextColor(mz1VarD.K());
            U(audioViewHolder.voiceIcon, mz1VarD.i0());
        } else {
            audioViewHolder.llVoice.setPadding(0, 0, (int) (dimensionPixelSize * entityAudio.getTime()), 0);
            R(audioViewHolder.llVoice, mz1VarD.g0());
            audioViewHolder.voiceTime.setTextColor(mz1VarD.h0());
            U(audioViewHolder.voiceIcon, mz1VarD.o());
        }
        Y(audioViewHolder.userImg, z);
        audioViewHolder.voicePlay.setOnClickListener(new l(mz1VarD, z, audioViewHolder, i2));
        X(i2, audioViewHolder.userImg, audioViewHolder.llRootAnima, z, audioViewHolder.chatItemTimeCreate);
    }

    public final void z(ChatViewHolder chatViewHolder, ControlLinkCommunMessage controlLinkCommunMessage, DataEntityAbstract dataEntityAbstract, int i2, boolean z) {
        w wVar;
        chatViewHolder.messageBlur.setVisibility(8);
        chatViewHolder.messageGlass.setVisibility(8);
        EntityChat entityChat = (EntityChat) dataEntityAbstract;
        String text = entityChat.getText();
        mz1 mz1VarD = nz1.e().d();
        if (z) {
            R(chatViewHolder.userMessage, mz1VarD.y());
            chatViewHolder.userMessage.setTextColor(mz1VarD.K());
        } else {
            R(chatViewHolder.userMessage, mz1VarD.g0());
            chatViewHolder.userMessage.setTextColor(mz1VarD.h0());
        }
        chatViewHolder.userMessage.setOnDrawFinish(new j(controlLinkCommunMessage, chatViewHolder, i2, text));
        if (this.b.a(controlLinkCommunMessage.getId())) {
            chatViewHolder.userMessage.setOneUpdateToDraw(true);
        }
        Y(chatViewHolder.userImg, z);
        if (!z && (wVar = this.p) != null) {
            if (wVar.a(controlLinkCommunMessage, entityChat)) {
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
        if (this.d.D(entityChat.getText())) {
            chatViewHolder.fl_emoji.setVisibility(0);
            chatViewHolder.flUserMessage.setVisibility(8);
            File fileR = this.d.r(entityChat.getText());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) chatViewHolder.fl_emoji.getLayoutParams();
            if (fileR == null || !fileR.exists()) {
                chatViewHolder.iv_emoji.setImageBitmap(this.d.F(entityChat.getText()));
                layoutParams.width = ce3.a(this.m, 24.0f);
                layoutParams.height = ce3.a(this.m, 24.0f);
            } else {
                kf.v(this.m).s(fileR).A0(chatViewHolder.iv_emoji);
                layoutParams.width = ce3.a(this.m, 68.0f);
                layoutParams.height = ce3.a(this.m, 68.0f);
            }
            layoutParams.leftMargin = ce3.a(this.m, 6.0f);
            layoutParams.rightMargin = ce3.a(this.m, 6.0f);
            chatViewHolder.fl_emoji.setLayoutParams(layoutParams);
            String strS = this.d.s(entityChat.getText(), false);
            chatViewHolder.lottieView.g();
            if (TextUtils.isEmpty(strS) || !controlLinkCommunMessage.isShowEmojiAnim()) {
                chatViewHolder.iv_emoji.setVisibility(0);
                chatViewHolder.lottieView.setVisibility(8);
            } else {
                chatViewHolder.iv_emoji.setVisibility(8);
                chatViewHolder.lottieView.setVisibility(0);
                this.d.O(chatViewHolder.lottieView, strS);
                controlLinkCommunMessage.setShowEmojiAnim(false);
                vg3.b().a(new m(this, controlLinkCommunMessage));
            }
        } else {
            chatViewHolder.fl_emoji.setVisibility(8);
            chatViewHolder.flUserMessage.setVisibility(0);
            chatViewHolder.userMessage.setUrlText(this.d, entityChat.getText(), z, new HttpTextView.a() { // from class: dc.lk1
                @Override // com.wear.util.HttpTextView.a
                public final void a(boolean z2, String str) {
                    this.a.M(z2, str);
                }
            });
        }
        X(i2, chatViewHolder.userImg, chatViewHolder.llRootAnima, z, chatViewHolder.chatItemTimeCreate);
    }
}
