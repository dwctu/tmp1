package dc;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.sun.jna.Callback;
import com.wear.bean.Toy;
import com.wear.bean.ToyFeedbackBean;
import com.wear.bean.event.ToyCtrlGameEvent;
import com.wear.bean.event.ToyGserEvent;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: ToyEventApiUtil.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00040\bJ$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\n2\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00040\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\u001c\u0010\u0013\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00040\bJ&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00040\bJ\"\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u00192\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¨\u0006\u001b"}, d2 = {"Lcom/wear/main/server/ToyEventApiUtil;", "", "()V", "getFeedbackBean", "", "event", "Lcom/wear/bean/event/ToyCtrlGameEvent;", Callback.METHOD_NAME, "Lkotlin/Function1;", "Lcom/wear/bean/ToyFeedbackBean;", "Lcom/wear/bean/event/ToyGserEvent;", "getIntArr", "", "levelInflation", "", "value", "levelToPercent", FirebaseAnalytics.Param.LEVEL, "maxLevel", "sendToyList", "sendToyStatus", "Lcom/wear/bean/Toy;", MultipleAddresses.Address.ELEMENT, "", "speedDirectionPos", "Lkotlin/Triple;", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class lf2 {
    public static final int b = 100;

    @NotNull
    public static final String c = "toy-status";

    @NotNull
    public static final String d = "button-up";

    @NotNull
    public static final String e = "button-down";

    @NotNull
    public static final String f = "button-pressed";

    @NotNull
    public static final String g = "function-strength-changed";

    @NotNull
    public static final String h = "shake-frequency-changed";

    @NotNull
    public static final String i = "shake";

    @NotNull
    public static final String j = "depth-changed";

    @NotNull
    public static final String k = "battery-changed";

    @NotNull
    public static final String l = "vibration";

    @NotNull
    public static final String m = "rotitaion";

    @NotNull
    public static final String n = "inflation";

    @NotNull
    public static final String o = "toy-list";

    @NotNull
    public static final b a = new b(null);

    @NotNull
    public static final Lazy<lf2> p = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) a.a);

    /* compiled from: ToyEventApiUtil.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/main/server/ToyEventApiUtil;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<lf2> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final lf2 invoke() {
            return new lf2(null);
        }
    }

    /* compiled from: ToyEventApiUtil.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/wear/main/server/ToyEventApiUtil$Companion;", "", "()V", "DATA_INFLATION", "", "DATA_ROTITAION", "DATA_THRUSTING", "DATA_VIBRATION", "MODEL_FEEDBACK_GSER", "MODEL_FEEDBACK_OFF", "MODEL_FEEDBACK_ON", "MODEL_FEEDBACK_START_WITH", "MODEL_FEEDBACK_Y_ALL", "", "TAG", "TYPE_BATTERY_CHANGED", "TYPE_BUTTON_DOWN", "TYPE_BUTTON_PRESSED", "TYPE_BUTTON_UP", "TYPE_DEPTH_CHANGED", "TYPE_FUNCTION_STRENGTH_CHANGED", "TYPE_SHAKE", "TYPE_SHAKE_FREQUENCY_CHANGED", "TYPE_TOY_LIST", "TYPE_TOY_STATUS", DefaultSettingsSpiCall.INSTANCE_PARAM, "Lcom/wear/main/server/ToyEventApiUtil;", "getInstance", "()Lcom/wear/main/server/ToyEventApiUtil;", "instance$delegate", "Lkotlin/Lazy;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final lf2 a() {
            return (lf2) lf2.p.getValue();
        }
    }

    public lf2() {
    }

    public /* synthetic */ lf2(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x01ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(@org.jetbrains.annotations.NotNull com.wear.bean.event.ToyCtrlGameEvent r10, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.wear.bean.ToyFeedbackBean, kotlin.Unit> r11) {
        /*
            Method dump skipped, instructions count: 502
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.lf2.b(com.wear.bean.event.ToyCtrlGameEvent, kotlin.jvm.functions.Function1):void");
    }

    public final void c(@NotNull ToyGserEvent event, @NotNull Function1<? super ToyFeedbackBean, Unit> callback) {
        Toy toyO;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(callback, "callback");
        int[] iArrE = e(event);
        if (iArrE == null || iArrE.length != 2 || (toyO = pc1.a.O(event.getAddress())) == null || !toyO.isFeedbackModeEnable()) {
            return;
        }
        ToyFeedbackBean toyFeedbackBean = new ToyFeedbackBean();
        toyFeedbackBean.feedback = WearUtils.B ? event.getValue() : null;
        toyFeedbackBean.type = h;
        toyFeedbackBean.toyId = toyO.getDeviceId();
        ToyFeedbackBean.DataDTO dataDTO = new ToyFeedbackBean.DataDTO();
        toyFeedbackBean.data = dataDTO;
        dataDTO.value = Integer.valueOf(g(iArrE[0], 4));
        callback.invoke(toyFeedbackBean);
        if (iArrE[1] == 1) {
            ToyFeedbackBean toyFeedbackBean2 = new ToyFeedbackBean();
            toyFeedbackBean2.feedback = WearUtils.B ? event.getValue() : null;
            toyFeedbackBean2.type = i;
            toyFeedbackBean2.toyId = toyO.getDeviceId();
            callback.invoke(toyFeedbackBean2);
        }
    }

    public final int[] d(ToyCtrlGameEvent toyCtrlGameEvent) {
        List listEmptyList;
        String str = toyCtrlGameEvent.value;
        Intrinsics.checkNotNullExpressionValue(str, "event.value");
        String strSubstring = str.substring(0, toyCtrlGameEvent.value.length() - 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        List<String> listSplit = new Regex(SignatureImpl.INNER_SEP).split(strSubstring, 0);
        if (listSplit.isEmpty()) {
            listEmptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (!(listIterator.previous().length() == 0)) {
                    listEmptyList = CollectionsKt___CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                    break;
                }
            }
            listEmptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        if (strArr.length != 4) {
            return null;
        }
        try {
            return new int[]{Integer.parseInt(strArr[1]), Intrinsics.areEqual(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, strArr[2]) ? b : Integer.parseInt(strArr[2]), Integer.parseInt(strArr[3])};
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final int[] e(ToyGserEvent toyGserEvent) {
        List listEmptyList;
        if (toyGserEvent == null || TextUtils.isEmpty(toyGserEvent.getValue())) {
            return null;
        }
        List<String> listSplit = new Regex(SignatureImpl.INNER_SEP).split(StringsKt__StringsJVMKt.replace$default(toyGserEvent.getValue(), ";", "", false, 4, (Object) null), 0);
        if (listSplit.isEmpty()) {
            listEmptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (!(listIterator.previous().length() == 0)) {
                    listEmptyList = CollectionsKt___CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                    break;
                }
            }
            listEmptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        if (strArr.length != 3) {
            return null;
        }
        try {
            return new int[]{Integer.parseInt(strArr[1]), Integer.parseInt(strArr[2])};
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final int f(int i2) {
        if (1 <= i2 && i2 < 151) {
            return 1;
        }
        if (151 <= i2 && i2 < 211) {
            return 2;
        }
        return 211 <= i2 && i2 <= Integer.MAX_VALUE ? 3 : 0;
    }

    public final int g(int i2, int i3) {
        if (i2 == i3) {
            return 20;
        }
        return (int) ((i2 * 20.0d) / i3);
    }

    public final void h(@NotNull Function1<? super ToyFeedbackBean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ToyFeedbackBean toyFeedbackBean = new ToyFeedbackBean();
        toyFeedbackBean.type = o;
        toyFeedbackBean.toyList = new ArrayList();
        Iterator<Toy> it = pc1.a.P().iterator();
        while (it.hasNext()) {
            Toy next = it.next();
            if (next.isFeedbackModeEnable()) {
                ToyFeedbackBean.ToyListDTO toyListDTO = new ToyFeedbackBean.ToyListDTO();
                toyListDTO.id = next.getDeviceId();
                toyListDTO.name = next.getSimpleName();
                toyListDTO.type = next.getType();
                int iTypeInt = next.typeInt();
                String str = "";
                if (iTypeInt > 1) {
                    str = "" + iTypeInt;
                }
                toyListDTO.hVersion = str;
                toyListDTO.fVersion = Integer.valueOf(next.getToyVersion());
                toyListDTO.nickname = next.getDefineRename();
                toyListDTO.battery = Integer.valueOf(next.getBattery());
                toyListDTO.connected = Boolean.valueOf(next.isConnected());
                toyFeedbackBean.toyList.add(toyListDTO);
            }
        }
        callback.invoke(toyFeedbackBean);
    }

    @Nullable
    public final Toy i(@NotNull String address, @NotNull Function1<? super ToyFeedbackBean, Unit> callback) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Iterator<Toy> it = pc1.a.P().iterator();
        while (it.hasNext()) {
            Toy next = it.next();
            if (TextUtils.equals(address, next.getAddress()) && next.isFeedbackModeEnable()) {
                ToyFeedbackBean toyFeedbackBean = new ToyFeedbackBean();
                toyFeedbackBean.type = c;
                toyFeedbackBean.toyId = next.getDeviceId();
                ToyFeedbackBean.DataDTO dataDTO = new ToyFeedbackBean.DataDTO();
                toyFeedbackBean.data = dataDTO;
                dataDTO.connected = Boolean.valueOf(next.isConnected());
                callback.invoke(toyFeedbackBean);
                return next;
            }
        }
        return null;
    }

    public final Triple<Integer, Integer, Integer> j(int i2) {
        int i3 = (i2 >> 8) & 255;
        int i4 = i2 & 255;
        return new Triple<>(Integer.valueOf(i3), Integer.valueOf(i4 & 127), Integer.valueOf((i4 & 128) > 0 ? 1 : 0));
    }
}
