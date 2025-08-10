package androidx.biometric;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* loaded from: classes.dex */
public class KeyguardUtils {

    @RequiresApi(16)
    public static class Api16Impl {
        private Api16Impl() {
        }

        public static boolean isKeyguardSecure(@NonNull KeyguardManager keyguardManager) {
            return keyguardManager.isKeyguardSecure();
        }
    }

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @Nullable
        public static KeyguardManager getKeyguardManager(@NonNull Context context) {
            return (KeyguardManager) context.getSystemService(KeyguardManager.class);
        }

        public static boolean isDeviceSecure(@NonNull KeyguardManager keyguardManager) {
            return keyguardManager.isDeviceSecure();
        }
    }

    private KeyguardUtils() {
    }

    @Nullable
    public static KeyguardManager getKeyguardManager(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.getKeyguardManager(context);
        }
        Object systemService = context.getSystemService("keyguard");
        if (systemService instanceof KeyguardManager) {
            return (KeyguardManager) systemService;
        }
        return null;
    }

    public static boolean isDeviceSecuredWithCredential(@NonNull Context context) {
        KeyguardManager keyguardManager = getKeyguardManager(context);
        if (keyguardManager == null) {
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return Api23Impl.isDeviceSecure(keyguardManager);
        }
        if (i >= 16) {
            return Api16Impl.isKeyguardSecure(keyguardManager);
        }
        return false;
    }
}
