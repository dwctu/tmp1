package dc;

import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: ControlState.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u001e\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nH&J\u001e\u0010\f\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nH&¨\u0006\r"}, d2 = {"Lcom/wear/main/control/state/ControlState;", "", "nextState", "controller", "Lcom/wear/main/control/ControlInterface;", "event", "Lcom/wear/main/control/Event;", "onEnter", "", CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY, "", "", "onExit", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface f22 {
    @Nullable
    f22 a(@Nullable x12 x12Var, @Nullable Event b22Var);

    void b(@Nullable Map<String, ? extends Object> map);

    void c(@Nullable Map<String, ? extends Object> map);
}
