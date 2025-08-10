package dc;

import android.app.Activity;
import androidx.appcompat.widget.ActivityChooserModel;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.wear.widget.control.FingImageLayout;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmDefault;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ControlInterface.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u0000 (2\u00020\u0001:\u0001(J(\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H\u0017J\b\u0010\t\u001a\u00020\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\bH&J\u001a\u0010\f\u001a\u0014\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000f0\u000e\u0018\u00010\rH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\bH&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J\b\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH\u0017J\b\u0010\u001d\u001a\u00020\u0003H&J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\u0012\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u000fH&J \u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H&J\u0012\u0010&\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010\u0005H&¨\u0006)"}, d2 = {"Lcom/wear/main/control/ControlInterface;", "", "changeState", "", "state", "Lcom/wear/main/control/state/ControlState;", CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY, "", "", "closeExpandWindow", "", "getAnimation", "getBlackList", "", "Ljava/lang/Class;", "Landroid/app/Activity;", "getControlState", "getControllingState", "Lcom/wear/main/control/state/ControllingState;", "getControllingTip", "getIdleState", "Lcom/wear/main/control/state/IdleState;", "getMediator", "Lcom/wear/main/control/Mediator;", "getPriority", "Lcom/wear/main/control/ControlPriority;", "handleEvent", "event", "Lcom/wear/main/control/Event;", "isOpeningExpandWindow", "isShowFloatView", "onActivityCreated", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "openExpandWindow", TtmlNode.LEFT, "x", "", FingImageLayout.ObjectAnimatorY, "setControlState", "controlState", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface x12 {

    /* compiled from: ControlInterface.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/wear/main/control/ControlInterface$Companion;", "", "()V", "TAG", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public static final /* synthetic */ a a = new a();
    }

    /* compiled from: ControlInterface.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        public static boolean a(@NotNull x12 x12Var) {
            return true;
        }
    }

    static {
        a aVar = a.a;
    }

    boolean a();

    @JvmDefault
    boolean b(@Nullable f22 f22Var, @Nullable Map<String, ? extends Object> map);

    void c(@Nullable f22 f22Var);

    @Nullable
    String d();

    @Nullable
    f22 e();

    boolean f();

    void g();

    @NotNull
    a22 getPriority();

    @JvmDefault
    boolean h(@NotNull Event b22Var);

    @Nullable
    h22 i();

    void j(boolean z, int i, int i2);

    @Nullable
    e22 k();

    @Nullable
    g22 l();

    void m(@Nullable Activity activity);

    @Nullable
    List<Class<? extends Activity>> n();

    @Nullable
    String o();
}
