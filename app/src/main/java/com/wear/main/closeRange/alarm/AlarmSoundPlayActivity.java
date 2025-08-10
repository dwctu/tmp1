package com.wear.main.closeRange.alarm;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Pattern;
import com.wear.bean.PatternHead;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.SoundView;
import dc.ah4;
import dc.sg3;
import dc.so3;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class AlarmSoundPlayActivity extends BaseActivity {
    public MyActionBar a;
    public SoundView b;
    public SeekBar c;
    public ImageView e;
    public TextView f;
    public View g;
    public TextView h;
    public so3 i;
    public String j;
    public Pattern k;
    public Timer t;
    public Handler u;
    public int v;
    public int d = 100;
    public String l = "";
    public List<String> m = new ArrayList();
    public int n = 1;
    public LinkedList<Integer> o = new LinkedList<>();
    public int p = 5;
    public boolean q = false;
    public int s = 0;
    public boolean w = false;
    public boolean x = true;
    public long y = 0;

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) throws IOException {
            if (!new File(AlarmSoundPlayActivity.this.j).exists()) {
                sg3.i(AlarmSoundPlayActivity.this, R.string.alarm_audio_file_error);
                return;
            }
            WearUtils.l2(AlarmSoundPlayActivity.this.k.getId(), WearUtils.r0(AlarmSoundPlayActivity.this.l));
            if (!WearUtils.x0(AlarmSoundPlayActivity.this.k.getId()).exists()) {
                sg3.i(AlarmSoundPlayActivity.this, R.string.alarm_audio_file_error);
                return;
            }
            AlarmSoundPlayActivity.this.w = true;
            Intent intent = new Intent();
            intent.putExtra("alarm_pattern_id", AlarmSoundPlayActivity.this.k.getId());
            intent.putExtra("alarm_sound_path", AlarmSoundPlayActivity.this.j);
            intent.putExtra("alarm_item_times", WearUtils.I0(AlarmSoundPlayActivity.this.s / 10));
            AlarmSoundPlayActivity.this.setResult(1655, intent);
            AlarmSoundPlayActivity.this.finish();
        }
    }

    public class b implements SeekBar.OnSeekBarChangeListener {
        public b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            AlarmSoundPlayActivity.this.d = i;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    public class c extends Handler {
        public c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws IllegalStateException {
            if (AlarmSoundPlayActivity.this.isFinishing() || AlarmSoundPlayActivity.this.isDestroyed()) {
                return;
            }
            int i = message.what;
            if (i == 0) {
                if (AlarmSoundPlayActivity.this.b != null) {
                    AlarmSoundPlayActivity.this.b.setSoundLevel(AlarmSoundPlayActivity.this.v, AlarmSoundPlayActivity.this.d, AlarmSoundPlayActivity.this.v + 45);
                    return;
                }
                return;
            }
            if (i != 1) {
                return;
            }
            AlarmSoundPlayActivity.E4(AlarmSoundPlayActivity.this);
            int i2 = AlarmSoundPlayActivity.this.s / 10;
            if (i2 == 5) {
                AlarmSoundPlayActivity.this.a.getYesBtn().setEnabled(true);
            } else if (i2 >= 50) {
                if (i2 != 60) {
                    AlarmSoundPlayActivity.this.g.setVisibility(0);
                    AlarmSoundPlayActivity.this.h.setText("" + (60 - i2));
                } else if (!AlarmSoundPlayActivity.this.q) {
                    AlarmSoundPlayActivity.this.R4();
                    sg3.i(AlarmSoundPlayActivity.this, R.string.alarm_audio_recording_over_notice);
                }
            }
            AlarmSoundPlayActivity.this.f.setText(WearUtils.I0(i2));
        }
    }

    public class d implements View.OnTouchListener {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() throws IOException {
                AlarmSoundPlayActivity alarmSoundPlayActivity = AlarmSoundPlayActivity.this;
                alarmSoundPlayActivity.x = true;
                alarmSoundPlayActivity.s = 0;
                AlarmSoundPlayActivity.this.q = false;
                AlarmSoundPlayActivity.this.a.getYesBtn().setEnabled(false);
                AlarmSoundPlayActivity.this.O4();
                AlarmSoundPlayActivity.this.Q4();
            }
        }

        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) throws IllegalStateException {
            int action = motionEvent.getAction();
            if (action == 0) {
                AlarmSoundPlayActivity alarmSoundPlayActivity = AlarmSoundPlayActivity.this;
                if (alarmSoundPlayActivity.x) {
                    alarmSoundPlayActivity.x = false;
                    alarmSoundPlayActivity.parentHandler.postDelayed(new a(), 500L);
                }
            } else if (action == 1) {
                if (!AlarmSoundPlayActivity.this.q) {
                    AlarmSoundPlayActivity alarmSoundPlayActivity2 = AlarmSoundPlayActivity.this;
                    if (alarmSoundPlayActivity2.x) {
                        alarmSoundPlayActivity2.R4();
                    }
                }
                AlarmSoundPlayActivity.this.parentHandler.removeCallbacksAndMessages(null);
                AlarmSoundPlayActivity.this.x = true;
            }
            return true;
        }
    }

    public class e extends TimerTask {
        public e() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (AlarmSoundPlayActivity.this.q) {
                return;
            }
            AlarmSoundPlayActivity.this.S4();
        }
    }

    public static /* synthetic */ int E4(AlarmSoundPlayActivity alarmSoundPlayActivity) {
        int i = alarmSoundPlayActivity.s;
        alarmSoundPlayActivity.s = i + 1;
        return i;
    }

    public final int M4() {
        int iIntValue = 0;
        if (this.o.size() == 0) {
            return 0;
        }
        Iterator<Integer> it = this.o.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if (next != null) {
                iIntValue += next.intValue();
            }
        }
        return iIntValue / this.o.size();
    }

    public final void N4() {
        Timer timer = this.t;
        if (timer != null) {
            timer.cancel();
            this.t = null;
        }
    }

    public void O4() throws IOException {
        WearUtils.y();
        WearUtils.T1(this.k.getId());
        this.k = new Pattern();
        ArrayList arrayList = new ArrayList();
        arrayList.add("V:1;T:lush;F:" + PSOProgramService.VS_Key + ";S:100;A:y;;M:" + PatternHead.P_M_DEF + ";#" + System.getProperty("line.separator"));
        String strN2 = WearUtils.n2(arrayList, this.k.getId(), false);
        this.l = strN2;
        this.l = strN2.replace(PatternHead.P_M_DEF, PatternHead.P_M);
        this.m.clear();
    }

    public final void P4() {
        N4();
        Timer timer = new Timer();
        this.t = timer;
        timer.scheduleAtFixedRate(new e(), 0L, 20L);
    }

    public final void Q4() {
        this.e.setBackgroundResource(R.drawable.content_icon_record_hold);
        if (!WearUtils.e1(this.j)) {
            new File(this.j).delete();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(WearUtils.T("mic").getAbsolutePath());
        sb.append("/");
        sb.append(WearUtils.B(System.currentTimeMillis() + ".acc"));
        String string = sb.toString();
        this.j = string;
        if (this.i.w(string)) {
            P4();
        } else {
            N4();
            sg3.i(this, R.string.chat_record_failure);
        }
    }

    public final void R4() throws IllegalStateException {
        this.q = true;
        this.i.H();
        N4();
        this.g.setVisibility(8);
        this.e.setBackgroundResource(R.drawable.content_icon_record_default);
        this.application.G().u0();
        try {
            if (this.m.size() > 0) {
                List<String> list = this.m;
                list.remove(list.size() - 1);
            }
            this.m.add("0");
            this.l += WearUtils.n2(this.m, this.k.getId(), true);
            this.m = new ArrayList();
            if (this.s < 50) {
                sg3.l(ah4.e(R.string.alarm_sound_min_time));
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void S4() {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.main.closeRange.alarm.AlarmSoundPlayActivity.S4():void");
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.alarm_sound_play);
        MyActionBar myActionBar = (MyActionBar) findViewById(R.id.actionbar);
        this.a = myActionBar;
        myActionBar.n();
        SoundView soundView = (SoundView) findViewById(R.id.music_line);
        this.b = soundView;
        soundView.setIconVisibility(8);
        this.a.setYesAction(R.string.common_save, new a());
        this.a.getYesBtn().setEnabled(false);
        this.i = new so3();
        this.e = (ImageView) findViewById(R.id.touch_record);
        this.f = (TextView) findViewById(R.id.tv_record_times);
        this.g = findViewById(R.id.tv_record_times_over_layout);
        this.h = (TextView) findViewById(R.id.tv_record_times_over);
        SeekBar seekBar = (SeekBar) findViewById(R.id.music_sensitivity);
        this.c = seekBar;
        seekBar.setMax(100);
        this.d = 100;
        this.c.setProgress(100);
        this.c.setOnSeekBarChangeListener(new b());
        this.u = new c();
        WearUtils.y();
        setVolumeControlStream(3);
        this.e.setOnTouchListener(new d());
        this.k = new Pattern();
        this.x = true;
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.application.G().u0();
        this.a.s();
        Handler handler = this.u;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        N4();
        if (!this.w && !WearUtils.e1(this.j)) {
            new File(this.j).delete();
        }
        WearUtils.T1(this.k.getId());
        EventBus.getDefault().unregister(this);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
