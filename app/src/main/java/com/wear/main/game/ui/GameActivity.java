package com.wear.main.game.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.util.WearUtils;
import dc.qf3;
import dc.r32;
import dc.s32;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;
import pl.droidsonroids.gif.GifDrawable;

/* loaded from: classes3.dex */
public class GameActivity extends BaseActivity implements s32 {
    public Timer a;
    public long b;

    @BindView(R.id.iv_mirrorlife_play_wave)
    public ImageView ivMirrorlifePlayWave;

    @BindView(R.id.iv_top_bg)
    public ImageView ivTopBg;

    @BindView(R.id.tv_stop)
    public TextView tvStop;

    @BindView(R.id.tv_time)
    public TextView tvTime;

    @BindView(R.id.tv_tip)
    public TextView tvTip;

    public class a extends TimerTask {

        /* renamed from: com.wear.main.game.ui.GameActivity$a$a, reason: collision with other inner class name */
        public class RunnableC0099a implements Runnable {
            public RunnableC0099a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                GameActivity gameActivity = GameActivity.this;
                TextView textView = gameActivity.tvTime;
                if (textView != null) {
                    textView.setText(WearUtils.Q(gameActivity.b));
                }
            }
        }

        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            GameActivity.t4(GameActivity.this);
            GameActivity.this.runOnMainThread(new RunnableC0099a());
        }
    }

    public static /* synthetic */ long t4(GameActivity gameActivity) {
        long j = gameActivity.b;
        gameActivity.b = 1 + j;
        return j;
    }

    public static void w4(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) GameActivity.class));
    }

    @Override // dc.s32
    public void W0() {
        u4();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_game);
        qf3.C();
        ButterKnife.bind(this);
        v4();
        GifDrawable gifDrawable = (GifDrawable) this.ivMirrorlifePlayWave.getDrawable();
        if (!gifDrawable.isPlaying()) {
            gifDrawable.start();
        }
        EventBus.getDefault().register(this);
        r32.l().y(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        r32.l().y(null);
    }

    @OnClick({R.id.tv_stop})
    public void onViewClicked() {
        r32.l().k(true);
    }

    public final void u4() {
        Timer timer = this.a;
        if (timer != null) {
            timer.cancel();
            this.a = null;
        }
        finish();
    }

    public final void v4() {
        Timer timer = this.a;
        if (timer != null) {
            timer.cancel();
            this.a = null;
        }
        this.b = 0L;
        Timer timer2 = new Timer();
        this.a = timer2;
        timer2.schedule(new a(), 1000L, 1000L);
    }
}
