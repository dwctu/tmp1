package dc;

import com.component.dxhttp.NetException;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import dc.jy;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.HttpException;

/* compiled from: NetAllSubscriber.java */
/* loaded from: classes.dex */
public class ry<T> extends my<bd4> implements Serializable {
    private ny<T> callback;
    private Type finalNeedType;

    public ry(String str, Type type, ny<T> nyVar) {
        this.url = str;
        this.finalNeedType = type;
        this.callback = nyVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(String str) throws JSONException, JsonSyntaxException {
        JSONObject jSONObject = new JSONObject(str);
        boolean zOptBoolean = jSONObject.optBoolean("result", false);
        String strOptString = jSONObject.optString("message", jy.d(null));
        String strOptString2 = jSONObject.optString(XHTMLText.CODE, NetException.j);
        if (!zOptBoolean) {
            jy.a aVarA = jy.a(strOptString2, strOptString);
            a(strOptString2, strOptString);
            this.callback.b(new NetException(aVarA.a(), aVarA.b()));
            return;
        }
        Class<?> cls = str.getClass();
        String strFromJson = str;
        if (cls != this.finalNeedType) {
            strFromJson = new Gson().fromJson(str, this.finalNeedType);
        }
        try {
            this.callback.d(strFromJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // org.reactivestreams.Subscriber
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onNext(bd4 bd4Var) {
        try {
            String str = new String(bd4Var.bytes());
            if (this.callback != null) {
                try {
                    if (fe0.a(str)) {
                        throw new NetException(NetException.c, jy.d(null));
                    }
                    d(str);
                } catch (Exception e) {
                    de0.i("NetAllSubscriber", "====ResponseBody:=====Exception====url: " + this.url + ", jsStr: " + str);
                    e.printStackTrace();
                    ny<T> nyVar = this.callback;
                    if (nyVar != null) {
                        nyVar.b(new NetException(NetException.c, jy.d(e)));
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            ny<T> nyVar2 = this.callback;
            if (nyVar2 != null) {
                nyVar2.b(new NetException(NetException.c, jy.d(e2)));
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        ny<T> nyVar = this.callback;
        if (nyVar != null) {
            nyVar.a();
        }
    }

    @Override // dc.my, org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        super.onError(th);
        if (this.callback != null) {
            th.printStackTrace();
            if (th instanceof SocketTimeoutException) {
                this.callback.b(new NetException(NetException.d, jy.e()));
                return;
            }
            if (th instanceof HttpException) {
                this.callback.b(new NetException(NetException.e, jy.d(th)));
                return;
            }
            if (th instanceof ConnectException) {
                this.callback.b(new NetException(NetException.f, jy.d(th)));
                return;
            }
            if (th instanceof TimeoutException) {
                this.callback.b(new NetException(NetException.g, jy.d(th)));
                return;
            }
            if (th instanceof SocketException) {
                this.callback.b(new NetException(NetException.h, jy.d(th)));
            } else if (th instanceof NullPointerException) {
                this.callback.b(new NetException(NetException.h, jy.d(th)));
            } else {
                this.callback.b(new NetException(NetException.a, jy.d(th)));
            }
        }
    }

    @Override // io.reactivex.subscribers.DisposableSubscriber
    public void onStart() {
        super.onStart();
        if (c(ve0.a())) {
            ny<T> nyVar = this.callback;
            if (nyVar != null) {
                nyVar.c();
                return;
            }
            return;
        }
        ny<T> nyVar2 = this.callback;
        if (nyVar2 != null) {
            nyVar2.b(new NetException(NetException.b, jy.b()));
        }
        if (isDisposed()) {
            return;
        }
        dispose();
    }
}
