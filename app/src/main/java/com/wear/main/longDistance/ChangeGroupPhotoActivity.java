package com.wear.main.longDistance;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.fastjson.JSON;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.BaseActivity;
import com.wear.bean.Group;
import com.wear.network.protocol.exception.NetException;
import com.wear.phonertc.RequestPermissionActivity;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.bo3;
import dc.ch3;
import dc.cs3;
import dc.ep1;
import dc.gg3;
import dc.gp1;
import dc.ii;
import dc.ip1;
import dc.is3;
import dc.kf;
import dc.kn3;
import dc.kv1;
import dc.q61;
import dc.qe3;
import dc.qo;
import dc.sg3;
import dc.t51;
import dc.tg3;
import dc.tn2;
import dc.u51;
import dc.vg3;
import dc.zb2;
import dc.zn2;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.jivesoftware.smackx.disco.bean.request.RequestRoomSetting;
import org.jivesoftware.smackx.disco.bean.response.BaseResponse;

/* loaded from: classes3.dex */
public class ChangeGroupPhotoActivity extends BaseActivity {
    public qo a;

    @BindView(R.id.ab_title)
    public MyActionBar abTitle;
    public Group b;
    public gp1 d;
    public File f;
    public Uri g;

    @BindView(R.id.iv_show_big_img)
    public RoundedImageView ivShowBigImg;

    @BindView(R.id.ll_screan_root_layout)
    public LinearLayout llScreanRootLayout;
    public int c = -1;
    public String e = "";

    public class a implements zn2<String> {

        /* renamed from: com.wear.main.longDistance.ChangeGroupPhotoActivity$a$a, reason: collision with other inner class name */
        public class RunnableC0108a implements Runnable {
            public final /* synthetic */ NormalResponse a;

            public RunnableC0108a(NormalResponse normalResponse) {
                this.a = normalResponse;
            }

            @Override // java.lang.Runnable
            public void run() {
                String message = this.a.getMessage();
                ChangeGroupPhotoActivity.this.C4(message);
                if (!message.startsWith("http")) {
                    message = WearUtils.e + message;
                }
                kf.z(ChangeGroupPhotoActivity.this).v(message).a(ChangeGroupPhotoActivity.this.a).A0(ChangeGroupPhotoActivity.this.ivShowBigImg);
            }
        }

        public a() {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class);
            if (normalResponse != null) {
                if (normalResponse != null && normalResponse.isResult()) {
                    ChangeGroupPhotoActivity.this.runOnMainThread(new RunnableC0108a(normalResponse));
                    return;
                } else {
                    ChangeGroupPhotoActivity.this.dissDialog();
                    sg3.k(ChangeGroupPhotoActivity.this, normalResponse.getMessage());
                    return;
                }
            }
            ChangeGroupPhotoActivity.this.dissDialog();
            sg3.j(ChangeGroupPhotoActivity.this, R.string.common_serverError, " [" + NetException.SERVICE_DATA_ERROR + "]");
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            ChangeGroupPhotoActivity.this.dissDialog();
            sg3.k(ChangeGroupPhotoActivity.this, netException.getMessage());
        }
    }

    public class b implements kv1 {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        @Override // dc.kv1
        public void a(String str) {
            if (((BaseResponse) JSON.parseObject(str, BaseResponse.class)).suc()) {
                ChangeGroupPhotoActivity.this.b.setUrl(this.a);
                ChangeGroupPhotoActivity.this.b.setMcs(this.a);
                sg3.i(ChangeGroupPhotoActivity.this, R.string.comman_saved_successfully);
            }
            ChangeGroupPhotoActivity.this.dissDialog();
        }

        @Override // dc.kv1
        public void onError(Exception exc) {
            ChangeGroupPhotoActivity.this.dissDialog();
        }
    }

    public class c implements MyActionBar.f {
        public c() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            if (ChangeGroupPhotoActivity.this.b.isExit()) {
                return;
            }
            ChangeGroupPhotoActivity.this.A4();
        }
    }

    public class d implements bo3.d {
        public d() {
        }

        @Override // dc.bo3.d
        public void a(int i) {
            ChangeGroupPhotoActivity.this.y4(R.id.from_camera);
        }
    }

    public class e implements bo3.d {
        public e() {
        }

        @Override // dc.bo3.d
        public void a(int i) {
            ChangeGroupPhotoActivity.this.y4(R.id.from_album);
        }
    }

    public class f implements u51 {

        public class a implements is3.d {
            public a() {
            }

            @Override // dc.is3.d
            public void doConfirm() {
                RequestPermissionActivity.s4(ChangeGroupPhotoActivity.this);
            }
        }

        public f() {
        }

        @Override // dc.u51
        public void a(List<String> list, boolean z) {
            t51.a(this, list, z);
            if (z) {
                is3.b bVar = new is3.b(ChangeGroupPhotoActivity.this.activity);
                bVar.p(ah4.e(R.string.app_open_camera_permission));
                bVar.o(ah4.e(R.string.common_confirm));
                bVar.n(ah4.e(R.string.common_cancel));
                bVar.d(new a());
                cs3.h(bVar).show();
            }
        }

        @Override // dc.u51
        public void b(List<String> list, boolean z) {
            if (z) {
                ChangeGroupPhotoActivity.this.z4();
            }
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ Intent a;

        public class a implements tg3.a {
            public a() {
            }

            @Override // dc.tg3.a
            public void a(Bitmap bitmap, String str) {
                ChangeGroupPhotoActivity.this.B4(null);
            }
        }

        public g(Intent intent) {
            this.a = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uri data = ChangeGroupPhotoActivity.this.g;
            Intent intent = this.a;
            if (intent != null && intent.getData() != null) {
                data = this.a.getData();
            }
            tg3.e(ChangeGroupPhotoActivity.this.f, ChangeGroupPhotoActivity.this, data, new a());
        }
    }

    public class h implements ip1 {
        public h() {
        }

        @Override // dc.ip1
        public void G() {
            ChangeGroupPhotoActivity.this.dissDialog();
        }

        @Override // dc.ip1
        public void d() {
            ChangeGroupPhotoActivity.this.cancleDelay();
        }
    }

    public class i implements Runnable {
        public final /* synthetic */ Bitmap a;

        public i(Bitmap bitmap) {
            this.a = bitmap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(Bitmap bitmap) {
            ChangeGroupPhotoActivity.this.B4(bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d(Bitmap bitmap) throws IOException {
            final Bitmap bitmapI2 = WearUtils.I2(bitmap);
            WearUtils.d2(bitmapI2, ChangeGroupPhotoActivity.this.f.getPath());
            ChangeGroupPhotoActivity.this.parentHandler.post(new Runnable() { // from class: dc.j42
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b(bitmapI2);
                }
            });
        }

        @Override // java.lang.Runnable
        public void run() {
            vg3 vg3VarB = vg3.b();
            final Bitmap bitmap = this.a;
            vg3VarB.a(new Runnable() { // from class: dc.i42
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    this.a.d(bitmap);
                }
            });
        }
    }

    public class j implements ip1 {
        public j() {
        }

        @Override // dc.ip1
        public void G() {
            ChangeGroupPhotoActivity.this.dissDialog();
        }

        @Override // dc.ip1
        public void d() {
            ChangeGroupPhotoActivity.this.cancleDelay();
        }
    }

    public class k implements kn3.d {
        public k() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            RequestPermissionActivity.s4(ChangeGroupPhotoActivity.this);
        }
    }

    public ChangeGroupPhotoActivity() {
        File fileE0 = WearUtils.e0("camera.jpg");
        this.f = fileE0;
        this.g = Uri.fromFile(fileE0);
    }

    public final void A4() {
        bo3 bo3Var = new bo3(this, R.layout.bottom_sheet_account_photo);
        bo3Var.show();
        bo3Var.d(R.id.from_camera, new d());
        bo3Var.d(R.id.from_album, new e());
        bo3Var.d(R.id.delete_avatar, null);
    }

    public final void B4(Bitmap bitmap) {
        HashMap map = new HashMap();
        map.put("type", "1");
        map.put("idstr", this.b.getId());
        showDialog();
        tn2.x(WearUtils.x).A("/wear/avatar/add", this.f, map, new a());
    }

    public final void C4(String str) {
        RequestRoomSetting requestRoomSetting = new RequestRoomSetting();
        requestRoomSetting.setRoomId(this.e);
        requestRoomSetting.setUrl(WearUtils.B(str));
        zb2.O().C0(requestRoomSetting, WearUtils.k0(this.e), new b(str));
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 16) {
            if (i3 == -1) {
                this.d = new gp1(new g(intent), new h());
                showDialog();
                ep1.b().r(this, this.d);
                return;
            }
            return;
        }
        if (i2 != 17) {
            if (i2 == 888 && i3 == -1) {
                boolean booleanExtra = intent.getBooleanExtra("grant_all", false);
                intent.getIntArrayExtra("grant_results");
                if (booleanExtra) {
                    z4();
                    return;
                } else {
                    new kn3((Context) this, ah4.e(R.string.app_open_camera_permission), ah4.e(R.string.common_confirm), ah4.e(R.string.common_cancel), true, (kn3.d) new k()).show();
                    return;
                }
            }
            return;
        }
        if (i3 != -1 || intent == null || intent.getData() == null) {
            return;
        }
        Uri data = intent.getData();
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            options.inSampleSize = 2;
            options.inJustDecodeBounds = false;
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(getContentResolver().openInputStream(data), null, options);
            Bitmap bitmapL = WearUtils.l(this.application, bitmapDecodeStream, qe3.g(this, data, bitmapDecodeStream));
            if (bitmapL != null) {
                this.d = new gp1(new i(bitmapL), new j());
                if (ep1.b().r(this, this.d)) {
                    showDialog();
                }
            }
        } catch (Exception e2) {
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_change_group_photo);
        ButterKnife.bind(this);
        this.e = getIntent().getStringExtra("roomId");
        Group groupK = ch3.n().k(this.e);
        this.b = groupK;
        if (groupK == null) {
            finish();
            return;
        }
        this.a = new qo().h(R.drawable.chat_avatar_default).X(R.drawable.chat_avatar_default).f(ii.b);
        tg3.i(this.ivShowBigImg, this.b);
        this.abTitle.setTitle("");
        this.abTitle.setYesAction(ah4.e(R.string.common_change), new c());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ivShowBigImg.getLayoutParams();
        int iE = gg3.e(this);
        layoutParams.width = iE;
        layoutParams.height = iE;
        this.ivShowBigImg.setLayoutParams(layoutParams);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.application.s0("avatar", null);
        File file = this.f;
        if (file != null && file.exists()) {
            this.f.delete();
        }
        ep1.b().m(this);
    }

    public final void y4(int i2) {
        this.c = i2;
        q61 q61VarM = q61.m(this);
        q61VarM.h("android.permission.CAMERA", "android.permission.READ_MEDIA_IMAGES");
        q61VarM.j(new f());
    }

    public void z4() {
        int i2 = this.c;
        if (i2 == R.id.from_camera) {
            this.g = tg3.l(this, this.f, 16);
        } else if (i2 == R.id.from_album) {
            tg3.k(this, 17);
        }
    }
}
