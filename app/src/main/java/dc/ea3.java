package dc;

import androidx.exifinterface.media.ExifInterface;
import com.wear.bean.ConnectionGroupBean;
import com.wear.bean.ConnectionLetterBean;
import com.wear.bean.ConnectionUserBean;
import com.wear.bean.Group;
import com.wear.bean.User;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.official.OfficialAcount;
import com.wear.ui.longDistance.officialaccount.OfficialaCountModel;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.packet.Presence;

/* compiled from: ConnectionsRepository.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bJ\f\u0010\u0011\u001a\u00020\f*\u00020\u0012H\u0002R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/wear/ui/longDistance/repository/ConnectionsRepository;", "", "()V", "officialAccount", "Lcom/wear/bean/official/OfficialAcount;", "getOfficialAccount", "()Lcom/wear/bean/official/OfficialAcount;", "officialAccount$delegate", "Lkotlin/Lazy;", "requestUser", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/wear/bean/ConnectionUserBean;", "getRequestUser", "()Lkotlinx/coroutines/flow/Flow;", "getAllFriendList", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "convertConnectionUserBean", "Lcom/wear/bean/handlerbean/IPeopleInfo;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class ea3 {

    @NotNull
    public final Lazy a = LazyKt__LazyJVMKt.lazy(d.a);

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

    /* compiled from: ConnectionsRepository.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/wear/bean/handlerbean/IPeopleInfo;", "kotlin.jvm.PlatformType", "invoke", "(Lcom/wear/bean/handlerbean/IPeopleInfo;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function1<IPeopleInfo, Boolean> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(IPeopleInfo iPeopleInfo) {
            String showNickName = iPeopleInfo.getShowNickName();
            return Boolean.valueOf(!(showNickName == null || showNickName.length() == 0));
        }
    }

    /* compiled from: ConnectionsRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u00012\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "", "", "Lcom/wear/bean/handlerbean/IPeopleInfo;", "kotlin.jvm.PlatformType", "user", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function1<IPeopleInfo, Triple<? extends Character, ? extends Object, ? extends IPeopleInfo>> {
        public static final c a = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Triple<Character, Object, IPeopleInfo> invoke(IPeopleInfo iPeopleInfo) {
            String strA = uf3.a(iPeopleInfo.getShowNickName());
            Intrinsics.checkNotNullExpressionValue(strA, "getPingYin(user.showName)");
            char upperCase = Character.toUpperCase(StringsKt___StringsKt.first(strA));
            return new Triple<>(Character.valueOf('A' <= upperCase && upperCase < '[' ? upperCase : '['), 'A' <= upperCase && upperCase < '[' ? Character.valueOf(upperCase) : "#", iPeopleInfo);
        }
    }

    /* compiled from: ConnectionsRepository.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/bean/official/OfficialAcount;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<OfficialAcount> {
        public static final d a = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final OfficialAcount invoke() {
            return OfficialaCountModel.g.a().p();
        }
    }

    /* compiled from: SafeCollector.common.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class e implements t34<List<ConnectionUserBean>> {
        public final /* synthetic */ t34 a;
        public final /* synthetic */ ea3 b;

        /* compiled from: Emitters.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class a<T> implements u34, SuspendFunction {
            public final /* synthetic */ u34 a;
            public final /* synthetic */ ea3 b;

            /* compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            @DebugMetadata(c = "com.wear.ui.longDistance.repository.ConnectionsRepository$special$$inlined$map$1$2", f = "ConnectionsRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
            /* renamed from: dc.ea3$e$a$a, reason: collision with other inner class name */
            public static final class C0176a extends ContinuationImpl {
                public Object L$0;
                public int label;
                public /* synthetic */ Object result;

                public C0176a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(u34 u34Var, ea3 ea3Var) {
                this.a = u34Var;
                this.b = ea3Var;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // dc.u34
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(java.lang.Object r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof dc.ea3.e.a.C0176a
                    if (r0 == 0) goto L13
                    r0 = r9
                    dc.ea3$e$a$a r0 = (dc.ea3.e.a.C0176a) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    dc.ea3$e$a$a r0 = new dc.ea3$e$a$a
                    r0.<init>(r9)
                L18:
                    java.lang.Object r9 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L6f
                L29:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L31:
                    kotlin.ResultKt.throwOnFailure(r9)
                    dc.u34 r9 = r7.a
                    java.util.List r8 = (java.util.List) r8
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r4 = 10
                    int r4 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r8, r4)
                    r2.<init>(r4)
                    java.util.Iterator r8 = r8.iterator()
                L47:
                    boolean r4 = r8.hasNext()
                    if (r4 == 0) goto L62
                    java.lang.Object r4 = r8.next()
                    com.wear.bean.User r4 = (com.wear.bean.User) r4
                    dc.ea3 r5 = r7.b
                    java.lang.String r6 = "it"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
                    com.wear.bean.ConnectionUserBean r4 = dc.ea3.a(r5, r4)
                    r2.add(r4)
                    goto L47
                L62:
                    java.util.List r8 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(r2)
                    r0.label = r3
                    java.lang.Object r8 = r9.emit(r8, r0)
                    if (r8 != r1) goto L6f
                    return r1
                L6f:
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: dc.ea3.e.a.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public e(t34 t34Var, ea3 ea3Var) {
            this.a = t34Var;
            this.b = ea3Var;
        }

        @Override // dc.t34
        @Nullable
        public Object collect(@NotNull u34<? super List<ConnectionUserBean>> u34Var, @NotNull Continuation continuation) {
            Object objCollect = this.a.collect(new a(u34Var, this.b), continuation);
            return objCollect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
        }
    }

    public final ConnectionUserBean b(IPeopleInfo iPeopleInfo) {
        String id = iPeopleInfo.getId();
        String showNickName = iPeopleInfo.getShowNickName();
        String avatar = iPeopleInfo.getAvatar();
        String moodMessage = iPeopleInfo.getMoodMessage();
        int i = 0;
        if (!(iPeopleInfo instanceof OfficialAcount)) {
            if (iPeopleInfo.isOnline()) {
                i = 1;
            } else if (iPeopleInfo.getStatusMode() == Presence.Mode.dnd) {
                i = 2;
            }
        }
        return new ConnectionUserBean(id, showNickName, avatar, moodMessage, i);
    }

    @NotNull
    public final List<tq> c() {
        tq tqVarB;
        List<IPeopleInfo> list = ch3.i;
        if (!list.contains(d())) {
            list.add(OfficialaCountModel.g.a().p());
        }
        Intrinsics.checkNotNullExpressionValue(list, "users.apply {\n        if…aCount())\n        }\n    }");
        Sequence sequenceSortedWith = SequencesKt___SequencesKt.sortedWith(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(list), b.a), c.a), new a());
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
                IPeopleInfo user = (IPeopleInfo) ((Triple) it.next()).getThird();
                if (user.isGroup()) {
                    String id = user.getId();
                    String showNickName = user.getShowNickName();
                    Group group = user instanceof Group ? (Group) user : null;
                    tqVarB = new ConnectionGroupBean(id, showNickName, group != null ? group.getUrl() : null);
                } else {
                    Intrinsics.checkNotNullExpressionValue(user, "user");
                    tqVarB = b(user);
                }
                arrayList3.add(tqVarB);
            }
            listMutableListOf.addAll(arrayList3);
            CollectionsKt__MutableCollectionsKt.addAll(arrayList2, listMutableListOf);
        }
        return CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
    }

    public final OfficialAcount d() {
        return (OfficialAcount) this.a.getValue();
    }

    @NotNull
    public final t34<List<ConnectionUserBean>> e() {
        List<User> requestUsers = ch3.j;
        Intrinsics.checkNotNullExpressionValue(requestUsers, "requestUsers");
        ArrayList arrayList = new ArrayList();
        for (Object obj : requestUsers) {
            User user = (User) obj;
            String showNickName = user.getShowNickName();
            boolean z = false;
            if (!(showNickName == null || showNickName.length() == 0) && !MyApplication.N().i.q(WearUtils.i0(user.getId()))) {
                z = true;
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        return new e(v34.l(arrayList), this);
    }
}
