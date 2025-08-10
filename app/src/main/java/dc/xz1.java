package dc;

import android.app.Activity;
import com.wear.ext.ActivityKt;
import com.wear.main.longDistance.ChatActivity;
import com.wear.main.longDistance.ChatRoomActivity;
import com.wear.ui.chat.NewChatActivity;
import com.wear.ui.longDistance.controlLink.ControlLinkChatActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecordVoiceAction.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, d2 = {"checkCancelRecordVoice", "", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class xz1 {
    public static final void a() {
        if (ActivityKt.e() == null) {
            return;
        }
        Activity activityE = ActivityKt.e();
        if (activityE instanceof ChatActivity) {
            Activity activityE2 = ActivityKt.e();
            Intrinsics.checkNotNull(activityE2, "null cannot be cast to non-null type com.wear.main.longDistance.ChatActivity");
            ((ChatActivity) activityE2).J6();
            return;
        }
        if (activityE instanceof ChatRoomActivity) {
            Activity activityE3 = ActivityKt.e();
            Intrinsics.checkNotNull(activityE3, "null cannot be cast to non-null type com.wear.main.longDistance.ChatRoomActivity");
            ((ChatRoomActivity) activityE3).s6();
        } else if (activityE instanceof ControlLinkChatActivity) {
            Activity activityE4 = ActivityKt.e();
            Intrinsics.checkNotNull(activityE4, "null cannot be cast to non-null type com.wear.ui.longDistance.controlLink.ControlLinkChatActivity");
            ((ControlLinkChatActivity) activityE4).b5();
        } else if (activityE instanceof NewChatActivity) {
            Activity activityE5 = ActivityKt.e();
            Intrinsics.checkNotNull(activityE5, "null cannot be cast to non-null type com.wear.ui.chat.NewChatActivity");
            ((NewChatActivity) activityE5).G4();
        }
    }
}
