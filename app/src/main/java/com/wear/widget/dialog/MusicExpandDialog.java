package com.wear.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.main.closeRange.music.MusicControl;
import dc.ag3;
import dc.is3;
import dc.th4;

/* loaded from: classes4.dex */
public class MusicExpandDialog extends FullScreenDialog<c> {

    @BindView(R.id.ll_expand_bg)
    public LinearLayout LLExpandBg;

    @BindView(R.id.fl_root_view)
    public FrameLayout flRootView;
    public d g;

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

    @BindView(R.id.tv_time)
    public TextView tvTime;

    @BindView(R.id.tv_name)
    public TextView tvUserName;

    public class a implements Runnable {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            Animation animationLoadAnimation;
            MusicExpandDialog.this.LLExpandBg.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) MusicExpandDialog.this.LLExpandBg.getLayoutParams();
            MusicExpandDialog musicExpandDialog = MusicExpandDialog.this;
            int i = ((c) musicExpandDialog.c).a;
            layoutParams.topMargin = i;
            if (i < 0) {
                layoutParams.topMargin = 0;
            } else if (i > musicExpandDialog.flRootView.getHeight() - MusicExpandDialog.this.LLExpandBg.getHeight()) {
                layoutParams.topMargin = MusicExpandDialog.this.flRootView.getHeight() - MusicExpandDialog.this.LLExpandBg.getHeight();
            }
            MusicExpandDialog musicExpandDialog2 = MusicExpandDialog.this;
            if (((c) musicExpandDialog2.c).b) {
                layoutParams.gravity = 3;
                musicExpandDialog2.LLExpandBg.setBackgroundResource(R.drawable.minimize_expand_left_big);
                animationLoadAnimation = AnimationUtils.loadAnimation(MusicExpandDialog.this.LLExpandBg.getContext(), R.anim.slide_left);
            } else {
                layoutParams.gravity = 5;
                musicExpandDialog2.LLExpandBg.setBackgroundResource(R.drawable.minimize_expand_right_big);
                animationLoadAnimation = AnimationUtils.loadAnimation(MusicExpandDialog.this.LLExpandBg.getContext(), R.anim.slide_right);
            }
            MusicExpandDialog musicExpandDialog3 = MusicExpandDialog.this;
            musicExpandDialog3.tvUserName.setText(((c) musicExpandDialog3.c).d);
            MusicExpandDialog musicExpandDialog4 = MusicExpandDialog.this;
            musicExpandDialog4.ivIcon.setImageResource(((c) musicExpandDialog4.c).c);
            MusicExpandDialog.this.LLExpandBg.setLayoutParams(layoutParams);
            MusicExpandDialog.this.LLExpandBg.startAnimation(animationLoadAnimation);
        }
    }

    public class b implements DialogInterface.OnDismissListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            DialogInterface.OnDismissListener onDismissListener = MusicExpandDialog.this.a.i;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
    }

    public static class c {
        public int a;
        public boolean b;
        public int c;
        public String d;
    }

    public interface d {
        void a();

        void b();

        void c();

        void end();
    }

    public MusicExpandDialog(Context context) {
        super(context);
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_general_float_expand;
    }

    @Override // dc.is3
    public void i() {
        super.i();
        new ag3(this.f);
        if (MusicControl.h0().f != null && MusicControl.h0().f.getMusicType() == 2) {
            this.ivPrevious.setImageDrawable(th4.d(this.b, R.drawable.music_icon_previous_disable));
            this.ivNext.setImageDrawable(th4.d(this.b, R.drawable.music_icon_next_disable));
            this.ivPlayOrPause.setImageResource(R.drawable.pattern_play_pause);
        }
        this.flRootView.post(new a());
        setOnDismissListener(new b());
    }

    @OnClick({R.id.iv_bg, R.id.iv_end, R.id.ll_expand_bg, R.id.iv_play_or_pause, R.id.iv_next, R.id.iv_previous})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_bg /* 2131363102 */:
                dismiss();
                is3.c cVar = this.a.h;
                if (cVar != null) {
                    cVar.doCancel();
                    break;
                }
                break;
            case R.id.iv_end /* 2131363161 */:
                d dVar = this.g;
                if (dVar != null) {
                    dVar.end();
                    dismiss();
                    break;
                }
                break;
            case R.id.iv_next /* 2131363219 */:
                d dVar2 = this.g;
                if (dVar2 != null) {
                    dVar2.c();
                    break;
                }
                break;
            case R.id.iv_play_or_pause /* 2131363258 */:
                d dVar3 = this.g;
                if (dVar3 != null) {
                    dVar3.a();
                    break;
                }
                break;
            case R.id.iv_previous /* 2131363265 */:
                d dVar4 = this.g;
                if (dVar4 != null) {
                    dVar4.b();
                    break;
                }
                break;
            case R.id.ll_expand_bg /* 2131363509 */:
                dismiss();
                is3.a aVar = this.a;
                if (aVar.h != null) {
                    aVar.g.doConfirm();
                    break;
                }
                break;
        }
    }

    public void setListener(d dVar) {
        this.g = dVar;
    }
}
