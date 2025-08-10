package dc;

import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.wear.bean.event.NotificationMusicCloseEvent;
import com.wear.main.closeRange.music.MusicControl;
import java.util.Map;
import kotlin.Metadata;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.Nullable;

/* compiled from: ControllingState.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001e\u0010\b\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/wear/main/control/state/ControllingState;", "Lcom/wear/main/control/state/ControlState;", "()V", "nextState", "controller", "Lcom/wear/main/control/ControlInterface;", "event", "Lcom/wear/main/control/Event;", "onEnter", "", CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY, "", "", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class g22 implements f22 {

    /* compiled from: ControllingState.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c22.values().length];
            iArr[c22.EVENT_START.ordinal()] = 1;
            iArr[c22.EVENT_STOP.ordinal()] = 2;
            a = iArr;
        }
    }

    @Override // dc.f22
    @Nullable
    public f22 a(@Nullable x12 x12Var, @Nullable Event event) {
        if (x12Var == null || event == null) {
            return null;
        }
        c22 name = event.getName();
        int i = name == null ? -1 : a.a[name.ordinal()];
        if (i == 1) {
            return this;
        }
        if (i != 2) {
            return null;
        }
        return x12Var.getG();
    }

    @Override // dc.f22
    public void b(@Nullable Map<String, ? extends Object> map) {
        if (MusicControl.h0().u) {
            MusicControl.h0().S();
            EventBus.getDefault().post(new NotificationMusicCloseEvent());
        }
    }
}
