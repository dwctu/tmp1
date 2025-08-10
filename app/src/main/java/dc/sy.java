package dc;

import com.component.dxhttp.NetException;
import com.google.gson.Gson;
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

/* compiled from: NetNoRuleSubscriber.java */
/* loaded from: classes.dex */
public class sy<T> extends my<bd4> implements Serializable {
    private ny<T> callback;
    private Type finalNeedType;

    public sy(String str, Type type, ny<T> nyVar) {
        this.url = str;
        this.finalNeedType = type;
        this.callback = nyVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.reactivestreams.Subscriber
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onNext(bd4 bd4Var) throws JSONException {
        boolean z;
        ny<T> nyVar;
        try {
            String str = new String(bd4Var.bytes());
            de0.i("NetNoRuleSubscriber", "====ResponseBody:====urlL: " + this.url + ", jsStr: " + str);
            if (fe0.a(str)) {
                throw new NetException(NetException.c, jy.c(" ResponseBody is Empty !"));
            }
            if (xd0.e(str, this.finalNeedType) == null) {
                throw new NetException(NetException.c, jy.c(" Json translate Type failed  Json = " + str));
            }
            if (str.startsWith("[")) {
                Class<?> cls = str.getClass();
                String strFromJson = str;
                if (cls != this.finalNeedType) {
                    strFromJson = new Gson().fromJson(str, this.finalNeedType);
                }
                if (strFromJson == null || (nyVar = this.callback) == null) {
                    return;
                }
                nyVar.d(strFromJson);
                return;
            }
            if (str.startsWith("{")) {
                JSONObject jSONObject = new JSONObject(str);
                try {
                    jSONObject.get("result");
                    z = true;
                } catch (JSONException unused) {
                    z = false;
                }
                boolean zOptBoolean = jSONObject.optBoolean("result", false);
                String strOptString = jSONObject.optString("message", jy.c("Json Response Body has no key message"));
                String strOptString2 = jSONObject.optString(XHTMLText.CODE, NetException.c);
                if (!z || zOptBoolean) {
                    try {
                        Class<?> cls2 = str.getClass();
                        String strFromJson2 = str;
                        if (cls2 != this.finalNeedType) {
                            strFromJson2 = new Gson().fromJson(str, this.finalNeedType);
                        }
                        if (strFromJson2 != null) {
                            ny<T> nyVar2 = this.callback;
                            if (nyVar2 != null) {
                                nyVar2.d(strFromJson2);
                                return;
                            }
                            return;
                        }
                    } catch (Exception unused2) {
                        if (zOptBoolean) {
                            ny<T> nyVar3 = this.callback;
                            if (nyVar3 != null) {
                                nyVar3.d(null);
                            }
                            de0.l("NetNoRuleSubscriber", " request is success ,but translate 'data' is failed .");
                            return;
                        }
                    }
                }
                jy.a aVarA = jy.a(strOptString2, strOptString);
                a(strOptString2, strOptString);
                ny<T> nyVar4 = this.callback;
                if (nyVar4 != null) {
                    nyVar4.b(new NetException(aVarA.a(), aVarA.b()));
                }
            }
        } catch (Exception e) {
            de0.i("NetNoRuleSubscriber", "====ResponseBody:====Exception====url: " + this.url);
            e.printStackTrace();
            ny<T> nyVar5 = this.callback;
            if (nyVar5 != null) {
                nyVar5.b(new NetException(NetException.c, jy.c(e.getMessage())));
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
        this.callback.b(new NetException(NetException.b, jy.b()));
        if (isDisposed()) {
            return;
        }
        dispose();
    }
}
