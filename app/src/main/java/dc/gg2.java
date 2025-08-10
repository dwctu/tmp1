package dc;

import android.app.Dialog;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.bean.response.QrCodeBean;
import com.wear.bean.socketio.scan.ScanBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.is3;
import java.util.HashMap;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: RemoteVibrateJump.java */
/* loaded from: classes3.dex */
public class gg2 implements yc2 {
    public static gg2 e;
    public final MyApplication a = WearUtils.x;
    public String b;
    public BaseActivity c;
    public Dialog d;

    /* compiled from: RemoteVibrateJump.java */
    public class a implements zn2<BaseResponseBeanNew<QrCodeBean>> {
        public a() {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBeanNew<QrCodeBean> baseResponseBeanNew) {
            gg2.this.c();
            String strH = nd3.h(baseResponseBeanNew.data.getQrDate());
            if (TextUtils.isEmpty(strH)) {
                sg3.h(R.string.qrcode_not_lovense_qrcode);
                return;
            }
            xe3.a(gg2.this.b, "解密：result:" + strH);
            ScanBean scanBean = null;
            try {
                scanBean = (ScanBean) JSON.parseObject(strH, ScanBean.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (scanBean == null) {
                sg3.h(R.string.qrcode_not_lovense_qrcode);
            } else if ("c".equals(scanBean.getA())) {
                sg3.h(R.string.qrcode_scan_with_connect);
            } else {
                fg2.j().l(scanBean.getD(), gg2.this);
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) throws NumberFormatException {
            gg2.this.c();
            try {
                int i = Integer.parseInt(netException.getCode());
                if (i == 70092) {
                    sg3.h(R.string.invalid_unique_code);
                } else if (i == 70093) {
                    sg3.h(R.string.invalid_qr_code);
                } else if (TextUtils.isEmpty(netException.message) || i == 99999) {
                    sg3.l(ah4.e(R.string.common_internet_error));
                } else {
                    sg3.l(netException.message);
                }
            } catch (NumberFormatException unused) {
                if (TextUtils.isEmpty(netException.message)) {
                    sg3.l(ah4.e(R.string.common_internet_error));
                } else {
                    sg3.l(netException.message);
                }
            }
        }
    }

    public static gg2 d() {
        if (e == null) {
            synchronized (gg2.class) {
                if (e == null) {
                    e = new gg2();
                }
            }
        }
        return e;
    }

    @Override // dc.yc2
    public void S3() {
        c();
    }

    @Override // dc.yc2
    public void a2() {
    }

    public final void c() {
        BaseActivity baseActivity = this.c;
        if (baseActivity != null) {
            baseActivity.dissDialog();
        }
    }

    public void e(BaseActivity baseActivity, String str) {
        if (WearUtils.e1(str)) {
            return;
        }
        this.c = baseActivity;
        if (TextUtils.isEmpty(str)) {
            sg3.h(R.string.qrcode_not_lovense_qrcode);
            return;
        }
        HashMap map = new HashMap();
        map.put(XHTMLText.CODE, str);
        f();
        tn2.x(WearUtils.x).k("/api/remote/shortCode", map, new a());
    }

    @Override // dc.yc2
    public void e0() {
        f();
    }

    public final void f() {
        BaseActivity baseActivity = this.c;
        if (baseActivity != null) {
            baseActivity.showDialog();
        }
    }

    @Override // dc.yc2
    public void f1() {
    }

    @Override // dc.yc2
    public boolean x2(String str) {
        if (this.a.G().N() != null) {
            return true;
        }
        if (this.c.isFinishing() || this.c.isDestroyed()) {
            sg3.l(str);
            return false;
        }
        Dialog dialog = this.d;
        if (dialog != null && dialog.isShowing()) {
            this.d.dismiss();
        }
        is3.b bVar = new is3.b(this.c);
        bVar.p(str);
        bVar.k(R.layout.dialog_default_ok_new);
        is3 is3VarH = cs3.h(bVar);
        this.d = is3VarH;
        is3VarH.show();
        return false;
    }
}
