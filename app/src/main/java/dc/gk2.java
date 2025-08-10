package dc;

import com.broadcom.bt.util.io.IOUtils;
import com.component.dxtoy.business.longc.aapattern.bean.AAPatternItemBean;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.lovense.wear.R;
import com.wear.bean.Pattern;
import com.wear.bean.Toy;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SolaceProPatternUtil.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u001a\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002J\u0018\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0015J\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001aJ\u000e\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0015J0\u0010 \u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0004J \u0010$\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\nJ\u0010\u0010&\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001aJ\u001e\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0004J\u001e\u0010)\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u0004J&\u0010*\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010+\u001a\u00020\u0013R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/wear/main/toy/solacepro/SolaceProPatternUtil;", "", "()V", "interceptNoticeSolacePlayType", "", "getInterceptNoticeSolacePlayType", "()Z", "setInterceptNoticeSolacePlayType", "(Z)V", "mIndex", "", "mPause", "mSpeed", "patternItems", "", "Lcom/component/dxtoy/business/longc/aapattern/bean/AAPatternItemBean;", "patternPlayIndex", "patternSpeedItems", "clear", "", "compatibleSolaceProFunction", "", "symbol", "patternFunc", "getFunc", "mPattern", "Lcom/wear/bean/Pattern;", "data", "getPatternTag", "pattern", "getToyTag", "str", "initProcessor", "speed", FirebaseAnalytics.Param.INDEX, "isLocalPattern", "noticeSolacePlayType", "playType", "patternIsPos", "pauseOrStart", "pause", "setPlayIndex", "setVelvoDataBySpeed", "stop", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class gk2 {

    @NotNull
    public static final b g = new b(null);

    @NotNull
    public static final Lazy<gk2> h = LazyKt__LazyJVMKt.lazy(a.a);

    @Nullable
    public List<AAPatternItemBean> a = new ArrayList();

    @Nullable
    public List<Integer> b = new ArrayList();
    public int c = 100;
    public int d;
    public boolean e;
    public boolean f;

    /* compiled from: SolaceProPatternUtil.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/main/toy/solacepro/SolaceProPatternUtil;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<gk2> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final gk2 invoke() {
            return new gk2();
        }
    }

    /* compiled from: SolaceProPatternUtil.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/wear/main/toy/solacepro/SolaceProPatternUtil$Companion;", "", "()V", DefaultSettingsSpiCall.INSTANCE_PARAM, "Lcom/wear/main/toy/solacepro/SolaceProPatternUtil;", "getInstance$annotations", "getInstance", "()Lcom/wear/main/toy/solacepro/SolaceProPatternUtil;", "instance$delegate", "Lkotlin/Lazy;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final gk2 a() {
            return (gk2) gk2.h.getValue();
        }
    }

    @NotNull
    public static final gk2 e() {
        return g.a();
    }

    public final void b() {
        List<AAPatternItemBean> list = this.a;
        if (list != null) {
            list.clear();
        }
        List<Integer> list2 = this.b;
        if (list2 != null) {
            list2.clear();
        }
    }

    public final String c(String str, String str2) {
        return (uu1.b(str) && Intrinsics.areEqual(str2, PSOProgramService.VS_Key)) ? "t" : str2;
    }

    @NotNull
    public final String d(@Nullable Pattern pattern, @NotNull String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        String toyFunc = "";
        if (pattern == null) {
            if (data.length() == 0) {
                return "";
            }
            pattern = new Pattern();
            pattern.setData(StringsKt__StringsKt.contains$default((CharSequence) data, (CharSequence) IOUtils.LINE_SEPARATOR_UNIX, false, 2, (Object) null) ? (String) StringsKt__StringsKt.split$default((CharSequence) data, new String[]{";#\n"}, false, 0, 6, (Object) null).get(1) : (String) StringsKt__StringsKt.split$default((CharSequence) data, new String[]{";#"}, false, 0, 6, (Object) null).get(1));
            pattern.setToyTag(g((String) StringsKt__StringsKt.split$default((CharSequence) data, new String[]{";#"}, false, 0, 6, (Object) null).get(0)));
        }
        if (!WearUtils.e1(pattern.getToyTag())) {
            toyFunc = pattern.getToyTag();
            Intrinsics.checkNotNullExpressionValue(toyFunc, "it.toyTag");
        } else if (!WearUtils.e1(pattern.getToyFunc())) {
            toyFunc = pattern.getToyFunc();
            Intrinsics.checkNotNullExpressionValue(toyFunc, "it.toyFunc");
        }
        return c(pattern.getToySymbol(), toyFunc);
    }

    @NotNull
    public final String f(@NotNull Pattern pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        String toyTag = !WearUtils.e1(pattern.getToyTag()) ? pattern.getToyTag() : !WearUtils.e1(pattern.getToyFunc()) ? pattern.getToyFunc() : null;
        return toyTag == null ? "" : toyTag;
    }

    @NotNull
    public final String g(@NotNull String str) {
        MatchGroupCollection groups;
        MatchGroup matchGroup;
        Intrinsics.checkNotNullParameter(str, "str");
        String value = null;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("F:(.*?);"), str, 0, 2, null);
        if (matchResultFind$default != null && (groups = matchResultFind$default.getGroups()) != null && (matchGroup = groups.get(1)) != null) {
            value = matchGroup.getValue();
        }
        return value == null ? "" : value;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void h(@org.jetbrains.annotations.Nullable com.wear.bean.Pattern r15, @org.jetbrains.annotations.NotNull java.lang.String r16, int r17, int r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.gk2.h(com.wear.bean.Pattern, java.lang.String, int, int, boolean):void");
    }

    public final void i(@Nullable Pattern pattern, @NotNull String data, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.f || i == 1 || i == 2) {
            return;
        }
        Iterator<Toy> it = pc1.a.P().iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            Toy next = it.next();
            if (next.isBAToy()) {
                String strD = d(pattern, data);
                if (Intrinsics.areEqual(strD, "pos")) {
                    if (fk2.a.c(next != null ? next.getAddress() : null) == ek2.SPEED) {
                        sg3.l(MyApplication.N().getString(R.string.tip_controlling_position));
                        break;
                    }
                } else {
                    if (!StringsKt__StringsKt.contains$default((CharSequence) strD, (CharSequence) "t", false, 2, (Object) null)) {
                        if (!(pattern != null && pattern.isSystemPattern()) || !Intrinsics.areEqual(strD, PSOProgramService.VS_Key)) {
                        }
                    }
                    if (fk2.a.c(next != null ? next.getAddress() : null) == ek2.POSITION) {
                        sg3.l(MyApplication.N().getString(R.string.tip_controlling_thrusting));
                        break;
                    }
                }
            }
        }
        if (pattern != null && pattern.isSystemPattern()) {
            z = true;
        }
        if (z) {
            this.f = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001a A[PHI: r0
  0x001a: PHI (r0v3 java.lang.String) = (r0v1 java.lang.String), (r0v4 java.lang.String) binds: [B:20:0x0030, B:10:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean j(@org.jetbrains.annotations.Nullable com.wear.bean.Pattern r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L8
            java.lang.String r1 = r4.getToyTag()
            goto L9
        L8:
            r1 = r0
        L9:
            boolean r1 = com.wear.util.WearUtils.e1(r1)
            java.lang.String r2 = ""
            if (r1 != 0) goto L1c
            if (r4 == 0) goto L17
            java.lang.String r0 = r4.getToyTag()
        L17:
            if (r0 != 0) goto L1a
            goto L32
        L1a:
            r2 = r0
            goto L32
        L1c:
            if (r4 == 0) goto L23
            java.lang.String r1 = r4.getToyFunc()
            goto L24
        L23:
            r1 = r0
        L24:
            boolean r1 = com.wear.util.WearUtils.e1(r1)
            if (r1 != 0) goto L32
            if (r4 == 0) goto L30
            java.lang.String r0 = r4.getToyFunc()
        L30:
            if (r0 != 0) goto L1a
        L32:
            java.lang.String r4 = "pos"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.gk2.j(com.wear.bean.Pattern):boolean");
    }

    public final void k(boolean z, int i, boolean z2) {
        this.d = i;
        if (z) {
            o();
        } else {
            n(this.c, i, z2, this.e);
        }
    }

    public final void l(boolean z) {
        this.f = z;
    }

    public final void m(int i, int i2, boolean z) {
        n(i, i2, true, z);
    }

    public final void n(int i, int i2, boolean z, boolean z2) {
        List<Integer> list;
        List<Integer> list2;
        if (z2) {
            return;
        }
        this.c = i;
        this.d = i2;
        this.b = new ArrayList();
        List<AAPatternItemBean> list3 = this.a;
        if (list3 != null) {
            int i3 = i2 + 1;
            int size = list3.size();
            while (true) {
                int i4 = 0;
                if (i3 >= size) {
                    break;
                }
                int value = list3.get(i3).getValue();
                if (i != 25) {
                    if (i != 50) {
                        if (i == 200) {
                            while (i4 < 2) {
                                List<Integer> list4 = this.b;
                                if (list4 != null) {
                                    list4.add(Integer.valueOf(value));
                                }
                                i4++;
                            }
                        } else if (i != 400) {
                            List<Integer> list5 = this.b;
                            if (list5 != null) {
                                list5.add(Integer.valueOf(value));
                            }
                        } else {
                            while (i4 < 4) {
                                List<Integer> list6 = this.b;
                                if (list6 != null) {
                                    list6.add(Integer.valueOf(value));
                                }
                                i4++;
                            }
                        }
                    } else if (i3 % 2 == 0 && (list2 = this.b) != null) {
                        list2.add(Integer.valueOf(value));
                    }
                } else if (i3 % 4 == 0 && (list = this.b) != null) {
                    list.add(Integer.valueOf(value));
                }
                i3++;
            }
            ArrayList<Toy> arrayListP = MyApplication.N().G().P();
            if (arrayListP.isEmpty()) {
                return;
            }
            for (Toy toy : arrayListP) {
                ek2 ek2VarC = fk2.a.c(toy.getAddress());
                if (toy.isBAToy() && (z || ek2VarC == ek2.POSITION)) {
                    ck2 ck2VarA = ck2.b.a();
                    List<Integer> listEmptyList = this.b;
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt__CollectionsKt.emptyList();
                    }
                    ck2VarA.c(toy, listEmptyList, false);
                }
            }
        }
    }

    public final void o() {
        Iterator<Toy> it = pc1.a.P().iterator();
        while (it.hasNext()) {
            Toy next = it.next();
            if (next.isBAToy()) {
                ck2 ck2VarA = ck2.b.a();
                String address = next.getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "toy.address");
                ck2VarA.e(address);
            }
        }
    }
}
