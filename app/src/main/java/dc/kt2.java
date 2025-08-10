package dc;

import android.R;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.IdRes;
import androidx.appcompat.widget.ActivityChooserModel;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.wear.ui.chat.pancel.helper.view.PanelSwitchLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: PanelSwitchHelper.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u0005J\u0006\u0010\u0013\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\fJ\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bJ\u0012\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\u0005H\u0007J\u0010\u0010\u001b\u001a\u00020\f2\b\b\u0001\u0010\u001c\u001a\u00020\u001dR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/wear/ui/chat/pancel/helper/PanelSwitchHelper;", "", "builder", "Lcom/wear/ui/chat/pancel/helper/PanelSwitchHelper$Builder;", "showKeyboard", "", "(Lcom/wear/ui/chat/pancel/helper/PanelSwitchHelper$Builder;Z)V", "hookBackUpSuccess", "Lcom/wear/ui/chat/pancel/helper/PanelSwitchHelper$HookBackUpSuccess;", "mPanelSwitchLayout", "Lcom/wear/ui/chat/pancel/helper/view/PanelSwitchLayout;", "addSecondaryInputView", "", "editText", "Landroid/widget/EditText;", "hookSystemBackByPanelSwitcher", "isContentScrollOutsizeEnable", "isKeyboardState", "isPanelState", "isResetState", "removeSecondaryInputView", "resetState", "setContentScrollOutsideEnable", StreamManagement.Enable.ELEMENT, "setHookBackUpSuccess", "toKeyboardState", "async", "toPanelState", "triggerViewId", "", "Builder", "HookBackUpSuccess", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class kt2 {

    @NotNull
    public final PanelSwitchLayout a;

    @Nullable
    public b b;

    /* compiled from: PanelSwitchHelper.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/wear/ui/chat/pancel/helper/PanelSwitchHelper$HookBackUpSuccess;", "", "hookBackUpSuccess", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface b {
        void o3();
    }

    public kt2(a aVar, boolean z) {
        jt2 jt2Var = jt2.a;
        jt2.b = aVar.getL();
        if (aVar.getL()) {
            List<yt2> listQ = aVar.q();
            au2 au2Var = au2.a;
            listQ.add(au2Var);
            aVar.m().add(au2Var);
            aVar.k().add(au2Var);
            aVar.j().add(au2Var);
        }
        PanelSwitchLayout h = aVar.getH();
        Intrinsics.checkNotNull(h);
        this.a = h;
        h.setTriggerViewClickInterceptor$app_marketRelease(aVar.getG());
        h.setContentScrollOutsizeEnable$app_marketRelease(aVar.getM());
        h.setScrollMeasurers$app_marketRelease(aVar.h());
        h.setPanelHeightMeasurers$app_marketRelease(aVar.n());
        h.o(aVar.q(), aVar.m(), aVar.k(), aVar.j());
        h.p(aVar.getI(), aVar.getK());
        if (z) {
            h.m0(true);
        }
    }

    public /* synthetic */ kt2(a aVar, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, z);
    }

    public final boolean a() {
        b bVar;
        boolean zC = this.a.C();
        if (zC && (bVar = this.b) != null) {
            bVar.o3();
        }
        return zC;
    }

    public final void b() {
        PanelSwitchLayout.t(this.a, -1, false, 2, null);
    }

    public final void c(@NotNull b hookBackUpSuccess) {
        Intrinsics.checkNotNullParameter(hookBackUpSuccess, "hookBackUpSuccess");
        this.b = hookBackUpSuccess;
    }

    public final void d(@IdRes int i) {
        PanelSwitchLayout.t(this.a, i, false, 2, null);
    }

    /* compiled from: PanelSwitchHelper.kt */
    @Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u0019\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u000e\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u0012J\u001f\u0010L\u001a\u00020\u00002\u0017\u0010N\u001a\u0013\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020Q0O¢\u0006\u0002\bRJ\u000e\u0010S\u001a\u00020\u00002\u0006\u0010T\u001a\u00020\u001eJ\u001f\u0010S\u001a\u00020\u00002\u0017\u0010N\u001a\u0013\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020Q0O¢\u0006\u0002\bRJ\u000e\u0010V\u001a\u00020\u00002\u0006\u0010T\u001a\u00020\"J\u001f\u0010V\u001a\u00020\u00002\u0017\u0010N\u001a\u0013\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020Q0O¢\u0006\u0002\bRJ\u000e\u0010X\u001a\u00020\u00002\u0006\u0010T\u001a\u00020)J\u001f\u0010X\u001a\u00020\u00002\u0017\u0010N\u001a\u0013\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020Q0O¢\u0006\u0002\bRJ\u000e\u0010Z\u001a\u00020\u00002\u0006\u0010[\u001a\u00020-J\u001f\u0010Z\u001a\u00020\u00002\u0017\u0010N\u001a\u0013\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020Q0O¢\u0006\u0002\bRJ\u000e\u0010]\u001a\u00020\u00002\u0006\u0010T\u001a\u00020BJ\u001f\u0010]\u001a\u00020\u00002\u0017\u0010N\u001a\u0013\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020Q0O¢\u0006\u0002\bRJ\u0012\u0010_\u001a\u00020`2\b\b\u0002\u0010a\u001a\u00020\u0018H\u0007J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010b\u001a\u00020Q2\u0006\u0010c\u001a\u00020\u000eH\u0002J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0018J\u000e\u0010d\u001a\u00020\u00002\u0006\u0010e\u001a\u00020<J\u000e\u0010f\u001a\u00020\u00002\u0006\u0010c\u001a\u00020\u000eR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R \u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R\u001a\u0010%\u001a\u00020\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010\u001cR \u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R \u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0014\"\u0004\b/\u0010\u0016R\u001c\u00100\u001a\u0004\u0018\u000101X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R \u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0014\"\u0004\bD\u0010\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001c\u0010I\u001a\u0004\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u00108\"\u0004\bK\u0010:¨\u0006g"}, d2 = {"Lcom/wear/ui/chat/pancel/helper/PanelSwitchHelper$Builder;", "", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "dialogFragment", "Landroidx/fragment/app/DialogFragment;", "(Landroidx/fragment/app/DialogFragment;)V", "window", "Landroid/view/Window;", "root", "Landroid/view/View;", "(Landroid/view/Window;Landroid/view/View;)V", "contentScrollMeasurers", "", "Lcom/wear/ui/chat/pancel/helper/interfaces/ContentScrollMeasurer;", "getContentScrollMeasurers$app_marketRelease", "()Ljava/util/List;", "setContentScrollMeasurers$app_marketRelease", "(Ljava/util/List;)V", "contentScrollOutsideEnable", "", "getContentScrollOutsideEnable$app_marketRelease", "()Z", "setContentScrollOutsideEnable$app_marketRelease", "(Z)V", "editFocusChangeListeners", "Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnEditFocusChangeListener;", "getEditFocusChangeListeners$app_marketRelease", "setEditFocusChangeListeners$app_marketRelease", "keyboardStatusListeners", "Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnKeyboardStateListener;", "getKeyboardStatusListeners$app_marketRelease", "setKeyboardStatusListeners$app_marketRelease", "logTrack", "getLogTrack$app_marketRelease", "setLogTrack$app_marketRelease", "panelChangeListeners", "Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnPanelChangeListener;", "getPanelChangeListeners$app_marketRelease", "setPanelChangeListeners$app_marketRelease", "panelHeightMeasurers", "Lcom/wear/ui/chat/pancel/helper/interfaces/PanelHeightMeasurer;", "getPanelHeightMeasurers$app_marketRelease", "setPanelHeightMeasurers$app_marketRelease", "panelSwitchLayout", "Lcom/wear/ui/chat/pancel/helper/view/PanelSwitchLayout;", "getPanelSwitchLayout$app_marketRelease", "()Lcom/wear/ui/chat/pancel/helper/view/PanelSwitchLayout;", "setPanelSwitchLayout$app_marketRelease", "(Lcom/wear/ui/chat/pancel/helper/view/PanelSwitchLayout;)V", "rootView", "getRootView$app_marketRelease", "()Landroid/view/View;", "setRootView$app_marketRelease", "(Landroid/view/View;)V", "triggerViewClickInterceptor", "Lcom/wear/ui/chat/pancel/helper/interfaces/TriggerViewClickInterceptor;", "getTriggerViewClickInterceptor$app_marketRelease", "()Lcom/wear/ui/chat/pancel/helper/interfaces/TriggerViewClickInterceptor;", "setTriggerViewClickInterceptor$app_marketRelease", "(Lcom/wear/ui/chat/pancel/helper/interfaces/TriggerViewClickInterceptor;)V", "viewClickListeners", "Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnViewClickListener;", "getViewClickListeners$app_marketRelease", "setViewClickListeners$app_marketRelease", "getWindow$app_marketRelease", "()Landroid/view/Window;", "setWindow$app_marketRelease", "(Landroid/view/Window;)V", "windowInsetsRootView", "getWindowInsetsRootView$app_marketRelease", "setWindowInsetsRootView$app_marketRelease", "addContentScrollMeasurer", "scrollMeasurer", "function", "Lkotlin/Function1;", "Lcom/wear/ui/chat/pancel/helper/interfaces/ContentScrollMeasurerBuilder;", "", "Lkotlin/ExtensionFunctionType;", "addEditTextFocusChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnEditFocusChangeListenerBuilder;", "addKeyboardStateListener", "Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnKeyboardStateListenerBuilder;", "addPanelChangeListener", "Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnPanelChangeListenerBuilder;", "addPanelHeightMeasurer", "panelHeightMeasurer", "Lcom/wear/ui/chat/pancel/helper/interfaces/PanelHeightMeasurerBuilder;", "addViewClickListener", "Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnViewClickListenerBuilder;", "build", "Lcom/wear/ui/chat/pancel/helper/PanelSwitchHelper;", "showKeyboard", "findSwitchLayout", "view", "setTriggerViewClickInterceptor", "interceptor", "setWindowInsetsRootView", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {

        @NotNull
        public List<yt2> a;

        @NotNull
        public List<wt2> b;

        @NotNull
        public List<ut2> c;

        @NotNull
        public List<tt2> d;

        @NotNull
        public List<ot2> e;

        @NotNull
        public List<qt2> f;

        @Nullable
        public st2 g;

        @Nullable
        public PanelSwitchLayout h;

        @NotNull
        public Window i;

        @NotNull
        public View j;

        @Nullable
        public View k;
        public boolean l;
        public boolean m;

        public a(@Nullable Window window, @Nullable View view) {
            this.a = new ArrayList();
            this.b = new ArrayList();
            this.c = new ArrayList();
            this.d = new ArrayList();
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.m = true;
            if (window == null) {
                throw new IllegalArgumentException("PanelSwitchHelper$Builder#build : window can't be null!please set value by call #Builder".toString());
            }
            this.i = window;
            if (view == null) {
                throw new IllegalArgumentException("PanelSwitchHelper$Builder#build : rootView can't be null!please set value by call #Builder".toString());
            }
            this.j = view;
        }

        public static /* synthetic */ kt2 f(a aVar, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return aVar.e(z);
        }

        @NotNull
        public final a a(@NotNull Function1<? super pt2, Unit> function) {
            Intrinsics.checkNotNullParameter(function, "function");
            List<ot2> list = this.e;
            pt2 pt2Var = new pt2();
            function.invoke(pt2Var);
            list.add(pt2Var);
            return this;
        }

        @NotNull
        public final a b(@NotNull Function1<? super vt2, Unit> function) {
            Intrinsics.checkNotNullParameter(function, "function");
            List<ut2> list = this.c;
            vt2 vt2Var = new vt2();
            function.invoke(vt2Var);
            list.add(vt2Var);
            return this;
        }

        @NotNull
        public final a c(@NotNull Function1<? super xt2, Unit> function) {
            Intrinsics.checkNotNullParameter(function, "function");
            List<wt2> list = this.b;
            xt2 xt2Var = new xt2();
            function.invoke(xt2Var);
            list.add(xt2Var);
            return this;
        }

        @NotNull
        public final a d(@NotNull Function1<? super rt2, Unit> function) {
            Intrinsics.checkNotNullParameter(function, "function");
            List<qt2> list = this.f;
            rt2 rt2Var = new rt2();
            function.invoke(rt2Var);
            list.add(rt2Var);
            return this;
        }

        @JvmOverloads
        @NotNull
        public final kt2 e(boolean z) {
            g(this.j);
            if (this.h == null) {
                throw new IllegalArgumentException("PanelSwitchHelper$Builder#build : not found PanelSwitchLayout!".toString());
            }
            kt2 kt2Var = new kt2(this, z, null);
            PanelSwitchLayout panelSwitchLayout = this.h;
            if (panelSwitchLayout != null) {
                panelSwitchLayout.n0();
            }
            return kt2Var;
        }

        public final void g(View view) {
            if (view instanceof PanelSwitchLayout) {
                if ((this.h == null ? 1 : 0) == 0) {
                    throw new IllegalArgumentException("PanelSwitchHelper$Builder#build : rootView has one more panelSwitchLayout!".toString());
                }
                this.h = (PanelSwitchLayout) view;
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                while (i < childCount) {
                    View childAt = viewGroup.getChildAt(i);
                    Intrinsics.checkNotNullExpressionValue(childAt, "view.getChildAt(i)");
                    g(childAt);
                    i++;
                }
            }
        }

        @NotNull
        public final List<ot2> h() {
            return this.e;
        }

        /* renamed from: i, reason: from getter */
        public final boolean getM() {
            return this.m;
        }

        @NotNull
        public final List<tt2> j() {
            return this.d;
        }

        @NotNull
        public final List<ut2> k() {
            return this.c;
        }

        /* renamed from: l, reason: from getter */
        public final boolean getL() {
            return this.l;
        }

        @NotNull
        public final List<wt2> m() {
            return this.b;
        }

        @NotNull
        public final List<qt2> n() {
            return this.f;
        }

        @Nullable
        /* renamed from: o, reason: from getter */
        public final PanelSwitchLayout getH() {
            return this.h;
        }

        @Nullable
        /* renamed from: p, reason: from getter */
        public final st2 getG() {
            return this.g;
        }

        @NotNull
        public final List<yt2> q() {
            return this.a;
        }

        @NotNull
        /* renamed from: r, reason: from getter */
        public final Window getI() {
            return this.i;
        }

        @Nullable
        /* renamed from: s, reason: from getter */
        public final View getK() {
            return this.k;
        }

        @NotNull
        public final a t(boolean z) {
            this.l = z;
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(@NotNull Activity activity) {
            this(activity.getWindow(), activity.getWindow().getDecorView().findViewById(R.id.content));
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }
}
