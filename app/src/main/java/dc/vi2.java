package dc;

import com.wear.bean.Toy;
import com.wear.bean.data.QureyToyCollectRequest;
import com.wear.bean.data.ToyCollectData;
import com.wear.bean.data.ToyCollectResponse;
import com.wear.bean.data.ToyReportData;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: ToyCollectInstance.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019J\u0018\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\u0015J \u0010\u001c\u001a\u00020\u000f2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH\u0002R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/wear/main/toy/ToyCollectInstance;", "", "()V", "map", "Ljava/util/HashMap;", "", "Lcom/wear/bean/data/ToyCollectData;", "Lkotlin/collections/HashMap;", "startTime", "", "toyCollectArr", "Ljava/util/ArrayList;", "Lcom/wear/bean/data/ToyReportData;", "Lkotlin/collections/ArrayList;", "addToyReportData", "", MultipleAddresses.Address.ELEMENT, "byteArr", "", "", "isNeedReportCollect", "", "", "queryToyCollect", "toy", "Lcom/wear/bean/Toy;", "sendToyCollectCommand", "isCollect", "submit", "arr", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class vi2 {
    public static long b;

    @NotNull
    public static final vi2 a = new vi2();

    @NotNull
    public static final ArrayList<ToyReportData> c = new ArrayList<>();

    @NotNull
    public static final HashMap<String, ToyCollectData> d = new HashMap<>();

    /* compiled from: ToyCollectInstance.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/wear/main/toy/ToyCollectInstance$queryToyCollect$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements zn2<String> {
        public final /* synthetic */ Toy a;

        public a(Toy toy) {
            this.a = toy;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable String str) {
            ToyCollectData data;
            if (str != null) {
                Toy toy = this.a;
                ToyCollectResponse collectResponse = (ToyCollectResponse) ro2.a(str, ToyCollectResponse.class);
                if (collectResponse != null) {
                    Intrinsics.checkNotNullExpressionValue(collectResponse, "collectResponse");
                    if (!Intrinsics.areEqual(collectResponse.getResult(), Boolean.TRUE) || (data = collectResponse.getData()) == null) {
                        return;
                    }
                    vi2 vi2Var = vi2.a;
                    String address = toy.getAddress();
                    Boolean needReport = data.getNeedReport();
                    vi2Var.e(address, needReport != null ? needReport.booleanValue() : false);
                    HashMap map = vi2.d;
                    String address2 = toy.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address2, "toy.address");
                    map.put(address2, data);
                }
            }
        }

        @Override // dc.zn2
        public void onError(@Nullable NetException e) {
        }
    }

    /* compiled from: ToyCollectInstance.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/wear/main/toy/ToyCollectInstance$submit$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements zn2<String> {
        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable String str) {
        }

        @Override // dc.zn2
        public void onError(@Nullable NetException e) {
        }
    }

    public final void b(@NotNull String address, @Nullable List<Integer> list) {
        Toy toyO;
        String strC;
        Intrinsics.checkNotNullParameter(address, "address");
        if (address.length() == 0) {
            return;
        }
        if ((list != null && list.isEmpty()) || (toyO = pc1.a.O(address)) == null || (strC = ro2.c(list)) == null) {
            return;
        }
        String deviceType = toyO.getDeviceType();
        Intrinsics.checkNotNullExpressionValue(deviceType, "toy.deviceType");
        ToyReportData toyReportData = new ToyReportData(StringsKt__StringsJVMKt.replace$default(deviceType, ";", "", false, 4, (Object) null), System.currentTimeMillis(), strC);
        ArrayList<ToyReportData> arrayList = c;
        arrayList.add(toyReportData);
        ToyCollectData toyCollectData = d.get(address);
        if (b == 0) {
            b = System.currentTimeMillis();
        }
        if (toyCollectData != null) {
            int size = arrayList.size();
            Integer nCount = toyCollectData.getNCount();
            if (nCount == null || size != nCount.intValue()) {
                if (System.currentTimeMillis() - b <= (toyCollectData.getXSecondTime() != null ? r10.intValue() * 1000 : 0)) {
                    return;
                }
            }
            ArrayList<ToyReportData> arrayList2 = new ArrayList<>();
            arrayList2.addAll(arrayList);
            a.f(arrayList2);
            arrayList.clear();
            b = 0L;
        }
    }

    public final boolean c(@Nullable byte[] bArr) {
        if (bArr != null) {
            return !(bArr.length == 0) && bArr[0] == -59;
        }
        return false;
    }

    public final void d(@NotNull Toy toy) {
        Intrinsics.checkNotNullParameter(toy, "toy");
        String deviceType = toy.getDeviceType();
        Intrinsics.checkNotNullExpressionValue(deviceType, "toy.deviceType");
        tn2.x(WearUtils.x).m("/toy_use_data_collect/query_need_collect", ro2.c(new QureyToyCollectRequest(StringsKt__StringsJVMKt.replace$default(deviceType, ";", "", false, 4, (Object) null))), new a(toy));
    }

    public final void e(@Nullable String str, boolean z) {
        if (str == null) {
            return;
        }
        gr1.a.a(str, z);
    }

    public final void f(ArrayList<ToyReportData> arrayList) {
        tn2.x(WearUtils.x).m("/toy_use_data_collect/report", ro2.c(arrayList), new b());
    }
}
