package dc;

import android.app.Activity;
import androidx.appcompat.widget.ActivityChooserModel;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.wear.widget.control.FingImageLayout;
import dc.x12;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoiceController.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u0014\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u0013\u0018\u00010\u0012H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u0014H\u0016J \u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0012\u0010'\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0006\u0010(\u001a\u00020\u000eJ\u0006\u0010)\u001a\u00020\u000eJ\b\u0010*\u001a\u00020\u000eH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/wear/ui/discover/voicecontrol/VoiceController;", "Lcom/wear/main/control/ControlInterface;", "mediator", "Lcom/wear/main/control/ControlMediator;", "(Lcom/wear/main/control/ControlMediator;)V", "controlState", "Lcom/wear/main/control/state/ControlState;", "controllingState", "Lcom/wear/main/control/state/ControllingState;", "idleState", "Lcom/wear/main/control/state/IdleState;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/wear/ui/discover/voicecontrol/VoiceController$VoiceControllerListener;", "closeExpandWindow", "", "getAnimation", "", "getBlackList", "", "Ljava/lang/Class;", "Landroid/app/Activity;", "getControlState", "getControllingState", "getControllingTip", "getIdleState", "getMediator", "Lcom/wear/main/control/Mediator;", "getPriority", "Lcom/wear/main/control/ControlPriority;", "isOpeningExpandWindow", "", "onActivityCreated", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "openExpandWindow", TtmlNode.LEFT, "x", "", FingImageLayout.ObjectAnimatorY, "registerListener", "setControlState", TtmlNode.START, "stop", "unregisterListenerListener", "VoiceControllerListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class c13 implements x12 {

    @NotNull
    public final y12 a;

    @Nullable
    public f22 b;

    @Nullable
    public h22 c;

    @Nullable
    public g22 d;

    @Nullable
    public c e;

    /* compiled from: VoiceController.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0016J\u001e\u0010\b\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/wear/ui/discover/voicecontrol/VoiceController$1", "Lcom/wear/main/control/state/IdleState;", "onEnter", "", CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY, "", "", "", "onExit", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends h22 {
        @Override // dc.f22
        public void b(@Nullable Map<String, ? extends Object> map) {
        }

        @Override // dc.f22
        public void c(@Nullable Map<String, ? extends Object> map) {
        }
    }

    /* compiled from: VoiceController.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0016J\u001e\u0010\b\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/wear/ui/discover/voicecontrol/VoiceController$2", "Lcom/wear/main/control/state/ControllingState;", "onEnter", "", CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY, "", "", "", "onExit", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends g22 {
        public b() {
        }

        @Override // dc.g22, dc.f22
        public void b(@Nullable Map<String, ? extends Object> map) {
            super.b(map);
            c cVar = c13.this.e;
            if (cVar != null) {
                cVar.a();
            }
        }

        @Override // dc.f22
        public void c(@Nullable Map<String, ? extends Object> map) {
            c cVar = c13.this.e;
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    /* compiled from: VoiceController.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/wear/ui/discover/voicecontrol/VoiceController$VoiceControllerListener;", "", "onVoiceControllerStart", "", "onVoiceControllerStop", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface c {
        void a();

        void b();
    }

    public c13(@NotNull y12 mediator) {
        Intrinsics.checkNotNullParameter(mediator, "mediator");
        this.a = mediator;
        a aVar = new a();
        this.c = aVar;
        this.d = new b();
        this.b = aVar;
    }

    @Override // dc.x12
    public boolean a() {
        return false;
    }

    @Override // dc.x12
    public /* synthetic */ boolean b(f22 f22Var, Map map) {
        return w12.a(this, f22Var, map);
    }

    @Override // dc.x12
    public void c(@Nullable f22 f22Var) {
        this.b = f22Var;
    }

    @Override // dc.x12
    @Nullable
    public String d() {
        return null;
    }

    @Override // dc.x12
    @Nullable
    /* renamed from: e, reason: from getter */
    public f22 getI() {
        return this.b;
    }

    @Override // dc.x12
    public boolean f() {
        return x12.b.a(this);
    }

    @Override // dc.x12
    public void g() {
    }

    @Override // dc.x12
    @NotNull
    public a22 getPriority() {
        return a22.PRIORITY_1;
    }

    @Override // dc.x12
    public /* synthetic */ boolean h(Event event) {
        return w12.b(this, event);
    }

    @Override // dc.x12
    @Nullable
    /* renamed from: i, reason: from getter */
    public h22 getJ() {
        return this.c;
    }

    @Override // dc.x12
    public void j(boolean z, int i, int i2) {
    }

    @Override // dc.x12
    @Nullable
    /* renamed from: k */
    public e22 getA() {
        return this.a;
    }

    @Override // dc.x12
    @Nullable
    /* renamed from: l, reason: from getter */
    public g22 getK() {
        return this.d;
    }

    @Override // dc.x12
    public void m(@Nullable Activity activity) {
    }

    @Override // dc.x12
    @Nullable
    public List<Class<? extends Activity>> n() {
        return null;
    }

    @Override // dc.x12
    @Nullable
    public String o() {
        return null;
    }

    public final void q(@Nullable c cVar) {
        this.e = cVar;
    }

    public final void r() {
        h(new Event(c22.EVENT_START, null));
    }

    public final void s() {
        t();
        h(new Event(c22.EVENT_STOP, null));
    }

    public final void t() {
        this.e = null;
    }
}
