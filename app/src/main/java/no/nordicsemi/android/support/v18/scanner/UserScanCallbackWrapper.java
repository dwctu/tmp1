package no.nordicsemi.android.support.v18.scanner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes5.dex */
public class UserScanCallbackWrapper extends ScanCallback {
    private final WeakReference<ScanCallback> weakScanCallback;

    public UserScanCallbackWrapper(@NonNull ScanCallback scanCallback) {
        this.weakScanCallback = new WeakReference<>(scanCallback);
    }

    @Nullable
    public ScanCallback get() {
        return this.weakScanCallback.get();
    }

    public boolean isDead() {
        return this.weakScanCallback.get() == null;
    }

    @Override // no.nordicsemi.android.support.v18.scanner.ScanCallback
    public void onBatchScanResults(@NonNull List<ScanResult> list) {
        ScanCallback scanCallback = this.weakScanCallback.get();
        if (scanCallback != null) {
            scanCallback.onBatchScanResults(list);
        }
    }

    @Override // no.nordicsemi.android.support.v18.scanner.ScanCallback
    public void onScanFailed(int i) {
        ScanCallback scanCallback = this.weakScanCallback.get();
        if (scanCallback != null) {
            scanCallback.onScanFailed(i);
        }
    }

    @Override // no.nordicsemi.android.support.v18.scanner.ScanCallback
    public void onScanResult(int i, @NonNull ScanResult scanResult) {
        ScanCallback scanCallback = this.weakScanCallback.get();
        if (scanCallback != null) {
            scanCallback.onScanResult(i, scanResult);
        }
    }
}
