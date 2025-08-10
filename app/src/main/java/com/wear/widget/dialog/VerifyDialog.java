package com.wear.widget.dialog;

import android.content.Context;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.network.presenter.bean.VerifyEmailBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import dc.ge3;
import dc.is3;
import dc.tn2;
import dc.yn2;
import java.util.HashMap;
import rx.Subscription;

/* loaded from: classes4.dex */
public class VerifyDialog extends is3<String> {
    public static boolean h = false;
    public static boolean i = false;
    public boolean f;
    public boolean g;

    public class a implements ge3.b {
        public final /* synthetic */ c a;

        public a(VerifyDialog verifyDialog, c cVar) {
            this.a = cVar;
        }

        @Override // dc.ge3.b
        public void R1(int i, String str) {
            c cVar = this.a;
            if (cVar != null) {
                try {
                    cVar.c(i, str);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // dc.ge3.b
        public void i0(String str) {
            c cVar = this.a;
            if (cVar != null) {
                cVar.sendSuc();
            }
        }
    }

    public class b implements yn2<BaseResponseBeanNew<VerifyEmailBean>> {
        public final /* synthetic */ c a;

        public b(VerifyDialog verifyDialog, c cVar) {
            this.a = cVar;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBeanNew<VerifyEmailBean> baseResponseBeanNew) {
            if (baseResponseBeanNew == null) {
                this.a.b(-1);
                return;
            }
            VerifyEmailBean verifyEmailBean = baseResponseBeanNew.data;
            if (verifyEmailBean == null || !verifyEmailBean.isVerify()) {
                this.a.b(-1);
            } else {
                this.a.a();
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            this.a.b(-1);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public interface c {
        void a();

        void b(int i);

        void c(int i, String str);

        void sendSuc();
    }

    public VerifyDialog(Context context) {
        super(context);
        this.g = false;
    }

    public Subscription p(c cVar) {
        return tn2.x(WearUtils.x).i("/api/checkVerifyEmail", new HashMap(), new b(this, cVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void q(c cVar) {
        ge3.b("", this.f, (String) this.c, new a(this, cVar));
    }

    public void setAutoSend(boolean z) {
        this.g = z;
    }

    public void setEditEmail(boolean z) {
        this.f = z;
    }
}
