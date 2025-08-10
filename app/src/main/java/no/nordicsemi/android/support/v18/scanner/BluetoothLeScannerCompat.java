package no.nordicsemi.android.support.v18.scanner;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import no.nordicsemi.android.support.v18.scanner.ScanSettings;

/* loaded from: classes5.dex */
public abstract class BluetoothLeScannerCompat {
    public static final String EXTRA_CALLBACK_TYPE = "android.bluetooth.le.extra.CALLBACK_TYPE";
    public static final String EXTRA_ERROR_CODE = "android.bluetooth.le.extra.ERROR_CODE";
    public static final String EXTRA_LIST_SCAN_RESULT = "android.bluetooth.le.extra.LIST_SCAN_RESULT";
    private static BluetoothLeScannerCompat instance;

    public static class ScanCallbackWrapper {
        private final boolean emulateBatching;
        private final boolean emulateFiltering;
        private final boolean emulateFoundOrLostCallbackType;

        @NonNull
        public final List<ScanFilter> filters;

        @NonNull
        public final Handler handler;

        @NonNull
        public final ScanCallback scanCallback;

        @NonNull
        public final ScanSettings scanSettings;

        @NonNull
        private final Object LOCK = new Object();

        @NonNull
        private final List<ScanResult> scanResults = new ArrayList();

        @NonNull
        private final Set<String> devicesInBatch = new HashSet();

        @NonNull
        private final Map<String, ScanResult> devicesInRange = new HashMap();

        @NonNull
        private final Runnable matchLostNotifierTask = new AnonymousClass1();
        private boolean scanningStopped = false;

        /* renamed from: no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat$ScanCallbackWrapper$1, reason: invalid class name */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void b(ScanResult scanResult) {
                ScanCallbackWrapper.this.scanCallback.onScanResult(4, scanResult);
            }

            @Override // java.lang.Runnable
            public void run() {
                long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                synchronized (ScanCallbackWrapper.this.LOCK) {
                    Iterator it = ScanCallbackWrapper.this.devicesInRange.values().iterator();
                    while (it.hasNext()) {
                        final ScanResult scanResult = (ScanResult) it.next();
                        if (scanResult.getTimestampNanos() < jElapsedRealtimeNanos - ScanCallbackWrapper.this.scanSettings.getMatchLostDeviceTimeout()) {
                            it.remove();
                            ScanCallbackWrapper.this.handler.post(new Runnable() { // from class: dc.lb4
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.a.b(scanResult);
                                }
                            });
                        }
                    }
                    if (!ScanCallbackWrapper.this.devicesInRange.isEmpty()) {
                        ScanCallbackWrapper scanCallbackWrapper = ScanCallbackWrapper.this;
                        scanCallbackWrapper.handler.postDelayed(this, scanCallbackWrapper.scanSettings.getMatchLostTaskInterval());
                    }
                }
            }
        }

        public ScanCallbackWrapper(boolean z, boolean z2, @NonNull List<ScanFilter> list, @NonNull ScanSettings scanSettings, @NonNull ScanCallback scanCallback, @NonNull final Handler handler) {
            this.filters = Collections.unmodifiableList(list);
            this.scanSettings = scanSettings;
            this.scanCallback = scanCallback;
            this.handler = handler;
            boolean z3 = false;
            this.emulateFoundOrLostCallbackType = (scanSettings.getCallbackType() == 1 || ((Build.VERSION.SDK_INT >= 23) && scanSettings.getUseHardwareCallbackTypesIfSupported())) ? false : true;
            this.emulateFiltering = (list.isEmpty() || (z2 && scanSettings.getUseHardwareFilteringIfSupported())) ? false : true;
            long reportDelayMillis = scanSettings.getReportDelayMillis();
            if (reportDelayMillis > 0 && (!z || !scanSettings.getUseHardwareBatchingIfSupported())) {
                z3 = true;
            }
            this.emulateBatching = z3;
            if (z3) {
                handler.postDelayed(new Runnable() { // from class: no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat.ScanCallbackWrapper.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ScanCallbackWrapper.this.scanningStopped) {
                            return;
                        }
                        ScanCallbackWrapper.this.flushPendingScanResults();
                        handler.postDelayed(this, ScanCallbackWrapper.this.scanSettings.getReportDelayMillis());
                    }
                }, reportDelayMillis);
            }
        }

        private boolean matches(@NonNull ScanResult scanResult) {
            Iterator<ScanFilter> it = this.filters.iterator();
            while (it.hasNext()) {
                if (it.next().matches(scanResult)) {
                    return true;
                }
            }
            return false;
        }

        public void close() {
            this.scanningStopped = true;
            this.handler.removeCallbacksAndMessages(null);
            synchronized (this.LOCK) {
                this.devicesInRange.clear();
                this.devicesInBatch.clear();
                this.scanResults.clear();
            }
        }

        public void flushPendingScanResults() {
            if (!this.emulateBatching || this.scanningStopped) {
                return;
            }
            synchronized (this.LOCK) {
                this.scanCallback.onBatchScanResults(new ArrayList(this.scanResults));
                this.scanResults.clear();
                this.devicesInBatch.clear();
            }
        }

        public void handleScanError(int i) {
            this.scanCallback.onScanFailed(i);
        }

        public void handleScanResult(int i, @NonNull ScanResult scanResult) {
            boolean zIsEmpty;
            ScanResult scanResultPut;
            if (this.scanningStopped) {
                return;
            }
            if (this.filters.isEmpty() || matches(scanResult)) {
                String address = scanResult.getDevice().getAddress();
                if (!this.emulateFoundOrLostCallbackType) {
                    if (!this.emulateBatching) {
                        this.scanCallback.onScanResult(i, scanResult);
                        return;
                    }
                    synchronized (this.LOCK) {
                        if (!this.devicesInBatch.contains(address)) {
                            this.scanResults.add(scanResult);
                            this.devicesInBatch.add(address);
                        }
                    }
                    return;
                }
                synchronized (this.devicesInRange) {
                    zIsEmpty = this.devicesInRange.isEmpty();
                    scanResultPut = this.devicesInRange.put(address, scanResult);
                }
                if (scanResultPut == null && (this.scanSettings.getCallbackType() & 2) > 0) {
                    this.scanCallback.onScanResult(2, scanResult);
                }
                if (!zIsEmpty || (this.scanSettings.getCallbackType() & 4) <= 0) {
                    return;
                }
                this.handler.removeCallbacks(this.matchLostNotifierTask);
                this.handler.postDelayed(this.matchLostNotifierTask, this.scanSettings.getMatchLostTaskInterval());
            }
        }

        public void handleScanResults(@NonNull List<ScanResult> list) {
            if (this.scanningStopped) {
                return;
            }
            if (this.emulateFiltering) {
                ArrayList arrayList = new ArrayList();
                for (ScanResult scanResult : list) {
                    if (matches(scanResult)) {
                        arrayList.add(scanResult);
                    }
                }
                list = arrayList;
            }
            this.scanCallback.onBatchScanResults(list);
        }
    }

    @NonNull
    public static synchronized BluetoothLeScannerCompat getScanner() {
        BluetoothLeScannerCompat bluetoothLeScannerCompat = instance;
        if (bluetoothLeScannerCompat != null) {
            return bluetoothLeScannerCompat;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            BluetoothLeScannerImplOreo bluetoothLeScannerImplOreo = new BluetoothLeScannerImplOreo();
            instance = bluetoothLeScannerImplOreo;
            return bluetoothLeScannerImplOreo;
        }
        if (i >= 23) {
            BluetoothLeScannerImplMarshmallow bluetoothLeScannerImplMarshmallow = new BluetoothLeScannerImplMarshmallow();
            instance = bluetoothLeScannerImplMarshmallow;
            return bluetoothLeScannerImplMarshmallow;
        }
        if (i >= 21) {
            BluetoothLeScannerImplLollipop bluetoothLeScannerImplLollipop = new BluetoothLeScannerImplLollipop();
            instance = bluetoothLeScannerImplLollipop;
            return bluetoothLeScannerImplLollipop;
        }
        BluetoothLeScannerImplJB bluetoothLeScannerImplJB = new BluetoothLeScannerImplJB();
        instance = bluetoothLeScannerImplJB;
        return bluetoothLeScannerImplJB;
    }

    public abstract void flushPendingScanResults(@NonNull ScanCallback scanCallback);

    public final void startScan(@NonNull ScanCallback scanCallback) {
        if (scanCallback == null) {
            throw new IllegalArgumentException("callback is null");
        }
        startScanInternal(Collections.emptyList(), new ScanSettings.Builder().build(), scanCallback, new Handler(Looper.getMainLooper()));
    }

    public abstract void startScanInternal(@NonNull List<ScanFilter> list, @NonNull ScanSettings scanSettings, @NonNull Context context, @NonNull PendingIntent pendingIntent, int i);

    public abstract void startScanInternal(@NonNull List<ScanFilter> list, @NonNull ScanSettings scanSettings, @NonNull ScanCallback scanCallback, @NonNull Handler handler);

    public final void stopScan(@NonNull ScanCallback scanCallback) {
        if (scanCallback == null) {
            throw new IllegalArgumentException("callback is null");
        }
        stopScanInternal(scanCallback);
    }

    public abstract void stopScanInternal(@NonNull Context context, @NonNull PendingIntent pendingIntent, int i);

    public abstract void stopScanInternal(@NonNull ScanCallback scanCallback);

    public final void stopScan(@NonNull Context context, @NonNull PendingIntent pendingIntent, int i) {
        if (pendingIntent == null) {
            throw new IllegalArgumentException("callbackIntent is null");
        }
        if (context != null) {
            stopScanInternal(context, pendingIntent, i);
            return;
        }
        throw new IllegalArgumentException("context is null");
    }

    public final void startScan(@Nullable List<ScanFilter> list, @Nullable ScanSettings scanSettings, @NonNull ScanCallback scanCallback) {
        if (scanCallback != null) {
            Handler handler = new Handler(Looper.getMainLooper());
            if (list == null) {
                list = Collections.emptyList();
            }
            if (scanSettings == null) {
                scanSettings = new ScanSettings.Builder().build();
            }
            startScanInternal(list, scanSettings, scanCallback, handler);
            return;
        }
        throw new IllegalArgumentException("callback is null");
    }

    public final void stopScan(@NonNull Context context, @NonNull PendingIntent pendingIntent) {
        stopScanInternal(context, pendingIntent, 0);
    }

    public final void startScan(@Nullable List<ScanFilter> list, @Nullable ScanSettings scanSettings, @NonNull ScanCallback scanCallback, @Nullable Handler handler) {
        if (scanCallback != null) {
            if (list == null) {
                list = Collections.emptyList();
            }
            if (scanSettings == null) {
                scanSettings = new ScanSettings.Builder().build();
            }
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            startScanInternal(list, scanSettings, scanCallback, handler);
            return;
        }
        throw new IllegalArgumentException("callback is null");
    }

    public final void startScan(@Nullable List<ScanFilter> list, @Nullable ScanSettings scanSettings, @NonNull Context context, @NonNull PendingIntent pendingIntent, int i) {
        if (pendingIntent == null) {
            throw new IllegalArgumentException("callbackIntent is null");
        }
        if (context != null) {
            if (list == null) {
                list = Collections.emptyList();
            }
            List<ScanFilter> list2 = list;
            if (scanSettings == null) {
                scanSettings = new ScanSettings.Builder().build();
            }
            startScanInternal(list2, scanSettings, context, pendingIntent, i);
            return;
        }
        throw new IllegalArgumentException("context is null");
    }

    public final void startScan(@Nullable List<ScanFilter> list, @Nullable ScanSettings scanSettings, @NonNull Context context, @NonNull PendingIntent pendingIntent) {
        startScan(list, scanSettings, context, pendingIntent, 0);
    }
}
