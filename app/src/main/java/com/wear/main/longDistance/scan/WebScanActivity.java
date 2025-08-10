package com.wear.main.longDistance.scan;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.huawei.hms.hmsscankit.OnResultCallback;
import com.huawei.hms.hmsscankit.RemoteView;
import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.lovense.wear.R;
import com.wear.activity.qrcode.QRCodeActivity;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.bean.response.QrCodeBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import com.wear.widget.dialog.InputQrcodeDailog;
import dc.ah4;
import dc.cs3;
import dc.is3;
import dc.sg3;
import dc.tg3;
import dc.tn2;
import dc.xe3;
import dc.ye3;
import dc.zn2;
import java.io.IOException;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* loaded from: classes3.dex */
public class WebScanActivity extends QRCodeActivity {
    public static final String v = WebScanActivity.class.getSimpleName();
    public FrameLayout m;
    public ProgressDialog n;
    public RemoteView o;
    public int p;
    public int q;
    public boolean s = true;
    public Handler t = new Handler(Looper.getMainLooper());
    public Runnable u = new b();

    public class a implements OnResultCallback {
        public a() {
        }

        @Override // com.huawei.hms.hmsscankit.OnResultCallback
        public void onResult(HmsScan[] hmsScanArr) {
            if (hmsScanArr == null || hmsScanArr.length <= 0 || hmsScanArr[0] == null || TextUtils.isEmpty(hmsScanArr[0].getOriginalValue()) || !WebScanActivity.this.s) {
                return;
            }
            WebScanActivity.this.s = false;
            xe3.a(WebScanActivity.v, "原始：result:" + hmsScanArr[0].getOriginalValue());
            WebScanActivity.this.t.removeCallbacksAndMessages(null);
            WebScanActivity.this.D5();
            WebScanActivity.this.Z4(hmsScanArr[0].getOriginalValue());
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WebScanActivity.this.s = true;
        }
    }

    public class c implements is3.c {
        public c() {
        }

        @Override // dc.is3.c
        public void doCancel() {
            WebScanActivity.this.T4();
        }
    }

    public class d implements InputQrcodeDailog.b {
        public final /* synthetic */ InputQrcodeDailog a;

        public d(InputQrcodeDailog inputQrcodeDailog) {
            this.a = inputQrcodeDailog;
        }

        @Override // com.wear.widget.dialog.InputQrcodeDailog.b
        public void a(String str) {
            this.a.dismiss();
            WebScanActivity.this.A5(str);
        }
    }

    public class e implements zn2<BaseResponseBeanNew<QrCodeBean>> {
        public e() {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBeanNew<QrCodeBean> baseResponseBeanNew) {
            WebScanActivity.this.dissDialog();
            WebScanActivity.this.Z4(baseResponseBeanNew.data.getQrDate());
        }

        @Override // dc.zn2
        public void onError(NetException netException) throws NumberFormatException {
            WebScanActivity.this.dissDialog();
            try {
                WebScanActivity.this.B5(Integer.parseInt(netException.getCode()), netException.getMessage());
            } catch (NumberFormatException unused) {
                WebScanActivity.this.B5(999999, netException.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T4() {
        this.t.removeCallbacksAndMessages(null);
        this.t.postDelayed(this.u, 1000L);
    }

    public final void A5(String str) {
        HashMap map = new HashMap();
        map.put(XHTMLText.CODE, str);
        showDialog();
        tn2.x(WearUtils.x).k("/api/remote/shortCode", map, new e());
    }

    public final void B5(int i, String str) {
        if (i == 70092) {
            sg3.h(R.string.invalid_unique_code);
            return;
        }
        if (i == 70093) {
            sg3.h(R.string.invalid_qr_code);
        } else if (TextUtils.isEmpty(str) || i == 99999) {
            sg3.l(ah4.e(R.string.common_internet_error));
        } else {
            sg3.l(str);
        }
    }

    public final void C5(HmsScan[] hmsScanArr) {
        for (int i = 0; i < hmsScanArr.length; i++) {
            String str = "扫码结果" + hmsScanArr[i].showResult;
            Z4(hmsScanArr[i].getOriginalValue());
        }
    }

    public final void D5() {
        ((Vibrator) getSystemService("vibrator")).vibrate(200L);
    }

    @Override // com.wear.BaseActivity
    public void dissDialog() {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        this.progressDialog.dismiss();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 23 && i2 == -1 && intent != null) {
            try {
                HmsScan[] hmsScanArrDecodeWithBitmap = ScanUtil.decodeWithBitmap(this, MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.parse(intent.getStringExtra("img_uri"))), new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(HmsScanBase.QRCODE_SCAN_TYPE, HmsScanBase.DATAMATRIX_SCAN_TYPE).setPhotoMode(true).create());
                if (hmsScanArrDecodeWithBitmap == null || hmsScanArrDecodeWithBitmap.length <= 0) {
                    sg3.h(R.string.qrcode_not_lovense_qrcode);
                } else {
                    C5(hmsScanArrDecodeWithBitmap);
                }
                return;
            } catch (IOException e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (i != 17 || i2 != -1 || intent == null || intent.getData() == null) {
            return;
        }
        Uri data = intent.getData();
        try {
            Intent intent2 = new Intent(this, (Class<?>) PictureEnlargeActivity.class);
            intent2.putExtra("picture_uri", data.toString());
            startActivityForResult(intent2, 23);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @OnClick({R.id.tv_input_code, R.id.scan_album_iv})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.scan_album_iv) {
            tg3.k(this.activity, 17);
            return;
        }
        if (id != R.id.tv_input_code) {
            return;
        }
        is3.b bVar = new is3.b(this);
        bVar.p(ah4.e(R.string.enter_qr_code));
        bVar.r(R.style.dialog_input);
        bVar.c(new c());
        InputQrcodeDailog inputQrcodeDailog = (InputQrcodeDailog) cs3.i(bVar, InputQrcodeDailog.class);
        inputQrcodeDailog.show();
        inputQrcodeDailog.setListener(new d(inputQrcodeDailog));
    }

    @Override // com.wear.activity.qrcode.QRCodeActivity, com.wear.xmpp.FragmentStateLossActivity, com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        setContentView(R.layout.activity_web_scan);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        this.m = (FrameLayout) findViewById(R.id.frameLayout);
        z5(bundle);
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.n = progressDialog;
        progressDialog.setMessage(ah4.e(R.string.common_loading));
        this.n.setIndeterminate(true);
        this.n.setCancelable(true);
        ye3.c("scan QR", "into page", null);
    }

    @Override // com.wear.activity.qrcode.QRCodeActivity, com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.o.onDestroy();
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.o.onPause();
    }

    @Override // com.wear.xmpp.FragmentStateLossActivity, com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.application.q0(this);
        this.o.onResume();
    }

    @Override // com.wear.xmpp.FragmentStateLossActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.o.onStart();
    }

    @Override // com.wear.xmpp.FragmentStateLossActivity, com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.o.onStop();
    }

    @Override // com.wear.BaseActivity
    public void showDialog() {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        this.progressDialog.show();
    }

    public final void z5(Bundle bundle) {
        float f = getResources().getDisplayMetrics().density;
        this.p = getResources().getDisplayMetrics().widthPixels;
        this.q = getResources().getDisplayMetrics().heightPixels;
        Rect rect = new Rect();
        int i = this.p;
        int i2 = ((int) (f * 240.0f)) / 2;
        rect.left = (i / 2) - i2;
        rect.right = (i / 2) + i2;
        int i3 = this.q;
        rect.top = (i3 / 2) - i2;
        rect.bottom = (i3 / 2) + i2;
        RemoteView remoteViewBuild = new RemoteView.Builder().setContext(this).setBoundingBox(rect).setFormat(0, new int[0]).build();
        this.o = remoteViewBuild;
        remoteViewBuild.setOnResultCallback(new a());
        this.o.onCreate(bundle);
        this.m.addView(this.o, new FrameLayout.LayoutParams(-1, -1));
    }
}
