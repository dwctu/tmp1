package dc;

import android.location.Location;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.location.LocationListenerCompat;
import java.util.List;

/* compiled from: LocationListenerCompat.java */
/* loaded from: classes.dex */
public final /* synthetic */ class j2 {
    public static void $default$onFlushComplete(LocationListenerCompat locationListenerCompat, int i) {
    }

    public static void $default$onLocationChanged(@NonNull LocationListenerCompat _this, List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            _this.onLocationChanged((Location) list.get(i));
        }
    }

    public static void $default$onProviderDisabled(@NonNull LocationListenerCompat locationListenerCompat, String str) {
    }

    public static void $default$onProviderEnabled(@NonNull LocationListenerCompat locationListenerCompat, String str) {
    }

    public static void $default$onStatusChanged(@NonNull LocationListenerCompat locationListenerCompat, String str, @Nullable int i, Bundle bundle) {
    }
}
