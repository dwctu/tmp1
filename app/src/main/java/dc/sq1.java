package dc;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.wear.bean.Toy;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToysHelper.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fH\u0007¨\u0006\r"}, d2 = {"Lcom/wear/component/dxtoy/command/control/ToysHelper;", "", "()V", "getFunctionDescription", "Lkotlin/Pair;", "", "", "toy", "Lcom/wear/bean/Toy;", "getToyNames", "()[Ljava/lang/String;", "getToys", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class sq1 {

    @NotNull
    public static final sq1 a = new sq1();

    @JvmStatic
    @NotNull
    public static final String[] b() {
        ArrayList<Toy> arrayListP = pc1.a.P();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayListP, 10));
        Iterator<T> it = arrayListP.iterator();
        while (it.hasNext()) {
            arrayList.add(((Toy) it.next()).getShowName());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @JvmStatic
    @NotNull
    public static final Map<String, String> c() {
        ArrayList<Toy> arrayListP = pc1.a.P();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayListP, 10)), 16));
        for (Toy toy : arrayListP) {
            Pair<String[], String[]> pairA = a.a(toy);
            String[] strArrComponent1 = pairA.component1();
            String[] strArrComponent2 = pairA.component2();
            String deviceId = toy.getDeviceId();
            Pair[] pairArr = new Pair[8];
            pairArr[0] = TuplesKt.to(TtmlNode.ATTR_ID, toy.getDeviceId());
            String realType = toy.getRealType();
            Intrinsics.checkNotNullExpressionValue(realType, "toy.realType");
            String lowerCase = realType.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            pairArr[1] = TuplesKt.to("name", lowerCase);
            pc1 pc1Var = pc1.a;
            String address = toy.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "toy.address");
            pairArr[2] = TuplesKt.to("status", pc1Var.a(address) ? "1" : "0");
            pairArr[3] = TuplesKt.to("battery", Integer.valueOf(toy.getBattery()));
            pairArr[4] = TuplesKt.to("nickName", WearUtils.e1(toy.getDefineRename()) ? "" : toy.getDefineRename());
            pairArr[5] = TuplesKt.to("version", toy.getGenerationVersion());
            pairArr[6] = TuplesKt.to("shortFunctionNames", strArrComponent1);
            pairArr[7] = TuplesKt.to("fullFunctionNames", strArrComponent2);
            Pair pair = TuplesKt.to(deviceId, MapsKt__MapsKt.mapOf(pairArr));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        String strX = ye3.x();
        Intrinsics.checkNotNullExpressionValue(strX, "getSessionId()");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("toys", WearUtils.A.toJson(linkedHashMap)), TuplesKt.to("gameAppId", StringsKt__StringsJVMKt.replace$default(strX, Constants.FILENAME_SEQUENCE_SEPARATOR, "", false, 4, (Object) null)), TuplesKt.to("appType", "remote"), TuplesKt.to("platform", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE));
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.Pair<java.lang.String[], java.lang.String[]> a(com.wear.bean.Toy r9) {
        /*
            r8 = this;
            r0 = 0
            java.lang.String[] r1 = new java.lang.String[r0]
            java.lang.String[] r2 = new java.lang.String[r0]
            java.lang.String r3 = r9.getName()
            java.lang.String r4 = r9.getShowName()
            r5 = 1
            if (r3 == 0) goto L19
            int r6 = r3.length()
            if (r6 != 0) goto L17
            goto L19
        L17:
            r6 = 0
            goto L1a
        L19:
            r6 = 1
        L1a:
            if (r6 != 0) goto L99
            if (r4 == 0) goto L27
            int r6 = r4.length()
            if (r6 != 0) goto L25
            goto L27
        L25:
            r6 = 0
            goto L28
        L27:
            r6 = 1
        L28:
            if (r6 != 0) goto L99
            java.lang.String r6 = "unknow"
            boolean r7 = kotlin.text.StringsKt__StringsJVMKt.equals(r3, r6, r5)
            if (r7 != 0) goto L99
            java.lang.String r7 = "unknown"
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.equals(r3, r7, r5)
            if (r3 != 0) goto L99
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.equals(r4, r6, r5)
            if (r3 != 0) goto L99
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.equals(r4, r7, r5)
            if (r3 == 0) goto L47
            goto L99
        L47:
            com.wear.bean.ToyConfigInfoBean r3 = r9.getToyConfigDataBean()
            if (r3 == 0) goto La5
            java.util.List r3 = r3.getFunctionDescription()
            if (r3 == 0) goto La5
            java.lang.String r4 = "functionDescription"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            int r9 = r9.typeInt()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.util.Iterator r3 = r3.iterator()
        L64:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto La5
            java.lang.Object r4 = r3.next()
            com.wear.bean.ToyConfigInfoBean$FunctionDescription r4 = (com.wear.bean.ToyConfigInfoBean.FunctionDescription) r4
            java.lang.String r5 = r4.getV()
            boolean r5 = android.text.TextUtils.equals(r5, r9)
            if (r5 == 0) goto L64
            java.lang.String[] r9 = r4.getShortNames()
            if (r9 != 0) goto L83
            java.lang.String[] r9 = new java.lang.String[r0]
            goto L88
        L83:
            java.lang.String r1 = "functionDescriptionIndex.shortNames ?: arrayOf()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r1)
        L88:
            r1 = r9
            java.lang.String[] r9 = r4.getFullNames()
            if (r9 != 0) goto L92
            java.lang.String[] r9 = new java.lang.String[r0]
            goto L97
        L92:
            java.lang.String r0 = "functionDescriptionIndex.fullNames ?: arrayOf()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
        L97:
            r2 = r9
            goto La5
        L99:
            java.lang.String r9 = "v"
            java.lang.String[] r1 = new java.lang.String[]{r9}
            java.lang.String r9 = "Vibrate"
            java.lang.String[] r2 = new java.lang.String[]{r9}
        La5:
            kotlin.Pair r9 = new kotlin.Pair
            r9.<init>(r1, r2)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.sq1.a(com.wear.bean.Toy):kotlin.Pair");
    }
}
