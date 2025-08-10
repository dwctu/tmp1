package com.wear.bean;

import com.wear.network.presenter.bean.BackupXmppUrlsBean;
import com.wear.network.presenter.bean.RecommendXmppUrlsBean;
import com.wear.util.WearUtils;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class LoginLogBean {
    private boolean autoLogin;
    private List<BackupXmppUrlsBean> backupXmppUrls;
    private int currentPort;
    private String currentUrl;
    private long endTime;
    private String errorMessage;
    private String netType;
    private List<RecommendXmppUrlsBean> recommendXmppUrls;
    private long startTime;
    private String tTime;
    private int urlType;
    private int loginResult = 0;
    private long gStartTime = -1;
    private long gSuccessTime = -1;
    private long gErrorTime = -1;
    private long lUStartTime = -1;
    private long lUSuccessTime = -1;
    private long lUErrorTime = -1;
    private long xCStartTime = -1;
    private long xCSuccessTime = -1;
    private long xCErrorTime = -1;
    private long xASuccessTime = -1;
    private long xAErrorTime = -1;
    private long gtTime = -1;
    private long luTime = -1;
    private long xcTime = -1;
    private long xaTime = -1;

    public static String keepTwoDecimalPlaces(double d) {
        return new DecimalFormat("0.00").format(d);
    }

    public void clear() {
        setCurrentUrl("");
        setCurrentPort(443);
        setUrlType(0);
        setNetType(null);
        setAutoLogin(false);
        setGStartTime(-1L);
        setGSuccessTime(-1L);
        setGErrorTime(-1L);
        setLUStartTime(-1L);
        setLUSuccessTime(-1L);
        setLUErrorTime(-1L);
        setXCStartTime(-1L);
        setXCSuccessTime(-1L);
        setXCErrorTime(-1L);
        setXASuccessTime(-1L);
        setXCErrorTime(-1L);
        settTime(null);
        setGtTime(-1L);
        setLuTime(-1L);
        setXcTime(-1L);
        setXaTime(-1L);
        setLoginResult(0);
        setStartTime(-1L);
        setEndTime(-1L);
    }

    public List<BackupXmppUrlsBean> getBackupXmppUrls() {
        return this.backupXmppUrls;
    }

    public int getCurrentPort() {
        return this.currentPort;
    }

    public String getCurrentUrl() {
        return this.currentUrl;
    }

    public double getDoule(long j) {
        return j / 1000.0d;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public long getGErrorTime() {
        return this.gErrorTime;
    }

    public long getGStartTime() {
        return this.gStartTime;
    }

    public long getGSuccessTime() {
        return this.gSuccessTime;
    }

    public long getGtTime() {
        return this.gtTime;
    }

    public long getLUErrorTime() {
        return this.lUErrorTime;
    }

    public long getLUStartTime() {
        return this.lUStartTime;
    }

    public long getLUSuccessTime() {
        return this.lUSuccessTime;
    }

    public Map<String, Object> getLog() {
        HashMap map = new HashMap();
        map.put("currentUrl", getCurrentUrl());
        HashMap map2 = new HashMap();
        map2.put("total", gettTime());
        map2.put("gtoken", Long.valueOf(getGtTime()));
        map2.put("loadUserinfo", Long.valueOf(getLuTime()));
        map2.put("xmppConnect", Long.valueOf(getXcTime()));
        map2.put("xmppAuth", Long.valueOf(getXaTime()));
        map.put("times", map2);
        map.put("netType", getNetType());
        map.put("autoLogin", Boolean.valueOf(isAutoLogin()));
        map.put("recommendXmppUrls", getRecommendXmppUrls());
        map.put("backupXmppUrls", getBackupXmppUrls());
        map.put("X", WearUtils.H);
        map.put("Y", WearUtils.I);
        return map;
    }

    public int getLoginResult() {
        return this.loginResult;
    }

    public long getLuTime() {
        return this.luTime;
    }

    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        if (this.loginResult == 0) {
            sb.append("登录失败");
        } else {
            sb.append("登录成功");
        }
        sb.append("，gToken:");
        sb.append(getGtTime());
        sb.append("，userInfo:");
        sb.append(getLuTime());
        sb.append("，xmppConnect:");
        sb.append(getXcTime());
        sb.append("，xmppLogin:");
        sb.append(getXaTime());
        sb.append("，登陆总:");
        sb.append(gettTime());
        return sb.toString();
    }

    public String getNetType() {
        return this.netType;
    }

    public List<RecommendXmppUrlsBean> getRecommendXmppUrls() {
        return this.recommendXmppUrls;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getUrlType() {
        return this.urlType;
    }

    public long getXAErrorTime() {
        return this.xAErrorTime;
    }

    public long getXASuccessTime() {
        return this.xASuccessTime;
    }

    public long getXCErrorTime() {
        return this.xCErrorTime;
    }

    public long getXCStartTime() {
        return this.xCStartTime;
    }

    public long getXCSuccessTime() {
        return this.xCSuccessTime;
    }

    public long getXaTime() {
        return this.xaTime;
    }

    public long getXcTime() {
        return this.xcTime;
    }

    public String gettTime() {
        return this.tTime;
    }

    public boolean isAutoLogin() {
        return this.autoLogin;
    }

    public void put(int i, long j) {
        try {
            String str = "put: " + i + "    " + System.currentTimeMillis();
            switch (i) {
                case 1:
                    setGStartTime(j);
                    break;
                case 2:
                    setGSuccessTime(j);
                    if (getGStartTime() != -1) {
                        setGtTime(j - getGStartTime());
                        break;
                    }
                    break;
                case 3:
                    setGErrorTime(j);
                    if (getGStartTime() != -1) {
                        setGtTime(j - getGStartTime());
                        break;
                    }
                    break;
                case 4:
                    setLUStartTime(j);
                    break;
                case 5:
                    setLUSuccessTime(j);
                    if (getLUStartTime() != -1) {
                        setLuTime(j - getLUStartTime());
                        break;
                    }
                    break;
                case 6:
                    setLUErrorTime(j);
                    if (getLUStartTime() != -1) {
                        setLuTime(j - getLUStartTime());
                        break;
                    }
                    break;
                case 7:
                    setXCStartTime(j);
                    break;
                case 8:
                    setXCSuccessTime(j);
                    if (getXCStartTime() != -1) {
                        setXcTime(j - getXCStartTime());
                        break;
                    }
                    break;
                case 9:
                    setXCErrorTime(j);
                    if (getXCStartTime() != -1) {
                        setXcTime(j - getXCStartTime());
                        break;
                    }
                    break;
                case 11:
                    setXASuccessTime(j);
                    if (getXCSuccessTime() != -1) {
                        setXaTime(j - getXCSuccessTime());
                        break;
                    }
                    break;
                case 12:
                    setXAErrorTime(j);
                    if (getXCSuccessTime() != -1) {
                        setXaTime(j - getXCSuccessTime());
                        break;
                    }
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAutoLogin(boolean z) {
        this.autoLogin = z;
    }

    public void setBackupXmppUrls(List<BackupXmppUrlsBean> list) {
        this.backupXmppUrls = list;
    }

    public void setCurrentPort(int i) {
        this.currentPort = i;
    }

    public void setCurrentUrl(String str) {
        this.currentUrl = str;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setGErrorTime(long j) {
        this.gErrorTime = j;
    }

    public void setGStartTime(long j) {
        this.gStartTime = j;
    }

    public void setGSuccessTime(long j) {
        this.gSuccessTime = j;
    }

    public void setGtTime(long j) {
        this.gtTime = j;
    }

    public void setLUErrorTime(long j) {
        this.lUErrorTime = j;
    }

    public void setLUStartTime(long j) {
        this.lUStartTime = j;
    }

    public void setLUSuccessTime(long j) {
        this.lUSuccessTime = j;
    }

    public void setLoginResult(int i) {
        this.loginResult = i;
    }

    public void setLuTime(long j) {
        this.luTime = j;
    }

    public void setNetType(String str) {
        this.netType = str;
    }

    public void setRecommendXmppUrls(List<RecommendXmppUrlsBean> list) {
        this.recommendXmppUrls = list;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public void setUrlType(int i) {
        this.urlType = i;
    }

    public void setXAErrorTime(long j) {
        this.xAErrorTime = j;
    }

    public void setXASuccessTime(long j) {
        this.xASuccessTime = j;
    }

    public void setXCErrorTime(long j) {
        this.xCErrorTime = j;
    }

    public void setXCStartTime(long j) {
        this.xCStartTime = j;
    }

    public void setXCSuccessTime(long j) {
        this.xCSuccessTime = j;
    }

    public void setXaTime(long j) {
        this.xaTime = j;
    }

    public void setXcTime(long j) {
        this.xcTime = j;
    }

    public void settTime(String str) {
        this.tTime = str;
    }

    public void settTime() {
        try {
            settTime((getEndTime() - getStartTime()) + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
