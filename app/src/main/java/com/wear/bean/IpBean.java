package com.wear.bean;

/* loaded from: classes3.dex */
public class IpBean {
    private boolean getIpSuccess;
    private String ipAddress;
    private boolean isIpv6;
    private boolean isLinkLocalAddress;
    private boolean isLoopbackAddress;

    public IpBean(boolean z) {
        this.getIpSuccess = z;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public boolean isGetIpSuccess() {
        return this.getIpSuccess;
    }

    public boolean isIpv6() {
        return this.isIpv6;
    }

    public boolean isLinkLocalAddress() {
        return this.isLinkLocalAddress;
    }

    public boolean isLoopbackAddress() {
        return this.isLoopbackAddress;
    }

    public void setGetIpSuccess(boolean z) {
        this.getIpSuccess = z;
    }

    public void setIpAddress(String str) {
        this.ipAddress = str;
    }

    public void setIpv6(boolean z) {
        this.isIpv6 = z;
    }

    public void setLinkLocalAddress(boolean z) {
        this.isLinkLocalAddress = z;
    }

    public void setLoopbackAddress(boolean z) {
        this.isLoopbackAddress = z;
    }

    public IpBean(String str, boolean z, boolean z2, boolean z3) {
        this.getIpSuccess = true;
        this.ipAddress = str;
        this.isIpv6 = z;
        this.isLoopbackAddress = z2;
        this.isLinkLocalAddress = z3;
    }
}
