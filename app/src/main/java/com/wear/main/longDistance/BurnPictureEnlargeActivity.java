package com.wear.main.longDistance;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.lovense.wear.R;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityPicture;
import com.wear.protocol.MessageType;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.hp;
import dc.kf;
import dc.wo;

/* loaded from: classes3.dex */
public class BurnPictureEnlargeActivity extends AppCompatActivity {
    public ImageView a;
    public LottieAnimationView b;
    public CommunMessage c = new CommunMessage();
    public CountDownTimer d = new a(5000, 1000);

    public class a extends CountDownTimer {
        public a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            BurnPictureEnlargeActivity.this.finish();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }
    }

    public class b extends wo<Drawable> {
        public final /* synthetic */ boolean d;

        public b(boolean z) {
            this.d = z;
        }

        @Override // dc.cp
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void f(@NonNull Drawable drawable, @Nullable hp<? super Drawable> hpVar) {
            BurnPictureEnlargeActivity.this.a.setImageDrawable(drawable);
            if (this.d) {
                return;
            }
            BurnPictureEnlargeActivity.this.b.setVisibility(0);
            BurnPictureEnlargeActivity.this.b.r();
            BurnPictureEnlargeActivity.this.d.start();
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("communMessage", BurnPictureEnlargeActivity.this.c);
            intent.putExtras(bundle);
            intent.putExtra("delect", true);
            BurnPictureEnlargeActivity.this.setResult(-1, intent);
        }

        @Override // dc.cp
        public void e(@Nullable Drawable drawable) {
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BurnPictureEnlargeActivity.this.finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.burn_picture_activity);
        getWindow().setFlags(8192, 8192);
        this.a = (ImageView) findViewById(R.id.burn_iv);
        this.b = (LottieAnimationView) findViewById(R.id.lottie_view_count_down);
        CommunMessage communMessage = (CommunMessage) getIntent().getSerializableExtra("burn_commun_message");
        this.c = communMessage;
        String strT4 = t4(communMessage);
        kf.z(this).v(strT4).A0(this.a);
        this.b.bringToFront();
        kf.z(this).v(strT4).x0(new b(this.c.isSelfMessage(WearUtils.y.r())));
        this.a.setOnClickListener(new c());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.d.cancel();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MyApplication.N().q0(this);
    }

    public final String t4(CommunMessage communMessage) {
        if (communMessage.getType() != MessageType.burnpicture || ((EntityPicture) communMessage.getDataBean()) == null) {
            return "";
        }
        String url = ((EntityPicture) communMessage.getDataBean()).getUrl();
        String localUrl = ((EntityPicture) communMessage.getDataBean()).getLocalUrl();
        String type = ((EntityPicture) communMessage.getDataBean()).getType();
        boolean z = !WearUtils.e1(type) && type.equals("emoji");
        if (!WearUtils.e1(localUrl) && (WearUtils.c0(localUrl).exists() || WearUtils.Z(localUrl).exists())) {
            return Uri.fromFile(z ? WearUtils.Z(localUrl) : WearUtils.c0(localUrl)).toString();
        }
        if (TextUtils.isEmpty(url)) {
            return "";
        }
        return WearUtils.e + url.replace("thum_", "");
    }
}
