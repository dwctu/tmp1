package dc;

import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.http.server.AsyncHttpServerResponse;
import com.wear.bean.Toy;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: LanApiOfPatternV2.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J>\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001`\rJ<\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001`\rJ\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004H\u0002J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0015H\u0002J\u001a\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0002J \u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0005H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/wear/main/server/LanApiOfPatternV2;", "", "()V", "toyCmdList", "", "", "dealWithPatternV2", SaslStreamElements.Response.ELEMENT, "Lcom/koushikdutta/async/http/server/AsyncHttpServerResponse;", "jsonCallback", "", "fromJson", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dealWithPosition", "fillData", "", "cmdData", "Lcom/wear/main/server/PatternItem;", "filterData", "data", "", "jsonToList", "json", "playOrStopPatternV2", "toy", "Lcom/wear/bean/Toy;", "playType", "startIndex", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class gf2 {

    @NotNull
    public static final b b = new b(null);

    @NotNull
    public static final Lazy<gf2> c = LazyKt__LazyJVMKt.lazy(a.a);

    @NotNull
    public final List<Integer> a = new ArrayList();

    /* compiled from: LanApiOfPatternV2.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/main/server/LanApiOfPatternV2;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<gf2> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final gf2 invoke() {
            return new gf2();
        }
    }

    /* compiled from: LanApiOfPatternV2.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/wear/main/server/LanApiOfPatternV2$Companion;", "", "()V", DefaultSettingsSpiCall.INSTANCE_PARAM, "Lcom/wear/main/server/LanApiOfPatternV2;", "getInstance$annotations", "getInstance", "()Lcom/wear/main/server/LanApiOfPatternV2;", "instance$delegate", "Lkotlin/Lazy;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final gf2 a() {
            return (gf2) gf2.c.getValue();
        }
    }

    /* compiled from: LanApiOfPatternV2.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/wear/main/server/LanApiOfPatternV2$jsonToList$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/wear/main/server/PatternItem;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c extends TypeToken<List<? extends PatternItem>> {
    }

    @NotNull
    public static final gf2 f() {
        return b.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x0149 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0166  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int b(@org.jetbrains.annotations.Nullable com.koushikdutta.async.http.server.AsyncHttpServerResponse r25, @org.jetbrains.annotations.Nullable java.lang.String r26, @org.jetbrains.annotations.NotNull java.util.HashMap<java.lang.String, java.lang.Object> r27) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.gf2.b(com.koushikdutta.async.http.server.AsyncHttpServerResponse, java.lang.String, java.util.HashMap):int");
    }

    public final int c(@NotNull AsyncHttpServerResponse response, @Nullable String str, @NotNull HashMap<String, Object> fromJson) {
        int iB;
        String string;
        String string2;
        String string3;
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(fromJson, "fromJson");
        Object obj = fromJson.get("toy");
        Integer intOrNull = null;
        String string4 = (obj == null || (string3 = obj.toString()) == null) ? null : StringsKt__StringsKt.trim((CharSequence) string3).toString();
        Object obj2 = fromJson.get("value");
        if (obj2 != null && (string = obj2.toString()) != null && (string2 = StringsKt__StringsKt.trim((CharSequence) string).toString()) != null) {
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(string2);
        }
        if (intOrNull == null || intOrNull.intValue() < 0 || intOrNull.intValue() > 100) {
            return 404;
        }
        if (!(string4 == null || string4.length() == 0) && (iB = ff2.n().b(string4)) != 200) {
            return iB;
        }
        ff2.n().x(response, true, null, 200, "", str);
        xe3.a("newCommand", "Position 校验完成 返回 200 , posValue = " + intOrNull);
        if (string4 == null || string4.length() == 0) {
            Iterator<T> it = WearUtils.x.G().P().iterator();
            while (it.hasNext()) {
                dk2.a.d((Toy) it.next(), intOrNull.intValue(), true);
            }
        } else {
            Toy toyR = WearUtils.x.G().R(string4);
            if (toyR != null) {
                dk2.a.d(toyR, intOrNull.intValue(), true);
            }
        }
        return 200;
    }

    public final void d(List<PatternItem> list) {
        int ts;
        int i;
        this.a.clear();
        ArrayList arrayList = new ArrayList();
        PatternItem patternItem = (PatternItem) CollectionsKt___CollectionsKt.getOrNull(list, 0);
        if (patternItem != null && patternItem.getTs() != 0) {
            list.add(0, new PatternItem(0, 0));
        }
        Iterator<T> it = list.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            PatternItem patternItem2 = (PatternItem) next;
            if (i2 < list.size() - 1 && (ts = (list.get(i3).getTs() / 100) - (patternItem2.getTs() / 100)) > 0 && 1 <= ts) {
                while (true) {
                    arrayList.add(new PatternItem(((patternItem2.getTs() / 100) * 100) + (i * 100), patternItem2.getPos()));
                    this.a.add(Integer.valueOf(patternItem2.getPos()));
                    i = i != ts ? i + 1 : 1;
                }
            }
            i2 = i3;
        }
        PatternItem patternItem3 = (PatternItem) CollectionsKt___CollectionsKt.lastOrNull((List) list);
        if (patternItem3 != null) {
            arrayList.add(new PatternItem(((patternItem3.getTs() / 100) + 1) * 100, patternItem3.getPos()));
            this.a.add(Integer.valueOf(patternItem3.getPos()));
        }
        de0.v("zbf", "setupPatternData size = " + arrayList.size() + " result = " + arrayList + ' ');
        StringBuilder sb = new StringBuilder();
        sb.append(" size = ");
        sb.append(this.a.size());
        sb.append(" value result = ");
        sb.append(this.a);
        de0.v("zbf", sb.toString());
    }

    public final List<PatternItem> e(List<PatternItem> list) {
        ArrayList<PatternItem> arrayList = new ArrayList();
        for (Object obj : list) {
            int pos = ((PatternItem) obj).getPos();
            boolean z = false;
            if (pos >= 0 && pos < 101) {
                z = true;
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int ts = Integer.MIN_VALUE;
        for (PatternItem patternItem : arrayList) {
            if (patternItem.getTs() > ts) {
                arrayList2.add(patternItem);
                ts = patternItem.getTs();
            }
        }
        return arrayList2;
    }

    public final List<PatternItem> g(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            return (List) xd0.e(str, new c().getType());
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void h(Toy toy, String str, int i) {
        if (toy.isBAToy()) {
            if (!Intrinsics.areEqual("Play", str)) {
                if (Intrinsics.areEqual("Stop", str)) {
                    ff2.n().D(null, toy.getAddress(), false);
                }
            } else {
                ff2.n().D(null, toy.getAddress(), false);
                List<Integer> list = this.a;
                ck2.b.a().c(toy, list.subList(i, list.size()), true);
            }
        }
    }
}
