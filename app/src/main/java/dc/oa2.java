package dc;

import android.view.View;
import android.widget.SeekBar;
import com.lovense.wear.R;
import com.wear.bean.User;
import com.wear.bean.UserRoulette;
import com.wear.main.longDistance.control.ChatSyncControl;
import com.wear.main.longDistance.control.LDRControl;
import com.wear.protocol.EntitySync;
import com.wear.util.WearUtils;

/* compiled from: ChatLDRControl.java */
/* loaded from: classes3.dex */
public class oa2 extends LDRControl {
    public ChatSyncControl q;
    public View r;
    public View s;
    public Runnable t = new a();

    /* compiled from: ChatLDRControl.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = oa2.this.s;
            if (view != null) {
                view.setEnabled(true);
            }
        }
    }

    /* compiled from: ChatLDRControl.java */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public b(oa2 oa2Var) {
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

    public oa2(ChatSyncControl chatSyncControl, View view, View view2) {
        this.q = chatSyncControl;
        this.r = view;
        this.i = WearUtils.x.G();
        r0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t0(View view) {
        this.s.setEnabled(false);
        this.f.postDelayed(this.t, 1000L);
        if (h0(true)) {
            EntitySync entitySync = new EntitySync();
            entitySync.setType(EntitySync.SyncOPTType.swap.toString());
            this.q.p1(entitySync);
            this.q.L1(this.n);
            if (this.g == null) {
                this.q.C1();
                this.d.setLiveStatus(1);
            }
        }
    }

    @Override // com.wear.main.longDistance.control.LDRControl
    public void N() {
        this.r.setVisibility(0);
    }

    @Override // com.wear.main.longDistance.control.LDRControl
    public void P() {
        EntitySync entitySync = new EntitySync();
        entitySync.setType(EntitySync.SyncOPTType.swapLDR.toString());
        User user = this.c;
        if (user == null || !user.isControlLink()) {
            ou3.s(entitySync, this.c);
        } else {
            ou3.t(entitySync, this.c);
        }
    }

    @Override // com.wear.main.longDistance.control.LDRControl
    public void Q(String str) {
        EntitySync entitySync = new EntitySync();
        entitySync.setType(EntitySync.SyncOPTType.swapLDRActiveToy.toString());
        entitySync.setData(str);
        User user = this.c;
        if (user != null && user.isControlLink()) {
            ou3.t(entitySync, this.c);
            return;
        }
        User user2 = this.c;
        if (user2 == null || !(user2 instanceof UserRoulette)) {
            ou3.s(entitySync, user2);
        } else {
            this.q.M1(this.g.getAndUpdateDeviceId());
        }
    }

    @Override // com.wear.main.longDistance.control.LDRControl
    public void i0(int i) {
        this.q.Q1(i);
    }

    @Override // com.wear.main.longDistance.control.LDRControl
    public int j() {
        return this.ldrSensitivity.getProgress();
    }

    @Override // com.wear.main.longDistance.control.LDRControl
    public void l0() {
        if (this.g != null) {
            this.q.multiControlPanel.setVisibility(8);
            this.q.syncLdrLayer.setVisibility(0);
        } else if (i() == 0) {
            this.q.C1();
        } else if (i() == 2) {
            this.q.multiControlPanel.setVisibility(8);
            this.q.syncLdrLayer.setVisibility(0);
        }
    }

    public void p0(boolean z) {
        if (this.d == null) {
            return;
        }
        this.r.setVisibility(8);
        if (z) {
            EntitySync entitySync = new EntitySync();
            entitySync.setType(EntitySync.SyncOPTType.swapLDS.toString());
            this.q.p1(entitySync);
        }
        pc1.a.F();
        if (!z && this.d.getLiveStatus() == 1) {
            this.q.O1(-1, false);
        } else if (z && this.d.getLiveStatus() == 2) {
            this.q.O1(-1, false);
        }
        ou3.w(this.c);
    }

    public final void q0() {
        this.ldrSensitivity.setMax(100);
        this.ldrSensitivity.setProgress(td3.d());
        this.ldrSensitivity.setOnSeekBarChangeListener(new b(this));
    }

    public final void r0() {
        p(this.r);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: dc.d92
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.t0(view);
            }
        };
        View viewFindViewById = this.r.findViewById(R.id.ldr_master_control_layout);
        this.s = viewFindViewById;
        viewFindViewById.setOnClickListener(onClickListener);
        q0();
    }
}
