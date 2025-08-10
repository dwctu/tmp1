package no.nordicsemi.android.support.v18.scanner;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class PendingIntentExecutor extends ScanCallback {

    @NonNull
    private final PendingIntent callbackIntent;

    @Nullable
    private Context context;
    private long lastBatchTimestamp;
    private final long reportDelay;

    @Nullable
    private Context service;

    public PendingIntentExecutor(@NonNull PendingIntent pendingIntent, @NonNull ScanSettings scanSettings) {
        this.callbackIntent = pendingIntent;
        this.reportDelay = scanSettings.getReportDelayMillis();
    }

    @Override // no.nordicsemi.android.support.v18.scanner.ScanCallback
    public void onBatchScanResults(@NonNull List<ScanResult> list) throws PendingIntent.CanceledException {
        Context context = this.context;
        if (context == null) {
            context = this.service;
        }
        if (context == null) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.lastBatchTimestamp > (jElapsedRealtime - this.reportDelay) + 5) {
            return;
        }
        this.lastBatchTimestamp = jElapsedRealtime;
        try {
            Intent intent = new Intent();
            intent.putExtra(BluetoothLeScannerCompat.EXTRA_CALLBACK_TYPE, 1);
            intent.putParcelableArrayListExtra(BluetoothLeScannerCompat.EXTRA_LIST_SCAN_RESULT, new ArrayList<>(list));
            intent.setExtrasClassLoader(ScanResult.class.getClassLoader());
            this.callbackIntent.send(context, 0, intent);
        } catch (PendingIntent.CanceledException unused) {
        }
    }

    @Override // no.nordicsemi.android.support.v18.scanner.ScanCallback
    public void onScanFailed(int i) throws PendingIntent.CanceledException {
        Context context = this.context;
        if (context == null) {
            context = this.service;
        }
        if (context == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.putExtra(BluetoothLeScannerCompat.EXTRA_ERROR_CODE, i);
            this.callbackIntent.send(context, 0, intent);
        } catch (PendingIntent.CanceledException unused) {
        }
    }

    @Override // no.nordicsemi.android.support.v18.scanner.ScanCallback
    public void onScanResult(int i, @NonNull ScanResult scanResult) throws PendingIntent.CanceledException {
        Context context = this.context;
        if (context == null) {
            context = this.service;
        }
        if (context == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.putExtra(BluetoothLeScannerCompat.EXTRA_CALLBACK_TYPE, i);
            intent.putParcelableArrayListExtra(BluetoothLeScannerCompat.EXTRA_LIST_SCAN_RESULT, new ArrayList<>(Collections.singletonList(scanResult)));
            this.callbackIntent.send(context, 0, intent);
        } catch (PendingIntent.CanceledException unused) {
        }
    }

    public void setTemporaryContext(@Nullable Context context) {
        this.context = context;
    }

    public PendingIntentExecutor(@NonNull PendingIntent pendingIntent, @NonNull ScanSettings scanSettings, @NonNull Service service) {
        this.callbackIntent = pendingIntent;
        this.reportDelay = scanSettings.getReportDelayMillis();
        this.service = service;
    }
}
