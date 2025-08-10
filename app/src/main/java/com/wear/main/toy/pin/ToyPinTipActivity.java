package com.wear.main.toy.pin;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Toy;
import com.wear.bean.ToyPinStatusBean;
import com.wear.dao.DaoUtils;
import com.wear.util.WearUtils;
import com.xtremeprog.sdk.ble.BleService;
import dc.ob0;
import dc.pc1;
import dc.qg3;
import dc.xc1;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class ToyPinTipActivity extends BaseActivity {
    public String a;
    public Toy b;
    public pc1 c;
    public boolean d = false;

    @BindView(R.id.iv_close)
    public ImageView ivClose;

    @BindView(R.id.tip_1_ok)
    public TextView tip1Ok;

    @BindView(R.id.tip_2_connect)
    public TextView tip2Connect;

    @BindView(R.id.tip_3_connecting)
    public TextView tip3Connecting;

    @BindView(R.id.tip_4_connect_again)
    public TextView tip4ConnectAgain;

    @BindView(R.id.tip_4_reseted)
    public TextView tip4Reseted;

    @BindView(R.id.toy_icon)
    public ImageView toyIcon;

    @BindView(R.id.toy_name)
    public TextView toyName;

    @BindView(R.id.toy_pin_tip_2)
    public LinearLayout toyPinTip2;

    @BindView(R.id.toy_pin_tip_3)
    public LinearLayout toyPinTip3;

    @BindView(R.id.toy_pin_tip_4)
    public LinearLayout toyPinTip4;

    @BindView(R.id.toy_pin_tip_text_1)
    public TextView toyPinTipText1;

    @BindView(R.id.toy_pin_tip_text_2)
    public TextView toyPinTipText2;

    @BindView(R.id.toy_pin_tip_text_3)
    public TextView toyPinTipText3;

    @BindView(R.id.toy_pin_tip_view)
    public View toyPinTipView;

    @BindView(R.id.toy_tip_3_connect_status)
    public TextView toyTip3ConnectStatus;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ToyPinTipActivity.this.finish();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ToyPinTipActivity.this.finish();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ToyPinTipActivity.this.toyPinTip2.setVisibility(8);
            ToyPinTipActivity.this.toyPinTip3.setVisibility(0);
            ToyPinTipActivity.this.toyPinTip4.setVisibility(8);
            ToyPinTipActivity.this.d = true;
            ToyPinTipActivity.this.b.setConnectTryNumb(4);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ToyPinTipActivity.this.toyPinTip2.setVisibility(8);
            ToyPinTipActivity.this.toyPinTip3.setVisibility(8);
            ToyPinTipActivity.this.toyPinTip4.setVisibility(0);
            ToyPinTipActivity.this.d = false;
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ToyPinTipActivity.this.d = false;
            ToyPinTipActivity.this.finish();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ToyPinTipActivity.this.d = true;
            ToyPinTipActivity.this.b.setConnectTryNumb(4);
        }
    }

    public ToyPinTipActivity() {
        new Handler();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_toy_pin_tip);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        this.a = getIntent().getStringExtra("toyId");
        getIntent().getIntExtra("type", 0);
        pc1 pc1VarG = WearUtils.x.G();
        this.c = pc1VarG;
        Toy toyQ = pc1VarG.Q(this.a);
        this.b = toyQ;
        if (toyQ == null) {
            finish();
            return;
        }
        toyQ.setConnectPriority(ob0.HIGH);
        this.toyIcon.setImageResource(Toy.getToyIconLinkedId(this.b.getType(), 0, false));
        if (WearUtils.e1(this.b.getDefineRename())) {
            this.toyName.setText(this.b.getSimpleName());
        } else {
            this.toyName.setText(this.b.getSimpleName() + " · " + this.b.getDefineRename());
        }
        this.ivClose.setOnClickListener(new a());
        this.toyPinTip2.setVisibility(0);
        this.toyPinTip3.setVisibility(8);
        this.toyPinTip4.setVisibility(8);
        this.tip1Ok.setOnClickListener(new b());
        this.tip2Connect.setOnClickListener(new c());
        this.tip3Connecting.setOnClickListener(new d());
        this.tip4Reseted.setOnClickListener(new e());
        this.tip4ConnectAgain.setOnClickListener(new f());
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.b.setConnectPriority(ob0.NORMAL);
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(xc1 xc1Var) {
        if (this.b.getAddress().equals(xc1Var.a()) && xc1Var.b() == 1) {
            w4(this.b.getAddress());
            DaoUtils.getToyPinStatusDao().updateOrAdd(new ToyPinStatusBean(this.b.getAddress(), 0));
            this.b.setIsSelect(1);
            DaoUtils.getToyDao().updateOrAdd(this.b);
            finish();
        }
    }

    public Toy u4() {
        return this.b;
    }

    public boolean v4() {
        return this.d;
    }

    public final void w4(String str) {
        ContentResolver contentResolver = getContentResolver();
        Uri uri = qg3.c;
        qg3.c(uri);
        if (contentResolver.getType(uri) == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(BleService.EXTRA_ADDR, str);
        contentValues.put("TYPE", (Integer) 0);
        contentValues.put("IS_ENCRYPT", Boolean.TRUE);
        contentValues.put("UPDATE_TIME", Long.valueOf(System.currentTimeMillis()));
        contentResolver.update(uri, contentValues, null, null);
    }
}
