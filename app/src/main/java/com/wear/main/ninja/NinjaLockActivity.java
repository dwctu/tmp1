package com.wear.main.ninja;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.wear.bean.event.LanguageEvent;
import com.wear.bean.event.NinjaLiveChangeEvent;
import com.wear.bean.event.NinjaLockTimeEvent;
import com.wear.bean.event.NinjaMusicChangeEvent;
import com.wear.bean.event.NinjaPatternChangeEvent;
import com.wear.bean.event.NinjaRemoteChangeEvent;
import com.wear.bean.event.NinjaSoundChangeEvent;
import com.wear.bean.event.NinjaSpeedModeChangeEvent;
import com.wear.bean.event.NotificationCloseEvent;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.ninja.view.SlidingFinishLayout;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.be3;
import dc.g12;
import dc.gg3;
import dc.i12;
import dc.k12;
import dc.lg3;
import dc.md2;
import java.text.DateFormat;
import java.util.Date;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class NinjaLockActivity extends AppCompatActivity implements SlidingFinishLayout.a, MusicControl.h {

    @BindView(R.id.btn_custom_loop)
    public ImageView btnCustomLoop;

    @BindView(R.id.btn_custom_next)
    public ImageView btnCustomNext;

    @BindView(R.id.btn_custom_play)
    public ImageView btnCustomPlay;

    @BindView(R.id.btn_custom_prev)
    public ImageView btnCustomPrev;
    public String c;
    public String d;
    public boolean e;
    public String f;

    @BindView(R.id.iv_audio)
    public ImageView ivAudio;

    @BindView(R.id.iv_audio_icon)
    public ImageView ivAudioIcon;

    @BindView(R.id.iv_under_preview)
    public ImageView iv_under_preview;

    @BindView(R.id.ll_custom_button)
    public LinearLayout llCustomButton;

    @BindView(R.id.music_seek)
    public SeekBar musicSeek;

    @BindView(R.id.music_loading_1)
    public ProgressBar music_loading_1;

    @BindView(R.id.rl_audio_effect)
    public RelativeLayout rlAudioEffect;

    @BindView(R.id.tv_audio)
    public TextView tvAudio;

    @BindView(R.id.tv_audio_name)
    public TextView tvAudioName;

    @BindView(R.id.lock_date)
    public TextView tvLockDate;

    @BindView(R.id.lock_time)
    public TextView tvLockTime;

    @BindView(R.id.lock_root)
    public SlidingFinishLayout vLockRoot;
    public int a = -1;
    public int b = 0;
    public int g = 100;
    public int h = -1;

    public class a extends SimpleImageLoadingListener {
        public a() {
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            NinjaLockActivity.this.ivAudioIcon.setVisibility(8);
            ((ImageView) view).setImageBitmap(bitmap);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            NinjaLockActivity.this.ivAudioIcon.setVisibility(0);
            if (NinjaLockActivity.this.a == 0) {
                NinjaLockActivity ninjaLockActivity = NinjaLockActivity.this;
                ninjaLockActivity.ivAudio.setImageDrawable(ninjaLockActivity.getResources().getDrawable(R.drawable.musci_fullscreen_bg));
                return;
            }
            if (NinjaLockActivity.this.a == 1) {
                NinjaLockActivity ninjaLockActivity2 = NinjaLockActivity.this;
                ninjaLockActivity2.ivAudio.setImageDrawable(ninjaLockActivity2.getResources().getDrawable(R.drawable.pattern_fullscreen_bg));
                return;
            }
            if (NinjaLockActivity.this.a == 2) {
                NinjaLockActivity ninjaLockActivity3 = NinjaLockActivity.this;
                ninjaLockActivity3.ivAudio.setImageDrawable(ninjaLockActivity3.getResources().getDrawable(R.drawable.speedmode_fullscreen_bg));
                return;
            }
            if (NinjaLockActivity.this.a == 3) {
                NinjaLockActivity ninjaLockActivity4 = NinjaLockActivity.this;
                ninjaLockActivity4.ivAudio.setImageDrawable(ninjaLockActivity4.getResources().getDrawable(R.drawable.sound_fullscreen_bg));
            } else if (NinjaLockActivity.this.a == 4) {
                NinjaLockActivity ninjaLockActivity5 = NinjaLockActivity.this;
                ninjaLockActivity5.ivAudio.setImageDrawable(ninjaLockActivity5.getResources().getDrawable(R.drawable.remote_control_fullscreen_bg));
            } else if (NinjaLockActivity.this.a == 5) {
                NinjaLockActivity ninjaLockActivity6 = NinjaLockActivity.this;
                ninjaLockActivity6.ivAudio.setImageDrawable(ninjaLockActivity6.getResources().getDrawable(R.drawable.live_control_fullscreen_bg));
            }
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
            if (NinjaLockActivity.this.a == 0) {
                NinjaLockActivity ninjaLockActivity = NinjaLockActivity.this;
                ninjaLockActivity.ivAudio.setImageDrawable(ninjaLockActivity.getResources().getDrawable(R.drawable.musci_fullscreen_bg));
                return;
            }
            if (NinjaLockActivity.this.a == 1) {
                NinjaLockActivity ninjaLockActivity2 = NinjaLockActivity.this;
                ninjaLockActivity2.ivAudio.setImageDrawable(ninjaLockActivity2.getResources().getDrawable(R.drawable.pattern_fullscreen_bg));
                return;
            }
            if (NinjaLockActivity.this.a == 2) {
                NinjaLockActivity ninjaLockActivity3 = NinjaLockActivity.this;
                ninjaLockActivity3.ivAudio.setImageDrawable(ninjaLockActivity3.getResources().getDrawable(R.drawable.speedmode_fullscreen_bg));
                return;
            }
            if (NinjaLockActivity.this.a == 3) {
                NinjaLockActivity ninjaLockActivity4 = NinjaLockActivity.this;
                ninjaLockActivity4.ivAudio.setImageDrawable(ninjaLockActivity4.getResources().getDrawable(R.drawable.sound_fullscreen_bg));
            } else if (NinjaLockActivity.this.a == 4) {
                NinjaLockActivity ninjaLockActivity5 = NinjaLockActivity.this;
                ninjaLockActivity5.ivAudio.setImageDrawable(ninjaLockActivity5.getResources().getDrawable(R.drawable.remote_control_fullscreen_bg));
            } else if (NinjaLockActivity.this.a == 5) {
                NinjaLockActivity ninjaLockActivity6 = NinjaLockActivity.this;
                ninjaLockActivity6.ivAudio.setImageDrawable(ninjaLockActivity6.getResources().getDrawable(R.drawable.live_control_fullscreen_bg));
            }
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(this.a);
            intent.setPackage(NinjaLockActivity.this.getPackageName());
            NinjaLockActivity.this.sendBroadcast(intent);
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ String a;

        public c(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(this.a);
            intent.setPackage(NinjaLockActivity.this.getPackageName());
            NinjaLockActivity.this.sendBroadcast(intent);
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ String a;

        public d(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(this.a);
            intent.setPackage(NinjaLockActivity.this.getPackageName());
            NinjaLockActivity.this.sendBroadcast(intent);
        }
    }

    public class e implements View.OnClickListener {
        public final /* synthetic */ String a;

        public e(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(this.a);
            intent.setPackage(NinjaLockActivity.this.getPackageName());
            NinjaLockActivity.this.sendBroadcast(intent);
        }
    }

    public class f implements SeekBar.OnSeekBarChangeListener {
        public f(NinjaLockActivity ninjaLockActivity) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) throws IllegalStateException {
            MusicControl.h0().D0(seekBar);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(lg3.h(context));
    }

    @Override // com.wear.main.closeRange.music.MusicControl.h
    public void e1(i12 i12Var) {
        try {
            int iB = i12Var.b();
            if (iB == 3) {
                this.musicSeek.setProgress(i12Var.a());
            } else if (iB == 9) {
                this.musicSeek.setProgress(0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    @Override // com.wear.main.ninja.view.SlidingFinishLayout.a
    public void g0() {
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = resources.getConfiguration();
        if (configuration.fontScale != 1.0f) {
            configuration.fontScale = 1.0f;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return resources;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
        try {
            getWindow().addFlags(4718592);
            WearUtils.C(this);
            setContentView(R.layout.activity_lock);
            ButterKnife.bind(this);
            r4();
        } catch (Exception e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
        md2.c();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MusicControl.h0().K0(this);
        EventBus.getDefault().unregister(this);
        md2.d();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(LanguageEvent languageEvent) {
        recreate();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NinjaPatternChangeEvent ninjaPatternChangeEvent) {
        this.a = 1;
        v4(ninjaPatternChangeEvent.getChangeStatus(), ninjaPatternChangeEvent.getPatternName(), ninjaPatternChangeEvent.getPatternAuthor(), ninjaPatternChangeEvent.isPlayOrPause(), ninjaPatternChangeEvent.getNowMode(), null, -1, -1);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        s4();
        MyApplication.N().q0(this);
    }

    public final void r4() {
        this.vLockRoot.setOnSlidingFinishListener(this);
        int iE = gg3.e(this);
        ViewGroup.LayoutParams layoutParams = this.rlAudioEffect.getLayoutParams();
        layoutParams.height = iE;
        this.rlAudioEffect.setLayoutParams(layoutParams);
        Intent intent = getIntent();
        String action = intent.getAction();
        this.c = intent.getStringExtra("play_name");
        this.d = intent.getStringExtra("play_author");
        this.b = intent.getIntExtra("play_mode", 0);
        this.e = intent.getBooleanExtra("pattern_pause", false);
        if ("play_lock".equals(action)) {
            this.f = null;
            this.musicSeek.setVisibility(8);
            this.g = -1;
            this.a = 1;
            this.btnCustomLoop.setVisibility(0);
        } else if ("music_lock".equals(action)) {
            this.a = 0;
            g12 g12Var = k12.m;
            MusicControl.h0().w0(this);
            this.f = intent.getStringExtra("music_cover");
            this.g = intent.getIntExtra("music_duration", 100);
            this.musicSeek.setVisibility(0);
            this.btnCustomLoop.setVisibility(0);
        } else if ("speed_mode_lock".equals(action)) {
            this.a = 2;
            this.f = null;
            this.g = -1;
            this.musicSeek.setVisibility(8);
            this.h = intent.getIntExtra("speed_mode_sensitivity", 0);
            this.btnCustomLoop.setVisibility(8);
        } else if ("sound_lock".equals(action)) {
            this.a = 3;
            this.f = null;
            this.g = -1;
            this.h = intent.getIntExtra("sound_sensitivity", 0);
            this.musicSeek.setVisibility(8);
            this.btnCustomLoop.setVisibility(8);
        } else if ("remote_lock".equals(action)) {
            this.a = 4;
            this.f = null;
            this.g = -1;
            this.h = intent.getIntExtra("remote_sensitivity", 0);
            this.musicSeek.setVisibility(8);
            this.btnCustomLoop.setVisibility(8);
        } else if ("live_lock".equals(action)) {
            this.a = 5;
            this.f = null;
            this.g = -1;
            this.h = intent.getIntExtra("live_sensitivity", 0);
            this.musicSeek.setVisibility(8);
            this.btnCustomLoop.setVisibility(8);
        }
        v4(99, this.c, this.d, this.e, this.b, this.f, this.g, this.h);
        u4();
    }

    public final void s4() {
        try {
            this.tvLockTime.setText(be3.d.format(new Date()));
            this.tvLockDate.setText(DateFormat.getDateInstance(2, lg3.e(this)).format(new Date()) + " " + be3.s.format(new Date()));
        } catch (Exception e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    public final void t4(String str, String str2, boolean z, int i, String str3, int i2, int i3) {
        Resources resources;
        int i4;
        this.c = str;
        this.d = str2;
        this.b = i;
        this.e = z;
        if (this.a == 0) {
            this.musicSeek.setMax(i2);
        }
        this.tvAudioName.setText(str.replace("/*!/", ""));
        if ((ah4.e(R.string.patterns_under_review) + "/*!/").equals(str)) {
            this.iv_under_preview.setVisibility(0);
        } else {
            this.iv_under_preview.setVisibility(8);
        }
        this.tvAudio.setText(str2);
        this.f = str3;
        if (WearUtils.e1(str3)) {
            int i5 = this.a;
            if (i5 == 0) {
                this.ivAudio.setImageDrawable(getResources().getDrawable(R.drawable.musci_fullscreen_bg));
            } else if (i5 == 1) {
                this.ivAudio.setImageDrawable(getResources().getDrawable(R.drawable.pattern_fullscreen_bg));
            } else if (i5 == 2) {
                this.ivAudio.setImageDrawable(getResources().getDrawable(R.drawable.speedmode_fullscreen_bg));
            } else if (i5 == 3) {
                this.ivAudio.setImageDrawable(getResources().getDrawable(R.drawable.sound_fullscreen_bg));
            } else if (i5 == 4) {
                this.ivAudio.setImageDrawable(getResources().getDrawable(R.drawable.remote_control_fullscreen_bg));
            } else if (i5 == 5) {
                this.ivAudio.setImageDrawable(getResources().getDrawable(R.drawable.live_control_fullscreen_bg));
            }
        } else {
            ImageLoader.getInstance().displayImage(str3, this.ivAudio, MyApplication.Y, new a());
        }
        int i6 = this.a;
        if (i6 == 0) {
            if (WearUtils.e1(str3)) {
                this.ivAudioIcon.setVisibility(0);
            } else {
                this.ivAudioIcon.setVisibility(8);
            }
            this.ivAudioIcon.setImageDrawable(getResources().getDrawable(R.drawable.fullscreen_musci));
        } else if (i6 == 1) {
            this.ivAudioIcon.setImageDrawable(getResources().getDrawable(R.drawable.fullscreen_pattern));
        } else if (i6 == 2) {
            this.btnCustomLoop.setVisibility(8);
            this.tvAudio.setVisibility(8);
            this.musicSeek.setVisibility(8);
            this.btnCustomPrev.setAlpha(0.4f);
            this.btnCustomNext.setAlpha(0.4f);
            this.ivAudioIcon.setImageDrawable(getResources().getDrawable(R.drawable.fullscreen_speedmode_dark));
        } else if (i6 == 3) {
            this.btnCustomPrev.setAlpha(0.4f);
            this.btnCustomNext.setAlpha(0.4f);
            if (i3 == 0) {
                this.btnCustomPrev.setAlpha(0.4f);
                this.btnCustomNext.setAlpha(1.0f);
            } else if (i3 == 100) {
                this.btnCustomNext.setAlpha(0.4f);
                this.btnCustomPrev.setAlpha(1.0f);
            } else {
                this.btnCustomNext.setAlpha(1.0f);
                this.btnCustomPrev.setAlpha(1.0f);
            }
            this.btnCustomLoop.setVisibility(8);
            this.tvAudio.setVisibility(8);
            this.musicSeek.setVisibility(8);
            this.ivAudioIcon.setImageDrawable(getResources().getDrawable(R.drawable.fullscreen_sound_dark));
        } else if (i6 == 4 || i6 == 5) {
            if (i3 == 0) {
                this.btnCustomPrev.setAlpha(0.4f);
                this.btnCustomNext.setAlpha(1.0f);
            } else if (i3 == 100) {
                this.btnCustomNext.setAlpha(0.4f);
                this.btnCustomPrev.setAlpha(1.0f);
            } else {
                this.btnCustomNext.setAlpha(1.0f);
                this.btnCustomPrev.setAlpha(1.0f);
            }
            this.btnCustomLoop.setVisibility(8);
            this.tvAudio.setVisibility(8);
            this.musicSeek.setVisibility(8);
            ImageView imageView = this.ivAudioIcon;
            if (this.a == 4) {
                resources = getResources();
                i4 = R.drawable.fullscreen_remote;
            } else {
                resources = getResources();
                i4 = R.drawable.fullscreen_live;
            }
            imageView.setImageDrawable(resources.getDrawable(i4));
        }
        int i7 = this.b;
        if (i7 == 0) {
            this.btnCustomLoop.setImageDrawable(getResources().getDrawable(R.drawable.widget_loop_all));
        } else if (i7 == 1) {
            this.btnCustomLoop.setImageDrawable(getResources().getDrawable(R.drawable.widget_loop_random));
        } else if (i7 == 2) {
            this.btnCustomLoop.setImageDrawable(getResources().getDrawable(R.drawable.widget_loop_single));
        }
        if (z) {
            this.btnCustomPlay.setImageDrawable(getResources().getDrawable(R.drawable.widget_play));
        } else {
            this.btnCustomPlay.setImageDrawable(getResources().getDrawable(R.drawable.widget_pause));
        }
    }

    public final void u4() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i = this.a;
        if (i == 0) {
            str = "com.wear.music.notify.prev";
            str5 = "com.wear.music.notify.play_state";
            str6 = "com.wear.music.notify.next";
            str4 = "com.wear.music.notify.loop";
        } else if (i == 1) {
            str = "com.wear.pattern.notify.prev";
            str5 = "com.wear.pattern.notify.play_state";
            str6 = "com.wear.pattern.notify.next";
            str4 = "com.wear.pattern.notify.loop";
        } else {
            if (i == 3) {
                str = "com.wear.sound.notify.prev";
                str2 = "com.wear.sound.notify.play_state";
                str3 = "com.wear.sound.notify.next";
            } else if (i == 4) {
                str = "com.wear.remote.notify.prev";
                str2 = "com.wear.remote.notify.play_state";
                str3 = "com.wear.remote.notify.next";
            } else {
                str = "com.wear.live.notify.prev";
                str2 = "com.wear.live.notify.play_state";
                str3 = "com.wear.live.notify.next";
            }
            String str7 = str3;
            str4 = "";
            str5 = str2;
            str6 = str7;
        }
        this.btnCustomNext.setOnClickListener(new b(str6));
        this.btnCustomPrev.setOnClickListener(new c(str));
        this.btnCustomPlay.setOnClickListener(new d(str5));
        this.btnCustomLoop.setOnClickListener(new e(str4));
        this.musicSeek.setOnSeekBarChangeListener(new f(this));
    }

    public final void v4(int i, String str, String str2, boolean z, int i2, String str3, int i3, int i4) {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
        if (i == 99) {
            t4(str, str2, z, i2, str3, i3, i4);
            return;
        }
        switch (i) {
            case 0:
                t4(str, str2, z, i2, str3, i3, i4);
                break;
            case 1:
                this.music_loading_1.setVisibility(8);
                this.btnCustomPlay.setVisibility(0);
                if (z) {
                    this.btnCustomPlay.setImageDrawable(getResources().getDrawable(R.drawable.widget_play));
                } else {
                    this.btnCustomPlay.setImageDrawable(getResources().getDrawable(R.drawable.widget_pause));
                }
                this.e = z;
                break;
            case 2:
                this.b = i2;
                if (i2 == 0) {
                    this.btnCustomLoop.setImageDrawable(getResources().getDrawable(R.drawable.widget_loop_all));
                    break;
                } else if (i2 == 1) {
                    this.btnCustomLoop.setImageDrawable(getResources().getDrawable(R.drawable.widget_loop_random));
                    break;
                } else if (i2 == 2) {
                    this.btnCustomLoop.setImageDrawable(getResources().getDrawable(R.drawable.widget_loop_single));
                    break;
                } else {
                    break;
                }
            case 3:
                this.music_loading_1.setVisibility(0);
                this.btnCustomPlay.setVisibility(8);
                break;
            case 4:
            case 5:
            case 6:
                if (i4 != 0) {
                    if (i4 != 100) {
                        this.btnCustomNext.setAlpha(1.0f);
                        this.btnCustomPrev.setAlpha(1.0f);
                        break;
                    } else {
                        this.btnCustomNext.setAlpha(0.2f);
                        this.btnCustomPrev.setAlpha(1.0f);
                        break;
                    }
                } else {
                    this.btnCustomPrev.setAlpha(0.2f);
                    this.btnCustomNext.setAlpha(1.0f);
                    break;
                }
            case 7:
                this.btnCustomPrev.setAlpha(0.2f);
                this.btnCustomNext.setAlpha(0.2f);
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NinjaMusicChangeEvent ninjaMusicChangeEvent) {
        this.a = 0;
        v4(ninjaMusicChangeEvent.getChangeStatus(), ninjaMusicChangeEvent.getPatternName(), ninjaMusicChangeEvent.getPatternAuthor(), ninjaMusicChangeEvent.isPlayOrPause(), ninjaMusicChangeEvent.getNowMode(), ninjaMusicChangeEvent.getImagePath(), ninjaMusicChangeEvent.getMusicDuration(), -1);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NinjaSpeedModeChangeEvent ninjaSpeedModeChangeEvent) {
        this.a = 2;
        v4(ninjaSpeedModeChangeEvent.getChangeStatus(), ah4.e(R.string.discover_speed_mode), "", ninjaSpeedModeChangeEvent.isPlayOrPause(), 0, null, -1, ninjaSpeedModeChangeEvent.getSensitivity());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NinjaSoundChangeEvent ninjaSoundChangeEvent) {
        this.a = 3;
        v4(ninjaSoundChangeEvent.getChangeStatus(), ah4.e(R.string.alarm_defind_record_audio), "", ninjaSoundChangeEvent.isPlayOrPause(), 0, null, -1, ninjaSoundChangeEvent.getSensitivity());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NinjaRemoteChangeEvent ninjaRemoteChangeEvent) {
        this.a = 4;
        v4(ninjaRemoteChangeEvent.getChangeStatus(), ah4.e(R.string.closeRange_remoteControl), "", ninjaRemoteChangeEvent.isPlayOrPause(), 0, null, -1, ninjaRemoteChangeEvent.getSensitivity());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NinjaLiveChangeEvent ninjaLiveChangeEvent) {
        this.a = 5;
        v4(ninjaLiveChangeEvent.getChangeStatus(), ninjaLiveChangeEvent.getTitle(), "", ninjaLiveChangeEvent.isPlayOrPause(), 0, null, -1, ninjaLiveChangeEvent.getSensitivity());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NotificationCloseEvent notificationCloseEvent) {
        finish();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NinjaLockTimeEvent ninjaLockTimeEvent) {
        s4();
    }
}
