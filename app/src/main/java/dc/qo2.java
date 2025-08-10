package dc;

import android.text.TextUtils;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.io.Serializable;
import java.lang.reflect.Type;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NetSimpleSubscriber.java */
/* loaded from: classes3.dex */
public class qo2 extends vn2<bd4> implements Serializable {
    private zn2<String> callBack;
    private Type finalNeedType;

    public qo2(String str, Type type, zn2<String> zn2Var) {
        this.url = tn2.w(str) + str;
        this.finalNeedType = type;
        this.callBack = zn2Var;
    }

    public final void e(String str) throws JSONException {
        try {
            this.callBack.onSuccess(str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            new JSONObject(str).optString(XHTMLText.CODE, NetException.SERVER_UN_DEFINE_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // rx.Observer
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onNext(bd4 bd4Var) {
        try {
            String str = new String(bd4Var.bytes());
            String str2 = "====ResponseBody:====" + str;
            if (this.callBack != null) {
                e(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // rx.Observer
    public void onCompleted() {
    }

    @Override // dc.vn2, rx.Observer
    public void onError(Throwable th) {
        super.onError(th);
        try {
            zn2<String> zn2Var = this.callBack;
            if (zn2Var != null) {
                zn2Var.onSuccess(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // rx.Subscriber
    public void onStart() {
        super.onStart();
        if (d(WearUtils.x)) {
            return;
        }
        try {
            this.callBack.onSuccess(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isUnsubscribed()) {
            return;
        }
        unsubscribe();
    }
}
