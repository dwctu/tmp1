package no.nordicsemi.android.support.v18.scanner;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat;

@TargetApi(21)
/* loaded from: classes5.dex */
public class BluetoothLeScannerImplLollipop extends BluetoothLeScannerCompat {

    @NonNull
    private final ScanCallbackWrapperSet<ScanCallbackWrapperLollipop> wrappers = new ScanCallbackWrapperSet<>();

    public static class ScanCallbackWrapperLollipop extends BluetoothLeScannerCompat.ScanCallbackWrapper {

        @NonNull
        private final android.bluetooth.le.ScanCallback nativeCallback;

        /* renamed from: no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerImplLollipop$ScanCallbackWrapperLollipop$1, reason: invalid class name */
        public class AnonymousClass1 extends android.bluetooth.le.ScanCallback {
            private long lastBatchTimestamp;

            public AnonymousClass1() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void b(List list) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (this.lastBatchTimestamp > (jElapsedRealtime - ScanCallbackWrapperLollipop.this.scanSettings.getReportDelayMillis()) + 5) {
                    return;
                }
                this.lastBatchTimestamp = jElapsedRealtime;
                ScanCallbackWrapperLollipop.this.handleScanResults(((BluetoothLeScannerImplLollipop) BluetoothLeScannerCompat.getScanner()).fromNativeScanResults(list));
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void d(int i) {
                if (!ScanCallbackWrapperLollipop.this.scanSettings.getUseHardwareCallbackTypesIfSupported() || ScanCallbackWrapperLollipop.this.scanSettings.getCallbackType() == 1) {
                    ScanCallbackWrapperLollipop.this.handleScanError(i);
                    return;
                }
                ScanCallbackWrapperLollipop.this.scanSettings.disableUseHardwareCallbackTypes();
                BluetoothLeScannerCompat scanner = BluetoothLeScannerCompat.getScanner();
                try {
                    scanner.stopScan(ScanCallbackWrapperLollipop.this.scanCallback);
                } catch (Exception unused) {
                }
                try {
                    ScanCallbackWrapperLollipop scanCallbackWrapperLollipop = ScanCallbackWrapperLollipop.this;
                    scanner.startScanInternal(scanCallbackWrapperLollipop.filters, scanCallbackWrapperLollipop.scanSettings, scanCallbackWrapperLollipop.scanCallback, scanCallbackWrapperLollipop.handler);
                } catch (Exception unused2) {
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void f(android.bluetooth.le.ScanResult scanResult, int i) {
                ScanCallbackWrapperLollipop.this.handleScanResult(i, ((BluetoothLeScannerImplLollipop) BluetoothLeScannerCompat.getScanner()).fromNativeScanResult(scanResult));
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onBatchScanResults(final List<android.bluetooth.le.ScanResult> list) {
                ScanCallbackWrapperLollipop.this.handler.post(new Runnable() { // from class: dc.ob4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b(list);
                    }
                });
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onScanFailed(final int i) {
                ScanCallbackWrapperLollipop.this.handler.post(new Runnable() { // from class: dc.qb4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.d(i);
                    }
                });
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onScanResult(final int i, final android.bluetooth.le.ScanResult scanResult) {
                ScanCallbackWrapperLollipop.this.handler.post(new Runnable() { // from class: dc.pb4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.f(scanResult, i);
                    }
                });
            }
        }

        private ScanCallbackWrapperLollipop(boolean z, boolean z2, @NonNull List<ScanFilter> list, @NonNull ScanSettings scanSettings, @NonNull ScanCallback scanCallback, @NonNull Handler handler) {
            super(z, z2, list, scanSettings, scanCallback, handler);
            this.nativeCallback = new AnonymousClass1();
        }
    }

    @Override // no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat
    public void flushPendingScanResults(@NonNull ScanCallback scanCallback) {
        ScanCallbackWrapperLollipop scanCallbackWrapperLollipop;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (scanCallback == null) {
            throw new IllegalArgumentException("callback cannot be null!");
        }
        synchronized (this.wrappers) {
            scanCallbackWrapperLollipop = (ScanCallbackWrapperLollipop) this.wrappers.get(scanCallback);
        }
        if (scanCallbackWrapperLollipop == null) {
            throw new IllegalArgumentException("callback not registered!");
        }
        ScanSettings scanSettings = scanCallbackWrapperLollipop.scanSettings;
        if (!defaultAdapter.isOffloadedScanBatchingSupported() || !scanSettings.getUseHardwareBatchingIfSupported()) {
            scanCallbackWrapperLollipop.flushPendingScanResults();
            return;
        }
        BluetoothLeScanner bluetoothLeScanner = defaultAdapter.getBluetoothLeScanner();
        if (bluetoothLeScanner == null) {
            return;
        }
        bluetoothLeScanner.flushPendingScanResults(scanCallbackWrapperLollipop.nativeCallback);
    }

    @NonNull
    public ScanResult fromNativeScanResult(@NonNull android.bluetooth.le.ScanResult scanResult) {
        return new ScanResult(scanResult.getDevice(), ScanRecord.parseFromBytes(scanResult.getScanRecord() != null ? scanResult.getScanRecord().getBytes() : null), scanResult.getRssi(), scanResult.getTimestampNanos());
    }

    @NonNull
    public ArrayList<ScanResult> fromNativeScanResults(@NonNull List<android.bluetooth.le.ScanResult> list) {
        ArrayList<ScanResult> arrayList = new ArrayList<>();
        Iterator<android.bluetooth.le.ScanResult> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(fromNativeScanResult(it.next()));
        }
        return arrayList;
    }

    @Override // no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat
    public void startScanInternal(@NonNull List<ScanFilter> list, @NonNull ScanSettings scanSettings, @NonNull ScanCallback scanCallback, @NonNull Handler handler) {
        ScanCallbackWrapperLollipop scanCallbackWrapperLollipop;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothLeScanner bluetoothLeScanner = defaultAdapter.getBluetoothLeScanner();
        if (bluetoothLeScanner == null) {
            throw new IllegalStateException("BT le scanner not available");
        }
        boolean zIsOffloadedScanBatchingSupported = defaultAdapter.isOffloadedScanBatchingSupported();
        boolean zIsOffloadedFilteringSupported = defaultAdapter.isOffloadedFilteringSupported();
        synchronized (this.wrappers) {
            if (this.wrappers.contains(scanCallback)) {
                throw new IllegalArgumentException("scanner already started with given callback");
            }
            scanCallbackWrapperLollipop = new ScanCallbackWrapperLollipop(zIsOffloadedScanBatchingSupported, zIsOffloadedFilteringSupported, list, scanSettings, new UserScanCallbackWrapper(scanCallback), handler);
            this.wrappers.add(scanCallbackWrapperLollipop);
        }
        android.bluetooth.le.ScanSettings nativeScanSettings = toNativeScanSettings(defaultAdapter, scanSettings, false);
        ArrayList<android.bluetooth.le.ScanFilter> nativeScanFilters = null;
        if (!list.isEmpty() && zIsOffloadedFilteringSupported && scanSettings.getUseHardwareFilteringIfSupported()) {
            nativeScanFilters = toNativeScanFilters(list);
        }
        bluetoothLeScanner.startScan(nativeScanFilters, nativeScanSettings, scanCallbackWrapperLollipop.nativeCallback);
    }

    @Override // no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat
    public void stopScanInternal(@NonNull ScanCallback scanCallback) {
        ScanCallbackWrapperLollipop scanCallbackWrapperLollipop;
        BluetoothLeScanner bluetoothLeScanner;
        synchronized (this.wrappers) {
            scanCallbackWrapperLollipop = (ScanCallbackWrapperLollipop) this.wrappers.remove(scanCallback);
        }
        if (scanCallbackWrapperLollipop == null) {
            return;
        }
        scanCallbackWrapperLollipop.close();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || (bluetoothLeScanner = defaultAdapter.getBluetoothLeScanner()) == null) {
            return;
        }
        bluetoothLeScanner.stopScan(scanCallbackWrapperLollipop.nativeCallback);
    }

    @NonNull
    public android.bluetooth.le.ScanFilter toNativeScanFilter(@NonNull ScanFilter scanFilter) {
        ScanFilter.Builder builder = new ScanFilter.Builder();
        builder.setServiceUuid(scanFilter.getServiceUuid(), scanFilter.getServiceUuidMask()).setManufacturerData(scanFilter.getManufacturerId(), scanFilter.getManufacturerData(), scanFilter.getManufacturerDataMask());
        if (scanFilter.getDeviceAddress() != null) {
            builder.setDeviceAddress(scanFilter.getDeviceAddress());
        }
        if (scanFilter.getDeviceName() != null) {
            builder.setDeviceName(scanFilter.getDeviceName());
        }
        if (scanFilter.getServiceDataUuid() != null) {
            builder.setServiceData(scanFilter.getServiceDataUuid(), scanFilter.getServiceData(), scanFilter.getServiceDataMask());
        }
        return builder.build();
    }

    @NonNull
    public ArrayList<android.bluetooth.le.ScanFilter> toNativeScanFilters(@NonNull List<ScanFilter> list) {
        ArrayList<android.bluetooth.le.ScanFilter> arrayList = new ArrayList<>();
        Iterator<ScanFilter> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(toNativeScanFilter(it.next()));
        }
        return arrayList;
    }

    @NonNull
    public android.bluetooth.le.ScanSettings toNativeScanSettings(@NonNull BluetoothAdapter bluetoothAdapter, @NonNull ScanSettings scanSettings, boolean z) {
        ScanSettings.Builder builder = new ScanSettings.Builder();
        if (z || (bluetoothAdapter.isOffloadedScanBatchingSupported() && scanSettings.getUseHardwareBatchingIfSupported())) {
            builder.setReportDelay(scanSettings.getReportDelayMillis());
        }
        if (scanSettings.getScanMode() != -1) {
            builder.setScanMode(scanSettings.getScanMode());
        } else {
            builder.setScanMode(0);
        }
        scanSettings.disableUseHardwareCallbackTypes();
        return builder.build();
    }

    @Override // no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat
    public void stopScanInternal(@NonNull Context context, @NonNull PendingIntent pendingIntent, int i) {
        Intent intent = new Intent(context, (Class<?>) ScannerService.class);
        intent.putExtra("no.nordicsemi.android.support.v18.EXTRA_PENDING_INTENT", pendingIntent);
        intent.putExtra(ScannerService.EXTRA_REQUEST_CODE, i);
        intent.putExtra(ScannerService.EXTRA_START, false);
        context.startService(intent);
    }

    @Override // no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat
    public void startScanInternal(@NonNull List<ScanFilter> list, @NonNull ScanSettings scanSettings, @NonNull Context context, @NonNull PendingIntent pendingIntent, int i) {
        if (BluetoothAdapter.getDefaultAdapter().getBluetoothLeScanner() != null) {
            Intent intent = new Intent(context, (Class<?>) ScannerService.class);
            intent.putParcelableArrayListExtra("no.nordicsemi.android.support.v18.EXTRA_FILTERS", new ArrayList<>(list));
            intent.putExtra("no.nordicsemi.android.support.v18.EXTRA_SETTINGS", scanSettings);
            intent.putExtra("no.nordicsemi.android.support.v18.EXTRA_PENDING_INTENT", pendingIntent);
            intent.putExtra(ScannerService.EXTRA_REQUEST_CODE, i);
            intent.putExtra(ScannerService.EXTRA_START, true);
            context.startService(intent);
            return;
        }
        throw new IllegalStateException("BT le scanner not available");
    }
}
