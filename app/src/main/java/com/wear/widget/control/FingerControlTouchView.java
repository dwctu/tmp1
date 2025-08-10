package com.wear.widget.control;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.lovense.wear.R;
import com.wear.bean.AnalyticsBean;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.control.TraditionalSeekBarView;
import dc.xe3;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* loaded from: classes4.dex */
public class FingerControlTouchView extends FrameLayout {
    public View a;
    public Animator.AnimatorListener b;
    public Timer c;
    public long d;
    public boolean e;
    public h f;
    public List<String> g;
    public int h;
    public boolean i;

    @BindView(R.id.iv_one)
    public ImageView ivOne;

    @BindView(R.id.iv_three)
    public ImageView ivThree;

    @BindView(R.id.iv_two)
    public ImageView ivTwo;
    public int j;
    public int k;
    public int l;

    @BindView(R.id.ll_traditional)
    public LinearLayout llTraditional;
    public int m;
    public String n;
    public int o;
    public boolean p;
    public int q;

    @BindView(R.id.rl_one)
    public RelativeLayout rlOne;

    @BindView(R.id.rl_three)
    public RelativeLayout rlThree;

    @BindView(R.id.rl_two)
    public RelativeLayout rlTwo;

    @BindView(R.id.v_one_line)
    public View vOneLine;

    @BindView(R.id.v_three_line)
    public View vThreeLine;

    @BindView(R.id.v_two_line)
    public View vTwoLine;

    @BindView(R.id.vb_one_vseek)
    public TraditionalSeekBarView vbOneVseek;

    @BindView(R.id.vb_three_vseek)
    public TraditionalSeekBarView vbThreeVseek;

    @BindView(R.id.vb_two_vseek)
    public TraditionalSeekBarView vbTwoVseek;

    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FingerControlTouchView fingerControlTouchView = FingerControlTouchView.this;
            fingerControlTouchView.j(true, fingerControlTouchView.a);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                FingerControlTouchView fingerControlTouchView = FingerControlTouchView.this;
                fingerControlTouchView.d++;
                fingerControlTouchView.n();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class c implements TraditionalSeekBarView.c {
        public c() {
        }

        @Override // com.wear.widget.control.TraditionalSeekBarView.c
        public void a() {
            if (FingerControlTouchView.this.f != null) {
                h hVar = FingerControlTouchView.this.f;
                FingerControlTouchView fingerControlTouchView = FingerControlTouchView.this;
                hVar.a(0L, fingerControlTouchView.n, fingerControlTouchView.vbOneVseek.getProgree(), FingerControlTouchView.this.vbTwoVseek.getProgree(), FingerControlTouchView.this.vbThreeVseek.getProgree(), true);
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FingerControlTouchView.this.i = false;
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public e(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            FingerControlTouchView fingerControlTouchView = FingerControlTouchView.this;
            RelativeLayout relativeLayout = fingerControlTouchView.rlOne;
            fingerControlTouchView.o(relativeLayout, true, (int) relativeLayout.getX(), this.a);
            FingerControlTouchView fingerControlTouchView2 = FingerControlTouchView.this;
            RelativeLayout relativeLayout2 = fingerControlTouchView2.rlTwo;
            fingerControlTouchView2.o(relativeLayout2, true, (int) relativeLayout2.getX(), this.b);
            FingerControlTouchView fingerControlTouchView3 = FingerControlTouchView.this;
            RelativeLayout relativeLayout3 = fingerControlTouchView3.rlThree;
            fingerControlTouchView3.o(relativeLayout3, true, (int) relativeLayout3.getX(), this.c);
        }
    }

    public class f implements View.OnTouchListener {
        public float a;
        public float b;
        public final /* synthetic */ View c;

        public f(View view) {
            this.c = view;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x00d2  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
            /*
                Method dump skipped, instructions count: 267
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.control.FingerControlTouchView.f.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public class g implements Animator.AnimatorListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ View b;

        public g(boolean z, View view) {
            this.a = z;
            this.b = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FingerControlTouchView.this.j(this.a, this.b);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public interface h {
        void a(long j, String str, int i, int i2, int i3, boolean z);
    }

    public FingerControlTouchView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0L;
        this.e = false;
        this.g = new ArrayList();
        this.h = 0;
        this.i = false;
        this.n = PSOProgramService.VS_Key;
        this.o = 1;
        View.inflate(context, R.layout.view_finger_control_touch, this);
        ButterKnife.bind(this);
        RelativeLayout relativeLayout = this.rlOne;
        this.a = relativeLayout;
        i(relativeLayout);
        setOnTouchViewListener(this.rlOne);
        setOnTouchViewListener(this.rlTwo);
        setOnTouchViewListener(this.rlThree);
        this.b = new a();
        this.vbOneVseek.setBg(R.drawable.v_seekbar_progress_left);
        this.vbOneVseek.setThumb(R.drawable.v_seekbar_thumb_one);
        this.vbTwoVseek.setFuc(PSOProgramService.VS_Key, 1);
        this.vbTwoVseek.setBg(R.drawable.v_seekbar_progress_right);
        this.vbTwoVseek.setThumb(R.drawable.v_seekbar_thumb_two);
        this.vbTwoVseek.setFuc(StreamManagement.AckRequest.ELEMENT, 2);
        this.vbThreeVseek.setBg(R.drawable.v_seekbar_progress_three);
        this.vbThreeVseek.setThumb(R.drawable.v_seekbar_thumb_three);
        this.vbThreeVseek.setFuc("p", 3);
        Timer timer = new Timer();
        this.c = timer;
        timer.scheduleAtFixedRate(new b(), 1000L, 100L);
        this.vbTwoVseek.setLister(new c());
    }

    private void setOnTouchViewListener(View view) {
        view.setOnTouchListener(new f(view));
    }

    public int getMode() {
        return this.q;
    }

    public final void i(View view) {
        if (view == this.rlOne) {
            view.setBackgroundResource(R.drawable.chat_toolbar_toyfunction_vibration_click);
            this.rlTwo.setBackground(null);
            this.rlThree.setBackground(null);
        } else if (view == this.rlTwo) {
            view.setBackgroundResource(R.drawable.chat_toolbar_toyfunction_rotation_click);
            this.rlOne.setBackground(null);
            this.rlThree.setBackground(null);
        } else {
            view.setBackgroundResource(R.drawable.chat_toolbar_toyfunction_contraction_click);
            this.rlTwo.setBackground(null);
            this.rlOne.setBackground(null);
        }
    }

    public final void j(boolean z, View view) {
        ObjectAnimator objectAnimatorOfFloat;
        if (!z) {
            if (view == this.rlOne) {
                this.vOneLine.setVisibility(4);
                return;
            } else if (view == this.rlTwo) {
                this.vTwoLine.setVisibility(4);
                return;
            } else {
                this.vThreeLine.setVisibility(4);
                return;
            }
        }
        if (view == this.rlOne) {
            this.vOneLine.setVisibility(0);
        } else if (view == this.rlTwo) {
            if (view.getVisibility() == 0) {
                this.vTwoLine.setVisibility(0);
            } else {
                this.vTwoLine.setVisibility(4);
            }
        } else if (view.getVisibility() == 0) {
            this.vThreeLine.setVisibility(0);
        } else {
            this.vThreeLine.setVisibility(4);
        }
        int y = (int) (view.getY() + (view.getHeight() / 2));
        AnimatorSet animatorSet = new AnimatorSet();
        if (view == this.rlOne) {
            View view2 = this.vOneLine;
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, FingImageLayout.ObjectAnimatorY, view2.getY(), y);
        } else if (view == this.rlTwo) {
            View view3 = this.vTwoLine;
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view3, FingImageLayout.ObjectAnimatorY, view3.getY(), y);
        } else {
            View view4 = this.vThreeLine;
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view4, FingImageLayout.ObjectAnimatorY, view4.getY(), y);
        }
        animatorSet.playTogether(objectAnimatorOfFloat);
        animatorSet.setDuration(0L);
        animatorSet.start();
    }

    public final int k(View view) {
        float y = view.getY();
        float height = this.m - view.getHeight();
        float f2 = height / 100.0f;
        if (y < 0.0f) {
            y = 0.0f;
        } else if (y > height) {
            y = height;
        }
        int i = (int) (100.0f - (y / f2));
        if (i < 0) {
            return 0;
        }
        if (i > 100) {
            return 100;
        }
        return i;
    }

    public final void l(View view) {
        int width = getWidth() / this.o;
        int width2 = (width / 2) - (view.getWidth() / 2);
        if (view != this.rlOne) {
            if (view == this.rlTwo) {
                width2 += width;
            } else if (view == this.rlThree) {
                width *= 2;
                width2 += width;
            } else {
                width2 = 0;
            }
        }
        o(view, false, width2, getHeight() - view.getHeight());
    }

    public final void m() {
        MyApplication myApplication = WearUtils.x;
        AnalyticsBean analyticsBean = myApplication.r;
        if (analyticsBean == null || !analyticsBean.usedTouchPannel) {
            return;
        }
        analyticsBean.usedTouchPannel = false;
        myApplication.q(analyticsBean.getEvenString(), null);
    }

    public final void n() throws NumberFormatException {
        int iK;
        int progree;
        String str = this.n;
        String[] strArrSplit = str.split(",");
        int iK2 = 0;
        if (this.p) {
            this.e = false;
            if (!this.g.isEmpty()) {
                this.g.clear();
            }
            progree = this.vbOneVseek.getProgree();
            if (strArrSplit.length == 3) {
                iK2 = this.vbTwoVseek.getProgree();
                iK = this.vbThreeVseek.getProgree();
            } else if (strArrSplit.length != 2) {
                iK = 0;
            } else if (str.contains(StreamManagement.AckRequest.ELEMENT)) {
                iK2 = this.vbTwoVseek.getProgree();
                iK = 0;
            } else {
                iK = this.vbTwoVseek.getProgree();
            }
        } else if (!this.e || this.g.isEmpty()) {
            int iK3 = k(this.rlOne);
            if (strArrSplit.length == 3) {
                iK2 = k(this.rlTwo);
                iK = k(this.rlThree);
            } else if (strArrSplit.length != 2) {
                iK = 0;
            } else if (str.contains(StreamManagement.AckRequest.ELEMENT)) {
                iK2 = k(this.rlTwo);
                iK = 0;
            } else {
                iK = k(this.rlTwo);
            }
            if (this.q == 1) {
                this.g.add(iK3 + "," + iK2 + "," + iK);
            } else if (!this.g.isEmpty()) {
                this.g.clear();
            }
            progree = iK3;
        } else {
            List<String> list = this.g;
            int i = this.h;
            this.h = i + 1;
            String[] strArrSplit2 = list.get(i % list.size()).split(",");
            progree = Integer.parseInt(strArrSplit2[0]);
            iK2 = Integer.parseInt(strArrSplit2[1]);
            iK = Integer.parseInt(strArrSplit2[2]);
        }
        if (!this.i) {
            this.j = progree;
            this.k = iK2;
            this.l = iK;
        }
        h hVar = this.f;
        if (hVar != null) {
            hVar.a(this.d, this.n, this.j, this.k, this.l, false);
        }
    }

    public final void o(View view, boolean z, int i, int i2) {
        p(view, z, i, i2, 0L);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.m = i2;
        if (this.q != 2 || this.p) {
            return;
        }
        int height = this.rlOne.getHeight();
        float f2 = i4 - height;
        int i5 = i2 - height;
        float f3 = i5;
        int y = (int) ((this.rlOne.getY() / f2) * f3);
        if (y < 0) {
            y = 0;
        } else if (y > i5) {
            y = i5;
        }
        int y2 = (int) ((this.rlTwo.getY() / f2) * f3);
        if (y2 < 0) {
            y2 = 0;
        } else if (y2 > i5) {
            y2 = i5;
        }
        int y3 = (int) ((this.rlThree.getY() / f2) * f3);
        if (y3 < 0) {
            i5 = 0;
        } else if (y3 <= i5) {
            i5 = y3;
        }
        new Handler(Looper.getMainLooper()).post(new e(y, y2, i5));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d5  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.control.FingerControlTouchView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(View view, boolean z, int i, int i2, long j) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, "x", view.getX(), i), ObjectAnimator.ofFloat(view, FingImageLayout.ObjectAnimatorY, view.getY(), i2));
        animatorSet.setDuration(j);
        animatorSet.start();
        animatorSet.addListener(new g(z, view));
    }

    public final void q(View view) {
        if (this.q != 2) {
            l(view);
        }
    }

    public void setListener(h hVar) {
        this.f = hVar;
    }

    public void setShowMore() {
        xe3.a("FingerControlTouchView", "setShowMore比例 " + this.rlOne.getY());
        this.i = true;
        new Handler(Looper.getMainLooper()).postDelayed(new d(), 100L);
    }
}
