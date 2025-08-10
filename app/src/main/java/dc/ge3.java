package dc;

import android.text.TextUtils;
import com.lovense.wear.R;
import com.wear.bean.response.BaseResponseStringBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.util.HashMap;

/* compiled from: EmailUtils.java */
/* loaded from: classes4.dex */
public class ge3 {
    public static boolean a;
    public static long b;

    /* compiled from: EmailUtils.java */
    public class a implements yn2<BaseResponseStringBean> {
        public final /* synthetic */ b a;
        public final /* synthetic */ String b;

        public a(b bVar, String str) {
            this.a = bVar;
            this.b = str;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseStringBean baseResponseStringBean) {
            boolean unused = ge3.a = false;
            ge3.b = System.currentTimeMillis();
            b bVar = this.a;
            if (bVar != null) {
                bVar.i0(this.b);
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
            boolean unused = ge3.a = false;
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            boolean unused = ge3.a = false;
            b bVar = this.a;
            if (bVar != null) {
                try {
                    bVar.R1(Integer.parseInt(netException.code), netException.getMessage());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: EmailUtils.java */
    public interface b {
        void R1(int i, String str);

        void i0(String str);
    }

    public static void b(String str, boolean z, String str2, b bVar) {
        if (a) {
            bVar.R1(-2, ah4.e(R.string.notif_note2));
            return;
        }
        if (System.currentTimeMillis() - b <= 60000) {
            bVar.R1(-3, ah4.e(R.string.notif_note2));
            return;
        }
        a = true;
        HashMap map = new HashMap();
        map.put("pf", "remote-android");
        if (z && !TextUtils.isEmpty(str2)) {
            map.put("email", nd3.w(str2));
        }
        map.put("language", lg3.b(WearUtils.x));
        tn2.x(WearUtils.x).p("/api/account/resendEmail", map, new a(bVar, str));
    }
}
