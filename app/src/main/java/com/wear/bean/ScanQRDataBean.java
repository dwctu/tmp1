package com.wear.bean;

import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.wear.util.WearUtils;
import dc.db2;
import dc.kf2;
import dc.nf3;
import dc.pc1;
import dc.ye3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes3.dex */
public class ScanQRDataBean {
    private String busiType;
    private String callback;
    private String heart;
    private String platform;
    private Timer reportTimer;
    private String uid;
    private String uname;
    private String utoken;

    private void getCallBackJson(Map<String, Object> map) {
        Object obj;
        String lowerCase;
        try {
            map.put("uid", this.uid);
            map.put("utoken", this.utoken);
            DomainBean domainBeanV = WearUtils.V();
            if (domainBeanV != null) {
                String ip = domainBeanV.getIp();
                if (domainBeanV.isIpv6()) {
                    obj = "v6-" + ip.replace(SignatureImpl.INNER_SEP, Constants.FILENAME_SEQUENCE_SEPARATOR) + WearUtils.q0();
                } else {
                    obj = ip.replace(".", Constants.FILENAME_SEQUENCE_SEPARATOR) + WearUtils.q0();
                }
            } else {
                obj = "";
            }
            map.put("domain", obj);
            map.put("httpPort", "" + kf2.m().o());
            map.put("wsPort", "" + kf2.m().o());
            map.put("httpsPort", "" + kf2.m().p());
            map.put("wssPort", "" + kf2.m().p());
            map.put("platform", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
            map.put("appType", "remote");
            map.put("version", SyncWsProtocol.CONTROL_SYNC_TYPE_KEY);
            map.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, WearUtils.q);
            HashMap map2 = new HashMap();
            pc1 pc1VarG = WearUtils.x.G();
            Iterator<Toy> it = pc1VarG.o().iterator();
            while (it.hasNext()) {
                Toy next = it.next();
                if (next.isSelect()) {
                    HashMap map3 = new HashMap();
                    String deviceType = next.getDeviceType();
                    int i = 0;
                    if (WearUtils.e1(deviceType) || deviceType.split(SignatureImpl.INNER_SEP).length != 3) {
                        lowerCase = "";
                    } else {
                        lowerCase = next.getDeviceType().split(SignatureImpl.INNER_SEP)[2].toLowerCase();
                        if (lowerCase.endsWith(";")) {
                            lowerCase = lowerCase.substring(0, lowerCase.length() - 1);
                        }
                    }
                    map3.put(TtmlNode.ATTR_ID, lowerCase);
                    map3.put("name", next.getType());
                    map3.put("nickName", WearUtils.e1(next.getDefineRename()) ? "" : next.getDefineRename());
                    int i2 = (next.isVirtualToy() && next.isSelect()) ? 1 : -1;
                    if (i2 != -1) {
                        i = i2;
                    } else if (pc1VarG.a(next.getAddress())) {
                        i = 1;
                    }
                    map3.put("status", Integer.valueOf(i));
                    map2.put(lowerCase, map3);
                }
            }
            map.put("toys", map2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getNewCallBackJson(Map<String, Object> map) {
        Object obj;
        String lowerCase;
        try {
            map.put("deviceCode", ye3.x().substring(ye3.x().length() - 6));
            map.put(CustomTabsCallback.ONLINE_EXTRAS_KEY, Boolean.valueOf(db2.A().b.l()));
            DomainBean domainBeanV = WearUtils.V();
            if (domainBeanV != null) {
                String ip = domainBeanV.getIp();
                if (domainBeanV.isIpv6()) {
                    obj = "v6-" + ip.replace(SignatureImpl.INNER_SEP, Constants.FILENAME_SEQUENCE_SEPARATOR) + WearUtils.q0();
                } else {
                    obj = ip.replace(".", Constants.FILENAME_SEQUENCE_SEPARATOR) + WearUtils.q0();
                }
            } else {
                obj = "";
            }
            map.put("domain", obj);
            map.put("httpsPort", Integer.valueOf(kf2.m().p()));
            map.put("wssPort", Integer.valueOf(kf2.m().p()));
            map.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, WearUtils.q);
            map.put("platform", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
            map.put("appType", "remote");
            ArrayList arrayList = new ArrayList();
            Iterator<Toy> it = WearUtils.x.G().o().iterator();
            while (it.hasNext()) {
                Toy next = it.next();
                if (next.isSelect()) {
                    HashMap map2 = new HashMap();
                    String deviceType = next.getDeviceType();
                    if (WearUtils.e1(deviceType) || deviceType.split(SignatureImpl.INNER_SEP).length != 3) {
                        lowerCase = "";
                    } else {
                        lowerCase = next.getDeviceType().split(SignatureImpl.INNER_SEP)[2].toLowerCase();
                        if (lowerCase.endsWith(";")) {
                            lowerCase = lowerCase.substring(0, lowerCase.length() - 1);
                        }
                    }
                    map2.put(TtmlNode.ATTR_ID, lowerCase);
                    map2.put("name", next.getSimpleName());
                    map2.put("toyType", next.getType());
                    map2.put("nickname", WearUtils.e1(next.getDefineRename()) ? "" : next.getDefineRename());
                    map2.put("hVersion", next.getGenerationVersion());
                    map2.put("fVersion", next.getVersion());
                    map2.put("battery", Integer.valueOf(next.getBattery() <= 0 ? -1 : next.getBattery()));
                    map2.put("connected", Boolean.valueOf(next.isConnected()));
                    arrayList.add(map2);
                }
            }
            map.put("toyList", arrayList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createAutoReportToService(int i) {
        onCancelReportToService();
        Timer timer = new Timer();
        this.reportTimer = timer;
        timer.schedule(new TimerTask() { // from class: com.wear.bean.ScanQRDataBean.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ScanQRDataBean.this.reportToService();
            }
        }, 0L, i * 1000);
    }

    public String getBusiType() {
        return this.busiType;
    }

    public String getCallback() {
        return this.callback;
    }

    public String getHeart() {
        return this.heart;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getTransPf() {
        String str = this.platform;
        return TextUtils.equals(str, "flash") ? "your tips" : str;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUname() {
        return this.uname;
    }

    public String getUtoken() {
        return this.utoken;
    }

    public void onCancelReportToService() {
        Timer timer = this.reportTimer;
        if (timer != null) {
            timer.cancel();
            this.reportTimer = null;
        }
    }

    public void reportToService() {
        HashMap map = new HashMap();
        String str = this.callback;
        if (WearUtils.e1(this.busiType) || !this.busiType.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
            getCallBackJson(map);
        } else {
            getNewCallBackJson(map);
        }
        StringBuilder sb = new StringBuilder();
        Timer timer = this.reportTimer;
        sb.append(timer == null ? "" : timer.toString());
        sb.append(" ");
        sb.append(map.toString());
        sb.toString();
        if (WearUtils.e1(str)) {
            return;
        }
        String str2 = "回调数据给开发者：data=" + WearUtils.A.toJson(map);
        nf3.c(str, WearUtils.A.toJson(map), this.busiType, new nf3.d() { // from class: com.wear.bean.ScanQRDataBean.2
            @Override // dc.nf3.d
            public void onRequestComplete(String str3) {
            }
        });
    }

    public void send3dxConnectStartLog() {
        String str;
        String lowerCase;
        HashMap map = new HashMap();
        try {
            map.put("uid", this.uid);
            map.put("utoken", this.utoken);
            DomainBean domainBeanV = WearUtils.V();
            if (domainBeanV != null) {
                String ip = domainBeanV.getIp();
                if (domainBeanV.isIpv6()) {
                    str = "v6-" + ip.replace(SignatureImpl.INNER_SEP, Constants.FILENAME_SEQUENCE_SEPARATOR) + WearUtils.q0();
                } else {
                    str = ip.replace(".", Constants.FILENAME_SEQUENCE_SEPARATOR) + WearUtils.q0();
                }
            } else {
                str = "";
            }
            String str2 = "reportToService: domain=" + str;
            map.put("domain", str);
            map.put("httpPort", "" + kf2.m().o());
            map.put("wsPort", "" + kf2.m().o());
            map.put("httpsPort", "" + kf2.m().p());
            map.put("wssPort", "" + kf2.m().p());
            map.put("platform", this.platform);
            map.put("appType", "remote");
            map.put("version", SyncWsProtocol.CONTROL_SYNC_TYPE_KEY);
            map.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, WearUtils.q);
            HashMap map2 = new HashMap();
            pc1 pc1VarG = WearUtils.x.G();
            Iterator<Toy> it = pc1VarG.o().iterator();
            while (it.hasNext()) {
                Toy next = it.next();
                if (next.isSelect()) {
                    HashMap map3 = new HashMap();
                    String deviceType = next.getDeviceType();
                    int i = 0;
                    if (WearUtils.e1(deviceType) || deviceType.split(SignatureImpl.INNER_SEP).length != 3) {
                        lowerCase = "";
                    } else {
                        lowerCase = next.getDeviceType().split(SignatureImpl.INNER_SEP)[2].toLowerCase();
                        if (lowerCase.endsWith(";")) {
                            lowerCase = lowerCase.substring(0, lowerCase.length() - 1);
                        }
                    }
                    map3.put(TtmlNode.ATTR_ID, lowerCase);
                    map3.put("name", next.getType());
                    map3.put("nickName", WearUtils.e1(next.getDefineRename()) ? "" : next.getDefineRename());
                    int i2 = (next.isVirtualToy() && next.isSelect()) ? 1 : -1;
                    if (i2 != -1) {
                        i = i2;
                    } else if (pc1VarG.a(next.getAddress())) {
                        i = 1;
                    }
                    map3.put("status", Integer.valueOf(i));
                    map2.put(lowerCase, map3);
                }
            }
            map.put("toys", map2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ye3.d("X0004", WearUtils.A.toJson(map));
    }

    public void send3dxConnectStop() {
        String lowerCase;
        HashMap map = new HashMap();
        try {
            map.put("userId", this.uid);
            map.put("platform", this.platform);
            HashMap map2 = new HashMap();
            pc1 pc1VarG = WearUtils.x.G();
            Iterator<Toy> it = pc1VarG.o().iterator();
            while (it.hasNext()) {
                Toy next = it.next();
                if (next.isSelect()) {
                    HashMap map3 = new HashMap();
                    String deviceType = next.getDeviceType();
                    int i = 0;
                    String defineRename = "";
                    if (WearUtils.e1(deviceType) || deviceType.split(SignatureImpl.INNER_SEP).length != 3) {
                        lowerCase = "";
                    } else {
                        lowerCase = next.getDeviceType().split(SignatureImpl.INNER_SEP)[2].toLowerCase();
                        if (lowerCase.endsWith(";")) {
                            lowerCase = lowerCase.substring(0, lowerCase.length() - 1);
                        }
                    }
                    map3.put(TtmlNode.ATTR_ID, lowerCase);
                    map3.put("name", next.getType());
                    if (!WearUtils.e1(next.getDefineRename())) {
                        defineRename = next.getDefineRename();
                    }
                    map3.put("nickName", defineRename);
                    int i2 = (next.isVirtualToy() && next.isSelect()) ? 1 : -1;
                    if (i2 != -1) {
                        i = i2;
                    } else if (pc1VarG.a(next.getAddress())) {
                        i = 1;
                    }
                    map3.put("status", Integer.valueOf(i));
                    map2.put(lowerCase, map3);
                }
            }
            map.put("toys", map2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ye3.d("X0006", WearUtils.A.toJson(map));
    }

    public void setBusiType(String str) {
        this.busiType = str;
    }

    public void setCallback(String str) {
        this.callback = str;
    }

    public void setHeart(String str) {
        this.heart = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUname(String str) {
        this.uname = str;
    }

    public void setUtoken(String str) {
        this.utoken = str;
    }
}
