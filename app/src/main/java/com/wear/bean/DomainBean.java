package com.wear.bean;

import java.util.List;

/* loaded from: classes3.dex */
public class DomainBean {
    private String ip;
    private List<IpBean> ipBeanList;
    private boolean isIpv6;

    public DomainBean(String str) {
        this.ip = str;
        this.isIpv6 = false;
        this.ipBeanList = null;
    }

    public String getIp() {
        return this.ip;
    }

    public List<IpBean> getIpBeanList() {
        return this.ipBeanList;
    }

    public boolean isIpv6() {
        return this.isIpv6;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setIpBeanList(List<IpBean> list) {
        this.ipBeanList = list;
    }

    public void setIpv6(boolean z) {
        this.isIpv6 = z;
    }

    public DomainBean(String str, boolean z, List<IpBean> list) {
        this.ipBeanList = list;
        this.ip = str;
        this.isIpv6 = z;
    }
}
