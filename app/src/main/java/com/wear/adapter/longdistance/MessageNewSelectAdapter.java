package com.wear.adapter.longdistance;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
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
import com.wear.bean.Account;
import com.wear.bean.AlarmListItems;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.bean.PictureBean;
import com.wear.bean.User;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.broadcast.AlarmMessagingService;
import com.wear.main.longDistance.ChatHistorySelectActivity;
import com.wear.main.longDistance.alarm.SetAlarmActivity;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntityAlarm;
import com.wear.protocol.EntityAudio;
import com.wear.protocol.EntityChat;
import com.wear.protocol.EntityLive;
import com.wear.protocol.EntityPattern;
import com.wear.protocol.EntityPicture;
import com.wear.protocol.EntityShortVideo;
import com.wear.protocol.EntitySync;
import com.wear.protocol.EntitySystem;
import com.wear.protocol.EntityVideo;
import com.wear.protocol.EntityVoice;
import com.wear.protocol.MessageType;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.GlassText;
import com.wear.widget.MyImageView;
import dc.ah4;
import dc.av1;
import dc.be3;
import dc.ce3;
import dc.ch3;
import dc.e82;
import dc.ff3;
import dc.hu3;
import dc.ie3;
import dc.kf;
import dc.mz1;
import dc.nz1;
import dc.qf3;
import dc.qo;
import dc.sd3;
import dc.sg3;
import dc.ta2;
import dc.th4;
import dc.xe2;
import dc.zb2;
import io.agora.rtm2.RtmConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.qiujuer.genius.graphics.Blur;
import org.aspectj.runtime.reflect.SignatureImpl;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import skin.support.constraint.SkinCompatConstraintLayout;

/* loaded from: classes3.dex */
public class MessageNewSelectAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    public List<CommunMessage> c;
    public ChatHistorySelectActivity d;
    public qo e;
    public c0 f;
    public ta2 h;
    public String i;
    public Account j;
    public e82 l;
    public ie3 m;
    public HashMap<String, GifImageView> a = new HashMap<>();
    public HashMap<String, View> b = new HashMap<>();
    public Handler g = new Handler(Looper.getMainLooper());
    public HashMap<String, String> k = new HashMap<>();
    public boolean n = true;
    public Handler o = new Handler(Looper.getMainLooper());

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

        public AlarmFriendViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(messageNewSelectAdapter, view);
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

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.AlarmViewHolder_ViewBinding, com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
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

        public AlarmSelfViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(messageNewSelectAdapter, view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder
        public ImageView a() {
            return this.blockSync;
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder
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

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.AlarmViewHolder_ViewBinding, com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
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

        public AlarmViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder
        public View c() {
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
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
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
        public AudioFriendViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(messageNewSelectAdapter, view);
        }
    }

    public class AudioSelfViewHolder extends AudioViewHolder {

        @BindView(R.id.block_sync)
        public ImageView blockSync;

        @BindView(R.id.loading)
        public ProgressBar loading;

        public AudioSelfViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(messageNewSelectAdapter, view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder
        public ImageView a() {
            return this.blockSync;
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder
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

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.AudioViewHolder_ViewBinding, com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
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

        @BindView(R.id.ll_voice)
        public SkinCompatConstraintLayout llVoice;

        @BindView(R.id.tv_expired)
        public TextView tvExpired;

        @BindView(R.id.user_img)
        public RoundedImageView userImg;

        @BindView(R.id.voice_icon)
        public LottieAnimationView voiceIcon;

        @BindView(R.id.voice_play)
        public SkinCompatConstraintLayout voicePlay;

        @BindView(R.id.voice_time)
        public TextView voiceTime;

        public AudioViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder
        public View c() {
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
            audioViewHolder.llVoice = (SkinCompatConstraintLayout) Utils.findRequiredViewAsType(view, R.id.ll_voice, "field 'llVoice'", SkinCompatConstraintLayout.class);
            audioViewHolder.voicePlay = (SkinCompatConstraintLayout) Utils.findRequiredViewAsType(view, R.id.voice_play, "field 'voicePlay'", SkinCompatConstraintLayout.class);
            audioViewHolder.userImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.user_img, "field 'userImg'", RoundedImageView.class);
            audioViewHolder.tvExpired = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_expired, "field 'tvExpired'", TextView.class);
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
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
            super.unbind();
        }
    }

    public static abstract class BaseViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.chat_item_time_create)
        public TextView chatItemTimeCreate;

        @BindView(R.id.long_chat_create_layout)
        public View longChatCreateLayout;

        @BindView(R.id.select_status)
        public ImageView select_status;

        @BindView(R.id.select_status_layout)
        public LinearLayout select_status_layout;

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
    }

    public class BaseViewHolder_ViewBinding implements Unbinder {
        public BaseViewHolder a;

        @UiThread
        public BaseViewHolder_ViewBinding(BaseViewHolder baseViewHolder, View view) {
            this.a = baseViewHolder;
            baseViewHolder.chatItemTimeCreate = (TextView) Utils.findRequiredViewAsType(view, R.id.chat_item_time_create, "field 'chatItemTimeCreate'", TextView.class);
            baseViewHolder.longChatCreateLayout = Utils.findRequiredView(view, R.id.long_chat_create_layout, "field 'longChatCreateLayout'");
            baseViewHolder.select_status_layout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.select_status_layout, "field 'select_status_layout'", LinearLayout.class);
            baseViewHolder.select_status = (ImageView) Utils.findRequiredViewAsType(view, R.id.select_status, "field 'select_status'", ImageView.class);
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
            baseViewHolder.select_status_layout = null;
            baseViewHolder.select_status = null;
        }
    }

    public class ChatFriendViewHolder extends ChatViewHolder {
        public ChatFriendViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(messageNewSelectAdapter, view);
        }
    }

    public class ChatSelfViewHolder extends ChatViewHolder {

        @BindView(R.id.block_sync)
        public ImageView blockSync;

        @BindView(R.id.loading)
        public ProgressBar loading;

        public ChatSelfViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(messageNewSelectAdapter, view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder
        public ImageView a() {
            return this.blockSync;
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder
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

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.ChatViewHolder_ViewBinding, com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
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

    public class ChatViewHolder extends BaseViewHolder {

        @BindView(R.id.fl_user_message)
        public FrameLayout flUserMessage;

        @BindView(R.id.fl_emoji)
        public FrameLayout fl_emoji;

        @BindView(R.id.iv_emoji)
        public ImageView iv_emoji;

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

        public ChatViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder
        public View c() {
            return this.userMessage;
        }
    }

    public class ChatViewHolder_ViewBinding extends BaseViewHolder_ViewBinding {
        public ChatViewHolder b;

        @UiThread
        public ChatViewHolder_ViewBinding(ChatViewHolder chatViewHolder, View view) {
            super(chatViewHolder, view);
            this.b = chatViewHolder;
            chatViewHolder.userMessage = (GlassText) Utils.findRequiredViewAsType(view, R.id.user_message, "field 'userMessage'", GlassText.class);
            chatViewHolder.messageBlur = (ImageView) Utils.findRequiredViewAsType(view, R.id.message_blur, "field 'messageBlur'", ImageView.class);
            chatViewHolder.messageGlass = (ImageView) Utils.findRequiredViewAsType(view, R.id.message_glass, "field 'messageGlass'", ImageView.class);
            chatViewHolder.flUserMessage = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_user_message, "field 'flUserMessage'", FrameLayout.class);
            chatViewHolder.userImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.user_img, "field 'userImg'", RoundedImageView.class);
            chatViewHolder.llRootAnima = Utils.findRequiredView(view, R.id.ll_root_anima, "field 'llRootAnima'");
            chatViewHolder.fl_emoji = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_emoji, "field 'fl_emoji'", FrameLayout.class);
            chatViewHolder.iv_emoji = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_emoji, "field 'iv_emoji'", ImageView.class);
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
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
            chatViewHolder.iv_emoji = null;
            super.unbind();
        }
    }

    public class ControlFriendViewHolder extends ControlViewHolder {
        public ControlFriendViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(messageNewSelectAdapter, view);
        }
    }

    public class ControlSelfViewHolder extends ControlViewHolder {
        public ControlSelfViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(messageNewSelectAdapter, view);
        }
    }

    public class ControlViewHolder extends BaseViewHolder {

        @BindView(R.id.control_bottom_layout)
        public LinearLayout controlBottomLayout;

        @BindView(R.id.control_message)
        public LinearLayout controlMessage;

        @BindView(R.id.icon_control)
        public ImageView iconControl;

        @BindView(R.id.tv_control_again)
        public TextView tvControlAgain;

        @BindView(R.id.tv_control_content)
        public TextView tvControlContent;

        @BindView(R.id.tv_control_time)
        public TextView tvControlTime;

        @BindView(R.id.user_img)
        public RoundedImageView userImg;

        public ControlViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder
        public View c() {
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
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
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
            super.unbind();
        }
    }

    public class DefalutViewHolder extends BaseViewHolder {
        public DefalutViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder
        public View c() {
            return null;
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

        public PatternFriendViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(messageNewSelectAdapter, view);
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

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.PatternViewHolder_ViewBinding, com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
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

        public PatternSelfViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(messageNewSelectAdapter, view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder
        public ImageView a() {
            return this.blockSync;
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder
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

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.PatternViewHolder_ViewBinding, com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
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

        public PatternViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder
        public View c() {
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
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
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
        public PictureFriendViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(messageNewSelectAdapter, view);
        }
    }

    public class PictureSelfViewHolder extends PictureViewHolder {

        @BindView(R.id.block_sync)
        public ImageView blockSync;

        @BindView(R.id.loading)
        public ProgressBar loading;

        public PictureSelfViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(messageNewSelectAdapter, view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder
        public ImageView a() {
            return this.blockSync;
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder
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

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.PictureViewHolder_ViewBinding, com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
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

        public PictureViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder
        public View c() {
            return this.userPicture;
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

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
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

    public class ShortVideoFriendViewHolder extends ShortVideoViewHolder {
        public ShortVideoFriendViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(messageNewSelectAdapter, view);
        }
    }

    public class ShortVideoSelfViewHolder extends ShortVideoViewHolder {

        @BindView(R.id.block_sync)
        public ImageView blockSync;

        @BindView(R.id.loading)
        public ProgressBar loading;

        public ShortVideoSelfViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(messageNewSelectAdapter, view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder
        public ImageView a() {
            return this.blockSync;
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder
        public View b() {
            return this.loading;
        }
    }

    public class ShortVideoSelfViewHolder_ViewBinding extends ShortVideoViewHolder_ViewBinding {
        public ShortVideoSelfViewHolder c;

        @UiThread
        public ShortVideoSelfViewHolder_ViewBinding(ShortVideoSelfViewHolder shortVideoSelfViewHolder, View view) {
            super(shortVideoSelfViewHolder, view);
            this.c = shortVideoSelfViewHolder;
            shortVideoSelfViewHolder.loading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.loading, "field 'loading'", ProgressBar.class);
            shortVideoSelfViewHolder.blockSync = (ImageView) Utils.findRequiredViewAsType(view, R.id.block_sync, "field 'blockSync'", ImageView.class);
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.ShortVideoViewHolder_ViewBinding, com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            ShortVideoSelfViewHolder shortVideoSelfViewHolder = this.c;
            if (shortVideoSelfViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.c = null;
            shortVideoSelfViewHolder.loading = null;
            shortVideoSelfViewHolder.blockSync = null;
            super.unbind();
        }
    }

    public class ShortVideoViewHolder extends BaseViewHolder {

        @BindView(R.id.user_img)
        public RoundedImageView userImg;

        @BindView(R.id.user_picture)
        public MyImageView userPicture;

        public ShortVideoViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder
        public View c() {
            return this.userPicture;
        }
    }

    public class ShortVideoViewHolder_ViewBinding extends BaseViewHolder_ViewBinding {
        public ShortVideoViewHolder b;

        @UiThread
        public ShortVideoViewHolder_ViewBinding(ShortVideoViewHolder shortVideoViewHolder, View view) {
            super(shortVideoViewHolder, view);
            this.b = shortVideoViewHolder;
            shortVideoViewHolder.userPicture = (MyImageView) Utils.findRequiredViewAsType(view, R.id.user_picture, "field 'userPicture'", MyImageView.class);
            shortVideoViewHolder.userImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.user_img, "field 'userImg'", RoundedImageView.class);
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            ShortVideoViewHolder shortVideoViewHolder = this.b;
            if (shortVideoViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            shortVideoViewHolder.userPicture = null;
            shortVideoViewHolder.userImg = null;
            super.unbind();
        }
    }

    public class SystemViewHolder extends BaseViewHolder {

        @BindView(R.id.sync_message_layout)
        public LinearLayout syncMessageLayout;

        @BindView(R.id.tv_sync_message)
        public TextView tvSyncMessage;

        public SystemViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder
        public View c() {
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
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
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

    public class UnsupportFriendViewHolder extends UnsupportViewHolder {
        public UnsupportFriendViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(messageNewSelectAdapter, view);
        }
    }

    public class UnsupportSelfViewHolder extends UnsupportViewHolder {

        @BindView(R.id.block_sync)
        public ImageView blockSync;

        @BindView(R.id.loading)
        public ProgressBar loading;

        public UnsupportSelfViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(messageNewSelectAdapter, view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder
        public ImageView a() {
            return this.blockSync;
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder
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

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.UnsupportViewHolder_ViewBinding, com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
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

        public UnsupportViewHolder(@NonNull MessageNewSelectAdapter messageNewSelectAdapter, View view) {
            super(view);
        }

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder
        public View c() {
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

        @Override // com.wear.adapter.longdistance.MessageNewSelectAdapter.BaseViewHolder_ViewBinding, butterknife.Unbinder
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

    public class a extends ff3 {
        public a() {
        }

        @Override // dc.ff3
        public void d(boolean z, Object obj, String str, String str2, long j) {
            MessageNewSelectAdapter.this.V(z, obj, str2);
        }
    }

    public class a0 implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ int b;

        public a0(CommunMessage communMessage, int i) {
            this.a = communMessage;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageNewSelectAdapter.this.h.V(this.a, this.b);
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ int b;

        public b(CommunMessage communMessage, int i) {
            this.a = communMessage;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageNewSelectAdapter.this.h.V(this.a, this.b);
        }
    }

    public class b0 implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ int b;

        public b0(CommunMessage communMessage, int i) {
            this.a = communMessage;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageNewSelectAdapter.this.h.V(this.a, this.b);
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ int b;

        public c(CommunMessage communMessage, int i) {
            this.a = communMessage;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageNewSelectAdapter.this.h.V(this.a, this.b);
        }
    }

    public interface c0 {
        boolean a(CommunMessage communMessage, EntityChat entityChat);
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ int b;

        public d(CommunMessage communMessage, int i) {
            this.a = communMessage;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageNewSelectAdapter.this.h.V(this.a, this.b);
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ Object a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    MessageNewSelectAdapter.this.notifyDataSetChanged();
                } catch (Exception e) {
                    FirebaseCrashlytics.getInstance().recordException(e);
                }
            }
        }

        public e(Object obj, boolean z, String str) {
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
                String str2 = "getView: " + patternFriendViewHolder.patternPlay.getTag() + "    " + str + "#" + strO;
                if ((str + "#" + strO).equals(patternFriendViewHolder.patternPlay.getTag())) {
                    if (this.b) {
                        MessageNewSelectAdapter.this.S(patternFriendViewHolder.patternPlay, mz1VarF.q());
                    } else {
                        MessageNewSelectAdapter.this.S(patternFriendViewHolder.patternPlay, mz1VarF.A());
                        try {
                            MessageNewSelectAdapter.this.g.post(new a());
                        } catch (Exception e) {
                            FirebaseCrashlytics.getInstance().recordException(e);
                        }
                    }
                    patternFriendViewHolder.patternTimePlay.setText(this.c);
                }
            }
        }
    }

    public class f implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ int b;

        public f(CommunMessage communMessage, int i) {
            this.a = communMessage;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageNewSelectAdapter.this.h.V(this.a, this.b);
        }
    }

    public class g implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ int b;

        public g(CommunMessage communMessage, int i) {
            this.a = communMessage;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageNewSelectAdapter.this.h.V(this.a, this.b);
        }
    }

    public class h implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ int b;

        public h(CommunMessage communMessage, int i) {
            this.a = communMessage;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageNewSelectAdapter.this.h.V(this.a, this.b);
        }
    }

    public class i implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ int b;

        public i(CommunMessage communMessage, int i) {
            this.a = communMessage;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageNewSelectAdapter.this.h.V(this.a, this.b);
        }
    }

    public class j extends av1 {
        public j(String str, String str2) {
            super(str, str2);
        }

        @Override // dc.av1
        public void a(String str, String str2) {
            MessageNewSelectAdapter.this.t(WearUtils.X(str2));
        }
    }

    public class k implements View.OnLongClickListener {
        public k(MessageNewSelectAdapter messageNewSelectAdapter) {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return false;
        }
    }

    public class l extends ClickableSpan {
        public l() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            MessageNewSelectAdapter messageNewSelectAdapter = MessageNewSelectAdapter.this;
            messageNewSelectAdapter.t(messageNewSelectAdapter.h.C().getId());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    public class m implements GlassText.a {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ ChatViewHolder b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        public m(CommunMessage communMessage, ChatViewHolder chatViewHolder, int i, String str) {
            this.a = communMessage;
            this.b = chatViewHolder;
            this.c = i;
            this.d = str;
        }

        @Override // com.wear.widget.GlassText.a
        public void a(int i, int i2) {
            if (!MessageNewSelectAdapter.this.l.F(this.a.getId())) {
                this.b.messageBlur.setVisibility(8);
                this.b.messageGlass.setVisibility(8);
            } else {
                MessageNewSelectAdapter messageNewSelectAdapter = MessageNewSelectAdapter.this;
                ChatViewHolder chatViewHolder = this.b;
                messageNewSelectAdapter.U(chatViewHolder, this.c, chatViewHolder.userMessage.getWidth(), this.b.userMessage.getHeight(), this.d);
                this.b.messageGlass.setVisibility(0);
            }
        }
    }

    public class n implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ int b;

        public n(CommunMessage communMessage, int i) {
            this.a = communMessage;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageNewSelectAdapter.this.h.V(this.a, this.b);
        }
    }

    public class o implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ int b;

        public o(CommunMessage communMessage, int i) {
            this.a = communMessage;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageNewSelectAdapter.this.h.V(this.a, this.b);
        }
    }

    public class p extends SimpleImageLoadingListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ ShortVideoViewHolder b;
        public final /* synthetic */ CommunMessage c;
        public final /* synthetic */ ShortVideoFriendViewHolder d;

        public class a extends SimpleImageLoadingListener {
            public a() {
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                p pVar = p.this;
                MessageNewSelectAdapter messageNewSelectAdapter = MessageNewSelectAdapter.this;
                String str2 = pVar.a;
                messageNewSelectAdapter.M(str, view, bitmap, str2, pVar.c, str2, false, pVar.d);
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
                if (WearUtils.e1(p.this.a)) {
                    return;
                }
                p pVar = p.this;
                MessageNewSelectAdapter.this.b.put(pVar.a, view);
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingStarted(String str, View view) {
                ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
            }
        }

        public p(String str, ShortVideoViewHolder shortVideoViewHolder, CommunMessage communMessage, ShortVideoFriendViewHolder shortVideoFriendViewHolder) {
            this.a = str;
            this.b = shortVideoViewHolder;
            this.c = communMessage;
            this.d = shortVideoFriendViewHolder;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            MessageNewSelectAdapter messageNewSelectAdapter = MessageNewSelectAdapter.this;
            String str2 = this.a;
            messageNewSelectAdapter.M(str, view, bitmap, str2, this.c, str2, false, this.d);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ImageLoader.getInstance().displayImage(WearUtils.e.replace("-api", "") + this.a, this.b.userPicture, MyApplication.Y, new a());
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
            ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
        }
    }

    public class q extends SimpleImageLoadingListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ CommunMessage b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ShortVideoViewHolder d;

        public q(String str, CommunMessage communMessage, String str2, ShortVideoViewHolder shortVideoViewHolder) {
            this.a = str;
            this.b = communMessage;
            this.c = str2;
            this.d = shortVideoViewHolder;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            MessageNewSelectAdapter.this.M(str, view, bitmap, this.a, this.b, this.c, false, this.d);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
            MessageNewSelectAdapter.this.b.put(str, view);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
            ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
        }
    }

    public class r extends SimpleImageLoadingListener {
        public final /* synthetic */ ShortVideoSelfViewHolder a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ShortVideoViewHolder c;
        public final /* synthetic */ CommunMessage d;

        public class a extends SimpleImageLoadingListener {
            public a() {
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                r rVar = r.this;
                MessageNewSelectAdapter messageNewSelectAdapter = MessageNewSelectAdapter.this;
                String str2 = rVar.b;
                messageNewSelectAdapter.M(str, view, bitmap, str2, rVar.d, str2, false, rVar.a);
                r.this.a.loading.setVisibility(8);
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
                r.this.a.loading.setVisibility(8);
                MessageNewSelectAdapter.this.b.put(str, view);
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingStarted(String str, View view) {
                ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
                r.this.a.loading.setVisibility(0);
            }
        }

        public r(ShortVideoSelfViewHolder shortVideoSelfViewHolder, String str, ShortVideoViewHolder shortVideoViewHolder, CommunMessage communMessage) {
            this.a = shortVideoSelfViewHolder;
            this.b = str;
            this.c = shortVideoViewHolder;
            this.d = communMessage;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            MessageNewSelectAdapter messageNewSelectAdapter = MessageNewSelectAdapter.this;
            String str2 = this.b;
            messageNewSelectAdapter.M(str, view, bitmap, str2, this.d, str2, false, this.a);
            this.a.loading.setVisibility(8);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ImageLoader.getInstance().displayImage(WearUtils.e.replace("-api", "") + this.b, this.c.userPicture, MyApplication.Y, new a());
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
            ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
            this.a.loading.setVisibility(0);
        }
    }

    public class s implements Runnable {
        public s() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MessageNewSelectAdapter.this.n = true;
        }
    }

    public static /* synthetic */ class t {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EntitySystem.SystemOPTCode.values().length];
            b = iArr;
            try {
                iArr[EntitySystem.SystemOPTCode.C200.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[EntitySystem.SystemOPTCode.C202.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[EntitySystem.SystemOPTCode.C203.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[EntitySystem.SystemOPTCode.C10000.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[EntitySystem.SystemOPTCode.C325.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[EntitySystem.SystemOPTCode.C326.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[EntitySystem.SystemOPTCode.C327.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[EntitySystem.SystemOPTCode.C328.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[EntitySystem.SystemOPTCode.C666.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[EntitySystem.SystemOPTCode.C10001.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr2 = new int[MessageType.values().length];
            a = iArr2;
            try {
                iArr2[MessageType.chat.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[MessageType.live.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[MessageType.sync.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[MessageType.alarm.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[MessageType.audio.ordinal()] = 5;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[MessageType.video.ordinal()] = 6;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[MessageType.voice.ordinal()] = 7;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[MessageType.system.ordinal()] = 8;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                a[MessageType.pattern.ordinal()] = 9;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[MessageType.picture.ordinal()] = 10;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[MessageType.shortvideo.ordinal()] = 11;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                a[MessageType.unsupport.ordinal()] = 12;
            } catch (NoSuchFieldError unused22) {
            }
        }
    }

    public class u implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ int b;

        public u(CommunMessage communMessage, int i) {
            this.a = communMessage;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageNewSelectAdapter.this.h.V(this.a, this.b);
        }
    }

    public class v implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ int b;

        public v(CommunMessage communMessage, int i) {
            this.a = communMessage;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageNewSelectAdapter.this.h.V(this.a, this.b);
        }
    }

    public class w implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ int b;

        public w(CommunMessage communMessage, int i) {
            this.a = communMessage;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageNewSelectAdapter.this.h.V(this.a, this.b);
        }
    }

    public class x extends SimpleImageLoadingListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PictureViewHolder c;
        public final /* synthetic */ CommunMessage d;
        public final /* synthetic */ PictureFriendViewHolder e;

        public class a extends SimpleImageLoadingListener {
            public a() {
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                x xVar = x.this;
                MessageNewSelectAdapter messageNewSelectAdapter = MessageNewSelectAdapter.this;
                String str2 = xVar.b;
                messageNewSelectAdapter.L(str, view, bitmap, str2, xVar.d, str2, xVar.a, xVar.e);
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
                x xVar = x.this;
                MessageNewSelectAdapter.this.b.put(xVar.b, view);
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingStarted(String str, View view) {
                ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
            }
        }

        public x(boolean z, String str, PictureViewHolder pictureViewHolder, CommunMessage communMessage, PictureFriendViewHolder pictureFriendViewHolder) {
            this.a = z;
            this.b = str;
            this.c = pictureViewHolder;
            this.d = communMessage;
            this.e = pictureFriendViewHolder;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            MessageNewSelectAdapter messageNewSelectAdapter = MessageNewSelectAdapter.this;
            String str2 = this.b;
            messageNewSelectAdapter.L(str, view, bitmap, str2, this.d, str2, this.a, this.e);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ImageLoader imageLoader = ImageLoader.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append(WearUtils.e.replace("-api", ""));
            sb.append(this.a ? this.b.replace("thum_", "") : this.b);
            imageLoader.displayImage(sb.toString(), this.c.userPicture, MyApplication.Y, new a());
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
            ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
        }
    }

    public class y extends SimpleImageLoadingListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ CommunMessage b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ PictureViewHolder e;

        public y(String str, CommunMessage communMessage, String str2, boolean z, PictureViewHolder pictureViewHolder) {
            this.a = str;
            this.b = communMessage;
            this.c = str2;
            this.d = z;
            this.e = pictureViewHolder;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            MessageNewSelectAdapter.this.L(str, view, bitmap, this.a, this.b, this.c, this.d, this.e);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
            MessageNewSelectAdapter.this.b.put(str, view);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
            ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
        }
    }

    public class z extends SimpleImageLoadingListener {
        public final /* synthetic */ PictureSelfViewHolder a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ PictureViewHolder d;
        public final /* synthetic */ CommunMessage e;

        public class a extends SimpleImageLoadingListener {
            public a() {
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                z zVar = z.this;
                MessageNewSelectAdapter messageNewSelectAdapter = MessageNewSelectAdapter.this;
                String str2 = zVar.c;
                messageNewSelectAdapter.L(str, view, bitmap, str2, zVar.e, str2, zVar.b, zVar.a);
                z.this.a.loading.setVisibility(8);
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
                z.this.a.loading.setVisibility(8);
                MessageNewSelectAdapter.this.b.put(str, view);
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingStarted(String str, View view) {
                ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
                z.this.a.loading.setVisibility(0);
            }
        }

        public z(PictureSelfViewHolder pictureSelfViewHolder, boolean z, String str, PictureViewHolder pictureViewHolder, CommunMessage communMessage) {
            this.a = pictureSelfViewHolder;
            this.b = z;
            this.c = str;
            this.d = pictureViewHolder;
            this.e = communMessage;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            MessageNewSelectAdapter messageNewSelectAdapter = MessageNewSelectAdapter.this;
            String str2 = this.c;
            messageNewSelectAdapter.L(str, view, bitmap, str2, this.e, str2, this.b, this.a);
            this.a.loading.setVisibility(8);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ImageLoader imageLoader = ImageLoader.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append(WearUtils.e.replace("-api", ""));
            sb.append(this.b ? this.c.replace("thum_", "") : this.c);
            imageLoader.displayImage(sb.toString(), this.d.userPicture, MyApplication.Y, new a());
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
            ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
            this.a.loading.setVisibility(0);
        }
    }

    public MessageNewSelectAdapter(List<CommunMessage> list, ChatHistorySelectActivity chatHistorySelectActivity, ta2 ta2Var, e82 e82Var, ie3 ie3Var) {
        this.c = list;
        this.d = chatHistorySelectActivity;
        Account accountU = ch3.n().u();
        this.j = accountU;
        this.i = accountU.getId();
        this.h = ta2Var;
        this.l = e82Var;
        this.m = ie3Var;
        this.e = new qo().h(R.drawable.chat_avatar_default).X(R.drawable.chat_avatar_default);
    }

    public final void A(AudioViewHolder audioViewHolder, CommunMessage communMessage, DataEntityAbstract dataEntityAbstract, int i2, boolean z2) {
        int iA;
        mz1 mz1VarF = nz1.e().f();
        EntityAudio entityAudio = (EntityAudio) dataEntityAbstract;
        boolean zIsExpired = entityAudio.isExpired();
        audioViewHolder.voiceTime.setText(entityAudio.getTime() + "''");
        if (z2) {
            audioViewHolder.voiceTime.setTextColor(mz1VarF.X());
        }
        audioViewHolder.voicePlay.setTag(entityAudio.getUrl());
        int dimensionPixelSize = this.d.getResources().getDimensionPixelSize(R.dimen.activity_msg_max_lenth) - this.d.getResources().getDimensionPixelSize(R.dimen.activity_msg_min_lenth);
        int i3 = dimensionPixelSize / 60;
        int iA2 = ce3.a(this.d, 11.0f);
        if (zIsExpired) {
            iA = ce3.a(this.d, 46.0f);
            audioViewHolder.tvExpired.setVisibility(0);
        } else {
            dimensionPixelSize = (int) (i3 * entityAudio.getTime());
            iA = ce3.a(this.d, 11.0f);
            audioViewHolder.tvExpired.setVisibility(8);
        }
        if (z2) {
            audioViewHolder.llVoice.setPadding(dimensionPixelSize, iA2, 0, iA);
            Q(audioViewHolder.llVoice, mz1VarF.y());
            audioViewHolder.voiceTime.setTextColor(mz1VarF.K());
            S(audioViewHolder.voiceIcon, zIsExpired ? mz1VarF.a0() : mz1VarF.i0());
        } else {
            audioViewHolder.llVoice.setPadding(0, iA2, dimensionPixelSize, iA);
            Q(audioViewHolder.llVoice, mz1VarF.g0());
            audioViewHolder.voiceTime.setTextColor(mz1VarF.h0());
            S(audioViewHolder.voiceIcon, zIsExpired ? mz1VarF.d0() : mz1VarF.o());
        }
        T(audioViewHolder.userImg, communMessage, z2 ? this.j : this.h.C());
    }

    public final void B(ChatViewHolder chatViewHolder, CommunMessage communMessage, DataEntityAbstract dataEntityAbstract, int i2, boolean z2) {
        c0 c0Var;
        chatViewHolder.messageBlur.setVisibility(8);
        chatViewHolder.messageGlass.setVisibility(8);
        EntityChat entityChat = (EntityChat) dataEntityAbstract;
        String text = entityChat.getText();
        mz1 mz1VarF = nz1.e().f();
        if (z2) {
            Q(chatViewHolder.userMessage, mz1VarF.y());
            chatViewHolder.userMessage.setTextColor(mz1VarF.K());
        } else {
            Q(chatViewHolder.userMessage, mz1VarF.g0());
            chatViewHolder.userMessage.setTextColor(mz1VarF.h0());
        }
        chatViewHolder.userMessage.setOnDrawFinish(new m(communMessage, chatViewHolder, i2, text));
        if (this.l.F(communMessage.getId())) {
            chatViewHolder.userMessage.setOneUpdateToDraw(true);
        }
        T(chatViewHolder.userImg, communMessage, z2 ? this.j : this.h.C());
        if (!z2 && (c0Var = this.f) != null) {
            if (c0Var.a(communMessage, entityChat)) {
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
        if (this.m.D(entityChat.getText())) {
            chatViewHolder.fl_emoji.setVisibility(0);
            chatViewHolder.flUserMessage.setVisibility(8);
            File fileR = this.m.r(entityChat.getText());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) chatViewHolder.fl_emoji.getLayoutParams();
            if (fileR == null || !fileR.exists()) {
                chatViewHolder.iv_emoji.setImageBitmap(this.m.F(entityChat.getText()));
                layoutParams.width = ce3.a(this.d, 24.0f);
                layoutParams.height = ce3.a(this.d, 24.0f);
            } else {
                kf.z(this.d).s(fileR).A0(chatViewHolder.iv_emoji);
                layoutParams.width = ce3.a(this.d, 68.0f);
                layoutParams.height = ce3.a(this.d, 68.0f);
            }
            chatViewHolder.fl_emoji.setLayoutParams(layoutParams);
        } else {
            chatViewHolder.fl_emoji.setVisibility(8);
            chatViewHolder.flUserMessage.setVisibility(0);
            this.m.i(chatViewHolder.userMessage, entityChat.getText());
        }
        chatViewHolder.userMessage.setOnClickListener(new n(communMessage, i2));
    }

    public final void C(ControlViewHolder controlViewHolder, CommunMessage communMessage, DataEntityAbstract dataEntityAbstract, int i2, boolean z2) {
        T(controlViewHolder.userImg, communMessage, z2 ? this.j : this.h.C());
        mz1 mz1VarF = nz1.e().f();
        if (z2) {
            Q(controlViewHolder.controlMessage, mz1VarF.v());
            controlViewHolder.tvControlAgain.setTextColor(mz1VarF.m());
            controlViewHolder.tvControlContent.setTextColor(mz1VarF.n());
        } else {
            Q(controlViewHolder.controlMessage, mz1VarF.t());
            controlViewHolder.tvControlAgain.setTextColor(mz1VarF.J());
            controlViewHolder.tvControlContent.setTextColor(mz1VarF.b());
        }
        int i3 = t.a[communMessage.getType().ordinal()];
        if (i3 == 2) {
            EntityLive entityLive = (EntityLive) dataEntityAbstract;
            R(communMessage.getType(), controlViewHolder, !z2 ? 1 : 0, entityLive.getLiveOPTType().equals(EntityLive.LiveOPTType.cancel) ? 0 : entityLive.getLiveOPTType().equals(EntityLive.LiveOPTType.reject) ? 1 : entityLive.getLiveOPTType().equals(EntityLive.LiveOPTType.end) ? 2 : entityLive.getLiveOPTType().equals(EntityLive.LiveOPTType.networkError) ? 3 : entityLive.getLiveOPTType().equals(EntityLive.LiveOPTType.noAnswer) ? 4 : -1, ah4.e(R.string.str_chatroom_live), entityLive.getControlTime(), 0, !z2 ? mz1VarF.F() : mz1VarF.d(), communMessage, i2);
            return;
        }
        if (i3 == 3) {
            EntitySync entitySync = (EntitySync) dataEntityAbstract;
            R(communMessage.getType(), controlViewHolder, !z2 ? 1 : 0, entitySync.getSyncOPTType().equals(EntitySync.SyncOPTType.cancel) ? 0 : entitySync.getSyncOPTType().equals(EntitySync.SyncOPTType.reject) ? 1 : entitySync.getSyncOPTType().equals(EntitySync.SyncOPTType.end) ? 2 : entitySync.getSyncOPTType().equals(EntitySync.SyncOPTType.networkError) ? 3 : entitySync.getSyncOPTType().equals(EntitySync.SyncOPTType.noAnswer) ? 4 : -1, ah4.e(R.string.str_chatroom_sync), entitySync.getControlTime(), 1, !z2 ? mz1VarF.z() : mz1VarF.R(), communMessage, i2);
        } else if (i3 == 6) {
            EntityVideo entityVideo = (EntityVideo) dataEntityAbstract;
            R(communMessage.getType(), controlViewHolder, !z2 ? 1 : 0, entityVideo.getVideoOPTType().equals(EntityVideo.VideoOPTType.cancel) ? 0 : entityVideo.getVideoOPTType().equals(EntityVideo.VideoOPTType.reject) ? 1 : entityVideo.getVideoOPTType().equals(EntityVideo.VideoOPTType.end) ? 2 : entityVideo.getVideoOPTType().equals(EntityVideo.VideoOPTType.networkError) ? 3 : entityVideo.getVideoOPTType().equals(EntityVideo.VideoOPTType.noAnswer) ? 4 : -1, ah4.e(R.string.str_chatroom_videocall), entityVideo.getControlTime(), 2, !z2 ? mz1VarF.b0() : mz1VarF.T(), communMessage, i2);
        } else {
            if (i3 != 7) {
                return;
            }
            EntityVoice entityVoice = (EntityVoice) dataEntityAbstract;
            R(communMessage.getType(), controlViewHolder, !z2 ? 1 : 0, entityVoice.getVoiceOPTType().equals(EntityVoice.VoiceOPTType.cancel) ? 0 : entityVoice.getVoiceOPTType().equals(EntityVoice.VoiceOPTType.reject) ? 1 : entityVoice.getVoiceOPTType().equals(EntityVoice.VoiceOPTType.end) ? 2 : entityVoice.getVoiceOPTType().equals(EntityVoice.VoiceOPTType.networkError) ? 3 : entityVoice.getVoiceOPTType().equals(EntityVoice.VoiceOPTType.noAnswer) ? 4 : -1, ah4.e(R.string.str_chatroom_voicecall), entityVoice.getControlTime(), 3, !z2 ? mz1VarF.c() : mz1VarF.Q(), communMessage, i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void D(com.wear.adapter.longdistance.MessageNewSelectAdapter.PatternFriendViewHolder r5, com.wear.protocol.CommunMessage r6, dc.mz1 r7, com.wear.protocol.EntityPattern r8, int r9) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.adapter.longdistance.MessageNewSelectAdapter.D(com.wear.adapter.longdistance.MessageNewSelectAdapter$PatternFriendViewHolder, com.wear.protocol.CommunMessage, dc.mz1, com.wear.protocol.EntityPattern, int):void");
    }

    public final void E(PatternSelfViewHolder patternSelfViewHolder, CommunMessage communMessage, EntityPattern entityPattern, int i2) {
        mz1 mz1VarF = nz1.e().f();
        TextView textView = patternSelfViewHolder.patternResend;
        if (textView != null) {
            textView.setTextColor(mz1VarF.s());
        }
        patternSelfViewHolder.patternVerticalLine.setBackgroundColor(mz1VarF.Y());
        TextView textView2 = patternSelfViewHolder.patternResend;
        if (textView2 != null) {
            textView2.setOnClickListener(new d(communMessage, i2));
        }
        if (patternSelfViewHolder.loading != null) {
            if (communMessage.isSendIng()) {
                patternSelfViewHolder.loading.setVisibility(0);
            } else {
                patternSelfViewHolder.loading.setVisibility(8);
            }
        }
    }

    public final void F(PatternViewHolder patternViewHolder, CommunMessage communMessage, DataEntityAbstract dataEntityAbstract, int i2, boolean z2) {
        mz1 mz1VarF = nz1.e().f();
        EntityPattern entityPattern = (EntityPattern) dataEntityAbstract;
        patternViewHolder.patternName.setText(entityPattern.getName().trim());
        patternViewHolder.patternTime.setText(WearUtils.Q(entityPattern.getTime()));
        if (WearUtils.e1(entityPattern.getUrl())) {
            return;
        }
        T(patternViewHolder.userImg, communMessage, z2 ? this.j : this.h.C());
        patternViewHolder.patternMessage.setOnClickListener(new a0(communMessage, i2));
        String status = communMessage.getStatus();
        if (WearUtils.e1(status) || xe2.L0().K(status) == null) {
            patternViewHolder.patternSave.setEnabled(true);
            patternViewHolder.patternSave.setText(ah4.e(R.string.common_save));
            patternViewHolder.patternSave.setTextColor(mz1VarF.s());
            patternViewHolder.patternSave.setOnClickListener(new b0(communMessage, i2));
        } else {
            patternViewHolder.patternSave.setEnabled(false);
            patternViewHolder.patternSave.setText(ah4.e(R.string.common_saved));
            patternViewHolder.patternSave.setTextColor(mz1VarF.s());
        }
        if (patternViewHolder instanceof PatternFriendViewHolder) {
            D((PatternFriendViewHolder) patternViewHolder, communMessage, mz1VarF, entityPattern, i2);
        } else {
            E((PatternSelfViewHolder) patternViewHolder, communMessage, entityPattern, i2);
        }
    }

    public final void G(PictureViewHolder pictureViewHolder, CommunMessage communMessage, DataEntityAbstract dataEntityAbstract, int i2, boolean z2) {
        EntityPicture entityPicture = (EntityPicture) dataEntityAbstract;
        String type = entityPicture.getType();
        boolean z3 = !WearUtils.e1(type) && "emoji".equals(type);
        String url = entityPicture.getUrl();
        String localUrl = entityPicture.getLocalUrl();
        String str = "handlerPictureViewHolder url: " + url;
        T(pictureViewHolder.userImg, communMessage, z2 ? this.j : this.h.C());
        pictureViewHolder.userPicture.setOnClickListener(new w(communMessage, i2));
        pictureViewHolder.userPicture.setEmoji(z3);
        PictureBean pictureBean = null;
        if (pictureViewHolder.userPicture.getTag() != null && (pictureViewHolder.userPicture.getTag() instanceof PictureBean)) {
            pictureBean = (PictureBean) pictureViewHolder.userPicture.getTag();
        }
        boolean zF = this.l.F(communMessage.getId());
        if (pictureViewHolder instanceof PictureFriendViewHolder) {
            PictureFriendViewHolder pictureFriendViewHolder = (PictureFriendViewHolder) pictureViewHolder;
            if (pictureBean != null && url.equals(pictureBean.url) && zF == pictureBean.isHide) {
                return;
            }
            ImageLoader imageLoader = ImageLoader.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append(WearUtils.e);
            sb.append(z3 ? url.replace("thum_", "") : url);
            imageLoader.displayImage(sb.toString(), pictureViewHolder.userPicture, MyApplication.Y, new x(z3, url, pictureViewHolder, communMessage, pictureFriendViewHolder));
            return;
        }
        PictureSelfViewHolder pictureSelfViewHolder = (PictureSelfViewHolder) pictureViewHolder;
        if (!WearUtils.e1(localUrl) && (WearUtils.c0(localUrl).exists() || WearUtils.Z(localUrl).exists() || WearUtils.a0(localUrl).exists())) {
            if (pictureBean != null && localUrl.equals(pictureBean.localUrl) && zF == pictureBean.isHide) {
                return;
            }
            ImageLoader.getInstance().displayImage(Uri.fromFile(z3 ? WearUtils.Z(localUrl).exists() ? WearUtils.Z(localUrl) : WearUtils.a0(localUrl) : WearUtils.c0(localUrl)).toString(), pictureViewHolder.userPicture, MyApplication.Y, new y(localUrl, communMessage, url, z3, pictureViewHolder));
            return;
        }
        if (WearUtils.e1(url)) {
            pictureSelfViewHolder.userPicture.setImageResource(R.drawable.content_icon_picture_loading);
            pictureSelfViewHolder.loading.setVisibility(8);
            this.b.put(url, pictureViewHolder.userPicture);
        } else {
            if (pictureBean != null && url.equals(pictureBean.url) && zF == pictureBean.isHide) {
                return;
            }
            ImageLoader imageLoader2 = ImageLoader.getInstance();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(WearUtils.e);
            sb2.append(z3 ? url.replace("thum_", "") : url);
            imageLoader2.displayImage(sb2.toString(), pictureViewHolder.userPicture, MyApplication.Y, new z(pictureSelfViewHolder, z3, url, pictureViewHolder, communMessage));
        }
    }

    public final void H(ShortVideoViewHolder shortVideoViewHolder, CommunMessage communMessage, DataEntityAbstract dataEntityAbstract, int i2, boolean z2) {
        EntityShortVideo entityShortVideo = (EntityShortVideo) dataEntityAbstract;
        String picUrl = entityShortVideo.getPicUrl();
        String picLocalUrl = entityShortVideo.getPicLocalUrl();
        T(shortVideoViewHolder.userImg, communMessage, z2 ? this.j : this.h.C());
        shortVideoViewHolder.userPicture.setOnClickListener(new o(communMessage, i2));
        PictureBean pictureBean = null;
        if (shortVideoViewHolder.userPicture.getTag() != null && (shortVideoViewHolder.userPicture.getTag() instanceof PictureBean)) {
            pictureBean = (PictureBean) shortVideoViewHolder.userPicture.getTag();
        }
        boolean zF = this.l.F(communMessage.getId());
        if (shortVideoViewHolder instanceof ShortVideoFriendViewHolder) {
            ShortVideoFriendViewHolder shortVideoFriendViewHolder = (ShortVideoFriendViewHolder) shortVideoViewHolder;
            if (pictureBean == null || WearUtils.e1(picUrl) || !picUrl.equals(pictureBean.url) || zF != pictureBean.isHide) {
                ImageLoader.getInstance().displayImage(WearUtils.e + picUrl, shortVideoViewHolder.userPicture, MyApplication.Y, new p(picUrl, shortVideoViewHolder, communMessage, shortVideoFriendViewHolder));
                return;
            }
            return;
        }
        ShortVideoSelfViewHolder shortVideoSelfViewHolder = (ShortVideoSelfViewHolder) shortVideoViewHolder;
        if (!WearUtils.e1(picLocalUrl) && (WearUtils.c0(picLocalUrl).exists() || WearUtils.Z(picLocalUrl).exists() || WearUtils.a0(picLocalUrl).exists())) {
            if (pictureBean != null && picLocalUrl.equals(pictureBean.localUrl) && zF == pictureBean.isHide) {
                return;
            }
            ImageLoader.getInstance().displayImage(Uri.fromFile(WearUtils.c0(picLocalUrl)).toString(), shortVideoViewHolder.userPicture, MyApplication.Y, new q(picLocalUrl, communMessage, picUrl, shortVideoViewHolder));
            return;
        }
        if (WearUtils.e1(picUrl)) {
            shortVideoSelfViewHolder.userPicture.setImageResource(R.drawable.content_icon_picture_loading);
            shortVideoSelfViewHolder.loading.setVisibility(8);
            this.b.put(picUrl, shortVideoViewHolder.userPicture);
        } else {
            if (pictureBean != null && picUrl.equals(pictureBean.url) && zF == pictureBean.isHide) {
                return;
            }
            ImageLoader.getInstance().displayImage(WearUtils.e + picUrl, shortVideoViewHolder.userPicture, MyApplication.Y, new r(shortVideoSelfViewHolder, picUrl, shortVideoViewHolder, communMessage));
        }
    }

    public final void I(SystemViewHolder systemViewHolder, CommunMessage communMessage, DataEntityAbstract dataEntityAbstract, int i2, boolean z2) {
        mz1 mz1VarF = nz1.e().f();
        try {
            ((GradientDrawable) systemViewHolder.syncMessageLayout.getBackground()).setColor(mz1VarF.N());
        } catch (Exception e2) {
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
        systemViewHolder.tvSyncMessage.setTextColor(mz1VarF.f0());
        EntitySystem entitySystem = (EntitySystem) dataEntityAbstract;
        if (entitySystem.getFirstSysOPTType() != EntitySystem.SystemOPTType.T200) {
            if (entitySystem.getFirstSysOPTType() == EntitySystem.SystemOPTType.T300 && entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C320) {
                y(systemViewHolder, communMessage, z2);
            }
            return;
        }
        switch (t.b[entitySystem.getFirstSysOPTCode().ordinal()]) {
            case 1:
                if (!z2) {
                    systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.chat_pattern_sync_notice));
                    break;
                } else {
                    systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.chat_pattern_sync_own_notice));
                    break;
                }
            case 2:
                systemViewHolder.tvSyncMessage.setText(WearUtils.e1(entitySystem.getFirstString()) ? "" : entitySystem.getFirstString());
                break;
            case 3:
                String firstString = entitySystem.getFirstString();
                if (!WearUtils.e1(firstString) && firstString.indexOf("#") >= 0) {
                    firstString = firstString.substring(0, firstString.indexOf("#"));
                }
                systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.block_frends_message_tip), firstString));
                break;
            case 4:
                w(systemViewHolder, mz1VarF);
                break;
            case 5:
                systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_start_sync_sontrol), communMessage.getRealFromNickName()));
                break;
            case 6:
                systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.group_end_sync_control));
                break;
            case 7:
                systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.ds_control_started), communMessage.getRealFromNickName()));
                break;
            case 8:
                systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.ds_control_ended));
                break;
            case 9:
                systemViewHolder.tvSyncMessage.setText(entitySystem.getSystemMessage());
                break;
            case 10:
                x(systemViewHolder, mz1VarF, entitySystem);
                break;
        }
    }

    public final void J(UnsupportViewHolder unsupportViewHolder, CommunMessage communMessage, DataEntityAbstract dataEntityAbstract, int i2, boolean z2) {
        unsupportViewHolder.messageBlur.setVisibility(8);
        unsupportViewHolder.messageGlass.setVisibility(8);
        mz1 mz1VarF = nz1.e().f();
        if (z2) {
            Q(unsupportViewHolder.userMessage, mz1VarF.y());
            unsupportViewHolder.userMessage.setTextColor(mz1VarF.K());
        } else {
            Q(unsupportViewHolder.userMessage, mz1VarF.g0());
            unsupportViewHolder.userMessage.setTextColor(mz1VarF.h0());
        }
        if (this.l.F(communMessage.getId())) {
            unsupportViewHolder.userMessage.setOneUpdateToDraw(true);
        }
        unsupportViewHolder.userMessage.setText("\u3000  " + ah4.e(R.string.chat_message_old_version_tip));
        unsupportViewHolder.userMessage.invalidate();
        unsupportViewHolder.flUserMessage.invalidate();
        T(unsupportViewHolder.userImg, communMessage, z2 ? this.j : this.h.C());
        if (z2 || this.f == null || !(unsupportViewHolder.llRootAnima.getTag() instanceof ValueAnimator)) {
            return;
        }
        ((ValueAnimator) unsupportViewHolder.llRootAnima.getTag()).end();
    }

    public final void K(mz1 mz1Var, BaseViewHolder baseViewHolder, boolean z2) {
        baseViewHolder.chatItemTimeCreate.setTextColor(mz1Var.Z());
        try {
            ((GradientDrawable) baseViewHolder.chatItemTimeCreate.getBackground()).setColor(mz1Var.D());
        } catch (Exception e2) {
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    public final void L(String str, View view, Bitmap bitmap, String str2, CommunMessage communMessage, String str3, boolean z2, BaseViewHolder baseViewHolder) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if ((baseViewHolder instanceof PictureViewHolder) || (baseViewHolder instanceof ShortVideoViewHolder)) {
            PictureBean pictureBean = new PictureBean();
            pictureBean.url = str3;
            pictureBean.localUrl = str2;
            pictureBean.isHide = this.l.F(communMessage.getId());
            view.setTag(pictureBean);
            if (bitmap == null) {
                ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
                return;
            }
            int iA = ce3.a(this.d, 180.0f);
            int iA2 = ce3.a(this.d, 80.0f);
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
            GifImageView gifImageView = new GifImageView(this.d);
            gifImageView.setImageBitmap(bitmap);
            gifImageView.setLayoutParams(layoutParams2);
            this.a.put(str, gifImageView);
            this.k.put(communMessage.getId(), layoutParams2.width + SignatureImpl.INNER_SEP + layoutParams2.height);
            view.setLayoutParams(layoutParams2);
            this.b.put(str, view);
            if (z2) {
                ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
                layoutParams3.width = 200;
                layoutParams3.height = (bitmap.getHeight() * 200) / bitmap.getWidth();
                File file = ImageLoader.getInstance().getDiskCache().get(str);
                if (file.exists()) {
                    try {
                        GifDrawable gifDrawable = new GifDrawable(file);
                        if (baseViewHolder instanceof PictureViewHolder) {
                            ((PictureViewHolder) baseViewHolder).userPicture.setImageDrawable(gifDrawable);
                        } else if (baseViewHolder instanceof ShortVideoViewHolder) {
                            ((ShortVideoViewHolder) baseViewHolder).userPicture.setImageDrawable(gifDrawable);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public final void M(String str, View view, Bitmap bitmap, String str2, CommunMessage communMessage, String str3, boolean z2, BaseViewHolder baseViewHolder) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if ((baseViewHolder instanceof PictureViewHolder) || (baseViewHolder instanceof ShortVideoViewHolder)) {
            PictureBean pictureBean = new PictureBean();
            pictureBean.url = str3;
            pictureBean.localUrl = str2;
            pictureBean.isHide = this.l.F(communMessage.getId());
            view.setTag(pictureBean);
            if (bitmap == null) {
                ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
                return;
            }
            int iA = ce3.a(this.d, 180.0f);
            int iA2 = ce3.a(this.d, 80.0f);
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
            GifImageView gifImageView = new GifImageView(this.d);
            gifImageView.setImageBitmap(bitmap);
            gifImageView.setLayoutParams(layoutParams2);
            this.a.put(str, gifImageView);
            this.k.put(communMessage.getId(), layoutParams2.width + SignatureImpl.INNER_SEP + layoutParams2.height);
            view.setLayoutParams(layoutParams2);
            this.b.put(str, view);
            if (z2) {
                File file = ImageLoader.getInstance().getDiskCache().get(str);
                if (file.exists()) {
                    try {
                        GifDrawable gifDrawable = new GifDrawable(file);
                        if (baseViewHolder instanceof PictureViewHolder) {
                            ((PictureViewHolder) baseViewHolder).userPicture.setImageDrawable(gifDrawable);
                        } else if (baseViewHolder instanceof ShortVideoViewHolder) {
                            ((ShortVideoViewHolder) baseViewHolder).userPicture.setImageDrawable(gifDrawable);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, @SuppressLint({RecyclerView.TAG}) int i2) {
        int itemViewType = getItemViewType(i2) & 3072;
        CommunMessage communMessage = this.c.get(i2);
        DataEntityAbstract dataBean = communMessage.getDataBean();
        if (be3.G(communMessage.getCreated())) {
            if (i2 <= 0 || !be3.B(this.c.get(i2 - 1).getCreated(), communMessage.getCreated(), 1)) {
                baseViewHolder.chatItemTimeCreate.setVisibility(0);
                baseViewHolder.chatItemTimeCreate.setText(WearUtils.u0(communMessage.getCreated()));
            } else {
                baseViewHolder.chatItemTimeCreate.setVisibility(8);
            }
        } else if (i2 <= 0 || !be3.B(this.c.get(i2 - 1).getCreated(), communMessage.getCreated(), 1)) {
            baseViewHolder.chatItemTimeCreate.setVisibility(0);
            baseViewHolder.chatItemTimeCreate.setText(WearUtils.u0(communMessage.getCreated()));
        } else {
            baseViewHolder.chatItemTimeCreate.setVisibility(8);
        }
        baseViewHolder.longChatCreateLayout.setVisibility(baseViewHolder.chatItemTimeCreate.getVisibility());
        baseViewHolder.select_status_layout.setVisibility(0);
        v(baseViewHolder, communMessage);
        if (baseViewHolder instanceof ChatViewHolder) {
            B((ChatViewHolder) baseViewHolder, communMessage, dataBean, i2, 1024 == itemViewType);
        } else if (baseViewHolder instanceof SystemViewHolder) {
            I((SystemViewHolder) baseViewHolder, communMessage, dataBean, i2, 1024 == itemViewType);
        } else if (baseViewHolder instanceof ControlViewHolder) {
            C((ControlViewHolder) baseViewHolder, communMessage, dataBean, i2, 1024 == itemViewType);
        } else if (baseViewHolder instanceof AlarmViewHolder) {
            z((AlarmViewHolder) baseViewHolder, communMessage, dataBean, i2, 1024 == itemViewType);
        } else if (baseViewHolder instanceof PatternViewHolder) {
            F((PatternViewHolder) baseViewHolder, communMessage, dataBean, i2, 1024 == itemViewType);
        } else if (baseViewHolder instanceof PictureViewHolder) {
            G((PictureViewHolder) baseViewHolder, communMessage, dataBean, i2, 1024 == itemViewType);
        } else if (baseViewHolder instanceof AudioViewHolder) {
            A((AudioViewHolder) baseViewHolder, communMessage, dataBean, i2, 1024 == itemViewType);
        } else if (baseViewHolder instanceof ShortVideoViewHolder) {
            H((ShortVideoViewHolder) baseViewHolder, communMessage, dataBean, i2, 1024 == itemViewType);
        } else if (baseViewHolder instanceof UnsupportViewHolder) {
            J((UnsupportViewHolder) baseViewHolder, communMessage, dataBean, i2, 1024 == itemViewType);
        }
        k kVar = new k(this);
        View viewC = baseViewHolder.c();
        if (viewC != null) {
            viewC.setOnLongClickListener(kVar);
        }
        baseViewHolder.itemView.setOnClickListener(new u(communMessage, i2));
        K(nz1.e().f(), baseViewHolder, 1024 == itemViewType);
        if (1024 == itemViewType) {
            View viewB = baseViewHolder.b();
            if (viewB != null) {
                if (communMessage.isSendIng()) {
                    viewB.setVisibility(0);
                } else {
                    viewB.setVisibility(8);
                }
            }
            ImageView imageViewA = baseViewHolder.a();
            if (imageViewA != null) {
                imageViewA.setVisibility(8);
                if (u(communMessage.getId(), i2)) {
                    imageViewA.setVisibility(0);
                    return;
                }
                if (communMessage.getSendStatus() == 4) {
                    if (communMessage.getType().equals(MessageType.live) || communMessage.getType().equals(MessageType.sync) || communMessage.getType().equals(MessageType.video) || communMessage.getType().equals(MessageType.voice)) {
                        imageViewA.setVisibility(8);
                        imageViewA.setOnClickListener(null);
                    } else {
                        imageViewA.setVisibility(0);
                        imageViewA.setOnClickListener(new v(communMessage, i2));
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i2, @NonNull List<Object> list) {
        if (list.isEmpty()) {
            onBindViewHolder(baseViewHolder, i2);
            return;
        }
        CommunMessage communMessage = this.c.get(i2);
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals("isSelected", it.next().toString())) {
                v(baseViewHolder, communMessage);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        int i3 = i2 & 3072;
        switch (i2 & (-3073)) {
            case 1:
                return i3 == 1024 ? new ChatSelfViewHolder(this, LayoutInflater.from(this.d).inflate(R.layout.item_chat_self, viewGroup, false)) : new ChatFriendViewHolder(this, LayoutInflater.from(this.d).inflate(R.layout.item_chat_friend, viewGroup, false));
            case 2:
            case 3:
            case 6:
            case 7:
                return i3 == 1024 ? new ControlSelfViewHolder(this, LayoutInflater.from(this.d).inflate(R.layout.item_control_self, viewGroup, false)) : new ControlFriendViewHolder(this, LayoutInflater.from(this.d).inflate(R.layout.item_control_friend, viewGroup, false));
            case 4:
                return i3 == 1024 ? new AlarmSelfViewHolder(this, LayoutInflater.from(this.d).inflate(R.layout.item_alarm_self, viewGroup, false)) : new AlarmFriendViewHolder(this, LayoutInflater.from(this.d).inflate(R.layout.item_alarm_friend, viewGroup, false));
            case 5:
                return i3 == 1024 ? new AudioSelfViewHolder(this, LayoutInflater.from(this.d).inflate(R.layout.item_audio_self, viewGroup, false)) : new AudioFriendViewHolder(this, LayoutInflater.from(this.d).inflate(R.layout.item_audio_friend, viewGroup, false));
            case 8:
                return new SystemViewHolder(this, LayoutInflater.from(this.d).inflate(R.layout.item_system, viewGroup, false));
            case 9:
                return i3 == 1024 ? new PatternSelfViewHolder(this, LayoutInflater.from(this.d).inflate(R.layout.item_pattern_self, viewGroup, false)) : new PatternFriendViewHolder(this, LayoutInflater.from(this.d).inflate(R.layout.item_pattern_friend, viewGroup, false));
            case 10:
                return i3 == 1024 ? new PictureSelfViewHolder(this, LayoutInflater.from(this.d).inflate(R.layout.item_picture_self, viewGroup, false)) : new PictureFriendViewHolder(this, LayoutInflater.from(this.d).inflate(R.layout.item_picture_friend, viewGroup, false));
            case 11:
                return i3 == 1024 ? new ShortVideoSelfViewHolder(this, LayoutInflater.from(this.d).inflate(R.layout.item_short_video_self, viewGroup, false)) : new ShortVideoFriendViewHolder(this, LayoutInflater.from(this.d).inflate(R.layout.item_short_video_friend, viewGroup, false));
            case 12:
                return i3 == 1024 ? new UnsupportSelfViewHolder(this, LayoutInflater.from(this.d).inflate(R.layout.item_unsupport_self, viewGroup, false)) : new UnsupportFriendViewHolder(this, LayoutInflater.from(this.d).inflate(R.layout.item_unsupport_friend, viewGroup, false));
            default:
                return new DefalutViewHolder(this, LayoutInflater.from(this.d).inflate(R.layout.item_system, viewGroup, false));
        }
    }

    public final void Q(View view, int i2) {
        int paddingLeft = view.getPaddingLeft();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingBottom = view.getPaddingBottom();
        view.setBackground(th4.d(view.getContext(), i2));
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    @SuppressLint({"StringFormatMatches"})
    public final void R(MessageType messageType, ControlViewHolder controlViewHolder, int i2, int i3, String str, String str2, int i4, int i5, CommunMessage communMessage, int i6) {
        if (i3 == -1) {
            return;
        }
        S(controlViewHolder.iconControl, i5);
        controlViewHolder.tvControlTime.setVisibility(8);
        String userName = this.h.getUserName();
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
        controlViewHolder.controlMessage.setOnClickListener(new i(communMessage, i6));
    }

    public final void S(ImageView imageView, int i2) {
        imageView.setImageDrawable(th4.d(imageView.getContext(), i2));
    }

    public final String T(RoundedImageView roundedImageView, CommunMessage communMessage, IPeopleInfo iPeopleInfo) {
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
        kf.z(this.d).v(strM).a(this.e).A0(roundedImageView);
        return strM;
    }

    public final void U(ChatViewHolder chatViewHolder, int i2, int i3, int i4, String str) {
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

    public final void V(boolean z2, Object obj, String str) {
        this.d.runOnUiThread(new e(obj, z2, str));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        CommunMessage communMessage = this.c.get(i2);
        int i3 = !this.i.equals(WearUtils.X(communMessage.getFrom())) ? 2048 : 1024;
        if (communMessage.getType() != null) {
            switch (t.a[communMessage.getType().ordinal()]) {
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
            }
        }
        return i3 + 0;
    }

    public final void t(String str) {
        if (this.n) {
            this.n = false;
            this.o.postDelayed(new s(), 500L);
            if (this.h.o()) {
                return;
            }
            User userV = ch3.n().v(str);
            if (userV != null && userV.isFriend()) {
                sg3.i(this.d, R.string.add_friend_user_exist);
                return;
            }
            if (userV != null && userV.addSendToMe()) {
                sg3.k(this.d, String.format(ah4.e(R.string.add_friend_user_requested), userV.getUserName()));
                return;
            }
            if (userV == null) {
                userV = new User(str);
            }
            if (hu3.k(str)) {
                userV.addFriendType(2);
                sg3.i(this.d, R.string.user_add_success);
            }
        }
    }

    public final boolean u(String str, int i2) {
        if (i2 < getItemCount() - 1) {
            CommunMessage communMessage = this.c.get(i2 + 1);
            if (communMessage.getDataBean() != null && communMessage.getType() == MessageType.system) {
                EntitySystem entitySystem = (EntitySystem) communMessage.getDataBean();
                if (entitySystem.getFirstSysOPTType() == EntitySystem.SystemOPTType.T200 && ((entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C325 || entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C326 || entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C203 || entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C10000 || entitySystem.getFirstSysOPTCode() == EntitySystem.SystemOPTCode.C10001) && !WearUtils.e1(entitySystem.getFirstString()) && entitySystem.getFirstString().indexOf(str) > 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void v(BaseViewHolder baseViewHolder, CommunMessage communMessage) {
        if (ChatHistorySelectActivity.O.containsKey(communMessage.getId())) {
            baseViewHolder.select_status.setImageResource(R.drawable.chat_pattern_item_select);
        } else {
            baseViewHolder.select_status.setImageResource(R.drawable.chat_pattern_item_unselect);
        }
    }

    public final void w(SystemViewHolder systemViewHolder, mz1 mz1Var) {
        String str = String.format(ah4.e(R.string.delete_frends_message_tip_1), this.h.getUserName());
        String strE = ah4.e(R.string.delete_frends_message_tip_2);
        SpannableString spannableString = new SpannableString(str + strE + ah4.e(R.string.delete_frends_message_tip_3));
        spannableString.setSpan(new ForegroundColorSpan(mz1Var.G()), str.length(), str.length() + strE.length(), 17);
        spannableString.setSpan(new l(), str.length(), str.length() + strE.length(), 17);
        systemViewHolder.tvSyncMessage.setMovementMethod(LinkMovementMethod.getInstance());
        systemViewHolder.tvSyncMessage.setText(spannableString);
    }

    public final void x(SystemViewHolder systemViewHolder, mz1 mz1Var, EntitySystem entitySystem) {
        EntitySystem.C10001Json objectFromJson;
        int operationType;
        try {
            objectFromJson = entitySystem.getObjectFromJson();
            operationType = objectFromJson.getOperationType();
        } catch (Exception e2) {
            systemViewHolder.tvSyncMessage.setVisibility(8);
            e2.printStackTrace();
        }
        if (operationType == 110) {
            if (objectFromJson.getByWho().equals(ch3.n().p())) {
                systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.group_chat_created2));
                return;
            } else {
                systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_created1), objectFromJson.getByWhoNickName()));
                return;
            }
        }
        if (operationType == 301) {
            if (objectFromJson.getWhos().get(0).getWho().equals(ch3.n().p())) {
                systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.group_chat_left_note1));
                return;
            } else {
                systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_left_note2), objectFromJson.getByWhoNickName()));
                return;
            }
        }
        if (operationType == 304) {
            systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_left_note3), objectFromJson.getByWhoNickName(), objectFromJson.getWhos().get(0).getWhoNickName(), objectFromJson.getByWhoNickName()));
            return;
        }
        if (operationType == 306) {
            systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_left_note2), objectFromJson.getByWhoNickName()));
            return;
        }
        switch (operationType) {
            case 201:
                EntitySystem.C10001Json.WhoBean whoBean = objectFromJson.getWhos().get(0);
                if (whoBean.getWho().equals(ch3.n().p())) {
                    systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_make_admin1), objectFromJson.getByWhoNickName()));
                    break;
                } else {
                    systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_make_admin2), objectFromJson.getByWhoNickName(), whoBean.getWhoNickName()));
                    break;
                }
            case 202:
                EntitySystem.C10001Json.WhoBean whoBean2 = objectFromJson.getWhos().get(0);
                if (whoBean2.getWho().equals(ch3.n().p())) {
                    systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_dismiss_admin1), objectFromJson.getByWhoNickName()));
                    break;
                } else {
                    systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_dismiss_admin2), objectFromJson.getByWhoNickName(), whoBean2.getWhoNickName()));
                    break;
                }
            case 203:
                EntitySystem.C10001Json.WhoBean whoBean3 = objectFromJson.getWhos().get(0);
                if (whoBean3.getWho().equals(ch3.n().p())) {
                    systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_removed1), objectFromJson.getByWhoNickName()));
                    break;
                } else {
                    systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_removed2), objectFromJson.getByWhoNickName(), whoBean3.getWhoNickName()));
                    break;
                }
            case 204:
                EntitySystem.C10001Json.WhoBean whoBean4 = objectFromJson.getWhos().get(0);
                if (whoBean4.getWho().equals(ch3.n().p())) {
                    systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_added_member1), objectFromJson.getByWhoNickName()));
                    break;
                } else {
                    systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_added_member2), objectFromJson.getByWhoNickName(), whoBean4.getWhoNickName()));
                    break;
                }
            case 205:
                systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_joined), objectFromJson.getWhos().get(0).getWhoNickName()));
                break;
            default:
                String str = "";
                switch (operationType) {
                    case 10000:
                        Iterator<EntitySystem.C10001Json.WhoBean> it = objectFromJson.getWhos().iterator();
                        while (it.hasNext()) {
                            str = str + it.next().getWhoNickName() + "，";
                        }
                        systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_decline_invitation1), str.substring(0, str.length() - 1)));
                        break;
                    case 10001:
                        Iterator<EntitySystem.C10001Json.WhoBean> it2 = objectFromJson.getWhos().iterator();
                        while (it2.hasNext()) {
                            str = str + it2.next().getWhoNickName() + "，";
                        }
                        String strSubstring = str.substring(0, str.length() - 1);
                        String str2 = String.format(ah4.e(R.string.group_chat_decline_invitation2), strSubstring);
                        systemViewHolder.tvSyncMessage.setText(str2);
                        SpannableString spannableString = new SpannableString(str2);
                        int iIndexOf = str2.indexOf(strSubstring);
                        if (iIndexOf != -1) {
                            spannableString.setSpan(new ForegroundColorSpan(mz1Var.G()), iIndexOf, strSubstring.length() + iIndexOf, 17);
                        }
                        for (EntitySystem.C10001Json.WhoBean whoBean5 : objectFromJson.getWhos()) {
                            String whoNickName = whoBean5.getWhoNickName();
                            int iIndexOf2 = str2.indexOf(whoNickName);
                            if (iIndexOf2 != -1) {
                                spannableString.setSpan(new j(whoNickName, whoBean5.getWho()), iIndexOf2, whoNickName.length() + iIndexOf2, 17);
                            }
                        }
                        systemViewHolder.tvSyncMessage.setMovementMethod(LinkMovementMethod.getInstance());
                        systemViewHolder.tvSyncMessage.setText(spannableString);
                        break;
                    case RtmConstants.RTM_ERR_EXCEED_JOIN_TOPIC_LIMITATION /* 10002 */:
                        Iterator<EntitySystem.C10001Json.WhoBean> it3 = objectFromJson.getWhos().iterator();
                        while (it3.hasNext()) {
                            str = str + it3.next().getWhoNickName() + "，";
                        }
                        systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_wrong_version), str.substring(0, str.length() - 1)));
                        break;
                    case RtmConstants.RTM_ERR_INVALID_TOPIC_NAME /* 10003 */:
                        Iterator<EntitySystem.C10001Json.WhoBean> it4 = objectFromJson.getWhos().iterator();
                        while (it4.hasNext()) {
                            str = str + it4.next().getWhoNickName() + "，";
                        }
                        systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.group_chat_user_unavailable), str.substring(0, str.length() - 1)));
                        break;
                    case RtmConstants.RTM_ERR_PUBLISH_TOPIC_MESSAGE_FAILED /* 10004 */:
                        String whoNickName2 = objectFromJson.getWhos().get(0).getWhoNickName();
                        String str3 = String.format(ah4.e(R.string.group_chat_added_member2), objectFromJson.getByWhoNickName(), whoNickName2);
                        String str4 = String.format(ah4.e(R.string.group_chat_stranger_member), whoNickName2);
                        systemViewHolder.tvSyncMessage.setText(str3 + " . " + str4);
                        break;
                    case RtmConstants.RTM_ERR_EXCEED_SUBSCRIBE_TOPIC_LIMITATION /* 10005 */:
                        String whoNickName3 = objectFromJson.getWhos().get(0).getWhoNickName();
                        String str5 = String.format(ah4.e(R.string.group_chat_joined), whoNickName3);
                        String str6 = String.format(ah4.e(R.string.group_chat_stranger_member), whoNickName3);
                        systemViewHolder.tvSyncMessage.setText(str5 + str6);
                        break;
                }
        }
    }

    public final void y(SystemViewHolder systemViewHolder, CommunMessage communMessage, boolean z2) {
        String showNickName;
        if (z2) {
            systemViewHolder.tvSyncMessage.setText(ah4.e(R.string.chat_sync_recall_owner));
            return;
        }
        showNickName = "";
        IPeopleInfo iPeopleInfoC = this.h.C();
        if (iPeopleInfoC instanceof Group) {
            GroupMember memberByJid = ((Group) iPeopleInfoC).getMemberByJid(communMessage.getRealFrom());
            showNickName = memberByJid != null ? memberByJid.getNickName() : "";
            if (TextUtils.isEmpty(showNickName)) {
                showNickName = communMessage.getRealFromNickName();
            }
        } else if (this.d != null && this.h.C() != null) {
            showNickName = this.h.C().getShowNickName();
        }
        systemViewHolder.tvSyncMessage.setText(String.format(ah4.e(R.string.chat_sync_recall_pattern), showNickName));
    }

    public final void z(AlarmViewHolder alarmViewHolder, CommunMessage communMessage, DataEntityAbstract dataEntityAbstract, int i2, boolean z2) {
        mz1 mz1VarF = nz1.e().f();
        EntityAlarm entityAlarm = (EntityAlarm) dataEntityAbstract;
        alarmViewHolder.alarmTime.setText(be3.c(entityAlarm.getPattern().getTime(), WearUtils.x));
        alarmViewHolder.alarmRequency.setText(SetAlarmActivity.K4(entityAlarm.getPattern().getFrequency(), entityAlarm.getPattern().getDates() == null ? null : WearUtils.A.toJson(entityAlarm.getPattern().getDates())));
        boolean z3 = alarmViewHolder instanceof AlarmSelfViewHolder;
        T(alarmViewHolder.userImg, communMessage, z3 ? this.j : this.h.C());
        S(alarmViewHolder.ivAlarm, mz1VarF.j());
        if (!z3) {
            AlarmFriendViewHolder alarmFriendViewHolder = (AlarmFriendViewHolder) alarmViewHolder;
            alarmFriendViewHolder.alarmAutoPlay.setTextColor(mz1VarF.s());
            alarmFriendViewHolder.alarmDecline.setTextColor(mz1VarF.s());
            alarmFriendViewHolder.alarmAccept.setTextColor(mz1VarF.s());
            alarmFriendViewHolder.alarmActionLayout.setVisibility(0);
            alarmFriendViewHolder.alarmDecline.setEnabled(true);
            alarmFriendViewHolder.alarmAccept.setEnabled(true);
            alarmFriendViewHolder.alarmVerticalLine.setBackgroundColor(mz1VarF.Y());
            String status = communMessage.getStatus();
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
                    IPeopleInfo iPeopleInfoC = this.h.C();
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
            alarmFriendViewHolder.alarmDecline.setOnClickListener(new f(communMessage, i2));
            alarmFriendViewHolder.alarmAccept.setOnClickListener(new g(communMessage, i2));
        }
        alarmViewHolder.alarmMessage.setOnClickListener(new h(communMessage, i2));
        T(alarmViewHolder.userImg, communMessage, z2 ? this.j : this.h.C());
    }
}
