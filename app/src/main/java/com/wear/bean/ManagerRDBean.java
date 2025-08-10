package com.wear.bean;

import com.google.gson.Gson;
import com.wear.dao.DaoUtils;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;

/* loaded from: classes3.dex */
public class ManagerRDBean {
    private static final String MANAGER_RED_DOT = "managerRedDot";
    private static final String MANAGER_RED_DOT_TYPE = "managerRedDotType";
    private static ManagerRDBean managerRDBean;
    private boolean isShowChangePassword;
    private boolean isShowChat;
    private boolean isShowChatTheme;
    private boolean isShowHomePage;
    private boolean isShowMe;
    private boolean isShowMyAccount;
    private boolean isShowSettings;

    private ManagerRDBean(boolean z, boolean z2, boolean z3) {
        this.isShowHomePage = z2;
        this.isShowChatTheme = z;
        this.isShowChangePassword = z3;
        update();
    }

    public static ManagerRDBean getManager() {
        if (managerRDBean == null) {
            String value = DaoUtils.getTestValueDao().getValue(MANAGER_RED_DOT, MANAGER_RED_DOT_TYPE);
            if (WearUtils.e1(value)) {
                managerRDBean = new ManagerRDBean(true, true, false);
            } else {
                managerRDBean = (ManagerRDBean) new Gson().fromJson(value, ManagerRDBean.class);
            }
        }
        return managerRDBean;
    }

    public static void saveManager() {
        if (managerRDBean == null) {
            return;
        }
        DaoUtils.getTestValueDao().save(MANAGER_RED_DOT, new Gson().toJson(managerRDBean), MANAGER_RED_DOT_TYPE);
    }

    private void update() {
        boolean z = this.isShowChangePassword;
        boolean z2 = MyApplication.O;
        boolean z3 = z & z2;
        this.isShowMyAccount = z3;
        boolean z4 = z3 & z2;
        this.isShowSettings = z4;
        this.isShowMe = z4;
    }

    public boolean isShowChat() {
        update();
        return this.isShowChat;
    }

    public boolean isShowChatTheme() {
        return this.isShowChatTheme;
    }

    public boolean isShowHomePage() {
        return this.isShowHomePage;
    }

    public boolean isShowMe() {
        update();
        return this.isShowMe;
    }

    public boolean isShowMyAccount() {
        update();
        return this.isShowMyAccount;
    }

    public boolean isShowSettings() {
        update();
        return this.isShowSettings;
    }

    public void setShowChangePassword(boolean z) {
        this.isShowChangePassword = z;
        update();
    }

    public void setShowChatTheme(boolean z) {
        this.isShowChatTheme = z;
        update();
    }

    public void setShowHomePage(boolean z) {
        this.isShowHomePage = z;
        update();
    }
}
