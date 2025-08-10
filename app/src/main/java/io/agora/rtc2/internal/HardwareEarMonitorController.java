package io.agora.rtc2.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import androidx.annotation.VisibleForTesting;
import io.agora.base.internal.CalledByNative;
import io.agora.base.internal.ContextUtils;

/* loaded from: classes4.dex */
public class HardwareEarMonitorController implements HardwareEarMonitorListener {
    private static final String MANUFACTURER_HUAWEI = "huawei";
    private static final String TAG = "HardwareEarMonitorController";
    private static HardwareEarMonitorController mInstance;
    private IHardwareEarMonitor mHardwareEarMonitor;
    public VolumeChangeReceiver mVolumeChangeReceiver = null;

    private HardwareEarMonitorController() {
        this.mHardwareEarMonitor = null;
        if (Build.MANUFACTURER.trim().toLowerCase().contains(MANUFACTURER_HUAWEI)) {
            this.mHardwareEarMonitor = new HuaweiHardwareEarMonitor(this);
        }
    }

    @CalledByNative
    public static synchronized void destroy() {
        HardwareEarMonitorController hardwareEarMonitorController = mInstance;
        if (hardwareEarMonitorController != null) {
            hardwareEarMonitorController.destroyImpl();
        }
        mInstance = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001e A[Catch: all -> 0x0025, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0006, B:8:0x000c, B:12:0x001a, B:14:0x001e, B:11:0x0013), top: B:20:0x0001, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void destroyImpl() {
        /*
            r4 = this;
            monitor-enter(r4)
            android.content.Context r0 = io.agora.base.internal.ContextUtils.getApplicationContext()     // Catch: java.lang.Throwable -> L25
            r1 = 0
            io.agora.rtc2.internal.VolumeChangeReceiver r2 = r4.mVolumeChangeReceiver     // Catch: java.lang.Exception -> L12 java.lang.Throwable -> L25
            if (r2 == 0) goto L1a
            if (r0 == 0) goto L1a
            r0.unregisterReceiver(r2)     // Catch: java.lang.Exception -> L12 java.lang.Throwable -> L25
            r4.mVolumeChangeReceiver = r1     // Catch: java.lang.Exception -> L12 java.lang.Throwable -> L25
            goto L1a
        L12:
            r0 = move-exception
            java.lang.String r2 = io.agora.rtc2.internal.HardwareEarMonitorController.TAG     // Catch: java.lang.Throwable -> L25
            java.lang.String r3 = "unregister VolumeChangeReceiver failed "
            io.agora.rtc2.internal.Logging.e(r2, r3, r0)     // Catch: java.lang.Throwable -> L25
        L1a:
            io.agora.rtc2.internal.IHardwareEarMonitor r0 = r4.mHardwareEarMonitor     // Catch: java.lang.Throwable -> L25
            if (r0 == 0) goto L23
            r0.destroy()     // Catch: java.lang.Throwable -> L25
            r4.mHardwareEarMonitor = r1     // Catch: java.lang.Throwable -> L25
        L23:
            monitor-exit(r4)
            return
        L25:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc2.internal.HardwareEarMonitorController.destroyImpl():void");
    }

    @CalledByNative
    public static synchronized HardwareEarMonitorController getInstance() {
        if (mInstance == null) {
            mInstance = new HardwareEarMonitorController();
        }
        return mInstance;
    }

    @CalledByNative
    public synchronized int enableHardwareEarMonitor(boolean z) {
        IHardwareEarMonitor iHardwareEarMonitor = this.mHardwareEarMonitor;
        if (iHardwareEarMonitor == null) {
            return -7;
        }
        return iHardwareEarMonitor.enableHardwareEarMonitor(z);
    }

    @CalledByNative
    public synchronized void initialize() {
        IHardwareEarMonitor iHardwareEarMonitor = this.mHardwareEarMonitor;
        if (iHardwareEarMonitor != null) {
            iHardwareEarMonitor.initialize();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000d  */
    @io.agora.base.internal.CalledByNative
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isHardwareEarMonitorSupported() {
        /*
            r1 = this;
            monitor-enter(r1)
            io.agora.rtc2.internal.IHardwareEarMonitor r0 = r1.mHardwareEarMonitor     // Catch: java.lang.Throwable -> L10
            if (r0 == 0) goto Ld
            boolean r0 = r0.isHardwareEarMonitorSupported()     // Catch: java.lang.Throwable -> L10
            if (r0 == 0) goto Ld
            r0 = 1
            goto Le
        Ld:
            r0 = 0
        Le:
            monitor-exit(r1)
            return r0
        L10:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc2.internal.HardwareEarMonitorController.isHardwareEarMonitorSupported():boolean");
    }

    @Override // io.agora.rtc2.internal.HardwareEarMonitorListener
    public synchronized void onInitSuccess() {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        try {
            this.mVolumeChangeReceiver = new VolumeChangeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(VolumeChangeReceiver.ACTION_VOLUME_CHANGED);
            applicationContext.registerReceiver(this.mVolumeChangeReceiver, intentFilter);
        } catch (Exception e) {
            Logging.e(TAG, "Unable to create VolumeChangeReceiver, ", e);
        }
    }

    @VisibleForTesting
    public void setHardwareEarMonitor(IHardwareEarMonitor iHardwareEarMonitor) {
        this.mHardwareEarMonitor = iHardwareEarMonitor;
    }

    @CalledByNative
    public synchronized int setHardwareEarMonitorVolume(int i) {
        IHardwareEarMonitor iHardwareEarMonitor = this.mHardwareEarMonitor;
        if (iHardwareEarMonitor == null) {
            return -7;
        }
        return iHardwareEarMonitor.setHardwareEarMonitorVolume(i);
    }
}
