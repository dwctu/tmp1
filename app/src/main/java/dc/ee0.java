package dc;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import dc.ve0;

/* compiled from: NotificationUtils.java */
/* loaded from: classes.dex */
public class ee0 {

    /* compiled from: NotificationUtils.java */
    public static class a {
        public static final a b = new a(ve0.a().getPackageName(), ve0.a().getPackageName(), 3);
        public NotificationChannel a;

        public a(String str, CharSequence charSequence, int i) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.a = new NotificationChannel(str, charSequence, i);
            }
        }

        public NotificationChannel b() {
            return this.a;
        }
    }

    public static Notification a(a aVar, ve0.b<NotificationCompat.Builder> bVar) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            ((NotificationManager) ve0.a().getSystemService("notification")).createNotificationChannel(aVar.b());
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(ve0.a());
        if (i >= 26) {
            builder.setChannelId(aVar.a.getId());
        }
        if (bVar != null) {
            bVar.accept(builder);
        }
        return builder.build();
    }
}
