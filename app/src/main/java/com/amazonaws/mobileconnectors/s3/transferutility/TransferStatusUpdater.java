package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class TransferStatusUpdater {
    public static final Log c = LogFactory.b(TransferStatusUpdater.class);
    public static final HashSet<TransferState> d = new HashSet<>(Arrays.asList(TransferState.PART_COMPLETED, TransferState.PENDING_CANCEL, TransferState.PENDING_PAUSE, TransferState.PENDING_NETWORK_DISCONNECT));
    public static final Map<Integer, List<TransferListener>> e = new ConcurrentHashMap<Integer, List<TransferListener>>() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.1
    };
    public static TransferDBUtil f;
    public static TransferStatusUpdater g;
    public final Map<Integer, TransferRecord> a;
    public final Handler b;

    public class TransferProgressListener implements ProgressListener {
        public final TransferRecord a;
        public long b;

        public TransferProgressListener(TransferRecord transferRecord) {
            this.a = transferRecord;
        }

        @Override // com.amazonaws.event.ProgressListener
        public synchronized void a(ProgressEvent progressEvent) {
            if (32 == progressEvent.b()) {
                TransferStatusUpdater.c.b("Reset Event triggered. Resetting the bytesCurrent to 0.");
                this.b = 0L;
            } else {
                long jA = this.b + progressEvent.a();
                this.b = jA;
                TransferRecord transferRecord = this.a;
                if (jA > transferRecord.g) {
                    transferRecord.g = jA;
                    TransferStatusUpdater.this.k(transferRecord.a, jA, transferRecord.f, true);
                }
            }
        }
    }

    public TransferStatusUpdater(TransferDBUtil transferDBUtil, Context context) {
        f = transferDBUtil;
        this.b = new Handler(Looper.getMainLooper());
        this.a = new ConcurrentHashMap();
    }

    public static synchronized TransferStatusUpdater c(Context context) {
        if (g == null) {
            TransferDBUtil transferDBUtil = new TransferDBUtil(context);
            f = transferDBUtil;
            g = new TransferStatusUpdater(transferDBUtil, context);
        }
        return g;
    }

    public static void g(int i, TransferListener transferListener) {
        if (transferListener == null) {
            throw new IllegalArgumentException("Listener can't be null");
        }
        Map<Integer, List<TransferListener>> map = e;
        synchronized (map) {
            List<TransferListener> list = map.get(Integer.valueOf(i));
            if (list == null) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                copyOnWriteArrayList.add(transferListener);
                map.put(Integer.valueOf(i), copyOnWriteArrayList);
            } else if (!list.contains(transferListener)) {
                list.add(transferListener);
            }
        }
    }

    public static void j(int i, TransferListener transferListener) {
        if (transferListener == null) {
            throw new IllegalArgumentException("Listener can't be null");
        }
        Map<Integer, List<TransferListener>> map = e;
        synchronized (map) {
            List<TransferListener> list = map.get(Integer.valueOf(i));
            if (list != null && !list.isEmpty()) {
                list.remove(transferListener);
            }
        }
    }

    public synchronized void b(TransferRecord transferRecord) {
        this.a.put(Integer.valueOf(transferRecord.a), transferRecord);
    }

    public synchronized TransferRecord d(int i) {
        return this.a.get(Integer.valueOf(i));
    }

    public synchronized Map<Integer, TransferRecord> e() {
        return Collections.unmodifiableMap(this.a);
    }

    public synchronized ProgressListener f(int i) {
        TransferRecord transferRecordD;
        transferRecordD = d(i);
        if (transferRecordD == null) {
            c.b("TransferStatusUpdater doesn't track the transfer: " + i);
            throw new IllegalArgumentException("transfer " + i + " doesn't exist");
        }
        c.b("Creating a new progress listener for transfer: " + i);
        return new TransferProgressListener(transferRecordD);
    }

    public synchronized void h(int i) {
        TransferRecord transferRecordJ = f.j(i);
        if (transferRecordJ != null) {
            String str = transferRecordJ.m;
            if (new File(str).getName().startsWith("aws-s3-d861b25a-1edf-11eb-adc1-0242ac120002")) {
                new File(str).delete();
            }
        }
        S3ClientReference.c(Integer.valueOf(i));
        f.c(i);
    }

    public void i(final int i, final Exception exc) {
        Map<Integer, List<TransferListener>> map = e;
        synchronized (map) {
            List<TransferListener> list = map.get(Integer.valueOf(i));
            if (list != null && !list.isEmpty()) {
                for (final TransferListener transferListener : list) {
                    this.b.post(new Runnable(this) { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.4
                        @Override // java.lang.Runnable
                        public void run() {
                            transferListener.c(i, exc);
                        }
                    });
                }
            }
        }
    }

    public synchronized void k(final int i, final long j, final long j2, boolean z) {
        TransferRecord transferRecord = this.a.get(Integer.valueOf(i));
        if (transferRecord != null) {
            transferRecord.g = j;
            transferRecord.f = j2;
        }
        f.p(i, j);
        if (z) {
            Map<Integer, List<TransferListener>> map = e;
            synchronized (map) {
                List<TransferListener> list = map.get(Integer.valueOf(i));
                if (list != null && !list.isEmpty()) {
                    for (Iterator<TransferListener> it = list.iterator(); it.hasNext(); it = it) {
                        final TransferListener next = it.next();
                        this.b.post(new Runnable(this) { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.3
                            @Override // java.lang.Runnable
                            public void run() {
                                next.b(i, j, j2);
                            }
                        });
                    }
                }
            }
        }
    }

    public synchronized void l(final int i, final TransferState transferState) {
        boolean zContains = d.contains(transferState);
        TransferRecord transferRecord = this.a.get(Integer.valueOf(i));
        if (transferRecord != null) {
            zContains |= transferState.equals(transferRecord.j);
            transferRecord.j = transferState;
            if (f.t(transferRecord) == 0) {
                c.g("Failed to update the status of transfer " + i);
            }
        } else if (f.s(i, transferState) == 0) {
            c.g("Failed to update the status of transfer " + i);
        }
        if (zContains) {
            return;
        }
        if (TransferState.COMPLETED.equals(transferState)) {
            h(i);
        }
        Map<Integer, List<TransferListener>> map = e;
        synchronized (map) {
            List<TransferListener> list = map.get(Integer.valueOf(i));
            if (list != null && !list.isEmpty()) {
                for (final TransferListener transferListener : list) {
                    if (transferListener instanceof TransferObserver.TransferStatusListener) {
                        transferListener.a(i, transferState);
                    } else {
                        this.b.post(new Runnable(this) { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.2
                            @Override // java.lang.Runnable
                            public void run() {
                                transferListener.a(i, transferState);
                            }
                        });
                    }
                }
                if (TransferState.isFinalState(transferState)) {
                    list.clear();
                }
            }
        }
    }
}
