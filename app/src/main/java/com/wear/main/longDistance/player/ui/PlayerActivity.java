package com.wear.main.longDistance.player.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.event.PlayerQuitEvent;
import com.wear.bean.event.PlayerToySelectEvent;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.bc2;
import dc.kn3;
import dc.qf3;
import dc.sz1;
import dc.tz1;
import dc.vf2;
import dc.xe3;
import dc.y22;
import dc.ye3;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class PlayerActivity extends BaseActivity implements tz1 {
    public Timer a;
    public long b;

    @BindView(R.id.log_text_view)
    public TextView logTextView;

    @BindView(R.id.tv_stop)
    public TextView tvStop;

    @BindView(R.id.tv_time)
    public TextView tvTime;

    @BindView(R.id.tv_tip)
    public TextView tvTip;

    public class a implements kn3.d {
        public a() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
            PlayerActivity.this.finish();
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            PlayerActivity.this.finish();
        }
    }

    public class b extends TimerTask {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayerActivity playerActivity = PlayerActivity.this;
                TextView textView = playerActivity.tvTime;
                if (textView != null) {
                    textView.setText(WearUtils.Q(playerActivity.b));
                }
            }
        }

        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            PlayerActivity.t4(PlayerActivity.this);
            PlayerActivity.this.runOnMainThread(new a());
        }
    }

    public static /* synthetic */ long t4(PlayerActivity playerActivity) {
        long j = playerActivity.b;
        playerActivity.b = 1 + j;
        return j;
    }

    public static void w4(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) PlayerActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean y4(View view) {
        y22.c().b(this);
        return false;
    }

    @Override // dc.tz1
    public int getPriority() {
        return 4;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_player);
        qf3.C();
        ButterKnife.bind(this);
        v4();
        if (WearUtils.v) {
            findViewById(R.id.top_view).setOnLongClickListener(new View.OnLongClickListener() { // from class: dc.cc2
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return this.a.y4(view);
                }
            });
        }
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bc2.r().n();
        EventBus.getDefault().unregister(this);
        sz1.d().s(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(PlayerToySelectEvent playerToySelectEvent) {
        if (playerToySelectEvent.isHide()) {
            this.tvTip.setVisibility(8);
            return;
        }
        if (TextUtils.isEmpty(playerToySelectEvent.getToyId())) {
            return;
        }
        this.tvTip.setVisibility(0);
        if (playerToySelectEvent.isConnected()) {
            this.tvTip.setText(String.format(ah4.e(R.string.player_select_toy_connect), playerToySelectEvent.getToyName()));
        } else {
            this.tvTip.setText(String.format(ah4.e(R.string.player_select_toy_disconnect), playerToySelectEvent.getToyName()));
        }
    }

    @OnClick({R.id.tv_stop})
    public void onViewClicked() {
        xe3.a(vf2.e, "点击Stop 退出界面！");
        HashMap map = new HashMap();
        map.put("reason", "点击Stop 退出界面！");
        map.put("time", Long.valueOf(this.b));
        map.put("type", 0);
        map.put("isConnect", Boolean.valueOf(vf2.o().l()));
        ye3.d("F0028", WearUtils.A.toJson(map));
        u4();
    }

    @Override // dc.tz1
    public void pauseConnon(int i) {
    }

    @Override // dc.tz1
    public void recovery() {
    }

    @Override // dc.tz1
    public void stop(int i) {
        xe3.a(vf2.e, "收到其他 退出界面！");
        HashMap map = new HashMap();
        map.put("reason", "收到其他更高优先级控制，退出Media Play");
        map.put("time", Long.valueOf(this.b));
        map.put("type", 0);
        ye3.d("F0028", WearUtils.A.toJson(map));
        u4();
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
        timer2.schedule(new b(), 1000L, 1000L);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(PlayerQuitEvent playerQuitEvent) {
        if (playerQuitEvent.getErrorCode() == 102) {
            kn3 kn3Var = new kn3((Context) this, ah4.e(R.string.player_disconnect_error), ah4.e(R.string.common_ok), false, false, (kn3.d) new a());
            kn3Var.n();
            kn3Var.show();
            return;
        }
        u4();
    }
}
