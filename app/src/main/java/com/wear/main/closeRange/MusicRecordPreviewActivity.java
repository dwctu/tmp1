package com.wear.main.closeRange;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Pattern;
import com.wear.bean.Toy;
import com.wear.bean.event.SavePatternFromPreview;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.control.NewCurveLineView;
import com.wear.widget.control.TouchControlView;
import dc.ToyControlBuilder;
import dc.ah4;
import dc.de0;
import dc.mp1;
import dc.pc1;
import dc.rq1;
import dc.wq1;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class MusicRecordPreviewActivity extends BaseActivity {

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public Pattern b;
    public List<String> f;
    public Handler g;
    public Runnable h;

    @BindView(R.id.iv_pause)
    public ImageView ivPause;

    @BindView(R.id.ll_record_pause)
    public LinearLayout llRecordPause;

    @BindView(R.id.ll_record_save)
    public LinearLayout llRecordSave;

    @BindView(R.id.pattern_line)
    public NewCurveLineView patternLine;

    @BindView(R.id.play_times)
    public TextView playTimes;

    @BindView(R.id.tv_record_total_time)
    public TextView tvRecordTotalTime;
    public String[] a = null;
    public int c = 0;
    public boolean d = false;
    public boolean e = false;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            MusicRecordPreviewActivity musicRecordPreviewActivity = MusicRecordPreviewActivity.this;
            musicRecordPreviewActivity.g.postDelayed(musicRecordPreviewActivity.h, 100L);
            if (MusicRecordPreviewActivity.this.d) {
                return;
            }
            if (MusicRecordPreviewActivity.this.c >= MusicRecordPreviewActivity.this.a.length - 1) {
                MusicRecordPreviewActivity.this.d = true;
                MusicRecordPreviewActivity.this.e = true;
                MusicRecordPreviewActivity.v4(MusicRecordPreviewActivity.this);
                rq1.d.q();
                MusicRecordPreviewActivity musicRecordPreviewActivity2 = MusicRecordPreviewActivity.this;
                musicRecordPreviewActivity2.playTimes.setText(musicRecordPreviewActivity2.b.calculateTime(MusicRecordPreviewActivity.this.c, 100));
                MusicRecordPreviewActivity.this.patternLine.b();
                MusicRecordPreviewActivity.this.G4();
            }
            if (MusicRecordPreviewActivity.this.c < 0) {
                return;
            }
            String str = MusicRecordPreviewActivity.this.a[MusicRecordPreviewActivity.this.c];
            if (WearUtils.e1(str)) {
                return;
            }
            MusicRecordPreviewActivity musicRecordPreviewActivity3 = MusicRecordPreviewActivity.this;
            musicRecordPreviewActivity3.patternLine.a(musicRecordPreviewActivity3.c, MusicRecordPreviewActivity.this.b, MusicRecordPreviewActivity.this.a);
            MusicRecordPreviewActivity musicRecordPreviewActivity4 = MusicRecordPreviewActivity.this;
            musicRecordPreviewActivity4.f = musicRecordPreviewActivity4.b.getHead().createCommands(str);
            Iterator it = MusicRecordPreviewActivity.this.f.iterator();
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    break;
                }
                de0.j("ble_pattern", "after cmd: " + ((String) it.next()));
            }
            if (mp1.h()) {
                wq1.a(str, MusicRecordPreviewActivity.this.b, new ToyControlBuilder(false, true, false, ToyControlBuilder.a.SPEED));
                if (MusicRecordPreviewActivity.this.f != null && MusicRecordPreviewActivity.this.f.size() > 1) {
                    MusicRecordPreviewActivity musicRecordPreviewActivity5 = MusicRecordPreviewActivity.this;
                    musicRecordPreviewActivity5.E4((String) musicRecordPreviewActivity5.f.get(MusicRecordPreviewActivity.this.f.size() - 1));
                }
                MusicRecordPreviewActivity.w4(MusicRecordPreviewActivity.this);
                return;
            }
            if (MusicRecordPreviewActivity.this.f != null) {
                Iterator<Toy> it2 = pc1.a.P().iterator();
                while (it2.hasNext()) {
                    pc1.a.m0(it2.next(), MusicRecordPreviewActivity.this.b.isSystemPattern(), MusicRecordPreviewActivity.this.f, false, true, false, false);
                }
                for (String str2 : MusicRecordPreviewActivity.this.f) {
                    if (MusicRecordPreviewActivity.this.f.size() != 1 && i >= MusicRecordPreviewActivity.this.f.size() - 1) {
                        MusicRecordPreviewActivity.this.E4(str2);
                    }
                    i++;
                }
            }
            MusicRecordPreviewActivity.w4(MusicRecordPreviewActivity.this);
        }
    }

    public static /* synthetic */ int v4(MusicRecordPreviewActivity musicRecordPreviewActivity) {
        int i = musicRecordPreviewActivity.c - 1;
        musicRecordPreviewActivity.c = i;
        return i;
    }

    public static /* synthetic */ int w4(MusicRecordPreviewActivity musicRecordPreviewActivity) {
        int i = musicRecordPreviewActivity.c;
        musicRecordPreviewActivity.c = i + 1;
        return i;
    }

    public final void E4(String str) {
        if (WearUtils.e1(str)) {
            return;
        }
        int i = this.c;
        if (i % 10 == 0) {
            this.playTimes.setText(this.b.calculateTime(i, 100));
        }
        if (str.split(",").length <= 2 || !this.b.getHead().isAllFunc()) {
            this.patternLine.setBothLinePoint(str);
        } else {
            this.patternLine.setBothLinePoint(str.split(",")[0]);
        }
    }

    public final void F4() {
        Pattern pattern = this.b;
        if (pattern == null) {
            return;
        }
        if (pattern.getData() == null) {
            Pattern pattern2 = this.b;
            pattern2.setData(WearUtils.N1(pattern2.getFile().getPath()));
        }
        if (WearUtils.e1(this.b.getData())) {
            return;
        }
        this.actionbar.setTitle(WearUtils.e1(this.b.getName()) ? ah4.e(R.string.pattern_name) : this.b.getName());
        this.a = this.b.getData().split(TouchControlView.P);
        this.patternLine.setShowBothLine(false);
        this.patternLine.b();
        this.c = 0;
        this.e = false;
        this.d = false;
        this.tvRecordTotalTime.setText(this.b.calculateTime(this.a.length, 100));
        Handler handler = this.g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = new Handler();
        this.g = handler2;
        a aVar = new a();
        this.h = aVar;
        handler2.postDelayed(aVar, 0L);
    }

    public final void G4() {
        if (this.d) {
            this.ivPause.setImageResource(R.drawable.icon_musci_pattern_pause_selected);
        } else {
            this.ivPause.setImageResource(R.drawable.icon_musci_pattern_pause_normal);
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_music_record_preview);
        ButterKnife.bind(this);
        this.b = (Pattern) getIntent().getExtras().getSerializable("pattern");
        F4();
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.d = true;
        this.e = true;
        Handler handler = this.g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @OnClick({R.id.ll_record_pause, R.id.ll_record_save})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id != R.id.ll_record_pause) {
            if (id != R.id.ll_record_save) {
                return;
            }
            EventBus.getDefault().post(new SavePatternFromPreview());
            finish();
            return;
        }
        this.d = !this.d;
        if (this.e) {
            F4();
        }
        G4();
    }
}
