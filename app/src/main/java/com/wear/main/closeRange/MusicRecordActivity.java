package com.wear.main.closeRange;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.os.EnvironmentCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.wear.BaseActivity;
import com.wear.bean.Music;
import com.wear.bean.Pattern;
import com.wear.bean.PatternHead;
import com.wear.bean.Toy;
import com.wear.bean.event.NetworkInfoEvent;
import com.wear.bean.event.SavePatternFromPreview;
import com.wear.bean.event.SpotifyPlayEvent;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.be3;
import dc.ff3;
import dc.i12;
import dc.i43;
import dc.k12;
import dc.k43;
import dc.pc1;
import dc.pj3;
import dc.rd3;
import dc.sg3;
import dc.xe2;
import dc.ye3;
import dc.zt3;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class MusicRecordActivity extends BaseActivity implements SeekBar.OnSeekBarChangeListener, MusicControl.h, k43, i43 {
    public Pattern a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public Timer e;
    public TimerTask f;

    @BindView(R.id.iv_loading)
    public ImageView ivLoading;

    @BindView(R.id.iv_music_record)
    public ImageView ivMusicRecord;

    @BindView(R.id.iv_pause)
    public ImageView ivPause;
    public boolean l;

    @BindView(R.id.ll_bottom)
    public LinearLayout llBottom;

    @BindView(R.id.ll_load_status)
    public LinearLayout llLoadStatus;

    @BindView(R.id.ll_playing)
    public LinearLayout llPlaying;

    @BindView(R.id.ll_re_recording)
    public LinearLayout llReRecording;

    @BindView(R.id.ll_record_pause)
    public LinearLayout llRecordPause;

    @BindView(R.id.ll_record_preview)
    public LinearLayout llRecordPreview;

    @BindView(R.id.ll_record_save)
    public LinearLayout llRecordSave;

    @BindView(R.id.ll_record_progress)
    public LinearLayout mLlRecordProgress;
    public boolean o;
    public boolean p;
    public int s;

    @BindView(R.id.sb_music_record)
    public SeekBar sbMusicRecord;

    @BindView(R.id.tv_music_record_name)
    public TextView tvMusicRecordName;

    @BindView(R.id.tv_music_record_name_1)
    public TextView tvMusicRecordName1;

    @BindView(R.id.tv_music_record_progress)
    public TextView tvMusicRecordProgress;

    @BindView(R.id.tv_music_record_status)
    public TextView tvMusicRecordStatus;

    @BindView(R.id.tv_music_record_time)
    public TextView tvMusicRecordTime;

    @BindView(R.id.tv_record_times)
    public TextView tvRecordTimes;
    public Unbinder w;
    public long x;
    public String b = "";
    public boolean c = false;
    public String d = "1";
    public final List<String> g = new ArrayList();
    public int h = 0;
    public int i = 0;
    public boolean j = false;
    public boolean k = true;
    public final String m = MusicRecordActivity.class.getSimpleName();
    public final ArrayList<Integer> n = new ArrayList<>();
    public Handler q = new Handler();
    public boolean t = true;
    public long u = 0;
    public long v = 0;

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            MusicRecordActivity.this.M4();
            MusicRecordActivity.this.finish();
        }
    }

    public class b implements MusicControl.f {
        public b() {
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void a(int i) {
            String unused = MusicRecordActivity.this.m;
            String str = "choose==" + i;
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void b(boolean z) {
            String unused = MusicRecordActivity.this.m;
            String str = "loadData==" + z;
            if (z) {
                MusicRecordActivity.this.p = true;
                MusicRecordActivity.this.q.removeCallbacksAndMessages(null);
                LinearLayout linearLayout = MusicRecordActivity.this.llBottom;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                LinearLayout linearLayout2 = MusicRecordActivity.this.llPlaying;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                LinearLayout linearLayout3 = MusicRecordActivity.this.llLoadStatus;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(8);
                }
            }
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void c(int i) {
            String unused = MusicRecordActivity.this.m;
            String str = "notifyDataChanged==" + i;
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void d(int i) {
            String unused = MusicRecordActivity.this.m;
            String str = "error==" + i;
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void e(boolean z) {
            MusicRecordActivity musicRecordActivity = MusicRecordActivity.this;
            musicRecordActivity.k = z;
            musicRecordActivity.J4();
            String unused = MusicRecordActivity.this.m;
            String str = "updateStatus==" + MusicRecordActivity.this.k;
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void f(int i, int i2, boolean z) {
            String unused = MusicRecordActivity.this.m;
            String str = "finish==" + i + "==" + i2;
        }
    }

    public class c extends ff3 {
        public c() {
        }

        @Override // dc.ff3
        public void a() {
            super.a();
        }

        @Override // dc.ff3
        public void b(boolean z, Object obj) throws IllegalStateException {
            if (z) {
                int iIntValue = ((Integer) obj).intValue();
                if (iIntValue == -1) {
                    if (MusicControl.h0().f.getMusicType() == 1) {
                        MusicControl.h0().e.b.G();
                    } else {
                        MusicControl.h0().d.b.G();
                    }
                    MusicControl.h0().b0();
                    MusicRecordActivity musicRecordActivity = MusicRecordActivity.this;
                    LinearLayout linearLayout = musicRecordActivity.llRecordSave;
                    if (linearLayout == null || musicRecordActivity.i < 5) {
                        return;
                    }
                    linearLayout.performClick();
                    return;
                }
                String unused = MusicRecordActivity.this.m;
                String str = "synToyPlay: " + iIntValue;
                MusicControl.h0().a0(iIntValue);
                if (iIntValue != 0) {
                    MusicRecordActivity.this.d = "" + iIntValue;
                }
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MusicRecordActivity.this.p) {
                return;
            }
            TextView textView = MusicRecordActivity.this.tvMusicRecordStatus;
            if (textView != null) {
                textView.setEnabled(true);
            }
            TextView textView2 = MusicRecordActivity.this.tvMusicRecordStatus;
            if (textView2 != null) {
                textView2.setText(ah4.e(R.string.music_record_fail_to_load));
            }
            TextView textView3 = MusicRecordActivity.this.tvMusicRecordStatus;
            if (textView3 != null) {
                textView3.setTextColor(-53879);
            }
            ImageView imageView = MusicRecordActivity.this.ivLoading;
            if (imageView != null) {
                imageView.clearAnimation();
                MusicRecordActivity.this.ivLoading.setVisibility(8);
            }
            MusicControl.h0().e.U();
        }
    }

    public class e implements ImageLoadingListener {
        public e() {
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            ImageView imageView = MusicRecordActivity.this.ivMusicRecord;
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ImageView imageView = MusicRecordActivity.this.ivMusicRecord;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.content_icon_music_cover);
            }
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MusicRecordActivity.this.p) {
                return;
            }
            MusicRecordActivity.this.tvMusicRecordStatus.setEnabled(true);
            MusicRecordActivity.this.tvMusicRecordStatus.setText(ah4.e(R.string.music_record_fail_to_load));
            MusicRecordActivity.this.tvMusicRecordStatus.setTextColor(-53879);
            MusicRecordActivity.this.ivLoading.clearAnimation();
            MusicRecordActivity.this.ivLoading.setVisibility(8);
            MusicControl.h0().e.U();
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LinearLayout linearLayout = MusicRecordActivity.this.llRecordPause;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setAlpha(1.0f);
            MusicRecordActivity.this.llRecordPause.setEnabled(true);
            MusicRecordActivity.this.J4();
        }
    }

    public class h extends TimerTask {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                TextView textView = MusicRecordActivity.this.tvRecordTimes;
                if (textView != null) {
                    textView.setText(WearUtils.Q(r0.i));
                    if (MusicControl.h0().f == null || MusicControl.h0().f.getMusicType() != 2) {
                        MusicRecordActivity.this.mLlRecordProgress.setVisibility(0);
                    } else {
                        MusicRecordActivity.this.mLlRecordProgress.setVisibility(8);
                    }
                    if (MusicControl.h0().f != null && MusicControl.h0().f.getMusicType() == 2) {
                        MusicRecordActivity.this.tvMusicRecordProgress.setText(WearUtils.Q(r0.i));
                        int duration = MusicControl.h0().f.getDuration() / 1000;
                        MusicRecordActivity musicRecordActivity = MusicRecordActivity.this;
                        musicRecordActivity.sbMusicRecord.setProgress(musicRecordActivity.i * 1000);
                    }
                    MusicRecordActivity musicRecordActivity2 = MusicRecordActivity.this;
                    if (musicRecordActivity2.i >= 5) {
                        musicRecordActivity2.llRecordPreview.setAlpha(1.0f);
                        MusicRecordActivity.this.llRecordPreview.setEnabled(true);
                        MusicRecordActivity.this.llRecordSave.setAlpha(1.0f);
                        MusicRecordActivity.this.llRecordSave.setEnabled(true);
                        return;
                    }
                    musicRecordActivity2.llRecordPreview.setAlpha(0.5f);
                    MusicRecordActivity.this.llRecordPreview.setEnabled(false);
                    MusicRecordActivity.this.llRecordSave.setAlpha(0.5f);
                    MusicRecordActivity.this.llRecordSave.setEnabled(false);
                }
            }
        }

        public h() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() throws IOException {
            String unused = MusicRecordActivity.this.m;
            String str = MusicRecordActivity.this.j + " " + MusicRecordActivity.this.k + " " + MusicRecordActivity.this.c + " " + MusicRecordActivity.this.o + " " + MusicRecordActivity.this.h;
            MusicRecordActivity musicRecordActivity = MusicRecordActivity.this;
            if (musicRecordActivity.j || musicRecordActivity.k || musicRecordActivity.c || MusicRecordActivity.this.o) {
                return;
            }
            MusicRecordActivity musicRecordActivity2 = MusicRecordActivity.this;
            if (!musicRecordActivity2.j && musicRecordActivity2.i >= 3599 && musicRecordActivity2.p) {
                MusicRecordActivity musicRecordActivity3 = MusicRecordActivity.this;
                musicRecordActivity3.j = true;
                musicRecordActivity3.K4(false, true);
                return;
            }
            MusicRecordActivity musicRecordActivity4 = MusicRecordActivity.this;
            int i = musicRecordActivity4.h + 1;
            musicRecordActivity4.h = i;
            if (i % 10 == 0) {
                musicRecordActivity4.i++;
                musicRecordActivity4.runOnUiThread(new a());
            }
            MusicRecordActivity.this.g.add(MusicRecordActivity.this.d);
            String unused2 = MusicRecordActivity.this.m;
            String str2 = "functonNum:  " + MusicRecordActivity.this.d;
            if (MusicRecordActivity.this.g.size() >= 500) {
                MusicRecordActivity musicRecordActivity5 = MusicRecordActivity.this;
                MusicRecordActivity.D4(musicRecordActivity5, WearUtils.n2(musicRecordActivity5.g, MusicRecordActivity.this.a.getId(), true));
                MusicRecordActivity.this.g.clear();
            }
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            MusicRecordActivity.this.G4();
        }
    }

    public static /* synthetic */ String D4(MusicRecordActivity musicRecordActivity, Object obj) {
        String str = musicRecordActivity.b + obj;
        musicRecordActivity.b = str;
        return str;
    }

    public final void F4(int i2) {
        int i3 = this.i;
        if (i3 <= 0 || i3 < 5) {
            return;
        }
        HashMap map = new HashMap();
        map.put(TypedValues.TransitionType.S_DURATION, Integer.valueOf(this.i));
        ArrayList arrayList = new ArrayList();
        Iterator<Toy> it = pc1.a.P().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getDeviceId());
        }
        map.put("toy_mac", arrayList);
        map.put("type", Integer.valueOf(i2));
        ye3.d("M0060", WearUtils.A.toJson(map));
    }

    public final void G4() throws IOException {
        TextView textView = this.tvRecordTimes;
        if (textView != null) {
            textView.setText("00:00");
        }
        TextView textView2 = this.tvMusicRecordProgress;
        if (textView2 != null) {
            textView2.setText("00:00");
        }
        SeekBar seekBar = this.sbMusicRecord;
        if (seekBar != null) {
            seekBar.setProgress(0);
        }
        Pattern pattern = this.a;
        if (pattern != null) {
            WearUtils.T1(pattern.getId());
        }
        this.a = new Pattern();
        ArrayList arrayList = new ArrayList();
        arrayList.add("V:1;T:;F:v;S:100;A:y;;M:" + PatternHead.P_M_DEF + ";#" + System.getProperty("line.separator"));
        String strN2 = WearUtils.n2(arrayList, this.a.getId(), false);
        this.b = strN2;
        this.b = strN2.replace(PatternHead.P_M_DEF, PatternHead.P_M);
        this.g.clear();
        this.h = 0;
        this.i = 0;
        this.j = false;
        this.d = "1";
        this.c = false;
        this.llRecordPreview.setAlpha(0.5f);
        this.llRecordPreview.setEnabled(false);
        this.llRecordSave.setAlpha(0.5f);
        this.llRecordSave.setEnabled(false);
        this.n.clear();
    }

    public final void H4(Music music) {
        if (music == null) {
            FirebaseCrashlytics.getInstance().recordException(new Throwable("MusicRecordActivity currentPlayMusic 为null"));
            finish();
        }
        this.tvMusicRecordName.setText(music.getTitle());
        this.tvMusicRecordName1.setText(music.getTitle());
        if (music.getMusicType() != 2 || rd3.f().j() == 0) {
            this.tvMusicRecordTime.setText(WearUtils.Q(music.getDuration() / 1000));
        } else {
            this.tvMusicRecordTime.setText(WearUtils.Q(this.v / 1000));
        }
        this.sbMusicRecord.setMax(music.getDuration());
        String imageUrl = "content://media/external/audio/albumart/" + music.getAlbumId();
        if (music.getMusicType() == 1) {
            imageUrl = music.getImageUrl();
        }
        if (!WearUtils.e1(imageUrl) && music.getAlbumId() > 0) {
            ImageLoader.getInstance().displayImage(imageUrl, this.ivMusicRecord, new e());
        } else if (music.getMusicType() != 2 || music.getBitmap() == null) {
            this.ivMusicRecord.setImageResource(R.drawable.content_icon_music_cover);
        } else {
            this.ivMusicRecord.setImageBitmap(music.getBitmap());
        }
        this.sbMusicRecord.setOnSeekBarChangeListener(this);
    }

    public boolean I4() {
        return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
    }

    public final void J4() {
        ImageView imageView = this.ivPause;
        if (imageView != null) {
            if (!this.k) {
                imageView.setImageResource(R.drawable.icon_musci_pattern_pause_normal);
            } else if (this.llRecordPause.isEnabled()) {
                this.ivPause.setImageResource(R.drawable.icon_musci_pattern_pause_selected);
            }
        }
    }

    public final void K4(boolean z, boolean z2) throws IOException {
        if (this.i < 5) {
            return;
        }
        Timer timer = this.e;
        int size = this.g.size() % 10;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(this.g.remove(this.g.size() - 1));
        }
        this.h -= size;
        this.b += WearUtils.n2(this.g, this.a.getId(), true);
        String string = this.tvMusicRecordName.getText().toString();
        if (WearUtils.S0(string)) {
            string = string.replace(SimpleComparison.LESS_THAN_OPERATION, "").replace(SimpleComparison.GREATER_THAN_OPERATION, "");
        }
        Pattern pattern = this.a;
        if (WearUtils.e1(string)) {
            string = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        pattern.setName(string);
        this.a.setEmail(WearUtils.y.r());
        this.a.setCreator(WearUtils.y.r());
        if (MyApplication.Z) {
            this.a.setAuthor("");
        } else if (WearUtils.y.u() == null) {
            this.a.setAuthor(zt3.k);
        } else {
            this.a.setAuthor(WearUtils.y.u().getUserName());
        }
        Pattern pattern2 = this.a;
        pattern2.setTimer(pattern2.calculateTime(this.h, 100));
        this.a.setToyFunc(null);
        if (z) {
            this.g.clear();
            this.g.addAll(arrayList);
            this.h += size;
            Bundle bundle = new Bundle();
            this.a.setData(this.b.replace(PatternHead.P_M, WearUtils.r0(this.b)));
            bundle.putSerializable("pattern", this.a);
            pj3.g(this, MusicRecordPreviewActivity.class, bundle);
        } else {
            WearUtils.l2(this.a.getId(), WearUtils.r0(this.b));
            xe2.L0().t(this.a, true);
            if (MusicControl.h0().f != null) {
                F4(MusicControl.h0().f.getFuncType());
            }
            sg3.e(this, R.string.music_record_pattern_saved_successfully);
            finish();
        }
        if (z2) {
            Timer timer2 = this.e;
            if (timer2 != null) {
                timer2.purge();
                this.e.cancel();
            }
            TimerTask timerTask = this.f;
            if (timerTask != null) {
                timerTask.cancel();
                this.f = null;
            }
            this.t = false;
        }
    }

    public void L4(int i2) {
        if (this.e == null || i2 == 1) {
            this.f = new h();
        }
        Timer timer = new Timer();
        this.e = timer;
        timer.scheduleAtFixedRate(this.f, 100L, 100L);
        this.u = be3.x();
        if (MusicControl.h0().f != null) {
            this.v = MusicControl.h0().f.getDuration() - (this.u - rd3.f().j());
        }
    }

    public void M4() {
        if (MusicControl.h0().f.getMusicType() != 2) {
            Timer timer = this.e;
            if (timer != null) {
                timer.cancel();
            }
            MusicControl.h0().p0();
            this.ivLoading.clearAnimation();
            this.q.removeCallbacksAndMessages(null);
        }
    }

    public void N4() {
        ImageView imageView;
        Music music = MusicControl.h0().f;
        if (music == null) {
            return;
        }
        if (music.getMusicType() == 2 && music.getBitmap() != null && (imageView = this.ivMusicRecord) != null) {
            imageView.setImageBitmap(music.getBitmap());
        }
        if (this.tvMusicRecordTime != null) {
            if (music.getMusicType() == 2) {
                this.tvMusicRecordTime.setText(WearUtils.Q(this.v / 1000));
            } else {
                this.tvMusicRecordTime.setText(WearUtils.Q(music.getDuration() / 1000));
            }
        }
        TextView textView = this.tvMusicRecordName;
        if (textView != null) {
            textView.setText(music.getTitle());
        }
        TextView textView2 = this.tvMusicRecordName1;
        if (textView2 != null) {
            textView2.setText(music.getTitle());
        }
        SeekBar seekBar = this.sbMusicRecord;
        if (seekBar != null) {
            seekBar.setMax(music.getDuration());
        }
    }

    @Override // dc.k43
    public void Y2(int i2) {
        if (i2 > 20) {
            i2 = 20;
        } else if (i2 < 0) {
            i2 = 0;
        }
        this.d = String.valueOf(i2);
    }

    @Override // com.wear.main.closeRange.music.MusicControl.h
    public void e1(i12 i12Var) {
        int iB = i12Var.b();
        if (iB == 2) {
            this.k = true;
            return;
        }
        if (iB != 3) {
            return;
        }
        int iA = i12Var.a();
        if (this.k) {
            this.o = false;
        } else {
            if (this.n.size() > 5) {
                this.n.remove(0);
            }
            this.n.add(Integer.valueOf(iA));
            if (this.n.size() > 5) {
                this.o = true;
                int iIntValue = this.n.get(0).intValue();
                int i2 = 0;
                while (true) {
                    if (i2 >= this.n.size()) {
                        break;
                    }
                    if (iIntValue != this.n.get(i2).intValue()) {
                        this.o = false;
                        break;
                    }
                    i2++;
                }
            } else {
                this.o = true;
            }
        }
        if (this.c || this.tvMusicRecordTime == null) {
            return;
        }
        this.tvMusicRecordProgress.setText(WearUtils.Q(iA / 1000));
        this.sbMusicRecord.setProgress(iA);
    }

    @Override // dc.i43
    public void m0(boolean z) throws IOException {
        if (this.t) {
            if (!z) {
                K4(false, false);
                return;
            }
            this.h = 0;
            this.i = 0;
            N4();
            if (I4()) {
                G4();
            } else {
                runOnMainThread(new i());
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        M4();
        finish();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalStateException, IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R.layout.activity_music_record);
        this.w = ButterKnife.bind(this);
        this.actionbar.setTitle(ah4.e(R.string.music_record_title));
        this.actionbar.setBackAction(new a());
        rd3.f().C(this);
        rd3.f().y(this);
        k12.m.d(this, findViewById(R.id.music_control_bar), findViewById(R.id.music_play_layer_placeholder), new b());
        c cVar = new c();
        MusicControl.h0().d.b(cVar);
        MusicControl.h0().e.b(cVar);
        L4(0);
        G4();
        EventBus.getDefault().register(this);
        H4(MusicControl.h0().f);
        if (MusicControl.h0().f.getMusicType() == 1) {
            this.llBottom.setVisibility(4);
            this.llPlaying.setVisibility(8);
            this.llLoadStatus.setVisibility(0);
            this.p = false;
        } else {
            this.p = true;
            this.llBottom.setVisibility(0);
            this.llPlaying.setVisibility(0);
            this.llLoadStatus.setVisibility(8);
        }
        this.ivLoading.startAnimation(AnimationUtils.loadAnimation(this, R.anim.roate_img));
        this.tvMusicRecordStatus.setEnabled(false);
        this.tvMusicRecordStatus.setText(ah4.e(R.string.common_loading));
        this.tvMusicRecordStatus.setTextColor(ContextCompat.getColor(this, R.color.text_secondary_light));
        this.p = false;
        this.q.postDelayed(new d(), SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US);
        this.s = MusicControl.h0().g;
        if (MusicControl.h0().f != null && MusicControl.h0().f.getMusicType() != 2) {
            MusicControl.h0().s0(MusicControl.h0().g);
        }
        MusicControl.h0().w0(this);
        if (MusicControl.h0().f == null || MusicControl.h0().f.getMusicType() != 2) {
            this.mLlRecordProgress.setVisibility(0);
        } else {
            this.mLlRecordProgress.setVisibility(8);
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        M4();
        this.w.unbind();
        EventBus.getDefault().unregister(this);
        MusicControl.h0().K0(this);
        Timer timer = this.e;
        if (timer != null) {
            timer.purge();
            this.e.cancel();
        }
        TimerTask timerTask = this.f;
        if (timerTask != null) {
            timerTask.cancel();
            this.f = null;
        }
        this.t = false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(SavePatternFromPreview savePatternFromPreview) throws IOException {
        K4(false, true);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(SpotifyPlayEvent spotifyPlayEvent) {
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MusicControl.h0().T();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        if (MusicControl.h0().f.getMusicType() != 2) {
            this.tvMusicRecordProgress.setText(WearUtils.Q(i2 / 1000));
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MusicControl.h0().U();
        if (this.l) {
            this.k = !this.k;
            this.l = false;
            MusicControl.h0().t0(false);
            J4();
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.c = MusicControl.h0().f.getMusicType() != 2;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) throws IllegalStateException {
        this.c = false;
        if (MusicControl.h0().f.getMusicType() != 2) {
            if (seekBar.getProgress() > seekBar.getMax() - 5000) {
                seekBar.setProgress(seekBar.getMax() - 5000);
            }
            MusicControl.h0().D0(seekBar);
        }
    }

    @OnClick({R.id.ll_re_recording, R.id.ll_record_preview, R.id.ll_record_save, R.id.ll_record_pause, R.id.tv_music_record_status})
    public void onViewClicked(View view) throws IllegalStateException, IOException {
        switch (view.getId()) {
            case R.id.ll_re_recording /* 2131363563 */:
                if (System.currentTimeMillis() - this.x > 1000) {
                    this.llRecordPause.setAlpha(0.5f);
                    this.llRecordPause.setEnabled(false);
                    this.x = System.currentTimeMillis();
                    G4();
                    if (MusicControl.h0().f != null && MusicControl.h0().f.getMusicType() != 2) {
                        MusicControl.h0().s0(this.s);
                    }
                    this.parentHandler.postDelayed(new g(), 1000L);
                    break;
                }
                break;
            case R.id.ll_record_pause /* 2131363565 */:
                this.k = !this.k;
                J4();
                MusicControl.h0().t0(false);
                break;
            case R.id.ll_record_preview /* 2131363566 */:
                boolean z = this.k;
                if (!z) {
                    this.k = !z;
                    this.l = true;
                    MusicControl.h0().t0(false);
                    J4();
                }
                K4(true, false);
                break;
            case R.id.ll_record_save /* 2131363568 */:
                MusicControl.h0().p0();
                K4(false, true);
                break;
            case R.id.tv_music_record_status /* 2131365187 */:
                if (!this.p) {
                    this.ivLoading.clearAnimation();
                    this.q.removeCallbacksAndMessages(null);
                    this.ivLoading.setVisibility(0);
                    this.ivLoading.startAnimation(AnimationUtils.loadAnimation(this, R.anim.roate_img));
                    this.tvMusicRecordStatus.setEnabled(false);
                    this.tvMusicRecordStatus.setText(ah4.e(R.string.common_loading));
                    this.tvMusicRecordStatus.setTextColor(ContextCompat.getColor(this, R.color.text_secondary_light));
                    this.p = false;
                    this.q.postDelayed(new f(), SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US);
                    G4();
                    MusicControl.h0().s0(this.s);
                    break;
                }
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NetworkInfoEvent networkInfoEvent) {
        if (!networkInfoEvent.isAvailable && MusicControl.h0().f.getMusicType() == 1) {
            sg3.e(this, R.string.music_record_net_connect_error_tip);
        }
    }
}
