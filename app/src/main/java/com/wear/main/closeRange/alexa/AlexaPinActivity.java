package com.wear.main.closeRange.alexa;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.gms.common.internal.ImagesContract;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.main.account.FrequentActivity;
import com.wear.protocol.EntityAlexa;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.a12;
import dc.ah4;
import dc.eg3;
import dc.nd3;
import dc.pj3;
import java.util.Timer;
import java.util.TimerTask;
import org.bouncycastle.i18n.MessageBundle;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class AlexaPinActivity extends BaseActivity {
    public int a = -1;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;

    @BindView(R.id.alexa_btn)
    public Button alexaBtn;

    @BindView(R.id.alexa_tall)
    public TextView alexaTall;
    public Timer b;

    @BindView(R.id.more_command)
    public LinearLayout moreCommand;

    @BindView(R.id.pin_number)
    public TextView pinNumber;

    public class a implements View.OnClickListener {

        /* renamed from: com.wear.main.closeRange.alexa.AlexaPinActivity$a$a, reason: collision with other inner class name */
        public class C0095a implements a12.c {
            public C0095a() {
            }

            @Override // dc.a12.c
            public void a(String str) {
                AlexaPinActivity.this.v4(str);
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlexaPinActivity.this.addAnalyticsEventId("alexa_getpin", null);
            a12.e().f(WearUtils.y.r(), true, new C0095a());
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putString("tag", "alexa");
            bundle.putString(MessageBundle.TITLE_ENTRY, ah4.e(R.string.remote_alexa));
            String str = "";
            String strI = nd3.i(eg3.h(WearUtils.x, "gen_token_Key", ""));
            StringBuilder sb = new StringBuilder();
            sb.append("/alexa/guide/help?e=");
            if (!WearUtils.e1(WearUtils.y.r())) {
                str = nd3.n(WearUtils.y.r()) + "&g=" + strI;
            }
            sb.append(str);
            bundle.putString(ImagesContract.URL, sb.toString());
            pj3.g(AlexaPinActivity.this, FrequentActivity.class, bundle);
        }
    }

    public class c extends TimerTask {
        public c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            AlexaPinActivity alexaPinActivity = AlexaPinActivity.this;
            int i = alexaPinActivity.a;
            if (i >= 0) {
                int i2 = i - 1;
                alexaPinActivity.a = i2;
                alexaPinActivity.w4(i2);
            }
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ int a;

        public d(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.a;
            if (i <= 0) {
                if (i == 0) {
                    AlexaPinActivity.this.alexaBtn.setText(ah4.e(R.string.remote_alexa_get_pin));
                    AlexaPinActivity.this.alexaBtn.setEnabled(true);
                    return;
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("<font color='white'>");
            sb.append(String.format(ah4.e(R.string.remote_alexa_pin_expire), "</font><font color='#FF2D89'>" + this.a + "</font><font color='white'>s"));
            sb.append("</font>");
            AlexaPinActivity.this.alexaBtn.setText(Html.fromHtml(sb.toString()).toString());
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ String a;

        public e(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlexaPinActivity.this.isFinishing() || AlexaPinActivity.this.isDestroyed()) {
                return;
            }
            if (WearUtils.e1(this.a)) {
                AlexaPinActivity.this.alexaTall.setText(ah4.e(R.string.remote_alexa_launch_open));
                AlexaPinActivity.this.pinNumber.setText("");
                AlexaPinActivity.this.w4(0);
            } else {
                AlexaPinActivity.this.alexaTall.setText(ah4.e(R.string.remote_alexa_launch_pin));
                AlexaPinActivity.this.pinNumber.setText(this.a);
                AlexaPinActivity alexaPinActivity = AlexaPinActivity.this;
                alexaPinActivity.a = 30;
                alexaPinActivity.alexaBtn.setEnabled(false);
            }
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.remote_alexa_pin);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        this.alexaBtn.setOnClickListener(new a());
        this.moreCommand.setOnClickListener(new b());
        this.pinNumber.setText("");
        Timer timer = new Timer();
        this.b = timer;
        timer.schedule(new c(), 1000L, 1000L);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Timer timer = this.b;
        if (timer != null) {
            timer.cancel();
            this.b = null;
        }
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EntityAlexa entityAlexa) {
        if (entityAlexa == null || entityAlexa.getAlexaOPTType() != EntityAlexa.AlexaOPTType.bind) {
            return;
        }
        this.a = -1;
        finish();
        addAnalyticsEventId("alexa_bind", null);
        Bundle bundle = new Bundle();
        bundle.putString("tag", "alexa");
        bundle.putString(MessageBundle.TITLE_ENTRY, ah4.e(R.string.remote_alexa));
        String str = "";
        String strI = nd3.i(eg3.h(WearUtils.x, "gen_token_Key", ""));
        StringBuilder sb = new StringBuilder();
        sb.append("/alexa/guide/help?e=");
        if (!WearUtils.e1(WearUtils.y.r())) {
            str = nd3.n(WearUtils.y.r()) + "&g=" + strI;
        }
        sb.append(str);
        bundle.putString(ImagesContract.URL, sb.toString());
        pj3.g(this, FrequentActivity.class, bundle);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public final void v4(String str) {
        runOnUiThread(new e(str));
    }

    public final void w4(int i) {
        runOnUiThread(new d(i));
    }
}
