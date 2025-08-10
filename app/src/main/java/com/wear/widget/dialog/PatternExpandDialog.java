package com.wear.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
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
import dc.ExpandData;
import dc.ag3;
import dc.is3;

/* loaded from: classes4.dex */
public class PatternExpandDialog extends FullScreenDialog<ExpandData> {

    @BindView(R.id.ll_expand_bg)
    public LinearLayout LLExpandBg;

    @BindView(R.id.fl_root_view)
    public FrameLayout flRootView;
    public c g;

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
    public ImageView iv_under_preview;

    @BindView(R.id.tv_name)
    public TextView tvPatternName;

    @BindView(R.id.tv_time)
    public TextView tvTime;

    public class a implements Runnable {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            Animation animationLoadAnimation;
            PatternExpandDialog.this.LLExpandBg.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PatternExpandDialog.this.LLExpandBg.getLayoutParams();
            int y = ((ExpandData) PatternExpandDialog.this.c).getY();
            layoutParams.topMargin = y;
            if (y < 0) {
                layoutParams.topMargin = 0;
            } else if (y > PatternExpandDialog.this.flRootView.getHeight() - PatternExpandDialog.this.LLExpandBg.getHeight()) {
                layoutParams.topMargin = PatternExpandDialog.this.flRootView.getHeight() - PatternExpandDialog.this.LLExpandBg.getHeight();
            }
            if (((ExpandData) PatternExpandDialog.this.c).getLeft()) {
                layoutParams.gravity = 3;
                PatternExpandDialog.this.LLExpandBg.setBackgroundResource(R.drawable.minimize_expand_left_big);
                animationLoadAnimation = AnimationUtils.loadAnimation(PatternExpandDialog.this.LLExpandBg.getContext(), R.anim.slide_left);
            } else {
                layoutParams.gravity = 5;
                PatternExpandDialog.this.LLExpandBg.setBackgroundResource(R.drawable.minimize_expand_right_big);
                animationLoadAnimation = AnimationUtils.loadAnimation(PatternExpandDialog.this.LLExpandBg.getContext(), R.anim.slide_right);
            }
            PatternExpandDialog patternExpandDialog = PatternExpandDialog.this;
            patternExpandDialog.ivIcon.setImageResource(((ExpandData) patternExpandDialog.c).getIcon());
            PatternExpandDialog.this.LLExpandBg.setLayoutParams(layoutParams);
            PatternExpandDialog.this.LLExpandBg.startAnimation(animationLoadAnimation);
            if (((ExpandData) PatternExpandDialog.this.c).getIsUnderPreview() == 1) {
                PatternExpandDialog.this.iv_under_preview.setVisibility(0);
                PatternExpandDialog.this.tvPatternName.setText(R.string.patterns_under_review);
            } else {
                PatternExpandDialog.this.iv_under_preview.setVisibility(8);
                PatternExpandDialog patternExpandDialog2 = PatternExpandDialog.this;
                patternExpandDialog2.tvPatternName.setText(TextUtils.isEmpty(((ExpandData) patternExpandDialog2.c).getName()) ? "" : ((ExpandData) PatternExpandDialog.this.c).getName());
            }
        }
    }

    public class b implements DialogInterface.OnDismissListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            DialogInterface.OnDismissListener onDismissListener = PatternExpandDialog.this.a.i;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
    }

    public interface c {
        void a();

        void b();

        void c();

        void end();
    }

    public PatternExpandDialog(Context context) {
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
                c cVar2 = this.g;
                if (cVar2 != null) {
                    cVar2.end();
                    dismiss();
                    break;
                }
                break;
            case R.id.iv_next /* 2131363219 */:
                c cVar3 = this.g;
                if (cVar3 != null) {
                    cVar3.b();
                    break;
                }
                break;
            case R.id.iv_play_or_pause /* 2131363258 */:
                c cVar4 = this.g;
                if (cVar4 != null) {
                    cVar4.a();
                    break;
                }
                break;
            case R.id.iv_previous /* 2131363265 */:
                c cVar5 = this.g;
                if (cVar5 != null) {
                    cVar5.c();
                    break;
                }
                break;
            case R.id.ll_expand_bg /* 2131363509 */:
                dismiss();
                is3.d dVar = this.a.g;
                if (dVar != null) {
                    dVar.doConfirm();
                    break;
                }
                break;
        }
    }

    public void setListener(c cVar) {
        this.g = cVar;
    }
}
