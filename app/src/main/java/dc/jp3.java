package dc;

import android.text.TextUtils;
import com.wear.bean.Toy;
import com.wear.widget.control.multiToys.MultiControlPanel;
import com.wear.widget.velvo.VelvoPreviewView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: VelvoPositionPreviewAction.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J\u001a\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\bH\u0016J\u0006\u0010\u001d\u001a\u00020\u0016J\u0006\u0010\u001e\u001a\u00020\u0016J\u000e\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u000eJ\u0018\u0010\u001f\u001a\u00020\u00162\u0010\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"J\u0010\u0010$\u001a\u00020\u00162\b\u0010%\u001a\u0004\u0018\u00010\bJ\u001c\u0010&\u001a\u00020\u00162\b\u0010%\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010'\u001a\u00020\u000bH\u0002J\"\u0010(\u001a\u00020\u00162\u001a\u0010)\u001a\u0016\u0012\u0004\u0012\u00020+\u0018\u00010*j\n\u0012\u0004\u0012\u00020+\u0018\u0001`,J\u0006\u0010-\u001a\u00020\u0016J\u0006\u0010.\u001a\u00020\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/wear/widget/control/multiToys/VelvoPositionPreviewAction;", "Lcom/wear/widget/control/multiToys/MultiControlPanel$OnVelvoPreviewListener;", "Lcom/wear/widget/velvo/VelvoPreviewView$OnPreviewHiddenListener;", "multiControlPanel", "Lcom/wear/widget/control/multiToys/MultiControlPanel;", "velvoPositionView", "Lcom/wear/widget/velvo/VelvoPreviewView;", "controlMode", "", "(Lcom/wear/widget/control/multiToys/MultiControlPanel;Lcom/wear/widget/velvo/VelvoPreviewView;Ljava/lang/String;)V", "isShowingNow", "", "pointMap", "", "", "selectAddress", "skipNotifyPreview", "getSkipNotifyPreview", "()Z", "setSkipNotifyPreview", "(Z)V", "hide", "", "hideVisible", "onPreviewHidden", "onRecoverPreview", "isShow", "onVelvoPreview", "toyAddress", "resetPoint", "resetVelvoPreviewViewPosition", "setPoint", "value", "ball2CurveEventList", "", "Lcom/wear/bean/controlmutlitoys/Ball2CurveEventBean;", "show", MultipleAddresses.Address.ELEMENT, "showForce", "onlyVisible", "showForceToys", "allToys", "Ljava/util/ArrayList;", "Lcom/wear/bean/Toy;", "Lkotlin/collections/ArrayList;", "showResumed", "showVisibleResumed", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class jp3 implements MultiControlPanel.v, VelvoPreviewView.a {

    @NotNull
    public static final a h = new a(null);
    public static boolean i;

    @NotNull
    public final MultiControlPanel a;

    @NotNull
    public final VelvoPreviewView b;

    @NotNull
    public final String c;

    @Nullable
    public String d;
    public boolean e;

    @NotNull
    public Map<String, Integer> f;
    public boolean g;

    /* compiled from: VelvoPositionPreviewAction.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007R\u0018\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002¨\u0006\b"}, d2 = {"Lcom/wear/widget/control/multiToys/VelvoPositionPreviewAction$Companion;", "", "()V", "recordHidden", "", "getRecordHidden$annotations", "resetRecordHidden", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            jp3.i = false;
        }
    }

    public jp3(@NotNull MultiControlPanel multiControlPanel, @NotNull VelvoPreviewView velvoPositionView, @NotNull String controlMode) {
        Intrinsics.checkNotNullParameter(multiControlPanel, "multiControlPanel");
        Intrinsics.checkNotNullParameter(velvoPositionView, "velvoPositionView");
        Intrinsics.checkNotNullParameter(controlMode, "controlMode");
        this.a = multiControlPanel;
        this.b = velvoPositionView;
        this.c = controlMode;
        multiControlPanel.I(this);
        velvoPositionView.a(this, controlMode);
        this.f = new LinkedHashMap();
    }

    public static /* synthetic */ void o(jp3 jp3Var, String str, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        jp3Var.n(str, z);
    }

    public static final void p(jp3 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b.setVisibility(0);
    }

    @Override // com.wear.widget.control.multiToys.MultiControlPanel.v
    public void a(boolean z) {
        if (z) {
            r();
        } else {
            e();
        }
    }

    @Override // com.wear.widget.velvo.VelvoPreviewView.a
    public void b() {
        i = true;
    }

    @Override // com.wear.widget.control.multiToys.MultiControlPanel.v
    public void c(boolean z, @Nullable String str) {
        String str2 = this.d;
        boolean z2 = true;
        if ((str2 == null || str2.length() == 0) || z) {
            this.d = str;
        }
        if (qa2.a() || this.a.Q()) {
            return;
        }
        if (z) {
            if (this.b.getVisibility() == 0) {
                if (str != null && str.length() != 0) {
                    z2 = false;
                }
                if (z2) {
                    return;
                }
                Integer num = this.f.get(str);
                j(num != null ? num.intValue() : 0);
                return;
            }
        }
        if (((Intrinsics.areEqual(this.c, "CHAT_SYNC_CONTROL") || Intrinsics.areEqual(this.c, "GROUP_CHAT_SYNC_CONTROL")) && !this.e) || i) {
            return;
        }
        if (this.g && Intrinsics.areEqual(this.c, "GROUP_CHAT_DS_CONTROL")) {
            this.g = false;
            return;
        }
        if (this.g && (Intrinsics.areEqual(this.c, "CHAT_VOICE_CONTROL") || Intrinsics.areEqual(this.c, "CHAT_VIDEO_CONTROL"))) {
            this.g = false;
        } else if (z) {
            this.b.p();
        } else {
            this.b.c();
        }
    }

    public final void e() {
        this.e = false;
        if (this.b.getVisibility() == 8) {
            return;
        }
        this.b.c();
    }

    public final void f() {
        this.b.setVisibility(8);
    }

    public final void h() {
        this.b.setPointY(100);
    }

    public final void i() {
        this.b.setPointY(100);
    }

    public final void j(int i2) {
        this.b.setPointY(100 - i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[LOOP:1: B:25:0x0044->B:90:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void k(@org.jetbrains.annotations.Nullable java.util.List<com.wear.bean.controlmutlitoys.Ball2CurveEventBean> r9) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.jp3.k(java.util.List):void");
    }

    public final void l(boolean z) {
        this.g = z;
    }

    public final void m(@Nullable String str) {
        if (Intrinsics.areEqual(str, this.d)) {
            if (this.b.getVisibility() == 0) {
                i = true;
                this.b.c();
                return;
            } else {
                this.b.p();
                i = false;
                return;
            }
        }
        this.d = str;
        VelvoPreviewView velvoPreviewView = this.b;
        Integer num = this.f.get(str);
        velvoPreviewView.setPointY(100 - (num != null ? num.intValue() : 0));
        this.b.n();
        this.b.p();
        i = false;
    }

    public final void n(String str, boolean z) {
        if (str != null) {
            this.d = str;
        }
        if (i) {
            return;
        }
        this.e = true;
        if (this.b.getVisibility() == 0) {
            return;
        }
        if (z) {
            this.b.post(new Runnable() { // from class: dc.gp3
                @Override // java.lang.Runnable
                public final void run() {
                    jp3.p(this.a);
                }
            });
        } else {
            this.b.p();
        }
    }

    public final void q(@Nullable ArrayList<Toy> arrayList) {
        Object next;
        ek2 ek2VarValueOf;
        if (i) {
            return;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((Toy) next).isBAToy()) {
                    break;
                }
            }
        }
        Toy toy = (Toy) next;
        if (toy == null) {
            return;
        }
        if (TextUtils.isEmpty(toy.getWorkMode())) {
            ek2VarValueOf = fk2.a.c(toy.getAddress());
        } else {
            String workMode = toy.getWorkMode();
            Intrinsics.checkNotNullExpressionValue(workMode, "toy.workMode");
            String upperCase = workMode.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            ek2VarValueOf = ek2.valueOf(upperCase);
        }
        if (ek2VarValueOf != ek2.POSITION) {
            return;
        }
        String address = toy.getAddress();
        if (address != null) {
            this.d = address;
        }
        this.e = true;
        if (this.b.getVisibility() == 0) {
            return;
        }
        this.b.p();
    }

    public final void r() {
        String strK = this.a.multiBallSelectPanel.k();
        if (strK != null) {
            o(this, strK, false, 2, null);
        }
    }

    public final void s() {
        String strK = this.a.multiBallSelectPanel.k();
        if (strK != null) {
            n(strK, true);
        }
    }
}
