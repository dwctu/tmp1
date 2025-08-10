package dc;

import com.wear.network.protocol.exception.NetException;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import java.util.HashMap;

/* compiled from: AlexaInstance.java */
/* loaded from: classes3.dex */
public class a12 {
    public static a12 c;
    public boolean a = false;
    public String b;

    /* compiled from: AlexaInstance.java */
    public class a implements zn2<String> {
        public final /* synthetic */ d a;

        public a(d dVar) {
            this.a = dVar;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            boolean z;
            boolean z2 = false;
            if (!WearUtils.e1(str)) {
                NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class);
                if (normalResponse == null || !normalResponse.isResult() || normalResponse.getData() == null) {
                    a12.this.a = false;
                    z = a12.this.a;
                } else {
                    a12.this.a = WearUtils.y1(normalResponse.getData().toString());
                    z = a12.this.a;
                }
                z2 = z;
            }
            d dVar = this.a;
            if (dVar != null) {
                dVar.a(z2);
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            d dVar = this.a;
            if (dVar != null) {
                dVar.a(false);
            }
        }
    }

    /* compiled from: AlexaInstance.java */
    public class b implements zn2<String> {
        public final /* synthetic */ c a;

        public b(c cVar) {
            this.a = cVar;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            String str2 = "";
            if (WearUtils.e1(str)) {
                ye3.d("H0003", "resultData==null");
            } else {
                NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class);
                if (normalResponse == null || !normalResponse.isResult() || normalResponse.getData() == null) {
                    a12.this.b = "";
                    String str3 = a12.this.b;
                    ye3.d("H0003", str);
                    str2 = str3;
                } else {
                    a12.this.b = normalResponse.getData().toString();
                    String str4 = a12.this.b;
                    ye3.d("H0002", a12.this.b);
                    str2 = str4;
                }
            }
            c cVar = this.a;
            if (cVar != null) {
                cVar.a(str2);
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            c cVar = this.a;
            if (cVar != null) {
                cVar.a("");
            }
            ye3.d("H0003", netException.getMessage());
        }
    }

    /* compiled from: AlexaInstance.java */
    public interface c {
        void a(String str);
    }

    /* compiled from: AlexaInstance.java */
    public interface d {
        void a(boolean z);
    }

    public static a12 e() {
        if (c == null) {
            c = new a12();
        }
        return c;
    }

    public void f(String str, boolean z, c cVar) {
        if (z) {
            HashMap map = new HashMap();
            ye3.d("H0001", "");
            tn2.x(WearUtils.x).l("/app/alexa/pin", map, new b(cVar));
        } else if (cVar != null) {
            cVar.a(this.b);
        }
    }

    public void g(String str, boolean z, d dVar) {
        if (z) {
            HashMap map = new HashMap();
            map.put("t", Long.valueOf(be3.I().getTime()));
            tn2.x(WearUtils.x).l("/app/alexa/pin/status", map, new a(dVar));
        } else if (dVar != null) {
            dVar.a(this.a);
        }
    }

    public void h() {
        this.a = false;
        c = null;
    }
}
