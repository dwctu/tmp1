package dc;

import androidx.exifinterface.media.ExifInterface;
import com.wear.bean.ConnectionBlockBean;
import com.wear.bean.ConnectionLetterBean;
import com.wear.bean.User;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: ConnectionsBlockRepository.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0002J\f\u0010\u000b\u001a\u00020\f*\u00020\bH\u0002¨\u0006\r"}, d2 = {"Lcom/wear/ui/longDistance/repository/ConnectionsBlockRepository;", "", "()V", "getAllBlockList", "", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "getBlockList", "", "Lcom/wear/bean/User;", "getFriendsJid", "", "convertConnectionBlockBean", "Lcom/wear/bean/ConnectionBlockBean;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class da3 {

    /* compiled from: Comparisons.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n*L\n1#1,328:1\n*E\n"})
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt__ComparisonsKt.compareValues((Character) ((Triple) t).getFirst(), (Character) ((Triple) t2).getFirst());
        }
    }

    /* compiled from: ConnectionsBlockRepository.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/wear/bean/User;", "invoke", "(Lcom/wear/bean/User;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function1<User, Boolean> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(@NotNull User it) {
            Intrinsics.checkNotNullParameter(it, "it");
            String showNickName = it.getShowNickName();
            return Boolean.valueOf(!(showNickName == null || showNickName.length() == 0));
        }
    }

    /* compiled from: ConnectionsBlockRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "", "", "Lcom/wear/bean/User;", "user", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function1<User, Triple<? extends Character, ? extends Object, ? extends User>> {
        public static final c a = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Triple<Character, Object, User> invoke(@NotNull User user) {
            Intrinsics.checkNotNullParameter(user, "user");
            String strA = uf3.a(user.getShowNickName());
            Intrinsics.checkNotNullExpressionValue(strA, "getPingYin(user.showName)");
            char upperCase = Character.toUpperCase(StringsKt___StringsKt.first(strA));
            return new Triple<>(Character.valueOf('A' <= upperCase && upperCase < '[' ? upperCase : '['), 'A' <= upperCase && upperCase < '[' ? Character.valueOf(upperCase) : "#", user);
        }
    }

    public final ConnectionBlockBean a(User user) {
        String strJ0 = WearUtils.j0(user.getId());
        return new ConnectionBlockBean(strJ0, user.getUserName(), user.getRemark(), user.getAvatar(), d().contains(strJ0));
    }

    @NotNull
    public final List<tq> b() {
        Sequence sequenceSortedWith = SequencesKt___SequencesKt.sortedWith(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(c()), b.a), c.a), new a());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : sequenceSortedWith) {
            Object second = ((Triple) obj).getSecond();
            Object arrayList = linkedHashMap.get(second);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(second, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            List listMutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new ConnectionLetterBean(entry.getKey().toString()));
            Iterable iterable = (Iterable) entry.getValue();
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList3.add(a((User) ((Triple) it.next()).getThird()));
            }
            listMutableListOf.addAll(arrayList3);
            CollectionsKt__MutableCollectionsKt.addAll(arrayList2, listMutableListOf);
        }
        return CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
    }

    public final List<User> c() {
        n82 n82Var = MyApplication.N().i;
        ArrayList arrayList = new ArrayList();
        if (n82Var != null) {
            arrayList.addAll(d());
            List<String> listF = n82Var.f(1);
            if (listF == null) {
                listF = CollectionsKt__CollectionsKt.emptyList();
            } else {
                Intrinsics.checkNotNullExpressionValue(listF, "it.getJids(1) ?: emptyList()");
            }
            arrayList.addAll(listF);
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(ch3.n().v(WearUtils.g0((String) it.next())));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            User user = (User) obj;
            boolean z = false;
            if (user != null) {
                String showNickName = user.getShowNickName();
                if (!(showNickName == null || showNickName.length() == 0)) {
                    z = true;
                }
            }
            if (z) {
                arrayList3.add(obj);
            }
        }
        return arrayList3;
    }

    public final List<String> d() {
        List<String> listF = MyApplication.N().i.f(0);
        return listF == null ? CollectionsKt__CollectionsKt.emptyList() : listF;
    }
}
