package com.wear.widget.control;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.lovense.wear.R;
import com.wear.bean.AnalyticsBean;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.th4;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* loaded from: classes4.dex */
public class TraditionalSeekBarView extends FrameLayout {
    public Context a;
    public c b;
    public String c;
    public boolean d;

    @BindView(R.id.iv_icon)
    public ImageView ivIcon;

    @BindView(R.id.ll_icon)
    public LinearLayout llIcon;

    @BindView(R.id.tv_fuc)
    public TextView tvFuc;

    @BindView(R.id.vseekBar)
    public VerticalSeekBar vseekBar;

    @BindView(R.id.vseekBar_bg)
    public TraditionalSeekBarViewBg vseekBarBg;

    public class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            MyApplication myApplication;
            AnalyticsBean analyticsBean;
            int i2 = i + 5;
            TraditionalSeekBarViewBg traditionalSeekBarViewBg = TraditionalSeekBarView.this.vseekBarBg;
            if (i2 > 100) {
                i2 = 100;
            }
            traditionalSeekBarViewBg.setProgress(i2);
            if (i == 0 || (analyticsBean = (myApplication = WearUtils.x).r) == null || !analyticsBean.usedSliderPannel) {
                return;
            }
            analyticsBean.usedSliderPannel = false;
            myApplication.q(analyticsBean.getEvenString(), null);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (StreamManagement.AckRequest.ELEMENT.equals(TraditionalSeekBarView.this.c)) {
                TraditionalSeekBarView traditionalSeekBarView = TraditionalSeekBarView.this;
                if (traditionalSeekBarView.b != null) {
                    boolean z = !traditionalSeekBarView.d;
                    traditionalSeekBarView.d = z;
                    if (z) {
                        traditionalSeekBarView.ivIcon.setImageDrawable(th4.d(traditionalSeekBarView.getContext(), R.drawable.chat_traditional_rotation_anticlockwise_blue));
                    } else {
                        traditionalSeekBarView.ivIcon.setImageDrawable(th4.d(traditionalSeekBarView.getContext(), R.drawable.chat_traditional_rotation_clockwise_blue));
                    }
                    TraditionalSeekBarView.this.b.a();
                }
            }
        }
    }

    public interface c {
        void a();
    }

    public TraditionalSeekBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = PSOProgramService.VS_Key;
        this.a = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.view_traditional_seekbar, this);
        ButterKnife.bind(this);
        this.vseekBar.setOnSeekBarChangeListener(new a());
        this.llIcon.setOnClickListener(new b());
    }

    public String getFuc() {
        return this.c;
    }

    public int getProgree() {
        return this.vseekBar.getProgress();
    }

    public void setBg(int i) {
        Drawable drawableD = th4.d(getContext(), i);
        drawableD.setBounds(this.vseekBarBg.getProgressDrawable().getBounds());
        this.vseekBarBg.setProgressDrawable(drawableD);
    }

    public void setFuc(String str, int i) {
        this.c = str;
        if (PSOProgramService.VS_Key.equals(str)) {
            this.tvFuc.setText(ah4.e(R.string.toy_control_vibrate));
            this.ivIcon.setVisibility(8);
            this.tvFuc.setTextColor(th4.b(this.a, R.color.default_color));
        } else {
            if (StreamManagement.AckRequest.ELEMENT.equals(str)) {
                this.tvFuc.setText(ah4.e(R.string.toy_control_rotate));
                this.ivIcon.setVisibility(0);
                this.d = true;
                this.tvFuc.setTextColor(th4.b(this.a, R.color.default_color));
                this.ivIcon.setImageDrawable(th4.d(getContext(), R.drawable.chat_traditional_rotation_anticlockwise_blue));
                return;
            }
            this.tvFuc.setText(ah4.e(R.string.toy_control_pump));
            this.ivIcon.setVisibility(8);
            if (i == 3) {
                this.tvFuc.setTextColor(th4.b(this.a, R.color.default_color));
            } else {
                this.tvFuc.setTextColor(th4.b(this.a, R.color.default_color));
            }
        }
    }

    public void setLister(c cVar) {
        this.b = cVar;
    }

    public void setProgress(int i) {
        this.vseekBar.setProgress(0);
    }

    public void setThumb(int i) {
        Drawable drawableD = th4.d(getContext(), i);
        drawableD.setBounds(this.vseekBar.getThumb().getBounds());
        this.vseekBar.setThumb(drawableD);
    }
}
