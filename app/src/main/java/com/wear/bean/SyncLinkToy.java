package com.wear.bean;

import com.wear.util.WearUtils;
import dc.fk2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes3.dex */
public class SyncLinkToy {
    private HashMap<String, Object> chat;
    private String platform;
    private List<ToysBean> toys;
    private int v;
    private String version;

    public static class ToysBean {
        private int battery;
        private String deviceType;
        private String fVersion;
        private String id;
        private String name;
        private String status;
        private String type;
        private String version;
        private boolean control = true;
        private int isSupportLdr = 0;
        private String workMode = null;

        public int getBattery() {
            return this.battery;
        }

        public String getDeviceType() {
            return this.deviceType;
        }

        public String getId() {
            return this.id;
        }

        public int getIsSupportLdr() {
            return this.isSupportLdr;
        }

        public String getName() {
            return this.name;
        }

        public String getStatus() {
            return this.status;
        }

        public String getType() {
            return this.type;
        }

        public String getVersion() {
            return this.version;
        }

        public String getWorkMode() {
            return this.workMode;
        }

        public String getfVersion() {
            return this.fVersion;
        }

        public boolean isControl() {
            return this.control;
        }

        public void setBattery(int i) {
            this.battery = i;
        }

        public void setControl(boolean z) {
            this.control = z;
        }

        public void setDeviceType(String str) {
            this.deviceType = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setIsSupportLdr(int i) {
            this.isSupportLdr = i;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public void setType(String str) {
            this.type = str;
        }

        public void setVersion(String str) {
            this.version = str;
        }

        public void setWorkMode(String str) {
            this.workMode = str;
        }

        public void setfVersion(String str) {
            this.fVersion = str;
        }
    }

    public static ToysBean getToysBeanFromToy(Toy toy) {
        String lowerCase;
        String deviceType = toy.getDeviceType();
        if (WearUtils.e1(deviceType) || deviceType.split(SignatureImpl.INNER_SEP).length != 3) {
            lowerCase = "";
        } else {
            lowerCase = toy.getDeviceType().split(SignatureImpl.INNER_SEP)[2].toLowerCase();
            if (lowerCase.endsWith(";")) {
                lowerCase = lowerCase.substring(0, lowerCase.length() - 1);
            }
        }
        ToysBean toysBean = new ToysBean();
        toysBean.setId(lowerCase);
        toysBean.setBattery(toy.getBattery() == -1 ? 50 : toy.getBattery());
        toysBean.setType(toy.getRealType());
        toysBean.setName(toy.getDefineRename());
        toysBean.setStatus(toy.isConnected() ? "true" : "false");
        toysBean.setfVersion(toy.getToyVersion() + "");
        toysBean.setVersion(toy.getGenerationVersion());
        toysBean.setControl(toy.isSelect());
        toysBean.setDeviceType(toy.getDeviceType());
        if (toy.isBAToy()) {
            toysBean.setWorkMode(fk2.a.c(toy.getAddress()).name().toLowerCase());
        }
        return toysBean;
    }

    public void addToys(ToysBean toysBean) {
        if (this.toys == null) {
            this.toys = new ArrayList();
        }
        this.toys.add(toysBean);
    }

    public HashMap<String, Object> getChat() {
        return this.chat;
    }

    public String getPlatform() {
        return this.platform;
    }

    public List<ToysBean> getToys() {
        return this.toys;
    }

    public int getV() {
        return this.v;
    }

    public String getVersion() {
        return this.version;
    }

    public void setChat(HashMap<String, Object> map) {
        this.chat = map;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setToys(List<ToysBean> list) {
        this.toys = list;
    }

    public void setV(int i) {
        this.v = i;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
