package dc;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.wear.util.WearUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuServiceInitiator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Notification.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\t\u001a\u00020\n*\u00020\u0006H\u0003\u001a\f\u0010\u000b\u001a\u00020\n*\u00020\u0006H\u0003\u001a\n\u0010\f\u001a\u00020\n*\u00020\r\u001a\u0012\u0010\u000e\u001a\u00020\n*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u0014\u0010\u0011\u001a\u00020\n*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0003\u001a\u0014\u0010\u0012\u001a\u00020\n*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"TAG", "", "pendingIntentRequestCode", "", "notificationManager", "Landroid/app/NotificationManager;", "Landroid/content/Context;", "getNotificationManager", "(Landroid/content/Context;)Landroid/app/NotificationManager;", "buildSilenceChannel", "", "buildSoundChannel", "createNotification", "Landroid/app/Activity;", "notify", "wrapper", "Lcom/wear/bean/NotificationWrapper;", "notifyAndroid", "notifyAndroidO", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
@JvmName(name = "NotificationUtils")
/* loaded from: classes3.dex */
public final class nu1 {
    @RequiresApi(26)
    public static final void a(Context context) {
        NotificationChannel notificationChannel = new NotificationChannel("com.lovense.wear.notic.silence", "RemoteNotificationSilence", 2);
        notificationChannel.setLockscreenVisibility(-1);
        notificationChannel.setDescription("mute notification");
        notificationChannel.setName("RemoteNotificationSilence");
        notificationChannel.setShowBadge(true);
        NotificationManager notificationManagerE = e(context);
        if (notificationManagerE != null) {
            notificationManagerE.createNotificationChannel(notificationChannel);
        }
    }

    @RequiresApi(26)
    public static final void b(Context context) {
        NotificationChannel notificationChannel = new NotificationChannel("com.lovense.wear.notic.sound", "RemoteNotificationSound", 3);
        notificationChannel.setLockscreenVisibility(-1);
        notificationChannel.setDescription("sound notification");
        notificationChannel.setLightColor(-16711936);
        notificationChannel.enableVibration(true);
        notificationChannel.enableLights(true);
        notificationChannel.setName("RemoteNotificationSound");
        notificationChannel.setShowBadge(true);
        notificationChannel.setSound(WearUtils.S(), notificationChannel.getAudioAttributes());
        NotificationManager notificationManagerE = e(context);
        if (notificationManagerE != null) {
            notificationManagerE.createNotificationChannel(notificationChannel);
        }
    }

    public static final void c(@NotNull final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            q61 q61VarM = q61.m(activity);
            q61VarM.h("android.permission.POST_NOTIFICATIONS");
            q61VarM.j(new u51() { // from class: dc.wt1
                @Override // dc.u51
                public /* synthetic */ void a(List list, boolean z) {
                    t51.a(this, list, z);
                }

                @Override // dc.u51
                public final void b(List list, boolean z) {
                    nu1.d(activity, list, z);
                }
            });
        } else if (i >= 26) {
            b(activity);
            a(activity);
            DfuServiceInitiator.createDfuNotificationChannel(activity);
        }
    }

    public static final void d(Activity this_createNotification, List permissions, boolean z) {
        Intrinsics.checkNotNullParameter(this_createNotification, "$this_createNotification");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        if (z) {
            b(this_createNotification);
            a(this_createNotification);
            DfuServiceInitiator.createDfuNotificationChannel(this_createNotification);
        }
    }

    @Nullable
    public static final NotificationManager e(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("notification");
        if (systemService instanceof NotificationManager) {
            return (NotificationManager) systemService;
        }
        return null;
    }
}
