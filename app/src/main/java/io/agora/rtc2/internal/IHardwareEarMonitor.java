package io.agora.rtc2.internal;

/* loaded from: classes4.dex */
public interface IHardwareEarMonitor {
    void destroy();

    int enableHardwareEarMonitor(boolean z);

    void initialize();

    boolean isHardwareEarMonitorSupported();

    int setHardwareEarMonitorVolume(int i);
}
