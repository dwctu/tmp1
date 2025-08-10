package dc;

import com.component.dxfunctionkits.featureconfig.bean.FeatureConfigReqBean;
import com.component.dxfunctionkits.featureconfig.bean.FeatureConfigResBean;
import com.component.dxhttp.NetException;
import com.component.dxhttp.bean.BaseResponse;
import com.google.gson.reflect.TypeToken;
import com.sun.jna.Callback;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: DXFeatureConfigApi.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0018\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000bH\u0007J\u001a\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\u0018\u0010&\u001a\u00020%2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020%H\u0007J$\u0010'\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\rj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b`\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R7\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\rj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b`\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/component/dxfunctionkits/featureconfig/DXFeatureConfigApi;", "", "()V", "CACHE_FILE_NAME", "", "CACHE_KEY_CONFIG_DATA", "CACHE_KEY_CONFIG_VERSION", "FEATURE_CONFIG_URL", "SERVER_URL", "TEST_SERVER_URL", "TIME_OUT_MILLIS", "", "configCache", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getConfigCache", "()Ljava/util/HashMap;", "configCache$delegate", "Lkotlin/Lazy;", "isRequestRetry", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mmkvUtil", "Lcom/component/dxutilcode/lib/utils/BaseMmkvUtil;", "getMmkvUtil", "()Lcom/component/dxutilcode/lib/utils/BaseMmkvUtil;", "mmkvUtil$delegate", "getConfigDataFromServer", "", "requestUrl", "devId", Callback.METHOD_NAME, "Lcom/component/dxfunctionkits/featureconfig/listener/FeatureConfigCallback;", "getValue", "feature", "defaultValue", "init", "isDebug", "", "isEnable", "loadDataFromCache", "featureConfig_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class sx {

    @NotNull
    public static final sx a = new sx();

    @NotNull
    public static final AtomicBoolean b = new AtomicBoolean(false);

    @NotNull
    public static final Lazy c = LazyKt__LazyJVMKt.lazy(e.a);

    @NotNull
    public static final Lazy d = LazyKt__LazyJVMKt.lazy(a.a);

    /* compiled from: DXFeatureConfigApi.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function0<HashMap<String, Integer>> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final HashMap<String, Integer> invoke() {
            return sx.a.m();
        }
    }

    /* compiled from: DXFeatureConfigApi.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/component/dxfunctionkits/featureconfig/DXFeatureConfigApi$getConfigDataFromServer$1", "Lcom/component/dxhttp/callback/ResponseCallback;", "Lcom/component/dxhttp/bean/BaseResponse;", "Lcom/component/dxfunctionkits/featureconfig/bean/FeatureConfigResBean;", "onError", "", "e", "Lcom/component/dxhttp/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "featureConfig_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends ny<BaseResponse<FeatureConfigResBean>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ tx b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public b(int i, tx txVar, String str, String str2) {
            this.a = i;
            this.b = txVar;
            this.c = str;
            this.d = str2;
        }

        @Override // dc.ny
        public void b(@Nullable NetException netException) {
            if (sx.b.compareAndSet(false, true)) {
                sx.a.h(this.c, this.d, this.b);
                return;
            }
            sx.b.set(false);
            tx txVar = this.b;
            if (txVar != null) {
                txVar.a(sx.a.g());
            }
        }

        @Override // dc.ny
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void d(@Nullable BaseResponse<FeatureConfigResBean> baseResponse) {
            FeatureConfigResBean data;
            FeatureConfigResBean data2;
            Integer dataVer;
            sx.b.set(false);
            int iIntValue = (baseResponse == null || (data2 = baseResponse.getData()) == null || (dataVer = data2.getDataVer()) == null) ? 0 : dataVer.intValue();
            HashMap<String, Integer> data3 = (baseResponse == null || (data = baseResponse.getData()) == null) ? null : data.getData();
            if (iIntValue > this.a) {
                sx sxVar = sx.a;
                sxVar.i().f("config_ver", iIntValue);
                if (data3 == null || data3.isEmpty()) {
                    sxVar.i().h("config_data");
                } else {
                    jd0 jd0VarI = sxVar.i();
                    String string = data3.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "configData.toString()");
                    jd0VarI.g("config_data", string);
                }
            }
            if (data3 == null || data3.isEmpty()) {
                tx txVar = this.b;
                if (txVar != null) {
                    txVar.a(sx.a.g());
                    return;
                }
                return;
            }
            tx txVar2 = this.b;
            if (txVar2 != null) {
                txVar2.a(data3);
            }
        }
    }

    /* compiled from: DXFeatureConfigApi.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/component/dxfunctionkits/featureconfig/DXFeatureConfigApi$init$1", "Lcom/component/dxhyttoutils/lib/listener/DeviceIdCallback;", "done", "", "devId", "", "featureConfig_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c implements lz {
        public final /* synthetic */ String a;
        public final /* synthetic */ tx b;

        public c(String str, tx txVar) {
            this.a = str;
            this.b = txVar;
        }

        @Override // dc.lz
        public void a(@NotNull String devId) {
            Intrinsics.checkNotNullParameter(devId, "devId");
            if (devId.length() > 0) {
                sx.a.h(this.a, devId, this.b);
            }
        }
    }

    /* compiled from: DXFeatureConfigApi.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00050\u0001¨\u0006\u0006"}, d2 = {"com/component/dxfunctionkits/featureconfig/DXFeatureConfigApi$loadDataFromCache$1$type$1", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "featureConfig_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d extends TypeToken<HashMap<String, Integer>> {
    }

    /* compiled from: DXFeatureConfigApi.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxutilcode/lib/utils/BaseMmkvUtil;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class e extends Lambda implements Function0<jd0> {
        public static final e a = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final jd0 invoke() {
            return new jd0("dx_feature_config", 0, 2, null);
        }
    }

    static {
        if (!r0.g().isEmpty()) {
            se0.g(new Runnable() { // from class: dc.rx
                @Override // java.lang.Runnable
                public final void run() {
                    sx.a();
                }
            }, 30000L);
        }
    }

    public static final void a() {
        try {
            gz.a.b().a("S0019", MapsKt__MapsKt.hashMapOf(TuplesKt.to("key", "feature_config"), TuplesKt.to("value", a.g())));
        } catch (Throwable th) {
            th.printStackTrace();
            de0.l(th.getMessage());
        }
    }

    @JvmStatic
    public static final void j(boolean z, @Nullable tx txVar) throws Exception {
        String str;
        if (z && gd0.i()) {
            str = "https://test10.lovense.com/api/features/getSwitch";
        } else {
            str = "https://apps2.lovense-api.com/api/features/getSwitch";
        }
        gz.a.a();
        a.g();
        tz.a.d(new c(str, txVar));
    }

    @JvmStatic
    public static final boolean k(@NotNull String feature, boolean z) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        Integer num = a.g().get(feature);
        return num != null ? num.intValue() == 1 : z;
    }

    public final HashMap<String, Integer> g() {
        return (HashMap) d.getValue();
    }

    public final void h(String str, String str2, tx txVar) {
        gz gzVar = gz.a;
        String tag = gzVar.c().b().getTag();
        String strA = gzVar.c().a();
        int iC = i().c("config_ver", 0);
        FeatureConfigReqBean featureConfigReqBean = new FeatureConfigReqBean(tag, strA, str2, iC);
        HashMap map = new HashMap();
        map.put("connect_timeout", "5000");
        map.put("read_timeout", "5000");
        map.put("write_timeout", "5000");
        ky.e(str, featureConfigReqBean, map, new b(iC, txVar, str, str2));
    }

    public final jd0 i() {
        return (jd0) c.getValue();
    }

    public final HashMap<String, Integer> m() {
        String strE = i().e("config_data", null);
        if (strE == null) {
            return new HashMap<>();
        }
        de0.v("DXFeatureConfig", "cache data = " + strE);
        HashMap<String, Integer> map = (HashMap) xd0.e(strE, new d().getType());
        if (map == null) {
            return new HashMap<>();
        }
        Intrinsics.checkNotNullExpressionValue(map, "GsonUtils.fromJson<HashM…(json, type) ?: HashMap()");
        return map;
    }
}
