package dc;

import android.app.Activity;
import com.wear.ext.ActivityKt;
import com.wear.ui.longDistance.ConnectionsActivity;
import com.wear.ui.longDistance.FriendsSearchSingleActivity;
import java.util.Iterator;
import kotlin.Metadata;

/* compiled from: ConnectionsHelper.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, d2 = {"connectionsFinishIfNeed", "", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class v83 {
    public static final void a() {
        Iterator<Activity> it = ActivityKt.d().iterator();
        while (it.hasNext()) {
            Activity next = it.next();
            if (next instanceof ConnectionsActivity) {
                next.finish();
            }
            if (next instanceof FriendsSearchSingleActivity) {
                next.finish();
            }
        }
    }
}
