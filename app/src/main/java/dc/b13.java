package dc;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.wear.bean.Toy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: VoiceControlExt.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\u001a\n\u0010\u0012\u001a\u00020\u0001*\u00020\u0001\u001a\u001a\u0010\u0013\u001a\u00020\b*\u0012\u0012\u0004\u0012\u00020\u00140\u0003j\b\u0012\u0004\u0012\u00020\u0014`\u0004\u001a\u001a\u0010\u0015\u001a\u00020\b*\u0012\u0012\u0004\u0012\u00020\u00140\u0003j\b\u0012\u0004\u0012\u00020\u0014`\u0004\u001a\u001a\u0010\u0016\u001a\u00020\b*\u0012\u0012\u0004\u0012\u00020\u00140\u0003j\b\u0012\u0004\u0012\u00020\u0014`\u0004\u001a\n\u0010\u0017\u001a\u00020\b*\u00020\u0001\u001a\n\u0010\u0018\u001a\u00020\b*\u00020\u0001\u001a\n\u0010\u0019\u001a\u00020\u001a*\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003j\b\u0012\u0004\u0012\u00020\u0001`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\b*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t\"\u0016\u0010\n\u001a\u00020\b*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\t\"\u0016\u0010\u000b\u001a\u00020\b*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t\"\u0016\u0010\f\u001a\u00020\b*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\f\u0010\t\"\u0016\u0010\r\u001a\u00020\b*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\t\"\u0016\u0010\u000e\u001a\u00020\b*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\t\"\u0016\u0010\u000f\u001a\u00020\b*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\t\"\u0016\u0010\u0010\u001a\u00020\b*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\t\"\u0016\u0010\u0011\u001a\u00020\b*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\t¨\u0006\u001b"}, d2 = {"dialogMsg", "", "presetCommand", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPresetCommand", "()Ljava/util/ArrayList;", "isDefault", "", "(Ljava/lang/String;)Z", "isFaster", "isSlower", "isStartCommand", "isStopCommand", "isStraight", "isStronger", "isWave", "isWeaker", "commandFormat", "isDomi", "Lcom/wear/bean/Toy;", "isLush", "isMax", "isSpeed", "isStrength", "numberFormat", "", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class b13 {

    @NotNull
    public static final ArrayList<String> a = CollectionsKt__CollectionsKt.arrayListOf(TtmlNode.START, "stop", "faster", "slower", "stronger", "weaker", "default", "straight", "wave", "speed zero", "speed one", "speed two", "speed three", "speed four", "speed five", "strength zero", "strength one", "strength two", "strength three", "strength four", "strength five", "strength six", "strength seven", "strength eight", "strength nine", "strength ten", "strength eleven", "strength twelve", "strength thirteen", "strength fourteen", "strength fifteen", "strength sixteen", "strength seventeen", "strength eighteen", "strength nineteen", "strength twenty");

    @NotNull
    public static final String a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (ArraysKt___ArraysKt.contains(new String[]{"stat", "star", TtmlNode.START}, str)) {
            return "Start";
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"stop", "stall", "spawn", "spock"}, str)) {
            return "Stop";
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"faster", "fast her", "foster"}, str)) {
            return "Faster";
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"slower", "so lower", "lower", "slow", "lola"}, str)) {
            return "Slower";
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"he faught", "default", "the fart", "the it", "different", "the fought", "the default", "the fall", "if all"}, str)) {
            return "Default";
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"wave", "wait", "way", "wage"}, str)) {
            return "Wave";
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"straight", "strike", "stretch it", "jet", "stretch", "jade", "trade", "changing"}, str)) {
            return "Straight";
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"stronger"}, str)) {
            return "Stronger";
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"weaker", "waco", "week", "wake", "wake her", "we can", "we cat", "weekend"}, str)) {
            return "Weaker";
        }
        if (f(str)) {
            List listSplit$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null);
            if (listSplit$default.size() <= 1) {
                return "Speed";
            }
            return "Speed " + h((String) listSplit$default.get(1));
        }
        if (!g(str)) {
            return "";
        }
        List listSplit$default2 = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null);
        if (listSplit$default2.size() <= 1) {
            return "Strength";
        }
        return "Strength " + h((String) listSplit$default2.get(1));
    }

    @NotNull
    public static final ArrayList<String> b() {
        return a;
    }

    public static final boolean c(@NotNull ArrayList<Toy> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Iterator<T> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            String showName = ((Toy) it.next()).getShowName();
            if (showName != null) {
                int iHashCode = showName.hashCode();
                if (iHashCode != 77124) {
                    if (iHashCode != 2135943) {
                        if (iHashCode == 2380222 && showName.equals("Lush")) {
                            i--;
                        }
                    } else if (showName.equals("Domi")) {
                        i++;
                    }
                } else if (showName.equals("Max")) {
                    i--;
                }
            }
        }
        return i > 0;
    }

    public static final boolean d(@NotNull ArrayList<Toy> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Iterator<T> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            String showName = ((Toy) it.next()).getShowName();
            if (showName != null) {
                int iHashCode = showName.hashCode();
                if (iHashCode != 77124) {
                    if (iHashCode != 2135943) {
                        if (iHashCode == 2380222 && showName.equals("Lush")) {
                            i++;
                        }
                    } else if (showName.equals("Domi")) {
                        i--;
                    }
                } else if (showName.equals("Max")) {
                    i--;
                }
            }
        }
        return i > 0;
    }

    public static final boolean e(@NotNull ArrayList<Toy> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Iterator<T> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            String showName = ((Toy) it.next()).getShowName();
            if (showName != null) {
                int iHashCode = showName.hashCode();
                if (iHashCode != 77124) {
                    if (iHashCode != 2135943) {
                        if (iHashCode == 2380222 && showName.equals("Lush")) {
                            i--;
                        }
                    } else if (showName.equals("Domi")) {
                        i--;
                    }
                } else if (showName.equals("Max")) {
                    i++;
                }
            }
        }
        return i > 0;
    }

    public static final boolean f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String[] strArr = {"speed", "speak", "speaks", "spin", "spi", "spring", "space", "big", "speech", "spit", "beat", "sleep", "spinks", "speight"};
        List listSplit$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null);
        if (!listSplit$default.isEmpty()) {
            return ArraysKt___ArraysKt.contains(strArr, listSplit$default.get(0));
        }
        return false;
    }

    public static final boolean g(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String[] strArr = {"strength", "stress", "strengths", "strange", "strings", "change", "trains", "chains", "stream", "drink", "strand", "jean", "strands", "jan", "during", "jang", "james", "jamie", "streams", "jay"};
        List listSplit$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null);
        if (!listSplit$default.isEmpty()) {
            return ArraysKt___ArraysKt.contains(strArr, listSplit$default.get(0));
        }
        return false;
    }

    public static final int h(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (ArraysKt___ArraysKt.contains(new String[]{"zero", "hero"}, str)) {
            return 0;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"one", "lung", "wow", "on"}, str)) {
            return 1;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"two", "to", "too"}, str)) {
            return 2;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"three", "silly", "street", "sleep"}, str)) {
            return 3;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"four", TtmlNode.ANNOTATION_POSITION_BEFORE, "for", "fall", ""}, str)) {
            return 4;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"five", "fi", "fyi", "fly", "fry"}, str)) {
            return 5;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"six", "sakes", "sake", "say", "face", "safe", "sex", "saying"}, str)) {
            return 6;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"seven", "simon", NotificationCompat.GROUP_KEY_SILENT, "say what", "say when", "sam and", "say one", "say well"}, str)) {
            return 7;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"eight", "aid", "a", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "paid"}, str)) {
            return 8;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"nine", "ny", "i", "hi"}, str)) {
            return 9;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"ten", "pen", "hand", "time", "can"}, str)) {
            return 10;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"eleven"}, str)) {
            return 11;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"twelve", "towel", "tell", "talf", "town"}, str)) {
            return 12;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"thirteen"}, str)) {
            return 13;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"fourteen"}, str)) {
            return 14;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"fifteen"}, str)) {
            return 15;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"sixteen", "says team"}, str)) {
            return 16;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"seventeen"}, str)) {
            return 17;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"eighteen"}, str)) {
            return 18;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"nineteen"}, str)) {
            return 19;
        }
        return ArraysKt___ArraysKt.contains(new String[]{"twenty"}, str) ? 20 : 0;
    }
}
