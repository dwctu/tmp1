package com.wear.main.account;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.wear.BaseActivity;
import com.wear.phonertc.RequestPermissionActivity;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.cs3;
import dc.gg3;
import dc.is3;
import dc.nz1;
import dc.pj3;
import dc.q61;
import dc.qe3;
import dc.sg3;
import dc.tg3;
import dc.u51;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

/* loaded from: classes3.dex */
public class ChatBackGroudActivity extends BaseActivity {
    public File a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public File b;
    public Uri c;

    @BindView(R.id.iv_bg)
    public ImageView ivBg;

    @BindView(R.id.screan_root_layout)
    public LinearLayout screanRootLayout;

    public class a implements u51 {
        public final /* synthetic */ boolean a;

        /* renamed from: com.wear.main.account.ChatBackGroudActivity$a$a, reason: collision with other inner class name */
        public class C0084a implements is3.d {
            public C0084a() {
            }

            @Override // dc.is3.d
            public void doConfirm() {
                RequestPermissionActivity.s4(ChatBackGroudActivity.this);
            }
        }

        public a(boolean z) {
            this.a = z;
        }

        @Override // dc.u51
        public void a(List<String> list, boolean z) {
            is3.b bVar = new is3.b(ChatBackGroudActivity.this.activity);
            bVar.p(ah4.e(R.string.app_open_camera_permission));
            bVar.o(ah4.e(R.string.common_confirm));
            bVar.n(ah4.e(R.string.common_cancel));
            bVar.d(new C0084a());
            cs3.h(bVar).show();
        }

        @Override // dc.u51
        public void b(List<String> list, boolean z) {
            if (z) {
                ChatBackGroudActivity.this.w4(this.a);
            }
        }
    }

    public class b implements tg3.a {
        public b() {
        }

        @Override // dc.tg3.a
        public void a(Bitmap bitmap, String str) throws IOException {
            File fileO = WearUtils.O();
            WearUtils.q(WearUtils.c0(str), fileO);
            ChatBackGroudActivity.this.x4(fileO);
        }
    }

    public class c extends SimpleImageLoadingListener {
        public c() {
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (bitmap != null) {
                ChatBackGroudActivity.this.ivBg.setImageBitmap(bitmap);
            }
        }
    }

    public ChatBackGroudActivity() {
        File fileE0 = WearUtils.e0("camera.jpg");
        this.b = fileE0;
        this.c = Uri.fromFile(fileE0);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 16) {
            if (i2 == -1) {
                Uri data = this.c;
                if (intent != null && intent.getData() != null) {
                    data = intent.getData();
                }
                tg3.e(this.b, this, data, new b());
                return;
            }
            return;
        }
        if (i != 17 || intent == null || intent.getData() == null) {
            return;
        }
        Uri data2 = intent.getData();
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            options.inSampleSize = 2;
            options.inJustDecodeBounds = false;
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(getContentResolver().openInputStream(data2), null, options);
            Bitmap bitmapL = WearUtils.l(this.application, bitmapDecodeStream, v4(data2, bitmapDecodeStream));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapL.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            File fileO = WearUtils.O();
            WearUtils.r(byteArrayInputStream, fileO);
            if (fileO.exists()) {
                x4(fileO);
            } else {
                sg3.i(this, R.string.setting_black_image_not_exist);
            }
        } catch (Exception e) {
            e.printStackTrace();
            sg3.i(this, R.string.setting_black_image_not_exist);
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_chat_back_groud);
        ButterKnife.bind(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        File file = this.b;
        if (file == null || !file.exists()) {
            return;
        }
        this.b.delete();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        nz1.e().k(this.ivBg);
    }

    @OnClick({R.id.rl_sys_chat_bg, R.id.rl_chat_bg_photo, R.id.rl_chat_bg_camar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_chat_bg_camar /* 2131364249 */:
                u4(true);
                break;
            case R.id.rl_chat_bg_photo /* 2131364250 */:
                u4(false);
                break;
            case R.id.rl_sys_chat_bg /* 2131364306 */:
                pj3.f(this, ChatBackGroudSysActivity.class);
                break;
        }
    }

    @SuppressLint({"CheckResult"})
    public final void u4(boolean z) {
        q61 q61VarM = q61.m(this);
        q61VarM.h("android.permission.CAMERA", "android.permission.READ_MEDIA_IMAGES");
        q61VarM.j(new a(z));
    }

    public final String v4(Uri uri, Bitmap bitmap) {
        return qe3.g(this, uri, bitmap);
    }

    public final void w4(boolean z) {
        if (z) {
            this.c = tg3.l(this, this.b, 16);
            return;
        }
        if (this.b.exists()) {
            this.b.delete();
        }
        tg3.k(this, 17);
    }

    public final void x4(File file) throws IOException {
        if (file.exists()) {
            this.a = file;
            this.actionbar.getYesBtn().setEnabled(true);
            ImageLoader.getInstance().loadImage(Uri.fromFile(file).toString(), new ImageSize(gg3.e(this.application), gg3.c(this.application)), new c());
            nz1.e().l(this.a);
        }
    }
}
