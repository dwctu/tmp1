package no.nordicsemi.android.support.v18.scanner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat;
import no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat.ScanCallbackWrapper;

/* loaded from: classes5.dex */
public class ScanCallbackWrapperSet<W extends BluetoothLeScannerCompat.ScanCallbackWrapper> {

    @NonNull
    private final Set<W> wrappers = new HashSet();

    private void cleanUp() {
        LinkedList linkedList = new LinkedList();
        for (W w : this.wrappers) {
            ScanCallback scanCallback = w.scanCallback;
            if ((scanCallback instanceof UserScanCallbackWrapper) && ((UserScanCallbackWrapper) scanCallback).isDead()) {
                linkedList.add(w);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            this.wrappers.remove((BluetoothLeScannerCompat.ScanCallbackWrapper) it.next());
        }
    }

    public void add(@NonNull W w) {
        this.wrappers.add(w);
    }

    public boolean contains(@NonNull ScanCallback scanCallback) {
        Iterator<W> it = this.wrappers.iterator();
        while (it.hasNext()) {
            ScanCallback scanCallback2 = it.next().scanCallback;
            if (scanCallback2 == scanCallback) {
                return true;
            }
            if ((scanCallback2 instanceof UserScanCallbackWrapper) && ((UserScanCallbackWrapper) scanCallback2).get() == scanCallback) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public W get(@NonNull ScanCallback scanCallback) {
        for (W w : this.wrappers) {
            ScanCallback scanCallback2 = w.scanCallback;
            if (scanCallback2 == scanCallback) {
                return w;
            }
            if ((scanCallback2 instanceof UserScanCallbackWrapper) && ((UserScanCallbackWrapper) scanCallback2).get() == scanCallback) {
                return w;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return this.wrappers.isEmpty();
    }

    @Nullable
    public W remove(@NonNull ScanCallback scanCallback) {
        for (W w : this.wrappers) {
            ScanCallback scanCallback2 = w.scanCallback;
            if (scanCallback2 == scanCallback) {
                return w;
            }
            if ((scanCallback2 instanceof UserScanCallbackWrapper) && ((UserScanCallbackWrapper) scanCallback2).get() == scanCallback) {
                this.wrappers.remove(w);
                return w;
            }
        }
        cleanUp();
        return null;
    }

    @NonNull
    public Set<W> values() {
        return this.wrappers;
    }
}
