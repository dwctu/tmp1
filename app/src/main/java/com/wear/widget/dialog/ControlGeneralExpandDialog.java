package com.wear.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import butterknife.BindView;
import butterknife.OnClick;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.lovense.wear.R;
import com.wear.bean.event.GeneralExpandDialogUpdateEvent;
import com.wear.widget.dialog.ControlGeneralExpandDialog;
import dc.ExpandData;
import dc.ah4;
import dc.is3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ControlGeneralExpandDialog.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 U2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002UVB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0002J\b\u0010?\u001a\u00020@H\u0014J\b\u0010A\u001a\u00020BH\u0014J\u0010\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020EH\u0007J\u0012\u0010F\u001a\u00020B2\b\u0010G\u001a\u0004\u0018\u00010HH\u0014J\u0012\u0010I\u001a\u00020B2\b\u0010J\u001a\u0004\u0018\u00010KH\u0007J\u0018\u0010L\u001a\u00020B2\u0006\u0010M\u001a\u00020<2\u0006\u0010N\u001a\u00020>H\u0002J\u0010\u0010O\u001a\u00020B2\u0006\u0010P\u001a\u00020QH\u0002J\u0010\u0010R\u001a\u00020B2\u0006\u0010S\u001a\u00020>H\u0002J\u0018\u0010T\u001a\u00020B2\u0006\u0010N\u001a\u00020>2\u0006\u0010S\u001a\u00020>H\u0002R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001e\u0010\u0017\u001a\u00020\u000f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001e\u0010\u001a\u001a\u00020\u000f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001e\u0010\u001d\u001a\u00020\u000f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001e\u0010 \u001a\u00020\u000f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001e\u0010#\u001a\u00020\u000f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010,\u001a\u00020-8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u00102\u001a\u0002038\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001e\u00108\u001a\u0002038\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00105\"\u0004\b:\u00107¨\u0006W"}, d2 = {"Lcom/wear/widget/dialog/ControlGeneralExpandDialog;", "Lcom/wear/widget/dialog/FullScreenDialog;", "Lcom/wear/main/control/ExpandData;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "flRootView", "Landroid/widget/FrameLayout;", "getFlRootView", "()Landroid/widget/FrameLayout;", "setFlRootView", "(Landroid/widget/FrameLayout;)V", "handler", "Landroid/os/Handler;", "ivBg", "Landroid/widget/ImageView;", "getIvBg", "()Landroid/widget/ImageView;", "setIvBg", "(Landroid/widget/ImageView;)V", "ivEnd", "getIvEnd", "setIvEnd", "ivIcon", "getIvIcon", "setIvIcon", "ivNext", "getIvNext", "setIvNext", "ivPlayOrPause", "getIvPlayOrPause", "setIvPlayOrPause", "ivPrevious", "getIvPrevious", "setIvPrevious", "ivUnderPreview", "getIvUnderPreview", "setIvUnderPreview", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/wear/widget/dialog/ControlGeneralExpandDialog$Listener;", "getListener", "()Lcom/wear/widget/dialog/ControlGeneralExpandDialog$Listener;", "setListener", "(Lcom/wear/widget/dialog/ControlGeneralExpandDialog$Listener;)V", "llExpandBg", "Landroid/widget/LinearLayout;", "getLlExpandBg", "()Landroid/widget/LinearLayout;", "setLlExpandBg", "(Landroid/widget/LinearLayout;)V", "tvName", "Landroid/widget/TextView;", "getTvName", "()Landroid/widget/TextView;", "setTvName", "(Landroid/widget/TextView;)V", "tvTime", "getTvTime", "setTvTime", "formatDate", "", "time", "", "getLayoutResID", "", "initData", "", "onClick", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onMessageEvent", "event", "Lcom/wear/bean/event/GeneralExpandDialogUpdateEvent;", "onMetadataChanged", "name", TypedValues.TransitionType.S_DURATION, "onPlaybackStateChanged", "status", "", "onUpdateProgress", "position", "updateDownTime", "Companion", "Listener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class ControlGeneralExpandDialog extends FullScreenDialog<ExpandData> {

    @NotNull
    public static final a i = new a(null);

    @BindView(R.id.fl_root_view)
    public FrameLayout flRootView;

    @Nullable
    public b g;

    @Nullable
    public Handler h;

    @BindView(R.id.iv_bg)
    public ImageView ivBg;

    @BindView(R.id.iv_end)
    public ImageView ivEnd;

    @BindView(R.id.iv_icon)
    public ImageView ivIcon;

    @BindView(R.id.iv_next)
    public ImageView ivNext;

    @BindView(R.id.iv_play_or_pause)
    public ImageView ivPlayOrPause;

    @BindView(R.id.iv_previous)
    public ImageView ivPrevious;

    @BindView(R.id.iv_under_preview)
    public ImageView ivUnderPreview;

    @BindView(R.id.ll_expand_bg)
    public LinearLayout llExpandBg;

    @BindView(R.id.tv_name)
    public TextView tvName;

    @BindView(R.id.tv_time)
    public TextView tvTime;

    /* compiled from: ControlGeneralExpandDialog.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/wear/widget/dialog/ControlGeneralExpandDialog$Companion;", "", "()V", "UPDATE_PROGRESS", "", "changeMetaData", "", "name", "", TypedValues.TransitionType.S_DURATION, "", "changeStatus", "status", "", "updateProgress", "position", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull String name, long j) {
            Intrinsics.checkNotNullParameter(name, "name");
            EventBus.getDefault().post(new GeneralExpandDialogUpdateEvent(name, Long.valueOf(j), null, null));
        }

        public final void b(boolean z) {
            EventBus.getDefault().post(new GeneralExpandDialogUpdateEvent(null, null, Boolean.valueOf(z), null));
        }

        public final void c(long j) {
            EventBus.getDefault().post(new GeneralExpandDialogUpdateEvent(null, null, null, Long.valueOf(j)));
        }
    }

    /* compiled from: ControlGeneralExpandDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/wear/widget/dialog/ControlGeneralExpandDialog$Listener;", "", TtmlNode.END, "", "next", "playOrPause", "previous", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface b {
        void a();

        void end();

        void next();

        void previous();
    }

    /* compiled from: ControlGeneralExpandDialog.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/wear/widget/dialog/ControlGeneralExpandDialog$initData$1", "Landroid/os/Handler;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            super.handleMessage(msg);
            if (msg.what == 15) {
                D d = ControlGeneralExpandDialog.this.c;
                ((ExpandData) d).m(((ExpandData) d).getPosition() + 200);
                ControlGeneralExpandDialog controlGeneralExpandDialog = ControlGeneralExpandDialog.this;
                controlGeneralExpandDialog.G(((ExpandData) controlGeneralExpandDialog.c).getDuration(), ((ExpandData) ControlGeneralExpandDialog.this.c).getPosition());
                sendEmptyMessageDelayed(15, 200L);
            }
        }
    }

    public ControlGeneralExpandDialog(@Nullable Context context) {
        super(context);
    }

    public static final void A(ControlGeneralExpandDialog this$0, DialogInterface dialogInterface) {
        DialogInterface.OnDismissListener onDismissListener;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Handler handler = this$0.h;
        if (handler != null) {
            handler.removeMessages(15);
        }
        EventBus.getDefault().unregister(this$0);
        is3.a aVar = this$0.a;
        if (aVar == null || (onDismissListener = aVar.i) == null) {
            return;
        }
        onDismissListener.onDismiss(dialogInterface);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void z(ControlGeneralExpandDialog this$0) throws Resources.NotFoundException {
        Animation animationLoadAnimation;
        Handler handler;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w().setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this$0.w().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        int y = ((ExpandData) this$0.c).getY();
        layoutParams2.topMargin = y;
        if (y < 0) {
            layoutParams2.topMargin = 0;
        } else if (y > this$0.s().getHeight() - this$0.w().getHeight()) {
            layoutParams2.topMargin = this$0.s().getHeight() - this$0.w().getHeight();
        }
        if (((ExpandData) this$0.c).getLeft()) {
            layoutParams2.gravity = 3;
            this$0.w().setBackgroundResource(R.drawable.minimize_expand_left_big);
            animationLoadAnimation = AnimationUtils.loadAnimation(this$0.w().getContext(), R.anim.slide_left);
            Intrinsics.checkNotNullExpressionValue(animationLoadAnimation, "loadAnimation(\n         …de_left\n                )");
        } else {
            layoutParams2.gravity = 5;
            this$0.w().setBackgroundResource(R.drawable.minimize_expand_right_big);
            animationLoadAnimation = AnimationUtils.loadAnimation(this$0.w().getContext(), R.anim.slide_right);
            Intrinsics.checkNotNullExpressionValue(animationLoadAnimation, "loadAnimation(\n         …e_right\n                )");
        }
        this$0.t().setImageResource(((ExpandData) this$0.c).getIcon());
        this$0.w().setLayoutParams(layoutParams2);
        this$0.w().startAnimation(animationLoadAnimation);
        if (((ExpandData) this$0.c).getIsUnderPreview() == 1) {
            this$0.v().setVisibility(0);
            this$0.x().setText(ah4.e(R.string.patterns_under_review));
        } else {
            this$0.v().setVisibility(8);
            this$0.x().setText(TextUtils.isEmpty(((ExpandData) this$0.c).getName()) ? "" : ((ExpandData) this$0.c).getName());
        }
        this$0.G(((ExpandData) this$0.c).getDuration(), ((ExpandData) this$0.c).getPosition());
        this$0.u().setImageResource(((ExpandData) this$0.c).getStatus() ? R.drawable.ic_expand_pause : R.drawable.ic_expand_play);
        if (!((ExpandData) this$0.c).getStatus() || (handler = this$0.h) == null) {
            return;
        }
        handler.sendEmptyMessageDelayed(15, 200L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D(String str, long j) {
        ((ExpandData) this.c).l(str);
        ((ExpandData) this.c).i(j);
        ((ExpandData) this.c).m(0L);
        x().setText(TextUtils.isEmpty(((ExpandData) this.c).getName()) ? "" : ((ExpandData) this.c).getName());
        if (((ExpandData) this.c).getDuration() != -1) {
            G(((ExpandData) this.c).getDuration(), ((ExpandData) this.c).getPosition());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void E(boolean z) {
        ((ExpandData) this.c).n(z);
        if (!((ExpandData) this.c).getStatus()) {
            Handler handler = this.h;
            if (handler != null) {
                handler.removeMessages(15);
            }
            u().setImageResource(R.drawable.ic_expand_play);
            return;
        }
        Handler handler2 = this.h;
        if (handler2 != null) {
            handler2.removeMessages(15);
        }
        Handler handler3 = this.h;
        if (handler3 != null) {
            handler3.sendEmptyMessageDelayed(15, 200L);
        }
        u().setImageResource(R.drawable.ic_expand_pause);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F(long j) {
        ((ExpandData) this.c).m(j);
        G(((ExpandData) this.c).getDuration(), ((ExpandData) this.c).getPosition());
    }

    public final void G(long j, long j2) {
        y().setText(r((j - j2) / 1000));
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_general_float_expand;
    }

    @Override // dc.is3
    public void i() {
        super.i();
        this.h = new c(Looper.getMainLooper());
        s().post(new Runnable() { // from class: dc.xp3
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                ControlGeneralExpandDialog.z(this.a);
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: dc.wp3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ControlGeneralExpandDialog.A(this.a, dialogInterface);
            }
        });
    }

    @OnClick({R.id.iv_bg, R.id.iv_end, R.id.ll_expand_bg, R.id.iv_play_or_pause, R.id.iv_next, R.id.iv_previous})
    public final void onClick(@NotNull View view) {
        is3.c cVar;
        is3.d dVar;
        Intrinsics.checkNotNullParameter(view, "view");
        switch (view.getId()) {
            case R.id.iv_bg /* 2131363102 */:
                dismiss();
                is3.a aVar = this.a;
                if (aVar != null && (cVar = aVar.h) != null) {
                    cVar.doCancel();
                    break;
                }
                break;
            case R.id.iv_end /* 2131363161 */:
                dismiss();
                b bVar = this.g;
                if (bVar != null) {
                    bVar.end();
                    break;
                }
                break;
            case R.id.iv_next /* 2131363219 */:
                b bVar2 = this.g;
                if (bVar2 != null) {
                    bVar2.next();
                    break;
                }
                break;
            case R.id.iv_play_or_pause /* 2131363258 */:
                b bVar3 = this.g;
                if (bVar3 != null) {
                    bVar3.a();
                    break;
                }
                break;
            case R.id.iv_previous /* 2131363265 */:
                b bVar4 = this.g;
                if (bVar4 != null) {
                    bVar4.previous();
                    break;
                }
                break;
            case R.id.ll_expand_bg /* 2131363509 */:
                dismiss();
                is3.a aVar2 = this.a;
                if (aVar2 != null && (dVar = aVar2.g) != null) {
                    dVar.doConfirm();
                    break;
                }
                break;
        }
    }

    @Override // dc.is3, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(@Nullable GeneralExpandDialogUpdateEvent event) {
        if (event != null) {
            if (event.getName() != null && event.getDuration() != null) {
                String name = event.getName();
                Intrinsics.checkNotNull(name);
                Long duration = event.getDuration();
                Intrinsics.checkNotNull(duration);
                D(name, duration.longValue());
            }
            if (event.getStatus() != null) {
                Boolean status = event.getStatus();
                Intrinsics.checkNotNull(status);
                E(status.booleanValue());
            }
            if (event.getPosition() != null) {
                Long position = event.getPosition();
                Intrinsics.checkNotNull(position);
                F(position.longValue());
            }
        }
    }

    public final String r(long j) {
        StringBuilder sb = new StringBuilder();
        if (j == 0) {
            sb.append("00:00");
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "builder.append(\"00:00\").toString()");
            return string;
        }
        long j2 = 60;
        long j3 = j / j2;
        if (j3 < 10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('0');
            sb2.append(j3);
            sb.append(sb2.toString());
        } else {
            sb.append(j3);
        }
        sb.append(" : ");
        long j4 = j % j2;
        if (j4 < 10) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append('0');
            sb3.append(j4);
            sb.append(sb3.toString());
        } else {
            sb.append(j4);
        }
        String string2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "builder.toString()");
        return string2;
    }

    @NotNull
    public final FrameLayout s() {
        FrameLayout frameLayout = this.flRootView;
        if (frameLayout != null) {
            return frameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("flRootView");
        return null;
    }

    public final void setFlRootView(@NotNull FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.flRootView = frameLayout;
    }

    public final void setIvBg(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
    }

    public final void setIvEnd(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
    }

    public final void setIvIcon(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivIcon = imageView;
    }

    public final void setIvNext(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
    }

    public final void setIvPlayOrPause(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivPlayOrPause = imageView;
    }

    public final void setIvPrevious(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
    }

    public final void setIvUnderPreview(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivUnderPreview = imageView;
    }

    public final void setListener(@Nullable b bVar) {
        this.g = bVar;
    }

    public final void setLlExpandBg(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.llExpandBg = linearLayout;
    }

    public final void setTvName(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvName = textView;
    }

    public final void setTvTime(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvTime = textView;
    }

    @NotNull
    public final ImageView t() {
        ImageView imageView = this.ivIcon;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
        return null;
    }

    @NotNull
    public final ImageView u() {
        ImageView imageView = this.ivPlayOrPause;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivPlayOrPause");
        return null;
    }

    @NotNull
    public final ImageView v() {
        ImageView imageView = this.ivUnderPreview;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivUnderPreview");
        return null;
    }

    @NotNull
    public final LinearLayout w() {
        LinearLayout linearLayout = this.llExpandBg;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("llExpandBg");
        return null;
    }

    @NotNull
    public final TextView x() {
        TextView textView = this.tvName;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvName");
        return null;
    }

    @NotNull
    public final TextView y() {
        TextView textView = this.tvTime;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvTime");
        return null;
    }
}
