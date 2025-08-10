package no.nordicsemi.android.dfu.internal.scanner;

import android.os.Build;
import androidx.annotation.NonNull;
import java.util.Locale;

/* loaded from: classes5.dex */
public final class BootloaderScannerFactory {
    private static final int ADDRESS_DIFF = 1;

    private BootloaderScannerFactory() {
    }

    public static String getIncrementedAddress(@NonNull String str) {
        return str.substring(0, 15) + String.format(Locale.US, "%02X", Integer.valueOf((Integer.valueOf(str.substring(15), 16).intValue() + 1) & 255));
    }

    public static BootloaderScanner getScanner(@NonNull String str) {
        String incrementedAddress = getIncrementedAddress(str);
        return Build.VERSION.SDK_INT >= 21 ? new BootloaderScannerLollipop(str, incrementedAddress) : new BootloaderScannerJB(str, incrementedAddress);
    }
}
