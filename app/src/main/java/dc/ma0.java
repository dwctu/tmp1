package dc;

import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: ToyCommandCtrlConstant.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bs\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R\u001b\u0010\f\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\r\u0010\u0006R\u001b\u0010\u000f\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0010\u0010\u0006R\u001b\u0010\u0012\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\b\u001a\u0004\b\u0013\u0010\u0006R\u001b\u0010\u0015\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0016\u0010\u0006R\u001b\u0010\u0018\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\b\u001a\u0004\b\u0019\u0010\u0006R\u001b\u0010\u001b\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\b\u001a\u0004\b\u001c\u0010\u0006R\u001b\u0010\u001e\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\b\u001a\u0004\b\u001f\u0010\u0006R\u001b\u0010!\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\b\u001a\u0004\b\"\u0010\u0006R\u001b\u0010$\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\b\u001a\u0004\b%\u0010\u0006R\u001b\u0010'\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\b\u001a\u0004\b(\u0010\u0006R\u001b\u0010*\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\b\u001a\u0004\b+\u0010\u0006R\u001b\u0010-\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\b\u001a\u0004\b.\u0010\u0006R\u001b\u00100\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\b\u001a\u0004\b1\u0010\u0006R\u001b\u00103\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\b\u001a\u0004\b4\u0010\u0006R\u001b\u00106\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\b\u001a\u0004\b7\u0010\u0006R\u001b\u00109\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\b\u001a\u0004\b:\u0010\u0006R\u001b\u0010<\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\b\u001a\u0004\b=\u0010\u0006R\u001b\u0010?\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\b\u001a\u0004\b@\u0010\u0006R\u001b\u0010B\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\b\u001a\u0004\b3\u0010\u0006R\u001b\u0010D\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\b\u001a\u0004\bE\u0010\u0006R\u001b\u0010G\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\b\u001a\u0004\bH\u0010\u0006R\u001b\u0010J\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\b\u001a\u0004\bK\u0010\u0006R\u001b\u0010M\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\b\u001a\u0004\bN\u0010\u0006R\u001b\u0010P\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bR\u0010\b\u001a\u0004\bQ\u0010\u0006R\u001b\u0010S\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\b\u001a\u0004\bT\u0010\u0006R\u001b\u0010V\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bX\u0010\b\u001a\u0004\bW\u0010\u0006R\u001b\u0010Y\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\b\u001a\u0004\bZ\u0010\u0006R\u001b\u0010\\\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b^\u0010\b\u001a\u0004\b]\u0010\u0006R\u001b\u0010_\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\ba\u0010\b\u001a\u0004\b`\u0010\u0006R\u001b\u0010b\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bd\u0010\b\u001a\u0004\bc\u0010\u0006R\u001b\u0010e\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bg\u0010\b\u001a\u0004\bf\u0010\u0006R\u001b\u0010h\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bj\u0010\b\u001a\u0004\bi\u0010\u0006R\u001b\u0010k\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bm\u0010\b\u001a\u0004\bl\u0010\u0006R\u001b\u0010n\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bp\u0010\b\u001a\u0004\bo\u0010\u0006R\u001b\u0010q\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bs\u0010\b\u001a\u0004\br\u0010\u0006R\u001b\u0010t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bv\u0010\b\u001a\u0004\bu\u0010\u0006¨\u0006w"}, d2 = {"Lcom/component/dxtoy/core/commandcore/constant/ToyCommandCtrlConstant;", "", "()V", "FLVS", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "getFLVS", "()Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "FLVS$delegate", "Lkotlin/Lazy;", "LVS", "getLVS", "LVS$delegate", "aAirLevel", "getAAirLevel", "aAirLevel$delegate", "aRotate", "getARotate", "aRotate$delegate", "aVibAir", "getAVibAir", "aVibAir$delegate", "aVibRotate", "getAVibRotate", "aVibRotate$delegate", "airIn", "getAirIn", "airIn$delegate", "airLevel", "getAirLevel", "airLevel$delegate", "airLoop", "getAirLoop", "airLoop$delegate", "airNLoop", "getAirNLoop", "airNLoop$delegate", "airOut", "getAirOut", "airOut$delegate", "depth", "getDepth", "depth$delegate", "fSetSite", "getFSetSite", "fSetSite$delegate", "fingering", "getFingering", "fingering$delegate", "getCap", "getGetCap", "getCap$delegate", "getPat", "getGetPat", "getPat$delegate", "getSite", "getGetSite", "getSite$delegate", "getStroke", "getGetStroke", "getStroke$delegate", "mply", "getMply", "mply$delegate", "multiply", "getMultiply", "multiply$delegate", "pat", "pat$delegate", "rotate", "getRotate", "rotate$delegate", "rotateChange", "getRotateChange", "rotateChange$delegate", "rotateFalse", "getRotateFalse", "rotateFalse$delegate", "rotateTrue", "getRotateTrue", "rotateTrue$delegate", "setPat", "getSetPat", "setPat$delegate", "setStroke", "getSetStroke", "setStroke$delegate", "suck", "getSuck", "suck$delegate", "thrusting", "getThrusting", "thrusting$delegate", "vibAir", "getVibAir", "vibAir$delegate", "vibRotate", "getVibRotate", "vibRotate$delegate", "vibrate", "getVibrate", "vibrate$delegate", "vibrate1", "getVibrate1", "vibrate1$delegate", "vibrate2", "getVibrate2", "vibrate2$delegate", "vibrate3", "getVibrate3", "vibrate3$delegate", "vibrateXT", "getVibrateXT", "vibrateXT$delegate", "vibrateXT1", "getVibrateXT1", "vibrateXT1$delegate", "vibrateXT2", "getVibrateXT2", "vibrateXT2$delegate", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ma0 {

    @NotNull
    public static final ma0 a = new ma0();

    @NotNull
    public static final Lazy b = LazyKt__LazyJVMKt.lazy(f0.a);

    @NotNull
    public static final Lazy c = LazyKt__LazyJVMKt.lazy(g0.a);

    @NotNull
    public static final Lazy d = LazyKt__LazyJVMKt.lazy(h0.a);

    @NotNull
    public static final Lazy e = LazyKt__LazyJVMKt.lazy(i0.a);

    @NotNull
    public static final Lazy f = LazyKt__LazyJVMKt.lazy(j0.a);

    @NotNull
    public static final Lazy g = LazyKt__LazyJVMKt.lazy(k0.a);

    @NotNull
    public static final Lazy h = LazyKt__LazyJVMKt.lazy(l0.a);

    @NotNull
    public static final Lazy i = LazyKt__LazyJVMKt.lazy(v.a);

    @NotNull
    public static final Lazy j = LazyKt__LazyJVMKt.lazy(y.a);

    @NotNull
    public static final Lazy k = LazyKt__LazyJVMKt.lazy(x.a);

    @NotNull
    public static final Lazy l = LazyKt__LazyJVMKt.lazy(w.a);

    @NotNull
    public static final Lazy m = LazyKt__LazyJVMKt.lazy(e0.a);

    @NotNull
    public static final Lazy n = LazyKt__LazyJVMKt.lazy(d.a);

    @NotNull
    public static final Lazy o = LazyKt__LazyJVMKt.lazy(f.a);

    @NotNull
    public static final Lazy p = LazyKt__LazyJVMKt.lazy(g.a);

    @NotNull
    public static final Lazy q = LazyKt__LazyJVMKt.lazy(k.a);

    @NotNull
    public static final Lazy r = LazyKt__LazyJVMKt.lazy(h.a);

    @NotNull
    public static final Lazy s = LazyKt__LazyJVMKt.lazy(i.a);

    @NotNull
    public static final Lazy t = LazyKt__LazyJVMKt.lazy(j.a);

    @NotNull
    public static final Lazy u = LazyKt__LazyJVMKt.lazy(d0.a);

    @NotNull
    public static final Lazy v = LazyKt__LazyJVMKt.lazy(c.a);

    @NotNull
    public static final Lazy w = LazyKt__LazyJVMKt.lazy(e.a);

    @NotNull
    public static final Lazy x = LazyKt__LazyJVMKt.lazy(c0.a);

    @NotNull
    public static final Lazy y = LazyKt__LazyJVMKt.lazy(b0.a);

    @NotNull
    public static final Lazy z = LazyKt__LazyJVMKt.lazy(n.a);

    @NotNull
    public static final Lazy A = LazyKt__LazyJVMKt.lazy(u.a);

    @NotNull
    public static final Lazy B = LazyKt__LazyJVMKt.lazy(z.a);

    @NotNull
    public static final Lazy C = LazyKt__LazyJVMKt.lazy(p.a);

    @NotNull
    public static final Lazy D = LazyKt__LazyJVMKt.lazy(m.a);

    @NotNull
    public static final Lazy E = LazyKt__LazyJVMKt.lazy(q.a);

    @NotNull
    public static final Lazy F = LazyKt__LazyJVMKt.lazy(a0.a);

    @NotNull
    public static final Lazy G = LazyKt__LazyJVMKt.lazy(r.a);

    @NotNull
    public static final Lazy H = LazyKt__LazyJVMKt.lazy(l.a);

    @NotNull
    public static final Lazy I = LazyKt__LazyJVMKt.lazy(t.a);

    @NotNull
    public static final Lazy J = LazyKt__LazyJVMKt.lazy(s.a);

    @NotNull
    public static final Lazy K = LazyKt__LazyJVMKt.lazy(o.a);

    @NotNull
    public static final Lazy L = LazyKt__LazyJVMKt.lazy(b.a);

    @NotNull
    public static final Lazy M = LazyKt__LazyJVMKt.lazy(a.a);

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<la0> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("FLVS", null, "FLVS:%s;", na0.CTRL_LVS, 2, null);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a0 extends Lambda implements Function0<la0> {
        public static final a0 a = new a0();

        public a0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("SetStroke", null, "SetStroke:%s:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<la0> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("LVS", null, "LVS:%s;", na0.CTRL_LVS, 2, null);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b0 extends Lambda implements Function0<la0> {
        public static final b0 a = new b0();

        public b0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("suck", "s", "suck:%s;", na0.CTRL_SINGLE);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<la0> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("AAirLevel", null, "AAirLevel:%s:%s;", na0.CTRL_SINGLE, 2, null);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c0 extends Lambda implements Function0<la0> {
        public static final c0 a = new c0();

        public c0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Thrusting", "t", "Thrusting:%s;", na0.CTRL_SINGLE);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<la0> {
        public static final d a = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("ARotate", null, "ARotate:%s:%s;", na0.CTRL_SINGLE, 2, null);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d0 extends Lambda implements Function0<la0> {
        public static final d0 a = new d0();

        public d0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("VibAir", null, "VibAir:%s;", na0.CTRL_SINGLE, 2, null);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function0<la0> {
        public static final e a = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("AVibAir", null, "AVibAir:%s:%s:%s;", na0.CTRL_SINGLE, 2, null);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e0 extends Lambda implements Function0<la0> {
        public static final e0 a = new e0();

        public e0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("VibRotate", null, "VibRotate:%s;", na0.CTRL_SINGLE, 2, null);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f extends Lambda implements Function0<la0> {
        public static final f a = new f();

        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("AVibRotate", null, "AVibRotate:%s:%s:%s;", na0.CTRL_SINGLE, 2, null);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f0 extends Lambda implements Function0<la0> {
        public static final f0 a = new f0();

        public f0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Vibrate", PSOProgramService.VS_Key, "Vibrate:%s;", na0.CTRL_SINGLE);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g extends Lambda implements Function0<la0> {
        public static final g a = new g();

        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Air:In", null, "Air:In:%s;", na0.CTRL_SINGLE, 2, null);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g0 extends Lambda implements Function0<la0> {
        public static final g0 a = new g0();

        public g0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Vibrate1", "v1", "Vibrate1:%s;", na0.CTRL_SINGLE);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class h extends Lambda implements Function0<la0> {
        public static final h a = new h();

        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Air:Level", "p", "Air:Level:%s;", na0.CTRL_SINGLE);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class h0 extends Lambda implements Function0<la0> {
        public static final h0 a = new h0();

        public h0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Vibrate2;", "v2", "Vibrate2:%s;", na0.CTRL_SINGLE);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class i extends Lambda implements Function0<la0> {
        public static final i a = new i();

        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("AirLoop", null, "AirLoop:%s:%s;", na0.CTRL_SINGLE, 2, null);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class i0 extends Lambda implements Function0<la0> {
        public static final i0 a = new i0();

        public i0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Vibrate3", "v3", "Vibrate3:%s;", na0.CTRL_SINGLE);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class j extends Lambda implements Function0<la0> {
        public static final j a = new j();

        public j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("AirNLoop", null, "AirNLoop:%s:%s;", na0.CTRL_SINGLE, 2, null);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class j0 extends Lambda implements Function0<la0> {
        public static final j0 a = new j0();

        public j0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("AVibrate", null, "AVibrate:%s:%s;", na0.CTRL_SINGLE, 2, null);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class k extends Lambda implements Function0<la0> {
        public static final k a = new k();

        public k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Air:Out", null, "Air:Out:%s;", na0.CTRL_SINGLE, 2, null);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class k0 extends Lambda implements Function0<la0> {
        public static final k0 a = new k0();

        public k0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("AVibrate1", null, "AVibrate1:%s:%s;", na0.CTRL_SINGLE, 2, null);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class l extends Lambda implements Function0<la0> {
        public static final l a = new l();

        public l() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Depth", GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, "Depth:%s;", na0.CTRL_SINGLE);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class l0 extends Lambda implements Function0<la0> {
        public static final l0 a = new l0();

        public l0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("AVibrate2", null, "AVibrate2:%s:%s;", na0.CTRL_SINGLE, 2, null);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class m extends Lambda implements Function0<la0> {
        public static final m a = new m();

        public m() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("FSetSite", "pos", "FSetSite:%s;", na0.CTRL_SINGLE);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class n extends Lambda implements Function0<la0> {
        public static final n a = new n();

        public n() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Finger", "f", "Finger:%s;", na0.CTRL_SINGLE);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class o extends Lambda implements Function0<la0> {
        public static final o a = new o();

        public o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("GetCap;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class p extends Lambda implements Function0<la0> {
        public static final p a = new p();

        public p() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("GetPat;", null, null, na0.NORMAL, 6, null);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class q extends Lambda implements Function0<la0> {
        public static final q a = new q();

        public q() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("GetSite;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class r extends Lambda implements Function0<la0> {
        public static final r a = new r();

        public r() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("GetStroke;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class s extends Lambda implements Function0<la0> {
        public static final s a = new s();

        public s() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Mply", null, "Mply:%s;", na0.CTRL_MULTI, 2, null);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class t extends Lambda implements Function0<la0> {
        public static final t a = new t();

        public t() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Multiply", null, "Multiply:%s;", na0.CTRL_MULTI, 2, null);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class u extends Lambda implements Function0<la0> {
        public static final u a = new u();

        public u() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Pat", "a", "Pat:%s;", na0.CTRL_SINGLE);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class v extends Lambda implements Function0<la0> {
        public static final v a = new v();

        public v() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Rotate", StreamManagement.AckRequest.ELEMENT, "Rotate:%s;", na0.CTRL_SINGLE);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class w extends Lambda implements Function0<la0> {
        public static final w a = new w();

        public w() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("RotateChange;", null, null, na0.CTRL_SINGLE, 6, null);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class x extends Lambda implements Function0<la0> {
        public static final x a = new x();

        public x() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Rotate:False;", StreamManagement.AckRequest.ELEMENT, "Rotate:False:%s;", na0.CTRL_SINGLE);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class y extends Lambda implements Function0<la0> {
        public static final y a = new y();

        public y() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Rotate:True", StreamManagement.AckRequest.ELEMENT, "Rotate:True:%s;", na0.CTRL_SINGLE);
        }
    }

    /* compiled from: ToyCommandCtrlConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class z extends Lambda implements Function0<la0> {
        public static final z a = new z();

        public z() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("SetPat", "a", "SetPat:%s:%s;", na0.NORMAL);
        }
    }

    @NotNull
    public final la0 A() {
        return (la0) F.getValue();
    }

    @NotNull
    public final la0 B() {
        return (la0) y.getValue();
    }

    @NotNull
    public final la0 C() {
        return (la0) x.getValue();
    }

    @NotNull
    public final la0 D() {
        return (la0) u.getValue();
    }

    @NotNull
    public final la0 E() {
        return (la0) m.getValue();
    }

    @NotNull
    public final la0 F() {
        return (la0) b.getValue();
    }

    @NotNull
    public final la0 G() {
        return (la0) c.getValue();
    }

    @NotNull
    public final la0 H() {
        return (la0) d.getValue();
    }

    @NotNull
    public final la0 I() {
        return (la0) e.getValue();
    }

    @NotNull
    public final la0 J() {
        return (la0) f.getValue();
    }

    @NotNull
    public final la0 K() {
        return (la0) g.getValue();
    }

    @NotNull
    public final la0 L() {
        return (la0) h.getValue();
    }

    @NotNull
    public final la0 a() {
        return (la0) v.getValue();
    }

    @NotNull
    public final la0 b() {
        return (la0) n.getValue();
    }

    @NotNull
    public final la0 c() {
        return (la0) w.getValue();
    }

    @NotNull
    public final la0 d() {
        return (la0) o.getValue();
    }

    @NotNull
    public final la0 e() {
        return (la0) p.getValue();
    }

    @NotNull
    public final la0 f() {
        return (la0) r.getValue();
    }

    @NotNull
    public final la0 g() {
        return (la0) s.getValue();
    }

    @NotNull
    public final la0 h() {
        return (la0) t.getValue();
    }

    @NotNull
    public final la0 i() {
        return (la0) q.getValue();
    }

    @NotNull
    public final la0 j() {
        return (la0) H.getValue();
    }

    @NotNull
    public final la0 k() {
        return (la0) M.getValue();
    }

    @NotNull
    public final la0 l() {
        return (la0) D.getValue();
    }

    @NotNull
    public final la0 m() {
        return (la0) z.getValue();
    }

    @NotNull
    public final la0 n() {
        return (la0) K.getValue();
    }

    @NotNull
    public final la0 o() {
        return (la0) C.getValue();
    }

    @NotNull
    public final la0 p() {
        return (la0) E.getValue();
    }

    @NotNull
    public final la0 q() {
        return (la0) G.getValue();
    }

    @NotNull
    public final la0 r() {
        return (la0) L.getValue();
    }

    @NotNull
    public final la0 s() {
        return (la0) J.getValue();
    }

    @NotNull
    public final la0 t() {
        return (la0) I.getValue();
    }

    @NotNull
    public final la0 u() {
        return (la0) A.getValue();
    }

    @NotNull
    public final la0 v() {
        return (la0) i.getValue();
    }

    @NotNull
    public final la0 w() {
        return (la0) l.getValue();
    }

    @NotNull
    public final la0 x() {
        return (la0) k.getValue();
    }

    @NotNull
    public final la0 y() {
        return (la0) j.getValue();
    }

    @NotNull
    public final la0 z() {
        return (la0) B.getValue();
    }
}
