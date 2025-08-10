package com.wear.ui.home.sound;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.main.toy.ToyActivity;
import com.wear.ui.home.sound.SoundPlayControl;
import com.wear.widget.MyActionBar;
import com.wear.widget.SensitivityProgressView;
import com.wear.widget.SoundView;
import dc.eg3;
import dc.fk2;
import dc.me3;
import dc.pj3;
import dc.q61;
import dc.qf3;
import dc.t51;
import dc.u51;
import dc.u53;
import dc.ye3;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class SoundPlayActivity extends BaseActivity implements u53 {
    public MyActionBar a;
    public SoundView b;
    public int c = 75;
    public SensitivityProgressView d;
    public TextView e;

    public class a implements SensitivityProgressView.b {
        public a() {
        }

        @Override // com.wear.widget.SensitivityProgressView.b
        public void a(int i) {
            if (i < 0) {
                i = 0;
            }
            SoundPlayActivity.this.e.setText(i + "%");
        }

        @Override // com.wear.widget.SensitivityProgressView.b
        public void b(int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            SoundPlayActivity.this.c = i;
            SoundPlayControl.M().W(SoundPlayActivity.this.c);
            SoundPlayActivity soundPlayActivity = SoundPlayActivity.this;
            eg3.k(soundPlayActivity, "sensitivity_seek", soundPlayActivity.c);
        }
    }

    public class b implements u51 {
        public b() {
        }

        @Override // dc.u51
        public void a(List<String> list, boolean z) {
            t51.a(this, list, z);
        }

        @Override // dc.u51
        public void b(List<String> list, boolean z) {
            if (z) {
                fk2.a.m(SoundPlayActivity.class, SoundPlayControl.M().a);
                if (SoundPlayControl.M().a) {
                    SoundPlayActivity.this.b.setPlayOrPause(SoundPlayControl.M().b);
                    if (SoundPlayControl.M().b) {
                        SoundPlayActivity.this.b.setSoundLevel(0, SoundPlayActivity.this.c, 0);
                    }
                } else {
                    SoundPlayControl.M().Y();
                }
                SoundPlayControl.M().V();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y4(View view) {
        pj3.f(this, ToyActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A4(View view) {
        onBackPressed();
    }

    @Override // dc.u53
    public void F() {
        finish();
    }

    @Override // dc.u53
    public void M2(int i, int i2, int i3) {
        SoundView soundView = this.b;
        if (soundView != null) {
            soundView.setSoundLevel(i, i2, i3);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (SoundPlayControl.M().b) {
            SoundPlayControl.M().K();
            finish();
        } else if (checkFloatWindowsPermission()) {
            finish();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home_sound_play);
        w4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        me3.c(me3.c.SOUND_UI_EXIT);
        this.a.s();
        EventBus.getDefault().unregister(this);
        SoundPlayControl.M().J();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.d.setResume(this.c);
    }

    @Override // dc.u53
    public void s(int i, boolean z) {
        this.c = i;
        this.e.setText(i + "%");
        this.d.setResume(i);
        this.b.setPlayOrPause(z);
    }

    public final void w4() {
        me3.c(me3.c.SOUND_UI_ENTER);
        ye3.c("sound", "into page", null);
        setCurrentScreen(this, "sound_control_screen_view", SoundPlayActivity.class.getSimpleName());
        setVolumeControlStream(3);
        if (qf3.a && !this.application.o) {
            qf3.C();
        }
        MyActionBar myActionBar = (MyActionBar) findViewById(R.id.actionbar);
        this.a = myActionBar;
        myActionBar.setToysAction(new MyActionBar.f() { // from class: dc.t53
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                this.a.y4(view);
            }
        }, false, this);
        this.a.setBackAction(new MyActionBar.f() { // from class: dc.r53
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                this.a.A4(view);
            }
        });
        this.a.n();
        this.b = (SoundView) findViewById(R.id.music_line);
        this.e = (TextView) findViewById(R.id.tv_progress);
        SensitivityProgressView sensitivityProgressView = (SensitivityProgressView) findViewById(R.id.sensitivity_progress);
        this.d = sensitivityProgressView;
        sensitivityProgressView.setSetProgressListen(new a());
        if (eg3.a(this, "sensitivity_seek")) {
            this.c = eg3.e(this, "sensitivity_seek");
        }
        this.d.setProgress(this.c);
        SoundPlayControl.M().W(this.c);
        this.e.setText(this.c + "%");
        q61 q61VarM = q61.m(this);
        q61VarM.h("android.permission.RECORD_AUDIO");
        q61VarM.j(new b());
        SoundPlayControl.M().X(this);
        this.b.setListener(new SoundView.b() { // from class: dc.s53
            @Override // com.wear.widget.SoundView.b
            public final void a() {
                SoundPlayControl.M().U();
            }
        });
        addAnalyticsEventId("sound_control", null);
        EventBus.getDefault().register(this);
    }
}
