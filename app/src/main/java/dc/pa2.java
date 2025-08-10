package dc;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.bean.User;
import com.wear.main.longDistance.control.ChatVideoControl;
import com.wear.main.longDistance.control.LDRControl;
import com.wear.protocol.EntityVideo;
import com.wear.protocol.EntityVoice;
import com.wear.util.WearUtils;

/* compiled from: ChatVideoLDRControl.java */
/* loaded from: classes3.dex */
public class pa2 extends LDRControl {
    public ChatVideoControl q;
    public View r;
    public LinearLayout s;
    public Runnable t = new a();

    /* compiled from: ChatVideoLDRControl.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (pa2.this.s != null) {
                pa2.this.s.setEnabled(true);
            }
        }
    }

    /* compiled from: ChatVideoLDRControl.java */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public b(pa2 pa2Var) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            td3.f(i);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* compiled from: ChatVideoLDRControl.java */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            pa2.this.s.setEnabled(false);
            pa2 pa2Var = pa2.this;
            pa2Var.f.postDelayed(pa2Var.t, 1000L);
            User user = pa2.this.c;
            if (user == null) {
                return;
            }
            if (dh3.l(user)) {
                pa2.this.v0(String.format(ah4.e(R.string.str_video_old_tip), pa2.this.c.getShowNickName()));
                return;
            }
            if (dh3.k(pa2.this.c)) {
                pa2.this.v0(ah4.e(R.string.str_video_old_pc_tip));
                return;
            }
            if (pa2.this.h0(true)) {
                if (pa2.this.q.k1()) {
                    EntityVideo entityVideo = new EntityVideo();
                    entityVideo.setType(EntityVideo.VideoOPTType.swapLDRControl.toString());
                    ou3.m(entityVideo, pa2.this.c);
                } else {
                    EntityVoice entityVoice = new EntityVoice();
                    entityVoice.setType(EntityVoice.VoiceOPTType.swapLDRControl.toString());
                    ou3.m(entityVoice, pa2.this.c);
                }
            }
        }
    }

    /* compiled from: ChatVideoLDRControl.java */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            pa2.this.U();
        }
    }

    public pa2(ChatVideoControl chatVideoControl, View view) {
        this.q = chatVideoControl;
        this.r = view;
        this.i = WearUtils.x.G();
        t0();
    }

    @Override // com.wear.main.longDistance.control.LDRControl
    public void N() {
    }

    @Override // com.wear.main.longDistance.control.LDRControl
    public void P() {
    }

    @Override // com.wear.main.longDistance.control.LDRControl
    public void Q(String str) {
        if (this.q.k1()) {
            EntityVideo entityVideo = new EntityVideo();
            entityVideo.setType(EntityVideo.VideoOPTType.swapLDRActiveToy.toString());
            entityVideo.setData(str);
            ou3.s(entityVideo, this.c);
            return;
        }
        EntityVoice entityVoice = new EntityVoice();
        entityVoice.setType(EntityVoice.VoiceOPTType.swapLDRActiveToy.toString());
        entityVoice.setData(str);
        ou3.s(entityVoice, this.c);
    }

    @Override // com.wear.main.longDistance.control.LDRControl
    public void i0(int i) {
        this.q.Z1(i);
    }

    @Override // com.wear.main.longDistance.control.LDRControl
    public int j() {
        return this.ldrSensitivity.getProgress();
    }

    @Override // com.wear.main.longDistance.control.LDRControl
    public void l0() {
        if (this.g != null) {
            ChatVideoControl chatVideoControl = this.q;
            chatVideoControl.Y1(chatVideoControl.flDlrLayout, chatVideoControl.touchPanel);
        } else {
            if (i() == 0) {
                this.q.P1();
                ChatVideoControl chatVideoControl2 = this.q;
                chatVideoControl2.Y1(chatVideoControl2.touchPanel, chatVideoControl2.flDlrLayout);
                this.q.multiControlPanel.m0(i());
                return;
            }
            if (i() == 2) {
                ChatVideoControl chatVideoControl3 = this.q;
                chatVideoControl3.Y1(chatVideoControl3.flDlrLayout, chatVideoControl3.touchPanel);
            }
        }
    }

    public final void s0() {
        this.ldrSensitivity.setMax(100);
        this.ldrSensitivity.setProgress(td3.d());
        this.ldrSensitivity.setOnSeekBarChangeListener(new b(this));
        this.s.setOnClickListener(new c());
    }

    public final void t0() {
        p(this.r);
        this.s = (LinearLayout) this.r.findViewById(R.id.ll_ldr_control);
        this.ivLdrControl = (ImageView) this.r.findViewById(R.id.iv_ldr_control);
        this.tvLdrControl = (TextView) this.r.findViewById(R.id.tv_ldr_control);
        this.ivLdrControlStates = (ImageView) this.r.findViewById(R.id.iv_ldr_control_states);
        s0();
    }

    public void u0(boolean z, boolean z2) {
        if (z) {
            d0(z2);
            return;
        }
        this.i.F();
        if (this.g != null) {
            this.f.postDelayed(new d(), 500L);
        }
    }

    public final void v0(String str) {
        cs3.j(h(), str).show();
    }
}
