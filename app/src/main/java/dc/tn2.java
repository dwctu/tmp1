package dc;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.wear.bean.Pattern;
import com.wear.network.protocol.cookie.PersistentCookieJar;
import com.wear.network.protocol.cookie.cache.SetCookieCache;
import com.wear.network.protocol.cookie.persistence.SharedPrefsCookiePersistor;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import dc.so2;
import dc.uc4;
import dc.vc4;
import dc.yc4;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/* compiled from: NetworkNewUtils.java */
/* loaded from: classes3.dex */
public class tn2 {
    public static volatile vc4 e = null;
    public static volatile tn2 f = null;
    public static String g = "NetworkNewUtils";
    public final Observable.Transformer b = new a(this);
    public final Observable.Transformer c = new b(this);
    public final Observable.Transformer d = new c(this);
    public sn2 a = (sn2) new Retrofit.Builder().baseUrl(WearUtils.e).client(y()).addConverterFactory(bo2.a()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build().create(sn2.class);

    /* compiled from: NetworkNewUtils.java */
    public class a implements Observable.Transformer {
        public a(tn2 tn2Var) {
        }

        @Override // rx.functions.Func1
        public Object call(Object obj) {
            return ((Observable) obj).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        }
    }

    /* compiled from: NetworkNewUtils.java */
    public class b implements Observable.Transformer {
        public b(tn2 tn2Var) {
        }

        @Override // rx.functions.Func1
        public Object call(Object obj) {
            return ((Observable) obj).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(Schedulers.io());
        }
    }

    /* compiled from: NetworkNewUtils.java */
    public class c implements Observable.Transformer {
        public c(tn2 tn2Var) {
        }

        @Override // rx.functions.Func1
        public Object call(Object obj) {
            return obj;
        }
    }

    /* compiled from: NetworkNewUtils.java */
    public class d extends hw3 {
        public final /* synthetic */ f f;

        public d(tn2 tn2Var, f fVar) {
            this.f = fVar;
        }

        @Override // dc.hw3
        public void f(long j, long j2, float f, float f2) {
            try {
                f fVar = this.f;
                if (fVar != null) {
                    fVar.a(j, f, f2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // dc.hw3
        public void g() {
            super.g();
            try {
                f fVar = this.f;
                if (fVar != null) {
                    fVar.onFinish();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // dc.hw3
        public void h(long j) {
            super.h(j);
            try {
                f fVar = this.f;
                if (fVar != null) {
                    fVar.b(j);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: NetworkNewUtils.java */
    public class e implements bc4 {
        public final /* synthetic */ f a;

        public e(tn2 tn2Var, f fVar) {
            this.a = fVar;
        }

        @Override // dc.bc4
        public void onFailure(ac4 ac4Var, IOException iOException) {
            iOException.printStackTrace();
            try {
                f fVar = this.a;
                if (fVar != null) {
                    fVar.onRequestComplete(null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // dc.bc4
        public void onResponse(ac4 ac4Var, ad4 ad4Var) throws IOException {
            try {
                f fVar = this.a;
                if (fVar != null) {
                    fVar.onRequestComplete(ad4Var.b().string());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: NetworkNewUtils.java */
    public interface f {
        void a(long j, float f, float f2);

        void b(long j);

        void onFinish();

        void onRequestComplete(String str);
    }

    public tn2(Context context) {
    }

    public static zc4 c(String str) {
        return zc4.create(tc4.d("text/plain"), str);
    }

    public static String v(String str, Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (stringBuffer.toString().isEmpty()) {
                stringBuffer.append("?");
            } else {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append(entry.getKey());
            stringBuffer.append("=");
            stringBuffer.append(entry.getValue());
        }
        return str + stringBuffer.toString();
    }

    public static String w(String str) {
        String str2 = WearUtils.e;
        if (str.contains("/activity/api/twitter/orgyActivitys") || str.contains("/activity/api/orgy/joinOrgy") || str.contains("/activity/api/orgy/joinStatusUpd") || str.contains("/activity/api/orgy/orgyActivitys") || str.contains("/activity/coll/marketingApp/event") || str.contains("/activity/api/market/scanStarCampaignQrCode") || str.contains("/activity/discord/activityStatus") || str.contains("/activity/discord/joinActivity") || str.contains("/activity/discord/leaveActivity")) {
            str2 = WearUtils.i;
        }
        if (str.contains("/wear/android/crashFile") || str.contains("/statisticsLog") || str.contains("/wear/logsNewV3") || str.contains("/app/exception/log") || str.contains("/wear/log/featuresConfig")) {
            str2 = WearUtils.h;
        }
        if (str.contains("/date-web-api/api/remote/getNtoken") || str.contains("/date-web-api/api/remote/overEngagement") || str.contains("/date-web-api/appTranslation/getVersion") || str.contains("/date-web-api/appTranslation/getLang") || str.contains("/date-web-api/appTranslationV3/remote/getVersion") || str.contains("/date-web-api/appTranslationV3/remote/getLang")) {
            str2 = WearUtils.f;
        }
        if (str.contains("/surfease-web-api/api/qrcode/getQrData") || str.contains("/date-web-api/api/server/timestamp")) {
            str2 = WearUtils.g;
        }
        if (str.contains("/nh-order/wishList/loginLink") || str.contains("/nh-order/web/login")) {
            str2 = WearUtils.k;
        }
        return (str.contains("/surfease/anon/common/reported/v3/share/download") || str.contains("/surfease/anon/video/static/list") || str.contains("/surfease/anon/video/static/user/like") || str.contains("/surfease/anon/pattern/static/listV2") || str.contains("/surfease/anon/pattern/static/userlike/listV2") || str.contains("/surfease/anon/pattern/static/user/like") || str.contains("/surfease/anon/check_device_install_app")) ? WearUtils.j : str2;
    }

    public static tn2 x(Context context) {
        if (f == null) {
            synchronized (tn2.class) {
                if (f == null) {
                    f = new tn2(context);
                }
            }
        }
        return f;
    }

    public static vc4 y() {
        if (e == null) {
            synchronized (tn2.class) {
                yb4 yb4Var = null;
                try {
                    yb4Var = new yb4(new File(WearUtils.x.getExternalCacheDir(), "FussenHttpCache"), 10485760L);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                PersistentCookieJar persistentCookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(WearUtils.x));
                if (e == null) {
                    un2 un2VarA = un2.a();
                    vc4.b bVar = new vc4.b();
                    bVar.c(yb4Var);
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    bVar.d(30L, timeUnit);
                    bVar.k(30L, timeUnit);
                    bVar.n(30L, timeUnit);
                    bVar.e(persistentCookieJar);
                    bVar.g(rn2.f);
                    bVar.a(un2VarA);
                    e = bVar.b();
                }
            }
        }
        return e;
    }

    public <T> Subscription A(String str, File file, Map<String, String> map, zn2<String> zn2Var) {
        uc4.b bVarC = uc4.b.c("file", file.getName(), zc4.create(tc4.d("multipart/form-data"), file));
        HashMap map2 = new HashMap();
        if (map != null) {
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                if (str3 != null) {
                    map2.put(str2, c(str3));
                }
            }
        }
        return this.a.i(str, map2, bVarC).compose(this.c).subscribe((Subscriber<? super R>) new mo2(str, zn2Var));
    }

    public void B(String str, List<Pattern> list, zn2<String> zn2Var) {
        if (list == null || list.size() == 0) {
            zn2Var.onError(new NetException(NetException.A013, "本地错误，tempPatterns参数为空"));
            return;
        }
        uc4.a aVar = new uc4.a();
        aVar.f(uc4.g);
        String str2 = "";
        String str3 = "";
        for (Pattern pattern : list) {
            if (pattern.getFile().exists()) {
                str2 = str2 + pattern.getId() + ",";
                aVar.b("files", pattern.getFile().getName(), zc4.create(tc4.d("file/*"), pattern.getFile()));
            } else {
                str3 = str3 + pattern.getId() + ",";
            }
        }
        String strSubstring = str2.substring(0, str2.length() - 1);
        if (!TextUtils.isEmpty(str3)) {
            String strSubstring2 = str3.substring(0, str3.length() - 1);
            zn2Var.onError(new NetException(NetException.A013, "本地错误，部分pattern文件不存在 id是：" + strSubstring2));
            return;
        }
        xe3.a(xe2.r, "文件ids：" + strSubstring);
        aVar.a("ids", strSubstring);
        this.a.e(str, aVar.e()).compose(this.d).subscribe((Subscriber<? super R>) new mo2(str, zn2Var));
    }

    public ac4 C(String str, File file, f fVar) {
        String str2;
        uc4 uc4VarE;
        yc4.a aVar = new yc4.a();
        if (str.startsWith("http")) {
            str2 = str;
        } else {
            str2 = WearUtils.e + str;
        }
        aVar.k(str2);
        aVar.a("connection", "keep-alive");
        if (str.contains("/wear/feedback/offline/add")) {
            uc4.a aVar2 = new uc4.a();
            aVar2.f(uc4.f);
            aVar2.b("file", file.getName(), zc4.create(tc4.d("multipart/form-data; charset=UTF-8"), file));
            aVar2.a("pwd", nd3.w("remote_app_off_line"));
            uc4VarE = aVar2.e();
        } else {
            uc4.a aVar3 = new uc4.a();
            aVar3.f(uc4.g);
            aVar3.b("file", file.getName(), zc4.create(tc4.d("multipart/form-data; charset=UTF-8"), file));
            uc4VarE = aVar3.e();
        }
        aVar.h(dw3.a(uc4VarE, new d(this, fVar)));
        ac4 ac4VarA = y().a(aVar.b());
        ac4VarA.j(new e(this, fVar));
        return ac4VarA;
    }

    public <T> Subscription D(String str, File file, String str2, Map<String, String> map, zn2<String> zn2Var) {
        uc4.b bVarC = uc4.b.c("file", str2, zc4.create(tc4.d("multipart/form-data"), file));
        HashMap map2 = new HashMap();
        if (map != null) {
            for (String str3 : map.keySet()) {
                map2.put(str3, c(map.get(str3)));
            }
        }
        return this.a.i(str, map2, bVarC).compose(this.b).subscribe((Subscriber<? super R>) new mo2(str, zn2Var));
    }

    public ac4 E(String str, File file, String str2, so2.b bVar) {
        zc4 zc4VarCreate = zc4.create(tc4.d(str2), file);
        uc4.a aVar = new uc4.a();
        aVar.f(uc4.g);
        aVar.b("file", file.getName(), zc4VarCreate);
        so2 so2Var = new so2(aVar.e(), bVar);
        yc4.a aVar2 = new yc4.a();
        aVar2.k(WearUtils.e + str);
        aVar2.h(so2Var);
        return y().a(aVar2.b());
    }

    public final List<Type> a(Type[] typeArr) {
        String str = "========types size: =======" + typeArr.length;
        ArrayList arrayList = new ArrayList();
        for (Type type : typeArr) {
            System.out.println("  " + type);
            if (type instanceof ParameterizedType) {
                for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                    String str2 = "===========childtype:=======" + type2;
                    arrayList.add(type2);
                    if (type2 instanceof ParameterizedType) {
                        for (Type type3 : ((ParameterizedType) type2).getActualTypeArguments()) {
                            arrayList.add(type3);
                            String str3 = "=========type:=======" + type2;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final <T> Subscription b(String str, Map<String, Object> map, vn2 vn2Var, Observable.Transformer transformer) {
        HashMap map2 = new HashMap();
        for (String str2 : map.keySet()) {
            map2.put(str2, String.valueOf(map.get(str2)));
        }
        return this.a.d(str.trim(), map2).compose(transformer).subscribe((Subscriber<? super R>) vn2Var);
    }

    public <T> Subscription d(String str, yn2<T> yn2Var) {
        Type[] genericInterfaces = yn2Var.getClass().getGenericInterfaces();
        if (a(genericInterfaces) == null || a(genericInterfaces).size() == 0) {
            return null;
        }
        return this.a.f(str).compose(this.b).subscribe((Subscriber<? super R>) new po2(str, a(genericInterfaces).get(0), yn2Var));
    }

    public <T> Subscription e(String str, yn2<T> yn2Var) {
        Type[] genericInterfaces = yn2Var.getClass().getGenericInterfaces();
        if (a(genericInterfaces) == null || a(genericInterfaces).size() == 0) {
            return null;
        }
        return this.a.f(str).compose(this.c).subscribe((Subscriber<? super R>) new po2(str, a(genericInterfaces).get(0), yn2Var));
    }

    public Subscription f(String str, zn2<String> zn2Var) {
        Type[] genericInterfaces;
        try {
            genericInterfaces = zn2Var.getClass().getGenericInterfaces();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (a(genericInterfaces) == null) {
            return null;
        }
        if (a(genericInterfaces).size() == 0) {
            return null;
        }
        return this.a.f(str).compose(this.c).subscribe((Subscriber<? super R>) new mo2(str, zn2Var));
    }

    public <T> Subscription g(String str, Map<String, Object> map, yn2<T> yn2Var) {
        String strV = v(str, map);
        Type[] genericInterfaces = yn2Var.getClass().getGenericInterfaces();
        if (a(genericInterfaces) == null || a(genericInterfaces).size() == 0) {
            return null;
        }
        return this.a.f(strV).compose(this.c).subscribe((Subscriber<? super R>) new po2(strV, a(genericInterfaces).get(0), yn2Var));
    }

    public <T> Subscription h(String str, String str2, yn2<T> yn2Var) {
        zc4 zc4VarCreate = zc4.create(tc4.d("application/json; charset=utf-8"), str2);
        Type[] genericInterfaces = yn2Var.getClass().getGenericInterfaces();
        if (a(genericInterfaces) == null || a(genericInterfaces).size() == 0) {
            return null;
        }
        return this.a.c(str, zc4VarCreate).compose(this.b).subscribe((Subscriber<? super R>) new lo2(str, a(genericInterfaces).get(0), yn2Var));
    }

    public <T> Subscription i(String str, Map<String, Object> map, yn2<T> yn2Var) {
        Type[] genericInterfaces = yn2Var.getClass().getGenericInterfaces();
        if (a(genericInterfaces) == null || a(genericInterfaces).size() == 0) {
            return null;
        }
        return b(str, map, new lo2(str, a(genericInterfaces).get(0), yn2Var), this.b);
    }

    public <T> Subscription j(String str, Map<String, Object> map, yn2<T> yn2Var) {
        Type[] genericInterfaces = yn2Var.getClass().getGenericInterfaces();
        if (a(genericInterfaces) == null || a(genericInterfaces).size() == 0) {
            return null;
        }
        return b(str, map, new lo2(str, a(genericInterfaces).get(0), yn2Var), this.c);
    }

    public <T> Subscription k(String str, Map<String, Object> map, zn2<T> zn2Var) {
        Type[] genericInterfaces = zn2Var.getClass().getGenericInterfaces();
        if (a(genericInterfaces) == null || a(genericInterfaces).size() == 0) {
            return null;
        }
        return b(str, map, new ko2(str, a(genericInterfaces).get(0), zn2Var), this.b);
    }

    public Subscription l(String str, Map<String, Object> map, zn2<String> zn2Var) {
        if (zn2Var != null) {
            try {
                Type[] genericInterfaces = zn2Var.getClass().getGenericInterfaces();
                if (a(genericInterfaces) == null) {
                    return null;
                }
                if (a(genericInterfaces).size() == 0) {
                    return null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return b(str, map, new mo2(str, zn2Var), this.c);
    }

    public Subscription m(String str, String str2, zn2<String> zn2Var) {
        return this.a.c(str, zc4.create(tc4.d("application/json; charset=utf-8"), str2)).compose(this.c).subscribe((Subscriber<? super R>) new mo2(str, zn2Var));
    }

    public Subscription n(String str, String str2, xn2<byte[]> xn2Var) {
        return this.a.c(str, zc4.create(tc4.d("application/json; charset=utf-8"), str2)).compose(this.c).subscribe((Subscriber<? super R>) new no2(str, xn2Var));
    }

    public <T> Subscription o(String str, Map<String, Object> map, yn2<T> yn2Var) {
        Type[] genericInterfaces = yn2Var.getClass().getGenericInterfaces();
        if (a(genericInterfaces) == null || a(genericInterfaces).size() == 0) {
            return null;
        }
        return b(str, map, new oo2(str, a(genericInterfaces).get(0), yn2Var), this.b);
    }

    public <T> Subscription p(String str, Map<String, Object> map, yn2<T> yn2Var) {
        return i(str, map, yn2Var);
    }

    public <T> Subscription q(String str, Map<String, Object> map, zn2<String> zn2Var) {
        if (zn2Var != null) {
            try {
                Type[] genericInterfaces = zn2Var.getClass().getGenericInterfaces();
                if (a(genericInterfaces) == null) {
                    return null;
                }
                if (a(genericInterfaces).size() == 0) {
                    return null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return b(str, map, new mo2(str, zn2Var), this.d);
    }

    public <T> Subscription r(String str, Map<String, Object> map, String[] strArr, yn2<T> yn2Var) {
        Type[] genericInterfaces = yn2Var.getClass().getGenericInterfaces();
        if (a(genericInterfaces) != null && a(genericInterfaces).size() != 0) {
            try {
                return z(str, map, strArr, new lo2(str, a(genericInterfaces).get(0), yn2Var), this.b);
            } catch (RuntimeException e2) {
                if (e2.getMessage().equals("2MB")) {
                    yn2Var.onError(new NetException(NetException.UPLOAD_FILE_TOO_LARGE, WearUtils.F2()));
                }
            }
        }
        return null;
    }

    public Subscription s(String str, String str2, zn2<String> zn2Var) {
        try {
            String strEncode = URLEncoder.encode(nd3.v(str2), "UTF-8");
            if (WearUtils.e1(strEncode)) {
                strEncode = "";
            }
            return this.a.h(str, zc4.create(tc4.d("text/plain; charset=UTF-8"), oe3.a(strEncode))).compose(this.c).subscribe((Subscriber<? super R>) new mo2(str, zn2Var));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public Subscription t(String str, Map<String, Object> map, zn2<String> zn2Var) {
        Type[] genericInterfaces = zn2Var.getClass().getGenericInterfaces();
        if (a(genericInterfaces) == null || a(genericInterfaces).size() == 0) {
            return null;
        }
        return b(str, map, new qo2(str, a(genericInterfaces).get(0), zn2Var), this.b);
    }

    public Subscription u(String str, String str2, zn2<String> zn2Var) {
        return this.a.c(str, zc4.create(tc4.d("application/json; charset=utf-8"), str2)).compose(this.d).subscribe((Subscriber<? super R>) new mo2(str, zn2Var));
    }

    public final <T> Subscription z(String str, Map<String, Object> map, String[] strArr, vn2 vn2Var, Observable.Transformer transformer) {
        uc4.a aVar = new uc4.a();
        aVar.f(uc4.g);
        for (String str2 : map.keySet()) {
            Object obj = map.get(str2);
            Objects.requireNonNull(obj);
            aVar.a(str2, obj.toString());
        }
        for (String str3 : strArr) {
            File file = new File(str3);
            if (file.length() >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) {
                throw new RuntimeException("2MB");
            }
            aVar.b("files", file.getName(), zc4.create(tc4.d("image/*"), file));
        }
        return this.a.g(str, aVar.e()).compose(transformer).subscribe((Subscriber<? super R>) vn2Var);
    }
}
