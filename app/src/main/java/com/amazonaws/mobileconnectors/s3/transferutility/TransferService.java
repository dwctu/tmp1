package com.amazonaws.mobileconnectors.s3.transferutility;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.IBinder;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Map;

/* loaded from: classes.dex */
public class TransferService extends Service {
    public static final Log d = LogFactory.b(TransferService.class);
    public static TransferNetworkLossHandler e;
    public boolean a = true;
    public int b = 3462;
    public boolean c = true;

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if ((getApplicationInfo().flags & 2) == 0) {
            return;
        }
        printWriter.printf("network status: %s\n", Boolean.valueOf(e.e()));
        Map<Integer, TransferRecord> mapE = TransferStatusUpdater.c(this).e();
        printWriter.printf("# of active transfers: %d\n", Integer.valueOf(mapE.size()));
        for (TransferRecord transferRecord : mapE.values()) {
            printWriter.printf("bucket: %s, key: %s, status: %s, total size: %d, current: %d\n", transferRecord.k, transferRecord.l, transferRecord.j, Long.valueOf(transferRecord.f), Long.valueOf(transferRecord.g));
        }
        printWriter.flush();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Can't bind to TransferService");
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log log = d;
        log.b("Starting Transfer Service to listen for network connectivity changes.");
        e = TransferNetworkLossHandler.d(getApplicationContext());
        synchronized (this) {
            if (this.a) {
                try {
                    log.b("Registering the network receiver");
                    registerReceiver(e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    this.a = false;
                } catch (IllegalArgumentException unused) {
                    d.g("Ignoring the exception trying to register the receiver for connectivity change.");
                } catch (IllegalStateException unused2) {
                    d.g("Ignoring the leak in registering the receiver.");
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:0|(2:31|2)|(6:4|d|19|20|25|26)|33|14|36) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
    
        com.amazonaws.mobileconnectors.s3.transferutility.TransferService.d.g("Exception trying to de-register the network receiver");
     */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onDestroy() {
        /*
            r4 = this;
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L18
            r1 = 26
            if (r0 < r1) goto L2f
            com.amazonaws.logging.Log r0 = com.amazonaws.mobileconnectors.s3.transferutility.TransferService.d     // Catch: java.lang.Exception -> L18
            java.lang.String r1 = "Moving the service out of the Foreground state."
            r0.b(r1)     // Catch: java.lang.Exception -> L18
            monitor-enter(r4)     // Catch: java.lang.Exception -> L18
            boolean r0 = r4.c     // Catch: java.lang.Throwable -> L15
            r4.stopForeground(r0)     // Catch: java.lang.Throwable -> L15
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L15
            goto L2f
        L15:
            r0 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L15
            throw r0     // Catch: java.lang.Exception -> L18
        L18:
            r0 = move-exception
            com.amazonaws.logging.Log r1 = com.amazonaws.mobileconnectors.s3.transferutility.TransferService.d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error in moving the service out of the foreground state: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.d(r0)
        L2f:
            com.amazonaws.logging.Log r0 = com.amazonaws.mobileconnectors.s3.transferutility.TransferService.d     // Catch: java.lang.IllegalArgumentException -> L4b
            java.lang.String r1 = "De-registering the network receiver."
            r0.b(r1)     // Catch: java.lang.IllegalArgumentException -> L4b
            monitor-enter(r4)     // Catch: java.lang.IllegalArgumentException -> L4b
            boolean r0 = r4.a     // Catch: java.lang.Throwable -> L48
            if (r0 != 0) goto L46
            com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler r0 = com.amazonaws.mobileconnectors.s3.transferutility.TransferService.e     // Catch: java.lang.Throwable -> L48
            r4.unregisterReceiver(r0)     // Catch: java.lang.Throwable -> L48
            r0 = 1
            r4.a = r0     // Catch: java.lang.Throwable -> L48
            r0 = 0
            com.amazonaws.mobileconnectors.s3.transferutility.TransferService.e = r0     // Catch: java.lang.Throwable -> L48
        L46:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L48
            goto L52
        L48:
            r0 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L48
            throw r0     // Catch: java.lang.IllegalArgumentException -> L4b
        L4b:
            com.amazonaws.logging.Log r0 = com.amazonaws.mobileconnectors.s3.transferutility.TransferService.d
            java.lang.String r1 = "Exception trying to de-register the network receiver"
            r0.g(r1)
        L52:
            super.onDestroy()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.TransferService.onDestroy():void");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                synchronized (this) {
                    Notification notification = (Notification) intent.getParcelableExtra("notification");
                    if (notification != null) {
                        this.b = intent.getIntExtra("ongoing-notification-id", this.b);
                        this.c = intent.getBooleanExtra("remove-notification", this.c);
                        d.b("Putting the service in Foreground state.");
                        startForeground(this.b, notification);
                    } else {
                        d.d("No notification is passed in the intent. Unable to transition to foreground.");
                    }
                }
            } catch (Exception e2) {
                d.d("Error in moving the service to foreground state: " + e2);
            }
            return 1;
        }
        synchronized (this) {
            if (!this.a) {
                return 1;
            }
            try {
                d.b("Registering the network receiver");
                registerReceiver(e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.a = false;
            } catch (IllegalArgumentException unused) {
                d.g("Ignoring the exception trying to register the receiver for connectivity change.");
            } catch (IllegalStateException unused2) {
                d.g("Ignoring the leak in registering the receiver.");
            }
            return 1;
        }
    }
}
